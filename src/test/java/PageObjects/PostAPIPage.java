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
import TestData.GetApiData;

public class PostAPIPage extends Urls {
	
WebDriver driver;
	
	String Logincode="";
	String empdata="";
	String 	ClaimId="";
	String bandid="";
	String travelexpenseid="";
	String travelinsertresponse="";
	String managerdata="";
	String APIBody="";
	String advanceid="";
	
	Calendar current = Calendar.getInstance();
	int k=0;
	
	
	public void apicalls(String functiontext,String username,String password,String managerusername,String managerpassword,String policytyp,String domaintext) throws JSONException, InterruptedException
	{
		
		//switch
		GetApiData gdata1 = new  GetApiData();
		captureData gdata = new  captureData();
		captureData citydata = new  captureData();
		
		 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
		 ArrayList<String> array1 = gdata.parseFromJSONResponse(userresponse);
		 
		 System.out.println(array1);
		 int i=0;
		 String userData=array1.get(i);
		 String passData=array1.get(i+1);
		String empdata=array1.get(i+2);
		String  bandid=array1.get(i+3);
		String  emailid=array1.get(i+4);		 
		 String message=array1.get(i+5);
		 String territiryId=array1.get(i+13);
		 String zoneId=array1.get(i+18);
		   String teamId=array1.get(i+19);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
			
		
			String foodid="";
			ArrayList<String> array ;
			 i=0;
		
		switch (functiontext)
		{
		
		case "AdvanceSettlements/Post" :
			 userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+username+"&PWD="+password+"&Domain="+domaintext+"");
			  array1 = gdata.parseFromJSONResponse(userresponse);
			 
			 System.out.println(array1);
			  i=0;
			  userData=array1.get(i);
			  passData=array1.get(i+1);
			 empdata=array1.get(i+2);
			  bandid=array1.get(i+3);

					
					String  cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?Domain="+domaintext+"");
					
				
				ArrayList<String>	 cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
					 int cityno=0;
					
					String  citynamefromdata=cityarray1.get(cityno+1);
					String  citynametodata=cityarray1.get(cityno+2);
					ArrayList<String>	  wbsarray = new ArrayList<String>();
					
					
					
					String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS"+"&domain="+domaintext);
					 wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
					System.out.println(wbsarray+"array");
				int	 wbscount=0;
				String	 wbsdata=wbsarray.get(wbscount+1);
					
					
		  	String  travelmodecaode= gdata1.getContenxtWeb(BaseUrl+"api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?"
				 		+ "ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");
				 assertTrue(travelmodecaode.equalsIgnoreCase("200")||travelmodecaode.equalsIgnoreCase("201"));
				 
				String	 travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&Domain="+domaintext+"");

				ArrayList<String>	  travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
					int travelmodecount=0;
					String travelmodedata=travelmodearray.get(travelmodecount+1);
		  	  dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				 localDate = LocalDate.now();
				
					  travelinsertresponse = gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetInsertUpdateTravelClaim?TravelDateFrom="+dtf.format(localDate)+"%2000:00:00.000&"
					 		+ "amount=2000&TravelDateTo="+dtf.format(localDate)+"%2000:00:00.000&CityFrom="+citynamefromdata+"&CityTo="+citynametodata+""
					 				+ "&Remarks=na&ModeOfTravel="+travelmodedata+"&WBS="+wbsdata+"&EmpID="+empdata+"&week=19/08/2018~25/08/2018&Exceed_Amt=0.00"
					 						+ "&TaxAmt=0&GSTIncluded=True&InvoiceNo=123&GSTN=123&CGSTAmt=100.00&SGSTAmt=100.00&IGSTAmt=100.00&intTypeOfVisit=1756&OtherFromCity=&OtherToCity=&Domain="+domaintext+"");
					
				
					  array = gdata.parseFromJSONResponse(travelinsertresponse);
					 int j=0;
					 System.out.println(array);
					  ClaimId=array.get(j+7);
					  travelexpenseid=array.get(j+8);
					  
				String	  AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
						 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
						 System.out.println(array);
						String  advancetype= array.get(1);
					String  InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
								+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
						 
						 array = gdata.parseFromJSONResponse(InsertAdvance);
						 System.out.println(array);
						   advanceid= array.get(23);
						    APIBody = "{\"AdvanceID\": "+advanceid+", \"ClaimID\":"+ClaimId+" , \"Other\": \"1\" ,\"Domain\" : '"+domaintext+"'}";
			gdata.httpPost(BaseUrl+"/api/AdvanceSettlements/Post?domain="+domaintext+"" , ClaimId , advanceid , APIBody );
			break;
			
			
		case "AdvanceDocument/Post" :
			 
					  
					  AdvanceRequest= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/Get?Domain="+domaintext+"");
						 array = gdata.parseFromJSONarrayResponse(AdvanceRequest);
						 System.out.println(array);
						  advancetype= array.get(1);
					  InsertAdvance= gdata.getContenxtWeb(BaseUrl+"/api/AdvanceRequest/InsertAdvance?fromDate="+dtf.format(localDate)+"&toDate="+dtf.format(localDate)+""
								+ "&Location=&LeaveType="+advancetype+"&Reason=test&NoOfLeaves=50.00&EmpID="+empdata+"&Domain="+domaintext+"");
						 
