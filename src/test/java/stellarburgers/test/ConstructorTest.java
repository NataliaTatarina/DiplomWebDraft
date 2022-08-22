package stellarburgers.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverLogLevel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class ConstructorTest extends AbstractTest {
    // Открытие страницы перед проведением тестов
    @Before
    public void startMainPageAndCreateUser() {
        //Выбор браузера
        if (useYandex) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model
            //options.setLogLevel(ChromeDriverLogLevel.OFF);
            System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\yandexdriver\\yandexdriver.exe");
            //options.setBinary("C:\\WebDriver\\yandexdriver\\yandexdriver.exe");
            driver = new ChromeDriver(options);
        } else {
            if (useOpera){

                System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\geckodriver-v0.31.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver();} else
            driver = new ChromeDriver();
        }
        setWebDriver(driver);
        //Отрытие главной страницы
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
    }

    @After
    public void closeDriverAndDeleteUser() {
        driver.quit();
    }

    @Test
    public void linkToppingsClickTest() {
        mainPage.getLinkToppings().click();
        Assert.assertTrue(
                "Mistake testing - link Toppings isn't active",
                mainPage.getActiveLinkToppings().exists());
        }

    @Test
    public void linkSaucesClickTest() {
        mainPage.getLinkSauces().click();
        Assert.assertTrue(
                "Mistake testing - link Sauces isn't active",
                mainPage.getActiveLinkSauces().exists());
    }

    @Test
    public void linkBunsClickTest() {
        mainPage.getLinkToppings().click();
        mainPage.getLinkBuns().click();
        Assert.assertTrue(
                "Mistake testing - link Toppings isn't active",
                mainPage.getActiveLinkBuns().exists());
    }

}


