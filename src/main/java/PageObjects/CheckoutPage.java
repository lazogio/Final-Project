package PageObjects;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class CheckoutPage {
    public SelenideElement FirstName=$("#input-payment-firstname");
    public SelenideElement LastName=$("#input-payment-lastname");
    public SelenideElement Address=$("#input-payment-address-1");
    public SelenideElement City=$("#input-payment-city");
    public SelenideElement Zipcode=$("#input-payment-postcode");
    public SelenideElement CountryBtn= $("#input-payment-country");
    public SelenideElement StateBtn= $("#input-payment-zone");
    public SelenideElement ContinueBtn= $("#button-payment-address");
    public SelenideElement ConfirmDeliverBtn= $("#button-shipping-address");
    public SelenideElement ConfirmDelBtn= $("#button-shipping-method");
    public SelenideElement AgreeBtn= $(byName("agree"));
    public SelenideElement ContBtn= $("#button-payment-method");
    public SelenideElement PaymentNew=$("#payment-new");
    public SelenideElement BillingDetailText=$(byClassName("accordion-toggle"));
    public SelenideElement ReopenNewAddress=$(byXpath("//input[@value='new']"));
    public SelenideElement ActualSubTotal= $(byXpath(".//tfoot//tr[1]//td[2]"));
    public SelenideElement ActualTotal= $(byXpath(".//tfoot//tr[3]//td[2]"));
    public SelenideElement FlatShip =$(byXpath("//*[@id='collapse-shipping-method']/div/div[1]/label"));
}