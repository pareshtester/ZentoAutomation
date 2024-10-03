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
import Data.capturePostAPIData;
import TestData.GetApiData;

public class CallPostAPI extends Urls {
	
WebDriver driver;
	
	String Logincode="";
	String empdata="";
	String 	ClaimId="";
	String bandid="";
	String travelexpenseid="";
	String travelinsertresponse="";
	String managerdata="";
	String APIBody="";
	String response="";
	String notificationid="";
	
	int k=0;
	Calendar current = Calendar.getInstance();
	ArrayList<String> array = new ArrayList<String>();

	String travelpolicybindcode="";
	DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	ExtendedCallAPI ecapi= new ExtendedCallAPI();
	PostAPIPage postapi = new PostAPIPage();
	MasterPostApi masterpostapi = new MasterPostApi();
	ClaimTypePostApi claimpostapi = new ClaimTypePostApi();
	FoodAttendanceclaim foodapostapi = new FoodAttendanceclaim();
	AdvanceClaimPostAPI advancepostapi = new AdvanceClaimPostAPI();
	LeavePostAPI leavepostapi = new LeavePostAPI();
	ClaimtypeApprovalProcessPostAPI claimapprovalapi = new ClaimtypeApprovalProcessPostAPI();
	VoucherUploadPostAPi voucherpostapi = new VoucherUploadPostAPi();
	PaymentteamPostAPI paymentpostapi = new PaymentteamPostAPI();
	PolicycheckPostAPI policypostapi = new PolicycheckPostAPI();
	VendorPostApi vendorpostapoi = new VendorPostApi();
	HCPPostAPI hpa = new HCPPostAPI();
	
	public void steps(String functiontext,String username,String password,String managerusername,String managerpassword,
			String policytype,String Gstn,String pannum,String ponum,String invoiceno,String domaintext) throws JSONException, InterruptedException 
	{
		
		String url="http://192.168.1.102:90/";
		
		GetApiData gdata1 = new  GetApiData();
		capturePostAPIData postapidata= new capturePostAPIData();
	
		
		  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
		  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		empdata= array.get(0);
		
		
		if(domaintext.equalsIgnoreCase("lechler"))
		{
		url = "https://lechler.zento.in";	
		}else if(domaintext.equalsIgnoreCase("fulcrum"))
		{
			url = "https://fulcrum.zento.in";	
		}
		   String clardatacode= gdata1.getContenxtWeb(url+"/ClearEmployeeClaims.aspx?EmpCode="+username+"&Domain="+domaintext+"");
			 assertTrue(clardatacode.equalsIgnoreCase("200")||clardatacode.equalsIgnoreCase("201"));
//		   String clardatacode= gdata1.getContenxtWeb("http://192.168.1.14:90/ClearEmployeeClaims.aspx?EmpCode="+username+"&Domain="+domaintext+"");
//			 assertTrue(clardatacode.equalsIgnoreCase("200")||clardatacode.equalsIgnoreCase("201"));
		switch(functiontext){
		case "Login/Get" : 
			
			
	          
			  APIBody = "{\r\n" + 
			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
			  		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Login/Get" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			break;
		
		case "login/GetLogin" : 
			
			
			          
			  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/Login/GetLogin" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			break;
			
		case "login/GetChangePassword" :
			
			  
			APIBody = "{\r\n" + 
					"    \"Mode\": \"changepassword\",\r\n" + 
					"    \"UName\": '"+username+"',\r\n" + 
					"    \"PWD\": '"+password+"',\r\n" + 
					"    \"NewPWD\": '"+password+"',\r\n" + 
					"    \"Domain\": '"+domaintext+"' }";
			  response= postapidata.httpPost(postbaseurl+"api/Login/GetChangePassword" , APIBody );
			 assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
			 
		case "login/GetForgotPassword" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"vcEmail\": \"paresh.patil@gdata.in\",\r\n" + 
			 		"  \"Status\": \"yes\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Login/GetForgotPassword" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
			 
		case "Notification/GetEmpNotificationCount" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"empid\":  '"+username+"',\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Notification/GetEmpNotificationCount" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
		case "Notification/GetEmpNotificationDetails" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"empid\":  "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Notification/GetEmpNotificationDetails" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
		case "Notification/UpdateNotifications" :
			 APIBody = "{\r\n" + 
				 		"  \"empid\":  "+empdata+",\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Notification/GetEmpNotificationDetails" , APIBody );
				  System.out.println(array);
				  notificationid= array.get(2);
			 APIBody = "{\r\n" + 
			 		"  \"NotificationID\": "+notificationid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Notification/UpdateNotifications" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
		case "Dashboard/GetMonths" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\":'"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Dashboard/GetMonths" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
		case "Dashboard/GetWeeks" :
			
			

			 APIBody = "{\r\n\"Month\": "+((current.get(Calendar.MONTH))+1)+",\r\n" + 
			 		"  \"Year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"Domain\":'"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/Dashboard/GetWeeks" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
			 
		case "Dashboard/GetClaimDetailsByClaimID" :
			
			
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
      case "Dashboard/GetClaim" :
			
			
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Dashboard/GetTotalClaim" :
			
			

			 APIBody = "{\r\n" + 
			 		"  \"EmpID\":"+empdata+",\r\n" + 
			 		"  \"Month\": "+((current.get(Calendar.MONTH))+1)+",\r\n" + 
			 		"  \"Year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"Week\": \"0\",\r\n" + 
			 		"  \"Operation\": \"LocalClaim\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Dashboard/GetTotalClaim" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 
			 
		case "Dashboard/GetDashboardClaimTotalExceedAmt" :
			
			

			 APIBody = "{\r\n" + 
			 		"  \"EmpID\":"+empdata+",\r\n" + 
			 		"  \"Month\": "+((current.get(Calendar.MONTH))+1)+",\r\n" + 
			 		"  \"Year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"Week\": \"0\",\r\n" + 
			 		"  \"Operation\": \"LocalClaim\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Dashboard/GetDashboardClaimTotalExceedAmt" , APIBody );
			  assertTrue(response.equalsIgnoreCase("Success"));
			 break;
			 //********************Masters********************************
			 
