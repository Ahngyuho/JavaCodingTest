package Prac1;
public class Prob1 {
    //01 29
    public String solution(String s) {
        String answer = "";
        int cnt = 1;
        s += " ";
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) != s.charAt(i-1)){
                if(cnt == 1) answer += s.charAt(i - 1);
                else {answer += s.charAt(i - 1) + "" + cnt;}
                cnt = 1;
            }else cnt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution("KKHSSSSSSSE"));
        System.out.println(T.solution("AAABCCCDD"));
    }
}
