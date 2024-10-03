package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Browsers.Urls;
import Data.captureData;

public class ActualActivityPage extends Urls {
	
WebDriver driver;
	
	public ActualActivityPage(WebDriver driver){
		
		this.driver=driver;
	}
	captureData gdata = new  captureData();
	
	@FindBy(xpath="//*[@id=\"make-small-nav\"]/i[1]")
	WebElement menuIcon;
//	@FindBy(xpath="//*[@id=\"ctl00_ulRecommender\"]/a[1]/span[1]")
//	WebElement aprove1;
	
	@FindBy(xpath="//*[contains(text(),'Approve claims')]")
	WebElement aprove1;
	
	@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl04_RptSubMenu_ctl00_lnkSubMenu\"]")
	WebElement aprove2;  
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_liActual\"]")
	WebElement atualactivtytab;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtReason\"]")
	WebElement enterreason;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnApprove\"]")
	WebElement approvebutton;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnDissapprove\"]")
	WebElement disapprovebutton;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnReopenActualActivity\"]")
	WebElement reopenbutton;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_liActual\"]")
	WebElement clickactualtab;
	
	@FindBy(xpath="//input[@value='Activity']")
	WebElement ativity1;
//	@FindBy(xpath="//*[@id='ctl00_rptMainMenu_ctl03_aDLink']/a/span[1]")
//	WebElement ativity1;
	//*[@id="ctl00_rptMainMenu_ctl03_aDLink"]/a/span[1]
	@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl03_RptSubMenu_ctl00_lnkSubMenu\"]")
	WebElement ativity2;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_liActual\"]")
	WebElement actualtab;
	//*[@id="ctl00_ContentPlaceHolder1_liActual"]
	
	
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlYear\"]")
	WebElement yearelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlMonth\"]")
	WebElement monthelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlActivityIDEstimated\"]")
	WebElement actvtidelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtActualActivityDate\"]")
	WebElement dateofactivityelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtVenueActual\"]")
	WebElement venueelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtTopicActual\"]")
	WebElement topicactivityelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtSpeakerActual\"]")
	WebElement speakeractualelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtNoOfParticipantsActual\"]")
	WebElement noOfparticipentselement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtPaymentFavourActual\"]")
	WebElement paymentfavelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtEstHotelAmt\"]")
	WebElement approvedhotelelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtActualHotelAmt\"]")
	WebElement actualhotelelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtEstFoodAmt\"]")
	WebElement approvedfoodelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtActualFoodAmt\"]")
	WebElement actualfoodelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtEstLCDAmt\"]")
	WebElement approvedlcdellement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtActualLCDAmt\"]")
	WebElement actuallcdellement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtEstTravelAmt\"]")
	WebElement approvedtravelelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtActualTravelAmt\"]")
	WebElement actualtravelelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtEstSpeakerAmt\"]")
	WebElement approvedspeakerelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtActualSpeakerAmt\"]")
	WebElement actualspeakerelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtEstOthersAmt\"]")
	WebElement approvedotherelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtActualOthersAmt\"]")
	WebElement actualotherelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtEstRegFeesAmt\"]")
	WebElement approvedregfeeselement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtActualRegFees\"]")
	WebElement actualregfeeselement;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_chkDocumentedEventHCPTravelApprovalForm\"]")
	WebElement checkbox1element;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_chkSentInvitationsAttendees\"]")
	WebElement checkbox2element;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_chkRegisterUpdates\"]")
	WebElement checkbox3element;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_chkAttendanceProof\"]")
	WebElement checkbox4element;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_chkInvoicesItemized\"]")
	WebElement checkbox5element;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_flpActualAttendance_Html5InputFile\"]")
	WebElement attendanceselectfileelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_flpActualPhotoes_Html5InputFile\"]")
	WebElement photosselectfileelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_flpActualBills_Html5InputFile\"]")
	WebElement billsselectfileelement;
	
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_flpActualAttendance_UploadOrCancelButton\"]")
	WebElement uploadattendanceelelemnt;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_flpActualPhotoes_UploadOrCancelButton\"]")
	WebElement uploadphotoselement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_flpActualBills_UploadOrCancelButton\"]")
	WebElement uploadbillselement;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnDraftActualActivity\"]")
	WebElement savedraftbutton;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_liActual\"]")
	WebElement actualactivitytab;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_imgeditActual\"]")
	WebElement editactualicon;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnUpdateActualActivity\"]")
	WebElement updatebutton;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_imgDeleteActual\"]")
	WebElement deleteicon;
	
	Calendar current = Calendar.getInstance();
	
	
	
	public void navigattoactualactivty() throws InterruptedException
	{
		Thread.sleep(1000);
		//menuIcon.click();
		JavascriptExecutor menuicons = (JavascriptExecutor) driver;
		menuicons.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", menuIcon);
		JavascriptExecutor ativityjs1 = (JavascriptExecutor) driver;
		ativityjs1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", ativity1);
		JavascriptExecutor ativityjs2 = (JavascriptExecutor) driver;
		ativityjs2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", ativity2);
		
		 ativityjs2 = (JavascriptExecutor) driver;
		ativityjs2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", actualtab);
	}
	public void navigattoapproveactualactivty() throws InterruptedException
	{
		Thread.sleep(1000);
		//menuIcon.click();
		JavascriptExecutor menuicons = (JavascriptExecutor) driver;
		menuicons.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", menuIcon);
		JavascriptExecutor ativityjs1 = (JavascriptExecutor) driver;
		ativityjs1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", aprove1);
		
		JavascriptExecutor ativityjs2 = (JavascriptExecutor) driver;
		ativityjs2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", aprove2);
		Thread.sleep(10000);
		JavascriptExecutor ativityjs3 = (JavascriptExecutor) driver;
		ativityjs3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", atualactivtytab);
		
	}
	public void addActualAtivityAPI(String EmployeeuserName,String EmployeepassWord,String activityid )
	{
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+"&Domain=fulcrum");
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 String empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
		System.out.println(empdata);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate	 localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		System.out.println(BaseUrl+"/api/Actual/InsertActualClaim?intActivityID="+activityid+"&dtActivity="+dtf.format(localDate)+""
		 		+ "&intActivityType=1747&vcVenue=test&vcTopic=test&vcSpeaker=test&intNoOfParticipants=3&vcPaymentFavour=&numHotelVenueAmt=100"
		 		+ "&numFoodAmt=100&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100&numTotalAmt=500&intEmp="+empdata+""
		 		+ "&numRegistrationFees=100&intIsEventHCPTravelFormDocumented=1&intIsInvitationSentToAttendees=1"
		 		+ "&intIsRegisterUpdatesOfInvitedHCP=1&intIsProofOfAttendeesAttached=1&intIsDetailedInvoicesItemized=1&Domain=fulcrum");
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/Actual/InsertActualClaim?intActivityID="+activityid+"&dtActivity="+dtf.format(localDate)+""
		 		+ "&intActivityType=1747&vcVenue=test&vcTopic=test&vcSpeaker=test&intNoOfParticipants=3&vcPaymentFavour=paresh&numHotelVenueAmt=100"
		 		+ "&numFoodAmt=100&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100&numTotalAmt=500&intEmp="+empdata+""
		 		+ "&numRegistrationFees=100&intIsEventHCPTravelFormDocumented=1&intIsInvitationSentToAttendees=1"
		 		+ "&intIsRegisterUpdatesOfInvitedHCP=1&intIsProofOfAttendeesAttached=1&intIsDetailedInvoicesItemized=1&Domain=fulcrum");
		
	
		 ArrayList<String> array = gdata.parseFromJSONResponse(userresponse1);
	
		  i=0;
		
		
		 String actualactivityid=array.get(i+22);
		 System.out.println(activityid);
		// return activityid;
	}
	
	
	public void submitAtualActivityAPI(String activityid )
	{ 
		TestData.GetData gdata1 = new  TestData.GetData();
		System.out.println(BaseUrl+"/api/ActivitySubmit/SubmitActivity?activityid="+activityid+"&isactual=0&Domain=fulcrum");
		 gdata1.getContenxtWeb(BaseUrl+"/api/ActivitySubmit/SubmitActivity?activityid="+activityid+"&isactual=1&Domain=fulcrum");
	}
	
	public void approveActualActivity(String approvalname1,String approvalpassword1, String ativityid,String action) throws InterruptedException
	{
		
		
		if(action.equalsIgnoreCase("approve"))
		{
		
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+approvalname1+"&PWD="+approvalpassword1+"&Domain=fulcrum");
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 String empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
		System.out.println(empdata);
		
		 Thread.sleep(10000);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
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
			    for( i=2; i<=size;i++)
			    {
			    	
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    		String claim=driver.findElement(By.xpath(".//*[@id='table2']/tbody/tr["+i+"]/td[2]/span/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	System.out.println("Activity" +ativityid);
			    	System.out.println(claim);

			    	if(claim.equalsIgnoreCase("Activity " +ativityid))
			    	{
			    		
				    	System.out.println("Inside if"+claim);

			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table2']/tbody/tr["+i+"]/td[2]/span/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    Thread.sleep(10000);
			    enterreason.sendKeys("test");
			    approvebutton.click();
			    Thread.sleep(10000);
			    Alert alertconfirm2 = driver.switchTo().alert();
				String alerttextconfirm2 = driver.switchTo().alert().getText();
				System.out.println(alerttextconfirm2);
				String verifytext="Are you sure you want to approve this claim?";
				//assertTrue(alerttextconfirm2.equalsIgnoreCase(verifytext));
				alertconfirm2.accept();
				Thread.sleep(10000);
				Alert alertsuccess = driver.switchTo().alert();
				String alerttextsuccess1 = driver.switchTo().alert().getText();
				System.out.println("Activity " +ativityid+"Approved successfully");
				//assertTrue(alerttextsuccess1.equalsIgnoreCase("Activity " +ativityid+" Approved successfully"));
				alertsuccess.accept();
				
		}else if(action.equalsIgnoreCase("reject")) {
			
			

			
			{
			
			TestData.GetData gdata1 = new  TestData.GetData();
			 String userresponse = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+approvalname1+"&PWD="+approvalpassword1+"&Domain=fulcrum");
			
		
			 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse);
			 int i=0;
			
			 String userData=array1.get(i);
			 String passData=array1.get(i+1);
			 String empdata=array1.get(i+2);
			 String bandid=array1.get(i+3);
			System.out.println(empdata);
			
			 Thread.sleep(10000);
				//WebDriverWait wait  = new WebDriverWait(driver, 10);
			//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
				// claimidlocator.click();
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
				    for( i=2; i<=size;i++)
				    {
				    	
				    		
				    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
				    		String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis3']/tbody/tr["+i+"]/td[2]/span/a")).getText();
				    	System.out.println("This is claim i am looking"+claim);
				    	System.out.println("Activity" +ativityid);
				    	System.out.println(claim);

				    	if(claim.equalsIgnoreCase("Activity " +ativityid))
				    	{
				    		
					    	System.out.println("Inside if"+claim);

				    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis3']/tbody/tr["+i+"]/td[2]/span/a"));
				    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
				    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
				    	    i=size;
				    	}
				    	
				    	
				    }
				    Thread.sleep(10000);
				    enterreason.sendKeys("test");
				    JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprovebutton);
				   // disapprovebutton.click();
		    	    Thread.sleep(10000);
				    Alert alertconfirm2 = driver.switchTo().alert();
					String alerttextconfirm2 = driver.switchTo().alert().getText();
					System.out.println(alerttextconfirm2);
					String verifytext="Are you sure you want to approve this claim?";
					//assertTrue(alerttextconfirm2.equalsIgnoreCase(verifytext));
					alertconfirm2.accept();
					Thread.sleep(10000);
					Alert alertsuccess = driver.switchTo().alert();
					String alerttextsuccess1 = driver.switchTo().alert().getText();
					System.out.println("Activity " +ativityid+"Approved successfully");
					//assertTrue(alerttextsuccess1.equalsIgnoreCase("Activity " +ativityid+" Approved successfully"));
					alertsuccess.accept();
			
			}
			
		}
			    
	}
	
	
	public void reopenactualactivity(String ativityid) throws InterruptedException
	{
		 Thread.sleep(10000);
		JavascriptExecutor menuicons = (JavascriptExecutor) driver;
		menuicons.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", clickactualtab);
		 Thread.sleep(1000);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tab2']")); 

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
			    		String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis3']/tbody/tr["+i+"]/td[2]/span/h7/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	System.out.println("Activity" +ativityid);
			    	System.out.println(claim);

			    	if(claim.equalsIgnoreCase("Activity " +ativityid))
			    	{
			    		
				    	System.out.println("Inside if"+claim);

			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis3']/tbody/tr["+i+"]/td[2]/span/h7/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    Thread.sleep(10000);
			    JavascriptExecutor submitjs = (JavascriptExecutor) driver;
			    submitjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", reopenbutton);
			    Alert alertconfirm = driver.switchTo().alert();
				String alerttextconfirm = driver.switchTo().alert().getText();
				System.out.println(alerttextconfirm);
				//assertTrue(alerttextconfirm.equalsIgnoreCase("Are you sure you want to submit claim?"));
				alertconfirm.accept();
				
				
				 Thread.sleep(5000);
				Alert alertsuccess = driver.switchTo().alert();
				String alerttextsuccess1 = driver.switchTo().alert().getText();
				System.out.println(alerttextsuccess1);
				//assertTrue(alerttextsuccess1.equalsIgnoreCase("Activity Submitted Successfully"));
				alertsuccess.accept();
		
	}

    public void applyactualactivitysteps(String Month
    		,String year,String id,String activity,String dateofactivity,String venueofactivity,String topicofactivity,String speakerofactivity,String noofpart,
    		String paymentinfav,String ahotel,String actualhotel,String afood,String actualfood,String alcd,String actuallcd,String atravel,String actualtravel,
    		String aspeaker,String actualspeaker,String aothers,String actualothers,String aregfees,String actualregfees) throws InterruptedException
    {
    	
    	if(!(dateofactivity==null))
    	{
    		JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
    		jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
    				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
    					+ ".dispatchEvent(evt);", dateofactivityelement);
    		//opendate.click();
    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
    		LocalDate	 localDate = LocalDate.now();
    		System.out.println(dtf.format(localDate));
    		JavascriptExecutor jscalenderdate = (JavascriptExecutor) driver;
    		jscalenderdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
    				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
    						+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='"+dtf.format(localDate)+"']")));
    	}else {
    		
    	}
    
    	
    
    	Select syear =new Select(yearelement);
    	syear.selectByValue(String .valueOf(current.get(Calendar.YEAR)));
    	Select smonth =new Select(monthelement);
    	smonth.selectByValue(String .valueOf(current.get(Calendar.MONTH)+1));
    	
    	Select sactivityid =new Select(actvtidelement);
    	sactivityid.selectByValue(id);
    	Thread.sleep(5000);
    	speakeractualelement.sendKeys(speakerofactivity);
    	noOfparticipentselement.sendKeys(noofpart);
    	paymentfavelement.sendKeys(paymentinfav);
    	
    	System.out.println(venueofactivity+topicofactivity);
    	System.out.println(venueelement.getAttribute("value")+topicactivityelement.getAttribute("value"));
    	assertTrue(venueofactivity.equalsIgnoreCase(venueelement.getAttribute("value")));
    	assertTrue(topicofactivity.equalsIgnoreCase(topicactivityelement.getAttribute("value")));
    	
    	assertTrue(ahotel.equalsIgnoreCase(approvedhotelelement.getAttribute("value")));
    	actualhotelelement.sendKeys(actualhotel);
    	assertTrue(afood.equalsIgnoreCase(approvedfoodelement.getAttribute("value")));
    	actualfoodelement.sendKeys(actualfood);
    	assertTrue(alcd.equalsIgnoreCase(approvedlcdellement.getAttribute("value")));
    	actuallcdellement.sendKeys(actuallcd);
    	assertTrue(atravel.equalsIgnoreCase(approvedtravelelement.getAttribute("value")));
    	actualtravelelement.sendKeys(actualtravel);
    	assertTrue(aspeaker.equalsIgnoreCase(approvedspeakerelement.getAttribute("value")));
    	actualspeakerelement.sendKeys(actualspeaker);
    	assertTrue(aothers.equalsIgnoreCase(approvedotherelement.getAttribute("value")));
    	actualotherelement.sendKeys(actualothers);
    	assertTrue(aregfees.equalsIgnoreCase(approvedregfeeselement.getAttribute("value")));
    	actualregfeeselement.sendKeys(actualregfees);
    	
    	
    	JavascriptExecutor jscheck = (JavascriptExecutor) driver;
		jscheck.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", checkbox1element);
		
		
		JavascriptExecutor jscheck1 = (JavascriptExecutor) driver;
		jscheck1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", checkbox2element);
		JavascriptExecutor jscheck2 = (JavascriptExecutor) driver;
		jscheck2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", checkbox3element);
		JavascriptExecutor jscheck3 = (JavascriptExecutor) driver;
		jscheck3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", checkbox4element);
		JavascriptExecutor jscheck4 = (JavascriptExecutor) driver;
		jscheck4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", checkbox5element);
		
		attendanceselectfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
		
	
		
		
		JavascriptExecutor jsupload1 = (JavascriptExecutor) driver;
		jsupload1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", uploadattendanceelelemnt);
		
		Thread.sleep(1500);
		photosselectfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
		JavascriptExecutor jsupload2 = (JavascriptExecutor) driver;
		jsupload2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", uploadphotoselement);
		Thread.sleep(1500);
		billsselectfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
		JavascriptExecutor jsupload3 = (JavascriptExecutor) driver;
		jsupload3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", uploadbillselement);
		
		Thread.sleep(3000);
		
		JavascriptExecutor jssavebutton = (JavascriptExecutor) driver;
		jssavebutton.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", savedraftbutton);
					Thread.sleep(15000);
					Alert alert = driver.switchTo().alert();
					String alerttext =alert.getText();
					assertTrue(alerttext.equalsIgnoreCase("Actual activity added successfully!"));
					alert.accept();
					
		
    }
   
    public void editactualactivitysteps(String Month
    		,String year,String id,String activity,String dateofactivity,String venueofactivity,String topicofactivity,String speakerofactivity,String noofpart,
    		String paymentinfav,String ahotel,String actualhotel,String afood,String actualfood,String alcd,String actuallcd,String atravel,String actualtravel,
    		String aspeaker,String actualspeaker,String aothers,String actualothers,String aregfees,String actualregfees) throws InterruptedException
    {
    	 Thread.sleep(10000);
 		JavascriptExecutor menuicons = (JavascriptExecutor) driver;
 		menuicons.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
 				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
 						+ ".dispatchEvent(evt);", clickactualtab);
 		 Thread.sleep(1000);
 			//WebDriverWait wait  = new WebDriverWait(driver, 10);
 		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
 			// claimidlocator.click();
 			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tab2']")); 

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
 			    		String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis3']/tbody/tr["+i+"]/td[2]/span/h7/a")).getText();
 			    	System.out.println("This is claim i am looking"+claim);
 			    	System.out.println("Activity" +id);
 			    	System.out.println(claim);

 			    	if(claim.equalsIgnoreCase("Activity " +id))
 			    	{
 			    		
 				    	System.out.println("Inside if"+claim);

 			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis3']/tbody/tr["+i+"]/td[2]/span/h7/a"));
 			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
 			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
 			    	    i=size;
 			    	}
 			    	
 			    }
 				 Thread.sleep(3000); 
	    		JavascriptExecutor jsedit = (JavascriptExecutor) driver;
	    		jsedit.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", editactualicon);
	    		 Thread.sleep(3000); 
 			  venueelement.clear();
 			  venueelement.sendKeys("tt");
 			  topicactivityelement.clear();
 			  topicactivityelement.sendKeys(topicofactivity);
 			  speakeractualelement.clear();
 			  speakeractualelement.sendKeys(speakerofactivity);
 			  noOfparticipentselement.clear();
 			  noOfparticipentselement.sendKeys(noofpart);
 			  
 			  
 	    	actualhotelelement.sendKeys(actualhotel);
 	    	actualfoodelement.sendKeys(actualfood);
 	    	actuallcdellement.sendKeys(actuallcd);
 	    	actualtravelelement.sendKeys(actualtravel);
 	    	actualspeakerelement.sendKeys(actualspeaker);
 	    	actualotherelement.sendKeys(actualothers);
 	    	actualregfeeselement.sendKeys(actualregfees);
 			  
 	    	
 	    	//
 	    	JavascriptExecutor jscheck1 = (JavascriptExecutor) driver;
 			jscheck1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
 					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
 						+ ".dispatchEvent(evt);", checkbox2element);
 			JavascriptExecutor jscheck2 = (JavascriptExecutor) driver;
 			jscheck2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
 					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
 						+ ".dispatchEvent(evt);", checkbox3element);
 			JavascriptExecutor jscheck3 = (JavascriptExecutor) driver;
 			jscheck3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
 					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
 						+ ".dispatchEvent(evt);", checkbox4element);
 			JavascriptExecutor jscheck4 = (JavascriptExecutor) driver;
 			jscheck4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
 					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
 						+ ".dispatchEvent(evt);", checkbox5element);
 			
 			
 			
 			
 			
 			attendanceselectfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
 			
 		
 			
 			
 			JavascriptExecutor jsupload1 = (JavascriptExecutor) driver;
 			jsupload1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
 					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
 						+ ".dispatchEvent(evt);", uploadattendanceelelemnt);
 			
 			Thread.sleep(1500);
 			photosselectfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
 			JavascriptExecutor jsupload2 = (JavascriptExecutor) driver;
 			jsupload2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
 					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
 						+ ".dispatchEvent(evt);", uploadphotoselement);
 			Thread.sleep(1500);
 			billsselectfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
 			JavascriptExecutor jsupload3 = (JavascriptExecutor) driver;
 			jsupload3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
 					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
 						+ ".dispatchEvent(evt);", uploadbillselement);
 			
 			Thread.sleep(3000);
 			  
 			Thread.sleep(3000);
 			
 			JavascriptExecutor jssavebutton = (JavascriptExecutor) driver;
 			jssavebutton.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
 					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
 						+ ".dispatchEvent(evt);", updatebutton);
 						Thread.sleep(15000);
 						Alert alert = driver.switchTo().alert();
 						String alerttext =alert.getText();
 						assertTrue(alerttext.equalsIgnoreCase("Activity details updated successfully !!"));
 						alert.accept();
 			  
    }
  
    public void deleteactualactivitysteps(String Month
    		,String year,String id,String activity,String dateofactivity,String venueofactivity,String topicofactivity,String speakerofactivity,String noofpart,
    		String paymentinfav,String ahotel,String actualhotel,String afood,String actualfood,String alcd,String actuallcd,String atravel,String actualtravel,
    		String aspeaker,String actualspeaker,String aothers,String actualothers,String aregfees,String actualregfees) throws InterruptedException
    {
    	 Thread.sleep(10000);
 		JavascriptExecutor menuicons = (JavascriptExecutor) driver;
 		menuicons.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
 				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
 						+ ".dispatchEvent(evt);", clickactualtab);
 		 Thread.sleep(1000);
 			//WebDriverWait wait  = new WebDriverWait(driver, 10);
 		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
 			// claimidlocator.click();
 			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tab2']")); 

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
 			    		String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis3']/tbody/tr["+i+"]/td[2]/span/h7/a")).getText();
 			    	System.out.println("This is claim i am looking"+claim);
 			    	System.out.println("Activity" +id);
 			    	System.out.println(claim);

 			    	if(claim.equalsIgnoreCase("Activity " +id))
 			    	{
 			    		
 				    	System.out.println("Inside if"+claim);

 			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis3']/tbody/tr["+i+"]/td[2]/span/h7/a"));
 			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
 			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
 			    	    i=size;
 			    	}
 			    	
 			    }
 				 Thread.sleep(3000); 
	    		JavascriptExecutor jsedit = (JavascriptExecutor) driver;
	    		jsedit.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, "
	    				+ "true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", deleteicon);
	    		 Thread.sleep(3000); 
	    		
					Alert alert = driver.switchTo().alert();
					String alerttext =alert.getText();
					assertTrue(alerttext.equalsIgnoreCase("Details Deleted Successfully !!"));
					alert.accept();
 			  
    }
}
