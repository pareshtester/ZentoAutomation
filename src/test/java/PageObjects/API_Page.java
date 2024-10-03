package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import TestData.GetApiData;
import TestData.GetData;
import Browsers.Urls;

public class API_Page extends Urls {
	
	
WebDriver driver;
	
String Logincode="";
String empdata="";
String 	ClaimId="";
String travelexpenseid="";
String travelinsertresponse="";
String managerdata="";
int k=0;
Calendar current = Calendar.getInstance();

String travelpolicybindcode="";
	
	
	public void steps2(String functiontext,String username,String password,String managerusername,String managerpassword,String policytype)
	{
		GetApiData gdata1 = new  GetApiData();
		GetData gdata = new  GetData();
		GetData citydata = new  GetData();
		
		
		String emailid="";
		String foodid="";
		switch(functiontext){
		
		
		case "login/GetLogin" : 
			                    
			String Logincode = gdata1.getContenxtWeb(BaseUrl+"api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			System.out.println("Response code is "+Logincode);
			assertTrue(Logincode.equalsIgnoreCase("200")||Logincode.equalsIgnoreCase("201"));
			 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			 ArrayList<String> array1 = gdata.parseFromJSONResponse(userresponse);
			 
			 System.out.println(array1);
			 int i=0;
			 String userData=array1.get(i);
			 String passData=array1.get(i+1);
			 empdata=array1.get(i+2);
			 String bandid=array1.get(i+3);
			  emailid=array1.get(i+4);		 
			 String message=array1.get(i+5);
			 break;
			 
		
		case "login/GetForgotPassword" :
			
			  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			  array1 = gdata.parseFromJSONResponse(userresponse);
			  i=0;
              userData=array1.get(i);
			  passData=array1.get(i+1);
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  emailid=array1.get(i+4);		 
			  message=array1.get(i+5);
			 String forgotpasswordcode= gdata1.getContenxtWeb(BaseUrl+"api/login/GetForgotPassword?vcEmail="+emailid+"&status=yes");
			 assertTrue(forgotpasswordcode.equalsIgnoreCase("200")||forgotpasswordcode.equalsIgnoreCase("201"));
			 break;
			 
		case "login/GetChangePassword" :
			
			  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			  array1 = gdata.parseFromJSONResponse(userresponse);
			  i=0;
			  userData=array1.get(i);
			  passData=array1.get(i+1);
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  emailid=array1.get(i+4);		 
			  message=array1.get(i+5);
			 String changepasswordcode= gdata1.getContenxtWeb(BaseUrl+"api/login/GetChangePassword?Mode=changepassword&UName="+userData+"&PWD="+passData+"&NewPWD=Zento123");
			 assertTrue(changepasswordcode.equalsIgnoreCase("200")||changepasswordcode.equalsIgnoreCase("201"));
			 break;
			 
		case "ProfileDetails/GetEmployeeProfileDetails"	:
			
			  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			  array1 = gdata.parseFromJSONResponse(userresponse);
			  i=0;
			  userData=array1.get(i);
			  passData=array1.get(i+1);
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  emailid=array1.get(i+4);		 
			  message=array1.get(i+5);
			System.out.println(BaseUrl+"api/ProfileDetails/GetEmployeeProfileDetails?EmpID="+empdata+"");
			 String profilecode= gdata1.getContenxtWeb(BaseUrl+"api/ProfileDetails/GetEmployeeProfileDetails?EmpID="+empdata+"");
			 assertTrue(profilecode.equalsIgnoreCase("200")||profilecode.equalsIgnoreCase("201"));
			 break;
			 
		case "ProfileDetails/UpdateEmployeeProfile"	:
			
			  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			  array1 = gdata.parseFromJSONResponse(userresponse);
			  i=0;
			  userData=array1.get(i);
			  passData=array1.get(i+1);
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  emailid=array1.get(i+4);		 
			  message=array1.get(i+5);
			 String editprofilecode= gdata1.getContenxtWeb(BaseUrl+"api/ProfileDetails/UpdateEmployeeProfile?EmpID="+empdata+"&EmpFName=paresh&EmpMName=M"
			 		+ "&EmpLName=Patil&BankName=test&AccountNo=0&Email=paresh.patil@gdata.in&dtJoining=01/01/2015&Mobile=9898989898");
			 assertTrue(editprofilecode.equalsIgnoreCase("200")||editprofilecode.equalsIgnoreCase("201"));
			 
		case "Master/GetBandList" :
			
			 //Band master
			System.out.println(BaseUrl+"api/Master/GetBandList");
			 String bandmastercode= gdata1.getContenxtWeb(BaseUrl+"api/Master/GetBandList");
			 assertTrue(bandmastercode.equalsIgnoreCase("200")||bandmastercode.equalsIgnoreCase("201"));
			 break;
			 
		case "travelclaim/GetCityDataList" :
			
			//City master 
			 String citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
			 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
			 break;
			 
        case "travelclaim/GetMasterDataList" :
			
        	 //WBS master   
   		     String WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
   		     assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 break;	 
			 
        case "otherClaim" :
			
        	//Nature of expense master  
        	System.out.println(BaseUrl+"/api/otherClaim/Get");
   		 String NOEmastercaode= gdata1.getContenxtWeb(BaseUrl+"/api/otherClaim/Get");
   		 assertTrue(NOEmastercaode.equalsIgnoreCase("200")||NOEmastercaode.equalsIgnoreCase("201"));
			 break;	
			 
        case "TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel" :	 
			 
        	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			  array1 = gdata.parseFromJSONResponse(userresponse);
			  i=0;
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			//Travel modes for travel claims  
			 String travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=TravelClaim&band="+bandid+"");
			 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
			 break;
			 
			 
        case "Master/GetAllClaimType" :	 
			 
        				// Claim type masters    http://115.249.204.243:84/api/Master/GetAllClaimType?status=yes
				 String claimtypemastercaode= gdata1.getContenxtWeb(BaseUrl+"/api/Master/GetAllClaimType?status=yes");
				 assertTrue(claimtypemastercaode.equalsIgnoreCase("200")||claimtypemastercaode.equalsIgnoreCase("201"));
			 break;
			 
        case "PolicyCheck/GetBandWisePolicy" :	 
			 
        	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 System.out.println(array1);
			  i=0;
			  userData=array1.get(i);
			  passData=array1.get(i+1);
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  travelpolicybindcode= gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Travel&Band="+bandid+"");
				 assertTrue(travelpolicybindcode.equalsIgnoreCase("200")||travelpolicybindcode.equalsIgnoreCase("201"));
			 break;
			 
			 
        case "TravelClaim/GetInsertUpdateTravelClaim" :	
        	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			  array1 = gdata.parseFromJSONResponse(userresponse);
			  i=0;
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
        	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
   		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
   		 

   			
   			 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
   			
   		
   			 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
   			 int cityno=0;
   			
   			 String citynamefromdata=cityarray1.get(cityno+1);
   			 String citynametodata=cityarray1.get(cityno+2);
        	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
   		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
   			String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
   			ArrayList<String> wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
   			int wbscount=0;
   			String wbsdata=wbsarray.get(wbscount+4);
   			
        	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
     		 		+ "ClaimType=TravelClaim&band="+bandid+"");
        	  System.out.println(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
       		 		+ "ClaimType=TravelClaim&band="+bandid+"");
     		 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
     		 
     			String travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

     			 ArrayList<String> travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
     			int travelmodecount=0;
     			String travelmodedata=travelmodearray.get(travelmodecount+1);
        	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
 			LocalDate localDate = LocalDate.now();
 				  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
 				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
 				 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
 				 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
 				
 			
 				 ArrayList<String> array = gdata.parseFromJSONResponse(travelinsertresponse);
 				 int j=0;
 				 System.out.println(array);
 				  ClaimId=array.get(j+7);
 				  travelexpenseid=array.get(j+8);
 				
 				
 				 break;
 			
 case "TravelClaimView/GetClaimByID" :	
        	
        	
        	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			
    		
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			 
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			 
        	
        	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
   		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
   		 

   			
   			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
   			
   		
   			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
   			  cityno=0;
   			
   			  citynamefromdata=cityarray1.get(cityno+1);
   			  citynametodata=cityarray1.get(cityno+2);
   			
        	
        	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
   		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
   		 
   			
   			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
   			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
   			 wbscount=0;
   			 wbsdata=wbsarray.get(wbscount+4);
   		
        	
        	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
     		 		+ "ClaimType=TravelClaim&band="+bandid+"");
     		 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
     		 
     		
     			 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

     			  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
     			 travelmodecount=0;
     			 travelmodedata=travelmodearray.get(travelmodecount+1);
        	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
 			 localDate = LocalDate.now();
 		
 			
 			
 				  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
 				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
 				 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
 				 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
 				
 			
 				  array = gdata.parseFromJSONResponse(travelinsertresponse);
 				  j=0;
 				 System.out.println(array);
 				  ClaimId=array.get(j+7);
 				  travelexpenseid=array.get(j+8);
 				 
 				
 				 
                 //****View Travel expense
				 
				 System.out.println("/api/TravelClaimView/GetClaimByID?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"");
				 String viewtravelexpensecode= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaimView/GetClaimByID?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"");
				 assertTrue(viewtravelexpensecode.equalsIgnoreCase("200")||viewtravelexpensecode.equalsIgnoreCase("201")); 
 				 
 				 break;
 				 
 				 
 case "GetEmpAppliedExpenseDataTravel" :	
 	
 	
 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		
		  i=0;

		
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		 
 	
 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
	 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
	 

		
		  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
		
	
		  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
		  cityno=0;
		
		  citynamefromdata=cityarray1.get(cityno+1);
		  citynametodata=cityarray1.get(cityno+2);
		
 	
 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
	 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
	 
		
		 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		 wbscount=0;
		 wbsdata=wbsarray.get(wbscount+4);
	
 	
 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
		 		+ "ClaimType=TravelClaim&band="+bandid+"");
		 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
		 
		
			 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

			  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
			 travelmodecount=0;
			 travelmodedata=travelmodearray.get(travelmodecount+1);
 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		 localDate = LocalDate.now();
	
		
		
			  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
			 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
			 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
			
