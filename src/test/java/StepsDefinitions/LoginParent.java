package StepsDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginParent { 

	private WebDriver driver = Hooks.driver;
    private WebDriverWait wait = Hooks.wait;
	 
	    @Given("Je suis sur la page d'accueil d'ESBonlineP")
	    public void je_suis_sur_la_page_d_accueil_d_es_bonlineP() {
	       
	  
	    }


	    @When("Je clique sur le {string}")
	    public void je_clique_surP(String linkText) {
	        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Espace Parent')]")));
	        link.click();
	    }

	  

	    @And("Une page d'authentification pour espace Parent s'affiche")
	    public void une_page_d_authentification_pour_espace_etudiant_s_affiche() {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Espace Parent')]")));
	  Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Espace Parent')]")).isDisplayed());
	    	    }

	    @And("J'entre un identifiant {string} avec des espaces au début")
	    public void j_entre_un_identifiant_désactivé_pour_l_utilisateur(String identifiantP) throws InterruptedException {
	        WebElement inputIdentifiant = driver.findElement(By.id("ContentPlaceHolder1_TextBox4"));
	        inputIdentifiant.sendKeys(identifiantP);
	        Thread.sleep(5000); // Utilisation de Thread.sleep pour simulation, à éviter dans les tests réels
	        
	    }
	    
	    @And("J'entre un identifiant incorrectP {string} pour l'utilisateur")
	    public void j_entre_un_identifiant_incorrectP_pour_l_utilisateur(String identifiantIncoP) throws InterruptedException {
	        WebElement inputIdentifiant = driver.findElement(By.id("ContentPlaceHolder1_TextBox4"));
	        inputIdentifiant.sendKeys(identifiantIncoP);
	        Thread.sleep(5000); // Utilisation de Thread.sleep pour simulation, à éviter dans les tests réels
	        
	    }
	    @And("J'entre un identifiant valide {string}")
	    public void j_entre_un_identifiant_valide_pour_P(String identifiantvalideP) throws InterruptedException {
	        WebElement inputIdentifiant = driver.findElement(By.id("ContentPlaceHolder1_TextBox4"));
	        inputIdentifiant.sendKeys(identifiantvalideP);
	        Thread.sleep(5000); // Utilisation de Thread.sleep pour simulation, à éviter dans les tests réels
	        
	    }

	    @And("je saisis un mot de passe correctP {string}")
	    public void je_saisis_un_mot_de_passe_correctP(String pswP) {
	        WebElement inputMotDePasse = driver.findElement(By.id("ContentPlaceHolder1_pass_parent"));
	        inputMotDePasse.sendKeys(pswP);
	    } 
	    
	    @And("je saisis un mot de passe incorrectP {string}")
	    public void je_saisis_un_mot_de_passe_incorrectP(String motdepasseincorrectP) {
	        WebElement inputMotDePasse = driver.findElement(By.id("ContentPlaceHolder1_pass_parent"));
	        inputMotDePasse.sendKeys(motdepasseincorrectP);
	    } 
	    @And("je saisis un mot de passe correctP2 {string}")
	    public void je_saisis_un_mot_de_passe_correctP1(String pswP1) {
	        WebElement inputMotDePasse = driver.findElement(By.id("ContentPlaceHolder1_pass_parent"));
	        inputMotDePasse.sendKeys(pswP1);
	    }
	 
	    @And("je clique sur le bouton de connexion suivant")
	    public void je_clique_sur_le_bouton_de_connexion() {
	        WebElement buttonConnexion = driver.findElement(By.id("ContentPlaceHolder1_ButtonParent"));
	        buttonConnexion.click();
	    }

	    @Then("l'utilisateur est redirigé vers son espace Parent")
	    public void l_utilisateur_est_redirigé_vers_son_espace_Parent() {
	    	 
	    	  WebElement userDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Bienvenue dans votre Espace')]")));
	    	    
	    	    Assert.assertTrue(userDashboard.isDisplayed());
	     }
	    
	    @Then("message d'erreur verifier vos parametres")
	    public void un_message_d_erreur_indiquant_que_l_identifiant_est_incorrect() {
	    	 
	    	try {
	            // Attendre jusqu'à 10 secondes pour que l'alerte soit présente
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            
	            // Vérifier que le texte de l'alerte contient "Verifier vos paramètres."
	            Assert.assertTrue(alert.getText().contains("Verifier vos paramètres."));
	            
	            // Accepter (fermer) l'alerte
	            alert.accept();
	        } catch (TimeoutException | NoAlertPresentException e) {
	            System.out.println("Aucune alerte n'est apparue dans le délai imparti ou l'alerte n'était pas présente.");
	            Assert.fail("Aucune alerte trouvée.");
	        }
	    }
	    
	    @Then("um message d'erreur Erreur du serveur dans l'application")
	    public void un_message_d_erreur_indiquant_que_l_identifiant_est_incorrect_devrait_s_afficher() {
	        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Erreur du serveur')]")));
	  
	        Assert.assertEquals("Erreur du serveur dans l'application '/ESBOnline'.", errorMessage.getText());
	    }
	    
	    @Then("un message d'erreur indiquant que cin incorrect")
	    public void un_message_d_erreur_indiquant_que_l_identifiant_est_requis() {
	        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ContentPlaceHolder1_RequiredFieldValidator4\"]")));
	  
	        Assert.assertEquals("Cin incorrect", errorMessage.getText());   
	    }
	    
	    
	    
	   }