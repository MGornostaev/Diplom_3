package ru.praktikum.diplom.selenium.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class AccountPage {
    WebDriver webDriver;

    public AccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By logoutButton = By.xpath(".//button[text() = 'Выход']");

    @Step
    public LoginPage clickLogoutButton(){
        WebElement element = webDriver.findElement(logoutButton);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new LoginPage(webDriver);
    }

    @Step
    public void checkLogoutButton(){
        var isDisplayed = webDriver.findElement(logoutButton).isDisplayed();
        assertTrue("Не найдена кнопка выхода из аккаунта",isDisplayed);
    }
}
