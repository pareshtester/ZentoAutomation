package Data;

import static io.restassured.RestAssured.given;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class capturePostAPIData {
	 ArrayList<String> dataarray= new ArrayList<String>();
	String responseMessage= "";
	String empid="";
	String bandid="";
	String territoryid="";
	String cityid="";
	String travelmodeid="";
	String wbsid="";
	String typeofvisitid="";
	String claimid="";
	String localexpenseid="";
	String hotelexpenseid="";
	String mobileclaimid="";
    String noeid="";
    String otherexpenseid="";
    String travelexpenseid="";
    String shiftid="";
    String foodid="";
    String foodtypeid="";
    String advancetypeid="";
    String advanceclaimid="";
    String advanceexpenseid="";
    String stateid="";
    String emailid="";
    String password="";
    String foodtype="";
    String claimtypeid="";
    String dailyexpensetravelmodeid="";
    String hqtype="";
    String place="";
    String teamid="";
    String notificationid="";
    String supporttravelid="";
    String result="";
    String usernamemail="";
    String companynametext="";
    String poid="";
    String responseflag="";
    String termid="";
    String termtext="";
	String vendorid="";
	String contactpersonemail="";
public String httpPost(String url, String APIBody) throws JSONException,InterruptedException {
		
		 System.out.println(APIBody);		
		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
			
		//Setting API's body
		builder.setBody(APIBody);
			
		//Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");
			
		RequestSpecification requestSpec = builder.build();

		//Making post request with authentication, leave blank in case there are no credentials- basic("","")
		Response response = given().authentication().preemptive().basic("", "")
					.spec(requestSpec).when().post(url);
		System.out.println("Response string"+response.body().asString());
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());

		
		//responseMessage=JSONResponseBody.get("ResponseMessage").toString();
		responseMessage=JSONResponseBody.get("ResponseFlag").toString();
			 if(JSONResponseBody.has("advanceID"))
             {
				String result=(JSONResponseBody.get("advanceID").toString());
            	   System.out.println("======>"+result);
            	 //loginArray.add(result);
             }
		
           return responseMessage;
		  }

