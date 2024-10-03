package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Browsers.Urls;
import Data.capturePostAPIData;

public class CreateInvoicePage extends Urls {
	
	
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
	   String managerdata="";
	   String poid="";
	   String termid="";
	   String cycleamount="";
	   String invoiceno="";
	   String termtext="";
	   String postatus="";
	   String response="";
	   Calendar current = Calendar.getInstance();
		ArrayList<String> array = new ArrayList<String>();
		
		@FindBy(xpath="//*[@id=\"make-small-nav\"]/i[1]")
		WebElement burgermenu;
		
		@FindBy(xpath="//*[@id=\"ctl00_ulVendor\"]/a[1]/span[1]")
		WebElement vendorcategory;
		
		@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl03_aDLink\"]/i[1]")
		WebElement invoicecategory;
		
		@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl03_RptSubMenu_ctl00_lnkSubMenu\"]")
		WebElement reimburseinvoice;
		
		@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl03_RptSubMenu_ctl01_lnkSubMenu\"]")
		WebElement onlinereimburse;
		
		@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl03_RptSubMenu_ctl02_lnkSubMenu\"]")
		WebElement cashreimburse;
		
		@FindBy(xpath="//*[@id=\"ctl00_UlVendor1\"]/a[1]/span[1]")
		WebElement createinvoice;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_DDLPoNumber\"]")
		WebElement ponumber;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtinvoicenumber\"]")
		WebElement invoicenumber;
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtinvoicedate\"]")
		WebElement invoicedate;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtremark\"]")
		WebElement invoiceremarks;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_fpupload_invoice\"]")
		WebElement invoiceuploads;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnadd\"]")
		WebElement invoiceaddbutton;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblMsg\"]")
		WebElement successmessage;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnSubmit\"]")
		WebElement submitinvoice;
		
		@FindBy(xpath="//*[@id=\"ctl00_UlVendor3\"]/a[1]/span[1]")
		WebElement invoicestatus;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlyear\"]")
		WebElement allyeardropdown;
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlYear\"]")
		WebElement allyeardropdown1;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlYear\"]")
		WebElement paymentteamallyear;
	
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnUpdate\"]")
		WebElement updateinvoice;
		
		@FindBy(xpath="//input[@value='Vendor']") 
		WebElement Vendormain;
		
		@FindBy(xpath="//*[contains(text(),'Approve Invoices')]") 
		WebElement approveinvoice;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnApprove\"]")
		WebElement approvebtn;
		
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnDisapprove\"]")
		WebElement rejectbtn;
		
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_DDLActionRemarks\"]")
		WebElement rejectreason;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnPaid\"]")
		WebElement paidbtn;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnpayment\"]")
		WebElement processpaybtn;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVPONumber\"]")
		WebElement ponumerror;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVInvoiceno\"]")
		WebElement invoicenoerror;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVdate\"]")
		WebElement invoicedateerror;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVamt\"]")
		WebElement invoiceamterror;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_RFVFileUploadInvoice\"]")
		WebElement invoiceuploaderror;
		
		@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblmsg2\"]")
		WebElement message;
		
		//ctl00_ContentPlaceHolder1_lblmsg2
		
		
		
	//	ctl00_ContentPlaceHolder1_grdCashinvoicelist
		
		String travelpolicybindcode="";
		DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter  dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		ExtendedCallAPI ecapi= new ExtendedCallAPI();
		PostAPIPage postapi = new PostAPIPage();
		
		capturePostAPIData postapidata= new capturePostAPIData();
		String msg;
