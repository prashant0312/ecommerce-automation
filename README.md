# AI-Powered E-Commerce Test Automation Framework

A Java-based Selenium WebDriver automation framework for testing the [DemoBlaze](https://www.demoblaze.com/) e-commerce application. Built with **Java 21, Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM)**, the framework includes HTML reporting, automatic failure screenshots, and a working GitHub Actions CI/CD pipeline.

## Project Overview

This project demonstrates practical QA Automation Engineer / SDET skills through reusable automation components, maintainable test architecture, automated browser execution, test reporting, and continuous integration.

**Application Under Test:** [DemoBlaze](https://www.demoblaze.com/)

**Repository:** [ecommerce-automation](https://github.com/prashant0312/ecommerce-automation)

## Key Features

- **UI Automation:** Automates browser-based workflows using Selenium WebDriver.
- **Page Object Model (POM):** Separates page interactions and locators from test logic.
- **TestNG:** Provides test organization, annotations, and assertions.
- **Maven:** Manages dependencies, compilation, and test execution.
- **ExtentReports:** Generates HTML execution reports.
- **Automatic Screenshots:** Captures screenshots when tests fail.
- **Headless Browser Execution:** Supports automated browser testing in CI environments.
- **Git and GitHub:** Maintains source control and project history.
- **GitHub Actions CI/CD:** Automatically runs Maven tests on pushes and pull requests targeting `main` or `master`.
- **Secure Test Configuration:** Reads DemoBlaze test credentials from environment variables and GitHub Actions secrets.
- **AI-Assisted Testing Roadmap:** Future scope for AI-generated test scripts and failure analysis.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution and assertions |
| Maven | Build and dependency management |
| Page Object Model | Maintainable framework design |
| ExtentReports | HTML test reporting |
| Google Chrome | Browser testing |
| Git and GitHub | Version control |
| GitHub Actions | Continuous integration and automated testing |

## Project Structure

```text
ecommerce-automation/
├── .github/
│   └── workflows/
│       └── maven-tests.yml
├── src/
│   └── test/
│       └── java/
│           └── com/aiqa/ecommerce/
│               ├── base/
│               │   └── BaseTest.java
│               ├── pages/
│               │   ├── CartPage.java
│               │   ├── HomePage.java
│               │   └── LoginPage.java
│               ├── reports/
│               │   ├── ExtentReportManager.java
│               │   └── ExtentTestListener.java
│               ├── tests/
│               │   ├── CartTest.java
│               │   └── LoginTest.java
│               └── utils/
│                   └── ScreenshotUtil.java
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
```

## Prerequisites

Install the following tools:

- JDK 21
- Apache Maven 3.9+
- Git
- Google Chrome
- Visual Studio Code or another Java-compatible IDE

Verify the installations:

```bash
java -version
mvn -version
git --version
```

## Setup and Execution

### 1. Clone the repository

```bash
git clone https://github.com/prashant0312/ecommerce-automation.git
cd ecommerce-automation
```

### 2. Configure test credentials

The valid-login test reads credentials from environment variables.

Configure a registered DemoBlaze test account using these variable names:

- `DEMOBLAZE_USERNAME`
- `DEMOBLAZE_PASSWORD`

In Windows PowerShell, set them for the current terminal session:

```powershell
$env:DEMOBLAZE_USERNAME = "your_demoblaze_username"
$env:DEMOBLAZE_PASSWORD = "your_demoblaze_password"
```

Replace the placeholders with your test-account credentials. Never commit actual credentials to source control.

For GitHub Actions, configure the corresponding repository secrets under **Settings → Secrets and variables → Actions**.

### 3. Run the tests

Execute the test suite using Maven:

```bash
mvn clean test
```

To run the same command used by CI:

```bash
mvn --batch-mode clean test
```

### 4. View test reports

After execution, review the generated output:

| Output | Location |
|---|---|
| ExtentReports HTML report | `target/ExtentReports/ExtentReport.html` |
| Maven Surefire