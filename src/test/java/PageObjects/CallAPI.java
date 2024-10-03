package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Browsers.Urls;
import Data.captureData;
import TestData.GetApiData;
import TestData.GetData;

public class CallAPI extends Urls {
	
	WebDriver driver;
	
	String Logincode="";
	String empdata="";
	String 	ClaimId="";
	String bandid="";
	String travelexpenseid="";
	String travelinsertresponse="";
	String managerdata="";
	int k=0;
	Calendar current = Calendar.getInstance();
	ArrayList<String> array = new ArrayList<String>();

	String travelpolicybindcode="";
	
	ExtendedCallAPI ecapi= new ExtendedCallAPI();
	PostAPIPage postapi = new PostAPIPage();
	
	public void steps(String functiontext,String username,String password,String managerusername,String managerpassword,String policytype,String domaintext) throws JSONException, InterruptedException 
	{
		
		
		
		GetApiData gdata1 = new  GetApiData();
		captureData gdata = new  captureData();
		captureData citydata = new  captureData();
		
		
		String emailid="";
		String foodid="";
		String url="http://192.168.1.14:90/";
	     System.out.println(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
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
//		if(domaintext.equalsIgnoreCase("lechler"))
//		{
//		url = "https://lechler.zento.in";	
//		}else if(domaintext.equalsIgnoreCase("fulcrum"))
//		{
//			url = "https://fulcrum.zento.in";	
//		}
//		   String clardatacode= gdata1.getContenxtWeb(url+"/ClearEmployeeClaims.aspx?EmpCode="+username+"&Domain="+domaintext+"");
//			 assertTrue(clardatacode.equalsIgnoreCase("200")||clardatacode.equalsIgnoreCase("201"));
		switch(functiontext){
		
		
		case "login/GetLogin" : 
			
			
			          
			String Logincode = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
		
			assertTrue(Logincode.equalsIgnoreCase("200")||Logincode.equalsIgnoreCase("201"));
			break;
		
		case "login/GetForgotPassword" :
		
		     System.out.println(BaseUrl+"api/login/GetForgotPassword?vcEmail="+emailid+"&status=yes&Domain="+domaintext+"");

			 String forgotpasswordcode= gdata1.getContenxtWeb(BaseUrl+"api/login/GetForgotPassword?vcEmail="+emailid+"&status=yes&Domain="+domaintext+"");
			 assertTrue(forgotpasswordcode.equalsIgnoreCase("200")||forgotpasswordcode.equalsIgnoreCase("201"));
			 break;
			 
		case "login/GetChangePassword" :
			
			  
			 String changepasswordcode= gdata1.getContenxtWeb(BaseUrl+"api/login/GetChangePassword?Mode=changepassword&UName="+userData+"&PWD="+passData+"&NewPWD=Zento123&Domain="+domaintext+"");
			 assertTrue(changepasswordcode.equalsIgnoreCase("200")||changepasswordcode.equalsIgnoreCase("201"));
			 break;
			 
		case "ProfileDetails/GetEmployeeProfileDetails"	:
			
			 
			
			 String profilecode= gdata1.getContenxtWeb(BaseUrl+"api/ProfileDetails/GetEmployeeProfileDetails?EmpID="+empdata+"&Domain="+domaintext+"");
			 assertTrue(profilecode.equalsIgnoreCase("200")||profilecode.equalsIgnoreCase("201"));
			 break;
			 
		case "ProfileDetails/UpdateEmployeeProfile"	:
			
			  
			 String editprofilecode= gdata1.getContenxtWeb(BaseUrl+"api/ProfileDetails/UpdateEmployeeProfile?EmpID="+empdata+"&EmpFName=paresh&EmpMName=M"
			 		+ "&EmpLName=Patil&BankName=test&AccountNo=0&Email=paresh.patil@gdata.in&dtJoining=01/01/2015&Mobile=9898989898&Domain="+domaintext+"");
			 assertTrue(editprofilecode.equalsIgnoreCase("200")||editprofilecode.equalsIgnoreCase("201"));
			 
		case "Master/GetBandList" :
			
			
			 String bandmastercode= gdata1.getContenxtWeb(BaseUrl+"api/Master/GetBandList?Domain="+domaintext+"");
			 assertTrue(bandmastercode.equalsIgnoreCase("200")||bandmastercode.equalsIgnoreCase("201"));
			 break;
			 
		case "travelclaim/GetCityDataList" :
			
			
			 String citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
			 break;
			 
        case "travelclaim/GetMasterDataList" :
			 //WBS master   
   		     String WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
   		     assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 break;	 
			 
        case "otherClaim" :
			
        	//Nature of expense master  
        	
   		 String NOEmastercaode= gdata1.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
   		 assertTrue(NOEmastercaode.equalsIgnoreCase("200")||NOEmastercaode.equalsIgnoreCase("201"));
			 break;	
			 
        case "TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel" :	 
			 
        	
			//Travel modes for travel claims  
			 String travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
			 break;
			 
			 
        case "Master/GetAllClaimType" :	 
			 
        				// Claim type masters    http://115.249.204.243:84/api/Master/GetAllClaimType?status=yes
        	
				 String claimtypemastercaode= gdata1.getContenxtWeb(BaseUrl+"/api/Master/GetAllClaimType?status=yes&Domain="+domaintext+"");
				 assertTrue(claimtypemastercaode.equalsIgnoreCase("200")||claimtypemastercaode.equalsIgnoreCase("201"));
			 break;
			 
        case "PolicyCheck/GetBandWisePolicy" :	 
			 
        	
			  travelpolicybindcode= gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Travel&Band="+bandid+"&Domain="+domaintext+"");
				 assertTrue(travelpolicybindcode.equalsIgnoreCase("200")||travelpolicybindcode.equalsIgnoreCase("201"));
			 break;
			 
			 
        case "TravelClaim/GetInsertUpdateTravelClaim" :	
        	
        	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 				
 				 break;
 			
 case "TravelClaimView/GetClaimByID" :	
        	
        	
        	
			 
	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 				 break;
 				 
 				 
 case "GetEmpAppliedExpenseDataTravel" :	
 	
 	
 	
		 
	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
			 
			 break;
 				 
 case "TravelClaimView/UpdateTravelClaim" :	
 	
 	
 	
	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
			 break;
			 
			 
 case "Submit/SubmitClaim" :	
	 	
	 	
	 	
	 	
	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
				 break;
				 
				 
 case "ClaimProcessing/ApproveDissapproveClaims" :	
	 	
	 	
	 	
			  
	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext);
				 break;
				 
				 
 case "ReOpen/ReopenClaim" :	
	 	
	 	
	 	
			  
	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext);
					 
					 break;
					 
 case "LocalClaim/GetInsertLocalClaim" :	
 	
 	
 	
		  
 
 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
	 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
	 

		
		String   cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		
	
	ArrayList<String>	  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
		int  cityno=0;
		
	String	  citynamefromdata=cityarray1.get(cityno+1);
	String  citynametodata=cityarray1.get(cityno+2);
		
 	
 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
	 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
	 
		
	 ArrayList<String> wbsarray = new ArrayList<String>();
		
		
		
		String  wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
		int  wbscount=0;
		String wbsdata=wbsarray.get(wbscount+1);
		
 	
		String localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
		 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
		 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
		 
		 
		 String localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

		 ArrayList<String> localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
		int localtravelmodecount=0;
		String localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
		DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		
		
		
		 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
			 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
			 				+ "&travelFrom=chinchpokli"
			 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
			
		
		 ArrayList<String> localarray = gdata.parseFromJSONarrayResponse(userresponse);
		  
		
		 int j=0;
		  ClaimId=localarray.get(j);
		  travelexpenseid=localarray.get(j+1);
		  //fromdate=array.get(j+5);
		
	     break;	
	     
	     
 case "LocalClaimView/GetClaimByID" :	
	 	
	 	
	 	
			 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
		
			
			
			 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&travelFrom=chinchpokli"
				 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
				
		
			 localarray = gdata.parseFromJSONarrayResponse(userresponse);
			  
			
			  j=0;
			  ClaimId=localarray.get(j);
			  travelexpenseid=localarray.get(j+1);
			  //fromdate=array.get(j+5);
		
			 
			//****View Local claim
			 
			 String viewlocalclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LocalClaimView/GetClaimByID?ClaimId="+ClaimId+"&Domain="+domaintext+"");
		 assertTrue(viewlocalclaimcode.equalsIgnoreCase("200")||viewlocalclaimcode.equalsIgnoreCase("201"));
		     break;	 
					 
 case "GetEmpAppliedExpenseDataLocal" :	
	 	
	 	
	 	
			 
	 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS?Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			
			
			 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&travelFrom=chinchpokli"
				 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");
				
			
			 localarray = gdata.parseFromJSONarrayResponse(userresponse);
			  
			
			  j=0;
			  ClaimId=localarray.get(j);
			  travelexpenseid=localarray.get(j+1);
			  //fromdate=array.get(j+5);
			
			 
			//****View Local claim  /api/LocalClaimView/GetEmpAppliedExpenseDataLocal?ClaimId=252&ExpenseId=1
			 
			  viewlocalclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LocalClaimView/GetEmpAppliedExpenseDataLocal?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
		 assertTrue(viewlocalclaimcode.equalsIgnoreCase("200")||viewlocalclaimcode.equalsIgnoreCase("201"));
		     break;	 
		     
		     
 case "LocalClaimView/UpdateLocalClaim" :	
	 	
	 	
	 	
			 
	 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
//			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
						 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			
			
			 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&travelFrom=chinchpokli"
				 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
				
		
			 localarray = gdata.parseFromJSONarrayResponse(userresponse);
			  
			
			  j=0;
			  ClaimId=localarray.get(j);
			  travelexpenseid=localarray.get(j+1);
			  //fromdate=array.get(j+5);
			
			 
			//****View Local claim  /api/LocalClaimView/UpdateLocalClaim?ClaimId=10811&LocalConveyanceClaimId=6392
			// &travelDateFrom=3/8/2018&amount=2000&cityFrom=5&cityTo=5&Remarks=test&modeOfTravel=624&travelFrom=test&travelTo=test
			// &travelDateTo=2016-12-01%2000:00:00.000&WBS=1&TaxAmt=0&GSTIncluded=true&Km=6
			 
			 
     String    updatetravelclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LocalClaimView/UpdateLocalClaim?ClaimId="+ClaimId+"&LocalConveyanceClaimId="+travelexpenseid+""
         		+ "&travelDateFrom="+dtf.format(localDate)+"&amount=2000&cityFrom="+citynamefromdata+"&cityTo="+citynametodata+"&Remarks=test&modeOfTravel="+localtravelmodedata+"&travelFrom=test&travelTo=test"
         		+ "&travelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&TaxAmt=0&GSTIncluded=true&Km=6&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
         
         
			 assertTrue(updatetravelclaimcode.equalsIgnoreCase("200")||updatetravelclaimcode.equalsIgnoreCase("201"));
		     break;	
		     
		     
		     
 case "LandLineClaim/GetInsertLandLineClaim" :	
	 	
	 	
	 	
			  
	 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
//			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
		
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			System.out.println(dtf.format(localDate));
			
			
			 String landlineuserresponse = gdata.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");
				
		
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
		     break;	
		     
 case "LandlineView/GetClaimByID" :	
	 	
	 	
	 	
			  
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			 
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			
			
			  landlineuserresponse = gdata.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");
				
			
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
				 
				 String viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LandlineView/GetClaimByID?ClaimId="+ClaimId+"&Domain="+domaintext+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
		     break;	
		     
 case "LandlineView/GetEmpAppliedExpenseDataLandLine" :	
	 	
	 	
	 	
			 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
//			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			
	 	   
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			
				System.out.println(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
		 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");

			  landlineuserresponse = gdata.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");
				
		
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
					System.out.println(BaseUrl+"/api/LandlineView/GetEmpAppliedExpenseDataLandLine?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
				  viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LandlineView/GetEmpAppliedExpenseDataLandLine?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
		     break;	
					
 case "LandlineView/UpdateLandLineClaim" :	
	 	
	 	
	 	
			 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			 
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
//			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
		
			
			
			  landlineuserresponse = gdata.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");
				
			
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
				 
				 String updatelandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LandlineView/UpdateLandLineClaim?ClaimId="+ClaimId+"&MobileClaimId="+travelexpenseid+"&dateFrom="+dtf.format(localDate)+""
					 		+ "&amount=200&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&TaxAmt=300"
					 		+ "&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");
					 assertTrue(updatelandlineclaimcode.equalsIgnoreCase("200")||updatelandlineclaimcode.equalsIgnoreCase("201")); 	 
		     break;	
		     
        case "Mobile/GetInsertMobileClaim":
        	
        	
			 
        	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
    		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
    		 
    			
    		 wbsarray = new ArrayList<String>();
    			
    			
//    			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
    			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
    			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
    		
    			 wbscount=0;
    			 wbsdata=wbsarray.get(wbscount+1);
    			
    			  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    				 localDate = LocalDate.now();
    				
        	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
			 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"&ContactNumber=8698294937");
			
		//System.out.println(userresponse);
			 array = gdata.parseFromJSONResponse(userresponse);
			  j=0;
			
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+9);
			  //fromdate=array.get(j+5);
			 
