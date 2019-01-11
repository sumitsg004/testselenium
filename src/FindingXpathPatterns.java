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

public class FindingXpathPatterns {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "null");
		
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
		driver.navigate().to("https://cnn.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String part1 = "//*[@id=\"intl_homepage1-zone-1\"]/div[2]/div/div[3]/ul/li[";
		String part2 = "]/article/div/div/h3/a/span[1]";
		
	/*	for(int i = 2; i<=10; i++)
		{
			driver.findElement(By.xpath(part1+i+part2)).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
		} */
		int i = 2;
		while(IsElementPresent(part1+i+part2,"xpath"))
		{
			driver.findElement(By.xpath(part1+i+part2)).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			i++;
		}
	
	}
	public static boolean IsElementPresent(String locator, String locatorType)
	{
		List<WebElement> allelements = null;
		if(locatorType.equals("xpath"))
		{
			allelements = driver.findElements(By.xpath(locator));
		}
		if(allelements.size() == 0)
		return false;
		else
			return true;
	}

}
