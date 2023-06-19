package codeanalyzer.analyzer;


import codeanalyzer.reader.SourceFileReader;
import codeanalyzer.reader.FileReaderFactory;

import java.io.IOException;

/**
 * An abstract class for analyzing source code files.
 */
public abstract class SourceCodeAnalyzer {
    protected SourceFileReader sourceFileReader;

    /**
     * Constructs a SourceCodeAnalyzer object with the specified type.
     *
     * @param type the type of source file reader to be used by the analyzer
     */
    public SourceCodeAnalyzer(String type) {
        FileReaderFactory fileReaderFactory = new FileReaderFactory();
        this.sourceFileReader = fileReaderFactory.createSourceFileReader(type);
    }

    /**
     * Calculates the Lines of Code (LOC) metric for the given source code file.
     *
     * @param filepath the path to the source code file
     * @return the number of lines of code in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public abstract int calculateLOC(String filepath) throws IOException;

    /**
     * Calculates the Number of Methods (NOM) metric for the given source code file.
     *
     * @param filepath the path to the source code file
     * @return the number of methods in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public abstract int calculateNOM(String filepath) throws IOException;

    /**
     * Calculates the Number of Classes (NOC) metric for the given source code file.
     *
     * @param filepath the path to the source code file
     * @return the number of classes in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public abstract int calculateNOC(String filepath) throws IOException;
}
