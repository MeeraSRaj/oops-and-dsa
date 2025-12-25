package project;

public class GraphSearch {
    int numberofvertices;
    int[][] adjMatrix;
    int[] colour; // BFS // DFS
    int[] d; // BFS
    int[] p; // BFS // DFS
    int[] discovery; // DFS
    int[] finish; // DFS 
    int time; // DFS

    public GraphSearch(int numberofvertices) {
        this.numberofvertices = numberofvertices;
        adjMatrix = new int[numberofvertices][numberofvertices];
        colour = new int[numberofvertices];
        d = new int[numberofvertices];
        p = new int[numberofvertices];
        discovery = new int[numberofvertices];
        finish = new int[numberofvertices];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
    }

    public void BFS(int source) {
        System.out.println("\nBreadth-First Search from node " + source + ":");
        int[] queue = new int[numberofvertices];
        int front = -1, rear = -1;

        for (int i = 0; i < numberofvertices; i++) {
            colour[i] = 0; // White
            d[i] = Integer.MAX_VALUE;
            p[i] = -1;
        }

        colour[source] = 1; // Gray
        d[source] = 0;


        front++;  //Enqueue
        rear++;
        queue[rear] = source;

        while (front <= rear) { 
            int u = queue[front];   //Dequeue
            front++;

            for (int v = 0; v < numberofvertices; v++) {
                if (adjMatrix[u][v] == 1 && colour[v] == 0) {
                    colour[v] = 1; // Gray
                    d[v] = d[u] + 1;
                    p[v] = u;

                    rear++;             //Enqueue
                    queue[rear] = v;
                }
            }
            colour[u] = 2; // Black
        }

        // Print BFS results in a table
        System.out.println("Vertex\tParent\tDistance");
        System.out.println("------\t------\t--------");
        for (int i = 0; i < numberofvertices; i++) {
            System.out.println(i + "\t" + 
                             (p[i] == -1 ? "NIL" : p[i]) + "\t" + 
                             (d[i] == Integer.MAX_VALUE ? "INF" : d[i]));
        }
    }

    public void DFS() {
        System.out.println("\nDepth-First Search:");
        for (int i = 0; i < numberofvertices; i++) {
            colour[i] = 0;
            p[i] = -1;
        }
        time = 0;
        for (int i = 0; i < numberofvertices; i++) {
            if (colour[i] == 0) {
                DFSvisit(i);  //Recursice Stack
            }
        }

        // Print DFS results in a table
        System.out.println("Vertex\tDiscovery\tFinish\tParent");
        System.out.println("------\t---------\t------\t------");
        for (int i = 0; i < numberofvertices; i++) {
            System.out.println(i + "\t" + 
                             discovery[i] + "\t" + 
                             finish[i] + "\t" + 
                             (p[i] == -1 ? "NIL" : p[i]));
        }
    }

    private void DFSvisit(int i) {
        colour[i] = 1;
        time++;  
        discovery[i] = time;  //When we "see" the node for the first time.
        for (int j = 0; j < numberofvertices; j++) {
            if (adjMatrix[i][j] == 1 && colour[j] == 0) {
                p[j] = i;
                DFSvisit(j);
            }
        }
        colour[i] = 2;  
        time++;
        finish[i] = time;  //Updated after visiting all the child nodes 
    }
}