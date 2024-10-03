package PageObjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Browsers.Urls;

public class EditexpenseDetailsLocator extends Urls {
	
WebDriver driver;
	String noeactive="";
;	public EditexpenseDetailsLocator(WebDriver driver) {
		
		this.driver=driver;
	}
	Calendar current = Calendar.getInstance();
	//Edit travel expense
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_RptTravelClaim_ctl01_imgEdit\"]")
	WebElement editIconclick;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_DDlCityfrom\"]")
	WebElement cityFrom;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtInvoiceNo\"]")
	WebElement Tinvoiceno;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_DDlCityTo\"]")
	WebElement cityTo;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_ddlMode\"]")
	WebElement travelMode;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtAmt\"]")
	WebElement travelAmount;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_TabContainerClaim_tabTravel_TravelControl_ddlWBS']")
	WebElement clientBorrower;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtGSTN\"]")
	WebElement Tgstn;
	//*[@id="ctl00_ContentPlaceHolder1_ctrlTravel_txtGSTN"]
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtCGSTAmount\"]")
	WebElement Tcgst;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtSGSTAmount\"]")
	WebElement Tsgst;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtIGSTAmount\"]")
	WebElement Tigst;

	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_txtRemark\"]")
	WebElement remarks;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_fpUpload_Travel1\"]")
	WebElement uploadFile;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_btnTravelUpdate\"]")
	WebElement traveleditbutton;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_RFVAmount\"]")
	WebElement travelamterror;
	
	
	//edit local expense
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ddlClaimTypes\"]")
	WebElement Leditclaimtype;
	//*[@id="ctl00_ContentPlaceHolder1_btnEdit"]
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_RptLocalClaim_ctl01_imgEdit\"]")
	WebElement localeditIconclick;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtInvoiceNo\"]")
	WebElement localinvoiceno;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_DDlCityfrom\"]")
	WebElement LocalcityFrom;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtTo\"]")
	WebElement LocalcityTo;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_ddlMode\"]")
	WebElement LocaltravelMode;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtAmt\"]")
	WebElement LocaltravelAmount;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_vcfrom\"]")
	WebElement Localfrom;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_vcTo\"]")
	WebElement LocalTo;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_TabContainerClaim_tabLocalClaims_LocalControl_ddlWBS']")
	WebElement LocalclientBorrower;
	
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtGSTN\"]")
	WebElement Lgstn;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtCGSTAmount\"]")
	WebElement Lcgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtSGSTAmount\"]")
	WebElement Lsgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtIGSTAmount\"]")
	WebElement Ligst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtRemark\"]")
	WebElement Localremarks;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_fpUpload_Travel1\"]")
	WebElement LocaluploadFile;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_imgbtnLocalUpdate\"]")   
	WebElement localeditbutton;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_RequiredFieldValidator7\"]")   
	WebElement Lfrmcityerror;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_RequiredFieldValidator8\"]")   
	WebElement Ltocityerror;
	
	//ctl00_ContentPlaceHolder1_ctrlLocal_RequiredFieldValidator8
	
	//Edit other
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_TabContainerClaim_TabOther_OtherControl_RptOtherClaim_ctl01_imgEdit']")
	WebElement othereditbutton;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_ddlNOE']")
	WebElement NOEelement;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_txtAmt']")
	WebElement othersAmount;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_TabContainerClaim_TabOther_OtherControl_ddlWBS']")
	WebElement OthersclientBorrower;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_txtLocation']")
	WebElement otherlocation;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_txtRemark']")
	WebElement Othersremarks;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_fpUpload_Other']")
	WebElement OthersuploadFile;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_TabContainerClaim_TabOther_OtherControl_imgbtnOthersUpdate']")
	WebElement OtherssaveDraft;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_txtGSTN']")
	WebElement OthersGSTN;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_txtCGSTAmount']")
	WebElement OthersCGST;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_txtSGSTAmount']")
	WebElement OthersIGST;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_txtIGSTAmount']")
	WebElement OthersSGSt;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_txtInvoiceNo']")
	WebElement OthersInvoiceNo;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_RptOtherClaim_ctl01_imgEdit']")
	WebElement othereditIconclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_imgbtnOthersUpdate']")
	WebElement otherUpdate;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlOther_RequiredFieldValidator1']")
	WebElement otheramterror;
	
	
	
	//Edit Mobile
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_RptMobileClaim_ctl01_imgEdit\"]")
	WebElement editIconMobileclick;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtInvoiceNo\"]")
	WebElement editInvoiceno;
	//*[@id="ctl00_ContentPlaceHolder1_ctrlMobile_txtInvoiceNo"]
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtAmt\"]")
	WebElement mobileAmount;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtRemark\"]")
	WebElement mobileremarks;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_fpUpload_Travel1\"]")
	WebElement mobileuploadFile;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtGSTN\"]")
	WebElement mgstn;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtCGSTAmount\"]")
	WebElement mcgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtSGSTAmount\"]")
	WebElement msgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_txtIGSTAmount\"]")
	WebElement migst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_btnUpdate\"]")
	WebElement mobileupdate;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_TabContainerClaim_TabMobile_MobileControl_ddlWBS']")
	WebElement mobileclientBorrower;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlMobile_RFVAmount']")
	WebElement mobileamterror;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlMobile_txtContactNumber']")
	WebElement mobnum;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlMobile_RequiredFieldValidator1']")
	WebElement moberrormsg;
	
		
	//Edit Hotel
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_RptHotelClaim_ctl01_imgEdit\"]")
	WebElement editIconHotelclick;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtInvoiceNo\"]")
	WebElement HInvoiceNo;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtstarttime\"]")
	WebElement HStartTime;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtendtime\"]")
	WebElement HEndTime;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtGSTN\"]")
	WebElement Hgstn;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtCGSTAmount\"]")
	WebElement Hcgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtSGSTAmount\"]")
	WebElement Hsgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtIGSTAmount\"]")
	WebElement Higst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_DDlCityfrom\"]")
	WebElement hotelCity;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtAmt\"]")
	WebElement hotelAmount;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_TabContainerClaim_TabHotel_HotelControl_ddlWBS']")
	WebElement hotelclientBorrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_txtRemark\"]")
	WebElement hotelremarks;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_fpUpload_Hotel\"]")
	WebElement hoteluploadFile;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_btnHotelUpdate\"]")
	WebElement hotelUpdatebutton;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_RFVAmount\"]")
	WebElement hotelamterror;
	
	//hotelamterror
	
	
	//Edit Food
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ddlClaimTypes\"]")
	WebElement Feditclaimtype;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_RptFoodClaim_ctl01_imgEdit\"]")
	WebElement editIconFoodclick;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtInvoiceNo\"]")
	WebElement FInvoiceNo;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_DDlCityfrom\"]")
	WebElement foodCity;   
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtAmt\"]")
	WebElement foodAmount;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_ddlFoodplace\"]")  
	WebElement foodTypeelement;  
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_TabContainerClaim_TabFood_FoodControl_ddlWBS']")
	WebElement foodclientBorrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtGSTN\"]")
	WebElement fgstn;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtCGSTAmount\"]")
	WebElement fcgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtSGSTAmount\"]")
	WebElement fsgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtIGSTAmount\"]")
	WebElement figst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_txtRemark\"]")
	WebElement foodremarks;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_fpUpload_Food1\"]")
	WebElement fooduploadFile;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_btnFoodUpdate\"]")
	WebElement foodupdatebutton;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_RFVAmount\"]")
	WebElement foodamterror;
	//foodamterror
	
	
	//Edit Landline
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_RptLandlineClaim_ctl01_imgEdit']")
	WebElement editIconLandlineclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_txtAmt']")
	WebElement landlineAmount;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_txtRemark']")
	WebElement landlineremarks;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_fpUpload_Landline1']")
	WebElement landlineuploadFile;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_btnUpdate']")
	WebElement landlinesaveDraft;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_TabContainerClaim_TabLandline_LandlineControl_ddlWBS']")
	WebElement landlineclientBorrower;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtGSTN\"]")
	WebElement landlinegstn;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtCGSTAmount\"]")
	WebElement landlinecgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtSGSTAmount\"]")
	WebElement landlinesgst;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_txtIGSTAmount\"]")
	WebElement landlineigst;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnEdit\"]")
	WebElement EditButton;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ddlClaimTypes\"]")
	WebElement editclaimtype;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_lblmsg2\"]")
	WebElement edittravelsuccess;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_lblmsg2\"]")
	WebElement editothersuccess;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_lblmsg2\"]")
	WebElement editloocalsuccess;  
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_lblmsg2\"]")
	WebElement editmobilesuccess;   
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_lblmsg2\"]")
	WebElement editlandlinesuccess;
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_lblmsg2\"]")
	WebElement edithotelsuccess;   
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_lblmsg2\"]")
	WebElement editfoodsuccess; 
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_RFVAmount\"]")
	WebElement landlineamterror; 
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtKms\"]")
	WebElement distanceval; 
	@FindBy(xpath=".//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_txtAmt\"]")
	WebElement localbillamt; 
	
	
	
	String traveldistance="";
	String travelcost="";
	//String distanceval="";
