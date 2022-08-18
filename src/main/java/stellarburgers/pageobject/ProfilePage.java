package stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {
    // Личный кабинет - ссылка "Профиль"
    @FindBy(how = How.XPATH, using = "/div/main/div/nav/ul/li[1]/a[@href='/account/profile']")
    private SelenideElement linkProfilePersonalCabinet;
    // Личный кабинет - ссылка "Выход"
    @FindBy(how = How.XPATH, using = "//div/main/div/nav/ul/li[3]/button[text()='Выход']")
    private SelenideElement linkExitPersonalCabinet;

    // Нажать ссылку "Выход" в личном кабинете
    public void linkExitPersonalCabinetClick () {
        linkExitPersonalCabinet.click();
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
