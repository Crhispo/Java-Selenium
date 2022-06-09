package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
	private WebDriver Driver;
	private String StringWebDriver = "webdriver.chrome.driver";
	private String UrlWebDriver = "./src/test/resources/chromedriver/chromedriver.exe";
	private By RegisterLinkLocater = By.linkText("REGISTER");
	private By ResgisterPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	private By UserNameLocator = By.id("email");
	private By PasswordLocator = By.name("password");
	private By ConfirmPassword = By.xpath("//input[@name='confirmPassword']");
	private By RegisterBtnLocator = By.name("submit");
	private By UseLocator = By.name("userName");
	private By passLocator = By.name("password");
	private By SingLocator = By.name("submit");

	@Before
	public void setUp() throws Exception {
		System.setProperty(StringWebDriver, UrlWebDriver);
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
		Driver.quit();
	}
	
	@Test
	public void SingIn() throws InterruptedException {
		if (Driver.findElement(UseLocator).isDisplayed()) {
			Driver.findElement(UseLocator).sendKeys("Crhistian");
			Driver.findElement(passLocator).sendKeys("MofuMofu#13");
			Driver.findElement(SingLocator).click();
			Thread.sleep(2000);
			List<WebElement> fonts = Driver.findElements(By.tagName("font"));
			assertTrue(fonts.get(3).isDisplayed());
		} else {
			System.out.print("Username textbox was not present");
		}
	}
	@Test
	public void RegisterUser() throws InterruptedException {
		Driver.findElement(RegisterLinkLocater).click();
		Thread.sleep(2000);
		if (Driver.findElement(ResgisterPageLocator).isDisplayed()) {
			Driver.findElement(UserNameLocator).sendKeys("Crhistian");
			Driver.findElement(PasswordLocator).sendKeys("MofuMofu#13");
			Driver.findElement(ConfirmPassword).sendKeys("MofuMofu#13");
			Driver.findElement(RegisterBtnLocator).click();
		} else {
			System.out.print("Register page was not found");
		}
		List<WebElement> fonts = Driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is Crhistian.", fonts.get(5).getText());
	}
}