			  break;
			  
			  
 case "MobileView/GetClaimByID":
        	
        	
			  
        	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
    		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
    		 
    			
    		 wbsarray = new ArrayList<String>();
    			
    			
//    			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
    			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
    			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
    		
    			 wbscount=0;
    			 wbsdata=wbsarray.get(wbscount+1);
    			
    			  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    				 localDate = LocalDate.now();
    				
        	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
			 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"&ContactNumber=8698294937");
			
		//System.out.println(userresponse);
			 array = gdata.parseFromJSONResponse(userresponse);
			  j=0;
			 
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+9);
			  //fromdate=array.get(j+5);
			
			  
			   viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/MobileView/GetClaimByID?ClaimId="+ClaimId+"&Domain="+domaintext+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
			  
			  break;
			  
 case "MobileView/GetEmpAppliedExpenseDataMobile":
 	
 	
		
 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
//			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
					 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
		
			  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				
 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
	 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
	 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"&ContactNumber=8698294937");
		
	
		 array = gdata.parseFromJSONResponse(userresponse);
		  j=0;
		
		  ClaimId=array.get(j+7);
		  travelexpenseid=array.get(j+9);
		  //fromdate=array.get(j+5);
		
		  
		   viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/MobileView/GetEmpAppliedExpenseDataMobile?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
			 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
		  
		  break;
		  
 case "MobileView/UpdateMobileClaim":
	 	
	 	
			  
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
			 wbsarray = new ArrayList<String>();
				
				
//				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
				System.out.println("API wbs mode name is "+wbsdata);
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
		 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"&ContactNumber=8698294937");
			
		//System.out.println(userresponse);
			 array = gdata.parseFromJSONResponse(userresponse);
			  j=0;
			
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+9);
			  //fromdate=array.get(j+5);
			 System.out.println("New claim id is "+ClaimId);
			  System.out.println("New claim id is "+travelexpenseid); 
			  
			  String updatemobileclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/MobileView/UpdateMobileClaim?ClaimId="+ClaimId+""
				 		+ "&MobileClaimId="+travelexpenseid+"&dateFrom="+dtf.format(localDate)+"&amount=123&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&TaxAmt=200"
				 		+ "&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"&ContactNumber=8698294937");
					 assertTrue(updatemobileclaimcode.equalsIgnoreCase("200")||updatemobileclaimcode.equalsIgnoreCase("201")); 
			  
			  break;
			  
			  
          case "AccomodationClaim/InsertAccomodationClaim":
        	  
        	 
			  
			  
			  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
				 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
				 
					
				 wbsarray = new ArrayList<String>();
					
					
					System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
					 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
					 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
					
					 wbscount=0;
					 wbsdata=wbsarray.get(wbscount+1);
					
					 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
					

					  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
					
				
					  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
					  cityno=0;
					
					  citynamefromdata=cityarray1.get(cityno+1);
					  citynametodata=cityarray1.get(cityno+2);
					 
        	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
				 		+ "&NoOfDays=1&amount=500&Remarks=test"
				 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
				 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
				
			
				  array = gdata.parseFromJSONResponse(userresponse);
				 j=0;
			
				  ClaimId=array.get(j+7);
				  //fromdate=array.get(j+5);
				  travelexpenseid=array.get(j+10);
				
				 break;
				 
  case "AccomodationClaimView/GetAccomodationClaim":
        	  
        	  
			  
			  
			  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
				 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
				 
					
				 wbsarray = new ArrayList<String>();
					
					
					System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
					 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
					 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
					
					 wbscount=0;
					 wbsdata=wbsarray.get(wbscount+1);
				
					 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					
					

					  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
					
				
					  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
					  cityno=0;
					
					  citynamefromdata=cityarray1.get(cityno+1);
					  citynametodata=cityarray1.get(cityno+2);
					  System.out.println(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"&Location="+citynamefromdata+""
						 		+ "&NoOfDays=1&amount=500&Remarks=test"
						 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
						 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&Domain="+domaintext+"");
        	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"&Location="+citynamefromdata+""
				 		+ "&NoOfDays=1&amount=500&Remarks=test"
				 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
				 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=test&Domain="+domaintext+"");
				
			
				  array = gdata.parseFromJSONResponse(userresponse);
				 j=0;
				
				  ClaimId=array.get(j+7);
				  //fromdate=array.get(j+5);
				  travelexpenseid=array.get(j+10);
				
				 viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/AccomodationClaimView/GetAccomodationClaims?ClaimId="+ClaimId+"&Domain="+domaintext+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
				 
				 break;
				 
				 
  case "AccomodationClaim/GetEmpAppliedExpenseDataAccomodation":
	  
	  
	  
	  
	  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			System.out.println("API wbs mode name is "+wbsdata);
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			System.out.println(dtf.format(localDate));
			

			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			  
			  
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
				 		+ "&NoOfDays=1&amount=500&Remarks=test"
				 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
				 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
		
	//System.out.println(userresponse);
		  array = gdata.parseFromJSONResponse(userresponse);
		 j=0;
		
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		  travelexpenseid=array.get(j+10);
		 
		 
		 
		 viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/GetEmpAppliedExpenseDataAccomodation?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
		 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
	  
	  break;
	  
	  
	  
 case "AccomodationClaimView/UpdateAccomodationClaim":
	  
	 
	  
	  
	  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
		
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			

			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
				 		+ "&NoOfDays=1&amount=500&Remarks=test"
				 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
				 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
		
	//System.out.println(userresponse);
		  array = gdata.parseFromJSONResponse(userresponse);
		 j=0;
		
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		  travelexpenseid=array.get(j+10);
		
		
		 String updatehotelclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/AccomodationClaimView/UpdateAccomodationClaim?ClaimId="+ClaimId+""
			 		+ "&AccomodationClaimId="+travelexpenseid+"&TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+"&NoOfDays=1&Amount=500.00&Remarks=na&WBS="+wbsdata+"&TaxAmt=50.00"
			 		+ "&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
					 assertTrue(updatehotelclaimcode.equalsIgnoreCase("200")||updatehotelclaimcode.equalsIgnoreCase("201")); 
	  
	  break;
	  
	  
 case "FoodClaim/GetFoodType":    //Get food types
	 
	 
	 String foodtypecode= gdata1.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domaintext+"");
	 assertTrue(foodtypecode.equalsIgnoreCase("200")||foodtypecode.equalsIgnoreCase("201"));
     break;
	 
 case "FoodClaim/InsertFoodClaim":  //insert food claim   http://192.168.1.14:84/api/FoodClaim/InsertFoodClaim?TravelDate=02/28/2018&Location=1&NoOfDays=1&amount=10000.00&Remarks=test&WBS=26&empId=672&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true&foodPlace=1

	 
	 
	 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	 wbsarray = new ArrayList<String>();
		
		
		System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
		 wbscount=0;
		 wbsdata=wbsarray.get(wbscount+1);
	System.out.println("API wbs mode name is "+wbsdata);
	System.out.println(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domaintext+"\"");
	String foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domaintext+"");
	ArrayList<String> foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
	
	
	i=0;
// foodid= foodTypeyarray1.get(i+1);
	
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
 
 System.out.println("New foodid id is "+foodid);
 System.out.println(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
	 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true"
				+ "&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
	  userresponse= gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
	 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true"
	 				+ "&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
	  array = gdata.parseFromJSONResponse(userresponse);
	  
	  j=0;
	
	  ClaimId=array.get(j+7);
	  //fromdate=array.get(j+5);
	 System.out.println("New claim id is "+ClaimId);
	 travelexpenseid=array.get(j+12);
	
	 System.out.println("New claim id is "+travelexpenseid); 
	 break;
	 
	 
 case "FoodClaimView/GetFoodClaims":
	     
	
	 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	 wbsarray = new ArrayList<String>();
		
		
		System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
	
		 wbscount=0;
		 wbsdata=wbsarray.get(wbscount+1);
	System.out.println("API wbs mode name is "+wbsdata);
	 foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domaintext+"");
	 foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
	 i=0;
//	 foodid =foodTypeyarray1.get(i+2);
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
	System.out.println(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
	 		+ "&amount=10000.00&Remarks=test&WBS=26&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true&foodPlace="+foodid);
	  userresponse= gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
	 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756"
	 				+ "&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
	  array = gdata.parseFromJSONResponse(userresponse);
	  
	  j=0;
	
	  ClaimId=array.get(j+7);
	  //fromdate=array.get(j+5);
	 System.out.println("New claim id is "+ClaimId);
	 travelexpenseid=array.get(j+12);
	
	 System.out.println("New claim id is "+travelexpenseid); 
	 
	 viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/FoodClaimView/GetFoodClaims?ClaimId="+ClaimId+"&Domain="+domaintext+"");
	 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
	 break;
	 
	     
 case "FoodClaimView/GetEmpAppliedExpenseDataFood" : 
	     
	
	 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	 wbsarray = new ArrayList<String>();
		
		
		System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
		 wbscount=0;
		 wbsdata=wbsarray.get(wbscount+1);
	System.out.println("API wbs mode name is "+wbsdata);
	 foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domaintext+"");
	 foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
	 i=0;
	// foodid=foodTypeyarray1.get(i+2);
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
	System.out.println(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
	 		+ "&amount=10000.00&Remarks=test&WBS=26&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true&foodPlace="+foodid);
	  userresponse= gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
	 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true"
	 				+ "&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
	  array = gdata.parseFromJSONResponse(userresponse);
	 
	  j=0;
	
	  ClaimId=array.get(j+7);
	  //fromdate=array.get(j+5);
	 System.out.println("New claim id is "+ClaimId);
	 travelexpenseid=array.get(j+12);
	
	 System.out.println("New claim id is "+travelexpenseid); 
	 
	 viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/FoodClaimView/GetEmpAppliedExpenseDataFood?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
	 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
	 break; 
	 
 case "FoodClaimView/UpdateFoodClaim" :
	
	 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	 wbsarray = new ArrayList<String>();
		
		
		System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
		 wbscount=0;
		 wbsdata=wbsarray.get(wbscount+1);
	System.out.println("API wbs mode name is "+wbsdata);
	 foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domaintext+"");
	 foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
	 i=0;
//	 foodid=foodTypeyarray1.get(i+2);
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
	
	  userresponse= gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
	 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true"
	 				+ "&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
	  array = gdata.parseFromJSONResponse(userresponse);
	 
	  j=0;
	
	  ClaimId=array.get(j+7);
	  //fromdate=array.get(j+5);
	 System.out.println("New claim id is "+ClaimId);
	 travelexpenseid=array.get(j+12);
	
	 System.out.println("New claim id is "+travelexpenseid); 
	 ///api/FoodClaimView/UpdateFoodClaim?ClaimId=9723&FoodClaimId=1&TravelDate=2016-12-01%2000:00:00.000&Location=2&NoOfDays=3&Amount=5000.00&Remarks=test&WBS=26&TaxAmt=50.00&GSTIncluded=true&FoodPlace=1
  
	 
	 String updatefoodclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/FoodClaimView/UpdateFoodClaim?ClaimId="+ClaimId+"&FoodClaimId="+travelexpenseid+""
	 		+ "&TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location=2&NoOfDays=3&Amount=5000.00&Remarks=test&WBS="+wbsdata+"&TaxAmt=50.00&GSTIncluded=true"
	 		+ "&FoodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
	 assertTrue(updatefoodclaimcode.equalsIgnoreCase("200")||updatefoodclaimcode.equalsIgnoreCase("201"));
	 break; 
	 
 case "otherClaim/GetInsertOtherClaim":
	 String noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		 String noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		

		 ArrayList<String> noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
