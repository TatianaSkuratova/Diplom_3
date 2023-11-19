package ru.praktikum.diplom3.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver webDriver;
     private By inputName = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
     private By inputEmail = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
     private By inputPassword = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
     private By buttonRegistration = By.xpath("//button[text()=\"Зарегистрироваться\"]");
     private By labelIncorrectPassword = By.xpath("//p[text()=\"Некорректный пароль\"]");
     private By linkLogin = By.xpath("//a[text()=\"Войти\"]");


    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public RegistrationPage sendKeysInputName(String name){
        webDriver.findElement(inputName).sendKeys(name);
        return this;
    }

    public RegistrationPage sendKeysInputEmail(String email){
        webDriver.findElement(inputEmail).sendKeys(email);
        return this;
    }
    public RegistrationPage sendKeysInputPassword(String password){
        webDriver.findElement(inputPassword).sendKeys(password);
        return this;
    }
    public LoginPage clickButtonRegistration(){
        webDriver.findElement(buttonRegistration).click();
        return new LoginPage(webDriver);
    }
    public LoginPage clickLinkLogin(){
        webDriver.findElement(linkLogin).click();
        return new LoginPage(webDriver);
    }
    public Boolean isVisibleIncorrectPassword(){
        return webDriver.findElement(labelIncorrectPassword).isDisplayed();
    }

}
