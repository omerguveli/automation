# Selenium Java Cucumber Framework

This is a test automation framework built using Selenium WebDriver, Cucumber, and JUnit 4.

## Prerequisites
- Java JDK 11 or higher
- Maven 3.6 or higher
- Chrome Browser (or Firefox/Edge)

## Project Structure
- `src/test/java/com/automation/pages`: Page Object Model classes
- `src/test/java/com/automation/stepdefinitions`: Cucumber Step Definitions
- `src/test/java/com/automation/runners`: JUnit Test Runner
- `src/test/java/com/automation/utilities`: Framework utilities (DriverFactory, etc.)
- `src/test/resources/features`: Gherkin feature files

## How to Run Tests

### Command Line (Maven)
To run all tests:
```bash
mvn clean test
```

To run with a specific browser (default is Chrome):
```bash
mvn clean test -Dbrowser=firefox
```

### IDE (IntelliJ / Eclipse)
1. Open `src/test/java/com/automation/runners/TestRunner.java`
2. Right-click and select **Run 'TestRunner'**

### Cucumber Reports
After execution, reports are generated at:
- `target/cucumber-reports.html`
