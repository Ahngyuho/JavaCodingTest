package realCode.Prac5;

public class Prob1 {

    int solution(int[] nums){
        int answer = 0;

        int lt = 0;
        int sum = 0;

        for (int rt = 0; rt < nums.length; rt++) {
            sum += nums[rt];
            while (sum % 2 == 0 && lt <= rt) {
                sum -= nums[lt];
                lt++;
            }
            if(sum % 2 == 1) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(new int[]{1, 3, 5}));
        System.out.println(T.solution(new int[]{2, 4, 6, 8, 10}));
        System.out.println(T.solution(new int[]{1, 2, 6, 2, 4, 3, 5, 3, 5, 3, 6, 3, 5, 4, 2, 3, 5, 1, 4, 3, 6}));
    }
}
