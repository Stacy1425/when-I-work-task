package taskWhenIwork.step_definitions;

import taskWhenIwork.pages.LoginPage;
import taskWhenIwork.utilities.ConfigurationReader;
import taskWhenIwork.utilities.Driver;
import io.cucumber.java.en.*;
import taskWhenIwork.utilities.BrowserUtils;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException{
        System.out.println("user is on the login page");
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);//to open login page
        BrowserUtils.wait(1000);
    }

    @When("user enters correct email, password and clicks on log in button")
    public void user_enters_correct_email_password_and_clicks_on_log_in_button() {
        System.out.println("user enters correct credentials");
        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(email, password);
    }

    @Then("user is logged in")
    public void user_is_logged_in() throws InterruptedException {
        System.out.println("user is logged in");
        BrowserUtils.wait(1000);
        loginPage.isLoggedIn();
    }

    @When("user enters wrong email")
    public void userEntersWrongEmail() {
        System.out.println("user enters wrong email");
        String email = ConfigurationReader.getProperty("incorrectEmail");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(email, password);
    }

    @Then("email error appears")
    public void email_error_appears() {
        System.out.println("email error appears");
        loginPage.emailErrorPresent();
    }

    @When("user enters wrong password")
    public void userEntersWrongPassword() {
        System.out.println("user enters wrong password");
        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("incorrectPassword");
        loginPage.login(email, password);
    }

    @Then("error appears")
    public void errorAppears() throws InterruptedException {
        System.out.println("error appears");
        BrowserUtils.wait(1000);
        loginPage.errorPresent();
    }
}
