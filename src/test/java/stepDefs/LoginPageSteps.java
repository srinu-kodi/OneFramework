package stepDefs;

import cucumber.api.java.en.Then;
import framework.pages.LoginPage;
import org.junit.Assert;

public class LoginPageSteps {
    @Then("^User should see page title as \"([^\"]*)\"$")
    public void userShouldSeePageTitleAs(String validationText) throws Throwable {
        Assert.assertEquals(new LoginPage().getTitle(), validationText);
    }
}