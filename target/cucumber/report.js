$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HomePage.feature");
formatter.feature({
  "line": 1,
  "name": "Copa Airlines homepage feature validation",
  "description": "",
  "id": "copa-airlines-homepage-feature-validation",
  "keyword": "Feature"
});
formatter.before({
  "duration": 158267,
  "status": "passed"
});
formatter.before({
  "duration": 8736178069,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Copa Airlines homepage scenario",
  "description": "",
  "id": "copa-airlines-homepage-feature-validation;copa-airlines-homepage-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@web"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "Application is launched",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "Search for \"round-trip\" journey with below criteria",
  "rows": [
    {
      "cells": [
        "From",
        "To",
        "Departure",
        "Return",
        "Adult",
        "Child",
        "ClassType"
      ],
      "line": 15
    },
    {
      "cells": [
        "\"Orlando\"",
        "\"Panama\"",
        "\"July 15, 2018\"",
        "\"July 25, 2018\"",
        "1",
        "1",
        "\"Business\""
      ],
      "line": 16
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.launchApplication()"
});
formatter.result({
  "duration": 70373684,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "round-trip",
      "offset": 12
    }
  ],
  "location": "SearchPageSteps.searchForUserJourney(String,DataTable)"
});
formatter.result({
  "duration": 2245840,
  "status": "passed"
});
formatter.after({
  "duration": 579306170,
  "status": "passed"
});
});