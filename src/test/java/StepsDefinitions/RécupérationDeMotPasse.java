package StepsDefinitions;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RécupérationDeMotPasse {
	private WebDriver driver = Hooks.driver;
    private WebDriverWait wait = Hooks.wait;

    @Given("L'utilisateur est sur la page de connexion Outlook")
    public void utilisateur_est_sur_page_connexion_outlook() {
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
        WebElement compteProfessionnelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='aadTileTitle']")));
        compteProfessionnelButton.click();
    }

    @And("je saisis un mot de passe correct {string}")
    public void je_saisis_un_mot_de_passe_correct(String password) {
        WebElement inputMotDePasse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
        inputMotDePasse.sendKeys(password);
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        signInButton.click();
    }

    @And("L'utilisateur approuve la demande de connexion manuellement")
    public void utilisateur_approuve_demande_connexion_manuellement() throws InterruptedException {
        Thread.sleep(30000); // Attendre l'approbation manuelle
    }

    @And("L'utilisateur répond à la question rester connecté")
    public void utilisateur_repond_rester_connecte() {
        WebElement staySignedInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        staySignedInButton.click();
    }

    @Then("L'utilisateur est redirigé vers la boîte de réception")
    public void utilisateur_est_redirige_vers_boite_de_reception() {
        WebElement inboxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Boîte de réception']")));
        Assert.assertTrue(inboxElement.isDisplayed());
    }

    @Then("L'utilisateur ouvre l'email pour la récupération de mot de passe")
    public void utilisateur_ouvre_email_recuperation() {
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
    public void entre_adresse_email(String emailCorrect) {
        WebElement emailField = driver.findElement(By.id("ContentPlaceHolder1_Adresse_mail_esp"));
        emailField.sendKeys(emailCorrect);
    }

    @When("L'utilisateur entre son adresse e-mailinvalide {string}")
    public void entre_adresse_emailinvalide(String  emailinvalide) {
        WebElement emailField = driver.findElement(By.id("ContentPlaceHolder1_Adresse_mail_esp"));
        emailField.sendKeys( emailinvalide);
    }

    @And("Je clique sur Récupérer mot de passe")
    public void clique_recuperer_mot_passe() {
        WebElement recupererMotPasseButton = driver.findElement(By.id("ContentPlaceHolder1_btn_renitialiser_mot_depasse"));
        recupererMotPasseButton.click();
    }

    @Then("Un message de confirmation \"Un e-mail a été envoyé pour réinitialiser le mot de passe\" doit s'afficher")
    public void message_confirmation_affiche() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();

        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Récupérer le Mot de passe de votre compte')]")));
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }

    @Then("Un message d'erreur doit s'afficher")
    public void message_erreur_affiche() {
        WebElement errorMessageBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Adresse e-mail incorrecte')]")));
        Assert.assertTrue(errorMessageBox.isDisplayed());
        System.out.println("Adresse e-mail incorrecte");
    }

    @Then("une capture d'écran est générée de notre email de récupération avec le nom {string}")
    public void genere_Capture_Decran(String nomDefichierDeCapture) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\NG\\Desktop\\RecuperationMotDepasse\\" + nomDefichierDeCapture));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @And("j'attends jusqu'à avoir le message de récupération")
    public void evoir_message_de_recup() {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'si_noreply@esprit.tn')]")));
        assertNotNull(emailElement);
    }
}
