package ru.praktikum.diplom3.client;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static ru.praktikum.diplom3.config.AppConfig.BURGER_URL;

public class BaseApiClient {

    public RequestSpecification getPostSpec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BURGER_URL);
    }

}
