package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentFormAutomation {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/automation-practice-form");

            // First Name
            driver.findElement(By.id("firstName")).sendKeys("Kunal");

            // Last Name
            driver.findElement(By.id("lastName")).sendKeys("Sontakke");

            // Email
            driver.findElement(By.id("userEmail")).sendKeys("kunalsontakke900@gmail.com");

            // Gender
            driver.findElement(By.xpath("//label[text()='Male']")).click();

            // Mobile
            driver.findElement(By.id("userNumber")).sendKeys("9850777484");

            // Date of Birth
            driver.findElement(By.id("dateOfBirthInput")).click();
            driver.findElement(By.className("react-datepicker__year-select")).sendKeys("2003");
            driver.findElement(By.className("react-datepicker__month-select")).sendKeys("October");
            driver.findElement(By.xpath("//div[text()='10']")).click();

            // Subject
            driver.findElement(By.id("subjectsInput")).sendKeys("English");
            driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);

            // Hobbies
            driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();

            // Address
            driver.findElement(By.id("currentAddress")).sendKeys("Rautwadi, Jatherpeth, Akola, Maharashtra, India");

            // State
            driver.findElement(By.id("react-select-3-input")).sendKeys("NCR");
            driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);

            // City
            driver.findElement(By.id("react-select-4-input")).sendKeys("Delhi");
            driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);

            // Submit
            driver.findElement(By.id("submit")).submit();
            
            System.out.println("Form submitted successfully!");
            System.out.println("Browser will remain open. Close manually when done.");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}