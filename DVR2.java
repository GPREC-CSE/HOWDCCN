import java.util.Scanner;

public class DVR2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Vertices: ");
        int v = sc.nextInt();
        System.out.print("Enter number of Edges: ");
        int e = sc.nextInt();

        int[][] graph = new int[v][v];
        int[][] rt = new int[v][v];

        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++)
                graph[i][j] = (i == j) ? 0 : 9999;

        for (int i = 0; i < e; i++) {
            System.out.printf("Edge %d: Source, Destination, Cost: ", i + 1);
            int s = sc.nextInt() - 1, d = sc.nextInt() - 1, c = sc.nextInt();
            graph[s][d] = graph[d][s] = c;
        }

        for (int k = 0; k < v; k++)
            for (int i = 0; i < v; i++)
                for (int j = 0; j < v; j++)
                    if (graph[i][j] > graph[i][k] + graph[k][j])
                        graph[i][j] = graph[i][k] + graph[k][j];

        System.out.println("\nInitial Routing Tables:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++)
                System.out.print("Dist: " + graph[i][j] + " ");
            System.out.println();
        }

        System.out.print("Source, Destination of changed edge and new Cost: ");
        int s = sc.nextInt() - 1, d = sc.nextInt() - 1, c = sc.nextInt();
        graph[s][d] = graph[d][s] = c;

        for (int k = 0; k < v; k++)
            for (int i = 0; i < v; i++)
                for (int j = 0; j < v; j++)
                    if (graph[i][j] > graph[i][k] + graph[k][j])
                        graph[i][j] = graph[i][k] + graph[k][j];

        System.out.println("\nUpdated Routing Tables:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++)
                System.out.print("Dist: " + graph[i][j] + " ");
            System.out.println();
        }
    }
}
