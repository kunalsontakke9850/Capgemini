package base;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setup() {
        
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        
        // Configure Chrome options for better stability
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        
        driver = new ChromeDriver(options);
        
        // Initialize WebDriverWait with 10 seconds timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterEach
    public void tearDown() {
        
        System.out.println("\n=== AUTOMATION COMPLETED ===");
        System.out.println("✅ Test finished successfully!");
        System.out.println("🌐 Browser will stay open for 15 seconds for you to view results");
        System.out.println("💡 Browser will close automatically after 15 seconds");
        
        // Wait 15 seconds so you can see the final result
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println("⏳ Closing browser in " + i + " seconds...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("🔒 Closing browser now...");
        driver.quit();
        System.out.println("✅ Browser closed successfully!");
    }
}