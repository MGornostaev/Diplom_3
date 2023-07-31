package ru.praktikum.diplom.selenium.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class MainPage {
    WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private By loginMainPageButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private By bunTab = By.xpath(".//span[text() = 'Булки']");
    private By ingredientsTab = By.xpath(".//span[text() = 'Начинки']");
    private By sauceTab = By.xpath(".//span[text() = 'Соусы']");
    private By makeOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");
    private By sauceTabParent = By.xpath(".//span[text() = 'Соусы']/parent::div");
    private By bunTabParent = By.xpath(".//span[text() = 'Булки']/parent::div");
    private By ingredientsTabParent = By.xpath(".//span[text() = 'Начинки']/parent::div");

    @Step
    public AccountPage clickPersonalAccountButton() {
        WebElement element = webDriver.findElement(personalAccountButton);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new AccountPage(webDriver);
    }

    @Step
    public HeaderPanel clickPersonalAccountButtonLogged() {
        WebElement element = webDriver.findElement(personalAccountButton);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new HeaderPanel(webDriver);
    }

    @Step
    public LoginPage clickLoginMainPageButton() {
        WebElement element = webDriver.findElement(loginMainPageButton);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new LoginPage(webDriver);
    }

    @Step
    public void checkMakeOrderButton() {
        var isDisplayed = webDriver.findElement(makeOrderButton).isDisplayed();
        assertTrue("Не найдена кнопка заказа", isDisplayed);
    }

    @Step
    public MainPage clickBunTab() {
        WebElement element = webDriver.findElement(bunTab);
        ((JavascriptExecutor) webDriver)
                .executeScript("arguments[0].click();", element);

        return new MainPage(webDriver);
    }

    @Step
    public MainPage clickSauceTab() {
        WebElement element = webDriver.findElement(sauceTab);
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();

        return new MainPage(webDriver);
    }

    @Step
    public MainPage clickIngredientsTab() {
        WebElement element = webDriver.findElement(ingredientsTab);
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();

        return new MainPage(webDriver);
    }

    @Step
    public void checkSauceTabActive() {
        WebElement element = webDriver.findElement(sauceTabParent);

        String expectedResult = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        var actualResult = element.getAttribute("class");

        assertEquals("Таб не выбран", expectedResult, actualResult);
    }

    @Step
    public void checkBunTabActive() {
        WebElement element = webDriver.findElement(bunTabParent);

        String expectedResult = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        var actualResult = element.getAttribute("class");

        assertEquals("Таб не выбран", expectedResult, actualResult);
    }

    @Step
    public void checkIngredientsTabActive() {
        WebElement element = webDriver.findElement(ingredientsTabParent);

        String expectedResult = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        var actualResult = element.getAttribute("class");

        assertEquals("Таб не выбран", expectedResult, actualResult);
    }
}