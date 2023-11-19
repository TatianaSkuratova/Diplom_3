package ru.praktikum.diplom3.client;

import io.restassured.response.Response;
import ru.praktikum.diplom3.models.CreateUserRequest;
import ru.praktikum.diplom3.models.LoginUserRequest;

import static ru.praktikum.diplom3.config.AppConfig.*;

public class UserApiClient extends BaseApiClient {
    public Response createUser(CreateUserRequest createUserRequest) {
        return getPostSpec()
                .body(createUserRequest)
                .when()
                .post(BURGER_URL + REGISTER_URL);
    }

    public Response deleteUser (String bearerToken){
        return getPostSpec()
                .headers(
                        "Authorization",
                        bearerToken)
                .delete(BURGER_URL + USER_URL);
    }

    public Response loginUser (LoginUserRequest loginUserRequest){
        return getPostSpec()
                .body(loginUserRequest)
                .when()
                .post(BURGER_URL + LOGIN_USER_URL);
    }
}
