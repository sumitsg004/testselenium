import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Popups_MultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		
		//driver.get("https://www.naukri.com/");
		driver.get("https://www.jobserve.com/in/en/Job-Search/");
		driver.findElement(By.id("SPTPosTitleLink")).click();
		
		Set<String> s = driver.getWindowHandles();
		System.out.println(s.size());
		Iterator<String> it = s.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			driver.close();
		}
		/*while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			driver.close();
		} */
	/*	String mainWindowId = it.next();
		String SecondWindowID = it.next();
		String ThirdWindowID = it.next();
		System.out.println(mainWindowId);
		System.out.println(SecondWindowID);
		System.out.println(ThirdWindowID);
		driver.switchTo().window(SecondWindowID);
		driver.close();
		driver.switchTo().window(ThirdWindowID);
		driver.close();
		driver.switchTo().window(mainWindowId);
		System.out.println(driver.getTitle());
		*/
		
	}

}