		//System.out.println(userresponse);
			  array = gdata.parseFromJSONResponse(travelinsertresponse);
			  j=0;
		
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+8);
			  
			
			 
          //****View Travel expense   /api/TravelClaimView/GetEmpAppliedExpenseDataTravel?ClaimId=408&ExpenseId=356
			 
			 System.out.println("/api/TravelClaimView/GetEmpAppliedExpenseDataTravel?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"");
			  viewtravelexpensecode= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaimView/GetClaimByID?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"");
			 assertTrue(viewtravelexpensecode.equalsIgnoreCase("200")||viewtravelexpensecode.equalsIgnoreCase("201"));
			 
			 break;
 				 
 case "TravelClaimView/UpdateTravelClaim" :	
 	
 	
 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
	
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
 	
 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
	 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
	 

		
		  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
		
	
		  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
		  cityno=0;
		
		  citynamefromdata=cityarray1.get(cityno+1);
		  citynametodata=cityarray1.get(cityno+2);
		
 	
 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
	 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
	 
		
		 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		 wbscount=0;
		 wbsdata=wbsarray.get(wbscount+4);
	
 	
 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
		 		+ "ClaimType=TravelClaim&band="+bandid+"");
		 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
		 
		
			 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

			  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
			 travelmodecount=0;
			 travelmodedata=travelmodearray.get(travelmodecount+1);
 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		 localDate = LocalDate.now();
	
		
		
			  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
			 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
			 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
			
		//System.out.println(userresponse);
			  array = gdata.parseFromJSONResponse(travelinsertresponse);
			  j=0;
		
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+8);
			  //fromdate=array.get(j+5);
		
			 
			 
			////***************Update travel claim    /api/TravelClaimView/UpdateTravelClaim?ClaimId=1&TravelClaimId=1&TravelDateFrom=2016-12-01 00:00:00.000&amount=6000.00&TravelDateTo=2016-12-01 00:00:00.000&CityFrom=1&CityTo=2&Remarks=edit&ModeOfTravel=26&WBS=26&TaxAmt=&GSTIncluded=true
		
           String updatetravelclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaimView/UpdateTravelClaim?ClaimId="+ClaimId+"&TravelClaimId="+travelexpenseid+""
						+ "&TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&amount=6000.00&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000"
								+ "&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
						+ "&Remarks=edit&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
			 assertTrue(updatetravelclaimcode.equalsIgnoreCase("200")||updatetravelclaimcode.equalsIgnoreCase("201"));
			 break;
			 
			 
 case "Submit/SubmitClaim" :	
	 	
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			  
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			 
	 	
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
		
	 	
	 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=TravelClaim&band="+bandid+"");
			 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
			 
			
				 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

				  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
				 travelmodecount=0;
				 travelmodedata=travelmodearray.get(travelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
		
			
			
				  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
				 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
				 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
			//System.out.println(userresponse);
				  array = gdata.parseFromJSONResponse(travelinsertresponse);
				  j=0;
				
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+8);
			
				 
				 
                       //******Submit claim     http://192.168.1.234/api/Submit/SubmitClaim?ClaimID=252    *********************

				 
				 String submitclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/Submit/SubmitClaim?ClaimID="+ClaimId+"");
				 assertTrue(submitclaimcode.equalsIgnoreCase("200")||submitclaimcode.equalsIgnoreCase("201"));
				 break;
				 
				 
 case "ClaimProcessing/ApproveDissapproveClaims" :	
	 	
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			 System.out.println(array1);
			  i=0;

		
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  
	 	
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
			
	 	
	 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=TravelClaim&band="+bandid+"");
			 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
			 
			
				 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

				  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
				 travelmodecount=0;
				 travelmodedata=travelmodearray.get(travelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
		
			
			
				  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
				 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
				 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
			//System.out.println(userresponse);
				  array = gdata.parseFromJSONResponse(travelinsertresponse);
				  j=0;
				
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+8);
				  //fromdate=array.get(j+5);
				
				 
				 
                    //******Submit claim     http://192.168.1.234/api/Submit/SubmitClaim?ClaimID=252    *********************

				 
				  submitclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/Submit/SubmitClaim?ClaimID="+ClaimId+"");
				 assertTrue(submitclaimcode.equalsIgnoreCase("200")||submitclaimcode.equalsIgnoreCase("201"));
				 
				 
    //*****Approve travel claim   http://192.168.1.234/api/ClaimProcessing/ApproveDissapproveClaims?claim_id=400&reccID=409&remarks=604&action=1&status=yes

				 
				 String managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"");
					
					
				 ArrayList<String> arraymanager = gdata.parseFromJSONResponse(managerresponse);
				 
				 System.out.println(arraymanager);
				  k=0;

				
				 managerdata=arraymanager.get(k+2);
			
				 String approvetravelclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/ClaimProcessing/ApproveDissapproveClaims?claim_id="+ClaimId+"&reccID="+managerdata+"&remarks=604&action=1&status=yes");
				 assertTrue(approvetravelclaimcode.equalsIgnoreCase("200")||approvetravelclaimcode.equalsIgnoreCase("201"));
				 break;
				 
				 
 case "ReOpen/ReopenClaim" :	
	 	
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  
	 	
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
			
	 	
	 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=TravelClaim&band="+bandid+"");
			 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
			 
			
				 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

				  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
				 travelmodecount=0;
				 travelmodedata=travelmodearray.get(travelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	
			
			
				  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
				 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
				 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
			//System.out.println(userresponse);
				  array = gdata.parseFromJSONResponse(travelinsertresponse);
				  j=0;
				
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+8);
				  //fromdate=array.get(j+5);
				
				 
				 
                 //******Submit claim     http://192.168.1.234/api/Submit/SubmitClaim?ClaimID=252    *********************

				 
				  submitclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/Submit/SubmitClaim?ClaimID="+ClaimId+"");
				 assertTrue(submitclaimcode.equalsIgnoreCase("200")||submitclaimcode.equalsIgnoreCase("201"));
				 
				 
				 //****************Reject claim****************************************
				  managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"");
					
					
				 arraymanager = gdata.parseFromJSONResponse(managerresponse);
				 
				 System.out.println(arraymanager);
				  k=0;

				
				 managerdata=arraymanager.get(k+2);
				
				   String rejecttravelclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/ClaimProcessing/ApproveDissapproveClaims?claim_id="+ClaimId+"&reccID="+managerdata+"&remarks=604&action=0&status=yes");
					 assertTrue(rejecttravelclaimcode.equalsIgnoreCase("200")||rejecttravelclaimcode.equalsIgnoreCase("201"));
				 

					 String reopenclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/ReOpen/ReopenClaim?claim_id="+ClaimId+"&amount=12");
					 assertTrue(reopenclaimcode.equalsIgnoreCase("200")||reopenclaimcode.equalsIgnoreCase("201"));	
					 
					 break;
					 
 case "LocalClaim/GetInsertLocalClaim" :	
 	
 	
 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		
		  i=0;

		
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  
 
 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
	 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
	 

		
		  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
		
	
		  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
		  cityno=0;
		
		  citynamefromdata=cityarray1.get(cityno+1);
		  citynametodata=cityarray1.get(cityno+2);
		
 	
 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
	 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
	 
		
		 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		 wbscount=0;
		 wbsdata=wbsarray.get(wbscount+4);
		
 	
		String localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
		 		+ "ClaimType=LocalClaim&band="+bandid+"");
		 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
		 
		 
		 String localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

		 ArrayList<String> localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
		int localtravelmodecount=0;
		String localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		 localDate = LocalDate.now();
		
		
		
		 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
			 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
			 				+ "&travelFrom=chinchpokli"
			 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
			
		
		 ArrayList<String> localarray = gdata.parseFromJSONarrayResponse(userresponse);
		  
		
		  j=0;
		  ClaimId=localarray.get(j);
		  travelexpenseid=localarray.get(j+1);
		  //fromdate=array.get(j+5);
		
	     break;	
	     
	     
 case "LocalClaimView/GetClaimByID" :	
	 	
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			 
			  i=0;

			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

			 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
		
			
			
			 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&travelFrom=chinchpokli"
				 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
		
			 localarray = gdata.parseFromJSONarrayResponse(userresponse);
			  
			
			  j=0;
			  ClaimId=localarray.get(j);
			  travelexpenseid=localarray.get(j+1);
			  //fromdate=array.get(j+5);
		
			 
			//****View Local claim
			 
			 String viewlocalclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LocalClaimView/GetClaimByID?ClaimId="+ClaimId+"");
		 assertTrue(viewlocalclaimcode.equalsIgnoreCase("200")||viewlocalclaimcode.equalsIgnoreCase("201"));
		     break;	 
					 
 case "GetEmpAppliedExpenseDataLocal" :	
	 	
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
		
			  i=0;

			 
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			 
	 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

			 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			
			
			 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&travelFrom=chinchpokli"
				 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
			
			 localarray = gdata.parseFromJSONarrayResponse(userresponse);
			  
			
			  j=0;
			  ClaimId=localarray.get(j);
			  travelexpenseid=localarray.get(j+1);
			  //fromdate=array.get(j+5);
			
			 
			//****View Local claim  /api/LocalClaimView/GetEmpAppliedExpenseDataLocal?ClaimId=252&ExpenseId=1
			 
			  viewlocalclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LocalClaimView/GetEmpAppliedExpenseDataLocal?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"");
		 assertTrue(viewlocalclaimcode.equalsIgnoreCase("200")||viewlocalclaimcode.equalsIgnoreCase("201"));
		     break;	 
		     
		     
 case "LocalClaimView/UpdateLocalClaim" :	
	 	
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			  
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			 
	 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

			 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			
			
			 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/LocalClaim/GetInsertLocalClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&travelFrom=chinchpokli"
				 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
		
			 localarray = gdata.parseFromJSONarrayResponse(userresponse);
			  
			 System.out.println(localarray);
			  j=0;
			  ClaimId=localarray.get(j);
			  travelexpenseid=localarray.get(j+1);
			  //fromdate=array.get(j+5);
			
			 
			//****View Local claim  /api/LocalClaimView/UpdateLocalClaim?ClaimId=10811&LocalConveyanceClaimId=6392
			// &travelDateFrom=3/8/2018&amount=2000&cityFrom=5&cityTo=5&Remarks=test&modeOfTravel=624&travelFrom=test&travelTo=test
			// &travelDateTo=2016-12-01%2000:00:00.000&WBS=1&TaxAmt=0&GSTIncluded=true&Km=6
			 
			 
         updatetravelclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LocalClaimView/UpdateLocalClaim?ClaimId="+ClaimId+"&LocalConveyanceClaimId="+travelexpenseid+""
         		+ "&travelDateFrom="+dtf.format(localDate)+"&amount=2000&cityFrom="+citynamefromdata+"&cityTo="+citynametodata+"&Remarks=test&modeOfTravel="+localtravelmodedata+"&travelFrom=test&travelTo=test"
         		+ "&travelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&TaxAmt=0&GSTIncluded=true&Km=6&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
         
         
			 assertTrue(updatetravelclaimcode.equalsIgnoreCase("200")||updatetravelclaimcode.equalsIgnoreCase("201"));
		     break;	
		     
		     
		     
 case "LandLineClaim/GetInsertLandLineClaim" :	
	 	
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  
	 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
		
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

			  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			System.out.println(dtf.format(localDate));
			
			
			 String landlineuserresponse = gdata.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
		
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				 System.out.println(array);
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
		     break;	
		     
 case "LandlineView/GetClaimByID" :	
	 	
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			 
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			 
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

			  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			
			
			  landlineuserresponse = gdata.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
			
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				;
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
				 
				 String viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LandlineView/GetClaimByID?ClaimId="+ClaimId+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
		     break;	
		     
 case "LandlineView/GetEmpAppliedExpenseDataLandLine" :	
	 	
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			 
			
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

			  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			
			
			  landlineuserresponse = gdata.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
		
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
				 
				  viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LandlineView/GetEmpAppliedExpenseDataLandLine?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
		     break;	
					
 case "LandlineView/UpdateLandLineClaim" :	
	 	
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			 
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
			
	 	
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid);

			  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
		
			
			
			  landlineuserresponse = gdata.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetInsertLandLineClaim?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
			
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
				 
				 String updatelandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LandlineView/UpdateLandLineClaim?ClaimId="+ClaimId+"&MobileClaimId="+travelexpenseid+"&dateFrom="+dtf.format(localDate)+""
					 		+ "&amount=200&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&TaxAmt=300"
					 		+ "&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
					 assertTrue(updatelandlineclaimcode.equalsIgnoreCase("200")||updatelandlineclaimcode.equalsIgnoreCase("201")); 	 
		     break;	
		     
        case "Mobile/GetInsertMobileClaim":
        	
        	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			 
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			 
        	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
    		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
    		 
    			
    			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
    			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
    			 wbscount=0;
    			 wbsdata=wbsarray.get(wbscount+4);
    			System.out.println("API wbs mode name is "+wbsdata);
    			  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    				 localDate = LocalDate.now();
    				
        	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
			 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
			
		//System.out.println(userresponse);
			 array = gdata.parseFromJSONResponse(userresponse);
			  j=0;
			
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+9);
			  //fromdate=array.get(j+5);
			 
			  break;
			  
			  
 case "MobileView/GetClaimByID":
        	
        	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			  
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  
        	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
    		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
    		 
    			
    			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
    			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
    			 wbscount=0;
    			 wbsdata=wbsarray.get(wbscount+4);
    			
    			  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    				 localDate = LocalDate.now();
    				
        	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
			 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
			
		//System.out.println(userresponse);
			 array = gdata.parseFromJSONResponse(userresponse);
			  j=0;
			 
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+9);
			  //fromdate=array.get(j+5);
			
			  
			   viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/MobileView/GetClaimByID?ClaimId="+ClaimId+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
			  
			  break;
			  
 case "MobileView/GetEmpAppliedExpenseDataMobile":
 	
 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 
		  i=0;

		 
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		
 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
		
			  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				
 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
		 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
		
	
		 array = gdata.parseFromJSONResponse(userresponse);
		  j=0;
		
		  ClaimId=array.get(j+7);
		  travelexpenseid=array.get(j+9);
		  //fromdate=array.get(j+5);
		
		  
		   viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/MobileView/GetEmpAppliedExpenseDataMobile?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"");
			 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
		  
		  break;
		  
 case "MobileView/UpdateMobileClaim":
	 	
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			  
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+4);
				System.out.println("API wbs mode name is "+wbsdata);
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					
	 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
			 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
			
		//System.out.println(userresponse);
			 array = gdata.parseFromJSONResponse(userresponse);
			  j=0;
			  System.out.println(array);
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+9);
			  //fromdate=array.get(j+5);
			 System.out.println("New claim id is "+ClaimId);
			  System.out.println("New claim id is "+travelexpenseid); 
			  
			  String updatemobileclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/MobileView/UpdateMobileClaim?ClaimId="+ClaimId+""
				 		+ "&MobileClaimId="+travelexpenseid+"&dateFrom="+dtf.format(localDate)+"&amount=123&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&TaxAmt=200"
				 		+ "&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
					 assertTrue(updatemobileclaimcode.equalsIgnoreCase("200")||updatemobileclaimcode.equalsIgnoreCase("201")); 
			  
			  break;
			  
			  
          case "AccomodationClaim/InsertAccomodationClaim":
        	  
        	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
  			
  			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			 
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  
			  
			  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
				 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
				 
					
					 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
					 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
					 wbscount=0;
					 wbsdata=wbsarray.get(wbscount+4);
					System.out.println("API wbs mode name is "+wbsdata);
					 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
					

					  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
					
				
					  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
					  cityno=0;
					
					  citynamefromdata=cityarray1.get(cityno+1);
					  citynametodata=cityarray1.get(cityno+2);
					 
        	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
				 		+ "&NoOfDays=1&amount=500&Remarks=test"
				 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
				 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
			//System.out.println(userresponse);
				  array = gdata.parseFromJSONResponse(userresponse);
				 j=0;
				 System.out.println(array);
				  ClaimId=array.get(j+7);
				  //fromdate=array.get(j+5);
				  travelexpenseid=array.get(j+10);
				
				 break;
				 
  case "AccomodationClaimView/GetAccomodationClaim":
        	  
        	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
  			
  			
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			
			  i=0;

			  ;
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);
			  
			  
			  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
				 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
				 
					
					 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
					 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
					 wbscount=0;
					 wbsdata=wbsarray.get(wbscount+4);
				
					 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					
					

					  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
					
				
					  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
					  cityno=0;
					
					  citynamefromdata=cityarray1.get(cityno+1);
					  citynametodata=cityarray1.get(cityno+2);
					 
        	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
				 		+ "&NoOfDays=1&amount=500&Remarks=test"
				 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
				 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
				
			//System.out.println(userresponse);
				  array = gdata.parseFromJSONResponse(userresponse);
				 j=0;
				 System.out.println(array);
				  ClaimId=array.get(j+7);
				  //fromdate=array.get(j+5);
				  travelexpenseid=array.get(j+10);
				
				 viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/AccomodationClaimView/GetAccomodationClaims?ClaimId="+ClaimId+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
				 
				 break;
				 
				 
  case "AccomodationClaim/GetEmpAppliedExpenseDataAccomodation":
	  
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 System.out.println(array1);
	  i=0;

	  
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  
	  
	  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
			System.out.println("API wbs mode name is "+wbsdata);
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			System.out.println(dtf.format(localDate));
			

			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
				 		+ "&NoOfDays=1&amount=500&Remarks=test"
				 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
				 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
		
	//System.out.println(userresponse);
		  array = gdata.parseFromJSONResponse(userresponse);
		 j=0;
		 System.out.println(array);
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		  travelexpenseid=array.get(j+10);
		 
		 
		 
		 viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/GetEmpAppliedExpenseDataAccomodation?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"");
		 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
	  
	  break;
	  
	  
	  
 case "AccomodationClaimView/UpdateAccomodationClaim":
	  
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 
	  i=0;

	 
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  
	  
	  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
		
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			

			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/AccomodationClaim/InsertAccomodationClaim?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
				 		+ "&NoOfDays=1&amount=500&Remarks=test"
				 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
				 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
		
	//System.out.println(userresponse);
		  array = gdata.parseFromJSONResponse(userresponse);
		 j=0;
		 System.out.println(array);
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		  travelexpenseid=array.get(j+10);
		
		
		 String updatehotelclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/AccomodationClaimView/UpdateAccomodationClaim?ClaimId="+ClaimId+""
			 		+ "&AccomodationClaimId="+travelexpenseid+"&TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+"&NoOfDays=1&Amount=500.00&Remarks=na&WBS="+wbsdata+"&TaxAmt=50.00"
			 		+ "&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
					 assertTrue(updatehotelclaimcode.equalsIgnoreCase("200")||updatehotelclaimcode.equalsIgnoreCase("201")); 
	  
	  break;
	  
	  
 case "FoodClaim/GetFoodType":    //Get food types
	 
	 
	 String foodtypecode= gdata1.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType");
	 assertTrue(foodtypecode.equalsIgnoreCase("200")||foodtypecode.equalsIgnoreCase("201"));
     break;
	 
 case "FoodClaim/InsertFoodClaim":  //insert food claim   http://192.168.1.14:84/api/FoodClaim/InsertFoodClaim?TravelDate=02/28/2018&Location=1&NoOfDays=1&amount=10000.00&Remarks=test&WBS=26&empId=672&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true&foodPlace=1

	 
	 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 System.out.println(array1);
	  i=0;

	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  emailid=array1.get(i+4);		 
	  message=array1.get(i+5);
	 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
	 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
	 wbscount=0;
	 wbsdata=wbsarray.get(wbscount+4);
	System.out.println("API wbs mode name is "+wbsdata);
	String foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType");
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
	System.out.println(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
	 		+ "&amount=10000.00&Remarks=test&WBS=26&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true&foodPlace="+foodid);
	  userresponse= gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/InsertFoodClaim?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
	 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
	  array = gdata.parseFromJSONResponse(userresponse);
	  System.out.println(array);
	  j=0;
	
	  ClaimId=array.get(j+7);
	  //fromdate=array.get(j+5);
	 System.out.println("New claim id is "+ClaimId);
	 travelexpenseid=array.get(j+12);
	
	 System.out.println("New claim id is "+travelexpenseid); 
	 break;
	 
	 
 case "FoodClaimView/GetFoodClaims":
	     
	 
	 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 System.out.println(array1);
	  i=0;

	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  emailid=array1.get(i+4);		 
	  message=array1.get(i+5);
	 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
	 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
	 wbscount=0;
	 wbsdata=wbsarray.get(wbscount+4);
	System.out.println("API wbs mode name is "+wbsdata);
	 foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType");
	 foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
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
	 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
	  array = gdata.parseFromJSONResponse(userresponse);
	  System.out.println(array);
	  j=0;
	
	  ClaimId=array.get(j+7);
	  //fromdate=array.get(j+5);
	 System.out.println("New claim id is "+ClaimId);
	 travelexpenseid=array.get(j+12);
	
	 System.out.println("New claim id is "+travelexpenseid); 
	 
	 viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/FoodClaimView/GetFoodClaims?ClaimId="+ClaimId+"");
	 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
	 break;
	 
	     
 case "FoodClaimView/GetEmpAppliedExpenseDataFood" : 
	     
	 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 System.out.println(array1);
	  i=0;

	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  emailid=array1.get(i+4);		 
	  message=array1.get(i+5);
	 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
	 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
	 wbscount=0;
	 wbsdata=wbsarray.get(wbscount+4);
	System.out.println("API wbs mode name is "+wbsdata);
	 foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType");
	 foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
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
	 				+ "&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
	  array = gdata.parseFromJSONResponse(userresponse);
	  System.out.println(array);
	  j=0;
	
	  ClaimId=array.get(j+7);
	  //fromdate=array.get(j+5);
	 System.out.println("New claim id is "+ClaimId);
	 travelexpenseid=array.get(j+12);
	
	 System.out.println("New claim id is "+travelexpenseid); 
	 
	 viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/FoodClaimView/GetEmpAppliedExpenseDataFood?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"");
	 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
	 break; 
	 
 case "FoodClaimView/UpdateFoodClaim" :
	 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 System.out.println(array1);
	  i=0;

	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  emailid=array1.get(i+4);		 
	  message=array1.get(i+5);
	 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
	 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
	 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
	 wbscount=0;
	 wbsdata=wbsarray.get(wbscount+4);
	System.out.println("API wbs mode name is "+wbsdata);
	 foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType");
	 foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
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
	 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
	  array = gdata.parseFromJSONResponse(userresponse);
	  System.out.println(array);
	  j=0;
	
	  ClaimId=array.get(j+7);
	  //fromdate=array.get(j+5);
	 System.out.println("New claim id is "+ClaimId);
	 travelexpenseid=array.get(j+12);
	
	 System.out.println("New claim id is "+travelexpenseid); 
	 ///api/FoodClaimView/UpdateFoodClaim?ClaimId=9723&FoodClaimId=1&TravelDate=2016-12-01%2000:00:00.000&Location=2&NoOfDays=3&Amount=5000.00&Remarks=test&WBS=26&TaxAmt=50.00&GSTIncluded=true&FoodPlace=1
  
	 
	 String updatefoodclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/FoodClaimView/UpdateFoodClaim?ClaimId="+ClaimId+"&FoodClaimId="+travelexpenseid+""
	 		+ "&TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location=2&NoOfDays=3&Amount=5000.00&Remarks=test&WBS="+wbsdata+"&TaxAmt=50.00&GSTIncluded=true"
	 		+ "&FoodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
	 assertTrue(updatefoodclaimcode.equalsIgnoreCase("200")||updatefoodclaimcode.equalsIgnoreCase("201"));
	 break; 
	 
 case "otherClaim/GetInsertOtherClaim":
	 String noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		 String noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get");
		

		 ArrayList<String> noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename);
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
		
		  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
		  
		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+4);
				System.out.println("API wbs mode name is "+wbsdata);
				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
		
		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
		
	        //System.out.println(userresponse);
		    array = gdata.parseFromJSONResponse(userresponse);
		    j=0;
		    System.out.println(array);
		     ClaimId=array.get(j+7);
		     travelexpenseid=array.get(j+11);
		     //fromdate=array.get(j+5);
		     System.out.println("New claim id is "+ClaimId);
		     System.out.println("New claim id is "+travelexpenseid);
             break;
             
             
             

	 
	  
 case "OtherClaimView/GetClaimByID":
	  noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get");
		

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename);
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
		
		  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
		  
		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+4);
				System.out.println("API wbs mode name is "+wbsdata);
				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
		
		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
		
	        //System.out.println(userresponse);
		    array = gdata.parseFromJSONResponse(userresponse);
		    j=0;
		    System.out.println(array);
		     ClaimId=array.get(j+7);
		     travelexpenseid=array.get(j+11);
		     //fromdate=array.get(j+5);
		     System.out.println("New claim id is "+ClaimId);
		     System.out.println("New claim id is "+travelexpenseid);
		     
		     viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/OtherClaimView/GetClaimByID?ClaimId="+ClaimId+"");
			 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
             break;
 
 case "OtherClaimView/GetEmpAppliedExpenseDataOther":
	  noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get");
		  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename);
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
		
		 
		  
		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+4);
				System.out.println("API wbs mode name is "+wbsdata);
				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
		
		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
		
	        //System.out.println(userresponse);
		    array = gdata.parseFromJSONResponse(userresponse);
		    j=0;
		    System.out.println(array);
		     ClaimId=array.get(j+7);
		     travelexpenseid=array.get(j+11);
		     //fromdate=array.get(j+5);
		     System.out.println("New claim id is "+ClaimId);
		     System.out.println("New claim id is "+travelexpenseid);
		     
		     viewlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/OtherClaimView/GetEmpAppliedExpenseDataOther?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"");
			 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
			 
			 break;
			 
			 
 case "OtherClaimView/UpdateOtherClaim":
	  noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get");
		

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename);
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
		
		  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
		  
		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+4);
				System.out.println("API wbs mode name is "+wbsdata);
				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
		
		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
		
	        //System.out.println(userresponse);
		    array = gdata.parseFromJSONResponse(userresponse);
		    j=0;
		    System.out.println(array);
		     ClaimId=array.get(j+7);
		     travelexpenseid=array.get(j+11);
		     //fromdate=array.get(j+5);
		     System.out.println("New claim id is "+ClaimId);
		     System.out.println("New claim id is "+travelexpenseid);
		     
		     String updateotherclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/OtherClaimView/UpdateOtherClaim?ClaimId=2440&OtherExpenseClaimId="+ClaimId+""
				 		+ "&dateFrom="+dtf.format(localDate)+"&amount=567&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&vcLocation=pune&TaxAmt=300&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
							 assertTrue(updateotherclaimcode.equalsIgnoreCase("200")||updateotherclaimcode.equalsIgnoreCase("201")); 
							 break;
							 
    case "dashboard/GetTotalClaim"	:	//get filter wise total claims   api/dashboard/GetTotalClaim?EmpId=604&Month=11&Year=2017&Week=0&Operation=LocalClaim
    	
    	   
    	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
    	 System.out.println(BaseUrl+"/api/dashboard/GetTotalClaim?EmpId="+empdata+"&Month="+(current.get(Calendar.MONTH))+1+"&Year="+current.get(Calendar.YEAR)+"&Week=0&Operation="+policytype+"");
    	 String totalclaimscode= gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetTotalClaim?EmpId="+empdata+"&Month="+(current.get(Calendar.MONTH))+1+"&Year="+current.get(Calendar.YEAR)+"&Week=0&Operation="+policytype+"");
		 assertTrue(totalclaimscode.equalsIgnoreCase("200")||totalclaimscode.equalsIgnoreCase("201"));
    	break;
    	
    	
    case "dashboard/GetClaim"	:	//retrieve dashboard data
 	   
  	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
  	 System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month="+(current.get(Calendar.MONTH))+1+"&Year="+current.get(Calendar.YEAR)+"&Week=0&sortBy=CLAIMID");
  	 String dashboarddatacode= gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month="+(current.get(Calendar.MONTH))+1+"&Year="+current.get(Calendar.YEAR)+"&Week=0&sortBy=CLAIMID");
		 assertTrue(dashboarddatacode.equalsIgnoreCase("200")||dashboarddatacode.equalsIgnoreCase("201"));
  	break;
    	
  	
    case "FoodPolicy/GetBandWisePolicy" :
    	  
    	 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
		  
		  
		   foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType");
			 foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
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
    	String foodpolicycode= gdata1.getContenxtWeb(BaseUrl+"/api/FoodPolicy/GetBandWisePolicy?Band="+bandid+"&foodPlace="+foodid);
		 assertTrue(foodpolicycode.equalsIgnoreCase("200")||foodpolicycode.equalsIgnoreCase("201"));
		 break;
		 
		 
    case "LevelIndicator/GetClaimApprover" :   //get data to show level indicator in app

    	
    	
    	 noename="";
 		//TestData.GetData gdata = new  TestData.GetData();
 		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get");
 		

 		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
 		
 		for( j=0;j<noearray1.size();j++)
 		{
 			
 			 noename=noearray1.get(j);
 			System.out.println("Noe name is:->>>>>>>>>"+noename);
 			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename);
 			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
 			//String noename2=noepolicyarray1.get(1);
 			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
 			if(noepolicyarray1.size()!=0)
 			{
 				j=noearray1.size();
 			}
 		}
 		
 		  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
 			
 			
 		  array1 = gdata.parseFromJSONResponse(userresponse);
 		 
 		 System.out.println(array1);
 		  i=0;

 		  userData=array1.get(i);
 		  passData=array1.get(i+1);
 		 empdata=array1.get(i+2);
 		  bandid=array1.get(i+3);
 		  emailid=array1.get(i+4);		 
 		  message=array1.get(i+5);
 		  
 		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
 			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
 			 
 				
 				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
 				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
 				 wbscount=0;
 				 wbsdata=wbsarray.get(wbscount+4);
 				System.out.println("API wbs mode name is "+wbsdata);
 				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
 				 localDate = LocalDate.now();
 				System.out.println(dtf.format(localDate));
 		
 		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
 		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
 		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
 		
 	        //System.out.println(userresponse);
 		    array = gdata.parseFromJSONResponse(userresponse);
 		    j=0;
 		    System.out.println(array);
 		     ClaimId=array.get(j+7);
 		     travelexpenseid=array.get(j+11);
 		     //fromdate=array.get(j+5);
 		     System.out.println("New claim id is "+ClaimId);
 		     System.out.println("New claim id is "+travelexpenseid);
 		     System.out.println(BaseUrl+"/api/LevelIndicator/GetClaimApprover?ClaimID="+ClaimId);
 		    String levelindicatorcode= gdata1.getContenxtWeb(BaseUrl+"/api/LevelIndicator/GetClaimApprover?ClaimID="+ClaimId);
 			 assertTrue(levelindicatorcode.equalsIgnoreCase("200")||levelindicatorcode.equalsIgnoreCase("201"));
 			 break;
 			 
 			 
    case "LocalClaim/GetBandWisePolicyDetailsLocal" :    //get local claim policy    Pending

    	 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
			
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
 		   System.out.println(BaseUrl+"api/LocalClaim/GetBandWisePolicyDetailsLocal?band="+bandid);  
 		  String lpolicycode= gdata1.getContenxtWeb(BaseUrl+"api/LocalClaim/GetBandWisePolicyDetailsLocal?band="+bandid+"");
 		 
 		 assertTrue(lpolicycode.equalsIgnoreCase("200")||lpolicycode.equalsIgnoreCase("201"));
 		 break;
 		 
 	
    case "MobileView/ValiadteMobileClaim" :
    	 
    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
    	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+4);
			System.out.println("API wbs mode name is "+wbsdata);
			  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				System.out.println(dtf.format(localDate));
				System.out.println(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
		 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True");
    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Mobile/GetInsertMobileClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
		 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
		
	//System.out.println(userresponse);
		 array = gdata.parseFromJSONResponse(userresponse);
		  j=0;
		  System.out.println(array);
		  ClaimId=array.get(j+7);
		  travelexpenseid=array.get(j+9);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		  System.out.println("New claim id is "+travelexpenseid); 
		  String mobilevalidationcode= gdata1.getContenxtWeb(BaseUrl+"api/MobileView/ValiadteMobileClaim?date_from="+dtf.format(localDate)+"&date_to="+dtf.format(localDate)+""
		  		+ "&emp_id="+empdata+"&expenseID="+travelexpenseid+"");
	 		 
	 		 assertTrue(mobilevalidationcode.equalsIgnoreCase("200")||mobilevalidationcode.equalsIgnoreCase("201"));
	 		 break;
	 		 
    case "Notification/GetEmpNotificationCount" :   //get emp wise notification count
    	
    	
    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
    	
    	String notcountcode= gdata1.getContenxtWeb(BaseUrl+"api/Notification/GetEmpNotificationCount?empid="+empdata+"");
	 		 
	 		 assertTrue(notcountcode.equalsIgnoreCase("200")||notcountcode.equalsIgnoreCase("201"));
    	    
    	 break;
    	 
    case "Notification/GetEmpNotificationDetails" :  //get notification details
    	   

    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
    	
    	String notcountdetailscode= gdata1.getContenxtWeb(BaseUrl+"api/Notification/GetEmpNotificationDetails?empid="+empdata+"&Status=yes");
	 		 
	 		 assertTrue(notcountdetailscode.equalsIgnoreCase("200")||notcountdetailscode.equalsIgnoreCase("201"));
	 		 
	 		 break;
	 		 
    case "test" :
    	
    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
    	
    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/Notification/GetEmpNotificationDetails?empid="+empdata+"&Status=yes");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
    	
    	break;
    	

    	
    case "RptClaimDetails/GetApproverClaimCount" :   //get total pending claim count
    	//http://192.168.1.14:84/api/RptClaimDetails/GetApproverClaimCount?EMPId=604&month=12&year=2017&week=0&action=pending

    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
    	
    	String pendingclaimcountcode= gdata1.getContenxtWeb(BaseUrl+"api/RptClaimDetails/GetApproverClaimCount?EMPId="+empdata+"&month="+(current.get(Calendar.MONTH))+1+""
    			+ "&year="+current.get(Calendar.YEAR)+"&week=0&action=pending");
		 
		 assertTrue(pendingclaimcountcode.equalsIgnoreCase("200")||pendingclaimcountcode.equalsIgnoreCase("201"));
		
    	break;
    	
    case "LoadMasterData/GetTypeOfWork" :
    	  
    	String typeofworkcode= gdata1.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork");
		 
		 assertTrue(typeofworkcode.equalsIgnoreCase("200")||typeofworkcode.equalsIgnoreCase("201"));
    	break;
    	
    	
    case "PolicyCheckOtherClaim/GetBandWisePolicy" :     //get other expense policy   http://192.168.1.14:84/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE=10


    	
   	 noename="";
		//TestData.GetData gdata = new  TestData.GetData();
		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get");
		  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123"); 			
			
	  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);

		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
		
		for( j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename);
		ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
			//String noename2=noepolicyarray1.get(1);			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
			if(noepolicyarray1.size()!=0)
			{
				j=noearray1.size();
			}
		}
  	
  	String otherpolicycode= gdata1.getContenxtWeb(BaseUrl+"api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"");
		 
		 assertTrue(otherpolicycode.equalsIgnoreCase("200")||otherpolicycode.equalsIgnoreCase("201"));
		 break;
		 
    case "PolicyCheck/GetCheckAllowed" :
	   
 	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;

		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
		  
		  String allowclaimtypescode= gdata1.getContenxtWeb(BaseUrl+"api/PolicyCheck/GetCheckAllowed?Band="+bandid+"&EmpId="+empdata+"");
	 		 
	 		 assertTrue(allowclaimtypescode.equalsIgnoreCase("200")||allowclaimtypescode.equalsIgnoreCase("201"));
	 		 break;
    	
    case "OtherClaimView/ValidateOtherClaim" : //  validate other claim
    	
   	    	
   	    	  noename="";
   	 		//TestData.GetData gdata = new  TestData.GetData();
   	 		  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get");
    	 		
    	
    	 		 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
    	 		
    	 		for( j=0;j<noearray1.size();j++)
    	 		{
    	 			
    	 			 noename=noearray1.get(j);
    	 			System.out.println("Noe name is:->>>>>>>>>"+noename);
    	 			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename);
    	 			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
   	 			//String noename2=noepolicyarray1.get(1);
    	 			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
    	 			if(noepolicyarray1.size()!=0)
    	 			{
    	 				j=noearray1.size();
    	 			}
    	 		}
    	 		
    	 		  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
    	 			
    	 			
    	 		  array1 = gdata.parseFromJSONResponse(userresponse);
    	 		 
    	 		 System.out.println(array1);
    	 		  i=0;
    	//
    	 		  userData=array1.get(i);
    	 		  passData=array1.get(i+1);
    	 		 empdata=array1.get(i+2);
    	 		  bandid=array1.get(i+3);
    	 		  emailid=array1.get(i+4);		 
    	 		  message=array1.get(i+5);
    	 		  
    	 		  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS");
    	 			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
    	 			 
    	 				
   	 				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
    	 				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
    	 				 wbscount=0;
    	 				 wbsdata=wbsarray.get(wbscount+4);
   	 				System.out.println("API wbs mode name is "+wbsdata);
    	 				 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	 				 localDate = LocalDate.now();
    	 				System.out.println(dtf.format(localDate));
    	 		
    	 		userresponse = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/GetInsertOtherClaim?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
    	 		 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
    	 		 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756");
    	 		
    	 	        //System.out.println(userresponse);
    	 		    array = gdata.parseFromJSONResponse(userresponse);
    	 		    j=0;
    	 		    System.out.println(array);
    	 		     ClaimId=array.get(j+7);
    	 		     travelexpenseid=array.get(j+11);
    	 		     //fromdate=array.get(j+5);
    	 		     System.out.println("New claim id is "+ClaimId);
    	 		     System.out.println("New claim id is "+travelexpenseid);
    			    System.out.println(BaseUrl+"api/OtherClaimView/ValidateOtherClaim?date_from="+dtf.format(localDate)+"&date_to="+dtf.format(localDate)+"&emp_id="+empdata+"&noe="+noename+"&expenseID="+travelexpenseid+"");
    	          String validateothercode= gdata1.getContenxtWeb(BaseUrl+"api/OtherClaimView/ValidateOtherClaim?date_from="+dtf.format(localDate)+"&date_to="+dtf.format(localDate)+"&emp_id="+empdata+"&noe="+noename+"&expenseID="+travelexpenseid+"");
  		 		 
  		 		 assertTrue(validateothercode.equalsIgnoreCase("200")||validateothercode.equalsIgnoreCase("201"));
    		 		 
    		 		 break;
    		 		 
    		 		 //Danone
  
    case "Place/GetTownList" :     //Get Town list   http://192.168.1.14:84/api/Place/GetTownList?TownType=FromTown&Territory=604


    	 
    	   
    	 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
			
			
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;
//
		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
		  String territiryId=array1.get(i+13);
		  System.out.println(territiryId);
		  
		  String territorycode= gdata1.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"");
	 		 
	 		 assertTrue(territorycode.equalsIgnoreCase("200")||territorycode.equalsIgnoreCase("201"));
		  break;
    case "LoadTravelMode/GetTravelMode" :   //get travel modes for daily allowance
