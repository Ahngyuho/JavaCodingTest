package Prac2;

public class Prob6 {
    public int solution(int[] nums){
        int answer=0;
        int n=nums.length;
        int[] dist = new int[n];
        int d=1000;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                d=0;
                dist[i]=d;
            }
            else{
                d++;
                dist[i]=d;
            }
        }
        d=1000;
        for(int i=n-1; i>=0; i--){
            if(nums[i]==1) d=0;
            else{
                d++;
                dist[i]=Math.min(dist[i], d);
            }
        }

        for(int x : dist){
            System.out.print(x + " ");
            answer=Math.max(answer, x);
        }
        return answer;
    }
    //01 29
    public int solution1(int[] nums) {
        int n = nums.length;
        int[] dist = new int[n];
        int d = 1000;
        for(int i=0;i<n;i++){
            if(nums[i] == 1) {
                d = 0;
            }
            else{
                d++;
                dist[i] = d;
            }
        }
        d = 1000;
        for(int i=n-1;i>=0;i--){
            if(nums[i] == 1) d = 0;
            else{
                d++;
                dist[i] = Math.min(dist[i], d);
            }
        }
        int answer = 0;
        for(int x : dist) {
            System.out.print(x + " ");
            answer = Math.max(x,answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob6 T = new Prob6();
        System.out.println(T.solution(new int[]{0, 0, 0, 0, 1, 0, 0, 1, 0, 1}));
    }
}
