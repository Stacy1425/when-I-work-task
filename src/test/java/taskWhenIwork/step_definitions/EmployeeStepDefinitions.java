package taskWhenIwork.step_definitions;

import io.cucumber.java.en.*;
import taskWhenIwork.utilities.BrowserUtils;
import taskWhenIwork.pages.EmployeePage;

public class EmployeeStepDefinitions {

    EmployeePage employeePage = new EmployeePage();

    @And("adds new employee")
    public void adds_new_employee(String firstName, String lastName) {
        employeePage.addEmployee(firstName, lastName);
    }

    @Then("employee {} is successfully added")
    public void employeeIsSuccessfullyAdded(String employee) {
        BrowserUtils.wait(1);
        employeePage.isEmployeeCreated(employee);
    }
}
