import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class WebTables_Dynamic {

	public static void main(String[] args) {
		
System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		String companyName = "Bata India";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rediff.com");
		driver.findElement(By.xpath("//*[@id=\"homewrapper\"]/div[5]/a[3]/div/u")).click();
		driver.findElement(By.xpath("//*[@id=\"div_bse_gainer\"]/p/a")).click();
		
		List<WebElement> CompanyList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> CurrentpriceList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		System.out.println(CompanyList.size());
		System.out.println(CurrentpriceList.size());
		int cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size();
		int rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
		System.out.println(rows);
		System.out.println(cols);
		int i;
		for(i = 0; i < CompanyList.size(); i++)
		{
			WebElement element = CompanyList.get(i);
			String Name = element.getText();
			if(Name.equals(companyName))
			{
				System.out.println(CurrentpriceList.get(i).getText());
				//i++;
				break;
			}
		}
//		System.out.println(i);
//		WebElement RequiredPrice = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[4]"));
//		String Currentprice = RequiredPrice.getText();
//		System.out.println(Currentprice);
	}

}
