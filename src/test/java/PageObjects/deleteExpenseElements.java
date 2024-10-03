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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Browsers.Urls;

public class deleteExpenseElements extends Urls {
	
	
WebDriver driver;
	
	public deleteExpenseElements(WebDriver driver) {
		
		this.driver=driver;
	}
	Calendar current = Calendar.getInstance();
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ddlClaimTypes\"]")
	WebElement claimType;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_RptTravelClaim_ctl01_lnkDelete\"]")  
	WebElement deleteIconclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlLocal_RptLocalClaim_ctl01_lnkDelete']")
	WebElement localdeleteIconclick;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_RptOtherClaim_ctl01_lnkDelete\"]")
	WebElement otherdeleteIconclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlMobile_RptMobileClaim_ctl01_lnkDelete']")
	WebElement mobiledeleteIconclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlHotel_RptHotelClaim_ctl01_lnkDelete']")
	WebElement hoteldeleteIconclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctrlFood_RptFoodClaim_ctl01_lnkDelete']")
	WebElement fooddeleteIconclick;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_ctlLandline_RptLandlineClaim_ctl01_lnkDelete']")
	WebElement landlinedeleteIconclick;
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnEdit\"]")
	WebElement editbutton;
	
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlTravel_lblmsg2\"]")
	WebElement deletetravelsuccess;   
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlOther_lblmsg2\"]")
	WebElement deleteothersuccess;     
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlMobile_lblmsg2\"]")
	WebElement deletemobilesuccess; 
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlLocal_lblmsg2\"]")
	WebElement deletelocalsuccess;  
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctlLandline_lblmsg2\"]")
	WebElement deletelandlinesuccess;  
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlHotel_lblmsg2\"]")
	WebElement deletehotelsuccess;   
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ctrlFood_lblmsg2\"]")
	WebElement deletefoodsuccess;
	
	public void deletetravelSteps(String user,String pass,String claimid,String fromCity,String toCity,String tMode,String tamount,String CB,String travelRemarks, String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
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
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", editbutton);
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
	    	        Select selectclaimtype = new Select(claimType);
	    	        selectclaimtype.selectByVisibleText("Travel");
	    	        
			    JavascriptExecutor deleteiconclick = (JavascriptExecutor) driver;
			    deleteiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		deleteIconclick);
			    Alert alert1 = driver.switchTo().alert();
				String alerttext1 = driver.switchTo().alert().getText();
				System.out.println(alerttext1);
				assertTrue(alerttext1.equalsIgnoreCase("Are you sure you want to delete expense?"));
				alert1.accept();
				
//				 Alert alertsuccess = driver.switchTo().alert();
//					String alerttextsuccess1 = driver.switchTo().alert().getText();
//					System.out.println(alerttextsuccess1);
//					assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense deleted successfully"));
//					alertsuccess.accept();
			    assertTrue((deletetravelsuccess.getText()).equalsIgnoreCase("Expense deleted successfully !"));

	}
	public void deletelocalSteps(String user,String pass,String claimid,String fromCity,String toCity,String tMode,String tamount,String CB,String travelRemarks, String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
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
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", editbutton);
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
	    	        Select selectclaimtype = new Select(claimType);
	    	        selectclaimtype.selectByValue("2");
			    JavascriptExecutor deleteiconclick = (JavascriptExecutor) driver;
			    deleteiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		localdeleteIconclick);
			    Alert alert1 = driver.switchTo().alert();
				String alerttext1 = driver.switchTo().alert().getText();
				System.out.println(alerttext1);
				assertTrue(alerttext1.equalsIgnoreCase("Are you sure you want to delete expense?"));
				alert1.accept();
				
//				 Alert alertsuccess = driver.switchTo().alert();
//					String alerttextsuccess1 = driver.switchTo().alert().getText();
//					System.out.println(alerttextsuccess1);
//					assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense deleted successfully"));
//					alertsuccess.accept();
				
			    assertTrue((deletelocalsuccess.getText()).equalsIgnoreCase("Expense deleted successfully. !"));


	}

	public void deleteOtherSteps(String user,String pass,String claimid,String fromCity,String toCity,String tMode,String tamount,String CB,String travelRemarks, String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
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
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", editbutton);
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
	    	        Select selectclaimtype = new Select(claimType);
	    	        selectclaimtype.selectByVisibleText("Other");
			    JavascriptExecutor deleteiconclick = (JavascriptExecutor) driver;
			    deleteiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		otherdeleteIconclick);
			    Alert alert1 = driver.switchTo().alert();
				String alerttext1 = driver.switchTo().alert().getText();
				System.out.println(alerttext1);
				assertTrue(alerttext1.equalsIgnoreCase("Are you sure you want to delete expense?"));
				alert1.accept();
				
