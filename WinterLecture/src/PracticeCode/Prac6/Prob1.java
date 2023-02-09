package PracticeCode.Prac6;
import java.util.*;
public class Prob1 {
    //2023 01 31
//    LinkedList<Character> list;
//    HashMap<Character,Integer> nH;
//    char[] alpha;
//    ArrayList<String> res;
//    public void DFS(int size){
//        if(list.size() == size){
//            char[] tmp = new char[list.size()];
//            for(int i=0;i<list.size();i++)tmp[i] = list.get(i);
//            res.add(String.valueOf(tmp));
//        }else{
//            for(int i=0;i<nH.size();i++){
//                if(nH.get(alpha[i]) == 0) continue;
//                list.addFirst(alpha[i]);
//                list.addLast(alpha[i]);
//                nH.put(alpha[i],nH.get(alpha[i]) - 2);
//                DFS(size);
//                list.pollFirst();
//                list.pollLast();
//                nH.put(alpha[i],nH.get(alpha[i]) + 2);
//            }
//        }
//    }
//    public String[] solution(String s) {
//        res = new ArrayList<>();
//        String[] answer = {};
//        nH = new HashMap<>();
//        list = new LinkedList<>();
//        for(char x : s.toCharArray()){
//            nH.put(x,nH.getOrDefault(x,0) + 1);
//        }
//        int oddCnt = 0;
//        char oddChar = '0';
//        for(char x : nH.keySet()) {
//            if (nH.get(x) % 2 == 1) {
//                oddCnt++;
//                oddChar = x;
//            }
//            if (oddCnt >= 2) return new String[]{};
//        }
//        if(nH.containsKey(oddChar)) {
//            if(nH.get(oddChar) == 1) nH.remove(oddChar);
//            else nH.put(oddChar, nH.get(oddChar) - 1);
//            list.add(oddChar);
//        }
//        alpha = new char[nH.size()];
//        int idx = 0;
//        for(char x : nH.keySet()){
//            alpha[idx++] = x;
//        }
//        DFS(s.length());
//        answer = new String[res.size()];
//        for(int i=0;i<res.size();i++) {
//            answer[i] = res.get(i);
//            System.out.print(answer[i] + " ");
//        }
//        return answer;
//    }
    LinkedList<Character> tmp;
    HashMap<Character,Integer> nH;
    ArrayList<String> res;
    int len;
    public void DFS(){
        if(tmp.size() == len){
            String Ts = "";
            for(char x : tmp) Ts += x;
            res.add(Ts);
        }else{
            for(char x : nH.keySet()){
                if(nH.get(x) == 0) continue;
                tmp.addLast(x);
                tmp.addFirst(x);
                nH.put(x,nH.get(x) - 2);
                DFS();
                tmp.pollLast();
                tmp.pollFirst();
                nH.put(x,nH.get(x) + 2);
            }
        }
    }
    public String[] solution(String s) {
        String[] answer;
        tmp = new LinkedList<>();
        nH = new HashMap<>();
        res = new ArrayList<>();
        len = s.length();
        for(char x : s.toCharArray()){
            nH.put(x,nH.getOrDefault(x,0) + 1);
        }
        char t = ' ';
        int cnt = 0;
        for(char x : nH.keySet()){
            if(nH.get(x) % 2 == 1) {cnt++;t=x;}
            if(cnt > 1) return new String[]{};
        }
        if(t != ' '){
            tmp.add(t);
            nH.put(t,nH.get(t) - 1);
        }
        DFS();
        answer = new String[res.size()];
        for(int i=0;i<res.size();i++) answer[i] = res.get(i);
        return answer;
    }



    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        //System.out.println(Arrays.toString(T.solution("abbcc")));
        //System.out.println(Arrays.toString(T.solution("abbccee")));
        //System.out.println(Arrays.toString(T.solution("abbcceee")));
    }
}
