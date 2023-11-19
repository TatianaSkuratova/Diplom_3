package ru.praktikum.diplom3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class WebDriverFactory {
    static WebDriver driver;
    public static WebDriver get(String browserName){
            switch (browserName) {
                case "yandex":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                    ChromeOptions options = new ChromeOptions();
                    options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                    driver = new ChromeDriver(options);
                    return driver;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setBinary(new File("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"));
                    driver = new ChromeDriver(chromeOptions);
                    return driver;
                default:
                    throw new RuntimeException("Browser is not defined");
            }
    }
}

