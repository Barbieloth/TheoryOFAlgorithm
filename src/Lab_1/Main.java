package Lab_1;
// Казік Максим Кн-31 Лабараторна №1
/*
=== Прогін A, L, B, D, C на n від 100 до 3200 ===
n        | O(1)   | O(log n)   | O(n)     | O(n log n)   | O(n^2)
------------------------------------------------------------------
        100      | 1      | 6          | 100      | 600          | 10000
        200      | 1      | 7          | 200      | 1400         | 40000
        400      | 1      | 8          | 400      | 3200         | 160000
        800      | 1      | 9          | 800      | 7200         | 640000
        1600     | 1      | 10         | 1600     | 16000        | 2560000
        3200     | 1      | 11         | 3200     | 35200        | 10240000

=== Прогін E та F на малих n ===

        --- Функція E O(2^n) ---
n    | Steps O(2^n)
---------------------
        1    | 2
        2    | 4
        3    | 8
        4    | 16
        5    | 32
        6    | 64
        7    | 128
        8    | 256
        9    | 512
        10   | 1024
        11   | 2048
        12   | 4096

        --- Функція F O(n!) ---
n    | Steps O(n!)
--------------------
        4    | 24
        5    | 120
        6    | 720
        7    | 5040
        8    | 40320
        9    | 362880
 */
public class Main {

    // A. O(1) — без циклу
    public static long funcA(long n){
        long steps = 1;
        long sum = n * (n + 1) / 2;
        return steps;
    }

    // L. O(log n) — цикл ділить навпіл
    public static long funcL(long n){
        long steps = 0;
        long j = n;
        while (j > 1) {
            steps++;
            j = j / 2;
        }
        return steps;
    }

    // B. O(n) — один цикл
    public static long funcB(long n){
        long steps = 0;
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            steps++;
            sum += i;
        }
        return steps;
    }

    // D. O(n log n) — вкладений цикл, внутрішній ділить навпіл
    public static long funcD(long n){
        long steps = 0;
        for (long i = 1; i <= n; i++) {
            long j = n;
            while (j > 1) {
                steps++;
                j = j / 2;
            }
        }
        return steps;
    }

    // C. O(n^2) — два вкладених цикли від 1 до n
    public static long funcC(long n){
        long steps = 0;
        for (long i = 1; i <= n; i++) {
            for (long j = 1; j <= n; j++) {
                steps++;
            }
        }
        return steps;
    }

    // E. O(2^n) — ітеративний експоненційний ріст
    public static long funcE(long n){
        long steps = 0;
        long limit = 1L << n; // 2^n
        for (long i = 0; i < limit; i++) {
            steps++;
        }
        return steps;
    }

    // F. O(n!) — факторіальний ріст
    public static long funcF(long n){
        long steps = 0;
        long limit = 1;
        for (long i = 1; i <= n; i++) {
            limit *= i;
        }
        for (long i = 0; i < limit; i++) {
            steps++;
        }
        return steps;
    }

    static void main() {
        long[] nValues = {100, 200, 400, 800, 1600, 3200};
        long[] nExp = {8, 10, 12, 14, 16, 18};
        long[] nFact = {4, 5, 6, 7, 8, 9};

        System.out.println("=== Прогін A, L, B, D, C на n від 100 до 3200 ===");
        System.out.printf("%-8s | %-6s | %-10s | %-8s | %-12s | %-12s%n",
                "n", "O(1)", "O(log n)", "O(n)", "O(n log n)", "O(n^2)");
        System.out.println("------------------------------------------------------------------");

        for (long n : nValues) {
            long stepsA = funcA(n);
            long stepsL = funcL(n);
            long stepsB = funcB(n);
            long stepsD = funcD(n);
            long stepsC = funcC(n);

            System.out.printf("%-8d | %-6d | %-10d | %-8d | %-12d | %-12d%n",
                    n, stepsA, stepsL, stepsB, stepsD, stepsC);
        }

        System.out.println("\n=== Прогін E та F на малих n ===");
        System.out.println("\n--- Функція E O(2^n) ---");
        System.out.printf("%-4s | %-12s%n", "n", "Steps O(2^n)");
        System.out.println("---------------------");
        for (long n = 1; n <= 12; n++) {
            long stepsE = funcE(n);
            System.out.printf("%-4d | %-12d%n", n, stepsE);
        }
        System.out.println("\n--- Функція F O(n!) ---");
        System.out.printf("%-4s | %-12s%n", "n", "Steps O(n!)");
        System.out.println("--------------------");
        for (long n : nFact) {
            long stepsF = funcF(n);
            System.out.printf("%-4d | %-12d%n", n, stepsF);
        }
    }

}
