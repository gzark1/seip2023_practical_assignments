package codeanalyzer.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the SourceFileReader interface for reading a locally stored file.
 * Reads the contents of a file and provides methods to retrieve the content as a list of strings or a single string.
 */
public class LocalFileReader implements SourceFileReader{

    /**
     * Reads a locally stored file and returns its content as a list of strings.
     *
     * @param filepath the path to the locally stored file to be read
     * @return a list of strings containing the content of the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public List<String> readFileIntoList(String filepath) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    /**
     * Reads a locally stored file and returns its content as a single string.
     *
     * @param filepath the path to the locally stored file to be read
     * @return a string containing the content of the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public String readFileIntoString(String filepath) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        reader.close();
        return sb.toString();
    }
}
