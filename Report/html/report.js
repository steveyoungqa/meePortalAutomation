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
formatter.scenarioOutline({
  "comments": [
    {
      "line": 7,
      "value": "#  Scenario: As an administrator, I want to test that to automatic HTTP to HTTPS redirect is working (1)"
    },
    {
      "line": 8,
      "value": "#    Given I have navigated to the HTTP version of the admin portal Url"
    },
    {
      "line": 9,
      "value": "#      Then the new Url is in HTTPS format"
    },
    {
      "line": 10,
      "value": "#"
    },
    {
      "line": 11,
      "value": "#  Scenario Outline: As an administrator, I want to check that validation is in place for login on the admin portal (2)"
    },
    {
      "line": 12,
      "value": "#    Given I have navigated to the admin portal"
    },
    {
      "line": 13,
      "value": "#    And I have entered a \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\""
    },
    {
      "line": 14,
      "value": "#    When I click the Log in button"
    },
    {
      "line": 15,
      "value": "#    Then A validation \"\u003cError\u003e\" is displayed"
    },
    {
      "line": 16,
      "value": "#"
    },
    {
      "line": 17,
      "value": "#    Examples:"
    },
    {
      "line": 18,
      "value": "#      | Username          | Password          | Error                     |"
    },
    {
      "line": 19,
      "value": "#      |                   | incorrectpassword | Username-error            |"
    },
    {
      "line": 20,
      "value": "#      | incorrectusername |                   | Password-error            |"
    },
    {
      "line": 21,
      "value": "#      | wpritchard        | password          | validation-summary-errors |"
    }
  ],
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
    },
    {
      "cells": [
        "ttester1",
        "Username"
      ],
      "line": 34,
      "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-all-the-search-fields-from-the-users-page-(3);;3"
    },
    {
      "cells": [
        "tester1",
        "Firstname"
      ],
      "line": 35,
      "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-all-the-search-fields-from-the-users-page-(3);;4"
    },
    {
      "cells": [
        "tester1",
        "Lastname"
      ],
      "line": 36,
      "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-all-the-search-fields-from-the-users-page-(3);;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 95839,
  "status": "passed"
});
formatter.before({
  "duration": 587016,
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
  "duration": 83962481,
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
  "duration": 4016306563,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_logged_into_the_admin_portal()"
});
formatter.result({
  "duration": 3173062437,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_navigated_to_the_Users_page_of_the_site()"
});
formatter.result({
  "duration": 2208552840,
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
  "duration": 222505348,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.click_the_search_button()"
});
formatter.result({
  "duration": 208653699,
  "error_message": "java.lang.NullPointerException\n\tat webDriver.Driver.refreshPage(Driver.java:159)\n\tat stepDefinition.AdminPortalStepDefs.click_the_search_button(AdminPortalStepDefs.java:98)\n\tat ✽.And Click the search button(AdminPortal.feature:28)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 221251333,
  "status": "passed"
});
formatter.before({
  "duration": 24007,
  "status": "passed"
});
formatter.before({
  "duration": 8041,
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
  "duration": 50142,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "As an administrator, I want to check all the search fields from the users page (3)",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-all-the-search-fields-from-the-users-page-(3);;3",
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
  "name": "I enter a search parameter \"ttester1\" into a search field \"Username\"",
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
  "duration": 2410131072,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_logged_into_the_admin_portal()"
});
formatter.result({
  "duration": 51293061706,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"Username\"}\n  (Session info: chrome\u003d47.0.2526.106)\n  (Driver info: chromedriver\u003d2.20.353124 (035346203162d32c80f1dce587c8154a1efa0c3b),platform\u003dMac OS X 10.11.3 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 15.03 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b\u0027, time: \u00272016-03-15 17:00:58\u0027\nSystem info: host: \u0027MLGBLOCR04-0020\u0027, ip: \u002710.101.110.17\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.11.3\u0027, java.version: \u00271.8.0_73\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, chrome\u003d{userDataDir\u003d/var/folders/w9/8b4z2__x1vjgmx__0fdwxk3jj51clw/T/.org.chromium.Chromium.Qk6jkb}, takesHeapSnapshot\u003dtrue, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d47.0.2526.106, platform\u003dMAC, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: b5a6b9e6bc1da4d91e600a71e05fed3b\n*** Element info: {Using\u003did, value\u003dUsername}\nCommand duration or timeout: 15.34 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.47.1\u0027, revision: \u0027unknown\u0027, time: \u00272015-07-30 11:02:44\u0027\nSystem info: host: \u0027MLGBLOCR04-0020\u0027, ip: \u002710.101.110.17\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.11.3\u0027, java.version: \u00271.8.0_73\u0027\nDriver info: org.openqa.selenium.remote.RemoteWebDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, chrome\u003d{userDataDir\u003d/var/folders/w9/8b4z2__x1vjgmx__0fdwxk3jj51clw/T/.org.chromium.Chromium.Qk6jkb}, takesHeapSnapshot\u003dtrue, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d47.0.2526.106, platform\u003dMAC, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, webdriver.remote.sessionid\u003d8b78e974-93a2-467e-a04e-ac72c292a448, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 8b78e974-93a2-467e-a04e-ac72c292a448\n*** Element info: {Using\u003did, value\u003dUsername}\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:422)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:595)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:348)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:389)\n\tat org.openqa.selenium.By$ById.findElement(By.java:215)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:340)\n\tat webDriver.Driver.findElement(Driver.java:128)\n\tat pageObject.AdminPortal.Username(AdminPortal.java:14)\n\tat supportMethods.SessionUtilities.LoginAdminPortal(SessionUtilities.java:80)\n\tat stepDefinition.AdminPortalStepDefs.i_have_logged_into_the_admin_portal(AdminPortalStepDefs.java:73)\n\tat ✽.And I have logged into the admin portal(AdminPortal.feature:25)\nCaused by: org.openqa.selenium.remote.ScreenshotException: Screen shot has been taken\nBuild info: version: \u00272.47.1\u0027, revision: \u0027unknown\u0027, time: \u00272015-07-30 11:02:44\u0027\nSystem info: host: \u0027MLGBLOCR04-0020\u0027, ip: \u002710.101.110.17\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.11.3\u0027, java.version: \u00271.8.0_73\u0027\nDriver info: driver.version: Driver\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:138)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:595)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:348)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:389)\n\tat org.openqa.selenium.By$ById.findElement(By.java:215)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:340)\n\tat webDriver.Driver.findElement(Driver.java:128)\n\tat pageObject.AdminPortal.Username(AdminPortal.java:14)\n\tat supportMethods.SessionUtilities.LoginAdminPortal(SessionUtilities.java:80)\n\tat stepDefinition.AdminPortalStepDefs.i_have_logged_into_the_admin_portal(AdminPortalStepDefs.java:73)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:497)\n\tat cucumber.runtime.Utils$1.call(Utils.java:34)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\n\tat cucumber.runtime.Utils.invoke(Utils.java:30)\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:35)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:298)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:48)\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:55)\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:47)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:160)\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:69)\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:234)\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:74)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:497)\n\tat com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)\nCaused by: org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"Username\"}\n  (Session info: chrome\u003d47.0.2526.106)\n  (Driver info: chromedriver\u003d2.20.353124 (035346203162d32c80f1dce587c8154a1efa0c3b),platform\u003dMac OS X 10.11.3 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 15.03 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b\u0027, time: \u00272016-03-15 17:00:58\u0027\nSystem info: host: \u0027MLGBLOCR04-0020\u0027, ip: \u002710.101.110.17\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.11.3\u0027, java.version: \u00271.8.0_73\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, chrome\u003d{userDataDir\u003d/var/folders/w9/8b4z2__x1vjgmx__0fdwxk3jj51clw/T/.org.chromium.Chromium.Qk6jkb}, takesHeapSnapshot\u003dtrue, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d47.0.2526.106, platform\u003dMAC, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: b5a6b9e6bc1da4d91e600a71e05fed3b\n*** Element info: {Using\u003did, value\u003dUsername}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.47.1\u0027, revision: \u0027unknown\u0027, time: \u00272015-07-30 11:02:44\u0027\nSystem info: host: \u0027MLGBLOCR04-0020\u0027, ip: \u002710.101.110.17\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.11.3\u0027, java.version: \u00271.8.0_73\u0027\nDriver info: driver.version: EventFiringWebDriver\n\tat sun.reflect.GeneratedConstructorAccessor19.newInstance(Unknown Source)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:422)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:413)\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\n\tat sun.reflect.GeneratedMethodAccessor11.invoke(Unknown Source)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:497)\n\tat org.openqa.selenium.support.events.EventFiringWebDriver$2.invoke(EventFiringWebDriver.java:103)\n\tat com.sun.proxy.$Proxy1.findElement(Unknown Source)\n\tat org.openqa.selenium.support.events.EventFiringWebDriver.findElement(EventFiringWebDriver.java:188)\n\tat org.openqa.selenium.remote.server.handler.FindElement.call(FindElement.java:48)\n\tat org.openqa.selenium.remote.server.handler.FindElement.call(FindElement.java:1)\n\tat java.util.concurrent.FutureTask.run(FutureTask.java:266)\n\tat org.openqa.selenium.remote.server.DefaultSession$1.run(DefaultSession.java:176)\n\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\n\tat java.lang.Thread.run(Thread.java:745)\n",
  "status": "failed"
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_navigated_to_the_Users_page_of_the_site()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "ttester1",
      "offset": 28
    },
    {
      "val": "Username",
      "offset": 59
    }
  ],
  "location": "AdminPortalStepDefs.i_enter_a_search_parameter_into_a_search_field(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminPortalStepDefs.click_the_search_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 192395075,
  "status": "passed"
});
formatter.before({
  "duration": 13875,
  "status": "passed"
});
formatter.before({
  "duration": 5666,
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
  "duration": 56080,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "As an administrator, I want to check all the search fields from the users page (3)",
  "description": "",
  "id": "as-a-mee-application-administrator-i-want-to-be-able-to-perform-administratory-actions;as-an-administrator,-i-want-to-check-all-the-search-fields-from-the-users-page-(3);;4",
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
  "name": "I enter a search parameter \"tester1\" into a search field \"Firstname\"",
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
  "duration": 2373947272,
  "status": "passed"
});
formatter.match({
  "location": "AdminPortalStepDefs.i_have_logged_into_the_admin_portal()"
});
