package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	boolean isTrue = false;
	private int i_numN, i_numO;

	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to(homeUrl);
		// curLoc(HomePage.getPageName());
	}

// =========================================================================
	@Given("^I see five hyperlinks on the site$")
	public void shouldNavigateToTestorSite() throws Throwable {
		init();
		assertEquals(numberOfElementOnthePage("//a"), 5);
		threadSleep_3000();
	}

	@When("^I click on any one of them")
	public void clickOnHyperlinks() throws Throwable {
		int ranNum = getRandomInteger(4, 0);
		homePage = new HomePage(driver);
		switch (ranNum) {
		case 0:
			// redirectingToPage(Ch1Page.getPageName());
			homePage.checkoutChapter1();
			// curLoc(HomePage.getPageName());
			break;
		case 1:
			// redirectingToPage(Ch2Page.getPageName());
			homePage.checkoutChapter2();
			// curLoc(HomePage.getPageName());
			break;
		case 2:
			// redirectingToPage(Ch3Page.getPageName());
			homePage.checkoutChapter3();
			// curLoc(HomePage.getPageName());
			break;
		case 3:
			// redirectingToPage(Ch4Page.getPageName());
			homePage.checkoutChapter4();
			// curLoc(HomePage.getPageName());
			break;
		case 4:
			// redirectingToPage(Ch8Page.getPageName());
			homePage.checkoutChapter8();
			// curLoc(HomePage.getPageName());
			break;

		}
		threadSleep_3000();
	}

	@Then("^I should be on that hyperlink page$")
	public void onHyperlinkPage() {
		assertNotEquals(homeUrl, currentURL(driver));
		tearDownTest();
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
		tearDownTest();
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
		tearDownTest();
	}

	@When("^I select all the visible text on the webesite$")
	public void selectAlltheText() throws Throwable {
		init();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "a");
		isSelected = true;
		threadSleep_2000();
	}

	@Then("^the text is selectable$")
	public void textIsSelected() throws Throwable {
		assertTrue(isSelected);
		tearDownTest();
	}

	@Given("there is a text editing field on the page")
	public void oneInputFieldOnthePage() throws Throwable {
		init();
		assertEquals(numberOfElementOnthePage("//input"), 1);
		threadSleep_3000();
	}

	@When("^I click on it$")
	public void clickOnTextEditField() throws Throwable {
		homePage = new HomePage(driver);
		assertTrue(homePage.isTextFieldBlank());
		homePage.setTextInTextField();
		threadSleep_5000();
	}

	@Then("^I can input some text$")
	public void giveSomeInput() throws Throwable {
		homePage = new HomePage(driver);
		assertFalse(homePage.isTextFieldSelected());
		tearDownTest();
	}
	/* Home Page */
