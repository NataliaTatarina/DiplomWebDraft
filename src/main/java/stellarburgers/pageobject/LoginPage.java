package stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    //// Форма авторизации - ссылка "Зарегистрироваться"

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

    public SelenideElement getButtonAuthorization() {
        return buttonAuthorization;
    }

    public void setButtonAuthorization(SelenideElement buttonAuthorization) {
        this.buttonAuthorization = buttonAuthorization;
    }
}
