package com.progressive.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.progressive.utils.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Configuration configuration = new Configuration(null);

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = localDriver("chrome");
		driver.get(configuration.getConfiguration("url"));
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageLoadWait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));
	}

	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		return driver;
	}

	protected WebDriver getDriver() {
		return driver;

	}

	@AfterMethod
	public void terminate() {
		driver.quit();

	}

}
