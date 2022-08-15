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
    public void startMainPage() {
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

    @After
    public void closeDriver() {
        driver.quit();
    }

    // Проверка перехода в личный кабинет по ссылке в верхнем заголовке "Личный кабинет"
    // Пользователь создан, не авторизирован
    @Test
    public void clickPersonalCabinetWithoutAuthorizationTest() {
        // Нажать ссылку "Личный кабинет"
        mainPage.headerLinkPersonalCabinetClick();
        // Убедиться, что открылась форма для регистрации  - есть надпись Вход
        mainPage.print();
        MatcherAssert.assertThat(
                "Mistake testing temp page is authorization form",
                mainPage.getTitleEntrance().getText(),
                equalTo("Вход"));
            }

    // Проверка перехода в личный кабинет по ссылке в верхнем заголовке "Личный кабинет"
    // Пользователь создан
    @Test
    public void test()
    {
        System.out.println(mainPage.getButtonLogin().text());
    }
    // Авторизация - нажать "Войти в аккаунт", ввести корректные логин и пароль,
    // нажать "Войти",
    // убедиться, что кнопка "Войти в аккаунт" сменила надпись на "Оформить заказ"
    // Нажать ссылку "Личный кабинет"
    // Убедиться, что открывается личный кабинет - есть надпись "Профиль"


}
