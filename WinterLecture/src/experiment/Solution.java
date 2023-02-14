package experiment;

import java.util.*;
class Solution {
    int[] dy;
    public int DFS(int start, String s){
        if(dy[start] > 0) return dy[start];
        if(start < s.length() && s.charAt(start) == '0') return 0;
        if(start == s.length() -1 || start == s.length()) return 1;
        else{
            int res = DFS(start + 1, s);
            System.out.println(s.substring(start,start+1));
            int tmp = Integer.parseInt(s.substring(start, start + 2));
            if(tmp <= 26) {
                res += DFS(start + 2, s);
                System.out.println(s.substring(start,start+2));
            }
            return dy[start] = res;
        }
    }

    public int solution(String s){
        dy = new int[101];
        int answer = DFS(0, s);
        for(int i=0;i<s.length();i++){
            System.out.print(dy[i] + " ");
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
    }
}