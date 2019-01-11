import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

public class Draggable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/draggable/");
		int numFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println(numFrames);
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.id("draggable"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(element, 50, 150).build().perform();
		driver.switchTo().defaultContent();
		
	}

}
