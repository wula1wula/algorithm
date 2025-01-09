package PathPlanning;

import java.util.*;

public class DoubleBFS {
    private Map<Integer, List<Integer>> adjacencyList;
    public DoubleBFS(){
        adjacencyList = new HashMap<>();
    }
    public void addVertex(int vertex){
        adjacencyList.putIfAbsent(vertex,new ArrayList<>());
    }
    public void addEdge(int start,int end){
        adjacencyList.get(start).add(end);
        adjacencyList.get(end).add(start);
    }

    public int double_BFS(int start,int end){
        if(start == end) return 0;
        Queue<Integer> minQueue = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited_1 = new HashSet<>();
        Set<Integer> visited_2 = new HashSet<>();
        int level = 0;
        minQueue.add(start);
        visited_1.add(start);
        queue.add(end);
        visited_2.add(end);
        while(!minQueue.isEmpty() && !queue.isEmpty()){
            if(minQueue.size() > queue.size()){
               swap(minQueue,queue,visited_1,visited_2);

            }
            //层级加一
            level++;
            int size = minQueue.size();
            for(int i =0; i<size;i++){
                int current = minQueue.poll();
                for(int neighbor : adjacencyList.get(current)){
                    if(visited_2.contains(neighbor)){
                       return level;
                    }
                    if(!visited_1.contains(neighbor)){
                        minQueue.add(neighbor);
                        visited_1.add(neighbor);
                    }
                }
            }
        }
        return -1;
    }
    //交换
    private void swap(Queue<Integer> minQueue, Queue<Integer> queue, Set<Integer> visited_1, Set<Integer> visited_2) {
        Queue<Integer> temp = minQueue;
        minQueue = queue;
        queue = temp;
        Set<Integer> tempSet = visited_1;
        visited_1 = visited_2;
        visited_2 = tempSet;
    }
    public static void main(String[] args) {
        DoubleBFS doubleBFS = new DoubleBFS();
        doubleBFS.addVertex(1);
        doubleBFS.addVertex(2);
        doubleBFS.addVertex(3);
        doubleBFS.addVertex(4);
        doubleBFS.addVertex(5);
        doubleBFS.addEdge(1,2);
        doubleBFS.addEdge(1,3);
        doubleBFS.addEdge(2,4);
        doubleBFS.addEdge(3,4);
        doubleBFS.addEdge(4,5);
        System.out.println(doubleBFS.double_BFS(1,5));
    }
}