//	String localbillamt="";
	public void edittravelSteps(String user,String pass,String claimid,String fromCity,String toCity,String tMode,String tamount,String CB,String travelRemarks, String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
	{
		if(travelRemarks==null)
		{
			travelRemarks="";
		}
		if(tamount==null)
		{
			tamount="";
		}
		if(gstn==null)
		{
			gstn="";
		}
		if(cgst==null)
		{
			cgst="";
		}
		if(sgst==null)
		{
			sgst="";
		}
		if(igst==null)
		{
			igst="";
		}
		
		
	    TestData.GetData gdata1 = new  TestData.GetData();
		 String  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
			
			
			 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
			 int i=0;
			
			 String userData=array1.get(i);
			 String passData=array1.get(i+1);
			 String empdata=array1.get(i+2);
			 String bandid=array1.get(i+3);
					 
			 String message=array1.get(i+4);
			 
			 System.out.println("This is" +userData);
			 System.out.println("This is" +passData);
			 System.out.println("This is" +empdata);
		 Thread.sleep(10000);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']")); 

			// Now get all the TR elements from the table 
			List<WebElement> allRows = table.findElements(By.tagName("tr")); 
	                          int size=allRows.size();
	                          System.out.println("Row count is"+size);
	                          int sizecell=0;
			// And iterate over them, getting the cells 
			for (WebElement row : allRows) { 
			    List<WebElement> cells = row.findElements(By.tagName("td")); 
			     sizecell=cells.size();
			   
			    // Print the contents of each cell
			    
			}
			 System.out.println("col count is"+sizecell);
			    for( i=2; i<=size;i++)
			    {
			    	
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	if(claim.equalsIgnoreCase(claimid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    Thread.sleep(1000);
			    
			    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
			    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
				  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
				 System.out.println(array1);
				 String claimtype= array1.get(1);
				 System.out.println("Claim type status is"+claimtype);
				 
				 if(claimtype.equalsIgnoreCase("0"))
				 {
					 
				
				 JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", EditButton);
//			    String windowHandle = driver.getWindowHandle();
//			    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//			    
//			    ArrayList tabs = new ArrayList (driver.getWindowHandles());
//			    System.out.println(tabs.size());
			   // driver.switchTo().window(windowHandle);
			    
//			   driver.switchTo().window((String) tabs.get(0));
//		      driver.get("zento.in");
	    	    
	    	    
	    	    
	    	    String parent=driver.getWindowHandle();
	    	    Set<String>s1window=driver.getWindowHandles();
	    	    Iterator<String> I1= s1window.iterator();
	    	    while(I1.hasNext())
	    	    {
	    	      String child_window=I1.next();
	    	      if(!parent.equals(child_window))
	    	      {
	    	        driver.switchTo().window(child_window);
	    	        System.out.println(driver.switchTo().window(child_window).getTitle());
	    	        
	    	      }
	    	    }
	    	    
	    	    
				 }
			    JavascriptExecutor editiconclickjs = (JavascriptExecutor) driver;
			    editiconclickjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		editIconclick);
			    Thread.sleep(500);
			    
			    Tinvoiceno.clear();
			    Tinvoiceno.sendKeys("05");
			    
			   // TestData.GetData gdata1 = new  TestData.GetData();
				
				 

					TestData.GetData citydata = new  TestData.GetData();
					 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
					
				
					 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
					 int cityno=0;
					
					 String citynamefromdata=cityarray1.get(cityno+1);
					 String citynametodata=cityarray1.get(cityno+2);
					 System.out.println("API CIty name is "+citynamefromdata);
					 System.out.println("API CIty name is "+citynametodata);
			    Select s = new Select(cityFrom);
				s.selectByValue(citynamefromdata);
				Select s1 = new Select(cityTo);
				s1.selectByValue(citynametodata);
				if(!(tamount==null))
						{
				travelAmount.clear();
				travelAmount.sendKeys(tamount);
				
						}
				
				
				
				TestData.GetData gdata = new  TestData.GetData();
				String travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType=TravelClaim&band="+bandid+"&domain="+domain);

				 ArrayList<String> travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
				int travelmodecount=0;
				String travelmodedata=travelmodearray.get(travelmodecount);
				
				System.out.println("API travel mode name is "+travelmodedata);
				Select s2 = new Select(travelMode);
				s2.selectByValue(travelmodedata);
			
//				
//				String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS&domain="+domain);
//				ArrayList<String> wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
//				int wbscount=0;
//				String wbsdata=wbsarray.get(wbscount+4);
//				System.out.println("API wbs mode name is "+wbsdata);
//				Select s4 = new Select(clientBorrower);
//				s4.selectByValue(wbsdata);
				System.out.println("Remarks are"+travelRemarks);
				
				
			
				remarks.clear();
				
				remarks.sendKeys(travelRemarks);
		//travelAmount.clear();
				
				
				
				uploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				
				    Tgstn.clear();				
				 	Tgstn.sendKeys(gstn);
				 	System.out.println("tamount type status is"+tamount);
				 	Tcgst.clear();
				    Tcgst.sendKeys(cgst);
				    System.out.println("tamount type status is"+tamount);
				    Tsgst.clear();
				    Tsgst.sendKeys(sgst);
				    Tigst.clear();
				    Tigst.sendKeys(igst);
				    
				    
				if(tamount==null || tamount=="")
				{
					travelAmount.clear();
					System.out.println("here inside null");
					JavascriptExecutor js6 = (JavascriptExecutor) driver;
				    js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
				    		+ "arguments[0].dispatchEvent(evt);", traveleditbutton);
				    
				  
				    
				    System.out.println(travelamterror.getText());
					assertTrue(travelamterror.getText().equalsIgnoreCase("Please enter total bill amount !"));
					
					
				}
				else
				{
				JavascriptExecutor js6 = (JavascriptExecutor) driver;
			    js6.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
			    		+ "arguments[0].dispatchEvent(evt);", traveleditbutton);
			    
			    assertTrue((edittravelsuccess.getText()).equalsIgnoreCase("Claim updated successfully !"));
			    
				}
			    
//			    Alert alert1 = driver.switchTo().alert();
//				String alerttext1 = driver.switchTo().alert().getText();
//				
//				System.out.println(alerttext1);
//				assertTrue(alerttext1.equalsIgnoreCase("Claim Updated successfully"));
//				alert1.accept();
			    
			    
	}

	public void editlocalSteps(String user,String pass,String claimid,String localCity,String localtmode,String Lamount,
			String fromplace,String toplace,String LCB,String Lremarks,String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
	{
		
	    TestData.GetData gdata1 = new  TestData.GetData();
		 String  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
			
		 if(Lremarks==null)
			{
			 Lremarks="";
			}
			if(Lamount==null)
			{
				Lamount="";
			}
			
			if(gstn==null)
			{
				gstn="";
			}
			if(cgst==null)
			{
				cgst="";
			}
			if(sgst==null)
			{
				sgst="";
			}
			if(igst==null)
			{
				igst="";
			}
			 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
			 int i=0;
			
			 String userData=array1.get(i);
			 String passData=array1.get(i+1);
			 String empdata=array1.get(i+2);
			 String bandid=array1.get(i+3);
					 
			 String message=array1.get(i+4);
			 
			 System.out.println("This is" +userData);
			 System.out.println("This is" +passData);
			 System.out.println("This is" +empdata);
		 Thread.sleep(10000);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']")); 

			// Now get all the TR elements from the table 
			List<WebElement> allRows = table.findElements(By.tagName("tr")); 
	                          int size=allRows.size();
	                          System.out.println("Row count is"+size);
	                          int sizecell=0;
			// And iterate over them, getting the cells 
			for (WebElement row : allRows) { 
			    List<WebElement> cells = row.findElements(By.tagName("td")); 
			     sizecell=cells.size();
			   
			    // Print the contents of each cell
			    
			}
			 System.out.println("col count is"+sizecell);
			    for( i=2; i<=size;i++)
			    {
			    	
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	if(claim.equalsIgnoreCase(claimid))
			    	{
			    		System.out.println("pass");
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	   
			    	}
			    	
			    	
			    }
			    Thread.sleep(10000);
			    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
			    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
				  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
				 System.out.println(array1);
				 String claimtype= array1.get(1);
				 System.out.println("Claim type status is"+claimtype);
				 
				 if(claimtype.equalsIgnoreCase("0"))
				 {
					 
				
				 JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", EditButton);
//			    String windowHandle = driver.getWindowHandle();
//			    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//			    
//			    ArrayList tabs = new ArrayList (driver.getWindowHandles());
//			    System.out.println(tabs.size());
			   // driver.switchTo().window(windowHandle);
			    
//			   driver.switchTo().window((String) tabs.get(0));
//		      driver.get("zento.in");
	    	    
	    	    
	    	    
	    	    String parent=driver.getWindowHandle();
	    	    Set<String>s1window=driver.getWindowHandles();
	    	    Iterator<String> I1= s1window.iterator();
	    	    while(I1.hasNext())
	    	    {
	    	      String child_window=I1.next();
	    	      if(!parent.equals(child_window))
	    	      {
	    	        driver.switchTo().window(child_window);
	    	        System.out.println(driver.switchTo().window(child_window).getTitle());
	    	        
	    	      }
	    	    }
	    	    
	    	    
				 }
	    	    
	    	    Select s = new Select(Leditclaimtype);
				 s.selectByValue("2");
			    
			
				
				 
//				 Select s = new Select(Leditclaimtype);
//				 s.selectByVisibleText("Local");
					
			    JavascriptExecutor editiconclick = (JavascriptExecutor) driver;
			    editiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		localeditIconclick);
			    Thread.sleep(10000);
			    
			    localinvoiceno.clear();
			    localinvoiceno.sendKeys("45");
			    
			    TestData.GetData citydata = new  TestData.GetData();
				
				 TestData.GetData gdata = new  TestData.GetData();
				
				 ArrayList<String> fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
				 
				 String travelmodeapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetClaimTypeWiseAndBandWiseModeOfTravel?ClaimType="
							+ "LocalClaim&band="+bandid+"&domain="+domain);

					 ArrayList<String> travelmodearray = gdata.parseFromJSONarrayResponse(travelmodeapiresponse);
					 String travelmodedata="";
						String travelmodetext="";
						for(i =0;i<=travelmodearray.size();i++)
						{
							 travelmodedata=travelmodearray.get(i);
							 travelmodetext=travelmodearray.get(i+1);
						
						
						System.out.println("prining travel mode travelmodetext "+travelmodetext);
						System.out.println("prining travel mode localtmode "+localtmode);
						if(localtmode.equalsIgnoreCase(travelmodetext))
				       {
						
						i=travelmodearray.size();
				       }
						}
					
//				 Select s2 = new Select(LocaltravelMode);
//				//	s2.selectByVisibleText(localtmode);
//					s2.selectByValue(travelmodedata);
						userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/PolicyCheck/GetBandWisePolicy?ClaimType=Local&Band="+bandid+"&Domain="+domain);
						   fieldstatusarray = gdata1.parseFromJSONarrayResponse(userresponse1);
						 System.out.println("New documetarry is"+fieldstatusarray);
						
						 String traveldistance="";
							String travelcost="";
						
							String newtravelmode="";
						
						for(i=0;i<=fieldstatusarray.size();i++)
						{
							 newtravelmode=fieldstatusarray.get(i+2);
							
							if(travelmodedata.equalsIgnoreCase(newtravelmode)) {
								
								
								 traveldistance=fieldstatusarray.get(i+1);
								System.out.println("Travel Distance"+traveldistance);
								 travelcost=fieldstatusarray.get(i);
								System.out.println("Travel cost"+travelcost);
//								dateclaimpolicy=fieldstatusarray.get(i+5);
//								System.out.println("dateclaimpolicy"+dateclaimpolicy);
								i=fieldstatusarray.size();
								
							}
							i=i+5;
							 System.out.println("API newtravelmode name is "+newtravelmode);	
							 
						}
						
					
				
					Select s2 = new Select(LocaltravelMode);
					s2.selectByValue(travelmodedata);
					
					
					if(!(Lamount==null))
					{
					if(!(traveldistance.equalsIgnoreCase("0"))&& (!(travelcost.equalsIgnoreCase("0"))))
							{
						distanceval.sendKeys(traveldistance);
						distanceval.sendKeys(Keys.ENTER);
						Thread.sleep(1000);
						double result= ((Double.parseDouble(traveldistance))*(Double.parseDouble(travelcost)));
					System.out.println(result);
					System.out.println(Double.parseDouble(localbillamt.getAttribute("value")));
						assertTrue(result==(Double.parseDouble(localbillamt.getAttribute("value"))));
							}
					
					else if((traveldistance.equalsIgnoreCase("0"))&& ((travelcost.equalsIgnoreCase("0"))))
					{
						localbillamt.sendKeys("100");        
						
					}
					else if((traveldistance.equalsIgnoreCase("0")) && (!(travelcost.equalsIgnoreCase("0"))))
					{
						distanceval.sendKeys("55");
						
						distanceval.sendKeys(Keys.ENTER);
						Thread.sleep(1000);
						double result= (55)*(Double.parseDouble(travelcost));
					System.out.println(result);
					System.out.println(Double.parseDouble(localbillamt.getAttribute("value")));
						assertTrue(result==(Double.parseDouble(localbillamt.getAttribute("value"))));
					}
					else if(!(traveldistance.equalsIgnoreCase("0")) && (travelcost.equalsIgnoreCase("0")))
					{
						System.out.println(".........."+traveldistance);
						distanceval.sendKeys(traveldistance);
						distanceval.sendKeys(Keys.ENTER);
				        
						localbillamt.clear();
						Thread.sleep(1000);
						localbillamt.sendKeys("50");
						
					}
					
					}
					
						
						 citydata = new  TestData.GetData();
						 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
						 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
						 int cityno=0;
						 String citynamefromdata=cityarray1.get(cityno+1);
						// String citynametodata=cityarray1.get(cityno+2);
						 System.out.println("API CIty name is "+citynamefromdata);
						// System.out.println("API CIty name is "+citynametodata);
						
						  s = new Select(LocalcityFrom);
						s.selectByValue(citynamefromdata);
					
						
						if(!(Lamount==null))
						{
							LocaltravelAmount.clear();
							LocaltravelAmount.sendKeys(Lamount);
						}
						LocaluploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
						
						if(!(gstn==null))
						{
							Lgstn.clear();
							Lgstn.sendKeys(gstn);
							
						}
						if(!(cgst==null))
						{
							Lcgst.clear();
							Lcgst.sendKeys(cgst);
						}
						if(!(sgst==null))
						{
							Lsgst.clear();
							Lsgst.sendKeys(sgst);
						}
						if(!(igst==null))
						{
							Ligst.clear();
							Ligst.sendKeys(igst);
						}
						if(!(Lremarks==null))
						{
							Localremarks.clear();
							Localremarks.sendKeys(Lremarks);
						}
						
						if(fromplace==null && toplace==null)
						{
							LocalcityFrom.clear();
							LocalcityTo.clear();
							JavascriptExecutor js9 = (JavascriptExecutor) driver;
						    js9.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
						    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
						    		+ "arguments[0].dispatchEvent(evt);", localeditbutton);
						    
						    System.out.println(Lfrmcityerror.getText());
							assertTrue(Lfrmcityerror.getText().equalsIgnoreCase("Please select from place !"));
							  System.out.println(Ltocityerror.getText());
								assertTrue(Ltocityerror.getText().equalsIgnoreCase("Please select to place !"));
						   
						}
						else
						{
						JavascriptExecutor js9 = (JavascriptExecutor) driver;
					    js9.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
					    		+ "arguments[0].dispatchEvent(evt);", localeditbutton);
