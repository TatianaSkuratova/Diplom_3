package ru.praktikum.diplom3.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.diplom3.WebDriverFactory;

public class PersonalAccountPage {

    WebDriver webDriver;
    By buttonExit = By.xpath("//button[text()=\"Выход\"]");
    public PersonalAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Boolean isVisibleButtonExit(){
        return webDriver.findElement(buttonExit).isDisplayed();
    }
    public LoginPage clickToButtonExit(){
       webDriver.findElement(buttonExit).click();
       return new LoginPage(webDriver);
    }

}
