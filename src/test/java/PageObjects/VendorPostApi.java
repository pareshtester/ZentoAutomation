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

public class VendorPostApi extends Urls {
	  
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
		String stateid="";
		String designationid="";
		String vendorid="";
		String poid="";
		String termid="";
		String termtext="";
		String cycleamount="";
		String invoiceno="688482";
		String postatus="";
		String podocid="";
		String POnumber="6393";
		String invoiceid="";
		String invoicedocid="";
		String depatmentdata="";
		
		int k=0;
		Calendar current = Calendar.getInstance();
		ArrayList<String> array = new ArrayList<String>();

		String travelpolicybindcode="";
		DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		ExtendedCallAPI ecapi= new ExtendedCallAPI();
		PostAPIPage postapi = new PostAPIPage();
		capturePostAPIData postapidata= new capturePostAPIData();
		
		public void steps(String functiontext,String username,String password,String managerusername,String managerpassword,String policytype,String Gstn,String pannum,String ponum,String invoiceno,String domaintext) throws JSONException, InterruptedException 
		{
			
		
			
			  APIBody = "{\r\n" + 
				  		"  \"Email\": '"+managerusername+"',\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
				 ArrayList<String> array=  postapidata.Postarray(postbaseurl+"api/Vendor/DeleteVendorAllDetails" , APIBody );
				 String successmessage =array.get(1);
				 assertTrue(successmessage.equalsIgnoreCase("Details Deleted Successfully"));
			
			GetApiData gdata1 = new  GetApiData();
			capturePostAPIData postapidata= new capturePostAPIData();
			
			  
			 System.out.println("here"+functiontext);
			switch(functiontext){
			
			
				
				 
			case "Vendor/RegisterVendor" :
				
				
				
				 APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
					  fromcityid = array.get(1);
					  
					  APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
						  stateid = array.get(1);
				
						  APIBody = "{\r\n" + 
							 		"  \"Domain\": '"+domaintext+"'\r\n" + 
							 		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
							  System.out.println(array);
							  designationid = array.get(1);

					  System.out.println("designationid id is"+designationid);
				 APIBody = "{\r\n" + 
				 		"  \"companyName\": \"gdata12\",\r\n" + 
				 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
				 		"  \"phone\": \"8698294937\",\r\n" + 
				 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
				 		"  \"branch\": 5,\r\n" + 
				 		"  \"address\": \"sample string 6\",\r\n" + 
				 		"  \"city\": "+fromcityid+",\r\n" + 
				 		"  \"state\": "+stateid+",\r\n" + 
				 		"  \"country\": 9,\r\n" + 
				 		"  \"pincode\": \"sample string 10\",\r\n" + 
				 		"  \"gst\": '"+Gstn+"',\r\n" + 
				 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
				 		"  \"designation\": "+designationid+",\r\n" + 
				 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
				 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
				 		"  \"userName\": '"+managerusername+"',\r\n" + 
				 		"  \"password\": \"sample string 17\",\r\n" + 
				 		"  \"bank\": \"sample string 18\",\r\n" + 
				 		"  \"accountno\": \"sample string 19\",\r\n" + 
				 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
				 		"  \"pan\": '"+pannum+"',\r\n" + 
				 		"  \"createdy\": 22,\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
			case "Vendor/GetVendorListdetails" :
				
				APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 response= postapidata.httpPost(postbaseurl+"api/Vendor/GetVendorListdetails" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
			
				 
				 
				 
			case "Vendor/VendorDetailsByVendorID" :
				
				
				 APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
					  fromcityid = array.get(1);
					  
					  APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
						  stateid = array.get(1);
				
						  APIBody = "{\r\n" + 
							 		"  \"Domain\": '"+domaintext+"'\r\n" + 
							 		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
							  System.out.println(array);
							  designationid = array.get(1);

					  System.out.println("designationid id is"+designationid);
					  APIBody = "{\r\n" + 
						 		"  \"companyName\": \"gdata12\",\r\n" + 
						 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
						 		"  \"phone\": \"8698294937\",\r\n" + 
						 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
						 		"  \"branch\": 5,\r\n" + 
						 		"  \"address\": \"sample string 6\",\r\n" + 
						 		"  \"city\": "+fromcityid+",\r\n" + 
						 		"  \"state\": "+stateid+",\r\n" + 
						 		"  \"country\": 9,\r\n" + 
						 		"  \"pincode\": \"sample string 10\",\r\n" + 
						 		"  \"gst\": '"+Gstn+"',\r\n" + 
						 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
						 		"  \"designation\": "+designationid+",\r\n" + 
						 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
						 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
						 		"  \"userName\": '"+managerusername+"',\r\n" + 
						 		"  \"password\": \"sample string 17\",\r\n" + 
						 		"  \"bank\": \"sample string 18\",\r\n" + 
						 		"  \"accountno\": \"sample string 19\",\r\n" + 
						 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
						 		"  \"pan\": '"+pannum+"',\r\n" + 
						 		"  \"createdy\": 22,\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
				  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
				  
				
				APIBody = "{\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"search\": \"''\",\r\n" + 
						"  \"year\": 0,\r\n" + 
						"  \"month\": 0,\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
				
				
				 response= postapidata.httpPost(postbaseurl+"api/Vendor/VendorDetailsByVendorID" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
			case "Vendor/UpdateVendorData" :
				
				 APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
					  fromcityid = array.get(1);
					  
					  APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
						  stateid = array.get(1);
				
						  APIBody = "{\r\n" + 
							 		"  \"Domain\": '"+domaintext+"'\r\n" + 
							 		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
							  System.out.println(array);
							  designationid = array.get(1);

					  System.out.println("designationid id is"+designationid);
					  APIBody = "{\r\n" + 
						 		"  \"companyName\": \"gdata12\",\r\n" + 
						 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
						 		"  \"phone\": \"8698294937\",\r\n" + 
						 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
						 		"  \"branch\": 5,\r\n" + 
						 		"  \"address\": \"sample string 6\",\r\n" + 
						 		"  \"city\": "+fromcityid+",\r\n" + 
						 		"  \"state\": "+stateid+",\r\n" + 
						 		"  \"country\": 9,\r\n" + 
						 		"  \"pincode\": \"sample string 10\",\r\n" + 
						 		"  \"gst\": '"+Gstn+"',\r\n" + 
						 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
						 		"  \"designation\": "+designationid+",\r\n" + 
						 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
						 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
						 		"  \"userName\": '"+managerusername+"',\r\n" + 
						 		"  \"password\": \"sample string 17\",\r\n" + 
						 		"  \"bank\": \"sample string 18\",\r\n" + 
						 		"  \"accountno\": \"sample string 19\",\r\n" + 
						 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
						 		"  \"pan\": '"+pannum+"',\r\n" + 
						 		"  \"createdy\": 22,\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
				  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
				  
				
				 APIBody = "{\r\n" + 
				 		"  \"VendorID\": "+vendorid+",\r\n" + 
				 		"  \"companyName\": \"Gdata1Test\",\r\n" + 
				 		"  \"typeOfBusiness\": \"Gdata1test\",\r\n" + 
				 		"  \"phone\": \"98767890987\",\r\n" + 
				 		"  \"emailID\": \"yfu@gdta.in\",\r\n" + 
				 		"  \"branch\": 6,\r\n" + 
				 		"  \"address\": \"sample string 7\",\r\n" + 
				 		"  \"city\": "+fromcityid+",\r\n" + 
				 		"  \"state\": "+stateid+",\r\n" + 
				 		"  \"country\": 10,\r\n" + 
				 		"  \"pincode\": \"sample string 11\",\r\n" + 
				 		"  \"gst\": '"+Gstn+"',\r\n" + 
				 		"  \"contactPerson\": \"sample string 14\",\r\n" + 
				 		"  \"designation\": "+designationid+",\r\n" + 
				 		"  \"contactPersonMobile\": \"sample string 15\",\r\n" + 
				 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
				 		"  \"bank\": \"sample string 17\",\r\n" + 
				 		"  \"accountno\": \"sample string 18\",\r\n" + 
				 		"  \"ifsccode\": \"sample string 19\",\r\n" + 
				 		"  \"pan\": '"+pannum+"',\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
					
					  
					  response= postapidata.httpPost(postbaseurl+"api/Vendor/UpdateVendorData" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					  break;
					  
			case "Vendor/Login" :
				
				 APIBody = "{\r\n" + 
				 		"  \"mode\": \"Login\",\r\n" + 
				 		"  \"username\": \""+managerusername+"\",\r\n" + 
				 		"  \"password\": \""+managerpassword+"\",\r\n" + 
				 		"  \"Domain\": \'"+domaintext+"'\r\n" + 
				 		"}";
					  
					  
					  response= postapidata.httpPost(postbaseurl+"api/Vendor/Login" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					  break;
					  
			case "Vendor/ActiveInactiveVendor" :
				
				APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				  fromcityid = array.get(1);
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
					  stateid = array.get(1);
			
					  APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
						  System.out.println(array);
						  designationid = array.get(1);

				  System.out.println("designationid id is"+designationid);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
			  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
				
				 APIBody = "{\r\n" + 
				 		"  \"VendorID\": "+vendorid+",\r\n" + 
				 		"  \"Action\": \"Active\",\r\n" + 
				 		"  \"Domain\": \'"+domaintext+"'\r\n" + 
				 		"}";
					  
					  
					  response= postapidata.httpPost(postbaseurl+"api/Vendor/ActiveInactiveVendor" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));	
					  break;
					 
			case "Vendor/ChangePassword" :
				
				APIBody = "{\r\n" + 
						"  \"mode\": \"changepassword\",\r\n" + 
						"  \"username\": \"manali.h@gdata.in\",\r\n" + 
						"  \"oldpass\": \"Vendor123\",\r\n" + 
						"  \"newpass\": \"Vendor123\",\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}"; 
				
				 response= postapidata.httpPost(postbaseurl+"api/Vendor/ChangePassword" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));	
				break;
					  
			case "Vendor/GetDuplicateVendorDetails" :
				
				APIBody = "{\r\n" + 
						"  \"EmailID\": \"manali.h@gdata.in\",\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}"; 
				
				 response= postapidata.httpPost(postbaseurl+"api/Vendor/GetDuplicateVendorDetails" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));	
				break;
				
				
			case "Vendor/ForgotPassword" :
				
				APIBody = "{\r\n" + 
						"  \"EmailID\": \"paresh.patil@gdata.in\",\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}"; 
				
				 response= postapidata.httpPost(postbaseurl+"api/Vendor/ForgotPassword" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));	
				break;
				
			case "Vendor/GetActiveVendorDetails" :
				
				APIBody = "{\r\n" + 
						"  \"EmailID\": \"paresh.patil@gdata.in\",\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}"; 
				
				 response= postapidata.httpPost(postbaseurl+"api/Vendor/GetActiveVendorDetails" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));	
				break;
				
			case "PO/CreatePO" :
				APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				  fromcityid = array.get(1);
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
					  stateid = array.get(1);
			
					  APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
						  System.out.println(array);
						  designationid = array.get(1);
						  APIBody = "{\r\n" + 
							 		"  \"companyName\": \"gdata12\",\r\n" + 
							 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
							 		"  \"phone\": \"8698294937\",\r\n" + 
							 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
							 		"  \"branch\": 5,\r\n" + 
							 		"  \"address\": \"sample string 6\",\r\n" + 
							 		"  \"city\": "+fromcityid+",\r\n" + 
							 		"  \"state\": "+stateid+",\r\n" + 
							 		"  \"country\": 9,\r\n" + 
							 		"  \"pincode\": \"sample string 10\",\r\n" + 
							 		"  \"gst\": '"+Gstn+"',\r\n" + 
							 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
							 		"  \"designation\": "+designationid+",\r\n" + 
							 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
							 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
							 		"  \"userName\": '"+managerusername+"',\r\n" + 
							 		"  \"password\": \"sample string 17\",\r\n" + 
							 		"  \"bank\": \"sample string 18\",\r\n" + 
							 		"  \"accountno\": \"sample string 19\",\r\n" + 
							 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
							 		"  \"pan\": '"+pannum+"',\r\n" + 
							 		"  \"createdy\": 22,\r\n" + 
							 		"  \"Domain\": '"+domaintext+"'\r\n" + 
							 		"}";
				  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
					
				System.out.println("here ");
				
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}"; 
				
