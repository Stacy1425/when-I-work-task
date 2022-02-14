package taskWhenIwork.step_definitions;

import io.cucumber.java.en.*;
import taskWhenIwork.pages.NavigationBarPage;

public class NavigationBarStepDefinitions {

    NavigationBarPage navigationBarPage = new NavigationBarPage();

    @And("goes to settings menu")
    public void goToSettingsMenu() {
        navigationBarPage.goToSettingsMenu();
    }

    @And("navigate to Scheduler")
    public void navigateToScheduler() {
        navigationBarPage.navigateToScheduler();
    }

}
