package TestCases;

import java.io.IOException;
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
import PageObjects.Loginpage;
import PageObjects.RedChilliesPage;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

public class EditRedchilliesfoodexpense extends Urls {
String EmployeeuserName=null;
String EmployeepassWord=null;
WebDriver driver;
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
public void testSteps(String EmployeeuserName,String EmployeepassWord,String copartnerusername,String copartnerpassword,String managername,String managerpassword,String domain,String intime,String outtime) throws InterruptedException, IOException
{
b.uploadexcelattendance(EmployeeuserName, copartnerusername, intime, outtime);
Loginpage locator = PageFactory.initElements(driver, Loginpage.class);


System.out.println(EmployeeuserName);
System.out.println(EmployeepassWord);
b.clearData(EmployeeuserName,EmployeepassWord,domainname);

logger = extent.startTest("Editing attendancewise Food Expense Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");
Reporter.log("=====User Login=====", true);




logger.log(LogStatus.INFO, "Test result of Editing attendancewuse Food Expense Functionality");

RedChilliesPage rcp = PageFactory.initElements(driver, RedChilliesPage.class);

String foodid= rcp.submitfoodclaimusingAPI(EmployeeuserName, EmployeepassWord,copartnerusername,copartnerpassword, domainname);
System.out.println(foodid);
locator.Login(copartnerusername, copartnerpassword, domainname);
rcp.NavigateTointernalReportings();
rcp.approvalfoodsteps(foodid,"disapprove");
locator.logout();
locator.Login(EmployeeuserName, EmployeepassWord, domainname);
rcp.editfoodsteps(EmployeeuserName, EmployeepassWord, foodid, domainname,copartnerusername,copartnerpassword);

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
data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoDataProvider.xls", "reopenartistfood");
return data_login;


}

}