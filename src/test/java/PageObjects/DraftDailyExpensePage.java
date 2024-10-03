package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.bcel.generic.AASTORE;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browsers.Urls;
import Data.captureData;
import TestData.GetApiData;

public class DraftDailyExpensePage extends Urls{
	
WebDriver driver;
GetApiData gdata1 = new  GetApiData();
captureData gdata = new  captureData();
	public DraftDailyExpensePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlClaimTypes\"]")
	WebElement calimtypelement;
	
	@FindBy(xpath=".//*[@id='make-small-nav']/i")
	WebElement SideMenu;
	@FindBy(xpath="//*[@id=\"ctl00_ulApplyClaim\"]/a[1]/span[1]")
	WebElement ApplycliamClick;
	@FindBy(xpath="//*[@id=\"ctl00_lnkDailyExpense\"]/span[1]")
	WebElement ApplycliamClick2;
	@FindBy(xpath="//*[@id=\"ctl00_ulApplyClaim\"]/a[1]/span[1]")
	WebElement ApprovecliamClick;
	@FindBy(xpath="//*[@id=\"ctl00_ulApplyClaim\"]/a[1]/span[1]")
	WebElement ApprovecliamClick2;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtDate\"]")
	WebElement clickdate;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlTypeOfWork\"]")
	WebElement worktypeelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlFromTown\"]")
	WebElement townselement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlTypeOfLocation\"]")
	WebElement locationelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtAllowance\"]")
	WebElement allowanceamountelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtChemistCalls\"]")
	WebElement chemistcallselement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtDoctorCalls\"]")
	WebElement doctorcallselement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_flpTravel\"]")
	WebElement uploadfileelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_rblNightHalt_0\"]")
	WebElement nighthaltyes;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_rblMetroNonMetro_0\"]")
	WebElement staytown;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtFoodAmt\"]")
	WebElement foodamount;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtLaundryAmt\"]")
	WebElement laundryamount;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lnkAddHotelExpense\"]")
	WebElement addhotelexpenseclick;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtInvoiceNo\"]")
	WebElement invoicenumber;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtVendorName\"]")
	WebElement vendornumber;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtVendorGSTN\"]")
	WebElement vendorgstn;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlState\"]")
	WebElement vendostate;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtNIPLGSTN\"]")
	WebElement niplgstn;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_rblTravelType_1\"]")   
	WebElement travelway;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtInvoiceDt\"]")
	WebElement clickpopdate;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtFomPlace\"]")
	WebElement fromplace;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtToPlace\"]")
	WebElement toplace;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_rblResidential_0\"]")
	WebElement residentialelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_rblResidential_1\"]")
	WebElement noresidentialelement;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtTravelFair\"]")    
	WebElement fare;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlTaxRate\"]")
	WebElement taxratedropdown;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_txtInvoiceNetValue\"]")
	WebElement hotelgrossvalue;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnHotelFoodAdd\"]")
	WebElement addbutton;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_Button1\"]")
	WebElement closepopup;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlTravelMode\"]")
	WebElement selecttravelmode;
	
	
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnTravelUpload\"]")
	WebElement uploadfilebuttonelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnDraft\"]")
	WebElement savedraftelement;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_rblInOut_0\"]")
	WebElement inoutelement;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
	LocalDate	 localDate = LocalDate.now();
	String displayedallowanceamount;
	int nighthaltid;	
	int inoutid;
	int residentialid;
	public void navigateToapplydailyexpense() throws InterruptedException
	{
		Thread.sleep(500);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", SideMenu);
		//SideMenu.click();
		Thread.sleep(500);
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ApplycliamClick);
		//ApplycliamClick.click();
		Thread.sleep(500);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
	    js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ApplycliamClick2);
		//ApplycliamClick2.click();
		
	}
	
	public void navigateToapprovedailyexpense() throws InterruptedException
	{
		Thread.sleep(500);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", SideMenu);
		//SideMenu.click();
		Thread.sleep(500);
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ApprovecliamClick);
		//ApplycliamClick.click();
		Thread.sleep(500);
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
	    js5.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ApprovecliamClick2);
	}
	
	public void applysteps(String employeeusername,String employeepasword,String domain,String worktype,String location,String nighthaltvalue,String inoutna,String residential) throws InterruptedException
	{
		
		
		String allowanceamount = getdailyallowance(employeeusername, employeepasword,domain,location,nighthaltvalue,inoutna,residential,worktype);
		
		System.out.println(allowanceamount);
		
		JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
		jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", clickdate);
		//opendate.click();
		
		JavascriptExecutor jscalenderdate = (JavascriptExecutor) driver;
		jscalenderdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='Sunday, December 01, 2019']")));
		Thread.sleep(1000);
		Select selectworktype = new Select(worktypeelement);
		selectworktype.selectByVisibleText(worktype);
		
		if(worktype.equalsIgnoreCase("fieldwork"))
		{
			Select selecttown = new Select(townselement);
			selecttown.selectByVisibleText("TestTown3 - TestTown3");
			if(location.equalsIgnoreCase("HQ"))
			{
				Select selectlocation = new Select(locationelement);
				selectlocation.selectByVisibleText("HQ");
				
				 displayedallowanceamount=allowanceamountelement.getAttribute("value");
				System.out.println("displayedallowanceamount"+displayedallowanceamount);
				assertTrue(displayedallowanceamount.equalsIgnoreCase(allowanceamount));
				doctorcallselement.sendKeys("3");
				chemistcallselement.sendKeys("4");
				uploadfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				JavascriptExecutor jsuploadfile = (JavascriptExecutor) driver;
				jsuploadfile.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", uploadfilebuttonelement);
				
			}else if(location.equalsIgnoreCase("EX-HQ"))
			{
				Select selectlocation = new Select(locationelement);
				selectlocation.selectByVisibleText("EX-HQ");
				if(nighthaltvalue.equalsIgnoreCase("yes"))
				{
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
							+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
										+ ".dispatchEvent(evt);", nighthaltyes);
						
					
					if(inoutna.equalsIgnoreCase("inout"))
					{
						
						JavascriptExecutor inoutjse = (JavascriptExecutor) driver;
						inoutjse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
											+ ".dispatchEvent(evt);", inoutelement);
                         Thread.sleep(1000);
						 displayedallowanceamount=allowanceamountelement.getAttribute("value");
						System.out.println("displayedallowanceamount"+displayedallowanceamount);
						assertTrue(displayedallowanceamount.equalsIgnoreCase(allowanceamount));
						
						JavascriptExecutor metrojse = (JavascriptExecutor) driver;
						metrojse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
											+ ".dispatchEvent(evt);", staytown);
						
						foodamount.sendKeys("500");
//						WebDriverWait wt = new WebDriverWait(driver, 10);
//						wt.until(ExpectedConditions.visibilityOf(laundryamount));
						Thread.sleep(5000);
						laundryamount.sendKeys("300");
					//	addhotelexpenseclick.click();
						Thread.sleep(5000);
						JavascriptExecutor addhotelexpensejs = (JavascriptExecutor) driver;
						addhotelexpensejs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
											+ ".dispatchEvent(evt);", addhotelexpenseclick);
						Thread.sleep(5000);
						invoicenumber.sendKeys("2569");
						vendornumber.sendKeys("paresh");
						vendorgstn.sendKeys("569856565656265");
						Select vendorstateselect = new Select(vendostate);
						vendorstateselect.selectByValue("2");
						niplgstn.sendKeys("24646464");
						
						Select taxselect = new Select(taxratedropdown);
						taxselect.selectByValue("12");
						Thread.sleep(1000);
						hotelgrossvalue.sendKeys("630");
