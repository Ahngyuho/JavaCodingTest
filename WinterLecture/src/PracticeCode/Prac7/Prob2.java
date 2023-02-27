package PracticeCode.Prac7;
import java.util.*;
public class Prob2 {
    public int solution2(int s,int e) {
        int answer = 0;
        int L = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int[][] ch = new int[2][200001];
        ch[L%2][s] = 1;
        while(!Q.isEmpty()){
            int len = Q.size();
            L++;
            e += L;
            for(int i=0;i<len;i++){
                int cur = Q.poll();
                System.out.println("송아지 " + e);
                for(int x : new int[]{cur - 1,cur + 1,cur * 2}){
                    if(x < 0 || x > 200000 || ch[L%2][x] == 1) continue;
                    System.out.print(x + " ");
                    //이건 안됨 지금 노드가 x를 기준으로 -1 , 1 마다 반복됨 그래서 굉장히 많은 노드들이 중복돼서 원하는 시간 내에 통과될 수 없음
                    //그러면 x == e 로 판단하게 된다면 실제로는 노드가 해당 L 에 존재해야 하지만 시간 문제로 인해 노드를 넣지 않았기 때문에 여기서 걸릴 수 없다.
//                    if(x == e) return L;
                    ch[L%2][x] = 1;
                    Q.offer(x);
                }
                System.out.println();
            }
            if(e > 100) return -1;
            //노드 e 는 해당 L 이 홀수면 홀수 짝수면 짝수만큼 계속 반복돼서 나타남
            //그 노드를 우리는 중복해서 넣지 않기 위해 이런 visited 배열을 만들었고 실제로 있는지 체크해보기 위해서도 이 배열을 사용해야함
            if(ch[L%2][e] == 1) return L;
        }
        return -1;
    }
    //02 03
    public int solution1(int s,int e) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            L++;
            e = L + e;
            for(int i=0;i<len;i++){
                int t = Q.poll();
                for(int x : new int[]{t-1,t+1,t*2}){
                    if(x < 0 || x > 200000) continue;
                    else {
                        if (x == e) return L;
                        Q.offer(x);
                    }
                }
            }
        }
        return answer;
    }

    public int solution(int s, int e){
        int[][] ch = new int[2][200001];
        Queue<Integer> Q = new LinkedList<>();
        ch[0][s] = 1;
        ch[1][s] = 1;
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            L++;
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                for(int nx : new int[]{x-1, x+1, x*2}){
                    if(nx >= 0 && nx <= 200000 && ch[L%2][nx] == 0){
                        ch[L%2][nx] = 1;
                        Q.offer(nx);
                        if (L == 19 && nx == 34757) {
                            System.out.print(nx + " ");
                        }
                    }
                }
            }
            e = e + L;
            if(e > 200000) return -1;
            if(ch[L%2][e] == 1) {
                System.out.println(e);
                return L;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        //System.out.println(T.solution(1, 11));
       // System.out.println(T.solution(10, 3));
        //System.out.println(T.solution(2, 54321));
        System.out.println(T.solution(6, 6));
    }
}
