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

public class VirementInterneIT {

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
	public void testVirementInterne() throws Exception {
		selenium.open(baseUrl + "mfb-web/login.html?lang=fr");
		selenium.type("id=form-top", "user");
		selenium.type("name=j_password", "user");
		selenium.click("css=button.btn");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("COMPTE 3 user"));
		assertTrue(selenium.isTextPresent("+ 1 500,00"));
		assertTrue(selenium.isTextPresent("COMPTE 4 user"));
		assertTrue(selenium.isTextPresent("+ 2 500,00"));
		selenium.click("link=Virement interne");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=montant", "ggrerg");
		selenium.type(
				"id=motif",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		selenium.click("css=button.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Vous devez saisir un nombre"));
		assertTrue(selenium.isTextPresent("Même compte"));
		assertTrue(selenium.isTextPresent("Le motif doit faire 64 caractères max"));
		selenium.click("link=Annuler le virement");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("COMPTE 3 user"));
		assertTrue(selenium.isTextPresent("+ 1 500,00"));
		assertTrue(selenium.isTextPresent("COMPTE 4 user"));
		assertTrue(selenium.isTextPresent("+ 2 500,00"));
		selenium.click("link=Virement interne");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=montant", "100");
		selenium.select("id=compteADebiter", "label=regexp:COMPTE 3 user / 1\\s500,00 €");
		selenium.select("id=compteACrediter", "label=regexp:COMPTE 4 user / 2\\s500,00 €");
		selenium.type("id=motif", "Virement");
		selenium.click("css=button.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Votre virement a bien été pris en compte."));
		selenium.click("link=Accueil");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("COMPTE 3 user"));
		assertTrue(selenium.isTextPresent("+ 1 400,00"));
		assertTrue(selenium.isTextPresent("COMPTE 4 user"));
		assertTrue(selenium.isTextPresent("+ 2 600,00"));
		selenium.click("link=Accueil");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Historique')])[3]");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Virement"));
		assertTrue(selenium.isTextPresent("- 100,00"));
		selenium.click("link=Revenir à la liste des comptes");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Historique')])[4]");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Virement"));
		assertTrue(selenium.isTextPresent("+ 100,00"));
		selenium.click("link=Virement interne");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=montant", "1500");
		selenium.select("id=compteADebiter", "label=regexp:COMPTE 3 user / 1\\s400,00 €");
		selenium.select("id=compteACrediter", "label=regexp:COMPTE 4 user / 2\\s600,00 €");
		selenium.type("id=motif", "Decouvert");
		selenium.click("css=button.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Le compte à débiter est à découvert."));
		selenium.click("link=Accueil");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("COMPTE 3 user"));
		assertTrue(selenium.isTextPresent("+ 1 400,00"));
		assertTrue(selenium.isTextPresent("COMPTE 4 user"));
		assertTrue(selenium.isTextPresent("+ 2 600,00"));
		selenium.click("link=Virement interne");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=montant", "100");
		selenium.select("id=compteADebiter", "label=regexp:COMPTE 4 user / 2\\s600,00 €");
		selenium.select("id=compteACrediter", "label=regexp:COMPTE 3 user / 1\\s400,00 €");
		selenium.type("id=motif", "Virement 2");
		selenium.click("css=button.btn.btn-success");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Votre virement a bien été pris en compte."));
		selenium.click("link=Accueil");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("COMPTE 3 user"));
		assertTrue(selenium.isTextPresent("+ 1 500,00"));
		assertTrue(selenium.isTextPresent("COMPTE 4 user"));
		assertTrue(selenium.isTextPresent("+ 2 500,00"));
		selenium.click("xpath=(//a[contains(text(),'Historique')])[3]");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Virement 2"));
		assertTrue(selenium.isTextPresent("+ 100,00"));
		selenium.click("link=Revenir à la liste des comptes");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Historique')])[4]");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Virement 2"));
		assertTrue(selenium.isTextPresent("- 100,00"));
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
