package math; //same package structure with the functional class whose code it is testing.

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticOperationsTest {

    @Test(expected = ArithmeticException.class)
    public void divideShouldThrowArithmeticExceptionIfDividedBy0(){
        ArithmeticOperations arithmeticOps = new ArithmeticOperations();
        arithmeticOps.divide(5,0);
    }

}