				 response= postapidata.httpPost(postbaseurl+"api/PO/CreatePO" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));	
				break;
				
			case "PO/GetPOList" :
				
				APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				  fromcityid = array.get(1);
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
					  stateid = array.get(1);
			
					  APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
						  System.out.println(array);
						  designationid = array.get(1);
						  APIBody = "{\r\n" + 
							 		"  \"companyName\": \"gdata12\",\r\n" + 
							 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
							 		"  \"phone\": \"8698294937\",\r\n" + 
							 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
							 		"  \"branch\": 5,\r\n" + 
							 		"  \"address\": \"sample string 6\",\r\n" + 
							 		"  \"city\": "+fromcityid+",\r\n" + 
							 		"  \"state\": "+stateid+",\r\n" + 
							 		"  \"country\": 9,\r\n" + 
							 		"  \"pincode\": \"sample string 10\",\r\n" + 
							 		"  \"gst\": '"+Gstn+"',\r\n" + 
							 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
							 		"  \"designation\": "+designationid+",\r\n" + 
							 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
							 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
							 		"  \"userName\": '"+managerusername+"',\r\n" + 
							 		"  \"password\": \"sample string 17\",\r\n" + 
							 		"  \"bank\": \"sample string 18\",\r\n" + 
							 		"  \"accountno\": \"sample string 19\",\r\n" + 
							 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
							 		"  \"pan\": '"+pannum+"',\r\n" + 
							 		"  \"createdy\": 22,\r\n" + 
							 		"  \"Domain\": '"+domaintext+"'\r\n" + 
							 		"}";
				  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
					
				System.out.println("here ");
				
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}"; 
				
				 response= postapidata.httpPost(postbaseurl+"api/PO/CreatePO" , APIBody);
				
				APIBody = "{\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}"; 
				
				 response= postapidata.httpPost(postbaseurl+"api/PO/GetPOList" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));	
				break;
				
			case "PurchaseOrder/GetPODetailsByID" :
				
				
				APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				  fromcityid = array.get(1);
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
					  stateid = array.get(1);
			
					  APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
						  System.out.println(array);
						  designationid = array.get(1);
						  APIBody = "{\r\n" + 
							 		"  \"companyName\": \"gdata12\",\r\n" + 
							 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
							 		"  \"phone\": \"8698294937\",\r\n" + 
							 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
							 		"  \"branch\": 5,\r\n" + 
							 		"  \"address\": \"sample string 6\",\r\n" + 
							 		"  \"city\": "+fromcityid+",\r\n" + 
							 		"  \"state\": "+stateid+",\r\n" + 
							 		"  \"country\": 9,\r\n" + 
							 		"  \"pincode\": \"sample string 10\",\r\n" + 
							 		"  \"gst\": '"+Gstn+"',\r\n" + 
							 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
							 		"  \"designation\": "+designationid+",\r\n" + 
							 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
							 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
							 		"  \"userName\": '"+managerusername+"',\r\n" + 
							 		"  \"password\": \"sample string 17\",\r\n" + 
							 		"  \"bank\": \"sample string 18\",\r\n" + 
							 		"  \"accountno\": \"sample string 19\",\r\n" + 
							 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
							 		"  \"pan\": '"+pannum+"',\r\n" + 
							 		"  \"createdy\": 22,\r\n" + 
							 		"  \"Domain\": '"+domaintext+"'\r\n" + 
							 		"}";
				  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
					
				System.out.println("here ");
				
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
				
				 array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody);
				 poid =array.get(0);
					System.out.println("here "+poid);	
				APIBody = "{\r\n" + 
						"  \"POID\": "+poid+",\r\n" + 
						"  \"intVendorID\": "+vendorid+",\r\n" + 
						"  \"search\": \"sample string 3\",\r\n" + 
						"  \"year\": 0,\r\n" + 
						"  \"month\": 0,\r\n" + 
						"  \"ponumber\": \"8814\",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}"; 
				
				 response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/GetPODetailsByID" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));	
				break;
				
			case "PurchaseOrder/UpdatePO" :
				
				APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
				  fromcityid = array.get(1);
				  
				  APIBody = "{\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
					  stateid = array.get(1);
			
					  APIBody = "{\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'\r\n" + 
						 		"}";
						  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
						  System.out.println(array);
						  designationid = array.get(1);
						  APIBody = "{\r\n" + 
							 		"  \"companyName\": \"gdata12\",\r\n" + 
							 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
							 		"  \"phone\": \"8698294937\",\r\n" + 
							 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
							 		"  \"branch\": 5,\r\n" + 
							 		"  \"address\": \"sample string 6\",\r\n" + 
							 		"  \"city\": "+fromcityid+",\r\n" + 
							 		"  \"state\": "+stateid+",\r\n" + 
							 		"  \"country\": 9,\r\n" + 
							 		"  \"pincode\": \"sample string 10\",\r\n" + 
							 		"  \"gst\": '"+Gstn+"',\r\n" + 
							 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
							 		"  \"designation\": "+designationid+",\r\n" + 
							 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
							 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
							 		"  \"userName\": '"+managerusername+"',\r\n" + 
							 		"  \"password\": \"sample string 17\",\r\n" + 
							 		"  \"bank\": \"sample string 18\",\r\n" + 
							 		"  \"accountno\": \"sample string 19\",\r\n" + 
							 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
							 		"  \"pan\": '"+pannum+"',\r\n" + 
							 		"  \"createdy\": 22,\r\n" + 
							 		"  \"Domain\": '"+domaintext+"'\r\n" + 
							 		"}";
				  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
					
				System.out.println("here ");
				
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}"; 
				
				 array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody);
				 poid =array.get(0);
					System.out.println("here "+poid);	
			
			
				
				APIBody = "{\r\n" + 
						"  \"POID\": "+poid+",\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"PODate\": \"2019-12-23T12:14:32.1584356+05:30\",\r\n" + 
						"  \"PODateExpiry\": \"2019-12-23T12:14:32.1584356+05:30\",\r\n" + 
						"  \"Remark\": \"sample string 6\",\r\n" + 
						"  \"numAmt\": 7.0,\r\n" + 
						"  \"numAdvanceAmt\": 8.0,\r\n" + 
						"  \"Recc1\": 9,\r\n" + 
						"  \"Recc2\": 10,\r\n" + 
						"  \"Recc3\": 11,\r\n" + 
						"  \"Recc4\": 12,\r\n" + 
						"  \"Recc5\": 13,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}"; 
				
				 response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/UpdatePO" , APIBody);
				 System.out.println("update po response "+response);
				  assertTrue(response.equalsIgnoreCase("1"));	
				break;
				
			case "PurchaseOrder/GetPaymentCycle" :
				
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
					  
