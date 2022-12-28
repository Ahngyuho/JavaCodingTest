package Prac4;

public class Prob7 {
    int solution(int num){
        int answer = 0;
        int end = num / 2 + 1;
        int left = 0;
        int sum = 0;

        for(int right=1;right<=end;right++){
            sum += right;

            while(sum > num){
                sum -= left;
                left++;
            }

            if(sum == num) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob7 T = new Prob7();
        System.out.println(T.solution(45678));
    }
}