//						WebDriverWait waitaddbutton = new WebDriverWait(driver, 10);
//						waitaddbutton.until(ExpectedConditions.visibilityOf(addbutton));
						Thread.sleep(5000);
						//addbutton.click();
						JavascriptExecutor addhoteljs = (JavascriptExecutor) driver;
						addhoteljs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
											+ ".dispatchEvent(evt);", addbutton);
					
						Select travelmodeselect = new Select(selecttravelmode);
						travelmodeselect.selectByValue("2");
						
						JavascriptExecutor travelwayjs = (JavascriptExecutor) driver;
						travelwayjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
											+ ".dispatchEvent(evt);", travelway);
						fare.sendKeys("500");
						
						doctorcallselement.sendKeys("3");
						chemistcallselement.sendKeys("4");
						uploadfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
						JavascriptExecutor jsuploadfile = (JavascriptExecutor) driver;
						jsuploadfile.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
							+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
										+ ".dispatchEvent(evt);", uploadfilebuttonelement);
					}
				}
				
			}else if(location.equalsIgnoreCase("UP"))
			{
				Select selectlocation = new Select(locationelement);
				selectlocation.selectByVisibleText("UP");
				if(nighthaltvalue.equalsIgnoreCase("yes"))
				{
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
							+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
										+ ".dispatchEvent(evt);", nighthaltyes);
						
					
					if(inoutna.equalsIgnoreCase("inout"))
					{
						
						JavascriptExecutor inoutjse = (JavascriptExecutor) driver;
						inoutjse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
											+ ".dispatchEvent(evt);", inoutelement);
                         Thread.sleep(1000);
						 displayedallowanceamount=allowanceamountelement.getAttribute("value");
						System.out.println("displayedallowanceamount"+displayedallowanceamount);
						assertTrue(displayedallowanceamount.equalsIgnoreCase(allowanceamount));
						
						JavascriptExecutor metrojse = (JavascriptExecutor) driver;
						metrojse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
											+ ".dispatchEvent(evt);", staytown);
						
						foodamount.sendKeys("500");
