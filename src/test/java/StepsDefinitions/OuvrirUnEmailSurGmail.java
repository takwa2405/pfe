package StepsDefinitions;

import java.time.Duration;

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

public class OuvrirUnEmailSurGmail {

    WebDriver driver;
    private static WebDriverWait wait;

    @Given("L'utilisateur est sur la page de connexion outlook")
    public void utilisateur_est_sur_page_connexion_gmail() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\NG\\Desktop\\takwa\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://outlook.office.com/mail/");
    }

    @When("L'utilisateur se connecte avec l'adresse email {string}")
    public void utilisateur_se_connecte_avec_email(String  emailCorrect) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116")));
        emailField.sendKeys(emailCorrect);
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        nextButton.click();
    }

    @And("Créé par vous")
    public void je_clique_sur_Créé_par_vous() {
        WebElement buttonCreeParVous = wait.until(ExpectedConditions.elementToBeClickable(By.id("msaTileHint")));
        buttonCreeParVous.click();
    }

    @And("je saisis un mot de passe correct {string}")
    public void je_saisis_un_mot_de_passe_valide_Email(String password) {
        WebElement inputMotDePasse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118"))); // Assurez-vous que l'ID est correct
        inputMotDePasse.sendKeys(password);
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
        signInButton.click();
    }

    @And("L'utilisateur ouvre l'email avec le sujet {string}")
    public void utilisateur_ouvre_email_avec_sujet(String subject) {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), '" + subject + "')]")));
        email.click();
    }

    @Then("L'utilisateur doit voir le contenu de l'email")
    public void utilisateur_voit_contenu_email() {
        WebElement emailBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.a3s.aXjCH")));
        assert emailBody.isDisplayed();
    }
}
