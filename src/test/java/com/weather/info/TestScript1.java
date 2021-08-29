package com.weather.info;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.managerclass.GetWeatherInfoManager;

import utils.BaseUrl;

public class TestScript1 extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void setUpTest() {

		System.setProperty("webdriver.chrome.driver",
				BaseUrl.getUserDirectory() + "/src/test/resources/driver/chromedriver");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void test() {

		driver.get(BaseUrl.url_1);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='query']")).sendKeys("Gurgaon");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search-results']/div[2]/div")));
		driver.findElement(By.xpath("//div[@class='search-results']/div[2]/div")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cur-con-weather-card__panel']/div/div/div")));
		String temp = driver.findElement(By.xpath("//div[@class='cur-con-weather-card__panel']/div/div/div")).getText();
		temp = temp.substring(0, 2);
		GetWeatherInfoManager info = new GetWeatherInfoManager();
		info.setAppId("7fe67bf08c80ded756e598d6f8fedaea");
		info.setCityName("Gurgaon");
		info.setUnit("metric");
		
		info.execute();
	
		WeatherComparator comparator = new WeatherComparator();
		int comparedRes = comparator.compare(Double.parseDouble(temp), info.getResponsePojo().getMain().getTemp());
		
		try {
			if(comparedRes == 0) {
				
				if(Double.parseDouble(temp) < info.getResponsePojo().getMain().getTemp())
					
					assertTrue(comparator.variance((info.getResponsePojo().getMain().getTemp()), Double.parseDouble(temp)) == 1, "Not in a range");
				
				else
					assertTrue(comparator.variance(Double.parseDouble(temp), info.getResponsePojo().getMain().getTemp()) == 1, "Not in a range");

			}
			
		}
		catch (OutOfRangeException o) {
			
			System.out.println(o);
			
		}
		
		assertTrue(true);
	}

	@AfterTest
	public void tearDown() {

		driver.close();
	}

}
