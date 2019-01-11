import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Excercise_ShoppingCart {

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
	driver.get("https://www.americangolf.co.uk/");
	driver.manage().window().maximize();
	
	//WebDriverWait wait = new WebDriverWait(driver,10);
	//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon icon-basket']")));
	driver.findElement(By.cssSelector("#header-navigation>:nth-child(2)>:nth-child(4)>:nth-child(1)>:nth-child(2)>a")).click();
	//driver.findElement(By.xpath("//div[@id='header-navigation']/div[2]/div[4]/div/div[2]/a")).click();
	System.out.println(driver.findElement(By.cssSelector(".heading-1.cart-heading")).getText());
	//System.out.println(driver.findElement(By.xpath("//h1[@class='heading-1 cart-heading']")).getText());
	//driver.findElement(By.xpath("//*[@id=\"header-top-wrapper\"]/div/div[3]/div[2]/div[4]/div/div[2]/a/i/span[1]")).click();
	}

}
