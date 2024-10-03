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

public class HCPPostAPI extends Urls{
	
	
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
	String Stateid="";
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
		  array=  postapidata.getdata(BaseUrl+"api/Login/GetLogin" , APIBody );
		  System.out.println(array);
		
		empdata= array.get(0);
		bandid=array.get(1);
		territoryid=array.get(2);
		 System.out.println("here"+functiontext);
		switch(functiontext){
	
			 
		case "HCP/GetSpecialityByQualificationList" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetSpecialityByQualificationList" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
			  
		case "HCP/GetSpecialityByPracticeList" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetSpecialityByPracticeList" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
		case "HCP/GetQualificationList" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetQualificationList" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
		case "HCP/GetClassificationList" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetClassificationList" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
		case "HCP/GetLocationType" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetLocationType" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
		case "HCP/GetHospitalType" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetHospitalType" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
		case "HCP/GetHospitalAttachedTo" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetHospitalAttachedTo" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
		case "HCP/GetStateList" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetStateList" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
			  
		case "HCP/GetHCPLadder" :
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetHCPLadder" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
		case "HCP/GetCityList" :
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				  array= postapidata.getarraydata(BaseUrl+"api/Master/GetStateList" , APIBody );
				  System.out.println(array);
			Stateid = array.get(2);
			
			 APIBody = "{\r\n" + 
			 		"  \"State\": "+Stateid+",\r\n" + 
			 		"  \"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetCityList" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
			  
		case "HCP/GetDomesticWorkShopList" :
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetDomesticWorkShopList" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
		case "HCP/GetInternationalWorkShopList" :
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetInternationalWorkShopList" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
		case "HCP/GetPriorityBandList" :
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetPriorityBandList" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			  
		case "HCP/GetCMESpeakerTypes" :
			
			
			 APIBody = "{\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'\r\n" + 
				 		"}";
				 
			  response= postapidata.httpPost(BaseUrl+"api/HCP/GetCMESpeakerTypes" , APIBody);
			 assertTrue(response.equalsIgnoreCase("1"));
			  break;
			 
		}
	}

}
