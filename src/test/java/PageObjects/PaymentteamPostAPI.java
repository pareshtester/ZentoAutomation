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

public class PaymentteamPostAPI extends Urls {
	
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
	String Stateid="";
	String emailid="";
	String passwordtext="";
	String foodtype="";
	String advanceid="";
	String advancetypeid="";
	String advanceclaimid="";
	String advanceexpenseid="";
	
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
	String leavetypeid="";
	String leaveid="";
	String leavemasterid="";
	String expenseid="";
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
		emailid= array.get(3);
		passwordtext=array.get(4);
;//		   String clardatacode= gdata1.getContenxtWeb("http://192.168.1.14:90/ClearEmployeeClaims.aspx?EmpCode="+username+"&Domain="+domaintext+"");
//			 assertTrue(clardatacode.equalsIgnoreCase("200")||clardatacode.equalsIgnoreCase("201"));
		switch(functiontext){
		
		
			 
			 
		case "Payment/GetPaymentApprovedClaimIds" :
		
			 APIBody = "{\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Payment/GetPaymentApprovedClaimIds" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;

		case "Payment/GetPaymentApprovedClaimList" :
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
			  claimid=array.get(0);
			  localexpenseid=array.get(1);
			 APIBody = "{\r\n" + 
			 		"  \"claimid\": 20139,\r\n" + 
			 		"  \"Domain\": \"gdata\"\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Payment/GetPaymentApprovedClaimList" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
			 
		case "PaymentAction/GetDataForDashboardHGS" :
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
			  claimid=array.get(0);
			  localexpenseid=array.get(1);
			 APIBody = "{\r\n" + 
			 		"  \"month\": 0,\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"Type\": \"0\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/PaymentAction/GetDataForDashboardHGS" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
			 
			 
			 //driver
			 
			 
		case "DriverClaim/GetInsertDriverClaim" :
			
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
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"amount\": 3.0,\r\n" + 
			 		"  \"driverName\": \"paresh\",\r\n" + 
			 		"  \"month_Name\": \"Jan\",\r\n" + 
			 		"  \"Remarks\": \"sample string 6\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"45\",\r\n" + 
			 		"  \"GSTN\": \"777777777\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/DriverClaim/GetInsertDriverClaim" , APIBody);
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
			 
		case "DriverClaim/Get" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/DriverClaim/Get" , APIBody);
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
		case "DriverClaim/GetInsertClaimDocs" :
			
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
			  claimid=array.get(0);
			  localexpenseid=array.get(1);
			
