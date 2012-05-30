package com.ebi.formation.mfb.web.selenium;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LienRetourCompteEtCarteIT {

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
	public void testLienRetourCompteEtCarteIT() throws Exception {
		driver.get(baseUrl + "/mfb-web/login.html?lang=fr");
		driver.findElement(By.id("form-top")).clear();
		driver.findElement(By.id("form-top")).sendKeys("user");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("user");
		driver.findElement(By.cssSelector("button.btn")).click();
		driver.findElement(By.xpath("//section[@id='comptes']/div/div/table/tbody/tr[6]/td[2]")).click();
		driver.findElement(By.cssSelector("td.aligneSolde.coloreVert")).click();
		driver.findElement(By.linkText("Revenir au détail du compte")).click();
		driver.findElement(By.linkText("Revenir à la liste des comptes")).click();
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
}
