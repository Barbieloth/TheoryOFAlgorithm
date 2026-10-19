package Lab_2;

/**
 * Практична робота №2
 * Варіант 8
 * Крок | Дія                  | Стан масиву
 * -----|----------------------|------------------
 * 0    | Початковий масив     | 7, 1, 4, 8, 2, 6
 * 1    | Обмін 7 та 1         | 1, 7, 4, 8, 2, 6
 * 2    | Обмін 7 та 2         | 1, 2, 4, 8, 7, 6
 * 3    | Обмін не потрібен    | 1, 2, 4, 8, 7, 6
 * 4    | Обмін 8 та 6         | 1, 2, 4, 6, 7, 8
 * 5    | Обмін не потрібен    | 1, 2, 4, 6, 7, 8
 * Кількість порівнянь: 15
 * Кількість обмінів: 3
 */

public class Main {
    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int m = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[m]) {
                    m = j;
                }
            }

            int temp = a[i];
            a[i] = a[m];
            a[m] = temp;
        }
    }
    static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = a[(lo + hi) / 2];
        int i = lo;
        int j = hi;

        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;

            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

                i++;
                j--;
            }
        }

        if (lo < j) quickSort(a, lo, j);
        if (i < hi) quickSort(a, i, hi);
    }
    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }
    static int binarySearch(int[] a, int x) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (a[mid] == x) {
                return mid;
            }

            if (a[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
    static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }

        return c;
    }
    public static void main(String[] args) {
        int[] original = {7, 1, 4, 8, 2, 6};
        int[] a = original.clone();
        int[] b = original.clone();

        System.out.println("Вхідний масив: "
                + java.util.Arrays.toString(original));

        selectionSort(a);
        System.out.println("Вибором: "
                + java.util.Arrays.toString(a));

        quickSort(b, 0, b.length - 1);
        System.out.println("Хоара: "
                + java.util.Arrays.toString(b));

        System.out.println("Лінійний пошук 6: "
                + linearSearch(original, 6));

        System.out.println("Бінарний пошук 6: "
                + binarySearch(b, 6));

        System.out.println("Бінарний пошук 99: "
                + binarySearch(b, 99));

        int[] first = {3, 5, 12};
        int[] second = {1, 4, 8, 9};

        System.out.println("Злиття: "
                + java.util.Arrays.toString(merge(first, second)));
    }

}
