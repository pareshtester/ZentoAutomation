package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;

import Browsers.Urls;
import Data.captureData;
import TestData.GetApiData;

public class ExtendedCallAPI extends Urls {
WebDriver driver;
	
	String Logincode="";
	String empdata="";
	String 	ClaimId="";
	String bandid="";
	String travelexpenseid="";
	String travelinsertresponse="";
	String managerdata="";
	String APIBody="";
	String advanceid="";
	
	String responsecode="";
	
	Calendar current = Calendar.getInstance();
	int k=0;
	
	public void apicalls(String functiontext,String username,String password,String managerusername,String managerpassword,String policytyp,String domaintext) throws JSONException, InterruptedException
	{
		
		//switch
		GetApiData gdata1 = new  GetApiData();
		captureData gdata = new  captureData();
		captureData citydata = new  captureData();
		
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
		 ArrayList<String> array1 = gdata.parseFromJSONResponse(userresponse);
		 
		
		 int i=0;
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		String empdata=array1.get(i+2);
		String  bandid=array1.get(i+3);
		String  emailid=array1.get(i+4);		 
		 String message=array1.get(i+5);
		 String territiryId=array1.get(i+13);
		 String zoneId=array1.get(i+18);
		   String teamId=array1.get(i+19);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
			
		
			String foodid="";
			ArrayList<String> array ;
			 i=0;
		
		switch (functiontext)
		{
		
		 case "TravelClaim/GetInsertUpdateTravelClaim" :	
			 
			 
			
	   			 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
	   			
	   		
	   			 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
	   			 int cityno=0;
	   			
	   			 String citynamefromdata=cityarray1.get(cityno+1);
	   			 String citynametodata=cityarray1.get(cityno+2);
	   			 ArrayList<String> wbsarray = new ArrayList<String>();
	   			
	   			
	   			
	   			String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
	   			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
	   			System.out.println(wbsarray+"array");
	   			int wbscount=0;
	   			String wbsdata=wbsarray.get(wbscount+1);
	   			
	   			
	        	 String  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
	     		 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
	     		 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
	     		 
	     			String travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

	     			 ArrayList<String> travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
	     			int travelmodecount=0;
	     			String travelmodedata=travelmodearray.get(travelmodecount+1);
	        	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 			 localDate = LocalDate.now();
	 			
	 				  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
	 				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
	 				 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
	 				 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
	 				
	 			
	 				 array = gdata.parseFromJSONResponse(travelinsertresponse);
	 				 int j=0;
	 				 System.out.println(array);
	 				  ClaimId=array.get(j+7);
	 				  travelexpenseid=array.get(j+8);
			 
			 break;
			 
			 
		 case "TravelClaimView/GetClaimByID" :	
	        	
	        	
	        	
			 
	        	
        	String citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
   		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
   		 

   			
   			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
   			
   		
   			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
   			  cityno=0;
   			
   			  citynamefromdata=cityarray1.get(cityno+1);
   			  citynametodata=cityarray1.get(cityno+2);
   			
        	
 wbsarray = new ArrayList<String>();
   			
   			
   			
   			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
   			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
   		
   			 wbscount=0;
   			 wbsdata=wbsarray.get(wbscount+1);
   		
        	
        	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
     		 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
     		 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
     		 
     		
     			 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

     			  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
     			 travelmodecount=0;
     			 travelmodedata=travelmodearray.get(travelmodecount+1);
        	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
 			 localDate = LocalDate.now();
 		
 			
 			
 				  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
 				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
 				 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
 				 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
 				
 			
 				  array = gdata.parseFromJSONResponse(travelinsertresponse);
 				  j=0;
 				
 				  ClaimId=array.get(j+7);
 				  travelexpenseid=array.get(j+8);
 				 
 				
 				 
                 //****View Travel expense
				 
				
				 String viewtravelexpensecode= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaimView/GetClaimByID?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
				 assertTrue(viewtravelexpensecode.equalsIgnoreCase("200")||viewtravelexpensecode.equalsIgnoreCase("201")); 
 				 
 				 break;
 				 
 				 
		 case "GetEmpAppliedExpenseDataTravel" :	
			 	
			 	
			 	
			 
			 	
		 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
			 

				
				  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
				
			
				  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
				  cityno=0;
				
				  citynamefromdata=cityarray1.get(cityno+1);
				  citynametodata=cityarray1.get(cityno+2);
				
		 	
		 	String  WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
			  wbsarray = new ArrayList<String>();
				
				
				
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
			
		 	
		 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
				 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
				 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
				 
				
					 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

					  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
					 travelmodecount=0;
					 travelmodedata=travelmodearray.get(travelmodecount+1);
		 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
			
				
				
					  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
					 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
					 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
					 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
					
					  array = gdata.parseFromJSONResponse(travelinsertresponse);
					  j=0;
				
					  ClaimId=array.get(j+7);
					  travelexpenseid=array.get(j+8);
					  
					
					 
		          
					 
					
					  viewtravelexpensecode= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaimView/GetClaimByID?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
					 assertTrue(viewtravelexpensecode.equalsIgnoreCase("200")||viewtravelexpensecode.equalsIgnoreCase("201"));
					 
					 break;
					 
					 
		 case "TravelClaimView/UpdateTravelClaim" :	
			 	
			 	
			System.out.println(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+""); 	
			 	
		 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
			 

				
				  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
				
			
				  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
				  cityno=0;
				
				  citynamefromdata=cityarray1.get(cityno+1);
				  citynametodata=cityarray1.get(cityno+2);
				System.out.println(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 	
		 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
			 wbsarray = new ArrayList<String>();
			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);	
				
			
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
			System.out.println(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
		 	
		 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
				 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
				 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
				 
				
					 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

					  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
					 travelmodecount=0;
					 travelmodedata=travelmodearray.get(travelmodecount+1);
		 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
			
				System.out.println(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
		 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
		 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
				
					  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
					 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
					 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
					 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
					
				
					  array = gdata.parseFromJSONResponse(travelinsertresponse);
					  j=0;
				
					  ClaimId=array.get(j+7);
					  travelexpenseid=array.get(j+8);
					  //fromdate=array.get(j+5);
				
					 
					 
					////***************Update travel claim    /api/TravelClaimView/UpdateTravelClaim?ClaimId=1&TravelClaimId=1&TravelDateFrom=2016-12-01 00:00:00.000&amount=6000.00&TravelDateTo=2016-12-01 00:00:00.000&CityFrom=1&CityTo=2&Remarks=edit&ModeOfTravel=26&WBS=26&TaxAmt=&GSTIncluded=true
				
		           String updatetravelclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaimView/UpdateTravelClaim?ClaimId="+ClaimId+"&TravelClaimId="+travelexpenseid+""
								+ "&TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&amount=6000.00&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000"
										+ "&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
								+ "&Remarks=edit&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
					 assertTrue(updatetravelclaimcode.equalsIgnoreCase("200")||updatetravelclaimcode.equalsIgnoreCase("201"));
					 break;
					 
		 case "Submit/SubmitClaim" :	
			 	
			 	
			 	
			 	
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
			
		 	
		 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
				 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
				 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
				 
				
					 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

					  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
					 travelmodecount=0;
					 travelmodedata=travelmodearray.get(travelmodecount+1);
		 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
			
				
				
					  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
					 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
					 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
					 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
					
				//System.out.println(userresponse);
					  array = gdata.parseFromJSONResponse(travelinsertresponse);
					  j=0;
					
					  ClaimId=array.get(j+7);
					  travelexpenseid=array.get(j+8);
				
					 
					 
	                       //******Submit claim     http://192.168.1.234/api/Submit/SubmitClaim?ClaimID=252    *********************

					 
					 String submitclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/Submit/SubmitClaim?ClaimID="+ClaimId+"&Domain="+domaintext+"");
					 assertTrue(submitclaimcode.equalsIgnoreCase("200")||submitclaimcode.equalsIgnoreCase("201"));
					 break;
					 
					 
					 
					 
					 
		 case "ClaimProcessing/ApproveDissapproveClaims" :	
			 	
			 	
			 	
			  System.out.println(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			 	
		 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
			 

				
				  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
				
			
				  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
				  cityno=0;
				
				  citynamefromdata=cityarray1.get(cityno+1);
				  citynametodata=cityarray1.get(cityno+2);
				
		 	System.out.println(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
			 wbsarray = new ArrayList<String>();
				
				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
			System.out.println(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");	
		 	
		 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
				 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
				 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
				 
			System.out.println(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");	
					 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

					  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
					 travelmodecount=0;
					 travelmodedata=travelmodearray.get(travelmodecount+1);
		 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
			
			System.out.println(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
	 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
	 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");	
				
					  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
					 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
					 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
					 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
					
				
					  array = gdata.parseFromJSONResponse(travelinsertresponse);
					  j=0;
					
					  ClaimId=array.get(j+7);
					  travelexpenseid=array.get(j+8);
					
					
					 
					 
	              System.out.println(BaseUrl+"/api/Submit/SubmitClaim?ClaimID="+ClaimId+"&Domain="+domaintext+"");

					 
					  submitclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/Submit/SubmitClaim?ClaimID="+ClaimId+"&Domain="+domaintext+"");
					 assertTrue(submitclaimcode.equalsIgnoreCase("200")||submitclaimcode.equalsIgnoreCase("201"));
					 
					 

					 System.out.println(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
					 
					 String managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
						
						
					 ArrayList<String> arraymanager = gdata.parseFromJSONResponse(managerresponse);
					 
					
					  k=0;

					
					 managerdata=arraymanager.get(k+2);
					 
					 System.out.println(BaseUrl+"/api/ClaimProcessing/ApproveDissapproveClaims?claim_id="+ClaimId+"&reccID="+managerdata+"&remarks=604&action=1&status=yes&Domain="+domaintext+"");
				
					 String approvetravelclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/ClaimProcessing/ApproveDissapproveClaims?claim_id="+ClaimId+"&reccID="+managerdata+"&remarks=604&action=1&status=yes&Domain="+domaintext+"");
					 assertTrue(approvetravelclaimcode.equalsIgnoreCase("200")||approvetravelclaimcode.equalsIgnoreCase("201"));
					 break;
		
		 case "ActivityClaim/InsertActivityClaim" :  //insert activity claim
	    	 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			 String activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			 String activitytype= array.get(i+1);
	    	
	    	String activityclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	 		 assertTrue(activityclaimcode.equalsIgnoreCase("200")||activityclaimcode.equalsIgnoreCase("201"));
	 		 break;
	 		 
		 case "ActivityClaim/GetEstimatedActivityById" :   //get estimated activity by activity id

			 
			  activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			  activitytype= array.get(i+1);
			
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	    	
	    	 activityclaimcode= gdata.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	    	 
	    	 array = gdata.parseFromJSONResponse(activityclaimcode);
	    	 String activityid= array.get(i+21);
	    	
	    	 
	    	 String estimitedactivityidcode = gdata1.getContenxtWeb(BaseUrl+"/api/ActivityClaim/GetEstimatedActivityById?ActivityID="+activityid+"&Domain="+domaintext+"");
	 		 assertTrue(estimitedactivityidcode.equalsIgnoreCase("200")||estimitedactivityidcode.equalsIgnoreCase("201"));
	    	
	    	break;
	    	
	    	
		 case "ActivityClaim/GetDashboardEstimatedActivities" :   //get estimated dashboard data
			  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123&Domain="+domaintext+"");
			  array = gdata.parseFromJSONResponse(userresponse);
			  i=0;
			 empdata=array.get(i+2);
			 
			 String estimateddashboardcode = gdata1.getContenxtWeb(BaseUrl+"/api/ActivityClaim/"
			 		+ "GetDashboardEstimatedActivities?empid="+empdata+"&month="+current.get(Calendar.MONTH)+""
			 				+ "&year="+current.get(Calendar.YEAR)+"&sortBy=CLAIMID&IsActual=0&Domain="+domaintext+"");
	 		 assertTrue(estimateddashboardcode.equalsIgnoreCase("200")||estimateddashboardcode.equalsIgnoreCase("201"));
	    	
			 
			 break;
			 
			 
		 case "ActivityClaim/UpdateEstimatedActivity" :  //update estimated activity

			 
			 
			 activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			  activitytype= array.get(i+1);
			 System.out.println(activitytype);
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	    	
	    	 activityclaimcode= gdata.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	    	 
	    	 array = gdata.parseFromJSONResponse(activityclaimcode);
	    	  activityid= array.get(i+21);
	    	 System.out.println(activityid);
	    	 dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			 localDate = LocalDate.now();
	    	

	    	 
	    	 String updateestimatedactivitycode = gdata1.getContenxtWeb(BaseUrl+"/api/ActivityClaim/UpdateEstimatedActivity?intActivityId="+activityid+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100" + 
	    	 		"&numFoodAmt=100&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=500&numOtherAmt=100&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails=&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=5&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1&intIncidentalTravel=1&" + 
	    	 		"intEventLocalLaws=1&intAttachReqDocs=1&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1&intClusterThreshold=1&dtActivity="+dtf.format(localDate)+"&Domain="+domaintext+"");
	    	 
	 		 assertTrue(updateestimatedactivitycode.equalsIgnoreCase("200")||updateestimatedactivitycode.equalsIgnoreCase("201"));
	    	
			 
			 break;
			   
		 case "ActivityClaim/DeleteActivity" :   //delete activity
			 
			 
			 activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			  activitytype= array.get(i+1);
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	    	
	    	 activityclaimcode= gdata.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	    	 
	    	 array = gdata.parseFromJSONResponse(activityclaimcode);
	    	  activityid= array.get(i+21);

			 String deleteactivitycode = gdata1.getContenxtWeb(BaseUrl+"/api/ActivityClaim/DeleteActivity?Activityid="+activityid+"&IsActual=0&Domain="+domaintext+"");
		    	
		 		 assertTrue(deleteactivitycode.equalsIgnoreCase("200")||deleteactivitycode.equalsIgnoreCase("201"));
			 
			 break;  
			 
			 
       case "ActivityClaim/GetEstimatedSettledActivities" :    //get settled estimated activities

    	   String settledestimatedactivitiescode = gdata1.getContenxtWeb(BaseUrl+"/api/ActivityClaim/GetEstimatedSettledActivities?year="+current.get(Calendar.YEAR)+""
    	   		+ "&empid="+empdata+"&month="+current.get(Calendar.MONTH)+1+"&mode=Add&Domain="+domaintext+"");
	    	
	 		 assertTrue(settledestimatedactivitiescode.equalsIgnoreCase("200")||settledestimatedactivitiescode.equalsIgnoreCase("201"));
			 break;
			 
			 
       case "ActivityProcessing/ActivityStatus" :  //get activity status

    	   activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			  activitytype= array.get(i+1);
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	    	
	    	 activityclaimcode= gdata.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	    	 
	    	 array = gdata.parseFromJSONResponse(activityclaimcode);
	    	  activityid= array.get(i+21);
	    	 
	    	 String activitystatuscode = gdata1.getContenxtWeb(BaseUrl+"/api/ActivityProcessing/ActivityStatus?activityid="+activityid+"&IsActual=0&Domain="+domaintext+"");
		    	
	 		 assertTrue(activitystatuscode.equalsIgnoreCase("200")||activitystatuscode.equalsIgnoreCase("201"));
			 break;
			 
			 
       case "ActivitySubmit/SubmitActivity" :   //ActivitySubmit/SubmitActivity
    	   
    	   activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			  activitytype= array.get(i+1);
			 
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	    	
	    	 activityclaimcode= gdata.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	    	 
	    	 array = gdata.parseFromJSONResponse(activityclaimcode);
	    	  activityid= array.get(i+21);
	    	 
	    	 
	    	 
	    	 
	    	 String activitysubmitcode = gdata1.getContenxtWeb(BaseUrl+"/api/ActivitySubmit/SubmitActivity?activityid="+activityid+"&isactual=0&Domain="+domaintext+"");
		    	
	 		 assertTrue(activitysubmitcode.equalsIgnoreCase("200")||activitysubmitcode.equalsIgnoreCase("201"));
			 break;
			 
			 
       case "ReOpen/ReopenClaim" :	
   	 	
   	 	
   	 	
			  
   	 	
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
  			
  	 	
  	 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
  			 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
  			 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
  			 
  			
  				 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

  				  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
  				 travelmodecount=0;
  				 travelmodedata=travelmodearray.get(travelmodecount+1);
  	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  			 localDate = LocalDate.now();
  	
  			
  			
  				  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
  				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
  				 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
  				 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
  				
  			//System.out.println(userresponse);
  				  array = gdata.parseFromJSONResponse(travelinsertresponse);
  				  j=0;
  				
  				  ClaimId=array.get(j+7);
  				  travelexpenseid=array.get(j+8);
  				  //fromdate=array.get(j+5);
  				
  				 
  				 
                   //******Submit claim     http://192.168.1.234/api/Submit/SubmitClaim?ClaimID=252    *********************

  				 
  				  submitclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/Submit/SubmitClaim?ClaimID="+ClaimId+"&Domain="+domaintext+"");
  				 assertTrue(submitclaimcode.equalsIgnoreCase("200")||submitclaimcode.equalsIgnoreCase("201"));
  				 
  				 
  				 //****************Reject claim****************************************
  				  managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
  					
  					
  				 arraymanager = gdata.parseFromJSONResponse(managerresponse);
  				 
  				
  				  k=0;

  				
  				 managerdata=arraymanager.get(k+2);
  				
  				   String rejecttravelclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/ClaimProcessing/ApproveDissapproveClaims?claim_id="+ClaimId+"&reccID="+managerdata+"&remarks=604&action=0&status=yes&Domain="+domaintext+"");
  					 assertTrue(rejecttravelclaimcode.equalsIgnoreCase("200")||rejecttravelclaimcode.equalsIgnoreCase("201"));
  				 

  					 String reopenclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/ReOpen/ReopenClaim?claim_id="+ClaimId+"&amount=12&Domain="+domaintext+"");
  					 assertTrue(reopenclaimcode.equalsIgnoreCase("200")||reopenclaimcode.equalsIgnoreCase("201"));	
  					 
  					 break;
			 
       case "ActivityProcessing/ApproveDissapproveActivity" :   //approve disapprove activity
    	   
    	    managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
			
			
			  arraymanager = gdata.parseFromJSONResponse(managerresponse);
			 
			  k=0;

			
			 managerdata=arraymanager.get(k+2);

    	   activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			  activitytype= array.get(i+1);
			 System.out.println(activitytype);
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	    	
	    	 activityclaimcode= gdata.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	    	 
	    	 array = gdata.parseFromJSONResponse(activityclaimcode);
	    	  activityid= array.get(i+21);
	    	 System.out.println(activityid);
	    	 
	    	 
	    	 
	    	 
	    	  activitysubmitcode = gdata.getContenxtWeb(BaseUrl+"/api/ActivitySubmit/SubmitActivity?activityid="+activityid+"&isactual=0");
		    	 String activityapproavecode = gdata1.getContenxtWeb(BaseUrl+"/api/ActivityProcessing/ApproveDissapproveActivity?ActivityId="+activityid+"&ReccId="+managerdata+"&Remarks=&Action=0&IsActual=0&ActivityType="+activitytype+"&Domain="+domaintext+"");
			    	
		 		 assertTrue(activityapproavecode.equalsIgnoreCase("200")||activityapproavecode.equalsIgnoreCase("201"));
				 break;
				 
				 
       case "Actual/InsertActualClaim?intActivityID" : //insert actual claim

    	   
    	  

  	   activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			  activitytype= array.get(i+1);
			 System.out.println(activitytype);
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	    	
	    	 activityclaimcode= gdata.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	    	 
	    	 array = gdata.parseFromJSONResponse(activityclaimcode);
	    	  activityid= array.get(i+21);
	    	 System.out.println(activityid);
	    	 
	    	 String insertactualcode= gdata1.getContenxtWeb(BaseUrl+"/api/Actual/InsertActualClaim?intActivityID="+activityid+""
	    	 		+ "&dtActivity="+dtf.format(localDate)+"&intActivityType=1747&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    	 		+ "&intNoOfParticipants=3&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    	 		+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    	 		+ "&numTotalAmt=500&intEmp=2712&numRegistrationFees=100&intIsEventHCPTravelFormDocumented=1"
	    	 		+ "&intIsInvitationSentToAttendees=1&intIsRegisterUpdatesOfInvitedHCP=1&intIsProofOfAttendeesAttached=1"
	    	 		+ "&intIsDetailedInvoicesItemized=1&Domain="+domaintext+"");
			 assertTrue(insertactualcode.equalsIgnoreCase("200")||insertactualcode.equalsIgnoreCase("201"));
			 break;
			 
			 
       case "Actual/UpdateActualActivity" :  //update actual activity
    	   
    	   
    	   activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			  activitytype= array.get(i+1);
			 System.out.println(activitytype);
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	    	
	    	 activityclaimcode= gdata.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	    	 
	    	 array = gdata.parseFromJSONResponse(activityclaimcode);
	    	  activityid= array.get(i+21);
	    	
	    	 
	    	  insertactualcode= gdata.getContenxtWeb(BaseUrl+"/api/Actual/InsertActualClaim?intActivityID="+activityid+""
	    	 		+ "&dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    	 		+ "&intNoOfParticipants=3&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    	 		+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    	 		+ "&numTotalAmt=500&intEmp=2712&numRegistrationFees=100&intIsEventHCPTravelFormDocumented=1"
	    	 		+ "&intIsInvitationSentToAttendees=1&intIsRegisterUpdatesOfInvitedHCP=1&intIsProofOfAttendeesAttached=1"
	    	 		+ "&intIsDetailedInvoicesItemized=1&Domain="+domaintext+"");
	    	  
	    	  
	    	  array = gdata.parseFromJSONResponse(insertactualcode);
	    	  String actualactivityid= array.get(i+22);
	    	 
	    	  
	    	  

	    	  dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				 localDate = LocalDate.now();
	    	  
	    	  String updateactualcode = gdata1.getContenxtWeb(BaseUrl+"/api/Actual/UpdateActualActivity?intActivityId="+activityid+""
	    	  		+ "&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test&intNoOfParticipants=3&vcPaymentFavour=&numHotelVenueAmt=100"
	    	  				+ "&numFoodAmt=100&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100&numTotalAmt=500&intEmp=2712"
	    	  				+ "&numRegistrationFees=100&intIsEventHCPTravelFormDocumented=1&intIsInvitationSentToAttendees=1&intIsRegisterUpdatesOfInvitedHCP=1"
	    	  				+ "&intIsProofOfAttendeesAttached=1&intIsDetailedInvoicesItemized=1&dtActivity="+dtf.format(localDate)+"&Domain="+domaintext+"");
	    	  
				 assertTrue(updateactualcode.equalsIgnoreCase("200")||updateactualcode.equalsIgnoreCase("201"));

	    	  break;
	    	  
	    	  
       case "Actual/GetActualActivityById" : //get actual activity by id
    	   activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			  activitytype= array.get(i+1);
			 System.out.println(activitytype);
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	    	
	    	 activityclaimcode= gdata.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	    	 
	    	 array = gdata.parseFromJSONResponse(activityclaimcode);
	    	  activityid= array.get(i+21);
	    	
	    	 
	    	  insertactualcode= gdata.getContenxtWeb(BaseUrl+"/api/Actual/InsertActualClaim?intActivityID="+activityid+""
	    	 		+ "&dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    	 		+ "&intNoOfParticipants=3&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    	 		+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    	 		+ "&numTotalAmt=500&intEmp=2712&numRegistrationFees=100&intIsEventHCPTravelFormDocumented=1"
	    	 		+ "&intIsInvitationSentToAttendees=1&intIsRegisterUpdatesOfInvitedHCP=1&intIsProofOfAttendeesAttached=1"
	    	 		+ "&intIsDetailedInvoicesItemized=1&Domain="+domaintext+"");
	    	  
	    	  
	    	  array = gdata.parseFromJSONResponse(insertactualcode);
	    	   actualactivityid= array.get(i+22);
	    	  System.out.println(actualactivityid);
	    	  System.out.println(BaseUrl+"/api/Actual/GetActualActivityById?ActivityID="+actualactivityid+"");
    	   
    	   String getactualbyidcode = gdata1.getContenxtWeb(BaseUrl+"/api/Actual/GetActualActivityById?ActivityID="+activityid+"&Domain="+domaintext+"");
	    	  
				 assertTrue(getactualbyidcode.equalsIgnoreCase("200")||getactualbyidcode.equalsIgnoreCase("201"));

	    	  break;
			 
			 
       case "LoadActivityMasterData/GetActivityFinalTotal" :
    	   activitytyperesponse = gdata.getContenxtWeb(BaseUrl+"/api/LoadMasterData/GetTypeOfWork?worktype=TypeAActivity&empid="+empdata+"&Domain="+domaintext+"");
			 array = gdata.parseFromJSONarrayResponse(activitytyperesponse);
			 i=0;
			  activitytype= array.get(i+1);
			 System.out.println(activitytype);
			 dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
	    	
	    	 activityclaimcode= gdata.getContenxtWeb(BaseUrl+"/api/ActivityClaim/InsertActivityClaim?"
	    			+ "dtActivity="+dtf.format(localDate)+"&intActivityType="+activitytype+"&vcVenue=test&vcTopic=test&vcSpeaker=test"
	    			+ "&intNoOfParticipants=5&vcPaymentFavour=&numHotelVenueAmt=100&numFoodAmt=100"
	    			+ "&numLCDAudioVideoAmt=100&numTravelAmt=100&numSpeakerAmt=100&numOtherAmt=100"
	    			+ "&numTotalAmt=100&intEmp=2712&intEventOrganizer=12&vcEventOrganizerDetails="
	    			+ "&vcVenueSelectionCriteria=14&numRegistrationAmt=100&vcTypeOfParticipants=2"
	    			+ "&vcHCPSelectionCriteria=9&vcHCPFlags=7&intHCPInfluence=1&intHCPPotentialConflict=1"
	    			+ "&intHCPDecision=1&intEmployerMedicalBoard=1&intHCPEmployerFormalWrittenRequest=1"
	    			+ "&intThirdPartyPolicy=1&intEventSocialPlatform=1&intEventSupportHCPSpouse=1"
	    			+ "&intIncidentalTravel=1&intEventLocalLaws=1&intAttachReqDocs=1"
	    			+ "&intSpeakerInternationalCongress=1&intSpeakerHonorarium=1&vcEventName=1"
	    			+ "&vcAgendaPurpose=1&vcHCPName=1&vcEmployer=1&vcPlaceOfWorkPractice=1"
	    			+ "&intClusterThreshold=1&Domain="+domaintext+"");
	    	 
	    	 array = gdata.parseFromJSONResponse(activityclaimcode);
	    	  activityid= array.get(i+21);
	    	 System.out.println(activityid);
    	   String getacttivitytotalcode = gdata1.getContenxtWeb(BaseUrl+"/api/LoadActivityMasterData/GetActivityFinalTotal?activityid="+activityid+"&isactual=0&Domain="+domaintext+"");
	    	  
			 assertTrue(getacttivitytotalcode.equalsIgnoreCase("200")||getacttivitytotalcode.equalsIgnoreCase("201"));

  	  break;
    	   
    	   
		 case "AutoApprovalPolicyBandWise/GetAllAutoApproverPolicy" :  //get auto approval policy
		    	String getautoapprovalcode= gdata1.getContenxtWeb(BaseUrl+"/api/AutoApprovalPolicyBandWise/GetAllAutoApproverPolicy?Domain="+domaintext+"");
				 assertTrue(getautoapprovalcode.equalsIgnoreCase("200")||getautoapprovalcode.equalsIgnoreCase("201"));
				 break;
			 
		 case "AutoApprovalPolicyBandWise/GetAllAutoApproverPolicybyBandIDAndClaimtype" :  //get auto approval policy band wise
		    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123&Domain="+domaintext+"");
				  array = gdata.parseFromJSONResponse(userresponse);
				  i=0;
				 empdata=array.get(i+2);
				   bandid=array.get(i+3);
				  String claimtypemastercaode= gdata.getContenxtWeb(BaseUrl+"/api/Master/GetAllClaimType?status=yes&Domain="+domaintext+"");
		          array = gdata.parseFromJSONarrayResponse(claimtypemastercaode);
		          System.out.println(array);
		          for(int k=0;k<array.size();k++)
		          {
		          	String getautoapprovalbandcode= gdata1.getContenxtWeb(BaseUrl+"/api/AutoApprovalPolicyBandWise/GetAllAutoApproverPolicybyBandIDAndClaimtype?"
		        			+ "BandID="+bandid+"&claimTypeID="+array.get(k+1)+"&Domain="+domaintext+"");
		    		 assertTrue(getautoapprovalbandcode.equalsIgnoreCase("200")||getautoapprovalbandcode.equalsIgnoreCase("201"));
		          	k++;
		          }
				 break;
				 
				 
		 case "AutoApprovalPolicy/CheckDuplicateAutoApproverPolicy" : //duplicate auto approval policy
		    	
		    	
		    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD=Zento123&Domain="+domaintext+"");
				  array = gdata.parseFromJSONResponse(userresponse);
				  i=0;
				 empdata=array.get(i+2);
				  bandid=array.get(i+3);
				  claimtypemastercaode= gdata.getContenxtWeb(BaseUrl+"/api/Master/GetAllClaimType?status=yes&Domain="+domaintext+"");
		        array = gdata.parseFromJSONarrayResponse(claimtypemastercaode);
		        System.out.println(array);
		        for(int k=0;k<array.size();k++)
		        {
		        	String getautoapprovalbandcode= gdata1.getContenxtWeb(BaseUrl+"/api/AutoApprovalPolicy/CheckDuplicateAutoApproverPolicy?band="+bandid+"&claimTypeID="+array.get(k+1)+"&Domain="+domaintext+"");
		  		 assertTrue(getautoapprovalbandcode.equalsIgnoreCase("200")||getautoapprovalbandcode.equalsIgnoreCase("201"));
		        	k++;
		        }
				 break;
				 
		 case "Mobile/GetBandWisePolicyDetails" :   //get mobile claim policy

		    	
		    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
		   		
		   		
		 		  array = gdata.parseFromJSONResponse(userresponse);
		 		 
		 		 System.out.println(array);
		 		  i=0;

		 		   userData=array.get(i);
		 		    passData=array.get(i+1);
		 		 empdata=array.get(i+2);
		 		  bandid=array.get(i+3);
		 		  emailid=array.get(i+4);		 
		 		   message=array.get(i+5);
		 		  
		 		 
		    	
		    	String getbandwisepolicydetailsmobilecode= gdata1.getContenxtWeb(BaseUrl+"/api/Mobile/GetBandWisePolicyDetails?"
		    			+ "ClaimType=MobileClaim&band="+bandid+"&Domain="+domaintext+"");
				 assertTrue(getbandwisepolicydetailsmobilecode.equalsIgnoreCase("200")||getbandwisepolicydetailsmobilecode.equalsIgnoreCase("201"));
				 break;
				 
				 
		 case "TravelClaimView/Get" :   //get current week   Http://192.168.1.14:84/api/TravelClaimView/Get

		    	String currentweek= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaimView/Get?Domain="+domaintext+"");
				 assertTrue(currentweek.equalsIgnoreCase("200")||currentweek.equalsIgnoreCase("201"));
				 break;
				 
				 
		 case "Mobile/GetEmpAppliedClaimData" :  //get applied mobile claim data  

	    	 currentweek= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaimView/Get?Domain="+domaintext+"");
	   array = gdata.parseFromJSONarrayResponse(currentweek);
	   i=0;
	   String currentweekdata = array.get(i);
	    	
	    	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
			
			
			  array = gdata.parseFromJSONResponse(userresponse);
			 
			 System.out.println(array);
			  i=0;

			 
			 empdata=array.get(i+2);
			 
			  
			  
	    	
	    	String getappliedmobileclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/Mobile/GetEmpAppliedClaimData?ClaimWeek="+currentweekdata+"&EmpID="+empdata+"&Domain="+domaintext+"");
			 assertTrue(getappliedmobileclaimcode.equalsIgnoreCase("200")||getappliedmobileclaimcode.equalsIgnoreCase("201"));
			 break;
			 
			 
		 case "LandLineClaim/GetEmpAppliedClaimDataLandLine" :  //get applied landline claim data  

		   	 currentweek= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaimView/Get?Domain="+domaintext+"");
		  array = gdata.parseFromJSONarrayResponse(currentweek);
		  i=0;
		   currentweekdata = array.get(i);
		   	
		   	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
				
				
				  array = gdata.parseFromJSONResponse(userresponse);
				 
				 System.out.println(array);
				  i=0;

				 empdata=array.get(i+2);
				  
				  
				  
		   	
		   	String getappliedlandlineclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetEmpAppliedClaimDataLandLine?ClaimWeek="+currentweekdata+"&EmpID="+empdata+"&Domain="+domaintext+"");
				 assertTrue(getappliedlandlineclaimcode.equalsIgnoreCase("200")||getappliedlandlineclaimcode.equalsIgnoreCase("201"));
				 break;
				 
				 
		 case "otherClaim/GetEmpAppliedClaimDataOthe" :  //get other claims for week
			  

	      	 currentweek= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaimView/Get?Domain="+domaintext+"");
	     array = gdata.parseFromJSONarrayResponse(currentweek);
	     i=0;
	      currentweekdata = array.get(i);
	      	
	      	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
	   		
	   		
	   		  array = gdata.parseFromJSONResponse(userresponse);
	   		 
	   	
	   		  i=0;

	   		
	   		 empdata=array.get(i+2);
	   		  
	   		  
	      	String getappliedotherclaimcode= gdata1.getContenxtWeb(BaseUrl+"/api/LandLineClaim/GetEmpAppliedClaimDataLandLine?ClaimWeek="+currentweekdata+"&EmpID="+empdata+"&Domain="+domaintext+"");
	   		 assertTrue(getappliedotherclaimcode.equalsIgnoreCase("200")||getappliedotherclaimcode.equalsIgnoreCase("201"));
	   		 break;
	   		 
	   		 
	   		 
		 case "Master/GetBindEmployeeClaimTypes" : //claim type list for employees

		    	
		   	 currentweek= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaimView/Get?Domain="+domaintext+"");
		     array = gdata.parseFromJSONarrayResponse(currentweek);
		     i=0;
		      currentweekdata = array.get(i);
		      	
		      	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
		   		
		   		
		   		  array = gdata.parseFromJSONResponse(userresponse);
		   		 
		   		
		   		  i=0;

		   		  userData=array.get(i);
		   		  passData=array.get(i+1);
		   		 empdata=array.get(i+2);
		   		  bandid=array.get(i+3);
		   		  emailid=array.get(i+4);		 
		   		  message=array.get(i+5);
		   		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				 
		    	String claimtypelistempcode= gdata1.getContenxtWeb(BaseUrl+"/api/Master/GetBindEmployeeClaimTypes?"
		    			+ "bandID="+bandid+"&EmpID="+empdata+"&ClaimWeek="+currentweekdata+"&month="+current.get(Calendar.MONTH)+1+"&date="+dtf.format(localDate)+"&Domain="+domaintext+"");
				 assertTrue(claimtypelistempcode.equalsIgnoreCase("200")||claimtypelistempcode.equalsIgnoreCase("201"));
				 break;
				 
				 
		 case "ApplyLeave/Get" :   //Get leave types
			 
			 String leavetypescodes= gdata1.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
				 assertTrue(leavetypescodes.equalsIgnoreCase("200")||leavetypescodes.equalsIgnoreCase("201"));
			 
			 break;
			 
		 case "ApplyLeave/InsertLeave" :  //Insert leave
			 
			String  leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
			  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
			 
			 
			 for(i=1;i<array.size();i++)
				 
			 {
				String leavetypeid= array.get(i) ;
				
				String insertleaverespnse= gdata1.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domaintext+"");
				 assertTrue(insertleaverespnse.equalsIgnoreCase("200")||insertleaverespnse.equalsIgnoreCase("201"));
				 
			 }
					 break;
					 
					 
					 
		 case "ApplyLeave/UpdateLeave":  //update leave details
			 array=null;
			   leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
			  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
		
			 
			 for(i=1;i<array.size();i++)
				 
			 {
				String leavetypeid= array.get(i) ;
				
				String insertleaverespnse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domaintext+"");
				
				 array1 = gdata.parseFromJSONResponse(insertleaverespnse);
				System.out.println(array1);
				 j=0;
				 String leavid = array1.get(j+23);
					System.out.println(leavid);
					
					String updateleaverespnse= gdata1.getContenxtWeb(BaseUrl+"/api/ApplyLeave/UpdateLeave?LeaveDetailsId="+leavid+"&fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&Domain="+domaintext+"");
					 assertTrue(updateleaverespnse.equalsIgnoreCase("200")||updateleaverespnse.equalsIgnoreCase("201"));
					

			 }
				 
		 

				 break;
				 
				 
		 case "GetEmpLeaveData/GetLeaveDetailsByLeaveID" :  //get leave details by leave id
			 
			 
			 
			 array=null;
			   leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
			  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
			
			 
			 for(i=1;i<array.size();i++)
				 
			 {
				String leavetypeid= array.get(i) ;
				
				String insertleaverespnse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domaintext+"");
				
				 array1 = gdata.parseFromJSONResponse(insertleaverespnse);
				System.out.println(array1);
				 j=0;
				 String leavid = array1.get(j+23);
				 String leaveitemid= array1.get(j+24);
					System.out.println(leavid);
					
					String leavedetailsresponse= gdata1.getContenxtWeb(BaseUrl+"/api/GetEmpLeaveData/GetLeaveDetailsByLeaveID?LeaveMasterId="+leavid+""
							+ "&LeaveId="+leaveitemid+"&Domain="+domaintext+"");
					 assertTrue(leavedetailsresponse.equalsIgnoreCase("200")||leavedetailsresponse.equalsIgnoreCase("201"));
					

			 }
			 
			 break;
			 
			 
		 case "GetEmpLeaveData/DeleteLeave" :  //delete leave
			 array=null;
			   leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
			  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
			
			 
			 for(i=1;i<array.size();i++)
				 
			 {
				String leavetypeid= array.get(i) ;
				
				String insertleaverespnse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domaintext+"");
				
				 array1 = gdata.parseFromJSONResponse(insertleaverespnse);
				
				 j=0;
				 String leavid = array1.get(j+23);
				 String leaveitemid= array1.get(j+24);
					System.out.println(leavid);
					
					String deleteleaveresponse= gdata1.getContenxtWeb(BaseUrl+"/api/GetEmpLeaveData/DeleteLeave?LeaveId="+leavid+"&Domain="+domaintext+"");
					 assertTrue(deleteleaveresponse.equalsIgnoreCase("200")||deleteleaveresponse.equalsIgnoreCase("201"));
					

			 }
			 
			 break;
			 
			 
		 case "LeaveProcessing/SubmitLeave" :  //submit leave
			 
			 array=null;
			   leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
			  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
			
			 
			 for(i=1;i<array.size();i++)
				 
			 {
				String leavetypeid= array.get(i) ;
				
				String insertleaverespnse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domaintext+"");
				
				 array1 = gdata.parseFromJSONResponse(insertleaverespnse);
				
				 j=0;
				 String leavid = array1.get(j+23);
			
					System.out.println(leavid);
					
					String submitleaveresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/SubmitLeave?LeaveId="+leavid+"&Domain="+domaintext+"");
					 assertTrue(submitleaveresponse.equalsIgnoreCase("200")||submitleaveresponse.equalsIgnoreCase("201"));
					 
					 
					

			 }
			 
			 break;
			 
			 
 case "GetEmpLeaveData/GetEmpAppliedLeaves" :  //get employee applied leaves

			 
			 array=null;
			   leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
			  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
			
			 
			 for(i=1;i<array.size();i++)
				 
			 {
				String leavetypeid= array.get(i) ;
				
				String insertleaverespnse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domaintext+"");
				
				 array1 = gdata.parseFromJSONResponse(insertleaverespnse);
				
				 j=0;
				 String leavid = array1.get(j+23);
				// String leaveitemid= array1.get(j+24);
					System.out.println(leavid);
					
					String submitleaveresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/SubmitLeave?LeaveId="+leavid+"&Domain="+domaintext+"");
					
					 
					 String appliadleaveresponse= gdata1.getContenxtWeb(BaseUrl+"/api/GetEmpLeaveData/GetEmpAppliedLeaves?EmpId="+empdata+""
					 		+ "&IsSubmit=1&month="+current.get(Calendar.MONTH)+"&year="+current.get(Calendar.YEAR)+"&LeaveId="+leavid+"&Domain="+domaintext+"");
					 assertTrue(appliadleaveresponse.equalsIgnoreCase("200")||appliadleaveresponse.equalsIgnoreCase("201"));
					

			 }
			
			 
			 break;
			 
 case "LeaveProcessing/GetApproverLeaves" :  //Get approve list

	  managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
		
		
		 arraymanager = gdata.parseFromJSONResponse(managerresponse);
		 
		 
		  k=0;

		
		 managerdata=arraymanager.get(k+2);

	 
	 array=null;
	   leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
	  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
	
	 
	 for(i=1;i<array.size();i++)
		 
	 {
		String leavetypeid= array.get(i) ;
		
		String insertleaverespnse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domaintext+"");
		
		 array1 = gdata.parseFromJSONResponse(insertleaverespnse);
		
		 j=0;
		 String leavid = array1.get(j+23);
		// String leaveitemid= array1.get(j+24);
			System.out.println(leavid);
			
			String submitleaveresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/SubmitLeave?LeaveId="+leavid+"&Domain="+domaintext+"");
			
			 System.out.println(BaseUrl+"/api/GetEmpLeaveData/GetEmpAppliedLeaves?EmpId="+empdata+""
				 		+ "&IsSubmit=1&month="+current.get(Calendar.MONTH)+"&year="+current.get(Calendar.YEAR)+"&LeaveId="+leavid+"&Domain="+domaintext+"");
			 
			

	 }
	
	 String approveleavelistresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/GetApproverLeaves?ApproverId="+managerdata+""
	 		+ "&status=pending&month="+current.get(Calendar.MONTH)+"&year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
		 assertTrue(approveleavelistresponse.equalsIgnoreCase("200")||approveleavelistresponse.equalsIgnoreCase("201"));
	 
	 break;
	 
 case "LeaveProcessing/ApproveDisapproveLeave" :  //approve leave

	  managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
		
		
		 arraymanager = gdata.parseFromJSONResponse(managerresponse);
		 
		
		  k=0;

		
		 managerdata=arraymanager.get(k+2);

	 
	 array=null;
	   leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
	  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
	 System.out.println("array is"+array);
	 
	 for(i=1;i<array.size();i++)
		 
	 {
		String leavetypeid= array.get(i) ;
		
		String insertleaverespnse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domaintext+"");
		
		 array1 = gdata.parseFromJSONResponse(insertleaverespnse);
		System.out.println(array1);
		 j=0;
		 String leavid = array1.get(j+23);
		// String leaveitemid= array1.get(j+24);
			System.out.println(leavid);
			
			String submitleaveresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/SubmitLeave?LeaveId="+leavid+"&Domain="+domaintext+"");
			
			 String approveleavetresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/ApproveDisapproveLeave?LeaveId="+leavid+"&ReccId="+managerdata+""
			 		+ "&Remarks=test&Action=1&Domain="+domaintext+"");
					 assertTrue(approveleavetresponse.equalsIgnoreCase("200")||approveleavetresponse.equalsIgnoreCase("201"));
			

	 }
	
	
	 
	 break;
	 
 case "LeaveProcessing/ReopenLeave" :  //disapprove leave

	  managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
		
		
		 arraymanager = gdata.parseFromJSONResponse(managerresponse);
		 
		
		  k=0;

		
		 managerdata=arraymanager.get(k+2);

	 
	 array=null;
	   leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
	  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
	 System.out.println("array is"+array);
	 
	 for(i=1;i<array.size();i++)
		 
	 {
		String leavetypeid= array.get(i) ;
		
		String insertleaverespnse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domaintext+"");
		
		 array1 = gdata.parseFromJSONResponse(insertleaverespnse);
		
		 j=0;
		 String leavid = array1.get(j+23);
			System.out.println(leavid);
			
			String submitleaveresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/SubmitLeave?LeaveId="+leavid+"&Domain="+domaintext+"");
			
			 System.out.println(BaseUrl+"/api/GetEmpLeaveData/GetEmpAppliedLeaves?EmpId="+empdata+""
				 		+ "&IsSubmit=1&month="+current.get(Calendar.MONTH)+"&year="+current.get(Calendar.YEAR)+"&LeaveId="+leavid+"&Domain="+domaintext+"");
			 String approveleavetresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/ApproveDisapproveLeave?LeaveId="+leavid+"&ReccId="+managerdata+""
			 		+ "&Remarks=test&Action=0&Domain="+domaintext+"");
					
			
					 String reopenleavetresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/ReopenLeave?LeaveId="+leavid+"&NoOfLeaves=5&Domain="+domaintext+"");
								 assertTrue(reopenleavetresponse.equalsIgnoreCase("200")||reopenleavetresponse.equalsIgnoreCase("201"));
	 }
	
	
	 
	 break;
			
			
				 
 case "LeaveStatus/LeaveStatus" :  //submit leave
	 
	 array=null;
	   leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
	  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
	 System.out.println("array is"+array);
	 
	 for(i=1;i<array.size();i++)
		 
	 {
		String leavetypeid= array.get(i) ;
		
		String insertleaverespnse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/InsertLeave?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Location=test&LeaveType="+leavetypeid+"&Reason=Sick%20Leave&NoOfLeaves=5&EmpID="+empdata+"&Domain="+domaintext+"");
		
		 array1 = gdata.parseFromJSONResponse(insertleaverespnse);
		
		 j=0;
		 String leavid = array1.get(j+23);
		// String leaveitemid= array1.get(j+24);
			System.out.println(leavid);
			
			String submitleaveresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveProcessing/SubmitLeave?LeaveId="+leavid+"&Domain="+domaintext+"");
			
			
			 
			 String statusleaveresponse= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveStatus/LeaveStatus?LeaveMasterId="+leavid+"&Domain="+domaintext+"");
			 assertTrue(statusleaveresponse.equalsIgnoreCase("200")||statusleaveresponse.equalsIgnoreCase("201"));
			

	 }
	 
	 break;
		
				 
 case "FoodClaim/GetFoodType1" :    //Get food types    /api/FoodClaim/GetFoodType?domain=gdata

		
		
