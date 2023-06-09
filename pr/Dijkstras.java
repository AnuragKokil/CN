import java.util.*;
import java.lang.*;
import java.io.*;

public class Dijkstras {
    static final int V = 9;

    int minDistance(int dist[], Boolean sptset[]) {
        int min = Integer.MAX_VALUE, minindex = -1;

        for (int i = 0; i < V; i++) {
            if (sptset[i] == false && dist[i] <= min) {
                min = dist[i];
                minindex = i;
            }
        }
        return minindex;
    }

    void printans(int dist[], int n) {
        System.out.println("Vertex  Distance from Source");
        for (int i = 0; i < n; i++) {
            System.out.println("    " + i + "   " + dist[i]);
        }
    }

    void dijkstras(int graph[][], int src) {
        int dist[] = new int[V];
        Boolean sptset[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptset[i] = false;
        }

        dist[src] = 0;

        for (int i = 0; i < (V - 1); i++) {
            int u = minDistance(dist, sptset);
            sptset[u] = true;

            for (int j = 0; j < V; j++) {
                if (!sptset[j] && graph[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][j] < dist[j]) {
                    dist[j] = dist[u] + graph[u][j];
                }
            }
        }
        printans(dist, V);
    }

    public static void main(String args[]) {
        int grapg[][] = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        Dijkstras d = new Dijkstras();
        d.dijkstras(grapg, 0);
    }
}
