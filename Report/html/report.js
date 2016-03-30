$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "Regression tests for the login feature",
  "description": "",
  "id": "regression-tests-for-the-login-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.scenarioOutline({
  "line": 77,
  "name": "User successful login attempt (3a)",
  "description": "",
  "id": "regression-tests-for-the-login-feature;user-successful-login-attempt-(3a)",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 76,
      "name": "@coding"
    }
  ]
});
formatter.step({
  "line": 78,
  "name": "I am on the MEE portal for \"dev\"",
  "keyword": "Given "
});
formatter.step({
  "line": 79,
  "name": "I have clicked on the login button",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "I log in as username \"\u003cusername\u003e\" and password \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 81,
  "name": "I am logged into MEE",
  "keyword": "Then "
});
formatter.step({
  "line": 82,
  "name": "I log out of MEE",
  "keyword": "Then "
});
formatter.examples({
  "line": 84,
  "name": "",
  "description": "",
  "id": "regression-tests-for-the-login-feature;user-successful-login-attempt-(3a);",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 85,
      "id": "regression-tests-for-the-login-feature;user-successful-login-attempt-(3a);;1"
    },
    {
      "cells": [
        "meeadmin",
        "M4cmillan"
      ],
      "line": 86,
      "id": "regression-tests-for-the-login-feature;user-successful-login-attempt-(3a);;2"
    },
    {
      "cells": [
        "meetest",
        "meetest"
      ],
      "line": 87,
      "id": "regression-tests-for-the-login-feature;user-successful-login-attempt-(3a);;3"
    },
    {
      "cells": [
        "tmomoh4",
        "QWnjAZpg"
      ],
      "line": 88,
      "id": "regression-tests-for-the-login-feature;user-successful-login-attempt-(3a);;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 105247,
  "status": "passed"
});
formatter.before({
  "duration": 415880,
  "status": "passed"
});
formatter.scenario({
  "line": 86,
  "name": "User successful login attempt (3a)",
  "description": "",
  "id": "regression-tests-for-the-login-feature;user-successful-login-attempt-(3a);;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 76,
      "name": "@coding"
    },
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 78,
  "name": "I am on the MEE portal for \"dev\"",
  "keyword": "Given "
});
formatter.step({
  "line": 79,
  "name": "I have clicked on the login button",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "I log in as username \"meeadmin\" and password \"M4cmillan\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 81,
  "name": "I am logged into MEE",
  "keyword": "Then "
});
formatter.step({
  "line": 82,
  "name": "I log out of MEE",
  "keyword": "Then "
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
  "duration": 3844072136,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.i_have_clicked_on_the_login_button()"
});
formatter.result({
  "duration": 1154822548,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "meeadmin",
      "offset": 22
    },
    {
      "val": "M4cmillan",
      "offset": 46
    }
  ],
  "location": "LoginStepDefs.i_log_in_as_username_and_password(String,String)"
});
formatter.result({
  "duration": 711995748,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.iAmLoggedIntoMEE()"
});
formatter.result({
  "duration": 1037722567,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.iLogOutOfMEE()"
});
formatter.result({
  "duration": 760009689,
  "status": "passed"
});
formatter.after({
  "duration": 72555,
  "status": "passed"
});
formatter.before({
  "duration": 15434,
  "status": "passed"
});
formatter.before({
  "duration": 6636,
  "status": "passed"
});
formatter.scenario({
  "line": 87,
  "name": "User successful login attempt (3a)",
  "description": "",
  "id": "regression-tests-for-the-login-feature;user-successful-login-attempt-(3a);;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 76,
      "name": "@coding"
    },
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 78,
  "name": "I am on the MEE portal for \"dev\"",
  "keyword": "Given "
});
formatter.step({
  "line": 79,
  "name": "I have clicked on the login button",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "I log in as username \"meetest\" and password \"meetest\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 81,
  "name": "I am logged into MEE",
  "keyword": "Then "
});
formatter.step({
  "line": 82,
  "name": "I log out of MEE",
  "keyword": "Then "
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
  "duration": 447764124,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.i_have_clicked_on_the_login_button()"
});
formatter.result({
  "duration": 801545885,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "meetest",
      "offset": 22
    },
    {
      "val": "meetest",
      "offset": 45
    }
  ],
  "location": "LoginStepDefs.i_log_in_as_username_and_password(String,String)"
});
formatter.result({
  "duration": 681026560,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.iAmLoggedIntoMEE()"
});
formatter.result({
  "duration": 1384872929,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.iLogOutOfMEE()"
});
formatter.result({
  "duration": 671642291,
  "status": "passed"
});
formatter.after({
  "duration": 17318,
  "status": "passed"
});
formatter.before({
  "duration": 13563,
  "status": "passed"
});
formatter.before({
  "duration": 6455,
  "status": "passed"
});
formatter.scenario({
  "line": 88,
  "name": "User successful login attempt (3a)",
  "description": "",
  "id": "regression-tests-for-the-login-feature;user-successful-login-attempt-(3a);;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 76,
      "name": "@coding"
    },
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 78,
  "name": "I am on the MEE portal for \"dev\"",
  "keyword": "Given "
});
formatter.step({
  "line": 79,
  "name": "I have clicked on the login button",
  "keyword": "And "
});
formatter.step({
  "line": 80,
  "name": "I log in as username \"tmomoh4\" and password \"QWnjAZpg\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 81,
  "name": "I am logged into MEE",
  "keyword": "Then "
});
formatter.step({
  "line": 82,
  "name": "I log out of MEE",
  "keyword": "Then "
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
  "duration": 399484140,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.i_have_clicked_on_the_login_button()"
});
formatter.result({
  "duration": 628200473,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "tmomoh4",
      "offset": 22
    },
    {
      "val": "QWnjAZpg",
      "offset": 45
    }
  ],
  "location": "LoginStepDefs.i_log_in_as_username_and_password(String,String)"
});
formatter.result({
  "duration": 676114000,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.iAmLoggedIntoMEE()"
});
formatter.result({
  "duration": 776205930,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefs.iLogOutOfMEE()"
});
formatter.result({
  "duration": 597268935,
  "status": "passed"
});
formatter.after({
  "duration": 19293,
  "status": "passed"
});
});