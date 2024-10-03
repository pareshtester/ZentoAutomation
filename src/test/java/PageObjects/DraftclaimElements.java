package PageObjects;

import static org.testng.Assert.assertTrue;

import java.beans.Visibility;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browsers.Urls;

public class DraftclaimElements extends Urls {
WebDriver driver;
	
	public DraftclaimElements(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	String successtext="";
	String foodplaceid="";
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlClaimTypes\"]")
	WebElement calimtypelement;
	
	@FindBy(xpath=".//*[@id='make-small-nav']/i")
	WebElement SideMenu;
	@FindBy(xpath=".//*[@id='sidebar-nav']/ul/li[2]/a/span")
	WebElement ApplycliamClick;
	@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl01_RptSubMenu_ctl00_lnkSubMenu\"]")
	WebElement ApplycliamClick2;
	
	//Add travel expense
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_DDLTypeofvisit\"]")
	WebElement typeofvisit;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtInvoiceNo\"]")
	WebElement invoiceno;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_tbPanTravel']")
	WebElement TravelexpenseTabclick;
	@FindBy(css="input#ctl00_ContentPlaceHolder1_Local1_imgbtnDate")
	WebElement DailyexpenseCalender1;
	@FindBy(xpath="//*[@title='Saturday, August 04, 2018']")
	WebElement DailyexpenseCalenderSelect1;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_DDlCityfrom\"]")
	WebElement cityFrom;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_DDlCityTo\"]")
	WebElement cityTo;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_ddlMode\"]")
	WebElement travelMode;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_Travel1_txtAmt']")
	WebElement travelAmount;
	@FindBy(xpath=".//*//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_ddlWBS\"]")
	WebElement clientBorrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtRemark\"]")
	WebElement remarks;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_fpUpload_Travel1\"]")
	WebElement uploadFile;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_btnAdd\"]")
	WebElement saveDraft;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlTravel_txtFrm']")
	WebElement opendate;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlTravel_txtTo']")
	WebElement opentodate;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtAmt\"]")
	WebElement billamt;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtGSTN\"]")
	WebElement travelgstn;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtCGSTAmount\"]")
	WebElement travelcgst;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtSGSTAmount\"]")
	WebElement travelsgst;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtIGSTAmount\"]")
	WebElement traveligst;
	
		
	//Add Local Expense
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_DDLTypeofvisit\"]")
	WebElement localtypeofvisit;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_ddlWBS\"]")     
	WebElement localborrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtInvoiceNo\"]")
	WebElement localinvoiceno;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtFrm\"]")
	WebElement localopendate;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtTo\"]")
	WebElement localopentodate;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_ddlMode\"]")
	WebElement localtravelMode;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtAmt\"]")
	WebElement localbillamt;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_DDlCityfrom\"]")
	WebElement localcityfrom;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_tbPanLocal']")
	WebElement LocalexpenseTabclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_Local1_txtFrm']")
	WebElement LocalDailyexpenseCalender1;
	@FindBy(xpath="//*[@title='Saturday, August 04, 2018']")
	WebElement LocalDailyexpenseCalenderSelect1;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_vcfrom\"]")
	WebElement LocalcityFrom;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_vcTo\"]")
	WebElement LocalcityTo;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_Local1_ddlMode']")
	WebElement LocaltravelMode;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_Local1_txtAmt']")
	WebElement LocaltravelAmount;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_Local1_vcfrom']")
	WebElement Localfrom;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_Local1_vcTo']")
	WebElement LocalTo;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_Local1_ddlWBS']")
	WebElement LocalclientBorrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtRemark\"]")
	WebElement Localremarks;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_fpUpload_Travel1\"]")
	WebElement LocaluploadFile;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtGSTN\"]")
	WebElement Localgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtCGSTAmount\"]")
	WebElement Localcgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtSGSTAmount\"]")
	WebElement Localsgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtIGSTAmount\"]")
	WebElement Localigst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_btnAdd\"]")
	WebElement LocalsaveDraft;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_RFVDateFrom\"]")
	WebElement Ldateerrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_RequiredFieldValidator6\"]")
	WebElement Lamterrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_RequiredFieldValidator7\"]")
	WebElement Lfrmplcerrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_RequiredFieldValidator8\"]")
	WebElement Ltoplcerrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_RFVFileUploadLocal\"]")
	WebElement Luploaderrormsg;	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtKms\"]")
	WebElement distanceval;
	
	
		
	//Add Others
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_DDLTypeofvisit\"]")   
	WebElement othertypeofvisit;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_txtInvoiceNo\"]")
	WebElement otherinvoiceno;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_txtFrm\"]")
	WebElement Otherfrom;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_txtTo\"]")
	WebElement Otherto;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_ddlNOE\"]")
	WebElement Othernature;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_tbpanOthers']")
	WebElement OthersexpenseTabclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_othercontrol_txtFrm']")
	WebElement OthersDailyexpenseCalender1;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_othercontrol_ddlNOE']")
	WebElement NOEelement;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_txtLocation\"]")
	WebElement otherlocation;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_txtAmt\"]")
	WebElement othersAmount;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_ddlWBS\"]")
	WebElement OthersclientBorrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_txtGSTN\"]")
	WebElement Othergstn;			
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_txtCGSTAmount\"]")
	WebElement Othercgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_txtSGSTAmount\"]")
	WebElement Othersgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_txtIGSTAmount\"]")
	WebElement Otherigst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_txtRemark\"]")
	WebElement Othersremarks;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_fpUpload_Other\"]")
	WebElement OthersuploadFile;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_btnAdd\"]")
	WebElement OtherssaveDraft;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_RFVNOE\"]")
	WebElement noeerrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_RFVDateFrom\"]")
	WebElement odateerrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_RequiredFieldValidator1\"]")
	WebElement oamterrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_RFVFileUpload\"]")
	WebElement otheruploaderrormsg;
	
	//ctl00_ContentPlaceHolder1_ctrlTravel_RFVFileUpload
	
	//Add Mobile
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_DDLTypeofvisit\"]")
	WebElement Mobiletypeofvisit;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtInvoiceNo\"]")
	WebElement Mobileinvoiceno;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_tbPanMobile']")
	WebElement MobilesexpenseTabclick;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtFrm\"]")
	WebElement Mobilefromdate;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtTo\"]")
	WebElement Mobiletodate;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtGSTN\"]")
	WebElement Mobilegstn;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtCGSTAmount\"]")
	WebElement Mobilecgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtSGSTAmount\"]")
	WebElement Mobilesgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtIGSTAmount\"]")
	WebElement Mobileigst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtAmt\"]")
	WebElement mobileAmount;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtRemark\"]")
	WebElement mobileremarks;
	@FindBy(xpath=".//*//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_ddlWBS\"]")
	WebElement MobileclientBorrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_fpUpload_Travel1\"]")
	WebElement MobileuploadFile;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_btnAdd\"]")
	WebElement MobilesaveDraft;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtContactNumber\"]")
	WebElement Mobilenumber;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_RFVDateFrom\"]")
	WebElement Mdatererror;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_RFVAmount\"]")
	WebElement Mamterror;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_RFVFileUploadMobile\"]")
	WebElement Muploaderror;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_RequiredFieldValidator1\"]")
	WebElement Mobnumerror;
	
	//Add hotel
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_DDLTypeofvisit\"]")
	WebElement Hoteltypeofvisit;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_ddlWBS\"]")
	WebElement Hotelclientborrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtInvoiceNo\"]")
	WebElement Hotelinvoiceno;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_tabPanHotel']")
	WebElement HotelsexpenseTabclick;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtFrm\"]")
	WebElement Hotelfromdate;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtTo\"]")
	WebElement Hoteltodate;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_DDlCityfrom\"]")
	WebElement hotelcity;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtGSTN\"]")
	WebElement hotelgstn;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtCGSTAmount\"]")
	WebElement hotelcgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtSGSTAmount\"]")
	WebElement hotelsgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtIGSTAmount\"]")
	WebElement hoteligst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtAmt\"]")
	WebElement hotelAmount;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_HotelControl_ddlWBS']")
	WebElement HotelclientBorrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtRemark\"]")
	WebElement hotelremarks;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_fpUpload_Hotel\"]")
	WebElement HoteluploadFile;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_btnAdd\"]")
	WebElement HotelsaveDraft;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_RFVDateFrom\"]")
	WebElement hdateerror;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_RFVAmount\"]")
	WebElement hamterrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_RFVFileUploadHotel\"]")
	WebElement huploadfileerrormsg;
	
	//ctl00_ContentPlaceHolder1_ctrlHotel_RFVFileUploadHotel
	
	//Add food
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_DDLTypeofvisit\"]")
	WebElement Foodtypeofvisit;	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtInvoiceNo\"]")
	WebElement Foodinvoiceno;	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_tbPanFood']")
	WebElement FoodexpenseTabclick;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtFrm\"]")
	WebElement foodfromdate;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtTo\"]")
	WebElement foodtodate;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_ddlFoodplace\"]")
	WebElement foodplace;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_DDlCityfrom\"]")
	WebElement foodCity;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_FoodControl_ddlFoodplace']")
	WebElement foodType;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtAmt\"]")
	WebElement foodAmount;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_ddlWBS\"]")
	WebElement foodclientborrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtRemark\"]")
	WebElement foodRemarks;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_RFVFileUploadFood\"]")
	WebElement foodFileUpload;
	//ctl00_ContentPlaceHolder1_ctrlFood_RFVFileUploadFood
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtGSTN\"]")
	WebElement foodgstn;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtCGSTAmount\"]")
	WebElement foodcgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtSGSTAmount\"]")
	WebElement foodsgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtIGSTAmount\"]")
	WebElement foodigst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_btnAdd\"]")
	WebElement foodSaveDraft;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_RFVAmount\"]")
	WebElement famterrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_RFVFileUploadFood\"]")
	WebElement fuploadfileerrormsg;
	
	