//			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
		
		  
		  
		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
			 wbsarray = new ArrayList<String>();
				
				
				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
				System.out.println("API wbs mode name is "+wbsdata);
				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
		
		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&Domain="+domaintext+"");
		
	        //System.out.println(userresponse);
		    array = gdata.parseFromJSONResponse(userresponse);
		    j=0;
		   
		     ClaimId=array.get(j+7);
		     travelexpenseid=array.get(j+11);
		     //fromdate=array.get(j+5);
		     System.out.println("New claim id is "+ClaimId);
		     System.out.println("New claim id is "+travelexpenseid);
             break;
             
             
             

	 
	  
 case "OtherClaimView/GetClaimByID":
	  noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
//			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
		
		 
		  
		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
			 wbsarray = new ArrayList<String>();
				
				
//				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
				System.out.println("API wbs mode name is "+wbsdata);
				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
		
		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");
		
	        //System.out.println(userresponse);
		    array = gdata.parseFromJSONResponse(userresponse);
		    j=0;
		  
		     ClaimId=array.get(j+7);
		     travelexpenseid=array.get(j+11);
		     //fromdate=array.get(j+5);
		     System.out.println("New claim id is "+ClaimId);
		     System.out.println("New claim id is "+travelexpenseid);
		     
		     viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/OtherClaimView/GetClaimByID?ClaimId="+ClaimId+"&Domain="+domaintext+"");
			 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
             break;
 
 case "OtherClaimView/GetEmpAppliedExpenseDataOther":
	  noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		  

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
		
		 
		  
		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
			 wbsarray = new ArrayList<String>();
				
				
				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
				System.out.println("API wbs mode name is "+wbsdata);
				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
		
		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");
		
	        //System.out.println(userresponse);
		    array = gdata.parseFromJSONResponse(userresponse);
		    j=0;
		  
		     ClaimId=array.get(j+7);
		     travelexpenseid=array.get(j+11);
		     //fromdate=array.get(j+5);
		     System.out.println("New claim id is "+ClaimId);
		     System.out.println("New claim id is "+travelexpenseid);
		     
		     viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/OtherClaimView/GetEmpAppliedExpenseDataOther?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
			 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
			 
			 break;
			 
			 
 case "OtherClaimView/UpdateOtherClaim":
	  noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
//			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
		
		 
		  
		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
			 wbsarray = new ArrayList<String>();
				
				
				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
				System.out.println("API wbs mode name is "+wbsdata);
				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
		
		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&Domain="+domaintext+"");
		
	        //System.out.println(userresponse);
		    array = gdata.parseFromJSONResponse(userresponse);
		    j=0;
		  
		     ClaimId=array.get(j+7);
		     travelexpenseid=array.get(j+11);
		     //fromdate=array.get(j+5);
		     System.out.println("New claim id is "+ClaimId);
		     System.out.println("New claim id is "+travelexpenseid);
		     System.out.println(BaseUrl+"/api/OtherClaimView/UpdateOtherClaim?ClaimId=2440&OtherExpenseClaimId="+ClaimId+""
				 		+ "&dateFrom="+dtf.format(localDate)+"&amount=567&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&vcLocation=pune&TaxAmt=300&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&Domain="+domaintext+"");
		     String updateotherclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/OtherClaimView/UpdateOtherClaim?ClaimId=2440&OtherExpenseClaimId="+ClaimId+""
				 		+ "&dateFrom="+dtf.format(localDate)+"&amount=567&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&vcLocation=pune&TaxAmt=300&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&NOE="+noename+"&Domain="+domaintext+"");
							 assertTrue(updateotherclaimcode.equalsIgnoreCase("200")||updateotherclaimcode.equalsIgnoreCase("201")); 
							 break;
							 
    case "dashboard/GetTotalClaim"	:	//get filter wise total claims   api/dashboard/GetTotalClaim?EmpId=604&Month=11&Year=2017&Week=0&Operation=LocalClaim
    	
    	   
    	  
    	 String totalclaimscode= gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetTotalClaim?EmpId="+empdata+"&Month="+(current.get(Calendar.MONTH))+1+"&Year="+current.get(Calendar.YEAR)+"&Week=0&Operation="+policytype+"&Domain="+domaintext+"");
		 assertTrue(totalclaimscode.equalsIgnoreCase("200")||totalclaimscode.equalsIgnoreCase("201"));
    	break;
    	
    	
    case "dashboard/GetClaim"	:	//retrieve dashboard data
 	   
  	 System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&Year="+current.get(Calendar.YEAR)+"&Week=0&sortBy=CLAIMID&Domain="+domaintext+"");
  	 String dashboarddatacode= gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month="+(current.get(Calendar.MONTH))+1+"&Year="+current.get(Calendar.YEAR)+"&Week=0&sortBy=CLAIMID&Domain="+domaintext+"");
		 assertTrue(dashboarddatacode.equalsIgnoreCase("200")||dashboarddatacode.equalsIgnoreCase("201"));
  	break;
    	
  	
    case "FoodPolicy/GetBandWisePolicy" :
    	  
    	
		  
		  
		   foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?Domain="+domaintext+"");
			 foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
			 i=0;
