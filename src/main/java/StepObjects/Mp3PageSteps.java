package StepObjects;
import PageObjects.Mp3Page;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;

public class Mp3PageSteps {
    Mp3Page mp3Page=new Mp3Page();
    @Step("Mp3 Button Click ")
    public Mp3PageSteps ClickMp3Btn(){
        mp3Page.Mp3Btn.click();
        return this;
    }
    @Step("Hover Text visible Check")
    public Mp3PageSteps Hover(){
        mp3Page.hover.scrollTo().hover();
        if (mp3Page.Text.getText().equals("iPod Touch") && mp3Page.Text.isDisplayed()){
            System.out.println("iPod Touch is present");
        } else {
            System.out.println("iPod Touch its not present");
        }
        return this;
    }
    @Step("hover Click")
    public Mp3PageSteps ClickMBtn(){
        mp3Page.hover.click();
        return this;
    }
    @Step("Add Button Click")
    public Mp3PageSteps AddBtn(){
        mp3Page.AddBtn.click();
        return this;
    }
    @Step("Check Item Price And Count Correct")
    public Mp3PageSteps CheckPrice(){
        mp3Page.Cart.shouldBe(Condition.text(mp3Page.ItemCount.val() +" "+ "item(s) -" + " " + mp3Page.Price.getText()));
        Assert.assertEquals(mp3Page.ItemCount.val() +" "+ "item(s) -" + " " + mp3Page.Price.getText(),mp3Page.Cart.scrollTo().getText(),"Not Correct Price");
        return this;
    }
    @Step("Cart Click")
    public Mp3PageSteps CartBtn(){
        mp3Page.Cart.click();
        return this;
    }
    @Step("CheckOut Button Click")
    public Mp3PageSteps CheckOutBtn(){
        mp3Page.CheckOutBtn.click();
        return this;
    }
}
