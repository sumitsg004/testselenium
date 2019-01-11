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

public class multipleElements {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "null");
		
		String browser = "Chrome";
		WebDriver driver = null;
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
		//List<WebElement> list = driver.findElements(By.tagName("a"));
		//System.out.println("Total number of links - "+list.size());
		/*WebElement Tenthlink = list.get(9);
		System.out.println("Tenth link is "+Tenthlink.getText());
		Tenthlink.click();
		*/ 
	/*	for(int i = 0; i < list.size(); i++)
		{
			WebElement element = list.get(i);
			System.out.println(element.getText()+"----"+element.isDisplayed());
		}*/
	//extracting links from specific area of the web page
		//select the box
		WebElement box = driver.findElement(By.xpath("//*[@id=\"intl_homepage1-zone-1\"]/div[2]/div/div[3]"));
		List<WebElement> list = box.findElements(By.tagName("a"));
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++)
		{
			 box = driver.findElement(By.xpath("//*[@id=\"intl_homepage1-zone-1\"]/div[2]/div/div[3]"));
			 list = box.findElements(By.tagName("a"));
			list.get(i).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
		}
	}

}
