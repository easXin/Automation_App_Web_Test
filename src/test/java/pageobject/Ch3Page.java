package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ch3Page {
	@FindBy(xpath = "//a[@id='index']")
	WebElement goBackToHomePage;
	@FindBy(xpath = "//title[contains(text(),'Selenium: Beginners Guide')]")
	WebElement websiteTitle;
	WebDriver driver=null;

	public Ch3Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return websiteTitle.getText();
	}

	public WebElement getGoBackToHomePage() {
		return goBackToHomePage;
	}

	public void goToHomePage() {
		getGoBackToHomePage().click();
	}

}