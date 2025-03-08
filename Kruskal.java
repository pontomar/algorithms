import java.util.*;

public class Kruskal {
    private static int[][] edges = {{0, 1, 4},
            {4, 2, 3},
            {1, 2, 1},
            {1, 3, 2},
            {2, 3, 5}};
    private static int[] root;
    private static int result;

    public static void main(String[] args) {
        minimumCost(4, edges);
        System.out.println(result); // Expected result is 6
    }

    public static int minimumCost(int n, int[][] edges) {
        root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }

        // 1. Sort the edges array according to the weights
        Arrays.sort(edges, (x, y) -> Integer.compare(x[2], y[2]));

        /* 2. Iterate through the array and add those edges to the mst,
         that don't produce a cycle */
        result = 0;  // Initialize result here to avoid wrong result from previous runs
        for (int i = 0; i < edges.length; i++) {
            if (!hasSameRoot(edges[i][0], edges[i][1])) {
                result += edges[i][2];
            }
        }
        return result; // return the minimum spanning tree cost
    }

    public static int getRoot(int i) {
        if (root[i] == i) {
            return i;
        }
        root[i] = getRoot(root[i]);  // Path compression
        return root[i];  // Return the root after path compression
    }

    public static boolean hasSameRoot(int i, int j) {
        int iRoot = getRoot(i);
        int jRoot = getRoot(j);
        if (iRoot == jRoot) {
            return true;  // They are already in the same set, adding this edge would form a cycle
        }
        root[iRoot] = jRoot;  // Union operation
        return false;  // No cycle formed, the edge can be included in the MST
    }
}
