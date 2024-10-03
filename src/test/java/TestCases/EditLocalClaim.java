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

import Browsers.Open_Browser;
import Browsers.Urls;
import PageObjects.EditexpenseDetailsLocator;
import PageObjects.Loginpage;
import PageObjects.SubmitCliamsLocator;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

import com.relevantcodes.extentreports.LogStatus;

public class EditLocalClaim extends Urls {
	
	
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
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String Date,String localCity,String localtmode,String Lamount,
				String fromplace,String toplace,String LCB,String Lremarks, String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
		    {
			
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
			//	locator.Login(EmployeeuserName,EmployeepassWord);
				
				System.out.println(EmployeeuserName);
				System.out.println(EmployeepassWord);
				b.clearData(EmployeeuserName,EmployeepassWord,domainname);
			//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	        // String strDate = dateFormat.format(datetext); 
			logger = extent.startTest("Edit Local Expense Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
			Reporter.log("=====User Login=====", true);
			System.out.println(EmployeeuserName);
			System.out.println(EmployeepassWord);
			SubmitCliamsLocator deLocator = PageFactory.initElements(driver, SubmitCliamsLocator.class);
			String claimid=deLocator.addLexpense(EmployeeuserName,EmployeepassWord,domainname,gstn,cgst,sgst,igst,localtmode,Lamount);
			System.out.println(claimid);
//			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
			locator.Login(EmployeeuserName,EmployeepassWord,domainname);
			logger.log(LogStatus.INFO, "Test result of Edit Local Expense Functionality");
			EditexpenseDetailsLocator editLocator =  PageFactory.initElements(driver, EditexpenseDetailsLocator.class);
			editLocator.editlocalSteps(EmployeeuserName,EmployeepassWord,claimid,localCity,localtmode,Lamount,fromplace,toplace,LCB,Lremarks,domainname,gstn,cgst,sgst,igst);
			
			
			}
		
		@AfterMethod
		public void closebrowser()
		{
			//driver.quit();
		}
		
		@AfterTest
		public void close(){
			
		
			//driver.quit();
		}
		
		   @DataProvider(name="Login1")
		   public String[][] Authentication() throws Exception{
			   CaptureExcelData ed = new CaptureExcelData();
				
				String[][] data_login = null;
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", ExcelFileName, "LocalClaimData");
				return data_login;
				
			 
					}

}