String Logincode = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?domain="+domaintext+"");

assertTrue(Logincode.equalsIgnoreCase("200")||Logincode.equalsIgnoreCase("201"));
break;	


 case "FoodPolicy/GetBandWisePolicy1" :    //Food Policy    /api/FoodPolicy/GetBandWisePolicy?Band=522&foodPlace=683&Domain=gdata
	
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
	 array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 System.out.println(array1);
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
		
 String foodclaimresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?domain="+domaintext+"");
 ArrayList<String> fieldstatusarray = gdata.parseFromJSONarrayResponse(foodclaimresponse);
 int arrayln= fieldstatusarray.size();

 String foodtypeid="";
 for(int fsize=0;fsize<fieldstatusarray.size();fsize++)
	{
		
		
		
	  foodtypeid=fieldstatusarray.get(fsize);
		System.out.println("food type Id is ->>>>>>>>"+foodtypeid);
		 String status= fieldstatusarray.get(fsize+1);
		System.out.println("status is  ->>>>>>>>"+status);
		fsize=fsize+1;
		if(status.equalsIgnoreCase("True"))
		{
			 
			
			fsize=fieldstatusarray.size();
			
			
		}
	}


String statusfoodbandresponse= gdata1.getContenxtWeb(BaseUrl+"/api/FoodPolicy/GetBandWisePolicy?Band="+bandid+"&foodPlace="+foodtypeid+"&domain="+domaintext+"");
assertTrue(statusfoodbandresponse.equalsIgnoreCase("200")||statusfoodbandresponse.equalsIgnoreCase("201"));
break;	
				 
			 
 case "RedChillies/GetShifts" :   //Get shift types
	 
	 String shiftscodes= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
		 assertTrue(shiftscodes.equalsIgnoreCase("200")||shiftscodes.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "RedChillies/GetFoodType" :   //Get food types
	 
	 String foodtypecode= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
		 assertTrue(foodtypecode.equalsIgnoreCase("200")||foodtypecode.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "RedChillies/GetEmpPunchingDetails" :   //Get emp punching details
	 String getemppunchingcode= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetEmpPunchingDetails?empid="+empdata+"&date="+dtf.format(localDate)+"&Domain="+domaintext+"");
		 assertTrue(getemppunchingcode.equalsIgnoreCase("200")||getemppunchingcode.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "RedChillies/getCoempClaimDate" :   //Get emp punching details
	 String getcoempdatecode= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/getCoempClaimDate?empid="+empdata+"&date="+dtf.format(localDate)+"&Domain="+domaintext+"");
		 assertTrue(getcoempdatecode.equalsIgnoreCase("200")||getcoempdatecode.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "RedChillies/InsertArtistClaim" :   //insert artist food 
	
	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+""); 
	array1 = gdata.parseFromJSONResponse(userresponse);
	 
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 managerdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  System.out.println(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	  String shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	  ArrayList<String> shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	  System.out.println("New array"+shiftarray);
	   arrayln= shiftarray.size();
	  System.out.println(arrayln);
	  
	  
	  String shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		
		  shiftid=shiftarray.get(fsize);
	 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	 
	  String foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
	  
	
	  ArrayList<String> foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
	
	   arrayln= foodtypearray.size();
	  System.out.println(arrayln);
	  
	  
	  String artistfoodtypeid="";
	  for(int fsize=0;fsize<foodtypearray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  artistfoodtypeid=foodtypearray.get(fsize+1);
	 		 String foodtypename= foodtypearray.get(fsize+2);
	 		fsize=fsize+2;
	 		if(foodtypename.equalsIgnoreCase("Dinner"))
	 		{
	 			 
	 			
	 			fsize=foodtypearray.size();
	 			
	 			
	 		}
	 	}
	   wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
	 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
		 wbscount=0;
		 wbsdata=wbsarray.get(wbscount+1);
	  
	  DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate localDate1 = LocalDate.now();
			 System.out.println(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
				 		+ "claimdate="+dtf.format(localDate)+""
				 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
				 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
	 String insertfoodcode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
	 		+ "claimdate="+dtf.format(localDate)+""
	 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
	 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
	
		  ArrayList<String> foodclaimarray = gdata.parseFromJSONarrayResponse(insertfoodcode);
		  
		   arrayln= foodclaimarray.size();
		   i=0;
		   String artistclaimid= foodclaimarray.get(i);
		 
		 System.out.println(artistclaimid);
//		 String deletefoodresponse = gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/deleteClaimById?Domain="+domaintext+"&claimid="+artistclaimid+"");
		 String deletefoodresponse="";
//		 assertTrue(deletefoodresponse.equalsIgnoreCase("200")||deletefoodresponse.equalsIgnoreCase("201"));
	 break;	
	 
	 
case "RedChillies/getClaimById" :   //insert artist food 
	
	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+""); 
	array1 = gdata.parseFromJSONResponse(userresponse);
	 
	
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 managerdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	   shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	 
	   arrayln= shiftarray.size();
	  System.out.println(arrayln);
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  shiftid=shiftarray.get(fsize);
	 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	 
	   foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
	  
	
	   foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
	 
	   arrayln= foodtypearray.size();
	  System.out.println(arrayln);
	  
	  
	   artistfoodtypeid="";
	  for(int fsize=0;fsize<foodtypearray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  artistfoodtypeid=foodtypearray.get(fsize+1);
	 		System.out.println("food type Id is ->>>>>>>>"+artistfoodtypeid);
	 		 String foodtypename= foodtypearray.get(fsize+2);
	 		System.out.println("status is  ->>>>>>>>"+foodtypename);
	 		fsize=fsize+2;
	 		if(foodtypename.equalsIgnoreCase("Dinner"))
	 		{
	 			 
	 			
	 			fsize=foodtypearray.size();
	 			
	 			
	 		}
	 	}
	   dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 localDate1 = LocalDate.now();
		 
		    wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
	  
	  insertfoodcode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
		 		+ "claimdate="+dtf.format(localDate)+""
		 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
		 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
	  foodclaimarray = gdata.parseFromJSONarrayResponse(insertfoodcode);
	
	   arrayln= foodclaimarray.size();
	   i=0;
	    artistclaimid= foodclaimarray.get(i);
	   
	   String getatistfoodifcode= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/getClaimById?Domain="+domaintext+"&claimid="+artistclaimid+"");
			 assertTrue(getatistfoodifcode.equalsIgnoreCase("200")||getatistfoodifcode.equalsIgnoreCase("201"));
			 
			  deletefoodresponse = gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/deleteClaimById?Domain="+domaintext+"&claimid="+artistclaimid+"");
			 
			 assertTrue(deletefoodresponse.equalsIgnoreCase("200")||deletefoodresponse.equalsIgnoreCase("201"));
	 break;	
			 
case "RedChillies/GetFoodClaimStatusDetails" :   //get month year wise food claim detaills      "+(current.get(Calendar.MONTH))+1+"&Year="+current.get(Calendar.YEAR)+"
	 String foodclaimstatuscode= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodClaimStatusDetails?domain="+domaintext+"&empId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"");
		 assertTrue(foodclaimstatuscode.equalsIgnoreCase("200")||foodclaimstatuscode.equalsIgnoreCase("201"));
	 
	 break;	
	 
	 
case "RedChillies/deleteClaimById" :   //delete artist food 
	
	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+""); 
	array1 = gdata.parseFromJSONResponse(userresponse);
	 
	
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 managerdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	   shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);

	   arrayln= shiftarray.size();
	 
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  shiftid=shiftarray.get(fsize);
	 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	 
	   foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
	  
	
	   foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
	
	   arrayln= foodtypearray.size();
	  System.out.println(arrayln);
	  
	  
	   artistfoodtypeid="";
	  for(int fsize=0;fsize<foodtypearray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		
		  artistfoodtypeid=foodtypearray.get(fsize+1);
	 		System.out.println("food type Id is ->>>>>>>>"+artistfoodtypeid);
	 		 String foodtypename= foodtypearray.get(fsize+2);
	 		System.out.println("status is  ->>>>>>>>"+foodtypename);
	 		fsize=fsize+2;
	 		if(foodtypename.equalsIgnoreCase("Dinner"))
	 		{
	 			 
	 			
	 			fsize=foodtypearray.size();
	 			
	 			
	 		}
	 	}
	  
	   dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			 localDate1 = LocalDate.now();
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
	  
	 
	  insertfoodcode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
		 		+ "claimdate="+dtf.format(localDate)+""
		 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
		 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
		   foodclaimarray = gdata.parseFromJSONarrayResponse(insertfoodcode);
		
		   arrayln= foodclaimarray.size();
		   i=0;
		    artistclaimid= foodclaimarray.get(i);
		 
		 
		  deletefoodresponse = gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/deleteClaimById?Domain="+domaintext+"&claimid="+artistclaimid+"");
		 
		 assertTrue(deletefoodresponse.equalsIgnoreCase("200")||deletefoodresponse.equalsIgnoreCase("201"));
	 break;	
	 
case "RedChillies/getClaimStatus" :   //get claim status by claim id
      
	 String getclaimstatus= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/getClaimStatus?Domain="+domaintext+"&empid="+empdata+"&claimtypeid=12");
		 assertTrue(getclaimstatus.equalsIgnoreCase("200")||getclaimstatus.equalsIgnoreCase("201"));
	 
	 break;	
	 
	 
case "RedChillies/GetShiftById" :   //get shift details by id

    
	shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	 
	   arrayln= shiftarray.size();
	  System.out.println(arrayln);
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 	
	 		
		  shiftid=shiftarray.get(fsize);
	 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	 String getshiftbyiscode= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShiftById?Domain="+domaintext+"&Shiftid="+shiftid+"");
		 assertTrue(getshiftbyiscode.equalsIgnoreCase("200")||getshiftbyiscode.equalsIgnoreCase("201"));
	 
	 break;
	 
case "RedChillies/GetAllClaimStatus" :   //get all claim status

    
	 String getallclaimstatus= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetAllClaimStatus?Domain="+domaintext+"&empid="+empdata+"");
		 assertTrue(getallclaimstatus.equalsIgnoreCase("200")||getallclaimstatus.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "RedChillies/GetAllClaimStatusConditionWise" :   //get food claim status
	 foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
	  
		
	   foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
	  
	   arrayln= foodtypearray.size();
	  System.out.println(arrayln);
	  
	  
	   artistfoodtypeid="";
	  for(int fsize=0;fsize<foodtypearray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  artistfoodtypeid=foodtypearray.get(fsize+1);
	 		System.out.println("food type Id is ->>>>>>>>"+artistfoodtypeid);
	 		 String foodtypename= foodtypearray.get(fsize+2);
	 		System.out.println("status is  ->>>>>>>>"+foodtypename);
	 		fsize=fsize+2;
	 		if(foodtypename.equalsIgnoreCase("Dinner"))
	 		{
	 			 
	 			
	 			fsize=foodtypearray.size();
	 			
	 			
	 		}
	 	}
    
	
	 String GetAllClaimStatusConditionWisestatus= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetAllClaimStatusConditionWise?Domain="+domaintext+"&empid="+empdata+""
	 		+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&claimstatus=pending");
		 assertTrue(GetAllClaimStatusConditionWisestatus.equalsIgnoreCase("200")||GetAllClaimStatusConditionWisestatus.equalsIgnoreCase("201"));
		 
		
	 
	 break;	
	 
	 
case "RedChillies/GetFoodWiseClaimStatus" :   //get food wise claim status

	 foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
	  
		
	   foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
	  
	   arrayln= foodtypearray.size();
	  System.out.println(arrayln);
	  
	  
	   artistfoodtypeid="";
	  for(int fsize=0;fsize<foodtypearray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  artistfoodtypeid=foodtypearray.get(fsize+1);
	 		System.out.println("food type Id is ->>>>>>>>"+artistfoodtypeid);
	 		 String foodtypename= foodtypearray.get(fsize+2);
	 		System.out.println("status is  ->>>>>>>>"+foodtypename);
	 		fsize=fsize+2;
	 		if(foodtypename.equalsIgnoreCase("Dinner"))
	 		{
	 			 
	 			
	 			fsize=foodtypearray.size();
	 			
	 			
	 		}
	 	}
   
	
	 String GetFoodWiseClaimStatus= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodWiseClaimStatus?Domain="+domaintext+"&empid="+empdata+"&claimtypeid=12&foodtypeid="+artistfoodtypeid+"");
		 assertTrue(GetFoodWiseClaimStatus.equalsIgnoreCase("200")||GetFoodWiseClaimStatus.equalsIgnoreCase("201"));
		 
		
	 
	 break;	
	 
case "RedChillies/GetAllClaimRejectedStatus" :   //get claims rejected status


    
	
	 String GetAllClaimRejectedStatus= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetAllClaimRejectedStatus?Domain="+domaintext+"&empid="+empdata+"");
		 assertTrue(GetAllClaimRejectedStatus.equalsIgnoreCase("200")||GetAllClaimRejectedStatus.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "RedChillies/GetEmpPendingClaimStatus" :   //get employee pending claim status

	
	 String GetEmpPendingClaimStatus= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetEmpPendingClaimStatus?Domain="+domaintext+"&empid="+empdata+"");
		 assertTrue(GetEmpPendingClaimStatus.equalsIgnoreCase("200")||GetEmpPendingClaimStatus.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "RedChillies/GetClaimCoditionWise" :   //get pending, approved, rejected claim status
	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+""); 
	array1 = gdata.parseFromJSONResponse(userresponse);
	 
	
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 managerdata=array1.get(i+2);
	
	 String GetClaimCoditionWise= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetClaimCoditionWise?Domain="+domaintext+"&empid="+empdata+"&claimstatus=pending&coempid="+managerdata+"&fromdate=&todate=");
		 assertTrue(GetClaimCoditionWise.equalsIgnoreCase("200")||GetClaimCoditionWise.equalsIgnoreCase("201"));
	 
	 break;	
	 
	 
case "RedChillies/UpdateArtistClaim" :   //update artist claim
	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+""); 
	array1 = gdata.parseFromJSONResponse(userresponse);
	 
	
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 managerdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	
	   shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	 
	   arrayln= shiftarray.size();
	  System.out.println(arrayln);
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		
	 		
		  shiftid=shiftarray.get(fsize);
	 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	 
	
	   foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
	  
	
	   foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
	
	   arrayln= foodtypearray.size();
	  System.out.println(arrayln);
	  
	  
	   artistfoodtypeid="";
	  for(int fsize=0;fsize<foodtypearray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  artistfoodtypeid=foodtypearray.get(fsize+1);
	 		System.out.println("food type Id is ->>>>>>>>"+artistfoodtypeid);
	 		 String foodtypename= foodtypearray.get(fsize+2);
	 		System.out.println("status is  ->>>>>>>>"+foodtypename);
	 		fsize=fsize+2;
	 		if(foodtypename.equalsIgnoreCase("Dinner"))
	 		{
	 			 
	 			
	 			fsize=foodtypearray.size();
	 			
	 			
	 		}
	 	}
	  
	   dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			 localDate1 = LocalDate.now();
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
	  
	  
	  insertfoodcode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
		 		+ "claimdate="+dtf.format(localDate)+""
		 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
		 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
		   foodclaimarray = gdata.parseFromJSONarrayResponse(insertfoodcode);
		 
		   arrayln= foodclaimarray.size();
		   i=0;
		    artistclaimid= foodclaimarray.get(i);
		   
		    String UpdateArtistClaim= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/UpdateArtistClaim?Domain="+domaintext+"&empid="+empdata+""
		    		+ "&coempid="+managerdata+",&claimdate="+dtf1.format(localDate1)+"&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
		    				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&claimid="+artistclaimid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
			 assertTrue(UpdateArtistClaim.equalsIgnoreCase("200")||UpdateArtistClaim.equalsIgnoreCase("201"));
			 
			 
			 deletefoodresponse = gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/deleteClaimById?Domain="+domaintext+"&claimid="+artistclaimid+"");
			 
			 assertTrue(deletefoodresponse.equalsIgnoreCase("200")||deletefoodresponse.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "RedChillies/DisapproveClaim" :   //disapprove claim

	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+""); 
	array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 System.out.println(array1);
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 managerdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  System.out.println(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	
	   arrayln= shiftarray.size();
	  System.out.println(arrayln);
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  shiftid=shiftarray.get(fsize);
	 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	 
	  
	   foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
	  
	
	   foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
	 
	   arrayln= foodtypearray.size();
	  System.out.println(arrayln);
	  
	  
	   artistfoodtypeid="";
	  for(int fsize=0;fsize<foodtypearray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  artistfoodtypeid=foodtypearray.get(fsize+1);
	 		System.out.println("food type Id is ->>>>>>>>"+artistfoodtypeid);
	 		 String foodtypename= foodtypearray.get(fsize+2);
	 		System.out.println("status is  ->>>>>>>>"+foodtypename);
	 		fsize=fsize+2;
	 		if(foodtypename.equalsIgnoreCase("Dinner"))
	 		{
	 			 
	 			
	 			fsize=foodtypearray.size();
	 			
	 			
	 		}
	 	}
	  
	   dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			 localDate1 = LocalDate.now();
	  
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
	  
	 
	  insertfoodcode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
		 		+ "claimdate="+dtf.format(localDate)+""
		 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
		 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
		   foodclaimarray = gdata.parseFromJSONarrayResponse(insertfoodcode);
		  
		   arrayln= foodclaimarray.size();
		   i=0;
		    artistclaimid= foodclaimarray.get(i);
	
	 String DisapproveClaim= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/DisapproveClaim?Domain="+domaintext+"&claimid="+artistclaimid+"&empid="+empdata+"");
		 assertTrue(DisapproveClaim.equalsIgnoreCase("200")||DisapproveClaim.equalsIgnoreCase("201"));
		 
		 deletefoodresponse = gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/deleteClaimById?Domain="+domaintext+"&claimid="+artistclaimid+"");
		 
		 assertTrue(deletefoodresponse.equalsIgnoreCase("200")||deletefoodresponse.equalsIgnoreCase("201"));
	 
	 break;	
	 
	 
case "RedChillies/ReopenClaim" :   //reopen claim


	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+""); 
	array1 = gdata.parseFromJSONResponse(userresponse);
	 
	
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 managerdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	
	   shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	  
	   arrayln= shiftarray.size();
	  System.out.println(arrayln);
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  shiftid=shiftarray.get(fsize);
	 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	 
	
	   foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
	  
	
	   foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
	
	   arrayln= foodtypearray.size();
	  System.out.println(arrayln);
	  
	  
	   artistfoodtypeid="";
	  for(int fsize=0;fsize<foodtypearray.size();fsize++)
	 	{
	 		
	 		
	 		
		  artistfoodtypeid=foodtypearray.get(fsize+1);
	 		System.out.println("food type Id is ->>>>>>>>"+artistfoodtypeid);
	 		 String foodtypename= foodtypearray.get(fsize+2);
	 		System.out.println("status is  ->>>>>>>>"+foodtypename);
	 		fsize=fsize+2;
	 		if(foodtypename.equalsIgnoreCase("Dinner"))
	 		{
	 			 
	 			
	 			fsize=foodtypearray.size();
	 			
	 			
	 		}
	 	}
	  
	   dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			 localDate1 = LocalDate.now();
	  
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
	  
	 
	  insertfoodcode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
		 		+ "claimdate="+dtf.format(localDate)+""
		 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
		 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
		   foodclaimarray = gdata.parseFromJSONarrayResponse(insertfoodcode);
		
		   arrayln= foodclaimarray.size();
		   i=0;
		    artistclaimid= foodclaimarray.get(i);
	
	  DisapproveClaim= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/DisapproveClaim?Domain="+domaintext+"&claimid="+artistclaimid+"&empid="+managerdata+"");
		 assertTrue(DisapproveClaim.equalsIgnoreCase("200")||DisapproveClaim.equalsIgnoreCase("201"));
		 
		 System.out.println(BaseUrl+"/api/RedChillies/ReopenClaim?Domain="+domaintext+"&empid="+empdata+"&claimid="+artistclaimid+"");
String ReopenClaimstatus = gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/ReopenClaim?Domain="+domaintext+"&empid="+empdata+"&claimid="+artistclaimid+"");
		 
		 assertTrue(ReopenClaimstatus.equalsIgnoreCase("200")||ReopenClaimstatus.equalsIgnoreCase("201"));
		 
		 deletefoodresponse = gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/deleteClaimById?Domain="+domaintext+"&claimid="+artistclaimid+"");
		 
		 assertTrue(deletefoodresponse.equalsIgnoreCase("200")||deletefoodresponse.equalsIgnoreCase("201"));
	 
	 break;	
	 
	 
case "RedChillies/ApproveClaim" :   //approve claim


	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+""); 
	array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 System.out.println(array1);
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 managerdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	 
	   shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	 
	   arrayln= shiftarray.size();
	  System.out.println(arrayln);
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  shiftid=shiftarray.get(fsize);
	 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	 
	
	   foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
	  
	
	   foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
	 
	   arrayln= foodtypearray.size();
	  System.out.println(arrayln);
	  
	  
	   artistfoodtypeid="";
	  for(int fsize=0;fsize<foodtypearray.size();fsize++)
	 	{
	 		
	 		
	 		
		  artistfoodtypeid=foodtypearray.get(fsize+1);
	 		System.out.println("food type Id is ->>>>>>>>"+artistfoodtypeid);
	 		 String foodtypename= foodtypearray.get(fsize+2);
	 		System.out.println("status is  ->>>>>>>>"+foodtypename);
	 		fsize=fsize+2;
	 		if(foodtypename.equalsIgnoreCase("Dinner"))
	 		{
	 			 
	 			
	 			fsize=foodtypearray.size();
	 			
	 			
	 		}
	 	}
	  
	   dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			 localDate1 = LocalDate.now();
	  
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
	  
	 
	  insertfoodcode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
		 		+ "claimdate="+dtf.format(localDate)+""
		 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
		 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
		   foodclaimarray = gdata.parseFromJSONarrayResponse(insertfoodcode);
		 
		   arrayln= foodclaimarray.size();
		   i=0;
		    artistclaimid= foodclaimarray.get(i);

	 String ApproveClaim= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/ApproveClaim?Domain="+domaintext+"&claimid="+artistclaimid+"&empid="+managerdata+"");
		 assertTrue(ApproveClaim.equalsIgnoreCase("200")||ApproveClaim.equalsIgnoreCase("201"));
		 
		 deletefoodresponse = gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/deleteClaimById?Domain="+domaintext+"&claimid="+artistclaimid+"");
		 
		 assertTrue(deletefoodresponse.equalsIgnoreCase("200")||deletefoodresponse.equalsIgnoreCase("201"));
	 
	 break;
	 
case "RedChillies/GetCOEmployeeByClaim" :   //get claim id wise claim co-employees


	userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+""); 
	array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 System.out.println(array1);
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 managerdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	 
	   shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	 
	   arrayln= shiftarray.size();
	 
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
		  shiftid=shiftarray.get(fsize);
	 		
	 		 String shiftname= shiftarray.get(fsize+1);
	 		
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	 
	 
	   foodtyperesponsecode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetFoodType?Domain="+domaintext+"");
	  
	
	   foodtypearray = gdata.parseFromJSONarrayResponse(foodtyperesponsecode);
	 
	   arrayln= foodtypearray.size();
	  System.out.println(arrayln);
	  
	  
	   artistfoodtypeid="";
	  for(int fsize=0;fsize<foodtypearray.size();fsize++)
	 	{
	 		
	 	
	 		
		  artistfoodtypeid=foodtypearray.get(fsize+1);
	 	
	 		 String foodtypename= foodtypearray.get(fsize+2);
	 	
	 		fsize=fsize+2;
	 		if(foodtypename.equalsIgnoreCase("Dinner"))
	 		{
	 			 
	 			
	 			fsize=foodtypearray.size();
	 			
	 			
	 		}
	 	}
	  
	   dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			 localDate1 = LocalDate.now();
	  
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
				
				 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
	  
	
	  insertfoodcode= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/InsertArtistClaim?Domain="+domaintext+"&empid="+empdata+"&coempid="+managerdata+",&"
		 		+ "claimdate="+dtf.format(localDate)+""
		 		+ "&shiftid="+shiftid+"&amount=20&voucher=test&claimstatus=pending"
		 				+ "&claimtypeid=12&foodtypeid="+artistfoodtypeid+"&Remarks=test&WBS="+wbsdata+"&BillAmt=500");
		   foodclaimarray = gdata.parseFromJSONarrayResponse(insertfoodcode);
		 
		   arrayln= foodclaimarray.size();
		   i=0;
		    artistclaimid= foodclaimarray.get(i);
	 String GetCOEmployeeByClaim= gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/GetCOEmployeeByClaim?Domain="+domaintext+"&claimid="+artistclaimid+"");
		 assertTrue(GetCOEmployeeByClaim.equalsIgnoreCase("200")||GetCOEmployeeByClaim.equalsIgnoreCase("201"));
		 
		 deletefoodresponse = gdata1.getContenxtWeb(BaseUrl+"/api/RedChillies/deleteClaimById?Domain="+domaintext+"&claimid="+artistclaimid+"");
		 
		 assertTrue(deletefoodresponse.equalsIgnoreCase("200")||deletefoodresponse.equalsIgnoreCase("201"));
	 
	 break;
	 