//http://192.168.1.14:82/api/LoadTravelMode/GetTravelMode?empid=604&fromPlace=Barrackpur&toPlace=Naihati&HQType=1716&workType=1708
    	
    	 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

    	System.out.println("Type of work array is"+array1);
    	
    	i=0;
		 String typeofwork = array1.get(i+1);
		 System.out.println("Type of work is"+typeofwork);
    	
    	
    	
    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		  
		 
		 System.out.println(array1);
		  i=0;
//
		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
		   territiryId=array1.get(i+13);
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"");
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
    	System.out.println(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+""
    			+ "&fromPlace="+fromtown+"&toPlace="+totown+"&HQType="+hqtypedata+"&workType="+typeofwork+"");
    	String travemodedanonecode= gdata1.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"");
		 
		 assertTrue(travemodedanonecode.equalsIgnoreCase("200")||travemodedanonecode.equalsIgnoreCase("201"));
		 break;
		 
    
    	
		  
    case "LoadDistance/GetKmDistance" :    //get km distance
//http://192.168.1.14:84/api/LoadDistance/GetKmDistance?Territory=604&fromPlace=Barrackpur&toPlace=Naihati&HQType=1716&TravelMode=1&travelWay=1720

    	    
    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

  	System.out.println("Type of work array is"+array1);
  	
  	i=0;
		  typeofwork = array1.get(i+1);
    	
    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;
