import java.util.Scanner;

public class FibonacciDP {
    public static long fibonacci(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Create an array to store Fibonacci numbers
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // Fill the array using the recurrence relation
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }
}
