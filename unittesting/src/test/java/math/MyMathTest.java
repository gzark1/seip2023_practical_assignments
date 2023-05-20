package math;

import org.junit.Test;
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
}