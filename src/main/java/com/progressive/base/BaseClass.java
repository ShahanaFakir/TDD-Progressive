package com.progressive.base;

import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.progressive.common.CommonFunctions;
import com.progressive.common.CommonWaits;
import com.progressive.objects.AboutVehiclePage;
import com.progressive.objects.AutoAndHomePage;
import com.progressive.objects.AutoPage;
import com.progressive.objects.BirthdatePage;
import com.progressive.objects.HomePage;
import com.progressive.reporting.ExtentManager;
import com.progressive.reporting.ExtentTestManager;
import com.progressive.utils.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Configuration configuration = Configuration.getInstance();

	WebDriver driver;
	WebDriverWait wait;
	CommonWaits waits;
	ExtentReports extent;

	protected CommonFunctions commons;
	protected HomePage homePage;
	protected AutoPage aboutP;
	protected BirthdatePage birthdatePage;
	protected AboutVehiclePage aboutVehiclePage;
	protected AutoAndHomePage aboutAutoAndHomePage;

	@BeforeSuite
	public void initiatingReport() {
		extent = ExtentManager.initiatingReport();
	}

	@BeforeMethod
	public void beforeEachTest(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManager.creatingTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);

	}

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser1) {
		driver = localDriver("browser1");
		driver.manage().window().maximize();
		driver.get(configuration.get("url"));
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.get("pageLoadWait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.get("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.get("explicitWait"))));
		initClasses();
	}

	@AfterMethod
	public void afterEachtest(Method method, ITestResult result) {
		for (String group : result.getMethod().getGroups()) {
			ExtentTestManager.getTest().assignCategory(group);
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "Test Passes");
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed \n" + result.getThrowable());
			ExtentTestManager.getTest().addScreenCaptureFromPath(commons.getScreenshot(method.getName()));
		}
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
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	protected WebDriver getDriver() {
		return driver;

	}

	private void initClasses() {
		waits = new CommonWaits(wait);
		commons = new CommonFunctions(driver, waits);
		homePage = new HomePage(driver, commons);
		aboutP = new AutoPage(driver, commons);
		birthdatePage = new BirthdatePage(driver, commons);
		aboutVehiclePage = new AboutVehiclePage(driver, commons);
		aboutAutoAndHomePage = new AutoAndHomePage(driver, commons);

	}

	@AfterMethod
	public void terminate() {
		driver.quit();

	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}
