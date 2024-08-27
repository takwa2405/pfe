package StepsDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;
  @Before
    public  void setUp() {
       ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Activer le mode headless
        options.addArguments("--disable-search-engine-choice-screen"); // Autres arguments optionnels
        options.addArguments("--no-sandbox"); // Pour éviter des problèmes liés au sandbox
        options.addArguments("--disable-dev-shm-usage"); // Pour éviter des erreurs de mémoire partagée
        options.addArguments("--disable-gpu"); // Désactiver l'accélération GPU

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get("http://192.168.0.21:7070/ESBOnline/Online/default.aspx");
        driver.manage().window().maximize(); // Peut être inutile en mode headless, mais n'affecte pas
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
