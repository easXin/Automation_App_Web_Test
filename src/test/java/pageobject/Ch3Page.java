package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class Ch3Page{
	@FindBy(xpath="//a[@id='index']")
	WebElement goBackToHomePage;
	
	public void goBackToPreviousPage() {
		goBackToHomePage.click();
	}
}