package AutoTesting.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebElement countryChoice;

	@FindBy(xpath = "//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement formLink;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/input[1]")
	private WebElement nameField;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
	private WebElement countryDrop;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement ukSelect;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement franceSelect;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement germanySelect;

	@FindBy(id = "nameInput")
	private WebElement email;

	@FindBy(id = "passInput")
	private WebElement pass1;

	@FindBy(id = "passInput2")
	private WebElement pass2;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
	private WebElement submitBtn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/h1")
	private WebElement check;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/p[10]")
	private WebElement passCheck;

	public void goToForm() {
		formLink.click();
	}

	public void fillCountry(WebDriver driver, String country, Actions action) {
		WebElement dynamicEl = (new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(nameField)));
		dynamicEl.sendKeys("Dom");
		action.moveToElement(countryDrop).perform();

		if (country.equals("United Kingdom")) {
			countryChoice = ukSelect;
		}
		if (country.equals("France")) {
			countryChoice = franceSelect;
		}
		if (country.equals("Germany")) {
			countryChoice = germanySelect;
		}

		WebElement dynamicEl2 = (new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(countryChoice)));
		action.moveToElement(dynamicEl2).click().perform();
		;

	}

	public void fillEmail(String email1) {
		email.sendKeys(email1);
	}

	public void fillPassword(String password) {
		pass1.sendKeys(password);
	}

	public void fillPasswordConf(String password) {
		pass2.sendKeys(password);
		submitBtn.click();
	}

	public String checkCreation() {
		
		return check.getText();
	
	}
	
	public String checkFail() {
		return passCheck.getText();
	}
}
