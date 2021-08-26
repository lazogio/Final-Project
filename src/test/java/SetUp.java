import StepObjects.*;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.open;

public class SetUp {
    public SetUp(){
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
        Configuration.timeout=5000;
        open("http://tutorialsninja.com/demo/");
    }
    BasePageSteps basePageSteps= new BasePageSteps();
    DatabaseSteps databaseSteps=new DatabaseSteps();
    RegisterPageSteps registerPageSteps= new RegisterPageSteps();
    LapTopPageSteps lapTopPageSteps= new LapTopPageSteps();
    DesktopPageSteps desktopPageSteps=new DesktopPageSteps();
    Mp3PageSteps mp3PageSteps=new Mp3PageSteps();
    CheckoutPageSteps checkoutPageSteps =new CheckoutPageSteps();
}
