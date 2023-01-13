package PracticeCode.Prac2;
import java.util.*;
public class Prob4 {
    
	String solution(String[] votes, int k){
		ArrayList<String> answer = new ArrayList<>();
		HashMap<String,HashSet<String>> nH = new HashMap<>();
		HashMap<String,Integer> candi = new HashMap<>();
		HashMap<String,Integer> present = new HashMap<>();
		
		
		for(String x : votes){
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			nH.putIfAbsent(a,new HashSet<String>());
			nH.get(a).add(b);
			candi.put(b,candi.getOrDefault(b,0)+1);
		}
		int max = Integer.MIN_VALUE;
		for(String x : nH.keySet()){
			int cnt = 0;
			for(String y : nH.get(x)){
				
				if(candi.get(y) >= k) cnt++;
			}
			present.put(x,cnt);
			max = Math.max(max,cnt);
		}
		
		for(String x : present.keySet()){
			if(max == present.get(x)) answer.add(x);
		}
		Collections.sort(answer);
		return answer.get(0);
	}
	
	public static void main(String[] args){
		Prob4 T = new Prob4();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom",
                "daniel tom", "luis john"},2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 3));
	}
}