//					  APIBody = "{\r\n" + 
//						  		"  \"Action\": \"Periodic\",\r\n" + 
//						  		"  \"Term\": \"Monthly\",\r\n" + 
//						  		"  \"amt\": 6000.0,\r\n" + 
//						  		"  \"advamt\": 0,\r\n" + 
//						  		"  \"percent\": \"0\",\r\n" + 
//						  		"  \"fromdate\": \"01/01/2019\",\r\n" + 
//						  		"  \"todate\": \"01/01/2020\",\r\n" + 
//						  		"  \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//						  		"  \"Domain\": '"+domaintext+"'\r\n" + 
//						  		"}";
					  
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
					  response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));	
				break;
				
	case "PurchaseOrder/Get_tblPaymentCycle" :
				
				APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/Get_tblPaymentCycle" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
	case "PurchaseOrder/Get_tblTerms" :
		
		 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
		 response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/Get_tblTerms" , APIBody );
	
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
	case "PurchaseOrder/Get_tblPercentage" :
		
		 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
		 response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/Get_tblPercentage" , APIBody );
	
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
	case "PurchaseOrder/CreatePOPaymentCycle" :
		
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		  
		  
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
		  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
					  System.out.println( "{\r\n" + 
						  		"  \"intPOID\": 1,\r\n" + 
						  		"  \"intPC_ID\": 1,\r\n" + 
						  		"  \"intTerm_ID\": "+termid+",\r\n" + 
						  		"  \"intPercent_ID\": 0,\r\n" + 
						  		"  \"cyclenumamt\": "+cycleamount+",\r\n" + 
						  		"  \"dtDate\": \"01/01/2019\",\r\n" + 
						  		"  \"Stage\": 0,\r\n" + 
						  		"  \"Domain\": "+domaintext+"\r\n" + 
						  		"}");
					  
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
					   response= postapidata.httpPost(postbaseurl+"/api/PurchaseOrder/CreatePOPaymentCycle" , APIBody );
	
	
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
	case "PurchaseOrder/GetPOCycleDetailsByID" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
		  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
				  		"  \"PONumber\": \"71\",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
					   response= postapidata.httpPost(postbaseurl+"/api/PurchaseOrder/GetPOCycleDetailsByID" , APIBody );
		
	
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
		 
	case "PurchaseOrder/DeletePOPaymentCycle" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
		  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
					   response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/DeletePOPaymentCycle" , APIBody );
		
	
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
				
		 
	case "PurchaseOrder/DocumentUpload" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
		  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
				  		"  \"intPODocId\": 0,\r\n" + 
				  		"  \"intVendorID\": "+vendorid+",\r\n" + 
				  		"  \"intPOID\": "+poid+",\r\n" + 
				  		"  \"vcFile\": \"sample string 4\",\r\n" + 
				  		"  \"fileDetails\": \"sample string 5\",\r\n" + 
				  		"  \"fileType\": \"sample string 6\",\r\n" + 
				  		"  \"dtCreatedOn\": \"2020-01-09T12:13:32.6808266+05:30\",\r\n" + 
				  		"  \"RootPath\": \"sample string 7\",\r\n" + 
				  		"  \"Domain\": \'"+domaintext+"'\r\n" + 
				  		"}";
					   response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/DocumentUpload" , APIBody );
		
	
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
				
		 
	case "PurchaseOrder/DownloadDoc" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
		  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
						  		"  \"intPODocId\": 0,\r\n" + 
						  		"  \"intVendorID\": \"96\",\r\n" + 
						  		"  \"intPOID\": "+poid+",\r\n" + 
						  		"  \"vcFile\": \"sample string 4\",\r\n" + 
						  		"  \"fileDetails\": \"sample string 5\",\r\n" + 
						  		"  \"fileType\": \"sample string 6\",\r\n" + 
						  		"  \"dtCreatedOn\": \"2020-01-09T12:13:32.6808266+05:30\",\r\n" + 
						  		"  \"RootPath\": \"sample string 7\",\r\n" + 
						  		"  \"Domain\": \'"+domaintext+"'\r\n" + 
						  		"}";
					   array= postapidata.Postarray(postbaseurl+"api/PurchaseOrder/DocumentUpload" , APIBody );
					   System.out.println(array);
					   podocid = array.get(1);
						  APIBody = "{\r\n" + 
						  		"  \"intPODocId\": "+podocid+",\r\n" + 
						  		"  \"Domain\": '"+domaintext+"'\r\n" + 
						  		"}";
								   response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/DownloadDoc" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
	case "PurchaseOrder/GetPOWiseDocuments" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
		  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
						  		"  \"intPODocId\": 0,\r\n" + 
						  		"  \"intVendorID\": "+vendorid+",\r\n" + 
						  		"  \"intPOID\": "+poid+",\r\n" + 
						  		"  \"vcFile\": \"sample string 4\",\r\n" + 
						  		"  \"fileDetails\": \"sample string 5\",\r\n" + 
						  		"  \"fileType\": \"sample string 6\",\r\n" + 
						  		"  \"dtCreatedOn\": \"2020-01-09T12:13:32.6808266+05:30\",\r\n" + 
						  		"  \"RootPath\": \"sample string 7\",\r\n" + 
						  		"  \"Domain\": \'"+domaintext+"'\r\n" + 
						  		"}";
					   array= postapidata.Postarray(postbaseurl+"api/PurchaseOrder/DocumentUpload" , APIBody );
					   System.out.println(array);
					   podocid = array.get(1);
					  
					 APIBody = "{\r\n" + 
						  		"  \"intPOId\": "+poid+",\r\n" + 
						  		"  \"Domain\":'"+domaintext+"'\r\n" + 
						  		"}";
								   response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/GetPOWiseDocuments" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
	case "PurchaseOrder/DeleteDoc" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
		  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
						  		"  \"intPODocId\": 0,\r\n" + 
						  		"  \"intVendorID\": "+vendorid+",\r\n" + 
						  		"  \"intPOID\": "+poid+",\r\n" + 
						  		"  \"vcFile\": \"sample string 4\",\r\n" + 
						  		"  \"fileDetails\": \"sample string 5\",\r\n" + 
						  		"  \"fileType\": \"sample string 6\",\r\n" + 
						  		"  \"dtCreatedOn\": \"2020-01-09T12:13:32.6808266+05:30\",\r\n" + 
						  		"  \"RootPath\": \"sample string 7\",\r\n" + 
						  		"  \"Domain\": \'"+domaintext+"'\r\n" + 
						  		"}";
					   array= postapidata.Postarray(postbaseurl+"api/PurchaseOrder/DocumentUpload" , APIBody );
					   System.out.println(array);
					   podocid = array.get(1);
					  
					 APIBody = "{\r\n" + 
					 		"  \"intPOId\": "+poid+",\r\n" + 
					 		"  \"intPODocId\": "+podocid+",\r\n" + 
					 		"  \"Domain\": \'"+domaintext+"'\r\n" + 
					 		"}";
								   response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/DeleteDoc" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
	case "PurchaseOrder/GetPOStatus" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
		  vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
					 		"  \"PONumber\": '"+POnumber+"',\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
								   response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/GetPOStatus" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
	case "PurchaseOrder/CheckPOApprovalHierarchy" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
						vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
					 		"  \"PONumber\": '"+POnumber+"',\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
								   response= postapidata.httpPost(postbaseurl+"api/PurchaseOrder/CheckPOApprovalHierarchy" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
	case "Invoice/InsertInvoiceDetails" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
						vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
								"  \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
								"  \"PONumber\": '"+ponum+"',\r\n" + 
								"  \"InvoiceDate\": \"01/01/2019\",\r\n" + 
								"  \"Amount\": "+cycleamount+",\r\n" + 
								"  \"Remark\": \"sample string 5\",\r\n" + 
								"  \"BalAmt\": 0,\r\n" + 
								"  \"Stage\": 0,\r\n" + 
								"  \"Domain\": '"+domaintext+"'\r\n" + 
								"}";
								   response= postapidata.httpPost(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
	case "Invoice/UpdateInvoiceDetails" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
						vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
								"  \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
								"  \"PONumber\": '"+POnumber+"',\r\n" + 
								"  \"InvoiceDate\": \"01/01/2019\",\r\n" + 
								"  \"Amount\": "+cycleamount+",\r\n" + 
								"  \"Remark\": \"sample string 5\",\r\n" + 
								"  \"BalAmt\": 0,\r\n" + 
								"  \"Stage\": 0,\r\n" + 
								"  \"Domain\": '"+domaintext+"'\r\n" + 
								"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
					  invoiceid = array.get(0);
					  APIBody = "{\r\n" + 
					  		"  \"InvoiceID\": "+invoiceid+",\r\n" + 
					  		"  \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
					  		"  \"PONumber\": '"+ponum+"',\r\n" + 
					  		"  \"InvoiceDate\": \"01/01/2019\",\r\n" + 
					  		"  \"Amount\": 5.0,\r\n" + 
					  		"  \"Remark\": \"sample string 6\",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
								   response= postapidata.httpPost(postbaseurl+"api/Invoice/UpdateInvoiceDetails" , APIBody );  
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
	case "Invoice/GetInvoiceDetailsByPONumber" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
						vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
								"  \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
								"  \"PONumber\": '"+ponum+"',\r\n" + 
								"  \"InvoiceDate\": \"01/01/2019\",\r\n" + 
								"  \"Amount\": "+cycleamount+",\r\n" + 
								"  \"Remark\": \"sample string 5\",\r\n" + 
								"  \"BalAmt\": 0,\r\n" + 
								"  \"Stage\": 0,\r\n" + 
								"  \"Domain\": '"+domaintext+"'\r\n" + 
								"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
					  invoiceid = array.get(0);
					  APIBody = "{\r\n" + 
					  		"  \"PONumber\": '"+ponum+"',\r\n" + 
					  		"  \"VendorID\": "+vendorid+",\r\n" + 
					  		"  \"year\": 3,\r\n" + 
					  		"  \"month\": 4,\r\n" + 
					  		"  \"submittedstatus\": \"sample string 5\",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
								   response= postapidata.httpPost(postbaseurl+"api/Invoice/GetInvoiceDetailsByPONumber" , APIBody );  
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
	case "Invoice/DeleteInvoiceDetails" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
						vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
								"  \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
								"  \"PONumber\": '"+ponum+"',\r\n" + 
								"  \"InvoiceDate\": \"01/01/2019\",\r\n" + 
								"  \"Amount\": "+cycleamount+",\r\n" + 
								"  \"Remark\": \"sample string 5\",\r\n" + 
								"  \"BalAmt\": 0,\r\n" + 
								"  \"Stage\": 0,\r\n" + 
								"  \"Domain\": '"+domaintext+"'\r\n" + 
								"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
					  invoiceid = array.get(0);
					  APIBody = "{\r\n" + 
					  		"  \"InvoiceID\": "+invoiceid+",\r\n" + 
					  		"  \"Domain\":'"+domaintext+"'\r\n" + 
					  		"}";
								   response= postapidata.httpPost(postbaseurl+"api/Invoice/DeleteInvoiceDetails" , APIBody );  
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
	case "Invoice/GetInvoiceDetailsByInvoiceID" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
						vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
								"  \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
								"  \"PONumber\": '"+ponum+"',\r\n" + 
								"  \"InvoiceDate\": \"01/01/2019\",\r\n" + 
								"  \"Amount\": "+cycleamount+",\r\n" + 
								"  \"Remark\": \"sample string 5\",\r\n" + 
								"  \"BalAmt\": 0,\r\n" + 
								"  \"Stage\": 0,\r\n" + 
								"  \"Domain\": '"+domaintext+"'\r\n" + 
								"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
					  invoiceid = array.get(0);
					  APIBody = "{\r\n" + 
					  		"  \"InvoiceID\": "+invoiceid+",\r\n" + 
					  		"  \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
								   response= postapidata.httpPost(postbaseurl+"api/Invoice/GetInvoiceDetailsByInvoiceID" , APIBody );  
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
	case "Invoice/SubmitInvoice" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
						vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
								"  \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
								"  \"PONumber\": '"+ponum+"',\r\n" + 
								"  \"InvoiceDate\": \"01/01/2019\",\r\n" + 
								"  \"Amount\": "+cycleamount+",\r\n" + 
								"  \"Remark\": \"sample string 5\",\r\n" + 
								"  \"BalAmt\": 0,\r\n" + 
								"  \"Stage\": 0,\r\n" + 
								"  \"Domain\": '"+domaintext+"'\r\n" + 
								"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
					  invoiceid = array.get(0);
					  APIBody = "{\r\n" + 
					  		"  \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
								   response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody );  
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
	case "Invoice/InvoiceStatus" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
						vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
				  APIBody = "{\r\n" + 
							"  \"PONumber\": '"+ponum+"',\r\n" + 
							"  \"VendorID\": "+vendorid+",\r\n" + 
							"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
							"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
							"  \"Remarks\": \"sample string 5\",\r\n" + 
							"  \"numAmt\": 60000.0,\r\n" + 
							"  \"numAdvanceAmt\": 7.0,\r\n" + 
							"  \"Recc1\": 8,\r\n" + 
							"  \"Recc2\": '',\r\n" + 
							"  \"Recc3\": '',\r\n" + 
							"  \"Recc4\": '',\r\n" + 
							"  \"Recc5\": '',\r\n" + 
							"  \"numBalAmt\": 13.0,\r\n" + 
							"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
								"  \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
								"  \"PONumber\": '"+ponum+"',\r\n" + 
								"  \"InvoiceDate\": \"01/01/2019\",\r\n" + 
								"  \"Amount\": "+cycleamount+",\r\n" + 
								"  \"Remark\": \"sample string 5\",\r\n" + 
								"  \"BalAmt\": 0,\r\n" + 
								"  \"Stage\": 0,\r\n" + 
								"  \"Domain\": '"+domaintext+"'\r\n" + 
								"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
					  invoiceid = array.get(0);
					  APIBody = "{\r\n" + 
					  		    "  \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
					  		    "  \"Domain\": '"+domaintext+"'\r\n" + 
					  		    "}";
								   response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody );  
								   
					  APIBody = "{\r\n" + 
					  			"  \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
					  			"  \"Domain\": '"+domaintext+"'\r\n" + 
					  			"}";
					  				response= postapidata.httpPost(postbaseurl+"api/Invoice/InvoiceStatus" , APIBody );				   
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
	case "Invoice/GetPOListbyVendorID" :
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		managerdata= array.get(0);
		 System.out.println(managerdata);
		APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );
		
		  fromcityid=array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
			  stateid = array.get(1);
	
			  APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
				  System.out.println(array);
				  designationid = array.get(1);
				  APIBody = "{\r\n" + 
					 		"  \"companyName\": \"gdata12\",\r\n" + 
					 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
					 		"  \"phone\": \"8698294937\",\r\n" + 
					 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
					 		"  \"branch\": 5,\r\n" + 
					 		"  \"address\": \"sample string 6\",\r\n" + 
					 		"  \"city\": "+fromcityid+",\r\n" + 
					 		"  \"state\": "+stateid+",\r\n" + 
					 		"  \"country\": 9,\r\n" + 
					 		"  \"pincode\": \"sample string 10\",\r\n" + 
					 		"  \"gst\": '"+Gstn+"',\r\n" + 
					 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
					 		"  \"designation\": "+designationid+",\r\n" + 
					 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
					 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
					 		"  \"userName\": '"+managerusername+"',\r\n" + 
					 		"  \"password\": \"sample string 17\",\r\n" + 
					 		"  \"bank\": \"sample string 18\",\r\n" + 
					 		"  \"accountno\": \"sample string 19\",\r\n" + 
					 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
					 		"  \"pan\": '"+pannum+"',\r\n" + 
					 		"  \"createdy\": 22,\r\n" + 
					 		"  \"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
						vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
			
		  System.out.println("vendorid"+vendorid);
		  APIBody = "{\r\n" + 
					"  \"PONumber\": '"+ponum+"',\r\n" + 
					"  \"VendorID\": "+vendorid+",\r\n" + 
					"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
					"  \"Remarks\": \"sample string 5\",\r\n" + 
					"  \"numAmt\": 60000.0,\r\n" + 
					"  \"numAdvanceAmt\": 7.0,\r\n" + 
					"  \"Recc1\": 8,\r\n" + 
					"  \"Recc2\": '',\r\n" + 
					"  \"Recc3\": '',\r\n" + 
					"  \"Recc4\": '',\r\n" + 
					"  \"Recc5\": '',\r\n" + 
					"  \"numBalAmt\": 13.0,\r\n" + 
					"  \"Domain\": \'"+domaintext+"'\r\n" + 
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
								"  \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
								"  \"PONumber\": '"+ponum+"',\r\n" + 
								"  \"InvoiceDate\": \"01/01/2019\",\r\n" + 
								"  \"Amount\": "+cycleamount+",\r\n" + 
								"  \"Remark\": \"sample string 5\",\r\n" + 
								"  \"BalAmt\": 0,\r\n" + 
								"  \"Stage\": 0,\r\n" + 
								"  \"Domain\": '"+domaintext+"'\r\n" + 
								"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
					  invoiceid = array.get(0);
					  APIBody = "{\r\n" + 
					  		    "  \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
					  		    "  \"Domain\": '"+domaintext+"'\r\n" + 
					  		    "}";
								   response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody );  
								   
					  APIBody = "{\r\n" + 
					  			"  \"VendorID\":\"95\",\r\n" + 
					  			"  \"Domain\": '"+domaintext+"'\r\n" + 
					  			"}";
					 
					  		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetPOListbyVendorID" , APIBody );				   
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
	case "Invoice/GetValidateInvoiceAmt" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
						array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
						System.out.println(array);
						poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 

		APIBody = "{\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"AppliedAmt\": 2.0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetValidateInvoiceAmt" , APIBody );	
		assertTrue(response.equalsIgnoreCase("1"));
		break;
		
		
	case "Invoice/GetApproverPO" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
							"  \"PONumber\": '"+ponum+"',\r\n" + 
							"  \"VendorID\": "+vendorid+",\r\n" + 
							"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
							"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
							"  \"Remarks\": \"sample string 5\",\r\n" + 
							"  \"numAmt\": 60000.0,\r\n" + 
							"  \"numAdvanceAmt\": 7.0,\r\n" + 
							"  \"Recc1\": 8,\r\n" + 
							"  \"Recc2\": '',\r\n" + 
							"  \"Recc3\": '',\r\n" + 
							"  \"Recc4\": '',\r\n" + 
							"  \"Recc5\": '',\r\n" + 
							"  \"numBalAmt\": 13.0,\r\n" + 
							"  \"Domain\": \'"+domaintext+"'\r\n" + 
							"}";
						array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
						System.out.println(array);
						poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

						APIBody = "{\r\n" + 
						" \"Action\": \"Periodic\",\r\n" + 
						" \"Term\": '"+termtext+"',\r\n" + 
						" \"amt\": 6000.0,\r\n" + 
						" \"advamt\": 0,\r\n" + 
						" \"percent\": \"0\",\r\n" + 
						" \"fromdate\": \"01/01/2020\",\r\n" + 
						" \"todate\": \"01/01/2020\",\r\n" + 
						" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
						" \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
						array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
						cycleamount = array.get(0);
						System.out.println(cycleamount);
				
				
						APIBody = "{\r\n" + 
								" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
								" \"PONumber\": '"+ponum+"',\r\n" + 
								" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
								" \"Amount\": "+cycleamount+",\r\n" + 
								" \"Remark\": \"sample string 5\",\r\n" + 
								" \"BalAmt\": 0,\r\n" + 
								" \"Stage\": 0,\r\n" + 
								" \"Domain\": '"+domaintext+"'\r\n" + 
								"}";
						array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
						invoiceid = array.get(0);
						APIBody = "{\r\n" + 
						" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
						" \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
						response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
				
						APIBody = "{\r\n" + 
								"  \"ReccId\": "+managerdata+",\r\n" + 
								"  \"Action\": \"pending\",\r\n" + 
								"  \"fromDate\": \"01/01/2019\",\r\n" + 
								"  \"toDate\": \"01/02/2020\",\r\n" + 
								"  \"PONumber\": '"+ponum+"',\r\n" + 
								"  \"VendorID\": "+vendorid+",\r\n" + 
								"  \"Domain\": '"+domaintext+"'\r\n" + 
								"}";
				
						response= postapidata.httpPost(postbaseurl+"api/Invoice/GetApproverPO" , APIBody );	
						assertTrue(response.equalsIgnoreCase("1"));
						break;
		
	case "Invoice/DocumentUpload" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
						APIBody = "{\r\n" + 
								"  \"PONumber\": '"+ponum+"',\r\n" + 
								"  \"VendorID\": "+vendorid+",\r\n" + 
								"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
								"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
								"  \"Remarks\": \"sample string 5\",\r\n" + 
								"  \"numAmt\": 60000.0,\r\n" + 
								"  \"numAdvanceAmt\": 7.0,\r\n" + 
								"  \"Recc1\": 8,\r\n" + 
								"  \"Recc2\": '',\r\n" + 
								"  \"Recc3\": '',\r\n" + 
								"  \"Recc4\": '',\r\n" + 
								"  \"Recc5\": '',\r\n" + 
								"  \"numBalAmt\": 13.0,\r\n" + 
								"  \"Domain\": \'"+domaintext+"'\r\n" + 
										"}";
				array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
				System.out.println(array);
				poid = array.get(0);
		
				APIBody = "{\r\n" + 
				" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

				APIBody = "{\r\n" + 
				" \"Action\": \"Periodic\",\r\n" + 
				" \"Term\": '"+termtext+"',\r\n" + 
				" \"amt\": 6000.0,\r\n" + 
				" \"advamt\": 0,\r\n" + 
				" \"percent\": \"0\",\r\n" + 
				" \"fromdate\": \"01/01/2020\",\r\n" + 
				" \"todate\": \"01/01/2020\",\r\n" + 
				" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
				" \"Domain\": '"+domaintext+"'\r\n" + 
				"}";
				array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
				cycleamount = array.get(0);
				System.out.println(cycleamount);
		
		
				APIBody = "{\r\n" + 
				" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
				" \"PONumber\": '"+ponum+"',\r\n" + 
				" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
				" \"Amount\": "+cycleamount+",\r\n" + 
				" \"Remark\": \"sample string 5\",\r\n" + 
				" \"BalAmt\": 0,\r\n" + 
				" \"Stage\": 0,\r\n" + 
				" \"Domain\": '"+domaintext+"'\r\n" + 
				"}";
				array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
				invoiceid = array.get(0);
			

		APIBody = "{\r\n" + 
				"  \"intInvoiceDocId\": 10,\r\n" + 
				"  \"intVendorID\": "+vendorid+",\r\n" + 
				"  \"intPOID\": "+poid+",\r\n" + 
				"  \"intInvoiceID\": "+invoiceid+",\r\n" + 
				"  \"vcFile\": \"sample string 5\",\r\n" + 
				"  \"fileDetails\": \"sample string 6\",\r\n" + 
				"  \"fileType\": \"sample string 7\",\r\n" + 
				"  \"dtCreatedOn\": \"01/01/2019\",\r\n" + 
				"  \"RootPath\": \"sample string 8\",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/DocumentUpload" , APIBody );	
		assertTrue(response.equalsIgnoreCase("1"));
		break;
		
	case "Invoice/DownloadDoc" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
				array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
				System.out.println(array);
				poid = array.get(0);
		
				APIBody = "{\r\n" + 
				" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
		APIBody = "{\r\n" + 
				"  \"intInvoiceDocId\": 0,\r\n" + 
				"  \"intVendorID\": "+vendorid+",\r\n" + 
				"  \"intPOID\": "+poid+",\r\n" + 
				"  \"intInvoiceID\": "+invoiceid+",\r\n" + 
				"  \"vcFile\": \"sample string 5\",\r\n" + 
				"  \"fileDetails\": \"sample string 6\",\r\n" + 
				"  \"fileType\": \"sample string 7\",\r\n" + 
				"  \"dtCreatedOn\": \"01/01/2019\",\r\n" + 
				"  \"RootPath\": \"sample string 8\",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		array= postapidata.Postarray(postbaseurl+"api/Invoice/DocumentUpload" , APIBody );
		invoicedocid=array.get(1);
		APIBody = "{\r\n" + 
				"  \"intInvoiceDocId\": "+invoicedocid+",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/DownloadDoc" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetInvoiceWiseDocuments" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
					APIBody = "{\r\n" + 
							"  \"PONumber\": '"+ponum+"',\r\n" + 
							"  \"VendorID\": "+vendorid+",\r\n" + 
							"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
							"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
							"  \"Remarks\": \"sample string 5\",\r\n" + 
							"  \"numAmt\": 60000.0,\r\n" + 
							"  \"numAdvanceAmt\": 7.0,\r\n" + 
							"  \"Recc1\": 8,\r\n" + 
							"  \"Recc2\": '',\r\n" + 
							"  \"Recc3\": '',\r\n" + 
							"  \"Recc4\": '',\r\n" + 
							"  \"Recc5\": '',\r\n" + 
							"  \"numBalAmt\": 13.0,\r\n" + 
							"  \"Domain\": \'"+domaintext+"'\r\n" + 
							"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
		APIBody = "{\r\n" + 
				"  \"intInvoiceDocId\": 0,\r\n" + 
				"  \"intVendorID\": "+vendorid+",\r\n" + 
				"  \"intPOID\": "+poid+",\r\n" + 
				"  \"intInvoiceID\": "+invoiceid+",\r\n" + 
				"  \"vcFile\": \"sample string 5\",\r\n" + 
				"  \"fileDetails\": \"sample string 6\",\r\n" + 
				"  \"fileType\": \"sample string 7\",\r\n" + 
				"  \"dtCreatedOn\": \"01/01/2019\",\r\n" + 
				"  \"RootPath\": \"sample string 8\",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		array= postapidata.Postarray(postbaseurl+"api/Invoice/DocumentUpload" , APIBody );
		invoicedocid=array.get(1);
		APIBody = "{\r\n" + 
				"  \"intInvoiceID\": "+invoiceid+",\r\n" + 
				"  \"Status\": \"pending\",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetInvoiceWiseDocuments" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/DeleteDoc" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
