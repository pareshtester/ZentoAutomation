package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Browsers.Urls;

public class ArtistApplyClaimPage extends Urls {
WebDriver driver;

public ArtistApplyClaimPage(WebDriver driver) {
// TODO Auto-generated constructor stub
this.driver=driver;
}
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlClaimType\"]")
WebElement calimtypelement;

@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlShifts\"]")
WebElement shift;

@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtDate\"]")
WebElement Fdate;


@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlFoodType\"]")
WebElement Ftype;

@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddcbEmployee_sl\"]")
WebElement EmpNamedropdown;
@FindBy(xpath="//input[@value='479']")
WebElement EmpName;

@FindBy(xpath="//*[@id=\"make-small-nav\"]")
WebElement sidemenu;
@FindBy(xpath="//*[@id=\"rptMainMenu_aDLink_0\"]/span[1]")
WebElement mastermenu;
@FindBy(xpath="//*[contains(text(),'Attendance')]")
WebElement attendancemaster;
//*[contains(text(),'Vendor Registration')]

@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_fpUpload\"]")
WebElement selectattendance;
@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_UploadFile\"]")
WebElement uploadattendance;
@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_lblmsg\"]")
WebElement attendancesuccess;

@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtAmt\"]")
WebElement enteramt;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_FUVoucher\"]")
WebElement uploadvocher;

@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]")
WebElement submitbtn;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtRemark\"]")
WebElement rmks;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblStatus\"]")
WebElement foodsuccess;


DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
LocalDate Date = LocalDate.now();

public void addSteps(String coemployee,String copass,String domain) throws InterruptedException
{


//TravelexpenseTabclick.click();
Select selecttype = new Select(calimtypelement);
selecttype.selectByVisibleText("Food");



System.out.println(dtf.format(Date)); JavascriptExecutor jscalenderopen =
(JavascriptExecutor) driver;
jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');"
+ "evt.initMouseEvent" +
"('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
+ "arguments[0]" + ".dispatchEvent(evt);", Fdate);

//opendate.click();

// Fdate.sendKeys("06 01 2019");




JavascriptExecutor jscalenderdate = (JavascriptExecutor) driver;
jscalenderdate.executeScript("var evt = document.createEvent('MouseEvents');"
+ "evt.initMouseEvent" +
"('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
+ "arguments[0]" + ".dispatchEvent(evt);",
driver.findElement(By.xpath("//*[@title='"+dtf.format(Date)+"']")));



Thread.sleep(500);

Select selectshift = new Select(shift);
selectshift.selectByVisibleText("Morning shift : 7:00 AM - 3:00 PM");

Select selectfoodtype = new Select(Ftype);
selectfoodtype.selectByVisibleText("Dinner");

TestData.GetData gdata = new TestData.GetData();
System.out.println(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+coemployee+"&PWD="+copass+"&domain="+domain);
String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+coemployee+"&PWD="+copass+"&domain="+domain);


ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
int i=0;

// String userData=array.get(i);
// String passData=array.get(i+1);
String empdata=array.get(i+2);
// String message=array.get(i+3);


System.out.println("This is" +empdata);
System.out.println("I am here");

JavascriptExecutor jscalenderopen1 = (JavascriptExecutor) driver;
jscalenderopen1.
executeScript("var evt = document.createEvent('MouseEvents');" +
"evt.initMouseEvent" +
"('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
+ "arguments[0]" + ".dispatchEvent(evt);", driver.findElement(By.xpath("//input[@value="+empdata+"]")));
// EmpNamedropdown.click(); EmpName.click();


Thread.sleep(500);
rmks.sendKeys("Testing");
enteramt.sendKeys("200");
enteramt.sendKeys(Keys.ENTER);
Thread.sleep(1000);
uploadvocher.sendKeys(System.getProperty("user.dir")+"/Images/Chrysanthemum.jpg");
Thread.sleep(1000);
System.out.println(dtf.format(Date)); JavascriptExecutor jssubmit =
(JavascriptExecutor) driver;
jssubmit.executeScript("var evt = document.createEvent('MouseEvents');"
+ "evt.initMouseEvent" +
"('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
+ "arguments[0]" + ".dispatchEvent(evt);", submitbtn);
Thread.sleep(500);

assertTrue(foodsuccess.getText().equalsIgnoreCase("Food Claim Submitted Successfully !"));
// Thread.sleep(500);


}

public void navigatetouploadadv() throws InterruptedException
{
//sidemenu.click();

Thread.sleep(1000);
//menuIcon.click();
JavascriptExecutor menuicons = (JavascriptExecutor) driver;
menuicons.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", sidemenu);

JavascriptExecutor ativityjs1 = (JavascriptExecutor) driver;
ativityjs1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", mastermenu);

Thread.sleep(10000);
JavascriptExecutor ativityjs3 = (JavascriptExecutor) driver;
ativityjs3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", attendancemaster);
selectattendance.sendKeys(System.getProperty("user.dir")+"/Excel/Attendance.xls");
//uploadattendance.click();
JavascriptExecutor uploaddata = (JavascriptExecutor) driver;
uploaddata.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", uploadattendance);
System.out.println(attendancesuccess.getText());
assertTrue(attendancesuccess.getText().equalsIgnoreCase("Data uploaded successfully !"));

}

}