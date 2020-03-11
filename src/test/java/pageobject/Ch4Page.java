package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Ch4Page{
	WebDriver webDriver = null;
	@FindBy(xpath="//a[@id='index']")
	WebElement goBackToPreviousPage;
	
	@FindBy(xpath="//input[@id='dateInput']")
	WebElement firstInputField;
	
	@FindBy(xpath="//select[@id='selecttype']")
	WebElement dropDownMenu1;
	
	@FindBy(xpath="//input[@id='selectLoad']")
	WebElement thisTextFieldDoingNothing;
	
	@FindBy(xpath="//select[@id='ajaxLoad']")
	WebElement dropDownMenu2_doingNothing;
	
	@FindBy(xpath="//input[@id='blurry']")
	WebElement secondInputField;
	
	@FindBy(xpath="//input[@id='nextBid']")
	WebElement thirdInputField;
	
	@FindBy(xpath="//div[@id='hoverOver']")
	WebElement hoverArena;
	
	@FindBy(xpath = "//title[contains(text(),'Selenium: Beginners Guide')]")
	WebElement websiteTitle;
	WebDriver driver;
	public Ch4Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void goToHomePage() {
		goBackToPreviousPage.click(); // and come back to this page
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