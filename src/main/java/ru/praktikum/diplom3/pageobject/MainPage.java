package ru.praktikum.diplom3.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.diplom3.config.AppConfig;

import java.time.Duration;

public class MainPage {
    public  WebDriver webDriver;
    public By buttonPersonalAccount  = By.xpath("//p[text()=\"Личный Кабинет\"]");
    public By buttonLoginToAccount = By.xpath("//button[text()=\"Войти в аккаунт\"]");
    public By buttonConstructor = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a");
    public By imageLogo = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");
    public static final long SHORT_WAIT = 3;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(AppConfig.BURGER_URL);
    }

    public LoginPage clickButtonPersonalAccount(){
        webDriver.findElement(buttonPersonalAccount).click();
        return new LoginPage(webDriver);
    }
    public PersonalAccountPage clickButtonAuthPersonalAccount(){
        WebElement login = new WebDriverWait(webDriver, Duration.ofSeconds(SHORT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonPersonalAccount));
        login.click();
        return new PersonalAccountPage(webDriver);
    }

    public LoginPage clickButtonLoginToAccount(){
        WebElement login = new WebDriverWait(webDriver, Duration.ofSeconds(SHORT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLoginToAccount));
        login.click();
        return new LoginPage(webDriver);
    }
    public ConstructorPage clickButtonConstructor(){
        WebElement constructor = new WebDriverWait(webDriver, Duration.ofSeconds(SHORT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonConstructor));
        constructor.click();
        return new ConstructorPage(webDriver);
    }
    public ConstructorPage clickImageLogo(){
        WebElement logo = new WebDriverWait(webDriver, Duration.ofSeconds(SHORT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(imageLogo));
        logo.click();;
        return new ConstructorPage(webDriver);
    }
}