case "TravelClaim/AllowOvertimeToTravelClaim" :   //check overtime policy for travel claim

	 
	 String AllowOvertimeToTravelClaim= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/AllowOvertimeToTravelClaim?EmpId="+empdata+"&Date="+dtf.format(localDate)+""
	 		+ "&Domain="+domaintext+"");
		 assertTrue(AllowOvertimeToTravelClaim.equalsIgnoreCase("200")||AllowOvertimeToTravelClaim.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "FieldMaster/GetFieldMaster" :   //Show hide fields on apply claim

	
	 String GetFieldMaster= gdata1.getContenxtWeb(BaseUrl+"/api/FieldMaster/GetFieldMaster?intClaimType=11&vcModule=Apply&Domain="+domaintext+"");
		 assertTrue(GetFieldMaster.equalsIgnoreCase("200")||GetFieldMaster.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "TravelClaim/InsertUpdateSupportTarvelClaim" :   //insert artist local
	
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	String  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");

	ArrayList<String> localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
	 int localtravelmodecount=0;
	String  localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	
	shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	   arrayln= shiftarray.size();
	  System.out.println(arrayln);
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  shiftid=shiftarray.get(fsize);
	 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	  wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
	
	 String InsertUpdateSupportTarvelClaim= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/InsertUpdateSupportTarvelClaim?empId="+empdata+""
		 		+ "&claimType=11&Date="+dtf.format(localDate)+"&intTravelWay="+localtravelmodedata+"&remarks=&shift="+shiftid+"&amount=60&voucher="
		 				+ "&Domain="+domaintext+"&WBS="+wbsdata+"");
		
	 
	 
			 foodclaimarray = gdata.parseFromJSONarrayResponse(InsertUpdateSupportTarvelClaim);
			  
			   arrayln= foodclaimarray.size();
			   i=0;
			    artistclaimid= foodclaimarray.get(i);
		 String DeleteTravelClaimDetails= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/DeleteTravelClaimDetails?claimId="+artistclaimid+"&Domain="+domaintext+"");
		 assertTrue(DeleteTravelClaimDetails.equalsIgnoreCase("200")||DeleteTravelClaimDetails.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "TravelClaim/GetSupportTravelClaimStatusDetails" :   //get travel claim status   

	
	 String GetSupportTravelClaimStatusDetails= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetSupportTravelClaimStatusDetails?"
	 		+ "empId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&domain="+domaintext+"");
		 assertTrue(GetSupportTravelClaimStatusDetails.equalsIgnoreCase("200")||GetSupportTravelClaimStatusDetails.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "TravelClaim/GetSupportTravelClaimPendingDetails" :   //get pending travel claim details 

	 String GetSupportTravelClaimPendingDetails= gdata1.getContenxtWeb(BaseUrl+"//api/TravelClaim/GetSupportTravelClaimPendingDetails?empId="+empdata+"&domain="+domaintext+"");
		 assertTrue(GetSupportTravelClaimPendingDetails.equalsIgnoreCase("200")||GetSupportTravelClaimPendingDetails.equalsIgnoreCase("201"));
	 
	 break;	
	 
case "TravelClaim/GetTravelDetailsByID" :   //get claim id wise travel claim

	
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");

	 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
	  localtravelmodecount=0;
	  localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 
	shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	 
	   arrayln= shiftarray.size();
	  System.out.println(arrayln);
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		
	 		
		  shiftid=shiftarray.get(fsize);
	 	
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	  wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
	
	  InsertUpdateSupportTarvelClaim= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/InsertUpdateSupportTarvelClaim?empId="+empdata+""
		 		+ "&claimType=11&Date="+dtf.format(localDate)+"&intTravelWay="+localtravelmodedata+"&remarks=&shift="+shiftid+"&amount=60&voucher="
		 				+ "&Domain="+domaintext+"&WBS="+wbsdata+"");
		
		 
		 
		 foodclaimarray = gdata.parseFromJSONarrayResponse(InsertUpdateSupportTarvelClaim);
		  System.out.println("New array"+foodclaimarray);
		   arrayln= foodclaimarray.size();
		   i=0;
		    artistclaimid= foodclaimarray.get(i);
		    String GetTravelDetailsByID= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetTravelDetailsByID?claimId="+artistclaimid+"&Domain="+domaintext+"");
			 assertTrue(GetTravelDetailsByID.equalsIgnoreCase("200")||GetTravelDetailsByID.equalsIgnoreCase("201"));
			  DeleteTravelClaimDetails= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/DeleteTravelClaimDetails?claimId="+artistclaimid+"&Domain="+domaintext+"");
			 assertTrue(DeleteTravelClaimDetails.equalsIgnoreCase("200")||DeleteTravelClaimDetails.equalsIgnoreCase("201"));
	 break;	
	 
case "TravelClaim/DeleteTravelClaimDetails" :   //delete travel claim

	
	
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");

	 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
	  localtravelmodecount=0;
	  localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	
	shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	 
	   arrayln= shiftarray.size();
	 
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		
	 		
	 		//String noename2=noepolicyarray1.get(1);
	 		//System.out.println("NOE name @@@@2 is ->>>."+noename2);
	 		
		  shiftid=shiftarray.get(fsize);
	 		System.out.println("food type Id is ->>>>>>>>"+shiftid);
	 		 String shiftname= shiftarray.get(fsize+1);
	 		System.out.println("status is  ->>>>>>>>"+shiftname);
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	  wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
	
	  InsertUpdateSupportTarvelClaim= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/InsertUpdateSupportTarvelClaim?empId="+empdata+""
		 		+ "&claimType=11&Date="+dtf.format(localDate)+"&intTravelWay="+localtravelmodedata+"&remarks=&shift="+shiftid+"&amount=60&voucher="
		 				+ "&Domain="+domaintext+"&WBS="+wbsdata+"");
		
		 
		 
		 foodclaimarray = gdata.parseFromJSONarrayResponse(InsertUpdateSupportTarvelClaim);
		 
		   arrayln= foodclaimarray.size();
		   i=0;
		    artistclaimid= foodclaimarray.get(i);
		     DeleteTravelClaimDetails= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/DeleteTravelClaimDetails?claimId="+artistclaimid+"&Domain="+domaintext+"");
			 assertTrue(DeleteTravelClaimDetails.equalsIgnoreCase("200")||DeleteTravelClaimDetails.equalsIgnoreCase("201"));
	 break;	
	 
