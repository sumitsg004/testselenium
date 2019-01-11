import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Downloading_Files {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir","D:\\Selenium\\downloads");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		options.setProfile(profile);
		WebDriver driver = new FirefoxDriver(options);
		driver.get("http://qtpselenium.com/test/testdownload.php");
		driver.findElement(By.linkText("Word Doc")).click();
		
		ChromeOptions Coptions = new ChromeOptions();
	//	browser.helperApps.neverAsk.saveToDisk;
	//	browser.download.folderList;
	//	browser.download.dir;

	}

}
