package ru.praktikum.diplom3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {
    static WebDriver driver;

    public static WebDriver get(String browserName) {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        switch (browserName) {
            case "yandex":
                String yandexapp = property.getProperty("yandexapp");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                ChromeOptions options = new ChromeOptions();
                System.out.println(yandexapp);
                options.setBinary(yandexapp);
                driver = new ChromeDriver(options);
                return driver;
            case "chrome":
                String chromeapp = property.getProperty("chromeapp");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setBinary(new File(chromeapp));
                driver = new ChromeDriver(chromeOptions);
                return driver;
            default:
                throw new RuntimeException("Browser is not defined");
        }
    }
}
