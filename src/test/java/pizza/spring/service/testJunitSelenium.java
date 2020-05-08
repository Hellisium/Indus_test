package pizza.spring.service;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testJunitSelenium {

	  private WebDriver webDriver;

	  @Before
	  public void createWebDriver() {
	    webDriver = new ChromeDriver();
	  }

	  @After
	  public void closeWebDriver() {
	    webDriver.quit();
	  }

	  @Test
		public void commandSucess() throws Exception {

			Resultat resultat = Main.openWith(webDriver).choisirPizza("pizzaId", "//option[. = 'Orientale']")
					.entrerTexte("nom", "HOLEC").entrerTexte("telephone", "0123456789").validerCommande();

			assertTrue(resultat.verifId("recap-commande"));
		}

		@Test
		public void CommandeSansPizza() throws Exception {

			Resultat resultat = Main.openWith(webDriver).entrerTexte("nom", "HOLEC").entrerTexte("telephone", "0123456789").validerCommande();


			assertTrue(resultat.verifId("pizzaId.errors"));
			assertEquals("Choisisez une pizza !", resultat.getValueId("pizzaId.errors"));
		}

		@Test
		public void CommandeSansTel() throws Exception {

			Resultat resultat = Main.openWith(webDriver).choisirPizza("pizzaId", "//option[. = 'Orientale']")
					.entrerTexte("nom", "HOLEC").validerCommande();

			assertTrue(resultat.verifId("telephone.errors"));
			assertEquals("Veuillez mettre un N° de contact", resultat.getValueId("telephone.errors"));
		}

}
