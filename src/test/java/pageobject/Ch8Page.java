package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class Ch8Page{
	@FindBy(xpath="//input[@id='secondCookie']")
	WebElement btn_secondCookies;
	
	public void clickCookieBtn() {
		btn_secondCookies.click();
	}
}
