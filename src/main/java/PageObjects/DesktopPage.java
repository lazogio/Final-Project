package PageObjects;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class DesktopPage {
    public SelenideElement DesktopBtn=$("[class='nav navbar-nav'] :nth-child(1) .dropdown-toggle");
    public SelenideElement ShowAllBtn=$("[class='nav navbar-nav'] :nth-child(2) .see-all");
}
