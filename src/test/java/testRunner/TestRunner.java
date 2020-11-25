package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@pagePrinting",
        features = {"classpath:Features"},
        glue = {"classpath:StepDefinitions"},
        plugin = {"pretty", "html:target/reports"},
        monochrome = true
)

public class TestRunner {

}
