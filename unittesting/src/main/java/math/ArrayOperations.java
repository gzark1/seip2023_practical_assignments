package math;

import io.FileIO;

import java.util.ArrayList;
import java.util.List;

/**
 * The ArrayOperations class provides operations on arrays of numbers.
 *
 * @author  gzark1
 * @version 1.0
 * @since   2023-05-22
 */
public class ArrayOperations {

    /**
     * Finds prime numbers in a file.
     *
     * @param fileIo The FileIO object used for file operations.
     * @param filepath The path of the file to read.
     * @param myMath The MyMath object used for prime number checks.
     * @return An array containing the prime numbers found in the file.
     */
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
