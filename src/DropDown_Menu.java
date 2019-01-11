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
import org.openqa.selenium.support.ui.Select;

public class DropDown_Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		driver.get("http://qtpselenium.com/contact-us");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Select s = new Select(driver.findElement(By.name("country_id")));
		s.selectByIndex(1);
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByVisibleText("India");
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByValue("10");
		System.out.println(s.getFirstSelectedOption().getText());
		
		System.out.println("--------------*****ALL OPTIONS*****--------------");
		List<WebElement> list = s.getOptions();
		for(WebElement e:list)
		{
		System.out.println(e.getText());	
		}
	}

}
