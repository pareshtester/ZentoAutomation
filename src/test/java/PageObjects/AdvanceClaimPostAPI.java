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

public class AdvanceClaimPostAPI extends Urls {
	
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
		
		
			
			 
		case "AdvanceRequest/InsertAdvance" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "AdvanceRequest/GetMasterAdvanceId" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  response= postapidata.httpPost(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AdvanceRequest/UpdateAdvance" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"LeaveDetailsId\": "+advanceclaimid+",\r\n" + 
				  		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
				  		"  \"Location\": \"sample string 4\",\r\n" + 
				  		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
				  		"  \"Reason\": \"sample string 6\",\r\n" + 
				  		"  \"NoOfLeaves\": 7.0,\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvanceRequest/UpdateAdvance" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "GetEmpAdvanceData/GetEmpAppliedAdvance" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"EmpId\": "+empdata+",\r\n" + 
				  		"  \"IsSubmit\": 2,\r\n" + 
				  		"  \"month\": 0,\r\n" + 
				  		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/GetEmpAdvanceData/GetEmpAppliedAdvance" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				
			 break;
			 
		case "GetEmpAdvanceData/GetEmpAppliedAdvanceByStatus" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"EmpId\": "+empdata+",\r\n" + 
				  		"  \"IsSubmit\": 2,\r\n" + 
				  		"  \"month\": 0,\r\n" + 
				  		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
				  		"  \"Status\": 1,\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/GetEmpAdvanceData/GetEmpAppliedAdvanceByStatus" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
		case "GetEmpAdvanceData/GetLeaveDetailsByAdvanceID" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"LeaveMasterId\": "+advanceclaimid+",\r\n" + 
				  		"  \"LeaveId\": "+advanceexpenseid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/GetEmpAdvanceData/GetLeaveDetailsByAdvanceID" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				
			 break;
			 
			 
		case "GetEmpAdvanceData/DeleteAdvance" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"LeaveId\": "+advanceclaimid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/GetEmpAdvanceData/DeleteAdvance" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				
			 break;
			 
			 
		case "AdvanceSettlements/GetAdvancesatdetailsbyid" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"satid\": 1,\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvanceSettlements/GetAdvancesatdetailsbyid" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "AdvanceSettlements/Get" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvanceSettlements/Get" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "AdvancePayment/GetAllAdvanceClaim" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvancePayment/GetAllAdvanceClaim" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "AdvanceProcessing/SubmitAdvance" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"LeaveId\": "+advanceclaimid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvanceProcessing/SubmitAdvance" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "AdvanceProcessing/AdvanceDetailsbyID" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"Claimid\": "+advanceclaimid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvanceProcessing/AdvanceDetailsbyID" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "AdvanceProcessing/AdvanceDetailsByClaimID" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"Claimid\": "+advanceclaimid+",\r\n" + 
				  		"  \"Ctype\": 2,\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvanceProcessing/AdvanceDetailsByClaimID" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "AdvanceProcessing/GetApproverAdvance" :
			
			 APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
			  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
			  System.out.println(array);
			
			managerdata= array.get(7);
			bandid=array.get(1);
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"ApproverId\": "+managerdata+",\r\n" + 
				  		"  \"status\": \"pending\",\r\n" + 
				  		"  \"month\": 0,\r\n" + 
				  		"  \"year\": '"+current.get(Calendar.YEAR)+"',\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvanceProcessing/GetApproverAdvance" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "AdvanceProcessing/ApproveDisapproveAdvance" :
			
			 APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
			  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
			  System.out.println(array);
			
			managerdata= array.get(7);
			System.out.println("manager data"+managerdata);
			bandid=array.get(1);
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  System.out.println("advance claimid"+advanceclaimid);
				  APIBody = "{\r\n" + 
					  		"  \"LeaveId\": "+advanceclaimid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
				  response= postapidata.httpPost(postbaseurl+"api/AdvanceProcessing/SubmitAdvance" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
				  APIBody = "{\r\n" + 
				  		"  \"LeaveId\": "+advanceclaimid+",\r\n" + 
				  		"  \"ReccId\": "+managerdata+",\r\n" + 
				  		"  \"Remarks\": \"sample string 3\",\r\n" + 
				  		"  \"Action\": 1,\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvanceProcessing/ApproveDisapproveAdvance" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "AdvanceProcessing/ReopenAdvance" :
			
			 APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
			  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
			  System.out.println(array);
			
			managerdata= array.get(7);
			System.out.println("manager data"+managerdata);
			bandid=array.get(1);
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  System.out.println("advance claimid"+advanceclaimid);
				  APIBody = "{\r\n" + 
					  		"  \"LeaveId\": "+advanceclaimid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
				  response= postapidata.httpPost(postbaseurl+"api/AdvanceProcessing/SubmitAdvance" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
				  APIBody = "{\r\n" + 
				  		"  \"LeaveId\": "+advanceclaimid+",\r\n" + 
				  		"  \"ReccId\": "+managerdata+",\r\n" + 
				  		"  \"Remarks\": \"sample string 3\",\r\n" + 
				  		"  \"Action\": 0,\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvanceProcessing/ApproveDisapproveAdvance" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
						  
						  APIBody = "{\r\n" + 
						  		"  \"LeaveId\": "+advanceclaimid+",\r\n" + 
						  		"  \"NoOfLeaves\": 2.0,\r\n" + 
						  		"  \"Domain\": '"+domaintext+"'\r\n" + 
						  		"}";
									  response= postapidata.httpPost(postbaseurl+"api/AdvanceProcessing/ReopenAdvance" , APIBody);
									  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
			 
		case "AdvanceSettlements" :
			

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
			  System.out.println("localexpenseid"+localexpenseid);
			  
			  
			  
			  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
			  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
			  System.out.println(array);
			
			managerdata= array.get(7);
			System.out.println("manager data"+managerdata);
			bandid=array.get(1);
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
						  
						  APIBody = "{\r\n" + 
						  		"  \"satID\": 1,\r\n" + 
						  		"  \"AdvanceID\": "+advanceclaimid+",\r\n" + 
						  		"  \"ClaimID\": "+claimid+",\r\n" + 
						  		"  \"Other\": \"sample string 4\",\r\n" + 
						  		"  \"Domain\": '"+domaintext+"'\r\n" + 
						  		"}";
									  response= postapidata.httpPost(postbaseurl+"api/AdvanceSettlements" , APIBody);
									  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "Advance" :
			
			 APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
			  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
			  System.out.println(array);
			
			managerdata= array.get(3);
			System.out.println("manager data"+managerdata);
			bandid=array.get(1);
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  System.out.println("advance claimid"+advanceclaimid);
				  APIBody = "{\r\n" + 
					  		"  \"LeaveId\": "+advanceclaimid+",\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
				  response= postapidata.httpPost(postbaseurl+"api/AdvanceProcessing/SubmitAdvance" , APIBody);
				  assertTrue(response.equalsIgnoreCase("1"));
				  APIBody = "{\r\n" + 
				  		"  \"LDID\": 1,\r\n" + 
				  		"  \"FileName\": \"sample string 2\",\r\n" + 
				  		"  \"FileExt\": \"sample string 3\",\r\n" + 
				  		"  \"Path\": \"sample string 4\",\r\n" + 
				  		"  \"intLeaveMasterID\": "+advanceclaimid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/Advance" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		case "AdvanceDocument/GetAdvanceDocumentsList" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  
			  response= postapidata.httpPost(postbaseurl+"api/AdvanceDocument/GetAdvanceDocumentsList" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "AdvanceDocument/GetAdvanceDocument" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody );
				  advancetypeid = array.get(1);
			

				  System.out.println("advancetypeid id is"+advancetypeid);
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+advancetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/AdvanceRequest/InsertAdvance" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
				  array= postapidata.getdata(postbaseurl+"api/AdvanceRequest/GetMasterAdvanceId" , APIBody);
				  System.out.println(array);
				  advanceclaimid= array.get(7);
				  advanceexpenseid=array.get(8);
				  APIBody = "{\r\n" + 
				  		"  \"intLeaveMasterID\": "+advanceexpenseid+",\r\n" + 
				  		"  \"Domain\": '"+domaintext+"'\r\n" + 
				  		"}";
						  response= postapidata.httpPost(postbaseurl+"api/AdvanceDocument/GetAdvanceDocument" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
				 
			 break;
			 
			 
		
			 
		}
	}

}
