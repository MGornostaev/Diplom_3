package ru.praktikum.diplom.selenium.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By registerLink = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private By passwordRecoveryLink = By.xpath(".//a[text() = 'Восстановить пароль']");
    private By passwordInputField = By.xpath(".//input[@type = 'password']");
    private By emailInputField = By.xpath(".//input[@name = 'name']");
    private By loginFormButton = By.xpath(".//button[text() = 'Войти']");
    private By loginFormHeader = By.xpath(".//h2[text() = 'Вход']");

    @Step
    public RegistrationPage clickRegisterLink(){
        WebElement element = webDriver.findElement(registerLink);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new RegistrationPage(webDriver);
    }

    @Step
    public void checkLoginPageFormHeader(){
        var isDisplayed = webDriver.findElement(loginFormHeader).isDisplayed();
        assertTrue("Не найден заголовок формы логина",isDisplayed);
    }

    @Step
    public LoginPage inputEmail(String email){
        webDriver.findElement(emailInputField).sendKeys(email);
        return this;
    }

    @Step
    public MainPage clickLoginFormButton(){
        WebElement element = webDriver.findElement(loginFormButton);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new MainPage(webDriver);
    }

    @Step
    public PasswordRecoveryPage clickPasswordRecoveryLink(){
        WebElement element = webDriver.findElement(passwordRecoveryLink);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new PasswordRecoveryPage(webDriver);
    }

    @Step
    public LoginPage inputPassword(String password){
        webDriver.findElement(passwordInputField).sendKeys(password);
        return this;
    }
}
