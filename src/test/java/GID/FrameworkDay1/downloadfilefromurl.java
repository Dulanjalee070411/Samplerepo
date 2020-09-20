package GID.FrameworkDay1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class downloadfilefromurl {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dulanjaleema\\eclipse-workspace\\FrameworkDay1\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseurl= "https://chromedriver.storage.googleapis.com/index.html?path=86.0.4240.22/";
		
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement downloadbutton = driver.findElement(By.xpath("//a[contains(text(),'chromedriver_win32.zip')]"));
		String sourceLocation = downloadbutton.getAttribute("href");
		String wget_command ="cmd /c C:\\Wget\\wget.exe –P D: --no-check-certificate  "+ sourceLocation;
		
		try {
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exitval = exec.waitFor();
			System.out.println("Exit value:" + exitval);
		}catch (InterruptedException e) {
			System.out.println(e.toString());
		}catch (IOException e) {
				System.out.println(e.toString());
			}
driver.close();
	}

}
