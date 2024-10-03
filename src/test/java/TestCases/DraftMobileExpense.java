package TestCases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browsers.Open_Browser;
import Browsers.Urls;
import PageObjects.DraftclaimElements;
import PageObjects.Loginpage;
import TestData.CaptureExcelData;
import TestData.RetryAnalyzer;

import com.relevantcodes.extentreports.LogStatus;

public class DraftMobileExpense extends Urls {


String filename="";
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

// @Parameters( { "FileName"} )
// @BeforeTest
// public String getexcel(String Filename)
// {
// filename = Filename;
// return filename;
// }


@Test(dataProvider="Login1",retryAnalyzer = RetryAnalyzer.class)
public void testSteps(String EmployeeuserName,String EmployeepassWord,String Date,String mamount,String CB,String mRemarks, String domain, String gstn, String cgst, String sgst, String igst,String mobnumber)
throws InterruptedException
{

Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
// locator.Login(EmployeeuserName,EmployeepassWord);

System.out.println(EmployeeuserName);
System.out.println(EmployeepassWord);
b.clearData(EmployeeuserName,EmployeepassWord,domainname);
// String strDate = dateFormat.format(datetext);
logger = extent.startTest("Drafting Mobile expense Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");
Reporter.log("=====User Login=====", true);
System.out.println(EmployeeuserName);
System.out.println(EmployeepassWord);

// Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
locator.Login(EmployeeuserName,EmployeepassWord,domainname);
logger.log(LogStatus.INFO, "Test result of Drafting Mobile expense Functionality");
//locator.logout();
//Thread.sleep(1000);
DraftclaimElements deLocator = PageFactory.initElements(driver, DraftclaimElements.class);
deLocator.navigateToapplyclaim();
deLocator.mobileAddSteps(EmployeeuserName, EmployeepassWord, Date, mamount, CB, mRemarks,domainname,gstn,cgst,sgst,igst,mobnumber);
//Ex-Hq-kalyani Fieldwork
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
data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoDataProvider.xls", "MobileClaimData");
return data_login;


}

}