package Prac2;

import java.util.HashMap;

public class Prob4 {
    public String solution(String[] votes) {
        String answer = "";
        HashMap<String,Integer> chandi = new HashMap<>();
        HashMap<String,Integer> vote = new HashMap<>();

        for (String s : votes) {
            String[] s1 = s.split(" ");
            vote.put(s1[1], vote.getOrDefault(s1[1], 0) + 1);
            
        }

        return answer;
    }
}
