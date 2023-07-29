package ru.praktikum.diplom.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static ru.praktikum.diplom.selenium.config.AppConfig.YA_BROWSER_DIRECTORY;

public class WebDriverFactory {
    public static WebDriver get() {
        WebDriver webDriver;

        String browserName = System.getProperty("browserName");

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary(YA_BROWSER_DIRECTORY);
                webDriver = new ChromeDriver(options);
                break;
            default:
                throw new RuntimeException("Browser is not detected");
        }
        return webDriver;
    }
}
