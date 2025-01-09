package SearchAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    private static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int weight;
        public Edge(int src,int dest,int weight){
            this.dest = dest;
            this.src = src;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    private static class UnionFind{
        int[] parent; //父节点数组
        int[] rank; //集合高度数组
        public UnionFind(int size){
            parent = new int[size];
            rank = new int[size];
            for(int i=0;i<size;i++){
                parent[i] = i; //初始化时每个节点都是独立的集合，所以父节点就是自己
                rank[i] = 0; //初始化时每个集合的高度都是0
            }
        }
        //查找集合的根节点,并路径压缩
        public int Find(int x){
            if(parent[x] !=x){
                parent[x] = Find(parent[x]); //路径压缩
            }
            return parent[x];
        }
        //合并两个集合
        public void Union(int x,int y){
            int rootX = Find(x);
            int rootY = Find(y);
            if(rootX!=rootY){
                if(rank[rootX]>rank[rootY]){
                    parent[rootY] = rootX;
                } else if (rank[rootX]<rank[rootY]){
                    parent[rootX] = rootY;
                }else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
    public static List<Edge> kruskal(int size,List<Edge> edges){
        //存储最小生成树的边
        List<Edge> mst = new ArrayList<>();
        //对所有边排序
        Collections.sort(edges);
        //初始化并查集
        UnionFind uf = new UnionFind(size);
        //遍历所有边
        for(Edge edge : edges){
            //如果边的两个节点不在同一个集合中，则加入最小生成树
            int rootSrc = uf.Find(edge.src);
            int rootDest = uf.Find(edge.dest);
            if(rootSrc!=rootDest){
                mst.add(edge); //加入最小生成树
                uf.Union(edge.src,edge.dest); //合并两个节点所在的集合
                if(mst.size() == size -1){
                    break; //如果最小生成树已经包含所有节点，则退出循环
                }
            }
        }
        return mst;
    }
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,6));
        edges.add(new Edge(0,3,5));
        edges.add(new Edge(1,3,15));
        edges.add(new Edge(2,3,4));
        List<Edge> mst = kruskal(4,edges);
        for(Edge edge : mst){
            System.out.println(edge.src + " " + edge.dest + " " + edge.weight);
        }
    }
}
