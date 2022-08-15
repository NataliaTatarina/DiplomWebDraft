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

// Верхнее меню
    // Надпись "Личный кабинет"
   // @FindBy(xpath = "//*[@id=\"root\"]/div/header/nav/a/p[@class='AppHeader_header__linkText__3q_va ml-2']")
   @FindBy(xpath = "//div/header/nav/a/p[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement headerPersonalCabinet;









    public void butClick(){
        //System.out.println(headerPersonalCabinet.text());
        headerPersonalCabinet.click();
    }

    public SelenideElement getHeaderPersonalCabinet() {
        return headerPersonalCabinet;
    }

    public void setHeaderPersonalCabinet(SelenideElement headerPersonalCabinet) {
        this.headerPersonalCabinet = headerPersonalCabinet;
    }
}
