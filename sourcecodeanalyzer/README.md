# Design Patterns Assignment
This project is a Java application designed to perform static code analysis on a given Java source code file. It generates a CSV or JSON file containing the metrics selected by the user. The user can choose between two types of source code analyzers: regex or strcomp. Additionally, they can select between two types of source code locations: local or web. Lastly, the user has the option to specify the output file format as either CSV or JSON.

## Design Patterns

### SourceFileReader: Factory Pattern with Interface
To address the design issues and violations of design principles in the initial implementation of the SourceFileReader class, the Factory pattern in combination with the Interface design pattern was applied.
The Factory pattern was chosen to encapsulate the object creation process and provide a centralized way of creating instances of SourceFileReader. This pattern provides an interface for creating objects but delegates the responsibility of instantiation to subclasses.
The system can easily accommodate new types of SourceFileReader in the future by simply adding new concrete implementations and updating the factory method.


Classes Participating in the Pattern:
* SourceFileReader (Interface): The interface defines the contract for reading a source file into a list of strings or a single string. It declares the methods readFileIntoList and readFileIntoString, which are implemented by the concrete classes.
* LocalFileReader (Concrete Implementation): This class implements the SourceFileReader interface and provides the implementation for reading a locally stored file.
* WebFileReader (Concrete Implementation): This class also implements the SourceFileReader interface and handles the reading of a file stored on the web.
* FileReaderFactory (Factory): The factory class is responsible for creating instances of SourceFileReader. It contains the createSourceFileReader method that takes a type parameter and returns the appropriate concrete implementation of SourceFileReader based on the provided type. It follows the factory method pattern, allowing for flexible instantiation of SourceFileReader objects.

## Build the project

1. Build the executable Java application with:
	mvn package jacoco:report

2. Run the executable by executing
	java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
were args translate to: 	
	arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	arg2 = “SourceCodeLocationType” [local|web]
	arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	arg4 = “OutputFileType” [csv|json]
example: 
	java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv