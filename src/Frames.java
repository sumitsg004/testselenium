import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://paytm.com/");
		
		Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div")).click();
int total_frames = driver.findElements(By.tagName("iframe")).size();
System.out.println(total_frames);
for(int i = 0; i<total_frames; i++)
{
	driver.switchTo().frame(i);
	List<WebElement> list = driver.findElements(By.xpath("//span[text()='Login/Signup with mobile number and password']"));
	if(list.size()==0)
		driver.switchTo().defaultContent();
	else
		break;
			}

//driver.switchTo().frame(0);
driver.findElement(By.xpath("//span[text()='Login/Signup with mobile number and password']")).click();
	}

}
