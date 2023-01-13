package realCode.Prac6;

public class Prob3 {
    int[] mem;
    int DFS(int start,String s){
        int res = 0;
        if(mem[start] > 0) return mem[start];
        if(start < s.length() && s.charAt(start) == '0') return 0;
        if(start == s.length() || start == s.length() - 1){
            return 1;
        }else{
            for(int i=start ; i<s.length();i++){
                if(s.charAt(start) == '0') continue;
                res = DFS(start+1,s);
                if(Integer.parseInt(s.substring(start,start+2)) <= 26) res += DFS(start+2,s);
            }
        }
        mem[start] = res;
        return res;
    }
    int solution(String s){
        mem = new int[101];
        return DFS(0,s);
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