WebDriver driver;
	
	public CreateInvoicePage(WebDriver driver){
		
		this.driver=driver;
		
	}

	
	
	public String createPOAPI(String domaintext,String vendorid,String managerusername,String managerpassword,String ponumber) throws JSONException, InterruptedException
	{
		System.out.println(managerusername); 
		System.out.println(managerpassword);
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		  int cuurentday= current.get(Calendar.DAY_OF_MONTH);
			int month = current.get(Calendar.MONTH)+1;
			int year =current.get(Calendar.YEAR);
		  fromcityid=array.get(1);
		  System.out.println("vendorid"+vendorid);
		 APIBody = "{\r\n" + 
		 		"  \"PONumber\": '"+ponumber+"',\r\n" + 
		 		"  \"VendorID\": "+vendorid+",\r\n" + 
		 		"  \"dtPO\": '"+dtf.format(localDate)+"',\r\n" + 
		 		"  \"dtPOExpiry\": '"+dtf.format(LocalDate.of(year+1, month, cuurentday))+"',\r\n" + 
		 		"  \"Remarks\": \"sample string 5\",\r\n" + 
		 		"  \"numAmt\": 6000.0,\r\n" + 
		 		"  \"numAdvanceAmt\": 0.0,\r\n" + 
		 		"  \"Recc1\": "+managerdata+",\r\n" + 
		 		"  \"Recc2\": '',\r\n" + 
		 		"  \"Recc3\": '',\r\n" + 
		 		"  \"Recc4\": '',\r\n" + 
		 		"  \"Recc5\": '',\r\n" + 
		 		"  \"numBalAmt\": 6000,\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
			  System.out.println(array);
			  poid = array.get(0);
			  
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/Get_tblTerms" , APIBody );
				  System.out.println(array);
				
				  
				  for(int i=0;i<=array.size();i++)
				  {
					  termid = array.get(i);
					  termtext =array.get(i+1);
					  
					  if(termtext.equalsIgnoreCase("Half Yearly"))
					  {
						 i=array.size(); 
					  }
				  }
				  
//				  APIBody = "{\r\n" + 
//					  		"  \"Action\": \"Periodic\",\r\n" + 
//					  		"  \"Term\": \"Monthly\",\r\n" + 
//					  		"  \"amt\": 6000.0,\r\n" + 
//					  		"  \"advamt\": 0,\r\n" + 
//					  		"  \"percent\": \"0\",\r\n" + 
//					  		"  \"fromdate\": \"01/01/2019\",\r\n" + 
//					  		"  \"todate\": \"01/01/2020\",\r\n" + 
//					  		"  \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
//					  		"}";
				  
				  APIBody = "{\r\n" + 
				  		"  \"Action\": \"Periodic\",\r\n" + 
				  		"  \"Term\": '"+termtext+"',\r\n" + 
				  		"  \"amt\": 6000.0,\r\n" + 
				  		"  \"advamt\": 0,\r\n" + 
				  		"  \"percent\": \"0\",\r\n" + 
				  		"  \"fromdate\": \"01/01/2019\",\r\n" + 
				  		"  \"todate\": \"01/01/2020\",\r\n" + 
				  		"  \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
					  cycleamount = array.get(0);
					  System.out.println(cycleamount);
					
					  
				  APIBody = "{\r\n" + 
				  		"  \"intPOID\": "+poid+",\r\n" + 
				  		"  \"intPC_ID\": 1,\r\n" + 
				  		"  \"intTerm_ID\": "+termid+",\r\n" + 
				  		"  \"intPercent_ID\": 0,\r\n" + 
				  		"  \"cyclenumamt\": "+cycleamount+",\r\n" + 
				  		"  \"dtDate\": \"01/01/2019\",\r\n" + 
				  		"  \"Stage\": 0,\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
					  String rsponse= postapidata.httpPost(postbaseurl+"/api/PurchaseOrder/CreatePOPaymentCycle" , APIBody );
				  
			  return poid;
			  
	}
	
	public void navigatetocreateinvoice() 
	{
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", burgermenu);
	
	    JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", vendorcategory);
	    JavascriptExecutor js5 = (JavascriptExecutor) driver;
	    js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", createinvoice);
	    
	    
	}
	
	public void navigatetoapproveinvoice()
	{

	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", burgermenu);

	JavascriptExecutor js5 = (JavascriptExecutor) driver;
	js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", Vendormain);

	JavascriptExecutor js4 = (JavascriptExecutor) driver;
	js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", approveinvoice);


	}
	public void navigatetoinvoicestatus() 
	{
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", burgermenu);
	
	    JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", vendorcategory);
	    JavascriptExecutor js5 = (JavascriptExecutor) driver;
	    js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoicestatus);
	    Select selectyears = new Select(allyeardropdown);
	    selectyears.selectByVisibleText("All Years");
	    
	    
	}
	public void createinvoicesteps(String ponum,String invoiceno, String invoicedt,String invoiceupload,String remarks) throws InterruptedException
	{
		if(!(ponum==null))
				{
		Select selectpo = new Select(ponumber);
		selectpo.selectByVisibleText(ponum);
				}
		Thread.sleep(1000);
		if(!(invoiceno==null))
		{
		invoicenumber.sendKeys(invoiceno);
		}
		Thread.sleep(1000);
		if(!(remarks==null))
		{
		invoiceremarks.sendKeys(remarks);
		}
		Thread.sleep(1000);
		
		if(!(invoicedt==null))
		{
			String toenable = "document.getElementsByName('ctl00$ContentPlaceHolder1$txtinvoicedate')[0].removeAttribute('readonly');";
			JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
			jscalenderopen.executeScript(toenable);
			System.out.println(dtf1.format(localDate));
			invoicedate.sendKeys(dtf1.format(localDate));
			invoicedate.sendKeys(Keys.ENTER);
		}
		Thread.sleep(5000);
		if(!(invoiceupload==null))
		{
		invoiceuploads.sendKeys(System.getProperty("user.dir") +"/Images/TRAVEL EXPENSE SHEET.pdf");
		}
		
		if((ponum==null) && (invoiceno==null) && (invoicedt==null) && (invoiceupload==null))
			{
				System.out.println("here inside null");
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
				js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoiceaddbutton);
		Thread.sleep(1000);
		System.out.println(ponumerror.getText());
		assertTrue(ponumerror.getText().equalsIgnoreCase("Please select PO number !"));
		
		System.out.println(invoicenoerror.getText());
		assertTrue(invoicenoerror.getText().equalsIgnoreCase("Please enter invoice number !"));
		
		System.out.println(invoicedateerror.getText());
		assertTrue(invoicedateerror.getText().equalsIgnoreCase("Please select date !"));
		
//		System.out.println(invoiceamterror.getText());
//		assertTrue(invoiceamterror.getText().equalsIgnoreCase("Please enter amount !"));
		
		System.out.println(invoiceuploaderror.getText());
		assertTrue(invoiceuploaderror.getText().equalsIgnoreCase("Please upload Invoice Copy !"));
		
		
			}else
	{
//				invoiceaddbutton.click();
				 Thread.sleep(1000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoiceaddbutton);
		
	    Thread.sleep(1000);
	    String successmessagetext = successmessage.getText();
System.out.println(successmessagetext);
assertTrue(	successmessagetext.equalsIgnoreCase("Invoice Created Successfully !"));
	}
		
	}

	
	public String createinvoiceapi(String domaintext,String ponumber,String invoiceno)
	{
		  APIBody = "{\r\n" + 
			  		"  \"Action\": \"Periodic\",\r\n" + 
			  		"  \"Term\": \"Monthly\",\r\n" + 
			  		"  \"amt\": 6000.0,\r\n" + 
			  		"  \"advamt\": 0,\r\n" + 
			  		"  \"percent\": \"0\",\r\n" + 
			  		"  \"fromdate\": \"01/01/2019\",\r\n" + 
			  		"  \"todate\": \"01/01/2020\",\r\n" + 
			  		"  \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
				  cycleamount = array.get(0);
				  System.out.println(cycleamount);
		
		APIBody = "{\r\n" + 
				"  \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
				"  \"PONumber\": '"+ponumber+"',\r\n" + 
				"  \"InvoiceDate\": \"01/01/2019\",\r\n" + 
				"  \"Amount\": "+cycleamount+",\r\n" + 
				"  \"Remark\": \"sample string 5\",\r\n" + 
				"  \"BalAmt\": 0,\r\n" + 
				"  \"Stage\": 0,\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		  System.out.println(array);
		 // invoiceno="89";
		  String invoice = invoiceno;
		  return invoice;
		  
	}
	
	public void submitinvoicesteps(String invoiceno) throws InterruptedException
	{
		int i=0;
		 Thread.sleep(1000);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='table-two-axis2']")); 

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
			    		String invoiceNo=driver.findElement(By.xpath(".//*[@id='table-two-axis2']/tbody/tr["+i+"]/td[2]/span")).getText();
			    	System.out.println("This is invoice i am looking"+invoiceNo);
			    	System.out.println(invoiceno);
			    	if(invoiceNo.equalsIgnoreCase(invoiceno))
			    	{
			    		System.out.println("inside click");
			    		WebElement invoiceidclick=driver.findElement(By.xpath(".//*[@id='table-two-axis2']/tbody/tr["+i+"]/td[7]/span/input"));
			    		System.out.println(".//*[@id='table-two-axis2']/tbody/tr[\"+i+\"]/td[7]/span");
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoiceidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
				JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", submitinvoice);
	
	    	    String successmessagetext = successmessage.getText();
	    	    System.out.println(successmessagetext);
	    	  //  assertTrue(	successmessagetext.equalsIgnoreCase("Invoice submitted successfully !"));
	
	}

	public void submitinvoiceonstatussteps(String invoiceno) throws InterruptedException
	{
		int i=0;
		 Thread.sleep(500);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice']")); 

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
			    		String invoiceNo=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice']/tbody/tr["+i+"]/td[1]/span")).getText();
			    	System.out.println("This is claim i am looking"+invoiceNo);
			    	System.out.println(invoiceno);
			    	if(invoiceNo.equalsIgnoreCase(invoiceno))
			    	{
			    		System.out.println("inside click");
			    		WebElement invoiceidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice']/tbody/tr["+i+"]/td[9]/span/input"));
			    		System.out.println(".//*[@id='table-two-axis2']/tbody/tr[\"+i+\"]/td[7]/span");
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoiceidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
				
	
	    	    String successmessagetext = successmessage.getText();
	    	    System.out.println(successmessagetext);
	    	    assertTrue(	successmessagetext.equalsIgnoreCase("Invoice submitted successfully !"));
	
	}
	
	
	
	public void editinvoiceonstatussteps(String invoiceno,String poid) throws InterruptedException
	{
		int i=0;
		 Thread.sleep(500);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice']")); 

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
			    		String invoiceNo=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice']/tbody/tr["+i+"]/td[1]/span")).getText();
			    	System.out.println("This is claim i am looking"+invoiceNo);
			    	System.out.println(invoiceno);
			    	if(invoiceNo.equalsIgnoreCase(invoiceno))
			    	{
			    		System.out.println("inside click"+i);
			    	//	System.out.println(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice_ctl0"+i+"_imgbtnEdit']");
			    		WebElement invoiceidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice_ctl0"+i+"_imgbtnEdit']"));
			    		
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoiceidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    
			 
			
				Thread.sleep(5000);
				invoiceremarks.sendKeys("test1 test 3test2");
				invoiceuploads.sendKeys(System.getProperty("user.dir") +"/Images/TRAVEL EXPENSE SHEET.pdf");
				
			    JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", updateinvoice);
	    	    String successmessagetext = successmessage.getText();
	    	    System.out.println(successmessagetext);
	    	    assertTrue(	successmessagetext.equalsIgnoreCase("Invoice details updated successfully !"));
	
	}
	
	
	public void deleteinvoiceonstatussteps(String invoiceno,String poid) throws InterruptedException
	{
		int i=0;
		 Thread.sleep(500);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice']")); 

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
			    		String invoiceNo=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice']/tbody/tr["+i+"]/td[1]/span")).getText();
			    	System.out.println("This is claim i am looking"+invoiceNo);
			    	System.out.println(invoiceno);
			    	if(invoiceNo.equalsIgnoreCase(invoiceno))
			    	{
			    		System.out.println("inside click"+i);
			    	
			    		WebElement invoiceidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice_ctl0"+i+"_imgbtnDel']"));
			    		
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoiceidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    
			 
			Alert alert =driver.switchTo().alert();
			String deleteconfirmaion = driver.switchTo().alert().getText();
			assertTrue(deleteconfirmaion.equalsIgnoreCase("Are you sure you want to delete this?"));
			alert.accept();
		
	    	    String successmessagetext = successmessage.getText();
	    	    System.out.println(successmessagetext);
	    	    assertTrue(	successmessagetext.equalsIgnoreCase("Invoice Deleted successfully !"));
	
	}
	
	
	public void termid(String domaintext)
	{
		 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/Get_tblTerms" , APIBody );
			  System.out.println(array);
			
			  
			  for(int i=0;i<=array.size();i++)
			  {
				  termid = array.get(i);
				  termtext =array.get(i+1);
				  
				  if(termtext.equalsIgnoreCase("Half Yearly"))
				  {
					 i=array.size(); 
				  }
			  }
			  
			  System.out.println(termid);
			  System.out.println(termtext);
	}
	
	
	public void poclosesteps(String domaintext,String vendorid,String ManagerName,String ManagerpassWord,String pono) throws JSONException, InterruptedException
	{
//		poid  = createPOAPI(domaintext, "95", ManagerName, ManagerpassWord);
//		 APIBody = "{\r\n" + 
//		 		"  \"PONumber\": '"+pono+"',\r\n" + 
//		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
//		 		"}";
//			  postatus= postapidata.getonlydata(postbaseurl+"api/PurchaseOrder/GetPOStatus" , APIBody );
//			  System.out.println(postatus);
//			  assertTrue(postatus.equalsIgnoreCase("New"));
			  
			  
			  
		
	}
	
	
   public void SubmitInvoice(String invoicenumber, String domaintext) throws JSONException, InterruptedException {
		 
		APIBody = "{\r\n" + 
				"  \"InvoiceNo\":'"+invoicenumber+"',\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody );
		 
		  
	}


    public void approveinvoice(String pono, String invoiceno, String Action) throws InterruptedException
 {
int i=0;
Thread.sleep(500);
//WebDriverWait wait = new WebDriverWait(driver, 10);
//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
// claimidlocator.click();
WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdPODetails']")); 

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
String poNO=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdPODetails']/tbody/tr["+i+"]/td[1]/span/a")).getText();
System.out.println("This is po i am looking"+poNO);
System.out.println(pono);
if(poNO.equalsIgnoreCase(pono))
{
System.out.println("inside click");
WebElement poidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdPODetails']/tbody/tr["+i+"]/td[1]/span/a"));

JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", poidclick);
i=size;

}
}

//Select Checkbox

Thread.sleep(500);
//WebDriverWait wait = new WebDriverWait(driver, 10);
//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
// claimidlocator.click();
table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoiceDetails']")); 

// Now get all the TR elements from the table 
allRows = table.findElements(By.tagName("tr")); 
size=allRows.size();
System.out.println("Row count is"+size);
sizecell=0;
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
String invoicenumber=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoiceDetails']/tbody/tr["+i+"]/td[1]/span")).getText();
System.out.println("This is po i am looking"+invoicenumber);
System.out.println(invoiceno);
if(invoicenumber.equalsIgnoreCase(invoiceno))
{
System.out.println("inside click");
WebElement checkboxclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoiceDetails']/tbody/tr["+i+"]/td[6]/span/span/input"));

JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", checkboxclick);
i=size;

}
}


//Approve/Disapprove invoice
if(Action.equalsIgnoreCase("Approve"))
{
System.out.println("Approve");
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", approvebtn);


//	approvebtn.click();
Thread.sleep(1000);
//Alert al= driver.switchTo().alert();
//String successtext= driver.switchTo().alert().getText();
//System.out.println(successtext+ "Invoice "+invoiceno+" Approved successfully");
msg=message.getText();
assertTrue(msg.equalsIgnoreCase("Invoice "+invoiceno+" Approved successfully"));
//al.accept();



}
else if(Action.equalsIgnoreCase("Reject"))
{
System.out.println("Reject");

Select selecttype= new Select(rejectreason);
selecttype.selectByVisibleText("Voucher mismatched with invoice amount");
Thread.sleep(500);
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", rejectbtn);
Thread.sleep(500);
//Alert alert=driver.switchTo().alert();
//String confmsg=driver.switchTo().alert().getText();
//System.out.println(confmsg);
msg=message.getText();
assertTrue(msg.equalsIgnoreCase("Invoice "+invoiceno+" Rejected successfully"));
//alert.accept();
}

}

public void Reopeninvoice(String invoiceno) throws InterruptedException
{
int i=0;
Thread.sleep(500);
//WebDriverWait wait = new WebDriverWait(driver, 10);
//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
// claimidlocator.click();
WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice']")); 

// Now get all the TR elements from the table 
List<WebElement> allRows = table.findElements(By.tagName("tr")); 
int size=allRows.size();
System.out.println("Row count is"+size);
int sizecell=0;
// And iterate over them, getting the cells 
for (WebElement row : allRows) 
{ 
List<WebElement> cells = row.findElements(By.tagName("td")); 
sizecell=cells.size();

// Print the contents of each cell

}
System.out.println("col count is"+sizecell);
for( i=2; i<=size;i++)
{


//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
String invoiceNo=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice']/tbody/tr["+i+"]/td[1]/span")).getText();
System.out.println("This is claim i am looking"+invoiceNo);
System.out.println(invoiceno);
if(invoiceNo.equalsIgnoreCase(invoiceno))
{
System.out.println("inside click");
WebElement invoiceidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdInvoice']/tbody/tr["+i+"]/td[9]/span/input"));
System.out.println(".//*[@id='table-two-axis2']/tbody/tr[\"+i+\"]/td[7]/span");
JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoiceidclick);



i=size;
}


}

Alert alert= driver.switchTo().alert();
String conftext= driver.switchTo().alert().getText();
System.out.println(conftext);
assertTrue(conftext.equalsIgnoreCase("Are you sure you want to Reopen this?"));	
alert.accept();
String successmessagetext = successmessage.getText();
System.out.println(successmessagetext);
assertTrue(	successmessagetext.equalsIgnoreCase("Invoice Reopened Successfully !"));

}

