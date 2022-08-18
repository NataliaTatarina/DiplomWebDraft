package stellarburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterPage {

    //// Форма регистрации - надпись "Регистрация"
    @FindBy(xpath = "//div/main/div/h2[text()='Регистрация']")
    private SelenideElement titleRegistration;

    //// Форма регистрации - поле для ввода имени
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[1]/div/div/input[@name = 'name']")
    private SelenideElement fieldName;

    //// Форма регистрации - поле для ввода email
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[2]/div/div/input[@name = 'name']")
    private SelenideElement fieldEmail;

    //// Форма регистрации - поле для ввода пароля
    @FindBy(xpath = "/html/body/div/div/main/div/form/fieldset[3]/div/div/input[@name = 'Пароль']")

    private SelenideElement fieldPassword;

    //// Форма регистрации - кнопка "Зарегистрироваться"
    @FindBy(xpath = "/html/body/div/div/main/div/form/button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
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
        LoginPage loginPage = Selenide.page(LoginPage.class);
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not authorization form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
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
