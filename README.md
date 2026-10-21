# AI-Powered E-Commerce Test Automation Framework

A Selenium WebDriver automation framework built with **Java, TestNG, Maven, and the Page Object Model (POM)** to automate functional testing of an e-commerce web application. The project includes HTML test reporting, automatic screenshots on test failure, and a foundation for CI/CD and AI-assisted testing enhancements.

## Project Overview

This project demonstrates practical QA automation engineering skills, including reusable test automation components, maintainable framework design, automated execution, and test reporting.

**Application Under Test:** [Demoblaze](https://www.demoblaze.com/)

### Key Features

- **UI Automation:** Automates browser-based application workflows using Selenium WebDriver.
- **Java:** Implements test logic and reusable automation components.
- **Page Object Model (POM):** Separates page locators and interactions from test cases.
- **TestNG:** Supports test execution, assertions, annotations, and test organization.
- **Maven:** Manages dependencies and builds the project.
- **ExtentReports:** Generates HTML test execution reports.
- **Automatic Screenshots:** Captures screenshots when tests fail.
- **Headless Execution:** Supports headless browser execution for CI environments.
- **Git and GitHub:** Provides source control and project collaboration.
- **CI/CD Ready:** Designed for integration with GitHub Actions.
- **AI-Assisted Testing Roadmap:** Planned enhancements for test script generation and failure analysis.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution and assertions |
| Maven | Build and dependency management |
| ExtentReports | HTML test reporting |
| Chrome / ChromeDriver | Browser testing |
| Git and GitHub | Version control |
| GitHub Actions | Planned CI/CD automation |

## Project Structure

```text
ecommerce-automation/
├── .github/
│   └── workflows/
│       └── maven-tests.yml
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── aiqa/
│                   └── ecommerce/
│                       ├── base/
│                       │   └── BaseTest.java
│                       ├── pages/
│                       │   ├── CartPage.java
│                       │   ├── HomePage.java
│                       │   └── LoginPage.java
│                       ├── reports/
│                       │   ├── ExtentReportManager.java
│                       │   └── ExtentTestListener.java
│                       ├── tests/
│                       │   ├── CartTest.java
│                       │   └── LoginTest.java
│                       └── utils/
│                           └── ScreenshotUtil.java
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
```

*Note: The structure represents the intended framework layout. Update the file names and paths if your current project differs.*

## Prerequisites

Install the following tools before running the project:

- JDK 21
- Apache Maven 3.9+
- Git
- Google Chrome
- Visual Studio Code or another Java-compatible IDE

Verify Java and Maven installations:

```bash
java -version
mvn -version
git --version
```

## Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/prashant0312/ecommerce-automation.git
cd ecommerce-automation
```

### 2. Configure test credentials

The login test uses environment variables rather than hard-coded credentials.

Configure these variables with your dedicated Demoblaze test account:

- `DEMOBLAZE_USERNAME`
- `DEMOBLAZE_PASSWORD`

On Windows PowerShell, set them for the current terminal session:

```powershell
$env:DEMOBLAZE_USERNAME = "your_demoblaze_username"
$env:DEMOBLAZE_PASSWORD = "your_demoblaze_password"
```

Replace the placeholders with your own test-account credentials. Never commit real credentials to GitHub.

### 3. Run the automated tests

Execute the full Maven test suite:

```bash
mvn clean test
```

Maven will compile the project, execute the configured tests, and generate test results.

### 4. View test reports

After execution, review the generated reports:

- **ExtentReports:** `target/ExtentReports/ExtentReport.html`
- **Maven Surefire reports:** `target/surefire-reports/`
- **Failure screenshots:** `target/screenshots/`

Report and screenshot locations depend on the framework configuration. Open the generated HTML report in a browser to review test execution details.

## Test Scenarios

The framework currently includes login and cart-related test classes.

| Test class | Testing objective |
|---|---|
| `LoginTest.java` | Validate login-related functionality |
| `CartTest.java` | Validate cart-related functionality |

The exact test cases and assertions are defined in the respective test classes. Additional scenarios can be added as the framework evolves.

## Framework Architecture

The framework follows a layered design:

1. **Base Layer:** Initializes and manages browser setup and teardown.
2. **Page Layer:** Encapsulates page locators and user interactions.
3. **Test Layer:** Contains test scenarios and assertions.
4. **Utility Layer:** Provides reusable functions, including failure screenshots.
5. **Reporting Layer:** Creates and manages ExtentReports output.
6. **Build and Execution Layer:** Uses Maven and TestNG to execute automated tests.

This separation improves maintainability, readability, and reusability.

## Continuous Integration

The project is intended to use GitHub Actions to run Maven tests automatically on repository changes.

Planned workflow capabilities:

- Run tests on pushes and pull requests.
- Set up Java 21 in the CI environment.
- Execute tests in headless browser mode.
- Pass test credentials securely through GitHub Actions secrets.
- Upload test reports and screenshots as workflow artifacts.

The CI/CD workflow should be considered configured only after the workflow file has been added, committed, and verified in a successful GitHub Actions run.

## Future Enhancements

- [ ] Configure GitHub Actions CI/CD.
- [ ] Improve cross-browser test execution.
- [ ] Expand login, cart, and checkout test coverage.
- [ ] Add data-driven testing.
- [ ] Integrate API automation using REST Assured.
- [ ] Add AI-assisted test case and script generation.
- [ ] Add AI-assisted failure analysis and debugging suggestions.
- [ ] Document the architecture with a diagram.
- [ ] Record a project demonstration video.

## Engineering Practices

- Reusable page objects and utility methods.
- Separation of test logic from page interactions.
- Environment variables for sensitive test configuration.
- Generated build outputs excluded from version control.
- Automated reporting to support failure investigation.


---

*This project is intended for learning, demonstrating, and improving software test automation engineering practices.*
