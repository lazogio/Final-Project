package StepObjects;
import DataObjects.Database;
import DataObjects.Users;
import PageObjects.CheckoutPage;
import PageObjects.Mp3Page;
import io.qameta.allure.*;
import org.testng.Assert;
import java.sql.SQLException;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class CheckoutPageSteps {
    CheckoutPage checkoutPage = new CheckoutPage();
    Mp3Page mp3Page=new Mp3Page();
    String FlatShipping,ExSubPrice, ExTotal, SubPrice, Total;
    static Users users;
    @Feature("Fill BillingDetail")
    @Story("Fill BillingDetail Value")
    @Description("Fill BillingDetail Value")
    @Step("Fill BillingDetails Value : {firstName}, {lastName}, {Address}, {City}, {Zipcode}, {County}, {State}}")
    public CheckoutPageSteps FillBillingDetails(String firstName,String lastName,String Address,String City,int Zipcode,String County,String State) throws SQLException {
        Users lastUsers = Database.GetLastUsers();
        checkoutPage.FirstName.setValue(lastUsers.getFirstName());
        checkoutPage.LastName.setValue(lastUsers.getLastName());
        checkoutPage.Address.setValue(lastUsers.getAddress());
        checkoutPage.City.setValue(lastUsers.getCity());
        checkoutPage.Zipcode.setValue(String.valueOf(lastUsers.getZip()));
        checkoutPage.CountryBtn.scrollTo().click();
        checkoutPage.CountryBtn.selectOption(lastUsers.getCountry());
        checkoutPage.StateBtn.click();
        checkoutPage.StateBtn.selectOption(lastUsers.getCity());
        checkoutPage.ContinueBtn.click();
        return this;
    }

    @Step("Skip Detail Deliver And Take Flat Ship Price")
    public CheckoutPageSteps SkipDeliver(){
        checkoutPage.ConfirmDeliverBtn.click();
        FlatShipping=  checkoutPage.FlatShip.shouldBe(visible).getText();
        FlatShipping= FlatShipping.replace("Flat Shipping Rate - ","");
        checkoutPage.ConfirmDelBtn.click();
        checkoutPage.AgreeBtn.click();
        checkoutPage.ContBtn.click();
        return this;
    }
    @Step("Reopen Fill Page")
    public CheckoutPageSteps ReopenFill(){
        if (!checkoutPage.PaymentNew.exists()) {
            checkoutPage.BillingDetailText.click();
            if (checkoutPage.ReopenNewAddress.exists()) {
                checkoutPage.ReopenNewAddress.click();
            }
        }
        return this;}

    @Step("Get Expected Price")
    public CheckoutPageSteps ExpPrice(){
        mp3Page.Cart.scrollTo().click();
        ExSubPrice = mp3Page.ExpectedSubTotal.shouldBe(exist).getText();
        ExTotal =mp3Page.ExpectedTotal.shouldBe(exist).getText();
        return  this;
    }
    @Step("Get Actual Sub Price And Price ")
    public CheckoutPageSteps GetPrice(){
        SubPrice =checkoutPage.ActualSubTotal.shouldBe(visible).getText();
        Total=checkoutPage.ActualTotal.shouldBe(visible).getText();
        return this;
    }
    @Feature("Check Actual Price")
    @Story("Check Actual Price")
    @Description("Check Actual Price And SubPrice, convert Total Price")
    @Step("Check Actual Price And Sub Price")
    public CheckoutPageSteps ActualPrice(){
        double i = Double.parseDouble(ExSubPrice.replace("$", ""));
        double j = Double.parseDouble(FlatShipping.replace("$", ""));
        double ExpTotalPrice =i+j;
        double AcTotalPrice =Double.parseDouble((Total.replace("$","")));
        Assert.assertEquals(SubPrice,ExSubPrice,"SubPrice Not Same");
        //Assert.assertEquals(Total,ExTotal,"Total Price Not Same"); // Total Price Not stability
        Assert.assertEquals(AcTotalPrice, ExpTotalPrice,"Total Price Not Same");
        return this;
    }
}
