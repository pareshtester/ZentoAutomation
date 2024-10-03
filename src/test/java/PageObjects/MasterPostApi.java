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

public class MasterPostApi extends Urls {
	
	
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
	String travelwayid="";
	 String travelmodeid="";
	 String towndata="";
	 String fromtown="";
	 String totown="";
	 String hqtype="";
	 String Fromtowntrim="";
	 String totowntrim="";
	 String teamid="";
	 
	 String fromcityid="";
		String tocityid="";
	
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
	 String[] arrOfStr = towndata.split("-", 0); 

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
		teamid=array.get(5);
;//		   String clardatacode= gdata1.getContenxtWeb("http://192.168.1.14:90/ClearEmployeeClaims.aspx?EmpCode="+username+"&Domain="+domaintext+"");
//			 assertTrue(clardatacode.equalsIgnoreCase("200")||clardatacode.equalsIgnoreCase("201"));
		switch(functiontext){
		
		
			 //Masters
			 
		case "GetReasonsList" :
		
			 APIBody = "{\r\n" + 
			 		"  \"Domain\":'"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetReasonsList" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetTypeOfWork" :
			 APIBody = "{\r\n" + 
			 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetMasterDataList" :
		
			 APIBody = "{\r\n" + 
			 		"  \"MasterType\": \"WBS\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetClaimTypeWiseAndBandWiseModeOfTravel" :
			
			 APIBody = "{\r\n" + 
			 		"  \"ClaimType\": \"Travelclaim\",\r\n" + 
			 		"  \"band\": "+bandid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetClaimTypeWiseAndBandWiseModeOfTravel" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetCityDataList" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetCityDataList" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
		case "GetEmployees" :
			
			 APIBody = "{\r\n" + 
			 		"  \"TeamId\": 0,\r\n" + 
			 		"  \"ZoneId\": 0,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Employees/GetEmployees" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
		case "GetBandList" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetBandList" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetAllClaimType" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetAllClaimType" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetStateList" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetStateList" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetTownList" :
			
			 APIBody = "{\r\n" + 
			 		"  \"TownType\": \"fromtown\",\r\n" + 
			 		"  \"Territory\": "+territoryid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Holiday/GetTownList" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "LoadCoverageType" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Territory\": "+territoryid+",\r\n" + 
			 		"  \"fromPlace\": \"TestTown3\",\r\n" +      //hardcoded 
			 		"  \"toPlace\": \"TestTown3\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Holiday/LoadCoverageType" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetDomainBasedEmployeeList" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Login/Get" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "GetBindEmployeeClaimTypes" :
			
			 APIBody = "{\r\n" + 
			 		"  \"bandID\": "+bandid+",\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"ClaimWeek\": \"0\",\r\n" + 
			 		"  \"month\": 0,\r\n" + 
			 		"  \"date\": \"2019-10-01T13:09:01.8881543+05:30\",\r\n" + 
			 		"  \"Domain\": \"lechler\"\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetBindEmployeeClaimTypes" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
		case "GetDepartmentList" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetDepartmentList" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "OtherClaim/Get" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/OtherClaim/Get" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "employees/GetShifts" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/employees/GetShifts" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "FoodClaim/GetFoodType" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetFoodType" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "Master/GetCoEmployeeFoodType" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetCoEmployeeFoodType" , APIBody );
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "AdvanceRequest/Get" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/AdvanceRequest/Get" , APIBody);
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "Holiday" :
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
				  System.out.println(array);
			Stateid = array.get(2);
			 APIBody = "{\r\n" + 
			 		"  \"HId\": 1,\r\n" + 
			 		"  \"HolidayName\": \"Makarsankranti\",\r\n" + 
			 		"  \"HolidayDetails\": \"Makarsankranti\",\r\n" + 
			 		"  \"HolidayFromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"HolidayToDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"CreatedBy\": 4,\r\n" + 
			 		"  \"year\": "+current.get(Calendar.YEAR)+",\r\n" + 
			 		"  \"State\": "+Stateid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Holiday" , APIBody);
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "Holiday/GetHolidayList" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"year\": "+(current.get(Calendar.YEAR))+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/Holiday/GetHolidayList" , APIBody);
				  System.out.println("Response is->>>"+response);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "Holiday/GetCountHoliday" :
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetStateList" , APIBody );
				  System.out.println(array);
			Stateid = array.get(2);
			 APIBody = "{\r\n" + 
			 		"  \"state\": "+Stateid+",\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Holiday/GetCountHoliday" , APIBody);
			  System.out.println("Response is->>>"+response);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "Holiday/GetCountHolidaybyEMPID" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"EMPID\": "+empdata+",\r\n" + 
			 		"  \"fromDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"toDate\": '"+dtf.format(localDate)+"',\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/Holiday/GetCountHolidaybyEMPID" , APIBody);
				  System.out.println("Response is->>>"+response);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "Holiday/GetHolidayByEmpID" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"EMPID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/Holiday/GetHolidayByEmpID" , APIBody);
				  System.out.println("Response is->>>"+response);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "Master/GetFoodType" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\":'"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetFoodType" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "Master/GetDepartmentList" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Domain\":'"+domaintext+"'}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetDepartmentList" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "Master/GetAllowance" :
			
			 APIBody = "{\r\n" + 
			 		"  \"AllowanceHead\": 1,\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"HQ\": 3,\r\n" + 
			 		"  \"Residential\": 4,\r\n" + 
			 		"  \"NightHalt\": 5,\r\n" + 
			 		"  \"INOUTNA\": 6,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetAllowance" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "Master/GetTravelMode" :
			
			 APIBody = "{\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"fromPlace\": \"TestTown3\",\r\n" + 
			 		"  \"toPlace\": \"TestTown3\",\r\n" + 
			 		"  \"HQType\": 1715,\r\n" + 
			 		"  \"workType\": 1709,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetTravelMode" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
		case "Master/GetTravelModePrice" :
			
			
			APIBody = "{\r\n" + 
			 		"  \"empid\": "+empdata+",\r\n" + 
			 		"  \"fromPlace\": \"TestTown3\",\r\n" + 
			 		"  \"toPlace\": \"TestTown3\",\r\n" + 
			 		"  \"HQType\": 1715,\r\n" + 
			 		"  \"workType\": 1709,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTravelMode" , APIBody );
			  System.out.println(array);
			 APIBody = "{\r\n" + 
			 		"  \"travelmode\": 1,\r\n" + 
			 		"  \"Domain\": \"fulcrum\"\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetTravelModePrice" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
		
			 
         case "Master/GetSFC" :
			
			 APIBody = "{\r\n" + 
			 		"  \"Territory\": "+territoryid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetSFC" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
         case "Master/GetTravelFare" :
        	 
        	 APIBody = "{\r\n" + 
 			 		"  \"empid\": "+empdata+",\r\n" + 
 			 		"  \"fromPlace\": \"TestTown3\",\r\n" + 
 			 		"  \"toPlace\": \"TestTown3\",\r\n" + 
 			 		"  \"HQType\": 1715,\r\n" + 
 			 		"  \"workType\": 1709,\r\n" + 
 			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
 			 		"}";
 			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTravelMode" , APIBody );
 			   travelmodeid= array.get(1);
        	 APIBody = "{\r\n" + 
				 		"  \"worktype\": \"TravelWay\",\r\n" + 
				 		"  \"empid\": "+empdata+",\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
				  System.out.println("travelwayid array is"+array);
				  travelwayid=array.get(1);
			 APIBody = "{\r\n" + 
			 		"  \"TravelMode\": "+travelmodeid+",\r\n" + 
			 		"  \"travelWay\": "+travelwayid+",\r\n" + 
			 		"  \"travelKm\": 3.0,\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetTravelFare" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
  case "Master/GetKmDistance" :
        	 
	  System.out.println("here");
	  
	  APIBody = "{\r\n" + 
		 		"  \"worktype\": \"TypeOfWork\",\r\n" + 
		 		"  \"empid\": "+empdata+",\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'}";
		  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
		  System.out.println("travelwayid array is"+array);
		  travelwayid=array.get(1);
	  
	  APIBody = "{\r\n" + 
		 		"  \"Territory\": "+territoryid+",\r\n" + 
		 		"  \"fromPlace\": \"TestTown3\",\r\n" +      //hardcoded 
		 		"  \"toPlace\": \"TestTown3\",\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Holiday/LoadCoverageType" , APIBody );
		  
		  hqtype = array.get(1);
		 APIBody = "{\r\n" + 
		 		"  \"TownType\": \"fromtown\",\r\n" + 
		 		"  \"Territory\": "+territoryid+",\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  array= postapidata.getarraydata(postbaseurl+"api/Holiday/GetTownList" , APIBody );
		  System.out.println(array);
		  int i=0;
			
		  towndata=array.get(i);
		
		
	
		 
		  arrOfStr = towndata.split("-", 0); 
			//System.out.println(Arrays.toString(towndata.split("-")));
			i=0;
			//String[] townarray = Arrays.toString(towndata.split("-"));
            //String fromTown = Arrays.toString(towndata.split("-"))
			 fromtown = arrOfStr[0];
			 totown = arrOfStr[1];
			 System.out.println(fromtown);
			 System.out.println(totown);
			 
			 Fromtowntrim = fromtown.trim();
			 totowntrim = totown.trim();
			 System.out.println(Fromtowntrim);
			 System.out.println(totowntrim);
        	 APIBody = "{\r\n" + 
        	 		"  \"empid\": "+empdata+",\r\n" + 
        	 		"  \"fromPlace\": '"+Fromtowntrim+"',\r\n" + 
        	 		"  \"toPlace\": '"+totowntrim+"',\r\n" + 
        	 		"  \"HQType\": "+hqtype+",\r\n" + 
        	 		"  \"workType\": "+travelwayid+",\r\n" + 
        	 		"  \"Domain\": '"+domaintext+"'\r\n" + 
        	 		"}";
 			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTravelMode" , APIBody );
 			   travelmodeid= array.get(1);
        	 APIBody = "{\r\n" + 
				 		"  \"worktype\": \"TravelWay\",\r\n" + 
				 		"  \"empid\": "+empdata+",\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'}";
				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
				  System.out.println("travelwayid array is"+array);
				  travelwayid=array.get(1);
			 APIBody = "{\r\n" + 
			 		"  \"Territory\": "+territoryid+",\r\n" + 
			 		"  \"fromPlace\": '"+Fromtowntrim+"',\r\n" + 
			 		"  \"toPlace\": '"+totowntrim+"',\r\n" + 
			 		"  \"HQType\": "+hqtype+",\r\n" + 
			 		"  \"TravelMode\": "+travelmodeid+",\r\n" + 
			 		"  \"travelWay\": "+travelwayid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			  response= postapidata.httpPost(postbaseurl+"api/Master/GetKmDistance" , APIBody );
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
  case "GetZonesByTeam" :
		
		 APIBody = "{\r\n" + 
		 		"  \"TeamId\": "+teamid+",\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  response= postapidata.httpPost(postbaseurl+"api/Employees/GetZonesByTeam" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
			 
		 
  case "GetCOEmployeeByClaim" :
	  
	  System.out.println("here");
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
		  
