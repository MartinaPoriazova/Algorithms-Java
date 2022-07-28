package graph_theory_traversal_shortest_paths_07;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSortDfs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String nextLine = scanner.nextLine();
            if (nextLine.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> nextNodes = Arrays.stream(nextLine.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                graph.add(nextNodes);
            }
        }

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.print("Connected component: ");
            for (int integer : connectedComponent) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();

        for (int start = 0; start < graph.size(); start++) {
            if (!visited[start]) {
                components.add(new ArrayDeque<>());
                dfs(start, components, graph, visited);
            }
        }
        return components;
    }

    private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;

            for (int child : graph.get(node)) {
                dfs(child, components, graph, visited);
            }
            components.get(components.size() - 1).offer(node);
        }
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        List<String> sorted = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Set<String> detectedCycles = new HashSet<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dfs(node.getKey(), visited, graph, sorted, detectedCycles);
        }

        Collections.reverse(sorted);


        return sorted;
    }

    private static void dfs(String key, Set<String> visited, Map<String, List<String>> graph, List<String> sorted, Set<String> detectedCycles) {
        if (detectedCycles.contains(key)) {
            throw new IllegalArgumentException();
        }
        if (!visited.contains(key)) {
            visited.add(key);
            detectedCycles.add(key);
            for (String child : graph.get(key)) {
                dfs(child, visited, graph, sorted, detectedCycles);
            }
            detectedCycles.remove(key);
            sorted.add(key);
        }
    }
}
