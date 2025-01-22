package DynamicProgramming;

public class MinimumPathSum {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // 创建 dp 数组
            int[][] dp = new int[m][n];

            // 初始化 dp[0][0] 为起点的值
            dp[0][0] = grid[0][0];

            // 初始化第一行
            for(int i =1;i<n;i++){
                dp[0][i] = dp[0][i-1] + grid[0][i];
            }

            // 初始化第一列
            for(int i =1;i<m;i++){
                dp[i][0] = dp[i-1][0] + grid[i][0];
            }

            // 填充 dp 数组的其余部分
           for(int i =1;i<m;i++){
               for(int j =1;j<n;j++){
                   dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
               }
           }

            // 最终返回右下角的路径和
            return dp[m-1][n-1];

        }

        public static void main(String[] args) {
            MinimumPathSum mps = new MinimumPathSum();
            int[][] grid = {
                    {1, 3, 1},
                    {1, 5, 1},
                    {4, 2, 1}
            };
            int result = mps.minPathSum(grid);
            System.out.println("Minimum Path Sum: " + result);  // 输出 7
        }


}
