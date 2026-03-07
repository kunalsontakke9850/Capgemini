package com.example;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentFormAutomationJUnitTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    @DisplayName("Should submit student form and close success modal")
    void shouldSubmitStudentFormAndCloseModal() {
        driver.get("https://demoqa.com/automation-practice-form");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));

        driver.findElement(By.id("firstName")).sendKeys("Kunal");
        driver.findElement(By.id("lastName")).sendKeys("Sontakke");
        driver.findElement(By.id("userEmail")).sendKeys("kunalsontakke900@gmail.com");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("9850777484");

        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.className("react-datepicker__year-select")).sendKeys("2003");
        driver.findElement(By.className("react-datepicker__month-select")).sendKeys("October");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='10']")))
                .click();

        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys("English");
        subjectsInput.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("Rautwadi, Jatherpeth, Akola, Maharashtra, India");

        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys("NCR");
        stateInput.sendKeys(Keys.ENTER);

        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        cityInput.sendKeys("Delhi");
        cityInput.sendKeys(Keys.ENTER);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
        Assertions.assertTrue(modal.isDisplayed(), "Success modal should be displayed after submit");

        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("closeLargeModal")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
