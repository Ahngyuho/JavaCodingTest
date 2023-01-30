package Prac2;

public class Prob7 {
    //01 29
    public int solution(String s,int n) {
        int answer = 0;
        int[] used = new int[27];
        for(int x : s.toCharArray()){
            if(x >= 97 && x <= 122){
                used[x - 97] = 1;
            }else if(x >= 65 && x<= 90){
                used[x-65] = 1;
                used[26] = 1;
            }
        }
        for(int i=0;i<27;i++) if(used[i] == 1) answer++;
        if(answer > n) return -1;
        return s.length();
    }

    public static void main(String[] args) {
        Prob7 T = new Prob7();
        System.out.println(T.solution("time to time", 5));
        System.out.println(T.solution("time to study", 7));
        System.out.println(T.solution("Big Life is Good", 10));
        System.out.println(T.solution("Life is Good", 7));
    }
}
