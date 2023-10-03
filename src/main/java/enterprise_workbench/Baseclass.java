package enterprise_workbench;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Baseclass {

	protected static WebDriver DR;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		Reporter.log("*=*=* BROWSER SESSION STARTED *=*=*", true);
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		DR= new ChromeDriver(options);
		DR.get("https://enterprise-uat.dmart.in/");
		System.out.println("Navigated to Enterprise Home page");
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void tearDown() {
		DR.manage().deleteAllCookies();
		if(DR!=null) {
			DR.quit();
		}
		Reporter.log("*=*=* BROWSER SESSION END *=*=*", true);
	}
}
