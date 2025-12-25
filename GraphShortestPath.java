package project;

public class GraphShortestPath {
    int numberofvertices;
    int[][] adjMatrix;

    GraphShortestPath(int numberofvertices) {
        this.numberofvertices = numberofvertices;
        adjMatrix = new int[numberofvertices][numberofvertices];

        for (int i = 0; i < numberofvertices; i++) {
            for (int j = 0; j < numberofvertices; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void addEdge(int u, int v, int w) {
        adjMatrix[u][v] = w;
    }

    public boolean BellmanFord(int source) {
        System.out.println("\nBellman-Ford from node " + source + ":");
        int[] dist = new int[numberofvertices];
        int[] parent = new int[numberofvertices];

        //initialize single-source
        for (int i = 0; i < numberofvertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i]=-1;
        }
        dist[source] = 0;

        for (int k = 0; k < numberofvertices - 1; k++) {
            for (int u = 0; u < numberofvertices; u++) {  //relax
                for (int v = 0; v < numberofvertices; v++) {
                    if (adjMatrix[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + adjMatrix[u][v]) {
                        dist[v] = dist[u] + adjMatrix[u][v];
                        parent[v]=u;
                    }
                }
            }
        }

        for (int u = 0; u < numberofvertices; u++) {
            for (int v = 0; v < numberofvertices; v++) {
                if (adjMatrix[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + adjMatrix[u][v]) {
                    System.out.println(" Negative weight cycle detected!");
                    return false;
                }
            }
        }

        for (int i = 0; i < numberofvertices; i++) {
            System.out.println("Node " + i + ": Distance: " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i])+ " Parent: "+ (parent[i]==-1 ? "NIL" : parent[i]));
        }

        return true;
    }

    public void Dijkstra(int source) {
        System.out.println("\n Dijkstra's Algorithm from node " + source + ":");
        int[] dist = new int[numberofvertices];
        boolean[] visited = new boolean[numberofvertices];
        int[] parent = new int[numberofvertices];

        for (int i = 0; i < numberofvertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
            parent[i]=-1;
        }
        dist[source] = 0;

        for (int j = 0; j < numberofvertices - 1; j++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < numberofvertices; i++) {           //find the minimum distanced-vertex which is unvisited
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }

            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < numberofvertices; v++) {                              //go to all the unvisited adjacent vertex of u and relax the edges.
                if (!visited[v] && adjMatrix[u][v] != Integer.MAX_VALUE && dist[v] > dist[u] + adjMatrix[u][v] ) {
                    dist[v] = dist[u] + adjMatrix[u][v];
                    parent[v]=u;
                }
            }
        }

        for (int i = 0; i < numberofvertices; i++) {
            System.out.println("Node " + i + ": Distance: " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i])+ " Parent: "+ (parent[i]==-1 ? "NIL" : parent[i]));
        }
    }

    public void FloydWarshall() {
        System.out.println("\nFloyd-Warshall All-Pairs Shortest Paths:");
    
        int[][] dist = new int[numberofvertices][numberofvertices];
        int[][] parent = new int[numberofvertices][numberofvertices];
    
        for (int i = 0; i < numberofvertices; i++) {
            for (int j = 0; j < numberofvertices; j++) {
                dist[i][j] = adjMatrix[i][j];
    
                if (i!=j && adjMatrix[i][j] != Integer.MAX_VALUE) {
                    parent[i][j] = i; // direct edge exists
                } else {
                    parent[i][j] = -1; // no path yet
                }
            }
        }
        for (int k = 0; k < numberofvertices; k++) {
            for (int i = 0; i < numberofvertices; i++) {
                for (int j = 0; j < numberofvertices; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]; //update the distance
                        parent[i][j] = parent[k][j]; // update the parent
                    }
                }
            }
        }
        System.out.println("Distance Matrix:");
        for (int i = 0; i < numberofvertices; i++) {
            for (int j = 0; j < numberofvertices; j++) {
                System.out.print((dist[i][j] == Integer.MAX_VALUE ? "INF" : dist[i][j]) + "\t");
            }
            System.out.println();
        }
        System.out.println("\nParent Matrix:");
        for (int i = 0; i < numberofvertices; i++) {
            for (int j = 0; j < numberofvertices; j++) {
                System.out.print((parent[i][j] == -1 ? "NIL" : parent[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}
