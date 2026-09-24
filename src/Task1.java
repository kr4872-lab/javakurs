import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> matrix = Utils.inputMatrix(scanner);

        System.out.println("\nИсходная матрица:");
        Utils.printMatrix(matrix);

        System.out.println("Какой циклический сдвиг мы будем делать (right, left, up, down)?");
        scanner.nextLine();
        String choice = scanner.nextLine().toLowerCase();

        switch (choice){
            case "right":
                System.out.print("Введите количество позиций для сдвига (k): ");
                int kRight = scanner.nextInt();

                for (int i = 0; i < matrix.size(); i++) {
                    ArrayList<Integer> row = matrix.get(i);
                    int size = row.size();
                    if (size == 0) continue;

                    int shift = kRight % size;
                    if (shift < 0) shift += size;

                    ArrayList<Integer> temp = new ArrayList<>(row);
                    for (int j = 0; j < size; j++) {
                        int newIndex = (j + shift) % size;
                        row.set(newIndex, temp.get(j));
                    }
                }

                System.out.println("\nМатрица после сдвига вправо:");
                Utils.printMatrix(matrix);
                break;

            case "left":
                System.out.print("Введите количество позиций для сдвига (k): ");
                int kLeft = scanner.nextInt();

                for (int i = 0; i < matrix.size(); i++) {
                    ArrayList<Integer> row = matrix.get(i);
                    int size = row.size();
                    if (size == 0) continue;

                    int shift = kLeft % size;
                    if (shift < 0) shift += size;

                    ArrayList<Integer> temp = new ArrayList<>(row);
                    for (int j = 0; j < size; j++) {

                        int newIndex = (j - shift + size) % size;
                        row.set(newIndex, temp.get(j));
                    }
                }

                System.out.println("\nМатрица после сдвига влево:");
                Utils.printMatrix(matrix);
                break;

            case "down":
                System.out.print("Введите количество позиций для сдвига (k): ");
                int kDown = scanner.nextInt();

                int rows = matrix.size();
                if (rows == 0) break;

                int shiftRowsDown = kDown % rows;
                if (shiftRowsDown < 0) shiftRowsDown += rows;

                ArrayList<ArrayList<Integer>> tempMatrixDown = new ArrayList<>();
                for (ArrayList<Integer> row : matrix) {
                    tempMatrixDown.add(new ArrayList<>(row));
                }

                for (int i = 0; i < rows; i++) {
                    int newRowIndex = (i + shiftRowsDown) % rows;
                    matrix.set(newRowIndex, tempMatrixDown.get(i));
                }

                System.out.println("\nМатрица после сдвига вниз:");
                Utils.printMatrix(matrix);
                break;

            case "up":
                System.out.print("Введите количество позиций для сдвига (k): ");
                int kUp = scanner.nextInt();

                int rowsCount = matrix.size();
                if (rowsCount == 0) break;

                int shiftRowsUp = kUp % rowsCount;
                if (shiftRowsUp < 0) shiftRowsUp += rowsCount;


                ArrayList<ArrayList<Integer>> tempMatrixUp = new ArrayList<>();
                for (ArrayList<Integer> row : matrix) {
                    tempMatrixUp.add(new ArrayList<>(row));
                }

                for (int i = 0; i < rowsCount; i++) {
                    int newRowIndex = (i - shiftRowsUp + rowsCount) % rowsCount;
                    matrix.set(newRowIndex, tempMatrixUp.get(i));
                }

                System.out.println("\nМатрица после сдвига вверх:");
                Utils.printMatrix(matrix);
                break;

            default:
                System.out.println("Лучше за шавой пойдем");
        }

        scanner.close();
    }
}