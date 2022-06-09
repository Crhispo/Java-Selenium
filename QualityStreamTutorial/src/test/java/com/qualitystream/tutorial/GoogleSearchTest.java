package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	private WebDriver Driver;
	private String StringWebDriver = "webdriver.chrome.driver";
	private String UrlWebDriver = "./src/test/resources/chromedriver/chromedriver.exe";
	
	@Before
	public void setUp() {
		System.setProperty(StringWebDriver, UrlWebDriver);
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://www.google.com/");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void TestGooglePage() {
		WebElement searchbox = Driver.findElement(By.name("q"));
		searchbox.clear();

		searchbox.sendKeys("quality-stream Introduccion a la Automatizacion de Pruebas de Software");

		searchbox.submit();

		Driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		assertEquals("quality-stream Introduccion a la Automatizacion de Pruebas de Software - Buscar con Google",
				Driver.getTitle());
		
		}

		@After
		public void TearDown() {
			Driver.quit();
		}
	
}
