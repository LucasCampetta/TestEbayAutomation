package testEbay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjetc.ZapatillasPuma;

public class ExamenEbay{

	 private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	 
	 
	 @Test
	 public void testBuscadorEbay() {
		
		driver.navigate().to("https://www.ebay.com/");
		ZapatillasPuma miszapatillaspuma= new ZapatillasPuma(driver);
		miszapatillaspuma.busqueda("Shoes");
		
	}
		
		
	@AfterMethod
	public void after() {
		//driver.close();
		//driver.quit();
	}

}