//						WebDriverWait wt = new WebDriverWait(driver, 10);
//						wt.until(ExpectedConditions.visibilityOf(laundryamount));
						Thread.sleep(5000);
						laundryamount.sendKeys("300");
					//	addhotelexpenseclick.click();
						Thread.sleep(5000);
						JavascriptExecutor addhotelexpensejs = (JavascriptExecutor) driver;
						addhotelexpensejs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
											+ ".dispatchEvent(evt);", addhotelexpenseclick);
						Thread.sleep(5000);
						
						
//						JavascriptExecutor jscalenderpopopen = (JavascriptExecutor) driver;
//						jscalenderpopopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
//								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
//									+ ".dispatchEvent(evt);", clickpopdate);
//						//opendate.click();
//						
//						JavascriptExecutor jscalenderpopdate = (JavascriptExecutor) driver;
//						jscalenderpopdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
//								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
//										+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='Sunday, December 01, 2019']")));
						invoicenumber.sendKeys("2569");
						vendornumber.sendKeys("paresh");
						vendorgstn.sendKeys("569856565656265");
						Select vendorstateselect = new Select(vendostate);
						vendorstateselect.selectByValue("2");
						niplgstn.sendKeys("24646464");
						
						Select taxselect = new Select(taxratedropdown);
						taxselect.selectByValue("12");
						Thread.sleep(1000);
						hotelgrossvalue.sendKeys("630");
