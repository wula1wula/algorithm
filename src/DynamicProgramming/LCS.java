package DynamicProgramming;

public class LCS {
    //递归
    public int lcs(String s1,String s2,int m,int n){
        if(m==0 || n==0){
            return 0;
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return 1+lcs(s1,s2,m-1,n-1);
        }
        return Math.max(lcs(s1,s2,m-1,n),lcs(s1,s2,m,n-1));
    }

    //动态规划
    public int lcs2(String s1,String s2,int m,int n){
        int[][] dp = new int[m+1][n+1];
        for(int i =0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.lcs2("abcde","ace",5,3));
    }
}
