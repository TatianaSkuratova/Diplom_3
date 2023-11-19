package ru.praktikum.diplom3.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver webDriver;
    private final By linkRegistration =  By.xpath("//a[text()=\"Зарегистрироваться\"]");
    private final By labelLogin = By.xpath("//h2[text()=\"Вход\"]");
    private final By linkRestorePassword = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a");

    private final By inputEmail = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private final By inputPassword = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By buttonLogin = By.xpath("//button[text()=\"Войти\"]");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public RegistrationPage clickLinkRegistration(){
        webDriver.findElement(linkRegistration).click();
        return new RegistrationPage(webDriver);
    }
    public boolean isVisibleLabelLogin(){
        return webDriver.findElement(labelLogin).isDisplayed();
    }

    public ForgotPasswordPage clickLinkRestorePassword(){
        webDriver.findElement(linkRestorePassword).click();
        return new ForgotPasswordPage(webDriver);
    }
    public LoginPage sendKeysInputEmail(String email){
        webDriver.findElement(inputEmail).sendKeys(email);
        return this;
    }
    public LoginPage sendKeysInputPassword(String password){
        webDriver.findElement(inputPassword).sendKeys(password);
        return this;
    }
    public MainPage clickOnButtonLogin(){
        webDriver.findElement(buttonLogin).click();
        return new MainPage(webDriver);
    }
}
