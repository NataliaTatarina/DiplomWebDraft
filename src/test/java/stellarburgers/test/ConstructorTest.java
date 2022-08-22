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

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class ConstructorTest extends AbstractTest {
    // Открытие страницы перед проведением тестов
    @Before
    public void startMainPageAndCreateUser() {
        //Выбор браузера
        if (useYandex) {
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\yandexdriver\\yandexdriver.exe");
            driver = new ChromeDriver();
        } else {
            if (useFirefox) {
                System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\geckodriver-v0.31.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else
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
    public void linkToppingsClickTest() throws InterruptedException {
        if (useFirefox)
            TimeUnit.SECONDS.sleep(3);
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
    public void linkBunsClickTest() throws InterruptedException {
        mainPage.getLinkToppings().click();
        mainPage.getLinkBuns().click();
        TimeUnit.SECONDS.sleep(3);
        Assert.assertTrue(
                "Mistake testing - link Buns isn't active",
                mainPage.getActiveLinkBuns().exists());
    }

}


