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

public class FoodAttendanceclaim extends Urls {

	
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
		
		
			
			 
		case "FoodClaim/InsertArtistClaim" :
			
			
			
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
			  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/InsertArtistClaim" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "FoodClaim/GetFoodTypeById" :
			
			
			
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
			 		"  \"id\": "+foodclaimid+"\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetFoodTypeById" , APIBody);
				 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "FoodClaim/getClaimById" :
			
			
			
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
			 		"  \"claimid\": "+foodclaimid+"\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/getClaimById" , APIBody);
				 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
		case "FoodClaim/GetFoodClaimStatusDetails" :
			
			
			
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
			 		"  \"empID\": "+empdata+",\r\n" + 
			 		"  \"month\": 0,\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+"\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetFoodClaimStatusDetails" , APIBody);
				 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
		case "FoodClaim/deleteClaimById" :
			
			
			
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
			 		"  \"rMessage\": \"''\"\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetFoodClaimStatusDetails" , APIBody);
				 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
			 
		case "FoodClaim/getCoempClaimDate" :
			
			
			
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
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"date\": '"+dtf.format(localDate)+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/getCoempClaimDate" , APIBody);
				 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "FoodClaim/getClaimStatus" :
			
		
			 APIBody = "{\r\n" + 
			 		"  \"domain\": '"+domaintext+"',\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"claimtypeid\": 12\r\n" + 
			 		"  \r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/getClaimStatus" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "FoodClaim/GetFoodWiseClaimStatus" :
			

			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCoEmployeeFoodType" , APIBody );
				  foodid = array.get(1);
			 APIBody = "{\r\n" + 
			 		"  \"domain\": '"+domaintext+"',\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"claimtypeid\": 3,\r\n" + 
			 		"  \"foodTypeId\": "+foodid+"\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetFoodWiseClaimStatus" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "FoodClaim/GetAllClaimStatus" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"domain\": '"+domaintext+"',\r\n" + 
			 		"  \"empid\": "+empdata+"\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetAllClaimStatus" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "FoodClaim/GetAllClaimStatusConditionWise" :
			

			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCoEmployeeFoodType" , APIBody );
				  foodid = array.get(1);
			 APIBody = "{\r\n" + 
			 		"  \"domain\": '"+domaintext+"',\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"claimtypeid\": \"12\",\r\n" + 
			 		"  \"foodtypeid\": "+foodid+",\r\n" + 
			 		"  \"month\": '"+(current.get(Calendar.MONTH)+1)+"',\r\n" + 
			 		"  \"year\": '"+current.get(Calendar.YEAR)+"',\r\n" + 
			 		"  \"claimstatus\": \"pending\"\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetAllClaimStatusConditionWise" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "FoodClaim/GetAllClaimRejectedStatus" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"domain\": '"+domaintext+"',\r\n" + 
			 		"  \"empid\": "+empdata+"\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetAllClaimRejectedStatus" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
	   case "FoodClaim/GetEmpPendingClaimStatus" :
					

					 APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCoEmployeeFoodType" , APIBody );
						  foodid = array.get(1);
					 APIBody = "{\r\n" + 
					 		"  \"domain\": '"+domaintext+"',\r\n" + 
					 		"  \"empid\": "+empdata+",\r\n" + 
					 		"  \"claimtypeid\": 12,\r\n" + 
					 		"  \"foodTypeId\": "+foodid+"\r\n" + 
					 		"}";
					  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetEmpPendingClaimStatus" , APIBody);
					 assertTrue(response.equalsIgnoreCase("1"));
					 break;
					 
					 
	   case "FoodClaim/GetClaimCoditionWise" :
			

			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCoEmployeeFoodType" , APIBody );
				  foodid = array.get(1);
			 APIBody = "{\r\n" + 
			 		"  \"domain\": '"+domaintext+"',\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"claimstatus\": \"pending\",\r\n" + 
			 		"  \"coempid\": \"''\",\r\n" + 
			 		"  \"fromdate\": "+dtf.format(localDate)+",\r\n" + 
			 		"  \"todate\": "+dtf.format(localDate)+"\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetClaimCoditionWise" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "FoodClaim/GetArtistDFoodDetailsByID" :
			
			
			
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
			 		"  \"claimId\": "+foodclaimid+",\r\n" + 
			 		"  \"domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetArtistDFoodDetailsByID" , APIBody);
				 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
		case "FoodClaim/UpdateArtistClaim" :
			
			
			
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
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"coempid\": \"''\",\r\n" + 
			 		"  \"claimdate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"shiftId\": "+shiftid+",\r\n" + 
			 		"  \"amount\": 6.0,\r\n" + 
			 		"  \"voucher\": \"sample string 7\",\r\n" + 
			 		"  \"claimStatus\": \"pending\",\r\n" + 
			 		"  \"claimtypeid\": 12,\r\n" + 
			 		"  \"foodtypeid\": "+foodid+",\r\n" + 
			 		"  \"claimId\": "+foodclaimid+",\r\n" + 
			 		"  \"Remarks\": \"sample string 12\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"BillAmt\": 14.0\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/UpdateArtistClaim" , APIBody);
				 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "FoodClaim/GetLocalClaimAppliedbyDate" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"domain\": '"+domaintext+"',\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"date\": '"+dtf.format(localDate)+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetLocalClaimAppliedbyDate" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "FoodClaim/GetCheckAppliedCoEmpData" :
			
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
			 APIBody = "{\r\n" + 
			 		"  \"date\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"shift\": "+shiftid+",\r\n" + 
			 		"  \"foodtype\": "+foodid+",\r\n" + 
			 		"  \"coEmpIDs\": \"''\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/FoodClaim/GetCheckAppliedCoEmpData" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "FoodClaimView/GetFoodClaims" :
			
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
			 		"  \"foodPlace\": 683,\r\n" + 
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
					  claimid=array.get(5);
					  foodexpenseid=array.get(4);
					  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+claimid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
			    	  response= postapidata.httpPost(postbaseurl+"api/FoodClaimView/GetFoodClaims" , APIBody);
					 assertTrue(response.equalsIgnoreCase("1"));
		
			 break;
		}
	}
}
