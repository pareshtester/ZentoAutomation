package PageObjects;

import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;

import com.sun.org.apache.xerces.internal.util.URI;

import Browsers.Urls;
import Data.capturePostAPIData;
import TestData.GetApiData;

public class visapostapi extends Urls{
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
	String stateid="";
	String designationid="";
	String vendorid="";
	String poid="";
	String termid="";
	String termtext="";
	String cycleamount="";
	String invoiceno="688482";
	String postatus="";
	String podocid="";
	String POnumber="6393";
	String invoiceid="";
	String invoicedocid="";
	String depatmentdata="";
	String claimtypeid="";
	String empid="";
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	int k=0;
	Calendar current = Calendar.getInstance();
	ArrayList<String> array = new ArrayList<String>();

	String travelpolicybindcode="";
	DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate localDate = LocalDate.now();
	ExtendedCallAPI ecapi= new ExtendedCallAPI();
	
	PostAPIPage postapi = new PostAPIPage();
	
	capturePostAPIData postapidata= new capturePostAPIData();
	
	public void steps(String functiontext,String username,String password,String managerusername,String managerpassword,String policytype,String Gstn,String pannum,String ponum,String invoiceno,String domaintext) throws JSONException, InterruptedException, ParseException 
	{
//		
//		  APIBody = "{\r\n" + 
//			  		"  \"Email\": '"+managerusername+"',\r\n" + 
//			  		"  \"Domain\": '"+domaintext+"'\r\n" + 
//			  		"}";
//			 ArrayList<String> array=  postapidata.Postarray(postbaseurl+"api/Vendor/DeleteVendorAllDetails" , APIBody );
//			 String successmessage =array.get(1);
//			 assertTrue(successmessage.equalsIgnoreCase("Details Deleted Successfully"));
//		
		GetApiData gdata1 = new  GetApiData();
		capturePostAPIData postapidata= new capturePostAPIData();
		
		  
		 System.out.println("here"+functiontext);
		switch(functiontext){
		
		
			//Import card statement
			 
		case "CreditCardStatement/InsertCreditStatementDetails" :
			
						
			APIBody = "{\r\n" + 
					"  \"EmpCode\": '"+username+"',\r\n" + 
					"  \"AccountNo\": \"78457788\",\r\n" + 
					"  \"SerialNo\": \"100101\",\r\n" + 
					"  \"CardSerialNo\": \"11\",\r\n" + 
					"  \"TypeSerNoGledger\": \"14\",\r\n" + 
					"  \"I002No\": \"45666\",\r\n" + 
					"  \"TxnType\": \"test\",\r\n" + 
					"  \"MccCode\": \"45657\",\r\n" + 
					"  \"MccNo\": \"65788\",\r\n" + 
					"  \"I013TrxnDate\": '"+dtf.format(localDate)+"',\r\n" + 
					"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
					"  \"I048TextData\": \"yrty\",\r\n" + 
					"  \"AccountStatus\": \"test\",\r\n" + 
					"  \"Amount\": 150,\r\n" + 
					"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
					"  \"AuthID\": \"3565\",\r\n" + 
					"  \"I031ArnNo\": \"4566\",\r\n" + 
					"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
					"  \"Domain\": '"+domaintext+"'\r\n" + 
					"}";
			
			  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
		
			 
			 //Submit visa card
			 
		case "CreditCardStatement/InsertEmpCreditCardData" :
			APIBody = "{\r\n" + 
					"  \"EmpCode\": '"+username+"',\r\n" + 
					"  \"AccountNo\": \"78457788\",\r\n" + 
					"  \"SerialNo\": \"100101\",\r\n" + 
					"  \"CardSerialNo\": \"11\",\r\n" + 
					"  \"TypeSerNoGledger\": \"14\",\r\n" + 
					"  \"I002No\": \"45666\",\r\n" + 
					"  \"TxnType\": \"test\",\r\n" + 
					"  \"MccCode\": \"45657\",\r\n" + 
					"  \"MccNo\": \"65788\",\r\n" + 
					"  \"I013TrxnDate\": \"04/04/2020\",\r\n" + 
					"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
					"  \"I048TextData\": \"yrty\",\r\n" + 
					"  \"AccountStatus\": \"test\",\r\n" + 
					"  \"Amount\": 150,\r\n" + 
					"  \"PostDate\": \"04/03/2020\",\r\n" + 
					"  \"AuthID\": \"3565\",\r\n" + 
					"  \"I031ArnNo\": \"4566\",\r\n" + 
					"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
					"  \"Domain\": '"+domaintext+"'\r\n" + 
					"}";
			
			 System.out.println(APIBody);
			
			  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
			  System.out.println(array);
			
			  String creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
			  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
			  
			  String stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
			  
			  APIBody = "{\r\n" + 
				 		"  \"MasterType\": \"WBS\",\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
			  wbsid= array.get(1);
			//  System.out.println("wbs id is"+array);
		
			
			 APIBody = "{\r\n" + 
			 		"\"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
				  claimtypeid=array.get(1);
				  System.out.println("Response is->>>"+claimtypeid);
				 // assertTrue(response.equalsIgnoreCase("1"));
			
				  APIBody = "{\r\n" + 
					  		"  \"TeamId\": 0,\r\n" + 
					  		"  \"ZoneId\": 0,\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
					  System.out.println("emp array is"+array);
					//  assertTrue(response.equalsIgnoreCase("Success"));
					  empid=array.get(1);
					  System.out.println("Empid is"+empid);
					  
					  Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
					    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
						
					    String newdate=sdf.format(date1);
					    
					    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
						  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
						  System.out.println(array);
						
						empdata= array.get(0);
						
			System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
			APIBody = "{\r\n" + 
					"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
					"  \"intEmpId\": '"+empdata+"',\r\n" + 
					"  \"dtTransaction\": \"04/04/2020\",\r\n" + 
					"  \"vcDescription\": \"Test\",\r\n" + 
					"  \"vcAmount\": 100,\r\n" + 
					"  \"vcCategory\": \"teshgdfg\",\r\n" + 
					"  \"intClient\": '"+wbsid+"',\r\n" + 
					"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
					"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
					"  \"Domain\": '"+domaintext+"'\r\n" + 
					"}";
			
			  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 //Approve Reject visa card
			 
		case "CreditCardStatement/ApproveDisapproveCard" :
			
			APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
			  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
			  System.out.println(array);
			
			managerdata= array.get(0);
			
			APIBody = "{\r\n" + 
					"  \"EmpCode\": '"+username+"',\r\n" + 
					"  \"AccountNo\": \"78457788\",\r\n" + 
					"  \"SerialNo\": \"100101\",\r\n" + 
					"  \"CardSerialNo\": \"11\",\r\n" + 
					"  \"TypeSerNoGledger\": \"14\",\r\n" + 
					"  \"I002No\": \"45666\",\r\n" + 
					"  \"TxnType\": \"test\",\r\n" + 
					"  \"MccCode\": \"45657\",\r\n" + 
					"  \"MccNo\": \"65788\",\r\n" + 
					"  \"I013TrxnDate\": \"04/02/2020\",\r\n" + 
					"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
					"  \"I048TextData\": \"yrty\",\r\n" + 
					"  \"AccountStatus\": \"test\",\r\n" + 
					"  \"Amount\": 150,\r\n" + 
					"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
					"  \"AuthID\": \"3565\",\r\n" + 
					"  \"I031ArnNo\": \"4566\",\r\n" + 
					"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
					"  \"Domain\": '"+domaintext+"'\r\n" + 
					"}";
			
			 System.out.println(APIBody);
			
			  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
			  System.out.println(array);
			
			   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
			  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
			  
			   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
			
			
			
			
			 APIBody = "{\r\n" + 
				 		"  \"MasterType\": \"WBS\",\r\n" + 
				 		"  \"Domain\": '"+domaintext+"'}";
			  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
			  wbsid= array.get(1);
			 // System.out.println("wbs id is"+array);
		
			
			 APIBody = "{\r\n" + 
			 		"\"Domain\": '"+domaintext+"'\r\n" + 
			 		"}";
			 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
				  claimtypeid=array.get(1);
				  System.out.println("Response is->>>"+claimtypeid);
				 // assertTrue(response.equalsIgnoreCase("1"));
			
				  APIBody = "{\r\n" + 
					  		"  \"TeamId\": 0,\r\n" + 
					  		"  \"ZoneId\": 0,\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
					  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
					  System.out.println("emp array is"+array);
					//  assertTrue(response.equalsIgnoreCase("Success"));
					  empid=array.get(1);
					  System.out.println("Empid is"+empid);
					  
					   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
					    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
						
					     newdate=sdf.format(date1);
					    
					    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
						  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
						  System.out.println(array);
						
						empdata= array.get(0);
						 
						
						
						 
						
			System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
			APIBody = "{\r\n" + 
					"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
					"  \"intEmpId\": '"+empdata+"',\r\n" + 
					"  \"dtTransaction\": \"04/02/2020\",\r\n" + 
					"  \"vcDescription\": \"Test\",\r\n" + 
					"  \"vcAmount\": 100,\r\n" + 
					"  \"vcCategory\": \"teshgdfg\",\r\n" + 
					"  \"intClient\": '"+wbsid+"',\r\n" + 
					"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
					"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
					"  \"Domain\": '"+domaintext+"'\r\n" + 
					"}";
			
			 System.out.println(APIBody);
			
			  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
			  System.out.println(array);
			  
			  
			  String creditstmtid=array.get(0);

			  
			  
			
			APIBody = "{\r\n" + 
					"  \"intEmpCreditCardStatement\": '"+creditstmtid+"',\r\n" + 
					"  \"ReccId\": '"+managerdata+"',\r\n" + 
					"  \"Remarks\": \"testrmks\",\r\n" + 
					"  \"Action\": 0,\r\n" + 
					"  \"Domain\": '"+domaintext+"'\r\n" + 
					"}";
			
			  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/ApproveDisapproveCard" , APIBody);
			  assertTrue(response.equalsIgnoreCase("1"));
			 break;
			 
			 //Reopen 
				case "CreditCardStatement/ReopenCardStatement" :
					
					APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					managerdata= array.get(0);
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/02/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
								
								
								 
								
								
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"04/02/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);

								  
								  
								
								APIBody = "{\r\n" + 
										"  \"intEmpCreditCardStatement\": '"+creditstmtid+"',\r\n" + 
										"  \"ReccId\": '"+managerdata+"',\r\n" + 
										"  \"Remarks\": \"testrmks\",\r\n" + 
										"  \"Action\": 0,\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/ApproveDisapproveCard" , APIBody);
								//  assertTrue(response.equalsIgnoreCase("1"));
								
					APIBody = "{\r\n" + 
							"  \"intEmpCreditCardStatement\": '"+creditstmtid+"',\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/ReopenCardStatement" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					 break;
					 
					 // Update card
				case "CreditCardStatement/UpdateEmpCreditCardData" :
					
					
					APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+managerusername+"' ,\"PWD\": '"+managerpassword+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					managerdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/02/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
								
								
								 
								
								
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"04/02/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);

								  
								  
								
								APIBody = "{\r\n" + 
										"  \"intEmpCreditCardStatement\": '"+creditstmtid+"',\r\n" + 
										"  \"ReccId\": '"+managerdata+"',\r\n" + 
										"  \"Remarks\": \"testrmks\",\r\n" + 
										"  \"Action\": 0,\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/ApproveDisapproveCard" , APIBody);
								//  assertTrue(response.equalsIgnoreCase("1"));
								
					
					  
