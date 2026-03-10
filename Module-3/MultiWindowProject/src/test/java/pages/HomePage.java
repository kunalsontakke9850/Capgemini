package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for navigating to Multiple Windows section
    private By multipleWindowsLink = By.linkText("Multiple Windows");
    private By clickHereLink = By.linkText("Click Here");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOpenNewWindow() {
        // First, check if we're on the main page and need to navigate to Multiple Windows
        if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/")) {
            System.out.println("📍 On main page, navigating to Multiple Windows section...");
            
            // Find and click the Multiple Windows link
            try {
                WebElement multipleWindowsElement = wait.until(ExpectedConditions.elementToBeClickable(multipleWindowsLink));
                multipleWindowsElement.click();
                System.out.println("✅ Successfully navigated to Multiple Windows section");
                
                // Wait a moment for the page to load
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            } catch (Exception e) {
                System.out.println("❌ Could not find Multiple Windows link on main page");
                // Debug: Print all available links
                List<WebElement> allLinks = driver.findElements(By.tagName("a"));
                System.out.println("📋 Available links on main page:");
                for (WebElement link : allLinks) {
                    String linkText = link.getText().trim();
                    if (!linkText.isEmpty()) {
                        System.out.println("   - '" + linkText + "'");
                    }
                }
                throw e;
            }
        }
        
        // Now look for the "Click Here" link on the Multiple Windows page
        System.out.println("🔍 Searching for 'Click Here' link...");
        System.out.println("📍 Current URL: " + driver.getCurrentUrl());
        
        // Add more wait time for the page to fully load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        
        try {
            WebElement clickHereElement = wait.until(ExpectedConditions.elementToBeClickable(clickHereLink));
            clickHereElement.click();
            System.out.println("✅ Successfully clicked 'Click Here' to open new window");
        } catch (Exception e) {
            System.out.println("❌ Could not find 'Click Here' link");
            // Debug: Print all available links on this page
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            System.out.println("📋 Available links on current page:");
            for (WebElement link : allLinks) {
                String linkText = link.getText().trim();
                String href = link.getAttribute("href");
                if (!linkText.isEmpty()) {
                    System.out.println("   - '" + linkText + "' -> " + href);
                }
            }
            
            // Try alternative selectors
            System.out.println("🔄 Trying alternative selectors...");
            try {
                WebElement alternativeElement = driver.findElement(By.xpath("//a[contains(text(),'Click')]"));
                alternativeElement.click();
                System.out.println("✅ Found and clicked element using XPath");
            } catch (Exception e2) {
                System.out.println("❌ Alternative selectors also failed");
                throw e;
            }
        }
    }
}