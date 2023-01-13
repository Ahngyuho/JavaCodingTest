package realCode.Prac6;
import java.util.*;
public class Prob1 {
    public int m;
    public ArrayList<Character> arr;
    public Stack<Character> stack = new Stack<>();
    public ArrayList<String> answer = new ArrayList<>();
    public HashSet<String> check = new HashSet<>();
    public int[] ch;
    public void DFS(int L) {
        if (L == m) {
            int left = 0;
            int right = m - 1;
            String tmp = "";
            for(char x : stack) tmp += x;
            //System.out.println(tmp);
            while(left <= right) {
                if (tmp.charAt(left) != tmp.charAt(right)) return;
                left++;
                right--;
            }
            //System.out.println(tmp);
            check.add(tmp);
        }
        else{
            for(int i=0;i<m;i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    stack.push(arr.get(i));
                    DFS(L + 1);
                    ch[i] = 0;
                    stack.pop();
                }
            }
        }
    }

    String[] solution(String s) {
        String[] answer = new String[]{};
        m = s.length();
        arr = new ArrayList<>();
        ch = new int[m];
        for(char x : s.toCharArray()) arr.add(x);

        DFS(0);
        for(String x : check) System.out.print(x + " ");

        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution("aaaabb"));
        //System.out.println(T.solution("abbcc"));
        //System.out.println(T.solution("abbccee"));
        //System.out.println(T.solution("abbcceee"));
    }
}
