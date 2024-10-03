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

public class LeavePostAPI extends Urls{
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
	String leavetypeid="";
	String leaveid="";
	String leavemasterid="";
	int k=0;
	Calendar current = Calendar.getInstance();
	ArrayList<String> array = new ArrayList<String>();

	String travelpolicybindcode="";
	DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	ExtendedCallAPI ecapi= new ExtendedCallAPI();

	
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
	
			 
		case "ApplyLeave/Get" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "ApplyLeave/InsertLeave" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  response= postapidata.httpPost(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "ApplyLeave/GetMasterLeaveId" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  response= postapidata.httpPost(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "ApplyLeave/UpdateLeave" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				
				APIBody = "{\r\n" + 
						"  \"LeaveDetailsId\": "+leaveid+",\r\n" + 
						"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
						"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
						"  \"Location\": \"sample string 4\",\r\n" + 
						"  \"LeaveType\": "+leavetypeid+",\r\n" + 
						"  \"Reason\": \"sample string 6\",\r\n" + 
						"  \"NoOfLeaves\": 7.0,\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/ApplyLeave/UpdateLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "GetEmpLeaveData/GetEmpAppliedLeaves" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				APIBody = "{\r\n" + 
						"  \"EmpId\": "+empdata+",\r\n" + 
						"  \"IsSubmit\": 2,\r\n" + 
						"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
						"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/GetEmpLeaveData/GetEmpAppliedLeaves" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
		case "GetEmpLeaveData/GetLeaveDetailsByLeaveID" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				leavemasterid=array.get(4);
				APIBody = "{\r\n" + 
						"  \"LeaveMasterId\": "+leavemasterid+",\r\n" + 
						"  \"LeaveId\": "+leaveid+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/GetEmpLeaveData/GetLeaveDetailsByLeaveID" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;

			 
		case "GetEmpLeaveData/DeleteLeaveDTO" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				leavemasterid=array.get(4);
				APIBody = "{\r\n" + 
						"  \"LeaveId\": "+leaveid+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/GetEmpLeaveData/DeleteLeaveDTO" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "LeaveDocument" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				leavemasterid=array.get(4);
				APIBody = "{\r\n" + 
						"  \"LDID\": 1,\r\n" + 
						"  \"FileName\": \"sample string 2\",\r\n" + 
						"  \"FileExt\": \"sample string 3\",\r\n" + 
						"  \"Path\": \"sample string 4\",\r\n" + 
						"  \"intLeaveMasterID\": "+leavemasterid+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveDocument" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "LeaveBalance" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				leavemasterid=array.get(4);
				APIBody = "{\r\n" + 
						"  \"intLID\": 1,\r\n" + 
						"  \"vcEmpCode\": '"+empdata+"',\r\n" + 
						"  \"vcLeaveType\": "+leavetypeid+",\r\n" + 
						"  \"Entitlement\": 4.0,\r\n" + 
						"  \"EARNED\": 5.0,\r\n" + 
						"  \"C_F1\": 6.0,\r\n" + 
						"  \"C_F2\": 7.0,\r\n" + 
						"  \"IN_LIEU\": 8.0,\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveBalance" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "LeaveDocument/GetLeaveDocument" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				leavemasterid=array.get(4);
				APIBody = "{\r\n" + 
						"  \"intLeaveMasterID\": "+leavemasterid+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveDocument/GetLeaveDocument" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "LeaveProcessing/SubmitLeave" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				leavemasterid=array.get(4);
				APIBody = "{\r\n" + 
						"  \"LeaveId\": "+leavemasterid+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveProcessing/SubmitLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "LeaveProcessing/GetApproverLeaves" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				leavemasterid=array.get(4);
				
				APIBody = "{\r\n" + 
						"  \"LeaveId\": "+leavemasterid+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveProcessing/SubmitLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  
			  
				APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
				  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
				  System.out.println(array);
				
				managerdata= array.get(5);
				
				
				APIBody = "{\r\n" + 
						"  \"ApproverId\": "+managerdata+",\r\n" + 
						"  \"status\": \"pending\",\r\n" + 
						"  \"month\": "+(current.get(Calendar.MONTH)+1)+",\r\n" + 
						"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveProcessing/GetApproverLeaves" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "LeaveProcessing/ApproveDisapproveLeave" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				leavemasterid=array.get(4);
				APIBody = "{\r\n" + 
						"  \"LeaveId\": "+leavemasterid+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveProcessing/SubmitLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
				
				
				APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
				  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
				  System.out.println(array);
				
				managerdata= array.get(5);
				
				
				APIBody = "{\r\n" + 
						"  \"LeaveId\": "+leavemasterid+",\r\n" + 
						"  \"ReccId\": "+managerdata+",\r\n" + 
						"  \"Remarks\": \"sample string 3\",\r\n" + 
						"  \"Action\": 0,\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveProcessing/ApproveDisapproveLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "LeaveProcessing/ReopenLeave" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				leavemasterid=array.get(4);
				
				
				
				APIBody = "{\r\n" + 
						"  \"LeaveId\": "+leavemasterid+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveProcessing/SubmitLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  
				APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
				  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
				  System.out.println(array);
				
				managerdata= array.get(5);
				
				
				APIBody = "{\r\n" + 
						"  \"LeaveId\": "+leavemasterid+",\r\n" + 
						"  \"ReccId\": "+managerdata+",\r\n" + 
						"  \"Remarks\": \"sample string 3\",\r\n" + 
						"  \"Action\": 0,\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveProcessing/ApproveDisapproveLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  
			  APIBody = "{\r\n" + 
			  		"  \"LeaveId\": "+leavemasterid+",\r\n" + 
			  		"  \"NoOfLeaves\": 2.0,\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveProcessing/ReopenLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));

			 break;
			 
		case "LeaveStatus/LeaveStatus" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			System.out.println(array);
			
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Location\": \"sample string 3\",\r\n" + 
			 		"  \"LeaveType\": "+leavetypeid+",\r\n" + 
			 		"  \"Reason\": \"sample string 5\",\r\n" + 
			 		"  \"NoOfLeaves\": 6.0,\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  
			  
			  masterclaimid= postapidata.getonlydata(postbaseurl+"api/ApplyLeave/InsertLeave" , APIBody);
			  masterclaimid = masterclaimid.replaceAll("[\\[\\]\\(\\)]", "");
			  APIBody = "{\r\n" + 
			  		"  \"LeaveDetailsId\": "+masterclaimid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  array= postapidata.getdata(postbaseurl+"api/ApplyLeave/GetMasterLeaveId" , APIBody);
				System.out.println("leave id"+array);
				leaveid = array.get(3);
				leavemasterid=array.get(4);
				
				
				
				APIBody = "{\r\n" + 
						"  \"LeaveId\": "+leavemasterid+",\r\n" + 
						"  \"Domain\": '"+domaintext+"'\r\n" + 
						"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveProcessing/SubmitLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  
				
			  
			  APIBody = "{\r\n" + 
			  		"  \"LeaveMasterId\": "+leavemasterid+",\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveStatus/LeaveStatus" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));

			 break;
			 
			 
		case "LeaveBalance/GetEmployeeBalance" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			
			  
				
			  
			  APIBody = "{\r\n" + 
			  		"  \"EmpCode\": '"+empdata+"',\r\n" + 
			  		"  \"LeaveType\": '"+leavetypeid+"',\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveBalance/GetEmployeeBalance" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));

			 break;
			 
			 
		case "LeaveBalance/GetEmployeeBalanceLeave" :
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			
			
			  
				
			  
			  APIBody = "{\r\n" + 
			  		"  \"EmpCode\": '"+empdata+"',\r\n" + 
			  		"  \"LeaveType\": '"+leavetypeid+"',\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveBalance/GetEmployeeBalance" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  
		case "LeaveBalance/GetCheckAppliedLeave" :
			
			  APIBody = "{\r\n" + 
			  		"  \"EmpCode\": "+username+",\r\n" + 
			  		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveBalance/GetCheckAppliedLeave" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));

			 break;
			 
		case "LeaveDocument/Get" :
			
			  APIBody = "{\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeaveDocument/Get" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));

			 break;
			 
		
			 
		
}
	}
}
