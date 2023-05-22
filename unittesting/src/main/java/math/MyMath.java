package math;

/**
 * The MyMath class provides mathematical utility functions.
 *
 *  @author  gzark1
 *  @version 1.0
 *  @since   2023-05-22
 */
public class MyMath {

    /**
     * Calculates the factorial of a given number.
     *
     * @param n The number for which to calculate the factorial.
     * @return The factorial of the given number.
     * @throws IllegalArgumentException If the number is less than 0 or greater than 12.
     */
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

    /**
     * Checks if a number is prime.
     *
     * @param n The number to check.
     * @return true if the number is prime, false otherwise.
     * @throws IllegalArgumentException If the number is less than 2.
     */
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
