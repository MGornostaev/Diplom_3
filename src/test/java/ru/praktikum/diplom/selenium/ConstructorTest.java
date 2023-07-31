package ru.praktikum.diplom.selenium;

import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import ru.praktikum.diplom.selenium.pageobject.MainPage;

public class ConstructorTest extends BaseTest{
    @Test
    @DisplayName("Switching tab to Sauce tab and checking its header")
    public void checkSwitchToSauceTab() {
        new MainPage(webDriver)
                .clickSauceTab()
                .checkSauceTabActive();
    }

    @Test
    @DisplayName("Switching tab to Bun tab and checking its header")
    public void checkSwitchToBunTab() {
        new MainPage(webDriver)
                .clickSauceTab()
                .clickBunTab()
                .checkBunTabActive();
    }

    @Test
    @DisplayName("Switching tab to Ingredients tab and checking its header")
    public void checkSwitchToIngredientsTab() {
        new MainPage(webDriver)
                .clickIngredientsTab()
                .checkIngredientsTabActive();
    }
}

