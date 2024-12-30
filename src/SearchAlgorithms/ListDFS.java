package SearchAlgorithms;

import java.util.*;

public class ListDFS {
    private Map<Integer, List<Integer>> adjList;
    public ListDFS(){
        adjList = new HashMap<>();
    }

    public void addNode(int node){
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(int src, int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }
    //递归dfs
    public List<Integer> dfs(int start){
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited, result);
        return result;
    }
    private void dfsHelper(int node, Set<Integer> visited, List<Integer> result){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        result.add(node);
        for(int neighbor : adjList.get(node)){
            dfsHelper(neighbor,visited, result);
        }
    }
    //非递归dfs
    public List<Integer> dfsIterative(int start){
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            result.add(node);
            for(int neighbor : adjList.get(node)){
                stack.push(neighbor);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ListDFS dfs = new ListDFS();
        dfs.addNode(1);
        dfs.addNode(2);
        dfs.addNode(3);
        dfs.addNode(4);
        dfs.addNode(5);
        dfs.addEdge(1,2);
        dfs.addEdge(1,3);
        dfs.addEdge(2,4);
        dfs.addEdge(3,4);
        dfs.addEdge(4,5);
        System.out.println(dfs.dfs(1));
        System.out.println(dfs.dfsIterative(1));
    }
}
