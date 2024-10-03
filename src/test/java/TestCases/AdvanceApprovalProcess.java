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
import PageObjects.AdvancePageObjects;
import PageObjects.Loginpage;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class AdvanceApprovalProcess extends Urls {
	
	String EmployeeuserName=null;
	   String EmployeepassWord=null;
		WebDriver driver;
		//String user = "999";
		//String pass= "Zento123";
		//String browserName="firefox";
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
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String domain,String approvetype,String managerUsername,String managerPassword) throws InterruptedException
		    {
			
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
			//	locator.Login(EmployeeuserName,EmployeepassWord);
				
				System.out.println(EmployeeuserName);
				System.out.println(EmployeepassWord);
				b.clearData(EmployeeuserName,EmployeepassWord,domainname);
			AdvancePageObjects advancepage = PageFactory.initElements(driver, AdvancePageObjects.class);
			//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	        // String strDate = dateFormat.format(datetext); 
			logger = extent.startTest("Advance "+approvetype+" Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
			Reporter.log("=====User Login=====", true);
			System.out.println(EmployeeuserName);
			System.out.println(EmployeepassWord);
			
		
		
			logger.log(LogStatus.INFO, "Test result of Drafting Food Expense Functionality");
		
			//locator.logout();
			//Thread.sleep(1000);
			String advanceid=advancepage.submitAdvanceUsingAPI(EmployeeuserName, EmployeepassWord, domainname);
			locator.Login(managerUsername,managerPassword,domainname);
			advancepage.approveadvancestpes(domainname,approvetype,advanceid);
			
			//Ex-Hq-kalyani   Fieldwork
			//UP-Krishnanagar
			//deLocator.addExpenseSteps(workType,toTown,datetext);
			//driver.quit();
		
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
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoDataProviderAdvance.xls", "AdvanceApprove");
				return data_login;
				
			 
					}

}
