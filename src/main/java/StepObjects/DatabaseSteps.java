package StepObjects;
import DataObjects.Database;
import DataObjects.Users;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class DatabaseSteps {
    static Users users;
    @Feature("Last Users Information")
    @Story("Inserts Last Users Information")
    @Description("Inserts Last Users Information")
    @Step("Insert Users")
    public DatabaseSteps Selector(){
        users = new Users();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
        String GeneratedString = RandomStringUtils.randomAlphabetic(12);
        String Email = GeneratedString + randomInt+ "@gmail.com";
        users.setEmail(Email);
        Database.InsertUsers(users.getFirstName(),users.getLastName(),users.getPhone(),users.getPassword(),
                users.getAddress(),users.getEmail(),users.getCountry(),
                users.getState(),users.getCity(),users.getZip());
        return this;
    }
}