					  APIBody = "{\r\n" + 
					  		"  \"intCreditStmtID\": '"+creditstmtid+"',\r\n" + 
					  		"  \"dtTransaction\": \"04/02/2020\",\r\n" + 
					  		"  \"vcDescription\": \"test\",\r\n" + 
					  		"  \"vcAmount\": \"100\",\r\n" + 
					  		"  \"vcCategory\": \"test\",\r\n" + 
					  		"  \"intClient\": '"+wbsid+"',\r\n" + 
					  		"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
					  		"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
						
						  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/UpdateEmpCreditCardData" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
					 break;
					 
				case "CreditCardStatement/GetCreditCardTransactionDetails" :
					
					 APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					APIBody = "{\r\n" + 
							"  \"year\": \"2020\",\r\n" + 
							"  \"month\": \"04\",\r\n" + 
							"  \"EmpId\": '"+empdata+"',\r\n" + 
							"  \"Action\": \"pending\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/GetCreditCardTransactionDetails" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					 break;
		
					 
					 
				case "CreditCardStatement/DocumentUpload" :
					
					  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/02/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
							
								
								
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"04/02/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"intCreditCardStatementId\": '"+creditstmtid+"',\r\n" + 
							"  \"intEmpid\": '"+empdata+"',\r\n" + 
							"  \"vcFile\": \"sample string 3\",\r\n" + 
							"  \"fileDetails\": \"sample string 4\",\r\n" + 
							"  \"fileType\": \"sample string 5\",\r\n" + 
							"  \"dtCreatedOn\": \"04/02/2020\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/DocumentUpload" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					 
					 break;
					 
					 
					//get Approved data 
					 
