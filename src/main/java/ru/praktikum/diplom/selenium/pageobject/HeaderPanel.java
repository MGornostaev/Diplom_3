package ru.praktikum.diplom.selenium.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPanel {
    WebDriver webDriver;

    public HeaderPanel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private By constructorButton = By.xpath(".//p[text() = 'Конструктор']");
    private By appLogo = By.className("AppHeader_header__logo__2D0X2");

    @Step
    public LoginPage clickPersonalAccountButton(){
        WebElement element = webDriver.findElement(personalAccountButton);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new LoginPage(webDriver);
    }

    @Step
    public MainPage clickConstructorButton(){
        WebElement element = webDriver.findElement(constructorButton);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new MainPage(webDriver);
    }

    @Step
    public MainPage clickAppLogo(){
        WebElement element = webDriver.findElement(appLogo);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new MainPage(webDriver);
    }

}
