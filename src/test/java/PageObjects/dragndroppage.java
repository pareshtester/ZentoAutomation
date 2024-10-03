package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class dragndroppage {
	WebDriver driver;
	public dragndroppage(WebDriver driver){
		
		this.driver=driver;
		
	}
	@FindBy(xpath=".//*[@id='txtUserName']")
	WebElement username;
	
	public void drag() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
//		String inputId ="dropzone-wrapper"+"FileUpload";
//		JavascriptExecutor js7 = (JavascriptExecutor) driver;
//		js7.executeScript(inputId + " = window.$('<input id=' + inputId + '/>').attr({type:'file'}).appendTo('body');'\");
//				   driver.findElement(By.id(inputId)).sendKeys(System.getProperty("user.dir") +"/Images/Chrysanthemum.jpg");
		
//		WebElement from =driver.findElement(By.xpath("//img[contains(@src,'images/logo.png')]"));
//		WebElement to  = driver.findElement(By.id("dropzone-wrapper"));
		Actions act = new Actions(driver);
		//act.dragAndDrop(from, to).build().perform();
		WebElement clickelement =driver.findElement(By.id("dropzone"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", clickelement);
		act.doubleClick(clickelement).build().perform();
		Runtime.getRuntime().exec("D:\\Paresh\\AutoIT\\FileUpload.exe");
		
	}

}
