package math;

import io.FileIO;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayOperationsTest {

    ArrayOperations arrOp = new ArrayOperations();
    public static String resourcesPath = "src/test/resources/";

    @Test
    public void testFindPrimesInFileMocking() {
        MyMath mm = mock(MyMath.class);
        FileIO fIO = mock(FileIO.class);
        String filepath = resourcesPath + "findPrimesMockingFile.txt";

        when(fIO.readFile(filepath)).thenReturn(new int[]{4, 5, 11, 6, 53, 9372, 111});
        when(mm.isPrime(4)).thenReturn(false);
        when(mm.isPrime(5)).thenReturn(true);
        when(mm.isPrime(11)).thenReturn(true);
        when(mm.isPrime(6)).thenReturn(false);
        when(mm.isPrime(53)).thenReturn(true);
        when(mm.isPrime(9372)).thenReturn(true);
        when(mm.isPrime(111)).thenReturn(false);

        assertArrayEquals(new int[]{5, 11, 53, 9372}, arrOp.findPrimesInFile(fIO, filepath, mm));
    }
}