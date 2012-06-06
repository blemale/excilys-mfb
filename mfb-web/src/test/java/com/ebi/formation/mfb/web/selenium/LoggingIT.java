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

public class LoggingIT {

	private Selenium selenium;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		baseUrl = "http://localhost:8082/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		selenium.setTimeout("5000");
	}

	@Test
	public void testConsultationSolde() throws Exception {
		selenium.open(baseUrl + "mfb-web/login.html?lang=fr");
		selenium.type("id=form-top", "user");
		selenium.type("name=j_password", "user");
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Tahar Bakir"));
		assertTrue(selenium.isTextPresent("COMPTE 1 user"));
		assertTrue(selenium.isTextPresent("COMPTE 2 user"));
		selenium.click("link=Accueil");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("COMPTE 1 user"));
		assertTrue(selenium.isTextPresent("COMPTE 2 user"));
		selenium.click("link=Virement interne");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Effectuer le virement"));
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=form-top", "admin");
		selenium.type("name=j_password", "admin");
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Bastien Lemale"));
		assertTrue(selenium.isTextPresent("MF Banking - Administration"));
		selenium.click("link=Accueil");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("MF Banking - Administration"));
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=form-top", "useradmin");
		selenium.type("name=j_password", "useradmin");
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("François Guillain"));
		assertTrue(selenium.isTextPresent("Vous n'avez aucun compte."));
		selenium.click("link=Accueil");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Vous n'avez aucun compte."));
		selenium.click("link=Virement interne");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Effectuer le virement"));
		selenium.click("link=Administration");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("MF Banking - Administration"));
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		assertEquals(baseUrl + "mfb-web/login.html", selenium.getLocation());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
