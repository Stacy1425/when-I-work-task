package taskWhenIwork.step_definitions;

import io.cucumber.java.en.*;
import taskWhenIwork.pages.WorkplacesPage;

public class WorkplacesStepDefinitions {

    WorkplacesPage workplacesPage = new WorkplacesPage();

    @When("clicks on specific workplace {}")
    public void clicks_on_specific_workplace(String workspaceName) {
        workplacesPage.clickOnSpecificWorkplace(workspaceName);
    }

}
