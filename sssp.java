import java.util.*;
import java.lang.*;
import java.io.*;

class sssp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = s.nextInt();
        int[][] graph = new int[V][V];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = s.nextInt();

        int[] dist = new int[V];
        Boolean[] visited = new Boolean[V];
        System.out.print("Enter the source vertex: ");
        int src = s.nextInt();

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int min = Integer.MAX_VALUE, u = -1;
            for (int v = 0; v < V; v++)
                if (!visited[v] && dist[v] <= min) {
                    min = dist[v];
                    u = v;
                }
            visited[u] = true;

            for (int v = 0; v < V; v++)
                if (!visited[v] && graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
}