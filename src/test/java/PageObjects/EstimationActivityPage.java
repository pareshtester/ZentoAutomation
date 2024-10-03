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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browsers.Urls;
import Data.captureData;

public class EstimationActivityPage extends Urls {
	
	
	
	   //String empdata=null;
WebDriver driver;

captureData gdata = new  captureData();
	
	public EstimationActivityPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	@FindBy(xpath="//*[@id=\"make-small-nav\"]/i[1]")
	WebElement menuIcon;
	@FindBy(xpath="//*[@id='ctl00_rptMainMenu_ctl03_aDLink']/span[1]")
	WebElement ativity1;
	////*[@id="ctl00_rptMainMenu_ctl03_aDLink"]/span[1]
	@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl03_RptSubMenu_ctl00_lnkSubMenu\"]")
	WebElement ativity2;
	//*[@id="ctl00_rptMainMenu_ctl03_RptSubMenu_ctl00_lnkSubMenu"]/ul[1]/li[1]/a[1]
	
	//add estimation activity
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtHCPName\"]")
	WebElement hcpname;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtEmployerHCO\"]")
	WebElement employer;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtWorkPlace\"]")
	WebElement placeofwork;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtHCPSelectionCriteria\"]")
	WebElement selectioncriteria;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtHCPFlags\"]")
	WebElement hcpflags;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtFoodAmt\"]")
	WebElement meals;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtHotelVenueAmt\"]")
	WebElement loadging;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtRegFees\"]")
	WebElement registrationfees;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtTravelAmt\"]")
	WebElement travel;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtLCDAudioVideoAmt\"]")
	WebElement audiovideo;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtSpeakerAmt\"]")
	WebElement speaker;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtOthersAmt\"]")
	WebElement other;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtNoOfInvitees\"]")
	WebElement noofinvities;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtEventName\"]")
	WebElement eventname;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtDate\"]")
	WebElement opendate;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtCountryVenue\"]")
	WebElement eventountry;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlActivityType\"]")    
	WebElement typeofactivity;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_rblEventOrganizer_0\"]")
	WebElement eventorganizer;
	//*[@id="ctl00_ContentPlaceHolder1_rblEventOrganizer"]/tbody[1]/tr[1]/td[1]/span[1]/label[1]
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtVenueSelectionCriteria\"]")
	WebElement venueselectioncriteria;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtAgendaPurpose\"]")
	WebElement agendapurpose;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnDraftEstActivity\"]")
	WebElement savedraft;
	
	//Claim submit
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnFrmBSubmitEstActivity\"]")
	WebElement submit;
	
	//Approve navigation
	
	@FindBy(xpath="//*[contains(text(),'Approve claims')]")
	WebElement aprove1;
	@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl04_RptSubMenu_ctl00_lnkSubMenu\"]")
	WebElement aprove2;  
	Calendar current = Calendar.getInstance();
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtReason\"]")
	WebElement enterreason;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnApprove\"]")
	WebElement approvebutton;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVHCPName\"]")
	WebElement HCPNameerror;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVEmployer\"]")
	WebElement EmpHCoerror;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVWorkPlace\"]")
	WebElement Plcofwrkerror;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVHCPSelectionCriteria\"]")
	WebElement HCPSelectionerror;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVHCPFlags\"]")
	WebElement HCPflagerror;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVNoOfInvitees\"]")
	WebElement inviteenumerror;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVEventName\"]")
	WebElement eventnmerror;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVDate\"]")
	WebElement eventdterror;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVAgendaPurpose\"]")
	WebElement eventagendaerror;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVVenueSelectionCriteria\"]")
	WebElement venueselectionerror;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVActivityType\"]")
	WebElement typeofactivityerror;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVCountryVenue\"]")
	WebElement eventcountryvenueerror;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVEventOrganizer\"]")
	WebElement eventorganizererror;
	
	
	
	public void navigateToactivitypage() throws InterruptedException
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
	}
	public void navigateToapprovepage() throws InterruptedException
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
	}
	
	
	public void addestimationactivity(String EmployeeuserName,String EmployeepassWord,String domainname,String HCPName,String EmpHCO,String placeofwrk,String HCPselection,String HCPFlag,String inviteenum,String EventName,String EventDate,String EventcountryVenue,String Typeofactivity,String EventOrganizer,String VenueSelection,String EventAgenda) throws InterruptedException

	
	{
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+""
			 		+ "&PWD="+EmployeepassWord+"&Domain="+domainname+"");
		 ArrayList<String> array1 = gdata.parseFromJSONResponse(userresponse);
		int i=0;
		String	 empdata=array1.get(i+2);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(!(HCPName==null))
		{
		hcpname.sendKeys(HCPName);
		}
		if(!(EmpHCO==null))
		{
		employer.sendKeys(EmpHCO);
		}
		if(!(placeofwrk==null))
		{
		placeofwork.sendKeys(placeofwrk);
		}
		if(!(HCPselection==null))
		{
		selectioncriteria.sendKeys(HCPselection);
		}
		if(!(HCPFlag==null))
		{
		hcpflags.sendKeys(HCPFlag);
		}
		meals.sendKeys("200");
		meals.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(loadging));
		loadging.sendKeys("200");
		loadging.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(registrationfees));
		registrationfees.sendKeys("300");
		registrationfees.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(travel));
		travel.sendKeys("200");
		travel.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(audiovideo));
		audiovideo.sendKeys("300");
		audiovideo.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(speaker));
		speaker.sendKeys("200");
		speaker.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(other));
		other.sendKeys("200");
		other.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(noofinvities));
		if(!(inviteenum==null))
		{
		noofinvities.sendKeys(inviteenum);
		noofinvities.sendKeys(Keys.ENTER);
		}
		Thread.sleep(5000);
		if(!(EventName==null))
		{
		eventname.sendKeys("test");
		}
		
		
		
		
		
		if(!(EventDate==null))
				{
		
		JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
		jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", opendate);
		//opendate.click();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
		LocalDate	 localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		JavascriptExecutor jscalenderdate = (JavascriptExecutor) driver;
		jscalenderdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='"+dtf.format(localDate)+"']")));
				}
		
		if(!(EventcountryVenue==null))
		{
		eventountry.sendKeys(EventcountryVenue);
		}
		//BaseUrl+"/api/LoadTravelMode/GetTravelMode?empid="+empdata+"&"
 		//+ "fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqid+"&workType="+workid+"&Domain="+domain+""
		//http://192.168.1.102:81/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid=4202&Domain=fulcrum
		
		 userresponse=gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domainname+"");
			 ArrayList<String>  arraytypeofwrk = gdata.parseFromJSONarrayResponse(userresponse);	
			  System.out.println("Type of activity is >>>>>>>>>>>>>"+arraytypeofwrk);	
			  String typeofactivityid="";
			  String typeofactivitytext="";
			  
			  
			  for( i =0; i<=arraytypeofwrk.size();i++)
			  {
				  typeofactivityid=arraytypeofwrk.get(i);
				  typeofactivitytext=arraytypeofwrk.get(i+1);
				  
				  				  
				  if(typeofactivitytext.equalsIgnoreCase(Typeofactivity))
				  {
					  i=arraytypeofwrk.size();
				  }
				  
				 // if(newtravelid)
			  }
		
		System.out.println("typeofactivityid"+typeofactivityid);
		System.out.println("typeofactivitytext"+typeofactivitytext);
		
