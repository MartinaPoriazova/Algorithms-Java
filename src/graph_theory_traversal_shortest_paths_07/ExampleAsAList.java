package graph_theory_traversal_shortest_paths_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleAsAList {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 10 + 1; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).addAll(Arrays.asList(9, 8, 5));
        graph.get(2).add(10);
        graph.get(3).add(1);

        for (int child : graph.get(1)) {
            System.out.println(child);
        }
    }
}
