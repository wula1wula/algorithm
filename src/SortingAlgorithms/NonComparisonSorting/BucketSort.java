package SortingAlgorithms.NonComparisonSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void bucketSort(Double[] arr){
        if(arr == null || arr.length <= 0){
            return;
        }
        sort(arr);
    }
    private static void sort(Double[] arr){
        //初始化桶
        int n = 5;
        List<List<Double>> buckets = new ArrayList<>();
        for(int i =0;i<n;i++){
            buckets.add(new ArrayList<>());
        }
        //将元素放入桶中
        //归一化处理
        double max = arr[0];
        double min = arr[0];
        for(Double num : arr){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        for(Double num : arr){
            double normalized= (num - min)/(max - min);
            int index = (int)(normalized*n);
            if(index == n){
                index--;
            }
            buckets.get(index).add(num);
        }
        //对每个桶进行排序
        for(List<Double> bucket : buckets){
            Collections.sort(bucket);
        }
        //将桶中的元素放回原数组
        int index = 0;
        for(List<Double> bucket : buckets){
            for(Double num : bucket){
                arr[index++] = num;
            }
        }
    }
    public static void main(String[] args) {
        Double [] arr = {0.23,0.45,0.67,0.34,0.12,0.89,0.56,0.78,0.90,0.11};
        bucketSort(arr);
        for (Double num : arr) {
            System.out.print(num + " ");
        }
    }
}
