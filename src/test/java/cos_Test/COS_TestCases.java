package cos_Test;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import enterprise_workbench.COS;
import enterprise_workbench.LoginToEnterprise;

public class COS_TestCases{

	LoginToEnterprise objenterprise;
	COS objcos;
	
	@Test(priority = 1,enabled= true,description = "This is a Login Test for Enterprise.")
	@Parameters({"username", "password"})
	public void Login(String username,String password) throws InterruptedException {
		objenterprise = new LoginToEnterprise();
		objenterprise.Login(username,password);
		Reporter.log("Login Test Passed.");
	}
	
	@Test(priority = 2,enabled=true,description="Open COS console.")
	public void CosConsole() {
		objcos = new COS();
		objcos.ClickCosConsole();
		Reporter.log("Clicked on COS Console");
	}
	
	@Parameters("orderno")
	@Test(priority = 3, enabled = true, description = "COS Order Search")
	public void CosOrderSearch(String orderno) throws InterruptedException {
		objcos = new COS();
		objcos.SearchOrder(orderno);
		objcos.CosOrderAssert();
		objcos.CosOrderStatus();
		objcos.PaymentMethod();
		objcos.OrderDate();
	}

	@Test(priority = 4, enabled = false, description = "COS Slot Change")
	public void SlotPanelClick() throws InterruptedException {
		objcos = new COS();
		objcos.Panel();

	}

	@Test(priority = 5, enabled = false, description = "COS Slot Change")
	public void SlotChangeChecks() throws InterruptedException {
		objcos = new COS();
		objcos.SlotChange();

	}

	@Test(priority = 6, enabled = false, description = "Internal Cancellation")
	public void Cancellation() throws InterruptedException {
		objcos = new COS();
		objcos.Cancellation();

	}

	@Test(priority = 7, enabled = false, description = "Cust Cancellation")
	public void CustCancellation() throws InterruptedException {
		objcos = new COS();
		objcos.CustCancellation();
	}
	@Parameters("QTY")
	@Test(priority = 8, enabled = true, description = "Returns")
	public void Returns(String QTY) throws InterruptedException   {
		objcos = new COS();
		objcos.CosReturns();
		objcos.CosReturnsandAddItems(QTY);
		

	}
}
