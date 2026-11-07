package Lab_3;

import java.util.*;

public class Main {

    private static final int N = 6;

    public static void main(String[] args) {
        int[][] matrix = new int[N][N];

        addEdge(matrix, 0, 1, 3);
        addEdge(matrix, 0, 2, 1);
        addEdge(matrix, 1, 3, 2);
        addEdge(matrix, 2, 3, 4);
        addEdge(matrix, 2, 5, 5);
        addEdge(matrix, 3, 4, 1);
        addEdge(matrix, 4, 5, 2);

        printMatrix(matrix);
        printList(matrix);

        System.out.println("\nBFS");
        bfs(matrix, 0);

        System.out.println("\nDFS");
        dfs(matrix, 0);

        System.out.println("\nДейкстри");
        dijkstra(matrix, 0, 5);
    }

    public static void addEdge (int[][] matrix, int a, int b, int weight) {
        matrix[a][b] = weight;
        matrix[b][a] = weight;
    }

    public static void printMatrix (int[][] matrix) {
        System.out.println("\nМатриця суміжності");

        System.out.print("    ");
        for (int i = 0; i < N; i++) {
            System.out.printf("%4c", (char) ('A' + i));
        }
        System.out.println();

        for (int i = 0; i < N; i++) {
            System.out.printf("%4c", (char) ('A' + i));

            for (int j = 0; j < N; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void printList(int[][] matrix) {
        System.out.println("\nСписок суміжності");

        for (int i = 0; i < N; i++) {
            System.out.print((char) ('A' + i) + ": ");

            for (int j = 0; j < N; j++) {
                if (matrix[i][j] > 0) {
                    System.out.print((char) ('A' + j)
                            + "(" + matrix[i][j] + ") ");
                }
            }
            System.out.println();
        }
    }

    public static void bfs(int[][] matrix, int a) {
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        List<Character> order = new ArrayList<>();

        visited[a] = true;
        distance[a] = 0;
        queue.add(a);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add((char) ('A' + current));

            for (int i = 0; i < N; i++) {
                if(matrix[current][i] > 0 && !visited[i]) {
                    visited[i] = true;
                    distance[i] = distance[current] + 1;
                    queue.add(i);
                }
            }
        }

        System.out.println("Порядок BFS: " + order);
        System.out.println("Відастань в ребрах від " + a + ": " + Arrays.toString(distance));
    }

    public static void dfs (int[][] matrix, int a) {
        boolean[] visited = new boolean[N];
        List<Character> order = new ArrayList<>();
        dfsRecursive(matrix, a, visited, order);
        System.out.println("Порядок DFS:" + order);
    }

    public static void dfsRecursive (int[][] matrix, int current, boolean[] visited, List<Character> order) {
        visited[current] = true;
        order.add((char) ('A' + current));

        System.out.println("Вхід у вершину: " + (char) ('A' + current));
        for (int i = 0; i < N; i++) {
            if(matrix[current][i] > 0 && !visited[i]) {
                dfsRecursive(matrix, i, visited, order);
            }
        }
    }

    public static void dijkstra(int[][] matrix, int start, int target) {
        int[] dist = new int[N];
        int[] prev = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        dist[start] = 0;

        for (int i = 0; i <= N; i++) {
            int current  = -1;
            int minDist = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    current  = j;
                }
            }

            if (current  == -1 || dist[current ] == Integer.MAX_VALUE) break;
            visited[current ] = true;

            for (int k = 0; k < N; k++) {
                if (matrix[current][k] > 0 && !visited[k]) {
                    if (dist[current] + matrix[current][k] < dist[k]) {
                        dist[k] = dist[current] + matrix[current][k];
                        prev[k] = current;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int at = target; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        List<Character> letterPath = new ArrayList<>();

        for (int vertex : path) {
            letterPath.add((char) ('A' + vertex));
        }
        System.out.println("Найкоротша відстань до " + target + ": " + dist[target]);
        System.out.println("Шлях: " + letterPath);
    }
}