package SearchAlgorithms;

import java.util.*;

public class Dijkstra {
    public static class Graph{
        private final Map<Integer, List<int[]>> adjList;
        public Graph(){
            adjList = new HashMap<>();
        }
        public void addEdge(int src, int dest, int weight){
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(new int[]{dest, weight});
        }
        public List<int[]> getNeighbors(int node){
            return adjList.getOrDefault(node,new ArrayList<>());
        }
    }
    public Map<Integer, Integer> dijkstra(Graph graph, int start) {
        Map<Integer, Integer> dist = new HashMap<>(); // 节点 -> 最短距离
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // [节点, 距离]
        Set<Integer> visited = new HashSet<>();

        pq.add(new int[]{start, 0});
        dist.put(start, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];

            if (visited.contains(node)) continue;
            visited.add(node);

            // 遍历当前节点的邻居
            for (int[] neighbor : graph.getNeighbors(node)) {
                int neighborNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = distance + weight;

                // 更新最短距离
                if (!dist.containsKey(neighborNode) || newDist < dist.get(neighborNode)) {
                    dist.put(neighborNode, newDist);
                    pq.add(new int[]{neighborNode, newDist});
                }
            }
        }

        return dist;
    }

        public static void main(String[] args) {
            Graph graph = new Graph();
            graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 1);
            graph.addEdge(2, 1, 2);
            graph.addEdge(1, 3, 1);
            graph.addEdge(2, 3, 5);

            Dijkstra dijkstra = new Dijkstra();
            Map<Integer, Integer> distances = dijkstra.dijkstra(graph, 0);

            System.out.println("Shortest distances from node 0:");
            for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
                System.out.println("Node " + entry.getKey() + " -> Distance: " + entry.getValue());
            }
        }
}

