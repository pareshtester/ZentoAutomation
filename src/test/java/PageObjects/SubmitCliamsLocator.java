package PageObjects;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browsers.Urls;

public class SubmitCliamsLocator extends Urls {
	Calendar current = Calendar.getInstance();
WebDriver driver;
	String noeactive="";
	public SubmitCliamsLocator(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	String ClaimId="";
	String fromdate="";
	String empdata="";
	String noestatus="";
	String apiuserresponse="";
	@FindBy(xpath="//*[text() = '3066']")
	WebElement claimidlocator;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_FinalSubmit\"]")
	WebElement Claimsubmitlocator;
	//submit local
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_btnFinalSubmit\"]")
	WebElement ClaimsubmitLocallocator;
	//
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_FinalSubmit\"]")
	WebElement Claimsubmitotherlocator;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_FinalSubmit\"]")
	WebElement Claimsubmitmobilelocator;
	//submit Hotel
    @FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_btnFinalSubmit\"]")
	WebElement ClaimsubmitHotellocator;
	//submit food
    @FindBy(xpath="//*[@id='ctl00_ContentPlaceHolder1_ctrlFood_btnFinalSubmit']")
	WebElement Claimsubmitfoodlocator;
	//submit landline
    @FindBy(xpath="//*[@id='ctl00_ContentPlaceHolder1_ctrlLandline_btnFinalSubmit']")
	WebElement Claimsubmitlandlinelocator;
		//Navigation
	@FindBy(xpath=".//*[@id='make-small-nav']/i")
	WebElement SideMenu;
	@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl02_aDLink\"]/span[1]")
	WebElement Reportingopen;
	@FindBy(xpath="//*[@id=\"ctl00_rptMainMenu_ctl02_RptSubMenu_ctl00_lnkSubMenu\"]")
	WebElement ReportingClick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_txtFromDate']")
	WebElement fromDateclick;
	
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_txtToDate']")
	WebElement toDateclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_BtnApproved']")
	WebElement approve;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_BtnDisApproved']")
	WebElement disapprove;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_DDLActionRemarks']")
	WebElement selectReason;
	@FindBy(xpath="//*[@id='ctl00_ContentPlaceHolder1_txtOtherRemarks']")
	WebElement otherTextField;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_FinalSubmit\"]")
	WebElement submitelement;  
	String bandid="";
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblmsg2\"]")
	WebElement successmessage; 
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblmsg2\"]")
	WebElement rejectravelsuccess; 
	
	public String addTexpense(String user,String pass,String domain,String gstn,String cgst,String sgst,String igst)
	{
		if(gstn==null)
		{
			gstn="";
		}
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
				 
		
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		 

			TestData.GetData citydata = new  TestData.GetData();
			 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
			
		
			 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			 int cityno=0;
			
			 String citynamefromdata=cityarray1.get(cityno+1);
			 String citynametodata=cityarray1.get(cityno+2);
			 System.out.println("API CIty name is "+citynamefromdata);
			 System.out.println("API CIty name is "+citynametodata);
				 
		TestData.GetData gdata = new  TestData.GetData();
	String travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim"
			+ "&band="+bandid+"&domain="+domain);
	System.out.println(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim"
			+ "&band="+bandid+"&domain="+domain);
	 ArrayList<String> travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
	int travelmodecount=0;
	String travelmodedata=travelmodearray.get(travelmodecount);
	
	System.out.println("API travel mode name is "+travelmodearray);
	ArrayList<String> wbsarray = new ArrayList<String>();
	
	 gdata = new  TestData.GetData();
	System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
	String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
	 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
	System.out.println(wbsarray+"array");
	int wbscount=0;
	String wbsdata=wbsarray.get(wbscount+1);
	System.out.println("API wbs mode name is "+wbsdata);
	  
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	
	if((sgst==null) &&(igst==null)&&(cgst==null))
	 {
		
		 sgst="0";
		 cgst="0";
		 igst="0";
	 }
	
	System.out.println(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
	 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domain);
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
		 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
		 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domain);
		
		 
		
		 
		 
		 
	System.out.println(userresponse);
		 ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
		 int j=0;
		 System.out.println(array);
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		 return ClaimId;
	}
	public String addLexpense(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst,String localtmode,String Lamount)
	{
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
				 
		
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		 

			TestData.GetData citydata = new  TestData.GetData();
			 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
			
		
			 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			 int cityno=0;
			
			 String citynamefromdata=cityarray1.get(cityno+1);
			 String citynametodata=cityarray1.get(cityno+2);
			 System.out.println("API CIty name is "+citynamefromdata);
			 System.out.println("API CIty name is "+citynametodata);
				 
		TestData.GetData gdata = new  TestData.GetData();
		String travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&domain="+domain);

		 ArrayList<String> travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
		 System.out.println("prining travel mode array"+travelmodearray);
		 System.out.println("prining travel mode array size"+travelmodearray.size());
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
		}
		System.out.println("prining travel mode "+travelmodedata);
		System.out.println("prining travel mode name"+travelmodetext);
		userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Local&Band="+bandid+"&Domain="+domain);
		 ArrayList<String>  fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
		 System.out.println("New documetarry is"+fieldstatusarray);
		
		 String traveldistance="";
			String travelcost="";
		
			String newtravelmode="";
		
		for(i=0;i<=fieldstatusarray.size();i++)
		{
			 newtravelmode=fieldstatusarray.get(i+2);
			
			if(travelmodedata.equalsIgnoreCase(newtravelmode)) {
				
				
				 traveldistance=fieldstatusarray.get(i+1);
				System.out.println("Travel Distance"+traveldistance);
				 travelcost=fieldstatusarray.get(i);
				System.out.println("Travel cost"+travelcost);
//				dateclaimpolicy=fieldstatusarray.get(i+5);
//				System.out.println("dateclaimpolicy"+dateclaimpolicy);
				i=fieldstatusarray.size();
				
			}
			i=i+5;
			 System.out.println("API newtravelmode name is "+newtravelmode);	
			 
		}
		
		
		double result=0;
		
		if(!(Lamount==null))
		{
		if(!(traveldistance.equalsIgnoreCase("0"))&& (!(travelcost.equalsIgnoreCase("0"))))
				{
		
		
			 result= ((Double.parseDouble(traveldistance))*(Double.parseDouble(travelcost)));
		
	
				}
		
		else if((traveldistance.equalsIgnoreCase("0"))&& ((travelcost.equalsIgnoreCase("0"))))
		{
			
			 result= ((Double.parseDouble(traveldistance))*(Double.parseDouble(travelcost)));
				result=((Double.parseDouble(Lamount)));
			
		}
		else if((traveldistance.equalsIgnoreCase("0")) && (!(travelcost.equalsIgnoreCase("0"))))
		{
		
			 result= (55)*(Double.parseDouble(travelcost));
		
		}
		else if(!(traveldistance.equalsIgnoreCase("0")) && (travelcost.equalsIgnoreCase("0")))
		{
			// result= ((Double.parseDouble(traveldistance))*(Double.parseDouble(travelcost)));
			
			result=1;
			
		
		}
		
		}
	
