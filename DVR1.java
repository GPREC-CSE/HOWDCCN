import java.util.Scanner;

public class Main {
    static int[][] graph, via, rt;
    static int v, e;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Vertices: ");
        v = sc.nextInt();
        System.out.print("Enter number of Edges: ");
        e = sc.nextInt();

        graph = new int[v][v];
        via = new int[v][v];
        rt = new int[v][v];
        initializeGraph();

        for (int i = 0; i < e; i++) {
            System.out.printf("Edge %d: Source, Destination, Cost: ", i + 1);
            int s = sc.nextInt() - 1, d = sc.nextInt() - 1, c = sc.nextInt();
            graph[s][d] = graph[d][s] = c;
        }

        calculateAndDisplay("Initial Routing Tables:");
        System.out.print("Source, Destination of changed edge and new Cost: ");
        int s = sc.nextInt() - 1, d = sc.nextInt() - 1, c = sc.nextInt();
        graph[s][d] = graph[d][s] = c;
        calculateAndDisplay("Updated Routing Tables:");
    }

    static void initializeGraph() {
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++)
                graph[i][j] = (i == j) ? 0 : 9999;
    }

    static void calculateAndDisplay(String message) {
        initializeTables();
        for (int k = 0; k < 4 * v; k++) updateTable(k % v);
        System.out.println("\n" + message);
        printTables();
    }

    static void initializeTables() {
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++) {
                rt[i][j] = (i == j) ? 0 : 9999;
                via[i][j] = (i == j) ? i : 100;
            }
    }

    static void updateTable(int src) {
        for (int i = 0; i < v; i++) {
            if (graph[src][i] == 9999) continue;
            int dist = graph[src][i];
            for (int j = 0; j < v; j++) {
                int interDist = (via[i][j] == src) ? 9999 : rt[i][j];
                if (dist + interDist < rt[src][j]) {
                    rt[src][j] = dist + interDist;
                    via[src][j] = i;
                }
            }
        }
    }

    static void printTables() {
        for (int[] row : rt) {
            for (int dist : row) System.out.print("Dist: " + dist + " ");
            System.out.println();
        }
    }
}