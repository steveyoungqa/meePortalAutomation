$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "As a user I want to validate the login procedure",
  "description": "",
  "id": "as-a-user-i-want-to-validate-the-login-procedure",
  "keyword": "Feature"
});
formatter.before({
  "duration": 310382,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Webpage scenario",
  "description": "",
  "id": "as-a-user-i-want-to-validate-the-login-procedure;webpage-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@now"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "I have opened a \"test\"",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I check for something",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "something is present",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 17
    }
  ],
  "location": "SampleLoginStepDefs.i_have_opened_a(String)"
});
formatter.result({
  "duration": 4422457548,
  "error_message": "org.junit.ComparisonFailure: Incorrect URL. expected:\u003c[https://sample-test-url/]\u003e but was:\u003c[data:text/html,chromewebdata]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat stepDefinition.SampleLoginStepDefs.i_have_opened_a(SampleLoginStepDefs.java:40)\r\n\tat ✽.Given I have opened a \"test\"(Login.feature:11)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "SampleLoginStepDefs.i_check_for_something()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SampleLoginStepDefs.something_is_present()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 3292660011,
  "status": "passed"
});
formatter.after({
  "duration": 3820675,
  "error_message": "java.lang.NullPointerException\r\n\tat webDriver.Driver.embedScreenshot(Driver.java:190)\r\n\tat stepDefinition.Hooks.after(Hooks.java:26)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:34)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:30)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:59)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:222)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:210)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:204)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:50)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:675)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\n",
  "status": "failed"
});
});