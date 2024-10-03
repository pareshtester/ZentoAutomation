package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browsers.Urls;
import Data.captureData;

public class RedChilliesPage extends Urls {
	WebDriver driver;
	
	public RedChilliesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
	LocalDate	 localDate = LocalDate.now();
	captureData gdata = new  captureData();
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlClaimType\"]")
	WebElement ClaimType;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_txtDate']")
	WebElement opendate;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlShifts\"]")
	WebElement shifttype;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ddlFoodType']")
	WebElement foodtype;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlMode\"]")
	WebElement travelmodetype;
	
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ddcbEmployee_sl']")
	WebElement employeeNametabclick;
	@FindBy(xpath=".//*[@id='Select4']")
	WebElement employeeName;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_txtAmt']")
	WebElement travelAmount;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_FUVoucher\"]")
	WebElement uploadtravel;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtRemark\"]")
	WebElement travelremarks;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_divSubmit\"]")
	WebElement submit;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]")
	WebElement enablesubmit;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblMsg\"]")
	WebElement successelement;
	@FindBy(xpath="//*[@id=\"horizontalTab\"]/ul[1]/li[3]")
	WebElement approvetab;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_DDLActionRemarks']")
	WebElement selectReason;
	@FindBy(xpath="//*[@id='ctl00_ContentPlaceHolder1_txtOtherRemarks']")
	WebElement otherTextField;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_BtnApproved']")
	WebElement approve;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_BtnDisApproved']")
	WebElement disapprove;
	@FindBy(xpath=".//*[@id='ctl00_ulRecommender']/a/span")
	WebElement Reportingopen;
	@FindBy(xpath="//*[contains(text(),'Approve claims')]")
	WebElement ApproveClaim;
	@FindBy(xpath="//*[contains(text(),'View')]")
	WebElement view;
	
	@FindBy(xpath=".//*[@id='ctl00_lnkReporting']/a/span")
	WebElement ReportingClick;
	@FindBy(xpath=".//*[@id='make-small-nav']/i")
	WebElement SideMenu;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnSave']")
	WebElement updatebutton;   
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_lblStatus']")
	WebElement updatefoodsuccesstext;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_lblMsg']")
	WebElement updatetravelsuccesstext;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnSave']")
	WebElement foodsubmit;   
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_lblStatus']")
	WebElement foodsuccesstext;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_lblStatus']")
	WebElement approvetabclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnApprove']")
	WebElement foodapprove;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnDisApprove']")
	WebElement fooddisapprove;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnSave']")
	WebElement updateFood;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_lblApproveReject']")
	WebElement foodrejectsuccess;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_lblStatus']")
	WebElement reopenfoodsuccess;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_lblMsg']")
	WebElement localsuccess;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_lblmsg2']")
	WebElement approvesuccess;
	
	
	//ctl00_ContentPlaceHolder1_lblMsg
	//ctl00_ContentPlaceHolder1_lblStatus
	
	public void applytravelsteps(String username,String password,String domain) throws InterruptedException
	{
		captureData gdata = new  captureData();
		System.out.println(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domain+"");
		String  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domain+"");
		ArrayList<String>  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		 int i=0;
		 String userData=array1.get(i);
		 String  passData=array1.get(i+1);
		 String empdata=array1.get(i+2);
		 String  bandid=array1.get(i+3);
	
		Select sclaimtype = new Select(ClaimType);
		sclaimtype.selectByValue("2");
		
		
		System.out.println(dtf.format(localDate));
		JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
		jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", opendate);
		//opendate.click();
		
		JavascriptExecutor jscalenderdate = (JavascriptExecutor) driver;
		jscalenderdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='"+dtf.format(localDate)+"']")));
		
		
		String shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domain+"");
		 ArrayList<String>  shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
		  System.out.println("New array"+shiftarray);
		  int arrayln= shiftarray.size();
		  System.out.println(arrayln);
		  
		  
		  String shiftid="";
		  for(int fsize=0;fsize<shiftarray.size();fsize++)
		 	{
		 		
		 		
		 		
		 		//String noename2=noepolicyarray1.get(1);
		 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
		 		
			  shiftid=shiftarray.get(fsize);
		 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
		 		 String shiftname= shiftarray.get(fsize+1);
		 		System.out.println("status is  ->>>>>>>>"+shiftname);
		 		fsize=fsize+1;
		 		if(shiftname.equalsIgnoreCase("Morning shift"))
		 		{
		 			 
		 			
		 			fsize=shiftarray.size();
		 			
		 			
		 		}
		 	}
		
		Select sshifytype = new Select(shifttype);
		sshifytype.selectByValue(shiftid);
		
		String localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&Domain="+domain+"");

		 ArrayList<String> localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
		int  localtravelmodecount=0;
		  String localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
		Select tavelmodeselect =  new Select(travelmodetype);
		tavelmodeselect.selectByValue(localtravelmodedata);
		
		
