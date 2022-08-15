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
    private SelenideElement buttonEntrance;

    // Форма авторизации - надпись "Вход"
    @FindBy(xpath = "/html/body/div/div/main/div/h2")
    private SelenideElement titleEntrance;

    // Форма авторизации - поле для ввода email
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement fieldEmailAuthorization;

    // Форма авторизации - поле для ввода пароля
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement fieldPasswordAuthorization;

    // Форма авторизации - кнопка "Войти"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/button")
    private SelenideElement buttonAuthorization;

    // Личный кабинет - ссылка "Профиль"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/nav/ul/li[1]/a")
    private SelenideElement linkProfilePersonalCabinet;

    //// Личный кабинет - ссылка "Выход"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/nav/ul/li[3]/button")
    private SelenideElement linkExitPersonalCabinet;


    // Нажать ссылку "Личный кабинет"
    public void headerLinkPersonalCabinetClick() {
        headerLinkPersonalCabinet.click();
    }

    // Нажать кнопку "Войти в аккаунт" на главной странице
    public void buttonLoginClick()
    {
        buttonEntrance.click();
    }

    // Нажать ссылку "Выход" в личном кабинете
    public void linkExitPersonalCabinetClick () {
        linkExitPersonalCabinet.click();
    }

    // Заполнить поля Email и Пароль на форме регистрации
    // Нажать кнопку "Войти" на форме регистрации
    public void fillFieldsAndClickButtonAuthorization(String userEmail, String userPassword)
    {
        fieldEmailAuthorization.setValue(userEmail);
        fieldPasswordAuthorization.setValue(userPassword);
        buttonAuthorization.click();
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


    public SelenideElement getButtonEntrance() {
        return buttonEntrance;
    }

    public void setButtonEntrance(SelenideElement buttonEntrance) {
        this.buttonEntrance = buttonEntrance;
    }

    public SelenideElement getButtonAuthorization() {
        return buttonAuthorization;
    }

    public void setButtonAuthorization(SelenideElement buttonAuthorization) {
        this.buttonAuthorization = buttonAuthorization;
    }

    public SelenideElement getFieldEmailAuthorization() {
        return fieldEmailAuthorization;
    }

    public void setFieldEmailAuthorization(SelenideElement fieldEmailAuthorization) {
        this.fieldEmailAuthorization = fieldEmailAuthorization;
    }

    public SelenideElement getFieldPasswordAuthorization() {
        return fieldPasswordAuthorization;
    }

    public void setFieldPasswordAuthorization(SelenideElement fieldPasswordAuthorization) {
        this.fieldPasswordAuthorization = fieldPasswordAuthorization;
    }

    public SelenideElement getLinkProfilePersonalCabinet() {
        return linkProfilePersonalCabinet;
    }

    public void setLinkProfilePersonalCabinet(SelenideElement linkProfilePersonalCabinet) {
        this.linkProfilePersonalCabinet = linkProfilePersonalCabinet;
    }
}
