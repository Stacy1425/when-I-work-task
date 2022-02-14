package taskWhenIwork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import taskWhenIwork.utilities.BrowserUtils;

public class NavigationBarPage {

    //-----ELEMENTS

    @FindBy(id = "app-settings-menu")
    public WebElement settingsMenuEl;

    @FindBy(xpath = "//span[text()='Employees']")
    public WebElement employeesBtn;

    @FindBy(xpath = "//span[text()='Scheduler']")
    public WebElement schedulerEl;

    @FindBy(xpath = "//span[text()='Dashboard']")
    public WebElement dashboardEl;

    //-----METHODS

    public void goToSettingsMenu() {
        BrowserUtils.waitForClickability(settingsMenuEl, 1000).click();
    }

    public void navigateToScheduler() {
        schedulerEl.click();
    }

    public void clickOnDashboard() {
        dashboardEl.click();
    }

    public void clickOnEmployeesBtn() {
        BrowserUtils.waitForClickability(employeesBtn, 1000).click();
    }
}
