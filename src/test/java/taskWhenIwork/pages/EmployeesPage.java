package taskWhenIwork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import taskWhenIwork.utilities.BrowserUtils;
import taskWhenIwork.utilities.Driver;

public class EmployeesPage {

    @FindBy(xpath = "//div[contains(@class, 'justify-content-between')]//child::span[text()='Continue']")
    public WebElement addEmployeeContinueBtn;

    @FindBy(xpath = "//span[text()='Add Employees']")
    public WebElement addEmployeeBtn;

    @FindBy(id = "first_name")
    public WebElement first_name;

    @FindBy(id = "last_name")
    public WebElement last_name;

    @FindBy(xpath = "//div[text()=' Employee']/parent::button[@type='submit']")
    public WebElement submitAddEmployee;

    public WebElement employeeInColumn(String name) {
        String xpath = "//div[@class='user-info col-2']//div[text()="+name+"]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public void clickContinueAddEmployee(){
        BrowserUtils.waitForClickability(addEmployeeContinueBtn, 1000).click();
    }

    public void addEmployee(String firstName, String lastName) {
        BrowserUtils.waitForClickability(addEmployeeBtn, 1000).click();
        BrowserUtils.waitForClickability(first_name, 1000).sendKeys(firstName);
        last_name.sendKeys(lastName);
        submitAddEmployee.click();
    }

    public void isEmployeeCreated(String name) {
        BrowserUtils.verifyElementDisplayed(employeeInColumn(name));
    }
}
