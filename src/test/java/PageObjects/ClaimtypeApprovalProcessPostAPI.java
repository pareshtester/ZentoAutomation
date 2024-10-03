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

public class ClaimtypeApprovalProcessPostAPI  extends Urls{
	

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
	String advanceid="";
	String advancetypeid="";
	String advanceclaimid="";
	String advanceexpenseid="";
	String travelexpense="";
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
		
		//Dashboard
		
		case "Dashboard/GetClaimDetailsByClaimID" :
			
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
			  claimid=array.get(6);

			 APIBody = "{\r\n" + 
			 		"  \"ClaimID\": "+claimid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Dashboard/GetClaimDetailsByClaimID" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			
			 
		case "Submit/SubmitClaim" :
			
			
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
				  System.out.println("wbs id is"+wbsid);
				  
				  
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
			  claimid=array.get(5);
			  localexpenseid=array.get(6);
			  System.out.println("localexpenseid"+localexpenseid);
			  APIBody = "{\r\n" + 
			  		"  \"claim_id\": "+claimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/Submit/SubmitClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "Submit/GetAllClaimsToSubmit" :
			
			
			
			  APIBody = "{\r\n" + 
			  		"  \"EmpId\": "+empdata+",\r\n" + 
			  		"  \"week\": \"0\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/Submit/GetAllClaimsToSubmit" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "ClaimProcessing/ApproveDissapproveClaim" :
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
				  System.out.println("wbs id is"+wbsid);
				  
				  
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
			  claimid=array.get(5);
			  localexpenseid=array.get(6);
			  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
			  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
			  System.out.println(array);
			
			managerdata= array.get(7);
			
			  APIBody = "{\r\n" + 
			  		"  \"claim_id\": '"+claimid+"',\r\n" + 
			  		"  \"recc_Level\": 1,\r\n" + 
			  		"  \"reccID\": "+managerdata+",\r\n" + 
			  		"  \"remarks\": \"sample string 4\",\r\n" + 
			  		"  \"action\": 0,\r\n" + 
			  		"  \"amount\": 6.0,\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/ClaimProcessing/ApproveDissapproveClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "ClaimProcessing/ApproveDissapproveClaims" :
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
				  System.out.println("wbs id is"+wbsid);
				  
				  
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
			  claimid=array.get(5);
			  localexpenseid=array.get(6);
			  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
			  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
			  System.out.println(array);
			
			managerdata= array.get(7);
			
			  APIBody = "{\r\n" + 
			  		"  \"claim_id\": '"+claimid+"',\r\n" + 
			  		"  \"reccID\": "+managerdata+",\r\n" + 
			  		"  \"remarks\": \"sample string 3\",\r\n" + 
			  		"  \"action\": 1,\r\n" + 
			  		"  \"status\": \"pending\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/ClaimProcessing/ApproveDissapproveClaims" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "ClaimProcessing/Valiadte_LandLineClaim" :
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
					  claimid=array.get(5);
					  landlineexpenseid=array.get(6);
					  System.out.println("localexpenseid"+localexpenseid);
			
		
			
			  APIBody = "{\r\n" + 
			  		"  \"date_from\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"date_to\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"emp_Id\": "+empdata+",\r\n" + 
			  		"  \"expenseID\": "+landlineexpenseid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/ClaimProcessing/Valiadte_LandLineClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "ClaimProcessing/ApproveClaim" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCoEmployeeFoodType" , APIBody );
				  foodid = array.get(1);
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
			  shiftid=array.get(1);
				 
	
			
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
			 		"  \"domain\": '"+domaintext+"',\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"coempid\": \",\",\r\n" + 
			 		"  \"claimdate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"shiftId\": "+shiftid+",\r\n" + 
			 		"  \"amount\": 6.0,\r\n" + 
			 		"  \"voucher\": \"sample string 7\",\r\n" + 
			 		"  \"claimStatus\": \"sample string 8\",\r\n" + 
			 		"  \"claimtypeid\": 12,\r\n" + 
			 		"  \"foodtypeid\": "+foodid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 11\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"BillAmt\": 13.0\r\n" + 
			 		"}";
			  foodclaimid= postapidata.getonlydata(postbaseurl+"api/FoodClaim/InsertArtistClaim" , APIBody);
			  foodclaimid = foodclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  foodclaimid = foodclaimid.replaceAll("^[\\\"']+|[\\\"']+$", "");
		    	System.out.println("New foodclaimid is"+foodclaimid);
			 System.out.println(foodclaimid);
			