//		  if(domaintext.equalsIgnoreCase("lechler"))
//		  {
//			  System.out.println("here typeofvisitid");
//			  APIBody = "{\r\n" + 
//				 		"  \"worktype\": \"Typeofvisit\",\r\n" + 
//				 		"  \"empid\": "+empdata+",\r\n" + 
//				 		"  \"Domain\": '"+domaintext+"'}";
//				  array= postapidata.getarraydata(postbaseurl+"api/Master/GetTypeOfWork" , APIBody );
//				  typeofvisitid=array.get(1);
//		  }else
//		  {
//			  typeofvisitid="0";
//		  }
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
		 		"  \"Domain\": '"+domaintext+"',\r\n" + 
		 		"  \"claimid\": "+foodclaimid+"\r\n" + 
		 		"}";
		  response= postapidata.httpPost(postbaseurl+"api/Employees/GetCOEmployeeByClaim" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
  case "GetEmpPunchingDetails" :
		
		 APIBody = "{\r\n" + 
		 		"  \"domain\": '"+domaintext+"',\r\n" + 
		 		"  \"empid\": "+empdata+",\r\n" + 
		 		"  \"date\": '"+dtf.format(localDate)+"'\r\n" + 
		 		"}";
		  response= postapidata.httpPost(postbaseurl+"api/Employees/GetEmpPunchingDetails" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
  case "GetShiftById" :
	  
	  APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
	  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
	  shiftid=array.get(1);
		
		 APIBody = "{\r\n" + 
		 		"  \"domain\": '"+domaintext+"',\r\n" + 
		 		"  \"shiftid\": "+shiftid+"\r\n" + 
		 		"}";
		  response= postapidata.httpPost(postbaseurl+"api/master/GetShiftById" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
     case "GetallEmpWorkingInShift" :
	  
	  APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
	  array= postapidata.getarraydata(postbaseurl+"api/employees/GetShifts" , APIBody );
	  shiftid=array.get(1);
		
		 APIBody = "{\r\n" + 
		 		"  \"date\": '"+dtf.format(localDate)+"',\r\n" + 
		 		"  \"shift\": "+shiftid+",\r\n" + 
		 		"  \"domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  response= postapidata.httpPost(postbaseurl+"api/Employees/GetallEmpWorkingInShift" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
     case "GetallEmpWorkingShiftData" :
    	 
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
   		 		"  \"empID\": "+empdata+",\r\n" + 
   		 		"  \"domain\": '"+domaintext+"'\r\n" + 
   		 		"}";
   		  response= postapidata.httpPost(postbaseurl+"api/Employees/GetallEmpWorkingShiftData" , APIBody );
   		  assertTrue(response.equalsIgnoreCase("1"));
   		 break;
   		 
   		 
    case "FieldMaster/GetFieldMaster" :
    	 
    	   		
   		 APIBody = "{\r\n" + 
   		 		"  \"intClaimType\": 1,\r\n" + 
   		 		"  \"vcModule\": \"apply\",\r\n" + 
   		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
   		 		"}";
   		  response= postapidata.httpPost(postbaseurl+"api/FieldMaster/GetFieldMaster" , APIBody );
   		  assertTrue(response.equalsIgnoreCase("1"));
   		 break;
   		 
     case "DeviceInfo" :
	 
		
		 APIBody = "{\r\n" + 
		 		"  \"EMPID\": "+empdata+",\r\n" + 
		 		"  \"DIdentifier\": \"sample string 1\",\r\n" + 
		 		"  \"TokenKey\": \"sample string 2\",\r\n" + 
		 		"  \"DType\": \"sample string 3\",\r\n" + 
		 		"  \"DOS\": \"sample string 4\",\r\n" + 
		 		"  \"DVersion\": \"sample string 5\",\r\n" + 
		 		"  \"Dlatitude\": \"sample string 6\",\r\n" + 
		 		"  \"Dlongitude\": \"sample string 7\",\r\n" + 
		 		"  \"LoginDate\": \"2019-11-21T14:38:37.5264128+05:30\",\r\n" + 
		 		"  \"Status\": 1,\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  response= postapidata.httpPost(postbaseurl+"api/DeviceInfo" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
     case "TotalCount/GetCount" :
    	 
 		
		 APIBody = "{\r\n" + 
		 		"  \"Domain\": '"+domaintext+"'\r\n" + 
		 		"}";
		  response= postapidata.httpPost(postbaseurl+"api/TotalCount/GetCount" , APIBody );
		  assertTrue(response.equalsIgnoreCase("1"));
		 break;
		 
		 
		 
		 
		 
		 
			 //Send email
		case "SendEmail/SendMail" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"Emailid\": '"+emailid+"',\r\n" + 
			 		"  \"PWD\": '"+passwordtext+"',\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/SendEmail/SendMail" , APIBody);
				  System.out.println("Response is->>>"+response);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "SendEmail" :
			
			
			 APIBody = "";
				  response= postapidata.httpPost(postbaseurl+"api/SendEmail" , APIBody);
				  System.out.println("Response is->>>"+response);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 //profile details
			 
		case "ProfileDetails/GetEmployeeProfileDetails" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				  response= postapidata.httpPost(postbaseurl+"api/ProfileDetails/GetEmployeeProfileDetails" , APIBody);
				  System.out.println("Response is->>>"+response);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
		case "ProfileDetails/UpdateEmployeeProfile" :
			
			
			 APIBody = "{\r\n" + 
			 		"  \"EmpID\": "+empdata+",\r\n" + 
			 		"  \"EmpFName\": \"paresh test\",\r\n" + 
			 		"  \"EmpMName\": \"M\",\r\n" + 
			 		"  \"EmpLName\": \"Patil\",\r\n" + 
			 		"  \"BankName\": \"test bank\",\r\n" + 
			 		"  \"AccountNo\": \"0\",\r\n" + 
			 		"  \"Email\": '"+emailid+"',\r\n" + 
			 		"  \"dtJoining\": \"2019-09-20\",\r\n" + 
			 		"  \"Mobile\": \"9987135525\",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}\r\n" + 
			 		"";
				  response= postapidata.httpPost(postbaseurl+"api/ProfileDetails/UpdateEmployeeProfile" , APIBody);
				  System.out.println("Response is->>>"+response);
				  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 
			 
		
			 
		}
	}
	

}
