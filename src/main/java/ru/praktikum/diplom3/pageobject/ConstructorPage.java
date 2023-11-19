package ru.praktikum.diplom3.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {

    public static final String BUNS = "Булки";
    public static final String SOUCES = "Соусы";
    public static final String FILLINGS = "Начинки";
    WebDriver webDriver;
    private static final String LABEL = "//h2[text()=\"%s\"]";
    private static final String TAB = "//span[text()=\"%s\"]/parent::div";
    private static final By labelCreateBurger = By.xpath("//h1[text()=\"Соберите бургер\"]");

    public ConstructorPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public Boolean clickOnLabel(String tab){
        String classNameCurrentTab = "tab_tab_type_current__2BEPc";
        if (webDriver.findElement(By.xpath(String.format(TAB, tab))).getAttribute("class").contains(classNameCurrentTab)){
            return true;
        }
        else {
            webDriver.findElement(By.xpath(String.format(TAB, tab))).click();
            return webDriver.findElement(By.xpath(String.format(TAB, tab))).getAttribute("class").contains(classNameCurrentTab);
        }
    }

    public Boolean isEnabledLabelCreateBurger(){
        return webDriver.findElement(labelCreateBurger).isDisplayed();
    }

}
