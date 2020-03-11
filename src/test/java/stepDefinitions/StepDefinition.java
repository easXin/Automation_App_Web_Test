package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.HomePage;

import pageobject.Ch1Page;
import pageobject.Ch2Page;
import pageobject.Ch3Page;
import pageobject.Ch4Page;
import pageobject.Ch8Page;

public class StepDefinition {

	private final String homeUrl = "http://book.theautomatedtester.co.uk/";
	WebDriver driver = null;
	HomePage homePage = null;
	Ch1Page ch1 = null;
	Ch2Page ch2 = null;
	Ch3Page ch3 = null;
	Ch4Page ch4 = null;
	Ch8Page ch8 = null;
	boolean isSelected = false;

	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to(homeUrl);
		curLoc(HomePage.getPageName());
	}

	@Given("^I see five hyperlinks on the site$")
	public void shouldNavigateToTestorSite() throws Throwable {
		init();
		assertEquals(5, numberOfElementOnthePage("//a"));
		threadSleep_3000();
	}

	@When("^I click on any one of them")
	public void clickOnHyperlinks() throws Throwable {
		int ranNum = getRandomInteger(4, 0);
		homePage = new HomePage(driver);
		switch (ranNum) {
		case 0:
			//redirectingToPage(Ch1Page.getPageName());
			homePage.checkoutChapter1();
			//curLoc(HomePage.getPageName());
			break;
		case 1:
			//redirectingToPage(Ch2Page.getPageName());
			homePage.checkoutChapter2();
			//curLoc(HomePage.getPageName());
			break;
		case 2:
			//redirectingToPage(Ch3Page.getPageName());
			homePage.checkoutChapter3();
			//curLoc(HomePage.getPageName());
			break;
		case 3:
			//redirectingToPage(Ch4Page.getPageName());
			homePage.checkoutChapter4();
			//curLoc(HomePage.getPageName());
			break;
		case 4:
			//redirectingToPage(Ch8Page.getPageName());
			homePage.checkoutChapter8();
			//curLoc(HomePage.getPageName());
			break;

		}
		threadSleep_3000();
	}

	@Then("^I should be on that hyperlink page$")
	public void onHyperlinkPage() {
		assertNotEquals(homeUrl, currentURL(driver));
		System.out.println( currentURL(driver).getClass());
		tearDownTest(1);
	}

	@When("^I visited all the links on the site$")
	public void visitAlltheWebsite() throws Throwable {
		homePage = new HomePage(driver);
		
		homePage.checkoutChapter1();
		threadSleep_2000();
		navigateToPreviousPage();

		homePage.checkoutChapter2();
		threadSleep_2000();
		navigateToPreviousPage();

		homePage.checkoutChapter3();
		threadSleep_2000();
		navigateToPreviousPage();

		homePage.checkoutChapter4();
		threadSleep_2000();
		navigateToPreviousPage();

		homePage.checkoutChapter8();
		threadSleep_2000();
		navigateToPreviousPage();

	}

	@Then("^I shold be taken back to the main site$")
	public void takingBacktoTheMainSite() throws Throwable {
		assertEquals(homeUrl, currentURL(driver));
	}

	@And("^the color of visited hyperlink should be changed$")
	public void colorOfLinksHasChanged() throws Throwable {
		homePage = new HomePage(driver);
		assertTrue(homePage.isCh1Visited());
		assertTrue(homePage.isCh2Visited());
		assertTrue(homePage.isCh3Visited());
		assertTrue(homePage.isCh4Visited());
		assertTrue(homePage.isCh8Visited());
		tearDownTest(2);
	}

	@Then("the website name should never changed")
	public void sameTitleAllTheTime() {
		homePage = new HomePage(driver);
		ch1 = new Ch1Page(driver);
		assertEquals(homePage.getTitle(), ch1.getTitle());
		ch2 = new Ch2Page(driver);
		assertEquals(homePage.getTitle(), ch2.getTitle());
		ch3 = new Ch3Page(driver);
		assertEquals(homePage.getTitle(), ch3.getTitle());
		ch4 = new Ch4Page(driver);
		assertEquals(homePage.getTitle(), ch4.getTitle());
		ch8 = new Ch8Page(driver);
		assertEquals(homePage.getTitle(), ch8.getTitle());
		tearDownTest(3);
	}

	@When("^I select all the visible text on the webesite$")
	public void selectAlltheText() throws Throwable {
		init();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"a");
		isSelected = true;
		threadSleep_2000();
	}

	@Then("^the text is selectable$")
	public void textIsSelected() throws Throwable {
		assertTrue(isSelected);
		tearDownTest(4);
	}

	@Given("there is a text editing field on the page")
	public void oneInputFieldOnthePage() throws Throwable {
		init();
		assertEquals(1, numberOfElementOnthePage("//input"));
		threadSleep_3000();
	}

	@When("^I click on it$")
	public void i_click_on_it() throws Throwable {
		homePage = new HomePage(driver);
		assertTrue(homePage.isTextFieldBlank());
		homePage.setTextInTextField();
		threadSleep_5000();
	}

	@Then("^I can input some text$")
	public void i_can_input_some_text() throws Throwable {
		homePage = new HomePage(driver);
		assertFalse(homePage.isTextFieldSelected());
		tearDownTest(5);
	}

	/*
	 * --------------------- Helper methods---------------------------------------
	 */

	private int numberOfElementOnthePage(String xpathStr) {
		List<WebElement> link = driver.findElements(By.xpath(xpathStr));

		return link.size();
	}

	private void navigateToPreviousPage() {
		driver.navigate().back();
	}

	private String currentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public static int getRandomInteger(int max, int min) {
		return ((int) (Math.random() * (max - min))) + min;
	}
	public void redirectingToPage(String loc) {
		System.out.println("Now redirecting to "+ loc );
	}

	public void tearDownTest(int i) {
		driver.close();
		driver.quit();
		System.out.println("Test " + i + " completed successfully");
	}
	public void curLoc(String loc) {
		System.out.println("Current page : "+loc);
	}

	public void threadSleep_5000() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public void threadSleep_3000() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public void threadSleep_2000() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
