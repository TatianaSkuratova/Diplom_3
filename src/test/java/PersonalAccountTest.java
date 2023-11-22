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

public class PersonalAccountTest extends BaseTest {
    private MainPage mainPage;
    private CreateUserRequest createUserRequest;
    private UserApiClient userApiClient;
    private CreateUserResponse createUserResponse;
    private LoginPage loginPage;

    @Before
    public void init() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        createUserRequest = CreateUserRequestGenerator.getRandomUser();
        userApiClient = new UserApiClient();
        createUserResponse = userApiClient.createUser(createUserRequest).as(CreateUserResponse.class);
    }

    @Test
    @DisplayName("Проверка перехода по клику в личный кабинет")
    public void clickPersonalAccountIsDisplayed() {
        LoginPage loginPage = mainPage.clickButtonLoginToAccount();
        PersonalAccountPage personalAccountPage = getPersonalAccountPage(loginPage);
        loginPage = personalAccountPage.clickToButtonExit();
        assertTrue(loginPage.isVisibleLabelLogin());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор")
    public void fromPersonalAccountToConstructor() {
        loginPage = mainPage.clickButtonPersonalAccount();
        PersonalAccountPage personalAccountPage = getPersonalAccountPage(loginPage);
        assertTrue(mainPage.clickButtonConstructor().isEnabledLabelCreateBurger());
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор при нажатии на логотип")
    public void fromPersonalAccountToLogo() {
        loginPage = mainPage.clickButtonPersonalAccount();
        PersonalAccountPage personalAccountPage = getPersonalAccountPage(loginPage);
        assertTrue(mainPage.clickImageLogo().isEnabledLabelCreateBurger());

    }

    @DisplayName("Вход в личный кабинет")
    public PersonalAccountPage getPersonalAccountPage(LoginPage loginPage) {
        mainPage = loginPage
                .sendKeysInputEmail(createUserRequest.getEmail())
                .sendKeysInputPassword(createUserRequest.getPassword())
                .clickOnButtonLogin();
        return mainPage.clickButtonAuthPersonalAccount();
    }

    @After
    @DisplayName("Удаление созданного пользователя")
    public void deleteUser() {
        userApiClient.deleteUser(createUserResponse.getAccessToken());
    }
}

