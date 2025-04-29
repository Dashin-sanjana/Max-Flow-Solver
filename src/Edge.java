// Author: K.A. Dashin Sanjana, Student ID: 20230500

public class Edge {
    public int from, to;
    public int capacity;
    public int flow;

    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0; // Initially, no flow
    }

    // Returns how much more flow can be pushed through this edge
    public int residualCapacity() {
        return capacity - flow;
    }

    // Adds flow to this edge (positive for forward, negative for reverse)
    public void addFlow(int amount) {
        flow += amount;
    }
}
