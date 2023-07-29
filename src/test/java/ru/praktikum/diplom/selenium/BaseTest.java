package ru.praktikum.diplom.selenium;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.praktikum.diplom.selenium.user.Credentials;
import ru.praktikum.diplom.selenium.user.User;
import ru.praktikum.diplom.selenium.user.UserClient;

import java.util.concurrent.TimeUnit;

import static ru.praktikum.diplom.selenium.config.AppConfig.APP_URI;

public class BaseTest {
    WebDriver webDriver;
    protected User user = new User("Roman","romkaaa131111@yandex.ru","111222");
    protected UserClient userClient = new UserClient();

    String name = user.getName();
    String email = user.getEmail();
    String password = user.getPassword();
    String incorrectPassword = "111";

    @Before
    public void init(){
        webDriver = WebDriverFactory.get();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(APP_URI);
    }

    @After
    public void clean(){

        webDriver.quit();

        Credentials credentials = Credentials.from(user);
        try {
            ValidatableResponse loginResponse = userClient.userLogin(credentials);
            String token = userClient.getToken(loginResponse);
            if (token == null) {
                token = "";
            }
            userClient.userDelete(token);
        } catch (AssertionError error) {
            System.out.println(error.getMessage());
        }


    }
}
