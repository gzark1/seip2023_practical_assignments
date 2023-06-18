package codeanalyzer.reader;

import java.io.IOException;
import java.util.List;

/**
 * Interface for reading the contents of a source file.
 * Implementing classes provide functionality to read a file and retrieve its content.
 */
public interface SourceFileReader {
    /**
     * Reads a source file and returns its content as a list of strings.
     *
     * @param filepath the path to the source file to be read
     * @return a list of strings containing the content of the source file
     * @throws IOException if an I/O error occurs while reading the file
     */
    List<String> readFileIntoList(String filepath) throws IOException;

    /**
     * Reads a source file and returns its content as a single string.
     *
     * @param filepath the path to the source file to be read
     * @return a string containing the content of the source file
     * @throws IOException if an I/O error occurs while reading the file
     */
    String readFileIntoString(String filepath) throws IOException;
}
