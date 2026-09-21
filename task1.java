//1.
//Найти все числа из заданной последовательности целых чисел, взаимно простые
//с заданным числом p. Взаимно простые числа — это два числа, для которых НОД
//(наибольший общий делитель) равен единице.

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the length of your sequence n =");
        int n = scan.nextInt();
        while (n <= 0){
            System.out.print("Invalid input. Try again. n = ");
            n = scan.nextInt();
        }

        int[] sequence = new int[n];
        System.out.println("Enter your sequence of " + n + " elements, separated by enter/space");
        for (int i = 0; i < n; i++) {
            sequence[i] = scan.nextInt();
        }

        System.out.print("Enter p = ");
        int p = scan.nextInt();
        int absP = Math.abs(p);

        int[] res = new int[n];
        int a, b, idx = 0;
        for (int elem : sequence){
            a = Math.abs(elem);
            b = absP;
            while (b != 0){
                int temp = b;
                b = a % b;
                a = temp;
            }
            if (a == 1){
                res[idx] = elem;
                idx++;
            }
        }

        if (idx == 0) {
            System.out.println("\nIn the given sequence there are no numbers coprime to " + p);
        }
        else {
            System.out.print("\nNumbers coprime to " + p + ": ");
            for(int i = 0; i < idx; i++){
                System.out.print(res[i] + " ");
            }
        }
    }
}