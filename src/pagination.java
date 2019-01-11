import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class pagination {
	static WebDriver driver;
	public static void main(String[] args) {
		String tool = "Java UI Developer";
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		 driver = new FirefoxDriver();
		driver.get("http://dice.com");
		driver.findElement(By.name("q")).sendKeys("java");
		wait(5);
	//	SelectOption(tool, "//ul[@class='typeahead__list']/li");
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='typeahead__list']/li"));
		System.out.println(options.size());
		for(WebElement e : options)
		{
			System.out.println(e.getText());
			if(e.getText().equals(tool))
			{
				e.click();
				break;
			}
		} 
		//write function which takes select parameter and xpath and select required option
		String location = "Chicago Ridge, IL";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys("Chicago");
		wait(5);
		// SelectOption(location,"//ul[@class='typeahead dropdown-menu']/li");
		List<WebElement> options1 = driver.findElements(By.xpath("//ul[@class='typeahead dropdown-menu']/li"));
		System.out.println(options1.size());
		for(WebElement e : options1)
		{
			System.out.println(e.getText());
			if(e.getText().equals(location))
			{
				Actions act = new Actions(driver);
				act.click(e).build().perform();
				//e.click();
				break;
			}
		} 
		driver.findElement(By.id("findTechJobs")).click();
		int i=1;
		do
		{
		waitforPagetoLoad();
		System.out.println("****************PAGE "+i+" jobs");
		List<WebElement> jobLinks = driver.findElements(By.xpath("//span[@itemprop='title']"));
		for(WebElement e : jobLinks)
		{
			if(!e.getText().trim().equals(""))
			System.out.println(e.getText());
		}
		i++;
		driver.findElement(By.xpath("//a[text()='"+i+"']")).click();
		}while(i<=5);
	}
	
	public static void waitforPagetoLoad()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i = 0;
		
			
			//System.out.println(state);
			while(i != 10)
			{
				String state = (String)js.executeScript("return document.readyState");
				if(state.equals("complete"))
					break;
				else
					wait(1);
				i++;
			}
	
			i = 0;
			while(i !=10)
			{
				boolean d = (boolean)js.executeScript("return window.jQuery!=undefined && jQuery.active==0;");	
				System.out.println(d);
				if(d)
					break;
				else
					wait(2);
				i++;
				
			}
		
	}
	public static void wait(int time)
	{
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void SelectOption(String value, String xpath)
	{
		List<WebElement> list = driver.findElements(By.xpath(xpath));
	for(WebElement e : list)
	{
		if(e.getText().equals(value))
		{
			Actions act = new Actions(driver);
			act.click().build().perform();
			break;
		}
	}
	}

}
