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
import PageObjects.LeavePageObjects;
import PageObjects.Loginpage;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class LeaveApprovalProcess extends Urls {
	
	String EmployeeuserName=null;
	   String EmployeepassWord=null;
		WebDriver driver;
		String domainname="";
		
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
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String managername,String managerpassword,String domain) throws InterruptedException
		    {
			
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
		
				
				System.out.println(EmployeeuserName);
				System.out.println(EmployeepassWord);
				b.clearleaveData(EmployeeuserName,EmployeepassWord,domainname);
			
			logger = extent.startTest("Leave approval (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
			Reporter.log("=====User Login=====", true);
			


		
			logger.log(LogStatus.INFO, "Test result of Leave approval Functionality");
			
			LeavePageObjects leavepage = PageFactory.initElements(driver, LeavePageObjects.class);

		String leaveid=	leavepage.submitLeaveUsingAPI(EmployeeuserName, EmployeepassWord, domainname);
		System.out.println(managername);
		System.out.println(managerpassword);
		locator.Login(managername,managerpassword,domainname);
		leavepage.approveleavestpes(domainname, "disapprove", leaveid);
			
			
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
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoLeaveData.xlsx", "leavedeata");
				return data_login;
				
			 
					}
	
	
	
	


}
