package realCode.Prac11;
import java.util.*;
public class Prob1 {
    public int[] solution(int[] arrival,int[] state){
        int n = arrival.length;
        int[] answer = new int[n];
        //0
        Queue<int[]> in = new LinkedList<>();
        //1
        Queue<int[]> out = new LinkedList<>();
        //사원
        int pos = 1;
        int inout;
        if(state[0] == 0) {
            answer[0] = arrival[0];
            inout = 0;
        }
        else {
            answer[0] = arrival[0];
            inout = 1;
        }
        for(int i=arrival[0];;i++){
            while(pos < n && arrival[pos] == i){
                if(state[pos] == 0){
                    out.offer(new int[]{pos,i});
                }else if(state[pos] == 1){
                    in.offer(new int[]{pos,i});
                }
                pos++;
            }
            if(in.peek()[1] <= i && inout == 0){
                answer[in.peek()[0]] = i;
            }else if(out.peek()[1] <= i && inout == 1){
                answer[out.peek()[0]] = i;
            }
        }
        return answer;
    }
}
