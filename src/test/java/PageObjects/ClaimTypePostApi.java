package PageObjects;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONException;

import Browsers.Urls;
import Data.capturePostAPIData;
import TestData.GetApiData;

public class ClaimTypePostApi extends Urls {
	
	String Logincode="";
	String empdata="";
	String 	ClaimId="";
	String bandid="";
	String travelexpenseid="";
	String travelinsertresponse="";
	String managerdata="";
	String APIBody="";
	String response="";
	String territoryid="";
	String fromcityid="";
	String tocityid="";
	String travelmodeid="";
	String wbsid="";
	String typeofvisitid="";
	String masterclaimid="";
	String claimid="";
	String localmasterclaimid="";
	String localexpenseid="";
	String landlineexpenseid="";
	String hotelexpenseid="";
	String mobileexpenseid="";
	String noeid="";
	String otherexpenseid="";
	String shiftid="";
	String supporttravelid="";
	String foodid="";
	String foodexpenseid="";
	String foodclaimid="";
	int k=0;
	Calendar current = Calendar.getInstance();
	ArrayList<String> array = new ArrayList<String>();

	String travelpolicybindcode="";
	DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	ExtendedCallAPI ecapi= new ExtendedCallAPI();
	PostAPIPage postapi = new PostAPIPage();
	
