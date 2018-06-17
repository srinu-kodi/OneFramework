package stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import framework.pages.LoginPage;

public class LoginPageSteps {
    @Then("^User should see page title as \"([^\"]*)\"$")
    public void userShouldSeePageTitleAs(String validationText) throws Throwable {
        new LoginPage().getTitle().equals(validationText);
    }
}
