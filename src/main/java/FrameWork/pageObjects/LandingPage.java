package FrameWork.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWork.abstractcomponents.AbstractComponent;

;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement email_Element;

	@FindBy(id = "userPassword")
	WebElement userPasswordElement;

	@FindBy(id = "login")
	WebElement loginElement;

	@FindBy(css = "[class*='flyInOut']")
	WebElement loginErrorMElement;

	public ProductCatalogue loginApplication(String email, String password) {
		email_Element.sendKeys(email);
		userPasswordElement.sendKeys(password);
		loginElement.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
		
	}

	public void goToLink() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errormessageText() {
		waitForElementToAppear(loginErrorMElement);
		return loginErrorMElement.getText();
		
	}

}
