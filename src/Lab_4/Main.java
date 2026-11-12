package Lab_4;

import java.util.Arrays;
/*
 *
 * === Результати для n = 8 ===
Факторіал (8!): 40320
Фібоначі (рекурсивно) fib(8): 21
Фібоначі (ітеративно) fib_iter(8): 21

=== Всі перестановки множини [A, B, C] ===
[A, B, C]
[A, C, B]
[B, A, C]
[B, C, A]
[C, B, A]
[C, A, B]

=== Кількість комбінацій ===
C(3, 2) = 3
 *
 *
 *
 *              fib(4)
 *             /      \
 *         fib(3)     fib(2)
 *        /      \
 *    fib(2)    fib(1)
 */
public class Main {
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static long fib(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static long fibIter(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;

        long prev1 = 1, prev2 = 1, current = 0;
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }

    public static void generatePermutations(String[] elements, int currentIndex) {
        if (currentIndex == elements.length - 1) {
            System.out.println(Arrays.toString(elements));
            return;
        }

        for (int i = currentIndex; i < elements.length; i++) {
            swap(elements, currentIndex, i);
            generatePermutations(elements, currentIndex + 1);
            swap(elements, currentIndex, i);
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static long combinations(int n, int k) {
        if (k < 0 || k > n) return 0;
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
    static void main() {
        int n = 8;
        String[] set = {"A", "B", "C"};

        System.out.println("=== Результати для n = " + n + " ===");
        System.out.println("Факторіал (" + n + "!): " + factorial(n));
        System.out.println("Фібоначі (рекурсивно) fib(" + n + "): " + fib(n));
        System.out.println("Фібоначі (ітеративно) fib_iter(" + n + "): " + fibIter(n));

        System.out.println("\n=== Всі перестановки множини " + Arrays.toString(set) + " ===");
        generatePermutations(set, 0);

        int setSize = set.length;
        int k = 2;
        System.out.println("\n=== Кількість комбінацій ===");
        System.out.println("C(" + setSize + ", " + k + ") = " + combinations(setSize, k));
    }
}
