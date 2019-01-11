import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class Attributes_Options {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "null");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("disable-notfications");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#login1")).sendKeys("Selenium");
		System.out.println(driver.findElement(By.cssSelector("#login1")).getAttribute("value"));
		System.out.println(driver.findElement(By.name("proceed")).getAttribute("value"));
		System.out.println(driver.findElement(By.cssSelector(".uncheck-label.f12")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='margTop10']/div/label")).getText());
		System.out.println(driver.findElement(By.name("remember")).getAttribute("checked"));
		driver.findElement(By.name("remember")).click();
		System.out.println(driver.findElement(By.name("remember")).getAttribute("checked"));
		
	}

	
}
