package StepObjects;
import PageObjects.DesktopPage;
import io.qameta.allure.Step;

public class DesktopPageSteps {
    DesktopPage desktopPage= new DesktopPage();
    @Step("Desktop Button Click")
    public DesktopPageSteps ClickBtn(){
        desktopPage.DesktopBtn.click();
        return this;
    }
    @Step("Show All Button Click")
    public DesktopPageSteps SelectBtn(){
        desktopPage.ShowAllBtn.click();
        return this;
    }
}