//PaymentteamApproval
public void navigatetoreimburseinvoice() 
{
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", burgermenu);

    JavascriptExecutor js4 = (JavascriptExecutor) driver;
    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoicecategory);
    JavascriptExecutor js5 = (JavascriptExecutor) driver;
    js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", reimburseinvoice);
    
//    JavascriptExecutor js6 = (JavascriptExecutor) driver;
//    js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", onlinereimburse);

    
    Select selectyears = new Select(allyeardropdown1);
    selectyears.selectByVisibleText("All Years");
    
    
}

public void Approvereimburseinvoice(String invoiceno,String paymentmethod) throws InterruptedException 
{

int i=0;
Thread.sleep(500);
//WebDriverWait wait = new WebDriverWait(driver, 10);
//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
// claimidlocator.click();
WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdinvoicelist']")); 

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
for( i=2; i<=size;i++)
{


//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
String invoiceNo=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdinvoicelist']/tbody/tr["+i+"]/td[1]/span")).getText();
System.out.println("This is claim i am looking"+invoiceNo);
System.out.println(invoiceno);
if(invoiceNo.equalsIgnoreCase(invoiceno))
{
System.out.println("inside click");

if(paymentmethod.equalsIgnoreCase("Online"))
{
	Select onlileselect = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdinvoicelist']/tbody/tr["+i+"]/td[11]/select")));
	onlileselect.selectByVisibleText("Online");
}else if(paymentmethod.equalsIgnoreCase("Cash"))
{
	Select cashselect = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdinvoicelist']/tbody/tr["+i+"]/td[11]/select")));
	cashselect.selectByVisibleText("Cash");
}

Thread.sleep(1000);
WebElement invoiceidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdinvoicelist']/tbody/tr["+i+"]/td[12]/span/input"));

JavascriptExecutor js3 = (JavascriptExecutor) driver;
js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoiceidclick);

Thread.sleep(1000);
JavascriptExecutor js4 = (JavascriptExecutor) driver;
js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", paidbtn);

i=size;
}


}
Alert alert = driver.switchTo().alert();
String conftext=driver.switchTo().alert().getText();
assertTrue(conftext.equalsIgnoreCase("Are you sure you want to submit selected records?"));
alert.accept();
Thread.sleep(1000);
//Alert alert1 = driver.switchTo().alert();
//String successtext=driver.switchTo().alert().getText();
msg=message.getText();
assertTrue(msg.equalsIgnoreCase("Payment mode selected successfully, please do further payment processing. !"));
//alert1.accept();
}

