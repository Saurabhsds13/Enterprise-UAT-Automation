package enterprise_workbench;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToEnterprise extends Baseclass {
	
	// PageFactory will set all these when the page is loaded
	@FindBy(id ="outlined-name")
	WebElement user;
	
	@FindBy(xpath="//*[contains(text(),'Next')]")
	WebElement nextbtn;
	
	@FindBy(id="outlined-adornment-password")
	WebElement pass;
	
	@FindBy(xpath="//*[contains(text(),'Sign In')]")
	WebElement signin;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/p/a")
	WebElement uservalidation;
	
	
	public void Login(String username,String password) throws InterruptedException {
		PageFactory.initElements(DR, this);
		Thread.sleep(2000);
		user.sendKeys(username);
		nextbtn.click();
		Thread.sleep(2000);
		pass.sendKeys(password);
		signin.click();
		Thread.sleep(1000);
		String actualString = uservalidation.getText();
		System.out.println("\tCOS User Name :- "+actualString);
	}	
}
