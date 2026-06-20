# Playwright Java Demo

A minimal Maven project for browser automation with [Playwright for Java](https://playwright.dev/java/) and JUnit 5, using [Swag Labs (Sauce Demo)](https://www.saucedemo.com/) as the test site.

## Prerequisites

- **Java 17** or later
- **Maven 3.6+**
- Internet access

Check your setup:

```bash
java -version
mvn -version
```

## Project Structure

```
playwright-java-demo/
├── pom.xml
├── screenshots/
│   ├── saucedemo-login-success.png
│   └── saucedemo-add-to-cart.png
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── demo/
│                   ├── locators/
│                   │   └── SauceDemoLocators.java
│                   ├── pages/
│                   │   ├── BasePage.java
│                   │   ├── LoginPage.java
│                   │   └── InventoryPage.java
│                   └── tests/
│                       ├── BaseTest.java
│                       └── SauceDemoTest.java
└── README.md
```

## Install Dependencies

```bash
mvn clean compile
```

Playwright browser binaries are downloaded automatically the first time a test runs.

## Run Tests

### Run all tests

```bash
mvn test
```

### Run Sauce Demo tests only

```bash
mvn test -Dtest=SauceDemoTest
```

### Run a single test method

```bash
mvn test -Dtest=SauceDemoTest#loginWithValidCredentials
mvn test -Dtest=SauceDemoTest#addProductToCart
```

### Clean build and run tests

```bash
mvn clean test
```

## Tests

Both tests use **https://www.saucedemo.com/** with:

- Username: `standard_user`
- Password: `secret_sauce`

| Test | Description |
|------|-------------|
| `loginWithValidCredentials` | Opens the site, logs in, verifies the Products page |
| `addProductToCart` | Logs in, adds the backpack to cart, verifies cart badge shows `1` |

## Page Object Model

| File | Purpose |
|------|---------|
| `locators/SauceDemoLocators.java` | CSS selectors for Sauce Demo elements |
| `pages/BasePage.java` | Shared actions (click, fill, navigate, screenshot) |
| `pages/LoginPage.java` | Login page actions |
| `pages/InventoryPage.java` | Products page actions |
| `tests/BaseTest.java` | Shared browser setup and teardown |
| `tests/SauceDemoTest.java` | JUnit tests |

## Run from an IDE

Open the project as a Maven project in IntelliJ IDEA, VS Code, or Cursor:

- Run all tests: use the run icon next to `SauceDemoTest`
- Run one test: use the run icon next to the `@Test` method

## Dependencies

| Library | Version | Purpose |
|---------|---------|---------|
| Playwright | 1.54.0 | Browser automation |
| JUnit Jupiter | 5.10.2 | Test framework |
| Maven Surefire | 3.2.5 | Runs tests via Maven |

## Troubleshooting

**No tests found**

- Confirm test files are under `src/test/java/`.

**Browser fails to launch**

- Re-run the test; Playwright will retry downloading browsers if needed.

**Headless mode for CI**

In `BaseTest.java`, change:

```java
.setHeadless(false)
```

to:

```java
.setHeadless(true)
```

## Useful Links

- [Sauce Demo (Swag Labs)](https://www.saucedemo.com/)
- [Playwright Java documentation](https://playwright.dev/java/docs/intro)
- [JUnit 5 user guide](https://junit.org/junit5/docs/current/user-guide/)
