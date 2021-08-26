package PageObjects;
import static com.codeborne.selenide.Selectors.*;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

public class Mp3Page {
    public SelenideElement Mp3Btn=$("[class='col-sm-3 hidden-xs'] :nth-child(10)");
    public SelenideElement hover=$(byTitle("iPod Touch"));
    public SelenideElement Text=$(byXpath("//a[text()='iPod Touch']"));
    public SelenideElement AddBtn=$("#button-cart");
    public SelenideElement Price=$("[class='col-sm-4'] :nth-child(4) :nth-child(1)");
    public SelenideElement ItemCount=$("#input-quantity");
    public SelenideElement Cart=$("#cart-total");
    public SelenideElement ExpectedSubTotal=$(byXpath("//div[@id = 'cart']//table[@class = 'table table-bordered']//strong[text() = 'Sub-Total']/parent::td/following-sibling::td"));
    public SelenideElement ExpectedTotal=$(byXpath("//div[@id = 'cart']//table[@class = 'table table-bordered']//strong[text() = 'Total']/parent::td/following-sibling::td"));
    public SelenideElement CheckOutBtn=$("[class='text-right'] :nth-child(2)");
}
