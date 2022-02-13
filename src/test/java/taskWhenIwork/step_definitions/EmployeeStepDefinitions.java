package taskWhenIwork.step_definitions;

import io.cucumber.java.en.*;
import taskWhenIwork.pages.EmployeesPage;
import taskWhenIwork.utilities.BrowserUtils;

import static org.junit.Assert.*;

public class EmployeeStepDefinitions {

    EmployeesPage employeesPage = new EmployeesPage();

    @When("clicks on add employee button")
    public void clicks_on_add_employee_button() {
        employeesPage.clickContinueAddEmployee();
    }

    @And("adds new employee")
    public void adds_new_employee(String firstName, String lastName) {
        employeesPage.addEmployee(firstName, lastName);
    }

    @Then("employee {} is successfully added")
    public void employeeIsSuccessfullyAdded(String employee) {
        BrowserUtils.wait(1);
        employeesPage.isEmployeeCreated(employee);
    }

//    @And("adds new employee")
//    public void addsNewEmployee() {
//    }
}
