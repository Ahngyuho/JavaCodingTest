package Prac1;
import java.util.*;
public class Prob4 {
    //01 29
    public String solution(String s) {
        String answer = "";
        HashMap<Character,Integer> nH = new HashMap<>();
        for(char x : s.toCharArray()){
            nH.put(x,nH.getOrDefault(x,0) + 1);
        }
        int cnt = 0;
        for(char x : nH.keySet()){
            if(nH.get(x) % 2 == 1) cnt++;
            if(cnt == 2) return "NO";
        }
        return "YES";
    }

    //01 29
    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }

    public String solution1(String s) {
        String answer = "";
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                String s1 = s.substring(left,right);
                String s2 = s.substring(left+1,right+1);
                if(!isPalindrome(s1) && !isPalindrome(s2)) return "NO";
            }
            left++;
            right--;
        }
        return "YES";
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution1("abcabbakcba"));
        System.out.println(T.solution1("abcacbakcba"));
    }
}
