// Author: K.A. Dashin Sanjana, Student ID: 20230500

import java.util.*;

public class MaxFlowSolver {

    // Finds the maximum flow using Edmonds-Karp (BFS-based Ford-Fulkerson)
    public static int findMaxFlow(FlowNetwork network, int source, int sink) {
        int totalFlow = 0;

        while (true) {
            Edge[] parent = new Edge[network.getNumNodes()];
            boolean pathFound = bfs(network, source, sink, parent);

            if (!pathFound) break; // No more augmenting paths

            // Find the bottleneck capacity on the path
            int bottleneck = Integer.MAX_VALUE;
            for (int v = sink; v != source; ) {
                Edge edge = parent[v];
                bottleneck = Math.min(bottleneck, edge.residualCapacity());
                v = edge.from;
            }

            // Push the flow and update reverse edges
            for (int v = sink; v != source; ) {
                Edge edge = parent[v];
                edge.addFlow(bottleneck);

                // Update the residual edge
                for (Edge rev : network.getAdjacencyList()[edge.to]) {
                    if (rev.to == edge.from) {
                        rev.addFlow(-bottleneck);
                        break;
                    }
                }

                v = edge.from;
            }

            totalFlow += bottleneck;
            System.out.println("Path found. Flow added: " + bottleneck + " | Total flow: " + totalFlow);
        }

        return totalFlow;
    }

    // BFS to find shortest augmenting path
    private static boolean bfs(FlowNetwork network, int source, int sink, Edge[] parent) {
        boolean[] visited = new boolean[network.getNumNodes()];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Edge edge : network.getAdjacencyList()[u]) {
                if (!visited[edge.to] && edge.residualCapacity() > 0) {
                    visited[edge.to] = true;
                    parent[edge.to] = edge;
                    queue.add(edge.to);

                    if (edge.to == sink) return true;
                }
            }
        }

        return false;
    }
}
