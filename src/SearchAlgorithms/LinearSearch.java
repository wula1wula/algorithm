package SearchAlgorithms;

public class LinearSearch {
    public int linearSearch(int[] arr,int target){
        int index =0;
        for(int i =0;i<arr.length;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        int target = 5;
        LinearSearch linearSearch = new LinearSearch();
        System.out.println("index is "+linearSearch.linearSearch(arr,target));
    }
}