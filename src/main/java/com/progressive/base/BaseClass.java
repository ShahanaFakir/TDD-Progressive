package com.progressive.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.progressive.common.Commons;
import com.progressive.objects.AutoPage;
import com.progressive.objects.BirthdatePage;
import com.progressive.objects.HomePage;
import com.progressive.utils.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Configuration configuration = new Configuration(null);

	WebDriver driver;
	protected HomePage homePage;
	protected Commons commons;
	protected AutoPage aboutP;
	protected BirthdatePage birthdatePage;

	@BeforeMethod
	public void setUp() {
		driver = localDriver("chrome");
		driver.manage().window().maximize();
		driver.get(configuration.getConfiguration("url"));
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageLoadWait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));
		initClasses();
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

	private void initClasses() {
		commons = new Commons();
		homePage = new HomePage(driver, commons);
		aboutP = new AutoPage(driver, commons);
		birthdatePage = new BirthdatePage(driver, commons);

	}

	@AfterMethod
	public void terminate() {
		driver.quit();

	}

}
