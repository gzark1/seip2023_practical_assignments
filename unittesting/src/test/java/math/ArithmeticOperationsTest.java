package math; //same package structure with the functional class whose code it is testing.

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class ArithmeticOperationsTest {

    @Test(expected = ArithmeticException.class)
    public void divideShouldThrowArithmeticExceptionIfDividedBy0(){
        ArithmeticOperations arithmeticOps = new ArithmeticOperations();
        double res = arithmeticOps.divide(5,0);
    }

    @Test
    public void divide9999999WithMinus8888888ShouldReturnMinus1Point125(){
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertTrue("9999999/(-8888888) equals -1.125", -1.125 == arithmeticOperations.divide(9999999, -8888888));
    }

    @Rule
    public final ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void multiplyShouldThrowIllegalArgumentExceptionIfXNegative(){
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("x & y should be >= 0");

        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        int res = arithmeticOperations.multiply(-3, 4);
    }

    @Test
    public void multiplyShouldThrowIllegalArgumentExceptionIfYNegative(){
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("x & y should be >= 0");

        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        int res = arithmeticOperations.multiply(10, -5);
    }

    @Test
    public void multiplyShouldThrowIllegalArgumentExceptionIfProductDoesNotFitIntType(){
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("The product does not fit in an Integer variable");

        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        int res = arithmeticOperations.multiply(Integer.MAX_VALUE, 2);
    }

    @Test
    public void multiply1055With39122ShouldReturn41273710(){
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertTrue("1055 * 39122 equals 41273710", arithmeticOperations.multiply(1055,39122) == 41273710);
    }
}