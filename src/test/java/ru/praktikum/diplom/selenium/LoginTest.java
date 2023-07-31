package ru.praktikum.diplom.selenium;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom.selenium.pageobject.HeaderPanel;
import ru.praktikum.diplom.selenium.pageobject.MainPage;

public class LoginTest extends BaseTest {
    @Before
    public void prepareData() {
        userClient.userCreate(user);
    }

    @Test
    @DisplayName("Logging in from main page and checking presence of make order button")
    public void checkLoginFromMainPage() {
        new MainPage(webDriver)
                .clickLoginMainPageButton()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .checkMakeOrderButton();
    }

    @Test
    @DisplayName("Logging in from personal account and checking presence of make order button")
    public void checkLoginFromPersonalAccount() {
        new HeaderPanel(webDriver)
                .clickPersonalAccountButton()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .checkMakeOrderButton();
    }

    @Test
    @DisplayName("Logging in from registration page and checking presence of make order button")
    public void checkLoginFromRegistrationPage() {
        new HeaderPanel(webDriver)
                .clickPersonalAccountButton()
                .clickRegisterLink()
                .clickLoginRegisterPageLink()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .checkMakeOrderButton();
    }

    @Test
    @DisplayName("Logging in from password recovery page and checking presence of make order button")
    public void checkLoginFromPasswordRecoveryPage() {
        new HeaderPanel(webDriver)
                .clickPersonalAccountButton()
                .clickPasswordRecoveryLink()
                .clickLoginLink()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .checkMakeOrderButton();
    }
}
