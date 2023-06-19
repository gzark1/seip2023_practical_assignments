package codeanalyzer.analyzer;

/**
 * Factory class for creating instances of SourceCodeAnalyzer.
 */
public class SourceCodeAnalyzerFactory {

    /**
     * Creates a SourceCodeAnalyzer based on the specified analyzer type and reader type.
     *
     * @param analyzerType the type of the analyzer to create ("regex" or "strcomp")
     * @param readerType   the type of the source file reader to be used by the analyzer
     * @return a new instance of SourceCodeAnalyzer based on the provided types
     */
    public SourceCodeAnalyzer createSourceCodeAnalyzer(String analyzerType, String readerType) {
        switch (analyzerType) {
            case "regex":
                return new RegexAnalyzer(readerType);
            case "strcomp":
                return new StrCompAnalyzer(readerType);
            default:
                return null;
        }
    }
}
