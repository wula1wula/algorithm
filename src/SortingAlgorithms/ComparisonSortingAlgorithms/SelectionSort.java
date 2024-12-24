package SortingAlgorithms.ComparisonSortingAlgorithms;

public class SelectionSort {
    public void selectionSort(int[] array){
        for(int i =0;i<array.length;i+=1){
            int minIndex =i;
            for(int j =i+1;j<array.length;j+=1) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            BubbleSort.swap(array, i, minIndex);
        }
    }
    public static void main(String[] args) {
        SelectionSort sorter = new SelectionSort();
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        sorter.selectionSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