			  APIBody = "{\r\n" + 
			  		"  \"domain\": '"+domaintext+"',\r\n" + 
			  		"  \"claimid\": "+foodclaimid+",\r\n" + 
			  		"  \"empid\": "+empdata+"\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/ClaimProcessing/ApproveClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "ClaimProcessing/DisapproveClaim" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCoEmployeeFoodType" , APIBody );
				  foodid = array.get(1);
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
			  shiftid=array.get(1);
				 
	
			
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
			 		"  \"domain\": '"+domaintext+"',\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"coempid\": \",\",\r\n" + 
			 		"  \"claimdate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"shiftId\": "+shiftid+",\r\n" + 
			 		"  \"amount\": 6.0,\r\n" + 
			 		"  \"voucher\": \"sample string 7\",\r\n" + 
			 		"  \"claimStatus\": \"sample string 8\",\r\n" + 
			 		"  \"claimtypeid\": 12,\r\n" + 
			 		"  \"foodtypeid\": "+foodid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 11\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"BillAmt\": 13.0\r\n" + 
			 		"}";
			  foodclaimid= postapidata.getonlydata(postbaseurl+"api/FoodClaim/InsertArtistClaim" , APIBody);
			  foodclaimid = foodclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  foodclaimid = foodclaimid.replaceAll("^[\\\"']+|[\\\"']+$", "");
		    	System.out.println("New foodclaimid is"+foodclaimid);
			 System.out.println(foodclaimid);
			
			  APIBody = "{\r\n" + 
			  		"  \"domain\": '"+domaintext+"',\r\n" + 
			  		"  \"claimid\": "+foodclaimid+",\r\n" + 
			  		"  \"empid\": "+empdata+"\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/ClaimProcessing/DisapproveClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "ClaimProcessing/DisapproveClaimForInternalAutoReject" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCoEmployeeFoodType" , APIBody );
				  foodid = array.get(1);
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
			  shiftid=array.get(1);
				 
	
			
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
			 		"  \"domain\": '"+domaintext+"',\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"coempid\": \",\",\r\n" + 
			 		"  \"claimdate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"shiftId\": "+shiftid+",\r\n" + 
			 		"  \"amount\": 6.0,\r\n" + 
			 		"  \"voucher\": \"sample string 7\",\r\n" + 
			 		"  \"claimStatus\": \"sample string 8\",\r\n" + 
			 		"  \"claimtypeid\": 12,\r\n" + 
			 		"  \"foodtypeid\": "+foodid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 11\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"BillAmt\": 13.0\r\n" + 
			 		"}";
			  foodclaimid= postapidata.getonlydata(postbaseurl+"api/FoodClaim/InsertArtistClaim" , APIBody);
			  foodclaimid = foodclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  foodclaimid = foodclaimid.replaceAll("^[\\\"']+|[\\\"']+$", "");
		    	System.out.println("New foodclaimid is"+foodclaimid);
			 System.out.println(foodclaimid);
			
			  APIBody = "{\r\n" + 
			  		"  \"domain\": '"+domaintext+"',\r\n" + 
			  		"  \"claimid\": "+foodclaimid+",\r\n" + 
			  		"  \"empid\": "+empdata+"\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/ClaimProcessing/DisapproveClaimForInternalAutoReject" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 //RptClaimDetails
			 
		case "RptClaimDetails/GetApproverClaimCount" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			
			 APIBody = "{\r\n" + 
			 		"  \"EMPId\": "+empdata+",\r\n" + 
			 		"  \"month\": 0,\r\n" + 
			 		"  \"year\": \"2019\",\r\n" + 
			 		"  \"week\": \"sample string 4\",\r\n" + 
			 		"  \"action\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/RptClaimDetails/GetApproverClaimCount" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
				 
		case "RptClaimDetails/GetApproverClaimsByClaimType" :
			
			 APIBody = "{\r\n" + 
				 		"  \"MasterType\": \"WBS\",\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
			  wbsid= array.get(1);
			
			 APIBody = "{\r\n" + 
			 		"  \"EMPId\": "+empdata+",\r\n" + 
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"clamType\": 5,\r\n" + 
			 		"  \"action\": \"pending\",\r\n" + 
			 		"  \"sortBy\": \"status\",\r\n" + 
			 		"  \"Employee\": 8,\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"ClientBorrower\": "+wbsid+",\r\n" + 
			 		"  \"FilterType\": \"sample string 12\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/RptClaimDetails/GetApproverClaimsByClaimType" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
				 
				 //Apply claim
				 
		case "ApplyClaim/GetCheckAppliedClaimsCWeek" :
			
			
			
			 APIBody = "{\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"ClaimWeek\": \"0\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/ApplyClaim/GetCheckAppliedClaimsCWeek" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
		case "ApplyClaim/CheckClaimExist" :
			
			
			
			 APIBody = "{\r\n" + 
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"EmpId\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/ApplyClaim/CheckClaimExist" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
		case "LevelIndicator/GetClaimApprover" :
			
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
			  claimid=array.get(5);
			  localexpenseid=array.get(6);
			
			 APIBody = "{\r\n" + 
			 		"  \"ClaimID\": "+claimid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/LevelIndicator/GetClaimApprover" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
		
		case "Dashboard/GetClaim" :
			
			
			
			 APIBody = "{\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"Year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"Week\":\"0\",\r\n" + 
			 		"  \"sortBy\": \"claimid\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/Dashboard/GetClaim" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
		
			 //DeleteExpenses
		case "DeleteExpenses/DeleteExpense" :
			
			 System.out.println("here");
			 
				
			 
			 
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
			  shiftid=array.get(1);
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
				  travelexpense = array.get(1);
			
			 APIBody = "{\r\n" + 
			 		"  \"mode\": \"travelclaim\",\r\n" + 
			 		"  \"ExpenseId\": "+travelexpense+",\r\n" + 
			 		"  \"ClaimId\": "+claimid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/DeleteExpenses/DeleteExpense" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
		}
		
	}

}
