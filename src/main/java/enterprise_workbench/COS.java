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

public class COS extends Baseclass {
	
	@FindBy(xpath="//*[contains(text(),'Customer & Order System')]")
	WebElement cosConsole;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement CosOrderSearch;
	@FindBy(xpath = "//button")
	WebElement CosOrderSearchBTN;
	@FindBy(xpath = "(//span[@class='orderDetails_value__hQRGT'])[2]")
	WebElement OrderSearchAssert;
	@FindBy(xpath="(//span[@class='orderDetails_value__hQRGT'])[1]")
	WebElement customer;
	@FindBy(xpath="(//span[@class='orderDetails_value__hQRGT'])[4]")
	WebElement CustomerId;
	@FindBy(xpath="(//span[@class='orderDetails_value__hQRGT'])[3]")
	WebElement OrderStatus;
	@FindBy(xpath="(//span[@class='orderDetails_value__euKXH'])[3]")
	WebElement Orderdate;
	@FindBy(xpath="(//span[@class='orderDetails_value__euKXH'])[5]")
	WebElement PaymentMethod;
	@FindBy(xpath="//*[@data-testid='ExpandMoreIcon']")
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
	@FindBy(name = "quantity")
	WebElement ReturnQTYBox;
	@FindBy(id ="returnReason")
	WebElement ReturnReason;
	@FindBy(xpath = "//li[text()='Item Damaged']")
	WebElement SelectReason;
	@FindBy(xpath="//button[@aria-label='Save']//*[name()='svg']")
	WebElement SaveReturnReasons;
	@FindBy(xpath = "(//button[text()='Create Return'])[2]")
	WebElement CreateReturnsBtn;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement CreateReturnsSavePUP;

	int items;
	
	public COS() {
		PageFactory.initElements(DR, this);
	}
	
	public void ClickCosConsole() {
		cosConsole.click();
		DR.navigate().refresh();
	}
	
	public void SearchOrder(String orderno) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(CosOrderSearch)).sendKeys(orderno);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(CosOrderSearchBTN)));
		CosOrderSearchBTN.click();
		Thread.sleep(500);
	}
	
	public void CosOrderAssert() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(OrderSearchAssert));
		String OrderNo = OrderSearchAssert.getText();
		wait.until(ExpectedConditions.elementToBeClickable(customer));
		String name=customer.getText();
		wait.until(ExpectedConditions.elementToBeClickable(CustomerId));
		String cusid=CustomerId.getText();
		System.out.println();
		System.out.println("\tCustomer Name = "+name);
		System.out.println("\tOrder No      = "+OrderNo);
		System.out.println("\tCustomer ID   = "+cusid);
		Thread.sleep(500);
	}
	
	public void CosOrderStatus() throws InterruptedException {
		String status = OrderStatus.getText();
		System.out.println("\tOrder status  = " + status);
		Thread.sleep(500);
	}

	public void PaymentMethod() throws InterruptedException {
		String payment = PaymentMethod.getText();
		System.out.println("\tPayment Mode  = " + payment);
		Thread.sleep(500);
	}

	public void OrderDate() throws InterruptedException {
		String date = Orderdate.getText();
		System.out.println("\tOrder Date is = " + date);
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
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) DR;
		Thread.sleep(500);
		
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",ReturnCheckbox);
		wait.until(ExpectedConditions.elementToBeClickable(Panel));
		Panel.click();
		Thread.sleep(500);
		
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",ReturnCheckbox);
		Thread.sleep(500);
		
		  
		List<WebElement> checkboxes = DR.findElements(By.xpath("//table[@aria-labelledby='tableTitle']//input[@type='checkbox']"));
		Thread.sleep(500);
		
		 for (int i = 0; i < 5; i++) {
	            js.executeScript("window.scrollBy(0, 500);");
	            try {
	                Thread.sleep(200);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
		
		// Loop through the check boxes and select them
		int i=0;
	     for (WebElement checkbox : checkboxes) {
	        	
	         if (!checkbox.isSelected()) {
	              checkbox.click();
	              i++;
	              Thread.sleep(250);
	            }
	          }
	     
	        items=i;
	        System.out.println("\tItem's eligible for returns = "+i+"\n");
       }
	
	public void CosReturnsandAddItems() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(DR, Duration.ofSeconds(30));
		((JavascriptExecutor) DR).executeScript("scroll(0,500)");
		
		wait.until(ExpectedConditions.elementToBeClickable(CreateReturn));
		CreateReturn.click();
		Thread.sleep(1000);
	System.out.println("\n\tArticle Description List :-  ");
		for(int i=1 ;i<=items;i++) {
			
			Thread.sleep(600);
			String xpath="//tbody/tr["+i+"]/td[8]/button[1]//*[name()='svg']";
			WebElement CreateQtyEditBtn= DR.findElement(By.xpath(xpath));
			wait.until(ExpectedConditions.elementToBeClickable(CreateQtyEditBtn));
			CreateQtyEditBtn.click();
			
			String quantityxpath="//body[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[5]";
			String itemIdxpath="//body[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[2]";
			String itemDescriptionxpath="//body[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[3]";
			String unitPricexpath ="//body[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[4]";
			
			WebElement itemId=DR.findElement(By.xpath(itemIdxpath));
			String ID =itemId.getText().trim();
			System.out.println();
			System.out.println("\tItem ID      = " +ID);
			
			WebElement itemDesc=DR.findElement(By.xpath(itemDescriptionxpath));
			String itemDescription=itemDesc.getText().trim();
			System.out.println("\tItem Name    = "+itemDescription);
			
			WebElement price=DR.findElement(By.xpath(unitPricexpath));
			String itemPrice=price.getText().trim();
			System.out.println("\tItem Price   = " +itemPrice);
			
			WebElement returnableQuantity =DR.findElement(By.xpath(quantityxpath));
			String a =returnableQuantity.getText().trim();
			String[] trimQuantity=a.split("\\.");
			String quantity= trimQuantity[0];
			System.out.println("\tReturnable Quantity is = " +quantity);
		
			ReturnQTYBox.sendKeys(quantity);
			ReturnReason.click();
			SelectReason.click();
			wait.until(ExpectedConditions.elementToBeClickable(SaveReturnReasons));
			SaveReturnReasons.click();
		}
	 
		CreateReturnsBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(CreateReturnsSavePUP));
//		CreateReturnsSavePUP.click();
		Thread.sleep(5000);
	}
}