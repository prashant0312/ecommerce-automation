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
| Maven Surefire reports | `target/surefire-reports/` |
| Failure screenshots | `target/screenshots/` |

Open the generated ExtentReports HTML file in a browser to inspect the test execution report. Actual output depends on the framework configuration and whether tests fail.

## Test Scenarios

The current TestNG suite contains login and cart-related tests.

| Test class | Purpose |
|---|---|
| `LoginTest.java` | Tests valid-login and invalid-login behavior |
| `CartTest.java` | Tests cart-related functionality |

The framework uses assertions to verify expected application behavior. Refer to the test classes for the detailed steps, locators, and validation logic.

## Latest Verified Test Results

The GitHub Actions workflow completed successfully with the following Maven Surefire results:

| Metric | Result |
|---|---:|
| Tests executed | 4 |
| Failures | 0 |
| Errors | 0 |
| Skipped | 0 |
| Test execution time | 13.53 seconds |

**Result: All four tests passed in the verified CI run.**

## Framework Architecture

The framework follows a layered architecture:

1. **Base Layer:** Manages WebDriver initialization, browser configuration, and teardown.
2. **Page Layer:** Encapsulates page locators and interactions through page objects.
3. **Test Layer:** Contains test scenarios, test data, and assertions.
4. **Utility Layer:** Provides reusable helper functionality, including screenshot capture.
5. **Reporting Layer:** Configures ExtentReports and test listeners.
6. **Build and CI Layer:** Uses Maven, TestNG, and GitHub Actions to execute tests.

This separation supports maintainability, reusability, and easier debugging.

## GitHub Actions CI/CD

The workflow is defined in `.github/workflows/maven-tests.yml`.

It is configured to run on:

- Pushes to `main` and `master`
- Pull requests targeting `main` and `master`
- Manual execution through GitHub Actions

The workflow:

1. Checks out the repository.
2. Sets up Java 21.
3. Verifies that required DemoBlaze secrets are populated.
4. Runs `mvn --batch-mode clean test`.
5. Uploads test reports and screenshots as workflow artifacts when available.

Test credentials are supplied through GitHub Actions secrets rather than hard-coded in the repository.

[View GitHub Actions runs](https://github.com/prashant0312/ecommerce-automation/actions)

## Engineering Practices

- Page Object Model for separation of concerns.
- Reusable automation components and utility methods.
- Environment variables for sensitive test configuration.
- Git-based source control and change tracking.
- Automated test execution and HTML reporting.
- Failure screenshots for debugging.
- CI execution with securely configured credentials.

## Future Enhancements

- [ ] Add broader end-to-end coverage for login, cart, and checkout workflows.
- [ ] Expand data-driven testing.
- [ ] Integrate REST Assured for API automation.
- [ ] Add cross-browser execution.
- [ ] Explore AI-assisted test-case and script generation.
- [ ] Add AI-assisted failure analysis and debugging suggestions.
- [ ] Document the framework with an architecture diagram.
- [ ] Record a project demonstration video.

## Author

**Prashant Kale**

QA Automation Engineer | Selenium WebDriver | Java | TestNG | Maven | API Testing

GitHub: [prashant0312](https://github.com/prashant0312)

---

This project is intended for learning, demonstrating, and improving software test automation engineering practices.
