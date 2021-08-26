package StepObjects;
import PageObjects.LaptopPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class LapTopPageSteps {
    LaptopPage laptopPage= new LaptopPage();
    @Step("LapTop And Notebook Button Click")
    public LapTopPageSteps ClickLaptop(){
        laptopPage.LaptopNotebooksBtn.click();
        return this;
    }
    @Step("Show All Button Click")
    public LapTopPageSteps ClickShowAll(){
        laptopPage.ShowAllBtn.click();
        return this;
    }

    @Step("Check Short")
    public LapTopPageSteps SortBtn(){
        String[] BeforeSort=new String[laptopPage.Price.size()];
        for (int i=0;i<laptopPage.Price.size();i++){
            BeforeSort[i]=laptopPage.Price.get(i).getText();
        }
        laptopPage.SortBtn.click();
        laptopPage.PriceSortBtn.click();
        String[] AfterSort=new String[laptopPage.AfterSortPrice.size()];
        for (int i=0;i<laptopPage.AfterSortPrice.size();i++){
            AfterSort[i]=laptopPage.AfterSortPrice.get(i).getText();
        }
       Assert.assertNotEquals(AfterSort,BeforeSort,"Sort Not Work");
        return this;
    }
}
