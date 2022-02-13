package taskWhenIwork.step_definitions;

import taskWhenIwork.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    //cleanup part
    //will be executed after every test scenario
    //to close browser
    @After
    public void teardown() {
        System.out.println("Closing browser");
        Driver.closeDriver();
    }
}
