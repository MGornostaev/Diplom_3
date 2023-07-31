package ru.praktikum.diplom.selenium;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.diplom.selenium.pageobject.HeaderPanel;

public class PersonalAccountTest extends BaseTest{
    @Before
    public void prepareData() {
        userClient.userCreate(user);
    }

    @Test
    @DisplayName("Entering personal account and checking presence of logout button")
    public void checkPersonalAccount() {
        new HeaderPanel(webDriver)
                .clickPersonalAccountButton()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .clickPersonalAccountButton()
                .checkLogoutButton();
    }

    @Test
    @DisplayName("Switching from personal account to Constructor by Constructor button and checking presence of make order button")
    public void checkPersonalAccountToConstructorUsingConstructorButton() {
        new HeaderPanel(webDriver)
                .clickPersonalAccountButton()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .clickPersonalAccountButtonLogged()
                .clickConstructorButton()
                .checkMakeOrderButton();
    }

    @Test
    @DisplayName("Switching from personal account to Constructor by App logo and checking presence of make order button")
    public void checkPersonalAccountToConstructorUsingAppLogo() {
        new HeaderPanel(webDriver)
                .clickPersonalAccountButton()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .clickPersonalAccountButtonLogged()
                .clickAppLogo()
                .checkMakeOrderButton();
    }

    @Test
    @DisplayName("Logout from personal account and checking presence of login form header")
    public void checkPersonalAccountLogout() {
        new HeaderPanel(webDriver)
                .clickPersonalAccountButton()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .clickPersonalAccountButton()
                .clickLogoutButton()
                .checkLoginPageFormHeader();
    }
}