public void navigatetoinvoicepayment(String paymentmethod) 
{
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", burgermenu);

    JavascriptExecutor js4 = (JavascriptExecutor) driver;
    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoicecategory);

	if(paymentmethod.equalsIgnoreCase("Online"))
	{
	    JavascriptExecutor js5 = (JavascriptExecutor) driver;
    js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", onlinereimburse);
	}
	else if(paymentmethod.equalsIgnoreCase("Cash"))
	{
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
	    js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", cashreimburse);

	}
//    JavascriptExecutor js6 = (JavascriptExecutor) driver;
//    js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", onlinereimburse);

  
    Select selectyears = new Select(paymentteamallyear);
    selectyears.selectByVisibleText("All Years");
    
    
}

public void onlinepaymentprocesssteps(String invoiceno) throws InterruptedException 
{
	int i=0;
	Thread.sleep(500);
	//WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(claimidlocator));
	// claimidlocator.click();
	WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdOnlineinvoicelist']")); 

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
	for( i=2; i<=size;i++)
	{


	//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
	String invoiceNo=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdOnlineinvoicelist']/tbody/tr["+i+"]/td[1]/span")).getText();
	System.out.println("This is claim i am looking"+invoiceNo);
	System.out.println(invoiceno);
	if(invoiceNo.equalsIgnoreCase(invoiceno))
	{
	System.out.println("inside click");

	

	Thread.sleep(1000);
	WebElement invoiceidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdOnlineinvoicelist']/tbody/tr["+i+"]/td[11]/span/input"));

	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoiceidclick);

	Thread.sleep(1000);
	JavascriptExecutor js4 = (JavascriptExecutor) driver;
	js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", processpaybtn);

	i=size;
	}
	
	
	}
	Thread.sleep(1000);
