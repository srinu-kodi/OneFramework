package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(features = {"src/test/java/features"},
        glue = "stepDefs",
        tags = {"@web", "~@ignore"},
        format = {"pretty", "html:target/cucumber"})
@RunWith(Cucumber.class)
public class WebRunner extends Hooks {

}