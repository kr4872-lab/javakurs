/*Определить, сколько раз каждая десятичная цифра встречается в записи каждого
числа n с чётным количеством цифр из заданной последовательности натуральных чисел*/
import java.util.Scanner;

public class Task1 {
    public static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input how many numbers are in the sequence");
        int l = scanner.nextInt();
        int numbers[] = new int[l];

        System.out.println("Input " + l + " numbers:");
        for (int i = 0; i < l; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            int count_digits = countDigits(numbers[i]);

            if (count_digits % 2 == 0) {
                int decimal_digits[] = new int[10];
                int temp = numbers[i];

                while (temp > 0) {
                    int p = temp % 10;
                    decimal_digits[p]++;
                    temp /= 10;
                }

                System.out.println("Число " + numbers[i] + " (четное кол-во цифр: " + count_digits + "):");

                for (int d = 0; d < 10; d++) {
                    if (decimal_digits[d] > 0) {
                        System.out.println("  Цифра " + d + " встречается: " + decimal_digits[d] + " раз(а)");
                    }
                }
            }
        }

        scanner.close();
    }
}