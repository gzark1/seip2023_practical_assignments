package math;

public class MyMath {
    public int factorial (int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException();
        }
        else if (n == 0) return 1;
        else {
            int result = n * factorial(n-1);
            return result;
        }
    }

    public boolean isPrime(int n) {
        // Check if n is less than 2, as prime numbers start from 2
        if (n < 2) {
            throw new IllegalArgumentException("number should be >= 2");
        }

        // Check for divisibility by numbers from 2 to the square root of n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // If n is divisible by any number, it is not prime
                return false;
            }
        }

        // If no divisors are found, n is prime
        return true;
    }
}
