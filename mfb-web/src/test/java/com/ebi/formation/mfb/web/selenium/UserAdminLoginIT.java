package com.ebi.formation.mfb.web.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UserAdminLoginIT {

	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8082";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUserAdminLogin() throws Exception {
		driver.get(baseUrl + "/mfb-web/login.html?lang=en");
		driver.findElement(By.id("form-top")).clear();
		driver.findElement(By.id("form-top")).sendKeys("useradmin");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("useradmin");
		driver.findElement(By.cssSelector("button.btn")).click();
		assertEquals("http://localhost:8082/mfb-web/client/home.html", driver.getCurrentUrl());
		driver.findElement(By.linkText("Home")).click();
		assertEquals("http://localhost:8082/mfb-web/client/home.html", driver.getCurrentUrl());
		driver.findElement(By.linkText("Administration")).click();
		assertEquals("http://localhost:8082/mfb-web/admin/home.html", driver.getCurrentUrl());
		driver.findElement(By.linkText("Home")).click();
		assertEquals("http://localhost:8082/mfb-web/client/home.html", driver.getCurrentUrl());
		driver.findElement(By.cssSelector("button.btn")).click();
		assertEquals("http://localhost:8082/mfb-web/login.html", driver.getCurrentUrl());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
