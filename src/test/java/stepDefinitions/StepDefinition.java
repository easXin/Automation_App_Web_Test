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

    @Given("^user opens facebook page$")
    public void user_opens_facebook_page() throws Throwable {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\codin\\Downloads\\chromedriver\\chromedriver.exe");
    	// create instance
    	WebDriver browser = new ChromeDriver();
    	// go to google.com
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	browser.navigate().to("https://www.facebook.com/");
       	browser.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys("Eric");
    	browser.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys("Wang");
    	
    	WebElement fName = browser.findElement(By.xpath("//input[@id='u_0_m']"));
    	WebElement lName = browser.findElement(By.xpath("//input[@id='u_0_o']"));
    	String expectedfName = "Eric";
    	String expectedlName = "Wang";
    	
    	// email 
    	browser.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys("xinxinw321@icloud.com");
    	browser.findElement(By.xpath("//input[@id='u_0_u']")).sendKeys
    	(browser.findElement(By.xpath("//input[@id='u_0_r']")).getAttribute("value"));
    	WebElement fEmail = browser.findElement(By.xpath("//input[@id='u_0_r']"));
    	WebElement sEmail = browser.findElement(By.xpath("//input[@id='u_0_u']"));
    	
    	
    	// password 
    	
    	browser.findElement(By.xpath("//input[@id='u_0_w']")).sendKeys("12134");
    	WebElement password = browser.findElement(By.xpath("//input[@id='u_0_w']"));
        String expectedPassword = "12134";
        
        // gender 
        browser.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
        List<WebElement> radio = browser.findElements(By.xpath("//input[@name='sex' and @type='radio']"));
        
        int idx_radio = -1;
        for(int i=0; i<radio.size();i++) {
        	WebElement local_radio = radio.get(i);
        	if(local_radio.isSelected()) {
        		idx_radio = i; 
        	}
        }
        // male is selected 
        System.out.println(idx_radio);
    	assertTrue(idx_radio==1);
    	assertFalse(idx_radio==0||idx_radio==2);
    	// month day year 
    	browser.findElement(By.id("month")).sendKeys("3");
    	browser.findElement(By.id("day")).sendKeys("10");
    	browser.findElement(By.id("year")).sendKeys("2010");
    	
//    	WebElement mySelectElement = browser.findElement(By.name("birthday_month"));
//    	Select dropdown= new Select(mySelectElement);
//    	System.out.println(dropdown.toString());
//    	browser.findElement(By.xpath("//input[@id='month']")).sendKeys("Sep");
//    	List<WebElement>Options_M = (List<WebElement>) browser.findElement(By.name("birthday_month"));
//    	for(WebElement option: Options_M) {
//    		if(option.getAttribute("value").equals("Sep")) {
//    			option.click();
//    			break;
//    		}
//    	}
//    	
//    	browser.findElement(By.xpath("//input[@id='month']")).sendKeys("1");
//    	List<WebElement>Options_D = (List<WebElement>) browser.findElement(By.xpath("//input[@id='month']"));
//    	for(WebElement option: Options_D) {
//    		if(option.getAttribute("value").equals("1")) {
//    			option.click();
//    			break;
//    		}
//    	}
//    
//    	browser.findElement(By.xpath("//input[@id='year']")).sendKeys("2010");
//    	List<WebElement>Options_Y = (List<WebElement>) browser.findElement(By.xpath("//input[@type='radio']"));
//    	for(WebElement option: Options_Y) {
//    		if(option.getAttribute("value").equals("2010")) {
//    			option.click();
//    			break;
//    		}
//    	}
    	WebElement dMonth = browser.findElement(By.id("month"));
    	WebElement dDay = browser.findElement(By.id("day"));
    	WebElement dYear = browser.findElement(By.id("year"));
    	
    	String expectedMonth ="3";
    	String expectedDay ="10";
    	String expectedYear ="2010";
    	
    	assertEquals(expectedfName,fName.getAttribute("value"));
    	assertEquals(expectedlName,lName.getAttribute("value"));
    	assertEquals(fEmail.getAttribute("value"),sEmail.getAttribute("value"));
    	assertEquals(expectedPassword,password.getAttribute("value"));
    	assertEquals(expectedMonth,dMonth.getAttribute("value"));
    	assertEquals(expectedDay,dDay.getAttribute("value"));
    	assertEquals(expectedYear,dYear.getAttribute("value"));
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	browser.close();
    }

    @When("^user inputs data$")
    public void user_inputs_data() throws Throwable {
       
    }

    @When("^user inputs confirmation code$")
    public void user_inputs_confirmation_code() throws Throwable {
      
    }

    @Then("^then new account is created$")
    public void then_new_account_is_created() throws Throwable {
       
    }

    @And("^clicks sign up button$")
    public void clicks_sign_up_button() throws Throwable {
       
    }
}

