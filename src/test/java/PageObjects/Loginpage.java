package PageObjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Browsers.Open_Browser;
import Browsers.Urls;
import Data.capturePostAPIData;

public class Loginpage extends Urls{
	String EmployeeuserName=null;
	   String EmployeepassWord=null;
	   String emailId=null;
	   String FPassword=null;
	   String APIBody="";
	   String responseflag="";
	   String message="";
		ArrayList<String> array = new ArrayList<String>();
	PostAPIPage postapi = new PostAPIPage();
	WebDriver driver;
		capturePostAPIData postapidata= new capturePostAPIData();
	  Open_Browser open= new Open_Browser(driver);

	String url=null;
	public Loginpage(WebDriver driver){
		
		this.driver=driver;
		
	}
	@FindBy(xpath=".//*[@id='txtUserName']")
	WebElement username;
	@FindBy(xpath=".//*[@id='txtPassword']")
	WebElement password;
	@FindBy(xpath=".//*[@id='txtAdminUserName']")
	WebElement adminusername;
	@FindBy(xpath=".//*[@id='txtAdminPassword']")
	WebElement adminpassword;
	@FindBy(xpath=".//*[@id='btnLogin']")
	WebElement loginButton;

	@FindBy(xpath=".//*[@id='content-header']/div/h1")
	WebElement dashboardtext;
	@FindBy(xpath=".//*[@id='ctl00_lblUsrNm']")
	WebElement logoutDropdown;
	@FindBy(xpath=".//*[@id='header-nav']/ul/li/ul/li[3]/a")
	WebElement logoutbutton;
	@FindBy(xpath=".//*[@id='lblMsg']")
	WebElement NOnRegisterError;
	@FindBy(css="#lblMsg")
	WebElement passIncorrect;
	//Forgot password 
	@FindBy(xpath=".//*[@id='LinkButton1']")
	WebElement FpasswordLink;
	@FindBy(xpath=".//*[@id='txtForPass1']")
	WebElement REmailId;
	@FindBy(xpath=".//*[@id='btnUpdate']")
	WebElement FpassButton;
	@FindBy(xpath=".//*[@id='RequiredFieldValidator14']")
	WebElement EnterEmailError;
	@FindBy(xpath=".//*[@id='RegularExpressionValidator1']")
	WebElement InvalidEmailError;
	@FindBy(xpath=".//*[@id='ddlClient']")
	WebElement Selectdomain;
	@FindBy(xpath=".//*[@id='ddlDomain']")
	WebElement Selectadmindomain;
	@FindBy(xpath="//*[@id=\"txtDomainName\"]")
	WebElement domainname;
	@FindBy(xpath="//*[@id=\"ddlDomain\"]")
	WebElement domainname2;
	
	
	
	
	
	
	//Login 
	public void Login(String EmployeeuserName,String EmployeepassWord,String domain) throws InterruptedException{
		
		
if(!(EmployeeuserName==null)  && !(EmployeepassWord==null))
			
		{
	url=open.urlpath();
	System.out.println(url);

	if(url.equalsIgnoreCase("https://demo.zento.in/")) {
		domainname.sendKeys("demo");
		
	}
	if(url.equalsIgnoreCase("http://203.192.228.227:90"))
	{
		
		System.out.println(">>>>>>>Domain is"+domain);
		Select selectdomain = new Select(Selectdomain);
		selectdomain.selectByVisibleText(domain);
		
	}
	
//	Select sdomain = new Select(Selectdomain);
//	sdomain.selectByValue(domain);
	System.out.println("baseurl is"+BaseUrl);
			TestData.GetData gdata = new  TestData.GetData();
			 System.out.println(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+"&domain="+domain);
			 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+"&domain="+domain);
			
		
			 ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
			 System.out.println("This is login array" +array);
			 int i=0;
			
			 String userData=array.get(i);
			 String passData=array.get(i+1);
			 String empdata=array.get(i+2);
			 String message=array.get(i+5);
			 
			 System.out.println("This is" +userData);
			 System.out.println("This is" +passData);
			 System.out.println("This is" +empdata);
			 System.out.println("This is" +message);
			 System.out.println("I am here");
	
			if(EmployeeuserName.equalsIgnoreCase(userData)&& EmployeepassWord.equalsIgnoreCase(passData))
			{
				 
				
			username.sendKeys(EmployeeuserName);
		
			password.sendKeys(EmployeepassWord);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			Thread.sleep(400);
	         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
			System.out.println("here");
			
			}else{
				if(message.equalsIgnoreCase("USER DOES NOT EXISTS."))
				{
					username.clear();
				username.sendKeys(EmployeeuserName);
				password.clear();
				password.sendKeys(EmployeepassWord);
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				
		        js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
				//loginButton.click();
				Thread.sleep(400);
				String nousererrorText= NOnRegisterError.getText();
				System.out.println(nousererrorText);
				assertTrue(nousererrorText.equalsIgnoreCase("USER DOES NOT EXISTS."));
				}
				//if(pass!=)
				if(message.equalsIgnoreCase("PASSWORD INCORRECT."))
				{
					
					System.out.println("inside password incorrect");
					username.clear();
					username.sendKeys(EmployeeuserName);
					password.clear();
					password.sendKeys(EmployeepassWord);
					JavascriptExecutor js1 = (JavascriptExecutor) driver;
					
			         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
			         Thread.sleep(400);
					String IPasswordText= passIncorrect.getText();
					System.out.println("message is"+IPasswordText);
					assertTrue(IPasswordText.equalsIgnoreCase("PASSWORD INCORRECT. !"));
				
				}
			}
		}else
		if(EmployeeuserName==null   || EmployeepassWord==null)
		{
			if( EmployeeuserName==null)
			{
				//username.sendKeys(user);
				password.sendKeys(EmployeepassWord);
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				
		         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
		         Thread.sleep(400);
				System.out.println("here");
			}
			if( EmployeepassWord==null)
			{
				System.out.println("in pass");
				username.clear();
				username.sendKeys(EmployeeuserName);
				//password.sendKeys(pass);
				//driver.hideKeyboard();
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				
		         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
		         Thread.sleep(400);
		         System.out.println("here");
			}
		}
		
	
		}
	
	
	
	
	public void LoginPostAPI(String EmployeeuserName,String EmployeepassWord,String domain) throws InterruptedException{
		
		
		if(!(EmployeeuserName==null)  && !(EmployeepassWord==null))
					
				{
//			String domain="redchillies";
			Select sdomain = new Select(Selectdomain);
			sdomain.selectByValue(domain);
			
					TestData.GetData gdata = new  TestData.GetData();
					 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+"&domain="+domain);
					
				
					 ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
					 int i=0;
					
					 String userData=array.get(i);
					 String passData=array.get(i+1);
					 String empdata=array.get(i+2);
					 String message=array.get(i+3);
					 
					 System.out.println("This is" +userData);
					 System.out.println("This is" +passData);
					 System.out.println("This is" +empdata);
					 System.out.println("I am here");
					
					if(EmployeeuserName.equalsIgnoreCase(userData)&& EmployeepassWord.equalsIgnoreCase(passData))
					{
						 
						
					username.sendKeys(EmployeeuserName);
				
					password.sendKeys(EmployeepassWord);
					JavascriptExecutor js1 = (JavascriptExecutor) driver;
					Thread.sleep(400);
			         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
					System.out.println("here");
					
					}else{
						if(message.equalsIgnoreCase("USER DOES NOT EXISTS."))
						{
							username.clear();
						username.sendKeys(EmployeeuserName);
						password.clear();
						password.sendKeys(EmployeepassWord);
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						
				        js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
						//loginButton.click();
						Thread.sleep(400);
						String nousererrorText= NOnRegisterError.getText();
						System.out.println(nousererrorText);
						assertTrue(nousererrorText.equalsIgnoreCase("USER DOES NOT EXISTS."));
						}
						//if(pass!=)
						if(message.equalsIgnoreCase("PASSWORD INCORRECT."))
						{
							username.clear();
							username.sendKeys(EmployeeuserName);
							password.clear();
							password.sendKeys(EmployeepassWord);
							JavascriptExecutor js1 = (JavascriptExecutor) driver;
							
					         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
					         Thread.sleep(400);
							String IPasswordText= passIncorrect.getText();
							System.out.println("message is"+IPasswordText);
							assertTrue(IPasswordText.equalsIgnoreCase("PASSWORD INCORRECT."));
						
						}
					}
				}else
				if(EmployeeuserName==null   || EmployeepassWord==null)
				{
					if( EmployeeuserName==null)
					{
					
						password.sendKeys(EmployeepassWord);
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						
				         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
				         Thread.sleep(400);
						System.out.println("here");
					}
					if( EmployeepassWord==null)
					{
						System.out.println("in pass");
						username.clear();
						username.sendKeys(EmployeeuserName);
						
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						
				         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
				         Thread.sleep(400);
				         System.out.println("here");
					}
				}
				
			
				}
	public void logout(){
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", logoutDropdown);
		
	    JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", logoutbutton);
		
		
	}
	
	public void adminLogin(String EmployeeuserName,String EmployeepassWord,String domain) throws InterruptedException{
		
		System.out.println("domain"+domain);
		System.out.println("adminurl"+adminurl);
		if(!(EmployeeuserName==null)  && !(EmployeepassWord==null))
					
				{

			if((adminurl.equalsIgnoreCase("https://demoadmin.zento.in/") ||  adminurl.equalsIgnoreCase("http://demoadmin.zento.in//default.aspx")))
			{
				System.out.println("Inside adminurl if case");
				domainname.sendKeys("demoadmin");
				domainname.sendKeys(Keys.ENTER);
			}
			
			
			if(adminurl.equalsIgnoreCase("http://192.168.1.102:91/default.aspx") && (domain.equalsIgnoreCase("CoreZento")))
			{
				System.out.println("Inside adminur 2");
				Select selectdomain = new Select(domainname2);
				selectdomain.selectByVisibleText(domain);
						
			}else if(adminurl.equalsIgnoreCase("http://192.168.1.102:91/default.aspx"))   
					{
				System.out.println("Inside adminur 3");
				Select selectdomain = new Select(domainname2);
				selectdomain.selectByVisibleText(domain);
					}
//			Select sdomain = new Select(Selectadmindomain);
//			sdomain.selectByVisibleText(domain);
			
					
					Thread.sleep(1000);
					 String userData="admin";
					 String passData="Zento123";
					 
					
					if(EmployeeuserName.equalsIgnoreCase(userData)&& EmployeepassWord.equalsIgnoreCase(passData))
					{
						 
						Thread.sleep(1000);
						adminusername.sendKeys(EmployeeuserName);
						
						adminpassword.sendKeys(EmployeepassWord);
					JavascriptExecutor js1 = (JavascriptExecutor) driver;
					Thread.sleep(400);
			         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
					System.out.println("here");
					
					}
				}else
				if(EmployeeuserName==null   || EmployeepassWord==null)
				{
					if( EmployeeuserName==null)
					{
						
						adminpassword.sendKeys(EmployeepassWord);
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						
				         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
				         Thread.sleep(400);
						System.out.println("here");
					}
					if( EmployeepassWord==null)
					{
						System.out.println("in pass");
						adminusername.clear();
						adminusername.sendKeys(EmployeeuserName);
						
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						
				         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
				         Thread.sleep(400);
				         System.out.println("here");
					}
				}
				
			
				}
	
	//Forgot password function
	public void FSteps(String emailId,String FPassword) throws InterruptedException
	{
		
		FpasswordLink.click();
	
		
		
		if(!(emailId==null))
		{
			 String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			    
		      Boolean validmail = emailId.matches(EMAIL_REGEX);
		      if(validmail)
		      {
		      System.out.println("is e-mail: "+emailId+" :Valid = " + validmail);
			TestData.GetData gdata = new  TestData.GetData();
	String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetForgotPassword?vcEmail="+emailId+"&status=yes");
	 ArrayList<String> array = gdata.parseFromJSONResponse(userresponse);
	 int i=0;
	 String message=array.get(i+2);
	 System.out.println(message);
	 if(message.equalsIgnoreCase(FPassword))
	 {
		 System.out.println("valid data");
		 REmailId.sendKeys(emailId);
		
		 
		 FpassButton.click();
		Thread.sleep(800);
		 Alert alert1 = driver.switchTo().alert();
			String alerttext1 = driver.switchTo().alert().getText();
			System.out.println(alerttext1);
			assertTrue(alerttext1.equalsIgnoreCase("Your password is sent to your EmailID"));
			
			alert1.accept();
		
	 }else{
		
		 REmailId.sendKeys(emailId);
		    
	 
	  FpassButton.click();
			
	  FpassButton.click();
		Thread.sleep(800);
		 Alert alert1 = driver.switchTo().alert();
			String alerttext1 = driver.switchTo().alert().getText();
			System.out.println(alerttext1);
			assertTrue(alerttext1.equalsIgnoreCase("Your email id does not exist in system!!"));
			
			alert1.accept();
	      
				
	      }
		      }else{
	    	  
	    	 

	    	  REmailId.sendKeys(emailId);
	    	 
	    	 
	    	  FpassButton.click();
	    	  Thread.sleep(500);
				String invalidemailtext=InvalidEmailError.getText();
				assertTrue(invalidemailtext.equalsIgnoreCase("Invalid Email"));
	    
		 
		
	 }
	
		}
		else{
			System.out.println("else part");
			
			 Thread.sleep(500);
			 FpassButton.click();
			 Thread.sleep(500);
			 String enteremailErrortext= EnterEmailError.getText();
				assertTrue(enteremailErrortext.equalsIgnoreCase("Please enter Email ID"));
		}
		
		
		
	}

	
	
	public void VendorLogin(String vendoruserName,String vendorpassWord,String domaintext) throws InterruptedException{
		
		
		if(!(vendoruserName==null)  && !(vendorpassWord==null))
					
				{
			
				
		

//			Select sdomain = new Select(Selectdomain);
//			sdomain.selectByValue(domain);
			
					TestData.GetData gdata = new  TestData.GetData();
					
					
					 APIBody = "{\"Mode\" : \"login\" ,\"username\": '"+vendoruserName+"' ,\"password\": '"+vendorpassWord+"' ,\"Domain\" : '"+domaintext+"'}";
					  array=  postapidata.Postarray(postbaseurl+"api/Vendor/Login" , APIBody );
					  System.out.println("array is"+array);
					  responseflag=array.get(0);
					  message=array.get(1);
					  System.out.println("message is"+message);
					  System.out.println("responseflag is"+responseflag);
					  if(responseflag.equalsIgnoreCase("1"))
					  {
						  username.sendKeys(vendoruserName);
							
								password.sendKeys(vendorpassWord);
								JavascriptExecutor js1 = (JavascriptExecutor) driver;
								Thread.sleep(400);
						         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
								System.out.println("here");
					  }else if(responseflag.equalsIgnoreCase("4"))
					  {
							
						  if(message.equalsIgnoreCase("USER DOES NOT EXISTS."))
								{
									username.clear();
								username.sendKeys(vendoruserName);
								password.clear();
								password.sendKeys(vendorpassWord);
								JavascriptExecutor js1 = (JavascriptExecutor) driver;
								
						        js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
								//loginButton.click();
								Thread.sleep(400);
								String nousererrorText= NOnRegisterError.getText();
								System.out.println(nousererrorText);
								assertTrue(nousererrorText.equalsIgnoreCase("USER DOES NOT EXISTS."));
								}
						  if(message.equalsIgnoreCase("PASSWORD INCORRECT."))
								{
									username.clear();
									username.sendKeys(vendoruserName);
									password.clear();
									password.sendKeys(vendorpassWord);
									JavascriptExecutor js1 = (JavascriptExecutor) driver;
									
							         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
							         Thread.sleep(400);
									String IPasswordText= passIncorrect.getText();
									System.out.println("message is"+IPasswordText);
									assertTrue(IPasswordText.equalsIgnoreCase("PASSWORD INCORRECT."));
								
								}
					  }
					

				}else
					if(vendoruserName==null   || vendoruserName==null)
					{
						if( vendoruserName==null)
						{
							//username.sendKeys(user);
							password.sendKeys(vendoruserName);
							JavascriptExecutor js1 = (JavascriptExecutor) driver;
							
					         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
					         Thread.sleep(400);
							System.out.println("here");
						}
						if( vendoruserName==null)
						{
							System.out.println("in pass");
							username.clear();
							username.sendKeys(vendoruserName);
							//password.sendKeys(pass);
							//driver.hideKeyboard();
							JavascriptExecutor js1 = (JavascriptExecutor) driver;
							
					         js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", loginButton);
					         Thread.sleep(400);
					         System.out.println("here");
						}
				
			
				}
	}
}
