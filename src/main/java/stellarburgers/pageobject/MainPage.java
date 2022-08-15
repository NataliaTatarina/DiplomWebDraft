package stellarburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    // Верхний заголовок - ссылка "Личный кабинет"
    @FindBy(xpath = "//div/header/nav/a/p[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement headerLinkPersonalCabinet;


    // Кнопка "Войти в аккаунт"/"Оформить заказ"
    @FindBy(xpath = "/html/body/div/div/main/section[2]/div/button")
    private SelenideElement buttonEntrance;

    // Нажать ссылку "Личный кабинет"
    public void headerLinkPersonalCabinetClick() {
        headerLinkPersonalCabinet.click();
    }

    // Нажать кнопку "Войти в аккаунт" на главной странице
    public void buttonLoginClick()
    {
        buttonEntrance.click();
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
