package ru.praktikum.diplom3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private WebDriver webDriver;
    private By buttonExit = By.xpath("//button[text()=\"Выход\"]");
    private By imageLogo = By.xpath("//a[@class=\"active\"]");

    public PersonalAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверка наличия кнопки \"Выход\" в личном кабинете")
    public Boolean isVisibleButtonExit() {
        return webDriver.findElement(buttonExit).isDisplayed();
    }

    @Step("Кликнуть на кнопку \"Выход\" в личном кабинете")
    public LoginPage clickToButtonExit() {
        webDriver.findElement(buttonExit).click();
        return new LoginPage(webDriver);
    }

    @Step("Кликнуть логотип на главной странице")
    public ConstructorPage clickImageLogo() {
        webDriver.findElement(imageLogo).click();
        return new ConstructorPage(webDriver);
    }
}
