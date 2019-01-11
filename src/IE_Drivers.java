import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IE_Drivers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
InternetExplorerOptions options = new InternetExplorerOptions();
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGLEVEL_PROPERTY, "INFO");
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "null");
		
	//	driver.get("javascript:document.getElementById('overridelink').click()");
	
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setAcceptInsecureCerts(true);
	caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	options.merge(caps);
	WebDriver driver = new InternetExplorerDriver(options);
	driver.get("https://192.163.254.17/");
	}

}
