package SearchAlgorithms;

import java.util.*;

public class Astar {
    private class Node{
        public Node parent;
        public int id;
        public int g;
        public int h;
        public int f;
        public Node(int id,int g,int h,Node parent){
            this.id=id;
            this.g=g;
            this.h=h;
            this.f=g+h;
            this.parent=parent;
        }
    }
    // 主算法
    public List<Integer> aStarSearch(Map<Integer, List<int[]>> graph, int start, int target, int[][] positions) {
        // 优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.f, b.f));
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Node> parentMap = new HashMap<>();

        // 起点初始化
        Node startNode = new Node(start, 0, heuristic(positions[start], positions[target]), null);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 如果找到目标节点
            if (current.id == target) {
                return reconstructPath(current);
            }

            // 标记为访问
            visited.add(current.id);

            // 遍历邻居节点
            for (int[] neighbor : graph.get(current.id)) {
                int neighborId = neighbor[0];
                int weight = neighbor[1];

                if (visited.contains(neighborId)) {
                    continue;
                }

                int newG = current.g + weight; // 实际代价
                int h = heuristic(positions[neighborId], positions[target]); // 估计代价
                Node neighborNode = new Node(neighborId, newG, h, current);

                // 如果邻居节点的代价更新，加入队列
                queue.add(neighborNode);
            }
        }

        return Collections.emptyList(); // 无解
    }

    // 路径回溯
    private List<Integer> reconstructPath(Node targetNode) {
        List<Integer> path = new ArrayList<>();
        Node current = targetNode;
        while (current != null) {
            path.add(current.id);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    // 启发式函数
    private int heuristic(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]); // 曼哈顿距离
    }
}
