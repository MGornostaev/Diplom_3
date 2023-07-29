package ru.praktikum.diplom.selenium.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class RegistrationPage {
    WebDriver webDriver;

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By loginRegisterPageLink = By.xpath(".//a[text() = 'Войти']");
    private By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private By emailInputField = By.xpath("//fieldset[2]/div/div/input");
    private By nameInputField = By.xpath("//fieldset[1]/div/div/input");
    private By passwordInputField = By.xpath(".//input[@type = 'password']");
    private By invalidPasswordMessage = By.xpath(".//p[text() = 'Некорректный пароль']");

    @Step
    public RegistrationPage inputName(String name){
        webDriver.findElement(nameInputField).sendKeys(name);
        return this;
    }

    @Step
    public RegistrationPage inputEmail(String email){
        webDriver.findElement(emailInputField).sendKeys(email);
        return this;
    }

    @Step
    public RegistrationPage inputPassword(String password){
        webDriver.findElement(passwordInputField).sendKeys(password);
        return this;
    }

    @Step
    public LoginPage clickRegisterButtonValid(){
        WebElement element = webDriver.findElement(registerButton);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new LoginPage(webDriver);
    }

    @Step
    public RegistrationPage clickRegisterButtonInvalid(){
        WebElement element = webDriver.findElement(registerButton);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return this;
    }

    @Step
    public void checkInvalidPasswordMessage(){
        var isDisplayed = webDriver.findElement(invalidPasswordMessage).isDisplayed();
        assertTrue("Не найдено сообщение об ошибке",isDisplayed);
    }

    @Step
    public LoginPage clickLoginRegisterPageLink(){
        WebElement element = webDriver.findElement(loginRegisterPageLink);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new LoginPage(webDriver);
    }

}
