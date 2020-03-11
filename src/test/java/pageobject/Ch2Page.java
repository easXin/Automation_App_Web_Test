package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ch2Page{
	@FindBy(xpath="//a[contains(text(),'Index')]")
	WebElement goBackToHomePage;
	
	@FindBy(xpath="//input[@name='but2']")
	WebElement btn_withNameDoesNothing;
	
	@FindBy(xpath="//input[@id='random']")
	WebElement btn_randomDoesNothing;
	
	@FindBy(xpath="//input[@id='but1']")
	WebElement btn_withIdDoesNothing;
	
	@FindBy(xpath="//div[@id='divontheleft']//input[2]")
	WebElement btn_siblingDoesNothing;
	
	@FindBy(xpath="//input[@name='verifybutton']")
	WebElement btn_verifyDoesNothng;
	
	@FindBy(xpath="//input[@name='verifybutton1']")
	WebElement btn_chocolateDoesNothing;
	
	@FindBy(xpath="//div[6]")
	WebElement checkMyId;
	
	@FindBy(xpath = "//title[contains(text(),'Selenium: Beginners Guide')]")
	WebElement websiteTitle;
	
	WebDriver driver;
	public Ch2Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public String getTitle() {
		return websiteTitle.getText();
	}
	public void clickOnIndex() {
		goBackToHomePage.click();
	}
	
	public void clickOnBtnWithName() {
		btn_withNameDoesNothing.click();
	}
	
	public void clickOnBtnRandom() {
		btn_randomDoesNothing.click();
	}
	
	public void clickOnBtnWithId() {
		btn_withIdDoesNothing.click();
	}
	
	public void clickOnBtnSibling() {
		btn_siblingDoesNothing.click();
	}
	
	public void clickOnBtnVerify() {
		btn_verifyDoesNothng.click();
	}
	
	public void clickOnBtnChocolate() {
		btn_chocolateDoesNothing.click();
	}
	
	public static String getPageName() {
		return "Ch2 Page";
	}
	
	public void checkDiv6ID() {
		// when the page is reloaded  : reload page twice, then do assertFail(oldId, newId) for selenium test
		
	}
	
}