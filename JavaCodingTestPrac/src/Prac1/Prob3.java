package Prac1;

public class Prob3 {
    //01 29
    public String solution(String s) {
        String answer;
        int left = 0;
        int right = s.length() - 1;
        char[] str = s.toCharArray();
        while(left < right){
            while(!Character.isAlphabetic(str[left])){
                left++;
            }
            while(!Character.isAlphabetic(str[right])){
                right--;
            }
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
        answer = String.valueOf(str);
        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution("a#b!GE*T@S"));
        System.out.println(T.solution("###ab*@@Sty"));
    }
}
