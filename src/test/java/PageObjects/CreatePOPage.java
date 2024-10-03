package PageObjects;

import static org.testng.Assert.assertTrue;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Browsers.Urls;
import Data.capturePostAPIData;

public class CreatePOPage extends Urls {
	WebDriver driver;
	public CreatePOPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
}
	
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
	String companyname="";
	String response;
	String paymentcycle="";
	Calendar current = Calendar.getInstance();
	ArrayList<String> array = new ArrayList<String>();
//	String nameofcompany;
//	String PoNumber="";
//	String poremarks="";
//	String poamt="";
//	String poadvamt="";
	String travelpolicybindcode="";
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	LocalDate localDate = LocalDate.now();
	ExtendedCallAPI ecapi= new ExtendedCallAPI();
	PostAPIPage postapi = new PostAPIPage();
	DecimalFormat dformat = new DecimalFormat("0.00");
	capturePostAPIData postapidata= new capturePostAPIData();
	@FindBy(xpath="//*[@id=\"make-small-nav\"]/i[1]")
	WebElement burgermenu;
	
	@FindBy(xpath="//input[@value='8']")
	WebElement vendorregistrationcategory;
	
	@FindBy(xpath="//*[contains(text(),'Vendor Registration')]")
	WebElement vendorregistrationsubcategory;
	
	@FindBy(xpath="//*[contains(text(),'Create PO')]")
	WebElement createvendortab;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_ddlvendorname\"]") 
//	WebElement vendorname;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtPOnumber\"]")
//	WebElement POnumber;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtPOdate\"]")
//	WebElement POdate;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtPOexpirydate\"]")
//	WebElement POexpirydate;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtPOremark\"]")
//	WebElement POremarks;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtPOamt\"]")
//	WebElement POamt;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtadvamt\"]")
//	WebElement POadvamt;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_ddlRecc1\"]")
//	WebElement POapproval1;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_rdnpaymentcycle_0\"]")
//	WebElement periodicpayment;  
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_rdnpaymentcycle\"]/tbody[1]/tr[1]/td[2]/span[1]/label[1]")
	WebElement stagewisepayment;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_DDLterm\"]")
//	WebElement term;
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_fp_PO\"]")
//	WebElement fileupload;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtbalamt\"]")
	WebElement balanceamount;
	
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_btnCreatePO\"]")
//	WebElement createpo;
	
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_lblMsg\"]")
	WebElement successmessage;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVnameofvendor\"]")
	WebElement companynameerror;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVponumber\"]")
	WebElement ponumbererror;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVPOdate\"]")
	WebElement podateerror;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVexppodate\"]")
	WebElement poexpirydateerror;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVPOAmt\"]")
	WebElement poamterror;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVterm\"]")
	WebElement termerror;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_RFVFileUploadPO\"]")
	WebElement vouchererror;
	
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txtbalamt\"]")
//	WebElement balamnt;
	
	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_rdnpaymentcycle_0\"]")
	WebElement periodicpaymentcycle;
	