//			 foodid=foodTypeyarray1.get(i+2);
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
    	String foodpolicycode= gdata1.getContenxtWeb(BaseUrl+"/api/FoodPolicy/GetBandWisePolicy?Band="+bandid+"&foodPlace="+foodid+"&Domain="+domaintext+"");
		 assertTrue(foodpolicycode.equalsIgnoreCase("200")||foodpolicycode.equalsIgnoreCase("201"));
		 break;
		 
		 
    case "LevelIndicator/GetClaimApprover" :   //get data to show level indicator in app

    	
    	
    	 noename="";
 		//TestData.GetData gdata = new  TestData.GetData();
 		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?&Domain="+domaintext+"");
 		

 		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
 		
 		for( j=0;j<noearray1.size();j++)
 		{
 			
 			 noename=noearray1.get(j);
// 			System.out.println("Noe name is:->>>>>>>>>"+noename);
 			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
 			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
 			//String noename2=noepolicyarray1.get(1);
 			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
 			if(noepolicyarray1.size()!=0)
 			{
 				j=noearray1.size();
 			}
 		}
 		
 		 
 		  
 		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
 			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
 			 
 				
 			 wbsarray = new ArrayList<String>();
 			
 			
 			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
 			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
 			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
 		
 			 wbscount=0;
 			 wbsdata=wbsarray.get(wbscount+1);
 				System.out.println("API wbs mode name is "+wbsdata);
 				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
 				 localDate = LocalDate.now();
 				System.out.println(dtf.format(localDate));
 		
 		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
 		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
 		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");
 		
 	        //System.out.println(userresponse);
 		    array = gdata.parseFromJSONResponse(userresponse);
 		    j=0;
 		   
 		     ClaimId=array.get(j+7);
 		     travelexpenseid=array.get(j+11);
 		     //fromdate=array.get(j+5);
 		     System.out.println("New claim id is "+ClaimId);
 		     System.out.println("New claim id is "+travelexpenseid);
 		   
 		    String levelindicatorcode= gdata1.getContenxtWeb(BaseUrl+"/api/LevelIndicator/GetClaimApprover?ClaimID="+ClaimId+"&Domain="+domaintext+"");
 			 assertTrue(levelindicatorcode.equalsIgnoreCase("200")||levelindicatorcode.equalsIgnoreCase("201"));
 			 break;
 			 
 			 
    case "LocalClaim/GetBandWisePolicyDetailsLocal" :    //get local claim policy    Pending

    	 
 		  System.out.println(BaseUrl+"api/LocalClaim/GetBandWisePolicyDetailsLocal?band="+bandid+"&Domain="+domaintext);
 		  String lpolicycode= gdata1.getContenxtWeb(BaseUrl+"api/LocalClaim/GetBandWisePolicyDetailsLocal?band="+bandid+"&Domain="+domaintext);
 		    System.out.println("New claim id is "+lpolicycode);
 		 assertTrue(lpolicycode.equalsIgnoreCase("200")||lpolicycode.equalsIgnoreCase("201"));
 		 break;
 		 
 	
    case "MobileView/ValiadteMobileClaim" :
    	 
    	
    	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		 wbsarray = new ArrayList<String>();
			
			
			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			System.out.println("API wbs mode name is "+wbsdata);
			  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				System.out.println(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
				 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
				 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"&ContactNumber=8698294937");
				
    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
		 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"&ContactNumber=8698294937");
		
	//System.out.println(userresponse);
		 array = gdata.parseFromJSONResponse(userresponse);
		  j=0;
		 
		  ClaimId=array.get(j+7);
		  travelexpenseid=array.get(j+9);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		  System.out.println("New claim id is "+travelexpenseid); 
		  String mobilevalidationcode= gdata1.getContenxtWeb(BaseUrl+"api/MobileView/ValiadteMobileClaim?date_from="+dtf.format(localDate)+"&date_to="+dtf.format(localDate)+""
		  		+ "&emp_id="+empdata+"&expenseID="+travelexpenseid+"&Domain="+domaintext+"");
	 		 
	 		 assertTrue(mobilevalidationcode.equalsIgnoreCase("200")||mobilevalidationcode.equalsIgnoreCase("201"));
	 		 break;
	 		 
    case "Notification/GetEmpNotificationCount" :   //get emp wise notification count
    	
    	
    	
    	
    	String notcountcode= gdata1.getContenxtWeb(BaseUrl+"api/Notification/GetEmpNotificationCount?empid="+empdata+"&Domain="+domaintext+"");
	 		 
	 		 assertTrue(notcountcode.equalsIgnoreCase("200")||notcountcode.equalsIgnoreCase("201"));
    	    
    	 break;
    	 
    case "Notification/GetEmpNotificationDetails" :  //get notification details
    	   

    	
    	
    	String notcountdetailscode= gdata1.getContenxtWeb(BaseUrl+"api/Notification/GetEmpNotificationDetails?empid="+empdata+"&Status=yes&Domain="+domaintext+"");
	 		 
	 		 assertTrue(notcountdetailscode.equalsIgnoreCase("200")||notcountdetailscode.equalsIgnoreCase("201"));
	 		 
	 		 break;
	 		 
    case "test" :
    	
    	
    	
    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Notification/GetEmpNotificationDetails?empid="+empdata+"&Status=yes&Domain="+domaintext+"");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
    	
    	break;
    	

    	
    case "RptClaimDetails/GetApproverClaimCount" :   //get total pending claim count
    	//http://192.168.1.14:84/api/RptClaimDetails/GetApproverClaimCount?EMPId=604&month=12&year=2017&week=0&action=pending

    	
    	
    	String pendingclaimcountcode= gdata1.getContenxtWeb(BaseUrl+"api/RptClaimDetails/GetApproverClaimCount?EMPId="+empdata+"&month="+(current.get(Calendar.MONTH))+1+""
    			+ "&year="+current.get(Calendar.YEAR)+"&week=0&action=pending&Domain="+domaintext+"");
		 
		 assertTrue(pendingclaimcountcode.equalsIgnoreCase("200")||pendingclaimcountcode.equalsIgnoreCase("201"));
		
    	break;
    	
    case "LoadMasterData/GetTypeOfWork" :
    	///api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid=1&Domain=gdata
    	  
    	String typeofworkcode= gdata1.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
		 
		 assertTrue(typeofworkcode.equalsIgnoreCase("200")||typeofworkcode.equalsIgnoreCase("201"));
    	break;
    	
    	
    case "PolicyCheckOtherClaim/GetBandWisePolicy" :     //get other expense policy   http://192.168.1.14:84/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE=10


    	
   	 noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		 

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
//			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"&Domain="+domaintext+"");
		ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
		System.out.println(BaseUrl+"api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"&Domain="+domaintext+"");
  	String otherpolicycode= gdata1.getContenxtWeb(BaseUrl+"api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"&Domain="+domaintext+"");
		 
		 assertTrue(otherpolicycode.equalsIgnoreCase("200")||otherpolicycode.equalsIgnoreCase("201"));
		 break;
		 
    case "PolicyCheck/GetCheckAllowed" :
	   
 	
		  
		  String allowclaimtypescode= gdata1.getContenxtWeb(BaseUrl+"api/PolicyCheck/GetCheckAllowed?Band="+bandid+"&EmpId="+empdata+"&Domain="+domaintext+"");
	 		 
	 		 assertTrue(allowclaimtypescode.equalsIgnoreCase("200")||allowclaimtypescode.equalsIgnoreCase("201"));
	 		 break;
    	
    case "OtherClaimView/ValidateOtherClaim" : //  validate other claim
    	
   	    	
   	    	  noename="";
   	 		//TestData.GetData gdata = new  TestData.GetData();
   	 		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
    	 		
    	
    	 		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
    	 		
    	 		for( j=0;j<noearray1.size();j++)
    	 		{
    	 			
    	 			 noename=noearray1.get(j);
//    	 			System.out.println("Noe name is:->>>>>>>>>"+noename);
    	 			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
    	 			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
   	 			//String noename2=noepolicyarray1.get(1);
    	 			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
    	 			if(noepolicyarray1.size()!=0)
    	 			{
    	 				j=noearray1.size();
    	 			}
    	 		}
    	 		
    	 		  
    	 		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
    	 			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
    	 			 
    	 				
    	 			 wbsarray = new ArrayList<String>();
    	 			
    	 			
    	 			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
    	 			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
    	 			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
    	 			
    	 			 wbscount=0;
    	 			 wbsdata=wbsarray.get(wbscount+1);
   	 				System.out.println("API wbs mode name is "+wbsdata);
    	 				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	 				 localDate = LocalDate.now();
    	 				System.out.println(dtf.format(localDate));
    	 		
    	 		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
    	 		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
    	 		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Domain="+domaintext+"");
    	 		
    	 	        //System.out.println(userresponse);
    	 		    array = gdata.parseFromJSONResponse(userresponse);
    	 		    j=0;
    	 		  
    	 		     ClaimId=array.get(j+7);
    	 		     travelexpenseid=array.get(j+11);
    	 		     //fromdate=array.get(j+5);
    	 		     System.out.println("New claim id is "+ClaimId);
    	 		     System.out.println("New claim id is "+travelexpenseid);
    	          String validateothercode= gdata1.getContenxtWeb(BaseUrl+"api/OtherClaimView/ValidateOtherClaim?date_from="+dtf.format(localDate)+"&date_to="+dtf.format(localDate)+"&emp_id="+empdata+"&noe="+noename+"&expenseID="+travelexpenseid+"&Domain="+domaintext+"");
  		 		 
  		 		 assertTrue(validateothercode.equalsIgnoreCase("200")||validateothercode.equalsIgnoreCase("201"));
    		 		 
    		 		 break;
    		 		 
    		 		 //Danone
  
    case "Place/GetTownList" :     //Get Town list   http://192.168.1.14:84/api/Place/GetTownList?TownType=FromTown&Territory=604


    	 
    	   
    	
		  
		  String territorycode= gdata1.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
	 		 
	 		 assertTrue(territorycode.equalsIgnoreCase("200")||territorycode.equalsIgnoreCase("201"));
		  break;
    case "LoadTravelMode/GetTravelMode" :   //get travel modes for daily allowance
//http://192.168.1.14:82/api/LoadTravelMode/GetTravelMode?empid=604&fromPlace=Barrackpur&toPlace=Naihati&HQType=1716&workType=1708
    	
    	 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

    	
    	
    	i=0;
		 String typeofwork = array1.get(i+1);
		 System.out.println("Type of work is"+typeofwork);
    	
    	
    	
		 System.out.println(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
			  ArrayList<String> arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
				 System.out.println(arraytown);
				 i=0;
					
				 String towndata=arraytown.get(i);
				 String hqtypedata=arraytown.get(i+1);
				 System.out.println("API town name is "+towndata);
				 System.out.println("API hqtype name is "+hqtypedata);
				 
				 String[] arrOfStr = towndata.split("-", 0); 
					//System.out.println(Arrays.toString(towndata.split("-")));
					i=0;
					//String[] townarray = Arrays.toString(towndata.split("-"));
	                //String fromTown = Arrays.toString(towndata.split("-"))
					String fromtown = arrOfStr[0];
					String totown = arrOfStr[1];
    	
    	String travemodedanonecode= gdata1.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"&Domain="+domaintext+"");
		 
		 assertTrue(travemodedanonecode.equalsIgnoreCase("200")||travemodedanonecode.equalsIgnoreCase("201"));
		 break;
		 
    
    	
		  
    case "LoadDistance/GetKmDistance" :    //get km distance       

    	    
    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

  
  	
  	i=0;
		  typeofwork = array1.get(i+1);
    	
    	
		  
		  userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
			 i=0;
				
			  towndata=arraytown.get(i);
			
			
		
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
                //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];

			System.out.println("From town is"+arrOfStr[0]);
			System.out.println("From town is"+arrOfStr[1]);
			String insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
	    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
			 ArrayList<String> hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
			
			 String hqtype = hqtypearray.get(1);
			 System.out.println("HQ id is"+hqtype);
			
	    	 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+""
	    	 		+ "&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+""
	    	 				+ "&Domain="+domaintext+"");
			   ArrayList<String> danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
               System.out.println(danonetravelmodedata);
			i=0;
			
			String danonetravelmode=danonetravelmodedata.get(i+1);
			
			
			
			
			String travelwayresponse = gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TravelWay&empid="+empdata+"&Domain="+domaintext+"");
			
			ArrayList<String> travelwayarray=gdata.parseFromJSONarrayResponse(travelwayresponse);
			i=0;
			String travelwayid = travelwayarray.get(i+1);
			System.out.println(BaseUrl+"api/LoadDistance/GetKmDistance?Territory="+territiryId+""
					+ "&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&TravelMode="+danonetravelmode+"&travelWay="+travelwayid+"&Domain="+domaintext+"");
			
			
			String kmdistancecode= gdata1.getContenxtWeb(BaseUrl+"api/LoadDistance/GetKmDistance?Territory="+territiryId+""
					+ "&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&TravelMode="+danonetravelmode+"&travelWay="+travelwayid+"&Domain="+domaintext+"");
	 		 
	 		 assertTrue(kmdistancecode.equalsIgnoreCase("200")||kmdistancecode.equalsIgnoreCase("201"));
	 		 
	 		 
	 		 

             break;
	 		 
	 		 
    case "LoadTravelModePrice/GetTravelModePrice" :    //load travel mode wise price per km for danone

    	
    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	System.out.println("Type of work array is"+array1);
	
	i=0;
		  typeofwork = array1.get(i+1);
  	
  	
		  
		  userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
			 i=0;
				
			  towndata=arraytown.get(i);
			
			 System.out.println("API town name is "+towndata);
			
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
              //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					
					  hqtype = hqtypearray.get(0);
		
			
	    	 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
			    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
             System.out.println(danonetravelmodedata);
			i=0;
			
			 danonetravelmode=danonetravelmodedata.get(i+1);
			 
			 
			 String kmdetailscode= gdata1.getContenxtWeb(BaseUrl+"api/LoadTravelModePrice/GetTravelModePrice?travelmode="+danonetravelmode+"&Domain="+domaintext+"");
			 
			 assertTrue(kmdetailscode.equalsIgnoreCase("200")||kmdetailscode.equalsIgnoreCase("201"));
	    	break;
	    	
	    	
    case "Allowance/GetAllowance?AllowanceHead" :  //get allowance amount for fieldwork
             //http://192.168.1.14:84/api/Allowance/GetAllowance?AllowanceHead=1708&empid=604&HQ=1715&Residential=0&NightHalt=0

    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	System.out.println("Type of work array is"+array1);
	
	i=0;
		  typeofwork = array1.get(i+1);
		  System.out.println("Type of work  is"+typeofwork);
		  System.out.println(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
			 i=0;
				
			  towndata=arraytown.get(i);
			
			 System.out.println("API town name is "+towndata);
			
			 
			  arrOfStr = towndata.split("-", 0); 
			  fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
			  insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
		    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
				  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
				 System.out.println(hqtypearray);
				  hqtype = hqtypearray.get(0);
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
              //String fromTown = Arrays.toString(towndata.split("-"))
				 
				 System.out.println(BaseUrl+"api/Allowance/GetAllowance?AllowanceHead="+typeofwork+"&empid="+empdata+""
			    			+ "&HQ="+hqtype+"&Residential=0&NightHalt=0&INOUTNA=1&Domain="+domaintext+"");
    	String allowanceamountcode= gdata1.getContenxtWeb(BaseUrl+"api/Allowance/GetAllowance?AllowanceHead="+typeofwork+"&empid="+empdata+""
    			+ "&HQ="+hqtype+"&Residential=0&NightHalt=0&INOUTNA=1&Domain="+domaintext+"");
		 
		 assertTrue(allowanceamountcode.equalsIgnoreCase("200")||allowanceamountcode.equalsIgnoreCase("201"));
   	break;
   	
   	
    case "DailyAllowance/InsertDailyAllowance" :    //insert daily allowance

    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		  typeofwork = array1.get(i+2);
    	
    	
		   
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
			 i=0;
				
			  towndata=arraytown.get(i);
			 
			 System.out.println("API town name is "+towndata);
		
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
              //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				  String Residentialvalue = array1.get(i+2);
				  
				  insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					 System.out.println(hqtypearray);
					  hqtype = hqtypearray.get(0);
				  System.out.println(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TravelWay&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				  String travelwayvalue = array1.get(i+2);
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=HQType&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				  String staytown = array1.get(i+2);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
				System.out.println(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
		    			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
		    			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
		    			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
		    					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");	

    	String insertallowancecode= gdata1.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
    			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
    			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
    			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
    					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");
		 
		 assertTrue(insertallowancecode.equalsIgnoreCase("200")||insertallowancecode.equalsIgnoreCase("201"));
    	     break;
    	     
    	     
    case "DailyAllowance/UpdateDailyAllowance" :   //update daily allowance

    
    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		  typeofwork = array1.get(i+1);
  	
  	
		   
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
		
			 i=0;
				
			  towndata=arraytown.get(i);
			 
			 System.out.println("API town name is "+towndata);
		
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
            //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				   Residentialvalue = array1.get(i+1);
				  
				  insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					 System.out.println(hqtypearray);
					  hqtype = hqtypearray.get(0);
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TravelWay&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=HQType&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   staytown = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					
//					///api/DailyAllowance/InsertDailyAllowance?empid=604&ClaimDate=05/08/2018&WorkType=1710&FromTown=Barrackpur&ToTown=Kalyani
//					&HQType=1716&NightHalt=0&Residential=1722&Allowance=800.00&TravelMode=1&TravelWay=1720&KmDistance=20&Fare=200.00&DoctorCalls=5
//							&ChemistCalls=3&Month=4&Year=2018&INOUTNA=&StayTown=&RandomNo=&FoodAmt=&LaundryAmt=&HotelAmt=&FoodLaundryHotel=&HotelTax=&Domain=gdata
  	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
  			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
  			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
  			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
  					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");    	 
    	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		
		  
		  String updateallowancecode= gdata1.getContenxtWeb(BaseUrl+"api/DailyAllowance/UpdateDailyAllowance?AllowanceId="+travelexpenseid+""
		  		+ "&ClaimId="+ClaimId+"&WorkType="+typeofwork+"&FromTown="+fromtown.replace(" ", "%20")+"&ToTown="+totown.replace(" ", "%20")+"&HQType="+hqtype+"&NightHalt=1"
		  		+ "&Residential="+Residentialvalue+"&Allowance=900.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=21&Fare=201.00&DoctorCalls=6"
		  		+ "&ChemistCalls=6&INOUTNA=1&StayTown="+staytown+"&FoodAmt=0&LaundryAmt=0&HotelAmt=0&FoodLaundryHotel=0&HotelTax=0&Random=0&Domain="+domaintext+"");
			 
			 assertTrue(updateallowancecode.equalsIgnoreCase("200")||updateallowancecode.equalsIgnoreCase("201"));
	    	     break;
	    	     
    case "DailyAllowanceByID/GetAllowanceByClaimID" :   //Get daily allowance by claim id

    	

    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		  typeofwork = array1.get(i+1);
  	
  	
		   
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
			 i=0;
				
			  towndata=arraytown.get(i);
			 
			 System.out.println("API town name is "+towndata);
		
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
            //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   Residentialvalue = array1.get(i+1);
				  
				  insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					 System.out.println(hqtypearray);
					  hqtype = hqtypearray.get(0);
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TravelWay&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=HQType&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				   staytown = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					
//					///api/DailyAllowance/InsertDailyAllowance?empid=604&ClaimDate=05/08/2018&WorkType=1710&FromTown=Barrackpur&ToTown=Kalyani
//					&HQType=1716&NightHalt=0&Residential=1722&Allowance=800.00&TravelMode=1&TravelWay=1720&KmDistance=20&Fare=200.00&DoctorCalls=5
//							&ChemistCalls=3&Month=4&Year=2018&INOUTNA=&StayTown=&RandomNo=&FoodAmt=&LaundryAmt=&HotelAmt=&FoodLaundryHotel=&HotelTax=&Domain=gdata
  	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
  			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
  			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
  			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
  					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");    	 
    	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		  System.out.println(array);
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		  
		  String getallowancecode= gdata1.getContenxtWeb(BaseUrl+"api/DailyAllowanceByID/GetAllowanceByClaimID?ClaimID="+ClaimId+"&Domain="+domaintext+"");
				 
				 assertTrue(getallowancecode.equalsIgnoreCase("200")||getallowancecode.equalsIgnoreCase("201"));
		    	     break;
		    	     
		    	     
    case "DailyAllowanceByID/ClaimStatus" :   //get claim status by claim id

    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		  typeofwork = array1.get(i+1);
	
	
		   
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
			 i=0;
				
			  towndata=arraytown.get(i);
			 
			 System.out.println("API town name is "+towndata);
		
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
          //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				   Residentialvalue = array1.get(i+1);
				  
				  insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					
					  hqtype = hqtypearray.get(0);
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TravelWay&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=HQType&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   staytown = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					
//					///api/DailyAllowance/InsertDailyAllowance?empid=604&ClaimDate=05/08/2018&WorkType=1710&FromTown=Barrackpur&ToTown=Kalyani
//					&HQType=1716&NightHalt=0&Residential=1722&Allowance=800.00&TravelMode=1&TravelWay=1720&KmDistance=20&Fare=200.00&DoctorCalls=5
//							&ChemistCalls=3&Month=4&Year=2018&INOUTNA=&StayTown=&RandomNo=&FoodAmt=&LaundryAmt=&HotelAmt=&FoodLaundryHotel=&HotelTax=&Domain=gdata
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");    	 
  	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		  
		  String getallowancestatuscode= gdata1.getContenxtWeb(BaseUrl+"api/DailyAllowanceByID/ClaimStatus?claim="+ClaimId+"&Domain="+domaintext+"");
				 
				 assertTrue(getallowancestatuscode.equalsIgnoreCase("200")||getallowancestatuscode.equalsIgnoreCase("201"));
		    	     break;
    	
    case "DanoneDashboard/GetDashboard" :   //get dashboard data for danone
    	
    	System.out.println(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
    	String danonedashboardcode= gdata1.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+1+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
		 
		 assertTrue(danonedashboardcode.equalsIgnoreCase("200")||danonedashboardcode.equalsIgnoreCase("201"));
   	     break;
   	     
    case "DanoneDashboard/GetApproverDashboard" :  //get approver dashboard for danone
    	
    	
    System.out.println(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+1+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");	
  	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+((current.get(Calendar.MONTH))+1)+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
  	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
  	
  	 i=0;
  	if(array1.size()!=0)
	{
		ClaimId=array1.get(i);
	}
	else if(ClaimId.equalsIgnoreCase(""))
	{
		ClaimId="0";
	}
  	 System.out.println(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId=\"+ClaimId+\"\"");
    	 String deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid=\"+empdata+\"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		  typeofwork = array1.get(i+1);
	
	
		   
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			
			 i=0;
				
			  towndata=arraytown.get(i);
			  hqtypedata=arraytown.get(i+1);
			 System.out.println("API town name is "+towndata);
			 System.out.println("API hqtype name is "+hqtypedata);
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
        //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
			
			i=0;
				   Residentialvalue = array1.get(i+1);
				  
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.replace(" ", "%20")+"&ToTown="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&NightHalt=0"
			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
			+ "&ChemistCalls=3&Month="+(current.get(Calendar.MONTH))+"&Year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		  System.out.println("New claim id is "+travelexpenseid); 
		  System.out.println(BaseUrl+"/api/Submit/SubmitClaim?ClaimID="+ClaimId+"&Domain="+domaintext+""); 

		 String  submitclaimcode= gdata.getContenxtWeb(BaseUrl+"api/Submit/SubmitClaim?ClaimID="+ClaimId+"&Domain="+domaintext+"");
		   
		   
		   
    	
		   
		   
		  String  managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
			
			
			ArrayList<String>  arraymanager = gdata.parseFromJSONResponse(managerresponse);
			 
			
			  k=0;

			
			 managerdata=arraymanager.get(k+2);
		   
		   String managerclaimscode= gdata1.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetApproverDashboard?"
		   		+ "empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&approverid="+managerdata+"&status=pending&Team="+teamId+"&Zone="+zoneId+"&Domain="+domaintext+"");
			 
			 assertTrue(managerclaimscode.equalsIgnoreCase("200")||managerclaimscode.equalsIgnoreCase("201"));
	   	     //String deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"");
    	
    	break;
    	
    case "DanoneDashboard/GetClaimFinalTotal" :   //get claims final total
             //http://192.168.1.14:84/api/DanoneDashboard/GetClaimFinalTotal?claim=17049
    	//String deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"");

    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid=\"+empdata+\"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	System.out.println("Type of work array is"+array1);
	
	i=0;
		  typeofwork = array1.get(i+1);
	
	
		   
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			
			 i=0;
				
			  towndata=arraytown.get(i);
			  hqtypedata=arraytown.get(i+1);
			 System.out.println("API town name is "+towndata);
			 System.out.println("API hqtype name is "+hqtypedata);
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
        //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   Residentialvalue = array1.get(i+1);
				  
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.replace(" ", "%20")+"&ToTown="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&NightHalt=0"
			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
			+ "&ChemistCalls=3&Month="+(current.get(Calendar.MONTH))+"&Year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		 
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		  System.out.println("New claim id is "+travelexpenseid);    	
    	String claimsfinaltotaldcode= gdata1.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetClaimFinalTotal?claim="+ClaimId+"&Domain="+domaintext+"");
		 
		 assertTrue(claimsfinaltotaldcode.equalsIgnoreCase("200")||claimsfinaltotaldcode.equalsIgnoreCase("201"));
  	     break;
    case "dashboard/GetMonths" : //list of months

    	
    	
    	String listofmonthscode= gdata1.getContenxtWeb(BaseUrl+"api/dashboard/GetMonths?Domain="+domaintext+"");
		 
		 assertTrue(listofmonthscode.equalsIgnoreCase("200")||listofmonthscode.equalsIgnoreCase("201"));
 	     break;
 	     
    case "dashboard/GetWeeks" :   //weeks
    	
    	String weekscode= gdata1.getContenxtWeb(BaseUrl+"api/dashboard/GetWeeks?Month="+current.get(Calendar.MONTH)+"&Year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
		 
		 assertTrue(weekscode.equalsIgnoreCase("200")||weekscode.equalsIgnoreCase("201"));
	     break;
	     
	     
    case "DanoneDashboard/GetClaimApprovedTotal" : //get claim approved total

    	
//    System.out.println(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");	
	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
	 
	 i=0;
	
	System.out.println("here"+ClaimId);
	if(array1.size()!=0)
	{
		ClaimId=array1.get(i);
	}
	else if(ClaimId.equalsIgnoreCase(""))
	{
		ClaimId="0";
	}
	 System.out.println(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId=\"+ClaimId+\"\"");
  	  deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

  	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid=\"+empdata+\"&Domain="+domaintext+"");
  	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		  typeofwork = array1.get(i+1);
	
	
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			
			 i=0;
				
			  towndata=arraytown.get(i);
			  hqtypedata=arraytown.get(i+1);
			 System.out.println("API town name is "+towndata);
			 System.out.println("API hqtype name is "+hqtypedata);
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
      //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   Residentialvalue = array1.get(i+1);
				  
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.replace(" ", "%20")+"&ToTown="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&NightHalt=0"
			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
			+ "&ChemistCalls=3&Month="+(current.get(Calendar.MONTH))+"&Year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		 
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		  System.out.println("New claim id is "+travelexpenseid); 

		   submitclaimcode= gdata.getContenxtWeb(BaseUrl+"api/Submit/SubmitClaim?ClaimID="+ClaimId+"&Domain="+domaintext+"");
		   
		   
		   
  	
		   
		   
		    managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
			
			
			  arraymanager = gdata.parseFromJSONResponse(managerresponse);
			 
		
			  k=0;

			
			 managerdata=arraymanager.get(k+2);
			 
//			 System.out.println(BaseUrl+"/api/ClaimProcessing/ApproveDissapproveClaims?claim_id="+ClaimId+"&reccID="+managerdata+"&remarks=604&action=1&status=yes");
			 String approvedailyallowanceclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/ClaimProcessing/ApproveDissapproveClaims?claim_id="+ClaimId+"&reccID="+managerdata+"&remarks=604&action=1&status=yes&Domain="+domaintext+"");
			 assertTrue(approvedailyallowanceclaimcode.equalsIgnoreCase("200")||approvedailyallowanceclaimcode.equalsIgnoreCase("201"));
			 
//			System.out.println(BaseUrl+"/api/DanoneDashboard/GetClaimApprovedTotal?Approvedclaimid="+ClaimId+"&Domain="+domaintext+"");
			 String approvetotalcode= gdata1.getContenxtWeb(BaseUrl+"/api/DanoneDashboard/GetClaimApprovedTotal?Approvedclaimid="+ClaimId+"&Domain="+domaintext+"");
			 assertTrue(approvetotalcode.equalsIgnoreCase("200")||approvetotalcode.equalsIgnoreCase("201"));
    	break;
    	
    case "Employees/GetEmployees" :  //Get employee list
    	
    	String employeelistcode= gdata1.getContenxtWeb(BaseUrl+"/api/Employees/GetEmployees?TeamId=0&ZoneId=0&Domain="+domaintext+"");
		 assertTrue(employeelistcode.equalsIgnoreCase("200")||employeelistcode.equalsIgnoreCase("201"));
	break;
    	  
	
    case "ExceedAmount/GetAppliedTotal" :  //get claim applied total amount

    	//http://192.168.1.14:84/api/ExceedAmount/GetAppliedTotal?week=11/27/2016~12/03/2016&Empid=65656&claimid=0
    	
    	String claimappliadtotalamountcode= gdata1.getContenxtWeb(BaseUrl+"/api/ExceedAmount/GetAppliedTotal?"
    			+ "week=0&Empid="+empdata+"&claimid=0&Domain="+domaintext+"");
		 assertTrue(claimappliadtotalamountcode.equalsIgnoreCase("200")||claimappliadtotalamountcode.equalsIgnoreCase("201"));
	break;
    case "ExceedAmount/CalculateBalanceAmountToAddClaim" :    //calculate balance amount while adding claim

    	//http://192.168.1.14:84/api/ExceedAmount/CalculateBalanceAmountToAddClaim?month=12&year=2018&Empid=686&noe=12&claimType=3&band=518&travelmode=3&foodplace=1&day=1&status=yes

    	
		   
		    localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
		   
			  claimtypemastercaode= gdata.getContenxtWeb(BaseUrl+"/api/Master/GetAllClaimType?status=yes&Domain="+domaintext+"");
                array = gdata.parseFromJSONarrayResponse(claimtypemastercaode);
               
                for(int k=0;k<array.size();k++)
                {
                	
                	System.out.println(array.get(k+1));
                	String balanceamountcode= gdata1.getContenxtWeb(BaseUrl+"/api/ExceedAmount/CalculateBalanceAmountToAddClaim?"
                			+ "month="+current.get(Calendar.MONTH)+"&year="+current.get(Calendar.YEAR)+"&Empid="+empdata+""
                					+ "&noe=12&claimType="+array.get(k+1)+"&band="+bandid+"&travelmode="+localtravelmodedata+"&foodplace=1&day=1&status=yes&Domain="+domaintext+"");
            		 assertTrue(balanceamountcode.equalsIgnoreCase("200")||balanceamountcode.equalsIgnoreCase("201"));
                	k++;
                }
		   
    	
		 
		 
	break;
	
	
    case "GetAllowanceByID/GetAllowanceByID" :   //get daily allowance by allowance id
//
    	
    	
	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
	 
	 i=0;
	 if(array1.size()!=0)
		{
			ClaimId=array1.get(i);
		}
		else if(ClaimId.equalsIgnoreCase(""))
		{
			ClaimId="0";
		}
	 System.out.println(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"");
	  deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		  typeofwork = array1.get(i+1);
	
	
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
			 i=0;
				
			  towndata=arraytown.get(i);
			
			
			
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
    //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				   Residentialvalue = array1.get(i+1);
				  
				   insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					 System.out.println(hqtypearray);
					  hqtype = hqtypearray.get(0);
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
					 insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
				    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
						  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
						 System.out.println(hqtypearray);
						  hqtype = hqtypearray.get(0);
						  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=HQType&empid="+empdata+"&Domain="+domaintext+"");
					    	
						  array1 =gdata.parseFromJSONarrayResponse(userresponse);

					System.out.println("Type of work array is"+array1);
					
					i=0;
						   staytown = array1.get(i+1);
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
 			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
 			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
 			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
 					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		  System.out.println("New claim id is "+travelexpenseid); 
		  
    	String balanceamountcode= gdata1.getContenxtWeb(BaseUrl+"/api/GetAllowanceByID/GetAllowanceByID?AllowanceID="+travelexpenseid+"&Domain="+domaintext+"");
		 assertTrue(balanceamountcode.equalsIgnoreCase("200")||balanceamountcode.equalsIgnoreCase("201"));
		 break;
		 
		 
    case "DanoneDashboard/CalculateMaxAllowance" :   //calculate maximum allowance

    	
    	
    	dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		 localDate = LocalDate.now();
		 
    	String maxallowancecode= gdata1.getContenxtWeb(BaseUrl+"/api/DanoneDashboard/CalculateMaxAllowance?"
    			+ "month="+current.get(Calendar.MONTH)+"&year="+current.get(Calendar.YEAR)+"&claimdate="+dtf.format(localDate)+"&empid="+empdata+"&Domain="+domaintext+"");
		 assertTrue(maxallowancecode.equalsIgnoreCase("200")||maxallowancecode.equalsIgnoreCase("201"));
		 break;
    	
    case "GetTravelFare/GetTravelFare" :  //get travel fare
    	
    	
    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		  typeofwork = array1.get(i+1);
    	
    	
		   
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			
			 i=0;
				
			  towndata=arraytown.get(i);
			 
			 System.out.println("API town name is "+towndata);
			
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
  //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 
				 insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					 System.out.println(hqtypearray);
					  hqtype = hqtypearray.get(0);

    	dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		 localDate = LocalDate.now();
		  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
		    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
       System.out.println(danonetravelmodedata);
		i=0;
		
		 danonetravelmode=danonetravelmodedata.get(i+1);
		 
		 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TravelWay&empid="+empdata+"&Domain="+domaintext+"");
	    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		   travelwayvalue = array1.get(i+1);
		  
    	String travelfarecode= gdata1.getContenxtWeb(BaseUrl+"/api/GetTravelFare/GetTravelFare?TravelMode="+danonetravelmode+"&travelWay="+travelwayvalue+"&travelKm=20&Domain="+domaintext+"");
		 assertTrue(travelfarecode.equalsIgnoreCase("200")||travelfarecode.equalsIgnoreCase("201"));
		 break;
		 
		 
    case "OtherClaim/InsertDanoneOtherExpense" : // insert danone other claim
    	
    	noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
//			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
    	
    	
    	
	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
	 i=0;
	 if(array1.size()!=0)
		{
			ClaimId=array1.get(i);
		}
		else if(ClaimId.equalsIgnoreCase(""))
		{
			ClaimId="0";
		}
	System.out.println(ClaimId);
	
	  deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid=\"+empdata+\"&Domain="+domaintext+"");
	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		  typeofwork = array1.get(i+1);
	
	
		   
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			
			 i=0;
				
			  towndata=arraytown.get(i);
			  hqtypedata=arraytown.get(i+1);
			 System.out.println("API town name is "+towndata);
			 System.out.println("API hqtype name is "+hqtypedata);
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
  //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   Residentialvalue = array1.get(i+1);
				  
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.replace(" ", "%20")+"&ToTown="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&NightHalt=0"
			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
			+ "&ChemistCalls=3&Month="+(current.get(Calendar.MONTH))+"&Year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		 
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		
    	String insertdanoneothercode= gdata1.getContenxtWeb(BaseUrl+"/api/OtherClaim/InsertDanoneOtherExpense?"
    			+ "ClaimId="+ClaimId+"&Amount=500&expenseType="+noename+"&Comments=mobileclaim&Domain="+domaintext+"");
		 assertTrue(insertdanoneothercode.equalsIgnoreCase("200")||insertdanoneothercode.equalsIgnoreCase("201"));
		 break;
		 
    case "GetCoverageType/LoadCoverageType" :   //load territry coverage types

    	
    	
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			
			 i=0;
				
			  towndata=arraytown.get(i);
			  hqtypedata=arraytown.get(i+1);
			 System.out.println("API town name is "+towndata);
			 System.out.println("API hqtype name is "+hqtypedata);
			 
			  arrOfStr = towndata.split("-",0); 
				System.out.println(arrOfStr);
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
//String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 System.out.println(fromtown.trim());
				 
				 totown = arrOfStr[1];
				 System.out.println(totown.trim());
//    	System.out.println(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
//    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
    	 insertterritorycoveragetypecode= gdata1.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
		 assertTrue(insertterritorycoveragetypecode.equalsIgnoreCase("200")||insertterritorycoveragetypecode.equalsIgnoreCase("201"));
		 break;
		 
		 
		 
    case "OtherClaimView/UpdateDanoneOtherClaim" :  //update danone other claim

    	
    	noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
    	
    	
    	
	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
	 
	 i=0;
	 if(array1.size()!=0)
		{
			ClaimId=array1.get(i);
		}
		else if(ClaimId.equalsIgnoreCase(""))
		{
			ClaimId="0";
		}
	 System.out.println(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");
	  deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid=\"+empdata+\"&Domain="+domaintext+"");
	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	
	
	i=0;
		  typeofwork = array1.get(i+1);
	
	
		   
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			
			 i=0;
				
			  towndata=arraytown.get(i);
			  hqtypedata=arraytown.get(i+1);
			 System.out.println("API town name is "+towndata);
			 System.out.println("API hqtype name is "+hqtypedata);
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
  //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   Residentialvalue = array1.get(i+1);
				  
				  
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

		
			
			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.replace(" ", "%20")+"&ToTown="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&NightHalt=0"
			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
			+ "&ChemistCalls=3&Month="+(current.get(Calendar.MONTH))+"&Year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		  
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		

    	 insertdanoneothercode= gdata.getContenxtWeb(BaseUrl+"/api/OtherClaim/InsertDanoneOtherExpense?"
    			+ "ClaimId="+ClaimId+"&Amount=500&expenseType="+noename+"&Comments=mobileclaim&Domain="+domaintext+"");
           array = gdata.parseFromJSONResponse(insertdanoneothercode);
         
           i=0;
    	String otherexpenseid=array.get(i+11);
    	String updateotherdanonecode= gdata1.getContenxtWeb(BaseUrl+"/api/OtherClaimView/UpdateDanoneOtherClaim?"
    			+ "Claimid="+ClaimId+"&amount=522&noe="+noename+"&remarks=edited&expenseid="+otherexpenseid+"&Domain="+domaintext+"");
		 assertTrue(updateotherdanonecode.equalsIgnoreCase("200")||updateotherdanonecode.equalsIgnoreCase("201"));
		 break;
		 
		 
    case "OtherClaimView/ValidateDanoneOtherClaim" :   //validate danone other claim
    	
    	
    	
    	noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
//			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
    	
    	
    	
	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
	 i=0;
	 if(array1.size()!=0)
		{
			ClaimId=array1.get(i);
		}
		else if(ClaimId.equalsIgnoreCase(""))
		{
			ClaimId="0";
		}
	  deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid=\"+empdata+\"&Domain="+domaintext+"");
	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);
	i=0;
		  typeofwork = array1.get(i+1);
	
	
		   
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 i=0;
			  towndata=arraytown.get(i);
			  hqtypedata=arraytown.get(i+1);
			  arrOfStr = towndata.split("-", 0); 
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			i=0;
				   Residentialvalue = array1.get(i+1);
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	           
				i=0;
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.replace(" ", "%20")+"&ToTown="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&NightHalt=0"
			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
			+ "&ChemistCalls=3&Month="+(current.get(Calendar.MONTH))+"&Year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		 
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		  System.out.println(BaseUrl+"/api/OtherClaim/InsertDanoneOtherExpense?"
	    			+ "ClaimId="+ClaimId+"&Amount=500&expenseType="+noename+"&Comments=mobileclaim&Domain="+domaintext+"");

    	 insertdanoneothercode= gdata.getContenxtWeb(BaseUrl+"/api/OtherClaim/InsertDanoneOtherExpense?"
    			+ "ClaimId="+ClaimId+"&Amount=500&expenseType="+noename+"&Comments=mobileclaim&Domain="+domaintext+"");
           array = gdata.parseFromJSONResponse(insertdanoneothercode);
           i=0;
    	 otherexpenseid=array.get(i+11);
    	String validateotherexpensecode= gdata1.getContenxtWeb(BaseUrl+"/api/OtherClaimView/ValidateDanoneOtherClaim?"
    			+ "claimid="+ClaimId+"&noe="+noename+"&empid="+empdata+"&expenseid="+otherexpenseid+"&amount=0&Domain="+domaintext+"");
		 assertTrue(validateotherexpensecode.equalsIgnoreCase("200")||validateotherexpensecode.equalsIgnoreCase("201"));
		 break;
		 
		 
    case "PaymentAction/GetDataForDashboardHGS" :  //payment team dashboard data

    	
    	String paymentteamdashboardcode= gdata1.getContenxtWeb(BaseUrl+"/api/PaymentAction/GetDataForDashboardHGS?month="+current.get(Calendar.MONTH)+"&year="+current.get(Calendar.YEAR)+"&type=HGSPending&Domain="+domaintext+"");
		 assertTrue(paymentteamdashboardcode.equalsIgnoreCase("200")||paymentteamdashboardcode.equalsIgnoreCase("201"));
		 break;
		 
    case "PolicyCheck/ViewPolicy" :   //band wise policy view

    	
    	
    	
    	String viewpolicycode= gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/ViewPolicy?ClaimID="+policytype+"&Band="+bandid+"&Domain="+domaintext+"");
		 assertTrue(viewpolicycode.equalsIgnoreCase("200")||viewpolicycode.equalsIgnoreCase("201"));
		 break;
		 
    case "PolicyCheck/GetCheckAllowedClaimTypes" :   //get allowed claim types

    	
    	
		   String getallowclaimtypes= gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetCheckAllowedClaimTypes?mode=&Band="+bandid+"&EmpId="+empdata+"&Domain="+domaintext+"");
			 assertTrue(getallowclaimtypes.equalsIgnoreCase("200")||getallowclaimtypes.equalsIgnoreCase("201"));
			 break;
		 
		 
    case "PolicyCheck/GetClaimTypeWiseClaimAmountLimit" : //get claim wise amount limit
    	
    	noename="";
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		for( j=0;j<noearray1.size();j++)
		{
			 noename=noearray1.get(j);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
    	
    	String claimamountlimittypes= gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetClaimTypeWiseClaimAmountLimit?mode="+policytype+"&band="+bandid+"&noe="+noename+"&status=yes&Domain="+domaintext+"");
		 assertTrue(claimamountlimittypes.equalsIgnoreCase("200")||claimamountlimittypes.equalsIgnoreCase("201"));
		 break;
		 
		 
    case "TravelClaim/GetBandWisePolicyDetails":  //check applied claim types
    	
    	
    	String getbandwisecode= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetBandWisePolicyDetails?EmpID="+empdata+"&ClaimWeek=0&Domain="+domaintext+"");
		 assertTrue(getbandwisecode.equalsIgnoreCase("200")||getbandwisecode.equalsIgnoreCase("201"));
		 break;
    	
    case "DanoneDashboard/GetOtherExpenseDashboard" :  //get other expenses dashboard for danone

    	noename="";
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			 noename=noearray1.get(j);
//			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
    	
    	
    	
	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
	 i=0;
	 if(array1.size()!=0)
		{
			ClaimId=array1.get(i);
		}
		else if(ClaimId.equalsIgnoreCase(""))
		{
			ClaimId="0";
		}
	  deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid=\"+empdata+\"&Domain="+domaintext+"");
	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);
	i=0;
		  typeofwork = array1.get(i+1);
	
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	
			 i=0;
			  towndata=arraytown.get(i);
			  hqtypedata=arraytown.get(i+1);
			 System.out.println("API town name is "+towndata);
			 System.out.println("API hqtype name is "+hqtypedata);
			 
			  arrOfStr = towndata.split("-", 0); 
				//System.out.println(Arrays.toString(towndata.split("-")));
				i=0;
				//String[] townarray = Arrays.toString(towndata.split("-"));
  //String fromTown = Arrays.toString(towndata.split("-"))
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);
			i=0;
				   Residentialvalue = array1.get(i+1);
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid=\"+empdata+\"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
			
			i=0;
				   travelwayvalue = array1.get(i+1);
				  
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.replace(" ", "%20")+"&ToTown="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&NightHalt=0"
			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
			+ "&ChemistCalls=3&Month="+(current.get(Calendar.MONTH))+"&Year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		  System.out.println(array);
		  ClaimId=array.get(j+16);
		  travelexpenseid=array.get(j+17);
		  //fromdate=array.get(j+5);
		

    	 insertdanoneothercode= gdata.getContenxtWeb(BaseUrl+"/api/OtherClaim/InsertDanoneOtherExpense?"
    			+ "ClaimId="+ClaimId+"&Amount=500&expenseType="+noename+"&Comments=mobileclaim&Domain="+domaintext+"");

    	
    	String otherexpensedashboardcode= gdata1.getContenxtWeb(BaseUrl+"/api/DanoneDashboard/GetOtherExpenseDashboard?claimid="+ClaimId+"&Domain="+domaintext+"");
		 assertTrue(otherexpensedashboardcode.equalsIgnoreCase("200")||otherexpensedashboardcode.equalsIgnoreCase("201"));
		 break;
		 
    case "Dashboard/GetClaimDetailsByClaimID" :   //get claim details by claim id
    	
    	
		  
	System.out.println(BaseUrl+"api/travelclaim/GetCityDataList");
	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
	 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
	 

		
		  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		
	
		  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
		  cityno=0;
		
		  citynamefromdata=cityarray1.get(cityno+1);
		  citynametodata=cityarray1.get(cityno+2);
		 System.out.println("API CIty name is "+citynamefromdata);
		 System.out.println("API CIty name is "+citynametodata);
	
	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
	 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
	 
		
	 wbsarray = new ArrayList<String>();
		
		
		System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
		 wbscount=0;
		 wbsdata=wbsarray.get(wbscount+1);
	
		 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
		 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
		 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
		 
		 
		  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

		  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
		 localtravelmodecount=0;
		 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		 localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		
		
		 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
			 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
			 				+ "&travelFrom=chinchpokli"
			 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&Domain="+domaintext+"");
			
		System.out.println(userresponse);
		  localarray = gdata.parseFromJSONarrayResponse(userresponse);
		  
		 System.out.println(localarray);
		  j=0;
		  ClaimId=localarray.get(j);
		  travelexpenseid=localarray.get(j+1);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);

    	String claimdetailscode= gdata1.getContenxtWeb(BaseUrl+"/api/Dashboard/GetClaimDetailsByClaimID?ClaimID="+ClaimId+"&Domain="+domaintext+"");
		 assertTrue(claimdetailscode.equalsIgnoreCase("200")||claimdetailscode.equalsIgnoreCase("201"));
		 break;
		 
    case "TravelClaimView/Get" :   //get current week   Http://192.168.1.14:84/api/TravelClaimView/Get

    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 break;
		 
    case "Mobile/GetEmpAppliedClaimData" :  //get applied mobile claim data  

    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 		
    	break;
		 
		 
    case "LandLineClaim/GetEmpAppliedClaimDataLandLine" :  //get applied landline claim data  

    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 		 
    	break;
		 
    case "otherClaim/GetEmpAppliedClaimDataOthe" :  //get other claims for week
  

    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext);    		
    	break;
		 
		 
    case "Master/GetBindEmployeeClaimTypes" : //claim type list for employees

    	
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 break;
		 
		 
    case "Mobile/GetBandWisePolicyDetails" :   //get mobile claim policy

    	
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 break;
		 
    case "MetroAllowance/InsertMetroAllowance" :  //insert metro allowance for danone
    	
    	
    	
    	noename="";
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
  	
  	
  	
	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
	 i=0;
	 if(array1.size()!=0)
		{
			ClaimId=array1.get(i);
		}
		else if(ClaimId.equalsIgnoreCase(""))
		{
			ClaimId="0";
		}
	  deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);
	i=0;
		  typeofwork = array1.get(i+1);
	
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	
			 i=0;
			  towndata=arraytown.get(i);
			
			 
			  arrOfStr = towndata.split("-", 0); 
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					 System.out.println(hqtypearray);
					  hqtype = hqtypearray.get(0);
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);
			i=0;
				   Residentialvalue = array1.get(i+1);
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);
			i=0;
				   travelwayvalue = array1.get(i+1);
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
					
					  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=HQType&empid="+empdata+"&Domain="+domaintext+"");
				    	
					  array1 =gdata.parseFromJSONarrayResponse(userresponse);

								
				i=0;
					   staytown = array1.get(i+1);
					
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
 			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
 			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
 			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
 					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		  System.out.println(array);
		  ClaimId=array.get(j+16);
		System.out.println(BaseUrl+"/api/MetroAllowance/InsertMetroAllowance?"
    			+ "claimid="+ClaimId+"&empid="+empdata+"&travelmode="+danonetravelmode+"&amount=300&Remarks=test&Domain="+domaintext+"");  
    	String insertmetrocode= gdata1.getContenxtWeb(BaseUrl+"/api/MetroAllowance/InsertMetroAllowance?"
    			+ "claimid="+ClaimId+"&empid="+empdata+"&travelmode="+danonetravelmode+"&amount=300&Remarks=test&Domain="+domaintext+"");
		 assertTrue(insertmetrocode.equalsIgnoreCase("200")||insertmetrocode.equalsIgnoreCase("201"));
		 break;
		 
    case "MetroAllowance/UpdateMetroAllowance" : //Update metro allowance
    	noename="";
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
  	
  	
  	
	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
	 i=0;
	 if(array1.size()!=0)
		{
			ClaimId=array1.get(i);
		}
		else if(ClaimId.equalsIgnoreCase(""))
		{
			ClaimId="0";
		}
	  deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);
	i=0;
		  typeofwork = array1.get(i+1);
	
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	
			 i=0;
			  towndata=arraytown.get(i);
			
			 
			  arrOfStr = towndata.split("-", 0); 
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					 System.out.println(hqtypearray);
					  hqtype = hqtypearray.get(0);
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);
			i=0;
				   Residentialvalue = array1.get(i+1);
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);
			i=0;
				   travelwayvalue = array1.get(i+1);
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
					
					  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=HQType&empid="+empdata+"&Domain="+domaintext+"");
				    	
					  array1 =gdata.parseFromJSONarrayResponse(userresponse);

				
				
				i=0;
					   staytown = array1.get(i+1);
