# Java Selenium Automation Training

[![Java](https://img.shields.io/badge/Java-17%20%7C%2021-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.21-43B02A?logo=selenium&logoColor=white)](https://www.selenium.dev/)
[![JUnit 5](https://img.shields.io/badge/JUnit-5.10-25A162?logo=junit5&logoColor=white)](https://junit.org/junit5/)
[![Maven](https://img.shields.io/badge/Maven-build-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/)

A collection of Java and Selenium automation exercises completed during software engineering industry training. The repository demonstrates browser automation, JUnit testing, Maven project structure, explicit waits, multi-window handling, and Page Object Model fundamentals.

## Projects

### Module 2 - Student Registration Form Automation

Automates the DemoQA student registration form and validates successful submission.

**Key concepts**

- Selenium WebDriver browser automation
- JUnit 5 test lifecycle and assertions
- Explicit waits with `WebDriverWait`
- WebDriverManager setup
- Form controls, dropdowns, keyboard input, and modal validation
- Maven-based dependency and test execution

Run the tests:

```bash
cd Module-2
mvn test
```

### Module 3 - Multi-Window Automation

Tests opening, switching to, validating, closing, and returning from a child browser window.

**Key concepts**

- Multi-window browser handling
- Page Object Model structure
- Shared test setup with a base class
- Reusable window utilities
- JUnit assertions and Maven Surefire

Run the tests:

```bash
cd Module-3/MultiWindowProject
mvn test
```

## Technology Stack

- Java 17 and Java 21
- Selenium WebDriver 4
- JUnit 5
- Maven
- WebDriverManager
- ChromeDriver

## Repository Structure

```text
Capgemini/
├── Module-2/
│   ├── pom.xml
│   └── src/
│       ├── main/java/com/example/
│       └── test/java/com/example/
└── Module-3/
    └── MultiWindowProject/
        ├── pom.xml
        └── src/test/java/
            ├── base/
            ├── pages/
            ├── tests/
            └── utils/
```

## Requirements

- JDK 17 or later for Module 2
- JDK 21 for Module 3
- Apache Maven
- Google Chrome

## Privacy

All form values in this public repository are fictional test data. Do not add personal contact details, addresses, credentials, or confidential information to automation fixtures.

## Note

This is a personal learning repository created during industry training. It contains training exercises only and does not contain proprietary or confidential company code.
