package ru.praktikum.diplom3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver webDriver;
    private By inputName = By.xpath(".//label[text()=\"Имя\"]/parent::div/input");
    private By inputEmail = By.xpath("//label[text()=\"Email\"]/parent::div/input");
    private By inputPassword = By.xpath("//label[text()=\"Пароль\"]/parent::div/input");
    private By buttonRegistration = By.xpath("//button[text()=\"Зарегистрироваться\"]");
    private By labelIncorrectPassword = By.xpath("//p[text()=\"Некорректный пароль\"]");
    private By linkLogin = By.xpath("//a[text()=\"Войти\"]");


    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Ввести имя на странице регистрации")
    public RegistrationPage sendKeysInputName(String name) {
        webDriver.findElement(inputName).sendKeys(name);
        return this;
    }

    @Step("Ввести email на странице регистрации")
    public RegistrationPage sendKeysInputEmail(String email) {
        webDriver.findElement(inputEmail).sendKeys(email);
        return this;
    }

    @Step("Ввести пароль на странице регистрации")
    public RegistrationPage sendKeysInputPassword(String password) {
        webDriver.findElement(inputPassword).sendKeys(password);
        return this;
    }

    @Step("Кликнуть на кнопку \"Зарегистрироваться\" на странице регистрации")
    public LoginPage clickButtonRegistration() {
        webDriver.findElement(buttonRegistration).click();
        return new LoginPage(webDriver);
    }

    @Step("Кликнуть на ссылку \"Войти\" на странице регистрации")
    public LoginPage clickLinkLogin() {
        webDriver.findElement(linkLogin).click();
        return new LoginPage(webDriver);
    }

    @Step("Проверка отображения сообщения \"Некорректный пароль\" на форме регистрации")
    public Boolean isVisibleIncorrectPassword() {
        return webDriver.findElement(labelIncorrectPassword).isDisplayed();
    }

}
