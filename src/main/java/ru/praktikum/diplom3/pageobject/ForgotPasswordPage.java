package ru.praktikum.diplom3.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    WebDriver webDriver;

    private By linkLoginPage = By.xpath("//a[text()=\"Войти\"]");
    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage clickLinkLoginPage(){
        webDriver.findElement(linkLoginPage).click();
        return new LoginPage(webDriver);
    }

}
