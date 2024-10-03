package TestCases;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Browsers.Urls;
import PageObjects.CallAPI;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer1;

public class NewZentoUIAPI extends Urls {
	

	String EmployeeuserName=null;
	   String EmployeepassWord=null;
		WebDriver driver;
		//String user = "999";
		//String pass= "Zento123";
		//String browserName="firefox";
		//Open_Browser b = new Open_Browser(driver);
		String sheetname="";
		@Parameters( { "domainName"})
		@BeforeMethod
		public String steps(String domainName) throws MalformedURLException
		{
			sheetname=domainName;
			return sheetname;
		}
	
	
		
		
		
		
		@Test(dataProvider="Login1",retryAnalyzer = RetryAnalyzer1.class) 
		
		public void testSteps(String functiontext,String username,String password,String managerusername,String managerpassword,
				String policytype,String domainName) throws InterruptedException, JSONException, ParseException
		    {
			System.out.println("Sheet name is"+sheetname);
			//b.clearData(EmployeeuserName);
			//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	        // String strDate = dateFormat.format(datetext); 
			logger = extent.startTest("API Test (Function name:"+functiontext +")  (Domain name:"+sheetname +")");	 
			Reporter.log("=====Zento API=====", true);
			System.out.println(functiontext);
			
			CallAPI deLocator = new CallAPI();
		
			//CallPostAPI deLocator = new CallPostAPI();
		//	deLocator.steps(functiontext,username,password,managerusername,managerpassword,policytype,Gstn,pannum,ponum,invoiceno,sheetname);
			deLocator.steps(functiontext, username, password, managerusername, managerpassword, policytype, sheetname);
			logger.log(LogStatus.INFO, "Test result of API Testing");
			
			//Thread.sleep(1000);
			
			//deLocator.navigateToapplyclaim();
			
			//Ex-Hq-kalyani   Fieldwork
			//UP-Krishnanagar
			//deLocator.addExpenseSteps(workType,toTown,datetext);
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
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "Zento_API_Data.xls", "drag&dropapi");
				return data_login;
				
			 
					}


}
