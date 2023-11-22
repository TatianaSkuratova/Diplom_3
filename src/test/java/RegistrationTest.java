import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom3.client.UserApiClient;
import ru.praktikum.diplom3.helper.CreateUserRequestGenerator;
import ru.praktikum.diplom3.models.CreateUserRequest;
import ru.praktikum.diplom3.models.LoginUserRequest;
import ru.praktikum.diplom3.models.LoginUserResponse;
import ru.praktikum.diplom3.pageobject.MainPage;
import ru.praktikum.diplom3.pageobject.RegistrationPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
    private MainPage mainPage;
    private Boolean successCreateUser = false;
    private RegistrationPage registrationPage;
    private CreateUserRequest createUserRequest;
    private UserApiClient userApiClient;
    private Response responseLoginUser;

    @Before
    @DisplayName("")
    public void init() {
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        createUserRequest = CreateUserRequestGenerator.getRandomUser();
        userApiClient = new UserApiClient();
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void checkSuccessRegistration() {
        Boolean isLoginPageVisible = mainPage.clickButtonPersonalAccount()
                .clickLinkRegistration()
                .sendKeysInputName(createUserRequest.getName())
                .sendKeysInputEmail(createUserRequest.getEmail())
                .sendKeysInputPassword(createUserRequest.getPassword())
                .clickButtonRegistration()
                .isVisibleLabelLogin();
        successCreateUser = checkCreateUser();
        assertTrue(isLoginPageVisible);
        assertTrue(successCreateUser);
    }

    @Test
    @DisplayName("Проверка недоступности регистрации с паролем меньше 6 символов")
    public void checkIncorrectPassword() {
        mainPage.clickButtonPersonalAccount()
                .clickLinkRegistration()
                .sendKeysInputName(createUserRequest.getName())
                .sendKeysInputEmail(createUserRequest.getEmail())
                .sendKeysInputPassword("12345")
                .clickButtonRegistration();
        successCreateUser = checkCreateUser();
        assertTrue(registrationPage.isVisibleIncorrectPassword());
        assertFalse(successCreateUser);
    }

    @After
    @DisplayName("Удаление созданного пользователя")
    public void deleteUser() {
        if (successCreateUser) {
            LoginUserResponse loginUserResponse = responseLoginUser.as(LoginUserResponse.class);
            String token = loginUserResponse.getAccessToken();
            userApiClient.deleteUser(token);
        }
    }

    @DisplayName("Метод, возвращающий успешность авторизации пользователя")
    public Boolean checkCreateUser() {
        responseLoginUser = userApiClient.loginUser(LoginUserRequest.fromCreateUserRequest(createUserRequest));
        return responseLoginUser.body().jsonPath().getBoolean("success");
    }

    ;
}