//					   System.out.println(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
//					 			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
//					 			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
//					 			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
//					 					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");			
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
 			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
 			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
 			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
 					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		 
		  ClaimId=array.get(j+16);
//		System.out.println(BaseUrl+"/api/MetroAllowance/InsertMetroAllowance?"
//    			+ "claimid="+ClaimId+"&empid="+empdata+"&travelmode="+danonetravelmode+"&amount=300&Remarks=test&Domain="+domaintext+"");  
    	 insertmetrocode= gdata.getContenxtWeb(BaseUrl+"/api/MetroAllowance/InsertMetroAllowance?"
    			+ "claimid="+ClaimId+"&empid="+empdata+"&travelmode="+danonetravelmode+"&amount=300&Remarks=test&Domain="+domaintext+"");
  	 
  	 array = gdata.parseFromJSONResponse(insertmetrocode);
  	 
  	 i=0;
  	 ClaimId= array.get(i+16);
  	 String mteroexpenseid=array.get(i+20);
  
//  	 System.out.println(BaseUrl+"/api/MetroAllowance/UpdateMetroAllowance?MetroAllowanceId="+mteroexpenseid+"&claimid="+ClaimId+"&travelmode="+danonetravelmode+"&amount=300&Remarks=test&Domain="+domaintext+"");
  	String updatemetro= gdata1.getContenxtWeb(BaseUrl+"/api/MetroAllowance/UpdateMetroAllowance?MetroAllowanceId="+mteroexpenseid+"&claimid="+ClaimId+"&travelmode="+danonetravelmode+"&amount=300&Remarks=test&Domain="+domaintext+"");
	 assertTrue(updatemetro.equalsIgnoreCase("200")||updatemetro.equalsIgnoreCase("201"));
  	 
  	break;
  	
    case "MetroAllowance/GetMetroAllowanceByClaimID" :   //get metro allowance by claimid
    	
    	noename="";
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
	
	
	
	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
	 i=0;
	 if(array1.size()!=0)
		{
			ClaimId=array1.get(i);
		}
		else if(ClaimId.equalsIgnoreCase(""))
		{
			ClaimId="0";
		}
	  deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);
	i=0;
		  typeofwork = array1.get(i+1);
	
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	
			 i=0;
			  towndata=arraytown.get(i);
			
			 
			  arrOfStr = towndata.split("-", 0); 
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					
					  hqtype = hqtypearray.get(0);
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);
			i=0;
				   Residentialvalue = array1.get(i+1);
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);
			i=0;
				   travelwayvalue = array1.get(i+1);
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
					
					  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=HQType&empid="+empdata+"&Domain="+domaintext+"");
				    	
					  array1 =gdata.parseFromJSONarrayResponse(userresponse);

				
				
				i=0;
					   staytown = array1.get(i+1);
