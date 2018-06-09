package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class HomePageSteps {
    @And("^Search for \"([^\"]*)\" journey with below criteria$")
    public void searchForUserJourney(String journeyType, DataTable searchCriteriaTable) throws Throwable {

    }

    @Given("^User chooses \"([^\"]*)\" option$")
    public void userChoosesOption(String option) throws Throwable {

    }
}
