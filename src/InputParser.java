// Author: K.A. Dashin Sanjana, Student ID: 20230500

import java.io.*;
import java.util.Scanner;

public class InputParser {

    // Parses a flow network from a text file
    public static FlowNetwork parseFromFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {

            int numNodes = Integer.parseInt(scanner.nextLine().trim());
            FlowNetwork network = new FlowNetwork(numNodes);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                int from = Integer.parseInt(parts[0]);
                int to = Integer.parseInt(parts[1]);
                int capacity = Integer.parseInt(parts[2]);

                network.addEdge(from, to, capacity);
            }

            return network;

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (Exception e) {
            System.err.println("Error while parsing the file: " + e.getMessage());
        }

        return null;
    }
}
