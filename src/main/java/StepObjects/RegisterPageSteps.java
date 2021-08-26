package StepObjects;
import DataObjects.Database;
import DataObjects.Users;
import PageObjects.RegisterPage;
import io.qameta.allure.*;

import java.sql.SQLException;

public class RegisterPageSteps {
    static Users users;
    RegisterPage registerPage= new RegisterPage();
    @Step("Fill Registration Value : {firstName}, {lastName}, {email}, {telephone}, {password}, {password}}")
    public RegisterPageSteps FillPage(String firstName,String lastName,String email,String telephone,String password,String ConfirmPassword) throws SQLException {
        Users lastUsers = Database.GetLastUsers();
        registerPage.firstName.setValue(lastUsers.getFirstName());
        registerPage.lastName.setValue(lastUsers.getLastName());
        registerPage.email.setValue(lastUsers.getEmail());
        registerPage.telephone.setValue(lastUsers.getPhone());
        registerPage.password.setValue(lastUsers.getPassword());
        registerPage.ConfirmPassword.setValue(lastUsers.getPassword());
        return this;
    }
    @Step("News letter Click")
    public RegisterPageSteps SetNewsletter(){
        registerPage.newsletter.click();
        return this;
    }
    @Step("Agree Button Click")
    public RegisterPageSteps SetAgreeBtn(){
        registerPage.AgreeBtn.click();
        return this;
    }
    @Step("Continue Button Click")
    public RegisterPageSteps SetContinueBtn(){
        registerPage.ContinueBtn.click();
        return this;
    }
}
