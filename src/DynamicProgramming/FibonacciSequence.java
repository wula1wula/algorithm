package DynamicProgramming;

public class FibonacciSequence {
    public int fib_1(int n){
        if(n==0||n==1) return n;

        return fib_1(n-1)+fib_1(n-2);
    }

    public int fib_2(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        return fib_2_Helper(n,dp);
    }
    public int fib_2_Helper(int n,int[] dp){
        if(n==0||n==1) return n;
        if(dp[n]!=0) return dp[n];
        dp[n] = fib_2_Helper(n-1,dp)+fib_2_Helper(n-2,dp);
        return dp[n];

    }

    public int fib_3(int n){
        if(n==0||n==1) return n;
        int a = 0,b = 1;
        for(int i =2;i<=n;i++){
            int temp = a+b;
            a = b;
            b = temp;
        }
        return b;
    }
    public static void main(String[] args) {
        FibonacciSequence fs = new FibonacciSequence();
        System.out.println(fs.fib_3(100));
       // System.out.println(fs.fib_1(100));
        System.out.println(fs.fib_2(100));
    }
}
