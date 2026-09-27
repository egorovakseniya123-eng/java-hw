//1. Дана целочисленная матрица размера A(n,m), элементы которой
//могут принимать значения от 0 до 10. Коэффициентом похожести строк
//назовем количество чисел из пересечения множеств, составленных их этих
//строк. Отсортировать строки матрицы по степени похожести с k-ой строкой.
//Уточним, пусть есть две строки {1, 1, 3, 1, 27, 2, 3, 3}{1, 1, 3, 44, 1, 1, 21, 22}.
//Составим множества, составленные их этих строк. {1, 3, 27, 2}{1, 3, 44, 21, 22}.
//Совпадают числа 1 и 3. Коэффициент похожести строк равен двум

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;


public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Matrix matrix = createMatrix(scan);

        int mode;
        while (true) {
            System.out.print("Заполнить матрицу: \n1 - случайными числами; \n2 - введенными числами.\n");
            mode = scan.nextInt();
            if (mode == 1 || mode == 2) {
                break;
            }
            System.out.print("\nНеверный ввод. Попробуйте снова");
        }
        if (mode == 1) {
            matrix.fillRandom();
        }
        else {
            matrix.fillManually(scan);
        }

        System.out.print("Ваша матрица: \n");
        matrix.print();

        int k;
        while (true) {
            System.out.print("Введите номер k строки-эталона ");
            k = scan.nextInt();
            if (k >= 1 && k <= matrix.getRows()) {
                break;
            }
            System.out.print("Ваше k выходит за пределы количества строк. Попробуйте снова.\n");
        }
        matrix.sortRows(k);

        System.out.print("Отсортированная матрица: \n");
        matrix.print();
    }
    private static Matrix createMatrix(Scanner scan) {
        while (true) {
            System.out.print("\nВведите количество строк матрицы. n = ");
            int n = scan.nextInt();
            System.out.print("Введите количество столбцов матрицы. m = ");
            int m = scan.nextInt();
            if (n <= 0 || m <= 0) {
                System.out.print("Размеры должны быть положительными. Попробуйте снова.\n");
                continue;
            }
            return new Matrix(n, m);

        }
    }
    static class Matrix {
        private final int[][] elements;
        private final int rows;
        private final int cols;

        public Matrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.elements = new int[rows][cols];
        }

        public void fillRandom() {
            Random rand = new Random();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    elements[i][j] = rand.nextInt(11);
                }
            }
        }

        public void fillManually(Scanner scanner) {
            System.out.println("Введите элементы матрицы построчно (через пробел):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    elements[i][j] = scanner.nextInt();
                }
            }
        }

        public void print() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(elements[i][j] + " ");
                }
                System.out.println();
            }
        }

        public int getRows() {
            return rows;
        }

        public void sortRows(int k) {
            if (rows <= 1) return;
            if (k < 1 || k > rows) {
                System.out.print("Неверный k.");
                return;
            }

            HashSet<Integer> refSet = new HashSet<>();
            for (int val : elements[k-1]) {
                refSet.add(val);
            }

            Integer[] indices = new Integer[rows];
            int[] similarities = new int[rows];

            for (int i = 0; i < rows; i++) {
                indices[i] = i;
                similarities[i] = countSimilarity(elements[i], refSet);
            }

            Arrays.sort(indices,(i1, i2) -> Integer.compare(similarities[i2], similarities[i1]));

            int[][] sorted = new int[rows][];
            for (int i = 0; i < rows; i++) {
                sorted[i] = elements[indices[i]];
            }

            System.arraycopy(sorted, 0, elements, 0, rows);
        }

        private int countSimilarity(int[] row, HashSet<Integer> referenceSet) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int val : row) {
                rowSet.add(val);
            }
            rowSet.retainAll(referenceSet);
            return rowSet.size();
        }
    }

}