System.out.println("vendorid"+vendorid);
					APIBody = "{\r\n" + 
							"  \"PONumber\": '"+ponum+"',\r\n" + 
							"  \"VendorID\": "+vendorid+",\r\n" + 
							"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
							"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
							"  \"Remarks\": \"sample string 5\",\r\n" + 
							"  \"numAmt\": 60000.0,\r\n" + 
							"  \"numAdvanceAmt\": 7.0,\r\n" + 
							"  \"Recc1\": 8,\r\n" + 
							"  \"Recc2\": '',\r\n" + 
							"  \"Recc3\": '',\r\n" + 
							"  \"Recc4\": '',\r\n" + 
							"  \"Recc5\": '',\r\n" + 
							"  \"numBalAmt\": 13.0,\r\n" + 
							"  \"Domain\": \'"+domaintext+"'\r\n" + 
							"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);

		
		APIBody = "{\r\n" + 
				"  \"intInvoiceDocId\": 10,\r\n" + 
				"  \"intVendorID\": "+vendorid+",\r\n" + 
				"  \"intPOID\": "+poid+",\r\n" + 
				"  \"intInvoiceID\": "+invoiceid+",\r\n" + 
				"  \"vcFile\": \"sample string 5\",\r\n" + 
				"  \"fileDetails\": \"sample string 6\",\r\n" + 
				"  \"fileType\": \"sample string 7\",\r\n" + 
				"  \"dtCreatedOn\": \"01/01/2019\",\r\n" + 
				"  \"RootPath\": \"sample string 8\",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		array= postapidata.Postarray(postbaseurl+"api/Invoice/DocumentUpload" , APIBody );
		invoicedocid=array.get(1);
		APIBody = "{\r\n" + 
				"  \"intInvoiceID\": "+invoiceid+",\r\n" + 
				"  \"intInvoiceDocId\": "+invoicedocid+",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/DeleteDoc" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetApproverPOIDByReccID" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		depatmentdata=array.get(6);
		 System.out.println("depatmentdata"+depatmentdata);
		 
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
System.out.println("vendorid"+vendorid);
					APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));

		APIBody = "{\r\n" + 
				"  \"ReccId\": "+managerdata+",\r\n" + 
				"  \"Action\": \"pending\",\r\n" + 
				"  \"PONumber\": '"+ponum+"',\r\n" + 
				"  \"VendorID\": "+vendorid+",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetApproverPOIDByReccID" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetApproverVendorIDByReccID" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
					APIBody = "{\r\n" + 
							"  \"PONumber\": '"+ponum+"',\r\n" + 
							"  \"VendorID\": "+vendorid+",\r\n" + 
							"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
							"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
							"  \"Remarks\": \"sample string 5\",\r\n" + 
							"  \"numAmt\": 60000.0,\r\n" + 
							"  \"numAdvanceAmt\": 7.0,\r\n" + 
							"  \"Recc1\": 8,\r\n" + 
							"  \"Recc2\": '',\r\n" + 
							"  \"Recc3\": '',\r\n" + 
							"  \"Recc4\": '',\r\n" + 
							"  \"Recc5\": '',\r\n" + 
							"  \"numBalAmt\": 13.0,\r\n" + 
							"  \"Domain\": \'"+domaintext+"'\r\n" + 
							"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
		APIBody = "{\r\n" + 
				"  \"intInvoiceDocId\": 0,\r\n" + 
				"  \"intVendorID\": "+vendorid+",\r\n" + 
				"  \"intPOID\": "+poid+",\r\n" + 
				"  \"intInvoiceID\": "+invoiceid+",\r\n" + 
				"  \"vcFile\": \"sample string 5\",\r\n" + 
				"  \"fileDetails\": \"sample string 6\",\r\n" + 
				"  \"fileType\": \"sample string 7\",\r\n" + 
				"  \"dtCreatedOn\": \"01/01/2019\",\r\n" + 
				"  \"RootPath\": \"sample string 8\",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		array= postapidata.Postarray(postbaseurl+"api/Invoice/DocumentUpload" , APIBody );
		invoicedocid=array.get(1);
		APIBody = "{\r\n" + 
				"  \"ReccId\": "+managerdata+",\r\n" + 
				"  \"Action\": \"pending\",\r\n" + 
				"  \"PONumber\": '"+ponum+"',\r\n" + 
				"  \"VendorID\": "+vendorid+",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetApproverVendorIDByReccID" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetDataforFinanceInvoiceDTO" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));

		APIBody = "{\r\n" + 
				"  \"VendorID\": "+vendorid+",\r\n" + 
				"  \"year\": 0,\r\n" + 
				"  \"month\": 0,\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetDataforFinanceInvoiceDTO" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetDataforOnlineInvoiceDTO" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));

		APIBody = "{\r\n" + 
				"  \"VendorID\": "+vendorid+",\r\n" + 
				"  \"year\": 0,\r\n" + 
				"  \"month\": 0,\r\n" + 
				"  \"mode\": \"cash\",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetDataforOnlineInvoiceDTO" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/UpdateSettledInvoice" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
	
		APIBody = "{\r\n" + 
				"  \"invoiceno\": '"+invoiceno+"',\r\n" + 
				"  \"ReccID\": "+managerdata+",\r\n" + 
				"  \"Remarks\": \"sample string 3\",\r\n" + 
				"  \"Action\": 1,\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetApproveDisapproveInvoice" , APIBody );
		
	
		APIBody = "{\r\n" + 
				"  \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
				"  \"chqno\": \"sample string 2\",\r\n" + 
				"  \"chqdate\": \"01/01/2020\",\r\n" + 
				"  \"bankname\": \"sample string 4\",\r\n" + 
				"  \"AccountNo\": \"sample string 5\",\r\n" + 
				"  \"IFSC\": \"sample string 6\",\r\n" + 
				"  \"remark\": \"sample string 7\",\r\n" + 
				"  \"POnumber\": '"+ponum+"',\r\n" + 
				"  \"InvoiceAmt\": 900,\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/UpdateSettledInvoice" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetInvoicePaidDetails" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
	
	
		APIBody = "{\r\n" + 
				"  \"month\": 0,\r\n" + 
				"  \"year\": 0,\r\n" + 
				"  \"dtPaymentProcessed\": \"01/01/1900\",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetInvoicePaidDetails" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
		
	case "Invoice/ReopenInvoice" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		
				
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
	
		APIBody = "{\r\n" + 
				"  \"invoiceno\": '"+invoiceno+"',\r\n" + 
				"  \"ReccID\": "+managerdata+",\r\n" + 
				"  \"Remarks\": \"sample string 3\",\r\n" + 
				"  \"Action\": 0,\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetApproveDisapproveInvoice" , APIBody );
		APIBody = "{\r\n" + 
				"  \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
				"  \"Amount\": 200,\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/ReopenInvoice" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetReccIDByInvoiceNo" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
	
	
		APIBody = "{\r\n" + 
				"  \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetReccIDByInvoiceNo" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetReasonsforInvoice" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
	
	
		APIBody = "{\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetReasonsforInvoice" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetInvoiceDetailsPONumberList" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
	
	
		APIBody = "{\r\n" + 
				"  \"VendorID\": "+vendorid+",\r\n" + 
				"  \"year\": 0,\r\n" + 
				"  \"month\": 0,\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetInvoiceDetailsPONumberList" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetValidateInvoice" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
	
	
		APIBody = "{\r\n" + 
				"  \"POID\": "+poid+",\r\n" + 
				"  \"InvoiceDate\": \"01/01/2020\",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetValidateInvoice" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetApproverInvoices" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
	
	
		APIBody = "{\r\n" + 
				"  \"ReccId\": "+managerdata+",\r\n" + 
				"  \"Action\": \"pending\",\r\n" + 
				"  \"VendorID\": "+vendorid+",\r\n" + 
				"  \"fromDate\": \"01/01/2020\",\r\n" + 
				"  \"toDate\": \"01/01/2020\",\r\n" + 
				"  \"POnumber\": '"+ponum+"',\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetApproverInvoices" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Invoice/GetApproveDisapproveInvoice" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		  APIBody = "{\r\n" + 
			 		"  \"companyName\": \"gdata12\",\r\n" + 
			 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
			 		"  \"phone\": \"8698294937\",\r\n" + 
			 		"  \"emailID\": \"yu@gdata.in\",\r\n" + 
			 		"  \"branch\": 5,\r\n" + 
			 		"  \"address\": \"sample string 6\",\r\n" + 
			 		"  \"city\": "+fromcityid+",\r\n" + 
			 		"  \"state\": "+stateid+",\r\n" + 
			 		"  \"country\": 9,\r\n" + 
			 		"  \"pincode\": \"sample string 10\",\r\n" + 
			 		"  \"gst\": '"+Gstn+"',\r\n" + 
			 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
			 		"  \"designation\": "+designationid+",\r\n" + 
			 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
			 		"  \"ContactPersonEmail\": '"+managerusername+"',\r\n" + 
			 		"  \"userName\": '"+managerusername+"',\r\n" + 
			 		"  \"password\": \"sample string 17\",\r\n" + 
			 		"  \"bank\": \"sample string 18\",\r\n" + 
			 		"  \"accountno\": \"sample string 19\",\r\n" + 
			 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
			 		"  \"pan\": '"+pannum+"',\r\n" + 
			 		"  \"createdy\": 22,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
				System.out.println("vendorid"+vendorid);
				APIBody = "{\r\n" + 
						"  \"PONumber\": '"+ponum+"',\r\n" + 
						"  \"VendorID\": "+vendorid+",\r\n" + 
						"  \"dtPO\": \"2019-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"dtPOExpiry\": \"2020-12-21T17:41:47.9491174+05:30\",\r\n" + 
						"  \"Remarks\": \"sample string 5\",\r\n" + 
						"  \"numAmt\": 60000.0,\r\n" + 
						"  \"numAdvanceAmt\": 7.0,\r\n" + 
						"  \"Recc1\": 8,\r\n" + 
						"  \"Recc2\": '',\r\n" + 
						"  \"Recc3\": '',\r\n" + 
						"  \"Recc4\": '',\r\n" + 
						"  \"Recc5\": '',\r\n" + 
						"  \"numBalAmt\": 13.0,\r\n" + 
						"  \"Domain\": \'"+domaintext+"'\r\n" + 
						"}";
		array= postapidata.getarraydata(postbaseurl+"api/PO/CreatePO" , APIBody );
		System.out.println(array);
		poid = array.get(0);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
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

//			APIBody = "{\r\n" + 
//			" \"Action\": \"Periodic\",\r\n" + 
//			" \"Term\": \"Monthly\",\r\n" + 
//			" \"amt\": 6000.0,\r\n" + 
//			" \"advamt\": 0,\r\n" + 
//			" \"percent\": \"0\",\r\n" + 
//			" \"fromdate\": \"01/01/2019\",\r\n" + 
//			" \"todate\": \"01/01/2020\",\r\n" + 
//			" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
//			" \"Domain\": '"+domaintext+"'\r\n" + 
//			"}";

		APIBody = "{\r\n" + 
		" \"Action\": \"Periodic\",\r\n" + 
		" \"Term\": '"+termtext+"',\r\n" + 
		" \"amt\": 6000.0,\r\n" + 
		" \"advamt\": 0,\r\n" + 
		" \"percent\": \"0\",\r\n" + 
		" \"fromdate\": \"01/01/2020\",\r\n" + 
		" \"todate\": \"01/01/2020\",\r\n" + 
		" \"applydate\": \"2020-01-02T11:52:59.6259867+05:30\",\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/PurchaseOrder/GetPaymentCycle" , APIBody );
		cycleamount = array.get(0);
		System.out.println(cycleamount);


		APIBody = "{\r\n" + 
		" \"InvoiceNumber\": '"+invoiceno+"',\r\n" + 
		" \"PONumber\": '"+ponum+"',\r\n" + 
		" \"InvoiceDate\": \"01/01/2020\",\r\n" + 
		" \"Amount\": "+cycleamount+",\r\n" + 
		" \"Remark\": \"sample string 5\",\r\n" + 
		" \"BalAmt\": 0,\r\n" + 
		" \"Stage\": 0,\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Invoice/InsertInvoiceDetails" , APIBody );
		invoiceid = array.get(0);
		APIBody = "{\r\n" + 
		" \"InvoiceNo\": '"+invoiceno+"',\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		response= postapidata.httpPost(postbaseurl+"api/Invoice/SubmitInvoice" , APIBody ); 
		assertTrue(response.equalsIgnoreCase("1"));
	
	
		APIBody = "{\r\n" + 
				"  \"invoiceno\": '"+invoiceno+"',\r\n" + 
				"  \"ReccID\": "+managerdata+",\r\n" + 
				"  \"Remarks\": \"sample string 3\",\r\n" + 
				"  \"Action\": 0,\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Invoice/GetApproveDisapproveInvoice" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
	case "Vendor/ChangeVendorPasswordByAdmin" :

		APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		array= postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		System.out.println(array);

		
		
		managerdata= array.get(0);
		System.out.println(managerdata);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetCityDataList" , APIBody );

		fromcityid=array.get(1);
		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
		stateid = array.get(1);

		APIBody = "{\r\n" + 
		" \"Domain\": '"+domaintext+"'\r\n" + 
		"}";
		array= postapidata.getarraydata(postbaseurl+"api/Master/GetDesignation" , APIBody );
		System.out.println(array);
		designationid = array.get(1);
		APIBody = "{\r\n" + 
		 		"  \"companyName\": \"gdata12\",\r\n" + 
		 		"  \"typeOfBusiness\": \"ee\",\r\n" + 
		 		"  \"phone\": \"8698294937\",\r\n" + 
		 		"  \"emailID\": \"yfu@gdata.in\",\r\n" + 
		 		"  \"branch\": 5,\r\n" + 
		 		"  \"address\": \"sample string 6\",\r\n" + 
		 		"  \"city\": "+fromcityid+",\r\n" + 
		 		"  \"state\": "+stateid+",\r\n" + 
		 		"  \"country\": 9,\r\n" + 
		 		"  \"pincode\": \"sample string 10\",\r\n" + 
		 		"  \"gst\": '"+Gstn+"',\r\n" + 
		 		"  \"contactPerson\": \"sample string 12\",\r\n" + 
		 		"  \"designation\": "+designationid+",\r\n" + 
		 		"  \"contactPersonMobile\": \"sample string 14\",\r\n" + 
		 		"  \"ContactPersonEmail\": \"sample@gdata.in\",\r\n" + 
		 		"  \"userName\": '"+managerusername+"',\r\n" + 
		 		"  \"password\": \"sample string 17\",\r\n" + 
		 		"  \"bank\": \"sample string 18\",\r\n" + 
		 		"  \"accountno\": \"sample string 19\",\r\n" + 
		 		"  \"ifsccode\": \"sample string 20\",\r\n" + 
		 		"  \"pan\": '"+pannum+"',\r\n" + 
		 		"  \"createdy\": 22,\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		
		vendorid= postapidata.getonlydata(postbaseurl+"api/Vendor/RegisterVendor" , APIBody);
	
		APIBody = "{\r\n" + 
				"  \"username\": '"+managerusername+"',\r\n" + 
				"  \"newpassword\": \"Vendor123\",\r\n" + 
				"  \"Domain\": '"+domaintext+"'\r\n" + 
				"}";

		response= postapidata.httpPost(postbaseurl+"api/Vendor/ChangeVendorPasswordByAdmin" , APIBody );
		assertTrue(response.equalsIgnoreCase("1"));		
		break;
		
		
	
			}
			}
		}

	


