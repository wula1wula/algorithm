package SortingAlgorithms.ComparisonSortingAlgorithms;

public class HeapSort {
    public static void heapSort(int[] array) {
        if(array == null || array.length == 0) {
            return;
        }
        int n = array.length;
        heapsort(array, n);
    }
    //堆排序，每次搜索出最大值，并将最大值放置到数组末尾，缩小数组范围，使用堆的选择排序
    private static void heapsort(int[] array, int n) {
        buildHeap(array, n);
        for(int i =n-1;i>0;i--){
            BubbleSort.swap(array, 0, i);
            heapify(array, i, 0);
        }
    }
    //将数组array构造成一个大顶堆
    private static void buildHeap(int[] array, int n) {
        for(int i = n/2-1;i>=0;i--){
            heapify(array, n, i);
        }
    }
    //将i位置元素向下调整，直到找到它应该在的位置
    private static void heapify(int[] array, int n, int i) {
        // 找到i位置元素，它的左右子节点中最大的那个
        int largest = i;
        int left = 2*i+1;
        int right= 2*i+2;
        if(left <n && array[left]>array[largest]){
            largest = left;
        }
        if(right <n && array[right]>array[largest]){
            largest = right;
        }
        //将原本i位置的元素向下调整，直到找到它应该在的位置
        if(largest != i){
            BubbleSort.swap(array, largest, i);
            heapify(array, n, largest);
        }
    }
}
