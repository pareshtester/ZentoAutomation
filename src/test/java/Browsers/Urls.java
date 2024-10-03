package Browsers;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.MediaEntityModelProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.sun.jna.platform.FileUtils;

public class Urls  {
//http://nhbsapi.zento.in
//http://zentoapi.zento.in  //http://192.168.1.14:84/        http://115.249.204.243:83/Core_ZentoAPI/  http://35.200.203.176:100  https://webapi.zento.in/
//115.249.204.243:84      http://34.93.154.136/
//nhbsapi:http://nhbsapi.zento.in/  for demo.zento.in  http://gdataapi.zento.in   http://192.168.1.14:83   http://115.249.204.243:84/";  https://api.zento.in/  http://67.222.157.154:212/
	
	public static WebDriver driver=null;
	File srcf=null;
	
	
		public static String BaseUrl=""; 
	public static String adminurl="";
	//public static String adminurl="http://demoadmin.zento.in//default.aspx";
	public static String vendorapproval="";
	public static String vendorurl="";
	public static String postbaseurl="";
	//34.93.154.136
	//*****Excel sheet path********  http://115.249.204.243:88"  http://34.93.230.68/ http://192.168.1.223:99/  http://192.168.1.14:92/   http://34.93.13.6:90/     http://34.93.13.6:90  http://34.93.154.136/
	public static String ExcelSheetPath="D:/Paresh/paresh";
	//**Excel File Name********
	public static String ExcelFileName="ZentoDataProvider.xls";
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static String SiteURL="";
	public static String elementattachtext="";
	//Open_Browser ob = new Open_Browser(driver);
	@BeforeSuite 
	public void startReport(){
		//String path="D:/DRIVED/Websites/Paresh/Com.Zento/test-output/Reports/report.html";
		String path="C:/Paresh/zento/test-output/Reports/report.html";
		//ExtentReports(String filePath,Boolean replaceExisting) 
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		
		
		try {
		    URI u = new URI(path.trim().replaceAll("\\u0020", "%20"));
			extent = new ExtentReports (u.getPath(), true);
		} catch (URISyntaxException ex) {
		  //  Exceptions.printStackTrace(ex);
		}
		
	
		//extent.addSystemInfo("Environment","Environment Name")
		extent
                .addSystemInfo("Host Name", "SoftwareTestingGData")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Paresh Patil");
                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	@Parameters( { "Siteurl" ,  "BaseURL" , "AdminUrl" , "VendorapprovalUrl","vendorURL","postBaseURL"}) 
	
	  @BeforeTest
	 public ArrayList<String> ulsetup(String Siteurl,String BaseURL,String AdminUrl,String VendorapprovalUrl,String vendorURL,String postBaseURL)
	 {
		  System.out.println("beforetest"+Siteurl);
		  SiteURL =Siteurl;
		  BaseUrl=BaseURL;
		  adminurl=AdminUrl;
		  vendorurl=vendorURL;
		  vendorapproval=VendorapprovalUrl;
		  postbaseurl=postBaseURL;
		  ArrayList<String> a =new ArrayList<String>();
		  a.add(SiteURL);
		  a.add(BaseUrl);
		  a.add(adminurl);
		  a.add(vendorapproval);
		  a.add(vendorurl);
//		  
//		  if(adminurl.equalsIgnoreCase("https://gdataadmin.zento.in/"))
//		  {
//			  elementattachtext="ctl00_";
//		  }else
//		  {
//			  elementattachtext="";
//		  }
		  return a;
	 }
	
	public String returnelementextension(String adminurl) {
		if(adminurl.equalsIgnoreCase("https://gdataadmin.zento.in/"))
		  {
			  elementattachtext="ctl00_";
		  }else
		  {
			  elementattachtext="";
		  }
		return elementattachtext;
		
	}
	
//	 public void failed(WebDriver driver)
//		{
//		 
//		 
//			File srcf= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			try {
//				org.apache.commons.io.FileUtils.copyFile(srcf, new File("D://Paresh/zento/Screenshots/testscreenshot.jpg"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
	
	

	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
//			String scrrenshotpath = ob.failed(result.getName());
//			logger.log(LogStatus.FAIL, logger.addScreenCapture(scrrenshotpath));
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
	//	extent.endTest(logger);
	}
	
	

	
	@AfterSuite
	public void endReport(){
		
                extent.flush();
                
                
                //Call close() at the very end of your session to clear all resources. 
                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
                //Once this method is called, calling any Extent method will throw an error.
                //close() - To close all the operation
                //extent.close();
                
    }
	
	
	
	public static Object screenshotcapture(String imagepath)
	{
//		logger.log(LogStatus.INFO,  MediaEntityBuilder.createScreenCaptureFromPath(imagepath, logdtails).build());
//		logger.log(LogStatus.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
//		logger.log
		logger.addScreenCapture(imagepath);
		return logger;
	}
}
