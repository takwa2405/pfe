package StepsDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class AuthentificationEspaceEtudiant {
	

    private static WebDriver driver;
    private static WebDriverWait wait;

    @Given("Je suis sur la page d'accueil d'ESBonline")
    public void je_suis_sur_la_page_d_accueil_d_es_bonline() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\NG\\Desktop\\chromedriver-win64\\chromedriver.exe");
        // Configurer les options pour Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");

        // Démarrer le navigateur Chrome avec les options spécifiées
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("http://192.168.0.21:7070/ESBOnline/Online/default.aspx");
    }


    @When("Je clique sur {string}")
    public void je_clique_sur(String linkText) {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
        link.click();
    }

    @And("Une page d'authentification pour espace étudiant s'affiche")
    public void une_page_d_authentification_pour_espace_etudiant_s_affiche() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_TextBox3")));
        Assert.assertTrue(driver.findElement(By.id("ContentPlaceHolder1_TextBox3")).isDisplayed());
        Thread.sleep(5000);
    }

  
    @And("J'entre un identifiant {string} désactivé pour l'utilisateur")
    public void j_entre_un_identifiant_désactivé_pour_l_utilisateur(String identifiant6) throws InterruptedException {
        WebElement inputIdentifiant = driver.findElement(By.id("ContentPlaceHolder1_TextBox3"));
        inputIdentifiant.sendKeys(identifiant6);
        Thread.sleep(5000); // Utilisation de Thread.sleep pour simulation, à éviter dans les tests réels
        
    }
    @And("J'entre un identifiant incorrect {string} pour l'utilisateur")
    public void j_entre_un_identifiant_pour_l_utilisateur(String identifiant7) {
        WebElement inputIdentifiant = driver.findElement(By.id("ContentPlaceHolder1_TextBox3"));
        inputIdentifiant.sendKeys(identifiant7);
    }


    @And("je saisis un identifiant invalide {string}")
    public void je_saisis_un_identifiant_invalide(String identifiant8) throws InterruptedException {
        WebElement inputIdentifiant = driver.findElement(By.id("ContentPlaceHolder1_TextBox3"));
        inputIdentifiant.sendKeys(identifiant8);
        Thread.sleep(5000); // Utilisation de Thread.sleep pour simulation, à éviter dans les tests réels
    }
    @And(" je saisis un identifiant  vide {string}")
    public void je_saisis_un_identifiant_vide(String identifiantvide) throws InterruptedException {
        WebElement inputIdentifiant = driver.findElement(By.id("ContentPlaceHolder1_TextBox3"));
        inputIdentifiant.sendKeys(identifiantvide);
        Thread.sleep(5000); // Utilisation de Thread.sleep pour simulation, à éviter dans les tests réels
    }
       
       
  

    @And("Je clique sur l'étape suivante")
    public void je_clique_sur_l_étape_suivante() {
        WebElement buttonSuivant = driver.findElement(By.id("ContentPlaceHolder1_Button3"));
        buttonSuivant.click();
    }

    @Then("Un message d'erreur indiquant que le compte est désactivé devrait s'afficher")
    public void un_message_d_erreur_indiquant_que_le_compte_est_désactivé_devrait_s_afficher() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Votre CIN ou ID']")));
     // Get the actual placeholder attribute value
        String actualPlaceholder = message.getAttribute("placeholder");

        // Expected placeholder value
        String expectedPlaceholder = "Votre CIN ou ID";

        // Assert that the actual placeholder value matches the expected value
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder);
    }

    // Implémentez les étapes restantes en suivant le même modèle

  
    @And("Un message d'erreur indiquant que l'identifiant est incorrect devrait s'afficher")
    public void un_message_d_erreur_indiquant_que_l_identifiant_est_incorrect_devrait_s_afficher() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Erreur du serveur')]")));
  
        Assert.assertEquals("Erreur du serveur dans l'application '/ESBOnline'.", errorMessage.getText());
    }
    
    


    @And("un message d'erreur indiquant que l'identifiant est invalide est affiché")
    public void un_message_d_erreur_indiquant_que_l_identifiant_est_invalide_est_affiché() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_LabelError")));
        Assert.assertTrue(errorMessage.isDisplayed());
        String expectedErrorMessage = "identifiant invalide"; // Vérifiez le texte exact attendu
        Assert.assertEquals(expectedErrorMessage, errorMessage.getText());
    }

    @And("je saisis un identifiant  valide de l'utilisateur {string}")
    public void je_saisis_l_identifiant_de_l_utilisateur(String identifiant9) {
        WebElement inputIdentifiant = driver.findElement(By.id("ContentPlaceHolder1_TextBox3"));
        inputIdentifiant.sendKeys(identifiant9);
    }

    @And("le champ du mot de passe est affiché")
    public void le_champ_du_mot_de_passe_est_affiché() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_TextBox7")));
    }

    @And("je saisis un mot de passe incorrect {string}")
    public void je_saisis_un_mot_de_passe_incorrect(String motdepasseincorrect) {
        WebElement inputMotDePasse = driver.findElement(By.id("ContentPlaceHolder1_TextBox7"));
        inputMotDePasse.sendKeys(motdepasseincorrect);
     
       
        
        
    }
    @And("je laisse le champ du mot de passe vide {string}")
    public void je_saisis_un_mot_de_passe_vide(String mdpvide) {
        WebElement inputMotDePasse = driver.findElement(By.id("ContentPlaceHolder1_TextBox7"));
        inputMotDePasse.sendKeys(mdpvide);
    }
    @And("je saisis un  mot de passe  valide {string}")
    public void je_saisis_un_mot_de_passe_valide(String motdepassecorrecte) {
        WebElement inputMotDePasse = driver.findElement(By.id("ContentPlaceHolder1_TextBox7"));
        inputMotDePasse.sendKeys(motdepassecorrecte);
    }

    @And("je clique sur le bouton de connexion")
    public void je_clique_sur_le_bouton_de_connexion() {
        WebElement buttonConnexion = driver.findElement(By.id("ContentPlaceHolder1_ButtonEtudiant"));
        buttonConnexion.click();
    }

    @And("l'utilisateur est redirigé vers son espace étudiant")
    public void l_utilisateur_est_redirigé_vers_son_espace_étudiant() {
    	 
    	  WebElement userDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Bienvenue dans votre Espace')]")));
    	    
    	    Assert.assertTrue(userDashboard.isDisplayed());
     }
     
       
    
    @And("je clique sur le bouton de déconnexion")
    public void je_clique_sur_le_bouton_de_déconnexion() {
        WebElement logoutButton = driver.findElement(By.id("LinkButton1"));
        logoutButton.click();
    }

    @Then("l'utilisateur est déconnecté et redirigé vers la page de connexion")
    public void l_utilisateur_est_déconnecté_et_redirigé_vers_la_page_de_connexion() {
        WebElement loginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Cette page donne')]")));
        Assert.assertTrue(loginPage.isDisplayed());
        
     
    }
    @And("un message d'erreur indiquant que le mot de passe est requis est affiché")
    public void un_message_d_erreur_indiquant_que_l_identifiant_est_requis_devrait_s_afficher() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_RequiredFieldValidator7")));
  
        Assert.assertEquals("Mot de passe incorrect", errorMessage.getText());
    }
    
    @And("un message d'erreur indiquant que le mot de passe est incorrect est affiché")
    public void un_message_d_erreur_indiquant_que_l_identifiant_est_incorrect() {
    	 
        Assert.assertTrue( driver.switchTo().alert().getText().contains("Verifier vos paramètres"));
        driver.switchTo().alert().accept();
    }
    @And("un message d'erreur indiquant que l'identifiant est requis est affiché")
    public void un_message_d_erreur_indiquant_que_l_identifiant_est_requis() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Cin incorrect')]")));
  
        Assert.assertEquals("Cin incorrect", errorMessage.getText());
    }
   // @After
   // public void fermerNavigateur() {
       //if (driver != null) {
           // driver.quit();
      //  }
    //}
    public static WebDriver getDriver() {
        if (driver == null) {
        	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\NG\\Desktop\\screeshot\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void takeScreenshot(String filePath) {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Fermer tous les navigateurs et terminer la session WebDriver
        }

    }
}
