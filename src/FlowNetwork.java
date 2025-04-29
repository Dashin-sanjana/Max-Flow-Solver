// Author: K.A. Dashin Sanjana, Student ID: 20230500

import java.util.*;

public class FlowNetwork {
    private final int numNodes;
    private final List<Edge>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public FlowNetwork(int numNodes) {
        this.numNodes = numNodes;
        this.adjacencyList = new ArrayList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    // Adds a forward and a residual (backward) edge
    public void addEdge(int from, int to, int capacity) {
        Edge forward = new Edge(from, to, capacity);
        Edge backward = new Edge(to, from, 0); // Residual edge starts with 0 capacity
        adjacencyList[from].add(forward);
        adjacencyList[to].add(backward);
    }

    public List<Edge>[] getAdjacencyList() {
        return adjacencyList;
    }

    public int getNumNodes() {
        return numNodes;
    }
}