				case "CreditCardStatement/GetApproverCreditCardStatement" :
					
					  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					  managerdata= array.get(0);
					empdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"empid\": '"+empdata+"',\r\n" + 
							"  \"month\": \"04\",\r\n" + 
							"  \"year\": \"2020\",\r\n" + 
							"  \"Reccid\": '"+managerdata+"',\r\n" + 
							"  \"Action\": \"pending\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/GetApproverCreditCardStatement" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					 break;
				
					 
					 // Credit card Statement Status
				
				case "CreditCardStatement/GetCreditCardStatementStatus" :
					
				

					  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/02/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
	
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"04/02/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);
				
									
					
					APIBody = "{\r\n" + 
							"  \"intEmpCreditCardStatement\": '"+creditstmtid+"',\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/GetCreditCardStatementStatus" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					 break;
					 
					 
				case "CreditCardStatement/GetReasonsforCreditCardStatement" :
					
					  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"Domain\":'"+domaintext+"'\r\n" + 
							"}";
					
					  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/GetReasonsforCreditCardStatement" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					 break;
					 
				case "CreditCardStatement/GetEmpCreditCardStatementDetailsByCreditStmtId" :
					
					  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/02/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
	
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"04/02/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);
				
					
	
					
					APIBody = "{\r\n" + 
							"  \"CreditStmtID\": '"+creditstmtid+"',\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/GetReasonsforCreditCardStatement" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					 break;
					 
