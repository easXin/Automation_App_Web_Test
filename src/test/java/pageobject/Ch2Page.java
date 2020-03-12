package pageobject;

import java.util.List;

import org.openqa.selenium.By;
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
	public void goToHomePage() {
		getGoBackToHomePage().click();
	}

	
	public WebElement getGoBackToHomePage() {
		return goBackToHomePage;
	}
	public void setGoBackToHomePage(WebElement goBackToHomePage) {
		this.goBackToHomePage = goBackToHomePage;
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
	public WebElement getBtn_withNameDoesNothing() {
		return btn_withNameDoesNothing;
	}
	public void setBtn_withNameDoesNothing(WebElement btn_withNameDoesNothing) {
		this.btn_withNameDoesNothing = btn_withNameDoesNothing;
	}
	public WebElement getBtn_randomDoesNothing() {
		return btn_randomDoesNothing;
	}
	public void setBtn_randomDoesNothing(WebElement btn_randomDoesNothing) {
		this.btn_randomDoesNothing = btn_randomDoesNothing;
	}
	public WebElement getBtn_withIdDoesNothing() {
		return btn_withIdDoesNothing;
	}
	public void setBtn_withIdDoesNothing(WebElement btn_withIdDoesNothing) {
		this.btn_withIdDoesNothing = btn_withIdDoesNothing;
	}
	public WebElement getBtn_siblingDoesNothing() {
		return btn_siblingDoesNothing;
	}
	public void setBtn_siblingDoesNothing(WebElement btn_siblingDoesNothing) {
		this.btn_siblingDoesNothing = btn_siblingDoesNothing;
	}
	public WebElement getBtn_verifyDoesNothng() {
		return btn_verifyDoesNothng;
	}
	public void setBtn_verifyDoesNothng(WebElement btn_verifyDoesNothng) {
		this.btn_verifyDoesNothng = btn_verifyDoesNothng;
	}
	public WebElement getBtn_chocolateDoesNothing() {
		return btn_chocolateDoesNothing;
	}
	public void setBtn_chocolateDoesNothing(WebElement btn_chocolateDoesNothing) {
		this.btn_chocolateDoesNothing = btn_chocolateDoesNothing;
	}
	public boolean isChocolateClicked() {
		return getBtn_chocolateDoesNothing().isEnabled();
	}
	public boolean isRandomClicked() {
		return getBtn_randomDoesNothing().isEnabled();
	}
	public boolean isSiblingClicked() {
		return getBtn_siblingDoesNothing().isEnabled();
	}
	public boolean isVerClicked() {
		return getBtn_verifyDoesNothng().isEnabled();
	}
	public boolean isIdClicked() {
		return getBtn_withIdDoesNothing().isEnabled();
	}
	public boolean isNameClicked() {
		return getBtn_withNameDoesNothing().isEnabled();
	}
	
	public static String getPageName() {
		return "Ch2 Page";
	}

	
}