			 APIBody = "{\r\n" + 
			 		"  \"ClaimId\": "+claimid+",\r\n" + 
			 		"  \"ExpenseId\": "+localexpenseid+",\r\n" + 
			 		"  \"Empid\": "+empdata+",\r\n" + 
			 		"  \"vcFile\": \"sample string 4\",\r\n" + 
			 		"  \"fileDetails\": \"sample string 5\",\r\n" + 
			 		"  \"fileType\": \"sample string 6\",\r\n" + 
			 		"  \"claimtype\": 5,\r\n" + 
			 		"  \"claimweek\": \"0\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/DriverClaim/GetInsertClaimDocs" , APIBody);
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
			 
			 
		case "DriverClaim/GetMasterClaimID" :
			
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
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"amount\": 3.0,\r\n" + 
			 		"  \"driverName\": \"paresh\",\r\n" + 
			 		"  \"month_Name\": \"Jan\",\r\n" + 
			 		"  \"Remarks\": \"sample string 6\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"45\",\r\n" + 
			 		"  \"GSTN\": \"777777777\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
		
			   masterclaimid= postapidata.getonlydata(postbaseurl+"api/DriverClaim/GetInsertDriverClaim" , APIBody);
				  System.out.println("claimid is"+masterclaimid);
				  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			    	System.out.println("New masterclaimid is"+masterclaimid);
			    	
			    	  APIBody = "{\r\n" + 
						  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
						  		"  \"Domain\": '"+domaintext+"'\r\n" + 
						  		"}";
						  
						
						  response= postapidata.httpPost(postbaseurl+"api/DriverClaim/GetMasterClaimID" , APIBody);
						  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
		case "DriverClaim/GetEmpAppliedClaimData" :
			
			
			    	
			    	  APIBody = "{\r\n" + 
			    	  		"  \"ClaimWeek\": \"0\",\r\n" + 
			    	  		"  \"EmpID\": "+empdata+",\r\n" + 
			    	  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			    	  		"}";
						  
						
						  response= postapidata.httpPost(postbaseurl+"api/DriverClaim/GetEmpAppliedClaimData" , APIBody);
						  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
			 
		case "DriverClaimView/GetClaimByID" :
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
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"amount\": 3.0,\r\n" + 
			 		"  \"driverName\": \"paresh\",\r\n" + 
			 		"  \"month_Name\": \"Jan\",\r\n" + 
			 		"  \"Remarks\": \"sample string 6\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"45\",\r\n" + 
			 		"  \"GSTN\": \"777777777\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
		
			   masterclaimid= postapidata.getonlydata(postbaseurl+"api/DriverClaim/GetInsertDriverClaim" , APIBody);
				  System.out.println("claimid is"+masterclaimid);
				  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			    	System.out.println("New masterclaimid is"+masterclaimid);
			
			    	 APIBody = "{\r\n" + 
						  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
						  		"  \"Domain\": '"+domaintext+"'\r\n" + 
						  		"}";

					  array= postapidata.getdata(postbaseurl+"api/DriverClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(0);
					  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+claimid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					  response= postapidata.httpPost(postbaseurl+"api/DriverClaimView/GetClaimByID" , APIBody);
					  assertTrue(response.equalsIgnoreCase("Success"));
	                  break;
	 
	 
		case "DriverClaimView/GetEmpAppliedExpenseDataDriver" :
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
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"amount\": 3.0,\r\n" + 
			 		"  \"driverName\": \"paresh\",\r\n" + 
			 		"  \"month_Name\": \"Jan\",\r\n" + 
			 		"  \"Remarks\": \"sample string 6\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"45\",\r\n" + 
			 		"  \"GSTN\": \"777777777\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
		
			   masterclaimid= postapidata.getonlydata(postbaseurl+"api/DriverClaim/GetInsertDriverClaim" , APIBody);
				  System.out.println("claimid is"+masterclaimid);
				  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			    	System.out.println("New masterclaimid is"+masterclaimid);
			
			    	 APIBody = "{\r\n" + 
						  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
						  		"  \"Domain\": '"+domaintext+"'\r\n" + 
						  		"}";

					  array= postapidata.getdata(postbaseurl+"api/DriverClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(5);
					  expenseid= array.get(6);
					  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+claimid+",\r\n" + 
					  		"  \"ExpenseId\": "+expenseid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					  response= postapidata.httpPost(postbaseurl+"api/DriverClaimView/GetEmpAppliedExpenseDataDriver" , APIBody);
					  assertTrue(response.equalsIgnoreCase("Success"));
	                 break;
	                 
	                 
		case "DriverClaimView/UpdateDriverClaim" :
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
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"amount\": 3.0,\r\n" + 
			 		"  \"driverName\": \"paresh\",\r\n" + 
			 		"  \"month_Name\": \"Jan\",\r\n" + 
			 		"  \"Remarks\": \"sample string 6\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"45\",\r\n" + 
			 		"  \"GSTN\": \"777777777\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
		
			   masterclaimid= postapidata.getonlydata(postbaseurl+"api/DriverClaim/GetInsertDriverClaim" , APIBody);
				  System.out.println("claimid is"+masterclaimid);
				  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			    	System.out.println("New masterclaimid is"+masterclaimid);
			
			    	 APIBody = "{\r\n" + 
						  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
						  		"  \"Domain\": '"+domaintext+"'\r\n" + 
						  		"}";

					  array= postapidata.getdata(postbaseurl+"api/DriverClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(5);
					  expenseid= array.get(6);
					  APIBody = "{\r\n" + 
					  		"  \"ClaimId\": "+claimid+",\r\n" + 
					  		"  \"OtherExpenseClaimId\": "+expenseid+",\r\n" + 
					  		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
					  		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
					  		"  \"amount\": 5.0,\r\n" + 
					  		"  \"driverName\": \"Mahesh\",\r\n" + 
					  		"  \"month_Name\": \"March\",\r\n" + 
					  		"  \"Remarks\": \"sample string 8\",\r\n" + 
					  		"  \"WBS\": "+wbsid+",\r\n" + 
					  		"  \"TaxAmt\": 10.0,\r\n" + 
					  		"  \"GSTIncluded\": true,\r\n" + 
					  		"  \"InvoiceNo\": \"55\",\r\n" + 
					  		"  \"GSTN\": \"555\",\r\n" + 
					  		"  \"CGSTAmt\": 14.0,\r\n" + 
					  		"  \"SGSTAmt\": 15.0,\r\n" + 
					  		"  \"IGSTAmt\": 16.0,\r\n" + 
					  		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					  response= postapidata.httpPost(postbaseurl+"api/DriverClaimView/UpdateDriverClaim" , APIBody);
					  assertTrue(response.equalsIgnoreCase("Success"));
	                 break;
	                 
	                 
		case "DriverClaimView/ValidateDriverClaim" :
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
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"amount\": 3.0,\r\n" + 
			 		"  \"driverName\": \"paresh\",\r\n" + 
			 		"  \"month_Name\": \"Jan\",\r\n" + 
			 		"  \"Remarks\": \"sample string 6\",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"WBS\": "+wbsid+",\r\n" + 
			 		"  \"Exceed_Amt\": 10.0,\r\n" + 
			 		"  \"TaxAmt\": 11.0,\r\n" + 
			 		"  \"GSTIncluded\": true,\r\n" + 
			 		"  \"InvoiceNo\": \"45\",\r\n" + 
			 		"  \"GSTN\": \"777777777\",\r\n" + 
			 		"  \"CGSTAmt\": 15.0,\r\n" + 
			 		"  \"SGSTAmt\": 16.0,\r\n" + 
			 		"  \"IGSTAmt\": 17.0,\r\n" + 
			 		"  \"intTypeOfVisit\": "+typeofvisitid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
		
			   masterclaimid= postapidata.getonlydata(postbaseurl+"api/DriverClaim/GetInsertDriverClaim" , APIBody);
				  System.out.println("claimid is"+masterclaimid);
				  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			    	System.out.println("New masterclaimid is"+masterclaimid);
			
			    	 APIBody = "{\r\n" + 
						  		"  \"ClaimId\": "+masterclaimid+",\r\n" + 
						  		"  \"Domain\": '"+domaintext+"'\r\n" + 
						  		"}";

					  array= postapidata.getdata(postbaseurl+"api/DriverClaim/GetMasterClaimID" , APIBody);
					  System.out.println("Masterclaimarray"+array);
					  claimid=array.get(5);
					  expenseid= array.get(6);
					  APIBody = "{\r\n" + 
					  		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
					  		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
					  		"  \"emp_Id\": "+empdata+",\r\n" + 
					  		"  \"expenseID\": "+expenseid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					  response= postapidata.httpPost(postbaseurl+"api/DriverClaimView/ValidateDriverClaim" , APIBody);
					  assertTrue(response.equalsIgnoreCase("Success"));
	                 break;
	       
	                 
	                 //Reopen claim
	                 
		case "ReOpen/ReopenClaim" :
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
			  		"  \"action\": 0,\r\n" + 
			  		"  \"status\": \"pending\",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  
			  response= postapidata.httpPost(postbaseurl+"api/ClaimProcessing/ApproveDissapproveClaims" , APIBody);
			  assertTrue(response.equalsIgnoreCase("Success"));
					  APIBody = "{\r\n" + 
					  		"  \"claim_id\": "+claimid+",\r\n" + 
					  		"  \"amount\": 2.0,\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  
					  response= postapidata.httpPost(postbaseurl+"api/ReOpen/ReopenClaim" , APIBody);
					  assertTrue(response.equalsIgnoreCase("Success"));
	                 break;
		
	                 
		case "ReOpen/ReopenCOEmployeeClaim" :
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
			  assertTrue(response.equalsIgnoreCase("Success"));
					  APIBody = "{\r\n" + 
					  		"  \"Domain\": '"+domaintext+"',\r\n" + 
					  		"  \"empid\": "+empdata+",\r\n" + 
					  		"  \"claimid\": "+foodclaimid+"\r\n" + 
					  		"}";
					  
					  response= postapidata.httpPost(postbaseurl+"api/ReOpen/ReopenCOEmployeeClaim" , APIBody);
					  assertTrue(response.equalsIgnoreCase("Success"));
	                 break;
		

}
	}
}
