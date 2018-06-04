package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import stepDefs.Hooks;

@CucumberOptions(features = {"src/test/java/features"},
        glue = "stepDefs",
        tags = {"@android", "~@ignore"},
        format = {"pretty", "html:target/cucumber"})
@RunWith(Cucumber.class)
public class AndroidRunner extends Hooks {

}