//						WebDriverWait waitaddbutton = new WebDriverWait(driver, 10);
//						waitaddbutton.until(ExpectedConditions.visibilityOf(addbutton));
						Thread.sleep(5000);
						//addbutton.click();
						JavascriptExecutor addhoteljs = (JavascriptExecutor) driver;
						addhoteljs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
											+ ".dispatchEvent(evt);", addbutton);
					
						Select travelmodeselect = new Select(selecttravelmode);
						travelmodeselect.selectByValue("3");
						
						JavascriptExecutor travelwayjs = (JavascriptExecutor) driver;
						travelwayjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
											+ ".dispatchEvent(evt);", travelway);
						Thread.sleep(1000);
						fare.sendKeys("500");
						
						doctorcallselement.sendKeys("3");
						chemistcallselement.sendKeys("4");
						uploadfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
						JavascriptExecutor jsuploadfile = (JavascriptExecutor) driver;
						jsuploadfile.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
							+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
										+ ".dispatchEvent(evt);", uploadfilebuttonelement);
					}
				}
				
			}
		}else if(worktype.equalsIgnoreCase("Training"))
		{
			fromplace.sendKeys("test1");
			toplace.sendKeys("test2");
			
			if(residential.equalsIgnoreCase("yes"))
			{
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", residentialelement);
					
				Thread.sleep(1000);
				 displayedallowanceamount=allowanceamountelement.getAttribute("value");
				System.out.println("displayedallowanceamount"+displayedallowanceamount);
				assertTrue(displayedallowanceamount.equalsIgnoreCase(allowanceamount));
				
				Select travelmodeselect = new Select(selecttravelmode);
				travelmodeselect.selectByValue("3");
				
				
				JavascriptExecutor travelwayjs = (JavascriptExecutor) driver;
				travelwayjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", travelway);
				Thread.sleep(5000);
				fare.sendKeys("500");
				
				
				uploadfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				JavascriptExecutor jsuploadfile = (JavascriptExecutor) driver;
				jsuploadfile.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", uploadfilebuttonelement);
			}else if(residential.equalsIgnoreCase("no"))
			{
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", noresidentialelement);
				
				
//				JavascriptExecutor inoutjse = (JavascriptExecutor) driver;
//				inoutjse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
//						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
//									+ ".dispatchEvent(evt);", inoutelement);
                 Thread.sleep(1000);
				 displayedallowanceamount=allowanceamountelement.getAttribute("value");
				System.out.println("displayedallowanceamount"+displayedallowanceamount);
				assertTrue(displayedallowanceamount.equalsIgnoreCase(allowanceamount));
				
				JavascriptExecutor metrojse = (JavascriptExecutor) driver;
				metrojse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", staytown);
				
				foodamount.sendKeys("500");
//				WebDriverWait wt = new WebDriverWait(driver, 10);
//				wt.until(ExpectedConditions.visibilityOf(laundryamount));
				Thread.sleep(5000);
				laundryamount.sendKeys("300");
			//	addhotelexpenseclick.click();
				Thread.sleep(5000);
				JavascriptExecutor addhotelexpensejs = (JavascriptExecutor) driver;
				addhotelexpensejs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", addhotelexpenseclick);
				Thread.sleep(5000);
				
				
				JavascriptExecutor jscalenderpopopen = (JavascriptExecutor) driver;
				jscalenderpopopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", clickpopdate);
				//opendate.click();
				
				JavascriptExecutor jscalenderpopdate = (JavascriptExecutor) driver;
				jscalenderpopdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='Sunday, December 01, 2019']")));
				invoicenumber.sendKeys("2569");
				vendornumber.sendKeys("paresh");
				vendorgstn.sendKeys("569856565656265");
				Select vendorstateselect = new Select(vendostate);
				vendorstateselect.selectByValue("2");
				niplgstn.sendKeys("24646464");
				
				Select taxselect = new Select(taxratedropdown);
				taxselect.selectByValue("12");
				Thread.sleep(1000);
				hotelgrossvalue.sendKeys("630");
//				WebDriverWait waitaddbutton = new WebDriverWait(driver, 10);
//				waitaddbutton.until(ExpectedConditions.visibilityOf(addbutton));
				Thread.sleep(5000);
				//addbutton.click();
				JavascriptExecutor addhoteljs = (JavascriptExecutor) driver;
				addhoteljs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", addbutton);
				
				addhoteljs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", addbutton);
				
			
				Thread.sleep(5000);
				JavascriptExecutor popupjs = (JavascriptExecutor) driver;
				popupjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", closepopup);
				Select travelmodeselect = new Select(selecttravelmode);
				travelmodeselect.selectByValue("3");
				Thread.sleep(5000);
				JavascriptExecutor travelwayjs = (JavascriptExecutor) driver;
				travelwayjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", travelway);
				System.out.println("break");
				Thread.sleep(5000);
				fare.sendKeys("500");
				
				
				uploadfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				JavascriptExecutor jsuploadfile = (JavascriptExecutor) driver;
				jsuploadfile.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", uploadfilebuttonelement);
				
			}
		}else if(worktype.equalsIgnoreCase("Meeting"))
		{
			fromplace.sendKeys("test1");
			toplace.sendKeys("test2");
			
			if(residential.equalsIgnoreCase("yes"))
			{
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", residentialelement);
					
				Thread.sleep(1000);
				 displayedallowanceamount=allowanceamountelement.getAttribute("value");
				System.out.println("displayedallowanceamount"+displayedallowanceamount);
				assertTrue(displayedallowanceamount.equalsIgnoreCase(allowanceamount));
				
				Select travelmodeselect = new Select(selecttravelmode);
				travelmodeselect.selectByValue("3");
				
				Thread.sleep(5000);
				JavascriptExecutor travelwayjs = (JavascriptExecutor) driver;
				travelwayjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", travelway);
				Thread.sleep(5000);
				fare.sendKeys("500");
				
				
				uploadfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				JavascriptExecutor jsuploadfile = (JavascriptExecutor) driver;
				jsuploadfile.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", uploadfilebuttonelement);
			}else if(residential.equalsIgnoreCase("no"))
			{
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", noresidentialelement);
				
				
//				JavascriptExecutor inoutjse = (JavascriptExecutor) driver;
//				inoutjse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
//						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
//									+ ".dispatchEvent(evt);", inoutelement);
                 Thread.sleep(1000);
				 displayedallowanceamount=allowanceamountelement.getAttribute("value");
				System.out.println("displayedallowanceamount"+displayedallowanceamount);
				assertTrue(displayedallowanceamount.equalsIgnoreCase(allowanceamount));
				
				JavascriptExecutor metrojse = (JavascriptExecutor) driver;
				metrojse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", staytown);
				
				foodamount.sendKeys("500");
//				WebDriverWait wt = new WebDriverWait(driver, 10);
//				wt.until(ExpectedConditions.visibilityOf(laundryamount));
				Thread.sleep(5000);
				laundryamount.sendKeys("300");
			//	addhotelexpenseclick.click();
				Thread.sleep(5000);
				JavascriptExecutor addhotelexpensejs = (JavascriptExecutor) driver;
				addhotelexpensejs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", addhotelexpenseclick);
				Thread.sleep(5000);
				
				
				JavascriptExecutor jscalenderpopopen = (JavascriptExecutor) driver;
				jscalenderpopopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", clickpopdate);
				//opendate.click();
				
				JavascriptExecutor jscalenderpopdate = (JavascriptExecutor) driver;
				jscalenderpopdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='Sunday, December 01, 2019']")));
				invoicenumber.sendKeys("2569");
				vendornumber.sendKeys("paresh");
				vendorgstn.sendKeys("569856565656265");
				Select vendorstateselect = new Select(vendostate);
				vendorstateselect.selectByValue("2");
				niplgstn.sendKeys("24646464");
				
				Select taxselect = new Select(taxratedropdown);
				taxselect.selectByValue("12");
				Thread.sleep(1000);
				hotelgrossvalue.sendKeys("630");
//				WebDriverWait waitaddbutton = new WebDriverWait(driver, 10);
//				waitaddbutton.until(ExpectedConditions.visibilityOf(addbutton));
				Thread.sleep(5000);
				//addbutton.click();
				JavascriptExecutor addhoteljs = (JavascriptExecutor) driver;
				addhoteljs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", addbutton);
				
				addhoteljs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", addbutton);
				
			
				Thread.sleep(5000);
				JavascriptExecutor popupjs = (JavascriptExecutor) driver;
				popupjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", closepopup);
				Select travelmodeselect = new Select(selecttravelmode);
				travelmodeselect.selectByValue("3");
				Thread.sleep(5000);
				JavascriptExecutor travelwayjs = (JavascriptExecutor) driver;
				travelwayjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", travelway);
				System.out.println("break");
				Thread.sleep(5000);
				fare.sendKeys("500");
				
				
				uploadfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				JavascriptExecutor jsuploadfile = (JavascriptExecutor) driver;
				jsuploadfile.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", uploadfilebuttonelement);
			}
		}else if(worktype.equalsIgnoreCase("Transit"))
		{
			fromplace.sendKeys("test1");
			toplace.sendKeys("test2");
			 displayedallowanceamount=allowanceamountelement.getAttribute("value");
				System.out.println("displayedallowanceamount"+displayedallowanceamount);
				assertTrue(displayedallowanceamount.equalsIgnoreCase(allowanceamount));
				
				Select travelmodeselect = new Select(selecttravelmode);
				travelmodeselect.selectByValue("3");
				
				
				JavascriptExecutor travelwayjs = (JavascriptExecutor) driver;
				travelwayjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", travelway);
				Thread.sleep(5000);
				fare.sendKeys("500");
				
				
				uploadfileelement.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				JavascriptExecutor jsuploadfile = (JavascriptExecutor) driver;
				jsuploadfile.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", uploadfilebuttonelement);
			
		}else if(worktype.equalsIgnoreCase("Admin Day"))
		{
			
		}
		
		JavascriptExecutor jssavedraft = (JavascriptExecutor) driver;
		jssavedraft.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", savedraftelement);
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String successtext=driver.switchTo().alert().getText();
		assertTrue(successtext.equalsIgnoreCase("Expense added successfully !!"));
		alert.accept();
		
	}
	
	
	
	public String getdailyallowance(String username,String password,String domaintext,String location,String nighthalt,String inoutna,String residential,String worktype)
	{
		
		

		String url="http://192.168.1.14:90/";
	
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
		 ArrayList<String> array1 = gdata.parseFromJSONResponse(userresponse);
	
		
		 int i=0;
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
	String	 empdata=array1.get(i+2);
	 String message=array1.get(i+5);
	 String territiryId=array1.get(i+13);
	 String zoneId=array1.get(i+18);
		
		userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	System.out.println("Type of work array is"+array1);
	String  typeofwork="";
	
//	i=0;
//		String  typeofwork = array1.get(i+2);
//		  System.out.println("Type of work  is"+typeofwork);
		  String workid="";
		  for( i=0;i<=array1.size();i++)
		  {
			  workid = array1.get(i);
			  typeofwork=array1.get(i+1);
			  System.out.println("Type of work  is"+typeofwork);
			  if(typeofwork.equalsIgnoreCase(worktype))
			  {
				  i=array1.size();
			  }
		  }
		  System.out.println("Type of work  is>>>>>>>>>>>>>"+typeofwork);
		  System.out.println(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   ArrayList<String>  arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
			 i=0;
				
			String  towndata=arraytown.get(i);
			
			 System.out.println("API town name is "+towndata);
			 
			 
			
			 
			 String[]	  arrOfStr = towndata.split("-", 0); 
		String	  fromtown = arrOfStr[0];
			String	 totown = arrOfStr[1];
			
			System.out.println(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
	    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
		String	  insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
		    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
		ArrayList<String>  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
//				 System.out.println(hqtypearray);
//				String  hqtype = hqtypearray.get(0);
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
            //String fromTown = Arrays.toString(towndata.split("-"))
				 String hqid="";
				 for(int fsize=0;fsize<hqtypearray.size();fsize++)
					{
						
						
						
						//String noename2=noepolicyarray1.get(1);
						//System.out.println("NOE name @@@@2 is ->>>."+noename2);
						
					  hqid=hqtypearray.get(fsize);
						System.out.println("field Id is ->>>>>>>>"+hqid);
						 String hqvalue= hqtypearray.get(fsize+1);
						System.out.println("status is  ->>>>>>>>"+hqvalue);
						fsize=fsize+1;
						System.out.println(location);
						if(hqvalue.equalsIgnoreCase(location))
						{
							
							
							fsize=hqtypearray.size();
							
							
						}
					}
				 
				 
				 if(nighthalt.equalsIgnoreCase("yes"))
				 {
					nighthaltid=1; 
				 }else if(nighthalt.equalsIgnoreCase("no"))
				 {
					 nighthaltid=0;
				 }
				 
				 if(inoutna.equalsIgnoreCase("inout"))
				 {
					inoutid=1; 
				 }else if(inoutna.equalsIgnoreCase("na"))
				 {
					 inoutid=0;
				 }
				 
				 
				 if(residential.equalsIgnoreCase("yes"))
				 {
					 residentialid = 1;
				 }else if(residential.equalsIgnoreCase("no"))
				 {
					 residentialid = 0;
				 }
				 System.out.println(BaseUrl+"api/Allowance/GetAllowance?AllowanceHead="+workid+"&empid="+empdata+""
				  			+ "&HQ="+hqid+"&Residential="+residentialid+"&NightHalt="+nighthaltid+"&INOUTNA="+inoutid+"&Domain="+domaintext+"");
  	String allowanceamountcode= gdata.getContenxtWeb(BaseUrl+"api/Allowance/GetAllowance?AllowanceHead="+workid+"&empid="+empdata+""
  			+ "&HQ="+hqid+"&Residential="+residentialid+"&NightHalt="+nighthaltid+"&INOUTNA="+inoutid+"&Domain="+domaintext+"");
    array1 =gdata.parseFromJSONarrayResponse(allowanceamountcode);
    System.out.println(array1.size()+"this"  + array1);
    String allowanceamount = array1.get(0);
    System.out.println(allowanceamount);
    return allowanceamount;
	}

}
