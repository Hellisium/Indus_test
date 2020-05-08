package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Resultat {

	private WebDriver webDriver;

	public Resultat(WebDriver webDriver) {
		this.webDriver = webDriver;
		assertTrue("Titre de page incorrecte" + webDriver.getTitle(), webDriver.getTitle().endsWith("Pizza Spring"));
	}

	public boolean verifId(String id) {
		return webDriver.findElement(By.id(id)).isDisplayed();
	}

	public String getValueId(String id) {
		return webDriver.findElement(By.id(id)).getText();
	}
}