package stellarburgers.test;
import org.openqa.selenium.WebDriver;
import stellarburgers.pageobject.*;

public class AbstractTest
{
    protected final Boolean useOpera = true;
    protected final Boolean useYandex = true;
    protected WebDriver driver;
    protected MainPage mainPage;
    protected ProfilePage profilePage;

    protected LoginPage loginPage;

    protected RegisterPage registerPage;

    protected ForgotPasswordPage forgotPasswordPage;
    protected String userName = "Test User";
    protected String userEmail = "nata-tatarina15@mail.ru";
    protected String userPassword = "Q!67mo8)";

}