//				 Alert alertsuccess = driver.switchTo().alert();
//					String alerttextsuccess1 = driver.switchTo().alert().getText();
//					System.out.println(alerttextsuccess1);
//					assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense deleted successfully"));
//					alertsuccess.accept();
			    assertTrue((deleteothersuccess.getText()).equalsIgnoreCase("Expense deleted successfully !"));

	}

	public void deleteMobileSteps(String user,String pass,String claimid,String fromCity,String toCity,String tMode,String tamount,String CB,String travelRemarks, String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
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
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", editbutton);
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
	    	        Select selectclaimtype = new Select(claimType);
	    	        selectclaimtype.selectByVisibleText("Mobile");
			    JavascriptExecutor deleteiconclick = (JavascriptExecutor) driver;
			    deleteiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		mobiledeleteIconclick);
			    Alert alert1 = driver.switchTo().alert();
				String alerttext1 = driver.switchTo().alert().getText();
				System.out.println(alerttext1);
				assertTrue(alerttext1.equalsIgnoreCase("Are you sure you want to delete expense?"));
				alert1.accept();
				
//				 Alert alertsuccess = driver.switchTo().alert();
//					String alerttextsuccess1 = driver.switchTo().alert().getText();
//					System.out.println(alerttextsuccess1);
//					assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense deleted successfully"));
//					alertsuccess.accept();
				
			    assertTrue((deletemobilesuccess.getText()).equalsIgnoreCase("Expense deleted successfully !"));

	}

	public void deletehotelSteps(String user,String pass,String claimid,String fromCity,String toCity,String tMode,String tamount,String CB,String travelRemarks, String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
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
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", editbutton);
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
	    	        Select selectclaimtype = new Select(claimType);
	    	        selectclaimtype.selectByVisibleText("Hotel");
			    JavascriptExecutor deleteiconclick = (JavascriptExecutor) driver;
			    deleteiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		hoteldeleteIconclick);
			    Alert alert1 = driver.switchTo().alert();
				String alerttext1 = driver.switchTo().alert().getText();
				System.out.println(alerttext1);
				assertTrue(alerttext1.equalsIgnoreCase("Are you sure you want to delete expense?"));
				alert1.accept();
				
//				 Alert alertsuccess = driver.switchTo().alert();
//					String alerttextsuccess1 = driver.switchTo().alert().getText();
//					System.out.println(alerttextsuccess1);
//					assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense deleted successfully"));
//					alertsuccess.accept();
				
			    assertTrue((deletehotelsuccess.getText()).equalsIgnoreCase("Expense deleted successfully. !"));

	}

	public void deletefoodSteps(String user,String pass,String claimid,String fromCity,String toCity,String tMode,String tamount,String CB,String travelRemarks, String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
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
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", editbutton);
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
	    	        Select selectclaimtype = new Select(claimType);
	    	        selectclaimtype.selectByVisibleText("Food");
			    JavascriptExecutor deleteiconclick = (JavascriptExecutor) driver;
			    deleteiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		fooddeleteIconclick);
//			    Alert alert1 = driver.switchTo().alert();
//				String alerttext1 = driver.switchTo().alert().getText();
//				System.out.println("Confirmation text is"+alerttext1);
//				assertTrue(alerttext1.equalsIgnoreCase("Are you sure you want to delete expense?"));
//				alert1.accept();
				Thread.sleep(1000);
//				 Alert alertsuccess = driver.switchTo().alert();
//					String alerttextsuccess1 = driver.switchTo().alert().getText();
//					System.out.println("Success message"+alerttextsuccess1);
//					assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense deleted successfully"));
//					alertsuccess.accept();
				
			    assertTrue((deletefoodsuccess.getText()).equalsIgnoreCase("Expense deleted successfully !"));

	}

	
	public void deleteLandlineSteps(String user,String pass,String claimid,String fromCity,String toCity,String tMode,String tamount,String CB,String travelRemarks, String domain, String gstn,String cgst, String sgst, String igst) throws InterruptedException
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
	    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", editbutton);
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
				 
				 Select selectclaimtype = new Select(claimType);
	    	        selectclaimtype.selectByVisibleText("LandLine");
			    JavascriptExecutor deleteiconclick = (JavascriptExecutor) driver;
			    deleteiconclick.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
			    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", 
			    		landlinedeleteIconclick);
			    Alert alert1 = driver.switchTo().alert();
				String alerttext1 = driver.switchTo().alert().getText();
				System.out.println(alerttext1);
				assertTrue(alerttext1.equalsIgnoreCase("Are you sure you want to delete expense?"));
				alert1.accept();
				
//				 Alert alertsuccess = driver.switchTo().alert();
//					String alerttextsuccess1 = driver.switchTo().alert().getText();
//					System.out.println(alerttextsuccess1);
//					assertTrue(alerttextsuccess1.equalsIgnoreCase("Expense deleted successfully"));
//					alertsuccess.accept();
				
			    assertTrue((deletelandlinesuccess.getText()).equalsIgnoreCase("Expense deleted successfully. !"));

	}
}
