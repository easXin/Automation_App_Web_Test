package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Ch1Page {
	
	@FindBy(id = "radiobutton")
	WebElement radioButton;

	@FindBy(id = "selecttype")
	WebElement dropdownMenu;

	@FindBy(name = "selected(1234)")
	WebElement checkBox;

	@FindBy(xpath = "//a[contains(text(),'Home Page')]")
	WebElement goToHomePage;

	@FindBy(xpath = "//input[@id='secondajaxbutton']")
	WebElement btn_loadTextToField;

	@FindBy(xpath = "//body//div[5]")
	WebElement anchor_1;

	@FindBy(xpath = "//body//div[6]")
	WebElement anchor_2;

	@FindBy(xpath = "//div[@id='loadajax']")
	WebElement anchor_3;

	@FindBy(xpath = "//div[@id='verifybutton']")
	WebElement btn_verify;

	@FindBy(xpath = "//div[@id='html5div']")
	WebElement contentTable;

	@FindBy(xpath = "//title[contains(text(),'Selenium: Beginners Guide')]")
	WebElement websiteTitle;
	public String getTitle() {
		return websiteTitle.getText();
	}
	WebDriver driver;
	public Ch1Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public void clickOnRadioButton() {
		radioButton.click();
	}

	public void clickOnCheckBox() {
		checkBox.click();
	}

	public void goToHomePage() {
		goToHomePage.click();
	}

	public void loadText() {
		btn_loadTextToField.click();
	}

	public void clickOnanchor1() {
		anchor_1.click();
	}

	public void clickOnanchor2() {
		anchor_2.click();
	}

	public void clickOnanchor3() {
		anchor_3.click();
	}
	public void clickOnVerifyBtn() {
		btn_verify.click();
	}
	public void contentTable() {
		contentTable.sendKeys("Okay, let's go");
	}
	public void dropdownMenu() {
		Select option = new Select(dropdownMenu);
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
	public String whereIAm() {
		return websiteTitle.getText();
	}
	public static String getPageName() {
		return "Ch1 Page";
	}
}
