$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AdminPortal.feature");
formatter.feature({
  "line": 2,
  "name": "As a MEE application administrator I want to be able to perform administratory actions",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@admin"
    }
  ]
});
formatter.before({
  "duration": 97632,
  "status": "passed"
});
formatter.before({
  "duration": 508383,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am using the \"test\" environment of MEE",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 16
    }
  ],
  "location": "Environment.i_am_using_the_environment_of_MEE(String)"
});
formatter.result({
  "duration": 76646405,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "As an administrator, I want to test that to automatic HTTP to HTTPS redirect is working (1)",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-test-that-to-automatic-http-to-https-redirect-is-working-(1)",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I have navigated to the HTTP version of the admin portal Url",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "the new Url is in HTTPS format",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_navigated_to_the_HTTP_version_of_the_admin_portal_Url()"
});
formatter.result({
  "duration": 2907267616,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.the_new_Url_is_in_HTTPS_format()"
});
formatter.result({
  "duration": 11493680,
  "status": "passed"
});
formatter.after({
  "duration": 61540,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 11,
  "name": "As an administrator, I want to check that validation is in place for login on the admin portal (2)",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-that-validation-is-in-place-for-login-on-the-admin-portal-(2)",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 12,
  "name": "I have navigated to the admin portal",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I have entered a \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click the Log in button",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "A validation \"\u003cError\u003e\" is displayed",
  "keyword": "Then "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-that-validation-is-in-place-for-login-on-the-admin-portal-(2);",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "Error"
      ],
      "line": 18,
      "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-that-validation-is-in-place-for-login-on-the-admin-portal-(2);;1"
    },
    {
      "cells": [
        "",
        "incorrectpassword",
        "Username-error"
      ],
      "line": 19,
      "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-that-validation-is-in-place-for-login-on-the-admin-portal-(2);;2"
    },
    {
      "cells": [
        "incorrectusername",
        "",
        "Password-error"
      ],
      "line": 20,
      "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-that-validation-is-in-place-for-login-on-the-admin-portal-(2);;3"
    },
    {
      "cells": [
        "wpritchard",
        "password",
        "validation-summary-errors"
      ],
      "line": 21,
      "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-that-validation-is-in-place-for-login-on-the-admin-portal-(2);;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 14035,
  "status": "passed"
});
formatter.before({
  "duration": 7023,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am using the \"test\" environment of MEE",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 16
    }
  ],
  "location": "Environment.i_am_using_the_environment_of_MEE(String)"
});
formatter.result({
  "duration": 87739,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "As an administrator, I want to check that validation is in place for login on the admin portal (2)",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-that-validation-is-in-place-for-login-on-the-admin-portal-(2);;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@admin"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I have navigated to the admin portal",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I have entered a \"\" and \"incorrectpassword\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click the Log in button",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "A validation \"Username-error\" is displayed",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_navigated_to_the_admin_portal()"
});
formatter.result({
  "duration": 2137801445,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 18
    },
    {
      "val": "incorrectpassword",
      "offset": 25
    }
  ],
  "location": "AdminPortalStepDefs.i_have_entered_a_and(String,String)"
});
formatter.result({
  "duration": 676118987,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.i_click_the_Log_in_button()"
});
formatter.result({
  "duration": 214616910,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Username-error",
      "offset": 14
    }
  ],
  "location": "AdminPortalStepDefs.a_validation_is_displayed(String)"
});
formatter.result({
  "duration": 161660635,
  "status": "passed"
});
formatter.after({
  "duration": 14766,
  "status": "passed"
});
formatter.before({
  "duration": 12135,
  "status": "passed"
});
formatter.before({
  "duration": 6846,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am using the \"test\" environment of MEE",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 16
    }
  ],
  "location": "Environment.i_am_using_the_environment_of_MEE(String)"
});
formatter.result({
  "duration": 44835,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "As an administrator, I want to check that validation is in place for login on the admin portal (2)",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-that-validation-is-in-place-for-login-on-the-admin-portal-(2);;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@admin"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I have navigated to the admin portal",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I have entered a \"incorrectusername\" and \"\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click the Log in button",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "A validation \"Password-error\" is displayed",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_navigated_to_the_admin_portal()"
});
formatter.result({
  "duration": 2140153659,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "incorrectusername",
      "offset": 18
    },
    {
      "val": "",
      "offset": 42
    }
  ],
  "location": "AdminPortalStepDefs.i_have_entered_a_and(String,String)"
});
formatter.result({
  "duration": 612348028,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.i_click_the_Log_in_button()"
});
formatter.result({
  "duration": 211406269,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Password-error",
      "offset": 14
    }
  ],
  "location": "AdminPortalStepDefs.a_validation_is_displayed(String)"
});
formatter.result({
  "duration": 155190367,
  "status": "passed"
});
formatter.after({
  "duration": 15061,
  "status": "passed"
});
formatter.before({
  "duration": 11625,
  "status": "passed"
});
formatter.before({
  "duration": 5333,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am using the \"test\" environment of MEE",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 16
    }
  ],
  "location": "Environment.i_am_using_the_environment_of_MEE(String)"
});
formatter.result({
  "duration": 58363,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "As an administrator, I want to check that validation is in place for login on the admin portal (2)",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-that-validation-is-in-place-for-login-on-the-admin-portal-(2);;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@admin"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I have navigated to the admin portal",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I have entered a \"wpritchard\" and \"password\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click the Log in button",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "A validation \"validation-summary-errors\" is displayed",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_navigated_to_the_admin_portal()"
});
formatter.result({
  "duration": 2139897040,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "wpritchard",
      "offset": 18
    },
    {
      "val": "password",
      "offset": 35
    }
  ],
  "location": "AdminPortalStepDefs.i_have_entered_a_and(String,String)"
});
formatter.result({
  "duration": 965730851,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.i_click_the_Log_in_button()"
});
formatter.result({
  "duration": 216742690,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "validation-summary-errors",
      "offset": 14
    }
  ],
  "location": "AdminPortalStepDefs.a_validation_is_displayed(String)"
});
formatter.result({
  "duration": 161275429,
  "status": "passed"
});
formatter.after({
  "duration": 17579,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 23,
  "name": "As an administrator, I want to check all the search fields from the users page (3)",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-all-the-search-fields-from-the-users-page-(3)",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 24,
  "name": "I have navigated to the admin portal",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I have logged into the admin portal",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I have navigated to the Users page of the site",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I enter a search parameter \"\u003cSearch Parameter\u003e\" into a search field \"\u003cSearch Field\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Click the search button",
  "keyword": "And "
});
formatter.examples({
  "comments": [
    {
      "line": 29,
      "value": "#    Then appropriate results are displayed"
    }
  ],
  "line": 31,
  "name": "",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-all-the-search-fields-from-the-users-page-(3);",
  "rows": [
    {
      "cells": [
        "Search Parameter",
        "Search Field"
      ],
      "line": 32,
      "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-all-the-search-fields-from-the-users-page-(3);;1"
    },
    {
      "cells": [
        "allstudent1@test.com",
        "Email"
      ],
      "line": 33,
      "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-all-the-search-fields-from-the-users-page-(3);;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 13557,
  "status": "passed"
});
formatter.before({
  "duration": 5530,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am using the \"test\" environment of MEE",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 16
    }
  ],
  "location": "Environment.i_am_using_the_environment_of_MEE(String)"
});
formatter.result({
  "duration": 44226,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "As an administrator, I want to check all the search fields from the users page (3)",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-all-the-search-fields-from-the-users-page-(3);;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@admin"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "I have navigated to the admin portal",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I have logged into the admin portal",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I have navigated to the Users page of the site",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I enter a search parameter \"allstudent1@test.com\" into a search field \"Email\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Click the search button",
  "keyword": "And "
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_navigated_to_the_admin_portal()"
});
formatter.result({
  "duration": 2134500037,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_logged_into_the_admin_portal()"
});
formatter.result({
  "duration": 3186990633,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_navigated_to_the_Users_page_of_the_site()"
});
formatter.result({
  "duration": 2215916772,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "allstudent1@test.com",
      "offset": 28
    },
    {
      "val": "Email",
      "offset": 71
    }
  ],
  "location": "AdminPortalStepDefs.i_enter_a_search_parameter_into_a_search_field(String,String)"
});
formatter.result({
  "duration": 205137746,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.click_the_search_button()"
});
formatter.result({
  "duration": 2218250529,
  "status": "passed"
});
formatter.after({
  "duration": 29321,
  "status": "passed"
});
});