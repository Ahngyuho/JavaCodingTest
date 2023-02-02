package PracticeCode.Prac2;
import java.util.*;

public class Prob2{
	//2023 02 01
	public int solution1(String s) {
		int[] alpha = new int[26];
		Arrays.fill(alpha,-1);
		HashSet<Integer> hs = new HashSet<>();
		for(int x : s.toCharArray()){
			if (alpha[x - 97] == -1) {
				alpha[x - 97] = 1;
			}else alpha[x-97]++;
		}
		int answer = 0;
		for(int i=0;i<26;i++){
			if(hs.contains(alpha[i])) {
				while(hs.contains(alpha[i]) && alpha[i] != -1){
					alpha[i]--;
					answer++;
				}
			}
			if(alpha[i] != 0) hs.add(alpha[i]);
		}
		return answer;
	}
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
		System.out.println(T.solution1("aaabbbcc"));
		System.out.println(T.solution1("aaabbc"));
		System.out.println(T.solution1("aebbbbc"));
		System.out.println(T.solution1("aaabbbccde"));
	}
}