case "TravelClaim/DeleteTravelClaimDocuments" :   //delete travel claim documents

	
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	 System.out.println(array1);
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");

	 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
	  localtravelmodecount=0;
	  localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	
	shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	 
	   arrayln= shiftarray.size();
	 
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 	
	 		
		  shiftid=shiftarray.get(fsize);
	 	
	 		 String shiftname= shiftarray.get(fsize+1);
	 	
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	  wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
	
	  InsertUpdateSupportTarvelClaim= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/InsertUpdateSupportTarvelClaim?empId="+empdata+""
		 		+ "&claimType=11&Date="+dtf.format(localDate)+"&intTravelWay="+localtravelmodedata+"&remarks=&shift="+shiftid+"&amount=60&voucher="
		 				+ "&Domain="+domaintext+"&WBS="+wbsdata+"");
		
		 
		 
		 foodclaimarray = gdata.parseFromJSONarrayResponse(InsertUpdateSupportTarvelClaim);
		 
		   arrayln= foodclaimarray.size();
		   i=0;
		    artistclaimid= foodclaimarray.get(i);
		    
		    String DeleteTravelClaimDocuments= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/DeleteTravelClaimDocuments?claimId="+artistclaimid+"&Domain="+domaintext+"");
			 assertTrue(DeleteTravelClaimDocuments.equalsIgnoreCase("200")||DeleteTravelClaimDocuments.equalsIgnoreCase("201"));
		     DeleteTravelClaimDetails= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/DeleteTravelClaimDetails?claimId="+artistclaimid+"&Domain="+domaintext+"");
			 assertTrue(DeleteTravelClaimDetails.equalsIgnoreCase("200")||DeleteTravelClaimDetails.equalsIgnoreCase("201"));
	 break;	
	 
