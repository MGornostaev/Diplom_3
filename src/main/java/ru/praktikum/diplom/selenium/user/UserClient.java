package ru.praktikum.diplom.selenium.user;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static ru.praktikum.diplom.selenium.config.AppConfig.*;

public class UserClient {
    public ValidatableResponse userCreate(User user) {
        return given().log().all()
                .baseUri(APP_URI)
                .contentType(ContentType.JSON)
                .body(user)
                .post( API_AUTH + "/register")
                .then().log().all();
    }

    public ValidatableResponse userLogin(Credentials credentials) {
        return given().log().all()
                .baseUri(APP_URI)
                .contentType(ContentType.JSON)
                .body(credentials)
                .post( API_AUTH + "/login")
                .then().log().all();
    }

    public void userDelete(String token) {
        given().log().all()
                .baseUri(APP_URI)
                .header("Authorization", token)
                .delete(API_AUTH + "/user")
                .then().log().all();
    }

    public String getToken(ValidatableResponse response) {
        return response
                .extract()
                .path("accessToken");
    }
}
