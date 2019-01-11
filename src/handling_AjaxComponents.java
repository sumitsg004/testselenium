import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class handling_AjaxComponents {

	public static void main(String[] args) throws InterruptedException {
System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Hello");
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		System.out.println(list.size());
		for(WebElement e:list)
			System.out.println(e.getText());

	}

}
