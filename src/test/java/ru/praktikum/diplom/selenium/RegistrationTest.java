package ru.praktikum.diplom.selenium;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.diplom.selenium.pageobject.HeaderPanel;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("Registration with valid data and checking presence of login form header")
    public void checkRegistrationWithValidData() {
        new HeaderPanel(webDriver)
                .clickPersonalAccountButton()
                .clickRegisterLink()
                .inputName(name)
                .inputEmail(email)
                .inputPassword(password)
                .clickRegisterButtonValid()
                .checkLoginPageFormHeader();
    }

    @Test
    @DisplayName("Registration with invalid data and checking presence of error message")
    public void checkRegistrationWithInvalidPassword() {
        new HeaderPanel(webDriver)
                .clickPersonalAccountButton()
                .clickRegisterLink()
                .inputName(name)
                .inputEmail(email)
                .inputPassword(incorrectPassword)
                .clickRegisterButtonInvalid()
                .checkInvalidPasswordMessage();
    }
}



