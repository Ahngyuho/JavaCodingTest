package Prac5;
import java.util.*;

public class Prob4 {
    int solution(int[][] nums){
        int answer = 0;

        Arrays.sort(nums,new Comparator<int []>(){
            @Override
            public int compare(int[] o1,int[] o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int start = nums[0][0];
        int end = nums[0][1];

        for(int i=0;i<nums.length;i++){
            if(nums[i][0] <= end && end < nums[i][1]){
                end = nums[i][1];
            }else if(nums[i][0] > end){
                answer += (end - start);
                start = nums[i][0];
                end = nums[i][1];
            }
        }

        answer += (end - start);

        return answer;
    }

    public static void main(String[] args){
        Prob4 T = new Prob4();
        int[][] nums = new int[][]{{5,6},{1,3},{7,8},{9,10}};
        System.out.println(T.solution(nums));
    }
}