						 array = gdata.parseFromJSONResponse(InsertAdvance);
						 System.out.println(array);
						   advanceid= array.get(23);
						  String advancemasterid= array.get(24); 
						   System.out.println(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
						 
						   String pathname=System.getProperty("user.dir");
						    APIBody = "{\"FileName\": \"Chrysanthemum.jpg\", \"FileExt\":\".jpg\" , \"Path\": '"+pathname+"' ,\"intLeaveMasterID\" : "+advancemasterid+",\"Domain\" : '"+domaintext+"'}}";
			gdata.httpPost(BaseUrl+"/api/AdvanceDocument/Post?Domain="+domaintext+"" , ClaimId , advanceid , APIBody );
			break;
			
			
			case "LeavePolicy/Post" :
				 
				  
				advanceid="";
				
				 String leavetyperesponse= gdata.getContenxtWeb(BaseUrl+"/api/ApplyLeave/Get?Domain="+domaintext+"");
				  array = gdata.parseFromJSONarrayResponse(leavetyperesponse);
				 System.out.println("array is"+array);
				 
				 for(i=1;i<array.size();i++)
					 
				 {
					String leavetypeid= array.get(i) ;
					
					APIBody = "{\"LeaveTypeID\" : "+leavetypeid+" ,\"limit\": "+10+" ,\"Accumulation\": \"10\" ,\"Encashment\" : \"10\" ,\"band\" : "+bandid+" ,"
							+ "\"Year\" : "+current.get(Calendar.YEAR)+" , \"CreatedBy\" : \"1\" ,\"CreatedDate\": '"+dtf.format(localDate)+"' ,\"Domain\": '"+domaintext+"'}";
					gdata.httpPost(BaseUrl+"api/LeavePolicy/Post?Domain="+domaintext+"" , ClaimId , advanceid , APIBody ); 
					 
				 }
					    
		break;



			case "State/GetStateList" :   //Get states
				 
				 String GetStateList= gdata1.getContenxtWeb(BaseUrl+"/api/State/GetStateList?Domain="+domaintext+"");
					 assertTrue(GetStateList.equalsIgnoreCase("200")||GetStateList.equalsIgnoreCase("201"));
				 
				 break;
				 
				 
			case "Holiday/Post" :   //post holidays
				 
				 System.out.println(BaseUrl+"/api/State/GetStateList?Domain="+domaintext+"");
				  GetStateList= gdata.getContenxtWeb(BaseUrl+"/api/State/GetStateList?Domain="+domaintext+"");
				  ArrayList<String >  statearray = gdata.parseFromJSONarrayResponse(GetStateList);
				  String stateid= statearray.get(1);
				 
           APIBody = "{\"HolidayName\": \"Public holiday\", \"HolidayDetails\":\"test\" , \"HolidayFromDate\": '"+dtf.format(localDate)+"' "
           		+ ",\"CreatedBy\" : \"1\",\"Year\" : '"+current.get(Calendar.YEAR)+"' ,\"state\" : "+stateid+" ,\"Domain\" : '"+domaintext+"'   }}";
					gdata.httpPost(BaseUrl+"api/Holiday/Post?Domain="+domaintext+"" , ClaimId , advanceid , APIBody );
				 
				 break;
			case "LeaveDocument/Post" :   //leave document
				 
				 String LeaveDocument= gdata1.getContenxtWeb(BaseUrl+"/api/LeaveDocument/Post?Domain="+domaintext+"");
					 assertTrue(LeaveDocument.equalsIgnoreCase("200")||LeaveDocument.equalsIgnoreCase("201"));
				 
				 break;
				 
			case "Dashboard/GetDashboardClaimTotalExceedAmt" :   
				 
				 String GetDashboardClaimTotalExceedAmt= gdata1.getContenxtWeb(BaseUrl+"/api/Dashboard/GetDashboardClaimTotalExceedAmt?EmpID="+empdata+""
				 		+ "&Month="+current.get(Calendar.MONTH)+"&Year="+current.get(Calendar.YEAR)+"&Week=0&Operation=TravelClaim&exceed=&Domain="+domaintext+"");
					 assertTrue(GetDashboardClaimTotalExceedAmt.equalsIgnoreCase("200")||GetDashboardClaimTotalExceedAmt.equalsIgnoreCase("201"));
				 
				 break;
				 
			
			 
		}
	}
	
	

}
