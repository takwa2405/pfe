/*
 * package StepsDefinitions;
 * 
 * import java.time.Duration; import java.util.ArrayList;
 * 
 * import org.junit.Assert; import org.openqa.selenium.Alert; import
 * org.openqa.selenium.By; import org.openqa.selenium.JavascriptExecutor; import
 * org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import io.cucumber.java.Before; import io.cucumber.java.en.And; import
 * io.cucumber.java.en.Given; import io.cucumber.java.en.Then; import
 * io.cucumber.java.en.When;
 * 
 * public class OuvrirUnEmailSurGmail {
 * 
 * WebDriver driver; private static WebDriverWait wait;
 * 
 * 
 * @Before public void setUp() { System.setProperty("webdriver.chrome.driver",
 * "C:\\Users\\NG\\Desktop\\takwa\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"
 * ); // Remplacez "path/to/chromedriver" par le chemin de votre driver Chrome
 * driver = new ChromeDriver(); wait = new WebDriverWait(driver,
 * Duration.ofSeconds(10)); }
 * 
 * @Given("L'utilisateur est sur la page de connexion Outlook") public void
 * utilisateur_est_sur_page_connexion_gmail() {
 * driver.get("https://outlook.office.com/mail/"); }
 * 
 * 
 * @When("L'utilisateur se connecte avec l'adresse email {string}") public void
 * utilisateur_se_connecte_avec_email(String emailCorrect) { WebElement
 * emailField =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116")));
 * emailField.sendKeys(emailCorrect);
 * 
 * WebElement suivantButton =
 * wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
 * suivantButton.click(); }
 * 
 * 
 * 
 * @And("L'utilisateur sélectionne le compte professionnel") public void
 * utilisateur_selectionne_compte_professionnel() { // Attendez que l'élément
 * soit cliquable WebElement compteProfessionnelButton =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//*[@id='aadTileTitle']")));
 * 
 * // Cliquez sur l'élément compteProfessionnelButton.click(); }
 * 
 * 
 * 
 * @And("je saisis un mot de passe correct {string}") public void
 * je_saisis_un_mot_de_passe_valide_Email(String password) { WebElement
 * inputMotDePasse =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118"))); //
 * Assurez-vous que l'ID est correct inputMotDePasse.sendKeys(password);
 * WebElement signInButton =
 * wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
 * signInButton.click();
 * 
 * 
 * }
 * 
 * @And("L'utilisateur approuve la demande de connexion manuellement") public
 * void utilisateur_approuve_demande_connexion_manuellement() throws
 * InterruptedException {
 * 
 * Thread.sleep(30000); // Wait 30 seconds for manual approval }
 * 
 * @And("L'utilisateur répond à la question rester connecté") public void
 * utilisateur_repond_rester_connecte() { WebElement staySignedInButton =
 * wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
 * staySignedInButton.click(); }
 * 
 * @Then("L'utilisateur est redirigé vers la boîte de réception") public void
 * utilisateur_est_redirige_vers_boite_de_reception() { WebElement inboxElement
 * = wait.until(ExpectedConditions.visibilityOfElementLocated(By.
 * xpath("//span[text()='Boîte de réception']"))); // Example XPath, adjust as
 * needed Assert.assertTrue(inboxElement.isDisplayed()); }
 * 
 * @Then("L'utilisateur ouvre l'email pour la récupération de mot de passe")
 * public void utilisateur_ouvre_email_recuperation() {
 * 
 * // Wait until the specific email is visible and clickable, then click on it
 * WebElement emailElement =
 * wait.until(ExpectedConditions.elementToBeClickable(By.
 * xpath("//span[contains(text(), 'si_noreply@esprit.tn')]")));
 * emailElement.click(); }
 * 
 * @And("Je bascule vers l'onglet Outlook") public void
 * bascule_vers_onglet_outlook() {
 * 
 * ((JavascriptExecutor)
 * driver).executeScript("window.open('about:blank', '_blank');");
 * ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
 * driver.switchTo().window(tabs.get(1)); }
 * 
 * 
 * 
 * 
 * }
 */