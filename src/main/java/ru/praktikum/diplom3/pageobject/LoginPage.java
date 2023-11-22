package ru.praktikum.diplom3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By linkRegistration = By.xpath("//a[text()=\"Зарегистрироваться\"]");
    private final By labelLogin = By.xpath("//h2[text()=\"Вход\"]");
    private final By linkRestorePassword = By.xpath("//a[text()=\"Восстановить пароль\"]");
    private final By inputEmail = By.name("name");
    private final By inputPassword = By.name("Пароль");
    ;
    private final By buttonLogin = By.xpath("//button[text()=\"Войти\"]");
    ;
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Кликнуть на ссылку \"Зарегистрироваться\" на странице авторизации")
    public RegistrationPage clickLinkRegistration() {
        webDriver.findElement(linkRegistration).click();
        return new RegistrationPage(webDriver);
    }

    @Step("Проверка наличия заголовка \"Логин\" на странице авторизации")
    public boolean isVisibleLabelLogin() {
        return webDriver.findElement(labelLogin).isDisplayed();
    }

    @Step("Кликнуть на ссылку \"Восстановить пароль\" на странице авторизации")
    public ForgotPasswordPage clickLinkRestorePassword() {
        webDriver.findElement(linkRestorePassword).click();
        return new ForgotPasswordPage(webDriver);
    }

    @Step("Заполнить поле email на странице авторизации")
    public LoginPage sendKeysInputEmail(String email) {
        webDriver.findElement(inputEmail).sendKeys(email);
        return this;
    }

    @Step("Заполнить поле пароль на странице авторизации")
    public LoginPage sendKeysInputPassword(String password) {
        webDriver.findElement(inputPassword).sendKeys(password);
        return this;
    }

    @Step("Кликнуть на кнопку \"Войти\" на странице авторизации")
    public MainPage clickOnButtonLogin() {
        webDriver.findElement(buttonLogin).click();
        return new MainPage(webDriver);
    }
}
