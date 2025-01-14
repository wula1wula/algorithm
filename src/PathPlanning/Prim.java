package PathPlanning;

import java.util.*;

public class Prim {
    private class Edge{
        int to; //目标点
        int weight; //权重
        public Edge(int to, int weight){
           this.to = to;
           this.weight = weight;
        }
    }
    //Prim算法
    public List<Edge> prim(Map<Integer,List<Edge>> graph, int start){
        if(graph == null || graph.isEmpty()){
            return null;
        }

        List<Edge> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e ->e.weight));

        //初始化
        visited.add(start);
        pq.addAll(graph.get(start));
        result.add(new Edge(start,0));

        while (!pq.isEmpty()) {
            //取出权重最小的边
            Edge edge = pq.poll();
            //如果边的目标点已经访问过，则跳过
            if(visited.contains(edge.to)){
                continue;
            }
            //将边加入结果集，并将边的目标点加入已访问集合
            visited.add(edge.to);
            result.add(edge);
            //将目标点的所有边加入优先队列
            for(Edge next:graph.get(edge.to)){
                if(!visited.contains(next.to)){
                    pq.add(next);
                }
            }
        }
        //如果访问过的点的数量等于图中的点的数量，则说明所有点都访问过了，返回结果集,否则返回null
        return visited.size() == graph.size() ? result : null;
    }

    //构建无向图
    public Map<Integer,List<Edge>> buildGraph(int[][] edges){
        Map<Integer,List<Edge>> graph = new HashMap<>();
        for(int[] edge:edges){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.computeIfAbsent(from,k->new ArrayList<>()).add(new Edge(to,weight));
            graph.computeIfAbsent(to,k->new ArrayList<>()).add(new Edge(from,weight));
        }
        return graph;
    }

    public static void main(String[] args) {
        Prim prim = new Prim();
        int[][] edges = {{0,1,10},{0,2,6},{0,3,5},{1,3,15},{2,3,4}};
        Map<Integer,List<Edge>> graph = prim.buildGraph(edges);
        int start = 0;
        List<Edge> list = prim.prim(graph,start);
        int sumWeight = 0;
        System.out.println("Prim算法结果：");
        for(Edge edge:list){
            sumWeight+=edge.weight;
            System.out.println("到达目标点："+edge.to + "  权重为：" + edge.weight+"  当前总权重为："+sumWeight);
        }
    }
}
