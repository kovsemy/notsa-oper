package com.example.tests;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestMethodsTest extends BaseTest {

    @Test
    public void getRequest() {
        given()
                .spec(requestSpec)
                .basePath("/get")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when().get()
                .then().statusCode(HttpStatus.SC_OK)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void postRawText() {
        given()
                .spec(requestSpec)
                .basePath("/post")
                .contentType("text/plain")
                .body("hello")
                .when().post()
                .then().statusCode(HttpStatus.SC_OK)
                .body("data", equalTo("hello"));
    }

    @Test
    public void postFormData() {
        given()
                .spec(requestSpec)
                .basePath("/post")
                /*
                Если вручную не отключать charset в Content-Type (charset=ISO-8859-1), который
                нам автоматически подставляет rest assured, то сервер будет возвращать 500,
                ну или через multipart/form-data данные передавать, тогда все окей:)
                 */
                .config(RestAssuredConfig.config().encoderConfig(
                        EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)
                ))
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when().post()
                .then().statusCode(HttpStatus.SC_OK)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void putRequest() {
        given()
                .spec(requestSpec)
                .basePath("/put")
                .contentType("text/plain")
                .body("hi")
                .when().put()
                .then().statusCode(HttpStatus.SC_OK)
                .body("data", equalTo("hi"));
    }

    @Test
    public void patchRequest() {
        given()
                .spec(requestSpec)
                .basePath("/patch")
                .contentType("text/plain")
                .body("hi")
                .when().patch()
                .then().statusCode(HttpStatus.SC_OK)
                .body("data", equalTo("hi"));
    }

    @Test
    public void deleteRequest() {
        given()
                .spec(requestSpec)
                .basePath("/delete")
                .contentType("text/plain")
                .body("hi")
                .when().delete()
                .then().statusCode(HttpStatus.SC_OK)
                .body("data", equalTo("hi"));
    }
}