		case "FoodClaim/GetFoodType" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetReasonsList" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetTypeOfWork" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetMasterDataList" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetClaimTypeWiseAndBandWiseModeOfTravel" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetCityDataList" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetEmployees" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetBandList" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetAllClaimType" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetStateList" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetTownList" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "LoadCoverageType" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetDomainBasedEmployeeList" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break; 
		case "GetBindEmployeeClaimTypes" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "GetDepartmentList" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "employees/GetShifts" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "Master/GetCoEmployeeFoodType" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceRequest/Get" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Master/GetFoodType" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "Master/GetDepartmentList" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "Master/GetAllowance" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Master/GetTravelMode" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Master/GetTravelModePrice" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Master/GetSFC" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Master/GetTravelFare" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Master/GetKmDistance" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetZonesByTeam" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetCOEmployeeByClaim" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpPunchingDetails" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetShiftById" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetallEmpWorkingInShift" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "GetallEmpWorkingShiftData" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FieldMaster/GetFieldMaster" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DeviceInfo" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TotalCount/GetCount" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		
			 
		case "GetInsertLocalClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetMasterClaimID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LocalClaimView/GetClaimByID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpAppliedExpenseDataLocal" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "UpdateLocalClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LocalClaim/GetInsertClaimDocs" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "OtherClaim/Get" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 //Landline claim  
			 
		case "GetInsertLandLineClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LandLineClaim/GetMasterClaimID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpAppliedClaimDataLandLine" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LandLineClaim/GetInsertClaimDocs" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			
		case "LandlineView/GetClaimByID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpAppliedExpenseDataLandLine" :	 
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LandlineView/UpdateLandLineClaim" :	 
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 //Mobile claim
			 
		 case "MobileClaim/GetEmpAppliedClaimData" :
			 claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetInsertMobileClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			
		case "MobileClaim/GetMasterClaimID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "MobileView/GetClaimByID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpAppliedExpenseDataMobile" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "UpdateMobileClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "MobileClaim/GetInsertClaimDocs" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "ValiadteMobileClaimDTO" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
			 //Hotel claim   	
		case "InsertAccomodationClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break; 
			 
