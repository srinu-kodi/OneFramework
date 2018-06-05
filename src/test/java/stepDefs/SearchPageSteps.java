package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;

public class SearchPageSteps {
    @And("^Search for \"([^\"]*)\" journey with below criteria$")
    public void searchForUserJourney(String journeyType, DataTable searchCriteriaTable) throws Throwable {

    }
}
