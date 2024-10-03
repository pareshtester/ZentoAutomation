package PageObjects;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Array;
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
import org.openqa.selenium.support.ui.Select;

import Browsers.Urls;
import Data.capturePostAPIData;

public class VendorPage extends Urls {
	
	
	String EmployeeuserName=null;
	   String EmployeepassWord=null;
	   String emailId=null;
	   String FPassword=null;
	   String APIBody="";
	   String Stateid="";
	   String fromcityid="";
	   String designationid="";
	   String vendorid="";
	   String vendorusername="";
	   String elementattachtext="";
	   Calendar current = Calendar.getInstance();
		ArrayList<String> array = new ArrayList<String>();
		

		String travelpolicybindcode="";
		DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		ExtendedCallAPI ecapi= new ExtendedCallAPI();
		PostAPIPage postapi = new PostAPIPage();
		
		capturePostAPIData postapidata= new capturePostAPIData();
		
WebDriver driver;
	
	public VendorPage(WebDriver driver){
		
		this.driver=driver;
		
	}
//	String x = elementattachtext+"ContentPlaceHolder1_txtNameOfCompany";
	@FindBy(xpath="//*[@id=\"make-small-nav\"]/i[1]")
	WebElement burgermenu;
	
	@FindBy(xpath="//input[@value='8']")
	WebElement vendorregistrationcategory;
	
	@FindBy(xpath="//*[contains(text(),'Vendor Registration')]")
	WebElement vendorregistrationsubcategory;
	Urls u = new Urls();
	
	@FindBy(xpath="//*[contains(text(),'Create Vendor')]")
	WebElement createvendortab;
	
	@FindBy(xpath="//*[contains(text(),'Existing Vendors')]")
	WebElement exstingvendortab;
//	@FindBy(xpath=".//*[@id=\""+u.returnelementextension(adminurl)+"ContentPlaceHolder1_txtNameOfCompany"+"\"]")
//	WebElement nameofcompany;
//	@FindBy(xpath="//*[@id='elementattachtext+'ContentPlaceHolder1_txtTypeOfBusiness'']")
//	WebElement typeofbusiness;
//	@FindBy(xpath="//*[@id=\"phonenumbertext\"]")
//	WebElement phonenumber;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtEmailID\"]")
//	WebElement emailid;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_ddlSiteBranch\"]")
	WebElement site;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtAddress\"]")
