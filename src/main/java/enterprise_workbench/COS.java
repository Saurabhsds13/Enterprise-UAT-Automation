package enterprise_workbench;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class COS extends Baseclass {
	
	@FindBy(xpath="//*[contains(text(),'Customer & Order System')]")
	WebElement cosConsole;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement CosOrderSearch;

	@FindBy(xpath = "//button")
	WebElement CosOrderSearchBTN;

	@FindBy(xpath = "(//span[@class='orderDetails_value__hQRGT'])[2]")
	WebElement OrderSearchAssert;

	@FindBy(xpath = "(//span[@class='orderDetails_value__hQRGT'])[3]")
	WebElement OrderStatus;

	@FindBy(xpath = "(//span[@class='orderDetails_value__euKXH'])[5]")
	WebElement PaymentMethod;

	@FindBy(xpath = "(//span[@class='orderDetails_value__euKXH'])[3]")
	WebElement Orderdate;

	@FindBy(xpath = "//h4[text()='Shipment Delivered']")
	WebElement Panel;
	
	@FindBy(xpath = "//*[@id=\"panel1a-header\"]/div[2]/span[1]")
	WebElement SlotPanel;
	
	@FindBy(xpath = "//span[text()='Slot Change']")
	WebElement SlotChange;

	@FindBy(xpath = "//span[text()='Internal Cancellation']")
	WebElement InternalCancellation;

	@FindBy(xpath = "//span[text()='Customer Cancellation']")
	WebElement CustomerCancellation;

	@FindBy(xpath = "(//div[@role='option'])[1]")
	WebElement SelectTime;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement SaveChangeSlot;

	@FindBy(xpath = "(//select[contains(@class,'MuiSelect-root MuiSelect-select')])[2]")
	WebElement CancelReason;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement InternalCancelBTN;

	@FindBy(xpath = "//span[text()='Customer Cancellation']")
	WebElement CustCancelBTN;

	@FindBy(xpath = "//table/tbody/tr")
	List<WebElement> ReturnOrderist;

	@FindBy(xpath = "//table[@aria-labelledby='tableTitle']//input[@type='checkbox']")
	WebElement ReturnCheckbox;

	@FindBy(xpath = "//button[normalize-space()='Create Return']")
	WebElement CreateReturn;

	@FindBy(xpath = "//span[text()='edit']")
	WebElement CreateQtyEditBtn;

	@FindBy(xpath = "(//td[text()='3'])[1]")
	WebElement ReturnQTYTxt;

	@FindBy(name = "quantity")
	WebElement ReturnQTYBox;

	@FindBy(id = "returnReason")
	WebElement ReturnReason;

	@FindBy(xpath = "//li[text()='Customer does not want']")
	WebElement SelectReason;

	@FindBy(xpath = "//span[text()='file_copy']")
	WebElement SaveReturnReasons;

	@FindBy(xpath = "(//span[text()='Create Return'])[2]")
	WebElement CreateReturnsBtn;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement CreateReturnsSavePUP;
	
	public COS() {
		PageFactory.initElements(DR, this);
	}
	
	public void ClickCosConsole() {
		cosConsole.click();
		DR.navigate().refresh();
	}
	
	public void SearchOrder(String orderno) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(CosOrderSearch)).sendKeys(orderno);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(CosOrderSearchBTN)));
		CosOrderSearchBTN.click();
		Thread.sleep(500);
	}
	
	public void CosOrderAssert() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(OrderSearchAssert));
		String Var = OrderSearchAssert.getText();
		System.out.println("Order No----" + Var);
		Reporter.log(Var);
		Thread.sleep(500);
	}

	public void CosOrderStatus() throws InterruptedException {
		String Var = OrderStatus.getText();
		System.out.println("Order status----" + Var);
		Reporter.log(Var);
		Thread.sleep(500);
	}

	public void PaymentMethod() throws InterruptedException {
		String Var = PaymentMethod.getText();
		System.out.println("PaymentMethod----" + Var);
		Reporter.log(Var);
		Thread.sleep(500);
	}

	public void OrderDate() throws InterruptedException {
		String Var = Orderdate.getText();
		System.out.println("OrderDate----" + Var);
		Reporter.log(Var);
		Thread.sleep(500);


	}

	public void Panel() throws InterruptedException {
		((JavascriptExecutor) DR).executeScript("scroll(0,500)");
		DR.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(SlotPanel)).click();
		Thread.sleep(500);


	}

	public void SlotChange() {
		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(SlotChange)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SelectTime)).click();
		String var = SelectTime.getText();
		wait.until(ExpectedConditions.elementToBeClickable(SaveChangeSlot)).click();
		System.out.println("New Slot ----" + var);

	}

	public void Cancellation() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) DR).executeScript("scroll(0,250)");
		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(InternalCancellation)).click();
		wait.until(ExpectedConditions.elementToBeClickable(CancelReason));
		Select Reasons = new Select(CancelReason);
		Reasons.selectByVisibleText("Area Not Reachable");
		Thread.sleep(2000);
		Reasons.selectByIndex(1);
		InternalCancelBTN.click();
		Thread.sleep(500);

	}

	public void CustCancellation() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) DR).executeScript("scroll(0,250)");
		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(60));
		//((JavascriptExecutor) DR).executeScript("arguments[0].scrollIntoView(true);", CustCancelBTN);
		wait.until(ExpectedConditions.elementToBeClickable(CustCancelBTN));
		CustCancelBTN.click();
		wait.until(ExpectedConditions.elementToBeClickable(CancelReason));
		Select Reasons = new Select(CancelReason);
		Reasons.selectByVisibleText("Customer Does Not Want");
		Thread.sleep(2000);
		Reasons.selectByIndex(1);
		InternalCancelBTN.click();
		Thread.sleep(500);
	}

	public void CosReturns() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(60));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) DR;
