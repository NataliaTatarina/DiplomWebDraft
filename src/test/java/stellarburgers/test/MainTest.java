package stellarburgers.test;

import com.codeborne.selenide.Condition;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class MainTest extends AbstractTest {

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
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);

        //// Регистрация пользователя перед проведением тестов
    }

    @After
    public void closeDriverAndDeleteUser() {
        driver.quit();

        //// Удаление пользователя
    }

    // Проверка перехода в личный кабинет по ссылке в верхнем заголовке "Личный кабинет"
    // Пользователь создан, не авторизирован
    @Test
    public void clickPersonalCabinetWithoutAuthorizationTest() {
        // Нажать ссылку "Личный кабинет"
        mainPage.headerLinkPersonalCabinetClick();
        // Убедиться, что открылась форма для регистрации  - есть надпись "Вход"
        MatcherAssert.assertThat(
                "Mistake testing temp page is authorization form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
            }

    // Проверка перехода в личный кабинет по ссылке в верхнем заголовке "Личный кабинет"
    // Пользователь создан
    @Test
    public void test()
    {
        // Авторизация - нажать "Войти в аккаунт", ввести корректные логин и пароль,
        // нажать "Войти"
        mainPage.headerLinkPersonalCabinetClick();
        loginPage.fillFieldsAndClickButtonAuthorization(userEmail, userPassword);
        // Убедиться, что кнопка "Войти в аккаунт" сменила надпись на "Оформить заказ"
        MatcherAssert.assertThat(
                "Authorization was not successful",
                mainPage.getButtonEntrance().getText(),
                equalTo("Оформить заказ"));
        // Нажать ссылку "Личный кабинет"
        mainPage.headerLinkPersonalCabinetClick();
        // Убедиться, что открывается личный кабинет - есть ссылка "Профиль"
        MatcherAssert.assertThat(
                "There is no lonk@Profile",
                profilePage.getLinkProfilePersonalCabinet().getText(),
                equalTo("Профиль"));
        // Разлогиниться - нажать ссылку "Выход" в личном кабинете
        profilePage.linkExitPersonalCabinetClick();
    }

}
