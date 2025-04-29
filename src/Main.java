// Author: K.A. Dashin Sanjana, Student ID: 20230500

public class Main {
    public static void main(String[] args) {
        System.out.println("Max Flow Network Solver");

        String inputFile = "benchmarks/bridge_1.txt";
        FlowNetwork network = InputParser.parseFromFile(inputFile);

        if (network != null) {
            int source = 0;
            int sink = network.getNumNodes() - 1;

            int maxFlow = MaxFlowSolver.findMaxFlow(network, source, sink);
            System.out.println("\n Maximum flow from node " + source + " to node " + sink + " is: " + maxFlow);
        } else {
            System.out.println("Failed to load the flow network.");
        }
    }
}
