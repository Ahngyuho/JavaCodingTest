package realCode.Sorting.P2024_12_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Horse {

    //left = mid + 1 -> 미드값을 높이자!
    //right = mid - 1 -> 미드값을 좁히자!
    int solution(int[] nums, int c){
        Arrays.sort(nums);
        int answer = 0;

        int left = 1;
        int right = nums[nums.length - 1];

        // <= 와 < 는 뭐가 다를까?
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(Count(nums,mid) >= c){ //간격은 충분!
                answer = mid;
                left = mid + 1; // mid 값을 높히자! ->
            }else right = mid - 1; //간격이 너무 넓다! 좁히자!
        }

        return answer;
    }

    int Count(int[] nums, int dist){
        int cnt = 1;
        int prev = nums[0];
        List<Integer> list = new ArrayList<>();
        list.add(prev);
        for(int i=1;i<nums.length;i++){

            //이 코드 블럭의 의미는??
            //prev(이건 nums[i-1]이 되면 안됨. ) 와 nums[i]
            //1 2 4 8 9
            //1 2 4
            //prev 와 현재 마구간 위치간의 간격이 dist 를 넘어서는 경우!
            if(nums[i] - prev >= dist) {
                cnt++;
                // 왜 이게 여기에 있어야 할까??
                prev = nums[i];

                // 오토 박싱
                list.add(prev);
            }

        }

        System.out.println(dist);
        for(int x : list){
            System.out.print(x +  " ");
        }
        System.out.println();

        return cnt;
    }

    public static void main(String[] args) {
        Horse T = new Horse();
        System.out.println(T.solution(new int[]{5, 12, 34, 16, 18, 23, 29, 15}, 7));
    }
}
