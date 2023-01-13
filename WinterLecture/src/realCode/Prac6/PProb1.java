package realCode.Prac6;

import java.util.*;

public class PProb1 {
    public int m;
    public int size;
    HashMap<Character,Integer> nH;
    LinkedList<Character> list;
    ArrayList<String> check;
    public void DFS() {
        if (list.size() == size) {
            String tmp = "";
            for(char x : list) tmp += x;
            check.add(tmp);
        }
        else{
            for(char x : nH.keySet()){
                if(nH.get(x) == 0){
                    list.addLast(x);
                    list.addFirst(x);
                    nH.put(x,nH.get(x) - 2);
                    DFS();
                    list.pollFirst();
                    list.pollLast();
                    nH.put(x,nH.get(x) + 2);
                }
            }
        }
    }

    String[] solution(String s) {
        nH = new HashMap<>();
        list = new LinkedList<>();
        check = new ArrayList<>();
        String[] answer;

        for(char x : s.toCharArray()) nH.put(x,nH.getOrDefault(x,0) + 1);
        int odd = 0;
        char mid = '0';
        for(char x : nH.keySet()){
            if(nH.get(x) % 2 == 1) {
                odd++;
                mid = x;
            }
        }

        if(odd > 1) return new String[]{};

        if(mid != '0'){
            list.add(mid);
            nH.put(mid,nH.get(mid) - 1);
        }

        DFS();
        int idx = 0;
        answer = new String[check.size()];
        for(String x : check) {
            System.out.print(x + " ");
            answer[idx] = x;
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        //System.out.println(T.solution("aaaabb"));
        System.out.println(T.solution("abbcc"));
        //System.out.println(T.solution("abbccee"));
        //System.out.println(T.solution("abbcceee"));
    }
}
