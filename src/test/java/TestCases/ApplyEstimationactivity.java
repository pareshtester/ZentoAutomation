package TestCases;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import PageObjects.EstimationActivityPage;
import PageObjects.Loginpage;
import PageObjects.LoginpageElements;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class ApplyEstimationactivity extends Urls {

	
	
	 String EmployeeuserName=null;
	   String EmployeepassWord=null;
	   String domainname="";
		WebDriver driver;
		//String user = "999";
		//String pass= "Zento123";
		//String browserName="firefox";
		
		Open_Browser b = new Open_Browser(driver);
		
		@Parameters( { "browserName" , "domainName"} ) 
		@BeforeMethod
		public String steps(String browserName,String domainName) throws MalformedURLException
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
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String domain,
				String HCPName,String EmpHCO,String placeofwrk,String HCPselection,String HCPFlag,String inviteenum,String EventName,String EventDate,
				String EventcountryVenue,String Typeofactivity,String EventOrganizer,String VenueSelection,String EventAgenda) throws InterruptedException
		    {
			
			b.clearData(EmployeeuserName,EmployeepassWord,domainname);
			logger = extent.startTest("Apply estimation (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
			Reporter.log("=====User Login=====", true);
			System.out.println(EmployeeuserName);
			System.out.println(EmployeepassWord);

			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
			locator.Login(EmployeeuserName,EmployeepassWord,domainname);
			
			EstimationActivityPage activityelements = PageFactory.initElements(driver, EstimationActivityPage.class);
			activityelements.navigateToactivitypage();
			activityelements.addestimationactivity(EmployeeuserName,EmployeepassWord,domainname,HCPName,EmpHCO,placeofwrk,HCPselection,HCPFlag,inviteenum,EventName,EventDate,EventcountryVenue,Typeofactivity,EventOrganizer,VenueSelection,EventAgenda);
			logger.log(LogStatus.INFO, "Test result of apply estimation Functionality");
			//locator.logout();
			//Thread.sleep(1000);
			//DailyExpense deLocator = PageFactory.initElements(driver, DailyExpense.class);
			//deLocator.navigateToDailyExpense();
			//deLocator.navigateToOthers();
			//deLocator.addOtherExpense("STATIONARY");
			//driver.quit();
			}
		
		@AfterMethod
		public void closebrowser()
		{
		//	driver.quit();
		}
		
		
		@AfterTest
		public void close(){
			
			
		//	driver.quit();
		}
		
		   @DataProvider(name="Login1")
		   public String[][] Authentication() throws Exception{
			   CaptureExcelData ed = new CaptureExcelData();
				
				String[][] data_login = null;
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoDataProvider.xls", "ApplyEstimation");
				return data_login;
				
			 
					}
}
