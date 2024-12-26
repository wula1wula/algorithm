package SearchAlgorithms;

public class JumpSearch {
    private int jumpSearch(int[] arr,int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int jumpIndex = 0;
        int prev =0;
        while(jumpIndex < n&& arr[jumpIndex] <= target) {
            prev = jumpIndex;
            jumpIndex += step;
        }
        for(int i = prev; i <= Math.min(jumpIndex,n); i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