case "DeleteExpenses/DeleteExpense" :   //delete expense

	
	
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);
	  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");

	 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
	  localtravelmodecount=0;
	  localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 
	shiftsresponsecodes= gdata.getContenxtWeb(BaseUrl+"/api/RedChillies/GetShifts?Domain="+domaintext+"");
	   shiftarray = gdata.parseFromJSONarrayResponse(shiftsresponsecodes);
	  
	   arrayln= shiftarray.size();
	
	  
	  
	   shiftid="";
	  for(int fsize=0;fsize<shiftarray.size();fsize++)
	 	{
	 		
	 		  shiftid=shiftarray.get(fsize);
	 		
	 		 String shiftname= shiftarray.get(fsize+1);
	 	
	 		fsize=fsize+1;
	 		if(shiftname.equalsIgnoreCase("Morning shift"))
	 		{
	 			 
	 			
	 			fsize=shiftarray.size();
	 			
	 			
	 		}
	 	}
	  wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
	
	  InsertUpdateSupportTarvelClaim= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/InsertUpdateSupportTarvelClaim?empId="+empdata+""
		 		+ "&claimType=11&Date="+dtf.format(localDate)+"&intTravelWay="+localtravelmodedata+"&remarks=&shift="+shiftid+"&amount=60&voucher="
		 				+ "&Domain="+domaintext+"&WBS="+wbsdata+"");
		
		 
		 
		 foodclaimarray = gdata.parseFromJSONarrayResponse(InsertUpdateSupportTarvelClaim);
		  System.out.println("New array"+foodclaimarray);
		   arrayln= foodclaimarray.size();
		   i=0;
		    artistclaimid= foodclaimarray.get(i);
		    String artistexpenseid= foodclaimarray.get(i+1);
		    
		    String DeleteExpense= gdata1.getContenxtWeb(BaseUrl+"/api/DeleteExpenses/DeleteExpense?mode=TravelClaim&ExpenseId="+artistexpenseid+"&ClaimId="+artistclaimid+"&Domain="+domaintext+"");
			 assertTrue(DeleteExpense.equalsIgnoreCase("200")||DeleteExpense.equalsIgnoreCase("201"));
		     DeleteTravelClaimDetails= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/DeleteTravelClaimDetails?claimId="+artistclaimid+"&Domain="+domaintext+"");
			 assertTrue(DeleteTravelClaimDetails.equalsIgnoreCase("200")||DeleteTravelClaimDetails.equalsIgnoreCase("201"));
	 break;	
	 

	 

	
