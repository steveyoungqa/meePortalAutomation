package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/featureFiles" },
		glue = { "webDriver", "stepDefinition", "testRunner" },
		// { "@tag1", "@tag2" "~@tag3"} will run anything with tag1 AND tag2, but not anything with tag3
		// { "@tag1, @tag2", "~@tag3 } will run anything with tag1 AND/OR tag2, but not anything with tag3
		tags = { "@now" },
		plugin = {"pretty", "html:Report/html"})
public class TestRunner {
}