				case "CreditCardStatement/CheckHierarchy" :
					
					  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"empid\": '"+empdata+"',\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/CheckHierarchy" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					 break;
				
					 
				case "CreditCardStatement/GetAllCardStatements" :
					
					  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/02/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
	
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"04/02/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);
	
					
					APIBody = "{\r\n" + 
							"  \"intEmpCreditCardStatement\": '"+creditstmtid+"',\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/GetAllCardStatements" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					 break;
					 
				case "CreditCardStatement/GetCardDocumentsByEmpCardID" :
					
					  APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/02/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
	
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"04/02/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);
	
					
					APIBody = "{\r\n" + 
							"  \"intEmpCreditCardStatement\": '"+creditstmtid+"',\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/GetCardDocumentsByEmpCardID" , APIBody);
					  assertTrue(response.equalsIgnoreCase("1"));
					 break;
					 
					 
					 
					 
					 
				case "CreditCardStatement/DownloadDocCardStatement" :
					
					 APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/05/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
							
								
								
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"05/04/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"intCreditCardStatementId\": '"+creditstmtid+"',\r\n" + 
							"  \"intEmpid\": '"+empdata+"',\r\n" + 
							"  \"vcFile\": \"sample string 3\",\r\n" + 
							"  \"fileDetails\": \"sample string 4\",\r\n" + 
							"  \"fileType\": \"sample string 5\",\r\n" + 
							"  \"dtCreatedOn\": \"04/02/2020\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/DocumentUpload" , APIBody);
					 System.out.println("Doc array is "+ array);
					  String docid= array.get(1);
					  System.out.println(docid);
					  
					  APIBody = "{\r\n" + 
					  		"  \"FileName\": \"sample string 1\",\r\n" + 
					  		"  \"docid\": '"+docid+"',\r\n" + 
					  		"  \"ClaimType\": '"+claimtypeid+"',\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
						
						  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/DownloadDocCardStatement" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));

						  
						  
						  
						  
				case "CreditCardStatement/StoreDocCardStatement" :
					
					 APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/05/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
							
								
								
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"05/04/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"intCreditCardStatementId\": '"+creditstmtid+"',\r\n" + 
							"  \"intEmpid\": '"+empdata+"',\r\n" + 
							"  \"vcFile\": \"sample string 3\",\r\n" + 
							"  \"fileDetails\": \"sample string 4\",\r\n" + 
							"  \"fileType\": \"sample string 5\",\r\n" + 
							"  \"dtCreatedOn\": \"04/02/2020\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/DocumentUpload" , APIBody);
					 System.out.println("Doc array is "+ array);
					   docid= array.get(1);
					  System.out.println(docid);
					  
					  APIBody = "{\r\n" + 
					  		"  \"FileName\": \"sample string 1\",\r\n" + 
					  		"  \"docid\": '"+docid+"',\r\n" + 
					  		"  \"ClaimType\": '"+claimtypeid+"',\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
						
						  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/StoreDocCardStatement" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));
						  
						  
						  
						  
				case "CreditCardStatement/DeleteDocCardStatement" :
					
					 APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/05/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
							
								
								
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"05/04/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"intCreditCardStatementId\": '"+creditstmtid+"',\r\n" + 
							"  \"intEmpid\": '"+empdata+"',\r\n" + 
							"  \"vcFile\": \"sample string 3\",\r\n" + 
							"  \"fileDetails\": \"sample string 4\",\r\n" + 
							"  \"fileType\": \"sample string 5\",\r\n" + 
							"  \"dtCreatedOn\": \"04/02/2020\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/DocumentUpload" , APIBody);
					 System.out.println("Doc array is "+ array);
					   docid= array.get(1);
					  System.out.println(docid);
					  
					  APIBody = "{\r\n" + 
					  		"  \"FileName\": \"sample string 1\",\r\n" + 
					  		"  \"docid\": '"+docid+"',\r\n" + 
					  		"  \"ClaimType\": '"+claimtypeid+"',\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
						
						  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/DeleteDocCardStatement" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));

						  
						  
				case "CreditCardStatement/DeleteCardDocByID" :
					
					 APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
					  System.out.println(array);
					
					empdata= array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"EmpCode\": '"+username+"',\r\n" + 
							"  \"AccountNo\": \"78457788\",\r\n" + 
							"  \"SerialNo\": \"100101\",\r\n" + 
							"  \"CardSerialNo\": \"11\",\r\n" + 
							"  \"TypeSerNoGledger\": \"14\",\r\n" + 
							"  \"I002No\": \"45666\",\r\n" + 
							"  \"TxnType\": \"test\",\r\n" + 
							"  \"MccCode\": \"45657\",\r\n" + 
							"  \"MccNo\": \"65788\",\r\n" + 
							"  \"I013TrxnDate\": \"04/05/2020\",\r\n" + 
							"  \"I044ReasonCode\": \"Testreason\",\r\n" + 
							"  \"I048TextData\": \"yrty\",\r\n" + 
							"  \"AccountStatus\": \"test\",\r\n" + 
							"  \"Amount\": 150,\r\n" + 
							"  \"PostDate\": '"+dtf.format(localDate)+"',\r\n" + 
							"  \"AuthID\": \"3565\",\r\n" + 
							"  \"I031ArnNo\": \"4566\",\r\n" + 
							"  \"TransactionSerialNo\": \"467567567\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					 System.out.println(APIBody);
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/InsertCreditStatementDetails" , APIBody );
					  System.out.println(array);
					
					   creditcardstatementvalue=array.get(1).replaceAll("^\"|\"$", "");
					  System.out.println(creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+",""));
					  
					   stmtidnew=creditcardstatementvalue.replaceAll("[^a-zA-Z0-9]+","");
					
					
					
					
					 APIBody = "{\r\n" + 
						 		"  \"MasterType\": \"WBS\",\r\n" + 
						 		"  \"Domain\": '"+domaintext+"'}";
					  array= postapidata.getarraydata(postbaseurl+"api/Master/GetMasterDataList" , APIBody );
					  wbsid= array.get(1);
					 // System.out.println("wbs id is"+array);
				
					
					 APIBody = "{\r\n" + 
					 		"\"Domain\": '"+domaintext+"'\r\n" + 
					 		"}";
					 array= postapidata.getarraydata(postbaseurl+"api/Master/GetAllClaimType" , APIBody);
						  claimtypeid=array.get(1);
						  System.out.println("Response is->>>"+claimtypeid);
						 // assertTrue(response.equalsIgnoreCase("1"));
					
						  APIBody = "{\r\n" + 
							  		"  \"TeamId\": 0,\r\n" + 
							  		"  \"ZoneId\": 0,\r\n" + 
							  		"  \"Domain\": '"+domaintext+"'\r\n" + 
							  		"}";
							  array= postapidata.getarraydata(postbaseurl+"api/Employees/GetEmployees" , APIBody );
							  System.out.println("emp array is"+array);
							//  assertTrue(response.equalsIgnoreCase("Success"));
							  empid=array.get(1);
							  System.out.println("Empid is"+empid);
							  
							   date1=new SimpleDateFormat("MM/dd/yyyy").parse(dtf.format(localDate));  
							    System.out.println("new date format"+dtf.format(localDate)+"\t"+date1);  
								
							     newdate=sdf.format(date1);
							    
							    APIBody = "{\"Mode\" : \"Login\" ,\"UName\": '"+username+"' ,\"PWD\": '"+password+"' ,\"Domain\" : '"+domaintext+"'}";
								  array=  postapidata.getdata(postbaseurl+"api/Login/GetLogin" , APIBody );
								  System.out.println(array);
								
								empdata= array.get(0);
								 
							
								
								
								System.out.println(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData");
								APIBody = "{\r\n" + 
										"  \"intCreditStmtID\": "+stmtidnew+",\r\n" + 
										"  \"intEmpId\": '"+empdata+"',\r\n" + 
										"  \"dtTransaction\": \"05/04/2020\",\r\n" + 
										"  \"vcDescription\": \"Test\",\r\n" + 
										"  \"vcAmount\": 100,\r\n" + 
										"  \"vcCategory\": \"teshgdfg\",\r\n" + 
										"  \"intClient\": '"+wbsid+"',\r\n" + 
										"  \"intSpendOnEmp\": '"+empid+"',\r\n" + 
										"  \"intClaimType\": '"+claimtypeid+"',\r\n" + 
										"  \"Domain\": '"+domaintext+"'\r\n" + 
										"}";
								
								 System.out.println(APIBody);
								
								  array= postapidata.getarraydata(postbaseurl+"api/CreditCardStatement/InsertEmpCreditCardData" , APIBody );
								  System.out.println(array);
								  
								  
								   creditstmtid=array.get(0);
					
					
					APIBody = "{\r\n" + 
							"  \"intCreditCardStatementId\": '"+creditstmtid+"',\r\n" + 
							"  \"intEmpid\": '"+empdata+"',\r\n" + 
							"  \"vcFile\": \"sample string 3\",\r\n" + 
							"  \"fileDetails\": \"sample string 4\",\r\n" + 
							"  \"fileType\": \"sample string 5\",\r\n" + 
							"  \"dtCreatedOn\": \"04/02/2020\",\r\n" + 
							"  \"Domain\": '"+domaintext+"'\r\n" + 
							"}";
					
					  array= postapidata.Postarray(postbaseurl+"api/CreditCardStatement/DocumentUpload" , APIBody);
					 System.out.println("Doc array is "+ array);
					   docid= array.get(1);
					  System.out.println(docid);
					  
					  APIBody = "{\r\n" + 
					  		"  \"docid\": '"+docid+"',\r\n" + 
					  		"  \"creditstmtid\": '"+creditstmtid+"',\r\n" + 
					  		"  \"Domain\": '"+domaintext+"'\r\n" + 
					  		"}";
						
						  response= postapidata.httpPost(postbaseurl+"api/CreditCardStatement/DeleteCardDocByID" , APIBody);
						  assertTrue(response.equalsIgnoreCase("1"));

		}
}
	
}
