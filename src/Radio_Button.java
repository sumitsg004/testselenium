import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class Radio_Button {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "null");
		WebDriver driver = null;
		String browser = "Chrome";
		
		if(browser.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("Mozilla"))
		{
			driver = new FirefoxDriver();
		}	
		else if(browser.equals("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
	//	driver.get("https://cnn.com/");
		driver.get("https://www.dyn-web.com/tutorials/forms/examples/pizza.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> list = driver.findElements(By.name("size"));
		list.get(0).click();
		System.out.println(list.get(0).isSelected());
		System.out.println(list.get(0).getAttribute("Selected"));
	}

}
