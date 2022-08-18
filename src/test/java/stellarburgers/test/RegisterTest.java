package stellarburgers.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class RegisterTest extends AbstractTest {
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
    }

    @After
    public void closeDriverAndDeleteUser() {
      driver.quit();

        //// Удаление пользователя
    }

    @Test
    public void successRegistrationTest() {
        // Перейти к регистрации по клику на "Войти в аккаунт"
        // Убедиться, что открылась форма входа - есть надпись "Вход"
        loginPage = mainPage.buttonLoginClick();
        System.out.println(driver.getCurrentUrl());
        // Нажать ссылку - "Зарегистрироваться"
        registerPage = loginPage.linkGoToRegistrationClick();
        System.out.println(driver.getCurrentUrl());
        // Заполнить корректно поля "Имя", "Email", "Пароль"
        // Нажать кнопку "Зарегистрироваться"
        // Проверить, что вернулись на форму входа - есть надпись "Вход"
        registerPage.fillFieldsAndButtonClickRegistration(userName, userEmail, userPassword);
        System.out.println(driver.getCurrentUrl());
    }





    //// Удалить учетную запись пользователя
/*
// Удалить пользователя
        deleteUserCheckStatus(requestSpec, userRegister, token);
public static void deleteUserCheckStatus(RequestSpecification requestSpec, UserRegister userRegister, String token) {
        given()
                .spec(requestSpec)
                .and()
                .body(userRegister)
                .auth().oauth2(token)
                .when()
                .delete("auth/user")
                .then()
                .statusCode(SC_ACCEPTED);
    }
 */


}
