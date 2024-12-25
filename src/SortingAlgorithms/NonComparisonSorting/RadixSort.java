package SortingAlgorithms.NonComparisonSorting;

public class RadixSort {
    public void radixSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr);
    }

    private void sort(int[] arr) {
        int max = getMax(arr); // 找到最大值
        int n = arr.length;
        int[] output = new int[n]; // 重复使用同一个输出数组

        // 基于每个位的权值从低到高进行排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, output, exp);
        }
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private void countSort(int[] arr, int[] output, int exp) {
        int n = arr.length;
        int[] count = new int[10];

        // 统计每个位上的出现次数
        for (int num : arr) {
            int index = (num / exp) % 10;
            count[index]++;
        }

        // 累加计数数组
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 从后向前遍历，确保稳定性
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i] / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        // 将排序结果拷贝回原数组
        System.arraycopy(output, 0, arr, 0, n);
    }
}
