package TestCases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.http.auth.UsernamePasswordCredentials;
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

import com.relevantcodes.extentreports.LogStatus;

import Browsers.Open_Browser;
import Browsers.Urls;
import PageObjects.ArtistApplyClaimPage;
import PageObjects.DraftclaimElements;
import PageObjects.Loginpage;
import TestData.CaptureExcelData;

public class ArtistApplyClaim extends Urls {
String EmployeeuserName=null;
String EmployeepassWord=null;
WebDriver driver=null;
String domainname;
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

@Test(dataProvider="Login1")
public void testSteps(String EmployeeuserName,String EmployeepassWord,String coemployee, String copass,String intime,String outtime,String domain) throws InterruptedException, IOException
{
System.out.println(intime);
System.out.println(outtime);
b.uploadexcelattendance(EmployeeuserName,coemployee,intime,outtime);
Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
// locator.Login(EmployeeuserName,EmployeepassWord);

System.out.println(EmployeeuserName);
System.out.println(EmployeepassWord);
b.clearData(EmployeeuserName,EmployeepassWord,domainname);
//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
// String strDate = dateFormat.format(datetext);
logger = extent.startTest("Applying attendance wise food Expense Test (User:"+EmployeeuserName +" pass:"+EmployeepassWord+")");
Reporter.log("=====User Login=====", true);
System.out.println("useername");
System.out.println(EmployeepassWord);

// Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
locator.Login(EmployeeuserName,EmployeepassWord,domainname);
logger.log(LogStatus.INFO, "Test result of Applying attendance wise food Expense Functionality");
//locator.logout();
//Thread.sleep(1000);
ArtistApplyClaimPage deLocator = PageFactory.initElements(driver, ArtistApplyClaimPage.class);
deLocator.addSteps(coemployee,copass,domainname);
//UP-Krishnanagar
//deLocator.addExpenseSteps(workType,toTown,datetext);
//driver.quit();
//deLocator.navigatetouploadadv();
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
data_login=ed.readfile(System.getProperty("user.dir") +"/Excel", "ZentoDataProvider.xls", "Redchillies");
return data_login;


}


}