package StepsDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginEnseignant {
	
	
	  private static WebDriver driver;
	    private static WebDriverWait wait;

	    @Given("Je suis sur la page d'accueil d'ESBonlineE")
	    public void je_suis_sur_la_page_d_accueil_d_es_bonline_Enseignant() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\NG\\Desktop\\takwa\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("http://192.168.0.21:7070/ESBOnline/Online/default.aspx");
	    }


	    @When("Je clique sur Enseignant {string}")
	    public void je_clique_sur_Enseignant(String linkText1) {
	        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Espace Enseignants')]")));
	        link.click();
	    }

	    @And("Une page d'authentification pour espace Enseignant s'affiche")
	    public void une_page_d_authentification_pour_espace_Enseignant() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_TextBox1")));
	        Assert.assertTrue(driver.findElement(By.id("ContentPlaceHolder1_TextBox1")).isDisplayed());
	    }
	    
	    @And("J'entre un identifiant incorrect {string} pour Enseignant")
	    public void j_entre_un_identifiant_pour_l_utilisateurE(String identifiant7E) {
	        WebElement inputIdentifiant = driver.findElement(By.id("ContentPlaceHolder1_TextBox1"));
	        inputIdentifiant.sendKeys(identifiant7E);
	    }
	    
	    @And("J'entre un identifiant valide pour Enseignant {string}")
	    public void j_entre_un_identifiant_pour_l_Enseignant(String identifiant9E) {
	        WebElement inputIdentifiant = driver.findElement(By.id("ContentPlaceHolder1_TextBox1"));
	        inputIdentifiant.sendKeys(identifiant9E);
	    }
	    
	    @And("Je clique sur l'étape suivante Enseignant")
	    public void je_clique_sur_l_étape_suivante_Enseignant() {
	        WebElement buttonSuivant = driver.findElement(By.id("ContentPlaceHolder1_Button1"));
	        buttonSuivant.click();
	        
	    }
	    @And("le champ du mot de passe est affiché pour espace enseignant")
	    public void le_champ_du_mot_de_passe_est_affiché_Enseignant() {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_TextBox2")));
	    }
	    @And("je saisis un mot de passe correct Enseignant {string}")
	    public void je_saisis_un_mot_de_passe_correct_Enseignant(String pswPE) {
	        WebElement inputMotDePasse = driver.findElement(By.id("ContentPlaceHolder1_TextBox2"));
	        inputMotDePasse.sendKeys(pswPE);
	          
	    }
	    
	    @And("je saisis un mot de passe incorrect Enseignant {string}")
	    public void je_saisis_un_mot_de_passe_incorrect_Enseignant(String motdepasseincorrectE) {
	        WebElement inputMotDePasse = driver.findElement(By.id("ContentPlaceHolder1_TextBox2"));
	        inputMotDePasse.sendKeys(motdepasseincorrectE);
	    }
	          
	    @And("je clique sur le bouton de connexion Enseignant")
	    public void je_clique_sur_le_bouton_de_connexion() {
	        WebElement buttonConnexion = driver.findElement(By.id("ContentPlaceHolder1_Button2"));
	        buttonConnexion.click();
	    }
	    
	    
	    
	    
	    @Then("revien au page connexion")
	    public void revien_au_page_connexion() {
	        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Identifiant']")));
	     // Get the actual placeholder attribute value
	        String actualPlaceholder = message.getAttribute("placeholder");

	        // Expected placeholder value
	        String expectedPlaceholder = "Identifiant";

	        // Assert that the actual placeholder value matches the expected value
	        Assert.assertEquals(actualPlaceholder, expectedPlaceholder);
	    }
	    @Then("revien au page connexion enseignant")
	    public void revien_au_page_connexion_E() {
	        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Identifiant']")));
	     // Get the actual placeholder attribute value
	        String actualPlaceholder = message.getAttribute("placeholder");

	        // Expected placeholder value
	        String expectedPlaceholder = "Identifiant";

	        // Assert that the actual placeholder value matches the expected value
	        Assert.assertEquals(actualPlaceholder, expectedPlaceholder);
	    }
	    @Then("revien au page connexion et affiche identifiant incorrect")
	    public void revien_au_page_connexion_e() {
	    	 WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Identifiant']")));
		     // Get the actual placeholder attribute value
		        String actualPlaceholder = message.getAttribute("placeholder");

		        // Expected placeholder value
		        String expectedPlaceholder = "Identifiant";

		        // Assert that the actual placeholder value matches the expected value
		        Assert.assertEquals(actualPlaceholder, expectedPlaceholder);
	     
}
	    @Then("affichage d'un message Password incorrect")
	    public void revien_au_page_connexion_enseignant() {
	    	 WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Password incorrect')]")));
		     // Get the actual placeholder attribute value
	    	  Assert.assertEquals("Password incorrect", errorMessage.getText());
	     
}
	    
	    }

	

