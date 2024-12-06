package realCode.Sorting.P2024_12_05;

import java.util.Arrays;

public class Lan {
    private int solution(int[] nums, int n) {
        Arrays.sort(nums);

        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        int answer = 0;

        while(left <= right){

            int mid = (left + right) / 2;
            if(check(nums,mid) >= n){
                answer = mid;
                left = mid + 1;
            }else right = mid - 1;
        }

        return answer;
    }

    private int check(int[] nums, int len) {
        int cnt = 0;
        for(int x : nums){
            cnt += Math.floor(x / len);
        }

        return cnt;
    }
    public static void main(String[] args) {
        Lan T = new Lan();
        System.out.println(T.solution(new int[]{93, 97, 93, 53, 75, 57, 85, 89, 67}, 30));
        System.out.println(T.solution(new int[]{802, 743, 457, 539}, 11));
        System.out.println(T.solution(new int[]{8593, 9617, 9313, 4513, 7505, 5457, 8257,4689, 2657}, 100));
    }
}
