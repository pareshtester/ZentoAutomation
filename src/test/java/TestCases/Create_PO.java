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

import com.gargoylesoftware.htmlunit.javascript.host.URLSearchParams;
import com.relevantcodes.extentreports.LogStatus;

import Browsers.Open_Browser;
import Browsers.Urls;
import PageObjects.CreatePOPage;
import PageObjects.DraftclaimElements;
import PageObjects.Loginpage;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class Create_PO extends Urls{
	String EmployeeuserName=null;
	   String EmployeepassWord=null;
		WebDriver driver;
		String filename="";
		String companyname="";
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
		
//		@Parameters( {  "FileName"} )  	
//		@BeforeTest
//		public String getexcel(String Filename)
//		{
//			filename = Filename;
//			return filename;
//		}
		
		
		@Test(dataProvider="Login1",retryAnalyzer = RetryAnalyzer.class)
		public void testSteps(String EmployeeuserName,String EmployeepassWord,String companyname,String Ponumber, String podate, 
				String poexpirydate,String poremarks,String poamt,String poadvamt,String approval1,String paymentcycle,
				String satgewise,String poterm,String voucher,String emailid,String domain) throws InterruptedException
		    {
			b.deletevendor(emailid, domainname);
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
//			locator.Login(EmployeeuserName,EmployeepassWord);
			CreatePOPage cpp = PageFactory.initElements(driver, CreatePOPage.class);
			System.out.println(podate);
			System.out.println("companyname"+companyname);
			
			if(!(companyname==null))
			{
				cpp.createvendorapisteps(domainname,emailid,companyname);
			}
		
			
		//b.clearData(EmployeeuserName,EmployeepassWord,domainname);

		//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
		// String strDate = dateFormat.format(datetext); 
		driver.get(adminurl);
		logger = extent.startTest("PO creation process Test (User:"+emailid +"doamin:"+domainname+")");	 
		Reporter.log("=====User Login=====", true);
		
	


		logger.log(LogStatus.INFO, "Test result of PO creation Functionality");
		locator.adminLogin("admin", "Zento123", domainname);
		
		cpp.navigtevendor();
		cpp.cratePOsteps(domainname, companyname , Ponumber, podate, poexpirydate, poremarks,
				poamt, poadvamt, approval1, paymentcycle, satgewise, poterm, voucher);
			
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
				data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "VendorDataProvider.xlsx", "podata");
				return data_login;
				
			 
					}


}
