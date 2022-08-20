package stellarburgers.test;

import org.hamcrest.MatcherAssert;
import org.junit.After;
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

public class LoginTest extends AbstractTest {
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
        // Создать учетную запись пользователя
        loginPage = mainPage.buttonEntranceClickReturnLoginPage();
        registerPage = loginPage.linkGoToRegistrationClick();
        registerPage.fillFieldsAndButtonClickRegistration(userName, userEmail, userPassword);
        registerPage.stellarBurgersLogoClick();
    }

    @After
    public void closeDriverAndDeleteUser() {
        // Убедиться, что открылась форма авторизации
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not authorization form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
        // Выполнить авторизацию
        loginPage.fillFieldsAndClickButtonAuthorization(userEmail, userPassword);
        // Убедиться, что на главной странице появиась кнопка "Оформить заказ"
        System.out.println(mainPage.getButtonEntrance().getText());
        MatcherAssert.assertThat(
                "Mistake testing - authorization failed",
                mainPage.getButtonEntrance().getText(),
                equalTo("Оформить заказ"));
        // Разлогиниться - нажать ссылку "Личный кабинет"
        profilePage = mainPage.headerLinkPersonalCabinetClickForAuthorizedUser();
        // Разлогиниться - нажать ссылку "Выход" в личном кабинете
        profilePage.linkExitPersonalCabinetClick();
        // driver.quit();
        // Удалить пользователя
        DeleteUserAPI.deleteUserAPI(userEmail, userPassword);
    }

    // Авторизация по кнопке "Войти в аккаунт" на главной форме
    @Test
    public void getToLoginPageFromMainPageByButtonEnterAccountClick() {
        // Нажать кнопку "Войти в аккаунт"
        mainPage.buttonEntranceClick();
    }

    // Авторизация по кнопке "Личный кабинет" на главной форме
    @Test
    public void getToLoginPageFromMainPageByLinkPersonalAccountClick() {
        // Нажать кнопку "Личный кабинет"
       loginPage = mainPage.headerLinkPersonalCabinetClickWithountAuthorization();
    }

    // Авторизация по кнопке "Личный кабинет" на форме регистрации
    @Test
    public void getToLoginPageFromRegisterPageByLinkPersonalAccountClick() {
    }

    // Авторизация по ссылке "Войти" на форме регистрации
    @Test
    public void getToLoginPageFromRegisterPageByLinkEnterClick() {
    }

    // Авторизация по кнопке "Личный кабинет" на форме восстановления пароля
    @Test
    public void getToLoginPageFromForgotPasswordPageByLinkPersonalAccountClick() {
    }

    // Авторизация по ссылке "Войти" на форме восстановления пароля
    @Test
    public void getToLoginPageFromForgotPasswordPageByLinkEnterClick() {
    }


}
