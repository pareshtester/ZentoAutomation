package TestCases;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Browsers.Open_Browser;
import Browsers.Urls;
import PageObjects.CreateInvoicePage;
import PageObjects.Loginpage;
import PageObjects.VendorPage;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class SettleInvoice extends Urls {
	String EmployeeuserName=null;
	String EmployeepassWord=null;
	WebDriver driver;
	//String user = "999";
	//String pass= "Zento123";
	//String browserName="firefox";
	String domainname="";
	String mobilenumber="";
	String vendorusername="";
	String vendorid="";
	String poid="";
	String invoiceno=""; 
	String ponumber="1000";


	Open_Browser b = new Open_Browser(driver);
	@Parameters( { "browserName" , "domainName"} ) 
	@BeforeMethod
	public String steps(String browserName,String domainName ) throws MalformedURLException
	{

	logger = extent.startTest("Smoke Test");	 
	Reporter.log("=====Browser starting=====", true);
	System.out.println(browserName);

	driver =b.open(browserName);
	logger.log(LogStatus.INFO, "Test result of launching browser");
	domainname=domainName;
	return domainname;

	}



	@Test(dataProvider="Login1",retryAnalyzer = RetryAnalyzer.class)
	public void testSteps(String ManagerName,String ManagerpassWord,String nameofcompany,String tob,String phonenumber,String emailid,String branch,
	String address,String country,String state,String city,String pincode,String gstn,String contactperson,String designation,String mobilenumber,
	String cemailid,String bankname,String accountno,String ifsccode,String pannumber,String domain,String ponum,String invoiceno,String paymentmethod) throws InterruptedException
	{
	b.deletevendor(cemailid, domainname);	
	Loginpage locator = PageFactory.initElements(driver, Loginpage.class);

	VendorPage vp =PageFactory.initElements(driver, VendorPage.class);
	System.out.println(EmployeeuserName);
	System.out.println(EmployeepassWord);
	CreateInvoicePage cip = PageFactory.initElements(driver, CreateInvoicePage.class);

	logger = extent.startTest("Settel invoice process Test (User:"+cemailid +" domain:"+domainname+")");	 
	Reporter.log("=====User Login=====", true);
	System.out.println(EmployeeuserName);
	System.out.println(phonenumber);
	System.out.println(gstn);
	System.out.println(mobilenumber);
	//jyk@gdata.in jylk@gdata.in jylkll@gdata.in jylkllp@gdata.in jylkllp@gdata.in
		ArrayList<String> vendorarray=	vp.createvendorapisteps(domainname, nameofcompany, tob, phonenumber, emailid, branch, address, country, state, city, pincode, gstn, 
		contactperson, designation, mobilenumber, cemailid, bankname, accountno, ifsccode, pannumber);
		System.out.println(vendorid);
		vendorusername=vendorarray.get(0);
		vendorid = vendorarray.get(2);
		System.out.println(vendorid);

	logger.log(LogStatus.INFO, "Test result of Settle invoice Functionality");
//		locator.adminLogin("admin", "Zento123", "Core Zento");
	poid = cip.createPOAPI(domainname, vendorid, ManagerName, ManagerpassWord,ponumber);
	invoiceno=cip.createinvoiceapi(domainname,ponumber,invoiceno);
//	driver.get(vendorurl);
//	locator.vendorlogin("jylkllpparsh@gdata.in", "Vendor123", domainname);
//	cip.navigatetocreateinvoice();
//	cip.submitinvoicestatus("21");
	
	
	cip.SubmitInvoice(invoiceno,domainname);
	
	driver.get(vendorapproval);
	locator.Login(ManagerName, ManagerpassWord, domainname);
	
	cip.navigatetoapproveinvoice();
	
	cip.approveinvoice(ponumber,invoiceno,"Approve");
	locator.logout();
	if(!(SiteURL.equalsIgnoreCase("https://gdata.zento.in/")))
	{
	locator.Login("paymentteam", ManagerpassWord, domainname);
	
	cip.navigatetoreimburseinvoice();
	cip.Approvereimburseinvoice(invoiceno,paymentmethod);

	if(paymentmethod.equalsIgnoreCase("Online"))
	{
	cip.navigatetoinvoicepayment("Online");
	cip.onlinepaymentprocesssteps(invoiceno);
	
	}else if(paymentmethod.equalsIgnoreCase("Cash"))
	{
		cip.navigatetoinvoicepayment("Cash");
	cip.cashpaymentprocesssteps(invoiceno);
	}
	}
	}
	@AfterMethod
	public void closebrowser()
	{
	//driver.quit();
	}

	


	@AfterTest
	public void close(){

	//driver.quit();

	}

	@DataProvider(name="Login1")
	public String[][] Authentication() throws Exception{
	CaptureExcelData ed = new CaptureExcelData();

	String[][] data_login = null;
	data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "VendorDataProvider.xlsx", "reimburseinvoice");
	return data_login;


	}

}
