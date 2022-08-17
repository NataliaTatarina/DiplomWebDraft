package stellarburgers.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stellarburgers.pageobject.RegisterPage;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginPage {
    //// Форма авторизации - ссылка "Зарегистрироваться"
    @FindBy(xpath = "/html/body/div/div/main/div/div/p[1]/a")
    private SelenideElement linkGoToRegistration;

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

    // Нажать ссылку "Зарегистироваться" в нижнем меню формы входа в профиль
    // Перейти на форму регистрации
    public RegisterPage linkGoToRegistrationClock (){
        linkGoToRegistration.click();
        // Создать PO для RegisterPage
        RegisterPage registerPage = Selenide.page(RegisterPage.class);
        //// Убедиться, что открылась форма регистрации - есть надпись "Регистрация"
        MatcherAssert.assertThat(
                "Mistake opening registration form",
                registerPage.getTitleRegistration().getText(),
                equalTo("Регистрация"));
        return registerPage;
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

    public SelenideElement getLinkGoToRegistration() {
        return linkGoToRegistration;
    }

    public void setLinkGoToRegistration(SelenideElement linkGoToRegistration) {
        this.linkGoToRegistration = linkGoToRegistration;
    }
}
