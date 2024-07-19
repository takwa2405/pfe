package StepsDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RécupérationDeMotPasse {

    WebDriver driver;
    WebDriverWait wait;
    

    @Given("Je suis sur la page d'accueil d'ESBonlineRCM")
    public void je_suis_sur_la_page_d_accueil_d_esbonlinercm() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\NG\\Desktop\\takwa\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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