package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Ch4Page {
	WebDriver webDriver = null;
	@FindBy(xpath = "//a[@id='index']")
	WebElement goBackToPreviousPage;

	@FindBy(xpath = "//input[@id='dateInput']")
	WebElement firstInputField;

	public WebElement getThirdInputField() {
		return thirdInputField;
	}

	public WebElement getFirstInputField() {
		return firstInputField;
	}

	public WebElement getSecondInputField() {
		return secondInputField;
	}

	@FindBy(xpath = "//select[@id='selecttype']")
	WebElement dropDownMenu1;

	@FindBy(xpath = "//input[@id='selectLoad']")
	WebElement thisTextFieldDoingNothing;

	public WebElement getThisTextFieldDoingNothing() {
		return thisTextFieldDoingNothing;
	}

	
	
	public void clickOnTextBtn() {
		thisTextFieldDoingNothing.click();
	}
	
	public boolean isTextBtnClicked() {
		return getThisTextFieldDoingNothing().isEnabled();
	}
	
	public void clickOnDropdownBtn2() {
		getDropDownMenu2_doingNothing().click();
	}
	
	public boolean isDropdownBtn2Clicked() {
		return getDropDownMenu2_doingNothing().isEnabled();
	}
	public WebElement getDropDownMenu2_doingNothing() {
		return dropDownMenu2_doingNothing;
	}

	@FindBy(xpath = "//select[@id='ajaxLoad']")
	WebElement dropDownMenu2_doingNothing;

	@FindBy(xpath = "//input[@id='blurry']")
	WebElement secondInputField;

	@FindBy(xpath = "//input[@id='nextBid']")
	WebElement thirdInputField;

	@FindBy(xpath = "//div[@id='hoverOver']")
	WebElement hoverArena;

	public WebElement getHoverArena() {
		return hoverArena;
	}

	@FindBy(xpath = "//title[contains(text(),'Selenium: Beginners Guide')]")
	WebElement websiteTitle;
	WebDriver driver;
	int numOfItem;

	public int getNumOfItem() {
		return numOfItem;
	}

	public Ch4Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void goToHomePage() {
		goBackToPreviousPage.click(); // and come back to this page
	}

	public WebElement getGoBackToPreviousPage() {
		return goBackToPreviousPage;
	}

	public void enterSomeText1() {
		firstInputField.sendKeys("Hello");
	}

	public void dropDownMenu1() {
		Select option = new Select(dropDownMenu1);
		// IDE Core RC Grid
		for (int i = 0; i < 4; i++) {
			try {
				Thread.sleep(4000);
				option.selectByIndex(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			option.selectByIndex(i);
		}
	}

	public void addContent(int temp) {
		String tempArr[] = { " OH NO, HERE WE GO AGAIN", " GOOGLE IS MY BEST FRIEND", "TESTING ...",
				" WHAT AM I DOING HERE", "I AM BORED", " STILL THINKING ABOUT TESTING",
				" I HAVE NO IDEA ON TOP OF MY HEAD", " Okay, let's go" };
		String str = tempArr[((int) (Math.random() * (7 - 0))) + 0];

		if (temp == 1) {
			getFirstInputField().sendKeys(str);
		} else if (temp == 1) {
			getSecondInputField().sendKeys(str);
		} else {
			getThirdInputField().sendKeys(str);
		}

	}
	public int numOfCharactor1() {
		return getFirstInputField().getText().length();
	}
	public int numOfCharactor2() {
		return getSecondInputField().getText().length();
	}
	public int numOfCharactor3() {
		return getThirdInputField().getText().length();
	}
	
	public void cleanUpText1() {
		getFirstInputField().clear();
	}
	public void cleanUpText2() {
		getSecondInputField().clear();
	}
	public void cleanUpText3() {
		getThirdInputField().clear();
	}
	public String getTitle() {
		return websiteTitle.getText();
	}

	public void clickOnThisTextField() {
		thisTextFieldDoingNothing.click();
	}

	public void dropDownMenu2() {
		Select option = new Select(dropDownMenu1);
		option.equals(null);
	}

	public void enterSomeText2() {
		secondInputField.sendKeys("Wassup");
	}

	public void enterSomeText3() {
		thirdInputField.sendKeys("Hello from the other side");
	}

	public void dismissAlertWindows() {
		Actions builder = new Actions(webDriver);
		builder.moveToElement(hoverArena).perform();
		webDriver.switchTo().alert().accept();
	}

	public static String getPageName() {
		return "Ch4 Page";
	}
}