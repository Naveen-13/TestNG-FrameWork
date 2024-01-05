package FrameWork.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameWork.Abstractcomponents.AbstractComponent;


public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(@class,'mb-3')]")
	List<WebElement> productElements;

	@FindBy(css = ".ng-animating")
	WebElement waitElement;

	@FindBy(xpath = "//*[@routerlink='/dashboard/cart']")
	WebElement cartButtonElement;

	By productListBy = By.xpath("//*[contains(@class,'mb-3')]");
	By addToCartBy = By.xpath("div/div/button[2]");
	By toastBy = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitElementToAppear(productListBy);
		return productElements;
	}

	public WebElement getProductByName(String productName) {
		WebElement desiredProd = getProductList().stream()
				.filter(product -> product.findElement(By.xpath("div/div/h5/b")).getText().equals(productName))
				.findFirst().orElse(null);
		return desiredProd;
	}

	public MyCart addProductToCart(String productName) throws InterruptedException {
		WebElement desiredElement = getProductByName(productName);
		desiredElement.findElement(addToCartBy).click();
		waitElementToAppear(toastBy);
		waitElementToDisappear(waitElement);
		cartButtonElement.click();
		MyCart mycart = new MyCart(driver);
		return mycart;
	}
}