//	WebElement address;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_ddlCountry\"]")
//	WebElement country;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_ddlState\"]")
//	WebElement state;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_ddlCity\"]")
//	WebElement city;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtPincode\"]")
//	WebElement pincode;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtGSTNo\"]")
//	WebElement gstnumber;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtContatPerson\"]")
//	WebElement contactPerson;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_DDLDesignation\"]")
//	WebElement designation;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtMobileNo\"]")
//	WebElement mobilenumber;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtContactPersonEmailID\"]")
//	WebElement contactemailid;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtBankName\"]")
//	WebElement bankname;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtAccountNo\"]")
//	WebElement accountno;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtIFSCCode\"]")
//	WebElement ifsccode;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtPANNo\"]")
//	WebElement panno;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_btnCreate\"]")
//	WebElement create;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_lblMsg\"]")
//	WebElement successmessage;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVnameofcomp\"]")
	WebElement nameofcompanymanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVtypeOfbussiness\"]")
	WebElement typeofbusinessmanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVPhone\"]")
	WebElement phonenumbermanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RequiredFieldValidator3\"]")
	WebElement emailidmanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVbranch\"]")
	WebElement sitemanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVaddress\"]")
	WebElement addressmanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVstate\"]")
	WebElement countrymanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVstate\"]")
	WebElement statemanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVcity\"]")
	WebElement citymanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVpincode\"]")
	WebElement pincodemanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVgst\"]")
	WebElement gstnumbermanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVContactname\"]")
	WebElement contactPersonmanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVdesignation\"]")
	WebElement designationmanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVmob\"]")
	WebElement mobilenumbermanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVemail\"]")
	WebElement contactemailidmanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVbank\"]")
	WebElement banknamemanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVaccount\"]")
	WebElement accountnomanerror;
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVifsc\"]")
	WebElement ifsccodemanerror;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_btnUpdate\"]")
	WebElement update;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_btninactive\"]")
	WebElement activeinactivebutton;
	
	
	public void navigateToCreatevendor()
	{
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", burgermenu);
	
	    JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", vendorregistrationcategory);
	    JavascriptExecutor js5 = (JavascriptExecutor) driver;
	    js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", vendorregistrationsubcategory);
	    JavascriptExecutor js6 = (JavascriptExecutor) driver;
	    js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", createvendortab);
	
	}
	
	
	public void navigateToexistingvendor()
	{
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", burgermenu);
	
	    JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", vendorregistrationcategory);
	    JavascriptExecutor js5 = (JavascriptExecutor) driver;
	    js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", vendorregistrationsubcategory);
	    JavascriptExecutor js6 = (JavascriptExecutor) driver;
	    js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", exstingvendortab);
	
	}
	
	/**
	 * @param domaintext
	 * @throws InterruptedException
	 */
	public void cratevendorsteps(String domaintext,String nameofcompanytext,String tob,String phonenumbertext,String emailidtext,String branch,
			String addresstext,String countrytext,String statetext,String citytext,String pincodetext,String gstntext,
			String contactpersontext,String designationid,String mobilenumbertext,
			String cemailidtext,String banknametext,String accountnotext,String ifsccodetext,String pannumbertext) throws InterruptedException
	{
		Urls getelement = new Urls();
		elementattachtext = getelement.returnelementextension(adminurl);
		
		System.out.println(".//*[@id="+elementattachtext+"ContentPlaceHolder1_txtNameOfCompany"+"]");
		System.out.println("elementattachtext"+elementattachtext);
		if(!(nameofcompanytext==null))
		{
			
			
		//nameofcompany.sendKeys(nameofcompanytext);
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtNameOfCompany"+"\"]")).sendKeys(nameofcompanytext);
		 
	}
		if(!(tob==null))
		{
	//	typeofbusiness.sendKeys(tob);
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtTypeOfBusiness"+"\"]")).sendKeys(tob);
		}
		if(!(phonenumbertext==null))
		{
	//	phonenumber.sendKeys(phonenumbertext);
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPhone"+"\"]")).sendKeys(phonenumbertext);
		}
		
		if(!(emailidtext==null))
		{
		//emailid.sendKeys(emailidtext);
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtEmailID"+"\"]")).sendKeys(emailidtext);
		}
		
