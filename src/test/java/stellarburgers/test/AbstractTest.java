package stellarburgers.test;
import org.openqa.selenium.WebDriver;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;
import stellarburgers.pageobject.ProfilePage;
import stellarburgers.pageobject.RegisterPage;

public class AbstractTest
{
    protected final Boolean useOpera = false;
    protected WebDriver driver;
    protected MainPage mainPage;
    protected ProfilePage profilePage;

    protected LoginPage loginPage;

    protected RegisterPage registerPage;

    protected String userName = "Test User";
    protected String userEmail = "nata-tatarina1@mail.ru";
    protected String userPassword = "Q!67mo8)";

}
