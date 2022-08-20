package stellarburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterPage {
    // Верхний заголовок - ссылка "Личный кабинет"
    @FindBy(xpath = "//div/header/nav/a/p[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement headerLinkPersonalCabinet;

    // Форма регистрации - надпись "Регистрация"
    @FindBy(xpath = "//div/main/div/h2[text()='Регистрация']")
    private SelenideElement titleRegistration;

    // Форма регистрации - поле для ввода имени
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[1]/div/div/input[@name = 'name']")
    private SelenideElement fieldName;

    // Форма регистрации - поле для ввода email
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[2]/div/div/input[@name = 'name']")
    private SelenideElement fieldEmail;

    // Форма регистрации - поле для ввода пароля
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[3]/div/div/input[@name = 'Пароль']")
    private SelenideElement fieldPassword;

    // Форма регистрации - кнопка "Зарегистрироваться"
    @FindBy(xpath = "/html/body/div/div/main/div/form/button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement buttonRegister;

    // Форма регистрации - сообщение "Некорректный пароль"
    @FindBy(xpath = "//div/main/div/form/fieldset[3]/div/p[@class='input__error text_type_main-default']")
    private SelenideElement wrongPasswordErrorMessage;

    public SelenideElement getTitleRegistration() {
        return titleRegistration;
    }
    public void fillFieldsAndButtonClickRegistration  (String userName, String userEmail, String userPassword)
    {

        fieldName.setValue(userName);
        fieldEmail.setValue(userEmail);
        fieldPassword.setValue(userPassword);
        buttonRegister.click();
    }
    public LoginPage fillFieldsAndButtonClickRegistration1  (String userName, String userEmail, String userPassword)
    {

        fieldName.setValue(userName);
        fieldEmail.setValue(userEmail);
        fieldPassword.setValue(userPassword);
        buttonRegister.click();
        LoginPage loginPage = Selenide.page(LoginPage.class);
        return loginPage;
    }

    public void headerLinkPersonalCabinetClick()
    {
        headerLinkPersonalCabinet.click();
    }

    public LoginPage headerLinkPersonalCabinetClick1()
    {
        headerLinkPersonalCabinet.click();
        LoginPage loginPage = Selenide.page(LoginPage.class);
        return loginPage;
    }
       public void setTitleRegistration(SelenideElement titleRegistration) {
        this.titleRegistration = titleRegistration;
    }

    public SelenideElement getFieldName() {
        return fieldName;
    }

    public void setFieldName(SelenideElement fieldName) {
        this.fieldName = fieldName;
    }

    public SelenideElement getFieldEmail() {
        return fieldEmail;
    }

    public void setFieldEmail(SelenideElement fieldEmail) {
        this.fieldEmail = fieldEmail;
    }

    public SelenideElement getFieldPassword() {
        return fieldPassword;
    }

    public void setFieldPassword(SelenideElement fieldPassword) {
        this.fieldPassword = fieldPassword;
    }

    public SelenideElement getButtonRegister() {
        return buttonRegister;
    }

    public void setButtonRegister(SelenideElement buttonRegister) {
        this.buttonRegister = buttonRegister;
    }

    public SelenideElement getWrongPasswordErrorMessage() {
        return wrongPasswordErrorMessage;
    }

    public void setWrongPasswordErrorMessage(SelenideElement wrongPasswordErrorMessage) {
        this.wrongPasswordErrorMessage = wrongPasswordErrorMessage;
    }

}
