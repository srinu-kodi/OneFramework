package framework.pages;

import framework.core.Page;
import framework.exceptionManager.LocatorNotSetException;

import java.util.HashMap;

public class HomePage extends Page {

    HashMap<String, HashMap> eleLoginBtn = new HashMap<>();
    HashMap<String, HashMap> eleSignupBtn = new HashMap<>();

    public HomePage() {
        eleLoginBtn.put("android", new HashMap(){{put("id", "login_button");}});
        eleLoginBtn.put("ios", new HashMap(){{put("id", "Log In Button");}});
        eleLoginBtn.put("web", new HashMap(){{put("id", "navbar-getstarted-link");}});

        eleSignupBtn.put("android", new HashMap(){{put("id", "create_site_button");}});
        eleSignupBtn.put("ios", new HashMap(){{put("id", "Sign up for WordPress.com Button");}});
        eleSignupBtn.put("web", new HashMap(){{put("id", "navbar-getstarted-link");}});
    }

    public LoginPage chooseSignInOption() throws LocatorNotSetException {
        click(eleLoginBtn);
        return new LoginPage();
    }

    public SignupPage chooseSignUpOption() throws LocatorNotSetException {
        click(eleSignupBtn);
        return new SignupPage();
    }
}