//
		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
		   territiryId=array1.get(i+13);
		  
		  userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
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

			System.out.println("From town is"+arrOfStr[0]);
			System.out.println("From town is"+arrOfStr[1]);
			
	    	 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"");
			   ArrayList<String> danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
               System.out.println(danonetravelmodedata);
			i=0;
			
			String danonetravelmode=danonetravelmodedata.get(i+1);
			
			
			
			
			String travelwayresponse = gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TravelWay");
			
			ArrayList<String> travelwayarray=gdata.parseFromJSONarrayResponse(travelwayresponse);
			i=0;
			String travelwayid = travelwayarray.get(i+1);
			System.out.println(travelwayarray);
			
			System.out.println(BaseUrl+"api/LoadDistance/GetKmDistance?Territory="+territiryId+""
					+ "&fromPlace="+fromtown+"&toPlace="+totown+"&HQType="+hqtypedata+"&TravelMode=1&travelWay="+travelwayid+"");
			String kmdistancecode= gdata1.getContenxtWeb(BaseUrl+"api/LoadDistance/GetKmDistance?Territory="+territiryId+""
					+ "&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&TravelMode="+danonetravelmode+"&travelWay="+travelwayid+"");
	 		 
	 		 assertTrue(kmdistancecode.equalsIgnoreCase("200")||kmdistancecode.equalsIgnoreCase("201"));
	 		 
	 		 
	 		 

             break;
	 		 
	 		 
    case "LoadTravelModePrice/GetTravelModePrice" :    //load travel mode wise price per km for danone

    	
    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	System.out.println("Type of work array is"+array1);
	
	i=0;
		  typeofwork = array1.get(i+1);
  	
  	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;
