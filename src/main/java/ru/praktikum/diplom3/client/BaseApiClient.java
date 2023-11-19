package ru.praktikum.diplom3.client;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
public class BaseApiClient {

    public RequestSpecification getPostSpec() {
        return given()
                //.filter(new RequestLoggingFilter())
                //.filter(new ResponseLoggingFilter())
                .contentType(ContentType.JSON);
    }

}
