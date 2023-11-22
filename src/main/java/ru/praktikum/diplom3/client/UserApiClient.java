package ru.praktikum.diplom3.client;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.praktikum.diplom3.models.CreateUserRequest;
import ru.praktikum.diplom3.models.LoginUserRequest;

import static ru.praktikum.diplom3.config.AppConfig.*;

public class UserApiClient extends BaseApiClient {
    @Step("Создание пользователя")
    public Response createUser(CreateUserRequest createUserRequest) {
        return getPostSpec()
                .body(createUserRequest)
                .when()
                .post(REGISTER_URL);
    }

    @Step("Удаление пользователя")
    public Response deleteUser(String bearerToken) {
        return getPostSpec()
                .headers(
                        "Authorization",
                        bearerToken)
                .delete(USER_URL);
    }


    @Step("Авторизация пользователя")
    public Response loginUser(LoginUserRequest loginUserRequest) {
        return getPostSpec()
                .body(loginUserRequest)
                .when()
                .post(LOGIN_USER_URL);
    }
}
