import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Drivers {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		options.addArguments("disable-infobars");
		options.addArguments("Start-maximized");
		options.addArguments("user-data-dir=C:\\Users\\STRTT\\AppData\\Local\\Google\\Chrome\\User Data\\");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://google.com");
		Thread.sleep(5000);
		//driver.quit();
	}

}
