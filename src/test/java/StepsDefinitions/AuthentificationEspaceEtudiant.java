package StepsDefinitions;


import org.junit.Assert;
import org.openqa.selenium.Alert;
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
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;

import org.apache.commons.io.FileUtils;


import java.io.IOException;


public class AuthentificationEspaceEtudiant  {
	

	private WebDriver driver =Hooks.driver;
    private WebDriverWait wait = Hooks.wait;
   
    // locators Etudiant
    private final By userNamelocator    = By.id("ContentPlaceHolder1_TextBox3") ;
    private final By bottunNextLocator  = By.id("ContentPlaceHolder1_Button3");
    private final By msgIdentIncorrctLocator = By.xpath("//h1[contains(text(),'Erreur du serveur')]");   
    private final By  msgIdentifInvalidLOcators =By.id("ContentPlaceHolder1_LabelError");
    private final By passwordLocator  =By.id("ContentPlaceHolder1_TextBox7");
    private final By bottonConnexionLocator   = By.id("ContentPlaceHolder1_ButtonEtudiant");
    private final By  pageAccuielEtudiantLocator=By.xpath("//h2[contains(text(),'Bienvenue dans votre Espace')]");
    private final By buttonLogoutLocator   =By.id("LinkButton1");
    private final By pageAuthentLocator=By.xpath("//p[contains(text(),'Cette page donne')]");
    private final By  MsgPasswordRequisLocator= By.id("ContentPlaceHolder1_RequiredFieldValidator7");
    private final By  msgIdentifiantRequisLocator = By.xpath("//span[contains(text(),'Cin incorrect')]");
    
    
    @Given("Je suis sur la page d'accueil d'ESBonline")
    public void je_suis_sur_la_page_d_accueil_d_es_bonline() throws Exception  {
    	
    	
    	 //System.setProperty("webdriver.chrome.driver","C:\\Users\\NG\\Desktop\\ESBChrome\\chromedriver-win64\\chromedriver.exe");
        // Configurer les options pour Chrome
    	 
       
 
    
    	 }

    @When("Je clique sur {string}")
    public void je_clique_sur(String linkText) {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
        link.click();
        
        
    }

