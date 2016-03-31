$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Register.feature");
formatter.feature({
  "line": 2,
  "name": "Regression tests for registering a new user",
  "description": "",
  "id": "regression-tests-for-registering-a-new-user",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@register"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Register a new user",
  "description": "",
  "id": "regression-tests-for-registering-a-new-user;register-a-new-user",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I am on the MEE portal for \"dev\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I have clicked on the Register button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I select language \"\u003cLanguage\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I register a first name of \"\u003cFirstname\u003e\" and surname of \"\u003cSurname\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I select a Country of residence of \"\u003cCountry\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I select a date of birth of \"\u003cday\u003e\" \"\u003cmonth\u003e\" \"\u003cyear\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I have clicked on the Next button",
  "keyword": "And "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "regression-tests-for-registering-a-new-user;register-a-new-user;",
  "rows": [
    {
      "cells": [
        "Language",
        "Firstname",
        "Surname",
        "Country",
        "day",
        "month",
        "year"
      ],
      "line": 14,
      "id": "regression-tests-for-registering-a-new-user;register-a-new-user;;1"
    },
    {
      "cells": [
        "English",
        "Fred",
        "Automation",
        "Spain",
        "10",
        "August",
        "1980"
      ],
      "line": 15,
      "id": "regression-tests-for-registering-a-new-user;register-a-new-user;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 118555,
  "status": "passed"
});
formatter.before({
  "duration": 424565,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Register a new user",
  "description": "",
  "id": "regression-tests-for-registering-a-new-user;register-a-new-user;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@register"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on the MEE portal for \"dev\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I have clicked on the Register button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I select language \"English\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I register a first name of \"Fred\" and surname of \"Automation\"",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I select a Country of residence of \"Spain\"",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I select a date of birth of \"10\" \"August\" \"1980\"",
  "matchedColumns": [
    4,
    5,
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I have clicked on the Next button",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "dev",
      "offset": 28
    }
  ],
  "location": "MeePortalStepDefs.i_am_on_the_MEE_portal_for(String)"
});
formatter.result({
  "duration": 3204611838,
  "status": "passed"
});
formatter.match({
  "location": "RegisterStepDefs.iHaveClickedOnTheRegisterButton()"
});
formatter.result({
  "duration": 1070680121,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "English",
      "offset": 19
    }
  ],
  "location": "LoginStepDefs.i_select_language(String)"
});
formatter.result({
  "duration": 238533348,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Fred",
      "offset": 28
    },
    {
      "val": "Automation",
      "offset": 50
    }
  ],
  "location": "RegisterStepDefs.iRegisterAFirstNameOfAndSurnameOf(String,String)"
});
formatter.result({
  "duration": 722317828,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Spain",
      "offset": 36
    }
  ],
  "location": "RegisterStepDefs.iSelectACountryOfResidenceOf(String)"
});
formatter.result({
  "duration": 3002662231,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 29
    },
    {
      "val": "August",
      "offset": 34
    },
    {
      "val": "1980",
      "offset": 43
    }
  ],
  "location": "RegisterStepDefs.iSelectADateOfBirthOf(String,String,String)"
});
formatter.result({
  "duration": 976645756,
  "status": "passed"
});
formatter.match({
  "location": "RegisterStepDefs.iHaveClickedOnTheNextButton()"
});
formatter.result({
  "duration": 5238520355,
  "status": "passed"
});
formatter.after({
  "duration": 117179,
  "status": "passed"
});
});