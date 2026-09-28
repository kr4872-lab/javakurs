package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Polynomial> polynomials = new ArrayList<>();

        System.out.print("Сколько полиномов вы хотите создать и просуммировать? ");
        int m = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            System.out.println("\nВвод полинома №" + (i + 1) );
            System.out.print("Введите количество коэффициентов (степень полинома + 1): ");
            int count = scanner.nextInt();

            List<Complex> coeffs = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                System.out.println("Коэффициент при x^" + j + ":");
                System.out.print("Введите действительную часть (re): ");
                double re = scanner.nextDouble();
                System.out.print("Введите мнимую часть (im): ");
                double im = scanner.nextDouble();

                coeffs.add(new Complex(re, im));
            }

            Polynomial p = new Polynomial(coeffs);
            polynomials.add(p);
            System.out.println("Созданный полином: " + p);
        }

        if (!polynomials.isEmpty()) {
            Polynomial zeroPolynomial = new Polynomial(List.of(new Complex(0, 0)));

            Polynomial totalSum = polynomials.stream()
                    .reduce(zeroPolynomial, Polynomial::add);

            System.out.println("\nСумма всех введенных полиномов:");
            System.out.println(totalSum);
        }

        scanner.close();
    }
}