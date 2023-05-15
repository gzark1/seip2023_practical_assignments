# SEIP2023 Practical Assignments

This Git repository contains lab assignments for the "Software Engineering in Practice" course. Each assignment is organized as a module within the parent Maven project.

## Purpose

The purpose of this repository is to provide a centralized location for me to submit my practical assignments. It serves as a platform for managing the source code and related files.

## Technologies and Tools

The project is built using the following technologies and tools:

- Java: The programming language used for development.
- Maven: The build automation tool for managing dependencies and packaging the project.
- Integrated Development Environment (IDE): IntelliJ IDE was used for development.
  
GradeHistogram module is built using additionally:
- JFreeChart: A Java library for creating charts, added as a dependency using Maven.

## Building and Running GradeHistogram project

To build and run the project, follow these steps:

1. Clone the repository to your local machine.
2. Open the parent Maven project in your preferred IDE.
3. Ensure that the IDE is configured with the appropriate JDK.
4. Let the IDE resolve the dependencies by importing the project as a Maven project.
5. Locate the `HistogramGenerator` class within the module project.
6. Ensure that the `main` method is present in the `HistogramGenerator` class.
7. Build the project using Maven, either through the IDE's built-in Maven support or by installing Maven in your machine and running the `mvn clean install` command in the project's root directory.
8. The build process will compile the code, package it into a fat jar (including dependencies), and generate the necessary artifacts.
9.  To run gradehistogram being in the parent project's directory, execute the generated fat jar by running the `java -jar gradeshistogram/target/gradeshistogram-1.0-SNAPSHOT-jar-with-dependencies.jar gradeshistogram/src/main/resources/grades.txt` command in the terminal or command prompt.

Ensure that you have the necessary dependencies, such as JFreeChart, downloaded and configured in your project.

## File Structure

The repository is structured as follows:

- `./pom.xml`: The parent Maven POM file for the project.
- `./gradeshistogram`: The module Maven project for the grades histogram assignment.
- `./gradehistogram/src`: The gradehistogram module's source code directory containing the Java classes for the assignment.
- `./gradehistogram/pom.xml`: The Maven POM file for the gradehistogram module project.
## Unit Testing Project
You can read Unit Testing Project's README.md file [here](unittesting/README.md)
