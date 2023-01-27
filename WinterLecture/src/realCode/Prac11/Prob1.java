package realCode.Prac11;
import java.util.*;
public class Prob1 {
    public int[] solution(int[] arrival,int[] state){
        int n = arrival.length;
        int[] answer = new int[n];
        Queue<Integer> in = new LinkedList<>();
        Queue<Integer> out = new LinkedList<>();
        int pos = 0;
        int cnt = 0;
        int inout = state[0];
        for(int i=0;;i++){
            if(cnt == n) break;
            if(in.isEmpty() && out.isEmpty() && i < arrival[pos]) i = arrival[pos];
            while(pos < n && arrival[pos] == i){
                if(state[pos] == 0) in.offer(pos);
                else if(state[pos] == 1) out.offer(pos);
                pos++;
            }
            if(out.isEmpty()) inout = 0;
            if(in.isEmpty()) inout = 1;
            if(inout == 0 && !in.isEmpty()){
                answer[in.peek()] = i;
                in.poll();
                cnt++;
            }else if(inout == 1 && !out.isEmpty()){
                answer[out.peek()] = i;
                out.poll();
                cnt++;
            }
        }
        for (int i = 0; i < n; i++) System.out.print(answer[i] + " ");
        System.out.println();
        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(new int[]{0, 1, 1, 1, 2, 3, 7},new int[]{1, 0, 0, 1, 0, 1, 1}));
        System.out.println(T.solution(new int[]{3, 3, 4, 5, 5, 5},new int[]{1, 0, 1, 0, 1, 0}));
        System.out.println(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10},new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0}));
    }
}
