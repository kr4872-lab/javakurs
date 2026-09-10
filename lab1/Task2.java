/* Для каждого числа из заданной последовательности натуральных чисел найти
произведение цифр, находящихся на чётных позициях (нумерация позиций идёт справа
налево)
*/
import java.util.Scanner;
public class Task2 {
    public static int multiplication_numbers(int num){
        int mul = 1;
        int pos = 1;
        boolean has_digit=false;
        while (num > 0){
            int a = num % 10;
            if (pos % 2 == 0){

                mul *=a;
                has_digit=true;
            }
            num /=10;
            pos++;
        }
        return has_digit ? mul : 0;


    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input how many numbers are in the sequence");
        int l = scanner.nextInt();
        int numbers[] = new int[l];

        System.out.println("Input " + l + " numbers:");
        for (int i = 0; i < l; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int j = 0;j < numbers.length; j++){
            if (j % 2 == 0){}
            int mult_digt = multiplication_numbers(numbers[j]);
            System.out.println("Число = " + numbers[j] + " его произведение цифр = " + mult_digt);
        }


    }
}