case "LeaveBalance/GetEmployeeBalance" :
	  leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
	  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
	 
	 
	 for(i=1;i<array.size();i++)
		 
	 {
		String leavetypeid= array.get(i) ;
		
		String GetEmployeeBalance= gdata1.getContenxtWeb(BaseUrl+"api/LeaveBalance/GetEmployeeBalance?EmpCode="+empdata+"&LeaveType="+leavetypeid+"&domain="+domaintext+"");
		 assertTrue(GetEmployeeBalance.equalsIgnoreCase("200")||GetEmployeeBalance.equalsIgnoreCase("201"));
		 
	 }
			 break;
			 
case "LeaveBalance/GetCheckAppliedLeave" :
	String GetCheckAppliedLeave= gdata1.getContenxtWeb(BaseUrl+"api/LeaveBalance/GetCheckAppliedLeave?EmpCode="+empdata+"&fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
	 assertTrue(GetCheckAppliedLeave.equalsIgnoreCase("200")||GetCheckAppliedLeave.equalsIgnoreCase("201"));
	 break;	 
	 
	 
case "Holiday/GetHolidayList" :
	String GetHolidayList= gdata1.getContenxtWeb(BaseUrl+"/api/Holiday/GetHolidayList?year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
	 assertTrue(GetHolidayList.equalsIgnoreCase("200")||GetHolidayList.equalsIgnoreCase("201"));
	break;
	
case "Holiday/GetCountHolidaybyEMPID" :
	String GetCountHolidaybyEMPID= gdata1.getContenxtWeb(BaseUrl+"/api/Holiday/GetCountHolidaybyEMPID?EMPID=1&fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
	 assertTrue(GetCountHolidaybyEMPID.equalsIgnoreCase("200")||GetCountHolidaybyEMPID.equalsIgnoreCase("201"));
	break;
case "Holiday/GetHolidayByEmpID" :
	String GetHolidayByEmpID= gdata1.getContenxtWeb(BaseUrl+"/api/Holiday/GetHolidayByEmpID?EMPID="+empdata+"&Domain="+domaintext+"");
	 assertTrue(GetHolidayByEmpID.equalsIgnoreCase("200")||GetHolidayByEmpID.equalsIgnoreCase("201"));
	break;
case "LeavePolicy/get" :
	String LeavePolicy= gdata1.getContenxtWeb(BaseUrl+"/api/LeavePolicy/get?Domain="+domaintext+"");
	 assertTrue(LeavePolicy.equalsIgnoreCase("200")||LeavePolicy.equalsIgnoreCase("201"));
case "LeavePolicy/BalanceLaveDetails" :
	
	leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
	  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
	
	 
	 for(i=1;i<array.size();i++)
		 
	 {
		String leavetypeid= array.get(i) ;
		String BalanceLaveDetails= gdata1.getContenxtWeb(BaseUrl+"/api/LeavePolicy/BalanceLaveDetails?EmpCode="+empdata+"&year="+current.get(Calendar.YEAR)+"&leavetype="+leavetypeid+"&Domain="+domaintext+"");
		 assertTrue(BalanceLaveDetails.equalsIgnoreCase("200")||BalanceLaveDetails.equalsIgnoreCase("201"));
		 
	 }
	
	break;
case "LeavePolicy/EmpCarryFBalanceLaveDetails?" :
	leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
	  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);

	 
	 for(i=1;i<array.size();i++)
		 
	 {
		String leavetypeid= array.get(i) ;
		String EmpCarryFBalanceLaveDetails= gdata1.getContenxtWeb(BaseUrl+"/api/LeavePolicy/EmpCarryFBalanceLaveDetails?EmpCode="+empdata+"&year="+current.get(Calendar.YEAR)+"&leavetype="+leavetypeid+"&Domain="+domaintext+"");
		 assertTrue(EmpCarryFBalanceLaveDetails.equalsIgnoreCase("200")||EmpCarryFBalanceLaveDetails.equalsIgnoreCase("201"));
		 
	 }
	break;
case "LeavePolicy/CheckDuplicateLeavePolicy" :
	leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
	  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
	
	 
	 for(i=1;i<array.size();i++)
		 
	 {
		String leavetypeid= array.get(i) ;
		String EmpCarryFBalanceLaveDetails= gdata1.getContenxtWeb(BaseUrl+"/api/LeavePolicy/CheckDuplicateLeavePolicy?Leavetype="+leavetypeid+"&Domain="+domaintext+"");
		 assertTrue(EmpCarryFBalanceLaveDetails.equalsIgnoreCase("200")||EmpCarryFBalanceLaveDetails.equalsIgnoreCase("201"));
		 
	 }
	 break;
	 
case "AdvanceRequest/Get" :
	String AdvanceRequest= gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 assertTrue(AdvanceRequest.equalsIgnoreCase("200")||AdvanceRequest.equalsIgnoreCase("201"));
	break;
	
	
case "AdvanceRequest/InsertAdvance" :
	
	 AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
	 
	 String advancetype= array.get(1);
	System.out.println(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	String InsertAdvance= gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	 assertTrue(InsertAdvance.equalsIgnoreCase("200")||InsertAdvance.equalsIgnoreCase("201"));
	break;
	
case "AdvanceRequest/UpdateAdvance" :
	
	 AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
	
	  advancetype= array.get(1);
	
	 InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(InsertAdvance);
	
	  String advanceid= array.get(23);
	  
	  
	  String UpdateAdvance= gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/UpdateAdvance?LeaveDetailsId="+advanceid+"&fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
	  		+ "&Location=1&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=400.00&Domain="+domaintext+"");
		 assertTrue(UpdateAdvance.equalsIgnoreCase("200")||UpdateAdvance.equalsIgnoreCase("201")); 

	break;
	
case "GetEmpAdvanceData/GetEmpAppliedAdvance" :
	
	 AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
	
	  advancetype= array.get(1);
	
	 InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	
	  String GetEmpAppliedAdvance= gdata1.getContenxtWeb(BaseUrl+"/api/GetEmpAdvanceData/GetEmpAppliedAdvance?EmpId="+empdata+"&IsSubmit=1"
	  		+ "&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Domain="+domaintext+"");
		 assertTrue(GetEmpAppliedAdvance.equalsIgnoreCase("200")||GetEmpAppliedAdvance.equalsIgnoreCase("201"));
	  
	  
	break;
	
case "GetEmpAdvanceData/GetEmpAppliedAdvanceByStatus" :
	
	 AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
	
	  advancetype= array.get(1);
	
	 InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	 
	  String GetEmpAppliedAdvanceByStatus= gdata1.getContenxtWeb(BaseUrl+"/api/GetEmpAdvanceData/GetEmpAppliedAdvanceByStatus?EmpId="+empdata+"&IsSubmit=1"
	  		+ "&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Status=1&Domain="+domaintext+"");
		 assertTrue(GetEmpAppliedAdvanceByStatus.equalsIgnoreCase("200")||GetEmpAppliedAdvanceByStatus.equalsIgnoreCase("201"));
	  
	break;
	
	
case "GetEmpAdvanceData/GetLeaveDetailsByAdvanceID" :
	
	 AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
	
	  advancetype= array.get(1);
	
	 InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(InsertAdvance);
	
	   advanceid= array.get(23);
	 String advancemasterid= array.get(24); 
	 
	 String GetLeaveDetailsByAdvanceID= gdata1.getContenxtWeb(BaseUrl+"/api/GetEmpAdvanceData/GetLeaveDetailsByAdvanceID?LeaveMasterId="+advancemasterid+""
	 		+ "&LeaveId="+advanceid+"&Domain="+domaintext+"");
			 assertTrue(GetLeaveDetailsByAdvanceID.equalsIgnoreCase("200")||GetLeaveDetailsByAdvanceID.equalsIgnoreCase("201"));
	 
	  break;
	  
	  
case "GetEmpAdvanceData/DeleteAdvance" :
	
	 AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
	 
	  advancetype= array.get(1);
	
	 InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(InsertAdvance);
	
	   advanceid= array.get(23);
	  advancemasterid= array.get(24); 
	  String DeleteAdvance= gdata1.getContenxtWeb(BaseUrl+"/api/GetEmpAdvanceData/DeleteAdvance?LeaveId="+advanceid+"&Domain="+domaintext+"");
				 assertTrue(DeleteAdvance.equalsIgnoreCase("200")||DeleteAdvance.equalsIgnoreCase("201"));
	 break;
	 
case "AdvanceProcessing/SubmitAdvance" :
	
	 AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
	
	  advancetype= array.get(1);
	
	 InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(InsertAdvance);
	 
	   advanceid= array.get(23);
	  advancemasterid= array.get(24); 
	  String SubmitAdvance= gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceProcessing/SubmitAdvance?LeaveId="+advanceid+"&Domain="+domaintext+"");
				 assertTrue(SubmitAdvance.equalsIgnoreCase("200")||SubmitAdvance.equalsIgnoreCase("201"));
	 break;
	 
case "AdvanceProcessing/GetApproverAdvance" :
	
	 managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
		
		
	  arraymanager = gdata.parseFromJSONResponse(managerresponse);
	 
	
	  k=0;

	
	 managerdata=arraymanager.get(k+2);
	 AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
	
	  advancetype= array.get(1);
	
	 InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(InsertAdvance);
	
	   advanceid= array.get(23);
	  advancemasterid= array.get(24); 
	
	  String GetApproverAdvance= gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceProcessing/GetApproverAdvance?ApproverId="+managerdata+"&status=pending"
	  		+ "&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Domain=lechler");
				 assertTrue(GetApproverAdvance.equalsIgnoreCase("200")||GetApproverAdvance.equalsIgnoreCase("201"));
	 break;
	 
case "AdvanceProcessing/ApproveDisapproveAdvance" :
	
	 managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
		
		
	  arraymanager = gdata.parseFromJSONResponse(managerresponse);
	 
	
	  k=0;

	
	 managerdata=arraymanager.get(k+2);
	 AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
	
	  advancetype= array.get(1);
	
	 InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(InsertAdvance);
	
	   advanceid= array.get(23);
	  advancemasterid= array.get(24); 
	 
	  String ApproveDisapproveAdvance= gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceProcessing/ApproveDisapproveAdvance?LeaveId="+advanceid+"&ReccId="+managerdata+""
	  		+ "&Remarks=test&Action=1&Domain="+domaintext+"");
				 assertTrue(ApproveDisapproveAdvance.equalsIgnoreCase("200")||ApproveDisapproveAdvance.equalsIgnoreCase("201"));
	 break;
	 
	 
