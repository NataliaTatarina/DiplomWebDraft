package stellarburgers.test;
import org.openqa.selenium.WebDriver;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;
import stellarburgers.pageobject.ProfilePage;

public class AbstractTest
{
    protected final Boolean useOpera = false;
    protected WebDriver driver;
    protected MainPage mainPage;
    protected ProfilePage profilePage;

    protected LoginPage loginPage;

    protected String userEmail = "nata-tatarina@mail.ru";
    protected String userPassword = "Q!67mo8)";

}
