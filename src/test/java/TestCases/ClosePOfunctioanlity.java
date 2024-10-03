package TestCases;

import java.net.MalformedURLException;

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

public class ClosePOfunctioanlity extends Urls {
	
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
				String cemailid,String bankname,String accountno,String ifsccode,String pannumber,String domain) throws InterruptedException
		    {
		
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
		
				VendorPage vp =PageFactory.initElements(driver, VendorPage.class);
				System.out.println(EmployeeuserName);
				System.out.println(EmployeepassWord);
				CreateInvoicePage cip = PageFactory.initElements(driver, CreateInvoicePage.class);
				
			logger = extent.startTest("Vendor creation process Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
			Reporter.log("=====User Login=====", true);
			System.out.println(EmployeeuserName);
			System.out.println(phonenumber);
			System.out.println(gstn);
			System.out.println(mobilenumber);
			//jyk@gdata.in   jylk@gdata.in   jylkll@gdata.in   jylkllp@gdata.in   jylkllp@gdata.in
//			ArrayList<String> vendorarray=	vp.createvendorapisteps(domainname, nameofcompany, tob, "8698294937", emailid, branch, address, country, state, city, pincode, gstn, 
//					contactperson, designation, "8698294937", cemailid, bankname, accountno, ifsccode, pannumber);
//			System.out.println(vendorid);
//			vendorusername=vendorarray.get(0);
//			vendorid = vendorarray.get(1);
//		System.out.println(vendorid);
		
			logger.log(LogStatus.INFO, "Test result of Vendor creation Functionality");
		//	locator.adminLogin("admin", "Zento123", "Core Zento");
	      // poid = cip.createPOAPI(domainname, "95", ManagerName, ManagerpassWord);
	       cip.poclosesteps(domainname, "95", ManagerName, ManagerpassWord, "71");

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
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "VendorDataProvider.xlsx", "vendordata");
				return data_login;
				
			 
					}

}
