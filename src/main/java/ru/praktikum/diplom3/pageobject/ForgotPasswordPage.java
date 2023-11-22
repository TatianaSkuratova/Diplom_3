package ru.praktikum.diplom3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver webDriver;

    private By linkLoginPage = By.xpath("//a[text()=\"Войти\"]");

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Кликнуть на ссылку войти на странице восстановления пароля")
    public LoginPage clickLinkLoginPage() {
        webDriver.findElement(linkLoginPage).click();
        return new LoginPage(webDriver);
    }

}
