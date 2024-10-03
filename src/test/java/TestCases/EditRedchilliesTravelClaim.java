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

public class EditRedchilliesTravelClaim extends Urls {

String EmployeeuserName=null;
String EmployeepassWord=null;
WebDriver driver;
String domainname="";
//String user = "999";
//String pass= "Zento123";
//String browserName="firefox";
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
public void testSteps(String EmployeeuserName,String EmployeepassWord,String managername,String managerpassword,String domain,String coemployee,String intime,String outtime) throws InterruptedException, IOException
{
b.uploadexcelattendance(EmployeeuserName, coemployee, intime, outtime);
Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
// locator.Login(EmployeeuserName,EmployeepassWord);

System.out.println(EmployeeuserName);
System.out.println(EmployeepassWord);
b.clearData(EmployeeuserName,EmployeepassWord,domainname);
//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
// String strDate = dateFormat.format(datetext);
logger = extent.startTest("Editing attendancewuse Local Expense Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");
Reporter.log("=====User Login=====", true);


// Loginpage locator = PageFactory.initElements(driver, Loginpage.class);

logger.log(LogStatus.INFO, "Test result of Editing attendancewuse Local Expense Functionality");
//locator.logout();
//Thread.sleep(1000);
RedChilliesPage rcp = PageFactory.initElements(driver, RedChilliesPage.class);

String localid= rcp.submitlocalclaimusingAPI(EmployeeuserName, EmployeepassWord, domainname);
locator.Login(managername, managerpassword, domainname);
rcp.NavigateToReportings();
rcp.approvalsteps(localid,"disapprove");
locator.logout();
System.out.println(localid);
locator.Login(EmployeeuserName, EmployeepassWord, domainname);
rcp.editsteps(EmployeeuserName,EmployeepassWord,localid,domainname);
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
data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoDataProvider.xls", "Redchilliestravelapprovaldata");
return data_login;


}


}