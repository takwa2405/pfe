package StepsDefinitions;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RécupérationDeMotPasse {

    WebDriver driver;
    WebDriverWait wait;  
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\NG\\Desktop\\takwa\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); // Remplacez "path/to/chromedriver" par le chemin de votre driver Chrome
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @Given("L'utilisateur est sur la page de connexion Outlook")
    public void utilisateur_est_sur_page_connexion_gmail() {
        driver.get("https://outlook.office.com/mail/");
    }


    @When("L'utilisateur se connecte avec l'adresse email {string}")
    public void utilisateur_se_connecte_avec_email(String emailCorrect) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116")));
        emailField.sendKeys(emailCorrect);

        WebElement suivantButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        suivantButton.click();
    }



    @And("L'utilisateur sélectionne le compte professionnel")
    public void utilisateur_selectionne_compte_professionnel() {
        // Attendez que l'élément soit cliquable
        WebElement compteProfessionnelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='aadTileTitle']")));
        
        // Cliquez sur l'élément
        compteProfessionnelButton.click();
    }
    
    
    
    @And("je saisis un mot de passe correct {string}")
    public void je_saisis_un_mot_de_passe_valide_Email(String password) {
        WebElement inputMotDePasse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118"))); // Assurez-vous que l'ID est correct
        inputMotDePasse.sendKeys(password);
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        signInButton.click();
        
   
    }
    @And("L'utilisateur approuve la demande de connexion manuellement")
    public void utilisateur_approuve_demande_connexion_manuellement() throws InterruptedException {
       
        Thread.sleep(30000); // Wait 30 seconds for manual approval
    }

    @And("L'utilisateur répond à la question rester connecté")
    public void utilisateur_repond_rester_connecte() {
        WebElement staySignedInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        staySignedInButton.click();
    }

    @Then("L'utilisateur est redirigé vers la boîte de réception")
    public void utilisateur_est_redirige_vers_boite_de_reception() {
        WebElement inboxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Boîte de réception']"))); // Example XPath, adjust as needed
        Assert.assertTrue(inboxElement.isDisplayed());
    }
    
    @Then("L'utilisateur ouvre l'email pour la récupération de mot de passe")
    public void utilisateur_ouvre_email_recuperation() {
    	 
        // Wait until the specific email is visible and clickable, then click on it
    	 WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'si_noreply@esprit.tn')]")));
         emailElement.click();
        }
    
    @And("Je bascule vers l'onglet Outlook")
    public void bascule_vers_onglet_outlook() {
        
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank', '_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); 
    }
        
        
    
    

    @Given("Je suis sur la page d'accueil d'ESBonlineRCM")
    public void je_suis_sur_la_page_d_accueil_d_esbonlinercm() {
    	
        driver.get("http://192.168.0.21:7070/ESBOnline/Online/default.aspx");
    }

    @And("Une page d'authentification pour espace étudiant s'afficheRCM")
    public void une_page_d_authentification_pour_espace_etudiant_s_affiche() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_TextBox3")));
    }
    

@And("J'entre un identifiant {string} valide1 pour l'utilisateur")
public void entre_identifiant_valide_utilisateur(String identifiantvalide) {
    WebElement identifiantField = driver.findElement(By.id("ContentPlaceHolder1_TextBox3"));
    identifiantField.sendKeys(identifiantvalide);
}

@And("Je clique sur l'étape suivanteRCM")
public void clique_etape_suivante() {
    WebElement etapeSuivanteButton = driver.findElement(By.id("ContentPlaceHolder1_Button3"));
    etapeSuivanteButton.click();
}

@And("L'utilisateur clique sur Mot de passe oublie")
public void clique_mot_passe_oublie() {
    WebElement motPasseOublieLink = driver.findElement(By.id("ContentPlaceHolder1_LinkButton2"));
    motPasseOublieLink.click();
}

@And("L'utilisateur entre son adresse e-mail {string}")
public void entre_adresse_email(String email) {
    WebElement emailField = driver.findElement(By.id("ContentPlaceHolder1_Adresse_mail_esp"));
    emailField.sendKeys(email);
}

@When("L'utilisateur entre son adresse e-mailinvalide {string}")
public void entre_adresse_emailinvalide(String emailinvalide) {
    WebElement emailField = driver.findElement(By.id("ContentPlaceHolder1_Adresse_mail_esp"));
    emailField.sendKeys(emailinvalide);
}
@And("Je clique sur Récupérer mot de passe")
public void clique_recuperer_mot_passe() {
    WebElement recupererMotPasseButton = driver.findElement(By.id("ContentPlaceHolder1_btn_renitialiser_mot_depasse"));
    recupererMotPasseButton.click();
}

@Then("Un message de confirmation \"Un e-mail a été envoyé pour réinitialiser le mot de passe\" doit s'afficher")
public void message_confirmation_affiche() {
   
        // Attendre que l'alerte soit présente
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Accepter l'alerte
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();

    // Attendre que le message de confirmation soit visible
    WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Récupérer le Mot de passe de votre compte')]")));

    // Vérifier que le message de confirmation est affiché
    Assert.assertTrue(confirmationMessage.isDisplayed());
}




@Then("Un message d'erreur doit s'afficher")
public void message_erreur_affiche() {
  
        // Attendre que le message d'erreur soit visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Adresse e-mail incorrecte')]")));
        
        // Vérifier que le message d'erreur est affiché
        Assert.assertTrue(errorMessageBox.isDisplayed());
        // Afficher un message d'erreur si l'élément n'est pas trouvé dans le délai imparti
        System.out.println("Le message d'erreur 'Adresse e-mail incorrecte' n'a pas été trouvé.");
      
}

}