package Prac1;

public class Prob2 {
    //01 29
    public String solution(String s) {
        String answer = "";
        s = s.toUpperCase();
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return "NO";
            left++;
            right--;
        }
        return "YES";
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution("gooG"));
        System.out.println(T.solution("Moon"));
        System.out.println(T.solution("MoooM"));
        System.out.println(T.solution("Mooon"));
    }
}
