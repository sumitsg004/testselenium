import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.annotations.Test;

public class LoadingOptions {

	@Test
	public void launchBroswer()
	{
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "null");
		
		String browser = "Chrome";
		WebDriver driver = null;
		if(browser.equals("Chrome"))
		{
			driver = new ChromeDriver(loadChromeOptions());
		}
		else if(browser.equals("Mozilla"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		driver.get("http://google.com");
	}
	public ChromeOptions loadChromeOptions()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		return options;
	}
}
