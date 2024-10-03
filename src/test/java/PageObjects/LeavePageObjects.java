package PageObjects;



import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browsers.Urls;
import Data.captureData;

public class LeavePageObjects extends Urls {


WebDriver driver;

public LeavePageObjects(WebDriver driver) {
// TODO Auto-generated constructor stub
this.driver=driver;
}




@FindBy(xpath=".//*[@id='make-small-nav']/i")
WebElement SideMenu;
@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl06_aDLink\"]/i[1]")
WebElement applyleave1;
@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl06_RptSubMenu_ctl00_lnkSubMenu\"]")
WebElement applyleave2;

@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlLeaveTypes\"]")
WebElement selectleavetype;

@FindBy(xpath="//*[@id='ctl00_ContentPlaceHolder1_txtFrmDate']")
WebElement fromdateCalender1;
@FindBy(xpath="//*[@id='ctl00_ContentPlaceHolder1_txtToDate']")
WebElement todateCalender1;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtdays\"]")
WebElement amount;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtReason\"]")
WebElement reason;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_FULeaveVoucher\"]")
WebElement upload;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnAdd\"]")
WebElement leavesubmit;
@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl07_aDLink\"]/span[1]")
WebElement leaveapprove1;

@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl07_RptSubMenu_ctl00_lnkSubMenu\"]")
WebElement leaveapprove2;

@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblmsg\"]")
WebElement leavetypeupdatesuccess;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnUpdate\"]")
WebElement leaveupdate;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblmsg\"]")
WebElement leavesubmitsuccess;

@FindBy(xpath="//*[@id=\"horizontalTab\"]/ul[1]/li[1]")
WebElement applyleavetab;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblmsg2\"]")
WebElement leavetypeapprovesuccess;
@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblmsg2\"]")
WebElement leaverejectmsg;


captureData gdata = new captureData();

DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
LocalDate localDate = LocalDate.now();


public void navigateToLeaveapplyPage() throws InterruptedException
{

Thread.sleep(500);
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", SideMenu);
JavascriptExecutor jsapplyclaimspage1 = (JavascriptExecutor) driver;
jsapplyclaimspage1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", applyleave1);
JavascriptExecutor jsapplyclaimspage2 = (JavascriptExecutor) driver;
jsapplyclaimspage2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", applyleave2);

}

public void navigateToApproveleavePage() throws InterruptedException
{
Thread.sleep(500);
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", SideMenu);
JavascriptExecutor jsapplyclaimspage1 = (JavascriptExecutor) driver;
jsapplyclaimspage1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", leaveapprove1);
JavascriptExecutor jsapplyclaimspage2 = (JavascriptExecutor) driver;
jsapplyclaimspage2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", leaveapprove2);
}



public void applyleavesteps() throws InterruptedException
{
JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", applyleavetab);

Select advancetypeselector = new Select(selectleavetype);
advancetypeselector.selectByValue("1");
Thread.sleep(5000);
//wait.until(ExpectedConditions.visibilityOf(fromdateCalender1));
jscalenderopen = (JavascriptExecutor) driver;
jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", fromdateCalender1);
//opendate.click();

JavascriptExecutor jscalenderdate = (JavascriptExecutor) driver;
jscalenderdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='"+dtf.format(localDate)+"']")));



JavascriptExecutor jscalendertoopen = (JavascriptExecutor) driver;
jscalendertoopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", todateCalender1);
//opendate.click();

JavascriptExecutor jscalendertodate = (JavascriptExecutor) driver;
jscalendertodate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='"+dtf.format(localDate)+"']")));


reason.sendKeys("test");
upload.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
JavascriptExecutor jssubmit = (JavascriptExecutor) driver;
jssubmit .executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", leavesubmit);
Thread.sleep(5000);
assertTrue((leavesubmitsuccess.getText()).equalsIgnoreCase("Leave Added Successfully !"));
}



public String submitLeaveUsingAPI(String EmployeeuserName,String EmployeepassWord,String domain)
{


String userresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+""
+ "&PWD="+EmployeepassWord+"&domain="+domain);


ArrayList<String> array1 = gdata.parseFromJSONResponse(userresponse1);
int i=0;
String leavid="";
String userData=array1.get(i);
String passData=array1.get(i+1);
String empdata=array1.get(i+2);
String bandid=array1.get(i+3);
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
LocalDate localDate = LocalDate.now();

String leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domain+"");
ArrayList<String> array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
System.out.println("array is"+array);

for(i=1;i<array.size();i++)

