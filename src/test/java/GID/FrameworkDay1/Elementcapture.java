package GID.FrameworkDay1;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class Elementcapture {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dulanjaleema\\eclipse-workspace\\FrameworkDay1\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		//Find the Element to capture screenshot 
		
		WebElement element = driver.findElement(By.xpath("//img[@id='hplogo']"));
		Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.viewportPasting(5000)).takeScreenshot(driver,element);
		ImageIO.write(screenshot.getImage(), "jpg", new File("C:\\Users\\dulanjaleema\\eclipse-workspace\\FrameworkDay1\\screenshot\\elementcapture.jpg"));
		
		driver.close();

	}

}
