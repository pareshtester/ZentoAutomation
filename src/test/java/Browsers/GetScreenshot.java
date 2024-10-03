package Browsers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot   {
	WebDriver driver;
	
	public GetScreenshot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		 String Base64StringofScreenshot="";
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination =  "./test-output/reports/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		//FileUtils.copyFile(source, finalDestination);
		destination ="./" + screenshotName + dateName + ".png";
		  byte[] fileContent = FileUtils.readFileToByteArray(source);
		  Base64StringofScreenshot = "data:image/png;base64,"+Base64.getEncoder().encodeToString(fileContent);
		  
		return Base64StringofScreenshot;
	}
		}