//	@FindBy(xpath="//*[@id=\"ContentPlaceHolder1_txttermamt\"]")
//	WebElement periodictermamt;
	
	
	
	
	String termid;
	int balamount;
	String cycleamount;
	
	public void navigtevendor()
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
	
	
	public String createvendorapisteps(String domaintext,String email,String companyname) throws JSONException, InterruptedException
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
			" \"Domain\": '"+domaintext+"'\r\n" + 
			"}";
			array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );

			designationid=array.get(1);

			APIBody = "{\r\n" + 
			" \"companyName\": '"+companyname+"',\r\n" + 
			" \"typeOfBusiness\": \"test2\",\r\n" + 
			" \"phone\": \"8698294937\",\r\n" + 
			" \"emailID\": \"paresh.patil@gdata.in\",\r\n" + 
			" \"branch\": 5,\r\n" + 
			" \"address\": \"sample string 6\",\r\n" + 
			" \"city\": "+fromcityid+",\r\n" + 
			" \"state\": "+Stateid+",\r\n" + 
			" \"country\": 9,\r\n" + 
			" \"pincode\": \"236434\",\r\n" + 
			" \"gst\": \"fof84h4f6fgfg\",\r\n" + 
			" \"contactPerson\": \"paresh\",\r\n" + 
			" \"designation\": "+designationid+",\r\n" + 
			" \"contactPersonMobile\": \"8698294937\",\r\n" + 
			" \"ContactPersonEmail\": '"+email+"',\r\n" + 
			" \"userName\": '"+email+"',\r\n" + 
			" \"password\": \"Vendor123\",\r\n" + 
			" \"bank\": \"testbank\",\r\n" + 
			" \"accountno\": \"6456465\",\r\n" + 
			" \"ifsccode\": \"55f5\",\r\n" + 
			" \"pan\": \"8tt3eh7f4g55\",\r\n" + 
			" \"createdy\": 22,\r\n" + 
			" \"Domain\": '"+domaintext+"'\r\n" + 
			"}";
			vendorid = postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody );

			APIBody = "{\r\n" + 
			" \"VendorID\": "+vendorid+",\r\n" + 
			" \"search\": \"\",\r\n" + 
			" \"year\": 0,\r\n" + 
			" \"month\": 0,\r\n" + 
			" \"Domain\": '"+domaintext+"'\r\n" + 
			"}";
			array= postapidata.getarraydata(postbaseurl+"api/Vendor/VendorDetailsByVendorID" , APIBody );
			System.out.println(array);
			vendorusername=array.get(0);
			companyname=array.get(1);
			 
			
			return companyname;
			
			
			}
	public void cratePOsteps(String domaintext,String companyname,String Ponumber, String podate, String poexpirydate,String poremarks,
			String poamt,String poadvamt,String approval1,String paymentcycle,String satgewise,String poterm,String voucher) throws InterruptedException
			{
		Urls getelement = new Urls();
		elementattachtext = getelement.returnelementextension(adminurl);
		
	
			if(!(companyname==null))
			{
			Select selecttype= new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_ddlvendorname"+"\"]")));
			selecttype.selectByVisibleText(companyname);
			
			}
			System.out.println("po is"+Ponumber);
				if(!(Ponumber==null))
				{
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPOnumber"+"\"]")).sendKeys(Ponumber);
				
				}
			
			
				if(!(podate==null))
				{
				String toenable = "document.getElementsByName('ctl00$ContentPlaceHolder1$txtPOdate')[0].removeAttribute('readonly');";
				JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
				jscalenderopen.executeScript(toenable);
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPOdate"+"\"]")).sendKeys(dtf.format(localDate));
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPOdate"+"\"]")).sendKeys(Keys.ENTER);
				}
				
				
				Thread.sleep(1000);
				if(!(poremarks==null))
				{
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPOremark"+"\"]")).sendKeys(poremarks);
				}
				
				

				Thread.sleep(1000);
				if(!(poexpirydate==null))
				{
					int cuurentday= current.get(Calendar.DAY_OF_MONTH);
					int month = current.get(Calendar.MONTH)+1;
					int year =current.get(Calendar.YEAR);
										
//					System.out.println("date is"+LocalDate.of(year, month, cuurentday));
//					
//					
//				dtf.format(LocalDate.of(year, month, cuurentday));
					//System.out.println("date is"+dtf.format(LocalDate.of(year+1, month, cuurentday)));
					
					
				String toenable1 = "document.getElementsByName('ctl00$ContentPlaceHolder1$txtPOexpirydate')[0].removeAttribute('readonly');";
				JavascriptExecutor jscalenderopen1 = (JavascriptExecutor) driver;
				jscalenderopen1.executeScript(toenable1);
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPOexpirydate"+"\"]")).sendKeys(dtf.format(LocalDate.of(year+1, month, cuurentday)));
				driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPOexpirydate"+"\"]")).sendKeys(Keys.ENTER);
				}
				
				
//				
				
