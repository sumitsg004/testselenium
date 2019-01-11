import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class WebTable_CustomFunction {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		//String companyName = "Bata India";
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rediff.com");
		driver.findElement(By.xpath("//*[@id=\"homewrapper\"]/div[5]/a[3]/div/u")).click();
		driver.findElement(By.xpath("//*[@id=\"div_bse_gainer\"]/p/a")).click();
		
		int rowNum = getRowNumberWithData("493.50");
		System.out.println(rowNum);

	}
	public static int getRowNumberWithData(String data)
	{
	/*	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		for(int rowNum = 0; rowNum < rows.size(); rowNum++)
		{
			WebElement row = rows.get(rowNum);
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(int colNum = 0; colNum < cols.size(); colNum++)
			{
				if(cols.get(colNum).getText().equals(data))
					return ++rowNum;
			}
		}
		return 0; */
	int rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
	int cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size();
	for(int i = 1; i <= rows; i++)
	{
		for(int j = 1; j <= cols; j++)
		{
		String text = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
		if(text.equals(data))
			return i;
		}
	}
	return 0;
	}

}