// =======================================================================

	@Given("^I am on the home page$")
	public void enterMainPage() throws Throwable {
		init();
		assertEquals(homeUrl, currentURL(driver));
		threadSleep_2000();
	}

	@When("^I click on chapter1$")
	public void clickOnCh1() throws Throwable {
		homePage = new HomePage(driver);
		actionClickAndHold(homePage.getChapter1());
		threadSleep_2000();
	}

	@Then("^I will be redirected to the ch1 page$")
	public void takenToCh1Page() throws Throwable {
		assertNotEquals(homeUrl, currentURL(driver));
		threadSleep_2000();
	}

	@When("^I click on the home page hyperlink$")
	public void clickOnHomePageAnchor() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.goToHomePage();
		homePage = new HomePage(driver);
		assertTrue(homePage.isCh1Visited());
	}

	@Then("^I should be taken back to the main page$")
	public void takeBackToMain() throws Throwable {
		assertEquals(homeUrl, currentURL(driver));
		tearDownTest();
	}

	@When("^I click on the radio button$")
	public void i_click_on_the_radio_button() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.clickOnRadioButton();

	}

	@Then("^radio button is selected$")
	public void radio_button_is_selected() throws Throwable {
		ch1 = new Ch1Page(driver);
		assertTrue(ch1.isRadioBtnClicked());
	}

	@When("^I click on the checkbox$")
	public void i_click_on_the_checkbox() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.clickOnCheckBox();
	}

	@Then("^It is checked$")
	public void it_is_checked() throws Throwable {
		ch1 = new Ch1Page(driver);
		assertTrue(ch1.isCheckBoxSelected());

	}

	@And("^radio button can not be unselected$")
	public void radio_button_can_not_be_unselected() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.clickOnCheckBox();
		ch1.clickOnCheckBox();
		assertFalse(ch1.isCheckBoxSelected());
	}

	@Then("It can be either checked or unchecked")
	public void it_can_be_either_checked_or_unchecked() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.clickOnCheckBox();
		assertFalse(ch1.isCheckBoxSelected());
		threadSleep_2000();
		ch1.clickOnCheckBox();
		assertTrue(ch1.isCheckBoxSelected());
		threadSleep_2000();
		tearDownTest();

	}

	@When("^I see the dropdown menu$")
	public void oneDropdownMenu() throws Throwable {
		ch1 = new Ch1Page(driver);
		assertEquals(1, numberOfElementOnthePage("//select[@id='selecttype']"));
	}

	@Then("^I want to click on every item on the menu$")
	public void clickOnAllFourItems() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.dropdownMenu();
		assertEquals(ch1.getNumOfItem(), 4);
	}

	@And("^go back to main page$")
	public void goBackToMain() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.goToHomePage();
		assertEquals(homeUrl, currentURL(driver));
		tearDownTest();
	}

	@And("^close browser$")
	public void closeNow() throws Throwable {
		tearDownTest();
	}

	@And("^I see two buttons, one textbox, one input field on this page$")
	public void i_see_two_buttons_one_textbox_one_input_field_on_this_page() throws Throwable {
		ch1 = new Ch1Page(driver);
		assertNotNull(ch1.getBtn_verify());
		assertNotNull(ch1.getBtn_loadTextToField());
		assertNotNull(ch1.getInputArea());
		assertNotNull(ch1.getContentTable());
	}

	@When("^I click load text button$")
	public void i_click_load_text_button() throws Throwable {
		ch1 = new Ch1Page(driver);
		i_numN = ch1.numOfCharactor();
		int i = 0;
		while (i < 3) {
			actionClickAndHold(ch1.getBtn_loadTextToField());
			threadSleep_2000();
			i++;
		}
		i_numO = ch1.numOfCharactor();

	}

	@Then("^new content will be added into textbox$")
	public void new_content_will_be_added_into_textbox() throws Throwable {
		// if numofchar are not equals, then new content has added into the text field
		assertNotEquals(i_numN, i_numO);
	}

	@When("^I click on verify button$")
	public void i_click_on_verify_button() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.isClickedVerBtn();
	}

	@Then("^nothing would happen$")
	public void nothing_would_happen() throws Throwable {
		assertTrue(Ch1Page.temp != 0);
	}

	@When("^I click on the textbox or input field$")
	public void i_click_on_the_textbox_or_input_field() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.addContent("content");
		ch1.cleanUpText();
		ch1.addContent("content");
		threadSleep_2000();
		ch1.addContent("content");
		threadSleep_2000();
		ch1.addContent("content");
		threadSleep_2000();
		ch1.addContent("input");
		ch1.cleanUpText();
		threadSleep_2000();
		ch1.addContent("input");
		threadSleep_3000();
		ch1.cleanUpInput();
		threadSleep_2000();
		ch1.addContent("input");
		ch1.cleanUpText();
		threadSleep_2000();
		ch1.addContent("content");
		ch1.addContent("input");
		threadSleep_5000();
		ch1.cleanUpText();
		ch1.cleanUpInput();
	}

	@Then("I can editting both texting filed")
	public void i_can_editting_both_texting_filed() {
		assertEquals(ch1.numOfCharactor(), ch1.numOfCharactorInput());
	}

	@When("^I click on first two links$")
	public void i_click_on_first_two_links() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.clickOnanchor1();
		ch1.clickOnanchor2();
		assertTrue(ch1.isAnchor1Clicked());
		assertTrue(ch1.isAnchor2Clicked());
		// ch1.isAnchor2Clicked();
	}

	@Then("^the page would pop out a new windows$")
	public void the_page_would_pop_out_a_new_windows() throws Throwable {
		ch1 = new Ch1Page(driver);
		Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		Iterator<String> itererator = windowId.iterator();
		String newAdwinID = itererator.next();
		driver.switchTo().window(newAdwinID);
		threadSleep_3000();
	}

	@When("^I clike on the third link$")
	public void i_clike_on_the_third_link() throws Throwable {
		ch1 = new Ch1Page(driver);
		ch1.clickOnanchor3();
		assertTrue(ch1.isAnchor3Clicked());
		threadSleep_3000();
	}

	@Then("^a paragraph would displays on the page$")
	public void a_new_text_field_would_displays_on_my_current_page() throws Throwable {
		ch1 = new Ch1Page(driver);
		assertTrue(ch1.isShow());
	}

	/* Chapter 1 */
	// =======================================================================
	@When("^I click on chapter2$")
	public void i_click_on_chapter2() throws Throwable {
		homePage = new HomePage(driver);
		actionClickAndHold(homePage.getChapter2());
		threadSleep_2000();
		;
	}

	@When("^I enter ch2 page, I will encounter six buttons$")
	public void i_enter_ch2_page_i_will_encounter_six_buttons() throws Throwable {
		ch2 = new Ch2Page(driver);
		List<WebElement> link = driver.findElements(By.tagName("input"));
		System.out.println(driver.getCurrentUrl());

		assertEquals(link.size(), 6);
	}

	@Then("^I will be redirected to the ch2 page$")
	public void i_will_be_redirected_to_the_ch2_page() throws Throwable {
		assertNotEquals(homeUrl, currentURL(driver));
		threadSleep_2000();
	}

	@Then("^I click on each one of them$")
	public void i_click_on_each_one_of_them() throws Throwable {
		ch2 = new Ch2Page(driver);
		ch2.clickOnBtnChocolate();
		ch2.clickOnBtnRandom();
		ch2.clickOnBtnSibling();
		ch2.clickOnBtnVerify();
		ch2.clickOnBtnWithId();
		ch2.clickOnBtnWithName();
	}

	@But("^nothing has changed except I clicked all the element once$")
	public void nothing_has_changed_except_i_clicked_all_the_element_once() throws Throwable {
		ch2 = new Ch2Page(driver);
		assertTrue(ch2.isChocolateClicked());
		assertTrue(ch2.isRandomClicked());
		assertTrue(ch2.isSiblingClicked());
		assertTrue(ch2.isVerClicked());
		assertTrue(ch2.isIdClicked());
		assertTrue(ch2.isNameClicked());
	}

	@Then("^I see an index hyperlink on the ch2 page$")
	public void i_see_an_index_hyperlink_on_the_ch2_page() throws Throwable {
		ch2 = new Ch2Page(driver);
		assertNotNull(ch2.getGoBackToHomePage());
	}

	@When("I click on the index")
	public void i_click_on_the_index() throws Throwable {
		ch2 = new Ch2Page(driver);
		ch2.goToHomePage();
		homePage = new HomePage(driver);
		assertTrue(homePage.isCh2Visited());
	}
	/* Chapter 2 */
	// =======================================================================

	@When("^I click on chapter3$")
	public void i_click_on_chapter3() throws Throwable {
		homePage = new HomePage(driver);
		actionClickAndHold(homePage.getChapter3());
		threadSleep_2000();
		;
	}

	@When("^I click on the index on ch3 page$")
	public void i_click_on_the_index_on_ch3_page() throws Throwable {
		ch3 = new Ch3Page(driver);
		ch3.goToHomePage();
		homePage = new HomePage(driver);
		assertTrue(homePage.isCh2Visited());
	}

	@Then("^I will be redirected to the ch3 page$")
	public void i_will_be_redirected_to_the_ch3_page() throws Throwable {
		assertNotEquals(homeUrl, currentURL(driver));
		threadSleep_2000();
	}

	@Then("^I see an index hyperlink on the ch3 page$")
	public void i_see_an_index_hyperlink_on_the_ch3_page() throws Throwable {
		ch3 = new Ch3Page(driver);
		assertNotNull(ch3.getGoBackToHomePage());
	}
	/* Chapter 3 */
	// =======================================================================

    @When("^I click on chapter4$")
    public void i_click_on_chapter4() throws Throwable {
    	homePage = new HomePage(driver);
		actionClickAndHold(homePage.getChapter4());
		threadSleep_2000();
    }

    @When("^I click on the index on ch4 page$")
    public void i_click_on_the_index_on_ch4_page() throws Throwable {
    	ch4 = new Ch4Page(driver);
		ch4.goToHomePage();
		homePage = new HomePage(driver);
		assertTrue(homePage.isCh4Visited());
    }

    @When("^I see the dropdown menus$")
    public void i_see_the_dropdown_menu() throws Throwable {
    	ch4 = new Ch4Page(driver);                             
		assertEquals(1, numberOfElementOnthePage("//select[@id='selecttype']"));
    }
    @Then("^go back to home page$")
    public void goToHomePage() throws Throwable {
    	ch4 = new Ch4Page(driver);
		ch4.goToHomePage();
		assertEquals(homeUrl, currentURL(driver));
		tearDownTest();
    }
    @Then("I will be redirected to the ch4 page")
    public void i_will_be_redirected_to_the_ch4_page() throws Throwable {
    	assertNotEquals(homeUrl, currentURL(driver));
		threadSleep_2000();
    }

    @Then("I see an index hyperlink on the ch4 page")
    public void i_see_an_index_hyperlink_on_the_ch4_page() throws Throwable {
    	ch4 = new Ch4Page(driver);
		assertNotNull(ch4.getGoBackToPreviousPage());
    }
    
    @Then("^I want to click on every item on the menu $")
    public void i_want_to_click_on_every_item_on_the_menu() throws Throwable {
    	ch4 = new Ch4Page(driver);
		ch4.dropDownMenu1();
		assertEquals(ch4.getNumOfItem(), 4);
    }
    
    @When("^I click on the input field$")
    public void i_click_on_the_input_field() throws Throwable {
    	ch4 = new Ch4Page(driver);
    	ch4.addContent(1);
    	ch4.cleanUpText1();
    	threadSleep_2000();
    	ch4.addContent(2);
    	ch4.addContent(3);
    	threadSleep_2000();
    	ch4.cleanUpText3();
    	threadSleep_2000();
    	ch4.cleanUpText2();
    	ch4.addContent(1);
    	ch4.addContent(2);
    	ch4.addContent(3);
    	ch4.cleanUpText1();
    	threadSleep_2000();
    	ch4.cleanUpText3();
    	threadSleep_2000();
    	ch4.cleanUpText2();
    	threadSleep_2000();
    }

    @Then("^I enter the text on all input fields$")
    public void i_enter_the_text_on_all_input_fields() throws Throwable {
    	assertEquals(ch4.numOfCharactor1(), ch4.numOfCharactor2());
    	assertEquals(ch4.numOfCharactor2(), ch4.numOfCharactor3());
    }


    @Then("^hover over text field at left bottom of the page$")
    public void hover_over_text_field_at_left_bottom_of_the_page() throws Throwable {
    	//hoverArena
    	ch4 = new Ch4Page(driver);
    	Actions act =new Actions(driver);
    	act.moveToElement(ch4.getHoverArena()).perform();
    	driver.switchTo().alert().accept();
    	isTrue = true;
    }


    @And("^on the chapter 4 page, I saw two buttons$")
    public void on_the_chapter_4_page_i_saw_two_buttons() throws Throwable {
    	ch4 = new Ch4Page(driver);
		assertNotNull(ch4.getThisTextFieldDoingNothing());
		assertNotNull(ch4.getDropDownMenu2_doingNothing());
    }

    @And("^show a popup when hovering over the text field$")
    public void show_a_popup_when_hovering_over_the_text_field() throws Throwable {
        assertTrue(isTrue);
    }

    @But("^nothing would happen when I click on these two button$")
    public void nothing_would_happen_when_i_click_on_these_two_button() throws Throwable {
        ch4 = new Ch4Page(driver);
        ch4.clickOnTextBtn();
        ch4.clickOnDropdownBtn2();
        assertTrue(ch4.isTextBtnClicked());
        assertTrue(ch4.isDropdownBtn2Clicked());
    }

	/* Chapter 4 */
	// =======================================================================
	@When("^I click on chapter8$")
	public void i_click_on_chapter8() throws Throwable {
		homePage = new HomePage(driver);
		actionClickAndHold(homePage.getChapter8());
		threadSleep_2000();
		
	}

	@Then("^I will be redirected to the ch8 page$")
	public void i_will_be_redirected_to_the_ch8_page() throws Throwable {
		assertNotEquals(homeUrl, currentURL(driver));
		threadSleep_2000();
	}

	@And("^on the chapter 8 page, I saw a button$")
	public void on_the_chapter_8_page_i_saw_a_button() throws Throwable {
		ch8 = new Ch8Page(driver);
		ch8.clickCookieBtn();
	}

	@But("^nothing would happen when I click on that button$")
	public void nothing_would_happen_when_i_click_on_that_button() throws Throwable {
		ch8 = new Ch8Page(driver);
		assertTrue(ch8.isBtnClicked());
		tearDownTest();
	}
	/* Chapter 8 */
	// =======================================================================
	/*
	 * --------------------- Helper methods---------------------------------------
	 */

	public void actionClickAndHold(WebElement e) {
		Actions actions = new Actions(driver);
		actions.moveToElement(e).clickAndHold().release().build().perform();
	}

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
		System.out.println("Now redirecting to " + loc);
	}

	public void tearDownTest() {
		driver.close();
		driver.quit();
	}

	public void curLoc(String loc) {
		System.out.println("Current page : " + loc);
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
