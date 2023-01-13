package PracticeCode.Prac5;

public class Prob2 {
	String[] solution(int[] nums){
		String[] answer = new String[nums.length];
		for(int i=0;i<nums.length;i++){
			int n = nums[i] - 1;
			int t = 1;
			int j = 1;
			for(; ;j++){
				
				if(n >= t*9) n-= t*9;
				else{
					int len = (j+1)/2;
					int[] res = new int[100];
					String pal = "";
					res[0] = 1;
					for(int k=0;k<len;k++){
						res[k] += n / t;
						pal += String.valueOf(res[k]);
						n = n % 10;
						t = t/10;
					}
					for(int k = len - (j%2) - 1;k>=0;k--){
						pal += String.valueOf(res[k]);
					}
					answer[i] = pal;
					break;
				}
			}
			
			if(j % 2 == 0) t *= 10;
		}
		
		return answer;
	}
}
