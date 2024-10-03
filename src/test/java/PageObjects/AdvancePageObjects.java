package PageObjects;


import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



import Browsers.Urls;

public class AdvancePageObjects extends Urls {
	
WebDriver driver;
	
	public AdvancePageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	@FindBy(xpath=".//*[@id='make-small-nav']/i")
	WebElement SideMenu;
	
	
	@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl03_aDLink\"]/span[1]")
	WebElement applyAdvance1;
	
	@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl03_RptSubMenu_ctl00_lnkSubMenu\"]")
	WebElement applyAdvance2;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlWBS\"]")
	WebElement selectadvancetype;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtdays\"]")
	WebElement amount;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtReason\"]")
	WebElement reason;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_FULeaveVoucher\"]")
	WebElement upload;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnAdd\"]")
	WebElement advancesubmit;
	@FindBy(xpath="//a/input[@value='Approve Advance']")
	WebElement advanceapprove1;
	
	//a/input[@value='145']
	@FindBy(xpath="//a/input[@value='145']")
	WebElement advanceapprove2;
	
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtOtherRemarks\"]")
	WebElement advancereasonapprove;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnUpdate\"]")
	WebElement advanceupdate;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblmsg2\"]")
	WebElement advanceupdatesuccess;
	@FindBy(xpath="//a/input[@value='Advance Claim']")
	WebElement reimburse1;
	
	@FindBy(xpath="//a/input[@value='Reimburse Advance Claims']")
	WebElement reimburse2;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnPaid\"]")
	WebElement paidbutton;
	@FindBy(xpath="//a/input[@value='Pending for online Payment Advance Claims']")
	WebElement paymentprocess1;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnLogin\"]")
	WebElement processpaymentbutton;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblmsg2\"]")
	WebElement advancesubmitsuccess;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtOtherRemarks\"]")
	WebElement reasontext;
	
	
	
		
	
	public void navigateToApplyAdvancePage() throws InterruptedException
	{
		Thread.sleep(500);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", SideMenu);
		JavascriptExecutor jsapplyclaimspage1 = (JavascriptExecutor) driver;
		jsapplyclaimspage1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", applyAdvance1);
		JavascriptExecutor jsapplyclaimspage2 = (JavascriptExecutor) driver;
		jsapplyclaimspage2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", applyAdvance2);
	
	}
	public void navigateToApproveadvancePage() throws InterruptedException
	{
		String s = driver.findElement(By.xpath("//a/input[@value='Approve Advance']")).getAttribute("id");
		System.out.println("s s"+s);
		String fileName = StringUtils.substringBeforeLast(s, "_");
		String finalstring = StringUtils.substringAfterLast(fileName, "_");
		System.out.println("id id"+finalstring);
		//ctl00_rptMainMenu_ctl04_RptSubMenu_ctl00_lnkSubMenu
		String main = "ctl00_rptMainMenu_ctl04_RptSubMenu_ctl00_lnkSubMenu";
		//ctl00_rptMainMenu_ctl00_RptSubMenu_ctl00_lnkSubMenu
  String substr1 = StringUtils.substringBeforeLast(main, "_RptSubMenu");
  System.out.println("substr1 id"+substr1);
		System.out.print( driver.findElement(By.xpath("//a/input[@value='Approve Advance']")).getAttribute("id"));
		Thread.sleep(500);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", SideMenu);
		JavascriptExecutor jsapplyclaimspage1 = (JavascriptExecutor) driver;
		jsapplyclaimspage1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", advanceapprove1);
		JavascriptExecutor jsapplyclaimspage2 = (JavascriptExecutor) driver;
		jsapplyclaimspage2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
				driver.findElement(By.id("ctl00_rptMainMenu_"+finalstring+"_RptSubMenu_ctl00_lnkSubMenu")));
	}
	
	public void applyadvancesteps()
	{
		Select advancetypeselector = new Select(selectadvancetype);
		advancetypeselector.selectByValue("1");
		amount.sendKeys("400");
		reason.sendKeys("test");
		upload.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
		JavascriptExecutor jsapplyclaimspage2 = (JavascriptExecutor) driver;
		jsapplyclaimspage2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", advancesubmit);
//		 Alert alertsuccess = driver.switchTo().alert();
//			String alerttextsuccess1 = driver.switchTo().alert().getText();
//			System.out.println(alerttextsuccess1);
//			assertTrue(alerttextsuccess1.equalsIgnoreCase("Advance Request submitted successfully!"));
//			alertsuccess.accept();
		
		assertTrue((advancesubmitsuccess.getText()).equalsIgnoreCase("Advance Request submitted successfully!"));	
	}
	
	public String submitAdvanceUsingAPI(String EmployeeuserName,String EmployeepassWord,String domain)
	{
		
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+""
		 		+ "&PWD="+EmployeepassWord+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 String empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
			 System.out.println(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test"
				  		+ "&LeaveType=1&Reason=test&NoOfLeaves=200&EmpID="+empdata+"&Domain="+domain);
		  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test"
		  		+ "&LeaveType=1&Reason=test&NoOfLeaves=200&EmpID="+empdata+"&Domain="+domain);
		 array1 = gdata1.parseFromJSONResponse(userresponse1);
		
		 i=0;
		 String advanceid= array1.get(i+23);
		 System.out.println(advanceid);
		 System.out.println(BaseUrl+"/api/AdvanceProcessing/SubmitAdvance?LeaveId="+advanceid+"&Domain="+domain);
		 userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceProcessing/SubmitAdvance?LeaveId="+advanceid+"&Domain="+domain);
		 return advanceid;
	}
	
	public void approveadvancestpes(String domain,String approvetype,String advanceid) throws InterruptedException
	{
		int i;
		 navigateToApproveadvancePage();
		 WebElement table = driver.findElement(By.xpath(".//*[@id='table2']")); 

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
			    		String claim=driver.findElement(By.xpath(".//*[@id='table2']/tbody/tr["+i+"]/td[1]/span/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	if(claim.equalsIgnoreCase(advanceid))
			    	{
			    		WebElement approvalbutton=driver.findElement(By.xpath(".//*[@id='table2']/tbody/tr["+i+"]/td[8]/span/div/input"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", approvalbutton);
			    	    i=size;
			    	}
			    	
			    	
			    }
			  Alert alertconfirm = driver.switchTo().alert();
				String alerttextconfirm1 = driver.switchTo().alert().getText();
				System.out.println(alerttextconfirm1);
				assertTrue(alerttextconfirm1.equalsIgnoreCase("Are you sure you want to approve this advance?"));
				alertconfirm.accept();
				Thread.sleep(1000);
				System.out.println(advancesubmitsuccess.getText());
				assertTrue(advancesubmitsuccess.getText().equalsIgnoreCase("Advance Approved Successfully. !"));
				
			
//				Alert alertsuccess = driver.switchTo().alert();
//				String alerttextsuccess1 = driver.switchTo().alert().getText();
//				System.out.println(alerttextsuccess1);
//				assertTrue(alerttextsuccess1.equalsIgnoreCase("Advance Approved Successfully!"));
//				alertsuccess.accept();
		 }else if(approvetype.equalsIgnoreCase("disapprove"))
		 {
			 
			 advancereasonapprove.sendKeys("test");
			 for( i=2; i<=size;i++)
			    {
			    	
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    		String claim=driver.findElement(By.xpath(".//*[@id='table2']/tbody/tr["+i+"]/td[1]/span/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	if(claim.equalsIgnoreCase(advanceid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table2']/tbody/tr["+i+"]/td[9]/span/div/input"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			
			 System .out.println("Reject advance");
			 Thread.sleep(500);
//			 Alert alertconfirm = driver.switchTo().alert();
//				String alerttextconfirm1 = driver.switchTo().alert().getText();
//				System.out.println(alerttextconfirm1);
//				assertTrue(alerttextconfirm1.equalsIgnoreCase("Are you sure you want to disapprove this advance?"));
//				alertconfirm.accept();
				//System.out.println(advancesubmitsuccess.getText());
				assertTrue(advancesubmitsuccess.getText().equalsIgnoreCase("Advance Disapproved Successfully. !"));
			 
			 Thread.sleep(5000);
//				Alert alertsuccess = driver.switchTo().alert();
//				String alerttextsuccess1 = driver.switchTo().alert().getText();
//				System.out.println(alerttextsuccess1);
//				assertTrue(alerttextsuccess1.equalsIgnoreCase("Advance Disapproved Successfully!"));
//				alertsuccess.accept();
		 }
	}
	
	public void reopensteps(String advanceid) throws InterruptedException {
		
		navigateToApplyAdvancePage();
		
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
			    	if(claim.equalsIgnoreCase(advanceid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[9]/span/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			 Thread.sleep(5000);
//				Alert alertsuccess = driver.switchTo().alert();
//				String alerttextsuccess1 = driver.switchTo().alert().getText();
//				System.out.println(alerttextsuccess1);
//				assertTrue(alerttextsuccess1.equalsIgnoreCase("Advance Re-Submitted Successfully"));
//				alertsuccess.accept();
				assertTrue(advanceupdatesuccess.getText().equalsIgnoreCase("Advance Re-Submitted Successfully!"));;
	}
	
	
	public void editsteps(String advanceid) throws InterruptedException {
		
		navigateToApplyAdvancePage();
		
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
			    	if(claim.equalsIgnoreCase(advanceid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[7]/span/input"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			 Thread.sleep(1000);

				Select advancetypeselector = new Select(selectadvancetype);
				advancetypeselector.selectByValue("1");
				amount.clear();
				amount.sendKeys("400");
				reason.clear();
				reason.sendKeys("test");
				upload.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				JavascriptExecutor jsapplyclaimspage2 = (JavascriptExecutor) driver;
				jsapplyclaimspage2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", advanceupdate);
				Thread.sleep(1000);
				assertTrue(advanceupdatesuccess.getText().equalsIgnoreCase("Details updated successfully !"));;
	}
	
	
    public void deletesteps(String advanceid) throws InterruptedException {
		
		navigateToApplyAdvancePage();
		
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
			    	if(claim.equalsIgnoreCase(advanceid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[8]/span/input"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			 Thread.sleep(1000);

				
				
				 Alert alertconfirm = driver.switchTo().alert();
					String alerttextconfirm1 = driver.switchTo().alert().getText();
					System.out.println(alerttextconfirm1);
					assertTrue(alerttextconfirm1.equalsIgnoreCase("Are you sure you want to delete Advance?"));
					alertconfirm.accept();
					Thread.sleep(5000);
//					Alert alertsuccess = driver.switchTo().alert();
//					String alerttextsuccess1 = driver.switchTo().alert().getText();
//					System.out.println(alerttextsuccess1);
//					assertTrue(alerttextsuccess1.equalsIgnoreCase("Deleted Successfully"));
//					alertsuccess.accept();
					assertTrue(advanceupdatesuccess.getText().equalsIgnoreCase("Deleted Successfully!"));;
	}

   
     public void paymentprocesssteps(String advanceid) throws InterruptedException
    {
    	 
    	
    	 Thread.sleep(500);
 		JavascriptExecutor js3 = (JavascriptExecutor) driver;
 	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", SideMenu);
 		JavascriptExecutor jsapplyclaimspage1 = (JavascriptExecutor) driver;
 		jsapplyclaimspage1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", reimburse1);
 		JavascriptExecutor jsapplyclaimspage2 = (JavascriptExecutor) driver;
 		jsapplyclaimspage2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", reimburse2);

 		

		 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']")); 

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
			    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[1]/span")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	if(claim.equalsIgnoreCase("Advance " +advanceid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[8]/span/span/input"));
			    		JavascriptExecutor js6 = (JavascriptExecutor) driver;
			    		js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			 Thread.sleep(1000);
		    	JavascriptExecutor jsapplyclaimspage8 = (JavascriptExecutor) driver;
		    	jsapplyclaimspage8.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", paidbutton);
		    	Alert alertconfirm = driver.switchTo().alert();
				String alerttextconfirm1 = driver.switchTo().alert().getText();
				System.out.println(alerttextconfirm1);
				assertTrue(alerttextconfirm1.equalsIgnoreCase("Are you sure you want to submit selected records?"));
				alertconfirm.accept();
				Thread.sleep(10000);
//				Alert alertsuccess = driver.switchTo().alert();
//				String alerttextsuccess1 = driver.switchTo().alert().getText();
//				System.out.println(alerttextsuccess1);
//				assertTrue(alerttextsuccess1.equalsIgnoreCase("Payment mode selected successfully, please do further payment processing"));
//				alertsuccess.accept();
				assertTrue(advancesubmitsuccess.getText().equalsIgnoreCase("Payment mode selected successfully, please do further payment processing. !"));
				
				Thread.sleep(1000);
				JavascriptExecutor jsmenu = (JavascriptExecutor) driver;
				jsmenu.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", SideMenu);
		 		JavascriptExecutor jspaymentprocesspage = (JavascriptExecutor) driver;
		 		jspaymentprocesspage.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", reimburse1);
		 		JavascriptExecutor jspaymentprocesspage2 = (JavascriptExecutor) driver;
		 		jspaymentprocesspage2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", paymentprocess1);
    
		 		
		 		

				 WebElement table2 = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']")); 

					// Now get all the TR elements from the table 
					List<WebElement> allRows2 = table2.findElements(By.tagName("tr")); 
			                          int size2=allRows2.size();
			                          System.out.println("Row count is"+size2);
			                          int sizecell2=0;
					// And iterate over them, getting the cells 
					for (WebElement row : allRows2) { 
					    List<WebElement> cells = row.findElements(By.tagName("td")); 
					     sizecell2=cells.size();
					   
					    // Print the contents of each cell
					    
					}
					 System.out.println("col count is"+sizecell2);
					 
					 for(int i=2; i<=size2;i++)
					    {
					    	
					    		
					    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
					    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[1]/span")).getText();
					    	System.out.println("This is claim i am looking"+claim);  
					    	if(claim.equalsIgnoreCase("Advance " +advanceid))
					    	{
					    		WebElement claimidclick1=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[10]/span//input[@type=\"checkbox\"]"));
					    		JavascriptExecutor js6 = (JavascriptExecutor) driver;
					    		js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick1);
					    	    i=size;
					    	}
					    	
					    	
					    }
					 
					 JavascriptExecutor jspaymentprocess = (JavascriptExecutor) driver;
					 jspaymentprocess.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", processpaymentbutton);
    
					 Thread.sleep(10000);
//						 alertsuccess = driver.switchTo().alert();
//						 alerttextsuccess1 = driver.switchTo().alert().getText();
//						System.out.println(alerttextsuccess1);
//						assertTrue(alerttextsuccess1.equalsIgnoreCase("Payment Processed"));
//						alertsuccess.accept();
					 assertTrue(advancesubmitsuccess.getText().equalsIgnoreCase("Payment Processed. !"));
    
    }
}
