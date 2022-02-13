package taskWhenIwork.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "src/test/java/taskWhenIwork/step_definitions",
        features = "src/test/resources/features",
        tags = "@login",
        dryRun = false,
        plugin = "json:target/cucumber1.json"
)
public class CukesRunner {
}

