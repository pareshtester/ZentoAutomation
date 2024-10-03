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
import PageObjects.Loginpage;
import PageObjects.VendorPage;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class VendorActiveInactiveStatus extends Urls{
	
	
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
		String contactpersonid="";
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
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String nameofcompany,String tob,String phonenumber,String emailid,String branch,
				String address,String country,String state,String city,String pincode,String gstn,String contactperson,String designation,String mobilenumber,
				String cemailid,String bankname,String accountno,String ifsccode,String pannumber,String domain) throws InterruptedException
		    {
			b.deletevendor(cemailid, domainname);
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
			//	locator.Login(EmployeeuserName,EmployeepassWord);
				VendorPage vp =PageFactory.initElements(driver, VendorPage.class);
				System.out.println(EmployeeuserName);
				System.out.println(EmployeepassWord);
				//b.clearData(EmployeeuserName,EmployeepassWord,domainname);
		
			//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	        // String strDate = dateFormat.format(datetext); 
				driver.get(adminurl);
				
			logger = extent.startTest("Vendor ActivateInactivate process Test (User:"+cemailid +" domain:"+domainname+")");	 
			Reporter.log("=====User Login=====", true);
			System.out.println(EmployeeuserName);
			System.out.println(phonenumber);
			System.out.println(gstn);
			System.out.println(mobilenumber);
			
			ArrayList<String> vendorarray=	vp.createvendorapisteps(domainname, nameofcompany, tob, phonenumber, emailid, branch, address, country, state, city, pincode, gstn, 
					contactperson, designation, mobilenumber, cemailid, bankname, accountno, ifsccode, pannumber);
			//locator.logout();
			vendorusername=vendorarray.get(0);
			
			contactpersonid=vendorarray.get(1);
					vendorid = vendorarray.get(2);
		System.out.println(vendorusername);
		
			logger.log(LogStatus.INFO, "Test result of Vendor ActivateInactivate Functionality");
			locator.adminLogin("admin", "Zento123", domainname);
	
		vp.navigateToexistingvendor();
		vp.activeinactive(vendorusername,domainname, nameofcompany, tob, phonenumber, emailid, branch, address, country, state, city, pincode, gstn, 
				contactperson, designation,mobilenumber , contactpersonid, bankname, accountno, ifsccode, pannumber);
			}
		@AfterMethod
		public void closebrowser()
		{
			driver.quit();
		}
		
		
		
		@AfterTest
		public void close(){
			
			driver.quit();
		
		}
		
		   @DataProvider(name="Login1")
		   public String[][] Authentication() throws Exception{
			   CaptureExcelData ed = new CaptureExcelData();
				
				String[][] data_login = null;
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "VendorDataProvider.xlsx", "APIdata");
				return data_login;
				
			 
					}


}
