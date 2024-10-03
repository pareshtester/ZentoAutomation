package PageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Browsers.Open_Browser;
import Browsers.Urls;
import PageObjects.EstimationActivityPage;
import PageObjects.LoginpageElements;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class SubmitEstimationActivity extends Urls {
	
	
	 String EmployeeuserName=null;
	   String EmployeepassWord=null;
		WebDriver driver;
		//String user = "999";
		//String pass= "Zento123";
		//String browserName="firefox";
		
		Open_Browser b = new Open_Browser(driver);
		
		@Parameters( { "browserName"})
		@BeforeMethod
		public void steps(String browserName) throws MalformedURLException
		{
			
			System.out.println(browserName);
			
			driver =b.open(browserName);
		}
		
		
		
		@Test(dataProvider="Login1",retryAnalyzer = RetryAnalyzer.class)  
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String approvaluser1,String approvalpass1) throws InterruptedException
		    {
			
		//	b.clearData(EmployeeuserName);
			logger = extent.startTest("Login Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
			Reporter.log("=====User Login=====", true);
			System.out.println(EmployeeuserName);
			System.out.println(EmployeepassWord);

			//LoginpageElements locator = PageFactory.initElements(driver, LoginpageElements.class);
			//locator.Login(EmployeeuserName,EmployeepassWord);
			
			EstimationActivityPage activityelements = PageFactory.initElements(driver, EstimationActivityPage.class);
			//activityelements.navigateToactivitypage();
			String Activityid=activityelements.addestimationdatailsapi(EmployeeuserName,EmployeepassWord);
			logger.log(LogStatus.INFO, "Test result of Login Functionality");
			LoginpageElements locator = PageFactory.initElements(driver, LoginpageElements.class);
			locator.Login(EmployeeuserName,EmployeepassWord);
			activityelements.submitestimationactivity(Activityid);
			//locator.logout();
			//Thread.sleep(1000);
			//DailyExpense deLocator = PageFactory.initElements(driver, DailyExpense.class);
			//deLocator.navigateToDailyExpense();
			//deLocator.navigateToOthers();
			//deLocator.addOtherExpense("STATIONARY");
			//driver.quit();
			}
		@AfterTest
		public void close(){
			
			
		//	driver.quit();
		}
		
		   @DataProvider(name="Login1")
		   public String[][] Authentication() throws Exception{
			   CaptureExcelData ed = new CaptureExcelData();
				
				String[][] data_login = null;
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoDataProvider.xls", "Login");
				return data_login;
				
			 
					}

}
