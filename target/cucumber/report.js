$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HomePage.feature");
formatter.feature({
  "line": 1,
  "name": "Wordpress Homepage Feature",
  "description": "",
  "id": "wordpress-homepage-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 257952,
  "status": "passed"
});
formatter.before({
  "duration": 17444623179,
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
  "duration": 858279419,
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
  "duration": 731944600,
  "status": "passed"
});
formatter.after({
  "duration": 53533576,
  "status": "passed"
});
});