//	ctl00_ContentPlaceHolder1_ctrlFood_RFVFileUploadFood
	
	//Add Landline
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_tbPanLandLine']")
	WebElement LandlineexpenseTabclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_LandlineClaim_txtFrm']")
	WebElement landlineDailyexpenseCalender1;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_LandlineClaim_ddlOperator']")
	WebElement landlineOperator;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_txtAmt']")
	WebElement landlineAmount;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_txtRemark']")
	WebElement landlineremarks;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_ddlWBS']")
	WebElement landlineclientborrower;;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_fpUpload_Landline1']")
	WebElement landlineFileUpload;
	//ctl00_ContentPlaceHolder1_ctlLandline_fpUpload_Landline1
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_btnAdd']")
	WebElement landlineSaveDraft;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_DDLTypeofvisit']")
	WebElement landlineTypeofvisit;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtInvoiceNo\"]")
	WebElement Landlineinvoiceno;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtFrm\"]")
	WebElement Landlinefromdate;	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtTo\"]")
	WebElement Landlinetodate;	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtGSTN\"]")
	WebElement Landlinegstn;	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtCGSTAmount\"]")
	WebElement Landlinecgst;	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtSGSTAmount\"]")
	WebElement Landlinesgst;	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtIGSTAmount\"]")
	WebElement Landlinetigst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_RFVDateFrom\"]")
	WebElement ldateerrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_RFVAmount\"]")
	WebElement lamterrormsg;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_RFVFileUploadLandline\"]")
	WebElement luploadfileerror;
	
//	ctl00_ContentPlaceHolder1_ctlLandline_RFVAmount
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_lblmsg2\"]")
	WebElement successmessage;

	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_lblmsg2\"]")
	WebElement othersuccessmessage;

	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_lblmsg2\"]")
	WebElement mobilesuccessmessage;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_lblmsg2\"]")
	WebElement localsuccessmessage;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_lblmsg2\"]")
	WebElement hotelsuccessmessage;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_lblmsg2\"]")
	WebElement landlinesuccessmessage;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_lblmsg2\"]")
	WebElement foodsuccessmessage;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_RFVDateFrom\"]")
	WebElement dateerrormsg;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_RFVAmount\"]")
	WebElement amterrormsg;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_RFVFileUpload\"]")
	WebElement uploadfileerror;
	
	 String is_Document_Mandatry="";
	 String dateclaimpolicy="";
	public void navigateToapplyclaim() throws InterruptedException
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
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
	LocalDate	 localDate = LocalDate.now();
	public void travelAddSteps(String EmployeeuserName,String EmployeepassWord,String Date,String fromCity,String toCity,String tMode,String tamount,String CB,String travelRemarks,String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException

	{
		System.out.println("Break");
	
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+"&domain="+domain);
		
		 
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 String empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
		

		Select selecttype = new Select(calimtypelement); 
		selecttype.selectByVisibleText("Travel");
		
		 System.out.println(BaseUrl+"/api/FieldMaster/GetFieldMaster?intClaimType=1&vcModule=Apply&Domain="+domain);
		
		  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/FieldMaster/GetFieldMaster?intClaimType=1&vcModule=Apply&Domain="+domain);
			// array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 ArrayList<String> fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println("New array"+fieldstatusarray);
			 int arrayln= fieldstatusarray.size();
			 System.out.println(arrayln);

			 
			 for(int fsize=0;fsize<fieldstatusarray.size();fsize++)
				{
					
					
					System.out.println(fsize);
				
					
				 String field=fieldstatusarray.get(fsize);
					System.out.println("field Id is ->>>>>>>>"+field);
					 String status= fieldstatusarray.get(fsize+1);
					System.out.println("status is  ->>>>>>>>"+status);
					fsize=fsize+1;
					if(field.equalsIgnoreCase("divTypeOfVisit")&& status.equalsIgnoreCase("True"))
					{
						Select visit = new Select(typeofvisit);
						visit.selectByVisibleText("Other");
						
						fsize=fieldstatusarray.size();
						
						
					}
				}
			 ArrayList<String> wbsarray = new ArrayList<String>();
		
		TestData.GetData gdata = new  TestData.GetData();
		//System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
		String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		System.out.println(wbsarray+"array");
		int wbscount=0;
		String wbsdata=wbsarray.get(wbscount+1);
		System.out.println("API wbs mode name is "+wbsdata);
		Select s4 = new Select(clientBorrower);
		s4.selectByValue(wbsdata);
		
		
		invoiceno.sendKeys("test2may");
		System.out.println(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Travel&Band="+bandid+"&Domain="+domain);
		userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Travel&Band="+bandid+"&Domain="+domain);
		  fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
		 System.out.println("New policy is"+" " +fieldstatusarray);
	
		dateclaimpolicy=fieldstatusarray.get(2);
		if(!(Date==null)) 
		{
			
			if(dateclaimpolicy.equalsIgnoreCase("Per Month"))
		{
		
		
		System.out.println(dtf.format(localDate));
		JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
		
		JavascriptExecutor jscalenderopento = (JavascriptExecutor) driver;
	jscalenderopento.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
				+ ".dispatchEvent(evt);", opentodate);
	
	Thread.sleep(500); 
	
	JavascriptExecutor jscalendertodate = (JavascriptExecutor) driver;
	jscalendertodate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlTravel_calExeToDate_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
							"")));
		
		
		jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
					+ ".dispatchEvent(evt);", opendate);
		//opendate.click();
		
		JavascriptExecutor jscalenderdate = (JavascriptExecutor) driver;
		jscalenderdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='"+dtf.format(localDate)+"']")));
		}
			else if(dateclaimpolicy.equalsIgnoreCase("Per Day"))
			{
				
				
				System.out.println(dtf.format(localDate));
				JavascriptExecutor jscalenderopen = (JavascriptExecutor) driver;
				
				jscalenderopen.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", opendate);
			
			Thread.sleep(500); 
			
			JavascriptExecutor jscalenderdate = (JavascriptExecutor) driver;
			jscalenderdate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[@title='"+dtf.format(localDate)+"']")));
			
			}
		}
		
		