		case "AccomodationClaim/GetMasterClaimID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AccomodationClaim/GetEmpAppliedExpenseDataAccomodation" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "GetEmpAppliedClaimDataAccomodation" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AccomodationClaimView/GetEmpAppliedClaimDataAccomodation" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "UpdateAccomodationClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AccomodationClaimView/GetAccomodationClaims" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		//Other claim
		case "GetInsertOtherClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "OtherClaim/GetMasterClaimID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "OtherClaim/GetInsertClaimDocs" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "OtherClaimView/GetClaimByID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "OtherClaimView/GetEmpAppliedExpenseDataOther" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "UpdateOtherClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "OtherClaimView/ValidateOtherClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "OtherClaim/GetEmpAppliedClaimDataOthe" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 //Travel claim    
			
		case "GetInsertUpdateTravelClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TravelClaim/GetMasterClaimID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TravelClaim/GetEmpAppliedClaimData" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		
		case "GetClaimTypeWiseTotalClaimAmountForExceed" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;  
			
		case "TravelClaim/GetInsertClaimDocs" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break; 
			 
		case "UpdateTravelClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;   
			 
		case "GetTotalExpensesForTravel" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "CalculateAndUpdateExceedAmountForTravel" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TravelClaimView/GetClaimDocuments" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TravelClaimView/GetEmpAppliedExpenseDataTravel" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TravelClaimView/GetClaimByID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TravelClaim/InsertUpdateSupportTarvelClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;   
			 
		case "GetSupportTravelClaimStatusDetails" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TravelClaim/GetTravelDetailsByID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TravelClaim/DeleteTravelClaimDetails" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DeleteTravelClaimDocuments" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "LocalClaim/GetEmpAppliedClaimData" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			
		case "TravelClaim/GetSupportTravelClaimPendingDetails" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TravelClaimView/CalculateAndUpdateExceedAmountForTravel" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
			 
            //Food
			 
		case "FoodClaim/InsertFoodClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetMasterClaimID" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetEmpAppliedClaimDataFood" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaimView/GetEmpAppliedExpenseDataFood" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "UpdateFoodClaim" :
			claimpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaimView/GetFoodClaims" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "FoodClaim/InsertArtistClaim" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetFoodTypeById" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/getClaimById" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "FoodClaim/GetFoodClaimStatusDetails" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/deleteClaimById" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "FoodClaim/getCoempClaimDate" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "FoodClaim/getClaimStatus" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetFoodWiseClaimStatus" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetAllClaimStatus" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetAllClaimStatusConditionWise" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetAllClaimRejectedStatus" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetEmpPendingClaimStatus" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetClaimCoditionWise" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetArtistDFoodDetailsByID" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "FoodClaim/UpdateArtistClaim" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetLocalClaimAppliedbyDate" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodClaim/GetCheckAppliedCoEmpData" :
			foodapostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		
			 
			 
			 //Advance claim
			 
		case "AdvanceRequest/InsertAdvance" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceRequest/GetMasterAdvanceId" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceRequest/UpdateAdvance" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpAdvanceData/GetEmpAppliedAdvance" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpAdvanceData/GetEmpAppliedAdvanceByStatus" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpAdvanceData/GetLeaveDetailsByAdvanceID" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpAdvanceData/DeleteAdvance" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "AdvanceSettlements/GetAdvancesatdetailsbyid" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceSettlements/Get" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvancePayment/GetAllAdvanceClaim" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceProcessing/SubmitAdvance" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceProcessing/AdvanceDetailsbyID" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceProcessing/AdvanceDetailsByClaimID" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceProcessing/GetApproverAdvance" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceProcessing/ApproveDisapproveAdvance" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		
		case "AdvanceProcessing/ReopenAdvance" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceSettlements" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Advance" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceDocument/GetAdvanceDocumentsList" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvanceDocument/GetAdvanceDocument" :
			advancepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		
			 
			 
			 //Leave
		case "ApplyLeave/Get" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ApplyLeave/InsertLeave" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ApplyLeave/GetMasterLeaveId" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ApplyLeave/UpdateLeave" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpLeaveData/GetEmpAppliedLeaves" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpLeaveData/GetLeaveDetailsByLeaveID" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "GetEmpLeaveData/DeleteLeaveDTO" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeaveDocument" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeaveBalance" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "LeaveDocument/GetLeaveDocument" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeaveProcessing/SubmitLeave" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "LeaveProcessing/GetApproverLeaves" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeaveProcessing/ApproveDisapproveLeave" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeaveProcessing/ReopenLeave" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeaveStatus/LeaveStatus" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "LeaveBalance/GetEmployeeBalance" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeaveBalance/GetEmployeeBalanceLeave" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeaveBalance/GetCheckAppliedLeave" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeaveDocument/Get" :
			leavepostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //Claim submit
		case "Submit/SubmitClaim" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Submit/GetAllClaimsToSubmit" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //Claim processing
		case "ClaimProcessing/ApproveDissapproveClaim" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ClaimProcessing/ApproveDissapproveClaims" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ClaimProcessing/Valiadte_LandLineClaim" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ClaimProcessing/ApproveClaim" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ClaimProcessing/DisapproveClaim" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ClaimProcessing/DisapproveClaimForInternalAutoReject" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //holiday
			 
