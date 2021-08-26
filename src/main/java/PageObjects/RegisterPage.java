package PageObjects;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class RegisterPage {
    public SelenideElement firstName=$("#input-firstname");
    public SelenideElement lastName=$("#input-lastname");
    public SelenideElement email=$("#input-email");
    public SelenideElement telephone=$("#input-telephone");
    public SelenideElement password=$("#input-password");
    public SelenideElement ConfirmPassword=$("#input-confirm");
    public SelenideElement newsletter=$(byName("newsletter"));
    public SelenideElement AgreeBtn=$(byName("agree"));
    public SelenideElement ContinueBtn=$("input[value='Continue']");
}
