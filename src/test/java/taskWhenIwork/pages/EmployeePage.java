package taskWhenIwork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import taskWhenIwork.utilities.BrowserUtils;
import taskWhenIwork.utilities.Driver;

public class EmployeePage {

    NavigationBarPage navigationBarPage = new NavigationBarPage();

    //-----ELEMENTS

    @FindBy(xpath = "//div[text()='Add Employee']")
    public WebElement addEmployeeBtn;

    @FindBy(xpath = "//button[@type='submit']//div[contains(text(), 'Employee')]")
    public WebElement submitAddEmployee;

    @FindBy(id = "first_name")
    public WebElement first_name;

    @FindBy(id = "last_name")
    public WebElement last_name;

    public WebElement employeeInColumn(String name) {
        String xpath = "//div[@class='user-name-info']//div[text()=" + name + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    //-----METHODS

    public void addEmployee(String firstName, String lastName) {
        navigationBarPage.clickOnEmployeesBtn();
        BrowserUtils.waitForClickability(addEmployeeBtn, 1000).click();
        BrowserUtils.waitForClickability(first_name, 1000).sendKeys(firstName);
        last_name.sendKeys(lastName);
        submitAddEmployee.click();
    }

    public void isEmployeeCreated(String name) {
        BrowserUtils.verifyElementDisplayed(employeeInColumn(name));
    }
}
