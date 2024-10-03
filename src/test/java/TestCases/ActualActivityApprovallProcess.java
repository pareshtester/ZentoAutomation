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
import PageObjects.ActualActivityPage;
import PageObjects.EstimationActivityPage;
import PageObjects.Loginpage;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class ActualActivityApprovallProcess extends Urls {
	
	
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
						String approvealuser2,String approvalpass2,String domain,String Month
		,String year,String id,String activity,String dateofactivity,String venueofactivity,String topicofactivity,String speakerofactivity,String noofpart,
		String paymentinfav,String ahotel,String actualhotel,String afood,String actualfood,String alcd,String actuallcd,String atravel,String actualtravel,
		String aspeaker,String actualspeaker,String aothers,String actualothers,String aregfees,String actualregfees,String action) throws InterruptedException
				    {
					
					b.clearData(EmployeeuserName,EmployeepassWord,domainname);
					logger = extent.startTest("Login Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");	 
					Reporter.log("=====User Login=====", true);
					System.out.println(EmployeeuserName);
					System.out.println(EmployeepassWord);

					//LoginpageElements locator = PageFactory.initElements(driver, LoginpageElements.class);
					//locator.Login(EmployeeuserName,EmployeepassWord);
					ActualActivityPage actualelements = PageFactory.initElements(driver, ActualActivityPage.class);
					EstimationActivityPage activityelements = PageFactory.initElements(driver, EstimationActivityPage.class);
					//activityelements.navigateToactivitypage();
					String activityid=activityelements.submitestimationativityapi(EmployeeuserName, EmployeepassWord, approvaluser1, approvalpass1,
							venueofactivity,topicofactivity,ahotel,afood,alcd,atravel,aspeaker,aothers,aregfees,activity,domainname);
					logger.log(LogStatus.INFO, "Test result of Login Functionality");
					Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
				//	locator.Login(EmployeeuserName,EmployeepassWord);
					//activityelements.submitestimationactivity(Activityid);
					//locator.logout();
					
//					locator.Login(approvaluser1,approvalpass1,domainname);
//					activityelements.navigateToapprovepage();
//					activityelements.approveEstimationActivity(approvaluser1, approvalpass1, activityid);
//					locator.logout();
					activityelements.approveestimationactivitybyapisteps(EmployeeuserName, EmployeepassWord, approvaluser1, approvalpass1, domain, activityid, activity, "approve");
//					locator.Login(approvealuser2,approvalpass2,domainname);
//					activityelements.navigateToapprovepage();
//					activityelements.approveEstimationActivity(approvealuser2, approvalpass2, activityid);
//					actualelements
					//				locator.logout();
					actualelements.addActualAtivityAPI(EmployeeuserName, EmployeepassWord, activityid);
					actualelements.submitAtualActivityAPI(activityid);
					locator.Login(approvaluser1, approvalpass1, domainname);
					actualelements.navigattoapproveactualactivty();
				     actualelements.approveActualActivity(approvaluser1, approvalpass1, activityid, action);
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
						data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoDataProvider.xls", "approveactual");
						return data_login;
						
					 
							}

}