//					   System.out.println(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
//					 			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
//					 			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
//					 			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
//					 					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");			
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		 
		  ClaimId=array.get(j+16);
//		System.out.println(BaseUrl+"/api/MetroAllowance/InsertMetroAllowance?"
//  			+ "claimid="+ClaimId+"&empid="+empdata+"&travelmode="+danonetravelmode+"&amount=300&Remarks=test&Domain="+domaintext+"");  
  	 insertmetrocode= gdata.getContenxtWeb(BaseUrl+"/api/MetroAllowance/InsertMetroAllowance?"
  			+ "claimid="+ClaimId+"&empid="+empdata+"&travelmode="+danonetravelmode+"&amount=300&Remarks=test&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertmetrocode);
	
	 i=0;
	 ClaimId= array.get(i+16);
	  mteroexpenseid=array.get(i+20);
		 
	 
	  
	  String metrobyidcode= gdata1.getContenxtWeb(BaseUrl+"/api/MetroAllowance/GetMetroAllowanceByClaimID?MetroClaimID="+ClaimId+"&Domain="+domaintext+"");
		 assertTrue(metrobyidcode.equalsIgnoreCase("200")||metrobyidcode.equalsIgnoreCase("201"));
		 break;
		 
		 
    case "MetroAllowance/GetMetroAllowanceByID": //metro allowance by metroid
    	noename="";
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&Domain="+domaintext+"");
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
	
	
	
	 danonedashboardcode= gdata.getContenxtWeb(BaseUrl+"api/DanoneDashboard/GetDashboard?empid="+empdata+"&month="+(current.get(Calendar.MONTH))+"&year="+current.get(Calendar.YEAR)+"&sortby=CLAIMID&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONarrayResponse(danonedashboardcode);
	 i=0;
	 if(array1.size()!=0)
		{
			ClaimId=array1.get(i);
		}
		else if(ClaimId.equalsIgnoreCase(""))
		{
			ClaimId="0";
		}
	  deletecode= gdata.getContenxtWeb(BaseUrl+"api/DeleteExpenses/DeleteExpense?mode=DailyAllowance&ExpenseId=0&ClaimId="+ClaimId+"&Domain="+domaintext+"");

	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork&empid="+empdata+"&Domain="+domaintext+"");
	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);
	i=0;
		  typeofwork = array1.get(i+1);
	
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"&Domain="+domaintext+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	
			 i=0;
			  towndata=arraytown.get(i);
			
			 
			  arrOfStr = towndata.split("-", 0); 
				 fromtown = arrOfStr[0];
				 totown = arrOfStr[1];
				 insertterritorycoveragetypecode= gdata.getContenxtWeb(BaseUrl+"/api/GetCoverageType/LoadCoverageType?"
			    			+ "Territory="+territiryId+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&Domain="+domaintext+"");
					  hqtypearray = gdata.parseFromJSONarrayResponse(insertterritorycoveragetypecode);	 
					 
					  hqtype = hqtypearray.get(0);
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);
			i=0;
				   Residentialvalue = array1.get(i+1);
				  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.trim()+"&toPlace="+totown.trim()+"&HQType="+hqtype+"&workType="+typeofwork+"&Domain="+domaintext+"");
				    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
	             System.out.println(danonetravelmodedata);
				i=0;
				
				 danonetravelmode=danonetravelmodedata.get(i+1);
				 
				 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=Residential&empid="+empdata+"&Domain="+domaintext+"");
			    	
				  array1 =gdata.parseFromJSONarrayResponse(userresponse);
			i=0;
				   travelwayvalue = array1.get(i+1);
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
					
					  userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=HQType&empid="+empdata+"&Domain="+domaintext+"");
				    	
					  array1 =gdata.parseFromJSONarrayResponse(userresponse);

			
				
				i=0;
					   staytown = array1.get(i+1);
