package stellarburgers.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    // Личный кабинет - ссылка "Профиль"
    @FindBy(how = How.XPATH, using = "//div/main/div/nav/ul/li[1]/a[text()='Профиль']")
    private SelenideElement linkProfilePersonalCabinet;

    // Личный кабинет - ссылка "Выход"
    @FindBy(how = How.XPATH, using = "//div/main/div/nav/ul/li[3]/button[text()='Выход']")
    private SelenideElement linkExitPersonalCabinet;

    // Верхнее меню - логотип
    @FindBy(how = How.XPATH, using = "//div/header/nav/div/a/svg")
    private SelenideElement stellarBurgersLogo;

    // Верхнее меню - ссылка "Конструктор"
    @FindBy(how = How.XPATH, using = "//div/header/nav/ul/li[1]/a/p[text()='Конструктор']")
    private SelenideElement linkConstructor;

    // Нажать ссылку "Выход" в личном кабинете
    public void linkExitPersonalCabinetClick () {
        linkExitPersonalCabinet.click();
    }

    // Нажать ссылку "Выход" - вернуться на форму авторизации
    public LoginPage linkExitPersonalCabinetClickBackToLoginPage () {
        linkExitPersonalCabinet.click();
        // Создать PO для ProfilePage
        LoginPage loginPage = Selenide.page(LoginPage.class);
        return loginPage;
    }

    // Нажать на логотип StellarBurger в верхнем меню
    public MainPage stellarBurgersLogoClick(){
        stellarBurgersLogo.click();
        // Создать PO для MainPage
        MainPage mainPage = Selenide.page(MainPage.class);
        return mainPage;
    }

    public SelenideElement getLinkProfilePersonalCabinet() {
        return linkProfilePersonalCabinet;
    }

    public void setLinkProfilePersonalCabinet(SelenideElement linkProfilePersonalCabinet) {
        this.linkProfilePersonalCabinet = linkProfilePersonalCabinet;
    }

    public SelenideElement getLinkExitPersonalCabinet() {
        return linkExitPersonalCabinet;
    }

    public void setLinkExitPersonalCabinet(SelenideElement linkExitPersonalCabinet) {
        this.linkExitPersonalCabinet = linkExitPersonalCabinet;
    }
}
