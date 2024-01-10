package FrameWork.baseComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import FrameWork.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initilizeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\FrameWork\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initilizeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goToLink();
		return landingPage;
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		//driver.close();
		driver.quit();  // To resolve the connection reset warning
	}
	
	public List<HashMap<String, String>> getJsonData() throws IOException {
		//Reading the file to String 
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\FrameWork\\data\\data.json");
		String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		
		//String to HashMap using Jackson Datbind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
		
		
		
	}
	
	

}
