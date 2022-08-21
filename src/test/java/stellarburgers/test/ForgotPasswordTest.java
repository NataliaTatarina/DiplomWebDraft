package stellarburgers.test;

import com.beust.ah.A;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import stellarburger.proc.DeleteUserAPI;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.hamcrest.Matchers.equalTo;

public class ForgotPasswordTest extends AbstractTest {
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
        // Отрытие главной страницы
        mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
    }

    @After
    public void closeDriverAndDeleteUser() {
       driver.quit();
    }

    // Авторизация по кнопке "Войти в аккаунт" на главной форме
    @Test
    public void getToForgotPasswordPageFromLoginTest() {
        // Нажать кнопку "Войти в аккаунт"
        loginPage = mainPage.buttonEntranceClickReturnLoginPage();
        // Проверить, что текущая страница - форма авторизации
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not login form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
        // Нажать ссылку "Восстановаить пароль"
        forgotPasswordPage = loginPage.linkRestorePasswordClick();
        // Убедиться, что открылась страница с восстановлением пароля
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not restore password form",
                forgotPasswordPage.getTitleRestorePassword().getText(),
                equalTo("Восстановление пароля"));
    }

}