//		if(!(branch==null))
//		{
//		Select siteselect = new Select(site);
//		siteselect.selectByVisibleText("Mulund");
//		}
		if(!(addresstext==null))
		{
		//address.sendKeys(addresstext);
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtAddress"+"\"]")).sendKeys(emailidtext);
		}
		if(!(countrytext==null))
		{
		Select countryselect = new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_ddlCountry"+"\"]")));
		countryselect.selectByVisibleText(countrytext);
		}
		Thread.sleep(1000);
		
		if(!(statetext==null))
		{
			APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/HCP/GetStateList" , APIBody );
			  System.out.println(array);
			  
		Stateid = array.get(2);
		  System.out.println(Stateid);
		  Select stateselect = new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_ddlState"+"\"]")));
		  stateselect.selectByValue(Stateid);
		}
		 if(!(citytext==null)) 
		 {
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/HCP/GetStateList" , APIBody );
				  System.out.println(array);
				  
			Stateid = array.get(2);
		APIBody = "{\r\n" + 
				"  \"State\": "+Stateid+",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";
		  array= postapidata.getarraydata(postbaseurl+"api/HCP/GetCityList" , APIBody );
		
		  fromcityid=array.get(1);
		  System.out.println(fromcityid);
		  Thread.sleep(1500);
		Select cityselect = new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_ddlCity"+"\"]")));
		cityselect.selectByValue(fromcityid);
		 
				}
				if(!(pincodetext==null))
				{
	//	pincode.sendKeys(pincodetext); 
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPincode"+"\"]")).sendKeys(pincodetext);
				}
				
				if(!(gstntext==null))
				{
					
		//gstnumber.sendKeys(gstntext);
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtGSTNo"+"\"]")).sendKeys(gstntext);
				}
				Thread.sleep(1000);
				if(!(contactpersontext==null))
				{
		//contactPerson.sendKeys(contactpersontext);
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtContatPerson"+"\"]")).sendKeys(contactpersontext);
				}
		
				Thread.sleep(1000);
			  if(!(designationid==null))
			  {
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
					
					  designationid=array.get(1);
		Select designationselect = new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_DDLDesignation"+"\"]")));
		designationselect.selectByValue(designationid);
			  }
			  if(!(mobilenumbertext==null))
			  {
		//mobilenumber.sendKeys(mobilenumbertext);
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtMobileNo"+"\"]")).sendKeys(mobilenumbertext);
			  }
			  if(!(cemailidtext==null))
			  {
		//contactemailid.sendKeys(cemailidtext);
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtContactPersonEmailID"+"\"]")).sendKeys(cemailidtext);
			  }
			  driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtContactPersonEmailID"+"\"]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		if(!(contactpersontext==null))
		{
			driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtContatPerson"+"\"]")).sendKeys(contactpersontext);
          //contactPerson.sendKeys(contactpersontext);
		}
		
		
		if(!(banknametext==null))
		{
			driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtBankName"+"\"]")).sendKeys(banknametext);
		//bankname.sendKeys(banknametext);
		}
		if(!(accountnotext==null))
		{
			driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtAccountNo"+"\"]")).sendKeys(accountnotext);
		//accountno.sendKeys(accountnotext);
		}
		Thread.sleep(1000);
		if(!(ifsccodetext==null))
		{
			driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtIFSCCode"+"\"]")).sendKeys(ifsccodetext);
		//ifsccode.sendKeys(ifsccodetext);
		}
		if(!(pannumbertext==null))
		{
			driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPANNo"+"\"]")).sendKeys(pannumbertext);
		//panno.sendKeys(pannumbertext);
		}
		
		
		if((nameofcompanytext==null) && (tob==null) && (phonenumbertext==null) &&  (emailidtext==null) && (branch==null) && (addresstext==null) 
				&& (countrytext==null) && (statetext==null) && (citytext==null) && (pincodetext==null) && (gstntext==null) && (contactpersontext==null)
				&& (designationid==null)&& (mobilenumbertext==null)&& (cemailidtext==null) && (banknametext==null) &&(accountnotext==null)&&
				(ifsccodetext==null)&& (pannumbertext==null))
				{
			 JavascriptExecutor js6 = (JavascriptExecutor) driver;
			    js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_btnCreate"+"\"]")));
			    Thread.sleep(1000);
			
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVnameofcomp"+"\"]")).getText().equalsIgnoreCase("Please enter name of company !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVtypeOfbussiness"+"\"]")).getText().equalsIgnoreCase("Please enter business type !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVPhone"+"\"]")).getText().equalsIgnoreCase("Please enter phone number !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RequiredFieldValidator3"+"\"]")).getText().equalsIgnoreCase("Please enter email id !"));
//			assertTrue(sitemanerror.getText().equalsIgnoreCase("Please select branch !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVaddress"+"\"]")).getText().equalsIgnoreCase("Please enter address !"));
		//	assertTrue(countrymanerror.getText().equalsIgnoreCase(""));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVstate"+"\"]")).getText().equalsIgnoreCase("Please select state !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVcity"+"\"]")).getText().equalsIgnoreCase("Please select city !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVpincode"+"\"]")).getText().equalsIgnoreCase("Please enter pincode !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVgst"+"\"]")).getText().equalsIgnoreCase("Please enter GST number !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVContactname"+"\"]")).getText().equalsIgnoreCase("Please enter name !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVdesignation"+"\"]")).getText().equalsIgnoreCase("Please select designation !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVmob"+"\"]")).getText().equalsIgnoreCase("Please enter mobile number !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVemail"+"\"]")).getText().equalsIgnoreCase("Please enter email id !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVbank"+"\"]")).getText().equalsIgnoreCase("Please enter bank name !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVaccount"+"\"]")).getText().equalsIgnoreCase("Please enter account no !"));
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVifsc"+"\"]")).getText().equalsIgnoreCase("Please enter IFSC code !"));
			
			
			
				}else {
					 JavascriptExecutor js6 = (JavascriptExecutor) driver;
					    js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 		
					    		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_btnCreate"+"\"]")));
					    Thread.sleep(5000);
					    String successmessagetext = driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_lblMsg"+"\"]")).getText();
			System.out.println(successmessagetext);
				assertTrue(	successmessagetext.equalsIgnoreCase("Vendor Created Successfully !"));
				}
		
	}

	public ArrayList<String> createvendorapisteps(String domaintext,String nameofcompanytext,String tob,String phonenumbertext,String emailidtext,String branch,
			String addresstext,String countrytext,String statetext,String citytext,String pincodetext,String gstntext,
			String contactpersontext,String designationid,String mobilenumbertext,
			String cemailidtext,String banknametext,String accountnotext,String ifsccodetext,String pannumbertext)
	{
		 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/HCP/GetStateList" , APIBody );
			  System.out.println(array);
			  
		Stateid = array.get(0);
		
		APIBody = "{\r\n" + 
				"  \"State\": "+Stateid+",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";
		  array= postapidata.getarraydata(postbaseurl+"api/HCP/GetCityList" , APIBody );
		
		  fromcityid=array.get(1);
		
		  
		 
		
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		
		  designationid=array.get(1);
		
		APIBody = "{\r\n" + 
				"  \"companyName\": '"+nameofcompanytext+"',\r\n" + 
				"  \"typeOfBusiness\": \"test2\",\r\n" + 
				"  \"phone\": \"8698294937\",\r\n" + 
				"  \"emailID\": \"paresh.patil@gdata.in\",\r\n" + 
				"  \"branch\": 5,\r\n" + 
				"  \"address\": \"sample string 6\",\r\n" + 
				"  \"city\": "+fromcityid+",\r\n" + 
				"  \"state\": "+Stateid+",\r\n" + 
				"  \"country\": 9,\r\n" + 
				"  \"pincode\": \"62388434\",\r\n" + 
				"  \"gst\": '"+gstntext+"',\r\n" + 
				"  \"contactPerson\": \"paresh\",\r\n" + 
				"  \"designation\": "+designationid+",\r\n" + 
				"  \"contactPersonMobile\": \"8698294937\",\r\n" + 
				"  \"ContactPersonEmail\": '"+cemailidtext+"',\r\n" + 
				"  \"userName\": '"+cemailidtext+"',\r\n" + 
				"  \"password\": \"Vendor123\",\r\n" + 
				"  \"bank\": \"testbank\",\r\n" + 
				"  \"accountno\": \"6456465\",\r\n" + 
				"  \"ifsccode\": \"55ttfhhy5\",\r\n" + 
				"  \"pan\": '"+pannumbertext+"',\r\n" + 
				"  \"createdy\": 22,\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";
		vendorid  = postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody );
		
		APIBody = "{\r\n" + 
				"  \"VendorID\": "+vendorid+",\r\n" + 
				"  \"search\": \"\",\r\n" + 
				"  \"year\": 0,\r\n" + 
				"  \"month\": 0,\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Vendor/VendorDetailsByVendorID" , APIBody );
		System.out.println(array);
		  //vendorusername=array.get(0);
		
			  
		return array;
	}
	
	public void editvendorsteps(String vendorusername,String domaintext,String nameofcompanytext,String tob,String phonenumbertext,String emailidtext,String branch,
			String addresstext,String countrytext,String statetext,String citytext,String pincodetext,String gstntext,
			String contactpersontext,String designationid,String mobilenumbertext,
			String cemailidtext,String banknametext,String accountnotext,String ifsccodetext,String pannumbertext) throws InterruptedException
	{
		
		Urls getelement = new Urls();
		elementattachtext = getelement.returnelementextension(adminurl);
	
		
		int i=0;
		 WebElement table = driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_grdVendorList"+"\"]")); 

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
			    		String vendoruser=driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_grdVendorList"+"\"]/tbody/tr["+i+"]/td[6]/span")).getText();
			    	System.out.println("This is vendoruser i am looking"+vendoruser);
			    	if(vendoruser.equalsIgnoreCase(vendorusername))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_grdVendorList"+"\"]/tbody/tr["+i+"]/td[8]/input"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    
			    Thread.sleep(1000);
			    driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtContactPersonEmailID"+"\"]")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtNameOfCompany"+"\"]")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtTypeOfBusiness"+"\"]")).clear();
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPhone"+"\"]")).clear();
				
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtEmailID"+"\"]")).clear();
//				Select siteselect = new Select(site);
//				siteselect.selectByVisibleText("Select");
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtAddress"+"\"]")).clear();
				Select stateselect = new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_ddlState"+"\"]")));
				stateselect.selectByValue("0");
				 Thread.sleep(1000);
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPincode"+"\"]")).clear();
				//gstnumber.clear();
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtGSTNo"+"\"]")).clear();
				Thread.sleep(1000);
				//contactPerson.clear();
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtContatPerson"+"\"]")).clear();
				Select designationselect = new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_DDLDesignation"+"\"]")));
				designationselect.selectByValue("0");
				//mobilenumber.clear();
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtMobileNo"+"\"]")).clear();

			
				
				
				
				
				
			
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtBankName"+"\"]")).clear();
				//bankname.clear();
				//accountno.clear();
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtAccountNo"+"\"]")).clear();
			//	ifsccode.clear();
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtIFSCCode"+"\"]")).clear();
				//panno.clear();
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPANNo"+"\"]")).clear();
				
				   Thread.sleep(1000);
			    if(!(nameofcompanytext==null))
				{
			    	
				//nameofcompany.sendKeys(nameofcompanytext);
			    	driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtNameOfCompany"+"\"]")).sendKeys(nameofcompanytext);
				}
				
				if(!(tob==null))
				{
//				typeofbusiness.sendKeys(tob);
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtTypeOfBusiness"+"\"]")).sendKeys(tob);
				}
				if(!(phonenumbertext==null))
				{
				//phonenumber.sendKeys(phonenumbertext);
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPhone"+"\"]")).sendKeys(phonenumbertext);
				}
				
				if(!(emailidtext==null))
				{
				//emailid.sendKeys(emailidtext);
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtEmailID"+"\"]")).sendKeys(emailidtext);
				}
				if(!(banknametext==null))
				{
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtBankName"+"\"]")).sendKeys(banknametext);
				//bankname.sendKeys(banknametext);
				}
				if(!(contactpersontext==null))
				{
		//contactPerson.sendKeys(contactpersontext);
		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtContatPerson"+"\"]")).sendKeys(contactpersontext);
				}
				if(!(accountnotext==null))
				{
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtAccountNo"+"\"]")).sendKeys(accountnotext);
				//accountno.sendKeys(accountnotext);
				}
