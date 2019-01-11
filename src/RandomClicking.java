import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

public class RandomClicking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://americangolf.co.uk/");
		WebElement golfLink = driver.findElement(By.xpath("//*[@id='header-navigation']/div[1]/ul/li[1]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(golfLink).build().perform();
		Thread.sleep(3000); 
		WebElement box = driver.findElement(By.xpath("//*[@id=\"CLUBS_1\"]"));
		List<WebElement> list = box.findElements(By.tagName("a"));
		int n = list.size();
		System.out.println(n);
		Random r = new Random();
		list.get(r.nextInt(n)).getText();
		list.get(r.nextInt(n)).click();
		
		
	}
}
