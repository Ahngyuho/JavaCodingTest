package Prac8;

import java.util.*;
class Point implements Comparable<Point>{
    char c;
    int n;
    Point(char c,int n){
        this.c = c;
        this.n = n;
    }
    @Override
    public int compareTo(Point o) {
        return o.n - this.n;
    }
}
public class Prob2 {
    String solution(String s){
        String answer = "";
        HashMap<Character,Integer> hs = new HashMap<>();
        PriorityQueue<Point> pQ = new PriorityQueue<>();
        for(char x : s.toCharArray()){
            hs.put(x, hs.getOrDefault(x, 0) + 1);
        }
        for(char x : hs.keySet()){
            pQ.add(new Point(x,hs.get(x)));
        }
        while(!pQ.isEmpty()){
            if(pQ.size() == 1){
                Point a = pQ.poll();
                answer += a.c;
            }else{
                Point a = pQ.poll();
                Point b = pQ.poll();
                answer += a.c;
                answer += b.c;
                if(a.n > 1) pQ.add(new Point(a.c,a.n - 1));
                if(b.n > 1) pQ.add(new Point(b.c,b.n - 1));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution("AAABBCDEFFG"));
        System.out.println(T.solution("ABCABCAD"));
    }
}
