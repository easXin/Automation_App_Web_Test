package pageobject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//a[contains(text(),'Chapter1')]")
	WebElement chapter1;

	@FindBy(xpath = "//a[contains(text(),'Chapter2')]")
	WebElement chapter2;

	@FindBy(xpath = "//a[contains(text(),'Chapter3')]")
	WebElement chapter3;

	@FindBy(xpath = "//a[contains(text(),'Chapter4')]")
	WebElement chapter4;

	@FindBy(xpath = "//a[contains(text(),'Chapter8')]")
	WebElement chapter8;

	@FindBy(xpath = "//input[@id='q']")
	WebElement textField;
	
	@FindBy(xpath = "//title[contains(text(),'Selenium: Beginners Guide')]")
	WebElement websiteTitle;
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getChapter1() {
		return chapter1;
	}

	public WebElement getChapter2() {
		return chapter2;
	}

	public WebElement getChapter3() {
		return chapter3;
	}

	public WebElement getChapter4() {
		return chapter4;
	}

	public WebElement getChapter8() {
		return chapter8;
	}
	public boolean isTextFieldSelected() {
		return textField.isSelected();
	}
	public boolean isTextFieldBlank() {
		return textField.isEnabled();
	}
	
	public boolean isCh1Visited() {
		return getChapter1().isEnabled();
	}

	public boolean isCh2Visited() {
		return getChapter2().isEnabled();
	}

	public boolean isCh3Visited() {
		return getChapter3().isEnabled();
	}

	public boolean isCh4Visited() {
		return getChapter4().isEnabled();
	}

	public boolean isCh8Visited() {
		return getChapter8().isEnabled();
	}
	
	public void selectAllTheText() {

	}
	public String getTitle() {
		return websiteTitle.getText();
	}
	public void clickOnLink() {
		chapter1.click();
	}

	public void setTextField(WebElement textField) {
		this.textField = textField;
	}

	public void checkoutChapter1() {
		chapter1.sendKeys(Keys.RETURN);
	}

	public void checkoutChapter2() {
		chapter2.sendKeys(Keys.RETURN);
	}

	public void checkoutChapter3() {
		chapter3.sendKeys(Keys.RETURN);
	}

	public void checkoutChapter4() {
		chapter4.sendKeys(Keys.RETURN);
	}

	public void checkoutChapter8() {
		chapter8.sendKeys(Keys.RETURN);
	}

	public void setTextInTextField() {
		String tempArr[] = { "OH NO, HERE WE GO AGAIN", "GOOGLE IS MY BEST FRIEND", "TESTING ...",
				"WHAT AM I DOING HERE", "I AM BORED", "STILL THINKING ABOUT TESTING",
				"I HAVE NO IDEA ON TOP OF MY HEAD" };
		textField.sendKeys(tempArr[getRandomInteger(6, 0)]);
	}
	public static String getPageName() {
		return "Main Page";
	}
	public int getRandomInteger(int max, int min) {
		return ((int) (Math.random() * (max - min))) + min;
	}

}
