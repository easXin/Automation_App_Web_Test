package stepDefinitions;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
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

    @Given("^I see 5 hyperlinks on this page$")
    public void i_see_5_hyperlinks_on_this_page() throws Throwable {
        
    }

    @Given("^I notice the text on page is same as the website title$")
    public void i_notice_the_text_on_page_is_same_as_the_website_title() throws Throwable {
        
    }

    @When("^I am opened any of these 5 hyperlinks$")
    public void i_am_opened_any_of_these_5_hyperlinks() throws Throwable {
       
    }

    @When("^I am on the subsite$")
    public void i_am_on_the_subsite() throws Throwable {
        
    }

    @When("^I am clicked on the texting editing field $")
    public void i_am_clicked_on_the_texting_editing_field() throws Throwable {
        
    }

    @When("^I select all the visible text on the webesite$")
    public void i_select_all_the_visible_text_on_the_webesite() throws Throwable {
        
    }

    @Then("^I should be taken to the disparate page$")
    public void i_should_be_taken_to_the_disparate_page() throws Throwable {
      
    }

    @Then("^I will be redirected back to previous page  $")
    public void i_will_be_redirected_back_to_previous_page() throws Throwable {
      
    }

    @Then("^I can input some text$")
    public void i_can_input_some_text() throws Throwable {
        
    }

    @Then("^I should be taken to disparate page$")
    public void i_should_be_taken_to_disparate_page() throws Throwable {
      
    }

    @Then("^the color of the hyperline should be changed to indicate the link is visited$")
    public void the_color_of_the_hyperline_should_be_changed_to_indicate_the_link_is_visited() throws Throwable {
       
    }

    @Then("^the text is selectable$")
    public void the_text_is_selectable() throws Throwable {
      
    }

    @And("^one text editing field$")
    public void one_text_editing_field() throws Throwable {
     
    }

    @But("^when I am going back the home page$")
    public void when_i_am_going_back_the_home_page() throws Throwable {
     
    }

	public void tearDownTest() {
		browser.close();
		browser.quit();
		System.out.println("Test completed successfully");
	}

	
	
	

	public void threadSleep() {
		try {
			setUpTest();
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
