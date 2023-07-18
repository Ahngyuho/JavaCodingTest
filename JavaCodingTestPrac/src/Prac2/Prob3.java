package Prac2;

public class Prob3 {

    public String solution2(int[] nums){
        String answer = "YES";
        int n = nums.length;
        int i = 0;
        while(i + 1 < n && nums[i + 1] > nums[i]) i++;
        if(i == 0 || i == n - 1) return "NO";
        while (i + 1 < n && nums[i + 1] < nums[i]) i++;
        if(i != n - 1) return "NO";
        return answer;
    }
    //01 29
    public String solution1(int[] nums) {
        String answer = "YES";
        int left = 0;
        int n = nums.length;
        for(int i = 1;i<n;i++){
            if(nums[i] > nums[i-1]){
                left++;
                if (i == n - 1) return "NO";
            }else if(nums[i] < nums[i-1]){
                left++;
            }
        }
        if(left != n-1) return "NO";
        return answer;
    }

    //01 29
    public String solution(int[] nums) {
        String answer = "YES";
        int i = 0;
        int n = nums.length;
        while(i + 1 < n && nums[i] < nums[i + 1]) i++;
        if(i == 0 || i == n-1) return "NO";
        while(i + 1 < n && nums[i] > nums[i + 1]) i++;
        if(i != n - 1) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution2(new int[]{1, 2, 3, 4, 5, 3, 1}));
        System.out.println(T.solution2(new int[]{1, 3, 4, 5, 5, 6, 4, 3}));
        System.out.println(T.solution2(new int[]{1, 2, 3, 4, 5}));
    }
}
