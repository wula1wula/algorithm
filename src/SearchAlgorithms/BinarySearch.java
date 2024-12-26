package SearchAlgorithms;

public class BinarySearch {
    //递归
    public int binarySearch(int[] array, int target) {
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        return binarySearch(array, target, left, right);
    }
    private int binarySearch(int[] array, int target,int left, int right) {
        if(left > right) {
            return -1;
        }
        int mid = left+(right-left) / 2;
        if(array[mid]==target){
            return mid;
        }
        if(array[mid] > target) {
            return binarySearch(array, target, left, mid - 1);
        }
        return binarySearch(array, target, mid + 1, right);
    }
    //循环
    public int binarySearchIterative(int[] array, int target) {
        if(array == null || array.length == 0){
            return -1;
        }
        int left =0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = left+(right-left) / 2;
            if(array[mid]==target){
                return mid;
            }
            if(array[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int index = binarySearch.binarySearch(array, target);
        int index_2 = binarySearch.binarySearchIterative(array,target);
        System.out.println("The index of " + target + " is " + index+"or"+index_2);
    }
}
