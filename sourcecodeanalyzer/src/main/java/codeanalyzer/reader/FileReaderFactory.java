package codeanalyzer.reader;

/**
 * Factory class for creating instances of source file readers based on the specified type.
 * The factory supports creating source file readers for local files and files stored on the web.
 */
public class FileReaderFactory {
    /**
     * Creates a source file reader based on the specified type.
     *
     * @param type the type of the source file reader to create
     *             Valid types are "local" for local file reader and "web" for web file reader.
     * @return an instance of the appropriate source file reader based on the type
     * @throws IllegalArgumentException if the specified type is not valid
     */
    public SourceFileReader createSourceFileReader(String type) {
        switch (type) {
            case "local":
                return new LocalFileReader();
            case "web":
                return new WebFileReader();
            default:
                throw new IllegalArgumentException("Invalid source file reader type: " + type);
        }
    }
}
