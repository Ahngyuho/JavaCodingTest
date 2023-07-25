package PracticeCode.Prac6;
import java.util.*;

/*
* 팰린드롬의 경우수
매개변수 s에 문자열이 주어지면 이 문자열의 문자들을 가지고 만들 수 있는 팬린드롬의 경우
들을 배열에 담아 반환하는 프로그램을 작성하세요. 팰린드롬의 순서는 상관없습니다.
만약 팰린드롬이 만들어 지지 않을 경우 빈배열을 반환합니다.
* */

public class Prob1 {
    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
    }
    LinkedList<Character> tmp;
    HashMap<Character,Integer> sH;
    ArrayList<String> res;
    int len;
    int count = 0;

    public String[] solution1(String s){
        return new String[]{};
    }

    public void DFS1(){

    }

    public String[] solution(String s) {
        String[] answer;
        len = s.length();
        System.out.println(s);
        sH = new HashMap<>();
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        for(char x : s.toCharArray()){
            sH.put(x,sH.getOrDefault(x,0) + 1);
        }

        int odd = 0;
        char mid = '#';
        for(char key : sH.keySet()){
            if(sH.get(key) % 2 == 1) {mid = key;odd++;}
        }
        if(odd > 1) return new String[]{};
        if(odd == 1){
            tmp.add(mid);
            sH.put(mid,sH.get(mid) - 1);
        }
        DFS();
        answer = new String[res.size()];
        for(int i=0;i<res.size();i++) answer[i] = res.get(i);
        System.out.println(count);
        return answer;
    }

    public void DFS(){
        if(tmp.size() ==  len){
            count++;
            String st = "";
            for(char x : tmp) {
                st += x;
                System.out.print(x + " ");
            }
            System.out.println();
            res.add(st);
        }else{
            for(char key : sH.keySet()){
                if(sH.get(key) == 0) {
                    System.out.println("what: " + key + " ");
                    continue;
                }
                tmp.add(0,key);
                tmp.add(key);
                System.out.println(tmp.get(0) + " " + tmp.getLast() + " ");
                sH.put(key,sH.get(key) - 2);
                DFS();
                tmp.pollFirst();
                tmp.pollLast();
                sH.put(key,sH.get(key) + 2);
            }
        }
    }


}
