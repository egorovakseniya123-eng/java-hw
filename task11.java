//11.
//Найти в натуральном числе n среднее арифметическое цифр, отличных от
//заданной цифры k.

import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter n = ");
        int n = scan.nextInt();
        while (n <= 0) {
            System.out.print("n must be a natural number. n = ");
            n = scan.nextInt();
        }

        System.out.print("Enter k = ");
        int k = scan.nextInt();
        while (k > 9 || k < 0) {
            System.out.print("k must be a digit. k = ");
            k = scan.nextInt();
        }

        int sum = 0, count = 0, digit;
        while(n != 0) {
            digit = n % 10;
            if (digit != k){
                sum += digit;
                count++;
            }
            n /= 10;
        }

        if (count == 0) {
            System.out.print("There are no digits other than " + k);
        }
        else {
            float mean = (float)sum/count;
            System.out.print("The arithmetic mean of the digits other than " + k + " is equal to " + mean);
        }
    }
}