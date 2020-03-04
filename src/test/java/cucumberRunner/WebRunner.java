package cucumberRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features", 
    glue = "stepDefinitions",
    tags = "@test")
public class WebRunner {
	
/*
 * Create steps in the feature files and relate them to step definitions 
 * so that during your test you open some page, fill in some text fields,
 * press some button, check checkbox, click some link. (the main goal is
 * to practice feature files, step definitions, interaction with various
 * elements on the page) - do as much as you can...a little exploration
 * here.
 */
}
