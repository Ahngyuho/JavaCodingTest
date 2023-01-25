package realCode.Prac10;

import java.util.*;

public class Prob2 {
    int solution(String[] s,int k){
        int n = 1 <<s.length;
        int len = s.length;
        int sum = 0;
        int answer = 0;
        HashMap<Character,Integer> nH = new HashMap<>();
        for(int i=0;i<n;i++){
            int shift = 0;
            for(int j=0;j<len;j++){
                if((i & (1<<j)) == 0) continue;
                String tmp = s[j];
                int score = s[j].length();
                for(char x : tmp.toCharArray()){
                    if(x == ' ') continue;
                    if(x>=65 && x<=90){
                        x = (char)(x + 32);
                        //nH.put(x,nH.getOrDefault(x,0) + 1);
                        shift = 1;
                        score++;
                    }
                    nH.put(x,1);
                }
                sum += score;
            }
            if(nH.size() + shift <= k) answer = Math.max(answer,sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution(new String[]{"Ges Big", "Ges in Big", "Big size", "Ges size"},7));
    }
}
