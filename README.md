# 📄 README.md

```markdown
# Network Flow Solver - Max Flow Calculation (Edmonds-Karp Algorithm)

## 📚 Project Overview

This project implements a solution for the **Network Flow Problem** using the **Edmonds-Karp algorithm** (BFS-based Ford-Fulkerson method).  
It calculates the **maximum flow** from a given **source node** to a **sink node** in a directed flow network.

This project was developed as part of the **Algorithms Coursework (5SENG003W)** for the **University of Westminster**.

---

## 🛠 Project Structure

- `Edge.java` — Represents directed edges with capacity and flow.
- `FlowNetwork.java` — Models the entire network using adjacency lists.
- `InputParser.java` — Parses input files to build flow networks.
- `MaxFlowSolver.java` — Computes the maximum flow using the Edmonds-Karp algorithm.
- `Main.java` — Main runner class that reads input and executes the solver.
- `benchmarks/` — Contains sample input files for testing.

---

## 🚀 How to Run

### 1. Requirements
- Java 8 or later installed
- (Optional) IntelliJ IDEA or Visual Studio Code with Java extensions

### 2. Compile and Run

**Using Command Line:**
```bash
javac src/*.java
java -cp src Main
```

**Using IntelliJ IDEA or VS Code:**
- Open the project folder.
- Set `src/` as the source folder.
- Right-click on `Main.java` → **Run**.

Make sure the input files (like `ladder_18.txt`) are in the correct directory (`benchmarks/`).

---

## 📥 Input Format

The input file must be structured as:
```
<number_of_nodes>
<from_node> <to_node> <capacity>
<from_node> <to_node> <capacity>
...
```

**Example:**
```
4
0 1 6
0 2 4
1 2 2
1 3 3
2 3 5
```

---

## 📊 Output Example

```
Max Flow Calculation
➕ Augmented path found, flow added: 4, total flow: 4
➕ Augmented path found, flow added: 4, total flow: 8
Maximum flow from node 0 to node 3: 8
```

---

## 🧠 Algorithm Details

- **Algorithm**: Edmonds-Karp (Breadth-First Search based Ford-Fulkerson)
- **Time Complexity**: O(V × E²)
- **Space Complexity**: O(V + E)

---

## 🛠 Algorithm Flow (Edmonds-Karp)

```
Start
  ↓
Initialize total flow = 0
  ↓
While (there is an augmenting path from source to sink):
    ↓
  Perform BFS to find the shortest augmenting path
    ↓
  Find the bottleneck (minimum residual capacity)
    ↓
  Add bottleneck flow along the path
    ↓
  Update residual and reverse edges
  ↓
Add bottleneck to total flow
  ↓
Repeat
  ↓
No more augmenting paths
  ↓
End (Total flow is maximum)
```

---

## 📑 Author

- **Name**: K.A Dashin Sanjana


## 📜 License

This project is for educational purposes.

```

---

# 📌 What to do next
1. Copy the above content into a file called `README.md` inside your GitHub project folder.
2. Commit and push it:
```bash
git add README.md
git commit -m "Add final README file"
git push
