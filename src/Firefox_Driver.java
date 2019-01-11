import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class Firefox_Driver {

	public static void main(String[] args) {
		
		//give driver location - not required if you have set drivers folder path to path environment variable
	//	System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver.exe");
		
		//hide logs or set path where to store the log file - donot print logs in console
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
		
		//Firefox options 
		FirefoxOptions options = new FirefoxOptions();
		//NONE - will not wait for complete page to load, will wait till only required element is needed
		//EAGER - similar to NONE but little faster
		//NORMAL - normal execution
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		//select firefox profile to use to run the code
		ProfilesIni all_prof = new ProfilesIni();
		FirefoxProfile profile = all_prof.getProfile("Module11");
		//turn of web notifications
		profile.setPreference("dom.webnotifications.enabled", false);
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		options.setProfile(profile);
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://192.163.254.17");
		
		

	}

}
