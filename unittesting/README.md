# Unittesting
This project is a part of the parent Maven project and focuses on unit testing and code coverage using JUnit and JaCoCo. It includes test cases for the ArithmeticOperations, ArrayOperations, MyMath and FileIO classes.

## Technologies and Tools
* Java
* Maven
* JUnit
* JaCoCo
* Mockito

## Building and Running Unittesting project
To build and run the Unittesting project, follow these steps:

1. Navigate to the project root directory.
2. Execute the following Maven command:
`mvn clean test`. This command will compile the project, run the unit tests and produce jacoco report.

## File structure
The project follows a standard directory structure, as outlined below:

* src/main/java: This directory contains the main Java source code for the application. It includes the following packages:
  * io: Classes of io package
  * math: Classes of math package
* src/test/java: This directory contains the test source code for the application. It includes the following packages:
  * io: Test Classes of io package
  * math: Test Classes of math package
* src/test/resources: This directory contains the test resources used in the application. Ensure that the test resources are properly placed in this directory to be accessible during test execution.

* pom.xml: This build configuration file specifies the project dependencies, build settings, and other project-specific configurations.


## Continuous Integration with GitHub Actions
I have added continuous integration (CI) using GitHub Actions to automatically build and test the project on every push or pull request. The CI workflow is defined in the .github/workflows directory.

You can check the status of the CI workflow by looking at the workflow status badge at the top of the main README file.
