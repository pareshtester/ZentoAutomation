package PageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
import TestData.GetApiData;

public class DailyExpensePage extends Urls {
	String empdata="";
	String 	ClaimId="";
	String bandid="";
	WebDriver driver;
	WebElement claimidclick;
	GetApiData gdata1 = new  GetApiData();
	captureData gdata = new  captureData();
		public DailyExpensePage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
		}
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnFinalClaimSubmit\"]")
		WebElement submitbutton;
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RptAllowances_ctl01_imgEdit\"]")
		WebElement editicon;
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlTypeOfWork\"]")
		WebElement worktypeelement;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlFromTown\"]")
		WebElement townselement;
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtDoctorCalls\"]")
		WebElement doctorcallselement;
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtChemistCalls\"]")
		WebElement chemistcallselement;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_flpTravel\"]")
		WebElement uploadfileelement;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnTravelUpload\"]")
		WebElement uploadfilebuttonelement;
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnUpdate\"]")
		WebElement editbuttonelement;
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlTypeOfLocation\"]")
		WebElement locationelement;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RptAllowances_ctl01_lnkDelete\"]")
		WebElement deleteicon;

		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnApprove\"]")
		WebElement approve;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnDissapprove\"]")
		WebElement reject;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnReopenClaim\"]")
		WebElement reopen;
		
		
		
		

		String Successtext;
	public String addDailyExpense(String username,String password,String domain)
{
		
		captureData gdata = new  captureData();
		captureData citydata = new  captureData();
		
		
		String emailid="";
		String foodid="";
	
	
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domain+"");
		 ArrayList<String> array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 
		 int i=0;
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		 String message=array1.get(i+5);
		 String territiryId=array1.get(i+13);
		 String zoneId=array1.get(i+18);
		   String teamId=array1.get(i+19);
		
		
		int[] datearray= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		for(int j=0;j<datearray.length;j++)
		{
			
			
	
		
		System.out.println(BaseUrl+"/api/DailyAllowance/InsertDailyAllowance?empid="+empdata+"&ClaimDate=2019/11/"+datearray[j]+""
				+ "&WorkType=1708&FromTown=TestTown3&ToTown=TestTown3&HQType=1715&NightHalt=0&Residential=1723&Allowance=800.00"
				+ "&TravelMode=1&TravelWay=1721&KmDistance=20&Fare=200.00&DoctorCalls=5&ChemistCalls=3&Month=4&Year=2019"
				+ "&INOUTNA=1&StayTown=1719&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0&FoodLaundryHotel=0&HotelTax=0"
				+ "&Domain="+domain+"");
		
		 userresponse= gdata.getContenxtWeb(BaseUrl+"/api/DailyAllowance/InsertDailyAllowance?empid="+empdata+"&ClaimDate=2019/11/"+datearray[j]+""
				+ "&WorkType=1708&FromTown=TestTown3&ToTown=TestTown3&HQType=1715&NightHalt=0&Residential=1723&Allowance=800.00"
				+ "&TravelMode=1&TravelWay=1721&KmDistance=20&Fare=200.00&DoctorCalls=5&ChemistCalls=3&Month=4&Year=2019"
				+ "&INOUTNA=1&StayTown=1719&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0&FoodLaundryHotel=0&HotelTax=0"
				+ "&Domain="+domain+"");
    	
	 array1 =gdata.parseFromJSONResponse(userresponse);
		
		}
		System.out.println(array1);
		ClaimId= array1.get(16);
		System.out.println(ClaimId);
		return ClaimId;
		
		
		
}
	
	
	public void submitdailyexpense(String ClaimId) throws InterruptedException
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
			    		System.out.println("Claim "+ ClaimId);
			    	System.out.println("This is claim i am looking"+claim+"new claim"+ClaimId);
			    	if(claim.equalsIgnoreCase("Claim "+ClaimId))
			    	{
			    		
			    		System.out.println("inside");
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[2]/span/h7/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    
			    JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
	    	    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent"
	    	    				+ "(evt);", submitbutton);
	    	     
	    	    
	    	    Alert alert = driver.switchTo().alert();
	    	    String confirmatiotext = alert.getText();
	    	    assertTrue(confirmatiotext.equalsIgnoreCase("Are you sure you want to submit claim?"));
	    	    alert.accept();
	    	    
	    	    
			    
	}

	
	public void ReopenDailyexpense(String ClaimId) throws InterruptedException
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
			    		System.out.println("Claim "+ ClaimId);
			    	System.out.println("This is claim i am looking"+claim+"new claim"+ClaimId);
			    	if(claim.equalsIgnoreCase("Claim "+ClaimId))
			    	{
			    		
			    		System.out.println("inside");
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[2]/span/h7/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    
			    JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
	    	    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent"
	    	    				+ "(evt);", reopen);
	    	     
	    	    
	    	    Alert alert = driver.switchTo().alert();
	    	    String confirmatiotext = alert.getText();
	    	    assertTrue(confirmatiotext.equalsIgnoreCase("Are you sure you want to reopen claim?"));
	    	    alert.accept();
	    	    
	    	    
			    
	}

	
	
	
	
	
	public void submitdailyexpenseapi(String ClaimId,String domain)throws InterruptedException
	{
		
		String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Submit/SubmitClaim?ClaimId="+ClaimId+"&Domain="+domain);
		System.out.println(userresponse);
		ArrayList<String> array1 =gdata.parseFromJSONResponse(userresponse);
		System.out.println(array1);
		String successmessage= array1.get(5);
		assertTrue(successmessage.equalsIgnoreCase("Claim submitted successfully"));
		
		}
	public void approvedailyexpense(String ClaimId,String Action)throws InterruptedException
	{
		
		Thread.sleep(1000);
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
			    for(int i=2; i<=size;i++)
			    {
			    	
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    		String claim=driver.findElement(By.xpath(".//*[@id='table3']/tbody/tr["+i+"]/td[2]/a")).getText();
			    		System.out.println("Claim "+ ClaimId);
			    	System.out.println("This is claim i am looking"+claim+"new claim"+ClaimId);
			    	if(claim.equalsIgnoreCase(ClaimId))
			    	{
			    		
			    		System.out.println("inside");
			    		 claimidclick=driver.findElement(By.xpath(".//*[@id='table3']/tbody/tr["+i+"]/td[2]/a"));
			    		 JavascriptExecutor js3 = (JavascriptExecutor) driver;
				    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			       
			    }
			    
			   if(Action.equalsIgnoreCase("Approve"))
			   {
				  // approve.click();
				   
				   
		    	JavascriptExecutor js4 = (JavascriptExecutor) driver;
			    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", approve);
			    
			    Alert confirmalert=driver.switchTo().alert();
			    Successtext=driver.switchTo().alert().getText();
			    assertTrue(Successtext.equalsIgnoreCase("Are you sure you want to approve this claim?"));
			    confirmalert.accept();
			    
			    Alert approvealert=driver.switchTo().alert();
			    Successtext=driver.switchTo().alert().getText();
			    assertTrue(Successtext.equalsIgnoreCase("CLAIM Approved SUCCESSFULY !!"));
			    confirmalert.accept();
			    
			   }
			   else if(Action.equalsIgnoreCase("Reject"))
			   {
				   JavascriptExecutor js5 = (JavascriptExecutor) driver;
				    js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", reject);
				    
				    
				    Alert confirmalert=driver.switchTo().alert();
				    Successtext=driver.switchTo().alert().getText();
				    assertTrue(Successtext.equalsIgnoreCase("Are you sure you want to Reject this claim?"));
				    confirmalert.accept();
				    
				    Alert approvealert=driver.switchTo().alert();
				    Successtext=driver.switchTo().alert().getText();
				    assertTrue(Successtext.equalsIgnoreCase("CLAIM DISAPPROVED SUCCESSFULLY !!"));
				    confirmalert.accept();
				    
			   }
			   
				   
			
	    		
	}
	
    public String addsingleDailyexpense(String username,String password,String domain) throws InterruptedException
    {
    	captureData gdata = new  captureData();
		captureData citydata = new  captureData();
		
		
		String emailid="";
		String foodid="";
	
	
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domain+"");
		 ArrayList<String> array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 
		 int i=0;
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		 String message=array1.get(i+5);
		 String territiryId=array1.get(i+13);
		 String zoneId=array1.get(i+18);
		   String teamId=array1.get(i+19);
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"/api/DailyAllowance/InsertDailyAllowance?empid="+empdata+"&ClaimDate=2019/11/1&WorkType=1708&FromTown=TestTown3&ToTown=TestTown3&HQType=1715&NightHalt=0&Residential=1723&Allowance=800.00"
					+ "&TravelMode=1&TravelWay=1721&KmDistance=20&Fare=200.00&DoctorCalls=5&ChemistCalls=3&Month=4&Year=2019"
					+ "&INOUTNA=1&StayTown=1719&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0&FoodLaundryHotel=0&HotelTax=0"
					+ "&Domain="+domain+"");
		   array1 =gdata.parseFromJSONResponse(userresponse);
			System.out.println(array1);
			ClaimId= array1.get(16);
			System.out.println(ClaimId);
			return ClaimId;
		   
    }
    
    public String addmultipleDailyexpenses(String username,String password,String domain)
    {
    	captureData gdata = new  captureData();
		captureData citydata = new  captureData();
		
		
		String emailid="";
		String foodid="";
	
	
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domain+"");
		 ArrayList<String> array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 
		 int i=0;
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		 String message=array1.get(i+5);
		 String territiryId=array1.get(i+13);
		 String zoneId=array1.get(i+18);
		   String teamId=array1.get(i+19);
		   System.out.println(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domain+"");
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domain+"");
	    	
			  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		System.out.println("Type of work array is"+array1);
		String  typeofwork="";
		
