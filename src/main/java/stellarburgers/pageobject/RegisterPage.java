package stellarburgers.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterPage {

    //// Форма регистрации - надпись "Регистрация"
    @FindBy(xpath = "/html/body/div/div/main/div/h2")
    private SelenideElement titleRegistration;

    //// Форма регистрации - поле для ввода имени
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement fieldName;

    //// Форма регистрации - поле для ввода email
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement fieldEmail;

    //// Форма регистрации - поле для ввода пароля
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[3]/div/div/input")

    private SelenideElement fieldPassword;

    //// Форма регистрации - кнопка "Зарегистрироваться"
    @FindBy(xpath = "/html/body/div/div/main/div/form/button")
    private SelenideElement buttonRegister;

    public SelenideElement getTitleRegistration() {
        return titleRegistration;
    }
    public void fillFieldsAndButtonClickRegistration  (String userName, String userEmail, String userPassword)
    {
        fieldName.setValue(userName);
        fieldEmail.setValue(userEmail);
        fieldPassword.setValue(userPassword);
        buttonRegister.click();
        System.out.println(buttonRegister.getText());
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
}
