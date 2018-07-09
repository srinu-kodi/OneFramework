package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import stepDefs.Hooks;

@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"stepDefs"},
        format = {"pretty", "html:runReport/cucumber"})
@RunWith(Cucumber.class)
public class TestRunner extends Hooks {

}