//					   System.out.println(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
//					 			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
//					 			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
//					 			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
//					 					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");			
	 insertallowancecode= gdata.getContenxtWeb(BaseUrl+"api/DailyAllowance/InsertDailyAllowance?empid="+empdata+""
			+ "&ClaimDate="+dtf.format(localDate)+"&WorkType="+typeofwork+"&FromTown="+fromtown.trim()+"&ToTown="+totown.trim()+"&HQType="+hqtype+"&NightHalt=0"
			+ "&Residential="+Residentialvalue+"&Allowance=800.00&TravelMode="+danonetravelmode+"&TravelWay="+travelwayvalue+"&KmDistance=20&Fare=200.00&DoctorCalls=5"
			+ "&ChemistCalls=3&Month=4&Year="+current.get(Calendar.YEAR)+"&INOUTNA=1&StayTown="+staytown+"&RandomNo=0&FoodAmt=0&LaundryAmt=0&HotelAmt=0"
					+ "&FoodLaundryHotel=0&HotelTax=0&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertallowancecode);
		  j=0;
		 
		  ClaimId=array.get(j+16);
		System.out.println(BaseUrl+"/api/MetroAllowance/InsertMetroAllowance?"
			+ "claimid="+ClaimId+"&empid="+empdata+"&travelmode="+danonetravelmode+"&amount=300&Remarks=test&Domain="+domaintext+"");  
	 insertmetrocode= gdata.getContenxtWeb(BaseUrl+"/api/MetroAllowance/InsertMetroAllowance?"
			+ "claimid="+ClaimId+"&empid="+empdata+"&travelmode="+danonetravelmode+"&amount=300&Remarks=test&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(insertmetrocode);
	
	 i=0;
	 ClaimId= array.get(i+16);
	  mteroexpenseid=array.get(i+20);
	  
	   metrobyidcode= gdata1.getContenxtWeb(BaseUrl+"/api/MetroAllowance/GetMetroAllowanceByID?MetroAllowanceId="+mteroexpenseid+"&Domain="+domaintext+"");
		 assertTrue(metrobyidcode.equalsIgnoreCase("200")||metrobyidcode.equalsIgnoreCase("201"));
		 break;
	

    	
		 
    case "AutoApprovalPolicyBandWise/GetAllAutoApproverPolicy" :  //get auto approval policy
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 break;
		 
    case "AutoApprovalPolicyBandWise/GetAllAutoApproverPolicybyBandIDAndClaimtype" :  //get auto approval policy band wise
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 

		 break;
		 
		 
    case "AutoApprovalPolicyBandWise/UpdateAutoRemarksClaim" : //update auto band wise
    	
    	
    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123&Domain="+domaintext+"");
			
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 
		  i=0;

		 
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		 System.out.println(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+4);
			
				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				
				

				  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
				
			
				  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
				  cityno=0;
				
				  citynamefromdata=cityarray1.get(cityno+1);
				  citynametodata=cityarray1.get(cityno+2);
				 
  	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
		 		+ "&NoOfDays=1&amount=500&Remarks=test"
		 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
		 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Domain="+domaintext+"");
			
		//System.out.println(userresponse);
			  array = gdata.parseFromJSONResponse(userresponse);
			 j=0;
			  ClaimId=array.get(j+7);
			  //fromdate=array.get(j+5);
			  travelexpenseid=array.get(j+10);
			
			 submitclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/Submit/SubmitClaim?ClaimID="+ClaimId+"&Domain="+domaintext+"");
			 
			  managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
				
				
			  arraymanager = gdata.parseFromJSONResponse(managerresponse);
			 
			 System.out.println(arraymanager);
			  k=0;

			
			 managerdata=arraymanager.get(k+2);
//			 System.out.println(BaseUrl+"/api/AutoApprovalPolicyBandWise/UpdateAutoRemarksClaim?"
//		    			+ "claim_id="+ClaimId+"&recc_Level=0&reccID="+managerdata+"&remarks=test&action=1&amount=test&Domain="+domaintext+"");
    	String updateautocode= gdata1.getContenxtWeb(BaseUrl+"/api/AutoApprovalPolicyBandWise/UpdateAutoRemarksClaim?"
    			+ "claim_id="+ClaimId+"&recc_Level=0&reccID="+managerdata+"&remarks=test&action=1&amount=300&Domain="+domaintext+"");
		 assertTrue(updateautocode.equalsIgnoreCase("200")||updateautocode.equalsIgnoreCase("201"));
		 break;
		 
		 
    case "AutoApprovalPolicy/CheckDuplicateAutoApproverPolicy" : //duplicate auto approval policy
    	
    	
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 break;
		 
    case "ActivityClaim/InsertActivityClaim" :
    	
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 break;
		 
    case "ActivityClaim/GetEstimatedActivityById" : //get estimated activity by activity id

    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 break;
		 
		 
    case "ActivityClaim/GetDashboardEstimatedActivities" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    case "ActivityClaim/UpdateEstimatedActivity" :   //update estimated activity

    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "ActivityClaim/DeleteActivity" :   //delete activity


    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "ActivityClaim/GetEstimatedSettledActivities" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "ActivityProcessing/ActivityStatus" :
    	
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    case "ActivitySubmit/SubmitActivity"  :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    case "ActivityProcessing/ApproveDissapproveActivity" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "Actual/InsertActualClaim?intActivityID" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    case "Actual/UpdateActualActivity" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    case "Actual/GetActualActivityById" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "LoadActivityMasterData/GetActivityFinalTotal"  :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "LeavePolicy/get" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "ApplyLeave/Get" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "LeaveBalance/GetEmployeeBalance" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "LeaveBalance/GetEmployeeBalanceLeave" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
		 
    case "ApplyLeave/InsertLeave" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "LeavePolicy/Post" :
    	postapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "LeavePolicy/BalanceLaveDetails" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "ApplyLeave/UpdateLeave" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 

    	break;
    	
    case "LeavePolicy/EmpCarryFBalanceLaveDetails?" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
		
    case "GetEmpLeaveData/GetLeaveDetailsByLeaveID" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "LeaveBalance/GetCheckAppliedLeave" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "GetEmpLeaveData/DeleteLeave" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
		 
    case "LeaveProcessing/SubmitLeave" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "GetEmpLeaveData/GetEmpAppliedLeaves" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "LeaveProcessing/GetApproverLeaves" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "LeaveProcessing/ApproveDisapproveLeave" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "LeaveProcessing/ReopenLeave" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "LeaveStatus/LeaveStatus" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "LeavePolicy/CheckDuplicateLeavePolicy" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "Holiday/GetHolidayList" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "Holiday/GetCountHolidaybyEMPID" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "Holiday/GetHolidayByEmpID" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
   
    case "FoodClaim/GetFoodType1" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "FoodPolicy/GetBandWisePolicy1" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "RedChillies/GetShifts" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/GetFoodType" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/GetEmpPunchingDetails" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/getCoempClaimDate" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    case "RedChillies/InsertArtistClaim" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;   
    	
    case "RedChillies/getClaimById" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    
    	
    case "RedChillies/GetFoodClaimStatusDetails" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    	
    case "RedChillies/deleteClaimById" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    case "RedChillies/getClaimStatus" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/GetShiftById" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    case "RedChillies/GetAllClaimStatus" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    case "RedChillies/GetAllClaimStatusConditionWise" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/GetFoodWiseClaimStatus" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/GetAllClaimRejectedStatus" : 
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/GetEmpPendingClaimStatus" :
    	
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/GetClaimCoditionWise" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/UpdateArtistClaim" :  
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/DisapproveClaim" :
    ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
	break;
	
	
    case "RedChillies/ReopenClaim" :  
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/ApproveClaim" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "RedChillies/GetCOEmployeeByClaim" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "TravelClaim/AllowOvertimeToTravelClaim" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "FieldMaster/GetFieldMaster" :  
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "TravelClaim/InsertUpdateSupportTarvelClaim" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "TravelClaim/GetSupportTravelClaimStatusDetails" : 
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "TravelClaim/GetSupportTravelClaimPendingDetails" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "TravelClaim/GetTravelDetailsByID" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "TravelClaim/DeleteTravelClaimDetails" : 
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "TravelClaim/DeleteTravelClaimDocuments" : 
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "DeleteExpenses/DeleteExpense" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "AdvanceRequest/Get" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "AdvanceRequest/InsertAdvance" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "AdvanceRequest/UpdateAdvance" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "GetEmpAdvanceData/GetEmpAppliedAdvance" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "GetEmpAdvanceData/GetEmpAppliedAdvanceByStatus" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "GetEmpAdvanceData/GetLeaveDetailsByAdvanceID" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "GetEmpAdvanceData/DeleteAdvance" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "AdvanceProcessing/SubmitAdvance" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "AdvanceProcessing/GetApproverAdvance" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "AdvanceProcessing/ApproveDisapproveAdvance" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    	
    case "AdvanceProcessing/ReopenAdvance" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "AdvanceProcessing/AdvanceDetailsbyID" :
    	ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "AdvanceSettlements/Post" :
    	postapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    case "AdvanceDocument/Post" :
    	postapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "State/GetStateList" :
    	postapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    	break;
    	
    case "Holiday/Post" :   //post holidays
		 
    	postapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 
		 break;
		 
    case "Dashboard/GetDashboardClaimTotalExceedAmt" :
	
    	postapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 
		 break;
    case "Dashboard/GetMonths" :
    	
    	postapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 
		 break;
		 
		 

		 //New drag & drop ui
     case "DragNDrop/GetInsertUpdateTravelClaim_DD" :
    	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
		 
		 break;
		 
     case "DragNDrop/UpdateTravelClaim_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 		 
 		 break;
     case "DragNDrop/GetEmpAppliedExpenseDataTravel_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 		 
 		 break;
     case "DragNDrop/GetInsertLocalClaim_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 		 
 		 break;
     case "DragNDrop/UpdateLocalClaim_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 		 
 		 break;
     case "DragNDrop/GetInsertMobileClaim_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 		 
 		 break;
     case "DragNDrop/UpdateMobileClaim_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 		 
 		 break;
     case "DragNDrop/GetEmpAppliedExpenseDataMobile_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 		 
 		 break;
     case "DragNDrop/GetInsertOtherClaim_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 		 
 		 break;
     case "DragNDrop/UpdateOtherClaim_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 		 
 		 break;
     case "DragNDrop/GetEmpAppliedExpenseDataOther_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
 		 
 		 break;
     case "DragNDrop/GetInsertLandLineClaim_DD" :
      	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
  		 
  		 break;
     case "DragNDrop/UpdateLandLineClaim_DD" :
      	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
  		 
  		 break;
     case "DragNDrop/GetEmpAppliedExpenseDataLandLine_DD" :
      	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
  		 
  		 break;
     case "DragNDrop/InsertFoodClaim_DD" :
      	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
  		 
  		 break;
  		 
  		 
     case "DragNDrop/UpdateFoodClaim_DD" :
       	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
   		 
   		 break;
     case "DragNDrop/GetEmpAppliedExpenseDataFood_DD" :
       	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
   		 
   		 break;
     case "DragNDrop/InsertAccomodationClaim_DD" :
       	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
   		 
   		 break;
     case "DragNDrop/UpdateAccomodationClaim_DD" :
        	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    		 
    		 break;
     case "DragNDrop/GetEmpAppliedExpenseDataAccomodation_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    		 
    		 break;
     case "DragNDrop/CalculateDistanceAmount_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    		 
    		 break;
     case "DragNDrop/usp_CalculateBalanceAmount_DD" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    		 
    		 break;
     case "DragNDrop/usp_CalculateBalanceExceedOnAddClaim" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    		 
    		 break;
     case "DragNDrop/CalculateAndUpdateExceedAmountPerDayMont" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    		 
    		 break;
     case "DragNDrop/GetCompanyList" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    		 
    		 break;
     case "ValidateHotelExpense" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    		 
    		 break;
     case "GetEmployeeDetails" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    		 
    		 break;
     case "DragNDrop" :
     	
    	 ecapi.apicalls(functiontext,username,password,managerusername,managerpassword,policytype,domaintext); 
    		 
    		 break;
    		 
  
     
    	
    	
    	
		}
		
	}
	
	
	
	
	
		
		
		
		
		
		
	
			
	
	
	

}