//		
					Thread.sleep(1000);
					
				
				
				if(!(poamt==null))
				{
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPOamt"+"\"]")).sendKeys(poamt);
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtPOamt"+"\"]")).sendKeys(Keys.ENTER);
				
				}
				Thread.sleep(1000);
				if(!(poadvamt==null))
				{
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtadvamt"+"\"]")).sendKeys(poadvamt);
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtadvamt"+"\"]")).sendKeys(Keys.ENTER);
				}
				if(!(poamt==null))
				{
			
				 balamount = ((Integer.parseInt(poamt)) - Integer.parseInt(poadvamt));
				
				 Thread.sleep(5000);
				 String displayedbalamt = driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txtbalamt"+"\"]")).getAttribute("value");
					System.out.println("Dispalyed amount is" +displayedbalamt+"Balnace amount is"+ balamount);
				 assertTrue(displayedbalamt.equalsIgnoreCase((String.valueOf((balamount)))));                
			
				}
				
				
				
				if(!(approval1==null))
				{
					Select selecttype= new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_ddlRecc1"+"\"]")));
					selecttype.selectByVisibleText(approval1);
				
				}
				
				if(!(paymentcycle==null)&&!(poterm==null))
				{
				if(paymentcycle.equalsIgnoreCase("periodic"))
				{
					JavascriptExecutor js3 = (JavascriptExecutor) driver;
					js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);",
							driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_rdnpaymentcycle_0"+"\"]")));

					if(!(poterm==null))
					{
					Select selecttype= new Select(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_DDLterm"+"\"]")));
					selecttype.selectByVisibleText(poterm);
					
					
					 APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/Get_tblTerms" , APIBody );
						  termid = array.get(0);
						  System.out.println(termid);
						  
						  APIBody = "{\r\n" + 
						  		"  \"Action\": \"Periodic\",\r\n" + 
						  		"  \"Term\": \"Monthly\",\r\n" + 
						  		"  \"amt\": "+balamount+",\r\n" + 
						  		"  \"advamt\": 0,\r\n" + 
						  		"  \"percent\": \"0\",\r\n" + 
						  		"  \"fromdate\": \"01/01/2019\",\r\n" + 
						  		"  \"todate\": \"01/01/2020\",\r\n" + 
						  		"  \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
						  		"  \"Domain\": '"+domaintext+"'\r\n" + 
						  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
							  System.out.println(array);
							  cycleamount = array.get(0);
							  System.out.println(cycleamount);
							  
							  String termamt = driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_txttermamt"+"\"]")).getAttribute("value");
								System.out.println("Term amount is" +termamt);
								
								 assertTrue(termamt.equalsIgnoreCase(cycleamount)); 
					}   
						
				}
				
				}
				else
				{
					System.out.println("Inside else");
				}
				
//				if(!(poterm==null))
//				{
//					Select selecttype= new Select(term);
//					selecttype.selectByVisibleText(poterm);
//				}
				
				Thread.sleep(1000);
				System.out.println("above voucher");
				if(!(voucher==null))
				{
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_fp_PO"+"\"]")).sendKeys(System.getProperty("user.dir") +"/Images/TRAVEL EXPENSE SHEET.pdf");
				}
				
				
				
				
			

			if((companyname==null) && (Ponumber==null) && (podate==null) && (poexpirydate==null) && (poremarks==null) && (poamt==null) && (poadvamt==null) 
			&& (approval1==null) && (paymentcycle==null) && (satgewise==null) && (poterm==null) && (voucher==null))
			{
				System.out.println("here inside null");
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false,"
					+ " false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_btnCreatePO"+"\"]")));
			Thread.sleep(1000);

			//assertTrue(nameofcompanymanerror.getText().equalsIgnoreCase("Please enter name of company !"));
			System.out.println(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVnameofvendor"+"\"]")).getText());
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVnameofvendor"+"\"]")).getText().equalsIgnoreCase("Please select company name !"));
			System.out.println(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVponumber"+"\"]")).getText());
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVponumber"+"\"]")).getText().equalsIgnoreCase("Please enter PO number !"));
			System.out.println(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVPOdate"+"\"]")).getText());
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVPOdate"+"\"]")).getText().equalsIgnoreCase("Please enter PO date !"));
			System.out.println(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVexppodate"+"\"]")).getText());
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVexppodate"+"\"]")).getText().equalsIgnoreCase("Please enter PO expiry date !"));
			System.out.println(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVPOAmt"+"\"]")).getText());
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVPOAmt"+"\"]")).getText().equalsIgnoreCase("Please enter amount !"));
			System.out.println(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVterm"+"\"]")).getText());
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVterm"+"\"]")).getText().equalsIgnoreCase("Please select term !"));
			System.out.println(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVFileUploadPO"+"\"]")).getText());
			assertTrue(driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_RFVFileUploadPO"+"\"]")).getText().equalsIgnoreCase("Please upload PO !"));
			
			



			}else {
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);",
					driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_btnCreatePO"+"\"]")));
			Thread.sleep(5000);
			String successmessagetext = driver.findElement(By.xpath(".//*[@id=\""+elementattachtext+"ContentPlaceHolder1_lblMsg"+"\"]")).getText();
			System.out.println(successmessagetext);
			assertTrue(	successmessagetext.equalsIgnoreCase("PO Created Successfully !"));
			
		
			}

			
			}
	
	 	
}
