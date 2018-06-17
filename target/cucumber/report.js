$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HomePage.feature");
formatter.feature({
  "line": 1,
  "name": "Wordpress Homepage Feature",
  "description": "",
  "id": "wordpress-homepage-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 18219055628,
  "status": "passed"
});
formatter.before({
  "duration": 75997,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Wordpress Homepage Login scenario",
  "description": "",
  "id": "wordpress-homepage-feature;wordpress-homepage-login-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@android"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User chooses \"Login\" option",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User should see page title as \"Log in to WordPress.com using an email address to manage all your WordPress sites.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Login",
      "offset": 14
    }
  ],
  "location": "HomePageSteps.userChoosesOption(String)"
});
formatter.result({
  "duration": 828932696,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Log in to WordPress.com using an email address to manage all your WordPress sites.",
      "offset": 31
    }
  ],
  "location": "LoginPageSteps.userShouldSeePageTitleAs(String)"
});
formatter.result({
  "duration": 693774040,
  "status": "passed"
});
formatter.after({
  "duration": 54332483,
  "status": "passed"
});
formatter.before({
  "duration": 15536039225,
  "status": "passed"
});
formatter.before({
  "duration": 122459,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Wordpress Homepage Signup scenario",
  "description": "",
  "id": "wordpress-homepage-feature;wordpress-homepage-signup-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@android"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "User chooses \"Signup\" option",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Signup",
      "offset": 14
    }
  ],
  "location": "HomePageSteps.userChoosesOption(String)"
});
formatter.result({
  "duration": 957968131,
  "status": "passed"
});
formatter.after({
  "duration": 108637705,
  "status": "passed"
});
});