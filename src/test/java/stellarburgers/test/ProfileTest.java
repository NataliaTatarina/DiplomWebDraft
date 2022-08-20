package stellarburgers.test;

import com.codeborne.selenide.Selenide;
import org.hamcrest.CoreMatchers;
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
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProfileTest extends AbstractTest {
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

    }

    // Закрыть приложение
    // Удалить учетную запись пользователя
    @After
    public void closeDriverAndDeleteUser() {
        // driver.quit();
        // Удалить учетную запись пользователя
        DeleteUserAPI.deleteUserAPI(userEmail, userPassword);
    }

    @Test
    public void linkExitClickTest() {

        // Разлогиниться - нажать ссылку "Выход" в личном кабинете
        loginPage = profilePage.linkExitPersonalCabinetClickBackToLoginPage();
        // Убедиться, что вернулись на страницу авторизации
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not authorization form",
                loginPage.getTitleEntrance().getText(),
                CoreMatchers.equalTo("Вход"));
    }

}
