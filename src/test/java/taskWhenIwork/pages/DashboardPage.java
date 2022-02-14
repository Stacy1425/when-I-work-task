package taskWhenIwork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import taskWhenIwork.utilities.BrowserUtils;
import taskWhenIwork.utilities.Driver;

public class DashboardPage {

    NavigationBarPage navigationBarPage = new NavigationBarPage();

    //----------ELEMENTS

    @FindBy(xpath = "//p[text()='There are currently no OpenShifts within this date range.']")
    public WebElement noOpenShiftsText;

    public WebElement scheduledShiftForEmp(String empName, String startHour) {
        String xpath = "//div[contains(@class, 'user-info col-2')]//div[text()="+empName+"]//following::div[contains(@class, 'col schedule-cell')]//div[contains(@class, 'shift')]//div[contains(text(), "+startHour+")]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    // ----------METHODS

    public void isOpenShiftPublished() {
        navigationBarPage.clickOnDashboard();
        BrowserUtils.verifyElementDisplayed(noOpenShiftsText);
    }

    public void isScheduledShiftPublishedForEmp(String empName, String startHour) {
        BrowserUtils.verifyElementDisplayed(scheduledShiftForEmp(empName, startHour));
    }
}
