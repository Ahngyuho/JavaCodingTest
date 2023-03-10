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

    public int solution3(int[] tasks,int k) {
        int n = tasks.length;
        int[] tmp = new int[n+1];
        for(int i=1;i<=n;i++) tmp[i] = tasks[i-1];
        Arrays.sort(tmp);
        int rest = n;
        for(int i=1;i<=n;i++){
            if(k < (tmp[i] - tmp[i-1]) * rest){
                long idx = k % rest;
                int cnt = 0;
                for(int j=0;j<n;j++){
                    if(tmp[i] <= tasks[j]){
                        if(cnt == idx) return j + 1;
                        cnt++;
                    }
//                    if(tasks[j] <= tmp[i]) {
//                        if(cnt == idx) return j+1;
//                        cnt++;
//                    }
                }
            }else {
                k -= (tmp[i] - tmp[i - 1]) * rest;
                rest--;
            }
        }
        return -1;
    }
    public int solution2(int[] tasks,int k) {
        int n = tasks.length;
        int rest = n;
        int[] sT = new int[n + 1];
        for(int i=1;i<=n;i++) sT[i] = tasks[i-1];
        Arrays.sort(sT);
        for(int i=1;i<=n;i++){
            if(k < ((sT[i] - sT[i-1]) * rest)){
                int idx = k % rest;
                System.out.println(k + " " + idx);
                int cnt = 0;
                for(int j=0;j<tasks.length;j++){
                    if(sT[i] <= tasks[j]) {
                        if(cnt == idx) return j+1;
                        cnt++;
                    }
                }
            }else {
                k -= (sT[i] - sT[i - 1]) * rest;
                rest--;
            }
        }
        return -1;
    }
    //01 28
    public int solution1(int[] tasks,int k) {
        int rest = tasks.length;
        int[] sT = new int[tasks.length + 1];
        System.arraycopy(tasks,0,sT,1,tasks.length);
        Arrays.sort(sT);
        for (int i = 1; i < sT.length; i++) {
            if (rest * (sT[i] - sT[i - 1]) > k) {
                long idx = k % rest;
                int cnt = 0;
                for (int j = 0; j < tasks.length; j++) {
                    if (tasks[j] >= sT[i]) {
                        if (cnt == idx) return j + 1;
                        cnt++;
                    }
                }
            } else {
                k -= (rest * (sT[i] - sT[i - 1]));
                rest--;
            }
        }
        return -1;
    }

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
        System.out.println(T.solution3(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution3(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.print(T.solution3(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}