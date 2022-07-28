package graph_theory_traversal_shortest_paths_07;

import java.util.ArrayList;
import java.util.List;

public class ExampleWithClass {

    public static class Graph {
        int source;
        List<Edge> edges;

        public Graph(int source) {
            this.source = source;
            this.edges = new ArrayList<>();
        }
    }

    public static class Edge {
        public int source;
        public int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void main(String[] args) {
        // 1 - > 2, 3, 4, 5, 6

        Graph graph = new Graph(1);
        graph.edges.add(new Edge(1, 2));
        graph.edges.add(new Edge(1, 3));
        graph.edges.add(new Edge(1, 4));
        graph.edges.add(new Edge(1, 5));
        graph.edges.add(new Edge(1, 6));


    }
}
