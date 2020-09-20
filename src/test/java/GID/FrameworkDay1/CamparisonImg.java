package GID.FrameworkDay1;


import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CamparisonImg {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dulanjaleema\\eclipse-workspace\\FrameworkDay1\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		WebElement element = driver.findElement(By.xpath("//img[@id='hplogo']"));
		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(5000)).takeScreenshot(driver,element);
		
		//read the image to compare
		BufferedImage expectedimage = null;
		try {
			expectedimage = ImageIO.read(new File("C:\\Users\\dulanjaleema\\eclipse-workspace\\FrameworkDay1\\screenshot\\elementcapture.jpg"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		BufferedImage actualImage =screenshot.getImage();
		//create Image different  object and call method make difference 
		
		
		ImageDiffer imgdiff = new ImageDiffer();
		assert expectedimage != null;
		ImageDiff diff = imgdiff.makeDiff(actualImage, expectedimage);
		if(diff.hasDiff()) {
			System.out.println("images are not same");
			
		}else {
			System.out.println("Images are same");
		}
		
		driver.quit();
		
		
	}

}
