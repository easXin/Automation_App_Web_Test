package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features", 
    glue = "stepDefinitions",
    tags = "@test")
public class WebRunner {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.close();
		driver.quit();
	}
	
/*
 * Create steps in the feature files and relate them to step definitions 
 * so that during your test you open some page, fill in some text fields,
 * press some button, check checkbox, click some link. (the main goal is
 * to practice feature files, step definitions, interaction with various
 * elements on the page) - do as much as you can...a little exploration
 * here.
 */
}
