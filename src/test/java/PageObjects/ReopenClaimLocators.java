package PageObjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReopenClaimLocators {
	
	
WebDriver driver;
	
	public ReopenClaimLocators(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnReopen']")
	WebElement travelReopenButton;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnReopen']")
	WebElement localReopenButton;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnReopen']")
	WebElement OtherReopenButton;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnReopen']")
	WebElement MobileReopenButton;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnReopen']")
	WebElement HotelReopenButton;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnReopen']")
	WebElement FoodReopenButton;
	@FindBy(xpath=".//*[@id='ctl00_ContentPlaceHolder1_btnReopen']")
	WebElement LandlineReopenButton;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnEdit\"]")
	WebElement editbutton;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_lblmsg2\"]")
	WebElement successmessage; 
	
	public void reopentravelSteps(String claimid) throws InterruptedException
	{
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
		    for(int i=2; i<=size;i++)
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
		    JavascriptExecutor travelreopenjs = (JavascriptExecutor) driver;
		    travelreopenjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", travelReopenButton);
	
//		    Alert alertapprovesuc = driver.switchTo().alert();
//			String alerttextapprovesuc = driver.switchTo().alert().getText();
//			System.out.println(alerttextapprovesuc);
//			assertTrue(alerttextapprovesuc.equalsIgnoreCase("Claim Re-Submitted successfully"));
//			alertapprovesuc.accept();
		    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim Re-Submitted successfully. !"));

	
	}
	public void reopenLocalSteps(String claimid) throws InterruptedException
	{
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
		    for(int i=2; i<=size;i++)
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
		    JavascriptExecutor travelreopenjs = (JavascriptExecutor) driver;
		    travelreopenjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", localReopenButton);
	
//		    Alert alertapprovesuc = driver.switchTo().alert();
//			String alerttextapprovesuc = driver.switchTo().alert().getText();
//			System.out.println(alerttextapprovesuc);
//			assertTrue(alerttextapprovesuc.equalsIgnoreCase("Claim Re-Submitted successfully"));
//			alertapprovesuc.accept();
		    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim Re-Submitted successfully. !"));

	
	}

	public void reopenOtherSteps(String claimid) throws InterruptedException
	{
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
		    for(int i=2; i<=size;i++)
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
		    JavascriptExecutor travelreopenjs = (JavascriptExecutor) driver;
		    travelreopenjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", OtherReopenButton);
	
//		    Alert alertapprovesuc = driver.switchTo().alert();
//			String alerttextapprovesuc = driver.switchTo().alert().getText();
//			System.out.println(alerttextapprovesuc);
//			assertTrue(alerttextapprovesuc.equalsIgnoreCase("Claim Re-Submitted successfully"));
//			alertapprovesuc.accept();
		    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim Re-Submitted successfully. !"));

	
	}


	public void reopenMobileSteps(String claimid) throws InterruptedException
	{
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
		    for(int i=2; i<=size;i++)
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
		    JavascriptExecutor travelreopenjs = (JavascriptExecutor) driver;
		    travelreopenjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", MobileReopenButton);
	
//		    Alert alertapprovesuc = driver.switchTo().alert();
//			String alerttextapprovesuc = driver.switchTo().alert().getText();
//			System.out.println(alerttextapprovesuc);
//			assertTrue(alerttextapprovesuc.equalsIgnoreCase("Claim Re-Submitted successfully"));
//			alertapprovesuc.accept();
		    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim Re-Submitted successfully. !"));

	
	}

	public void reopenhotelSteps(String claimid) throws InterruptedException
	{
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
		    for(int i=2; i<=size;i++)
		    {
		    	
		    		
		    		//.//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr[2]/td[2]/span/h7/a
		    		String claim=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a")).getText();
		    	System.out.println("This is claim i am looking"+claim);
		    	if(claim.equalsIgnoreCase(claimid))
		    	{
		    		WebElement claimidclick=driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_grvEmpList']/tbody/tr["+i+"]/td[2]/span/a"));
		    		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    	    js3.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
		    	    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + ""
		    	    				+ "arguments[0].dispatchEvent(evt);", claimidclick);
		    	    i=size;
		    	}
		    	
		    	
		    }
		    Thread.sleep(10000);
		    JavascriptExecutor travelreopenjs = (JavascriptExecutor) driver;
		    travelreopenjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
		    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent"
		    				+ "(evt);", HotelReopenButton);
	
//		    Alert alertapprovesuc = driver.switchTo().alert();
//			String alerttextapprovesuc = driver.switchTo().alert().getText();
//			System.out.println(alerttextapprovesuc);
//			assertTrue(alerttextapprovesuc.equalsIgnoreCase("Claim Re-Submitted successfully"));
//			alertapprovesuc.accept();
		    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim Re-Submitted successfully. !"));

	
	}

	public void reopenFoodSteps(String claimid) throws InterruptedException
	{
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
		    for(int i=2; i<=size;i++)
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
		    JavascriptExecutor travelreopenjs = (JavascriptExecutor) driver;
		    travelreopenjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
		    		+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", FoodReopenButton);
	
//		    Alert alertapprovesuc = driver.switchTo().alert();
//			String alerttextapprovesuc = driver.switchTo().alert().getText();
//			System.out.println(alerttextapprovesuc);
//			assertTrue(alerttextapprovesuc.equalsIgnoreCase("Claim Re-Submitted successfully"));
//			alertapprovesuc.accept();
		    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim Re-Submitted successfully. !"));

	
	}

	public void reopenLandlineSteps(String claimid) throws InterruptedException
	{
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
		    for(int i=2; i<=size;i++)
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
		    JavascriptExecutor travelreopenjs = (JavascriptExecutor) driver;
		    travelreopenjs.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", LandlineReopenButton);
	
//		    Alert alertapprovesuc = driver.switchTo().alert();
//			String alerttextapprovesuc = driver.switchTo().alert().getText();
//			System.out.println(alerttextapprovesuc);
//			assertTrue(alerttextapprovesuc.equalsIgnoreCase("Claim Re-Submitted successfully"));
//			alertapprovesuc.accept();
		    assertTrue((successmessage.getText()).equalsIgnoreCase("Claim Re-Submitted successfully. !"));

	
	}
}