//				if(!(branch==null))
//				{
//				 siteselect = new Select(site);
//				siteselect.selectByVisibleText("Mulund");
//				}
				if(!(addresstext==null))
				{
				//address.sendKeys(addresstext);
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtAddress"+"\"]")).sendKeys(addresstext);

				}
				if(!(countrytext==null))
				{
				Select countryselect = new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_ddlCountry"+"\"]")));
				countryselect.selectByVisibleText(countrytext);
				}
				Thread.sleep(1000);
				
				if(!(statetext==null))
				{
					  System.out.println("inside state");
					 APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/HCP/GetStateList" , APIBody );
						  System.out.println(array);
						  
					Stateid = array.get(2);
					Thread.sleep(1000);
				 stateselect = new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_ddlState"+"\"]")));
				stateselect.selectByValue(Stateid);
				}

				 
						Thread.sleep(1000);	
						if(!(citytext==null))
						{
							

							 APIBody = "{\r\n" + 
								 		"  \"Domain\": '"+domaintext+"'\r\n" + 
								 		"}";
								  array= postapidata.getarraydata(postbaseurl+"api/HCP/GetStateList" , APIBody );
								  System.out.println(array);
								  
							Stateid = array.get(2);
							APIBody = "{\r\n" + 
									"  \"State\": "+Stateid+",\r\n" + 
									"  \"Domain\": '"+domaintext+"'\r\n" + 
									"}";
							  array= postapidata.getarraydata(postbaseurl+"api/HCP/GetCityList" , APIBody );
							
							  fromcityid=array.get(3);
							  System.out.println(fromcityid);
				Select cityselect = new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_ddlCity"+"\"]")));
				cityselect.selectByValue(fromcityid);
						}
						if(!(pincodetext==null))
						{
			//	pincode.sendKeys(pincodetext);
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPincode"+"\"]")).sendKeys(pincodetext);
						}
						if(!(gstntext==null))
						{
				//gstnumber.sendKeys(gstntext);
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtGSTNo"+"\"]")).sendKeys(gstntext);
						}
						Thread.sleep(1000);
						
				
					  if(!(designationid==null))
					  {
						  
						  APIBody = "{\r\n" + 
							 		"  \"Domain\": '"+domaintext+"'\r\n" + 
							 		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
							
							  designationid=array.get(1);
				 designationselect = new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_DDLDesignation"+"\"]"))); 
				designationselect.selectByValue(designationid);
					  }
						Thread.sleep(1000);
					  if(!(mobilenumbertext==null))
					  {
				//mobilenumber.sendKeys(mobilenumbertext);
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtMobileNo"+"\"]")).sendKeys(mobilenumbertext);

					  }
					  if(!(cemailidtext==null))
					  {
				//contactemailid.sendKeys(cemailidtext);
						  driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtContactPersonEmailID"+"\"]")).sendKeys(cemailidtext);
					  }
					  driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtContactPersonEmailID"+"\"]")).sendKeys(Keys.ENTER);
				//contactemailid.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				
				if(!(ifsccodetext==null))
				{
				//ifsccode.sendKeys(ifsccodetext);
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtIFSCCode"+"\"]")).sendKeys(ifsccodetext);
				}
				if(!(pannumbertext==null))
				{
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPANNo"+"\"]")).sendKeys(pannumbertext);
				//panno.sendKeys(pannumbertext);
				}
				
				if((nameofcompanytext==null) && (tob==null) && (phonenumbertext==null) &&  (emailidtext==null) && (branch==null) && (addresstext==null) 
						&& (countrytext==null) && (statetext==null) && (citytext==null) && (pincodetext==null) && (gstntext==null) && (contactpersontext==null)
						&& (designationid==null)&& (mobilenumbertext==null)&& (cemailidtext==null) && (banknametext==null) &&(accountnotext==null)&&
						(ifsccodetext==null)&& (pannumbertext==null))
						{
					 JavascriptExecutor js6 = (JavascriptExecutor) driver;
					    js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", update);
					    Thread.sleep(1000);
					
					    assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVnameofcomp"+"\"]")).getText().equalsIgnoreCase("Please enter name of company !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVtypeOfbussiness"+"\"]")).getText().equalsIgnoreCase("Please enter business type !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVPhone"+"\"]")).getText().equalsIgnoreCase("Please enter phone number !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RequiredFieldValidator3"+"\"]")).getText().equalsIgnoreCase("Please enter email id !"));
