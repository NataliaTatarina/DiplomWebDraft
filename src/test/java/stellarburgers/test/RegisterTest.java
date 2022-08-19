package stellarburgers.test;

import com.codeborne.selenide.Selenide;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import stellarburger.proc.DeleteUserAPI;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.hamcrest.Matchers.equalTo;

public class RegisterTest extends AbstractTest {
    //Открытие страницы перед проведением тестов
    @Before
        public void startMainPageAndCreateUser() {
        //Выбор браузера
        if (useOpera) {
            driver = new OperaDriver();
        } else {
            driver = new ChromeDriver();
        }
        setWebDriver(driver);
        //Отрытие главной страницы
        mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }


    @Test
    public void successRegistrationTest() {

        // Перейти к регистрации по клику на "Войти в аккаунт"
        // Убедиться, что открылась форма входа - есть надпись "Вход"
        loginPage = mainPage.buttonLoginClick();
        System.out.println(driver.getCurrentUrl());
        // Нажать ссылку - "Зарегистрироваться"
        registerPage = loginPage.linkGoToRegistrationClick();
        System.out.println(driver.getCurrentUrl());
        // Заполнить корректно поля "Имя", "Email", "Пароль"
        // Нажать кнопку "Зарегистрироваться"
        // Проверить, что вернулись на форму входа - есть надпись "Вход"
        registerPage.fillFieldsAndButtonClickRegistration(userName, userEmail, userPassword);
        LoginPage loginPage = Selenide.page(LoginPage.class);
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not authorization form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
        System.out.println(driver.getCurrentUrl());
        // Удалить пользователя
        DeleteUserAPI.deleteUserAPI(userEmail, userPassword);
    }

    @Test
    public void registrationWithShortPasswordFallsTest() {
        // Перейти к регистрации по клику на "Войти в аккаунт"
        // Убедиться, что открылась форма входа - есть надпись "Вход"
        loginPage = mainPage.buttonLoginClick();
        System.out.println(driver.getCurrentUrl());
        // Нажать ссылку - "Зарегистрироваться"
        registerPage = loginPage.linkGoToRegistrationClick();
        System.out.println(driver.getCurrentUrl());
        // Заполнить корректно поля "Имя", "Email"
        // Ввести в поле "Пароль" некорректное значение - строку длиной 5 символов
        // Нажать кнопку "Зарегистрироваться"
        // Проверить, что вернулись на форму входа - есть надпись "Вход"
        registerPage.fillFieldsAndButtonClickRegistration(userName, userEmail,
                userPassword.substring(0, 5));
        // Проверить, что в появилось сообщение об ошибке
        Assert.assertTrue("Mistake testing - there is no error message for short password",
                registerPage.getWrongPasswordErrorMessage().isDisplayed());
        System.out.println(driver.getCurrentUrl());
    }
}
