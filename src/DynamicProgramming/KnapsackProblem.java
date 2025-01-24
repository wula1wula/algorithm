package DynamicProgramming;

public class KnapsackProblem {
    //递归方法
    public int knapsack(int[] weights, int[] value, int capacity,int n) {
        if(n==0 || capacity==0){
            return 0;
        }
        if(weights[n-1]<=capacity){
            return Math.max(value[n-1]+knapsack(weights,value,capacity-weights[n-1],n-1),knapsack(weights,value,capacity,n-1));
        }
        else{
            return knapsack(weights,value,capacity,n-1);
        }
    }
    //动态规划方法
    //每次在不同容量下尝试放入第i个物品，能放入就放入然后加剩余空间最大价值，每个物品的重量数组中的值要么从上一件物品的重量数组中继承价值，要么加入当前物品后价值优于这个重量下上一件物品的当前价值
    public int knapsack_1(int[] weights, int[] value, int capacity,int n) {
        int[][] dp = new int[n+1][capacity+1];
        for(int i =1;i<n+1;i++){
            for(int j=1;j<capacity+1;j++){
                //不放入当前物品
                dp[i][j] = dp[i-1][j];

                //放入当前物品
                if(weights[i-1]<=j){

                    //当前物品价值加剩余空间中最大价值和不放入物品时价值比较，取最大值
                    dp[i][j] = Math.max(value[i-1]+dp[i-1][j-weights[i-1]],dp[i][j]);

                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        KnapsackProblem ks = new KnapsackProblem();
        int[] values = {60, 100, 120};  // 物品的价值
        int[] weights = {10, 20, 30};  // 物品的重量
        int capacity = 50;  // 背包的最大承重

        int result = ks.knapsack_1(weights, values, capacity,values.length);
        System.out.println("Maximum value in Knapsack: " + result);  // 输出 220
    }
}
