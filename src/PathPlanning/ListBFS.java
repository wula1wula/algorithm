package PathPlanning;

import java.util.*;

public class ListBFS {
    private Map<Integer, List<Integer>> adjList;
    public ListBFS(){
        adjList = new HashMap<>();
    }

    public void addVertex(int node){
        adjList.putIfAbsent(node,new ArrayList<>());
    }

    public void addEdge(int src,int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    //bfs
    public List<Integer> bfs(int start){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int node= queue.poll();
            result.add(node);
            List<Integer> neighbors = adjList.getOrDefault(node,new ArrayList<>());
            for(int x:neighbors){
                if(!visited.contains(x)){
                    queue.add(x);
                    visited.add(x);
                }
            }
        }
        return result;
    }
}
