package PageObjects;
import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LaptopPage {
    public SelenideElement LaptopNotebooksBtn=$(byXpath("//a[text()='Laptops & Notebooks']"));
    public SelenideElement ShowAllBtn=$(byXpath("//a[text()='Show All Laptops & Notebooks']"));
    public SelenideElement SortBtn=$("#input-sort");
    public SelenideElement PriceSortBtn=$(byValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC"));
    public  ElementsCollection Price= $$("[class~='price']");
    public  ElementsCollection AfterSortPrice= $$("[class~='price']");
}
