import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screenshot implements ITestListener {
    @Attachment(value="web page Screenshot",type="image/png")
    public byte[] takeScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs( OutputType.BYTES);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = com.codeborne.selenide.WebDriverRunner.getWebDriver();
        takeScreenshot(driver);
    }
}
