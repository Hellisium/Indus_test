package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main {

	private WebDriver webDriver;

	public Main(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public Main open() {
		webDriver.navigate().to("http://localhost:8084/pizza-spring/commande");
		assertTrue("Titre de page incorrecte " + webDriver.getTitle(), webDriver.getTitle().startsWith("Pizza Spring"));
		return this;
	}

	public static Main openWith(WebDriver webDriver) {
		Main main = new Main(webDriver);
		main.open();
		return main;
	}

	public Main entrerTexte(String id, String... words) {
		WebElement searchInput = webDriver.findElement(By.id(id));
		searchInput.sendKeys(String.join(" ", words));
		return this;
	}

	public Main choisirPizza(String id, String pizza) {
		WebElement searchInput = webDriver.findElement(By.id(id));
		searchInput.findElement(By.xpath(pizza)).click();
		return this;
	}

	public Resultat validerCommande() {
		WebElement searchButton = webDriver.findElement(By.cssSelector("button"));
		searchButton.click();
		return new Resultat(webDriver);
	}

}