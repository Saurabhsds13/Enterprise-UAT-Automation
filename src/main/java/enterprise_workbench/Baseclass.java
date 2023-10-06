package enterprise_workbench;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Baseclass {

	protected static WebDriver DR;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		Reporter.log("*=*=* BROWSER SESSION STARTED *=*=*\n", true);
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.addArguments("force-device-scale-factor=0.90");
		options.addArguments("high-dpi-support=0.90");
		DR= new ChromeDriver(options);
		new WebDriverWait(DR, Duration.ofSeconds(60));
		DR.get("https://enterprise-uat.dmart.in/");
		System.out.println("\tNavigated to Enterprise Home page");
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void tearDown() {
		DR.manage().deleteAllCookies();
		if(DR!=null) {
			DR.quit();
		}
		Reporter.log("\n*=*=* BROWSER SESSION END *=*=*", true);
	}
}
