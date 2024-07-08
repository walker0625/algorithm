package graph;

import java.util.*;

public class BFS {

    public static Set searchGraphByBFS(Map<String, String[]> graph, String startVertex) {

        Set<String> visited = new LinkedHashSet<>();
        visited.add(startVertex);
        Queue<String> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            String[] vertexes = graph.get(currentVertex);
            for (String vertex : vertexes){
                if(!visited.contains(vertex)) {
                    visited.add(vertex);
                    queue.add(vertex);
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        Map<String, String[]> graph = new LinkedHashMap<>();
        graph.put("A", new String[]{"B", "D", "E"});
        graph.put("B", new String[]{"A", "C", "D"});
        graph.put("C", new String[]{"B"});
        graph.put("D", new String[]{"A", "B"});
        graph.put("E", new String[]{"A"});

        searchGraphByBFS(graph, "A").forEach(System.out::println);
    }

}