		case "Holiday" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Holiday/GetHolidayList" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Holiday/GetCountHoliday" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Holiday/GetCountHolidaybyEMPID" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Holiday/GetHolidayByEmpID" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //Email
		case "SendEmail/SendMail" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "SendEmail" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //Policy
			 
		case "PolicyCheck/get" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvancePolicy/Get" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeavePolicy/Get" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "PolicyCheck/ViewPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "PolicyCheck/GetBandWisePolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "PolicyCheck/GetCheckAllowed" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "PolicyCheck/GetCheckAllowedClaimTypes" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "PolicyCheck/GetClaimTypeWiseClaimAmountLimit" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "TravelClaim/AllowOvertimeToTravelClaim" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "FoodPolicy/GetBandWisePolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoApprovalPolicyBandWise/GetAllAutoApproverPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoApprovalPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvancePolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeavePolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoApprovalPolicy/UpdateAutoApproverPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoApprovalPolicy/CheckDuplicateAutoApproverPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvancePolicy/BalanceLaveDetails" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AdvancePolicy/EmpCarryFBalanceLaveDetails" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LeavePolicy/CheckDuplicateLeavePolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "AdvancePolicy/CheckDuplicateLeavePolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "LeavePolicy/CheckExpenseExist" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicyBandWise/GetAllAutoRejectPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;	
			 
		case "AutoApprovalPolicyBandWise/GetAllAutoApproverPolicybyBandID" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoApprovalPolicyBandWise/GetAllAutoApproverPolicybyBandIDAndClaimtype" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicyBandWise/GetAllAutoRejectPolicybyBandID" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicyForArtistBandWise/GetAllAutoRejectPolicybyBandID" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicyBandWise/GetAllAutoRejectPolicybyBandIDAndClaimtype" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicyForArtistBandWise/GetAllAutoRejectPolicybyBandIDAndClaimtype" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicyBandWise/UpdateAutoRemarksClaim" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicyForArtistBandWise/UpdateAutoRemarksClaim" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicy/UpdateAutoRejectPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicyForArtist/UpdateAutoRejectPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicy/CheckDuplicateAutoRejectPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicyForArtist/GetAllAutoRejectPolicyForArtist" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Po7licyCheckOtherClaim/GetBandWisePolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "AutoRejectPolicyForArtist/CheckDuplicateAutoRejectPolicy" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //Profile details
			 
		case "ProfileDetails/GetEmployeeProfileDetails" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ProfileDetails/UpdateEmployeeProfile" :
			masterpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
			 ////RptClaimDetails
			 
		case "RptClaimDetails/GetApproverClaimCount" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "RptClaimDetails/GetApproverClaimsByClaimType" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //upload voucher
			 
		case "DocumentUpload" :
			voucherpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DocumentUpload/DownloadDoc" :
			voucherpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DocumentUpload/GetClaimWiseDocuments" :
			voucherpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DocumentUpload/DeleteDoc" :
			voucherpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //Apply claim
			 
