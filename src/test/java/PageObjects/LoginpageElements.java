package PageObjects;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Browsers.Urls;

public class LoginpageElements extends Urls{
	String EmployeeuserName=null;
	   String EmployeepassWord=null;
	   String emailId=null;
	   String FPassword=null;
	   //String empdata=null;
WebDriver driver=null;
	
	public LoginpageElements(WebDriver driver){
		
		this.driver=driver;
		
	}
	@FindBy(xpath=".//*[@id='txtUserName']")
	WebElement username;
	@FindBy(xpath=".//*[@id='txtPassword']")
	WebElement password;
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
	
	
	
	
	//Login 
	public void Login(String EmployeeuserName,String EmployeepassWord) throws InterruptedException{
		
		
if(!(EmployeeuserName==null)  && !(EmployeepassWord==null))
			
		{
	
			TestData.GetData gdata = new  TestData.GetData();
			System.out.println(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+"");
			 String userresponse = gdata.getContenxtWeb(BaseUrl+"/api/login/GetLogin?Mode=Login&UName="+EmployeeuserName+"&PWD="+EmployeepassWord+"&Domain=fulcrum");
			
		
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
	public void logout(){
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", logoutDropdown);
		//logoutDropdown.click();
		//logout.click();
	    JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", logoutbutton);
		
		
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
	
	

}
