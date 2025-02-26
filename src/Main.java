import SortingAlgorithms.ComparisonSortingAlgorithms.BubbleSort;

import java.util.Arrays;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {2,3,6,8,65,4,2,9,0,19};
        bubbleSort.bubbleSort(array);
        for(int i =0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}