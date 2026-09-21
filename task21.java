import java.util.Scanner;

//21.
//Среди натуральных чисел найти число с максимальной суммой своих простых
//делителей.
public class task21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the length of sequence of natural numbers: ");
        int n = scan.nextInt();
        while (n <= 0) {
            System.out.print("Invalid input. n = ");
            n = scan.nextInt();
        }

        int[] sequence = new int[n];
        int num;
        System.out.print("Enter your sequence of " + n + " natural numbers, separated by enter/space: ");
        for (int i = 0; i < n; i++) {
            num = scan.nextInt();
            while (num <= 0) {
                System.out.print("Invalid input. num = ");
                num = scan.nextInt();
            }
            sequence[i] = num;
        }

        int maxSum = -1;
        int winner = -1;
        for (int elem : sequence) {
            int curSum = sumOfPrimes(elem);
            if (curSum > maxSum) {
                maxSum = curSum;
                winner = elem;
            }
        }
        System.out.print("The number with the maximum sum of its prime divisors: " + winner +
                "\nSum of divisors: " + maxSum);
    }


    public static int sumOfPrimes(int num) {
        if (num <= 1) {
            return 0;
        }
        int n = num;
        int sum = 0;
        if (n % 2 == 0) {
            sum += 2;
            while (n % 2 == 0) {
                n /= 2;
            }
        }
        for (int factor = 3; factor * factor <= n; factor += 2) {
            if (n % factor == 0) {
                sum += factor;
                while (n % factor == 0) {
                    n /= factor;
                }
            }
        }
        if (n > 1) {
            sum += n;
        }
        return sum;
    }
}