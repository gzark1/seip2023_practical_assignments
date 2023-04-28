import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/***
 * The purpose of this class is to read a file name from the command line,
 * then generate a histogram based on the list of numbers of that file
 * @author gzark1
 * @since April 2023
 */

public class HistogramGenerator {
    /**
     * A static method that reads the numbers from an inputStream, stores them in a List
     * and returns the List
     * @param inputStream
     *     The inputStream given
     * @return
     *     The List of numbers read
     * @throws IOException
     */
    static List<Integer> readGrades(InputStream inputStream) throws IOException {

        List<Integer> gradesArray = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line = reader.readLine()) != null){
                //check if the trimmed line is not empty
                if(!line.trim().isEmpty()){
                    int grade = Integer.parseInt(line.trim());
                    gradesArray.add(grade);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return gradesArray;
    }

    /**
     * A static method that receives a List of Integers, calculates the grade frequencies and
     * displays a JFreeChart XYLine chart using a XYSeriesCollection dataset.
     * @param gradesArray
     *     The List given
     */
    static void generateHistogram(List<Integer> gradesArray){
        XYSeriesCollection dataset = new XYSeriesCollection();

        // Calculate grade frequencies
        int[] frequencies = new int[11];
        for (double grade : gradesArray) {
            frequencies[(int) grade]++;
        }

        XYSeries data = new XYSeries("Grades Frequencies");

        for (int i = 0; i < frequencies.length; i++) {
            data.add(i, frequencies[i]);
        }

        dataset.addSeries(data);

        boolean legend = false; // do not visualize a legend
        boolean tooltips = false; // do not visualize tooltips
        boolean urls = false; // do not visualize urls

        JFreeChart chart = ChartFactory.createXYLineChart("Grades Frequencies", "Grade", "Frequency", dataset,
                PlotOrientation.VERTICAL, legend, tooltips, urls);

        ChartFrame frame = new ChartFrame("Grades Frequencies", chart);
        frame.pack();

        frame.setVisible(true);

    }
    /**
     * The main method of the program, which executes the readGrades and generateHistogram methods.
     * @param args
     *     main takes a single command-line argument, which represents the path of the file
     *     containing the numbers to be read.
     * An InputStream is created from main and passed to readGrades method.
     */
    public static void main(String[] args) {
        String gradesFile = args[0];
        try{
            InputStream inputStream = new FileInputStream(gradesFile);
            List<Integer> gradesArray = readGrades(inputStream);
            generateHistogram(gradesArray);
        }catch(IOException e){
            e.getStackTrace();
        }

    }
}
