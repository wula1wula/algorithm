package SearchAlgorithms;

public class ArrayDFS {
    private int[][] maze;
    private int MaxIndex;
    private int Index;
    public ArrayDFS(int Max){
        MaxIndex = Max;
        Index = 0;
        maze = new int[MaxIndex][MaxIndex];
    }
    public void addVertex(int v){
        if(Index == MaxIndex){
            System.out.println("Array is full");
        }else{
            maze[Index][Index] = 1;
            Index++;
        }
    }
    public void addEdge(int src,int dest){
        if(src >= MaxIndex || dest >= MaxIndex){
            System.out.println("Index out of bounds");
        }
        maze[src][dest]=1;
        maze[dest][src]=1;
    }
    //递归DFS
    public void ArrayDfs(int start){
        int[] visited = new int[MaxIndex];
        for(int i =0;i<MaxIndex;i++){
            visited[i] = 0;
        }
        DFSHelp(maze, visited, start);
    }
    private void DFSHelp(int[][] maze, int[] visited, int start){
        visited[start] =1;
        System.out.print(start+" ");
        for(int i=0;i<MaxIndex;i++){
            if(maze[start][i]==1&&visited[i]==0){
                DFSHelp(maze, visited, i);
            }
        }
    }
    //非递归DFS
    public void ArrayDfs2(int start){

    }
    public static void main(String[] args){
        ArrayDFS dfs = new ArrayDFS(5);
        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,3);
        dfs.addEdge(1,4);
        dfs.ArrayDfs(0);
    }
}