//		js.executeScript("arguments[0].scrollIntoView(true);,ReturnCheckbox");
		
		Thread.sleep(3000);
		
		 js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",ReturnCheckbox);
		 wait.until(ExpectedConditions.elementToBeClickable(Panel));
		 Panel.click();
		 Thread.sleep(2000);
		var b= Panel.isDisplayed();
		Thread.sleep(2000);
		var a =ReturnCheckbox.isDisplayed();
		Thread.sleep(2000);
		 js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",ReturnCheckbox);
		System.out.println(b);
		System.out.println(a);
//		 for (int i = 0; i < 5; i++) {
//	            // Scroll down by 200 pixels
//			 ((JavascriptExecutor) DR).executeScript("window.scrollBy(0, 200);");
//
//	            // Pause for 500 milliseconds before the next scroll
//	            try {	
//	                Thread.sleep(200);
//	            } catch (InterruptedException e) {
//	                e.printStackTrace();
//	            }
//	        }
//		wait.until(ExpectedConditions.elementToBeClickable(Panel));
//		System.out.println("Clicked on panel");
		//Panel.click();
//		Thread.sleep(2000);
//				((JavascriptExecutor) DR).executeScript("arguments[0].scrollIntoView(false);", ReturnCheckbox);
//				ReturnCheckbox.click();
		
		Thread.sleep(1000);
		  List<WebElement> checkboxes = DR.findElements(By.xpath("//table[@aria-labelledby='tableTitle']//input[@type='checkbox']"));
		  Thread.sleep(2000);
		  for(int i =0 ;i<=checkboxes.size();i++) {
			  Thread.sleep(1000);
			  System.out.println(i);
		  }
//		  System.out.println("Selected a checkboxes");
//	        // Loop through the checkboxes and select them
		  int i=0;
	        for (WebElement checkbox : checkboxes) {
	        	
	            if (!checkbox.isSelected()) {
	                checkbox.click();
	                i++;
	                Thread.sleep(2000);
	            }
	            System.out.println(i);
	            }
       }
	

	public void CosReturnsandAddItems(String Qty) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(60));
//		((JavascriptExecutor) DR).executeScript("scroll(0,500)");
		wait.until(ExpectedConditions.elementToBeClickable(CreateReturn));
		CreateReturn.click();

		wait.until(ExpectedConditions.elementToBeClickable(CreateQtyEditBtn));
		CreateQtyEditBtn.click();
		ReturnQTYBox.sendKeys(Qty);
		ReturnReason.click();
		SelectReason.click();
		SaveReturnReasons.click();
		CreateReturnsBtn.click();
		CreateReturnsSavePUP.click();
		Thread.sleep(5000);
	}

}
