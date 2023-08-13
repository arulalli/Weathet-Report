import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WeatherReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		System.setProperty("webdriver.chrome.driver",
				"/Users/Gokul/Documents/chrome/chromedriver_mac_arm64/chromedriver");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.visualcrossing.com");

		driver.findElement(By.xpath("//*[@id=\"errorModal\"]/div/div/div[2]/div[2]/button[1]")).click();
		
		driver.findElement(By.cssSelector("a[href='/weather-data']")).click();
		
		driver.findElement(By.id("wxlocation")).sendKeys("Chennai");
		
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
	}

}
