package math;

public class MyMath {
    public int factorial (int n){
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException();
        }
        else if (n == 0) return 1;
        else {
            int result = n * factorial(n-1);
            return result;
        }
    }
}
