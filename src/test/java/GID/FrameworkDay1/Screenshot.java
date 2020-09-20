package GID.FrameworkDay1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Screenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dulanjaleema\\eclipse-workspace\\FrameworkDay1\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
			// convert web driver object to TakeScreenshot
			TakesScreenshot srcShot = ((TakesScreenshot) driver);

			// Call getScreenshotAs method to create image file
			File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
			
			File desfile = new File("C:\\Users\\dulanjaleema\\eclipse-workspace\\FrameworkDay1\\screenshot\\image1.png");
			FileUtils.copyFile(srcFile, desfile);

			//Screenshot screenshot = new Ashot().takeScreenshot(driver);l
		
	}
	
	

}
