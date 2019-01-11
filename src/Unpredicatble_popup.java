import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Unpredicatble_popup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://qtpselenium.com/test/unpredicatble.php");
		Set<String> windowIds = driver.getWindowHandles();
		if(windowIds.size() == 2)
		{
			Iterator<String> it = windowIds.iterator();
			String mainWindowId = it.next();
			String PopupWindowId = it.next();
			
			driver.switchTo().window(PopupWindowId);
			driver.close();
			driver.switchTo().window(mainWindowId);
			
		}
	}

}
