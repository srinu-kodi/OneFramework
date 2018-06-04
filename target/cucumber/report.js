$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Feature",
  "description": "",
  "id": "feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 158112,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Scenario",
  "description": "",
  "id": "feature;scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@android"
    },
    {
      "line": 3,
      "name": "@web"
    },
    {
      "line": 3,
      "name": "@ios"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "First step",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.firstStep()"
});
formatter.result({
  "duration": 91544439,
  "status": "passed"
});
});