//		Select selecttactivity = new Select(typeofactivity);
//		selecttactivity.selectByValue(typeofactivityid);
		
		
		if(typeofactivitytext.equalsIgnoreCase("0")) {
			Thread.sleep(1000);
			Select travelmode= new Select(typeofactivity);
			travelmode.selectByValue(typeofactivityid);
			Thread.sleep(1000);
			JavascriptExecutor jssavedraft = (JavascriptExecutor) driver;
			jssavedraft.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", savedraft);
			
			System.out.println(typeofactivityerror.getText());
			assertTrue(typeofactivityerror.getText().equalsIgnoreCase("*"));
			
				
			}else {
				Select selecttactivity = new Select(typeofactivity);
				selecttactivity.selectByValue(typeofactivityid);
			}
		
		
		Thread.sleep(1000);
		if(!(EventOrganizer==null))
				{
		JavascriptExecutor jsrr = (JavascriptExecutor) driver;
		jsrr.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", eventorganizer);
				}
//		eventorganizer.click();
		
		Thread.sleep(1000);
		if(!(VenueSelection==null))
		{
		venueselectioncriteria.sendKeys(VenueSelection);
		}
		if(!(EventAgenda==null))
		{
		agendapurpose.sendKeys(EventAgenda);
		}
		
		
		if(HCPName==null && EmpHCO==null && placeofwrk==null && HCPselection==null && HCPFlag==null && inviteenum==null && EventName==null && EventDate==null && EventcountryVenue==null && EventOrganizer==null && VenueSelection==null && EventAgenda==null)
		
		{
			System.out.println("Inside Mandatory");
			JavascriptExecutor savedraftjs = (JavascriptExecutor) driver;
			savedraftjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", savedraft);
			
			Thread.sleep(5000);
			System.out.println(HCPNameerror.getText());
			assertTrue(HCPNameerror.getText().equalsIgnoreCase("*"));
			
			System.out.println(EmpHCoerror.getText());
			assertTrue(EmpHCoerror.getText().equalsIgnoreCase("*"));
			
			System.out.println(Plcofwrkerror.getText());
			assertTrue(Plcofwrkerror.getText().equalsIgnoreCase("*"));
			
			System.out.println(HCPSelectionerror.getText());
			assertTrue(HCPSelectionerror.getText().equalsIgnoreCase("*"));
			
			System.out.println(HCPflagerror.getText());
			assertTrue(HCPflagerror.getText().equalsIgnoreCase("*"));
			
			System.out.println(inviteenumerror.getText());
			assertTrue(inviteenumerror.getText().equalsIgnoreCase("*"));
			
			System.out.println(eventnmerror.getText());
			assertTrue(eventnmerror.getText().equalsIgnoreCase("*"));
			
			System.out.println(eventdterror.getText());
			assertTrue(eventdterror.getText().equalsIgnoreCase("*"));
			Thread.sleep(1000);
			System.out.println(eventcountryvenueerror.getText());
			assertTrue(eventcountryvenueerror.getText().equalsIgnoreCase("*"));
			
			System.out.println(eventorganizererror.getText());
			assertTrue(eventorganizererror.getText().equalsIgnoreCase("*"));
			
			System.out.println(venueselectionerror.getText());
			assertTrue(venueselectionerror.getText().equalsIgnoreCase("*"));
			
			System.out.println(eventagendaerror.getText());
			assertTrue(eventagendaerror.getText().equalsIgnoreCase("*"));
			
		}
		else {
		JavascriptExecutor savedraftjs = (JavascriptExecutor) driver;
		savedraftjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", savedraft);
		Thread.sleep(1000);
		Alert alertsuccess = driver.switchTo().alert();
		String alerttextsuccess1 = driver.switchTo().alert().getText();
		System.out.println(alerttextsuccess1);
		assertTrue(alerttextsuccess1.equalsIgnoreCase("Activity claim added successfully. !!"));
		alertsuccess.accept();
		}
	}

	
	public String addestimationdatailsapi(String EmployeeuserName,String EmployeepassWord )
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
		
		
		
		
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?dtActivity="+dtf.format(localDate)+"&intActivityType=1747"
		 		+ "&vcVenue=test&vcTopic=test&vcSpeaker=test&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
		 		+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100&numTotalAmt=100&intEmp="+empdata+""
		 		+ "&intEventOrganizer=12&vcEventOrganizerDetails=&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
		 		+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1&intHCPDecision=1&intEmployerMedicalBoard=1"
		 		+ "&intHCPEmployerFormalWrittenRequest=1&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
		 		+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1"
		 		+ "&vcEventName=1&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1&intClusterThreshold=1&Domain=fulcrum");
		
	
		 ArrayList<String> array = gdata1.parseFromJSONResponse(userresponse1);
	
		  i=0;
		
		
		 String activityid=array.get(i+21);
		 System.out.println(activityid);
		 return activityid;
			}
	
	
	
	public void submitestimationactivity(String ativityid) throws InterruptedException
	{
		
		 Thread.sleep(10000);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tab1']")); 

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
			    		String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis2']/tbody/tr["+i+"]/td[2]/span/h7/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	System.out.println("Activity" +ativityid);
			    	System.out.println(claim);

			    	if(claim.equalsIgnoreCase("Activity " +ativityid))
			    	{
			    		
				    	System.out.println("Inside if"+claim);

			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis2']/tbody/tr["+i+"]/td[2]/span/h7/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    Thread.sleep(10000);
			    JavascriptExecutor submitjs = (JavascriptExecutor) driver;
			    submitjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", submit);
			    Alert alertconfirm = driver.switchTo().alert();
				String alerttextconfirm = driver.switchTo().alert().getText();
				System.out.println(alerttextconfirm);
				assertTrue(alerttextconfirm.equalsIgnoreCase("Are you sure you want to submit claim?"));
				alertconfirm.accept();
				
				
				 Thread.sleep(1000);
				Alert alertsuccess = driver.switchTo().alert();
				String alerttextsuccess1 = driver.switchTo().alert().getText();
				System.out.println(alerttextsuccess1);
				assertTrue(alerttextsuccess1.equalsIgnoreCase("Activity Submitted Successfully"));
				alertsuccess.accept();
				
				
				
				
	}
	
	
	public void approveEstimationActivity(String approvalname1,String approvalpassword1, String ativityid) throws InterruptedException
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
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tab1']")); 

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
				System.out.println(size);
			    for( i=2; i<=size;i++)
			    {
			    	System.out.println("return");
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    		String claim=driver.findElement(By.xpath(".//*[@id='table-two-axis2']/tbody/tr["+i+"]/td[2]/span/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	//System.out.println("Activity"+ativityid);
			    	System.out.println("Activity "+ativityid);

			    	System.out.println(claim);

			    	if(claim.equalsIgnoreCase("Activity "+ativityid))
			    	{
			    		
				    	System.out.println("Inside if"+claim);

			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis2']/tbody/tr["+i+"]/td[2]/span/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    Thread.sleep(10000);
			    enterreason.sendKeys("test");
			    JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", approvebutton);
			   // approvebutton.click();
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
	
	public String submitestimationativityapi(String EmployeeuserName,String EmployeepassWord,String approvalname1,String approvalpassword1,String venueofactivity,
			String topicofactivity,String ahotel,String afood,String alcd,String atravel,String aspeaker,String aothers,String aregfees,String activity,String domainname)
	{
		
		
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+"&Domain="+domainname);
		
	
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
		
		
		 userresponse=gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domainname+"");
		 ArrayList<String>  arraytypeofwrk = gdata.parseFromJSONarrayResponse(userresponse);	
		  System.out.println("Type of activity is >>>>>>>>>>>>>"+arraytypeofwrk);	
		  String typeofactivityid="";
		  String typeofactivitytext="";
		  
		  
		  for( i =0; i<=arraytypeofwrk.size();i++)
		  {
			  typeofactivityid=arraytypeofwrk.get(i);
			  typeofactivitytext=arraytypeofwrk.get(i+1);
			  
			  				  
			  if(typeofactivitytext.equalsIgnoreCase(activity))
			  {
				  i=arraytypeofwrk.size();
			  }
			  
			 // if(newtravelid)
		  }
	System.out.println(ahotel+afood+alcd+atravel+aspeaker+aothers+aregfees);
	System.out.println("typeofactivityid"+typeofactivityid);
	System.out.println("typeofactivitytext"+typeofactivitytext);
	System.out.println(String.valueOf((Integer.parseInt(ahotel))+(Integer.parseInt(afood))+(Integer.parseInt(alcd))+(Integer.parseInt(atravel))+
			(Integer.parseInt(aspeaker))+(Integer.parseInt(aothers))+(Integer.parseInt(aregfees))));
		String totalamount = String.valueOf((Integer.parseInt(ahotel))+(Integer.parseInt(afood))+(Integer.parseInt(alcd))+(Integer.parseInt(atravel))+
				(Integer.parseInt(aspeaker))+(Integer.parseInt(aothers))+(Integer.parseInt(aregfees)));
		System.out.println(totalamount);
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?dtActivity="+dtf.format(localDate)+"&intActivityType="+typeofactivityid+""
		 		+ "&vcVenue="+venueofactivity+"&vcTopic="+topicofactivity+"&vcSpeaker=test&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt="+ahotel+""
		 				+ "&numFoodAmt="+afood+""
		 		+ "&numLCDAudioVideoAmt="+alcd+"&numTravelAmt="+atravel+"&numSpeakerAmt="+aspeaker+"&numOtherAmt="+aothers+"&numTotalAmt="+totalamount+"&intEmp="+empdata+""
		 		+ "&intEventOrganizer=12&vcEventOrganizerDetails=&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
		 		+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1&intHCPDecision=1&intEmployerMedicalBoard=1"
		 		+ "&intHCPEmployerFormalWrittenRequest=1&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
		 		+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1"
		 		+ "&vcEventName=1&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1&intClusterThreshold=1&Domain="+domainname);
		
	
		 ArrayList<String> array = gdata1.parseFromJSONResponse(userresponse1);
	
		  i=0;
		
		
		 String activityid=array.get(i+21);
		 System.out.println(activityid);
		 System.out.println(BaseUrl+"/api/ActivitySubmit/SubmitActivity?activityid="+activityid+"&isactual=0&Domain=fulcrum");
		 gdata1.getContenxtWeb(BaseUrl+"/api/ActivitySubmit/SubmitActivity?activityid="+activityid+"&isactual=0&Domain=fulcrum");
		 return activityid;
	}

	
	 public void approveestimationactivitybyapisteps(String EmployeeuserName,String EmployeepassWord,String managerusername,String managerpassword,
	    		String domainname,String activityid,String activitytype ,String approvalaction)
	    {
	    	
	    	TestData.GetData gdata1 = new  TestData.GetData();
			 String userresponse = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+"&Domain="+domainname);
			
		
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
	    	  userresponse=gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domainname+"");
			 ArrayList<String>  arraytypeofwrk = gdata.parseFromJSONarrayResponse(userresponse);	
			  System.out.println("Type of activity is >>>>>>>>>>>>>"+arraytypeofwrk);	
			  String typeofactivityid="";
			  String typeofactivitytext="";
			  
			  
			  for(  i =0; i<=arraytypeofwrk.size();i++)
			  {
				  typeofactivityid=arraytypeofwrk.get(i);
				  typeofactivitytext=arraytypeofwrk.get(i+1);
				  
				  				  
				  if(typeofactivitytext.equalsIgnoreCase(activitytype))
				  {
					  i=arraytypeofwrk.size();
				  }
				  
				 // if(newtravelid)
			  }
			  String  managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domainname+"");
				
				
			  ArrayList<String>  arraymanager = gdata.parseFromJSONResponse(managerresponse);
				 
				 int k=0;
				 String approvalactionid="";
	     if(approvalaction.equalsIgnoreCase("approve"))
	     {
	    	 approvalactionid="1";
	     }else if(approvalaction.equalsIgnoreCase("reject"))
	     {
	    	 approvalactionid="0";
	     }
				
				String managerdata=arraymanager.get(k+2);
		System.out.println("typeofactivityid"+typeofactivityid);
		System.out.println("typeofactivitytext"+typeofactivitytext);
		System.out.println(BaseUrl+"/api/ActivityProcessing/ApproveDissapproveActivity?ActivityId="+activityid+"&ReccId="+managerdata+"&Remarks="
		 		+ "&Action="+approvalactionid+"&IsActual=0&ActivityType="+typeofactivityid+"&Domain="+domainname+"");
		 String activityapproavecode = gdata1.getContenxtWeb(BaseUrl+"/api/ActivityProcessing/ApproveDissapproveActivity?ActivityId="+activityid+"&ReccId="+managerdata+"&Remarks="
		 		+ "&Action="+approvalactionid+"&IsActual=0&ActivityType="+typeofactivityid+"&Domain="+domainname+"");
	 	
			// assertTrue(activityapproavecode.equalsIgnoreCase("200")||activityapproavecode.equalsIgnoreCase("201"));
		
		
	    }
}
