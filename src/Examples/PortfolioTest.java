package Examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PortfolioTest {
	WebDriver driver;

	@Test(priority=1)
	public void createPortfolioTest()
	{
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
		driver.navigate().to("https://rediff.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='homewrapper']/div[5]/a[3]/div/u")).click();
		driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
		driver.findElement(By.id("useremail")).sendKeys("sumit104git@gmail.com");
		driver.findElement(By.id("emailsubmit")).click();
		//wait for password field to appear
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userpass"))));
		driver.findElement(By.id("userpass")).sendKeys("abcd@1234");
		driver.findElement(By.id("userpass")).sendKeys(Keys.ENTER);
		//boolean result = driver.findElement(By.xpath("//*[@id=\"createPortfolio\"]/img")).isDisplayed();
		//System.out.println(result);
		
		//ClickAndWait("//*[@id='createPortfolio']/img", "//*[@id='createPortfolioButton']", 10);
		waitforPagetoLoad();
		driver.findElement(By.xpath("//*[@id=\"createPortfolio\"]/img")).click();
		driver.findElement(By.id("create")).clear();
		driver.findElement(By.id("create")).sendKeys("Sumit1");
		driver.findElement(By.id("createPortfolioButton")).click();
		waitforPagetoLoad();
		//verify whether portfolio is created or not
		WebElement element = driver.findElement(By.id("portfolioid"));
		Select s = new Select(element);
		String portfolioName = s.getFirstSelectedOption().getText();
		System.out.println(portfolioName);
		
	}
	
	public void ClickAndWait(String xpathTarget, String xpathWait, int Maxtime)
	{
		
		for(int i = 0; i < Maxtime; i++)
		{
		driver.findElement(By.xpath(xpathTarget)).click();
		if(IsElementPresent(xpathWait) && driver.findElement(By.xpath(xpathWait)).isDisplayed())
		{
			return;
		}
		else {
			wait(1);
		}
		Assert.fail("Target Element coming after clicking on "+xpathTarget);
		}
	}
	public boolean IsElementPresent(String xpath)
	{
		int size = driver.findElements(By.xpath(xpath)).size();
		if(size == 0)
		return false;
		else
		return true;
	}
	
	public void wait(int time)
	{
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitforPagetoLoad()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i = 0;
		
			
			//System.out.println(state);
			while(i != 10)
			{
				String state = (String)js.executeScript("return document.readyState");
				if(state.equals("complete"))
					break;
				else
					wait(1);
				i++;
			}
	
			i = 0;
			while(i !=10)
			{
				long d = (long)js.executeScript("return jQuery.active;");	
				System.out.println(d);
				if(d == 0)
					break;
				else
					wait(2);
				i++;
				
			}
		
	}
	@Test(priority=2,dependsOnMethods= {"createPortfolioTest"})
	public void deletePortfolioTest()
	{
		driver.findElement(By.id("deletePortfolio")).click();
		driver.switchTo().alert().accept();
	}
}
