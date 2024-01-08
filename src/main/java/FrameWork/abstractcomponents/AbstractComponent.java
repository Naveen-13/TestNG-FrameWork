package FrameWork.abstractcomponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	WebDriverWait wait;
	

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orderButtonElement;

	public void waitElementToAppear(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToAppear(WebElement web) {
		wait.until(ExpectedConditions.visibilityOf(web));
	}

	public void waitElementToDisappear(WebElement waitElement) throws InterruptedException {
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.invisibilityOf(waitElement));
	}
	
	public OrderPage goToOrdersPage() {
		orderButtonElement.click();
		OrderPage orderPage =  new OrderPage(driver);
		return orderPage;
	}
	
	

}
