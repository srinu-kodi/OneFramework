$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HomePage.feature");
formatter.feature({
  "line": 1,
  "name": "Wordpress Homepage Feature",
  "description": "",
  "id": "wordpress-homepage-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 104160,
  "status": "passed"
});
formatter.before({
  "duration": 17751414079,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Wordpress Homepage Login feature scenario",
  "description": "",
  "id": "wordpress-homepage-feature;wordpress-homepage-login-feature-scenario",
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
  "duration": 707047783,
  "status": "passed"
});
formatter.after({
  "duration": 110314009,
  "status": "passed"
});
formatter.before({
  "duration": 49656,
  "status": "passed"
});
formatter.before({
  "duration": 16601169138,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Wordpress Homepage Login feature scenario",
  "description": "",
  "id": "wordpress-homepage-feature;wordpress-homepage-login-feature-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@android"
    }
  ]
});
formatter.step({
  "line": 9,
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
  "duration": 910233297,
  "status": "passed"
});
formatter.after({
  "duration": 107518152,
  "status": "passed"
});
});