package SearchAlgorithms;

public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        return binarySearch(array, target, left, right);
    }
    private int binarySearch(int[] array, int target,int left, int right) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if(array[mid]==target){
            return mid;
        }
        if(array[mid] > target) {
            return binarySearch(array, target, left, mid - 1);
        }
        return binarySearch(array, target, mid + 1, right);
    }
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int index = binarySearch.binarySearch(array, target);
        System.out.println("The index of " + target + " is " + index);
    }
}
