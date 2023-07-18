package Prac2;

public class Prob2 {
    public int solution3(int[] nums){
        int answer = 0;
        int height = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) height += (nums[i] - nums[i - 1]);
            else {
                answer = Math.max(answer, height);
                height = 0;
            }
        }
        answer = Math.max(answer, height);
        return answer;
    }
    public int solution2(int[] nums){
        //이 문제는 가장 긴 증가수열을 찾는 것이고, 증가수열이란 연속적으로 증가하는 부분수열 중에서
        //양 끝 수들의 차이가 가장 큰 부분수열을 의미한다.
        int answer = 0;
        int height = 0;
        for (int i = 1; i < nums.length; i++) {
            //수직선을 그려보자
            //2 --- 4 -----7
            //(2-4=2) (4-7=3)
            //2------------7
            //( 2 - 7 = 5 )
            if(nums[i] > nums[i-1]) {
                height += (nums[i] - nums[i-1]);
            }else{
                answer = Math.max(answer,height);
                height = 0;
            }
        }

        //임의의 인덱스에서 계속 값이 증가하는 형태인 경우
        //그 경우는 위의 for 문에서 Math.max 를 지나쳐버린다.
        //else 의 조건은 증가수열이 끊기는 것이므로...
        //그래서 그런 경우를 대비하여
        answer = Math.max(answer, height);
        return answer;
    }

    //01 29
    public int solution1(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int left = 0;
        for(int right = 1;right<n;right++){
            if(nums[right] <= nums[right - 1]){
                left = right;
            }else{
                answer = Math.max(nums[right] - nums[left], answer);
            }
        }
        return answer;
    }

    //01 29
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int height = 0;
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]){
                height += nums[i] - nums[i-1];
            }else {answer = Math.max(answer,height);height = 0;}
        }
        answer = Math.max(answer,height);
        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution3(new int[]{8, 12, 2, 3, 7, 6, 12, 20, 3}));
        System.out.println(T.solution3(new int[]{5, 2, 4, 7, 7, 3, 9, 10, 11}));
    }
}
