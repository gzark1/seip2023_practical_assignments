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

public class HistogramGenerator {

    static List<Integer> readGrades(InputStream inputStream){

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
