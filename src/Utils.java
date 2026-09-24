
import java.util.ArrayList;
import java.util.Scanner;


public class Utils {
    public static ArrayList<ArrayList<Integer>> inputMatrix(Scanner scanner){
        System.out.print("Введите количество строк : ");
        int rows = scanner.nextInt();

        System.out.print("Введите количество столбцов : ");
        int cols = scanner.nextInt();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i=0; i < rows; i++){
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int j=0;j<cols;j++){
                System.out.print("Введите элемент ["+i+"] ["+j+"]");
                currentRow.add(scanner.nextInt());
            }
            matrix.add(currentRow);
        }
        return matrix;
    }



    public static void printMatrix(ArrayList<ArrayList<Integer>> matrix){
        if (matrix.isEmpty()){
            System.out.print("Харам на матрицу");
            return;
        }

        for (ArrayList<Integer> row : matrix){
            for (Integer val : row) {
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }


}

