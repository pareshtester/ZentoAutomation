package TestCases;

import static org.testng.Assert.assertTrue;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class anywebsite {
	
	
	@Test
	public void test()
	{
	
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://gdata.in");
	driver.findElement(By.xpath("//*[@id=\"t3-header\"]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]"));
	//assertTrue(condition);
	driver.findElement(By.xpath("//*[@id=\"Mod240\"]/div[1]/div[1]/ul[1]/li[6]/a[1]")).click();;
	}

}