//	Alert alert = driver.switchTo().alert();
//	String successtext = driver.switchTo().alert().getText();
	msg=message.getText();
	assertTrue(msg.equalsIgnoreCase("Payment Processed. !"));
//	alert.accept();
}



public void cashpaymentprocesssteps(String invoiceno) throws InterruptedException 
{
	int i=0;
	Thread.sleep(500);
	//WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(claimidlocator));
	// claimidlocator.click();
	WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdCashinvoicelist']")); 

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
	for( i=2; i<=size;i++)
	{


	//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
	String invoiceNo=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdCashinvoicelist']/tbody/tr["+i+"]/td[1]/span")).getText();
	System.out.println("This is claim i am looking"+invoiceNo);
	System.out.println(invoiceno);
	if(invoiceNo.equalsIgnoreCase(invoiceno))
	{
	System.out.println("inside click");

	

	
	WebElement invoiceidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grdCashinvoicelist']/tbody/tr["+i+"]/td[11]/span/input"));

	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", invoiceidclick);


	

	i=size;
	}
	
	
	}
	Thread.sleep(1000);
	JavascriptExecutor js4 = (JavascriptExecutor) driver;
	js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", processpaybtn);
	
	Thread.sleep(1000);
//	Alert alert = driver.switchTo().alert();
//	String successtext = driver.switchTo().alert().getText();
	msg=message.getText();
	assertTrue(msg.equalsIgnoreCase("Payment Processed. !"));
//	alert.accept();
}
}

