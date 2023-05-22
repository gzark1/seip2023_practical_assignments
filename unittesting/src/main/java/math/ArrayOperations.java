package math;

import io.FileIO;

import java.util.ArrayList;
import java.util.List;

public class ArrayOperations {

    public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
        int[] initialNumbers = fileIo.readFile(filepath);
        List<Integer> primeNumbersList = new ArrayList<>();

        for(int number: initialNumbers) {
            if (myMath.isPrime(number)) {
                primeNumbersList.add(number);
            }
        }

        //Convert ArrayList to int[]
        int[] primeNumbersArray = primeNumbersList.stream().mapToInt(Integer::intValue).toArray();
        return primeNumbersArray;
    }
}
