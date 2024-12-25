# Hybrid Framework Using Selenium, Java, and TestNG

This is a hybrid automation framework designed using Selenium with Java and TestNG. It incorporates POM design pattern and tools for efficient (parallel testing) and scalable test automation.

---

## **Features**

- **Design Pattern:** 
  - Implements the **Page Object Model (POM)**:
    - Web elements and action methods are in a single class.
    - Test methods are in separate test classes for modularity.

- **Logging:**
  - Automation test logging is implemented with **Log4j2**.
  - Logs are captured at all levels, including **DEBUG**, for better coverage and traceability.

- **Data-Driven Testing:**
  - Supports data-driven testing using **Apache POI** for Excel file integration.
  - Includes a **Data Provider** class for parameterized test execution.

- **Reporting:**
  - Generates detailed test reports using **Extent Reports**.
  - Includes a **Listener class** for post-action methods to capture results and logs.

---

## **Technologies Used**

- **Programming Language:** Java
- **Testing Framework:** TestNG
- **Automation Tool:** Selenium WebDriver
- **Logging Tool:** Log4j2
- **Excel Integration:** Apache POI
- **Reporting Tool:** Extent Reports

---
