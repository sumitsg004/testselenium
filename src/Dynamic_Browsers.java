import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class Dynamic_Browsers {

	public static void main(String[] args) throws InterruptedException {
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
		driver.get("https://www.rediff.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("username");
		//driver.findElement(By.xpath("//div[@class = 'login-form']/div[3]/div/a")).click();
		driver.findElement(By.cssSelector(".f14.margTop10.form-label>:nth-child(2)>:nth-child(1)")).click();
		//WebElement passwd = driver.findElement(By.name("passwd"));
		//passwd.sendKeys("passwd1");
		//driver.findElement(By.name("proceed")).click();
		//Thread.sleep(3000);
		
		
		//driver.quit();
		//Thread.sleep(5000);
	//	System.out.println(driver.getTitle());
		
	}
	
	public ChromeOptions loadChromeOptions()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		return options;
	}

}
