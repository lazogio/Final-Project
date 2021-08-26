package StepObjects;
import PageObjects.BasePage;
import io.qameta.allure.Step;

public class BasePageSteps {
    BasePage basePage= new BasePage();
    @Step("Click Account Button")
    public BasePageSteps SetBasePage(){
        basePage.MyAccountBtn.click();
        return this;
    }
    @Step("Click Register Button")
    public BasePageSteps ClickRegister(){
        basePage.RegisterBtn.click();
        return this;
    }
}
