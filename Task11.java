//11. Дана целочисленная матрица размера A(n,m). Найти строки,
//содержащих равное количество положительных и отрицательных элементов
//(нулевые элементы матрицы не учитываются) и заменить все элементы таких
//строк нулями. Если таких строк нет, то удалить строки, состоящие из
//одинаковых элементов
import java.util.*;


public class Task11 {
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

        result(matrix);

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

    private static void result(Matrix matrix) {
        List<Integer> equal = matrix.findEquality();

        if (!equal.isEmpty()) {
            System.out.print("\nИндексы строк с равным количеством + и - : " + equal);
            matrix.resetToZero(equal);
        }
        else {
            System.out.print("\nСтрок с равным количеством + и - нет.");
            matrix.deleteIdentical();
        }
        System.out.print("\nИзмененная матрица: \n");
        matrix.print();
    }

    static class Matrix {
        private int[][] elements;
        private int rows;
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
                    elements[i][j] = rand.nextInt(21) - 10;
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

        public List<Integer> findEquality() {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                int pos = 0, neg = 0;
                for (int j = 0; j < cols; j++) {
                    if (elements[i][j] > 0) pos++;
                    else if (elements[i][j] < 0) neg++;
                }
                if (pos > 0 && pos == neg) {
                    result.add(i);
                }
            }
            return result;
        }

        public void resetToZero(List<Integer> rowIndices) {
            for (int i : rowIndices) {
                for (int j = 0; j < cols; j++) {
                    elements[i][j] = 0;
                }
            }
        }

        public void deleteIdentical() {
            List<int[]> kept = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                if (!isAllIdentical(elements[i])) {
                    kept.add(elements[i]);
                }
            }
            rows = kept.size();
            elements = kept.toArray(new int[rows][]);
        }

        private boolean isAllIdentical(int[] row) {
            for (int j = 1; j < row.length; j++) {
                if (row[j] != row[0]) return false;
            }
            return true;
        }

    }

}

