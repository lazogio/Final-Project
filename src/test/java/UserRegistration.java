import DataObjects.Database;
import DataObjects.Users;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.sql.SQLException;

@Listeners(Screenshot.class)
@Epic("UsersRegistration")
@Feature("UsersRegistration Steps")
public class UserRegistration extends SetUp{
   @Feature("Insert and Registration")
    @Story("Insert and Registration LastUser")
    @Description("Update and Insert LastUsers,Registration")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1,description = "Registration LastUser")
public void setUser() throws SQLException {
        Users lastUsers = Database.GetLastUsers();
    basePageSteps
            .SetBasePage()
            .ClickRegister();
    databaseSteps
            .Selector();
    registerPageSteps
            .FillPage(lastUsers.getFirstName(), lastUsers.getLastName(), lastUsers.getEmail(),
                    lastUsers.getPhone(), lastUsers.getPassword(), lastUsers.getPassword())
            .SetNewsletter()
            .SetAgreeBtn()
            .SetContinueBtn();
    }

    @Feature("LapTop And Notebook")
    @Story("LapTop And Notebook")
    @Description("Check Laptop And Notebook Price")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2,groups ={"Regression1"},description = "Check Price And Sort")
    public void LapTop(){
        lapTopPageSteps
                .ClickLaptop()
                .ClickShowAll()
                .SortBtn();
    }

    @Feature("Mp3 Page")
    @Story("Mp3 Page")
    @Description("Open Mp3 Page and Add for buy item,also Check Price")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3,dependsOnMethods = "setUser",groups ={"Regression2"},description = "Buy New ipod and Check Price")
    public void ipodTest(){
        desktopPageSteps
                .ClickBtn()
                .SelectBtn();
        mp3PageSteps
                .ClickMp3Btn()
                .Hover()
                .ClickMBtn()
                .AddBtn()
                .CheckPrice();
    }

    @Feature("Order Item")
    @Story("Order Item")
    @Description("Open CheckOut page and Fill Billing Information, Check Actual And Expected Price")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority =4,retryAnalyzer = MyRetry.class,dependsOnMethods = "ipodTest",groups ={"Regression2"},description = "Fill Billing Information")
    public void OrderItem() throws SQLException{
        Users lastUsers = Database.GetLastUsers();
        mp3PageSteps
                .CartBtn()
                .CheckOutBtn();
        checkoutPageSteps
                .ReopenFill()
                .FillBillingDetails(lastUsers.getFirstName(), lastUsers.getLastName(), lastUsers.getAddress(),
                        lastUsers.getCity(), lastUsers.getZip(), lastUsers.getCountry(), lastUsers.getState())
                .SkipDeliver()
                .GetPrice()
                .ExpPrice()
                .ActualPrice();
    }
}

