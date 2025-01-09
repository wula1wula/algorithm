package PathPlanning;

import java.util.*;

public class Prim {
    private static class Graph{
        private Map<Integer,List<int[]>> map;
        public Graph(){
            map = new HashMap<>();
        }
        public void addEdge(int a,int b,int weight){
            if(!map.containsKey(a)){
                map.put(a,new ArrayList<>());
            }
            if(!map.containsKey(b)){
                map.put(b,new ArrayList<>());
            }
            map.get(a).add(new int[]{a,weight});
            map.get(b).add(new int[]{b,weight});
        }
        public Map<Integer,List<int[]>> getMap(){
            return map;
        }
    }


    public List<int[]> prim(Graph graph){
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>();
        //初始化
        result.add(new int[]{0,0});
        visited.add(0);
        //将当前点的所有邻接边加入队列中
        for(int[] edge:graph.getMap().get(0)){
            pq.add(edge);
        }

        return result;
    }
}
