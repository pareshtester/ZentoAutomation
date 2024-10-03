package Browsers;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import com.aventstack.extentreports.MediaEntityBuilder;
import com.relevantcodes.extentreports.LogStatus;

import Data.capturePostAPIData;
import PageObjects.ArtistApplyClaimPage;
import PageObjects.Loginpage;
import TestData.CreateExcelData;
import javafx.scene.media.MediaBuilder;

public class Open_Browser extends Urls {	 WebDriver driver;
//http://demo.zento.in/default.aspx
//String SiteURL="http://192.168.1.14:91/";   http://115.249.204.243:99//  http://35.200.203.176:99/    http://192.168.1.14:90/

//String SiteURL="http://nhbs.zento.in";

		  String x;
		  
		 
		  
		  CreateExcelData createfile = new CreateExcelData();
		  public Open_Browser(WebDriver driver){
			  
			  this.driver=driver;
		  }
//		  @Parameters( { "SiteURL"} ) 
//		  @BeforeTest
//		 public String ulsetup(String SiteURL)
//		 {
//			  System.out.println("beforetest"+SiteURL);
//			  SiteURL =this.SiteURL;
//			  return SiteURL;
//		 }
		  
		  
		  public String urlpath()
		  {
			  System.out.println("secon d usrl"+SiteURL);
			  
			return SiteURL;
			  
		  }
		  String APIBody="";
		  capturePostAPIData postapidata= new capturePostAPIData();
			public WebDriver  open(String browserName) throws MalformedURLException{

			   // String url="http://192.168.1.120:5577/wd/hub";
			    //http://192.168.1.120:5566
			    	 String url="http://192.168.1.224:5566/wd/hub";
				//
				if(browserName.equalsIgnoreCase("chrome")){
					
//					ChromeOptions options = new ChromeOptions();  
//				    options.addArguments("test-type");
//				    options.addArguments("--disable-extensions");
//				    System.setProperty("webdriver.chrome.driver","D:/Paresh/paresh/chromedriver.exe");
//				    DesiredCapabilities cap = DesiredCapabilities.chrome();
//				    cap.setCapability("name", "Remote File Upload using Selenium 2's FileDetectors");
//				    driver = new RemoteWebDriver(new java.net.URL(url), cap);
//				    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
				    System.out.println("Connecting to ");
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/chromedriver.exe");
					ChromeOptions options = new ChromeOptions();  
					options.addArguments("start-maximized"); // open Browser in maximized mode
					options.addArguments("disable-infobars"); // disabling infobars
					options.addArguments("--disable-extensions"); // disabling extensions
					options.addArguments("--disable-gpu"); // applicable to windows os only
					options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
					options.addArguments("--no-sandbox"); // Bypass OS security model
					driver = new ChromeDriver();
					
				}
				if(browserName.equalsIgnoreCase("firefox")){
					/*
					  FirefoxOptions op = new FirefoxOptions();
					   op.addArguments("test");
					   op.addArguments("--disable-extensions");
					   DesiredCapabilities cap = DesiredCapabilities.firefox();
						driver = new RemoteWebDriver(new java.net.URL(url), cap);
						*/
						System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"/geckodriver.exe");
						driver  = new FirefoxDriver();
				}
				if(browserName.equalsIgnoreCase("IE")){
					  InternetExplorerOptions opIE = new InternetExplorerOptions();
					     
					

				}
			  
		  		 
		  
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		    return driver;
		    
			}
			public void clearData(String user,String pass,String domain) throws InterruptedException
			{
				System.out.println(">>>>URL"+SiteURL);
				driver.get(SiteURL);
				Loginpage lp = PageFactory.initElements(driver, Loginpage.class);
				lp.Login(user, pass, domain);

				driver.get(SiteURL+"/ClearEmployeeClaims.aspx?EmpCode="+user+"&Domain="+domain);
				System.out.println(SiteURL+"/ClearEmployeeClaims.aspx?EmpCode="+user+"&Domain="+domain);
				 Alert alert1 = driver.switchTo().alert();
					String alerttext1 = driver.switchTo().alert().getText();
					System.out.println(alerttext1);
					assertTrue(alerttext1.equalsIgnoreCase("Employee Claims Deleted Successfully"));
					alert1.accept();
					driver.get(SiteURL);
					
			}
			
			public void clearleaveData(String user,String pass,String domain) throws InterruptedException
			{
			driver.get(adminurl);
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);
			System.out.println(user);
			System.out.println(pass);
			String useradmin="Adanonzento";
			locator.adminLogin(useradmin,"DanoneAdmin$321",domain);
			System.out.println("http://192.168.1.102:91/Reports/LeaveDeleteByEMPCode.aspx?emp="+user);

//			driver.get(adminurl+"/Reports/LeaveDeleteByEMPCode.aspx?emp="+user);
//			Alert alert1 = driver.switchTo().alert();
//
//
//			alert1.accept();
			driver.get(SiteURL);

			}
			
			 public String failed(String screenshotname)
				{
				 String destination="";
				 
					File srcf= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
					try {
						 destination = "./screenReports/Screenshots/"+screenshotname+".jpg";
						 
						org.apache.commons.io.FileUtils.copyFile(srcf, new File(destination));
//						//org.apache.commons.io.FileUtils.copyFile(srcf, new File("D://Paresh/zento/Screenshots/"+"Failshot_"+this.getClass().getName()+"_"+".jpg"));
//						File destination = new File(System.getProperty("user.dir") + "/Screenshots/"+screenshotname+".jpg");
//								File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//								FileUtils.copyFile(scrFile, destination.getAbsoluteFile());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
					return destination;
					
				}
			
			
			 public String captureToBase64() throws IOException {

				    Rectangle screenSize = new 
				    Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				    BufferedImage screenCapture = null;
				    String base64Encoded = "";
				    

				    try {

				        screenCapture = new Robot().createScreenCapture(screenSize);
				        ByteArrayOutputStream baos = new ByteArrayOutputStream();
				        ImageIO.write(screenCapture, "jpg", baos);
				        baos.flush();
				        byte[] encodeBase64 = Base64.encodeBase64(baos.toByteArray());
				        base64Encoded = new String(encodeBase64);
				        baos.close();

				    } catch (AWTException e) {
				        e.getMessage();
				    }
System.out.println(base64Encoded);
				    return base64Encoded;
				}
			public void deletevendor(String email, String domain) throws JSONException, InterruptedException
			{
				System.out.println(email);
				System.out.println(domain);
				  
				  APIBody = "{\r\n" + 
				  		"  \"Email\": '"+email+"',\r\n" + 
				  		"  \"Domain\": '"+domain+"'\r\n" + 
				  		"}";
				 ArrayList<String> array=  postapidata.Postarray(postbaseurl+"api/Vendor/DeleteVendorAllDetails" , APIBody );
				 String successmessage =array.get(1);
				 assertTrue(successmessage.equalsIgnoreCase("Details Deleted Successfully"));
				 
				
			}
			
			
			
			public void uploadexcelattendance(String employeename,String coemployee,String intime,String outtime) throws IOException, InterruptedException
			{


			createfile.writeexceldata(employeename,coemployee,intime,outtime);


			driver.get(adminurl);
			Loginpage locator = PageFactory.initElements(driver, Loginpage.class);

			String useradmin="admin";
			locator.adminLogin(useradmin,"Zento123","Redchillies");
			ArtistApplyClaimPage artistapply= PageFactory.initElements(driver, ArtistApplyClaimPage.class);
			artistapply.navigatetouploadadv();


			}
			
			
			

}
