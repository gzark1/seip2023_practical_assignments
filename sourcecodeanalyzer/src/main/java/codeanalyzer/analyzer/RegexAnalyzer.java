package codeanalyzer.analyzer;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An implementation of the SourceCodeAnalyzer that uses regular expressions to analyze source code files.
 */
public class RegexAnalyzer extends SourceCodeAnalyzer {

    /**
     * Constructs a RegexAnalyzer object with the specified type.
     *
     * @param type the type of source file reader to be used by the analyzer
     */
    public RegexAnalyzer(String type) {
        super(type);
    }

    /**
     * Calculates the Lines of Code (LOC) metric for the given source code file.
     *
     * @param filepath the path to the source code file
     * @return the number of lines of code in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public int calculateLOC(String filepath) throws IOException {
        String sourceCode = sourceFileReader.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
            nonCodeLinesCounter++;
        }

        int sourceFileLength = sourceCode.split("\n").length;
        int loc = sourceFileLength - nonCodeLinesCounter;

        return loc;

    }

    /**
     * Calculates the Number of Methods (NOM) metric for the given source code file.
     *
     * @param filepath the path to the source code file
     * @return the number of methods in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public int calculateNOM(String filepath) throws IOException {
        String sourceCode = sourceFileReader.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*");
        Matcher methodSignatures = pattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
            methodCounter++;
        }
        return methodCounter;

    }

    /**
     * Calculates the Number of Classes (NOC) metric for the given source code file.
     *
     * @param filepath the path to the source code file
     * @return the number of classes in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public int calculateNOC(String filepath) throws IOException {
        String sourceCode = sourceFileReader.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile(".*\\s*class\\s+.*");
        Matcher classSignatures = pattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
            classCounter++;
        }
        return classCounter;
    }
}
