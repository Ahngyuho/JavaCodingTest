package Prac2;

public class Prob1 {
    public int[] solution2(int[] nums){
        //이미 오름차순이 되어 있는 배열을 모두 제곱하여 오름차순 정렬하는 문제이다.
        //lt rt 개념을 사용해서 두 수를 비교한 후 값을 찾아 배열에 넣으면 된다.
        //이미 정렬이 되어 있고, 두 수의 제곱의 비교는 결국 절대값이 누가 더 큰지 알아내는 것과 같다는 점을 이용
        int n = nums.length;
        int[] answer = new int[n];
        int lt = 0;
        int rt = n - 1;
        int tmp;

        for (int i = n - 1; i >= 0; i--) {
            if(Math.abs(nums[lt]) < Math.abs(nums[rt])){
                tmp = nums[rt];
                rt--;
            }else{
                tmp = nums[lt];
                lt++;
            }
            answer[i] = tmp * tmp;
        }
        for(int x : answer) System.out.print(x + " ");
        return answer;
    }

    public int[] solution1(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int lt = 0;
        int rt = n - 1;
        int tmp;
        for (int i = n - 1; i >= 0; i--) {
            if(Math.abs(nums[lt]) > Math.abs(nums[rt])){
                tmp = nums[rt];
                rt--;
            }else{
                tmp = nums[lt];
                lt++;
            }
            answer[i] = tmp * tmp;
        }
        return answer;
    }


    //01 29
    public int[] solution(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int left = 0;
        int right = n - 1;
        int tmp = 0;
        for(int i=n-1;i>=0;i--){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                tmp = nums[right];
                right--;
            }else{
                tmp = nums[left];
                left++;
            }
            answer[i] = tmp * tmp;
        }
        for(int x : answer) System.out.print(x + " ");
        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution2(new int[]{-4, -1, 0, 3, 10}));
        System.out.println(T.solution2(new int[]{-7, -3, 2, 3, 11}));
    }
}
