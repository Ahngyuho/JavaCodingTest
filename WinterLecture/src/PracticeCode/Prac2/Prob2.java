package PracticeCode.Prac2;
import java.util.*;

public class Prob2{
	int solution(String s){
		int answer = 0;
		HashMap<Character,Integer> nH = new HashMap<>();
		HashSet<Integer> hS = new HashSet<>();

		for(char x : s.toCharArray()){
			nH.put(x,nH.getOrDefault(x,0) + 1);
		}

		for(char x : nH.keySet()){
			while(hS.contains(nH.get(x))){
				answer++;
				nH.put(x,nH.get(x) - 1);
			}
			if(nH.get(x) != 0) hS.add(nH.get(x));
		}
		return answer;
	}
	public static void main(String[] args) {
		Prob2 T = new Prob2();
		System.out.println(T.solution("aaabbbcc"));
		System.out.println(T.solution("aaabbc"));
		System.out.println(T.solution("aebbbbc"));
		System.out.println(T.solution("aaabbbccde"));
	}
}
