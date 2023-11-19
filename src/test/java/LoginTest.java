import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom3.client.UserApiClient;
import ru.praktikum.diplom3.helper.CreateUserRequestGenerator;
import ru.praktikum.diplom3.models.CreateUserRequest;
import ru.praktikum.diplom3.models.CreateUserResponse;
import ru.praktikum.diplom3.pageobject.LoginPage;
import ru.praktikum.diplom3.pageobject.MainPage;
import ru.praktikum.diplom3.pageobject.PersonalAccountPage;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{

    private MainPage mainPage;
    CreateUserRequest createUserRequest;
    UserApiClient userApiClient;
    CreateUserResponse createUserResponse;
    @Before
    public void init(){
        mainPage = new MainPage(webDriver);
        createUserRequest = CreateUserRequestGenerator.getRandomUser();
        userApiClient = new UserApiClient();
        createUserResponse = userApiClient.createUser(createUserRequest).as(CreateUserResponse.class);
    }

    @Test
    @DisplayName("Проверка входа по кнопке \"Войти в аккаунт\"")
    public void checkLoginFromButtonLoginToAccount(){
        Boolean isVisibleLoginPage = mainPage.clickButtonLoginToAccount().isVisibleLabelLogin();
        assertTrue(isVisibleLoginPage);
    }

    @Test
    @DisplayName("Проверка входа по кнопке \"Личный кабинет\"")
    public void checkLoginFromButtonPersonalAccount(){
        LoginPage loginPage = mainPage.clickButtonPersonalAccount();
        PersonalAccountPage personalAccountPage = getPersonalAccountPage(loginPage);
        assertTrue(personalAccountPage.isVisibleButtonExit());
    }

    @Test
    @DisplayName("Проверка входа по ссылке \"Войти\" на форме регистрации")
    public void checkLoginFromLinkLogin(){
        LoginPage loginPage = mainPage.clickButtonPersonalAccount().clickLinkRegistration().clickLinkLogin();
        PersonalAccountPage personalAccountPage = getPersonalAccountPage(loginPage);
        assertTrue(personalAccountPage.isVisibleButtonExit());
    }

    @Test
    @DisplayName("Проверка входа по ссылке \"Войти\" на форме восстановления пароля")
    public void checkLoginFromPageForgotPassword(){
        LoginPage loginPage = mainPage.clickButtonLoginToAccount().clickLinkRestorePassword().clickLinkLoginPage();
        PersonalAccountPage personalAccountPage = getPersonalAccountPage(loginPage);
        assertTrue(personalAccountPage.isVisibleButtonExit());
    }

    @Step
    @DisplayName("Вход в личный кабинет")
    public PersonalAccountPage getPersonalAccountPage(LoginPage loginPage){
        MainPage mainPage =  loginPage
                .sendKeysInputEmail(createUserRequest.getEmail())
                .sendKeysInputPassword(createUserRequest.getPassword())
                .clickOnButtonLogin();
        return mainPage.clickButtonAuthPersonalAccount();

    }
    @After
    @DisplayName("Удаление созданного пользователя")
    public void deleteUser(){
            userApiClient.deleteUser(createUserResponse.getAccessToken());
        }
    }

