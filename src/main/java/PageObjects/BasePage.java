package PageObjects;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
  public SelenideElement MyAccountBtn =$("a[title='My Account']");
  public SelenideElement RegisterBtn=$(byXpath("//a[text()='Register']"));
}
