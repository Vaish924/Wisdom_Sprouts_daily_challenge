import java.util.Scanner;

public class DivisorCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a number: ");
        int N = sc.nextInt();

        int count = 0;

        // Loop only till sqrt(N)
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                // If divisors are equal (perfect square)
                if (i * i == N) {
                    count++;
                } else {
                    count += 2; // i and N/i
                }
            }
        }

        // Output
        System.out.println("Total number of divisors: " + count);

        sc.close();
    }
}
