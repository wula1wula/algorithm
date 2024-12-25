package SortingAlgorithms.NonComparisonSorting;

import java.util.Arrays;

public class CountingSort {
    public void countingSort(int[] arr) {
        if(arr == null || arr.length <=1){
            return;
        }
        countSort(arr);
    }
    private void countSort(int[] arr) {
        int maxValue = arr[0];
        for(int num :arr){
            maxValue = Math.max(maxValue,num);
        }
        int[] count = new int[maxValue + 1];
        //统计每个数出现的频率
        for(int i =0;i<arr.length;i++){
            count[arr[i]]++;
        }
        //统计每个数在排序后的数组中的位置
        for(int i =1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        int[] res = new int[arr.length];
        //从后往前遍历，count数组中每个索引代表要排序的值，索引中的值代表该索引需要填入的位置，每填入一个，就减一
        for(int i = arr.length-1;i>=0;i--){
            res[count[arr[i]]-1]=arr[i];
            count[arr[i]]--;
        }
        System.arraycopy(res,0,arr,0,res.length);
    }
    public static void main(String[] args) {
        int[] arr = {10,4,6,9,7,8};
        CountingSort countingSort = new CountingSort();
        countingSort.countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
