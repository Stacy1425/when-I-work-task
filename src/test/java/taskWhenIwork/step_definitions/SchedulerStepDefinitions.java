package taskWhenIwork.step_definitions;

import io.cucumber.java.en.*;
import taskWhenIwork.pages.NavigationBarPage;
import taskWhenIwork.pages.SchedulerPage;

public class SchedulerStepDefinitions {

    SchedulerPage schedulerPage = new SchedulerPage();
    NavigationBarPage navigationBarPage = new NavigationBarPage();

    @And("adds new OpenShift for {}")
    public void addsNewOpenShiftForHour(String hour) {
        schedulerPage.addOpenShift(hour);
    }

    @Then("openShift is successfully created for {} {}")
    public void openshiftIsSuccessfullyCreatedFor(String startHour, String endHour) {
        schedulerPage.isOpenShiftCreated(startHour, endHour);
    }

    @And("edit openShift and publish it for {} {} {}")
    public void editOpenShiftAndPublishItForKateSmith(String startHour, String endHour, String empName) {
        schedulerPage.assignShiftToEmp(startHour, endHour, empName);
    }

    @Then("openShift is published for {} at {}")
    public void openshiftIsPublishedForEmp(String empName, String startHour) {
        schedulerPage.isAssignedShiftPublished(empName, startHour);
    }

    @And("delete created shift for {} at {} and {} and assigned is {}")
    public void deleteCreatedShiftForEmpAtTime(String empName, String startHour,String endHour, boolean isAssigned) {
        schedulerPage.deleteCreatedShift(empName, startHour, endHour, isAssigned);
    }
}