{
String leavetypeid= array.get(i) ;
System.out.println(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domain+"");
String insertleaverespnse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
+ "&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=1&EmpID="+empdata+"&Domain="+domain+"");

array1 = gdata.parseFromJSONResponse(insertleaverespnse);
System.out.println(array1);
int j=0;
leavid = array1.get(j+23);
String leaveitemid= array1.get(j+24);
System.out.println(leavid);

i=array.size();

}


gdata.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/SubmitLeave?LeaveId="+leavid+"&Domain="+domain+"");
return leavid;
}

public void approveleavestpes(String domain,String approvetype,String advanceid) throws InterruptedException
{
int i;

navigateToApproveleavePage();
WebElement table = driver.findElement(By.xpath(".//*[@id='table3']"));

// Now get all the TR elements from the table
List<WebElement> allRows = table.findElements(By.tagName("tr"));
int size=allRows.size();
System.out.println("Row count is"+size);
int sizecell=0;
// And iterate over them, getting the cells
for (WebElement row : allRows) {
List<WebElement> cells = row.findElements(By.tagName("td"));
sizecell=cells.size();

// Print the contents of each cell

}
System.out.println("col count is"+sizecell);

if(approvetype.equalsIgnoreCase("approve"))
{
for( i=2; i<=size;i++)
{


//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
String claim=driver.findElement(By.xpath(".//*[@id='table3']/tbody/tr["+i+"]/td[1]/span/a")).getText();
System.out.println("This is claim i am looking"+claim);
if(claim.equalsIgnoreCase(advanceid))
{
WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table3']/tbody/tr["+i+"]/td[8]/span/div/input"));
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
i=size;
}


}
Alert alertconfirm = driver.switchTo().alert();
String alerttextconfirm1 = driver.switchTo().alert().getText();
System.out.println(alerttextconfirm1);
assertTrue(alerttextconfirm1.equalsIgnoreCase("Are you sure you want to approve this leave?"));
alertconfirm.accept();
Thread.sleep(1500);
System.out.println(leavetypeapprovesuccess.getText());
assertTrue(leavetypeapprovesuccess.getText().equalsIgnoreCase("Leave Approved Successfully !"));
//
// Alert alertsuccess = driver.switchTo().alert();
// String alerttextsuccess1 = driver.switchTo().alert().getText();
// System.out.println(alerttextsuccess1);
// assertTrue(alerttextsuccess1.equalsIgnoreCase("Advance Approved Successfully!"));
// alertsuccess.accept();

}else if(approvetype.equalsIgnoreCase("disapprove"))
{
System.out.println("here inside");
// advancereasonapprove.sendKeys("test");
for( i=2; i<=size;i++)
{


//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
String claim=driver.findElement(By.xpath(".//*[@id='table3']/tbody/tr["+i+"]/td[1]/span/a")).getText();
System.out.println("This is claim i am looking"+claim);
if(claim.equalsIgnoreCase(advanceid))
{
WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table3']/tbody/tr["+i+"]/td[9]/span/div/input"));
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
i=size;
}


}
Thread.sleep(5000);
Alert alertconfirm = driver.switchTo().alert();
String alerttextconfirm1 = driver.switchTo().alert().getText();
System.out.println(alerttextconfirm1);
assertTrue(alerttextconfirm1.equalsIgnoreCase("Are you sure you want to Reject this leave?"));
alertconfirm.accept();


Thread.sleep(5000);
// Alert alertsuccess = driver.switchTo().alert();
// String alerttextsuccess1 = driver.switchTo().alert().getText();
// System.out.println(alerttextsuccess1);
// assertTrue(alerttextsuccess1.equalsIgnoreCase("Advance Disapproved Successfully!"));
// alertsuccess.accept();
System.out.println(leaverejectmsg.getText());
assertTrue((leaverejectmsg.getText()).equalsIgnoreCase("Leave Disapproved Successfully !"));
}
}


public void editsteps(String leaveid,String domain) throws InterruptedException {

navigateToLeaveapplyPage();

WebElement table = driver.findElement(By.xpath(".//*[@id='table-two-axis']"));

// Now get all the TR elements from the table
List<WebElement> allRows = table.findElements(By.tagName("tr"));
int size=allRows.size();
System.out.println("Row count is"+size);
int sizecell=0;
// And iterate over them, getting the cells
for (WebElement row : allRows) {
List<WebElement> cells = row.findElements(By.tagName("td"));
sizecell=cells.size();

// Print the contents of each cell

}
System.out.println("col count is"+sizecell);

for(int i=2; i<=size;i++)
{


//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[1]/span")).getText();
System.out.println("This is claim i am looking"+claim);
if(claim.equalsIgnoreCase(leaveid))
{
WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[8]/span/input"));
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
i=size;
}


}
Thread.sleep(1000);
String leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domain+"");
ArrayList<String> array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
String leavtypeid= array.get(2);
Select leavetypeselector = new Select(selectleavetype);
leavetypeselector.selectByValue(leavtypeid);


JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", fromdateCalender1);
//opendate.click();

JavascriptExecutor jscalenderdate = (JavascriptExecutor) driver;
jscalenderdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='"+dtf.format(localDate)+"']")));



// JavascriptExecutor jscalendertoopen = (JavascriptExecutor) driver;
// jscalendertoopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
// + "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
// + ".dispatchEvent(evt);", todateCalender1);
//opendate.click();

// JavascriptExecutor jscalendertodate = (JavascriptExecutor) driver;
// jscalendertodate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
// + "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
// + ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='"+dtf.format(localDate)+"']")));
Thread.sleep(1000);
reason.clear();
reason.sendKeys("test");
upload.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
Thread.sleep(1000);
JavascriptExecutor jsapplyclaimspage2 = (JavascriptExecutor) driver;
jsapplyclaimspage2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", leaveupdate);
System.out.println(leavetypeupdatesuccess.getText());
assertTrue(leavetypeupdatesuccess.getText().equalsIgnoreCase("Details updated successfully !"));
}



public void deletesteps(String leaveid) throws InterruptedException {

navigateToLeaveapplyPage();

WebElement table = driver.findElement(By.xpath(".//*[@id='table-two-axis']"));

// Now get all the TR elements from the table
List<WebElement> allRows = table.findElements(By.tagName("tr"));
int size=allRows.size();
System.out.println("Row count is"+size);
int sizecell=0;
// And iterate over them, getting the cells
for (WebElement row : allRows) {
List<WebElement> cells = row.findElements(By.tagName("td"));
sizecell=cells.size();

// Print the contents of each cell

}
System.out.println("col count is"+sizecell);

for(int i=2; i<=size;i++)
{


//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[1]/span")).getText();
System.out.println("This is claim i am looking"+claim);
if(claim.equalsIgnoreCase(leaveid))
{
WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[9]/span/input"));
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
i=size;
}


}
Thread.sleep(1000);

Alert alertconfirm = driver.switchTo().alert();
String alerttextconfirm1 = driver.switchTo().alert().getText();
System.out.println(alerttextconfirm1);
assertTrue(alerttextconfirm1.equalsIgnoreCase("Are you sure you want to delete leave?"));
alertconfirm.accept();
Thread.sleep(5000);
// Alert alertsuccess = driver.switchTo().alert();
// String alerttextsuccess1 = driver.switchTo().alert().getText();
// System.out.println(alerttextsuccess1);
// assertTrue(alerttextsuccess1.equalsIgnoreCase("Deleted Successfully"));
// alertsuccess.accept();
System.out.println(leavetypeupdatesuccess.getText());
assertTrue(leavetypeupdatesuccess.getText().equalsIgnoreCase("Deleted Successfully !"));

}


public void reopensteps(String leaveid) throws InterruptedException {

navigateToLeaveapplyPage();

WebElement table = driver.findElement(By.xpath(".//*[@id='table-two-axis']"));

// Now get all the TR elements from the table
List<WebElement> allRows = table.findElements(By.tagName("tr"));
int size=allRows.size();
System.out.println("Row count is"+size);
int sizecell=0;
// And iterate over them, getting the cells
for (WebElement row : allRows) {
List<WebElement> cells = row.findElements(By.tagName("td"));
sizecell=cells.size();

// Print the contents of each cell

}
System.out.println("col count is"+sizecell);

for(int i=2; i<=size;i++)
{


//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[1]/span")).getText();
System.out.println("This is claim i am looking"+claim);
if(claim.equalsIgnoreCase(leaveid))
{
WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[10]/span/a"));
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
i=size;
}


}
Thread.sleep(5000);
// Alert alertsuccess = driver.switchTo().alert();
// String alerttextsuccess1 = driver.switchTo().alert().getText();
// System.out.println(alerttextsuccess1);
// assertTrue(alerttextsuccess1.equalsIgnoreCase("Leave Re-Submitted Successfully"));
// alertsuccess.accept();
assertTrue(leavesubmitsuccess.getText().equalsIgnoreCase("Leave Re-Submitted Successfully !"));
}
}