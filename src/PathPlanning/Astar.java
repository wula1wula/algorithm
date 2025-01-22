package PathPlanning;

import java.util.*;

public class Astar {
     static class Node implements Comparable<Node>{
        int x,y; //坐标
        int g; //从起点到当前点的代价
        int h; //从当前点到终点的代价
        int f; //总代价
        Node parent; //父节点
        public Node(int x,int y){
            this.x = x;
            this.y = y;
            this.g = Integer.MAX_VALUE;
            this.h = 0;
            this.f = Integer.MAX_VALUE;
            this.parent = null;
        }
        @Override
        public int compareTo(Node o) {
            return this.f-o.f;
        }
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }
        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
    }
    //图结构
//    private static class Graph{
//        private Map<Node,List<Node>> map;
//        public Graph(){
//            map = new HashMap<>();
//        }
//        //添加节点
//        public void addNode(Node node){
//            map.putIfAbsent(node,new ArrayList<>());
//        }
//        //添加边
//        public void addEdge(Node node1,Node node2){
//            if(map.containsKey(node1) && map.containsKey(node2)){
//                map.get(node1).add(node2);
//                map.get(node2).add(node1);
//            }
//        }
//        //获取邻居节点
//        public List<Node> getNeighbors(Node node){
//            return map.get(node);
//        }
//    }
    //启发函数
    private int H(Node current,Node target){
        return Math.abs(current.x-target.x)+Math.abs(current.y-target.y);
    }
    //移动方向
    private static final int[][] DIRECTIONS= {{-1,0},{1,0},{0,-1},{0,1}};
    //A*算法
    public List<Node> Astar(int x1,int y1,int x2,int y2,int[][] grid,int[][] weights){
        //创建优先队列，用于存储待处理的节点
        PriorityQueue<Node> openList = new PriorityQueue<>();
        //创建集合，用于存储已处理的节点
        Set<Node> closeList = new HashSet<>();
        //创建起点
        Node start = new Node(x1,y1);
        //创建终点
        Node end = new Node(x2,y2);
        start.g=0;
        start.h=H(start,end);
        start.f = start.g+start.h;
        openList.add(start);
        while(!openList.isEmpty()){
            //取出优先队列中代价最小的节点
            Node current = openList.poll();
            //判断是否到达终点
            if(current.equals(end)){
                //构建路径
                List<Node> path = new ArrayList<>();
                while(current != null){
                    path.add(current);
                    current = current.parent;
                }
                Collections.reverse(path);
                return path; //返回找到的路径
            }
            //将当前节点加入已处理集合
            closeList.add(current);
            //获取当前节点的邻居节点
            for(int[] dir:DIRECTIONS){
                //移动位置
                int nx = current.x+dir[0];
                int ny = current.y+dir[1];

                if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length || grid[nx][ny] ==1){
                    continue; //越界或是障碍物跳过
                }
                Node neighbor = new Node(nx,ny);
                if(closeList.contains(neighbor)){
                    continue;
                }
                //计算当前节点到邻居节点的代价
                int weiget = weights[nx][ny];
                int tentativeG = current.g+weiget;//x代表current到neighbor的权重
                if(!openList.contains(neighbor)){
                    openList.add(neighbor);  // 如果邻接节点不在 open list 中，加入
                }else if(tentativeG >= neighbor.g){
                    continue;// 如果通过当前节点不能减少邻接节点的 g 值，跳过
                }
                neighbor.g = tentativeG;
                neighbor.h = H(neighbor,end);
                neighbor.parent = current;
                neighbor.f = neighbor.h+ neighbor.g;
            }

        }
        return new ArrayList<>();  // 如果 open list 为空，返回空路径（表示没有路径）
    }
    public static void main(String[] args) {
        // 权重地图
        int[][] weights = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 10, 1},  // 高权重区域（障碍物或较高的代价区域）
                {1, 1, 1, 1, 1},
                {1, 1, 10, 1, 1},  // 高权重区域
                {1, 1, 1, 1, 1}
        };

        // 普通地图（0 表示可通行，1 表示障碍）
        int[][] grid = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        Astar aStar = new Astar();

        // 运行 A* 算法
        List<Node> path = aStar.Astar(0,0,4,4,grid,weights);

        // 打印路径
        System.out.println("Path: ");
        for (Node node : path) {
            System.out.println("(" + node.x + ", " + node.y + ")");
        }
    }
}
