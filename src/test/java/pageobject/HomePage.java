package pageobject;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath="//a[contains(text(),'Chapter1')]")
	WebElement chapter1;
	
	@FindBy(xpath="//a[contains(text(),'Chapter2')]")
	WebElement chapter2;
	
	@FindBy(xpath="//a[contains(text(),'Chapter3')]")
	WebElement chapter3;
	
	@FindBy(xpath="//a[contains(text(),'Chapter4')]")
	WebElement chapter4;
	
	@FindBy(xpath="//a[contains(text(),'Chapter8')]")
	WebElement chapter8;
	
	@FindBy(xpath="//input[@id='q']")
	WebElement textField;
	
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
	
	public void setTextInTextField(Random random) {
		String tempArr[] = {"OH NO, HERE WE GO AGAIN", "GOOGLE IS MY BEST FRIEND",
							"WHY CAN YOU EVEN SEE ME", "WHAT AM I DOING HERE",
							"I AM BORED","STILL THINKING ABOUT TESTING",
							"I HAVE NO IDEA ON TOP OF MY HEAD"}; 
		int index = (int)(0+random.nextInt((tempArr.length-1)-0+1));
		textField.sendKeys(tempArr[index]);
	}
	
}
