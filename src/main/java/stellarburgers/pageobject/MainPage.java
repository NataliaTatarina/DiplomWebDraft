package stellarburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    /*
     @FindBy(xpath = "//div[@class='Home_Scooter__3YdJy']")
    private SelenideElement pictScooterFill;
    @FindBy(how = How.CLASS_NAME, using = "Header_Disclaimer__3VEni")
    private SelenideElement headerLogoDisclaimer;
    */

    // Верхний заголовок - ссылка "Личный кабинет"
    @FindBy(xpath = "//div/header/nav/a/p[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement headerLinkPersonalCabinet;


    // Кнопка "Войти в аккаунт"/"Оформить заказ"
    @FindBy(xpath = "/html/body/div/div/main/section[2]/div/button")
    private SelenideElement buttonLogin;

    // Форма авторизации - надпись "Вход"
    @FindBy(xpath = "/html/body/div/div/main/div/h2")
    private SelenideElement titleEntrance;

    //// Форма авторизации - поле для ввода email
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div")
    private SelenideElement fieldEmailAuthorization;

    //// Форма авторизации - поле для ввода пароля
    //// Форма авторизации - кнопка "Войти"

    // Нажать ссылку "Личный кабинет"
    public void headerLinkPersonalCabinetClick() {
        headerLinkPersonalCabinet.click();
    }

    // Нажать кнопку "Войти в аккаунт"
    public void buttonLoginClick()
    {
        buttonLogin.click();
    }

    public SelenideElement getTitleEntrance() {
        return titleEntrance;
    }

    public void setTitleEntrance(SelenideElement titleEntrance) {
        this.titleEntrance = titleEntrance;
    }

    public SelenideElement getHeaderLinkPersonalCabinet() {
        return headerLinkPersonalCabinet;
    }

    public void setHeaderLinkPersonalCabinet(SelenideElement headerLinkPersonalCabinet) {
        this.headerLinkPersonalCabinet = headerLinkPersonalCabinet;
    }

    public SelenideElement getButtonLogin() {
        return buttonLogin;
    }

    public void setButtonLogin(SelenideElement buttonLogin) {
        this.buttonLogin = buttonLogin;
    }
}