case "AdvanceProcessing/ReopenAdvance" :
	
	 managerresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+managerusername+"&PWD="+managerpassword+"&Domain="+domaintext+"");
		
		
	  arraymanager = gdata.parseFromJSONResponse(managerresponse);
	 
	
	  k=0;

	
	 managerdata=arraymanager.get(k+2);
	 AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
	 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
	
	  advancetype= array.get(1);
	
	 InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
			+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
	 
	 array = gdata.parseFromJSONResponse(InsertAdvance);
	
	   advanceid= array.get(23);
	  advancemasterid= array.get(24); 
	   ApproveDisapproveAdvance= gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceProcessing/ApproveDisapproveAdvance?LeaveId="+advanceid+"&ReccId="+managerdata+""
		  		+ "&Remarks=test&Action=0&Domain="+domaintext+"");
	  
	  String ReopenAdvance= gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceProcessing/ReopenAdvance?LeaveId="+advanceid+"&NoOfLeaves=200.00&Domain="+domaintext+"");
				 assertTrue(ReopenAdvance.equalsIgnoreCase("200")||ReopenAdvance.equalsIgnoreCase("201"));
	 break;
	 
	 
	 
	 
case "AdvanceProcessing/AdvanceDetailsbyID" :
	
	
	
	
	  userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
	  array1 = gdata.parseFromJSONResponse(userresponse);
	 
	
	  i=0;
	  userData=array1.get(i);
	  passData=array1.get(i+1);
	 empdata=array1.get(i+2);
	  bandid=array1.get(i+3);

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			 cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			  wbsarray = new ArrayList<String>();
			
			
			
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			System.out.println(wbsarray+"array");
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			
			
   	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
		 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
		 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
		 
			 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
			 travelmodecount=0;
			 travelmodedata=travelmodearray.get(travelmodecount+1);
   	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		 localDate = LocalDate.now();
		
			  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
			 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
			 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
			
		
			  array = gdata.parseFromJSONResponse(travelinsertresponse);
			  j=0;
			
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+8);
			  
			  String AdvanceDetailsbyID= gdata1.getContenxtWeb(BaseUrl+"/api/AdvanceProcessing/AdvanceDetailsbyID?Claimid="+ClaimId+"&Domain="+domaintext+"");
				 assertTrue(AdvanceDetailsbyID.equalsIgnoreCase("200")||AdvanceDetailsbyID.equalsIgnoreCase("201"));
	
	break;
case "Dashboard/GetMonths" :
	 //WBS master   
	     String monthresponse= gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetMonths?Domain="+domaintext+"");
	     assertTrue(monthresponse.equalsIgnoreCase("200")||monthresponse.equalsIgnoreCase("201"));
	 break;
	 