public ArrayList<String> getdata(String url, String APIBody)
      {
	// Building request using requestSpecBuilder
	RequestSpecBuilder builder = new RequestSpecBuilder();
		
	//Setting API's body
	builder.setBody(APIBody);
		
	//Setting content type as application/json or application/xml
	builder.setContentType("application/json; charset=UTF-8");
		
	RequestSpecification requestSpec = builder.build();

	//Making post request with authentication, leave blank in case there are no credentials- basic("","")
	Response response = given().authentication().preemptive().basic("", "")
				.spec(requestSpec).when().post(url);
	System.out.println("Response string"+response.body().asString());
	JSONObject jsonObject = new JSONObject(response.body().asString());
	JSONObject jsonObject1 = jsonObject.getJSONObject("Data");
	System.out.println(jsonObject1);
	 if(jsonObject1.has("intEmpId"))
     {
    	 empid=Integer.toString(jsonObject1.getInt("intEmpId")) ;
    	  dataarray.add(empid);
     }
	 
	 if(jsonObject1.has("intLevelId"))
     {
    	 bandid=Integer.toString(jsonObject1.getInt("intLevelId")) ;
    	  dataarray.add(bandid);
     }
     if(jsonObject1.has("intTerritory"))
     {
    	 territoryid=Integer.toString(jsonObject1.getInt("intTerritory")) ;
    	  dataarray.add(territoryid);
     }

     
     if(jsonObject1.has("intappid"))
     {
			travelmodeid=jsonObject1.get("intappid").toString() ;
   	 
     }
     if(jsonObject1.has("intClaimID"))
     {
			claimid=jsonObject1.get("intClaimID").toString() ;
			   System.out.println("hotel claim id is"+claimid);
           dataarray.add(claimid);
     }
     if(jsonObject1.has("intAccomodationClaimId"))
     {
    	 hotelexpenseid=jsonObject1.get("intAccomodationClaimId").toString() ;
			 dataarray.add(hotelexpenseid);
   System.out.println("hotel expense id is"+hotelexpenseid);
     }
     if(jsonObject1.has("intMobileClaimId"))
     {
    	 mobileclaimid=jsonObject1.get("intMobileClaimId").toString() ;
			 dataarray.add(mobileclaimid);

     }
     
     if(jsonObject1.has("intOtherExpenseClaimId"))
     {
    	 otherexpenseid=jsonObject1.get("intOtherExpenseClaimId").toString() ;
			 dataarray.add(otherexpenseid);

     }
     
     if(jsonObject1.has("intTravelClaimId"))
     {
    	 travelexpenseid=jsonObject1.get("intTravelClaimId").toString() ;
			 dataarray.add(travelexpenseid);

     }
     
     if(jsonObject1.has("intFoodClaimId"))
     {
    	 foodtypeid=jsonObject1.get("intFoodClaimId").toString() ;
			 dataarray.add(foodtypeid);

     }
     
     if(jsonObject1.has("intLeaveDetailsId"))
     {
    	 advanceclaimid=jsonObject1.get("intLeaveDetailsId").toString() ;
			 dataarray.add(advanceclaimid);

     }
     
     
     if(jsonObject1.has("intLeaveMasterID"))
     {
    	 advanceexpenseid=jsonObject1.get("intLeaveMasterID").toString() ;
			 dataarray.add(advanceexpenseid);

     }
     
     if(jsonObject1.has("intLocalConvenceClaimId"))
     {
			localexpenseid=jsonObject1.get("intLocalConvenceClaimId").toString() ;
			dataarray.add(localexpenseid); 
     }
     
     if(jsonObject1.has("vcEmail"))
     {
			emailid=jsonObject1.getString("vcEmail") ;
			dataarray.add(emailid); 
     }
     
     if(jsonObject1.has("vcPassword"))
     {
			password=jsonObject1.getString("vcPassword") ;
			dataarray.add(password); 
     }
     
     if(jsonObject1.has("intTeamId"))
     {
			teamid=jsonObject1.get("intTeamId").toString() ;
			dataarray.add(teamid); 
     }
     if(jsonObject1.has("ResponseFlag"))
     {
			responseflag=jsonObject1.get("ResponseFlag").toString() ;
			dataarray.add(responseflag); 
     }
     if(jsonObject1.has("Department"))
     {
			responseflag=jsonObject1.get("Department").toString() ;
			dataarray.add(responseflag); 
     }
     
    
	System.out.println("data array is"+dataarray);
	
   return dataarray;
}
    
    
    public ArrayList<String> getarraydata(String url, String APIBody)
    {
	// Building request using requestSpecBuilder
	RequestSpecBuilder builder = new RequestSpecBuilder();
		
	//Setting API's body
	builder.setBody(APIBody);
		
	//Setting content type as application/json or application/xml
	builder.setContentType("application/json; charset=UTF-8");
		
	RequestSpecification requestSpec = builder.build();

	//Making post request with authentication, leave blank in case there are no credentials- basic("","")
	Response response = given().authentication().preemptive().basic("", "")
				.spec(requestSpec).when().post(url);
	System.out.println("Response string"+response.body().asString());
	JSONObject jsonObject = new JSONObject(response.body().asString());
	System.out.println(jsonObject);
	//JSONObject jsonObject1 = jsonObject.getJSONObject("Data");
	JSONArray jsonArray = new JSONArray();
	jsonArray=jsonObject.getJSONArray("Data");
	System.out.println(jsonArray);
	 ArrayList<String> loginArray= new ArrayList<String>();
	 for (int i = 0; i < jsonArray.length(); i++) {
		 jsonObject = jsonArray.getJSONObject(i); 
	try {
		if(jsonObject.has("intCityId"))
        {
			cityid=jsonObject.get("intCityId").toString() ;
      	  loginArray.add(cityid);
        }
		if(jsonObject.has("intappid"))
        {
			travelmodeid=jsonObject.get("intappid").toString() ;
      	  loginArray.add(travelmodeid);
        }
		if(jsonObject.has("intAppId"))
        {
			typeofvisitid=jsonObject.get("intAppId").toString() ;
      	  loginArray.add(typeofvisitid);
        }
		if(jsonObject.has("WBS_ID"))
        {
			wbsid=jsonObject.get("WBS_ID").toString() ;
      	  loginArray.add(wbsid);
        }
		if(jsonObject.has("intClaimID"))
        {
			claimid=jsonObject.get("intClaimID").toString() ;
      	  loginArray.add(claimid);
        }
		if(jsonObject.has("intLocalConvenceClaimId"))
        {
			localexpenseid=jsonObject.get("intLocalConvenceClaimId").toString() ;
      	  loginArray.add(localexpenseid); 
        }
		
		if(jsonObject.has("NOE_ID"))
        {
			noeid=jsonObject.get("NOE_ID").toString() ;
      	  loginArray.add(noeid); 
        }
		
		if(jsonObject.has("intMobileClaimId"))
        {
			claimid=jsonObject.get("intMobileClaimId").toString() ;
      	  loginArray.add(claimid); 
        }
		
		if(jsonObject.has("intshiftid"))
        {
			shiftid=jsonObject.get("intshiftid").toString() ;
      	  loginArray.add(shiftid); 
        }
		if(jsonObject.has("Result"))
        {
			result=jsonObject.get("Result").toString();
      	  loginArray.add(result); 
        }
		
		if(jsonObject.has("intFoodTypeId"))
        {
			foodid=jsonObject.get("intFoodTypeId").toString();
      	  loginArray.add(foodid); 
        }
		
		if(jsonObject.has("LeaveTypeID"))
        {
			advancetypeid=jsonObject.get("LeaveTypeID").toString();
      	  loginArray.add(advancetypeid); 
        }
		
		if(jsonObject.has("intStateId"))
        {
			stateid=jsonObject.get("intStateId").toString() ;
      	  loginArray.add(stateid);
        }
		
		if(jsonObject.has("vcAppName"))
        {
			foodtype=jsonObject.get("vcAppName").toString() ;
      	  loginArray.add(foodtype);
        }
		
		if(jsonObject.has("intClaimTypeID"))
		{
			claimtypeid=jsonObject.get("intClaimTypeID").toString();
			loginArray.add(claimtypeid);
		}
		
		if(jsonObject.has("intTravelMode"))
		{
			dailyexpensetravelmodeid=jsonObject.get("intTravelMode").toString();
			loginArray.add(dailyexpensetravelmodeid);
		}
		
		if(jsonObject.has("intCoverageType"))
		{
			hqtype=jsonObject.get("intCoverageType").toString();
			loginArray.add(hqtype);
		}
		
		if(jsonObject.has("Place"))
		{
			place=jsonObject.get("Place").toString();
			loginArray.add(place);
		}
		
		 if(jsonObject.has("intNotificationID"))
	     {
				notificationid=jsonObject.get("intNotificationID").toString() ;
				loginArray.add(notificationid); 
	     }
		 
		 if(jsonObject.has("TravelClaimId"))
	     {
				supporttravelid=jsonObject.get("TravelClaimId").toString() ;
				loginArray.add(supporttravelid); 
	     }
		 
		 if(jsonObject.has("Username"))
	        {
				usernamemail=jsonObject.get("Username").toString() ;
	      	  loginArray.add(usernamemail);
	        }
		 
		 if(jsonObject.has("RES"))
	        {
				poid=jsonObject.get("RES").toString() ;
	      	  loginArray.add(poid);
	        }
		 
		 if(jsonObject.has("ResponseFlag"))
	        {
			 responseflag=jsonObject.get("ResponseFlag").toString() ;
	      	  loginArray.add(responseflag);
	        }
		 
		 if(jsonObject.has("intTerm_ID"))
	        {
			 termid=jsonObject.get("intTerm_ID").toString() ;
	      	  loginArray.add(termid);
	        }
		 if(jsonObject.has("vcTerm_Type"))
	        {
			 termtext=jsonObject.get("vcTerm_Type").toString() ;
	      	  loginArray.add(termtext);
	        }
		 if(jsonObject.has("ContactPersonEmail"))
		 {
		 contactpersonemail=jsonObject.get("ContactPersonEmail").toString() ;
		 loginArray.add(contactpersonemail);
		 }
		 if(jsonObject.has("intVendorID"))
		 {
		 vendorid=jsonObject.get("intVendorID").toString() ;
		 loginArray.add(vendorid);
		 }
		 if(jsonObject.has("HcpStateId"))
		 {
		 stateid=jsonObject.get("HcpStateId").toString() ;
		 loginArray.add(stateid);
		 }
		 
		 if(jsonObject.has("HcpCityId"))
		 {
		 cityid=jsonObject.get("HcpCityId").toString() ;
		 loginArray.add(cityid);
		 }
		 

		 
	}catch (JSONException e) {
        e.printStackTrace();
    }
	 }
	 System.out.println("array is"+loginArray);
	 return loginArray;
    }
    
    public ArrayList<String> Postarray(String url, String APIBody) throws JSONException,InterruptedException {
		
		 System.out.println(APIBody);		
		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
			
		//Setting API's body
		builder.setBody(APIBody);
			
		//Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");
			
		RequestSpecification requestSpec = builder.build();

		//Making post request with authentication, leave blank in case there are no credentials- basic("","")
		Response response = given().authentication().preemptive().basic("", "")
					.spec(requestSpec).when().post(url);
		System.out.println("Response string"+response.body().asString());
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		 ArrayList<String> loginArray= new ArrayList<String>();
		
		//responseMessage=JSONResponseBody.get("ResponseMessage").toString();
		//responseMessage=JSONResponseBody.get("ResponseFlag").toString();
			 if(JSONResponseBody.has("advanceID"))
            {
				String result=(JSONResponseBody.get("advanceID").toString());
           	   System.out.println("======>"+result);
           	 loginArray.add(result);
            }
		
			 if(JSONResponseBody.has("ResponseFlag"))
	            {
					String result=(JSONResponseBody.get("ResponseFlag").toString());
	           	   System.out.println("======>"+result);
	           	 loginArray.add(result);
	            }
			 
			 if(JSONResponseBody.has("Data"))
	            {
					String result=(JSONResponseBody.get("Data").toString());
	           	   System.out.println("======>"+result);
	           	 loginArray.add(result);
	            }
          return loginArray;
		  }
    
    public String getonlydata(String url, String APIBody)
    {
    	// Building request using requestSpecBuilder
    	RequestSpecBuilder builder = new RequestSpecBuilder();
    		
    	//Setting API's body
    	builder.setBody(APIBody);
    		
    	//Setting content type as application/json or application/xml
    	builder.setContentType("application/json; charset=UTF-8");
    		
    	RequestSpecification requestSpec = builder.build();

    	//Making post request with authentication, leave blank in case there are no credentials- basic("","")
    	Response response = given().authentication().preemptive().basic("", "")
    				.spec(requestSpec).when().post(url);
    	System.out.println("Response string"+response.body().asString());
    	JSONObject jsonObject = new JSONObject(response.body().asString());
//    	JSONObject jsonObject1 = jsonObject.getJSONObject("Data");
    	if(jsonObject.has("Data"))
        {
			claimid=jsonObject.get("Data").toString() ;
			 
        }
    	
    	
    	
    	return claimid;
    }
}
