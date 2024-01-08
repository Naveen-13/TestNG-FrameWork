package FrameWork.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import FrameWork.baseComponents.Base;
import FrameWork.pageObjects.CheckoutPage;
import FrameWork.pageObjects.ConfirmPage;
import FrameWork.pageObjects.MyCart;
import FrameWork.pageObjects.ProductCatalogue;

public class StandAloneTest extends Base {

	@Test
	public void alone() throws InterruptedException, IOException {

		String productName = "ZARA COAT 3";
		String countryName = "India";

		ProductCatalogue productcatalogue = landingPage.loginApplication("naveen@gmail.com", "Naveen@9797");
		productcatalogue.getProductList();
		MyCart mycart = productcatalogue.addProductToCart(productName);
		Boolean result = mycart.cartValidation(productName);
		Assert.assertTrue(result);
		CheckoutPage checkoutPage = mycart.goToCheckoutPage();
		ConfirmPage confirmPage = checkoutPage.validatingCart(countryName);
		String actualMessage = confirmPage.purchaseValidation();
		Assert.assertTrue(actualMessage.equalsIgnoreCase("Thankyou for the order."));

	}
}

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://rahulshettyacademy.com/client");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
//		driver.findElement(By.id("userEmail")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Naveen@9797");
//		driver.findElement(By.id("login")).click();
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		WebElement desiredProd = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
//		desiredProd.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'mb-3')]")));
//		List<WebElement> products = driver.findElements(By.xpath("//*[contains(@class,'mb-3')]"));
//		WebElement desiredProd = products.stream().filter(product -> product.findElement(By.xpath("div/div/h5/b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//		desiredProd.findElement(By.xpath("div/div/button[2]")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.xpath("//*[@routerlink='/dashboard/cart']")).click();		
//		List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
//		Boolean result = cartProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
//		Assert.assertTrue(result);
//		driver.findElement(By.xpath("//*[contains(text(),'Checkout')]")).click();

//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "india").build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		driver.findElement(By.xpath("//*[contains(text(),'India')]")).click();
//		driver.findElement(By.cssSelector(".action__submit")).click();		
//		String actualMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
