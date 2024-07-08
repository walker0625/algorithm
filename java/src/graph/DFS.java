package graph;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DFS {

    private static Set searchGraphByDFS(Map<String, String[]> graph, String key, Set<String> visited) {

        visited.add(key);

        for (String vertex : graph.get(key)) {
            if(!visited.contains(vertex)) {
                searchGraphByDFS(graph, vertex, visited);
            }
        }

        return visited;
    }

    public static void main(String[] args) {

        Set<String> visited = new LinkedHashSet<>();

        Map<String, String[]> graph = new LinkedHashMap<>();
        graph.put("A", new String[]{"B", "D", "E"});
        graph.put("B", new String[]{"A", "C", "D"});
        graph.put("C", new String[]{"B"});
        graph.put("D", new String[]{"A", "B"});
        graph.put("E", new String[]{"A"});

        searchGraphByDFS(graph, "A", visited).forEach(System.out::println);
    }

}