package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class sample {

	
	WebDriver driver;
	
	@Test
	
	public void steps()
	{
		System.setProperty("webdriver.gecko.driver", "C://Paresh/zento/geckodriver.exe");
		driver =new FirefoxDriver();
		driver.get("https://wwww.gdata.in");
		
		
	}
	
}