//						assertTrue(sitemanerror.getText().equalsIgnoreCase("Please select branch !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVaddress"+"\"]")).getText().equalsIgnoreCase("Please enter address !"));
					//	assertTrue(countrymanerror.getText().equalsIgnoreCase(""));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVstate"+"\"]")).getText().equalsIgnoreCase("Please select state !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVcity"+"\"]")).getText().equalsIgnoreCase("Please select city !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVpincode"+"\"]")).getText().equalsIgnoreCase("Please enter pincode !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVgst"+"\"]")).getText().equalsIgnoreCase("Please enter GST number !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVContactname"+"\"]")).getText().equalsIgnoreCase("Please enter name !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVdesignation"+"\"]")).getText().equalsIgnoreCase("Please select designation !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVmob"+"\"]")).getText().equalsIgnoreCase("Please enter mobile number !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVemail"+"\"]")).getText().equalsIgnoreCase("Please enter email id !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVbank"+"\"]")).getText().equalsIgnoreCase("Please enter bank name !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVaccount"+"\"]")).getText().equalsIgnoreCase("Please enter account no !"));
						assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVifsc"+"\"]")).getText().equalsIgnoreCase("Please enter IFSC code !"));
					
					
					
						}else {
							 JavascriptExecutor js6 = (JavascriptExecutor) driver;
							    js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);",
							    		driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_btnUpdate"+"\"]")));
							    Thread.sleep(5000);
							    String successmessagetext = driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_lblMsg"+"\"]")).getText();
					System.out.println(successmessagetext);
						assertTrue(	successmessagetext.equalsIgnoreCase("Vendor details updated successfully !"));
						}
	}
	public void activeinactive(String vendorusername,String domaintext,String nameofcompanytext,String tob,String phonenumbertext,String emailidtext,String branch,
			String addresstext,String countrytext,String statetext,String citytext,String pincodetext,String gstntext,
			String contactpersontext,String designationid,String mobilenumbertext,
			String cemailidtext,String banknametext,String accountnotext,String ifsccodetext,String pannumbertext) throws InterruptedException
			{

		Urls getelement = new Urls();
		elementattachtext = getelement.returnelementextension(adminurl);


			int i=0;
			 WebElement table = driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_grdVendorList"+"\"]")); 

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
				String vendoruser=driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_grdVendorList"+"\"]/tbody/tr["+i+"]/td[6]/span")).getText();
			System.out.println("This is vendoruser i am looking"+vendoruser);
			if(vendoruser.equalsIgnoreCase(cemailidtext))
			{
				WebElement claimidclick=driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_grdVendorList"+"\"]/tbody/tr["+i+"]/td[8]/input"));
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			i=size;
			}


			}
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);",
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_btninactive"+"\"]")));

			Alert alert =driver.switchTo().alert();
			String conftecxt = driver.switchTo().alert().getText();
			assertTrue(conftecxt.equalsIgnoreCase("Are you sure you want to continue?"));
			alert.accept();

			Thread.sleep(1000);
			String successmessagetext = driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_lblMsg"+"\"]")).getText();
			System.out.println(successmessagetext);
			assertTrue(	successmessagetext.equalsIgnoreCase("Vendor Inactivated Successfully !"));	


			js3 = (JavascriptExecutor) driver;
			js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_btninactive"+"\"]")));

			alert =driver.switchTo().alert();
			conftecxt = driver.switchTo().alert().getText();
			assertTrue(conftecxt.equalsIgnoreCase("Are you sure you want to continue?"));
			alert.accept();

			Thread.sleep(1000);
			successmessagetext = driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_lblMsg"+"\"]")).getText();
			System.out.println(successmessagetext);
			assertTrue(	successmessagetext.equalsIgnoreCase("Vendor Activated Successfully !"));	
			}
	
}
