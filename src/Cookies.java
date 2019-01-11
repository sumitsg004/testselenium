import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Cookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cnn.com/");
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		Iterator<Cookie> it = cookies.iterator();
		//print all cookies
		while(it.hasNext())
		{
			Cookie cookie = it.next();
			System.out.println("Name of cookie is "+cookie.getName()+" and Value of coookie is "+cookie.getValue());
		}
		
		String cookieName = "countryCode";
		String newValue = "UK";
		//delete specific cookie and add cookie with same name but updated value
		it = cookies.iterator();
		while(it.hasNext())
		{
			
				Cookie cookie = it.next();
				if(cookie.getName().equals(cookieName))
				{
				driver.manage().deleteCookie(cookie);
				//System.out.println("-------------------------"+cookie.getName());
				break;
				}
				}
		
		Cookie mycookie = new Cookie(cookieName, newValue);
		driver.manage().addCookie(mycookie);
		cookies = driver.manage().getCookies();
		it = cookies.iterator();
		while(it.hasNext())
		{
			Cookie cookie = it.next();
			System.out.println("Name of cookie is "+cookie.getName()+" and Value of coookie is "+cookie.getValue());
		}
	}

}
