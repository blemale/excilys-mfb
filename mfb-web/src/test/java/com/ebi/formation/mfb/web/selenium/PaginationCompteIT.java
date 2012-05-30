package com.ebi.formation.mfb.web.selenium;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PaginationCompteIT {

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
	public void testPaginationCompteIT() throws Exception {
		driver.get(baseUrl + "/mfb-web/login.html?lang=fr");
		driver.findElement(By.id("form-top")).clear();
		driver.findElement(By.id("form-top")).sendKeys("user");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("user");
		driver.findElement(By.cssSelector("button.btn")).click();
		driver.findElement(By.xpath("//section[@id='comptes']/div/div/table/tbody/tr[6]/td[2]")).click();
		driver.findElement(By.linkText("2")).click();
		assertTrue(isElementPresent(By.xpath("//section[@id='compte']/div[2]/div/table[2]/tbody/tr/td")));
		driver.findElement(By.linkText("1")).click();
		assertTrue(isElementPresent(By.xpath("//section[@id='compte']/div[2]/div/table[2]/tbody/tr[2]/td")));
		driver.findElement(By.cssSelector("button.btn")).click();
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
