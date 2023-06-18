package codeanalyzer.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the SourceFileReader interface for reading a file stored on the web.
 * Reads the contents of a web file and provides methods to retrieve the content as a list of strings or a single string.
 */
public class WebFileReader implements SourceFileReader {

    /**
     * Reads a file stored on the web and returns its content as a list of strings.
     *
     * @param filepath the URL of the web file to be read
     * @return a list of strings containing the content of the web file
     * @throws IOException if an I/O error occurs while reading the web file
     */
    public List<String> readFileIntoList(String filepath) throws IOException {
        List<String> lines = new ArrayList<>();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    /**
     * Reads a file stored on the web and returns its content as a single string.
     *
     * @param filepath the URL of the web file to be read
     * @return a string containing the content of the web file
     * @throws IOException if an I/O error occurs while reading the web file
     */
    public String readFileIntoString(String filepath) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        reader.close();
        return sb.toString();
    }
}
