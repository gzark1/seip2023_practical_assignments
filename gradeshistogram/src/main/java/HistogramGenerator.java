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
        System.out.println(5);
    }

    public static void main(String[] args) {
        String gradesFile = args[0];
        ClassLoader classLoader = HistogramGenerator.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(gradesFile);

        List<Integer> gradesArray = readGrades(inputStream);
        for(int g: gradesArray){
            System.out.println(g);
        }
        //generateHistogram(gradesArray);
    }
}