    @And("Une page d'authentification pour espace étudiant s'affiche")
    public void une_page_d_authentification_pour_espace_etudiant_s_affiche() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNamelocator));
        Assert.assertTrue(driver.findElement(userNamelocator).isDisplayed());
     
    }

  
    @And("J'entre un identifiant {string} désactivé pour l'utilisateur")
    public void j_entre_un_identifiant_désactivé_pour_l_utilisateur(String identifiant6) throws InterruptedException {
        WebElement inputIdentifiant = driver.findElement(userNamelocator);
        inputIdentifiant.sendKeys(identifiant6);
        
        
    }
    @And("J'entre un identifiant incorrect {string} pour l'utilisateur")
    public void j_entre_un_identifiant_pour_l_utilisateur(String identifiant7) {
        WebElement inputIdentifiant = driver.findElement( userNamelocator);
        inputIdentifiant.sendKeys(identifiant7);
    }
    
    @Then("une capture d'écran est générée de l'espace etudiant etudiant avec identifiant incorrect {string}")
    public void genere_Capture_Decran_pour_espace_etudiant_identifiantIncorrect(String nomDefichierDeCapture2)
    {
    	
    	
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	// Now you can do whatever you need to do with it, for example copy somewhere
    	try {
    		FileUtils.copyFile(scrFile, new File("C:\\Users\\NG\\Desktop\\captureDecranEtudiant1\\" +nomDefichierDeCapture2));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    @And("je saisis un identifiant invalide {string}")
    public void je_saisis_un_identifiant_invalide(String identifiant8) throws InterruptedException {
        WebElement inputIdentifiant = driver.findElement( userNamelocator);
        inputIdentifiant.sendKeys(identifiant8);
        // Utilisation de Thread.sleep pour simulation, à éviter dans les tests réels
    }
    @Then("une capture d'écran est générée de l'espace etudiant etudiant avec identifiant invalide {string}")
    public void genere_Capture_Decran_pour_espace_etudiant_identifiantInvalide(String nomDefichierDeCapture3)
    {
    	
    	
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	// Now you can do whatever you need to do with it, for example copy somewhere
    	try {
    		FileUtils.copyFile(scrFile, new File("C:\\Users\\NG\\Desktop\\captureDecranEtudiant1\\" +nomDefichierDeCapture3));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    @And(" je saisis un identifiant  vide {string}")
    public void je_saisis_un_identifiant_vide(String identifiantvide) throws InterruptedException {
        WebElement inputIdentifiant = driver.findElement( userNamelocator);
        inputIdentifiant.sendKeys(identifiantvide);
        // Utilisation de Thread.sleep pour simulation, à éviter dans les tests réels
    }
    @Then("une capture d'écran est générée de l'espace etudiant etudiant identifiant vide {string}")
    public void genere_Capture_Decran_pour_espace_etudiant_identifiantvide(String nomDefichierDeCapture5)
    {
    	
    	
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	// Now you can do whatever you need to do with it, for example copy somewhere
    	try {
    		FileUtils.copyFile(scrFile, new File("C:\\Users\\NG\\Desktop\\captureDecranEtudiant1\\" +nomDefichierDeCapture5));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
       
  

    @And("Je clique sur l'étape suivante")
    public void je_clique_sur_l_étape_suivante() {
        WebElement buttonSuivant = driver.findElement(bottunNextLocator);
        buttonSuivant.click();
    }

    @And("Un message d'erreur indiquant que Veuillez régler votre situation financière !")
    public void un_message_d_erreur_indiquant_que_le_compte_est_désactivé_devrait_s_afficher() {
    	 Alert alert = driver.switchTo().alert();
         
         // Vérifier si le texte de l'alerte correspond à ce que vous attendez
         String alertText = alert.getText();
         Assert.assertTrue(alertText.contains("Veuillez régler votre situation financière !"));
         
         // Accepter l'alerte pour la fermer
         alert.accept();    }

    // Implémentez les étapes restantes en suivant le même modèle

  
    @And("Un message d'erreur indiquant que l'identifiant est incorrect devrait s'afficher")
    public void un_message_d_erreur_indiquant_que_l_identifiant_est_incorrect_devrait_s_afficher() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(msgIdentIncorrctLocator));
  
        Assert.assertEquals("Erreur du serveur dans l'application '/ESBOnline'.", errorMessage.getText());
    }
    
    


    @And("un message d'erreur indiquant que l'identifiant est invalide est affiché")
    public void un_message_d_erreur_indiquant_que_l_identifiant_est_invalide_est_affiché() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(msgIdentifInvalidLOcators));
        Assert.assertTrue(errorMessage.isDisplayed());
        String expectedErrorMessage = "identifiant invalide"; // Vérifiez le texte exact attendu
        Assert.assertEquals(expectedErrorMessage, errorMessage.getText());
    }

    @And("je saisis un identifiant  valide de l'utilisateur {string}")
    public void je_saisis_l_identifiant_de_l_utilisateur(String identifiant9) {
        WebElement inputIdentifiant = driver.findElement(userNamelocator);
        inputIdentifiant.sendKeys(identifiant9);
    }

    @And("le champ du mot de passe est affiché")
    public void le_champ_du_mot_de_passe_est_affiché() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
    }

    @And("je saisis un mot de passe incorrect {string}")
    public void je_saisis_un_mot_de_passe_incorrect(String motdepasseincorrect) {
        WebElement inputMotDePasse = driver.findElement(passwordLocator);
        inputMotDePasse.sendKeys(motdepasseincorrect);
         
    }
    @And("je laisse le champ du mot de passe vide {string}")
    public void je_saisis_un_mot_de_passe_vide(String mdpvide) {
        WebElement inputMotDePasse = driver.findElement(passwordLocator);
        inputMotDePasse.sendKeys(mdpvide);
    }
    @Then("une capture d'écran est générée de l'espace etudiant avec un identifiant valide et de mot de passe vide {string}")
    public void genere_Capture_Decran_pour_espace_etudiant_motDePasseVidde(String nomDefichierDeCapture6)
    {
    	
    	
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	// Now you can do whatever you need to do with it, for example copy somewhere
    	try {
    		FileUtils.copyFile(scrFile, new File("C:\\Users\\NG\\Desktop\\captureDecranEtudiant1\\" +nomDefichierDeCapture6));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	}
    @And("je saisis un  mot de passe  valide {string}")
    public void je_saisis_un_mot_de_passe_valide(String motdepassecorrecte) {
        WebElement inputMotDePasse = driver.findElement(passwordLocator);
        inputMotDePasse.sendKeys(motdepassecorrecte);
    }

    @And("je clique sur le bouton de connexion")
    public void je_clique_sur_le_bouton_de_connexion() {
        WebElement buttonConnexion = driver.findElement(bottonConnexionLocator);
        buttonConnexion.click();
    }

    @And("l'utilisateur est redirigé vers son espace étudiant")
    public void l_utilisateur_est_redirigé_vers_son_espace_étudiant() {
    	 
    	  WebElement userDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(pageAccuielEtudiantLocator));
    	    
    	    Assert.assertTrue(userDashboard.isDisplayed());
     }
    @Then("une capture d'écran est générée de l'espace etudiant avec un identifiant et mot de passe valides {string}")
    public void genere_Capture_Decran_pour_espace_etudiant_identifiantValide(String nomDefichierDeCapture7)
    {
    	
    	
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	// Now you can do whatever you need to do with it, for example copy somewhere
    	try {
    		FileUtils.copyFile(scrFile, new File("C:\\Users\\NG\\Desktop\\captureDecranEtudiant1\\" +nomDefichierDeCapture7));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
       
    
    @And("je clique sur le bouton de déconnexion")
    public void je_clique_sur_le_bouton_de_déconnexion() {
        WebElement logoutButton = driver.findElement(buttonLogoutLocator);
        logoutButton.click();
    }

    @Then("l'utilisateur est déconnecté et redirigé vers la page de connexion")
    public void l_utilisateur_est_déconnecté_et_redirigé_vers_la_page_de_connexion() {
        WebElement loginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(pageAuthentLocator));
        Assert.assertTrue(loginPage.isDisplayed());
        
    }
        @Then("une capture d'écran est générée de l'espace etudiant etudiant avec identifiant disactivé {string}")
        public void genere_Capture_Decran_pour_espace_etudiant(String nomDefichierDeCapture1)
        {
        	
        	
        	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	// Now you can do whatever you need to do with it, for example copy somewhere
        	try {
        		FileUtils.copyFile(scrFile, new File("C:\\Users\\NG\\Desktop\\captureDecranEtudiant1\\" +nomDefichierDeCapture1));
        	} catch (IOException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
     
    }
    @And("un message d'erreur indiquant que le mot de passe est requis est affiché")
    public void un_message_d_erreur_indiquant_que_l_identifiant_est_requis_devrait_s_afficher() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(MsgPasswordRequisLocator));
  
        Assert.assertEquals("Mot de passe incorrect", errorMessage.getText());
    }
    
    @And("un message d'erreur indiquant que le mot de passe est incorrect est affiché")
    public void un_message_d_erreur_indiquant_que_l_identifiant_est_incorrect() {
    	 
        Assert.assertTrue( driver.switchTo().alert().getText().contains("Verifier vos paramètres"));
        driver.switchTo().alert().accept();
    }
    @Then("une capture d'écran est générée de l'espace etudiant etudiant identifiant valide et un mot de passe incorrect {string}")
    public void genere_Capture_Decran_pour_espace_etudiant_identifiantvalide_mot_de_passe_incorrect(String nomDefichierDeCapture4)
    {
    	
    	
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	// Now you can do whatever you need to do with it, for example copy somewhere
    	try {
    		FileUtils.copyFile(scrFile, new File("C:\\Users\\NG\\Desktop\\captureDecranEtudiant1\\" +nomDefichierDeCapture4));
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    @And("un message d'erreur indiquant que l'identifiant est requis est affiché")
    public void un_message_d_erreur_indiquant_que_l_identifiant_est_requis() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(msgIdentifiantRequisLocator));
  
        Assert.assertEquals("Cin incorrect", errorMessage.getText());
    }
   // @After
   // public void fermerNavigateur() {
       //if (driver != null) {
           // driver.quit();
      //  }
    //}

   
    
}