case "Dashboard/GetWeeks" :
	 //WBS master   
	     String weekresponse= gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetMonths?Domain="+domaintext+"");
	     assertTrue(weekresponse.equalsIgnoreCase("200")||weekresponse.equalsIgnoreCase("201"));
	 break;

	
	case "DragNDrop/GetInsertUpdateTravelClaim_DD" :	
	 
	 
	
		  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		
	
		  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
		  cityno=0;
		
		  citynamefromdata=cityarray1.get(cityno+1);
		  citynametodata=cityarray1.get(cityno+2);
		  wbsarray = new ArrayList<String>();
		
		
		
		 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
		 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
		System.out.println(wbsarray+"array");
		 wbscount=0;
		 wbsdata=wbsarray.get(wbscount+1);
		
		
	   travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
	 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
	 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
	 
		 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

		  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
		 travelmodecount=0;
		 travelmodedata=travelmodearray.get(travelmodecount+1);
	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	 localDate = LocalDate.now();
	System.out.println(postbaseurl+"/api/DragNDrop/GetInsertUpdateTravelClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
	 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
		
	travelinsertresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertUpdateTravelClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
		 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
		 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
		
	
		 array = gdata.parseFromJSONResponse(travelinsertresponse);
		  j=0;
		 System.out.println(array);
		  ClaimId=array.get(j+7);
		  travelexpenseid=array.get(j+8);

		  break;

	

		case "DragNDrop/UpdateTravelClaim_DD" :	
		
	 		 		 	
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
		
	 	
	 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
			 
			
				 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

				  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
				 travelmodecount=0;
				 travelmodedata=travelmodearray.get(travelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
		
			
			
				  travelinsertresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertUpdateTravelClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
				 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
				 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
				  System.out.println(travelinsertresponse);
			
				  array = gdata.parseFromJSONResponse(travelinsertresponse);
				  j=0;
			System.out.print(array);
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+8);
				  //fromdate=array.get(j+5);
			
				 
				 
				////***************Update travel claim    /api/TravelClaimView/UpdateTravelClaim?ClaimId=1&TravelClaimId=1&TravelDateFrom=2016-12-01 00:00:00.000&amount=6000.00&TravelDateTo=2016-12-01 00:00:00.000&CityFrom=1&CityTo=2&Remarks=edit&ModeOfTravel=26&WBS=26&TaxAmt=&GSTIncluded=true
			System.out.println(postbaseurl+"/api/DragNDrop/UpdateTravelClaim_DD?ClaimId="+ClaimId+"&TravelClaimId="+travelexpenseid+""
					+ "&TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&amount=6000.00&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000"
					+ "&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
			+ "&Remarks=edit&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
	            updatetravelclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/UpdateTravelClaim_DD?ClaimId="+ClaimId+"&TravelClaimId="+travelexpenseid+""
							+ "&TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&amount=6000.00&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000"
									+ "&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
							+ "&Remarks=edit&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
				 assertTrue(updatetravelclaimcode.equalsIgnoreCase("200")||updatetravelclaimcode.equalsIgnoreCase("201"));
				 break;
	case "DragNDrop/GetEmpAppliedExpenseDataTravel_DD" :	
	 	
	 		 
	 	
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
		
	 	
	 	  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
			 
			
				 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

				  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
				 travelmodecount=0;
				 travelmodedata=travelmodearray.get(travelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
		
			
			
				  travelinsertresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertUpdateTravelClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
				 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
				 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
				 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
				
				  array = gdata.parseFromJSONResponse(travelinsertresponse);
				  j=0;
			
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+8);
				  
				
				 
	          System.out.println(postbaseurl+"/api/DragNDrop/GetEmpAppliedExpenseDataTravel_DD?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
				 
				
				  viewtravelexpensecode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetEmpAppliedExpenseDataTravel_DD?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
				 assertTrue(viewtravelexpensecode.equalsIgnoreCase("200")||viewtravelexpensecode.equalsIgnoreCase("201"));
				 
				 break;

				 
	 case "DragNDrop/GetInsertLocalClaim_DD" :	
		 	
		 			 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			   cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
		  citynametodata=cityarray1.get(cityno+2);
			
	 	
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
		 
			
		  wbsarray = new ArrayList<String>();
			
			
			System.out.println();
			  wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
			  wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			
	 	
			String localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			  localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
			  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			
			
			 userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertLocalClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&travelFrom=chinchpokli"
				 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
				
			
			 ArrayList<String> localarray = gdata.parseFromJSONarrayResponse(userresponse);
			  
			
			  j=0;
			  ClaimId=localarray.get(j);
			  travelexpenseid=localarray.get(j+1);
			  //fromdate=array.get(j+5);
			
		     break;	
		     
		     
		     
	 case "DragNDrop/UpdateLocalClaim_DD" :	
		 	
		 	
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
			
			
			
			 userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertLocalClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&travelFrom=chinchpokli"
				 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
				
		
			 localarray = gdata.parseFromJSONarrayResponse(userresponse);
			  
			
			  j=0;
			  ClaimId=localarray.get(j);
			  travelexpenseid=localarray.get(j+1);
			  //fromdate=array.get(j+5);
			
			 
			//****View Local claim  /api/LocalClaimView/UpdateLocalClaim?ClaimId=10811&LocalConveyanceClaimId=6392
			// &travelDateFrom=3/8/2018&amount=2000&cityFrom=5&cityTo=5&Remarks=test&modeOfTravel=624&travelFrom=test&travelTo=test
			// &travelDateTo=2016-12-01%2000:00:00.000&WBS=1&TaxAmt=0&GSTIncluded=true&Km=6
			 
			 
         updatetravelclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/UpdateLocalClaim_DD?ClaimId="+ClaimId+"&LocalConveyanceClaimId="+travelexpenseid+""
         		+ "&travelDateFrom="+dtf.format(localDate)+"&amount=2000&cityFrom="+citynamefromdata+"&cityTo="+citynametodata+"&Remarks=test&modeOfTravel="+localtravelmodedata+"&travelFrom=test&travelTo=test"
         		+ "&travelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&TaxAmt=0&GSTIncluded=true&Km=6&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
         
         
			 assertTrue(updatetravelclaimcode.equalsIgnoreCase("200")||updatetravelclaimcode.equalsIgnoreCase("201"));
		     break;	

	 case "DragNDrop/GetEmpAppliedExpenseDataLocal_DD" :	
		 	
		 		System.out.println(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+""); 
	 	 citymastercode= gdata1.getContenxtWeb(BaseUrl+"api/travelclaim/GetCityDataList?Domain="+domaintext+"");
		 assertTrue(citymastercode.equalsIgnoreCase("200")||citymastercode.equalsIgnoreCase("201"));
		 

			
			  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
			
		
			  cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
			  cityno=0;
			
			  citynamefromdata=cityarray1.get(cityno+1);
			  citynametodata=cityarray1.get(cityno+2);
			
//	 	System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS?Domain="+domaintext+"");
//	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS?Domain="+domaintext+"");
//		 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
//		 
			
//		 wbsarray = new ArrayList<String>();
			
			//BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext
			System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
			 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
			
			 wbscount=0;
			 wbsdata=wbsarray.get(wbscount+1);
			
	 	System.out.println(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
		 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
			 localtravelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
			 		+ "ClaimType=LocalClaim&band="+bandid+"&Domain="+domaintext+"");
			 assertTrue(localtravelmodecaode.equalsIgnoreCase("200")||localtravelmodecaode.equalsIgnoreCase("201"));
			 System.out.println(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
			 
			  localtravelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

			 localtravelmodearray = gdata.parseFromJSONarrayResponse(localtravelmodeapiresponse);
			 localtravelmodecount=0;
			 localtravelmodedata=localtravelmodearray.get(localtravelmodecount+1);
	 	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			 localDate = LocalDate.now();
			
			System.out.println(postbaseurl+"/api/DragNDrop/GetInsertLocalClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
			 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
	 				+ "&travelFrom=chinchpokli"
	 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
			
			 userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertLocalClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=450&CityFrom="+citynamefromdata+"&CityTo="+citynamefromdata+"&Remarks=nn&ModeOfTravel="+localtravelmodedata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&travelFrom=chinchpokli"
				 		+ "&travelTo=kurla&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&Km=0&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
				
			
			 localarray = gdata.parseFromJSONarrayResponse(userresponse);
			  
			
			  j=0;
			  ClaimId=localarray.get(j);
			  travelexpenseid=localarray.get(j+1);
			  //fromdate=array.get(j+5);
			
			 
			//****View Local claim  /api/LocalClaimView/GetEmpAppliedExpenseDataLocal?ClaimId=252&ExpenseId=1
			 System.out.println(postbaseurl+"/api/DragNDrop/GetEmpAppliedExpenseDataLocal_DD?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
			String  viewlocalclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetEmpAppliedExpenseDataLocal_DD?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
		 assertTrue(viewlocalclaimcode.equalsIgnoreCase("200")||viewlocalclaimcode.equalsIgnoreCase("201"));
		     break;	 

		     
		     
	 case "DragNDrop/GetInsertMobileClaim_DD":
     	
     	
		 
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
				
				 System.out.println(postbaseurl+"/api/DragNDrop/GetInsertMobileClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
					 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
					 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&ContactNumber=8698294937&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
				 
				 
    	userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertMobileClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
		 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
		 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&ContactNumber=8698294937&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
		
	//System.out.println(userresponse);
		 array = gdata.parseFromJSONResponse(userresponse);
		  j=0;
		
		  ClaimId=array.get(j+7);
		  travelexpenseid=array.get(j+9);
		  //fromdate=array.get(j+5);
		 
		  break;
		  
	 case "DragNDrop/UpdateMobileClaim_DD":
		 	
		 	
		  
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
					
	 	userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertMobileClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
			 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&ContactNumber=8698294937&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
			
		//System.out.println(userresponse);
			 array = gdata.parseFromJSONResponse(userresponse);
			  j=0;
			
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+9);
			  //fromdate=array.get(j+5);
			 System.out.println("New claim id is "+ClaimId);
			  System.out.println("New claim id is "+travelexpenseid); 
			  
			  String updatemobileclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/UpdateMobileClaim_DD?ClaimId="+ClaimId+""
				 		+ "&MobileClaimId="+travelexpenseid+"&dateFrom="+dtf.format(localDate)+"&amount=123&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&TaxAmt=200"
				 		+ "&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&ContactNumber=8698294937&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
					 assertTrue(updatemobileclaimcode.equalsIgnoreCase("200")||updatemobileclaimcode.equalsIgnoreCase("201")); 
			  
			  break;
			  
	 case "DragNDrop/GetEmpAppliedExpenseDataMobile_DD":
		 	
		 	
			
	 	 WBSmastercode= gdata1.getContenxtWeb(BaseUrl+"/api/travelclaim/GetMasterDataList?MasterType=WBS&Domain="+domaintext+"");
			 assertTrue(WBSmastercode.equalsIgnoreCase("200")||WBSmastercode.equalsIgnoreCase("201"));
			 
				
			 wbsarray = new ArrayList<String>();
				
				
//				System.out.println(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
				 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
						 wbscount=0;
				 wbsdata=wbsarray.get(wbscount+1);
			
				  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					 localDate = LocalDate.now();
					
	 	userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertMobileClaim_DD?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=300&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=test&EmpID="+empdata+"&week=19/08/2018~25/08/2018&WBS="+wbsdata+"&"
			 		+ "Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&ContactNumber=8698294937&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
			
		
			 array = gdata.parseFromJSONResponse(userresponse);
			  j=0;
			
			  ClaimId=array.get(j+7);
			  travelexpenseid=array.get(j+9);
			  //fromdate=array.get(j+5);
			
			  
			 String  viewlandlineclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetEmpAppliedExpenseDataMobile_DD?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
			  
			  break;
	
	 case "DragNDrop/GetInsertOtherClaim_DD":
		 String noename="";
			//TestData.GetData gdata = new  TestData.GetData();
			 String noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
			

			 ArrayList<String> noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
			
			for( j=0;j<noearray1.size();j++)
			{
				
				 noename=noearray1.get(j);
//				System.out.println("Noe name is:->>>>>>>>>"+noename);
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
			
			userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertOtherClaim_DD?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
			 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
			 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
			
		        //System.out.println(userresponse);
			    array = gdata.parseFromJSONResponse(userresponse);
			    j=0;
			   
			     ClaimId=array.get(j+7);
			     travelexpenseid=array.get(j+11);
			     //fromdate=array.get(j+5);
			     System.out.println("New claim id is "+ClaimId);
			     System.out.println("New claim id is "+travelexpenseid);
	             break;
	             
	 case "DragNDrop/UpdateOtherClaim_DD":
		  noename="";
			//TestData.GetData gdata = new  TestData.GetData();
			  noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domaintext+"");
			

			 noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
			
			for( j=0;j<noearray1.size();j++)
			{
				
				 noename=noearray1.get(j);
//				System.out.println("Noe name is:->>>>>>>>>"+noename);
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
			
					userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertOtherClaim_DD?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
					 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
					 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
					
		        //System.out.println(userresponse);
			    array = gdata.parseFromJSONResponse(userresponse);
			    j=0;
			  
			     ClaimId=array.get(j+7);
			     travelexpenseid=array.get(j+11);
			     //fromdate=array.get(j+5);
			     System.out.println("New claim id is "+ClaimId);
			     System.out.println("New claim id is "+travelexpenseid);
			     System.out.println(postbaseurl+"/api/DragNDrop/UpdateOtherClaim_DD?ClaimId=2440&OtherExpenseClaimId="+ClaimId+""
					 		+ "&dateFrom="+dtf.format(localDate)+"&amount=567&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&vcLocation=pune&TaxAmt=300&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&NOE="+noename+"&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
			    
			     
			     String updateotherclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/UpdateOtherClaim_DD?ClaimId=2440&OtherExpenseClaimId="+ClaimId+""
					 		+ "&dateFrom="+dtf.format(localDate)+"&amount=567&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&vcLocation=pune&TaxAmt=300&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&NOE="+noename+"&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
								 assertTrue(updateotherclaimcode.equalsIgnoreCase("200")||updateotherclaimcode.equalsIgnoreCase("201")); 
								 break;
								 
	 case "DragNDrop/GetEmpAppliedExpenseDataOther_DD":
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
			
					userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertOtherClaim_DD?dateFrom=%20"+dtf.format(localDate)+"%2000:00:00.000&"
					 		+ "amount=200&dateTo="+dtf.format(localDate)+"%2000:00:00.000&noe="+noename+"&Remarks=test&location=pune&EmpID="+empdata+"&week=19/08/2018~25/08/2018&"
					 		+ "WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
					
		        //System.out.println(userresponse);
			    array = gdata.parseFromJSONResponse(userresponse);
			    j=0;
			  
			     ClaimId=array.get(j+7);
			     travelexpenseid=array.get(j+11);
			     //fromdate=array.get(j+5);
			     System.out.println("New claim id is "+ClaimId);
			     System.out.println("New claim id is "+travelexpenseid);
			     
			     viewlandlineclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetEmpAppliedExpenseDataOther_DD?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
				 
				 break;

			  
	 case "DragNDrop/GetInsertLandLineClaim_DD" :	
		
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
			
			
			 String landlineuserresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertLandLineClaim_DD?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
				 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+""
				 						+ ""
				 						+ "&ContactNumber=343434345678&Domain="+domaintext+"");
				
		
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
		     break;	
		     
	 case "DragNDrop/UpdateLandLineClaim_DD" :	
		 	
		 	
		 	
		 
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
		
			
			
			  landlineuserresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertLandLineClaim_DD?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
		 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+""
		 						+ ""
		 						+ "&ContactNumber=343434345678&Domain="+domaintext+"");
				
			
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
				 
				 String updatelandlineclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/UpdateLandLineClaim_DD?ClaimId="+ClaimId+"&MobileClaimId="+travelexpenseid+"&dateFrom="+dtf.format(localDate)+""
					 		+ "&amount=200&dateTo="+dtf.format(localDate)+"&Remarks=test&WBS="+wbsdata+"&TaxAmt=300"
					 		+ "&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Company=test&DtInvoiceDate="+dtf.format(localDate)+""
					 				+ "&DtInvoiceDate="+dtf.format(localDate)+"&ContactNumber=343434345678&Domain="+domaintext+"");
					 assertTrue(updatelandlineclaimcode.equalsIgnoreCase("200")||updatelandlineclaimcode.equalsIgnoreCase("201")); 	 
		     break;	


	 case "DragNDrop/GetEmpAppliedExpenseDataLandLine_DD" :	
		 	
		 	
		 	
		 
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
			
			
			
			 landlineuserresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetInsertLandLineClaim_DD?dateFrom="+dtf.format(localDate)+"%2000:00:00.000"
				 		+ "&amount=500.00&dateTo="+dtf.format(localDate)+"%2000:00:00.000&Remarks=insert&EmpID="+empdata+"&week=19/08/2018~25/08/2018"
		 				+ "&WBS="+wbsdata+"&Exceed_Amt=0.00&TaxAmt=0&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+""
		 						+ ""
		 						+ "&ContactNumber=343434345678&Domain="+domaintext+"");
			
		
				 array = gdata.parseFromJSONResponse(landlineuserresponse);
				
				  j=0;
				  ClaimId=array.get(j+7);
				  travelexpenseid=array.get(j+9);
				  //fromdate=array.get(j+5);
				
				 
				  viewlandlineclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetEmpAppliedExpenseDataLandLine_DD?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
				 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
		     break;	

		     
	 case "DragNDrop/InsertFoodClaim_DD":  //insert food claim   http://192.168.1.14:84/api/FoodClaim/InsertFoodClaim?TravelDate=02/28/2018&Location=1&NoOfDays=1&amount=10000.00&Remarks=test&WBS=26&empId=672&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true&foodPlace=1

		 
		 
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
	 System.out.println(postbaseurl+"/api/DragNDrop/InsertFoodClaim_DD?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
		 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true"
 				+ "&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
		 
	 
	 userresponse= gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/InsertFoodClaim_DD?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
		 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true"
		 				+ "&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
		  array = gdata.parseFromJSONResponse(userresponse);
		  
		  j=0;
		
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		 travelexpenseid=array.get(j+12);
		
		 System.out.println("New claim id is "+travelexpenseid); 
		 break;

		 
	 case "DragNDrop/UpdateFoodClaim_DD" :
			
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
//		 foodid=foodTypeyarray1.get(i+2);
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
		
		userresponse= gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/InsertFoodClaim_DD?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
		 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true"
		 				+ "&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
		  array = gdata.parseFromJSONResponse(userresponse);
		 
		  j=0;
		
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		 travelexpenseid=array.get(j+12);
		
		 System.out.println("New claim id is "+travelexpenseid); 
		 ///api/FoodClaimView/UpdateFoodClaim?ClaimId=9723&FoodClaimId=1&TravelDate=2016-12-01%2000:00:00.000&Location=2&NoOfDays=3&Amount=5000.00&Remarks=test&WBS=26&TaxAmt=50.00&GSTIncluded=true&FoodPlace=1
	  
		 
		 String updatefoodclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/UpdateFoodClaim_DD?ClaimId="+ClaimId+"&FoodClaimId="+travelexpenseid+""
		 		+ "&TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location=2&NoOfDays=3&Amount=5000.00&Remarks=test&WBS="+wbsdata+"&TaxAmt=50.00&GSTIncluded=true"
		 		+ "&FoodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
		 assertTrue(updatefoodclaimcode.equalsIgnoreCase("200")||updatefoodclaimcode.equalsIgnoreCase("201"));
		 break; 

		 
	 case "DragNDrop/GetEmpAppliedExpenseDataFood_DD" : 
	     
			
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
		System.out.println(postbaseurl+"/api/DragNDrop/InsertFoodClaim_DD?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
		 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true"
 				+ "&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
		
		userresponse= gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/InsertFoodClaim_DD?TravelDate="+dtf.format(localDate)+"&Location=1&NoOfDays=1"
		 		+ "&amount=10000.00&Remarks=test&WBS="+wbsdata+"&empId="+empdata+"&week=02/25/2018~02/28/2018&TaxAmt=20.00&GSTIncluded=true"
		 				+ "&foodPlace="+foodid+"&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
		
		array = gdata.parseFromJSONResponse(userresponse);
		 
		  j=0;
		
		  ClaimId=array.get(j+7);
		  //fromdate=array.get(j+5);
		 System.out.println("New claim id is "+ClaimId);
		 travelexpenseid=array.get(j+12);
		
		 System.out.println("New claim id is "+travelexpenseid); 
		 
		 viewlandlineclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetEmpAppliedExpenseDataFood_DD?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
		 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
		 break; 

		     
	  case "DragNDrop/InsertAccomodationClaim_DD":
    	  
     	 
		  
		  
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
				 
    	  userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/InsertAccomodationClaim_DD?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
			 		+ "&NoOfDays=1&amount=500&Remarks=test"
			 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
			 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
			
		
			  array = gdata.parseFromJSONResponse(userresponse);
			 j=0;
		
			  ClaimId=array.get(j+7);
			  //fromdate=array.get(j+5);
			  travelexpenseid=array.get(j+10);
			
			 break;
			 
			 
	  case "DragNDrop/UpdateAccomodationClaim_DD":
		  
			 
		  
		  
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
				
				  userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/InsertAccomodationClaim_DD?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
					 		+ "&NoOfDays=1&amount=500&Remarks=test"
					 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
					 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
					
		//System.out.println(userresponse);
			  array = gdata.parseFromJSONResponse(userresponse);
			 j=0;
			
			  ClaimId=array.get(j+7);
			  //fromdate=array.get(j+5);
			  travelexpenseid=array.get(j+10);
			
			
			 String updatehotelclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/UpdateAccomodationClaim_DD?ClaimId="+ClaimId+""
				 		+ "&AccomodationClaimId="+travelexpenseid+"&TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+"&NoOfDays=1&Amount=500.00&Remarks=na&WBS="+wbsdata+"&TaxAmt=50.00"
				 		+ "&GSTIncluded=true&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
						 assertTrue(updatehotelclaimcode.equalsIgnoreCase("200")||updatehotelclaimcode.equalsIgnoreCase("201")); 
		  
		  break;

	  case "DragNDrop/GetEmpAppliedExpenseDataAccomodation_DD":
		  
		  
		  
		  
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
				
				  userresponse = gdata.getContenxtWeb(postbaseurl+"/api/DragNDrop/InsertAccomodationClaim_DD?TravelDate="+dtf.format(localDate)+"%2000:00:00.000&Location="+citynamefromdata+""
					 		+ "&NoOfDays=1&amount=500&Remarks=test"
					 		+ "&WBS="+wbsdata+"&empId="+empdata+"&week=19/08/2018~25/08/2018&TaxAmt=0&GSTIncluded=True&InvoiceNo=123"
					 				+ "&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&TravelDateTo="+dtf.format(localDate)+"&OtherFromCity=&Company=test&DtInvoiceDate="+dtf.format(localDate)+"&DtInvoiceDate="+dtf.format(localDate)+"&Domain="+domaintext+"");
					
		//System.out.println(userresponse);
			  array = gdata.parseFromJSONResponse(userresponse);
			 j=0;
			
			  ClaimId=array.get(j+7);
			  //fromdate=array.get(j+5);
			  travelexpenseid=array.get(j+10);
			 
			 
			 
			 viewlandlineclaimcode= gdata1.getContenxtWeb(postbaseurl+"/api/DragNDrop/GetEmpAppliedExpenseDataAccomodation_DD?ClaimId="+ClaimId+"&ExpenseId="+travelexpenseid+"&Domain="+domaintext+"");
			 assertTrue(viewlandlineclaimcode.equalsIgnoreCase("200")||viewlandlineclaimcode.equalsIgnoreCase("201"));
		  
		  break;

		  
       case "DragNDrop/CalculateDistanceAmount_DD":
		  
		  
		  
		  
    	   responsecode  = gdata1.getContenxtWeb(BaseUrl+"/api/DragNDrop/CalculateDistanceAmount_DD?txtKM=40&Amount=20&KM=2&Domain="+domaintext+"");
			 assertTrue(responsecode.equalsIgnoreCase("200")||responsecode.equalsIgnoreCase("201"));
			 
			 break;
			 
			 
       case "DragNDrop/usp_CalculateBalanceAmount_DD":
 		  
 		  
 		  
 		  
    	   responsecode  = gdata1.getContenxtWeb(BaseUrl+"/api/DragNDrop/usp_CalculateBalanceAmount_DD?BalAmt=20&Amount=10&Domain="+domaintext+"");
			 assertTrue(responsecode.equalsIgnoreCase("200")||responsecode.equalsIgnoreCase("201"));
			 
			 break;
			 
			 
			 
       case "DragNDrop/usp_CalculateBalanceExceedOnAddClaim":
  		  
  		  
  		  
  		  
    	   responsecode  = gdata1.getContenxtWeb(BaseUrl+"/api/DragNDrop/usp_CalculateBalanceExceedOnAddClaim?month="+current.get(Calendar.MONTH)+"&year="+current.get(Calendar.YEAR)+"&empid="+empdata+"&noe=0&claimtype=1&travelmode=0\r\n" + 
    	   		"&foodplace=0&day=1&fromdate="+dtf.format(localDate)+"&todate="+dtf.format(localDate)+"&claimmode=&ExpenseId=12&Domain="+domaintext+"");
			 assertTrue(responsecode.equalsIgnoreCase("200")||responsecode.equalsIgnoreCase("201"));
			 
			 break;
			 
       case "DragNDrop/CalculateAndUpdateExceedAmountPerDayMont":
   		  
   		  
   		  
   		  
    	   responsecode  = gdata1.getContenxtWeb(BaseUrl+"/api/DragNDrop/CalculateAndUpdateExceedAmountPerDayMonth?month=0&Empid="+empdata+"&year=2020&noe=&ClaimType=1\r\n" + 
    	   		"&day=&TravelMode=0&FoodPlace=&fromdate=21/07/2020&todate=21/07/2020&Claimmode=&ExpenseID=12\r\n" + 
    	   		"&previousFromDate=21/07/2020&previousToDate=21/07/2020&Domain="+domaintext+"");
			 assertTrue(responsecode.equalsIgnoreCase("200")||responsecode.equalsIgnoreCase("201"));
			 
			 break;
			 
       case "DragNDrop/GetCompanyList":
    		  
    		  
    		  
    		  
    	   responsecode  = gdata1.getContenxtWeb(BaseUrl+"/api/DragNDrop/GetCompanyList?prefix=ola&Domain="+domaintext+"");
			 assertTrue(responsecode.equalsIgnoreCase("200")||responsecode.equalsIgnoreCase("201"));
			 
			 break;
			 
       case "ValidateHotelExpense":
 		  
 		  
 		  
 		  
    	   responsecode  = gdata1.getContenxtWeb(BaseUrl+"/api/ValidateHotelExpense?FromDate="+dtf.format(localDate)+"&ToDate="+dtf.format(localDate)+"&Empid="+this.empdata+"&mode=&expenseid=1&Domain="+domaintext+"");
			 assertTrue(responsecode.equalsIgnoreCase("200")||responsecode.equalsIgnoreCase("201"));
			 
			 break;
			 
       case "GetEmployeeDetails":
  		  
  		  
  		  
  		  
    	   responsecode  = gdata1.getContenxtWeb(BaseUrl+"/api/GetEmployeeDetails?EmpID="+empdata+"&Domain="+domaintext+"");
			 assertTrue(responsecode.equalsIgnoreCase("200")||responsecode.equalsIgnoreCase("201"));
			 
			 break;
			 
       case "DragNDrop":
   		  
   		  
   		  
   		  
    	   responsecode  = gdata1.getContenxtWeb(BaseUrl+"//api/DragNDrop?Claimid=1&ExpenseId=1&Claimtype=1&Domain="+domaintext+"");
			 assertTrue(responsecode.equalsIgnoreCase("200")||responsecode.equalsIgnoreCase("201"));
			 
			 break;
			 
			 
		}
		
	}
}
