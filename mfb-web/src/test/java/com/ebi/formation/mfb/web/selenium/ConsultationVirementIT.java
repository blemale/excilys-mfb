package com.ebi.formation.mfb.web.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class ConsultationVirementIT {

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
	public void testPlop() throws Exception {
		selenium.open(baseUrl + "mfb-web/login.html?lang=fr");
		selenium.type("id=form-top", "user");
		selenium.type("name=j_password", "user");
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Historique virement");
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=2");
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=1");
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Mois précédent");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Mois précédent");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Mois précédent");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Mois précédent");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Mois précédent");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Mois suivant");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Mois suivant");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Mois suivant");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Mois suivant");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Mois suivant");
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Revenir à la liste des comptes");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Historique virement')])[2]");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Pas de virement ce mois ci"));
		selenium.click("link=Revenir à la liste des comptes");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		assertEquals(baseUrl + "mfb-web/login.html", selenium.getLocation());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
