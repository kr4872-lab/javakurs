import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> matrix = Utils.inputMatrix(scanner);

        System.out.println("\nИсходная матрица:");
        Utils.printMatrix(matrix);

        int rows = matrix.size();
        if (rows == 0) {
            scanner.close();
            return;
        }
        int cols = matrix.get(0).size();


        int minVal = matrix.get(0).get(0);
        int minRow = 0;
        int minCol = 0;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int currentVal = matrix.get(i).get(j);
                if (currentVal < minVal) {
                    minVal = currentVal;
                    minRow = i;
                    minCol = j;
                }
            }
        }

        System.out.printf("\nМинимальный элемент: %d найден на позиции [%d][%d]\n", minVal, minRow, minCol);


        System.out.print("Введите целевую строку (targetRow): ");
        int targetRow = scanner.nextInt();

        System.out.print("Введите целевой столбец (targetCol): ");
        int targetCol = scanner.nextInt();


        if (targetRow < 0 || targetRow >= rows || targetCol < 0 || targetCol >= cols) {
            System.out.println("Ошибка: индексы вне пределов матрицы!");
            scanner.close();
            return;
        }

        if (minRow != targetRow) {
            ArrayList<Integer> tempRow = matrix.get(minRow);
            matrix.set(minRow, matrix.get(targetRow));
            matrix.set(targetRow, tempRow);
        }


        if (minCol != targetCol) {
            for (int i = 0; i < rows; i++) {
                ArrayList<Integer> row = matrix.get(i);
                int tempVal = row.get(minCol);
                row.get(minCol); // просто для понимания
                row.set(minCol, row.get(targetCol));
                row.set(targetCol, tempVal);
            }
        }

        System.out.println("\nМатрица после перемещения минимального элемента:");
        Utils.printMatrix(matrix);

        scanner.close();
    }
}