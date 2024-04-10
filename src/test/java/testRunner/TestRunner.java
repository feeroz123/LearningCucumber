package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = "stepDefinitions",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-output.html"},
        tags = ("@sanity or @regression") // To execute only selected tests by using their tags
)

public class TestRunner {
}
