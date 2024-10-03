package TestCases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browsers.GetScreenshot;
import Browsers.Open_Browser;
import Browsers.Urls;
import PageObjects.Loginpage;
import TestData.CaptureExcelData;
import TestData.CustomListener;
import TestData.RetryAnalyzer;
//import javafx.scene.media.MediaBuilder;

//import com.aventstack.extentreports.MediaEntityBuilder;
import com.relevantcodes.extentreports.LogStatus;


//@Listeners(CustomListener.class)
public class Login extends Urls{
	 String EmployeeuserName=null;
	   String EmployeepassWord=null;
		WebDriver driver;
		//String user = "999";
		//String pass= "Zento123";
		//String browserName="firefox";
		String domainname="";
		String SiteURL="";
		Open_Browser b = new Open_Browser(driver);
		
		GetScreenshot getscreen = new GetScreenshot(driver);
		 
		@Parameters( { "browserName" , "domainName"} )  	
		@BeforeMethod
		public String steps(String browserName,String domainName ) throws MalformedURLException
		{
			
			logger = extent.startTest("Smoke Test");	 
			Reporter.log("=====Browser starting=====", true);
			System.out.println(browserName);
			
			driver=b.open(browserName);
			logger.log(LogStatus.INFO, "Test result of launching browser");
			domainname=domainName;
			return domainname;
			
		}

		
		
		
		@Test(dataProvider="Login1",retryAnalyzer = RetryAnalyzer.class)
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String domain) throws InterruptedException
		    {
			
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
			//	locator.Login(EmployeeuserName,EmployeepassWord);
				
				System.out.println(EmployeeuserName);
				System.out.println(EmployeepassWord);
				b.clearData(EmployeeuserName,EmployeepassWord,domainname);
			logger = extent.startTest("Login Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
			Reporter.log("=====User Login=====", true);
			System.out.println(EmployeeuserName);
			System.out.println(EmployeepassWord);

//			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
			locator.Login(EmployeeuserName,EmployeepassWord,domainname);
			logger.log(LogStatus.INFO, "Test result of Login Functionality");
			//locator.logout();
			//Thread.sleep(1000);
			//DailyExpense deLocator = PageFactory.initElements(driver, DailyExpense.class);
			//deLocator.navigateToDailyExpense();
			//deLocator.navigateToOthers();
			//deLocator.addOtherExpense("STATIONARY");
			//driver.quit();
			}
//		
//		@AfterMethod
//		public void getResult(ITestResult result) throws IOException{
//			if(result.getStatus() == ITestResult.FAILURE){
//				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
//				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
//
//				String screenshotPath = GetScreenshot.getScreenShot(driver, result.getName());
//				//logger.fail("Test Case Failed Snapshot is below " + logger.addBase64ScreenShot(screenshotPath)
//
//
//			}else if(result.getStatus() == ITestResult.SKIP){
//				logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
//			}
//			// ending test
//			//endTest(logger) : It ends the current test and prepares to create HTML report
//		//	extent.endTest(logger);
//		}
		
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