//
		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
		   territiryId=array1.get(i+13);
		  
		  userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
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

			System.out.println("From town is"+arrOfStr[0]);
			System.out.println("From town is"+arrOfStr[1]);
			
	    	 userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadTravelMode/GetTravelMode?empid="+empdata+"&fromPlace="+fromtown.replace(" ", "%20")+"&toPlace="+totown.replace(" ", "%20")+"&HQType="+hqtypedata+"&workType="+typeofwork+"");
			    danonetravelmodedata = gdata.parseFromJSONarrayResponse(userresponse);	 
             System.out.println(danonetravelmodedata);
			i=0;
			
			 danonetravelmode=danonetravelmodedata.get(i+1);
			 
			 
			 String kmdetailscode= gdata1.getContenxtWeb(BaseUrl+"api/LoadTravelModePrice/GetTravelModePrice?travelmode="+danonetravelmode+"");
			 
			 assertTrue(kmdetailscode.equalsIgnoreCase("200")||kmdetailscode.equalsIgnoreCase("201"));
	    	break;
	    	
	    	
    case "Allowance/GetAllowance?AllowanceHead" :  //get allowance amount for fieldwork
             //http://192.168.1.14:84/api/Allowance/GetAllowance?AllowanceHead=1708&empid=604&HQ=1715&Residential=0&NightHalt=0

    	userresponse= gdata.getContenxtWeb(BaseUrl+"api/LoadMasterData/GetTypeOfWork?worktype=TypeOfWork");
    	
		  array1 =gdata.parseFromJSONarrayResponse(userresponse);

	System.out.println("Type of work array is"+array1);
	
	i=0;
		  typeofwork = array1.get(i+1);
	
	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123");
		
		
		  array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		  i=0;
