package PracticeCode.Prac3;

import java.util.*;

//public class Prob4 {
//    public int solution(int[] tasks,int k) {
//        int answer = 0;
//        int[] sT = new int[tasks.length + 1];
//        System.arraycopy(tasks,0,sT,1,tasks.length);
//        Arrays.sort(sT);
//        int rest = tasks.length;
//        for(int i = 1;i<sT.length;i++){
//            if(k < (rest * (sT[i] - sT[i-1]))){
//                long idx = k % rest;
//                System.out.print(k + " " + rest + " " + idx + " ");
//                int cnt = 0;
//                for(int j=0;j<tasks.length;j++){
//                    if(tasks[j] >= sT[i]){
//                        if(cnt == idx) return j + 1;
//                        cnt++;
//                    }
//                }
//            }else{
//                k -= (rest * (sT[i] - sT[i-1]));
//                rest--;
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        Prob4 T = new Prob4();
//        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
//        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 6));
//        System.out.print(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
//    }
//}
import java.util.*;
class Prob4 {
    public int solution(int[] tasks, long k){
        int answer = 0;
        int[] sT = new int[tasks.length + 1];
        System.arraycopy(tasks, 0, sT, 1, tasks.length);
        Arrays.sort(sT);
        int rest = tasks.length;
        for(int i = 1; i < sT.length; i++){
            if(k < rest * (sT[i] - sT[i-1])){
                long idx = k % rest;
                System.out.print(k + " " + rest + " " + idx + " ");
                int cnt = 0;
                for(int j = 0; j < tasks.length; j++){
                    if(tasks[j] >= sT[i]){
                        if(cnt == idx) return j+1;
                        cnt++;
                    }
                }
            }
            else{
                k -= (rest * (sT[i] - sT[i-1]));
                rest--;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Prob4 T = new Prob4();
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.print(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}