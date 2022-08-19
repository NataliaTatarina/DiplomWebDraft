package stellarburgers.pageobject;

import stellarburgers.pageobject.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.hamcrest.CoreMatchers.equalTo;
public class MainPage {

    // Верхний заголовок - ссылка "Личный кабинет"
    @FindBy(xpath = "//div/header/nav/a/p[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement headerLinkPersonalCabinet;


    // Кнопка "Войти в аккаунт"/"Оформить заказ"
    @FindBy(xpath = "/html/body/div/div/main/section[2]/div/button")
    private SelenideElement buttonEntrance;

    // Нажать ссылку "Личный кабинет" без анализа результата
    public void headerLinkPersonalCabinetClick() {
        // Нажать кнопку "Личный кабинет"
        headerLinkPersonalCabinet.click();
    }
    public ProfilePage headerLinkPersonalCabinetClickForAuthorizedUser() {
        // Нажать кнопку "Личный кабинет"
        headerLinkPersonalCabinet.click();
        // Создать PO для ProfilePage
        ProfilePage profilePage = Selenide.page(ProfilePage.class);
        // Убедиться, что открылcя личный кабинет - есть надпись "Профиль"
       /* MatcherAssert.assertThat(
                "There is no link Profile",
                profilePage.getLinkProfilePersonalCabinet().getText(),
                equalTo("Профиль"));*/
        return profilePage;
    }

    // Нажать кнопку "Войти в аккаунт" на главной странице
    // Перейти на форму входа в профиль
    public LoginPage buttonLoginClick()
    {
        // Нажать кнопку "Войти в аккаунт"
        buttonEntrance.click();
        // Создать PO для LogimPage
        LoginPage loginPage = Selenide.page(LoginPage.class);
        // Убедиться, что открылась форма входа - есть надпись "Вход"
        MatcherAssert.assertThat(
                "Mistake testing - temp page is not authorization form",
                loginPage.getTitleEntrance().getText(),
                equalTo("Вход"));
        return loginPage;
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

}
