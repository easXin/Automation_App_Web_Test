package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition{
	WebDriver browser;
	WebElement fName,lName,fEmail,sEmail,password,local_radio,dMonth,dDay,dYear,signUp;
	String expectedfName,expectedlName,expectedPassword,expectedMonth,expectedDay,expectedYear;
	int idx_radio = -1; 
    @Given("^user opens facebook page$")
    public void user_opens_facebook_page() throws Throwable {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Codin\\Downloads\\chromedriver\\chromedriver.exe");
    	browser = new ChromeDriver();
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	browser.navigate().to("https://www.facebook.com/");
    	browser.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys("Eric");
    	browser.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys("Wang");
    	browser.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys("xinxinw321@icloud.com");
    	browser.findElement(By.xpath("//input[@id='u_0_u']")).sendKeys
    	(browser.findElement(By.xpath("//input[@id='u_0_r']")).getAttribute("value"));
    	browser.findElement(By.xpath("//input[@id='u_0_w']")).sendKeys("12134");
        browser.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
    	browser.findElement(By.id("month")).sendKeys("3");
    	browser.findElement(By.id("day")).sendKeys("10");
    	browser.findElement(By.id("year")).sendKeys("2010");
        // male is selected
        List<WebElement> radio = browser.findElements(By.xpath("//input[@name='sex' and @type='radio']"));
        for(int i=0; i<radio.size();i++) 
        {
        	 local_radio = radio.get(i);
        	if(local_radio.isSelected()) 
        	{
        		idx_radio = i; 
        	}
        }    		
    	fName = browser.findElement(By.xpath("//input[@id='u_0_m']"));
    	lName = browser.findElement(By.xpath("//input[@id='u_0_o']"));	
    	fEmail = browser.findElement(By.xpath("//input[@id='u_0_r']"));
    	sEmail = browser.findElement(By.xpath("//input[@id='u_0_u']"));
    	password = browser.findElement(By.xpath("//input[@id='u_0_w']"));
    	dMonth = browser.findElement(By.id("month"));
    	dDay = browser.findElement(By.id("day"));
    	dYear = browser.findElement(By.id("year"));
    	expectedfName = "Eric";
    	expectedlName = "Wang";
    	expectedPassword = "12134";
    	expectedMonth ="3";
    	expectedDay ="10";
    	expectedYear ="2010";
    	assertTrue(idx_radio==1);
    	assertFalse(idx_radio==0||idx_radio==2);
    	assertEquals(expectedfName,fName.getAttribute("value"));
    	assertEquals(expectedlName,lName.getAttribute("value"));
    	assertEquals(fEmail.getAttribute("value"),sEmail.getAttribute("value"));
    	assertEquals(expectedPassword,password.getAttribute("value"));
    	assertEquals(expectedMonth,dMonth.getAttribute("value"));
    	assertEquals(expectedDay,dDay.getAttribute("value"));
    	assertEquals(expectedYear,dYear.getAttribute("value"));
        signUp = browser.findElement(By.name("websubmit"));
	    signUp.click();
	    
	    browser.findElement(By.name("websubmit")).submit();
	    assertTrue(browser.findElement(By.id("u_0_17")).isEnabled());
	      	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	browser.close();
    }

    @When("^user enters data$")
    public void user_enters_data() throws Throwable
    {
    }

    @Then("^validate user input$")
    public void validate_user_input() throws Throwable
    {
 
    }

    @Then("^clicks_sign_up$")
    public void clicks_sign_up() throws Throwable {
       
    }
}

