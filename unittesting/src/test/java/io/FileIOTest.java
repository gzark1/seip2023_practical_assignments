package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class FileIOTest {

    FileIO fileIO = new FileIO();
    public static String resourcesPath = "src/test/resources/";

    @Test
    public void testreadFileNormalCase() {
        String filepath = resourcesPath + "testNormalCaseFile.txt";
        int[] expectedNumbers = new int[] { 6, 9, 10, 2, 4, 25, 32, 0, 1};
        assertArrayEquals(expectedNumbers, fileIO.readFile(filepath));
    }

    @Rule
    public final ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void readFileShouldThrowIllegalArgumentExceptionIfFileDoesntExist() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Input file does not exist");

        String filepath = resourcesPath + "nonExistentFile.txt";
        int[] numbersArray = fileIO.readFile(filepath);
    }

    @Test
    public void readFileShouldThrowIllegalArgumentExceptionIfFileIsEmpty() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Given file is empty");

        String filepath = resourcesPath + "emptyFile.txt";
        int[] numbersArray = fileIO.readFile(filepath);
    }

    @Test
    public void testReadFileContainsInvalidEntries() {
        String filepath = resourcesPath + "InvalidEntriesFile.txt";
        int[] numbersArray = fileIO.readFile(filepath);
        int[] expectedNumbers = new int[] { 3, 51, 10, 1, 49, 99};
        assertArrayEquals(expectedNumbers, fileIO.readFile(filepath));
    }

}