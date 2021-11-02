package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // path to the feature files
        glue = {"stepDefinitions"}, // path to the step definitions files
        monochrome = true, // display the console output in much readable way
        dryRun = true // check if all the Steps have the Step definition
)

public class TestRunner {
}
