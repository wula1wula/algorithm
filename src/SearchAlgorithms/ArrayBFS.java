package SearchAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayBFS {
    int[][] grid;
    int index;
    int MaxIndex;
    public ArrayBFS(int x){
        MaxIndex = x;
        index =0;
        grid = new int[MaxIndex][MaxIndex];
    }
    public void addEdge(int src,int dest){
        if(src >=MaxIndex||src<0||dest<0 || dest >= MaxIndex){
            System.out.print("error");
        }
        grid[src][dest] =1;
        grid[dest][src] =1;
    }
    public void addVertex(){
        if(index >= MaxIndex){
            System.out.print("error");
        }
        index++;
    }
    public void BFS(int src){
        boolean[] visited = new boolean[MaxIndex];
        Queue<Integer> queue = new LinkedList<>();
        BFSHelp(src,visited,queue);
    }
    public void BFSHelp(int src,boolean[] visited,Queue<Integer> queue){
        visited[src] = true;
        queue.add(src);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            System.out.print(curr+" ");
            for(int i=0;i<MaxIndex;i++){
                if(grid[curr][i]==1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
