package pageobject;

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

	@FindBy(xpath = "//input[@id='storeinput']")
	WebElement inputArea;

	@FindBy(xpath = "//div[@id='ajaxdiv']")
	WebElement textField2;

	public static int temp = 0;
	int numOfItem;

	public int getNumOfItem() {
		return numOfItem;
	}

	public WebElement getTextField2() {
		return textField2;
	}

	public boolean isShow() {
		return getTextField2().isDisplayed();
	}

	public void setNumOfItem(int numOfItem) {
		this.numOfItem = numOfItem;
	}

	public String getTitle() {
		return websiteTitle.getText();
	}

	WebDriver driver;

	public Ch1Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getInputArea() {
		return inputArea;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getBtn_loadTextToField() {
		return btn_loadTextToField;
	}

	public WebElement getAnchor_1() {
		return anchor_1;
	}

	public WebElement getAnchor_2() {
		return anchor_2;
	}

	public WebElement getAnchor_3() {
		return anchor_3;
	}

	public WebElement getBtn_verify() {
		return btn_verify;
	}

	public WebElement getContentTable() {
		return contentTable;
	}

	public int numOfCharactor() {
		return getContentTable().getText().length();
	}

	public int numOfCharactorInput() {
		return getInputArea().getText().length();
	}

	public void clickOnRadioButton() {
		radioButton.click();
	}

	public boolean isRadioBtnClicked() {
		return getRadioButton().isSelected();
	}

	public boolean isCheckBoxSelected() {
		return getCheckBox().isSelected();
	}

	public void clickOnCheckBox() {
		checkBox.click();
	}

	public void goToHomePage() {
		goToHomePage.click();
	}

	public void clickOnanchor1() {
		anchor_1.click();
	}

	public void clickOnanchor2() {
		anchor_2.click();
	}

	public boolean isAnchor1Clicked() {
		return getAnchor_1().isEnabled();
	}

	public boolean isAnchor2Clicked() {
		return getAnchor_2().isEnabled();
	}

	public boolean isAnchor3Clicked() {
		return getAnchor_3().isEnabled();
	}

	public void addContent(String temp) {
		String tempArr[] = { " OH NO, HERE WE GO AGAIN", " GOOGLE IS MY BEST FRIEND", "TESTING ...",
				" WHAT AM I DOING HERE", "I AM BORED", " STILL THINKING ABOUT TESTING",
				" I HAVE NO IDEA ON TOP OF MY HEAD", " Okay, let's go" };
		String str = tempArr[((int) (Math.random() * (7 - 0))) + 0];

		if (temp == "input") {
			getInputArea().sendKeys(str);
		} else {
			getContentTable().sendKeys(str);
		}

	}

	public void clickOnanchor3() {
		anchor_3.click();

	}

	public void isClickedVerBtn() {
		this.temp = 1;
	}

	public void cleanUpText() {
		getContentTable().clear();
	}

	public void cleanUpInput() {
		getInputArea().clear();
	}

	public void dropdownMenu() {
		Select option = new Select(dropdownMenu);
		int i = 0;
		// IDE Core RC Grid
		for (i = 0; i < 4; i++) {
			try {
				Thread.sleep(2000);
				option.selectByIndex(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			option.selectByIndex(i);
		}
		numOfOption(i);
	}

	public void numOfOption(int i) {
		setNumOfItem(i);
	}

}
