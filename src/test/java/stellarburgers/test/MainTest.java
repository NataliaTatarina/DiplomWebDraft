package stellarburgers.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import stellarburger.proc.DeleteUserAPI;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class MainTest extends AbstractTest {

    // Открытие страницы перед проведением тестов
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
        // Создать учетную запись пользователя
        loginPage = mainPage.buttonLoginClick();
        registerPage = loginPage.linkGoToRegistrationClick();
        registerPage.fillFieldsAndButtonClickRegistration(userName, userEmail, userPassword);

    }

    @After
    public void closeDriverAndDeleteUser() {
        //driver.quit();
    }

    // Проверка перехода в личный кабинет по ссылке в верхнем заголовке "Личный кабинет"
    // Пользователь не авторизирован - должны быть перенеправлены на страницу авторизации
    @Test
    public void clickPersonalCabinetWithoutAuthorizationTest() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        // Нажать ссылку "Личный кабинет"
        loginPage = mainPage.headerLinkPersonalCabinetClickWithountAuthorization();
        // Убедиться, что открылась форма для регистрации - есть надпись "Вход"
        MatcherAssert.assertThat(
                "Mistake - temp page is not authorization form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
    }

    // Проверка перехода в личный кабинет по ссылке в верхнем заголовке "Личный кабинет"
    // Пользователь авторизирован - должны быть перенаправлены на страницу с профилем пользователя
    @Test
    public void clickPersonalCabinetWithAuthorizationTest() {
        // Авторизация - ввести корректные логин и пароль, нажать "Войти"
        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.fillFieldsAndClickButtonAuthorization(userEmail, userPassword);
        // Нажать ссылку "Личный кабинет"
        profilePage = mainPage.headerLinkPersonalCabinetClickForAuthorizedUser();
        // Убедиться, что открывается личный кабинет - есть ссылка "Профиль"
        MatcherAssert.assertThat(
                "There is no link Profile",
                profilePage.getLinkProfilePersonalCabinet().getText(),
                equalTo("Профиль"));
        // Разлогиниться - нажать ссылку "Выход" в личном кабинете
        profilePage.linkExitPersonalCabinetClick();
        // Удалить учетную запись пользователя
       DeleteUserAPI.deleteUserAPI(userEmail, userPassword);
    }




}
