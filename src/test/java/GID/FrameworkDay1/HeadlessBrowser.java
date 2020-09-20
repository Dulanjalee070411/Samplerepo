package GID.FrameworkDay1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowser {

	public static void main(String[] args) {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\dulanjaleema\\eclipse-workspace\\FrameworkDay1\\driver\\chromedriver.exe");

		// WebDriverManager.chromedriver().setup();
		/*
		 * ChromeOptions chromeOptions = new ChromeOptions();
		 * chromeOptions.setHeadless(true);
		 * 
		 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 * capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 * capabilities.acceptInsecureCerts();
		 */

		/*
		 * DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 * capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
		 */
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.google.lk");
		System.out.println("Excuting hedless browser ");
		System.out.println("Test Git");
		String title = driver.getTitle();
		System.out.println(title);

	}

}
