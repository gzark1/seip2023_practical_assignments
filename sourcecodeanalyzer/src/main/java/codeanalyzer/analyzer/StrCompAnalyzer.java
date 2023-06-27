package codeanalyzer.analyzer;

import java.io.IOException;
import java.util.List;

/**
 * An implementation of SourceCodeAnalyzer that uses string comparison techniques.
 */
public class StrCompAnalyzer extends SourceCodeAnalyzer {

    /**
     * Constructs a new StrCompAnalyzer object with the given type.
     *
     * @param type the type of the source file reader to be used by the analyzer
     */
    public StrCompAnalyzer(String type) {
        super(type);
    }

    /**
     * Calculates the number of lines of code (LOC) in the specified file.
     *
     * @param filepath the path to the source file
     * @return the number of lines of code in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public int calculateLOC(String filepath) throws IOException {
        List<String> sourceCodeList = sourceFileReader.readFileIntoList(filepath);
        int nonCodeLinesCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //clear all leading and trailing white spaces
            if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
                nonCodeLinesCounter++;
        }
        int loc = sourceCodeList.size() - nonCodeLinesCounter;
        return loc;
    }

    /**
     * Calculates the number of methods (NOM) in the specified file.
     *
     * @param filepath the path to the source file
     * @return the number of methods in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public int calculateNOM(String filepath) throws IOException {
        List<String> sourceCodeList = sourceFileReader.readFileIntoList(filepath);
        int methodCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //clear all leading and trailing white spaces
            if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
                    || line.contains("void") || line.contains("int") || line.contains("String"))
                    && line.contains("(") && line.contains(")") && line.contains("{") )
                methodCounter++;
        }
        return methodCounter;
    }

    /**
     * Calculates the number of classes (NOC) in the specified file.
     *
     * @param filepath the path to the source file
     * @return the number of classes in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public int calculateNOC(String filepath) throws IOException {
        List<String> sourceCodeList = sourceFileReader.readFileIntoList(filepath);
        int classCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //remove leading and trailing white spaces
            if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
                classCounter++;
            }
        }
        return classCounter;
    }
}
