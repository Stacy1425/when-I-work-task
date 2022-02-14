package taskWhenIwork.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import taskWhenIwork.utilities.BrowserUtils;

public class LoginPage extends BasePage {

    //-----ELEMENTS

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBoxElement;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBoxElement;

    @FindBy(xpath = "//div[contains(@class, 'form-control-feedback')]")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//div[contains(@class, 'Toastify__progress-bar--error')]")
    public WebElement errorMessage;

    @FindBy (xpath = "//button[text()='Logout']")
    public WebElement logoutBtn;

    //-----METHODS

    public void login(String email, String password){
        emailInputBoxElement.sendKeys(email);
        passwordInputBoxElement.sendKeys(password, Keys.ENTER);
    }

    public void isLoggedIn() {
        BrowserUtils.verifyElementDisplayed(logoutBtn);
    }

    public void emailErrorPresent() {
        BrowserUtils.verifyElementDisplayed(emailErrorMessage);
    }

    public void errorPresent() {
        BrowserUtils.verifyElementDisplayed(errorMessage);
    }
}