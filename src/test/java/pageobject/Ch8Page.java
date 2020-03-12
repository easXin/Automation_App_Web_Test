package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ch8Page {
	@FindBy(xpath = "//input[@id='secondCookie']")
	WebElement btn_secondCookies;

	WebDriver driver = null;

	public Ch8Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//title[contains(text(),'Selenium: Beginners Guide')]")
	WebElement websiteTitle;

	public String getTitle() {
		return websiteTitle.getText();
	}

	public void clickCookieBtn() {
		btn_secondCookies.click();
	}

	public WebElement getBtn_SecondCookies() {
		return btn_secondCookies;
	}

	public boolean isBtnClicked() {
		return getBtn_SecondCookies().isEnabled();
	}

}
