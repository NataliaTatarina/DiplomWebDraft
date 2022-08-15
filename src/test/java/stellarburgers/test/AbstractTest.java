package stellarburgers.test;
import org.openqa.selenium.WebDriver;
import stellarburgers.pageobject.MainPage;

public class AbstractTest
{
    protected final Boolean useOpera = false;
    protected WebDriver driver;
    protected MainPage mainPage;

    protected String userEmail = "nata-tatarina@mail.ru";
    protected String userPassword = "Q!67mo8)";

}
