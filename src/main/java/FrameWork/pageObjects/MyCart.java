package FrameWork.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCart {
	WebDriver driver;

	public MyCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@class='cartSection']/h3")
	List<WebElement> cartProductElement;
	
	@FindBy(xpath="//*[contains(text(),'Checkout')]")
	WebElement checkoutButtonElement;
	
	public Boolean cartValidation(String productName) {
		Boolean result = cartProductElement.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return result;
		
	}
	public CheckoutPage goToCheckoutPage() {
		checkoutButtonElement.click();
		CheckoutPage checkoutPage =  new CheckoutPage(driver);
		return checkoutPage;
	}
	
	
	
}
