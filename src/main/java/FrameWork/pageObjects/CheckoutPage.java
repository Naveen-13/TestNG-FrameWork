package FrameWork.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWork.abstractcomponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@placeholder='Select Country']")
	WebElement countryNameElement;
	
	@FindBy(xpath="//*[contains(text(),'India')]")
	WebElement selectCountryElement;
	
	@FindBy(css=".action__submit")
	WebElement submitbuttonElement;
	
	
	
	By resultWaitTime = By.cssSelector(".ta-results");
	
	
	
	public ConfirmPage validatingCart(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(countryNameElement, countryName).build().perform();
		waitElementToAppear(resultWaitTime);
		selectCountryElement.click();
		submitbuttonElement.click();
		ConfirmPage confirmPage = new ConfirmPage(driver);
		return confirmPage;
		
	}
	

}
