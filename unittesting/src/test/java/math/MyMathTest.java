package math;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MyMathTest{
    @Test (expected = IllegalArgumentException.class)
    public void factorialOfMinus1ShouldThrowIllegalArgumentException() {
        MyMath myMathObj = new MyMath();
        int result = myMathObj.factorial(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void factorialOf13ShouldThrowIllegalArgumentException() {
        MyMath myMathObj = new MyMath();
        int result = myMathObj.factorial(13);
    }

    @Test
    public void testIsPrimeWithPrimeNumbers() {
        MyMath myMathObj = new MyMath();

        assertTrue(myMathObj.isPrime(2));
        assertTrue(myMathObj.isPrime(3));
        assertTrue(myMathObj.isPrime(5));
        assertTrue(myMathObj.isPrime(7));
        assertTrue(myMathObj.isPrime(36787));
        assertTrue(myMathObj.isPrime(4261));
        assertTrue(myMathObj.isPrime(6977));
    }

    @Test
    public void testIsPrimeWithNonPrimeNumbers() {
        MyMath myMathObj = new MyMath();

        assertFalse(myMathObj.isPrime(999));
        assertFalse(myMathObj.isPrime(4));
        assertFalse(myMathObj.isPrime(6));
        assertFalse(myMathObj.isPrime(8));
        assertFalse(myMathObj.isPrime(10002));
        assertFalse(myMathObj.isPrime(9372));
        assertFalse(myMathObj.isPrime(111));
    }

    @Rule
    public final ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void isPrimeShouldThrowIllegalArgumentExceptionIfNumberLessthan2() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("number should be >= 2");

        MyMath myMathObj = new MyMath();
        boolean flag = myMathObj.isPrime(1);
    }
}