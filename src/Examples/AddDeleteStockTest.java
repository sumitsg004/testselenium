package Examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

public class AddDeleteStockTest {

	WebDriver driver;
	@Test(priority=1)
	public void addStockTest() throws ParseException
	{
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "null");
		
		String browser = "Mozilla";
		
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
		//int year = 2018;
		//int day = 29;
		//int month = 10;
		String d = "11/09/2001";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		date = sdf.parse(d);
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
		int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
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
		waitforPagetoLoad();
		WebElement portfolio = driver.findElement(By.id("portfolioid"));
		Select s = new Select(portfolio);
		s.selectByVisibleText("Sumit1");
		driver.findElement(By.id("addStock")).click();
		driver.findElement(By.id("addstockname")).sendKeys("Varroc Engineering Ltd");
		wait(2);
		driver.findElement(By.id("addstockname")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("stockPurchaseDate")).click();
//		selectDate(d);
//		int currentday = getCurrentday();
//		if(day == currentday)
//			driver.findElement(By.xpath("//div[@class='dpDayHighlight']")).click();
//		else
//			driver.findElement(By.xpath("//td[text()='"+day+"']")).click();	
		//wait(5);
		
		while(true)//year select
		{
		String displayed_text = driver.findElement(By.xpath("//div[@class='dpTitleText']")).getText();
		
		String displayed_Year = displayed_text.split(" ")[1];
		System.out.println(displayed_text);
		
		System.out.println(displayed_Year);
		int yearDisplayed = Integer.parseInt(displayed_Year);
		if(year == yearDisplayed)
			break;
		else if(year < yearDisplayed)
			driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[1]/button")).click();
		else if(year > yearDisplayed)
			driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[5]/button")).click();
		
		}
		
		while(true)//month select
		{
			String displayed_text = driver.findElement(By.xpath("//div[@class='dpTitleText']")).getText();
			String displayed_month = displayed_text.split(" ")[0];
			System.out.println(displayed_text);
			System.out.println(displayed_month);
			int monthDisplayed = getMonth(displayed_month);
			if(month == monthDisplayed)
				break;
			else if(month < monthDisplayed)
				driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();	
			else if(month > monthDisplayed)
				driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
		}
		int currentday = getCurrentday();
		if(day == currentday)
			driver.findElement(By.xpath("//div[@class='dpDayHighlight']")).click();
		else
			driver.findElement(By.xpath("//td[text()='"+day+"']")).click();	
		
		driver.findElement(By.id("addstockqty")).sendKeys("100");
		driver.findElement(By.id("addstockprice")).sendKeys("250");
		driver.findElement(By.id("addStockButton")).click();
		
	waitforPagetoLoad();
	String text = driver.findElement(By.xpath("//table[@id='stock']/tbody/tr[1]/td[2]")).getText();
	System.out.println(text);
	int rownum = getRowWithCellData("Varroc Engineering");
	System.out.println(rownum);
	if(rownum == -1)
		Assert.fail("Stock not found in table");
	}
	
	public int getRowWithCellData(String data)
	{
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='stock']/tbody/tr"));
		for(int rNum = 0; rNum < rows.size(); rNum++)
		{
			WebElement row = rows.get(rNum);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(int cNum = 0; cNum < cells.size(); cNum++)
			{
				WebElement cell = cells.get(cNum);
				if(cell.getText().equals(data) && !cell.getText().trim().equals(""))
					return ++rNum;
			}
		}
		return -1;
		
	}
	public void selectDate(String d)
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			Date selected = sdf.parse(d);
			String day = new SimpleDateFormat("dd").format(selected);
			String month = new SimpleDateFormat("MMMM").format(selected);
			String year = new SimpleDateFormat("yyyy").format(selected);
			String desiredMonthYear = month+" "+year;
			while(true)
			{
				String displayedMonthYear = driver.findElement(By.xpath("//div[@class='dpTitleText']")).getText();
				if(desiredMonthYear.equals(displayedMonthYear))
					break;
				else
				{
					if(selected.compareTo(date) > 0)
						driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();	
					else if(selected.compareTo(date) < 0)
						driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();
				}
					
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int getMonth(String displayedMonth) throws ParseException
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
		date = sdf.parse(displayedMonth);
		int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
		return month;
	}
	
	public int getCurrentday()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("d");
		String day = sdf.format(date);
		//System.out.println(day);
		return Integer.parseInt(day);
	}
	
	@Test(priority=2, dependsOnMethods={"addStockTest"})
	public void deleteStockTest()
	{
	int rownum = getRowWithCellData("Varroc Engineering");
	driver.findElement(By.xpath("//table[@id='stock']/tbody/tr["+rownum+"]/td[1]")).click();
	driver.findElements(By.xpath("//input[@name='Delete']")).get(rownum-1).click();
	//driver.findElement(By.xpath("//table[@id='stock']/tbody/tr["+rownum+"]/td[3]/div/input[@name='Delete']")).click();
	driver.switchTo().alert().accept();
	waitforPagetoLoad();
	driver.switchTo().defaultContent();
	rownum = getRowWithCellData("Varroc Engineering");
	System.out.println(rownum);
	Assert.assertEquals(rownum,-1);
	
		
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
				boolean d = (boolean)js.executeScript("return window.jQuery!=undefined && jQuery.active==0;");	
				System.out.println(d);
				if(d)
					break;
				else
					wait(2);
				i++;
				
			}
		
	}
}