	public void steps(String functiontext,String username,String password,String managerusername,String managerpassword,String policytype,String domaintext) throws JSONException, InterruptedException 
	{
		
		
		
		GetApiData gdata1 = new  GetApiData();
		capturePostAPIData postapidata= new capturePostAPIData();
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		empdata= array.get(0);
		bandid=array.get(1);
		territoryid=array.get(2);
		 System.out.println("here"+functiontext);
		switch(functiontext){
		
		
			
			 
		case "GetInsertLocalClaim" :
		
			 System.out.println("here");
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
	  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
			 		"  \"CityTo\": "+tocityid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"ModeOfTravel\": "+travelmodeid+",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"13/10/2019~19/10/2019\",\r\n" + 
			 		"  \"travelFrom\": \"test1\",\r\n" + 
			 		"  \"travelTo\": \"test2\",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 13.0,\r\n" + 
			 		"  \"TaxAmt\": 14.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"Km\": 16.0,\r\n" + 
			 		"  \"InvoiceNo\": \"44\",\r\n" + 
			 		"  \"GSTN\": \"454545454545\",\r\n" + 
			 		"  \"CGSTAmt\": 19.0,\r\n" + 
			 		"  \"SGSTAmt\": 20.0,\r\n" + 
			 		"  \"IGSTAmt\": 21.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LocalClaim/GetInsertLocalClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 
			 break;
			 
		case "GetMasterClaimID" :
			
			 System.out.println("here");
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
			  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
			 		"  \"CityTo\": "+tocityid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"ModeOfTravel\": "+travelmodeid+",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"13/10/2019~19/10/2019\",\r\n" + 
			 		"  \"travelFrom\": \"test1\",\r\n" + 
			 		"  \"travelTo\": \"test2\",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 13.0,\r\n" + 
			 		"  \"TaxAmt\": 14.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"Km\": 16.0,\r\n" + 
			 		"  \"InvoiceNo\": \"44\",\r\n" + 
			 		"  \"GSTN\": \"454545454545\",\r\n" + 
			 		"  \"CGSTAmt\": 19.0,\r\n" + 
			 		"  \"SGSTAmt\": 20.0,\r\n" + 
			 		"  \"IGSTAmt\": 21.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			   masterclaimid= postapidata.getonlydata(postbaseurl+"api/LocalClaim/GetInsertLocalClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			
			  response= postapidata.httpPost(postbaseurl+"api/LocalClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "LocalClaimView/GetClaimByID" :
			
			 System.out.println("here");
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
			  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
			 		"  \"CityTo\": "+tocityid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"ModeOfTravel\": "+travelmodeid+",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"13/10/2019~19/10/2019\",\r\n" + 
			 		"  \"travelFrom\": \"test1\",\r\n" + 
			 		"  \"travelTo\": \"test2\",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 13.0,\r\n" + 
			 		"  \"TaxAmt\": 14.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"Km\": 16.0,\r\n" + 
			 		"  \"InvoiceNo\": \"44\",\r\n" + 
			 		"  \"GSTN\": \"454545454545\",\r\n" + 
			 		"  \"CGSTAmt\": 19.0,\r\n" + 
			 		"  \"SGSTAmt\": 20.0,\r\n" + 
			 		"  \"IGSTAmt\": 21.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LocalClaim/GetInsertLocalClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			
			  array= postapidata.getdata(postbaseurl+"api/LocalClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/LocalClaimView/GetClaimByID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetEmpAppliedExpenseDataLocal" :
			
			 System.out.println("here");
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
			 		"  \"CityTo\": "+tocityid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"ModeOfTravel\": "+travelmodeid+",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"13/10/2019~19/10/2019\",\r\n" + 
			 		"  \"travelFrom\": \"test1\",\r\n" + 
			 		"  \"travelTo\": \"test2\",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 13.0,\r\n" + 
			 		"  \"TaxAmt\": 14.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"Km\": 16.0,\r\n" + 
			 		"  \"InvoiceNo\": \"44\",\r\n" + 
			 		"  \"GSTN\": \"454545454545\",\r\n" + 
			 		"  \"CGSTAmt\": 19.0,\r\n" + 
			 		"  \"SGSTAmt\": 20.0,\r\n" + 
			 		"  \"IGSTAmt\": 21.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LocalClaim/GetInsertLocalClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			
			  array= postapidata.getdata(postbaseurl+"api/LocalClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  localexpenseid=array.get(8);
			  System.out.println("localexpenseid"+localexpenseid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"ExpenseId\": "+localexpenseid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/LocalClaimView/GetEmpAppliedExpenseDataLocal" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "UpdateLocalClaim" :
			
			 System.out.println("here");
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
			 		"  \"CityTo\": "+tocityid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"ModeOfTravel\": "+travelmodeid+",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"13/10/2019~19/10/2019\",\r\n" + 
			 		"  \"travelFrom\": \"test1\",\r\n" + 
			 		"  \"travelTo\": \"test2\",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 13.0,\r\n" + 
			 		"  \"TaxAmt\": 14.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"Km\": 16.0,\r\n" + 
			 		"  \"InvoiceNo\": \"44\",\r\n" + 
			 		"  \"GSTN\": \"454545454545\",\r\n" + 
			 		"  \"CGSTAmt\": 19.0,\r\n" + 
			 		"  \"SGSTAmt\": 20.0,\r\n" + 
			 		"  \"IGSTAmt\": 21.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LocalClaim/GetInsertLocalClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			
			  array= postapidata.getdata(postbaseurl+"api/LocalClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  localexpenseid=array.get(8);
			  System.out.println("localexpenseid"+localexpenseid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"LocalConveyanceClaimId\": "+localexpenseid+",\r\n" + 
			  		"  \"travelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"amount\": 4.0,\r\n" + 
			  		"  \"cityFrom\": "+fromcityid+",\r\n" + 
			  		"  \"cityTo\": "+tocityid+",\r\n" + 
			  		"  \"Remarks\": \"sample string 7\",\r\n" + 
			  		"  \"modeOfTravel\": "+travelmodeid+",\r\n" + 
			  		"  \"travelFrom\": \"test\",\r\n" + 
			  		"  \"travelTo\": \"test2\",\r\n" + 
			  		"  \"travelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"WBS\": '"+wbsid+"',\r\n" + 
			  		"  \"TaxAmt\": 13.0,\r\n" + 
			  		"  \"GSTIncluded\": true,\r\n" + 
			  		"  \"Km\": 15.0,\r\n" + 
			  		"  \"InvoiceNo\": \"22\",\r\n" + 
			  		"  \"GSTN\": \"3333333333\",\r\n" + 
			  		"  \"CGSTAmt\": 18.0,\r\n" + 
			  		"  \"SGSTAmt\": 19.0,\r\n" + 
			  		"  \"IGSTAmt\": 20.0,\r\n" + 
			  		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			  		"  \"OtherFromCity\": \"''\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/LocalClaimView/UpdateLocalClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "LocalClaim/GetInsertClaimDocs" :
			
			 System.out.println("here");
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
			 		"  \"CityTo\": "+tocityid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"ModeOfTravel\": "+travelmodeid+",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"13/10/2019~19/10/2019\",\r\n" + 
			 		"  \"travelFrom\": \"test1\",\r\n" + 
			 		"  \"travelTo\": \"test2\",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 13.0,\r\n" + 
			 		"  \"TaxAmt\": 14.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"Km\": 16.0,\r\n" + 
			 		"  \"InvoiceNo\": \"44\",\r\n" + 
			 		"  \"GSTN\": \"454545454545\",\r\n" + 
			 		"  \"CGSTAmt\": 19.0,\r\n" + 
			 		"  \"SGSTAmt\": 20.0,\r\n" + 
			 		"  \"IGSTAmt\": 21.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LocalClaim/GetInsertLocalClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			
			  array= postapidata.getdata(postbaseurl+"api/LocalClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  localexpenseid=array.get(8);
			  System.out.println("localexpenseid"+localexpenseid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"ExpenseId\": "+localexpenseid+",\r\n" + 
			  		"  \"Empid\": "+empdata+",\r\n" + 
			  		"  \"vcFile\": \"sample string 4\",\r\n" + 
			  		"  \"fileDetails\": \"sample string 5\",\r\n" + 
			  		"  \"fileType\": \"jpg\",\r\n" + 
			  		"  \"claimtype\": 2,\r\n" + 
			  		"  \"claimweek\": \"0\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/LocalClaim/GetInsertClaimDocs" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
		case "LocalClaim/GetEmpAppliedClaimData" :
			
			 System.out.println("here");
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
			 		"  \"CityTo\": "+tocityid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"ModeOfTravel\": "+travelmodeid+",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"13/10/2019~19/10/2019\",\r\n" + 
			 		"  \"travelFrom\": \"test1\",\r\n" + 
			 		"  \"travelTo\": \"test2\",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 13.0,\r\n" + 
			 		"  \"TaxAmt\": 14.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"Km\": 16.0,\r\n" + 
			 		"  \"InvoiceNo\": \"44\",\r\n" + 
			 		"  \"GSTN\": \"454545454545\",\r\n" + 
			 		"  \"CGSTAmt\": 19.0,\r\n" + 
			 		"  \"SGSTAmt\": 20.0,\r\n" + 
			 		"  \"IGSTAmt\": 21.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LocalClaim/GetInsertLocalClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			
			  array= postapidata.getdata(postbaseurl+"api/LocalClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  localexpenseid=array.get(8);
			  System.out.println("localexpenseid"+localexpenseid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimWeek\": \"0\",\r\n" + 
			  		"  \"EmpID\": "+empdata+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/LocalClaim/GetEmpAppliedClaimData" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 //Landline claim
			 
			 
		case "GetInsertLandLineClaim" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
			  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 12.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Remarks\": \"sample string 4\",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 6\",\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 8.0,\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"5656565656565656\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LandLineClaim/GetInsertLandLineClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "LandLineClaim/GetMasterClaimID" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 12.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Remarks\": \"sample string 4\",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 6\",\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 8.0,\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"5656565656565656\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LandLineClaim/GetInsertLandLineClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\":'"+domaintext+"'\r\n" + 
		    	 		"}";
		   	  response= postapidata.httpPost(postbaseurl+"api/LandLineClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
		    	 
			 break;
			 
		case "GetEmpAppliedClaimDataLandLine" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
			  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 12.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Remarks\": \"sample string 4\",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 6\",\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 8.0,\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"5656565656565656\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LandLineClaim/GetInsertLandLineClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"claimWeek\": \"0\",\r\n" + 
		    	 		"  \"empID\": "+empdata+",\r\n" + 
		    	 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		    	 		"}";
		   	  response= postapidata.httpPost(postbaseurl+"api/LandLineClaim/GetEmpAppliedClaimDataLandLine" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
		    	 
			 break;
			 
		case "LandLineClaim/GetInsertClaimDocs" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
			  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 12.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Remarks\": \"sample string 4\",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 6\",\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 8.0,\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"5656565656565656\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LandLineClaim/GetInsertLandLineClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					
					  array= postapidata.getdata(postbaseurl+"api/LandLineClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(7);
					  landlineexpenseid=array.get(8);
					  System.out.println("localexpenseid"+localexpenseid);
					  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+claimid+",\r\n" + 
					  		"  \"ExpenseId\": "+landlineexpenseid+",\r\n" + 
					  		"  \"Empid\":"+empdata+",\r\n" + 
					  		"  \"vcFile\": \"sample string 4\",\r\n" + 
					  		"  \"fileDetails\": \"sample string 5\",\r\n" + 
					  		"  \"fileType\": \"jpg\",\r\n" + 
					  		"  \"claimtype\": 6,\r\n" + 
					  		"  \"claimweek\": \"0\",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					  response= postapidata.httpPost(postbaseurl+"api/LandLineClaim/GetInsertClaimDocs" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
		    	 
			 break;
			 
			 
		case "LandlineView/GetClaimByID" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  

				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 12.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Remarks\": \"sample string 4\",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 6\",\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 8.0,\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"5656565656565656\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LandLineClaim/GetInsertLandLineClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					
					  array= postapidata.getdata(postbaseurl+"api/LandLineClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(7);
					  landlineexpenseid=array.get(8);
					  System.out.println("localexpenseid"+localexpenseid);
					  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+claimid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					  response= postapidata.httpPost(postbaseurl+"api/LandlineView/GetClaimByID" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
		    	 
			 break;
			 
		case "GetEmpAppliedExpenseDataLandLine" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
		  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 12.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Remarks\": \"sample string 4\",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 6\",\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 8.0,\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"5656565656565656\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LandLineClaim/GetInsertLandLineClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					
					  array= postapidata.getdata(postbaseurl+"api/LandLineClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(7);
					  landlineexpenseid=array.get(8);
					  System.out.println("localexpenseid"+localexpenseid);
					  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+claimid+",\r\n" + 
					  		"  \"ExpenseId\": "+landlineexpenseid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					  response= postapidata.httpPost(postbaseurl+"api/LandlineView/GetEmpAppliedExpenseDataLandLine" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
		    	 
			 break;
			 
			 
		case "LandlineView/UpdateLandLineClaim" :
			

			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 12.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Remarks\": \"sample string 4\",\r\n" + 
			 		"  \"EmpID\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 6\",\r\n" + 
			 		"  \"WBS\": '"+wbsid+"',\r\n" + 
			 		"  \"Exceed_Amt\": 8.0,\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"5656565656565656\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/LandLineClaim/GetInsertLandLineClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					
					  array= postapidata.getdata(postbaseurl+"api/LandLineClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(7);
					  landlineexpenseid=array.get(8);
					  System.out.println("localexpenseid"+localexpenseid);
					  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+claimid+",\r\n" + 
					  		"  \"MobileClaimId\": "+landlineexpenseid+",\r\n" + 
					  		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					  		"  \"amount\": 4.0,\r\n" + 
					  		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					  		"  \"Remarks\": \"sample string 6\",\r\n" + 
					  		"  \"WBS\": "+wbsid+",\r\n" + 
					  		"  \"TaxAmt\": 8.0,\r\n" + 
					  		"  \"GSTIncluded\": true,\r\n" + 
					  		"  \"InvoiceNo\": \"sample string 10\",\r\n" + 
					  		"  \"GSTN\": \"2323568948\",\r\n" + 
					  		"  \"CGSTAmt\": 12.0,\r\n" + 
					  		"  \"SGSTAmt\": 13.0,\r\n" + 
					  		"  \"IGSTAmt\": 14.0,\r\n" + 
					  		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					  response= postapidata.httpPost(postbaseurl+"api/LandlineView/UpdateLandLineClaim" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
		    	 
			 break;
			 //mobile
		 case "MobileClaim/GetEmpAppliedClaimData" :
	    	 
		 		
			 APIBody = "{\r\n" + 
			 		"  \"ClaimWeek\": \"0\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/MobileClaim/GetEmpAppliedClaimData" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetInsertMobileClaim" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Remarks\": \"sample string 4\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"ClaimWeek\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 9.0,\r\n" + 
			 		"  \"TaxAmt\": 10.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 12\",\r\n" + 
			 		"  \"GSTN\": \"sample string 13\",\r\n" + 
			 		"  \"CGSTAmt\": 14.0,\r\n" + 
			 		"  \"SGSTAmt\": 15.0,\r\n" + 
			 		"  \"IGSTAmt\": 16.0,\r\n" + 
			 		"  \"ContactNumber\": \"98390293892\",\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/MobileClaim/GetInsertMobileClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "MobileClaim/GetMasterClaimID" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"Remarks\": \"sample string 4\",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"ClaimWeek\": \"0\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"Exceed_Amt\": 9.0,\r\n" + 
					 		"  \"TaxAmt\": 10.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"sample string 12\",\r\n" + 
					 		"  \"GSTN\": \"sample string 13\",\r\n" + 
					 		"  \"CGSTAmt\": 14.0,\r\n" + 
					 		"  \"SGSTAmt\": 15.0,\r\n" + 
					 		"  \"IGSTAmt\": 16.0,\r\n" + 
					 		"  \"ContactNumber\": \"98390293892\",\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/MobileClaim/GetInsertMobileClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\":'"+domaintext+"'\r\n" + 
		    	 		"}";
		   	  response= postapidata.httpPost(postbaseurl+"api/MobileClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "MobileClaim/GetInsertClaimDocs" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"Remarks\": \"sample string 4\",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"ClaimWeek\": \"0\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"Exceed_Amt\": 9.0,\r\n" + 
					 		"  \"TaxAmt\": 10.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"sample string 12\",\r\n" + 
					 		"  \"GSTN\": \"sample string 13\",\r\n" + 
					 		"  \"CGSTAmt\": 14.0,\r\n" + 
					 		"  \"SGSTAmt\": 15.0,\r\n" + 
					 		"  \"IGSTAmt\": 16.0,\r\n" + 
					 		"  \"ContactNumber\": \"98390293892\",\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/MobileClaim/GetInsertMobileClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\":'"+domaintext+"'\r\n" + 
		    	 		"}";
		    	 
		    	 array= postapidata.getdata(postbaseurl+"api/MobileClaim/GetMasterClaimID" , APIBody);
				  System.out.println("Masterclaimarray"+array);
				  claimid=array.get(7);
				  mobileexpenseid=array.get(8);
				  System.out.println("mobileexpenseid"+mobileexpenseid);
				  APIBody = "{\r\n" + 
				  		"  \"ClaimId\": "+claimid+",\r\n" + 
				  		"  \"ExpenseId\": "+mobileexpenseid+",\r\n" + 
				  		"  \"Empid\": "+empdata+",\r\n" + 
				  		"  \"vcFile\": \"sample string 4\",\r\n" + 
				  		"  \"fileDetails\": \"sample string 5\",\r\n" + 
				  		"  \"fileType\": \"jpg\",\r\n" + 
				  		"  \"claimtype\": 3,\r\n" + 
				  		"  \"claimweek\": \"0\",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
		   	  response= postapidata.httpPost(postbaseurl+"api/MobileClaim/GetInsertClaimDocs" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "MobileView/GetClaimByID" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"Remarks\": \"sample string 4\",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"ClaimWeek\": \"0\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"Exceed_Amt\": 9.0,\r\n" + 
					 		"  \"TaxAmt\": 10.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"sample string 12\",\r\n" + 
					 		"  \"GSTN\": \"sample string 13\",\r\n" + 
					 		"  \"CGSTAmt\": 14.0,\r\n" + 
					 		"  \"SGSTAmt\": 15.0,\r\n" + 
					 		"  \"IGSTAmt\": 16.0,\r\n" + 
					 		"  \"ContactNumber\": \"98390293892\",\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/MobileClaim/GetInsertMobileClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\":'"+domaintext+"'\r\n" + 
		    	 		"}";
		    	 
		    	 array= postapidata.getdata(postbaseurl+"api/MobileClaim/GetMasterClaimID" , APIBody);
				  System.out.println("Masterclaimarray"+array);
				  claimid=array.get(7);
				  mobileexpenseid=array.get(8);
				  System.out.println("mobileexpenseid"+mobileexpenseid);
				  APIBody = "{\r\n" + 
				  		"  \"ClaimId\": "+claimid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
		   	  response= postapidata.httpPost(postbaseurl+"api/MobileView/GetClaimByID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetEmpAppliedExpenseDataMobile" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"Remarks\": \"sample string 4\",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"ClaimWeek\": \"0\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"Exceed_Amt\": 9.0,\r\n" + 
					 		"  \"TaxAmt\": 10.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"sample string 12\",\r\n" + 
					 		"  \"GSTN\": \"sample string 13\",\r\n" + 
					 		"  \"CGSTAmt\": 14.0,\r\n" + 
					 		"  \"SGSTAmt\": 15.0,\r\n" + 
					 		"  \"IGSTAmt\": 16.0,\r\n" + 
					 		"  \"ContactNumber\": \"98390293892\",\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/MobileClaim/GetInsertMobileClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\":'"+domaintext+"'\r\n" + 
		    	 		"}";
		    	 
		    	 array= postapidata.getdata(postbaseurl+"api/MobileClaim/GetMasterClaimID" , APIBody);
				  System.out.println("Masterclaimarray"+array);
				  claimid=array.get(7);
				  mobileexpenseid=array.get(8);
				  System.out.println("mobileexpenseid"+mobileexpenseid);
				  APIBody = "{\r\n" + 
				  		"  \"ClaimId\": "+claimid+",\r\n" + 
				  		"  \"ExpenseId\": "+mobileexpenseid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
		   	  response= postapidata.httpPost(postbaseurl+"api/MobileView/GetEmpAppliedExpenseDataMobile" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "UpdateMobileClaim" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"Remarks\": \"sample string 4\",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"ClaimWeek\": \"0\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"Exceed_Amt\": 9.0,\r\n" + 
					 		"  \"TaxAmt\": 10.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"sample string 12\",\r\n" + 
					 		"  \"GSTN\": \"sample string 13\",\r\n" + 
					 		"  \"CGSTAmt\": 14.0,\r\n" + 
					 		"  \"SGSTAmt\": 15.0,\r\n" + 
					 		"  \"IGSTAmt\": 16.0,\r\n" + 
					 		"  \"ContactNumber\": \"98390293892\",\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/MobileClaim/GetInsertMobileClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\":'"+domaintext+"'\r\n" + 
		    	 		"}";
		    	 
		    	 array= postapidata.getdata(postbaseurl+"api/MobileClaim/GetMasterClaimID" , APIBody);
				  System.out.println("Masterclaimarray"+array);
				  claimid=array.get(7);
				  mobileexpenseid=array.get(8);
				  System.out.println("mobileexpenseid"+mobileexpenseid);
				  APIBody = "{\r\n" + 
				  		"  \"ClaimId\": "+claimid+",\r\n" + 
				  		"  \"MobileClaimId\": "+mobileexpenseid+",\r\n" + 
				  		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"amount\": 4.0,\r\n" + 
				  		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"Remarks\": \"sample string 6\",\r\n" + 
				  		"  \"WBS\": "+wbsid+",\r\n" + 
				  		"  \"TaxAmt\": 8.0,\r\n" + 
				  		"  \"GSTIncluded\": true,\r\n" + 
				  		"  \"InvoiceNo\": \"sample string 10\",\r\n" + 
				  		"  \"GSTN\": \"sample string 11\",\r\n" + 
				  		"  \"CGSTAmt\": 12.0,\r\n" + 
				  		"  \"SGSTAmt\": 13.0,\r\n" + 
				  		"  \"IGSTAmt\": 14.0,\r\n" + 
				  		"  \"ContactNumber\": \"98390293892\",\r\n" +
				  		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
		   	  response= postapidata.httpPost(postbaseurl+"api/MobileView/UpdateMobileClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "ValiadteMobileClaimDTO" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"Remarks\": \"sample string 4\",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"ClaimWeek\": \"0\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"Exceed_Amt\": 9.0,\r\n" + 
					 		"  \"TaxAmt\": 10.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"sample string 12\",\r\n" + 
					 		"  \"GSTN\": \"sample string 13\",\r\n" + 
					 		"  \"CGSTAmt\": 14.0,\r\n" + 
					 		"  \"SGSTAmt\": 15.0,\r\n" + 
					 		"  \"IGSTAmt\": 16.0,\r\n" + 
					 		"  \"ContactNumber\": \"98390293892\",\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/MobileClaim/GetInsertMobileClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\":'"+domaintext+"'\r\n" + 
		    	 		"}";
		    	 
		    	 array= postapidata.getdata(postbaseurl+"api/MobileClaim/GetMasterClaimID" , APIBody);
				  System.out.println("Masterclaimarray"+array);
				  claimid=array.get(7);
				  mobileexpenseid=array.get(8);
				  System.out.println("mobileexpenseid"+mobileexpenseid);
				  APIBody = "{\r\n" + 
				  		"  \"date_from\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"date_to\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"emp_Id\": "+empdata+",\r\n" + 
				  		"  \"expenseID\": "+mobileexpenseid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
		   	  response= postapidata.httpPost(postbaseurl+"api/MobileView/ValiadteMobileClaimDTO" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 //Hotel
			 
		case "InsertAccomodationClaim" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 8\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"sample string 12\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AccomodationClaim/InsertAccomodationClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "AccomodationClaim/GetMasterClaimID" :
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 8\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"sample string 12\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/AccomodationClaim/InsertAccomodationClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ExpId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		    	 		"}";
		   	  response= postapidata.httpPost(postbaseurl+"api/AccomodationClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AccomodationClaim/GetEmpAppliedExpenseDataAccomodation" :
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 8\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"sample string 12\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/AccomodationClaim/InsertAccomodationClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ExpId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		    	 		"}";
		    	 array= postapidata.getdata(postbaseurl+"api/AccomodationClaim/GetMasterClaimID" , APIBody);
				  System.out.println("Masterclaimarray"+array);
				  claimid=array.get(7);
				  hotelexpenseid=array.get(8);
				  System.out.println("hotelexpenseid"+hotelexpenseid);
				  APIBody = "{\r\n" + 
				  		"  \"ClaimId\": "+claimid+",\r\n" + 
				  		"  \"ExpenseId\": "+hotelexpenseid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
			   	  response= postapidata.httpPost(postbaseurl+"api/AccomodationClaim/GetEmpAppliedExpenseDataAccomodation" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "GetEmpAppliedClaimDataAccomodation" :
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 8\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"sample string 12\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/AccomodationClaim/InsertAccomodationClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ExpId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		    	 		"}";
		    	 array= postapidata.getdata(postbaseurl+"api/AccomodationClaim/GetMasterClaimID" , APIBody);
				  System.out.println("Masterclaimarray"+array);
				  claimid=array.get(7);
				  hotelexpenseid=array.get(8);
				  System.out.println("hotelexpenseid"+hotelexpenseid);
				  APIBody = "{\r\n" + 
				  		"  \"claimWeek\": \"0\",\r\n" + 
				  		"  \"empID\": "+empdata+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
			   	  response= postapidata.httpPost(postbaseurl+"api/AccomodationClaimView/GetEmpAppliedClaimDataAccomodation" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "UpdateAccomodationClaim" :
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 8\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"sample string 12\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/AccomodationClaim/InsertAccomodationClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ExpId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		    	 		"}";
		    	 array= postapidata.getdata(postbaseurl+"api/AccomodationClaim/GetMasterClaimID" , APIBody);
				  System.out.println("Masterclaimarray"+array);
				  claimid=array.get(7);
				  hotelexpenseid=array.get(8);
				  System.out.println("hotelexpenseid"+hotelexpenseid);
				  APIBody = "{\r\n" + 
				  		"  \"ClaimId\": "+claimid+",\r\n" + 
				  		"  \"AccomodationClaimId\": "+hotelexpenseid+",\r\n" + 
				  		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"Location\": 4,\r\n" + 
				  		"  \"NoOfDays\": 5,\r\n" + 
				  		"  \"amount\": 6.0,\r\n" + 
				  		"  \"Remarks\": \"sample string 7\",\r\n" + 
				  		"  \"WBS\": "+wbsid+",\r\n" + 
				  		"  \"TaxAmt\": 9.0,\r\n" + 
				  		"  \"GSTIncluded\": true,\r\n" + 
				  		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
				  		"  \"GSTN\": \"sample string 12\",\r\n" + 
				  		"  \"CGSTAmt\": 13.0,\r\n" + 
				  		"  \"SGSTAmt\": 14.0,\r\n" + 
				  		"  \"IGSTAmt\": 15.0,\r\n" + 
				  		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
				  		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"OtherFromCity\": \"''\",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
			   	  response= postapidata.httpPost(postbaseurl+"api/AccomodationClaimView/UpdateAccomodationClaim" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "AccomodationClaimView/GetAccomodationClaims" :
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"sample string 8\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			 		"  \"GSTN\": \"sample string 12\",\r\n" + 
			 		"  \"CGSTAmt\": 13.0,\r\n" + 
			 		"  \"SGSTAmt\": 14.0,\r\n" + 
			 		"  \"IGSTAmt\": 15.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 masterclaimid= postapidata.getonlydata(postbaseurl+"api/AccomodationClaim/InsertAccomodationClaim" , APIBody);
			  System.out.println("masterclaimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
		    	
		    	 APIBody = "{\r\n" + 
		    	 		"  \"ExpId\": "+masterclaimid+",\r\n" + 
		    	 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		    	 		"}";
		    	 array= postapidata.getdata(postbaseurl+"api/AccomodationClaim/GetMasterClaimID" , APIBody);
				  System.out.println("Masterclaimarray"+array);
				  claimid=array.get(7);
				  hotelexpenseid=array.get(8);
				  System.out.println("hotelexpenseid"+hotelexpenseid);
				  APIBody = "{\r\n" + 
				  		"  \"ClaimId\": "+claimid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
			   	  response= postapidata.httpPost(postbaseurl+"api/AccomodationClaimView/GetAccomodationClaims" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 //Other claim
			 
		case "GetInsertOtherClaim" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"noe\": "+noeid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"location\": \"test\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 13\",\r\n" + 
			 		"  \"GSTN\": \"85859632145\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/OtherClaim/GetInsertOtherClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "OtherClaim/GetMasterClaimID" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"noe\": "+noeid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"location\": \"test\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 13\",\r\n" + 
			 		"  \"GSTN\": \"85859632145\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/OtherClaim/GetInsertOtherClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/OtherClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "OtherClaim/GetInsertClaimDocs" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"noe\": "+noeid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"location\": \"test\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 13\",\r\n" + 
			 		"  \"GSTN\": \"85859632145\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/OtherClaim/GetInsertOtherClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  array= postapidata.getdata(postbaseurl+"api/OtherClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  otherexpenseid=array.get(8);
			  System.out.println("otherexpenseid"+otherexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"ExpenseId\": "+otherexpenseid+",\r\n" + 
			  		"  \"Empid\": "+empdata+",\r\n" + 
			  		"  \"vcFile\": \"sample string 4\",\r\n" + 
			  		"  \"fileDetails\": \"sample string 5\",\r\n" + 
			  		"  \"fileType\": \"sample string 6\",\r\n" + 
			  		"  \"claimtype\": 4,\r\n" + 
			  		"  \"claimweek\": \"0\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/OtherClaim/GetInsertClaimDocs" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "OtherClaimView/GetClaimByID" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"noe\": "+noeid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"location\": \"test\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 13\",\r\n" + 
			 		"  \"GSTN\": \"85859632145\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/OtherClaim/GetInsertOtherClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  array= postapidata.getdata(postbaseurl+"api/OtherClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  otherexpenseid=array.get(8);
			  System.out.println("otherexpenseid"+otherexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/OtherClaimView/GetClaimByID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
			 
		case "OtherClaimView/GetEmpAppliedExpenseDataOther" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"noe\": "+noeid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"location\": \"test\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 13\",\r\n" + 
			 		"  \"GSTN\": \"85859632145\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/OtherClaim/GetInsertOtherClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  array= postapidata.getdata(postbaseurl+"api/OtherClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  otherexpenseid=array.get(8);
			  System.out.println("otherexpenseid"+otherexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"ExpenseId\": "+otherexpenseid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/OtherClaimView/GetEmpAppliedExpenseDataOther" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "UpdateOtherClaim" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"noe\": "+noeid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"location\": \"test\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 13\",\r\n" + 
			 		"  \"GSTN\": \"85859632145\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/OtherClaim/GetInsertOtherClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  array= postapidata.getdata(postbaseurl+"api/OtherClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  otherexpenseid=array.get(8);
			  System.out.println("otherexpenseid"+otherexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"OtherExpenseClaimId\": "+otherexpenseid+",\r\n" + 
			  		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"amount\": 4.0,\r\n" + 
			  		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"Remarks\": \"sample string 6\",\r\n" + 
			  		"  \"WBS\": "+wbsid+",\r\n" + 
			  		"  \"vcLocation\": \"sample string 8\",\r\n" + 
			  		"  \"TaxAmt\": 9.0,\r\n" + 
			  		"  \"GSTIncluded\": true,\r\n" + 
			  		"  \"InvoiceNo\": \"sample string 11\",\r\n" + 
			  		"  \"GSTN\": \"5689593236\",\r\n" + 
			  		"  \"CGSTAmt\": 13.0,\r\n" + 
			  		"  \"SGSTAmt\": 14.0,\r\n" + 
			  		"  \"IGSTAmt\": 15.0,\r\n" + 
			  		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			  		"  \"NOE\": "+noeid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/OtherClaimView/UpdateOtherClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "OtherClaimView/ValidateOtherClaim" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"dateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"dateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"noe\": "+noeid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"location\": \"test\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"sample string 13\",\r\n" + 
			 		"  \"GSTN\": \"85859632145\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/OtherClaim/GetInsertOtherClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  array= postapidata.getdata(postbaseurl+"api/OtherClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  otherexpenseid=array.get(8);
			  System.out.println("otherexpenseid"+otherexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"date_from\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"date_to\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"emp_Id\": "+empdata+",\r\n" + 
			  		"  \"noe\": "+noeid+",\r\n" + 
			  		"  \"expenseID\": "+otherexpenseid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/OtherClaimView/ValidateOtherClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
		case "OtherClaim/GetEmpAppliedClaimDataOthe" :
			
			
			
			 APIBody = "{\r\n" + 
			 		"  \"ClaimWeek\": \"0\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/OtherClaim/GetEmpAppliedClaimDataOthe" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
			 
			//Travel
			 
		case "GetInsertUpdateTravelClaim" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"amount\": 2.0,\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
			 		"  \"CityTo\": "+tocityid+",\r\n" + 
			 		"  \"Remarks\": \"test\",\r\n" + 
			 		"  \"ModeOfTravel\": \"602\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"Exceed_Amt\": 11.0,\r\n" + 
			 		"  \"TaxAmt\": 12.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"4563\",\r\n" + 
			 		"  \"GSTN\": \"123456789\",\r\n" + 
			 		"  \"CGSTAmt\": 16.0,\r\n" + 
			 		"  \"SGSTAmt\": 17.0,\r\n" + 
			 		"  \"IGSTAmt\": 18.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"OtherToCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "TravelClaim/GetMasterClaimID" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
					 		"  \"CityTo\": "+tocityid+",\r\n" + 
					 		"  \"Remarks\": \"test\",\r\n" + 
					 		"  \"ModeOfTravel\": \"602\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"Exceed_Amt\": 11.0,\r\n" + 
					 		"  \"TaxAmt\": 12.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"4563\",\r\n" + 
					 		"  \"GSTN\": \"123456789\",\r\n" + 
					 		"  \"CGSTAmt\": 16.0,\r\n" + 
					 		"  \"SGSTAmt\": 17.0,\r\n" + 
					 		"  \"IGSTAmt\": 18.0,\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"OtherFromCity\": \"''\",\r\n" + 
					 		"  \"OtherToCity\": \"''\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
		case "TravelClaim/GetEmpAppliedClaimData" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
					 		"  \"CityTo\": "+tocityid+",\r\n" + 
					 		"  \"Remarks\": \"test\",\r\n" + 
					 		"  \"ModeOfTravel\": \"602\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"Exceed_Amt\": 11.0,\r\n" + 
					 		"  \"TaxAmt\": 12.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"4563\",\r\n" + 
					 		"  \"GSTN\": \"123456789\",\r\n" + 
					 		"  \"CGSTAmt\": 16.0,\r\n" + 
					 		"  \"SGSTAmt\": 17.0,\r\n" + 
					 		"  \"IGSTAmt\": 18.0,\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"OtherFromCity\": \"''\",\r\n" + 
					 		"  \"OtherToCity\": \"''\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			  
			  
			  array= postapidata.getdata(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  travelexpenseid=array.get(8);
			  System.out.println("travelexpenseid"+travelexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"mode\": \"travelclaim\",\r\n" + 
			  		"  \"ClaimWeek\": \"0\",\r\n" + 
			  		"  \"EmpID\": "+empdata+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetEmpAppliedClaimData" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
		case "GetClaimTypeWiseTotalClaimAmountForExceed" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
					 		"  \"CityTo\": "+tocityid+",\r\n" + 
					 		"  \"Remarks\": \"test\",\r\n" + 
					 		"  \"ModeOfTravel\": \"602\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"Exceed_Amt\": 11.0,\r\n" + 
					 		"  \"TaxAmt\": 12.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"4563\",\r\n" + 
					 		"  \"GSTN\": \"123456789\",\r\n" + 
					 		"  \"CGSTAmt\": 16.0,\r\n" + 
					 		"  \"SGSTAmt\": 17.0,\r\n" + 
					 		"  \"IGSTAmt\": 18.0,\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"OtherFromCity\": \"''\",\r\n" + 
					 		"  \"OtherToCity\": \"''\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			  
			  
			  array= postapidata.getdata(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  travelexpenseid=array.get(8);
			  System.out.println("travelexpenseid"+travelexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"Month\": 0,\r\n" + 
			  		"  \"EmpID\": "+empdata+",\r\n" + 
			  		"  \"Noe\": \"0\",\r\n" + 
			  		"  \"Mode\": \"Travel claim\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetClaimTypeWiseTotalClaimAmountForExceed" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "TravelClaim/GetInsertClaimDocs" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
					 		"  \"CityTo\": "+tocityid+",\r\n" + 
					 		"  \"Remarks\": \"test\",\r\n" + 
					 		"  \"ModeOfTravel\": \"602\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"Exceed_Amt\": 11.0,\r\n" + 
					 		"  \"TaxAmt\": 12.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"4563\",\r\n" + 
					 		"  \"GSTN\": \"123456789\",\r\n" + 
					 		"  \"CGSTAmt\": 16.0,\r\n" + 
					 		"  \"SGSTAmt\": 17.0,\r\n" + 
					 		"  \"IGSTAmt\": 18.0,\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"OtherFromCity\": \"''\",\r\n" + 
					 		"  \"OtherToCity\": \"''\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			  
			  
			  array= postapidata.getdata(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  travelexpenseid=array.get(8);
			  System.out.println("travelexpenseid"+travelexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"ExpenseId\": "+travelexpenseid+",\r\n" + 
			  		"  \"Empid\": "+empdata+",\r\n" + 
			  		"  \"vcFile\": \"sample string 4\",\r\n" + 
			  		"  \"fileDetails\": \"sample string 5\",\r\n" + 
			  		"  \"fileType\": \"sample string 6\",\r\n" + 
			  		"  \"claimtype\": 1,\r\n" + 
			  		"  \"claimweek\": \"0\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetInsertClaimDocs" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "UpdateTravelClaim" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
					 		"  \"CityTo\": "+tocityid+",\r\n" + 
					 		"  \"Remarks\": \"test\",\r\n" + 
					 		"  \"ModeOfTravel\": \"602\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"Exceed_Amt\": 11.0,\r\n" + 
					 		"  \"TaxAmt\": 12.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"4563\",\r\n" + 
					 		"  \"GSTN\": \"123456789\",\r\n" + 
					 		"  \"CGSTAmt\": 16.0,\r\n" + 
					 		"  \"SGSTAmt\": 17.0,\r\n" + 
					 		"  \"IGSTAmt\": 18.0,\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"OtherFromCity\": \"''\",\r\n" + 
					 		"  \"OtherToCity\": \"''\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			  
			  
			  array= postapidata.getdata(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  travelexpenseid=array.get(8);
			  System.out.println("travelexpenseid"+travelexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"TravelClaimId\": "+travelexpenseid+",\r\n" + 
			  		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"amount\": 4.0,\r\n" + 
			  		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"CityFrom\": "+fromcityid+",\r\n" + 
			  		"  \"CityTo\": "+tocityid+",\r\n" + 
			  		"  \"Remarks\": \"test\",\r\n" + 
			  		"  \"ModeOfTravel\": "+travelmodeid+",\r\n" + 
			  		"  \"WBS\": "+wbsid+",\r\n" + 
			  		"  \"TaxAmt\": 11.0,\r\n" + 
			  		"  \"GSTIncluded\": true,\r\n" + 
			  		"  \"InvoiceNo\": \"234\",\r\n" + 
			  		"  \"GSTN\": \"555656565656565\",\r\n" + 
			  		"  \"CGSTAmt\": 15.0,\r\n" + 
			  		"  \"SGSTAmt\": 16.0,\r\n" + 
			  		"  \"IGSTAmt\": 17.0,\r\n" + 
			  		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			  		"  \"OtherFromCity\": \"''\",\r\n" + 
			  		"  \"OtherToCity\": \"''\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaimView/UpdateTravelClaim" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetTotalExpensesForTravel" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
					 		"  \"CityTo\": "+tocityid+",\r\n" + 
					 		"  \"Remarks\": \"test\",\r\n" + 
					 		"  \"ModeOfTravel\": \"602\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"Exceed_Amt\": 11.0,\r\n" + 
					 		"  \"TaxAmt\": 12.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"4563\",\r\n" + 
					 		"  \"GSTN\": \"123456789\",\r\n" + 
					 		"  \"CGSTAmt\": 16.0,\r\n" + 
					 		"  \"SGSTAmt\": 17.0,\r\n" + 
					 		"  \"IGSTAmt\": 18.0,\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"OtherFromCity\": \"''\",\r\n" + 
					 		"  \"OtherToCity\": \"''\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			  
			  
			  array= postapidata.getdata(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  travelexpenseid=array.get(8);
			  System.out.println("travelexpenseid"+travelexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"    \"month\": "+(current.get(Calendar.MONTH)+1)+",\r\n" + 
			  		"    \"year\": '"+current.get(Calendar.YEAR)+"',\r\n" + 
			  		"    \"Empid\": "+empdata+",\r\n" + 
			  		"    \"day\": 0,\r\n" + 
			  		"    \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaimView/GetTotalExpensesForTravel" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "CalculateAndUpdateExceedAmountForTravel" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
					 		"  \"CityTo\": "+tocityid+",\r\n" + 
					 		"  \"Remarks\": \"test\",\r\n" + 
					 		"  \"ModeOfTravel\": \"602\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"Exceed_Amt\": 11.0,\r\n" + 
					 		"  \"TaxAmt\": 12.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"4563\",\r\n" + 
					 		"  \"GSTN\": \"123456789\",\r\n" + 
					 		"  \"CGSTAmt\": 16.0,\r\n" + 
					 		"  \"SGSTAmt\": 17.0,\r\n" + 
					 		"  \"IGSTAmt\": 18.0,\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"OtherFromCity\": \"''\",\r\n" + 
					 		"  \"OtherToCity\": \"''\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			  
			  
			  array= postapidata.getdata(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  travelexpenseid=array.get(8);
			  System.out.println("travelexpenseid"+travelexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"appliedAmount\": 1.0,\r\n" + 
			  		"  \"amountLimit\": 2.0,\r\n" + 
			  		"  \"amountAppliedTotal\": 3.0,\r\n" + 
			  		"  \"TravelClaimId\": "+claimid+",\r\n" + 
			  		"  \"totalExceed\": 5.0,\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaimView/CalculateAndUpdateExceedAmountForTravel" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "TravelClaimView/GetClaimDocuments" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
					 		"  \"CityTo\": "+tocityid+",\r\n" + 
					 		"  \"Remarks\": \"test\",\r\n" + 
					 		"  \"ModeOfTravel\": \"602\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"Exceed_Amt\": 11.0,\r\n" + 
					 		"  \"TaxAmt\": 12.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"4563\",\r\n" + 
					 		"  \"GSTN\": \"123456789\",\r\n" + 
					 		"  \"CGSTAmt\": 16.0,\r\n" + 
					 		"  \"SGSTAmt\": 17.0,\r\n" + 
					 		"  \"IGSTAmt\": 18.0,\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"OtherFromCity\": \"''\",\r\n" + 
					 		"  \"OtherToCity\": \"''\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			  
			  
			  array= postapidata.getdata(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  travelexpenseid=array.get(8);
			  System.out.println("travelexpenseid"+travelexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"ExpenseId\": "+travelexpenseid+",\r\n" + 
			  		"  \"status\": \"yes\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaimView/GetClaimDocuments" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "TravelClaimView/GetEmpAppliedExpenseDataTravel" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
					 		"  \"CityTo\": "+tocityid+",\r\n" + 
					 		"  \"Remarks\": \"test\",\r\n" + 
					 		"  \"ModeOfTravel\": \"602\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"Exceed_Amt\": 11.0,\r\n" + 
					 		"  \"TaxAmt\": 12.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"4563\",\r\n" + 
					 		"  \"GSTN\": \"123456789\",\r\n" + 
					 		"  \"CGSTAmt\": 16.0,\r\n" + 
					 		"  \"SGSTAmt\": 17.0,\r\n" + 
					 		"  \"IGSTAmt\": 18.0,\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"OtherFromCity\": \"''\",\r\n" + 
					 		"  \"OtherToCity\": \"''\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			  
			  
			  array= postapidata.getdata(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  travelexpenseid=array.get(8);
			  System.out.println("travelexpenseid"+travelexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"ExpenseId\": "+travelexpenseid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaimView/GetEmpAppliedExpenseDataTravel" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "TravelClaimView/GetClaimByID" :
			
			 System.out.println("here");
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
				  APIBody = "{\r\n" + 
					 		"  \"TravelDateFrom\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"amount\": 2.0,\r\n" + 
					 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					 		"  \"CityFrom\": "+fromcityid+",\r\n" + 
					 		"  \"CityTo\": "+tocityid+",\r\n" + 
					 		"  \"Remarks\": \"test\",\r\n" + 
					 		"  \"ModeOfTravel\": \"602\",\r\n" + 
					 		"  \"WBS\": "+wbsid+",\r\n" + 
					 		"  \"EmpID\": "+empdata+",\r\n" + 
					 		"  \"week\": \"0\",\r\n" + 
					 		"  \"Exceed_Amt\": 11.0,\r\n" + 
					 		"  \"TaxAmt\": 12.0,\r\n" + 
					 		"  \"GSTIncluded\": true,\r\n" + 
					 		"  \"InvoiceNo\": \"4563\",\r\n" + 
					 		"  \"GSTN\": \"123456789\",\r\n" + 
					 		"  \"CGSTAmt\": 16.0,\r\n" + 
					 		"  \"SGSTAmt\": 17.0,\r\n" + 
					 		"  \"IGSTAmt\": 18.0,\r\n" + 
					 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					 		"  \"OtherFromCity\": \"''\",\r\n" + 
					 		"  \"OtherToCity\": \"''\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/TravelClaim/GetInsertUpdateTravelClaim" , APIBody);
			  System.out.println("claimid is"+masterclaimid);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
		    	System.out.println("New masterclaimid is"+masterclaimid);
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			  
			  
			  array= postapidata.getdata(postbaseurl+"api/TravelClaim/GetMasterClaimID" , APIBody);
			  System.out.println("Masterclaimarray"+array);
			  claimid=array.get(7);
			  travelexpenseid=array.get(8);
			  System.out.println("travelexpenseid"+travelexpenseid);
			  
			  APIBody = "{\r\n" + 
			  		"  \"ClaimId\": "+claimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaimView/GetClaimByID" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "TravelClaim/InsertUpdateSupportTarvelClaim" :
			
			 System.out.println("here");
			 
	
			 
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
			  shiftid=array.get(0);
			  System.out.println("now here");
			  System.out.println("shiftid mode id is"+shiftid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+wbsid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
				  		"  \"empId\": "+empdata+",\r\n" + 
				  		"  \"claimType\": 11,\r\n" + 
				  		"  \"date\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"intTravelWay\": 0,\r\n" + 
				  		"  \"remarks\": \"test\",\r\n" + 
				  		"  \"shift\": "+shiftid+",\r\n" + 
				  		"  \"amount\": 7.0,\r\n" + 
				  		"  \"voucher\": \"sample string 8\",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"',\r\n" + 
				  		"  \"wbs\": '"+wbsid+"'\r\n" + 
				  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/InsertUpdateSupportTarvelClaim" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "GetSupportTravelClaimStatusDetails" :
			
			 System.out.println("here");
			 
	
			 
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
			  shiftid=array.get(0);
			  System.out.println("now here");
			  System.out.println("shiftid mode id is"+shiftid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+wbsid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
				  		"  \"empId\": "+empdata+",\r\n" + 
				  		"  \"claimType\": 11,\r\n" + 
				  		"  \"date\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"intTravelWay\": 0,\r\n" + 
				  		"  \"remarks\": \"test\",\r\n" + 
				  		"  \"shift\": "+shiftid+",\r\n" + 
				  		"  \"amount\": 7.0,\r\n" + 
				  		"  \"voucher\": \"sample string 8\",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"',\r\n" + 
				  		"  \"wbs\": '"+wbsid+"'\r\n" + 
				  		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/TravelClaim/InsertUpdateSupportTarvelClaim" , APIBody );
				  System.out.println(array);
				  claimid=array.get(0);
				  
				  
				  APIBody = "{\r\n" + 
				  		"  \"empId\": "+empdata+",\r\n" + 
				  		"  \"month\": 0,\r\n" + 
				  		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
				  		"  \"domain\": \"redchillies\"\r\n" + 
				  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetSupportTravelClaimStatusDetails" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 


		case "TravelClaim/DeleteTravelClaimDetails" :
			
			 System.out.println("here");
			 
	
			 
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
			  shiftid=array.get(0);
			  System.out.println("now here");
			  System.out.println("shiftid mode id is"+shiftid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+wbsid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
				  		"  \"empId\": "+empdata+",\r\n" + 
				  		"  \"claimType\": 11,\r\n" + 
				  		"  \"date\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"intTravelWay\": 0,\r\n" + 
				  		"  \"remarks\": \"test\",\r\n" + 
				  		"  \"shift\": "+shiftid+",\r\n" + 
				  		"  \"amount\": 7.0,\r\n" + 
				  		"  \"voucher\": \"sample string 8\",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"',\r\n" + 
				  		"  \"wbs\": '"+wbsid+"'\r\n" + 
				  		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/TravelClaim/InsertUpdateSupportTarvelClaim" , APIBody );
				  System.out.println(array);
				  claimid=array.get(0);
				  
				  
				  APIBody = "{\r\n" + 
				  		"  \"claimId\": "+claimid+",\r\n" + 
				  		"  \"domain\": '"+domaintext+"'\r\n" + 
				  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/DeleteTravelClaimDetails" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "DeleteTravelClaimDocuments" :
			
			 System.out.println("here");
			 
	
			 
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
			  shiftid=array.get(0);
			  System.out.println("now here");
			  System.out.println("shiftid mode id is"+shiftid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+wbsid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
				  		"  \"empId\": "+empdata+",\r\n" + 
				  		"  \"claimType\": 11,\r\n" + 
				  		"  \"date\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"intTravelWay\": 0,\r\n" + 
				  		"  \"remarks\": \"test\",\r\n" + 
				  		"  \"shift\": "+shiftid+",\r\n" + 
				  		"  \"amount\": 7.0,\r\n" + 
				  		"  \"voucher\": \"sample string 8\",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"',\r\n" + 
				  		"  \"wbs\": '"+wbsid+"'\r\n" + 
				  		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/TravelClaim/InsertUpdateSupportTarvelClaim" , APIBody );
				  System.out.println(array);
				  claimid=array.get(0);
				  
				  
				  APIBody = "{\r\n" + 
				  		"  \"claimId\": "+claimid+",\r\n" + 
				  		"  \"domain\": '"+domaintext+"'\r\n" + 
				  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/DeleteTravelClaimDocuments" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "TravelClaim/GetSupportTravelClaimPendingDetails" :
			
			 System.out.println("here");
			 
	
			 
			 
			 
				  
				  APIBody = "{\r\n" + 
				  		"  \"empId\": "+empdata+",\r\n" + 
				  		"  \"domain\": '"+domaintext+"'\r\n" + 
				  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/GetSupportTravelClaimPendingDetails" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
		case "TravelClaimView/CalculateAndUpdateExceedAmountForTravel" :
			
			 System.out.println("here");
			 
	
			 
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
			  shiftid=array.get(0);
			  System.out.println("now here");
			  System.out.println("shiftid mode id is"+shiftid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+wbsid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
//				  
				  APIBody = "{\r\n" + 
				  		"  \"empId\": "+empdata+",\r\n" + 
				  		"  \"claimType\": 11,\r\n" + 
				  		"  \"date\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"intTravelWay\": 0,\r\n" + 
				  		"  \"remarks\": \"test\",\r\n" + 
				  		"  \"shift\": "+shiftid+",\r\n" + 
				  		"  \"amount\": 7.0,\r\n" + 
				  		"  \"voucher\": \"sample string 8\",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"',\r\n" + 
				  		"  \"wbs\": '"+wbsid+"'\r\n" + 
				  		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/TravelClaim/InsertUpdateSupportTarvelClaim" , APIBody );
				  System.out.println(array);
				  claimid=array.get(0);
				  
				  
				  APIBody = "{\r\n" + 
				  		"  \"appliedAmount\": 1.0,\r\n" + 
				  		"  \"amountLimit\": 2.0,\r\n" + 
				  		"  \"amountAppliedTotal\": 3.0,\r\n" + 
				  		"  \"TravelClaimId\": "+claimid+",\r\n" + 
				  		"  \"totalExceed\": 5.0,\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
				  
				  response= postapidata.httpPost(postbaseurl+"api/TravelClaimView/CalculateAndUpdateExceedAmountForTravel" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 //Food
			 
		case "FoodClaim/InsertFoodClaim" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetFoodType" , APIBody );
				  System.out.println("Food array"+array);
					  
					  foodid=array.get(2);
					  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"foodPlace\": "+foodid+",\r\n" + 
			 		"  \"InvoiceNo\": \"565\",\r\n" + 
			 		"  \"GSTN\": \"45696936\",\r\n" + 
			 		"  \"CGSTAmt\": 14.0,\r\n" + 
			 		"  \"SGSTAmt\": 15.0,\r\n" + 
			 		"  \"IGSTAmt\": 16.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/InsertFoodClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "FoodClaim/GetMasterClaimID" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetFoodType" , APIBody );
				  System.out.println("Food array"+array);
					  
					  foodid=array.get(2);
					  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"foodPlace\": "+foodid+",\r\n" + 
			 		"  \"InvoiceNo\": \"565\",\r\n" + 
			 		"  \"GSTN\": \"45696936\",\r\n" + 
			 		"  \"CGSTAmt\": 14.0,\r\n" + 
			 		"  \"SGSTAmt\": 15.0,\r\n" + 
			 		"  \"IGSTAmt\": 16.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			
			  
			  
			   masterclaimid= postapidata.getonlydata(postbaseurl+"api/FoodClaim/InsertFoodClaim" , APIBody);
				  System.out.println("claimid is"+masterclaimid);
				  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			    	System.out.println("New masterclaimid is"+masterclaimid);
			    	
			    	APIBody = "{\r\n" + 
			    			"  \"ExpId\": "+masterclaimid+",\r\n" + 
			    			"  \"Domain\": '"+domaintext+"'\r\n" + 
			    			"}";
			    	
			    	  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetMasterClaimID" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
		
			 break;
			 
			 
			 
		case "FoodClaim/GetEmpAppliedClaimDataFood" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetFoodType" , APIBody );
				  System.out.println("Food array"+array);
					  
					  foodid=array.get(2);
					  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"foodPlace\": "+foodid+",\r\n" + 
			 		"  \"InvoiceNo\": \"565\",\r\n" + 
			 		"  \"GSTN\": \"45696936\",\r\n" + 
			 		"  \"CGSTAmt\": 14.0,\r\n" + 
			 		"  \"SGSTAmt\": 15.0,\r\n" + 
			 		"  \"IGSTAmt\": 16.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			
			  
			  
			   masterclaimid= postapidata.getonlydata(postbaseurl+"api/FoodClaim/InsertFoodClaim" , APIBody);
				  System.out.println("claimid is"+masterclaimid);
				  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			    	System.out.println("New masterclaimid is"+masterclaimid);
			    	
			    	APIBody = "{\r\n" + 
			    			"  \"ExpId\": "+masterclaimid+",\r\n" + 
			    			"  \"Domain\": '"+domaintext+"'\r\n" + 
			    			"}";
			    	
			    	  array= postapidata.getdata(postbaseurl+"api/FoodClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(0);
					  
					  APIBody = "{\r\n" + 
					  		"  \"claimWeek\": \"0\",\r\n" + 
					  		"  \"empID\": "+empdata+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
			    	  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetEmpAppliedClaimDataFood" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
		
			 break;
			 
			 
		case "FoodClaimView/GetEmpAppliedExpenseDataFood" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetFoodType" , APIBody );
				  System.out.println("Food array"+array);
					  
					  foodid=array.get(2);
					  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"foodPlace\": "+foodid+",\r\n" + 
			 		"  \"InvoiceNo\": \"565\",\r\n" + 
			 		"  \"GSTN\": \"45696936\",\r\n" + 
			 		"  \"CGSTAmt\": 14.0,\r\n" + 
			 		"  \"SGSTAmt\": 15.0,\r\n" + 
			 		"  \"IGSTAmt\": 16.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			
			  
			  
			   masterclaimid= postapidata.getonlydata(postbaseurl+"api/FoodClaim/InsertFoodClaim" , APIBody);
				  System.out.println("claimid is"+masterclaimid);
				  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			    	System.out.println("New masterclaimid is"+masterclaimid);
			    	
			    	APIBody = "{\r\n" + 
			    			"  \"ExpId\": "+masterclaimid+",\r\n" + 
			    			"  \"Domain\": '"+domaintext+"'\r\n" + 
			    			"}";
			    	
			    	  array= postapidata.getdata(postbaseurl+"api/FoodClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(7);
					  foodexpenseid=array.get(8);
					  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+claimid+",\r\n" + 
					  		"  \"ExpenseId\": "+foodexpenseid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
			    	  response= postapidata.httpPost(postbaseurl+"api/FoodClaimView/GetEmpAppliedExpenseDataFood" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
		
			 break;
			 
			 
			 
		case "UpdateFoodClaim" :
			
			 System.out.println("here");
				
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				
				  fromcityid=array.get(1);
				  tocityid=array.get(2);
				  System.out.println("from city"+fromcityid+"tocity"+tocityid);
				  
				  APIBody = "{\r\n" + 
					 		"  \"ClaimType\": \"Localclaim\",\r\n" + 
					 		"  \"band\": "+bandid+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
				  travelmodeid=array.get(1);
				  System.out.println("now here");
				  System.out.println("travel mode id is"+travelmodeid);
				  
				  
				  APIBody = "{\r\n" + 
					 		"  \"MasterType\": \"WBS\",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
				  wbsid= array.get(1);
				  System.out.println("wbs id is"+travelmodeid);
				  
//				  if(domaintext.equalsIgnoreCase("lechler"))
//				  {
//					  System.out.println("here typeofvisitid");
//					  APIBody = "{\r\n" + 
//						 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//						 		"  \"empid\": "+empdata+",\r\n" + 
//						 		"  \"Domain\": '"+domaintext+"'}";
//						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//						  typeofvisitid=array.get(1);
//				  }else
//				  {
//					  typeofvisitid="0";
//				  }
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetFoodType" , APIBody );
				  System.out.println("Food array"+array);
					  
					  foodid=array.get(1);
					  
				  APIBody = "{\r\n" + 
					 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
					  System.out.println("typeofvisit array is"+array);
					  typeofvisitid=array.get(1);
				  System.out.println("typeofvisit id is"+typeofvisitid);
			 APIBody = "{\r\n" + 
			 		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": 2,\r\n" + 
			 		"  \"NoOfDays\": 3,\r\n" + 
			 		"  \"amount\": 4.0,\r\n" + 
			 		"  \"Remarks\": \"sample string 5\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"empId\": '"+empdata+"',\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"TaxAmt\": 9.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"foodPlace\": "+foodid+",\r\n" + 
			 		"  \"InvoiceNo\": \"565\",\r\n" + 
			 		"  \"GSTN\": \"45696936\",\r\n" + 
			 		"  \"CGSTAmt\": 14.0,\r\n" + 
			 		"  \"SGSTAmt\": 15.0,\r\n" + 
			 		"  \"IGSTAmt\": 16.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"OtherFromCity\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			
			  
			  
			   masterclaimid= postapidata.getonlydata(postbaseurl+"api/FoodClaim/InsertFoodClaim" , APIBody);
				  System.out.println("claimid is"+masterclaimid);
				  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			    	System.out.println("New masterclaimid is"+masterclaimid);
			    	
			    	APIBody = "{\r\n" + 
			    			"  \"ExpId\": "+masterclaimid+",\r\n" + 
			    			"  \"Domain\": '"+domaintext+"'\r\n" + 
			    			"}";
			    	
			    	  array= postapidata.getdata(postbaseurl+"api/FoodClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(7);
					  foodexpenseid=array.get(8);
					  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+claimid+",\r\n" + 
					  		"  \"FoodClaimId\": "+foodexpenseid+",\r\n" + 
					  		"  \"TravelDate\": '"+dtf.format(localDate)+"',\r\n" + 
					  		"  \"Location\": 4,\r\n" + 
					  		"  \"NoOfDays\": 5,\r\n" + 
					  		"  \"Amount\": 6.0,\r\n" + 
					  		"  \"Remarks\": \"sample string 7\",\r\n" + 
					  		"  \"WBS\": "+wbsid+",\r\n" + 
					  		"  \"TaxAmt\": 9.0,\r\n" + 
					  		"  \"GSTIncluded\": true,\r\n" + 
					  		"  \"FoodPlace\": "+foodid+",\r\n" + 
					  		"  \"InvoiceNo\": \"sample string 12\",\r\n" + 
					  		"  \"GSTN\": \"sample string 13\",\r\n" + 
					  		"  \"CGSTAmt\": 14.0,\r\n" + 
					  		"  \"SGSTAmt\": 15.0,\r\n" + 
					  		"  \"IGSTAmt\": 16.0,\r\n" + 
					  		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					  		"  \"TravelDateTo\": '"+dtf.format(localDate)+"',\r\n" + 
					  		"  \"OtherFromCity\": \"''\",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
			    	  response= postapidata.httpPost(postbaseurl+"api/FoodClaimView/UpdateFoodClaim" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
		
			 break;
			 
			 
		

		
			 
			 
			 
			 
		}
	}
	
	
	
	
	

}
