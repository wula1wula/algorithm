package SortingAlgorithms.ComparisonSortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] array){
        mergeSort(array,0,array.length-1);
    }
    private void mergeSort(int[] array,int start,int end) {
        if(array ==null||array.length<=1){
            return;
        }
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }
    private void merge(int[] array,int start,int mid,int end){
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k =0;
        while(i<=mid && j<=end){
            if(array[i]<array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        while(i<=mid){
            temp[k++] = array[i++];
        }
        while(j<=end){
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, start, temp.length);
    }
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        sorter.sort(array);
        System.out.println(Arrays.toString(array)); // 输出：[3, 9, 10, 27, 38, 43, 82]
    }
}
