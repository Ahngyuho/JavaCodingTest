package PracticeCode.Prac10;
import java.util.*;
class Prob2 {
    public int solution(String[] s, int k){
        int answer = 0;
        int n = s.length;
        HashMap<Character, Integer> sH = new HashMap<>();
        int cnt = (1 << n);
        System.out.println(cnt);
        for(int i = 0; i < cnt; i++){
            System.out.println("i : " + i);
            int sum = 0;
            int shift = 0;
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) == 0) continue;
                System.out.print(j + " ");
                int score = s[j].length();
                for(Character x : s[j].toCharArray()){
                    if(x == ' ') continue;
                    if(x >= 65 && x <= 90){
                        x = (char)(x + 32);
                        shift = 1;
                        score++;
                    }
                    sH.put(x, 1);
                }
                sum += score;
            }
            System.out.println();
            if(sH.size() + shift <= k) answer = Math.max(answer, sum);
            sH.clear();
        }
        return answer;
    }

    public static void main(String[] args){
        Prob2 T = new Prob2();
        System.out.println(T.solution(new String[]{"Ges Big", "Ges in Big", "Big size", "Ges size"}, 7));
//        System.out.println(T.solution(new String[]{"Time is Gold", "Gold", "Gold line Ggg"}, 9));
//        System.out.println(T.solution(new String[]{"That is sist atm", "hot miss", "asmt hot"}, 7));
    }
}