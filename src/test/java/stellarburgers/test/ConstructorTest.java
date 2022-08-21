package stellarburgers.test;

import com.codeborne.selenide.Condition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class ConstructorTest extends AbstractTest {
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

    @After
    public void closeDriverAndDeleteUser() {
        //driver.quit();
    }

    @Test
    // Подготовка к тестированию конструтора
    public void constructorTest() {
        System.out.println("Buns");
        System.out.println(mainPage.getLinkBuns().getText());
        System.out.println("Toppings");
        System.out.println(mainPage.getLinkToppings().getText());
        System.out.println("Sauces");
        System.out.println(mainPage.getLinkSauces().getText());

    }

    @Test
    public void linkToppingsClickTest() {
        // Нажать ссылку "Начинки"
        System.out.println("START-START-START");
        System.out.println(
             mainPage.getQwerty().exists()
        );
        mainPage.getLinkToppings().click();
        System.out.println("FINISH-FINISH-FINISH");
        System.out.println(
                mainPage.getQwerty().exists()
        );

    }
}