////		JavascriptExecutor jscalenderopento = (JavascriptExecutor) driver;
////		jscalenderopento.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
////				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
////					+ ".dispatchEvent(evt);", opentodate);
//		
//		Thread.sleep(500); 
//		
//		JavascriptExecutor jscalendertodate = (JavascriptExecutor) driver;
//		jscalendertodate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
//				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
//						+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlTravel_calExeToDate_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
//								"")));
		
		TestData.GetData citydata = new  TestData.GetData();   
		 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
		
	
		 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
		 int cityno=0;
		
		 String citynamefromdata=cityarray1.get(cityno+1);
		 String citynametodata=cityarray1.get(cityno+2);
		 System.out.println("API CIty name is "+citynamefromdata);
		 System.out.println("API CIty name is "+citynametodata);
		 if(!(fromCity==null))
		 {
		Select s = new Select(cityFrom);
		s.selectByValue(citynamefromdata);
		 }
		 Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(cityTo));
		if(!(toCity==null))
		{
		Select s1 = new Select(cityTo);
		s1.selectByValue(citynametodata);
		}
		System.out.println("Date amt null"+Date+tamount);
		if(!(tamount==null))
		{
		billamt.sendKeys("150");
		}
		 gdata = new  TestData.GetData();
		
		String travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&domain="+domain);
		 
		 ArrayList<String> travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
		int travelmodecount=0;
		String travelmodedata=travelmodearray.get(travelmodecount);
		
		System.out.println("API travel mode name is "+travelmodedata);
		Select s2 = new Select(travelMode);
		System.out.println("travel mode array"+travelmodearray);
		s2.selectByValue(travelmodedata);
		userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Travel&Band="+bandid+"&Domain="+domain);
		  fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
		 System.out.println("New documetarry is"+fieldstatusarray);
		
		
		is_Document_Mandatry= fieldstatusarray.get(1);
		
					if(is_Document_Mandatry.equalsIgnoreCase("True"))  
		{
			Thread.sleep(1000);
			uploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
		
		}
		
		
		
		
		
		// gstn
		if(!(gstn==null))
		{
		travelgstn.sendKeys(gstn);
		}
		if(!(cgst==null))
		{
		travelcgst.sendKeys(cgst);
		}
		if(!(sgst==null))
		{
		travelsgst.sendKeys(sgst);
		}
		if(!(igst==null))
		{
		traveligst.sendKeys(igst);
		}
		if(!(travelRemarks==null))
		{		
		remarks.sendKeys(travelRemarks);
		}
		
		System.out.println("Date amt null"+Date+tamount);
		if((Date==null) && (tamount== null)&& (is_Document_Mandatry.equalsIgnoreCase("True"))) {
			uploadFile.clear();
			System.out.println("here inside null");
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", saveDraft);
	Thread.sleep(1000);
	System.out.println(dateerrormsg.getText());
	assertTrue(dateerrormsg.getText().equalsIgnoreCase("Please select date of claim !"));
	
	System.out.println(amterrormsg.getText());
	assertTrue(amterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
	
	System.out.println(uploadfileerror.getText());
	assertTrue(uploadfileerror.getText().equalsIgnoreCase("Please upload voucher !"));
	
			
		}
		else if((Date==null) && (tamount== null)) {
			System.out.println("here inside null");
			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", saveDraft);
	Thread.sleep(1000);
	System.out.println(dateerrormsg.getText());
	assertTrue(dateerrormsg.getText().equalsIgnoreCase("Please select date of claim !"));
	
	System.out.println(amterrormsg.getText());
	assertTrue(amterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
		}
		
		else 
		{
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
	    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
	    		+ "arguments[0].dispatchEvent(evt);", saveDraft);
	    Thread.sleep(1000);
//	    Alert alertsuccess = driver.switchTo().alert();
//		String alerttextsuccess1 = driver.switchTo().alert().getText();
//		System.out.println(alerttextsuccess1);
//		assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense added successfully"));
//		alertsuccess.accept();
		
		//successtext = successmessage
	    assertTrue((successmessage.getText().equalsIgnoreCase("Expense added successfully !")));
	
		}
		
		
	}
	
	public void localAddSteps(String EmployeeuserName,String EmployeepassWord,String Date,String localCity,String localtmode,String Lamount,
			String fromplace,String toplace,String LCB,String Lremarks,String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException
	{
		
		
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+""+"&domain="+domain+"&gstn="+gstn+"&cgst="+cgst+"sgst="+"&igst="+igst);
		System.out.println(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+""+"&domain="+domain);
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 String empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
		 
//		 String claimtyperesponse = gdata1.getContenxtWeb(BaseUrl+"/api/Master/GetAllClaimType?status=yes&Domain="+domain);
//		 
//		 array1 = gdata1.parseFromJSONarrayResponse(claimtyperesponse);
//		 System.out.println("Claim types"+array1);
		 Select selecttype = new Select(calimtypelement); 
			selecttype.selectByValue("2");
			
	
			  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/FieldMaster/GetFieldMaster?intClaimType=1&vcModule=Apply&Domain="+domain);
				// array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
				 ArrayList<String> fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
				 System.out.println("New array"+fieldstatusarray);
				 int arrayln= fieldstatusarray.size();
				 System.out.println(arrayln);

				 
				 for(int fsize=0;fsize<fieldstatusarray.size();fsize++)
					{
						
						
						
						//String noename2=noepolicyarray1.get(1);
						//System.out.println("NOE name @@@@2 is ->>>."+noename2);
						
					 String field=fieldstatusarray.get(fsize);
						System.out.println("field Id is ->>>>>>>>"+field);
						 String status= fieldstatusarray.get(fsize+1);
						System.out.println("status is  ->>>>>>>>"+status);
						fsize=fsize+1;
						if(field.equalsIgnoreCase("divTypeOfVisit")&& status.equalsIgnoreCase("True"))
						{
							Select visit = new Select(localtypeofvisit);
							visit.selectByVisibleText("Other");
							
							fsize=fieldstatusarray.size();
							
							
						}
					}
				 
				 ArrayList<String> wbsarray = new ArrayList<String>();
					
					TestData.GetData gdata = new  TestData.GetData();
					System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
					String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
					 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
					System.out.println(wbsarray+"array");
					int wbscount=0;
					String wbsdata=wbsarray.get(wbscount+1);
//					System.out.println("API wbs mode name is "+wbsdata);
					Select s4 = new Select(localborrower);
					s4.selectByValue(wbsdata);
				 
			
			localinvoiceno.sendKeys("5");
			
			
			

			
			String traveldistance="";
			String travelcost="";
			 gdata = new  TestData.GetData();
			 System.out.println(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&domain="+domain);
				String travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&domain="+domain);

				 ArrayList<String> travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
				int travelmodecount=0;
				String travelmodedata="";
				String travelmodetext="";
				for(i =0;i<=travelmodearray.size();i++)
				{
					 travelmodedata=travelmodearray.get(i);
					 travelmodetext=travelmodearray.get(i+1);
				
				
				System.out.println("prining travel mode travelmodetext "+travelmodetext);
				System.out.println("prining travel mode localtmode "+localtmode);
				if(localtmode.equalsIgnoreCase(travelmodetext))
		       {
				
				i=travelmodearray.size();
		       }
				i++;
				}
				
				userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Local&Band="+bandid+"&Domain="+domain);
				  fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
				 System.out.println("New documetarry is"+fieldstatusarray);
				
				is_Document_Mandatry= fieldstatusarray.get(4);
				
				Thread.sleep(5000);
				
				for(i=0;i<=fieldstatusarray.size();i++)
				{
					String newtravelmode=fieldstatusarray.get(i+2);
					
					if(travelmodedata.equalsIgnoreCase(newtravelmode)) {
						
						
						 traveldistance=fieldstatusarray.get(i+1);
						System.out.println("Travel Distance"+traveldistance);
						 travelcost=fieldstatusarray.get(i);
						System.out.println("Travel cost"+travelcost);
						dateclaimpolicy=fieldstatusarray.get(i+5);
						System.out.println("dateclaimpolicy"+dateclaimpolicy);
						i=fieldstatusarray.size();
						
					}
					i=i+5;
					 System.out.println("API newtravelmode name is "+newtravelmode);	
					 
				}
				
				
				
				
				System.out.println("dateclaimpolicy"+dateclaimpolicy);


				if(!(Date==null)) {
					if(dateclaimpolicy.equalsIgnoreCase("Per Month"))
					{
				
				JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
				jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
						+ "arguments[0].dispatchEvent(evt);", localopendate);
				JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
				jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlLocal_CalendarExtender1_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
										"")));
				
				JavascriptExecutor jscalenderopento = (JavascriptExecutor) driver;
				jscalenderopento.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", localopentodate);
				
				Thread.sleep(500); 
				
				JavascriptExecutor jscalendertodate = (JavascriptExecutor) driver;
				jscalendertodate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlLocal_calExeToDate_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
										"")));
					}
					else if(dateclaimpolicy.equalsIgnoreCase("Per Day"))
					{

						JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
						jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
								+ "arguments[0].dispatchEvent(evt);", localopendate);
						JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
						jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
										+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlLocal_CalendarExtender1_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
												"")));
						
						
				
					}
				}
				if(!(Lamount==null))
				{
				if(!(traveldistance.equalsIgnoreCase("0"))&& (!(travelcost.equalsIgnoreCase("0"))))
						{
					distanceval.sendKeys(traveldistance);
					distanceval.sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					double result= ((Double.parseDouble(traveldistance))*(Double.parseDouble(travelcost)));
				System.out.println(result);
				System.out.println(Double.parseDouble(localbillamt.getAttribute("value")));
					assertTrue(result==(Double.parseDouble(localbillamt.getAttribute("value"))));
						}
				
				else if((traveldistance.equalsIgnoreCase("0"))&& ((travelcost.equalsIgnoreCase("0"))))
				{
					localbillamt.sendKeys("100");        
					
				}
				else if((traveldistance.equalsIgnoreCase("0")) && (!(travelcost.equalsIgnoreCase("0"))))
				{
					distanceval.sendKeys("55");
					
					distanceval.sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					double result= (55)*(Double.parseDouble(travelcost));
				System.out.println(result);
				System.out.println(Double.parseDouble(localbillamt.getAttribute("value")));
					assertTrue(result==(Double.parseDouble(localbillamt.getAttribute("value"))));
				}
				else if(!(traveldistance.equalsIgnoreCase("0")) && (travelcost.equalsIgnoreCase("0")))
				{
					System.out.println(".........."+traveldistance);
					distanceval.sendKeys(traveldistance);
					distanceval.sendKeys(Keys.ENTER);
			        
					localbillamt.clear();
					Thread.sleep(1000);
					localbillamt.sendKeys("50");
					
					
					
				
				}
				
				}
				
				if(!(fromplace==null))	
				{
				LocalcityFrom.sendKeys(fromplace);
				}
				if(!(toplace==null))
				{
				LocalcityTo.sendKeys(toplace);
				}
				
				TestData.GetData citydata = new  TestData.GetData();
				 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
				 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
				 int cityno=0;
				 String citynamefromdata=cityarray1.get(cityno+1);
				// String citynametodata=cityarray1.get(cityno+2);
				 System.out.println("API CIty name is "+citynamefromdata);
				// System.out.println("API CIty name is "+citynametodata);
				
				 Select s = new Select(localcityfrom);
				s.selectByValue(citynamefromdata);
			
				
		//		LocaluploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				
				if(!(gstn==null))
				{
				Localgst.sendKeys(gstn);
				}
				if(!(cgst==null))
				{
				Localcgst.sendKeys(cgst);
				}
				if(!(sgst==null))
				{
				Localsgst.sendKeys(sgst);
				}
				if(!(igst==null))
				{
				Localigst.sendKeys(igst);
				}
				if(!(Lremarks==null))
				{
				Localremarks.sendKeys(Lremarks);
				}
				
				System.out.println(is_Document_Mandatry.equalsIgnoreCase("True"));
				
				if(is_Document_Mandatry.equalsIgnoreCase("True"))  
				{
					Thread.sleep(1000);
					LocaluploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				
				}
				
				
				if((Date==null) && (Lamount==null) && (fromplace==null)&&(toplace==null)&& (is_Document_Mandatry.equalsIgnoreCase("True"))) 
				{  
					localbillamt.clear();
					LocaluploadFile.clear();
					System.out.println("here inside null");
					JavascriptExecutor js6 = (JavascriptExecutor) driver;
					js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", LocalsaveDraft);
			Thread.sleep(1000);
			
			System.out.println(Ldateerrormsg.getText());
			assertTrue(Ldateerrormsg.getText().equalsIgnoreCase("Please select date of claim !"));
			
			System.out.println(Lamterrormsg.getText());
			assertTrue(Lamterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
			
			System.out.println(Lfrmplcerrormsg.getText());
			assertTrue(Lfrmplcerrormsg.getText().equalsIgnoreCase("Please select from place !"));
			
			System.out.println(Ltoplcerrormsg.getText());
			assertTrue(Ltoplcerrormsg.getText().equalsIgnoreCase("Please select to place !"));
			
			System.out.println(Luploaderrormsg.getText());
			assertTrue(Luploaderrormsg.getText().equalsIgnoreCase("Please upload voucher !"));
			
				}
				
				
				
				else if((Date==null) && (Lamount==null) && (fromplace==null)&&(toplace==null))
				{
					JavascriptExecutor js6 = (JavascriptExecutor) driver;
					js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", LocalsaveDraft);
			Thread.sleep(1000);
			
			System.out.println(Ldateerrormsg.getText());
			assertTrue(Ldateerrormsg.getText().equalsIgnoreCase("Please select date of claim !"));
			
			System.out.println(Lamterrormsg.getText());
			assertTrue(Lamterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
			
			System.out.println(Lfrmplcerrormsg.getText());
			assertTrue(Lfrmplcerrormsg.getText().equalsIgnoreCase("Please select from place !"));
			
			System.out.println(Ltoplcerrormsg.getText());
			assertTrue(Ltoplcerrormsg.getText().equalsIgnoreCase("Please select to place !"));
				}
				else
				{
					
				JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
			    		+ "arguments[0].dispatchEvent(evt);", LocalsaveDraft);
//			    Alert alertsuccess = driver.switchTo().alert();
//				String alerttextsuccess1 = driver.switchTo().alert().getText();
//				System.out.println(alerttextsuccess1);
//				assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense added successfully"));
//				alertsuccess.accept();
				
			    assertTrue((localsuccessmessage.getText().equalsIgnoreCase("Expense added successfully. !")));
				}
	}
	public void othersAddSteps(String user,String pass,String NOE,String Date,String oamount,String location,String CB,String othersRemarks,String domain,String gstn, String cgst, String sgst, String igst) throws InterruptedException

	{
		String noename="";
		String noestatus="";
		TestData.GetData gdata = new  TestData.GetData();
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+""+"&domain="+domain);
			
			
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int k=0;
		
		 String userData=array1.get(k);
		 String passData=array1.get(k+1);
		 String empdata=array1.get(k+2);
		 String bandid=array1.get(k+3);
		 System.out.println(bandid);
		// String noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim?domain="+domain);
		 System.out.println(BaseUrl+"/api/otherClaim/Get?domain="+domain);
		 String noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?domain="+domain);
		 System.out.println("noeresponse1 name is:->>>>>>>>>"+noeresponse1);

		 ArrayList<String> noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		 
		for(int j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			System.out.println(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"&domain="+domain);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"&domain="+domain);
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			 System.out.println("noepolicyarray1 name is:->>>>>>>>>"+noepolicyarray1);
			 
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0  )
			{
				noestatus= noepolicyarray1.get(1);
				if(noestatus.equalsIgnoreCase("True"))
				{
					
				
				j=noearray1.size();
				}
			}
		}
		System.out.println("Noe name2 is:->>>>>>>>>"+noename);
		 Select selecttype = new Select(calimtypelement); 
			selecttype.selectByVisibleText("Other");
	if(!(NOE==null))
	{
		
	
			 Select selecnature = new Select(Othernature); 
			 selecnature.selectByValue(noename);
			 
			
	}
	
				  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/FieldMaster/GetFieldMaster?intClaimType=1&vcModule=Apply&Domain="+domain);
					// array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
					 ArrayList<String> fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
					 System.out.println("New array"+fieldstatusarray);
					 int arrayln= fieldstatusarray.size();
					 System.out.println(arrayln);

					 
					 for(int fsize=0;fsize<fieldstatusarray.size();fsize++)
						{							
						 String field=fieldstatusarray.get(fsize);
							System.out.println("field Id is ->>>>>>>>"+field);
							 String status= fieldstatusarray.get(fsize+1);
							System.out.println("status is  ->>>>>>>>"+status);
							fsize=fsize+1;
							if(field.equalsIgnoreCase("divTypeOfVisit")&& status.equalsIgnoreCase("True"))
							{
								Thread.sleep(1000);
								 Select selectothertype = new Select(othertypeofvisit); 
									selectothertype.selectByVisibleText("Other");
								
								fsize=fieldstatusarray.size();
								
							}
						}
					 
					 ArrayList<String> wbsarray = new ArrayList<String>();
						
						
						System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
						String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
						 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
						System.out.println(wbsarray+"array");
						int wbscount=0;
						String wbsdata=wbsarray.get(wbscount+1);
						System.out.println("API wbs mode name is "+wbsdata);
						WebDriverWait wait =  new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.visibilityOf(OthersclientBorrower));
						Select s4 = new Select(OthersclientBorrower);
						s4.selectByValue(wbsdata);
				
						wait.until(ExpectedConditions.visibilityOf(otherinvoiceno));
				otherinvoiceno.sendKeys("15");
				
				System.out.println(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"&domain="+domain);
				 String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"&domain="+domain);
				 ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
				is_Document_Mandatry= noepolicyarray1.get(2);
				System.out.println("is_Document_Mandatry is"+is_Document_Mandatry);
					
				
				dateclaimpolicy=noepolicyarray1.get(3);
				
				System.out.println("date policy is"+dateclaimpolicy);
					if(dateclaimpolicy.equalsIgnoreCase("Per Month"))
					{
						if(!(Date== null))
						{
				JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
				jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
						+ "arguments[0].dispatchEvent(evt);", Otherfrom);
				JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
				jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlOther_CalendarExtender1_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
										"")));
				
				JavascriptExecutor jscalenderopento = (JavascriptExecutor) driver;
				jscalenderopento.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", Otherto);
				
				Thread.sleep(500); 
				
				JavascriptExecutor jscalendertodate = (JavascriptExecutor) driver;
				jscalendertodate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlOther_calExeToDate_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
										"")));
						}
				
				}
					else if(dateclaimpolicy.equalsIgnoreCase("Per Day"))
					{
						if(!(Date== null))
						{
						
						JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
						jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
								+ "arguments[0].dispatchEvent(evt);", Otherfrom);
						Thread.sleep(500);
						JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
						jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
										+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlOther_CalendarExtender1_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
												"")));
					}
						
					}
				
			
				System.out.println("date is"+localDate);
				
				 Thread.sleep(1000);
				 if(!(oamount==null)) {
					 
				 othersAmount.sendKeys("500");
				 }
				 if(!(location==null))
				 {
				 otherlocation.sendKeys("Mumbai");
				 }
				 
				 OthersuploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				
				 if(!(gstn==null))
				 {
				 Othergstn.sendKeys("543576789889123");
				 }
				 if(!(cgst==null))
				 {
				 Othercgst.sendKeys("5");
				 }
				 if(!(sgst==null))
				 {
				 Othersgst.sendKeys("10");
				 }
				 if(!(igst==null))
				 {
				 Otherigst.sendKeys("10");
				 }
				 if(!(othersRemarks==null))
				 {				 
				 Othersremarks.sendKeys(othersRemarks);
				 }
				 
			
				
					
				if(is_Document_Mandatry.equalsIgnoreCase("True"))  
				{
					Thread.sleep(1000);
					OthersuploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				
				}
				 if((NOE==null) && (Date== null)&& (oamount==null) && (is_Document_Mandatry.equalsIgnoreCase("True"))) 
				 {
					 OthersuploadFile.clear();
						System.out.println("here inside null");
						JavascriptExecutor js6 = (JavascriptExecutor) driver;
						js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", OtherssaveDraft);
				Thread.sleep(1000);
				
				System.out.println(noeerrormsg.getText());
				assertTrue(noeerrormsg.getText().equalsIgnoreCase("Please select nature of expenses !"));
				
				System.out.println(odateerrormsg.getText());
				assertTrue(odateerrormsg.getText().equalsIgnoreCase("Please enter date of claim !"));
				
				System.out.println(oamterrormsg.getText());
				assertTrue(oamterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
				
				System.out.println(otheruploaderrormsg.getText());
				assertTrue(otheruploaderrormsg.getText().equalsIgnoreCase("Please upload voucher !"));
				
						
					}
					else if((NOE==null) && (Date== null)&& (oamount==null)) {
						System.out.println("here inside null");
						JavascriptExecutor js6 = (JavascriptExecutor) driver;
						js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", OtherssaveDraft);
				Thread.sleep(1000);
				
				System.out.println(noeerrormsg.getText());
				assertTrue(noeerrormsg.getText().equalsIgnoreCase("Please select nature of expenses !"));
				
				System.out.println(odateerrormsg.getText());
				assertTrue(odateerrormsg.getText().equalsIgnoreCase("Please enter date of claim !"));
				
				System.out.println(oamterrormsg.getText());
				assertTrue(oamterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
				
				 }
				else
				{
					Thread.sleep(500);
				 JavascriptExecutor js3 = (JavascriptExecutor) driver;
				    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
				    		+ "arguments[0].dispatchEvent(evt);", OtherssaveDraft);
//				    Alert alertsuccess = driver.switchTo().alert();
//					String alerttextsuccess1 = driver.switchTo().alert().getText();
//					System.out.println(alerttextsuccess1);
//					assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense added successfully"));
//					alertsuccess.accept();	
				    assertTrue((othersuccessmessage.getText().equalsIgnoreCase("Expense added successfully. !")));
				}
				}
					
							

	public void mobileAddSteps(String EmployeeuserName,String EmployeepassWord,String Date,String mamount,String CB,String mRemarks, String domain, String gstn, String cgst, String sgst, String igst,String mobnumber) throws InterruptedException

	{
		
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+""+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 String empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
		 
		 //Mobile
		 Select selecttype = new Select(calimtypelement); 
			selecttype.selectByVisibleText("Mobile");
			
			Mobilenumber.clear();
			 userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/FieldMaster/GetFieldMaster?intClaimType=1&vcModule=Apply&Domain="+domain);
				// array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
				 ArrayList<String> fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
				 System.out.println("New array"+fieldstatusarray);
				 int arrayln= fieldstatusarray.size();
				 System.out.println(arrayln);

				 
				 for(int fsize=0;fsize<fieldstatusarray.size();fsize++)
					{
						
						
						
						
						
					 String field=fieldstatusarray.get(fsize);
						System.out.println("field Id is ->>>>>>>>"+field);
						 String status= fieldstatusarray.get(fsize+1);
						System.out.println("status is  ->>>>>>>>"+status);
						fsize=fsize+1;
						if(field.equalsIgnoreCase("divTypeOfVisit")&& status.equalsIgnoreCase("True"))
						{Select visit = new Select(Mobiletypeofvisit);
						visit.selectByVisibleText("Other");
							
							fsize=fieldstatusarray.size();
							
							
						}
					}
				 
				 ArrayList<String> wbsarray = new ArrayList<String>();
					
					TestData.GetData gdata = new  TestData.GetData();
					System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
					String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
					 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
					System.out.println(wbsarray+"array");
					int wbscount=0;
					String wbsdata=wbsarray.get(wbscount+1);
					System.out.println("API wbs mode name is "+wbsdata);
					Select s4 = new Select(MobileclientBorrower);
					s4.selectByValue(wbsdata);
			
			
			Mobileinvoiceno.sendKeys("56");
			System.out.println(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Mobile&Band="+bandid+"&Domain="+domain);
			userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Mobile&Band="+bandid+"&Domain="+domain);
			  fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println("New documetarry is"+fieldstatusarray);
			
			
			is_Document_Mandatry= fieldstatusarray.get(1);
			dateclaimpolicy=fieldstatusarray.get(2);
			
			
			if(!(Date==null))
			{
			if(dateclaimpolicy.equalsIgnoreCase("Per Month"))
			{
			JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
			jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
					+ "arguments[0].dispatchEvent(evt);", Mobilefromdate);
			JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
			jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlMobile_CalendarExtender1_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
									"")));
			
			JavascriptExecutor jscalenderopento = (JavascriptExecutor) driver;
			jscalenderopento.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", Mobiletodate);
			
			Thread.sleep(500); 
			
			JavascriptExecutor jscalendertodate = (JavascriptExecutor) driver;
			jscalendertodate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlMobile_calExeToDate_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
									"")));
		 
			}
			else if(dateclaimpolicy.equalsIgnoreCase("Per Day"))
			{
			
				
				JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
				jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
						+ "arguments[0].dispatchEvent(evt);", Mobilefromdate);
				JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
				jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlMobile_CalendarExtender1_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
										"")));
			
			}
			}
				if(!(mamount==null))
				{
			mobileAmount.sendKeys("550");
				}
			Thread.sleep(1500);
		
			
			if(!(gstn==null))
			{
			Mobilegstn.sendKeys(gstn);
			}
			if(!(cgst==null))
			{
			Mobilecgst.sendKeys(cgst);
			}
			if(!(sgst==null))
			{
			Mobilesgst.sendKeys(sgst);
			}
			if(!(igst==null))
			{
			Mobileigst.sendKeys(igst);
			}
			if(!(mamount==null)) 
			{
			mobileremarks.sendKeys(mRemarks);
			}
			if(!(mobnumber==null)) 
			{
			Mobilenumber.sendKeys(mobnumber);
			}
			Thread.sleep(1500);
			
			
			
			
				
			if(is_Document_Mandatry.equalsIgnoreCase("True"))  
			{
				Thread.sleep(1000);
				MobileuploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
			
			}
			
					
			
			if((Date==null)&& (mamount== null)&&(mobnumber==null)&&(is_Document_Mandatry.equalsIgnoreCase("True")))
			{
				MobileuploadFile.clear();
				Mobilenumber.clear();
				System.out.println("here inside null");
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
				js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", MobilesaveDraft);
		Thread.sleep(1000);
		
		System.out.println(Mdatererror.getText());
		assertTrue(Mdatererror.getText().equalsIgnoreCase("Please enter date of claim !"));
		System.out.println(Mamterror.getText());
		assertTrue(Mamterror.getText().equalsIgnoreCase("Please enter total bill amount !"));
		System.out.println(Muploaderror.getText());
		assertTrue(Muploaderror.getText().equalsIgnoreCase("Please upload voucher !"));
		System.out.println(Mobnumerror.getText());
		assertTrue(Mobnumerror.getText().equalsIgnoreCase("Please enter valid mobile number !"));
			}
			 else if((Date==null)&& (mamount== null)&&(mobnumber==null)){
				{
					Mobilenumber.clear();
					System.out.println("here inside null");
					JavascriptExecutor js6 = (JavascriptExecutor) driver;
					js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", MobilesaveDraft);
			Thread.sleep(1000);
			
			System.out.println(Mdatererror.getText());
			assertTrue(Mdatererror.getText().equalsIgnoreCase("Please enter date of claim !"));
			System.out.println(Mamterror.getText());
			assertTrue(Mamterror.getText().equalsIgnoreCase("Please enter total bill amount !"));
			System.out.println(Muploaderror.getText());
			assertTrue(Muploaderror.getText().equalsIgnoreCase("Please upload voucher !"));
			System.out.println(Mobnumerror.getText());
			assertTrue(Mobnumerror.getText().equalsIgnoreCase("Please enter valid mobile number !"));
				}
			}
			else
			{
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
		    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
		    		+ "arguments[0].dispatchEvent(evt);", MobilesaveDraft);