//		Select sfoodtype = new Select(foodtype);
//		sfoodtype.selectByVisibleText("Lunch");
//		
//		Select semployeename = new Select(employeeName);
//		semployeename.selectByVisibleText("Nilesh");
		
		travelAmount.sendKeys("111");
		travelAmount.sendKeys(Keys.ENTER);
		waitForLoad(driver);
		travelremarks.sendKeys("test");
		Thread.sleep(5000);
		
		uploadtravel.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
		travelremarks.sendKeys("test");
		
		Thread.sleep(5000);
		JavascriptExecutor	 jssubmit = (JavascriptExecutor) driver;
		jssubmit.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", enablesubmit);
		String successtext = successelement.getText();
		//assertTrue(successtext.equalsIgnoreCase("Local Claim Submitted Successfully."));
		assertTrue(localsuccess.getText().equalsIgnoreCase("Local Conveyance claim submitted successfully !"));
		
		
		
		
	}
	
	public String submitlocalclaimusingAPI(String username,String password,String domaintext)
	{
		String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
		ArrayList<String>  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 int i=0;
		String  userData=array1.get(i);
		String  passData=array1.get(i+1);
		String empdata=array1.get(i+2);
		String bandid=array1.get(i+3);
		String  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");

		ArrayList<String> localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
		 int localtravelmodecount=0;
		String  localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
		
		String shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
		ArrayList<String>   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
		int   arrayln= shiftarray.size();
		  System.out.println(arrayln);
		  
		  
		  String  shiftid="";
		  for(int fsize=0;fsize<shiftarray.size();fsize++)
		 	{
		 		
		 		
		 		
		 		//String noename2=noepolicyarray1.get(1);
		 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
		 		
			  shiftid=shiftarray.get(fsize);
		 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
		 		 String shiftname= shiftarray.get(fsize+1);
		 		System.out.println("status is  ->>>>>>>>"+shiftname);
		 		fsize=fsize+1;
		 		if(shiftname.equalsIgnoreCase("Morning shift"))
		 		{
		 			 
		 			
		 			fsize=shiftarray.size();
		 			
		 			
		 		}
		 	}
		  String  wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			ArrayList<String> wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				System.out.println(wbsarray+"array");
				int wbscount=0;
				String	 wbsdata=wbsarray.get(wbscount+1);
				
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDate localDate = LocalDate.now();
				System.out.println(BaseUrl+"/api/TravelClaim/InsertUpdateSupportTarvelClaim?empId="+empdata+""
				 		+ "&claimType=11&Date="+dtf.format(localDate)+"&intTravelWay="+localtravelmodedata+"&remarks=&shift="+shiftid+"&amount=60&voucher="
		 				+ "&Domain="+domaintext+"&WBS="+wbsdata+"");
		 String InsertUpdateSupportTarvelClaim= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/InsertUpdateSupportTarvelClaim?empId="+empdata+""
			 		+ "&claimType=11&Date="+dtf.format(localDate)+"&intTravelWay="+localtravelmodedata+"&remarks=&shift="+shiftid+"&amount=60&voucher="
			 				+ "&Domain="+domaintext+"&WBS="+wbsdata+"");
			
		 
		 
			ArrayList<String>	 foodclaimarray = gdata.parseFromJSONarrayResponse(InsertUpdateSupportTarvelClaim);
				  System.out.println("New array"+foodclaimarray);
				   arrayln= foodclaimarray.size();
				   i=0;
				   String   artistclaimid= foodclaimarray.get(i);
				   return artistclaimid;
	}
	
	public void NavigateToReportings() throws InterruptedException
	{
		Thread.sleep(500);
		JavascriptExecutor sidemenujs = (JavascriptExecutor) driver;
		sidemenujs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", SideMenu);
	    Thread.sleep(500);
		JavascriptExecutor reportingopenjs = (JavascriptExecutor) driver;
		reportingopenjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ApproveClaim);
	    Thread.sleep(500);
		JavascriptExecutor reportingclickjs = (JavascriptExecutor) driver;
		reportingclickjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", view);
	}
	
	
	public void NavigateTointernalReportings() throws InterruptedException
	{
		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='horizontalTab']/ul/li[contains(.,'Claim Approve')]")); 
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
	}
	public void approvalsteps(String ClaimId,String approvalAction) throws InterruptedException
	{
		{
			
			
			Thread.sleep(1000);
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
				    		String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[2]/span/h7/a")).getText();
				    	
				    	if(claim.equalsIgnoreCase(ClaimId))
				    	{
				    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[2]/span/h7/a"));
				    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
				    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
				    	    i=size;
				    	}
				    	
				    	
				    }
				    if(approvalAction.equalsIgnoreCase("approve"))
				    {
				    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", approve);
				    	//approve.click();
			    	    Thread.sleep(500);
				    	Alert alertapprove = driver.switchTo().alert();
						String alerttextapprove = driver.switchTo().alert().getText();
						System.out.println(alerttextapprove);
						assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Approve Claim?"));
						alertapprove.accept();
						Thread.sleep(500);
//						Alert alertapprovesuc = driver.switchTo().alert();
//						String alerttextapprovesuc = driver.switchTo().alert().getText();
//						System.out.println(alerttextapprovesuc);
//						assertTrue(alerttextapprovesuc.equalsIgnoreCase(" CLAIM "+ClaimId+" Approved successfully"));
//						alertapprovesuc.accept();
						assertTrue(approvesuccess.getText().equalsIgnoreCase("CLAIM "+ClaimId+" Approved successfully"));
						
						
				    }else if(approvalAction.equalsIgnoreCase("disapprove"))
				    {
				    	Select s = new Select(selectReason);
						s.selectByVisibleText("Other");
						Thread.sleep(1000);
						otherTextField.sendKeys("test");
				    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
				    	//approve.click();
//			    	    Thread.sleep(500);
//			    	    Alert alertapprove = driver.switchTo().alert();
//						String alerttextapprove = driver.switchTo().alert().getText();
//						System.out.println(alerttextapprove);
//						assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//						alertapprove.accept();
						Thread.sleep(500);
//						Alert alertapprovesuc = driver.switchTo().alert();
//						String alerttextapprovesuc = driver.switchTo().alert().getText();
//						System.out.println(alerttextapprovesuc);
						System.out.println(approvesuccess.getText());
						assertTrue(approvesuccess.getText().equalsIgnoreCase("CLAIM "+ClaimId+" Rejected successfully,"));
					
						
				    }else if(approvalAction.equalsIgnoreCase("reopen"))
				    {
				    	Select s = new Select(selectReason);
						s.selectByVisibleText("Other");
						Thread.sleep(1000);
						otherTextField.sendKeys("test");
				    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
				    	//approve.click();
//			    	    Thread.sleep(500);
//			    	    Alert alertapprove = driver.switchTo().alert();
//						String alerttextapprove = driver.switchTo().alert().getText();
//						System.out.println(alerttextapprove);
//						assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//						alertapprove.accept();
						Thread.sleep(500);
//						Alert alertapprovesuc = driver.switchTo().alert();
//						String alerttextapprovesuc = driver.switchTo().alert().getText();
//						System.out.println(alerttextapprovesuc);
						//assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
						//alertapprovesuc.accept();
					//	assertTrue(leavetypeapprovesuccess.getText().equalsIgnoreCase("Leave Approved Successfully !"));
				    }
		}
	}
	
	public void editsteps(String username,String password,String localid,String domain) throws InterruptedException
	{
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
			    	if(claim.equalsIgnoreCase(localid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[12]/span/input"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	    System.out.println(">>>>>>>>>>>");
			    	}
			    	
			    	
			    }
			 
			 
			 System.out.println(dtf.format(localDate));
				
			 
				
				captureData gdata = new  captureData();
				System.out.println(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domain+"");
				String  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domain+"");
				ArrayList<String>  array1 = gdata.parseFromJSONResponse(userresponse);
				 
				 System.out.println(array1);
				 int i=0;
				 String userData=array1.get(i);
				 String  passData=array1.get(i+1);
				 String empdata=array1.get(i+2);
				 String  bandid=array1.get(i+3);
			
				
				String localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&Domain="+domain+"");

				 ArrayList<String> localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
				int  localtravelmodecount=0;
				  String localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