//		i=0;
//			String  typeofwork = array1.get(i+2);
//			  System.out.println("Type of work  is"+typeofwork);
			  String workid="";
			  for( i=0;i<=array1.size();i++)
			  {
				  workid = array1.get(i);
				  typeofwork=array1.get(i+1);
				  System.out.println("Type of work  is"+typeofwork);
				  if(typeofwork.equalsIgnoreCase("Training"))
				  {
					  i=array1.size();
				  }
			  }
			  System.out.println("Type of work  is>>>>>>>>>>>>>"+typeofwork);
		   System.out.println(BaseUrl+"/api/DailyAllowance/InsertDailyAllowance?empid="+empdata+"&ClaimDate=2019/11/1&WorkType=1708&FromTown=TestTown3&ToTown=TestTown3&HQType=1715&NightHalt=0&Residential=1723&Allowance=800.00"
					+ "&TravelMode=1&TravelWay=1721&KmDistance=20&Fare=200.00&DoctorCalls=5&ChemistCalls=3&Month=4&Year=2019"
					+ "&INOUTNA=1&StayTown=1719&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0&FoodLaundryHotel=0&HotelTax=0"
					+ "&Domain="+domain+"");
		   userresponse= gdata.getContenxtWeb(BaseUrl+"/api/DailyAllowance/InsertDailyAllowance?empid="+empdata+"&ClaimDate=2019/11/1&WorkType=1708&FromTown=TestTown3&ToTown=TestTown3&HQType=1715&NightHalt=0&Residential=1723&Allowance=800.00"
					+ "&TravelMode=1&TravelWay=1721&KmDistance=20&Fare=200.00&DoctorCalls=5&ChemistCalls=3&Month=4&Year=2019"
					+ "&INOUTNA=1&StayTown=1719&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0&FoodLaundryHotel=0&HotelTax=0"
					+ "&Domain="+domain+"");
		   System.out.println("Type of work  is>>>>>>>>>>>>>"+typeofwork);
		   System.out.println(BaseUrl+"/api/DailyAllowance/InsertDailyAllowance?empid="+empdata+"&ClaimDate=2019/11/1&WorkType="+workid+"&FromTown=TestTown3&ToTown=TestTown3&HQType=1715&NightHalt=0&Residential=1723&Allowance=800.00"
					+ "&TravelMode=1&TravelWay=1721&KmDistance=20&Fare=200.00&DoctorCalls=5&ChemistCalls=3&Month=4&Year=2019"
					+ "&INOUTNA=1&StayTown=1719&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0&FoodLaundryHotel=0&HotelTax=0"
					+ "&Domain="+domain+"");
		   userresponse= gdata.getContenxtWeb(BaseUrl+"/api/DailyAllowance/InsertDailyAllowance?empid="+empdata+"&ClaimDate=2019/11/1&WorkType="+workid+"&FromTown=Test3&ToTown=Test4&HQType=1715&NightHalt=0&Residential=1723&Allowance=800.00"
					+ "&TravelMode=1&TravelWay=1721&KmDistance=20&Fare=200.00&DoctorCalls=5&ChemistCalls=3&Month=4&Year=2019"
					+ "&INOUTNA=1&StayTown=1719&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0&FoodLaundryHotel=0&HotelTax=0"
					+ "&Domain="+domain+"");
		   array1 =gdata.parseFromJSONResponse(userresponse);
			System.out.println(array1);
			ClaimId= array1.get(16);
			System.out.println(ClaimId);
			return ClaimId;
    }
    public void editdailyexpense(String ClaimId) throws InterruptedException
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
			    		System.out.println("Claim "+ ClaimId);
			    	System.out.println("This is claim i am looking"+claim+"new claim"+ClaimId);
			    	if(claim.equalsIgnoreCase("Claim "+ClaimId))
			    	{
			    		
			    		System.out.println("inside");
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[2]/span/h7/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    
			    JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", editicon);
			    
	    	    
	    	    Thread.sleep(5000);
	    	    Select selectworktype = new Select(worktypeelement);
	    		selectworktype.selectByVisibleText("Fieldwork");
			    
	    		Select selecttown = new Select(townselement);
				selecttown.selectByVisibleText("TestTown3 - TestTown3");
				Select selectlocation = new Select(locationelement);
				selectlocation.selectByVisibleText("HQ");
				Thread.sleep(5000);
				doctorcallselement.clear();
				doctorcallselement.sendKeys("5");
				chemistcallselement.clear();
				chemistcallselement.sendKeys("6");
//				uploadfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
//				JavascriptExecutor jsuploadfile = (JavascriptExecutor) driver;
//				jsuploadfile.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
//					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
//								+ ".dispatchEvent(evt);", uploadfilebuttonelement);
				
				
				JavascriptExecutor jssavedraft = (JavascriptExecutor) driver;
				jssavedraft.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", editbuttonelement);
				Thread.sleep(5000);
				Alert alert = driver.switchTo().alert();
				String successtext=driver.switchTo().alert().getText();
				assertTrue(successtext.equalsIgnoreCase("Details updated successfully !!"));
				alert.accept();
			    
    }
    
    
    public void deletedailyexpense(String ClaimId) throws InterruptedException
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
			    		System.out.println("Claim "+ ClaimId);
			    	System.out.println("This is claim i am looking"+claim+"new claim"+ClaimId);
			    	if(claim.equalsIgnoreCase("Claim "+ClaimId))
			    	{
			    		
			    		System.out.println("inside");
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis']/tbody/tr["+i+"]/td[2]/span/h7/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    
			    JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", deleteicon);
	    	    
	    	    
                Alert alert =  driver.switchTo().alert();
                String confirmationupdatetext = alert.getText();
                assertTrue(confirmationupdatetext.equalsIgnoreCase("Are you sure you want to delete expense?"));
                alert.accept();
                Thread.sleep(500);
                Alert alert1 = driver.switchTo().alert();
                String successdeletetext =driver.switchTo().alert().getText();
                assertTrue(successdeletetext.equalsIgnoreCase("Deleted Successfully !!"));
                alert.accept();
                
    }

}
