package SearchAlgorithms;
import java.util.*;

public class BiDirectionalDFS {
    private Map<Integer, List<Integer>> adjList; // 图的邻接表

    public BiDirectionalDFS(Map<Integer, List<Integer>> adjList) {
        this.adjList = adjList;
    }


    //需要优化算法，使从两边遍历有意义
    public boolean bidirectionalDFS(int start, int target) {
        if (start == target) {
            return true; // 起点和终点相同，直接返回
        }

        // 两组访问标记
        Set<Integer> visitedFromStart = new HashSet<>();
        Set<Integer> visitedFromTarget = new HashSet<>();

        // 双向 DFS
        visitedFromStart.add(start);
        visitedFromTarget.add(target);
        return dfs(start, visitedFromStart, visitedFromTarget) ||
                dfs(target, visitedFromTarget, visitedFromStart);
    }

    private boolean dfs(int current, Set<Integer> currentVisited, Set<Integer> oppositeVisited) {
        // 如果当前节点在另一方向的访问标记中，路径相交
        if (oppositeVisited.contains(current)) {
            return true;
        }

        // 访问当前节点的邻居
        for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!currentVisited.contains(neighbor)) {
                currentVisited.add(neighbor);
                if (dfs(neighbor, currentVisited, oppositeVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 创建图的邻接表
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(1, Arrays.asList(2, 3));
        adjList.put(2, Arrays.asList(1, 4));
        adjList.put(3, Arrays.asList(1, 5));
        adjList.put(4, Arrays.asList(2, 5));
        adjList.put(5, Arrays.asList(3, 4, 6));
        adjList.put(6, Arrays.asList(5));

        // 初始化算法
        BiDirectionalDFS biDFS = new BiDirectionalDFS(adjList);

        // 测试双向 DFS
        int start = 1, target = 6;
        boolean pathExists = biDFS.bidirectionalDFS(start, target);
        System.out.println("Path exists between " + start + " and " + target + ": " + pathExists);
    }
}

