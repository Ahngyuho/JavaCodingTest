package PracticeCode.Prac6;
import java.util.*;
public class Prob2 {
    LinkedList<String> tmp;
    ArrayList<String> res;
    public void DFS1(String s,int start){
        if(tmp.size() == 4 && start == s.length()){
            String t = "";
            for(String x : tmp){
                t += x + ".";
            }
            res.add(t.substring(0,t.length() - 1));
        }else{
            for(int i=start;i<s.length();i++){
                if(s.charAt(start) == '0' && i > start) return;
                String num = s.substring(start,i+1);
                if(Integer.parseInt(num) > 255) return;
                tmp.add(num);
                DFS1(s,i+1);
                tmp.pollLast();
            }
        }
    }
    public String[] solution1(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS1(s,0);
        String[] answer = new String[res.size()];
        for(int i=0;i<res.size();i++) answer[i] = res.get(i);
        return answer;
    }
    public void DFS(int start, String s){
        if(tmp.size() == 4 && start == s.length()){
            String Ts = "";
            for(String x : tmp) Ts += x+".";
            res.add(Ts.substring(0, Ts.length()-1));
        }
        else{
            for(int i = start; i < s.length(); i++){
                if(s.charAt(start) == '0' && i > start) return;
                String num = s.substring(start, i + 1);
                if(Integer.parseInt(num) > 255) return;
                tmp.add(num);
                DFS(i + 1, s);
                tmp.pollLast();
            }
        }
    }

    public String[] solution(String s){
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS(0, s);
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(Arrays.toString(T.solution1("25114")));
        System.out.println(Arrays.toString(T.solution1("23251232")));
        System.out.println(Arrays.toString(T.solution1("21020132")));
        System.out.println(Arrays.toString(T.solution1("21350")));
        System.out.println(Arrays.toString(T.solution1("120225")));
        System.out.println(Arrays.toString(T.solution1("232012521")));
    }
}
