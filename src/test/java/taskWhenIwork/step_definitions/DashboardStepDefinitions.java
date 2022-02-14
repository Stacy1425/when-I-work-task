package taskWhenIwork.step_definitions;

import io.cucumber.java.en.*;
import taskWhenIwork.pages.DashboardPage;

public class DashboardStepDefinitions {

    DashboardPage dashboardPage = new DashboardPage();

    @And("openShift is not published")
    public void openshiftIsNotPublishedFor() {
        dashboardPage.isOpenShiftPublished();
    }
}