//					    Alert alertsuccess = driver.switchTo().alert();
//						String alerttextsuccess1 = driver.switchTo().alert().getText();
//						System.out.println(alerttextsuccess1);
//						assertTrue(alerttextsuccess1.equalsIgnoreCase("Claim Updated successfully"));
//						//alertsuccess.accept();
//						alertsuccess.dismiss();
					    assertTrue((editloocalsuccess.getText()).equalsIgnoreCase("Claim Updated successfully. !"));
	}
	}
    
	public void editotheresteps(String user,String pass,String claimid,String oamount,String location,String othersRemarks,
			String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException

	{
		  TestData.GetData gdata1 = new  TestData.GetData();
			 String  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
				
			 if(othersRemarks==null)
				{
				 othersRemarks="";
				}
				if(oamount==null)
				{
					oamount="";
				}
				if(gstn==null)
				{
					gstn="";
				}
				if(cgst==null)
				{
					cgst="";
				}
				if(sgst==null)
				{
					sgst="";
				}
				if(igst==null)
				{
					igst="";
				}	
			 
			 
			 
				 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
				 int i=0;
				
				 String userData=array1.get(i);
				 String passData=array1.get(i+1);
				 String empdata=array1.get(i+2);
				 String bandid=array1.get(i+3);
						 
				 String message=array1.get(i+4);
				 
				 System.out.println("This is" +userData);
				 System.out.println("This is" +passData);
				 System.out.println("This is" +empdata);
		Thread.sleep(10000);
		//WebDriverWait wait  = new WebDriverWait(driver, 10);
	//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
		// claimidlocator.click();
		 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']")); 

		// Now get all the TR elements from the table 
		List<WebElement> allRows = table.findElements(By.tagName("tr")); 
                          int size=allRows.size();
                          System.out.println("Row count is"+size);
                          int sizecell=0;
		// And iterate over them, getting the cells 
		for (WebElement row : allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 
		     sizecell=cells.size();
		   
		    // Print the contents of each cell
		    
		}
		 System.out.println("col count is"+sizecell);
		    for( i=2; i<=size;i++)
		    {
		    	
		    		
		    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
		    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
		    	System.out.println("This is claim i am looking"+claim);
		    	if(claim.equalsIgnoreCase(claimid))
		    	{
		    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
		    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
		    	    i=size;
		    	}
		    	
		    	
		    }
		    Thread.sleep(5000);
		    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
		    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
			  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
			 System.out.println(array1);
			 String claimtype= array1.get(1);
			 System.out.println("Claim type status is"+claimtype);
			 
			 if(claimtype.equalsIgnoreCase("0"))
			 {
				 
			
			 JavascriptExecutor js3 = (JavascriptExecutor) driver;
    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", EditButton);
//		    String windowHandle = driver.getWindowHandle();
//		    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//		    
//		    ArrayList tabs = new ArrayList (driver.getWindowHandles());
//		    System.out.println(tabs.size());
		   // driver.switchTo().window(windowHandle);
		    
//		   driver.switchTo().window((String) tabs.get(0));
//	      driver.get("zento.in");
    	    
    	    
    	    
    	    String parent=driver.getWindowHandle();
    	    Set<String>s1window=driver.getWindowHandles();
    	    Iterator<String> I1= s1window.iterator();
    	    while(I1.hasNext())
    	    {
    	      String child_window=I1.next();
    	      if(!parent.equals(child_window))
    	      {
    	        driver.switchTo().window(child_window);
    	        System.out.println(driver.switchTo().window(child_window).getTitle());
    	        
    	      }
    	    }
    	    
    	    
			 }
		Select selectclaimtype = new Select(Leditclaimtype);
		selectclaimtype.selectByVisibleText("Other");
		   
	String noename="";
	TestData.GetData gdata = new  TestData.GetData();
	 String noeresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/otherClaim/Get?Domain="+domain);
	

	 ArrayList<String> noearray1 = gdata.parseFromJSONarrayResponse(noeresponse1);
	
	 for(int j=0;j<noearray1.size();j++)
		{
			
			 noename=noearray1.get(j);
			System.out.println("Noe name is:->>>>>>>>>"+noename);
			String noepolicyresponse1 = gdata.getContenxtWeb(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band="+bandid+"&NOE="+noename+"&domain="+domain);
			System.out.println(BaseUrl+"/api/PolicyCheckOtherClaim/GetBandWisePolicy?Band=522&NOE="+noename+"&domain="+domain);
		     System.out.println("noepolicyresponse1"+noepolicyresponse1);
		     
			ArrayList<String> noepolicyarray1 = gdata.parseFromJSONarrayResponse(noepolicyresponse1);
		    System.out.println("noepolicyarray1"+noepolicyarray1);
			//String noename2=noepolicyarray1.get(1);
			//System.out.println("NOE name @@@@2 is ->>>."+noename2);
		 
			if(noepolicyarray1.size()!=0)
			{
				
				   noeactive=noepolicyarray1.get(1);
				   if(!(noeactive.equalsIgnoreCase("false")))
				   {
				    System.out.println("noeactive"+noeactive);
				j=noearray1.size();
				   }
			}
		}
		
	
	System.out.println("Noe with policy defined is ->>>"+noename);
	JavascriptExecutor  editiconclick = (JavascriptExecutor) driver;
	    editiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
	    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
	    		othereditIconclick);
	//TravelexpenseTabclick.click();
	Select s = new Select(NOEelement);
	s.selectByValue(noename);
	Thread.sleep(10000);
	// othersAmount.clear();    
	 OthersInvoiceNo.clear();
	 OthersInvoiceNo.sendKeys("12345");
	
	if(!(location==null))
	{
	otherlocation.clear();
	otherlocation.sendKeys(location);
	}
	
	
//	String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS&domain="+domain);
//	ArrayList<String> wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
//	int wbscount=0;
//	String wbsdata=wbsarray.get(wbscount+4);
//	System.out.println("API wbs mode name is "+wbsdata);
//	Select s4 = new Select(OthersclientBorrower);
//	s4.selectByValue(wbsdata);
	
			if(!(othersRemarks==null))
			{
				Othersremarks.clear();
				Othersremarks.sendKeys(othersRemarks);
			}
			if(!(gstn==null))
			{
				OthersGSTN.clear();
				OthersGSTN.sendKeys(gstn);
			}
			if(!(cgst==null))
			{
				OthersCGST.clear();
				OthersCGST.sendKeys(cgst);
			}
			if(!(igst==null))
			{
				OthersIGST.clear();
				OthersIGST.sendKeys(igst);
			}
			if(!(sgst==null))
			{
				OthersSGSt.clear();
				OthersSGSt.sendKeys(sgst);
			}
			if(!(oamount==null))
			{
				othersAmount.clear();
				othersAmount.sendKeys(oamount);
			}
	OthersuploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
	
	
	if(oamount==null || oamount=="")
	{
		othersAmount.clear();
		
		System.out.println("here inside null");
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
	    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
	    		+ "arguments[0].dispatchEvent(evt);", otherUpdate);
	    
	  
	    
	    System.out.println(otheramterror.getText());
		assertTrue(otheramterror.getText().equalsIgnoreCase("Please enter total bill amount !"));
		
	}
	else
	{
	
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
    		+ "arguments[0].dispatchEvent(evt);", otherUpdate);
//    Alert alertsuccess = driver.switchTo().alert();
//	String alerttextsuccess1 = driver.switchTo().alert().getText();
//	System.out.println(alerttextsuccess1);
//	assertTrue(alerttextsuccess1.equalsIgnoreCase("Claim updated successfully"));
//	alertsuccess.accept();
    assertTrue((editothersuccess.getText()).equalsIgnoreCase("Claim updated successfully !"));
	}
	}
	
	public void editmobilesteps(String user,String pass,String claimid,String mamount,String CB,String mRemarks,String domain, String gstn,String cgst, String sgst, String igst,String mnum) throws InterruptedException

	{TestData.GetData gdata1 = new  TestData.GetData();
	 String  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
		
	 if(mRemarks==null)
		{
		 	mRemarks="";
		}
		if(mamount==null)
		{
			mamount="";
		}
//		if(mnum==null)
//		{
//			mnum="";
//		}
		if(gstn==null)
		{
			gstn="";
		}
		if(cgst==null)
		{
			cgst="";
		}
		if(sgst==null)
		{
			sgst="";
		}
		if(igst==null)
		{
			igst="";
		}
	 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
	 int i=0;
	
	 String userData=array1.get(i);
	 String passData=array1.get(i+1);
	 String empdata=array1.get(i+2);
	 String bandid=array1.get(i+3);
			 
	 String message=array1.get(i+4);
	 
	 System.out.println("This is" +userData);
	 System.out.println("This is" +passData);
	 System.out.println("This is" +empdata);
		
		 Thread.sleep(10000);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']")); 

			// Now get all the TR elements from the table 
			List<WebElement> allRows = table.findElements(By.tagName("tr")); 
	                          int size=allRows.size();
	                          System.out.println("Row count is"+size);
	                          int sizecell=0;
			// And iterate over them, getting the cells 
			for (WebElement row : allRows) { 
			    List<WebElement> cells = row.findElements(By.tagName("td")); 
			     sizecell=cells.size();
			   
			    // Print the contents of each cell
			    
			}
			 System.out.println("col count is"+sizecell);
			    for( i=2; i<=size;i++)
			    {
			    	
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    	String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	if(claim.equalsIgnoreCase(claimid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    
//			    JavascriptExecutor editiconclick = (JavascriptExecutor) driver;
//			    editiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
//			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
//			    		editIconMobileclick);
			    Thread.sleep(10000);
			    gdata1 = new  TestData.GetData();
			    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
			     userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
			     array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
				 System.out.println(array1);
				 String claimtype= array1.get(1);
				 System.out.println("Claim type status is"+claimtype);
				 
				 if(claimtype.equalsIgnoreCase("0"))
				 {
					 
				
				 JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", EditButton);
//			    String windowHandle = driver.getWindowHandle();
//			    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//			    
//			    ArrayList tabs = new ArrayList (driver.getWindowHandles());
//			    System.out.println(tabs.size());
			   // driver.switchTo().window(windowHandle);
			    
//			   driver.switchTo().window((String) tabs.get(0));
//		      driver.get("zento.in");
	    	    
	    	    
	    	    
	    	    String parent=driver.getWindowHandle();
	    	    Set<String>s1window=driver.getWindowHandles();
	    	    Iterator<String> I1= s1window.iterator();
	    	    while(I1.hasNext())
	    	    {
	    	      String child_window=I1.next();
	    	      if(!parent.equals(child_window))
	    	      {
	    	        driver.switchTo().window(child_window);
	    	        System.out.println(driver.switchTo().window(child_window).getTitle());
	    	        
	    	      }
	    	    }
	    	    
	    	    
				 }
	    	    Select s = new Select(Leditclaimtype);
				 s.selectByVisibleText("Mobile");
				 
				 JavascriptExecutor editiconclick = (JavascriptExecutor) driver;
				    editiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
				    		editIconMobileclick);
				    
				
			    mobileremarks.clear();
			    mobileAmount.clear();
		TestData.GetData gdata = new  TestData.GetData();
		
//		String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
//		ArrayList<String> wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
//		int wbscount=0;
//		String wbsdata=wbsarray.get(wbscount+4);
//		System.out.println("API wbs mode name is "+wbsdata);
//		Select s4 = new Select(mobileclientBorrower);
//		s4.selectByValue(wbsdata);
		
		editInvoiceno.clear();
		editInvoiceno.sendKeys("1");
		
		if(!(gstn==null))
		{
		mgstn.clear();
		mgstn.sendKeys(gstn);
		}
		if(!(cgst==null))
		{
		mcgst.clear();
		mcgst.sendKeys(cgst);
		}
		if(!(sgst==null))
		{
		msgst.clear();
		msgst.sendKeys(sgst);
		}
		if(!(igst==null))
		{
		migst.clear();
		migst.sendKeys(igst);
		}
		
		if(!(mRemarks==null))
		{
			mobileremarks.clear();
			mobileremarks.sendKeys(mRemarks);
			Thread.sleep(5000);
		}
		if(!(mnum==null))
		{
			mobnum.clear();
			mobnum.sendKeys(mnum);
		}
		mobileAmount.sendKeys(mamount);
		mobileuploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
		
		if((mamount==null || mamount=="")&& (mnum==null))
		{
			mobileAmount.clear();
			mobnum.clear();
			System.out.println("here inside null");
			JavascriptExecutor js9 = (JavascriptExecutor) driver;
		    js9.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
		    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
		    		+ "arguments[0].dispatchEvent(evt);", mobileupdate);
		    
		  		    
		    System.out.println(mobileamterror.getText());
			assertTrue(mobileamterror.getText().equalsIgnoreCase("Please enter total bill amount !"));
			  System.out.println(moberrormsg.getText());
				assertTrue(moberrormsg.getText().equalsIgnoreCase("Please enter valid mobile number !"));
			
			
			
		}
		else
		{
		
		JavascriptExecutor js9 = (JavascriptExecutor) driver;
	    js9.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
	    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
	    		+ "arguments[0].dispatchEvent(evt);", mobileupdate);
//	    Alert alertsuccess = driver.switchTo().alert();
//		String alerttextsuccess1 = driver.switchTo().alert().getText();
//		System.out.println(alerttextsuccess1);
//		assertTrue(alerttextsuccess1.equalsIgnoreCase("Claim Updated successfully"));
//		//alertsuccess.accept();
//		alertsuccess.dismiss();
	    assertTrue((editmobilesuccess.getText()).equalsIgnoreCase("Claim updated successfully !"));

	}
	}

	public void edithotelSteps(String user,String pass,String claimid,String hamount,String CB,String hRemarks,String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
	{
		
		 if(hRemarks==null)
			{
			 hRemarks="";
			}
			if(hamount==null)
			{
				hamount="";
			}
//			if(mnum==null)
//			{
//				mnum="";
//			}
			if(gstn==null)
			{
				gstn="";
			}
			if(cgst==null)
			{
				cgst="";
			}
			if(sgst==null)
			{
				sgst="";
			}
			if(igst==null)
			{
				igst="";
			}
			
			
		 TestData.GetData gdata1 = new  TestData.GetData();
		 String  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
			
			
			 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
			 int i=0;
			
			 String userData=array1.get(i);
			 String passData=array1.get(i+1);
			 String empdata=array1.get(i+2);
			 String bandid=array1.get(i+3);
					 
			 String message=array1.get(i+4);
			 
			 System.out.println("This is" +userData);
			 System.out.println("This is" +passData);
			 System.out.println("This is" +empdata);
		 Thread.sleep(10000);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']")); 

			// Now get all the TR elements from the table 
			List<WebElement> allRows = table.findElements(By.tagName("tr")); 
	                          int size=allRows.size();
	                          System.out.println("Row count is"+size);
	                          int sizecell=0;
			// And iterate over them, getting the cells 
			for (WebElement row : allRows) { 
			    List<WebElement> cells = row.findElements(By.tagName("td")); 
			     sizecell=cells.size();
			   
			    // Print the contents of each cell
			    
			}
			 System.out.println("col count is"+sizecell);
			    for( i=2; i<=size;i++)
			    {
			    	
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	
//			    	if(claim.equalsIgnoreCase(claimid))
//			    	{
//			    		System.out.println("pass");
//			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
//			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
//			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
//			    	    i=size;
//			    	   
//			    	}
//			    	
//			    	
//			    }
			    	
			    	if(claim.equalsIgnoreCase(claimid))
			    	{
			    		System.out.println("pass");
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	    
			    	}
			    	
			    }
			    	Thread.sleep(10000);
			    	gdata1 = new  TestData.GetData();
				    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
				     userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
				     array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
					 System.out.println(array1);
					 String claimtype= array1.get(1);
					 System.out.println("Claim type status is"+claimtype);
					 
					 if(claimtype.equalsIgnoreCase("0"))
					 {
						 
					
					 JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", EditButton);
//				    String windowHandle = driver.getWindowHandle();
//				    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//				    
//				    ArrayList tabs = new ArrayList (driver.getWindowHandles());
//				    System.out.println(tabs.size());
				   // driver.switchTo().window(windowHandle);
				    
//				   driver.switchTo().window((String) tabs.get(0));
//			      driver.get("zento.in");
		    	    
		    	    
		    	    
		    	    String parent=driver.getWindowHandle();
		    	    Set<String>s1window=driver.getWindowHandles();
		    	    Iterator<String> I1= s1window.iterator();
		    	    while(I1.hasNext())
		    	    {
		    	      String child_window=I1.next();
		    	      if(!parent.equals(child_window))
		    	      {
		    	        driver.switchTo().window(child_window);
		    	        System.out.println(driver.switchTo().window(child_window).getTitle());
		    	        
		    	      }
		    	    }
		    	    
		    	    
					 }
		    	    Select s = new Select(Leditclaimtype);
					 s.selectByVisibleText("Hotel");
				    
			    	
			    	
			    
			    Thread.sleep(10000);
			    JavascriptExecutor editiconclick = (JavascriptExecutor) driver;
			    editiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		editIconHotelclick);
			    Thread.sleep(10000);
			    HInvoiceNo.clear();
			    HInvoiceNo.sendKeys("45");
			    Hgstn.clear();
			    Hgstn.sendKeys(gstn);
			    Hcgst.clear();
			    Hcgst.sendKeys(cgst);
			    Hsgst.clear();
			    Hsgst.sendKeys(sgst);
			    Higst.clear();
			    Higst.sendKeys(igst);
			    
//			    TestData.GetData gdata1 = new  TestData.GetData();
//				 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+""+"&domain="+domain);
//				
//			
//				 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
//				 int i=0;
//				
//				 String userData=array1.get(i);
//				 String passData=array1.get(i+1);
//				 String empdata=array1.get(i+2);
//				 String bandid=array1.get(i+3);
//						 
//				 String message=array1.get(i+4);
//				 
//				 System.out.println("This is" +userData);
//				 System.out.println("This is" +passData);
//				 System.out.println("This is" +empdata);
				 

					TestData.GetData citydata = new  TestData.GetData();
					 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
					
				
					 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
					 int cityno=0;
					
					 String citynamefromdata=cityarray1.get(cityno+1);
					
					 System.out.println("API CIty name is "+citynamefromdata);
					
			     s = new Select(hotelCity);
				s.selectByValue(citynamefromdata);
				
				
				TestData.GetData gdata = new  TestData.GetData();
				
			//	hotelAmount.clear();
				
				
//				String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
//				ArrayList<String> wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
//				int wbscount=0;
//				String wbsdata=wbsarray.get(wbscount+4);
//				System.out.println("API wbs mode name is "+wbsdata);
//				Select s4 = new Select(hotelclientBorrower);
//				s4.selectByValue(wbsdata);
				hotelremarks.clear();
				hotelremarks.sendKeys(hRemarks);
				//hotelAmount.sendKeys(hamount);
				hoteluploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
				if(hamount==null || hamount=="")
				{
					
					hotelAmount.clear();
					 System.out.println(hotelamterror.getText());
					assertTrue(hotelamterror.getText().equalsIgnoreCase("Please enter total bill amount !"));
				}
				else {
				
				JavascriptExecutor js9 = (JavascriptExecutor) driver;
			    js9.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
			    		+ "arguments[0].dispatchEvent(evt);", hotelUpdatebutton);
//			    Alert alert1 = driver.switchTo().alert();
//				String alerttext1 = driver.switchTo().alert().getText();
//				System.out.println(alerttext1);
//				assertTrue(alerttext1.equalsIgnoreCase("Claim Updated successfully"));
//				alert1.accept();
			    assertTrue((edithotelsuccess.getText()).equalsIgnoreCase("Claim updated successfully. !"));

	}
	}

	public void editfoodSteps(String user,String pass,String claimid,String famount,
			String CB,String foodRemarks, String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
	{
		
		 TestData.GetData gdata1 = new  TestData.GetData();
		 String  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
			
			
			 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
			 int i=0;
			
			 String userData=array1.get(i);
			 String passData=array1.get(i+1);
			 String empdata=array1.get(i+2);
			 String bandid=array1.get(i+3);
					 
			 String message=array1.get(i+4);
			 
			 System.out.println("This is" +userData);
			 System.out.println("This is" +passData);
			 System.out.println("This is" +empdata);
		 Thread.sleep(10000);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']")); 

			// Now get all the TR elements from the table 
			List<WebElement> allRows = table.findElements(By.tagName("tr")); 
	                          int size=allRows.size();
	                          System.out.println("Row count is"+size);
	                          int sizecell=0;
			// And iterate over them, getting the cells 
			for (WebElement row : allRows) { 
			    List<WebElement> cells = row.findElements(By.tagName("td")); 
			     sizecell=cells.size();
			   
			    // Print the contents of each cell
			    
			}
			 System.out.println("col count is"+sizecell);
			    for( i=2; i<=size;i++)
			    {
			    	
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    	String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	if(claim.equalsIgnoreCase(claimid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    }
			     gdata1 = new  TestData.GetData();
			    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
			     userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
			     array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
				 System.out.println(array1);
				 String claimtype= array1.get(1);
				 System.out.println("Claim type status is"+claimtype);
				 
				 if(claimtype.equalsIgnoreCase("0"))
				 {
					 
				
				 JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", EditButton);
//			    String windowHandle = driver.getWindowHandle();
//			    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//			    
//			    ArrayList tabs = new ArrayList (driver.getWindowHandles());
//			    System.out.println(tabs.size());
			   // driver.switchTo().window(windowHandle);
			    
//			   driver.switchTo().window((String) tabs.get(0));
//		      driver.get("zento.in");
	    	    
	    	    
	    	    
	    	    String parent=driver.getWindowHandle();
	    	    Set<String>s1window=driver.getWindowHandles();
	    	    Iterator<String> I1= s1window.iterator();
	    	    while(I1.hasNext())
	    	    {
	    	      String child_window=I1.next();
	    	      if(!parent.equals(child_window))
	    	      {
	    	        driver.switchTo().window(child_window);
	    	        System.out.println(driver.switchTo().window(child_window).getTitle());
	    	        
	    	      }
	    	    }
	    	    
	    	    
				 }
		    	     Select s = new Select(editclaimtype);
					 //s.selectByVisibleText("Food");
					 s.selectByValue("7");
					
			    	
			    
			    Thread.sleep(10000);
			    JavascriptExecutor editiconclick = (JavascriptExecutor) driver;
			    editiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		editIconFoodclick);
			    Thread.sleep(10000);
//			    TestData.GetData gdata1 = new  TestData.GetData();
//				 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+""+"&domain"+domain);
//				
			
//				 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
//				 int i=0;
				
//				 String userData=array1.get(i);
//				 String passData=array1.get(i+1);
//				 String empdata=array1.get(i+2);
//				 String bandid=array1.get(i+3);
//						 
//				 String message=array1.get(i+4);
				 
//				 System.out.println("This is" +userData);
//				 System.out.println("This is" +passData);
//				 System.out.println("This is" +empdata);
//				 
			    gdata1 = new  TestData.GetData();
//				 String userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+""+"&domain"+domain);
//				
			
//				 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
//				 int i=0;
				
//				 String userData=array1.get(i);
//				 String passData=array1.get(i+1);
//				 String empdata=array1.get(i+2);
//				 String bandid=array1.get(i+3);
//						 
//				 String message=array1.get(i+4);
				 
//				 System.out.println("This is" +userData);
//				 System.out.println("This is" +passData);
//				 System.out.println("This is" +empdata);
//				 

			    FInvoiceNo.clear();
			    FInvoiceNo.sendKeys("55");
					TestData.GetData citydata = new  TestData.GetData();
					 String cityresponse1 = citydata.getContenxtWeb(BaseUrl+"/api/travelclaim/GetCityDataList?domain="+domain);
					
				
					 ArrayList<String> cityarray1 = citydata.parseFromJSONarrayResponse(cityresponse1);
					 int cityno=0;
					
					 String citynamefromdata=cityarray1.get(cityno+1);
					
					 System.out.println("API CIty name is "+citynamefromdata);
					 
			    Select sfoodcity = new Select(foodCity);
			    sfoodcity.selectByValue(citynamefromdata);
				
				

				TestData.GetData gdata = new  TestData.GetData();
				String foodid="";
				String ftypename="";
				String foodtypeapiresponse = gdata.getContenxtWeb(BaseUrl+"/api/FoodClaim/GetFoodType?domain="+domain);
				ArrayList<String> foodTypeyarray1 = gdata.parseFromJSONarrayResponse(foodtypeapiresponse);
				for(int fsize=0;fsize<foodTypeyarray1.size();fsize++)
				{
					
					
					
					//String noename2=noepolicyarray1.get(1);
					//System.out.println("NOE name @@@@2 is ->>>."+noename2);
					
					foodid = foodTypeyarray1.get(fsize);
					System.out.println("Food Id is ->>>>>>>>"+foodid);
					String foodidactive= foodTypeyarray1.get(fsize+1);
					System.out.println("Food Id status is  ->>>>>>>>"+foodidactive);
					if(foodidactive.equalsIgnoreCase("True"))
					{
						fsize=foodTypeyarray1.size();
						System.out.println("Break");
					}
				}
				
				System.out.println("Food Id is ->>>>>>>>"+foodid);
				if(!domain.equalsIgnoreCase("lechler"))
				{
				Select selectfoodType = new Select(foodTypeelement);
				selectfoodType.selectByValue(foodid);
				
//
//					Thread.sleep(1000);
					//foodAmount.clear();
//					 Select s1 = new Select(foodTypeelement);
//						s1.selectByValue(foodid);
					
					fgstn.clear();				
					fgstn.sendKeys(gstn);
					fcgst.getClass();
					fcgst.sendKeys(cgst);
					fsgst.clear();
					fsgst.sendKeys(sgst);
					figst.clear();
					figst.sendKeys(igst);
				}
				if(!(foodRemarks==null))
				{
					foodremarks.clear();
					foodremarks.sendKeys(foodRemarks);
				}
					//foodAmount.sendKeys(famount);
				
				if(famount==null)
				{
					foodAmount.clear();

					fooduploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
					JavascriptExecutor	 js3 = (JavascriptExecutor) driver;
				    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
				    		+ "arguments[0].dispatchEvent(evt);", foodupdatebutton);
				    
				    System.out.println(foodamterror.getText());
					assertTrue(foodamterror.getText().equalsIgnoreCase("Please enter total bill amount !"));
					 
					
				    
				}
				else
				{
					fooduploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
					JavascriptExecutor	 js3 = (JavascriptExecutor) driver;
				    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
				    		+ "arguments[0].dispatchEvent(evt);", foodupdatebutton);
//				    Alert alert1 = driver.switchTo().alert();
//					String alerttext1 = driver.switchTo().alert().getText();
//					System.out.println(alerttext1);
//					assertTrue(alerttext1.equalsIgnoreCase("Claim Updated successfully"));
//					alert1.accept();
				    
				    assertTrue((editfoodsuccess.getText()).equalsIgnoreCase("Claim updated successfully. !"));

			  
	}

	}
	
	public void editlandlinesteps(String user,String pass,String claimid,String mamount,String CB,String mRemarks,String domain, String gstn, String cgst, String sgst, String igst) throws InterruptedException

	{
		if(mRemarks==null)
		{
			mRemarks="";
		}
		if(mamount==null)
		{
			mamount="";
		}
		if(gstn==null)
		{
			gstn="";
		}
		if(cgst==null)
		{
			cgst="";
		}
		if(sgst==null)
		{
			sgst="";
		}
		if(igst==null)
		{
			igst="";
		}
		 TestData.GetData gdata1 = new  TestData.GetData();
		 String  userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+user+"&PWD="+pass+"&domain="+domain);
			
			
			 ArrayList<String> array1 = gdata1.parseFromJSONResponse(userresponse1);
			 int i=0;
			
			 String userData=array1.get(i);
			 String passData=array1.get(i+1);
			 String empdata=array1.get(i+2);
			 String bandid=array1.get(i+3);
					 
			 String message=array1.get(i+4);
			 
			 System.out.println("This is" +userData);
			 System.out.println("This is" +passData);
			 System.out.println("This is" +empdata);
		
		 Thread.sleep(10000);
			//WebDriverWait wait  = new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.visibilityOf(claimidlocator));
			// claimidlocator.click();
			 WebElement table = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']")); 

			// Now get all the TR elements from the table 
			List<WebElement> allRows = table.findElements(By.tagName("tr")); 
	                          int size=allRows.size();
	                          System.out.println("Row count is"+size);
	                          int sizecell=0;
			// And iterate over them, getting the cells 
			for (WebElement row : allRows) { 
			    List<WebElement> cells = row.findElements(By.tagName("td")); 
			     sizecell=cells.size();
			   
			    // Print the contents of each cell
			    
			}
			 System.out.println("col count is"+sizecell);
			    for( i=2; i<=size;i++)
			    {
			    	
			    		
			    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
			    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
			    	System.out.println("This is claim i am looking"+claim);
			    	if(claim.equalsIgnoreCase(claimid))
			    	{
			    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
			    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", claimidclick);
			    	    i=size;
			    	}
			    	
			    	
			    }
			    
			    
			    Thread.sleep(1000);
			    System.out.println(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&Month=7&Year=2019&Week=0&sortby=CLAIMID&Domain="+domain);
			    userresponse1 = gdata1.getContenxtWeb(BaseUrl+"/api/dashboard/GetClaim?EmpId="+empdata+"&month="+((current.get(Calendar.MONTH)+1))+"&year="+current.get(Calendar.YEAR)+"&Week=0&sortby=CLAIMID&Domain="+domain);
				  array1 = gdata1.parseFromJSONarrayResponse(userresponse1);
				 System.out.println(array1);
				 String claimtype= array1.get(1);
				 System.out.println("Claim type status is"+claimtype);
				 
				 if(claimtype.equalsIgnoreCase("0"))
				 {
					 
				
				 JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", EditButton);
//			    String windowHandle = driver.getWindowHandle();
//			    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//			    
//			    ArrayList tabs = new ArrayList (driver.getWindowHandles());
//			    System.out.println(tabs.size());
			   // driver.switchTo().window(windowHandle);
			    
//			   driver.switchTo().window((String) tabs.get(0));
//		      driver.get("zento.in");
	    	    
	    	    
	    	    
	    	    String parent=driver.getWindowHandle();
	    	    Set<String>s1window=driver.getWindowHandles();
	    	    Iterator<String> I1= s1window.iterator();
	    	    while(I1.hasNext())
	    	    {
	    	      String child_window=I1.next();
	    	      if(!parent.equals(child_window))
	    	      {
	    	        driver.switchTo().window(child_window);
	    	        System.out.println(driver.switchTo().window(child_window).getTitle());
	    	        
	    	      }
	    	    }
	    	    
	    	    
				 }
	    	     Select s = new Select(editclaimtype);
				 //s.selectByVisibleText("Food");
				 s.selectByVisibleText("LandLine");
				
		    	
			    
			    
			    
			    JavascriptExecutor editiconclick = (JavascriptExecutor) driver;
			    editiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		editIconLandlineclick);
			    Thread.sleep(10000);
			    
		
		
		
	
		Thread.sleep(10000);
		if(!(mamount==null))
		{
		landlineAmount.clear();
		landlineAmount.sendKeys(mamount);
		}
		if(!(mRemarks==null))
		{
		landlineremarks.clear();
		landlineremarks.sendKeys(mRemarks);
		}
		
		
		
