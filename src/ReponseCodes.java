import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class ReponseCodes {

	public static void main(String[] args) throws ClientProtocolException, IOException {
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
		String url = "https://mail.rediff.com/cgi-bin/login.cgi";
		
		if(GetResponseCode(url))
		{
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}
	public static boolean GetResponseCode(String url) throws ClientProtocolException, IOException
	{
		int resp_code = Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
		System.out.println(resp_code);
		if(resp_code == 200)
		return true;
		else
			return false;
	}
}
