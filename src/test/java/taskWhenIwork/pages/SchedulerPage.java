package taskWhenIwork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import taskWhenIwork.utilities.BrowserUtils;
import taskWhenIwork.utilities.Driver;

public class SchedulerPage {

    NavigationBarPage navigationBarPage = new NavigationBarPage();
    DashboardPage dashboardPage = new DashboardPage();

    //----------ELEMENTS
    @FindBy(xpath = "//div[@id='schedule-select-container']//child::div[contains(@class, 'Select__indicators css-1wy0on6')]")
    public WebElement addShiftArrow;

    @FindBy(xpath = "//div[text()='+ Add Schedule']")
    public WebElement addPlusScheduleBtn;

    @FindBy(xpath = "//a[text()='Shift Templates']")
    public WebElement shiftTemplatesBtn;

    @FindBy(xpath = "//div[text()='Add Shift Template']")
    public WebElement addShiftTemplateBtn;

    @FindBy(xpath = "//input[contains(@class, 'time-picker-input')]")
    public WebElement timeBox;

    @FindBy(xpath = "//div[text()='Create Custom Shift']")
    public WebElement createCustomShiftBtn;

    @FindBy(xpath = "//p[text()='There are currently no OpenShifts within this date range.']")
    public WebElement noOpenShiftsText;

    @FindBy(xpath = "//div[text()='Save']")
    public WebElement saveWithoutPublishEl;

    @FindBy(xpath = "//div[text()='Save & Publish']")
    public WebElement publishEl;

    @FindBy(xpath = "//div[@class='row']//label[text()='Assign to']//following-sibling::div[contains(@class, 'container')]")
    public WebElement assignToDropdown;

    @FindBy(xpath = "//div[text()='Delete']")
    public WebElement deleteShiftBtn;

    @FindBy(xpath = "//div[text()='Confirm Delete']")
    public WebElement confirmDeleteBtn;

    public WebElement openShiftColHour(String hour) {
        String xpath = "//div[@id='user-row-0']//child::div[contains(@class, 'schedule-row-columns')]//div[contains(@id, "+hour+")]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement editOpenShiftBtn(String startHour, String endHour) {
        String xpath = "//div[contains(@class, 'openshift')]//child::div[text()=" + startHour + "and text()=" + endHour + "]//parent::div[contains(@class, 'shift-item')]//span[text()='Edit']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement createdOpenShiftEl(String startHour, String endHour) {
        String xpath = "//div[contains(@class, 'openshift')]//child::div[text()=" + startHour + "and text()=" + endHour + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement chooseEmpToAssignShift(String empName) {
        String xpath = "//div[contains(@class, 'Select__option')][text()=" + empName + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement assignedCreatedShiftEl(String empName, String startHour, String endHour) {
        String xpath = "//div[@class='user-info col-2']//div[text()=" + empName + "]//following::div[text()=" + startHour + "and text()=" + endHour + "]//parent::div[contains(@class, 'shift-item')]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    // ----------METHODS

    /**
     * addOpenShift: openShiftColHour - enter open shift time in format - '_02pm'
     * @param hour
     * @return
     */
    public void addOpenShift(String hour) {
        openShiftColHour(hour).click();
        BrowserUtils.waitForClickability(createCustomShiftBtn, 1000).click();
        String chooseHour = hour + " - 11pm";
        BrowserUtils.waitForClickability(timeBox, 1000).sendKeys(chooseHour, Keys.ENTER);
        saveWithoutPublishEl.click();
    }

    /**
     * isOpenShiftCreated: createdOpenShiftEl - enter start hour in format - '9a', endHour - '1p'
     * @param startHour
     * @param endHour
     * @return
     */
    public void isOpenShiftCreated(String startHour, String endHour) {
        BrowserUtils.verifyElementDisplayed(createdOpenShiftEl(startHour, endHour));
    }

    /**
     * assignShiftToEmp: editOpenShiftBtn - enter start hour in format - '9a', endHour - '1p'
     * @param startHour
     * @param endHour
     * @param empName
     * @return
     */
    public void assignShiftToEmp(String startHour, String endHour, String empName) {
        BrowserUtils.waitForClickability(editOpenShiftBtn(startHour, endHour), 1000).click();
        BrowserUtils.waitForClickability(assignToDropdown, 1000).click();
        BrowserUtils.waitForClickability(chooseEmpToAssignShift(empName), 1000).click();
        this.publishShift();
    }

    public void publishShift() {
        publishEl.click();
    }

    /**
     * isAssignedShiftPublished: assignedOrOpenShiftInDropdownDashboardEl - enter 'assigned-' or 'open'
     */
    public void isAssignedShiftPublished(String empName, String startHour) {
        navigationBarPage.clickOnDashboard();
        dashboardPage.isScheduledShiftPublishedForEmp(empName, startHour);
    }

    public void deleteCreatedShift(String empName, String startHour, String endHour, boolean isAssigned) {
        navigationBarPage.navigateToScheduler();
        if (isAssigned == true) {
            assignedCreatedShiftEl(empName, startHour, endHour).click();
        } else {
            createdOpenShiftEl(startHour,endHour).click();
        }
        BrowserUtils.waitForClickability(deleteShiftBtn, 2000).click();
        BrowserUtils.waitForClickability(confirmDeleteBtn, 1000).click();
    }
}