//		TestData.GetData gdata = new  TestData.GetData();
//		
//		String wbsapiresponse= gdata.getContenxtWeb(BaseUrl+"/api/TravelClaim/GetMasterDataList?MasterType=WBS");
//		ArrayList<String> wbsarray = gdata.parseFromJSONarrayResponse(wbsapiresponse);
//		int wbscount=0;
//		String wbsdata=wbsarray.get(wbscount+4);
//		System.out.println("API wbs mode name is "+wbsdata);
//		Select s4 = new Select(landlineclientBorrower);
//		s4.selectByValue(wbsdata);
	
		
		
		
		landlineuploadFile.sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
		landlinegstn.clear();
		landlinegstn.sendKeys(gstn);
		
		Thread.sleep(500);
		if(mamount==null || mamount=="")
		{
			landlineAmount.clear();
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
	    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
	    		+ "arguments[0].dispatchEvent(evt);", landlinesaveDraft);
	    
	    System.out.println(landlineamterror.getText());
		assertTrue(landlineamterror.getText().equalsIgnoreCase("Please enter total bill amount !"));
//	    Alert alertsuccess = driver.switchTo().alert();
//		String alerttextsuccess1 = driver.switchTo().alert().getText();
//		System.out.println(alerttextsuccess1);
//		assertTrue(alerttextsuccess1.equalsIgnoreCase("Claim updated successfully"));
//		alertsuccess.accept();
		}
		else {
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
		    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" 
		    		+ "arguments[0].dispatchEvent(evt);", landlinesaveDraft);
		

	    assertTrue((editlandlinesuccess.getText()).equalsIgnoreCase("Claim updated successfully. !"));
	}
	}
}
