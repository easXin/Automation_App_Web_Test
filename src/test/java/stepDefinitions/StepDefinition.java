package stepDefinitions;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	WebDriver browser = null;

	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		browser = new ChromeDriver();
		browser.get("http://book.theautomatedtester.co.uk/");
	}

	public void tearDownTest() {
		browser.close();
		browser.quit();
		System.out.println("Test completed successfully");
	}

	@Given("^user opens facebook page$")
	public void user_opens_facebook_page() throws Throwable {
    	try {
    		setUpTest();
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}		
		tearDownTest();
	}
	@When("^user enters data$")
	public void user_enters_data() throws Throwable {
	}

	@Then("^validate user input$")
	public void validate_user_input() throws Throwable {

	}

	@Then("^clicks_sign_up$")
	public void clicks_sign_up() throws Throwable {

	}

}
