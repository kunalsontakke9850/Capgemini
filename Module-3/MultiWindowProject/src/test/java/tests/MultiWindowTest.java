package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.ChildWindowPage;
import pages.HomePage;
import utils.WindowUtil;

public class MultiWindowTest extends BaseTest {

    @Test
    public void testMultiWindowHandling() {

        System.out.println("\n🚀 Starting Multi-Window Automation Test...");
        
        HomePage homePage = new HomePage(driver);
        String parentWindow = driver.getWindowHandle();
        
        System.out.println("📄 Current page loaded: " + driver.getTitle());
        
        // Wait 2 seconds so you can see the initial page
        waitAndLog("⏳ Waiting 2 seconds to show initial page...", 2);

        System.out.println("🖱️ Clicking 'Click Here' link to open new window...");
        homePage.clickOpenNewWindow();

        // Wait 2 seconds so you can see the new window opening
        waitAndLog("⏳ Waiting for new window to open...", 2);

        System.out.println("🔄 Switching to new window...");
        WindowUtil.switchToChildWindow(driver, parentWindow);

        ChildWindowPage childWindowPage = new ChildWindowPage(driver);
        String heading = childWindowPage.getHeadingText();
        
        System.out.println("✅ New window heading found: '" + heading + "'");
        
        // Wait 3 seconds so you can see the new window content
        waitAndLog("⏳ Displaying new window content for 3 seconds...", 3);

        Assertions.assertEquals("New Window", heading);

        System.out.println("❌ Closing new window...");
        driver.close();

        // Wait 1 second before switching back
        waitAndLog("🔄 Switching back to original window...", 1);

        driver.switchTo().window(parentWindow);
        
        System.out.println("🏠 Back to original window: " + driver.getTitle());
        
        // Wait 2 seconds to show we're back to original window
        waitAndLog("⏳ Showing original window for 2 seconds...", 2);

        Assertions.assertTrue(driver.getTitle().contains("The Internet"));
        
        System.out.println("🎉 Test completed successfully!");
    }
    
    private void waitAndLog(String message, int seconds) {
        System.out.println(message);
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}