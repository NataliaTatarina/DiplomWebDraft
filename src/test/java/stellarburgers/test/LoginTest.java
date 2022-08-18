package stellarburgers.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class LoginTest extends AbstractTest{
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
        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
    }

    @After
    public void closeDriverAndDeleteUser() {
         driver.quit();

        //// Удаление пользователя
    }
@Test
    public void tryq () {

    loginPage.fillFieldsAndClickButtonAuthorization(userEmail, userPassword);
    }
}
