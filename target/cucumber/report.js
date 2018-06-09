$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HomePage.feature");
formatter.feature({
  "line": 1,
  "name": "Copa Airlines homepage feature validation",
  "description": "",
  "id": "copa-airlines-homepage-feature-validation",
  "keyword": "Feature"
});
formatter.before({
  "duration": 158924,
  "status": "passed"
});
formatter.before({
  "duration": 13341469146,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Copa Airlines Login option scenario",
  "description": "",
  "id": "copa-airlines-homepage-feature-validation;copa-airlines-login-option-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@web"
    }
  ]
});
formatter.step({
  "line": 10,
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
  "duration": 73362487,
  "status": "passed"
});
formatter.after({
  "duration": 95894507,
  "status": "passed"
});
});