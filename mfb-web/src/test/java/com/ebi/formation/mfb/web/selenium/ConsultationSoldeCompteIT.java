package com.ebi.formation.mfb.web.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class ConsultationSoldeCompteIT {

	private Selenium selenium;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		baseUrl = "http://localhost:8082/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		selenium.setTimeout("1000");
	}

	@Test
	public void testConsultationSoldeCompte() throws Exception {
		selenium.open(baseUrl + "mfb-web/login.html?lang=fr");
		selenium.waitForPageToLoad("10000");
		selenium.type("id=form-top", "user");
		selenium.type("name=j_password", "user");
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		assertEquals(baseUrl + "mfb-web/client/home.html", selenium.getLocation());
		assertTrue(selenium.isTextPresent("00-000-01"));
		assertTrue(selenium.isTextPresent("COMPTE 1 user"));
		assertTrue(selenium.isTextPresent("+ 1 000,00"));
		assertTrue(selenium.isTextPresent("00-000-02"));
		assertTrue(selenium.isTextPresent("COMPTE 2 user"));
		assertTrue(selenium.isTextPresent("+ 2 000,00"));
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		assertEquals(baseUrl + "mfb-web/login.html", selenium.getLocation());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
