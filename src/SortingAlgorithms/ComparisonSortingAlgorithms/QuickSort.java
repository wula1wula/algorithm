package SortingAlgorithms.ComparisonSortingAlgorithms;

import java.util.Random;

public class QuickSort {
    public void quickSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }
    private void quickSort(int[] arr, int start, int end) {
        if (start >=end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }
    private int partition(int[] arr, int start, int end) {
        int pivotIndex = new Random().nextInt(start,end+1);
        BubbleSort.swap(arr,pivotIndex,end);
        int pivot = arr[end];
        int i = start;
        for(int j =start;j<end;j++){
            if(arr[j]<=pivot){
                BubbleSort.swap(arr,i,j);
                i++;
            }
        }
        BubbleSort.swap(arr,i,end);
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
