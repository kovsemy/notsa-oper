package web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PayBlockTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().browserVersion("138.0").setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");

        WebElement buttonCookieAgree = driver.findElement(By.id("cookie-agree"));
        if (buttonCookieAgree.isDisplayed()) {
            buttonCookieAgree.click();
        }
    }

    @Test
    public void shouldContainHeaderText() {
        WebElement headingPayBlock = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн')]"));
        String actualText = headingPayBlock.getText();
        Assert.assertEquals(actualText, "Онлайн пополнение\nбез комиссии");
    }

    @Test
    public void shouldContainPartnerLogos() {
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='pay__partners']//img"));
        List<String> expectedAlts = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

        for (WebElement logo : logos) {
            String alt = logo.getAttribute("alt");
            Assert.assertTrue(expectedAlts.contains(alt), "Unexpected logo: " + alt);
        }
    }

    @Test
    public void isClickableLink() {
        WebElement link = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        link.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    public void displayModalAfterClickContinueButton() {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("10");
        driver.findElement(By.id("connection-email")).sendKeys("unpleasantindigo@dcpa.net");
        driver.findElement(By.xpath("//button[text()='Продолжить']")).click();

        WebElement modal = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));
        Assert.assertTrue(modal.isDisplayed());
    }

    @AfterTest
    public void kill() {
        driver.close();
        driver.quit();
    }
}
