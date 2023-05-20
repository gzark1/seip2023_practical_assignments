package math;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FactorialParameterizedTest {

    @Parameter (value = 0)
    public int number;
    @Parameter (value = 1)
    public int factorial;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
            {0,1}, {1,1}, {2,2}, {12,479001600}
        };
        return Arrays.asList(data);
    }
    @Test
    public void testFactorialWithParameters(){
        MyMath myMathObj = new MyMath();
        assertTrue("Factorial calculation failed for number " + number + ". Expected factorial: " + factorial,
                myMathObj.factorial(number) == factorial);
    }
}