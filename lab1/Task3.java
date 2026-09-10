/*Найти все числа-палиндромы из заданной последовательности чисел при
возведении которых в квадрат получают также числа-палиндромы. Число называется
палиндромом, если его запись читается одинаково слева направо и справа налево,
например, 12321.
 */
import java.util.Scanner;

public class Task3 {

    public static boolean isPalindrome(long n) {
        if (n < 0) return false;
        long orig = n;
        long rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return orig == rev;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество чисел в последовательности");
        int n = scanner.nextInt();

        System.out.println("Введите числа");
        boolean found = false;

        for (int i = 0; i < n; i++) {
            long num = scanner.nextLong();

            if (isPalindrome(num)) {
                long square = num * num;

                if (isPalindrome(square)) {
                    System.out.println("Число:" + num + ", его квадрат:" + square);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Подходящих чисел не найдено");
        }
    }
}