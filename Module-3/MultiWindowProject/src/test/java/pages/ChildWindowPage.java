package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChildWindowPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By heading = By.tagName("h3");

    public ChildWindowPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHeadingText() {
        WebElement headingElement = wait.until(ExpectedConditions.presenceOfElementLocated(heading));
        return headingElement.getText();
    }
}