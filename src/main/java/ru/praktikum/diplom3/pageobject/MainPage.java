package ru.praktikum.diplom3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.diplom3.config.AppConfig;

import java.time.Duration;

public class MainPage {
    private static final long SHORT_WAIT = 3;
    public WebDriver webDriver;
    private By buttonPersonalAccount = By.xpath("//p[text()=\"Личный Кабинет\"]");
    private By buttonLoginToAccount = By.xpath("//button[text()=\"Войти в аккаунт\"]");
    private By buttonConstructor = By.xpath("//p[text()=\"Конструктор\"]/parent::a");
    private By imageLogo = By.xpath("//div[@class=\"AppHeader_header__logo__2D0X2\"]/a");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(AppConfig.BURGER_URL);
    }

    @Step("Кликнуть на кнопку \"Личный кабинет\" на главной странице")
    public LoginPage clickButtonPersonalAccount() {
        webDriver.findElement(buttonPersonalAccount).click();
        return new LoginPage(webDriver);
    }

    @Step("Кликнуть на кнопку \"Личный кабинет\" на главной странице авторизованному пользователю")
    public PersonalAccountPage clickButtonAuthPersonalAccount() {
        WebElement login = new WebDriverWait(webDriver, Duration.ofSeconds(SHORT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonPersonalAccount));
        login.click();
        return new PersonalAccountPage(webDriver);
    }

    @Step("Кликнуть на кнопку \"Войти в аккаунт\" на главной странице")
    public LoginPage clickButtonLoginToAccount() {
        WebElement login = new WebDriverWait(webDriver, Duration.ofSeconds(SHORT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLoginToAccount));
        login.click();
        return new LoginPage(webDriver);
    }

    @Step("Кликнуть на кнопку \"Конструктор\" на главной странице")
    public ConstructorPage clickButtonConstructor() {
        WebElement constructor = new WebDriverWait(webDriver, Duration.ofSeconds(SHORT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonConstructor));
        constructor.click();
        return new ConstructorPage(webDriver);
    }

    @Step("Кликнуть логотип на главной странице")
    public ConstructorPage clickImageLogo() {
        webDriver.findElement(imageLogo).click();
        return new ConstructorPage(webDriver);
    }
}
