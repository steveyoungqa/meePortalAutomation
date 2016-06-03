package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.project.MavenProject;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/featureFiles" },
		glue = { "webDriver", "stepDefinition", "testRunner" },
		tags = { "@end2end" },
		plugin = {"pretty", "html:target/html", "json:target/reports/cucumber.json" })
public class TestRunner {

    public static Map<String, String> config;
    public static Scenario scenario;
}
