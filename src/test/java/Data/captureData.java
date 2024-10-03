package Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import com.google.gson.JsonArray;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class captureData {
	public  String getContenxtWeb(String urlS) {
	    String pagina = "", devuelve = "";   String code="";
	    URL url;
	    try {
	        url = new URL(urlS);
	        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
	        conexion.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
	        System.out.println(conexion.getResponseCode());
	        
	        code=Integer.toString(conexion.getResponseCode());
	        System.out.println("Response of api is"+code);
	        if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK || conexion.getResponseCode() == HttpURLConnection.HTTP_CREATED ) {
	            BufferedReader reader = new BufferedReader(
	                    new InputStreamReader(conexion.getInputStream()));
	            String linea = reader.readLine();
	          //  System.out.println("this is linea"+linea);
	            while (linea != null) {
	                pagina += linea;
	                linea = reader.readLine();
	            }
	            reader.close();

	            devuelve = pagina;
	        } else {
	        	 conexion.disconnect();
	            return null;
	        }
	        conexion.disconnect();
//	        System.out.println("Response:"+devuelve);
	        return devuelve;
	       
	    } catch (Exception ex) {
	        return devuelve;
	    }
	}
	
	public  ArrayList<String> parseFromJSONResponse(String respo) 
    {
		//JSONParser parse = new JSONParser(); 
		//JSONObject[][] loginArray = new JSONObject[][];
		
        JSONObject myjson = null;
        String jsonObj1="";
        String jsonObj2="";
        String jsonObj3="";
        String jsonObjHQType="";
        String  jsonObjclaimId="";
        String  jsonObjempId="";
       String jsonObjbandId="";
       String jsonObjemailId="";
       String jsonObjtravelclaimId="";
       String jsonObjlandlineId="";
       String jsonObjHotelexpenseId="";
       String jsonObjOtherexpenseId="";
       String jsonObjfoodexpenseId="";
       String jsonObjterritoryId="";
       String jsonObjtownIdId="";
       String jsonObjhqtypeId="";
       String jsonObjallowanceId="";

       String jsonObjallowanceexpenseId="";
       String jsonObjzoneId="";
       String jsonObjteamId="";
       String jsonObjtmetroallowanceId="";
       String jasonObjactivityId="";
       String jasonObjactualid="";

       String jasonleaveid="";
       String leaveitemid="";
       String foodtypepolicyid="";
       String APIBody="";       
       
        ArrayList<String> loginArray= new ArrayList<String>();
        try 
        {
        	
            myjson = new JSONObject(respo);
            
            if(myjson.has("vcUserName"))
            {
            jsonObj1 = myjson.getString("vcUserName");
          
            }
            loginArray.add(jsonObj1);
             if(myjson.has("vcPassword"))     
             {
            jsonObj2 = myjson.getString("vcPassword");
            
            
             }
             
             loginArray.add(jsonObj2);
             if(myjson.has("intEmpId"))
             {
            	 jsonObjemailId=Integer.toString(myjson.getInt("intEmpId")) ;
             }
             loginArray.add(jsonObjemailId);
             if(myjson.has("intLevelId"))
             {
            	 jsonObjbandId=Integer.toString(myjson.getInt("intLevelId")) ;
             }
             loginArray.add(jsonObjbandId);
             
             if(myjson.has("vcEmail"))
             {
            	 jsonObjemailId = myjson.getString("vcEmail");
           
             }
             loginArray.add(jsonObjemailId);
             if(myjson.has("message"))
             {
            	jsonObj3=myjson.getString("message") ;
            	
             }
             loginArray.add(jsonObj3);
             if(myjson.has("vcAppValue"))
             {
            	 jsonObjHQType=myjson.getString("vcAppValue") ;
             }
             loginArray.add(jsonObjHQType);
             if(myjson.has("intClaimID"))
             {
            	 //jsonObjclaimId=Integer.toString(myjson.getInt("intClaimID")) ;
            	 jsonObjclaimId=myjson.get("intClaimID").toString();
             }
             loginArray.add(jsonObjclaimId);
             if(myjson.has("intTravelClaimId"))
             {
            	 jsonObjtravelclaimId=Integer.toString(myjson.getInt("intTravelClaimId")) ;
             }
             loginArray.add(jsonObjtravelclaimId);
             if(myjson.has("intMobileClaimId"))
             {
            	 jsonObjlandlineId=Integer.toString(myjson.getInt("intMobileClaimId")) ;
             }
             loginArray.add(jsonObjlandlineId);
             if(myjson.has("intAccomodationClaimId"))
             {
            	 jsonObjHotelexpenseId=Integer.toString(myjson.getInt("intAccomodationClaimId")) ;
             }
             loginArray.add(jsonObjHotelexpenseId);
             if(myjson.has("intOtherExpenseClaimId"))
             {
            	 jsonObjOtherexpenseId=Integer.toString(myjson.getInt("intOtherExpenseClaimId")) ;
             }
             loginArray.add(jsonObjOtherexpenseId);
             if(myjson.has("intFoodClaimId"))
             {
            	 jsonObjfoodexpenseId=Integer.toString(myjson.getInt("intFoodClaimId")) ;
             }
             loginArray.add(jsonObjfoodexpenseId);
             if(myjson.has("intTerritory"))
             {
            	 jsonObjterritoryId= (myjson.get("intTerritory")).toString() ;
             }
             loginArray.add(jsonObjterritoryId);
             if(myjson.has("place"))
             {
            	 jsonObjtownIdId=Integer.toString(myjson.getInt("place")) ;
             }
             loginArray.add(jsonObjtownIdId);
             if(myjson.has("intHQ"))
             {
            	 jsonObjhqtypeId=Integer.toString(myjson.getInt("intHQ")) ;
             }
             loginArray.add(jsonObjhqtypeId);
             
             if(myjson.has("intClaimId"))
             {
            	 jsonObjallowanceId=Integer.toString(myjson.getInt("intClaimId")) ;
             }
             loginArray.add(jsonObjallowanceId);
             
             if(myjson.has("intAllowanceId"))
             {
            	 jsonObjallowanceexpenseId=Integer.toString(myjson.getInt("intAllowanceId")) ;
             }
             loginArray.add(jsonObjallowanceexpenseId);
             if(myjson.has("intRegionId"))
            	 
             {
            	 
            	jsonObjzoneId= myjson.get("intRegionId").toString();
            	 
//           	 String n = "";
//           	 n=myjson.getString("intRegionId");
            	//sonObjzoneId=Integer.toString(myjson.getInt("intRegionId")) ;
            	 
             }
             loginArray.add(jsonObjzoneId);
             if(myjson.has("intTeamId"))
             {
            	 jsonObjteamId=myjson.get("intTeamId").toString();
             }
             loginArray.add(jsonObjteamId);
             if(myjson.has("intMetroAllowanceId"))
             {
            	 jsonObjtmetroallowanceId=Integer.toString(myjson.getInt("intMetroAllowanceId")) ;
             }
             loginArray.add(jsonObjtmetroallowanceId);
             
             if(myjson.has("intActivityID"))
             {
            	 jasonObjactivityId=Integer.toString(myjson.getInt("intActivityID")) ;
             }
             loginArray.add(jasonObjactivityId);
             
             if(myjson.has("intActualActivityID"))
             {
            	 jasonObjactualid=Integer.toString(myjson.getInt("intActualActivityID")) ;
             }
             loginArray.add(jasonObjactualid);
             if(myjson.has("intLeaveMasterID"))
             {
            	 jasonleaveid=myjson.get("intLeaveMasterID").toString() ;
             }
             loginArray.add(jasonleaveid);
             if(myjson.has("intLeaveDetailsId"))
             {
            	 leaveitemid=Integer.toString(myjson.getInt("intLeaveDetailsId")) ;
             }
             loginArray.add(leaveitemid);
         //   loginArray=myjson.getJSONArray("");
          //  JSONArray jsonObj2 = jsonObj1.getJSONArray("e");
         //   JSONObject jsonObj3 = jsonObj2.getJSONObject(0);
          //  System.out.println(jsonObj1.getJSONObject("content"));
          //  System.out.println("here ===>>>"+jsonObj1.getJSONObject("content").get("$t").toString());
//            System.out.println("======>"+jsonObjclaimId);
           
        } 
        catch (JSONException e) {
            e.printStackTrace();
        }
        return loginArray;
    }  
	
	public ArrayList<String> parseFromJSONarrayResponse(String respo) 

	
	
	{
		JSONObject jsonObject=null;
		 String jsonObjCityfrom="";
		 String jsonObjCityto="";
		 String jsonObjtravelmode="";
		 String jsonObjwbs="";
		String claimid="";
		String fromDate="";
		String foodType="";
		String foodTypeStatus="";
		String expenseid="";
		String noe="";
		String landlineexpenseid="";
		String townIdId="";
		String danonetravelmodeId="";
		String claimtypeid="";
	       String hqtypeId="";
	       String currentweektext="";
	       String activitytype="";
	       String jsonObjleaveid="";
	       String foodtypepolicyid="";
	       String shiftid="";
	       String shiftname="";
	       String artistfoodtypeid="";
	       String artistfoodtypename="";
	       String artistclaimid="";
	       String claimidresult="";
	       String artisttravelexpenseid="";
	       String coverageType="";
	       String jasonstateid="";
	       String jasobandvalue="";
	       String allowanceamount="";
		ArrayList<String> noearray = new ArrayList<String>();
		JSONArray jsonArray = new JSONArray(respo);
		System.out.println("Array ln->>>>>>>>>>"+jsonArray.length());
		 ArrayList<String> loginArray= new ArrayList<String>();
		for (int i = 0; i < jsonArray.length(); i++) {
			 jsonObject = jsonArray.getJSONObject(i); 
			 
			 try 
		        {
		        	
		          
		             if(jsonObject.has("intClaimID"))
		             {
		            	 claimid=Integer.toString(jsonObject.getInt("intClaimID")) ;
		            	  loginArray.add(claimid);
		             }
		           

		             if(jsonObject.has("intLocalConvenceClaimId"))
		             {
		            	 expenseid=Integer.toString(jsonObject.getInt("intLocalConvenceClaimId")) ;
		            	  loginArray.add(expenseid);
		             }
		             if(jsonObject.has("intMobileClaimId"))
		             {
		            	 landlineexpenseid=Integer.toString(jsonObject.getInt("intMobileClaimId")) ;
		            	  loginArray.add(landlineexpenseid);
		             }
		             if(jsonObject.has("intCityId"))
		             {
		            	 jsonObjCityfrom=Integer.toString(jsonObject.getInt("intCityId")) ;
		            	  loginArray.add(jsonObjCityfrom);
		             }
		           
		            
		             if(jsonObject.has("intappid"))
		             {
		            	 jsonObjtravelmode=Integer.toString(jsonObject.getInt("intappid")) ;
		            	 loginArray.add(jsonObjtravelmode);
		             }
		             
		             if(jsonObject.has("wbS_ID"))
		             {
		            	 jsonObjwbs=Integer.toString(jsonObject.getInt("wbS_ID")) ;
		            	 loginArray.add(jsonObjwbs);
		             }
		            
		             if(jsonObject.has("noE_ID"))
		             {
		            	 noe=Integer.toString(jsonObject.getInt("noE_ID"));
		            	 loginArray.add(noe);
		             }
		             if(jsonObject.has("intAppId"))
		             {
		            	 foodType=Integer.toString(jsonObject.getInt("intAppId"));
		            	 loginArray.add(foodType);
		             }
		             if(jsonObject.has("bitIsActive"))
		             {
		            	 foodTypeStatus=Boolean.toString(jsonObject.getBoolean("bitIsActive"));
		            	 loginArray.add(foodTypeStatus);
		             }
		             if(jsonObject.has("place"))
		             {
		            	// townIdId=Integer.toString(jsonObject.getInt("place"));
		            	 townIdId=jsonObject.getString("place");
		            	 loginArray.add(townIdId);;
		             }
		             if(jsonObject.has("intHQ"))
		             {
		            	 hqtypeId=Integer.toString(jsonObject.getInt("intHQ"));
		            	 loginArray.add(hqtypeId);
		             }
		             if(jsonObject.has("intTravelMode"))
		             {
		            	 danonetravelmodeId=Integer.toString(jsonObject.getInt("intTravelMode"));
		            	 loginArray.add(danonetravelmodeId);
		             }
		             if(jsonObject.has("intClaimTypeID"))
		             {
		            	 claimtypeid=Integer.toString(jsonObject.getInt("intClaimTypeID"));
		            	 loginArray.add(claimtypeid);
		             }
		             if(jsonObject.has("bindDate"))
		             {
		            	 currentweektext=jsonObject.getString("bindDate");
		            	 loginArray.add(currentweektext);
		             }
		             
		             
		             if(jsonObject.has("leaveTypeID"))
		             {
		            	   jsonObjleaveid=(jsonObject.get("leaveTypeID")).toString();
		            	
		            	 loginArray.add(jsonObjleaveid);
		             }
		             
		             
		            
		             if(jsonObject.has("intShiftId"))
		             {
		            	   shiftid=Integer.toString(jsonObject.getInt("intShiftId"));
		            	
		            	 loginArray.add(shiftid);
		             }
		             if(jsonObject.has("charShift"))
		             {
		            	   shiftname=jsonObject.getString("charShift");
		            	  
		            	 loginArray.add(shiftname);
		             }
		             
		             if(jsonObject.has("intFoodTypeId"))
		             {
		            	   artistfoodtypeid=Integer.toString(jsonObject.getInt("intFoodTypeId"));
		            	
		            	 loginArray.add(artistfoodtypeid);
		             }
		             if(jsonObject.has("charFoodTypeName"))
		             {
		            	   artistfoodtypename=jsonObject.getString("charFoodTypeName");
		            	
		            	 loginArray.add(artistfoodtypename);
		             }
		             
		             if(jsonObject.has("claimid"))
		             {
		            	   artistclaimid=Integer.toString(jsonObject.getInt("claimid"));
		            	 
		            	 loginArray.add(artistclaimid);
		             }
		             if(jsonObject.has("result"))
		             {
		            	   claimidresult=Integer.toString(jsonObject.getInt("result"));
		            	
		            	 loginArray.add(claimidresult);
		             }
		             if(jsonObject.has("travelClaimId"))
		             {
		            	   artisttravelexpenseid=Integer.toString(jsonObject.getInt("travelClaimId"));
		            	  
		            	 loginArray.add(artisttravelexpenseid);
		             }
		             if(jsonObject.has("intCoverageType"))
		             {
		            	   coverageType=Integer.toString(jsonObject.getInt("intCoverageType"));
		            	   
		            	 loginArray.add(coverageType);
		             }
		             
		             if(jsonObject.has("intStateId"))
		             {
		            	 jasonstateid= (jsonObject.get("intStateId")).toString() ;
		            	 loginArray.add(jasonstateid);
		             }
		             
		             if(jsonObject.has("vcappvalue"))
		             {
		            	 jasobandvalue= (jsonObject.get("vcappvalue")).toString() ;
		            	 loginArray.add(jasobandvalue);
		             }
		             if(jsonObject.has("vcAmount"))
		             {
		            	 allowanceamount=Integer.toString(jsonObject.getInt("vcAmount")) ;
		            	  loginArray.add(allowanceamount);
		             }
		             if(jsonObject.has("vcAppValue"))
		             {
		            	String jsonObjHQType=jsonObject.getString("vcAppValue") ;
		            	  loginArray.add(jsonObjHQType);
		             }
		         //   loginArray=myjson.getJSONArray("");
		          //  JSONArray jsonObj2 = jsonObj1.getJSONArray("e");
		         //   JSONObject jsonObj3 = jsonObj2.getJSONObject(0);
		          //  System.out.println(jsonObj1.getJSONObject("content"));
		          //  System.out.println("here ===>>>"+jsonObj1.getJSONObject("content").get("$t").toString());
		            //System.out.println("======>"+foodType);
		           
		        } 
		        catch (JSONException e) {
		            e.printStackTrace();
		        }
		}
		
		
	        
	        
	        return loginArray;
		
	}
	
	
	
	
	
	public void httpPost(String url, String claimid, String advanceid,String APIBody) throws JSONException,InterruptedException {
		
		//Initializing Rest API's URL
		//String APIUrl = "http://{API URL}";
		System.out.println(claimid + advanceid +APIBody);
		//Initializing payload or API body
		// APIBody = "{\"AdvanceID\": "+advanceid+", \"ClaimID\":"+claimid+" , \"Other\": \"1\" ,\"Domain\" : \"lechler\"}"; //e.g.- "{\"key1\":\"value1\",\"key2\":\"value2\"}"
		// System.out.println(APIBody);		
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
//String key="advanceID";

		//Fetching the desired value of a parameter
		
			
			
			 if(JSONResponseBody.has("advanceID"))
             {
				String result=(JSONResponseBody.get("advanceID").toString());
            	   System.out.println("======>"+result);
            	 //loginArray.add(result);
             }
		//Asserting that result of Norway is Oslo
		//Assert.assertEquals(result, "{expectedValue}");

		}
}
