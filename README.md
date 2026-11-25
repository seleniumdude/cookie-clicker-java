# Cookie Clicker UI Test Suite

A BDD UI automation suite for the Cookie Clicker web game, written in Java with Cucumber and Selenium WebDriver (Chrome).

## What it covers

The feature file `NewPlayer-HappyPath.feature` describes the happy path for a new player:

- Open the start screen, enter a player name and check the new game starts
- Buy cookies and check the Cookies counter updates
- Sell cookies and check the Money balance updates

Scenarios tagged `@test` are the ones the runner executes by default.

## Tech stack

| Area | Tool |
|---|---|
| Language | Java 11+ |
| Browser automation | Selenium WebDriver 4 |
| BDD framework | Cucumber JVM 7 (Gherkin) with JUnit 4 |
| Driver management | WebDriverManager |
| Assertions | AssertJ |
| Build | Maven |

## Prerequisites

- JDK 11 or newer
- Google Chrome (the matching ChromeDriver is downloaded automatically)
- Maven, or the Maven integration in your IDE
- Internet access, since the tests run against the live game

## How to run

From the command line:

```
mvn clean test
```

From IntelliJ, open the Maven panel, expand **Lifecycle**, and run **clean** then **test**. You can also run `runners.MainRunner` directly.

## Results

Maven prints the usual test summary, and Cucumber writes HTML and JSON reports under `target/`.

To run every scenario instead of only `@test`, remove the `tags` line from `MainRunner`.

## Project layout

```
pom.xml                       Maven build and dependencies
src/test/resources/           Gherkin feature files
src/test/java/runners/        MainRunner (Cucumber JUnit runner)
src/test/java/steps/          Step definitions (CommonSteps, HomepageSteps, GameSteps)
```