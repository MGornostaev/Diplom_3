package ru.praktikum.diplom.selenium.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordRecoveryPage {
    WebDriver webDriver;

    public PasswordRecoveryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private By loginLink = By.xpath(".//a[text() = 'Войти']");

    @Step
    public LoginPage clickLoginLink(){
        WebElement element = webDriver.findElement(loginLink);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new LoginPage(webDriver);
    }

}
