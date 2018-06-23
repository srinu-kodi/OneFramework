package stepDefs;

import cucumber.api.java.en.Given;
import framework.pages.HomePage;

public class HomePageSteps {

    @Given("^User chooses \"([^\"]*)\" option$")
    public void userChoosesOption(String option) throws Throwable {
        if(option.toLowerCase().equals("login")) {
            new HomePage().chooseSignInOption();
        }
        else if(option.toLowerCase().equals("signup")) {
            new HomePage().chooseSignUpOption();
        }
    }
}
