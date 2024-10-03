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

public class PolicycheckPostAPI extends Urls{
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
		
		
			 
			 
		case "PolicyCheck/get" :
		
			 APIBody = "{\r\n" + 
			 		"  \"Domain\":'"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/PolicyCheck/get" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AdvancePolicy/Get" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\":'"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/AdvancePolicy/Get" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "LeavePolicy/Get" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\":'"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/LeavePolicy/Get" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "PolicyCheck/ViewPolicy" :
			
			 APIBody = "{\r\n" + 
			 		"  \"ClaimType\": \"LocalClaim\",\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/PolicyCheck/ViewPolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "PolicyCheck/GetBandWisePolicy" :
			
			 APIBody = "{\r\n" + 
			 		"  \"ClaimType\": \"LocalClaim\",\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/PolicyCheck/GetBandWisePolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
	
		case "PolicyCheck/GetCheckAllowed" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"EmpId\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/PolicyCheck/GetCheckAllowed" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "PolicyCheck/GetCheckAllowedClaimTypes" :
			
			 APIBody = "{\r\n" + 
			 		"  \"mode\": \"Travel\",\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"EmpId\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/PolicyCheck/GetCheckAllowedClaimTypes\r\n" + 
			  		"" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "PolicyCheck/GetClaimTypeWiseClaimAmountLimit" :
			
			 APIBody = "{\r\n" + 
			 		"  \"mode\": \"Travel\",\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"noe\": \"0\",\r\n" + 
			 		"  \"Status\": \"yes\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/PolicyCheck/GetClaimTypeWiseClaimAmountLimit\r\n" + 
			  		"" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "TravelClaim/AllowOvertimeToTravelClaim" :
			
			 APIBody = "{\r\n" + 
			 		"  \"empId\": "+empdata+",\r\n" + 
			 		"  \"date\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/TravelClaim/AllowOvertimeToTravelClaim\r\n" + 
			  		"" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "FoodPolicy/GetBandWisePolicy" :
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\":'"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetFoodType" , APIBody );
			System.out.println(array);
			foodtype = array.get(2);
			
			 APIBody = "{\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"foodPlace\": "+foodtype+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/FoodPolicy/GetBandWisePolicy\r\n" + 
			  		"" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoApprovalPolicyBandWise/GetAllAutoApproverPolicy" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\":'"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoApprovalPolicyBandWise/GetAllAutoApproverPolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoApprovalPolicyBandWise/GetAllAutoApproverPolicybyBandID" :
			
