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
import PageObjects.EstimationActivityPage;
import PageObjects.Loginpage;
import PageObjects.LoginpageElements;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class ApproveEstimationActivity extends Urls {
	   String domainname="";

	String EmployeeuserName=null;
	   String EmployeepassWord=null;
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
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String approvaluser1,String approvalpass1,
				String approvealuser2,String approvalpass2,String domain,String HCPName,String EmpHCO,String placeofwrk,String HCPselection,String HCPFlag,String inviteenum,String EventName,String EventDate,
				String EventcountryVenue,String Typeofactivity,String EventOrganizer,String VenueSelection,String EventAgenda) throws InterruptedException
		    {
			
			b.clearData(EmployeeuserName,EmployeepassWord,domain);
			logger = extent.startTest("approve  estimation (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
			Reporter.log("=====User Login=====", true);
			System.out.println(EmployeeuserName);
			System.out.println(EmployeepassWord);

			//LoginpageElements locator = PageFactory.initElements(driver, LoginpageElements.class);
			//locator.Login(EmployeeuserName,EmployeepassWord);
			
			EstimationActivityPage activityelements = PageFactory.initElements(driver, EstimationActivityPage.class);
			//activityelements.navigateToactivitypage();
//			String activityid=activityelements.submitestimationativityapi(EmployeeuserName, EmployeepassWord, approvaluser1, approvalpass1,
//					venueofactivity,topicofactivity,topicofactivity,afood,alcd,atravel,aspeaker,aothers,aregfees,activity,domainname);
			logger.log(LogStatus.INFO, "Test result of approve estimation Functionality");
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
		//	locator.Login(EmployeeuserName,EmployeepassWord);
			//activityelements.submitestimationactivity(Activityid);
			//locator.logout();
			
			locator.Login(approvaluser1,approvalpass1,domain);
			activityelements.navigateToapprovepage();
			//activityelements.approveEstimationActivity(approvaluser1, approvalpass1, activityid);
			locator.logout();

			locator.Login(approvealuser2,approvalpass2,domain);
			activityelements.navigateToapprovepage();
		//	activityelements.approveEstimationActivity(approvealuser2, approvalpass2, activityid);
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
			driver.quit();
		}
		
		@AfterTest
		public void close(){
			
			
		//	driver.quit();
		}
		
		   @DataProvider(name="Login1")
		   public String[][] Authentication() throws Exception{
			   CaptureExcelData ed = new CaptureExcelData();
				
				String[][] data_login = null;
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoDataProvider.xls", "approveEstimation");
				return data_login;
				
			 
					}

}
