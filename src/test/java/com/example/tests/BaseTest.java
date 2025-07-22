package com.example.tests;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseTest {
    protected static RequestSpecification requestSpec;

    @BeforeTest
    public static void setup() {
        requestSpec = given()
                .baseUri("https://postman-echo.com");
    }
}