//				Select tavelmodeselect =  new Select(travelmodetype);
//				tavelmodeselect.selectByValue(localtravelmodedata);
				
				
//				Select sfoodtype = new Select(foodtype);
//				sfoodtype.selectByVisibleText("Lunch");
//				
//				Select semployeename = new Select(employeeName);
//				semployeename.selectByVisibleText("Nilesh");
				travelAmount.clear();
				travelAmount.sendKeys("111");
				travelAmount.sendKeys(Keys.ENTER);
				waitForLoad(driver);
				travelremarks.clear();
				travelremarks.sendKeys("test");
				Thread.sleep(5000);
				
				uploadtravel.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				travelremarks.sendKeys("test");
				
				Thread.sleep(5000);
				JavascriptExecutor	 jssubmit = (JavascriptExecutor) driver;
				jssubmit.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", updatebutton);
				String successtext = successelement.getText();
				assertTrue(successtext.equalsIgnoreCase("Local Conveyance claim updated successfully !"));
			 
			 
	}
	
	
	public void deletesteps(String localid)
	{
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
			    	if(claim.equalsIgnoreCase(localid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[13]/span/input"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			 
			 Alert alert1 = driver.switchTo().alert();
				String alerttext1 = driver.switchTo().alert().getText();
				System.out.println(alerttext1);
				assertTrue(alerttext1.equalsIgnoreCase("Are you sure you want to delete claim?"));
				alert1.accept();
//				String successtext = updatetravelsuccesstext.getText();
//				assertTrue(successtext.equalsIgnoreCase("Claim Deleted Successfully."));
				assertTrue(localsuccess.getText().equalsIgnoreCase("Claim deleted successfully !"));
				//alert1.accept();
	}
	
	
	public void reopensteps(String localid) throws InterruptedException
	{
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
		if(claim.equalsIgnoreCase(localid))
		{
		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[14]/span/a"));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
		i=size;
		}


		}


		// String successtext = updatetravelsuccesstext.getText();
		// System.out.println("successtext>>>>"+successtext);
		// assertTrue(successtext.equalsIgnoreCase("Claim reopened successfully !"));
		System.out.println(localsuccess.getText());
		assertTrue(localsuccess.getText().equalsIgnoreCase("Claim reopened successfully !"));
		// ctl00_ContentPlaceHolder1_lblMsg
		//alert1.accept();
	}
	
	
	public void applyfoodsteps(String username, String password, String domain) throws InterruptedException
	{
		captureData gdata = new  captureData();
		
		
		
		
	
		Select sclaimtype = new Select(ClaimType);
		sclaimtype.selectByValue("7");
		
		
		System.out.println(dtf.format(localDate));
		JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
		jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", opendate);
		//opendate.click();
		
		JavascriptExecutor jscalenderdate = (JavascriptExecutor) driver;
		jscalenderdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='"+dtf.format(localDate)+"']")));
		
		
		String shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domain+"");
		 ArrayList<String>  shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
		  System.out.println("New array"+shiftarray);
		  int arrayln= shiftarray.size();
		  System.out.println(arrayln);
		  
		  
		  String shiftid="";
		  for(int fsize=0;fsize<shiftarray.size();fsize++)
		 	{
		 		
		 		
		 		
		 		//String noename2=noepolicyarray1.get(1);
		 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
		 		
			  shiftid=shiftarray.get(fsize);
		 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
		 		 String shiftname= shiftarray.get(fsize+1);
		 		System.out.println("status is  ->>>>>>>>"+shiftname);
		 		fsize=fsize+1;
		 		if(shiftname.equalsIgnoreCase("Morning shift"))
		 		{
		 			 
		 			
		 			fsize=shiftarray.size();
		 			
		 			
		 		}
		 	}
		
		Select sshifytype = new Select(shifttype);
		sshifytype.selectByValue(shiftid);
		
		String foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domain+"");
		  
		
		  ArrayList<String> foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
		  System.out.println("New array"+foodtypearray);
		   arrayln= foodtypearray.size();
		  System.out.println(arrayln);
		  
		  
		  String artistfoodtypeid="";
		  for(int fsize=0;fsize<foodtypearray.size();fsize++)
		 	{
		 		
		 		
		 		
		 		
		 		
			  artistfoodtypeid=foodtypearray.get(fsize+1);
		 		 String foodtypename= foodtypearray.get(fsize+2);
		 		fsize=fsize+2;
		 		if(foodtypename.equalsIgnoreCase("Dinner"))
		 		{
		 			 
		 			
		 			fsize=foodtypearray.size();
		 			
		 			
		 		}
		 	}
		  String bandidtext="";
		  String bandname="";
		  
		  String  userresponse = gdata.getContenxtWeb(BaseUrl+"api/Master/GetBandList?Domain="+domain+"");
			ArrayList<String>  array1 = gdata.parseFromJSONarrayResponse(userresponse);
		  for (int k = 0; k<array1.size();k++)
		  {
			  
			   bandidtext = array1.get(k);
			   bandname = array1.get(k+1);
			  k= k+2;
			  if(bandname.equalsIgnoreCase("Artist"))
			  {
				 k=array1.size(); 
			  }
			  
			 
		  }
		  
		  System.out.println(">>>>>>>"+bandname);
		Select sfoodtype = new Select(foodtype);
		sfoodtype.selectByValue(artistfoodtypeid);
		JavascriptExecutor	 employeetabclick = (JavascriptExecutor) driver;
		employeetabclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", employeeNametabclick);
		//employeeNametabclick.click();
		
		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_ddcbEmployee_dv']/div/span/label[contains(.,'Pareshone  (1)')]")); 
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
//		Select semployeename = new Select(employeeName);
//		semployeename.selectByVisibleText("Nilesh");
		
		
		
		
		
		travelAmount.sendKeys("111");
		travelAmount.sendKeys(Keys.ENTER);
		waitForLoad(driver);
		travelremarks.sendKeys("test");
		Thread.sleep(5000);
		
		uploadtravel.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
		travelremarks.sendKeys("test");
		
		Thread.sleep(5000);
		JavascriptExecutor	 jssubmit = (JavascriptExecutor) driver;
		jssubmit.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", foodsubmit);
		String successtext = foodsuccesstext.getText();
		assertTrue(successtext.equalsIgnoreCase("Food Claim Submitted Successfully."));
		
	}
	
	
	public String submitfoodclaimusingAPI(String username,String password,String managerusername,String managerpassword, String domaintext)
	{
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
		
		ArrayList<String>  wbsarray =  new ArrayList<String>();
		
		String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
		ArrayList<String>  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 int i=0;
		String  userData=array1.get(i);
		String  passData=array1.get(i+1);
		String empdata=array1.get(i+2);
		String bandid=array1.get(i+3);
		 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+""); 
		array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		   i=0;
		  userData=array1.get(i);
		 passData=array1.get(i+1);
		String managerdata=array1.get(i+2);
		   bandid=array1.get(i+3);
		  System.out.println(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
		  String shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
		  ArrayList<String> shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
		  System.out.println("New array"+shiftarray);
		 int  arrayln= shiftarray.size();
		  System.out.println(arrayln);
		  
		  
		  String shiftid="";
		  for(int fsize=0;fsize<shiftarray.size();fsize++)
		 	{
		 		
		 		
		 		
		 		
			  shiftid=shiftarray.get(fsize);
		 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
		 		 String shiftname= shiftarray.get(fsize+1);
		 		System.out.println("status is  ->>>>>>>>"+shiftname);
		 		fsize=fsize+1;
		 		if(shiftname.equalsIgnoreCase("Morning shift"))
		 		{
		 			 
		 			
		 			fsize=shiftarray.size();
		 			
		 			
		 		}
		 	}
		 
		  String foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
		  
		
		  ArrayList<String> foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
		  System.out.println("New array"+foodtypearray);
		   arrayln= foodtypearray.size();
		  System.out.println(arrayln);
		  
		  
		  String artistfoodtypeid="";
		  for(int fsize=0;fsize<foodtypearray.size();fsize++)
		 	{
			  artistfoodtypeid=foodtypearray.get(fsize+1);
		 		 String foodtypename= foodtypearray.get(fsize+2);
		 		fsize=fsize+2;
		 		if(foodtypename.equalsIgnoreCase("Dinner"))
		 		{
		 			 
		 			fsize=foodtypearray.size();
		 			
		 		}
		 	}
		  String   wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		  wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			System.out.println(wbsarray+"array");
			int wbscount=0;
			String wbsdata=wbsarray.get(wbscount+1);
		  
		
				System.out.println(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
				 		+ "claimdate="+dtf.format(localDate)+""
				 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
				 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
		 String insertfoodcode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
		 		+ "claimdate="+dtf.format(localDate)+""
		 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
		 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
		
			  ArrayList<String> foodclaimarray = gdata.parseFromJSONarrayResponse(insertfoodcode);
			  System.out.println("New array"+foodclaimarray);
			   arrayln= foodclaimarray.size();
			   i=0;
			   String artistclaimid= foodclaimarray.get(i);
			   
			   return artistclaimid;
	}
	
	public void approvalfoodsteps(String ClaimId,String approvalAction) throws InterruptedException
	{
		{
			
			Thread.sleep(1000);
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdClaimApproval']")); 

				// Now get all the TR elements from the table 
				List<WebElement> allRows = table.findElements(By.tagName("tr")); 
		                          int size=allRows.size();
		                          System.out.println("Row count is"+size);
		                          int sizecell=0;
				// And iterate over them, getting the cells 
				for (WebElement row : allRows) { 
				    List<WebElement> cells = row.findElements(By.tagName("td")); 
				     sizecell=cells.size();
				    
				}
				 System.out.println("col count is"+sizecell);
				    for(int i=2; i<=size;i++)
				    {
				    	
				    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdClaimApproval']/tbody/tr["+i+"]/td[2]/span")).getText();
				    	System.out.println("claim is"+claim);
				    	if(claim.equalsIgnoreCase(ClaimId))
				    	{
				    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdClaimApproval']/tbody/tr["+i+"]/td[13]/span/input"));
				    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
				    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
				    	    i=size;
				    	}
				    	
				    	
				    }
				    if(approvalAction.equalsIgnoreCase("approve"))
				    {
				    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", foodapprove);
				    	//approve.click();
			    	    Thread.sleep(500);
//				    	Alert alertapprove = driver.switchTo().alert();
//						String alerttextapprove = driver.switchTo().alert().getText();
//						System.out.println(alerttextapprove);
//						assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Approve Claim?"));
//						alertapprove.accept();
//						Thread.sleep(500);
//						Alert alertapprovesuc = driver.switchTo().alert();
//						String alerttextapprovesuc = driver.switchTo().alert().getText();
//						System.out.println(alerttextapprovesuc);
//						assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));
//						alertapprovesuc.accept();
						
						 assertTrue(foodrejectsuccess.getText().equalsIgnoreCase("Claim Approved Successfully. !"));
						
				    }else if(approvalAction.equalsIgnoreCase("disapprove"))
				    {
				    	System.out.println("reject");
				    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", fooddisapprove);
			    	    
						Thread.sleep(500);
						assertTrue(foodrejectsuccess.getText().equalsIgnoreCase("Claim rejected successfully. !"));
						
					
						
				    }else if(approvalAction.equalsIgnoreCase("reopen"))
				    {
				    	
				    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", fooddisapprove);
			    	    fooddisapprove.click();
//						Thread.sleep(500);
//						Alert alertapprovesuc = driver.switchTo().alert();
//						String alerttextapprovesuc = driver.switchTo().alert().getText();
//						System.out.println(alerttextapprovesuc);
//						//assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//						alertapprovesuc.accept();
			    	
				    }
		}
	}
	
	
	public void editfoodsteps(String username,String password,String localid,String domain,String coemployee,String copass) throws InterruptedException
	{
		System.out.println(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+coemployee+"&PWD="+copass+"&domain="+domain);
		String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+coemployee+"&PWD="+copass+"&domain="+domain);


		ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
		int i=0;

		// String userData=array.get(i);
		// String passData=array.get(i+1);
		String empdata=array.get(i+2);
		// String message=array.get(i+3);
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
			 
			 for( i=2; i<=size;i++)
			    {
			    	
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    		String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[1]/span")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	if(claim.equalsIgnoreCase(localid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[12]/span/input"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	    System.out.println(">>>>>>>>>>>");
			    	}
			    	
			    	
			    }
			 
			
			 JavascriptExecutor jscalenderopen1 = (JavascriptExecutor) driver;
			 jscalenderopen1.
			 executeScript("var evt = document.createEvent('MouseEvents');" +
			 "evt.initMouseEvent" +
			 "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
			 + "arguments[0]" + ".dispatchEvent(evt);", driver.findElement(By.xpath("//input[@value="+empdata+"]")));
			
			
			
			
			travelAmount.clear();
			travelAmount.sendKeys("111");
			travelAmount.sendKeys(Keys.ENTER);
			waitForLoad(driver);
			travelremarks.clear();
			travelremarks.sendKeys("test");
			Thread.sleep(5000);
			
			uploadtravel.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
			travelremarks.sendKeys("test");
			
			Thread.sleep(5000);
			JavascriptExecutor	 jssubmit = (JavascriptExecutor) driver;
			jssubmit.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", updateFood);
			String successtext = foodsuccesstext.getText();
			assertTrue(successtext.equalsIgnoreCase("Food Claim updated Successfully. !"));
			 
			 
	}
	
	
	public void reopenfoodsteps(String localid) throws InterruptedException
	{
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
			    	if(claim.equalsIgnoreCase(localid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[14]/span/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			 
			
//				String successtext = updatefoodsuccesstext.getText();
//				System.out.println("successtext>>>>"+successtext);
//				assertTrue(successtext.equalsIgnoreCase("Claim Reopened Successfully."));
				assertTrue(reopenfoodsuccess.getText().equalsIgnoreCase("Claim Reopened Successfully. !"));
				//alert1.accept();
	}
	
	public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
	
}
