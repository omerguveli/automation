# Selenium Java Cucumber Framework

This is a test automation framework built using Selenium WebDriver, Cucumber, and JUnit 4.

## Prerequisites
- Java JDK 11 or higher
- Maven 3.6 or higher
- Chrome Browser (or Firefox/Edge)

## Project Structure
- `src/test/java/com/automation/pages`: Page Object Model classes
- `src/test/java/com/automation/stepdefinitions`: Cucumber Step Definitions
    - `ui`: UI-specific consumers (Hooks, LoginSteps, etc.)
    - `api`: API-specific consumers (ApiSteps)
- `src/test/java/com/automation/runners`: JUnit Test Runners
    - `TestRunner.java`: Runs all tests
    - `UiTestRunner.java`: Runs only UI tests
    - `ApiTestRunner.java`: Runs only API tests
- `src/test/java/com/automation/utilities`: Framework utilities
    - `ui`: DriverFactory, BrowserUtils
    - `api`: ApiUtils
- `src/test/resources/features`: Gherkin feature files

## How to Run Tests

### Command Line (Maven)
To run all tests:
```bash
mvn clean test
```

To run only API tests:
```bash
mvn clean test -Dtest=ApiTestRunner
```

To run only UI tests:
```bash
mvn clean test -Dtest=UiTestRunner
```

To run with a specific browser (default is Chrome):
```bash
mvn clean test -Dbrowser=firefox
```

### IDE (IntelliJ / Eclipse)
1. Open `src/test/java/com/automation/runners/TestRunner.java` (or Ui/Api runners)
2. Right-click and select **Run 'TestRunner'**

### Cucumber Reports
After execution, reports are generated at:
- `target/cucumber-reports.html`
