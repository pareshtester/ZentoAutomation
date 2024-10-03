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
import PageObjects.DailyExpensePage;
import PageObjects.DraftDailyExpensePage;
import PageObjects.Loginpage;
import TestData.CaptureExcelData;

public class SubmitDailyExpense extends Urls {

	String EmployeeuserName=null;
	   String EmployeepassWord=null;
		WebDriver driver;
		String filename="";
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
		
//		@Parameters( {  "FileName"} )  	
//		@BeforeTest
//		public String getexcel(String Filename)
//		{
//			filename = Filename;
//			return filename;
//		}
		
		
		@Test(dataProvider="Login1")
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String worktype,String HQtype,String nighthalt,
				String inoutna,String residential) throws InterruptedException
		    {
			b.clearData(EmployeeuserName,EmployeepassWord,domainname);
			   DailyExpensePage dep = PageFactory.initElements(driver, DailyExpensePage.class);
		      
			
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
		
				System.out.println(EmployeeuserName);
				System.out.println(EmployeepassWord);
				
		
			logger = extent.startTest("Submit Daily Expense Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
			Reporter.log("=====User Login=====", true);
			System.out.println(EmployeeuserName);
			System.out.println(EmployeepassWord);

			 String claimid= dep.addDailyExpense(EmployeeuserName,EmployeepassWord,domainname);
			locator.Login(EmployeeuserName,EmployeepassWord,domainname);
		    dep.submitdailyexpense(claimid);
			
		
			}
		
		@AfterMethod
		public void closebrowser()
		{
			//driver.quit();
		}
		
		@AfterTest
		public void close(){
			
			//driver.quit();
		//	driver.quit();
		}
		
		   @DataProvider(name="Login1")
		   public String[][] Authentication() throws Exception{
			   CaptureExcelData ed = new CaptureExcelData();
				
				String[][] data_login = null;
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoDataProvider.xls", "Dailyexpense");
				return data_login;
				
			 
					}
}
