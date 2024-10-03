package TestData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonArray;

import netscape.javascript.JSObject;

public class GetData {

String noeactive="";
public String getContenxtWeb(String urlS) {
String pagina = "", devuelve = "";
URL url;
try {
url = new URL(urlS);
HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
conexion.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
System.out.println(conexion.getResponseCode());
if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK || conexion.getResponseCode() == HttpURLConnection.HTTP_CREATED ) {
BufferedReader reader = new BufferedReader(
new InputStreamReader(conexion.getInputStream()));
String linea = reader.readLine();
// System.out.println("this is linea"+linea);
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
// System.out.println("Response:"+devuelve);
return devuelve;

} catch (Exception ex) {
return devuelve;
}
}

public ArrayList<String> parseFromJSONResponse(String respo)
{
//JSONParser parse = new JSONParser();
//JSONObject[][] loginArray = new JSONObject[][];

JSONObject myjson = null;
String jsonObj1="";
String jsonObj2="";
String jsonObj3="";
String jsonObjHQType="";
String jsonObjclaimId="";
String jsonObjempId="";
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
String jsonObjadvanceId="";
String datepolicy="";



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
jsonObjclaimId=Integer.toString(myjson.getInt("intClaimID")) ;
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
jsonObjterritoryId=Integer.toString(myjson.getInt("intTerritory")) ;
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
jsonObjzoneId=myjson.get("intRegionId").toString(); ;
}
loginArray.add(jsonObjzoneId);
if(myjson.has("intTeamId"))
{
jsonObjteamId=myjson.get("intRegionId").toString(); ;
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
jsonObjadvanceId = Integer.toString(myjson.getInt("intLeaveMasterID"));

}
loginArray.add(jsonObjadvanceId);
// loginArray=myjson.getJSONArray("");
// JSONArray jsonObj2 = jsonObj1.getJSONArray("e");
// JSONObject jsonObj3 = jsonObj2.getJSONObject(0);
// System.out.println(jsonObj1.getJSONObject("content"));
// System.out.println("here ===>>>"+jsonObj1.getJSONObject("content").get("$t").toString());
// System.out.println("======>"+jsonObjclaimId);

}
catch (JSONException e) {
e.printStackTrace();
}
return loginArray;
}

public ArrayList<String> parseFromJSONarrayResponse(String respo)
{

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
String jasoncontrolName="";
String jasonvisiblestatus="";
String jasonclaimtype="";
String jasonperkm="";
String jasonkmdistance="";
String jsontravelmodetype="";
String document="";
String datepolicy="";
ArrayList<String> noearray = new ArrayList<String>();
JSONArray jsonArray = new JSONArray(respo);
// System.out.println("Array ln->>>>>>>>>>"+jsonArray.length());
// System.out.println(jsonArray);
ArrayList<String> loginArray= new ArrayList<String>();
// System.out.println("size"+loginArray.size());
for (int i = 0; i < jsonArray.length(); i++) {
System.out.println(i);
JSONObject jsonObject = jsonArray.getJSONObject(i);
System.out.println(i);
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
// System.out.println("======>here1"+loginArray);
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
jsonObjleaveid=jsonObject.getString("leaveTypeID");

loginArray.add(jsonObjleaveid);
}
if(jsonObject.has("vcControlName"))
{
jasoncontrolName=jsonObject.getString("vcControlName");

loginArray.add(jasoncontrolName);
}
if(jsonObject.has("isVisible"))
{
jasonvisiblestatus=Boolean.toString(jsonObject.getBoolean("isVisible"));

loginArray.add(jasonvisiblestatus);
}
if(jsonObject.has("claim_type"))
{
jasonclaimtype=Integer.toString(jsonObject.getInt("claim_type"));

loginArray.add(jasonclaimtype);
}
if(jsonObject.has("vcPerKm"))
{
jasonperkm=Integer.toString(jsonObject.getInt("vcPerKm"));

loginArray.add(jasonperkm);
}
if(jsonObject.has("intKmPerDay"))
{
jasonkmdistance=Integer.toString(jsonObject.getInt("intKmPerDay"));
// System.out.println("======>"+jasonkmdistance);
loginArray.add(jasonkmdistance);
}
if(jsonObject.has("travel_Mode"))
{
jsontravelmodetype=jsonObject.get("travel_Mode").toString();
// System.out.println("======>"+jsontravelmodetype);
loginArray.add(jsontravelmodetype);
}

if(jsonObject.has("isActive"))
{
noeactive=Boolean.toString(jsonObject.getBoolean("isActive"));
// System.out.println("======>"+noeactive);
loginArray.add(noeactive);
}
if(jsonObject.has("is_Document_Mandatry"))
{
document=Boolean.toString(jsonObject.getBoolean("is_Document_Mandatry"));
// System.out.println("======>"+noeactive);
loginArray.add(document);
}

if(jsonObject.has("amtLimitCriteria"))
{
	 datepolicy=jsonObject.get("amtLimitCriteria").toString();
//	   System.out.println("======>"+jsontravelmodetype);
	loginArray.add(datepolicy);
}

// loginArray=myjson.getJSONArray("");
// JSONArray jsonObj2 = jsonObj1.getJSONArray("e");
// JSONObject jsonObj3 = jsonObj2.getJSONObject(0);
// System.out.println(jsonObj1.getJSONObject("content"));
// System.out.println("here ===>>>"+jsonObj1.getJSONObject("content").get("$t").toString());

// System.out.println("======>here"+jsonObjleaveid);

}
catch (JSONException e) {

e.printStackTrace();
}
}




return loginArray;

}
}