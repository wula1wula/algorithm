package SortingAlgorithms.ComparisonSortingAlgorithms;

public class BubbleSort {
    boolean isSorted = true;
    public void bubbleSort(int[] array){
        for(int i =0;i<array.length;i++){
            isSorted = true;
            for(int j =0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
