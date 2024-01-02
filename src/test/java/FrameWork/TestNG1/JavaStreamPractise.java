package FrameWork.TestNG1;

import java.util.List;import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaStreamPractise {
	
	@Test
	public void getSorted() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> orginalList = list.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = orginalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orginalList.equals(sortedList));
		List<String> price;
		do {
			List<WebElement> list1 = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		price = list1.stream().filter(s->s.getText().contains("hube")).map(s->getPrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		if(price.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(price.size()<1);
		
	}
private static String getPrice(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
	return priceValue;
	
}

}