//
		  userData=array1.get(i);
		  passData=array1.get(i+1);
		 empdata=array1.get(i+2);
		  bandid=array1.get(i+3);
		  emailid=array1.get(i+4);		 
		  message=array1.get(i+5);
		   territiryId=array1.get(i+13);
		   userresponse= gdata.getContenxtWeb(BaseUrl+"api/Place/GetTownList?TownType=FromTown&Territory="+territiryId+"");
		   arraytown = gdata.parseFromJSONarrayResponse(userresponse);	 
			 System.out.println(arraytown);
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
    	System.out.println(BaseUrl+"api/Allowance/GetAllowance?AllowanceHead="+typeofwork+"&empid="+empdata+""
    			+ "&HQ="+hqtypedata+"&Residential=0&NightHalt=0");
    	String allowanceamountcode= gdata1.getContenxtWeb(BaseUrl+"api/Allowance/GetAllowance?AllowanceHead="+typeofwork+"&empid="+empdata+""
    			+ "&HQ="+hqtypedata+"&Residential=0&NightHalt=0");
		 
		 assertTrue(allowanceamountcode.equalsIgnoreCase("200")||allowanceamountcode.equalsIgnoreCase("201"));
   	break;
   	

				 
		 

				 
				 
				 
		
				 
				 
				 
			 
			 
			 
			
		
		}
	}
	

}
