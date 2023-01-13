package realCode.Prac2;

import java.util.*;

public class Prob4 {
    public String solution(String[] votes, int k) {
        String answer = "";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String,Integer> candidate = new HashMap<>();
        HashMap<String,Integer> present = new HashMap<>();

        for (String s : votes) {
            String a = s.split(" ")[0];
            String b = s.split(" ")[1];

            voteHash.putIfAbsent(a,new HashSet<String>());
            voteHash.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }

        int max = Integer.MIN_VALUE;

        for (String a : voteHash.keySet()) {
            int cnt = 0;

            for (String b : voteHash.get(a)) {
                if(candidate.get(b) > k) cnt++;
            }
            present.put(a, cnt);
            max = Math.max(max, cnt);
        }

        ArrayList<String> tmp = new ArrayList<>();
        for (String name : present.keySet()) {
            if (max == present.get(name)) {
                tmp.add(name);
            }
        }

        Collections.sort(tmp);

        return tmp.get(0);
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom",
                "daniel tom", "luis john"},2));
    }
}
