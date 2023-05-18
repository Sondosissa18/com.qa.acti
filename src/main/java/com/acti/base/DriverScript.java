package com.acti.base;

import java.io.File;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Name: DriverScripts
 * Description: Manage the driver and browsers related configuration 
 * Developed By: Sondos
 * Reviewed By: Srini
 * Date Reviewed: 05-16-2023
 * */

public class DriverScript {

	public static WebDriver driver;
	Properties prop;

	
	/*
	 * Constructor is responsible for getting the details from properties file
	 */
	public DriverScript() {
		try {
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load confif.properties file, please check " + e.getMessage());

		}
	}
	
	/*
	 * initApplication will get the browser details from the properties file and launch the application 
	 */

	public void initApplication() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(browser + ": in use");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(browser + ": in use");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println(browser + " : in use");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println(browser + "is not supported please check config.properties file");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

		lauchURl();

	}

	/*
	 * load the url from properties file and pass this method to initApplication above
	 */
	public void lauchURl() {
		String url = prop.getProperty("url");
		driver.get(url);

	}
	
	/*
	 * quit the driver
	 */

	public void quitDriver() {
		driver.quit();

	}

}
