package SearchAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class greedyAlgorithm {
    //活动选择问题
    public static void selectActivities(int[] start,int[] end){
        int n = start.length;

        //将开始时间和结束时间装入二维数组中
        int[][] activities = new int[n][2];
        for(int i=0;i<n;i++){
            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }

        //按照结束时间排序
        Arrays.sort(activities,Comparator.comparingInt(a->a[1]));

        //查找并添加合适的活动
        List<int[]> list = new ArrayList<>();
        int lastEnd = -1;
        for(int[] activity:activities){
            if(activity[0]>= lastEnd){
                list.add(activity);
                lastEnd = activity[1];
            }
        }

        //输出结果
        System.out.print("活动选择问题的最优解为：\n");
        for(int[] activity:list){
            System.out.printf("开始时间：%d,结束时间：%d\n",activity[0],activity[1]);
        }
    }
    public static void main(String[] args) {
        int[] start = {1,3,0,5,3,5,6,8,8,2,12};
        int[] end = {4,5,6,7,8,9,10,11,12,13,14};
        selectActivities(start,end);
    }
}