//	travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Local&Band="+bandid+"&Domain="+domain);
//
//	
//	travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
//	
//	 System.out.println("2."+travelmodearray);
	  
	 ArrayList<String> wbsarray = new ArrayList<String>();
		
		 gdata = new  TestData.GetData();
		System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
		String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		System.out.println(wbsarray+"array");
		int wbscount=0;
		String wbsdata=wbsarray.get(wbscount+1);
		System.out.println("API wbs mode name is "+wbsdata); 
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
		TestData.GetData gdata2 = new  TestData.GetData();
		
		if(sgst==null && cgst==null && igst==null)
		{
			sgst="0";
			cgst="0";
			igst="0";
		}
		
		
		System.out.println(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
		 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+newtravelmode+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
 				+ "&travelFrom=chinchpokli"
 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0"
 				+ "&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756"
 				+ "&OtherFromCity=&OtherToCity=&Domain="+domain);
		
		
		 String userresponse = gdata2.getContenxtWeb(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
		 		+ "&amount="+result+"&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+newtravelmode+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
		 				+ "&travelFrom=chinchpokli"
		 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0"
		 				+ "&GSTIncluded=True&Km="+traveldistance+"&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756"
		 				+ "&OtherFromCity=&OtherToCity=&Domain="+domain);
		
	System.out.println(userresponse);
		 ArrayList<String> array = gdata2.parseFromJSONarrayResponse(userresponse);
		 int j=0;
		
		  ClaimId=array.get(j);
		 System.out.println(ClaimId);
		 return ClaimId;
	}
	
	
	public String addMexpense(String user,String pass,String domain,String gstn, String cgst, String sgst, String igst)
	{
		
		if(gstn==null)
		{
			gstn="";
		}
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
					 
	
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		 

		
			
				 
		 ArrayList<String> wbsarray = new ArrayList<String>();
			
			TestData.GetData gdata = new  TestData.GetData();
			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
			String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			System.out.println(wbsarray+"array");
			int wbscount=0;
			String wbsdata=wbsarray.get(wbscount+1);
			System.out.println("API wbs mode name is "+wbsdata);
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	
	if(sgst==null && igst==null && cgst==null)
	{
		sgst="0";
		cgst="0";
		igst="0";
	}
	
//		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
//		 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
//		 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain"+domain);
		
	
	System.out.println(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"&amount=300"
	 		+ "&TravelDateTo="+dtf.format(localDate)+"&Remarks=tst&EmpID="+empdata+"&week=11/27/2016~12/03/2016&WBS="+wbsdata+"&Exceed_Amt=200&TaxAmt=200&GSTIncluded=true"
	 		+ "&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&ContactNumber=8698294937&Domain="+domain);
	
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"&amount=300"
		 		+ "&TravelDateTo="+dtf.format(localDate)+"&Remarks=tst&EmpID="+empdata+"&week=11/27/2016~12/03/2016&WBS="+wbsdata+"&Exceed_Amt=200&TaxAmt=200&GSTIncluded=true"
		 		+ "&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&ContactNumber=8698294937&Domain="+domain);
	
		 ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
		 int j=0;
		
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		 return ClaimId;
	}
	
	
	public String addHexpense(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst)
	{
		if(gstn==null)
		{
			gstn="";
		}
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
	
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		 

			TestData.GetData citydata = new  TestData.GetData();
			 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
			
		
			 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			 int cityno=0;
			
			 String citynamefromdata=cityarray1.get(cityno+1);
			
			 System.out.println("API CIty name is "+citynamefromdata);
			 
				 
			 ArrayList<String> wbsarray = new ArrayList<String>();
			 
			
				
				TestData.GetData gdata = new  TestData.GetData();
				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
				String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				System.out.println(wbsarray+"array");
				int wbscount=0;
				String wbsdata=wbsarray.get(wbscount+1);
				System.out.println("API wbs mode name is "+wbsdata);
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	
	if(sgst==null && cgst==null && igst==null)
	{
		sgst="0";
		cgst="0";
		igst="0";
	}
	
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
		 		+ "&NoOfDays=1&amount=500&Remarks=test"
		 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=test&Domain="+domain);
		
	//System.out.println(userresponse);
		 ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
		 int j=0;
		
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		 return ClaimId;
	}
   
	public String addFexpense(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst)
	{
		if(gstn==null)
		{
			gstn="";
		}
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		 

			TestData.GetData citydata = new  TestData.GetData();
			 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
			
		
			 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			 int cityno=0;
			
			 String citynamefromdata=cityarray1.get(cityno+1);
			
			 System.out.println("API CIty name is "+citynamefromdata);
			
			 ArrayList<String> wbsarray = new ArrayList<String>();
				
				TestData.GetData gdata = new  TestData.GetData();
				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
				String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				int wbscount=0;
				String wbsdata=wbsarray.get(wbscount+1);
				System.out.println("API wbs mode name is "+wbsdata);
				 
		
	String foodid="";
	System.out.println(BaseUrl+"/api/FoodClaim/GetFoodType?domain="+domain);
	String foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?domain="+domain);
	ArrayList<String> foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
	for(int fsize=0;fsize<foodTypeyarray1.size();fsize++)
	{
		
		
		
		//String noename2=noepolicyarray1.get(1);
		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
		
		foodid = foodTypeyarray1.get(fsize);
		System.out.println("Food Id is ->>>>>>>>"+foodid);
		String foodidactive= foodTypeyarray1.get(fsize+1);
		System.out.println("Food Id status is  ->>>>>>>>"+foodidactive);
		if(foodidactive.equalsIgnoreCase("True"))
		{
			fsize=foodTypeyarray1.size();
		}
	}
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	
	if(cgst==null && sgst==null && igst==null)
	{
		cgst="0";
		sgst="0";
		igst="0";
	}
	
	
	System.out.println(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&"
			+ "Location="+citynamefromdata+"&NoOfDays=1&amount=500&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&"
			 + "GSTIncluded=True&foodPlace="+foodid+"&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domain);
	
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&"
		+ "Location="+citynamefromdata+"&NoOfDays=1&amount=500&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&"
		 + "GSTIncluded=True&foodPlace="+foodid+"&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domain);
		
		
	//System.out.println(userresponse);
		 ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
		 int j=0;
		
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		 return ClaimId;
	}

	
	public String addLandlineexpense(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst)
	{
		if(gstn==null)
		{
			gstn="";
		}
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		 

			TestData.GetData citydata = new  TestData.GetData();
			
				 
			 ArrayList<String> wbsarray = new ArrayList<String>();
				
				TestData.GetData gdata = new  TestData.GetData();
				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
				String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				System.out.println(wbsarray+"array");
				int wbscount=0;
				String wbsdata=wbsarray.get(wbscount+1);
				System.out.println("API wbs mode name is "+wbsdata);
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	
	if((sgst==null) &&(igst==null)&&(cgst==null))
	 {
		
		 sgst="0";
		 cgst="0";
		 igst="0";
	 }
	
	System.out.println(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
	 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756&Domain="+domain);
		
	
	String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
		 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
		 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756&Domain="+domain);
		
	//System.out.println(userresponse);
		 ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
		 int j=0;
		
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		 return ClaimId;
	}
	public void submittravelexpensesteps(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException
	{
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
				 
		
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		
		 Thread.sleep(10000);
		//WebDriverWait wait  = new WebDriverWait(driver, 10);
	//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
		// claimidlocator.click();
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
		    for( i=2; i<=size;i++)
		    {
		    	
		    		
		    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
		    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
		    	System.out.println("This is claim i am looking"+claim);
		    	if(claim.equalsIgnoreCase(ClaimId))
		    	{
		    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
		    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
		    	    i=size;
		    	}
		    	
		    	
		    }
		    Thread.sleep(10000);
		    
		    
		    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
		    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
			  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println(array1);
			 String claimtype= array1.get(1);
			 System.out.println("Claim type status is"+claimtype);
			 
			 if(claimtype.equalsIgnoreCase("0"))
			 {
				 
			
			 JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", submitelement);
    	    
    	    
			 }
			 else {
		    JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", Claimsubmitlocator);
		 //Claimsubmitlocator.click();
			 }
//		 Alert alert1 = driver.switchTo().alert();
//			String alerttext1 = driver.switchTo().alert().getText();
//			System.out.println(alerttext1);
//			assertTrue(alerttext1.equalsIgnoreCase("Claim submitted successfully"));
//			alert1.accept();
			 
			    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim submitted successfully. !"));


	}
	public String addOexpense(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst)
	{
		if(gstn==null)
		{
			gstn="";
		}
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	     
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		 System.out.println("array1" +array1);
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
        bandid= array1.get(i+3);
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		 

			
				 
		 ArrayList<String> wbsarray = new ArrayList<String>();
			
			TestData.GetData gdata = new  TestData.GetData();
			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
			String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domain);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			//System.out.println(wbsarray+"array");
			int wbscount=0;
			String wbsdata=wbsarray.get(wbscount+1);
			System.out.println("API wbs mode name is "+wbsdata);
	
	String noename="";
	//TestData.GetData gdata = new  TestData.GetData();
	 String noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?domain="+domain);
		System.out.println("noeresponse1:->>>>>>>>>"+noeresponse1);

	 ArrayList<String> noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		System.out.println("noearray1:->>>>>>>>>"+noearray1);
	for(int j=0;j<noearray1.size();j++)
	{
		
		 noename=noearray1.get(j);
		System.out.println("Noe name is:->>>>>>>>>"+noename);
		String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"&domain="+domain);
		System.out.println(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&domain="+domain);
	     System.out.println("noepolicyresponse1"+noepolicyresponse1);
	     
		ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
	    System.out.println("noepolicyarray1"+noepolicyarray1);
		//String noename2=noepolicyarray1.get(1);
		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 
		if(noepolicyarray1.size()!=0)
		{
			
			   noeactive=noepolicyarray1.get(1);
			   if(!(noeactive.equalsIgnoreCase("false")))
			   {
			    System.out.println("noeactive"+noeactive);
			j=noearray1.size();
			   }
		}
	}
	
	if(sgst==null && igst==null && cgst==null)
	{
		sgst="0";
		igst="0";
		cgst="0";
		
	}
	
	System.out.println("Noe with policy defined is ->>>"+noename);
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	System.out.println(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
	 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
	 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756&Domain="+domain);
		 
	
	String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN="+gstn+"&CGSTAmt="+cgst+"&SGSTAmt="+sgst+"&IGSTAmt="+igst+"&intTypeOfVisit=1756&Domain="+domain);
		
	//System.out.println(userresponse);
		 ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
		 int j=0;
		
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		 return ClaimId;
	}
	public void submitLocalexpensesteps(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException
	{
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
				 
		
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		
		
		 Thread.sleep(10000);
		//WebDriverWait wait  = new WebDriverWait(driver, 10);
	//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
		// claimidlocator.click();
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
		    for( i=2; i<=size;i++)
		    {
		    	
		    		
		    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
		    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
		    	System.out.println("This is claim i am looking"+claim);
		    	if(claim.equalsIgnoreCase(ClaimId))
		    	{
		    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
		    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
		    	    i=size;
		    	}
		    	
		    	
		    }
		    Thread.sleep(10000);
		   // ClaimsubmitLocallocator.click();
		    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
		    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
			  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println(array1);
			 String claimtype= array1.get(1);
			 System.out.println("Claim type status is"+claimtype);
			 
			 if(claimtype.equalsIgnoreCase("0"))
			 {
				 
			
			 JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", submitelement);
    	    
    	    
			 }else {
		    JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ClaimsubmitLocallocator);
	
			 }
//			 Alert alert1 = driver.switchTo().alert();
//			String alerttext1 = driver.switchTo().alert().getText();
//			System.out.println(alerttext1);
//			assertTrue(alerttext1.equalsIgnoreCase("Claim submitted successfully"));
//			alert1.accept();
			    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim submitted successfully. !"));


	}
	public void submitOtherexpensesteps(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException
	{
		
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
				 
		
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		 Thread.sleep(10000);
		//WebDriverWait wait  = new WebDriverWait(driver, 10);
	//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
		// claimidlocator.click();
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
		    for( i=2; i<=size;i++)
		    {
		    	
		    		
		    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
		    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
		    	System.out.println("This is claim i am looking"+claim);
		    	if(claim.equalsIgnoreCase(ClaimId))
		    	{
		    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
		    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
		    	    i=size;
		    	}
		    	
		    	
		    }
		    Thread.sleep(10000);
		    
		    
		    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
		    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
			  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println(array1);
			 String claimtype= array1.get(1);
			 System.out.println("Claim type status is"+claimtype);
			 
			 if(claimtype.equalsIgnoreCase("0"))
			 {
				 
			
			 JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", submitelement);
    	    
    	    
			 }else {
		   // ClaimsubmitLocallocator.click();
		    JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
    	    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
    	    		Claimsubmitotherlocator);
    	    
			 }
//		 Alert alert1 = driver.switchTo().alert();
//			String alerttext1 = driver.switchTo().alert().getText();
//			System.out.println(alerttext1);
//			assertTrue(alerttext1.equalsIgnoreCase("Claim submitted successfully"));
//			alert1.accept();
			 
			    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim submitted successfully. !"));


	}
	public void submitmobileexpensesteps(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException
	{
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
				 
		
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		
		 Thread.sleep(10000);
		//WebDriverWait wait  = new WebDriverWait(driver, 10);
	//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
		// claimidlocator.click();
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
		    for( i=2; i<=size;i++)
		    {
		    	
		    		
		    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
		    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
		    	System.out.println("This is claim i am looking"+claim);
		    	if(claim.equalsIgnoreCase(ClaimId))
		    	{
		    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
		    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
		    	    i=size;
		    	}
		    	
		    	
		    }
		    Thread.sleep(10000);
		    //Claimsubmitmobilelocator.click();
		    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
		    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
			  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println(array1);
			 String claimtype= array1.get(1);
			 System.out.println("Claim type status is"+claimtype);
			 
			 if(claimtype.equalsIgnoreCase("0"))
			 {
				 
			
			 JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", submitelement);
    	    
    	    
			 }else {
		    JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", Claimsubmitmobilelocator);
			 }
//    	    Alert alert1 = driver.switchTo().alert();
//			String alerttext1 = driver.switchTo().alert().getText();
//			System.out.println(alerttext1);
//			assertTrue(alerttext1.equalsIgnoreCase("Claim submitted successfully"));
//			alert1.accept();
			    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim submitted successfully. !"));

	}
    
	public void submithotelexpensesteps(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException
	{
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
				 
		
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		
		 Thread.sleep(10000);
		//WebDriverWait wait  = new WebDriverWait(driver, 10);
	//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
		// claimidlocator.click();
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
		    for( i=2; i<=size;i++)
		    {
		    	
		    		
		    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
		    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
		    	System.out.println("This is claim i am looking"+claim);
		    	if(claim.equalsIgnoreCase(ClaimId))
		    	{
		    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
		    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
		    	    i=size;
		    	}
		    	
		    	
		    }
		    Thread.sleep(10000);
		    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
		    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
			  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println(array1);
			 String claimtype= array1.get(1);
			 System.out.println("Claim type status is"+claimtype);
			 
			 if(claimtype.equalsIgnoreCase("0"))
			 {
				 
			
			 JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", submitelement);
    	    
    	    
			 }
			 else {
		    
		    //ClaimsubmitHotellocator.click();
		    JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
    	    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
    	    		ClaimsubmitHotellocator);
			 }
//		 Alert alert1 = driver.switchTo().alert();
//			String alerttext1 = driver.switchTo().alert().getText();
//			System.out.println(alerttext1);
//			assertTrue(alerttext1.equalsIgnoreCase("Claim submitted successfully"));
//			alert1.accept();
			    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim submitted successfully. !"));


	}
	
	public void submitfoodexpensesteps(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException
	{
		
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
				 
		
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		 Thread.sleep(10000);
		//WebDriverWait wait  = new WebDriverWait(driver, 10);
	//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
		// claimidlocator.click();
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
		    for( i=2; i<=size;i++)
		    {
		    	
		    		
		    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
		    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
		    	System.out.println("This is claim i am looking"+claim);
		    	if(claim.equalsIgnoreCase(ClaimId))
		    	{
		    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
		    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
		    	    i=size;
		    	}
		    	
		    	
		    }
		    Thread.sleep(10000);
		    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
		    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
			  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println(array1);
			 String claimtype= array1.get(1);
			 System.out.println("Claim type status is"+claimtype);
			 
			 if(claimtype.equalsIgnoreCase("0"))
			 {
				 
			
			 JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", submitelement);
    	    
    	    
			 }
			 else {
		    JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", Claimsubmitfoodlocator);
		   // Claimsubmitfoodlocator.click();
			 }
//		 Alert alert1 = driver.switchTo().alert();
//			String alerttext1 = driver.switchTo().alert().getText();
//			System.out.println(alerttext1);
//			assertTrue(alerttext1.equalsIgnoreCase("Claim submitted successfully"));
//			alert1.accept();
			    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim submitted successfully. !"));


	}
	
	public void submitLandlineexpensesteps(String user,String pass,String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException
	{
		TestData.GetData gdata1 = new  TestData.GetData();
		 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	
		 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
		 int i=0;
		
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		 String bandid=array1.get(i+3);
				 
		
		 
		 System.out.println("This is" +userData);
		 System.out.println("This is" +passData);
		 System.out.println("This is" +empdata);
		
		 Thread.sleep(10000);
		//WebDriverWait wait  = new WebDriverWait(driver, 10);
	//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
		// claimidlocator.click();
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
		    for( i=2; i<=size;i++)
		    {
		    	
		    		
		    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
		    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
		    	System.out.println("This is claim i am looking"+claim);
		    	if(claim.equalsIgnoreCase(ClaimId))
		    	{
		    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
		    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
		    	    i=size;
		    	}
		    	
		    	
		    }
		    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
		    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
			  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println(array1);
			 String claimtype= array1.get(1);
			 System.out.println("Claim type status is"+claimtype);
			 
			 if(claimtype.equalsIgnoreCase("0"))
			 {
				 
			
			 JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", submitelement);
    	    
    	    
			 }
			 else {
		    Thread.sleep(10000);
		    Claimsubmitlandlinelocator.click();
			 }
//		 Alert alert1 = driver.switchTo().alert();
//			String alerttext1 = driver.switchTo().alert().getText();
//			System.out.println(alerttext1);
//			assertTrue(alerttext1.equalsIgnoreCase("Claim submitted successfully"));
//			alert1.accept();
			    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim submitted successfully. !"));


	}
	public void NavigateToReportings() throws InterruptedException
	{
		Thread.sleep(500);
		JavascriptExecutor sidemenujs = (JavascriptExecutor) driver;
		sidemenujs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", SideMenu);
	    Thread.sleep(500);
		JavascriptExecutor reportingopenjs = (JavascriptExecutor) driver;
		reportingopenjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", Reportingopen);
	    Thread.sleep(500);
		JavascriptExecutor reportingclickjs = (JavascriptExecutor) driver;
		reportingclickjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ReportingClick);
	}
	public void approveTravelExpense(String fromDate,String Todate,String approvalAction) throws InterruptedException
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
			    	System.out.println("This is claim i am looking"+claim);
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
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));

					
			    }else if(approvalAction.equalsIgnoreCase("disapprove"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
			    }else if(approvalAction.equalsIgnoreCase("reopen"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
//					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }
	}
	
	public void approveLocalExpense(String fromDate,String Todate,String approvalAction) throws InterruptedException
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
			    	System.out.println("This is claim i am looking"+claim);
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
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));

					
			    }else if(approvalAction.equalsIgnoreCase("disapprove"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }else if(approvalAction.equalsIgnoreCase("reopen"))
			    {

			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }
	}
	
	public void approveOtherExpense(String fromDate,String Todate,String approvalAction) throws InterruptedException
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
			    	System.out.println("This is claim i am looking"+claim);
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
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));

					
			    }else if(approvalAction.equalsIgnoreCase("disapprove"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }else if(approvalAction.equalsIgnoreCase("reopen"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }
	}

	public void approveMobileExpense(String fromDate,String Todate,String approvalAction) throws InterruptedException
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
			    	System.out.println("This is claim i am looking"+claim);
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
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));

					
			    }else if(approvalAction.equalsIgnoreCase("disapprove"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }else if(approvalAction.equalsIgnoreCase("reopen"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }
	}

	public void approvehotelExpense(String fromDate,String Todate,String approvalAction) throws InterruptedException
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
			    	System.out.println("This is claim i am looking"+claim);
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
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));
//					alertapprovesuc.accept();
					   assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));
					
			    }else if(approvalAction.equalsIgnoreCase("disapprove"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
					  assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
			    }else if(approvalAction.equalsIgnoreCase("reopen"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }
	}

	public void approvefoodExpense(String fromDate,String Todate,String approvalAction) throws InterruptedException
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
			    	System.out.println("This is claim i am looking"+claim);
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
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));

					
			    }else if(approvalAction.equalsIgnoreCase("disapprove"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
//					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }else if(approvalAction.equalsIgnoreCase("reopen"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
		    	   // Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }
	}

	
	public void approveLandlineExpense(String fromDate,String Todate,String approvalAction) throws InterruptedException
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
			    	System.out.println("This is claim i am looking"+claim);
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
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Approved SUCCESSFULY"));
					
			    }else if(approvalAction.equalsIgnoreCase("disapprove"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }else if(approvalAction.equalsIgnoreCase("reopen"))
			    {
			    	Select s = new Select(selectReason);
					s.selectByVisibleText("Other");
					Thread.sleep(1000);
					otherTextField.sendKeys("test");
			    	JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", disapprove);
			    	//approve.click();
//		    	    Thread.sleep(500);
//		    	    Alert alertapprove = driver.switchTo().alert();
//					String alerttextapprove = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprove);
//					assertTrue(alerttextapprove.equalsIgnoreCase("Are you sure you want to Disapprove Claim?"));
//					alertapprove.accept();
					Thread.sleep(500);
//					Alert alertapprovesuc = driver.switchTo().alert();
//					String alerttextapprovesuc = driver.switchTo().alert().getText();
//					System.out.println(alerttextapprovesuc);
//					assertTrue(alerttextapprovesuc.equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));
//					alertapprovesuc.accept();
				    assertTrue((successmessage.getText()).equalsIgnoreCase("CLAIM Rejected SUCCESSFULY"));

			    }
	}

}