		case "ApplyClaim/GetCheckAppliedClaimsCWeek" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ApplyClaim/CheckClaimExist" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "LevelIndicator/GetClaimApprover" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
			 //Payment team 
		case "Payment/GetPaymentApprovedClaimIds" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "Payment/GetPaymentApprovedClaimList" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
		case "PaymentAction/GetDataForDashboardHGS" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //Driver 
		case "DriverClaim/GetInsertDriverClaim" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DriverClaim/Get" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
		case "DriverClaim/GetInsertClaimDocs" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DriverClaim/GetMasterClaimID" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DriverClaim/GetEmpAppliedClaimData" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DriverClaimView/GetClaimByID" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DriverClaimView/GetEmpAppliedExpenseDataDriver" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DriverClaimView/UpdateDriverClaim" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "DriverClaimView/ValidateDriverClaim" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
			 //Exceed amount
			 
		case "ExceedAmount/GetCalculateExceedAmountToAddClaim" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ExceedAmount/CalculateAndUpdateExceedAmount" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ExceedAmount/CalculateAndUpdateExceedAmountPerDayMonth" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ExceedAmount/GetAppliedTotal" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ExceedAmount/CalculateBalanceAmountToAddClaim" :
			policypostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
			 //Reopen Claim
			 
		case "ReOpen/ReopenClaim" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "ReOpen/ReopenCOEmployeeClaim" :
			paymentpostapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //DeleteExpenses   
			 
		case "DeleteExpenses/DeleteExpense" :
			claimapprovalapi.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 //HCP
			 
		case "HCP/GetSpecialityByQualificationList" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetSpecialityByPracticeList" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetQualificationList" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetClassificationList" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetLocationType" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetHospitalType" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetHospitalAttachedTo" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetStateList" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetHCPLadder" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetCityList" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetDomesticWorkShopList" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetInternationalWorkShopList" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetPriorityBandList" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
		case "HCP/GetCMESpeakerTypes" :
			hpa.steps(functiontext, username, password, managerusername, managerpassword, policytype, domaintext);
			 break;
			 
			 
			 //Vendor Management
			 
		case "Vendor/RegisterVendor" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Vendor/GetVendorListdetails" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Vendor/VendorDetailsByVendorID" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Vendor/UpdateVendorData" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Vendor/Login" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Vendor/ActiveInactiveVendor" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Vendor/ChangePassword" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Vendor/GetDuplicateVendorDetails" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Vendor/ForgotPassword" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Vendor/GetActiveVendorDetails" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PO/CreatePO" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PO/GetPOList" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/GetPODetailsByID" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/UpdatePO" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/GetPaymentCycle" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/Get_tblPaymentCycle" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/Get_tblTerms" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/Get_tblPercentage" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/CreatePOPaymentCycle" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/GetPOCycleDetailsByID" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/DeletePOPaymentCycle" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			 
			 
		case "PurchaseOrder/DocumentUpload" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			 
		case "PurchaseOrder/DownloadDoc" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/GetPOWiseDocuments" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
		case "PurchaseOrder/DeleteDoc" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;	 
			
		case "PurchaseOrder/GetPOStatus" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;	 
			
		case "PurchaseOrder/CheckPOApprovalHierarchy" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;	
			
		case "Invoice/InsertInvoiceDetails" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/UpdateInvoiceDetails" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetInvoiceDetailsByPONumber" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/DeleteInvoiceDetails" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetInvoiceDetailsByInvoiceID" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
		case "Invoice/SubmitInvoice" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/InvoiceStatus" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
		
		case "Invoice/GetPOListbyVendorID" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetValidateInvoiceAmt" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetApproverPO" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/DocumentUpload" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/DownloadDoc" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetInvoiceWiseDocuments" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/DeleteDoc" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetApproverPOIDByReccID" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetApproverVendorIDByReccID" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetDataforFinanceInvoiceDTO" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetDataforOnlineInvoiceDTO" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/UpdateSettledInvoice" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetInvoicePaidDetails" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/ReopenInvoice" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetReccIDByInvoiceNo" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetReasonsforInvoice" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetInvoiceDetailsPONumberList" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetValidateInvoice" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetApproverInvoices" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "Invoice/GetApproveDisapproveInvoice" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
			
		case "Vendor/ChangeVendorPasswordByAdmin" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		case "PurchaseOrder/UpdatePOPaymentCycle" :
			vendorpostapoi.steps(functiontext, username, password, managerusername, managerpassword, policytype, Gstn, pannum,ponum,invoiceno,domaintext);
			break;
			
		}
	}

}
