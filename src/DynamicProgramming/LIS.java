package DynamicProgramming;

import java.util.Arrays;

public class LIS {
    public int LIS(int[] nums){
        if(nums.length==0 || nums==null) return 0;
        int[]dp = new int[nums.length];
        Arrays.fill(dp,1);
        //状态转移方程
        //公式的意义：
        //dp[i]：表示以 nums[i] 为结尾的最长严格递增子序列的长度。
        //dp[j] + 1：
        //其中，dp[j] 是以 nums[j] 为结尾的最长严格递增子序列的长度。
        //+1 表示在 nums[j] 的基础上再接上当前元素 nums[i]，从而形成一个更长的子序列。
        //状态转移的本质：
        //我们遍历所有的 j < i，检查是否可以将 nums[i] 加到以 nums[j] 为结尾的子序列后。
        //如果 nums[i] > nums[j]，说明序列可以递增，dp[i] 的值应该更新为 之前的子序列长度 + 1。
        for(int i =0;i<nums.length;i++){
            for(int j =0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        for(int i=0;i<dp.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lis.LIS(nums));
    }
}
