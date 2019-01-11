import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class ICICI_Bank_Excercise {

	public static void main(String[] args) throws ParseException, InterruptedException {
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
		
		driver.get("https://loan.icicibank.com/asset-portal/auto-loan/check-eligibility");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//form[@name='checkEligibilityForm']/div[2]/div/div/div/button/span[1]")).click();
		driver.findElement(By.xpath("//span[text()='Used Car Loan']")).click();
		driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("9999999999");
		driver.findElement(By.xpath("//div[@class='custom-date-holder location-drpdwn map']/span/input")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//div[@class='custom-date-holder location-drpdwn map']/span/input")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[4]/div/div/form/div[2]/div[1]/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"check-eligibility-page\"]/div[4]/div/div/form/div[5]/div[2]/div/div/button/span[1]")).click();
		driver.findElement(By.xpath("//span[text()='Owned']")).click();
		driver.findElement(By.xpath("//*[@id=\"check-eligibility-page\"]/div[4]/div/div/form/div[6]/div[1]/div/div/div[1]/div/button/span[1]")).click();
		driver.findElement(By.xpath("//span[text()='2014']")).click();
		driver.findElement(By.xpath("//*[@id=\"check-eligibility-page\"]/div[4]/div/div/form/div[6]/div[1]/div/div/div[2]/div/button/span[1]")).click();
		driver.findElement(By.xpath("//span[text()='Mar']")).click();
		driver.findElement(By.xpath("//div[@class='custom-date-holder']/span/span")).click();
		String dob = "30/07/1986";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		date = sdf.parse(dob);
		String day = new SimpleDateFormat("d").format(date);
		String month = new SimpleDateFormat("MMM").format(date);
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);
		
		
		while(true)
		{
			String yearRange = driver.findElement(By.xpath("//*[starts-with(@id,'datepicker')]/strong")).getText();
			System.out.println(yearRange);
			int lowerYear = Integer.parseInt(yearRange.split("-")[0].trim());
			int upperYear = Integer.parseInt(yearRange.split("-")[1].trim());
			System.out.println(upperYear);
			System.out.println(lowerYear);
			System.out.println(year);
			if(lowerYear <= year && year <= upperYear) //Found year
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='"+year+"']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='btn btn-default']/span[text()='"+month+"']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='"+day+"']")).click();
				break;
			}
			else {
				if(year<lowerYear)
				{
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-chevron-left']")).click();
				}
					else if(year>upperYear)
					{
						Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-chevron-right']")).click();
					}
					}
			
		}
		
	}

}