			 APIBody = "{\r\n" + 
			 		"  \"BandID\": "+bandid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoApprovalPolicyBandWise/GetAllAutoApproverPolicybyBandID" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoApprovalPolicy" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"ClaimTypeID\": 1,\r\n" + 
			 		"  \"Amount\": 1.0,\r\n" + 
			 		"  \"TAT\": 1,\r\n" + 
			 		"  \"TAT2\": 1,\r\n" + 
			 		"  \"TAT3\": 1,\r\n" + 
			 		"  \"TAT4\": 1,\r\n" + 
			 		"  \"TAT5\": 1,\r\n" + 
			 		"  \"dtCreatedOn\": \"2019-11-07T17:14:17.1405005+05:30\",\r\n" + 
			 		"  \"CreatedBy\": 1,\r\n" + 
			 		"  \"Status\": true,\r\n" + 
			 		"  \"Domain\": \"gdata\"\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoApprovalPolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AdvancePolicy" :
			
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
			 		"  \"LMasterID\": "+advanceexpenseid+",\r\n" + 
			 		"  \"LeaveTypeID\": "+advancetypeid+",\r\n" + 
			 		"  \"limit\": 3.0,\r\n" + 
			 		"  \"Accumulation\": 4.0,\r\n" + 
			 		"  \"Encashment\": 5.0,\r\n" + 
			 		"  \"band\": "+bandid+",\r\n" + 
			 		"  \"Year\": '"+current.get(Calendar.YEAR)+"',\r\n" + 
			 		"  \"CreatedBy\": 8,\r\n" + 
			 		"  \"CreatedDate\": \"2019-11-07\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AdvancePolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "LeavePolicy" :
			
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
				leavemasterid=array.get(6);
			 APIBody = "{\r\n" + 
			 		"  \"LMasterID\": "+leavemasterid+",\r\n" + 
			 		"  \"LeaveTypeID\": "+leavetypeid+",\r\n" + 
			 		"  \"limit\": 3.0,\r\n" + 
			 		"  \"Accumulation\": 4.0,\r\n" + 
			 		"  \"Encashment\": 5.0,\r\n" + 
			 		"  \"band\": "+bandid+",\r\n" + 
			 		"  \"Year\": '"+current.get(Calendar.YEAR)+"',\r\n" + 
			 		"  \"CreatedBy\": 8,\r\n" + 
			 		"  \"CreatedDate\": \"2019-11-08T10:54:52.7665634+05:30\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeavePolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoRejectPolicy" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody );
				  
				  System.out.println(array);
				  
			 APIBody = "{\r\n" + 
			 		"  \"LMasterID\": "+leavemasterid+",\r\n" + 
			 		"  \"LeaveTypeID\": "+leavetypeid+",\r\n" + 
			 		"  \"limit\": 3.0,\r\n" + 
			 		"  \"Accumulation\": 4.0,\r\n" + 
			 		"  \"Encashment\": 5.0,\r\n" + 
			 		"  \"band\": "+bandid+",\r\n" + 
			 		"  \"Year\": '"+current.get(Calendar.YEAR)+"',\r\n" + 
			 		"  \"CreatedBy\": 8,\r\n" + 
			 		"  \"CreatedDate\": \"2019-11-08T10:54:52.7665634+05:30\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeavePolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoRejectPolicyForArtist" :
			
			
				  
			 APIBody = "{\r\n" + 
			 		"  \"Auto_ID\": 1,\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"ClaimTypeID\": 3,\r\n" + 
			 		"  \"TAT\": 4,\r\n" + 
			 		"  \"dtCreatedOn\": \"2019-11-08T14:38:49.9487844+05:30\",\r\n" + 
			 		"  \"CreatedBy\": 5,\r\n" + 
			 		"  \"Status\": true,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicyForArtist" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "AutoApprovalPolicy/UpdateAutoApproverPolicy" :
			
			
			  
			 APIBody = "{\r\n" + 
			 		"  \"auto_ID\": 1,\r\n" + 
			 		"  \"band\": "+bandid+",\r\n" + 
			 		"  \"claimTypeID\": 1,\r\n" + 
			 		"  \"Amount\": 4.0,\r\n" + 
			 		"  \"tat\": 5,\r\n" + 
			 		"  \"tat2\": 6,\r\n" + 
			 		"  \"tat3\": 7,\r\n" + 
			 		"  \"tat4\": 8,\r\n" + 
			 		"  \"tat5\": 9,\r\n" + 
			 		"  \"createdBy\": 10,\r\n" + 
			 		"  \"status\": true,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoApprovalPolicy/UpdateAutoApproverPolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoApprovalPolicy/CheckDuplicateAutoApproverPolicy" :
			
			
			  
			 APIBody = "{\r\n" + 
			 		"  \"band\": "+bandid+",\r\n" + 
			 		"  \"claimTypeID\": 2,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoApprovalPolicy/CheckDuplicateAutoApproverPolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AdvancePolicy/BalanceLaveDetails" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			 APIBody = "{\r\n" + 
			 		"  \"EmpCode\": "+username+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"leavetype\": "+leavetypeid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AdvancePolicy/BalanceLaveDetails" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "LeavePolicy/BalanceLaveDetails" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/AdvanceRequest/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			 APIBody = "{\r\n" + 
			 		"  \"EmpCode\": "+username+",\r\n" + 
			 		"  \"year\": '"+current.get(Calendar.YEAR)+"',\r\n" + 
			 		"  \"leavetype\": "+leavetypeid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeavePolicy/BalanceLaveDetails" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AdvancePolicy/EmpCarryFBalanceLaveDetails" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			 APIBody = "{\r\n" + 
			 		"  \"EmpCode\": "+username+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"leavetype\": "+leavetypeid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AdvancePolicy/EmpCarryFBalanceLaveDetails" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AdvancePolicy/CheckDuplicateLeavePolicy" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			 APIBody = "{\r\n" + 
			 		"  \"EmpCode\": "+username+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"leavetype\": "+leavetypeid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AdvancePolicy/CheckDuplicateLeavePolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "LeavePolicy/CheckDuplicateLeavePolicy" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			 APIBody = "{\r\n" + 
			 		"  \"leavetype\": "+leavetypeid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeavePolicy/CheckDuplicateLeavePolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "LeavePolicy/CheckExpenseExist" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  array= postapidata.getarraydata(postbaseurl+"api/ApplyLeave/Get" , APIBody);
			  leavetypeid=array.get(1);
			  
			 APIBody = "{\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"mode\": \"\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/LeavePolicy/CheckExpenseExist" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoRejectPolicyBandWise/GetAllAutoRejectPolicy" :
			
			
			  
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicyBandWise/GetAllAutoRejectPolicy" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "AutoApprovalPolicyBandWise/GetAllAutoApproverPolicybyBandIDAndClaimtype" :
			
			
			  
			 APIBody = "{\r\n" + 
			 		"  \"BandID\": "+bandid+",\r\n" + 
			 		"  \"ClaimTypeID\": 1,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoApprovalPolicyBandWise/GetAllAutoApproverPolicybyBandIDAndClaimtype" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoRejectPolicyBandWise/GetAllAutoRejectPolicybyBandID" :
			
		 
			 APIBody = "{\r\n" + 
			 		"  \"BandID\": "+bandid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicyBandWise/GetAllAutoRejectPolicybyBandID" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoRejectPolicyForArtistBandWise/GetAllAutoRejectPolicybyBandID" :
			
			 
			 APIBody = "{\r\n" + 
			 		"  \"BandID\": "+bandid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicyForArtistBandWise/GetAllAutoRejectPolicybyBandID" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoRejectPolicyBandWise/GetAllAutoRejectPolicybyBandIDAndClaimtype" :
			
			 
			 APIBody = "{\r\n" + 
			 		"  \"BandID\": "+bandid+",\r\n" + 
			 		"  \"claimTypeID\": 1,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicyBandWise/GetAllAutoRejectPolicybyBandIDAndClaimtype" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoRejectPolicyForArtistBandWise/GetAllAutoRejectPolicybyBandIDAndClaimtype" :
			
			 
			 APIBody = "{\r\n" + 
			 		"  \"BandID\": "+bandid+",\r\n" + 
			 		"  \"claimTypeID\": 1,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicyForArtistBandWise/GetAllAutoRejectPolicybyBandIDAndClaimtype" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AutoRejectPolicyBandWise/UpdateAutoRemarksClaim" :
			
			 
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
			 		"  \"claim_id\": "+claimid+",\r\n" + 
			 		"  \"recc_Level\": 1,\r\n" + 
			 		"  \"reccID\": "+managerdata+",\r\n" + 
			 		"  \"remarks\": \"sample string 4\",\r\n" + 
			 		"  \"action\": 0,\r\n" + 
			 		"  \"amount\": 6.0,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicyBandWise/UpdateAutoRemarksClaim" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
		
			 
		case "AutoRejectPolicyForArtistBandWise/UpdateAutoRemarksClaim" :
			
			 APIBody = "{\r\n" + 
				 		"  \"BandID\": "+bandid+",\r\n" + 
				 		"  \"claimTypeID\": 1,\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicyForArtistBandWise/GetAllAutoRejectPolicybyBandIDAndClaimtype" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
		case "AutoRejectPolicy/UpdateAutoRejectPolicy" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Auto_ID\": 1,\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"ClaimTypeID\": 1,\r\n" + 
			 		"  \"Amount\": 4.0,\r\n" + 
			 		"  \"TAT\": 1,\r\n" + 
			 		"  \"TAT2\": 1,\r\n" + 
			 		"  \"TAT3\": 1,\r\n" + 
			 		"  \"TAT4\": 1,\r\n" + 
			 		"  \"TAT5\": 1,\r\n" + 
			 		"  \"CreatedBy\": 10,\r\n" + 
			 		"  \"Status\": true,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicy/UpdateAutoRejectPolicy" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
		
		case "AutoRejectPolicyForArtist/UpdateAutoRejectPolicy" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Auto_ID\": 1,\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"ClaimTypeID\": 1,\r\n" + 
			 		"  \"TAT\": 1,\r\n" + 
			 		"  \"CreatedBy\": 5,\r\n" + 
			 		"  \"Status\": true,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicyForArtist/UpdateAutoRejectPolicy" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
		
		case "AutoRejectPolicy/CheckDuplicateAutoRejectPolicy" :
			
			 APIBody = "{\r\n" + 
			 
			 		"  \"band\": "+bandid+",\r\n" + 
			 		"  \"claimTypeID\": 1,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicy/CheckDuplicateAutoRejectPolicy" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
		case "Po7licyCheckOtherClaim/GetBandWisePolicy" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			
			 APIBody = "{\r\n" + 
			 		"  \"Band\": "+bandid+",\r\n" + 
			 		"  \"NOE\": "+noeid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/Po7licyCheckOtherClaim/GetBandWisePolicy" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
				 
		case "AutoRejectPolicyForArtist/CheckDuplicateAutoRejectPolicy" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/OtherClaim/Get" , APIBody );
			 System.out.println("noe array"+array);
				noeid= array.get(1);
			
			 APIBody = "{\r\n" + 
			 		"  \"band\": "+bandid+",\r\n" + 
			 		"  \"claimTypeID\": 1,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/AutoRejectPolicyForArtist/CheckDuplicateAutoRejectPolicy" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
		
				 
			 //Exceed Amount
				 
		case "ExceedAmount/GetCalculateExceedAmountToAddClaim" :
			
			 APIBody = "{\r\n" + 
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"Empid\": "+empdata+",\r\n" + 
			 		"  \"noe\": \"0\",\r\n" + 
			 		"  \"claimType\": 2,\r\n" + 
			 		"  \"band\": "+bandid+",\r\n" + 
			 		"  \"travelmode\": 621,\r\n" + 
			 		"  \"foodplace\": 683,\r\n" + 
			 		"  \"day\": 9,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/ExceedAmount/GetCalculateExceedAmountToAddClaim" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
				 
		case "ExceedAmount/CalculateAndUpdateExceedAmount" :
			
			 APIBody = "{\r\n" + 
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"Empid\": "+empdata+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"noe\": \"0\",\r\n" + 
			 		"  \"claimType\": 1,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/ExceedAmount/CalculateAndUpdateExceedAmount" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
				 
		case "ExceedAmount/CalculateAndUpdateExceedAmountPerDayMonth" :
			
			 APIBody = "{\r\n" + 
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"Empid\": "+empdata+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"noe\": \"0\",\r\n" + 
			 		"  \"claimType\": 1,\r\n" + 
			 		"  \"day\": 6,\r\n" + 
			 		"  \"travelmode\": 0,\r\n" + 
			 		"  \"foodplace\": 0,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/ExceedAmount/CalculateAndUpdateExceedAmountPerDayMonth" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
		case "ExceedAmount/GetAppliedTotal" :
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
			 APIBody = "{\r\n" + 
			 		"  \"week\": \"0\",\r\n" + 
			 		"  \"Empid\": "+empdata+",\r\n" + 
			 		"  \"claimid\": "+claimid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/ExceedAmount/GetAppliedTotal" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
				 
		case "ExceedAmount/CalculateBalanceAmountToAddClaim" :
			
			 APIBody = "{\r\n" + 
			 		"  \"month\": "+current.get(Calendar.MONTH)+",\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"Empid\": "+empdata+",\r\n" + 
			 		"  \"noe\": \"0\",\r\n" + 
			 		"  \"claimType\": 1,\r\n" + 
			 		"  \"band\": "+bandid+",\r\n" + 
			 		"  \"travelmode\": 0,\r\n" + 
			 		"  \"foodplace\": 0,\r\n" + 
			 		"  \"day\": 9,\r\n" + 
			 		"  \"status\": \"true\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/ExceedAmount/CalculateBalanceAmountToAddClaim" , APIBody );
				  assertTrue(response.equalsIgnoreCase("1"));
				 break;
			 
			 
		}
	}

}
