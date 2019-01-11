import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Uploading {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		options.addArguments("disable-infobars");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	//	driver.get("http://qtpselenium.com/test/uploadform/contactform.php");
	//	driver.findElement(By.id("photo")).sendKeys("C:\\Users\\STRTT\\Desktop\\Pic\\picture.jpg");
	driver.get("http://facebook.com/");
	driver.findElement(By.id("email")).sendKeys("7892005631");
	driver.findElement(By.id("pass")).sendKeys("sumitplayo");
	driver.findElement(By.xpath("//label[@id='loginbutton']/input")).click();
	driver.findElement(By.xpath("//div[@role='navigation']/div/div/div/a/span")).click();
	//WebElement element = driver.findElement(By.xpath("//div[@class='photoContainer']/div/div/div/a"));
//	WebElement element = driver.findElement(By.xpath("//*[@id='u_fetchstream_2_f']"));
	Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//div[@id='fbTimelineHeadline']/div[3]/div/div/a/img"));
	Actions act = new Actions(driver);
	act.moveToElement(element).build().perform();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[@id='fbTimelineHeadline']/div[3]/div/div/div/div/a")).click();
	Set<String> windows = driver.getWindowHandles();
	System.out.println(windows.size());
	Thread.sleep(4000);
	////span[text()='Upload Photo']
	driver.findElement(By.xpath("//a[@aria-label='Upload Photo']")).click();
	Thread.sleep(3000);
	new ProcessBuilder("D:\\Selenium\\temp.exe","C:\\Users\\STRTT\\Desktop\\Pic\\picture.jpg","open").start();
	windows = driver.getWindowHandles();
	System.out.println(windows.size());
	Thread.sleep(20000);
	//WebDriverWait wait = new WebDriverWait(driver,60);
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-testid='profilePicSaveButton']"))));
	driver.findElement(By.xpath("//button[@data-testid='profilePicSaveButton']")).click();
	
	
	}

}