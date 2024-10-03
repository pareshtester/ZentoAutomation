package TestCases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Browsers.GetScreenshot;
import Browsers.Open_Browser;
import Browsers.Urls;
import PageObjects.Loginpage;
import PageObjects.dragndroppage;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class dragndrop extends Urls{
	
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
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String domain) throws InterruptedException, IOException
		    {
			
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
			//	locator.Login(EmployeeuserName,EmployeepassWord);
				
				System.out.println(EmployeeuserName);
				System.out.println(EmployeepassWord);
				b.clearData("2061","Zento123",domainname);
			logger = extent.startTest("Login Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
			Reporter.log("=====User Login=====", true);
			System.out.println(EmployeeuserName);
			System.out.println(EmployeepassWord);

//			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
			locator.Login("50034","Zento123",domainname);
			driver.get("http://35.197.159.76:90/ApplyClaimNew.aspx");
			//driver.findElement(By.id("dropzone-wrapper")).click();
//			JavascriptExecutor js6 = (JavascriptExecutor) driver;
//			js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, "
//					+ "false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", driver.findElement(By.id("dropzone-wrapper")));
////	Thread.sleep(1000);
//			JavascriptExecutor js7 = (JavascriptExecutor) driver;
//			js7.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, "
//					+ "false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", driver.findElement(By.id("dropzone-wrapper")));
////	Thread.sleep(1000);
		//	driver.findElement(By.id("dropzone-wrapper")).sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
			//driver.findElement(By.id("dropzone-wrapper")).sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");

			dragndroppage  drpage =PageFactory.initElements(driver, dragndroppage.class);
			drpage.drag();
			
			logger.log(LogStatus.INFO, "Test result of Login Functionality");
			//locator.logout();
			//Thread.sleep(1000);
			//DailyExpense deLocator = PageFactory.initElements(driver, DailyExpense.class);
			//deLocator.navigateToDailyExpense();
			//deLocator.navigateToOthers();
			//deLocator.addOtherExpense("STATIONARY");
			//driver.quit();
			}
		
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
//		
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