//		    Alert alertsuccess = driver.switchTo().alert();
//			String alerttextsuccess1 = driver.switchTo().alert().getText();
//			System.out.println(alerttextsuccess1);
//			assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense added successfully"));
//			alertsuccess.accept();	
		    assertTrue((mobilesuccessmessage.getText().equalsIgnoreCase("Expense added successfully. !")));
			
			}

	}

	public void hotelAddSteps(String EmployeeuserName,String EmployeepassWord,String Date,String hamount,String CB,String hRemarks, String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException

	{
		
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+""+"&domain="+domain);
			
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String bandid=array1.get(i+3); 
		
		 Select selecttype = new Select(calimtypelement); 
			selecttype.selectByVisibleText("Hotel");
			
	
		 
			userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/FieldMaster/GetFieldMaster?intClaimType=1&vcModule=Apply&Domain="+domain);
			// array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 ArrayList<String> fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println("New array"+fieldstatusarray);
			 int arrayln= fieldstatusarray.size();
			 System.out.println(arrayln);

			 
			 for(int fsize=0;fsize<fieldstatusarray.size();fsize++)
				{
					
					
				 String field=fieldstatusarray.get(fsize);
					System.out.println("field Id is ->>>>>>>>"+field);
					 String status= fieldstatusarray.get(fsize+1);
					System.out.println("status is  ->>>>>>>>"+status);
					fsize=fsize+1;
					if(field.equalsIgnoreCase("divTypeOfVisit")&& status.equalsIgnoreCase("True"))
					{
						Select visit = new Select(Hoteltypeofvisit);
						visit.selectByVisibleText("Other");
						
						fsize=fieldstatusarray.size();
						
					}
				}
			 
			 ArrayList<String> wbsarray = new ArrayList<String>();
				
				TestData.GetData gdata = new  TestData.GetData();
				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
				String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				System.out.println(wbsarray+"array");
				int wbscount=0;
				String wbsdata=wbsarray.get(wbscount+1);
				System.out.println("API wbs mode name is "+wbsdata);
				Select s4 = new Select(Hotelclientborrower);
				s4.selectByValue(wbsdata);
			
			Hotelinvoiceno.sendKeys("15");
			
			
			System.out.println(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Accomodation&Band="+bandid+"&Domain="+domain);
			userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Accomodation&Band="+bandid+"&Domain="+domain);
			  fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println("New documetarry is"+fieldstatusarray);
			
			 System.out.println(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Accomodation&Band="+bandid+"&Domain="+domain);
			is_Document_Mandatry= fieldstatusarray.get(1);
			
			dateclaimpolicy=fieldstatusarray.get(2);
//			
			
//			String datepolicy=fieldstatusarray.get(index)
//			
//			if()
//			{
//			}
			
			if(dateclaimpolicy.equalsIgnoreCase("Per Month"))
			{
			
			
			if(!(Date==null))
			{
	
			JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
			jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
					+ "arguments[0].dispatchEvent(evt);", Hotelfromdate);
			JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
			jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlHotel_CalendarExtender1_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
									"")));
			
	
			
			JavascriptExecutor jscalenderopento = (JavascriptExecutor) driver;
			jscalenderopento.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", Hoteltodate);
			
			Thread.sleep(500); 
			
			JavascriptExecutor jscalendertodate = (JavascriptExecutor) driver;
			jscalendertodate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlHotel_calExeToDate_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
									"")));
			
			}
	
			}
			else if(dateclaimpolicy.equalsIgnoreCase("Per Day"))
			{
				{
					if(!(Date==null))
					{
					JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
					jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
							+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
							+ "arguments[0].dispatchEvent(evt);", Hotelfromdate);
					JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
					jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
							+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlHotel_CalendarExtender1_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
											"")));
					}
			}
			}
			TestData.GetData citydata = new  TestData.GetData();
			 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
			 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			 int cityno=0;
			 String citynamefromdata=cityarray1.get(cityno+1);
			// String citynametodata=cityarray1.get(cityno+2);
			 System.out.println("API CIty name is "+citynamefromdata);
			//System.out.println("API CIty name is "+citynametodata);
			
			 if(!(citynamefromdata==null))
			 {
			 Select s = new Select(hotelcity);
			s.selectByValue(citynamefromdata);
			 }
			if(!(hamount==null))
			{
			hotelAmount.sendKeys(hamount);
			}
		
			
				
			if(is_Document_Mandatry.equalsIgnoreCase("True"))  
			{
				Thread.sleep(1000);
				HoteluploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
			
			}
			
			
			
			
			if(!(igst==null))
			{
			hoteligst.sendKeys(igst);
			}
			if(!(sgst==null))
			{
			hotelsgst.sendKeys(sgst);
			}
			if(!(cgst==null))
			{
			hotelcgst.sendKeys(cgst);
			}
			if(!(gstn==null))
			{
			hotelgstn.sendKeys(gstn);
			}
		 
			if(!(hRemarks==null))
			{
			hotelremarks.sendKeys(hRemarks);
			}
			
			if((Date==null) && (hamount== null)&& (is_Document_Mandatry.equalsIgnoreCase("True"))) {
				HoteluploadFile.clear();
				System.out.println("here inside null");
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
				js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", HotelsaveDraft);
		Thread.sleep(1000);
		System.out.println(hdateerror.getText());
		assertTrue(hdateerror.getText().equalsIgnoreCase("Please enter date of claim !"));
		
		System.out.println(hamterrormsg.getText());
		assertTrue(hamterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
		
		System.out.println(huploadfileerrormsg.getText());
		assertTrue(huploadfileerrormsg.getText().equalsIgnoreCase("Please upload voucher !"));
								
			}
			else if((Date==null) && (hamount== null))
			{
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
				js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", HotelsaveDraft);
		Thread.sleep(1000);
		System.out.println(hdateerror.getText());
		assertTrue(hdateerror.getText().equalsIgnoreCase("Please enter date of claim !"));
		
		System.out.println(hamterrormsg.getText());
		assertTrue(hamterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
			}
			
			else
			{
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
		    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
		    		+ "arguments[0].dispatchEvent(evt);", HotelsaveDraft);
		    Thread.sleep(500);
//		    Alert alertsuccess = driver.switchTo().alert();
//		    
//			String alerttextsuccess1 = driver.switchTo().alert().getText();
//			System.out.println(alerttextsuccess1);
//			assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense added successfully"));
//			alertsuccess.accept();
			
		    assertTrue((hotelsuccessmessage.getText().equalsIgnoreCase("Expense added successfully. !")));
			}
			

	}

	public void foodAddSteps(String EmployeeuserName,String EmployeepassWord,String Date,String famount,
			String CB,String fRemarks,String domain,String gstn,String cgst, String sgst, String igst) throws InterruptedException

	{
		
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+""+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		 String bandid=array1.get(i+3);
		 
		
		 
		 
		 Select selecttype = new Select(calimtypelement); 
			selecttype.selectByVisibleText("Food");
			
					 
			  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/FieldMaster/GetFieldMaster?intClaimType=1&vcModule=Apply&Domain="+domain);
		// array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
		 ArrayList<String> fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
		 System.out.println("New array"+fieldstatusarray);
		 int arrayln= fieldstatusarray.size();
		 System.out.println(arrayln);

		 for(int fsize=0;fsize<fieldstatusarray.size();fsize++)
			{
				
				
				
				//String noename2=noepolicyarray1.get(1);
				//System.out.println("NOE name @@@@2 is ->>>."+noename2);
				
			 String field=fieldstatusarray.get(fsize);
				System.out.println("field Id is ->>>>>>>>"+field);
				 String status= fieldstatusarray.get(fsize+1);
				System.out.println("status is  ->>>>>>>>"+status);
				fsize=fsize+1;
				if(field.equalsIgnoreCase("divTypeOfVisit")&& status.equalsIgnoreCase("True"))
				{
					 Select selectfoodtype = new Select(Foodtypeofvisit); 
					 selectfoodtype.selectByVisibleText("Other");
					
					fsize=fieldstatusarray.size();
					
					
				}
			}
		 ArrayList<String> wbsarray = new ArrayList<String>();
			
			TestData.GetData gdata = new  TestData.GetData();
			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
			String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			System.out.println(wbsarray+"array");
			int wbscount=0;
			String wbsdata=wbsarray.get(wbscount+1);
			System.out.println("API wbs mode name is "+wbsdata);
			Select s4 = new Select(foodclientborrower);
			s4.selectByValue(wbsdata);
			Foodinvoiceno.sendKeys("56");
			 System.out.println(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domain);
			userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domain);
			fieldstatusarray= gdata.parseFromJSONarrayResponse(userresponse1);
				System.out.println("food place"+fieldstatusarray);
				for( i =0;i<=fieldstatusarray.size();i++)
				{
				
				
					String foodplacestatus = fieldstatusarray.get(i+1);
					if(foodplacestatus.equalsIgnoreCase("True"))
					{
						 foodplaceid= fieldstatusarray.get(i);
						i=fieldstatusarray.size();
					}
				}
				System.out.println(foodplaceid);
				
				 System.out.println(BaseUrl+"/api/FoodPolicy/GetBandWisePolicy?Band="+bandid+"&foodPlace="+foodplaceid+"&Domain="+domain);
				 
				userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/FoodPolicy/GetBandWisePolicy?Band="+bandid+"&foodPlace="+foodplaceid+"&Domain="+domain);
				  fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
				 System.out.println("New documetarry is....."+fieldstatusarray);
				
				//api/FoodPolicy/GetBandWisePolicy?Band={Band}&foodPlace={foodPlace}&Domain={Domain}
				is_Document_Mandatry= fieldstatusarray.get(1);
				
			dateclaimpolicy=fieldstatusarray.get(2);
				
				
				if(!(Date==null))
				{
					if(dateclaimpolicy.equalsIgnoreCase("Per Month"))
					{
				
				JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
				jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
						+ "arguments[0].dispatchEvent(evt);", foodfromdate);
				JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
				jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlFood_CalendarExtender2_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
										"")));
				
				
				
				JavascriptExecutor jscalenderopento = (JavascriptExecutor) driver;
				jscalenderopento.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", foodtodate);
				
				Thread.sleep(500); 
				
				JavascriptExecutor jscalendertodate = (JavascriptExecutor) driver;
				jscalendertodate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
								+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlFood_calExeToDate_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
										"")));
				}
				
					else if(dateclaimpolicy.equalsIgnoreCase("Per Day"))
					{
						JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
						jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
								+ "arguments[0].dispatchEvent(evt);", foodfromdate);
						JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
						jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
								+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
										+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctrlFood_CalendarExtender2_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
												"")));
					}
				}
			Thread.sleep(1000);
			
			
			TestData.GetData citydata = new  TestData.GetData();
			 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
			 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			 int cityno=0;
			 String citynamefromdata=cityarray1.get(cityno+1);
			// String citynametodata=cityarray1.get(cityno+2);
			 System.out.println("API CIty name is "+citynamefromdata);
			// System.out.println("API CIty name is "+citynametodata);
			
			 
			 if(!(citynamefromdata==null))
			 {
				 
			 Select s = new Select(foodCity);
			s.selectByValue(citynamefromdata);
			 }
			 
			 System.out.println(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domain);
			 userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domain);
			  fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
			  
			 System.out.println("New documetarry is"+fieldstatusarray);
		//	 System.out.println(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Food&Band="+bandid+"&Domain="+domain);
			 System.out.println(BaseUrl+"/api/FoodPolicy/GetBandWisePolicy?Band="+bandid+"&foodPlace=683&Domain="+domain);
			 
			
				
			if(is_Document_Mandatry.equalsIgnoreCase("True"))  
			{
				Thread.sleep(1000);
				foodFileUpload.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
			
			}
			 
			 if(!(domain.equalsIgnoreCase("lechler")))
					{
				System.out.println("Select food place");
				Select selectfoodplace = new Select(foodplace); 
			selectfoodplace.selectByVisibleText("Local");
			
			if(!(gstn==null))
			{
			foodgstn.sendKeys(gstn);
			}
			if(!(cgst==null))
			{
			foodcgst.sendKeys(cgst);
			}
			if(!(sgst==null))
			{
			foodsgst.sendKeys(sgst);
			}
			if(!(igst==null))
			{
			foodigst.sendKeys(igst);
			}
					}
			Thread.sleep(1000);
			
			if(!(fRemarks==null))
			{
			foodRemarks.sendKeys(fRemarks);
			}
			
			if(!(famount==null))
			{
			foodAmount.sendKeys(famount);
			}
			
			if((Date==null) && (famount== null)&& (is_Document_Mandatry.equalsIgnoreCase("True"))) {
				uploadFile.clear();
				System.out.println("here inside null");
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
				js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", foodSaveDraft);
		Thread.sleep(1000);
//		System.out.println(fdateerrormsg.getText());
//		assertTrue(fdateerrormsg.getText().equalsIgnoreCase("Please select date of claim !"));
		
		System.out.println(famterrormsg.getText());
		assertTrue(famterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
		
		System.out.println(fuploadfileerrormsg.getText());
		assertTrue(fuploadfileerrormsg.getText().equalsIgnoreCase("Please upload voucher !"));
		
				
			}
			
			else if((Date==null) && (famount== null))
			{
				System.out.println("here inside null");
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
				js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", foodSaveDraft);
		Thread.sleep(1000);
//		System.out.println(fdateerrormsg.getText());
//		assertTrue(fdateerrormsg.getText().equalsIgnoreCase("Please select date of claim !"));
		
		System.out.println(famterrormsg.getText());
		assertTrue(famterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
			}
			else
			{
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
		    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
		    		+ "arguments[0].dispatchEvent(evt);", foodSaveDraft);
//		    Alert alertsuccess = driver.switchTo().alert();
//			String alerttextsuccess1 = driver.switchTo().alert().getText();
//			System.out.println(alerttextsuccess1);
//			assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense added successfully"));
//			alertsuccess.accept();	
			
		    assertTrue((foodsuccessmessage.getText().equalsIgnoreCase("Expense added successfully. !")));

			}
		

	}

	public void LandlineAddSteps(String EmployeeuserName,String EmployeepassWord,String Date,String lamount,
			String CB,String lRemarks,String domain,String gstn,String cgst, String sgst, String igst) throws InterruptedException

	{
	
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+"&domain="+domain);
		
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		 String bandid=array1.get(i+3);
		
		
		Select selecttype = new Select(calimtypelement); 
		selecttype.selectByVisibleText("LandLine");

	 
		 userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/FieldMaster/GetFieldMaster?intClaimType=1&vcModule=Apply&Domain="+domain);
			// array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 ArrayList<String> fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println("New array"+fieldstatusarray);
			 int arrayln= fieldstatusarray.size();
			 System.out.println(arrayln);

		 
			 for(int fsize=0;fsize<fieldstatusarray.size();fsize++)
				{
														
				 String field=fieldstatusarray.get(fsize);
					System.out.println("field Id is ->>>>>>>>"+field);
					 String status= fieldstatusarray.get(fsize+1);
					System.out.println("status is  ->>>>>>>>"+status);
					fsize=fsize+1;
					if(field.equalsIgnoreCase("divTypeOfVisit")&& status.equalsIgnoreCase("True"))
					{
						 Select selectfoodtype = new Select(landlineTypeofvisit); 
						 selectfoodtype.selectByVisibleText("Other");
						
						fsize=fieldstatusarray.size();
						
					}
				}
			 
			 
			 ArrayList<String> wbsarray = new ArrayList<String>();
				
				TestData.GetData gdata = new  TestData.GetData();
				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
				String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				System.out.println(wbsarray+"array");
				int wbscount=0;
				String wbsdata=wbsarray.get(wbscount+1);
				System.out.println("API wbs mode name is "+wbsdata);
				Select s4 = new Select(landlineclientborrower);
				s4.selectByValue(wbsdata);
	
			
			Landlineinvoiceno.sendKeys("56");
			
			userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=LandLine&Band="+bandid+"&Domain="+domain);
			  fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println("New documetarry is"+fieldstatusarray);
			
			
			is_Document_Mandatry= fieldstatusarray.get(1);
			
			dateclaimpolicy=fieldstatusarray.get(2);
			
			if(!(Date==null))
			{
				if(dateclaimpolicy.equalsIgnoreCase("Per Month"))
				{
			JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
			jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
					+ "arguments[0].dispatchEvent(evt);", Landlinefromdate);
			JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
			jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctlLandline_CalendarExtender1_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
									"")));
			
			JavascriptExecutor jscalenderopento = (JavascriptExecutor) driver;
			jscalenderopento.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
						+ ".dispatchEvent(evt);", Landlinetodate);
			
			Thread.sleep(500); 
			
			JavascriptExecutor jscalendertodate = (JavascriptExecutor) driver;
			jscalendertodate.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
							+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctlLandline_calExeToDate_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
									"")));
			
			
			
			}
				else if(dateclaimpolicy.equalsIgnoreCase("Per Day"))
				{
			
					JavascriptExecutor jscalendericonclick = (JavascriptExecutor) driver;
					jscalendericonclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
							+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
							+ "arguments[0].dispatchEvent(evt);", Landlinefromdate);
					JavascriptExecutor jscalenderdate1 = (JavascriptExecutor) driver;
					jscalenderdate1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
							+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0]"
									+ ".dispatchEvent(evt);", driver.findElement(By.xpath("//*[contains(@id, 'ctl00_ContentPlaceHolder1_ctlLandline_CalendarExtender1_daysBody')]//*[contains(@title, '"+dtf.format(localDate)+"')]\r\n" + 
											"")));
			
				}
			}
			
			if(!(gstn==null))
			{			
			Landlinegstn.sendKeys(gstn);
			}
			if(!(cgst==null))
			{
			Landlinecgst.sendKeys(cgst);
			}
			if(!(sgst==null))
			{
			Landlinesgst.sendKeys(sgst);
			}
			if(!(igst==null))
			{
			Landlinetigst.sendKeys(igst);
			}
			if(!(lamount==null))
			{
			landlineAmount.sendKeys(lamount);
			}
			
			
			
			
							
    		if(is_Document_Mandatry.equalsIgnoreCase("True"))  
			{
				Thread.sleep(1000);
				landlineFileUpload.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
			
			}
			
						
			if(!(lRemarks==null))
			{
			landlineremarks.sendKeys(lRemarks);
			}
			if((Date==null) && (lamount==null) && (is_Document_Mandatry.equalsIgnoreCase("True")))
					{
				Thread.sleep(1000);
				
				System.out.println("here inside null");
				landlineFileUpload.clear();
				Thread.sleep(500);
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
				js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", landlineSaveDraft);
		Thread.sleep(1000);
		System.out.println(ldateerrormsg.getText());
		assertTrue(ldateerrormsg.getText().equalsIgnoreCase("Please select date of claim !"));
		
		System.out.println(lamterrormsg.getText());
		assertTrue(lamterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
		landlineFileUpload.clear();
		System.out.println(luploadfileerror.getText());
		assertTrue(luploadfileerror.getText().equalsIgnoreCase("Please upload voucher !"));
		
					}
			else if((Date==null) && (lamount==null))
			{
				System.out.println("here inside null");
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
				js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", landlineSaveDraft);
		Thread.sleep(1000);
		System.out.println(ldateerrormsg.getText());
		assertTrue(ldateerrormsg.getText().equalsIgnoreCase("Please select date of claim !"));
		
		System.out.println(lamterrormsg.getText());
		assertTrue(lamterrormsg.getText().equalsIgnoreCase("Please enter total bill amount !"));
			}
			else
			{
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
		    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
		    		+ "arguments[0].dispatchEvent(evt);", landlineSaveDraft);
//		    Alert alertsuccess = driver.switchTo().alert();
//			String alerttextsuccess1 = driver.switchTo().alert().getText();
//			System.out.println(alerttextsuccess1);
//			assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense added successfully"));
//			alertsuccess.accept();	
		    assertTrue((landlinesuccessmessage.getText().equalsIgnoreCase("Expense added successfully. !")));
			}
	}

}
