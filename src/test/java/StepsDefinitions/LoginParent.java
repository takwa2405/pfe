package StepsDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginParent { 

	 private static WebDriver driver;
	    private static WebDriverWait wait;

	    @Given("Je suis sur la page d'accueil d'ESBonlineP")
	    public void je_suis_sur_la_page_d_accueil_d_es_bonlineP() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\NG\\Desktop\\takwa\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("https://esprit-tn.com/esponline/online/default.aspx");
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
	    @Then("l'identifiant est incorrect")
	    public void messageErreurIdentifiantIncorrect() {
	        // Code pour vérifier qu'un message d'erreur s'affiche
	        // WebElement messageErreur = driver.findElement(By.id("idMessageErreur"));
	        // String messageErreurText = messageErreur.getText();
	        // assertEquals("Identifiant incorrect", messageErreurText);
	    }


}
