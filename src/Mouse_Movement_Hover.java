import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mouse_Movement_Hover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.americangolf.co.uk/");
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id='header-navigation']/div[1]/ul/li[1]/a"));
		act.moveToElement(element).build().perform();
		WebElement putters = driver.findElement(By.xpath("//*[@id=\"CLUBS_1\"]/ul/li[3]/ul/li/a/span"));
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(putters));
		putters.click();
		
	}

}
