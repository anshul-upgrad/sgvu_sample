# Gyan Vihar Sample Codebase

About the codebase:
---------------------------------
*This is a test project for testing a few scenarios on a sample flight/hotel booking website. There are **3 tests** in total spread over 3 test classes. Following tech stack has been used to develop the same.*

**Tech Stack:** *Java*, *Selenium*, *TestNG*,  *Maven*, *Allure*, 

Problem Statement
----------------------------------

1. Create a framework that caters to automated test execution on cloud infrastructure
2. Generate interactive test reports
3. Configure tests to be dynamic, data driven and modular

Solution Highlights
----------------------------------

1. Created a multi-tier architecture by separating tests, page objects and utilities. Created an initialization package to connect between all
2. Used Page Factory approach at the framework level - object of a PO would be created only when it is to be used
3. Added resources folder to keep all important files other than source code intact and together
4. Configured data file for making scripts data-driven
5. Created packaging structure for the entire code
6. Applied abstraction - exposing only Initiator to test classes and access to all PO methods through a single object
7. Applied Reusability - created BasePage PO having all common methods to be used across all other POs, explicit wait also added in a single utility class used across all POs
8. Applied Maintainability - Code is structured into different packages with loggers and relevant method names making it easier for debugging in the longer run

Benefits of the framework
----------------------------------

1. Single point of configuration and test data -> All config params(like execution platform, base URLs etc and test data are passed through a single config file)
2. Capability of test execution on local as well as cloud infra
3. Highly maintainable code due to use of Page Objects and modular approach
4. Single command execution for entire test suite, readily integrable to any CI tool(like Jenkins etc)
5. Integrated allure reporting which creates highly understandable and rich web reports


Execution pre-requisites
----------------------------------

1. Install Java
2. Install Maven
3. Only for local execution, you'd need chromedriver executable as well 


Execution command
----------------------------------

mvn clean verify allure:serve

Post execution, reports will be auto-launched on local browser instance.

