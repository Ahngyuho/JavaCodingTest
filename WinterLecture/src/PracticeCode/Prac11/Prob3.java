package PracticeCode.Prac11;
import java.util.*;
public class Prob3 {
    public int[] solution1(int[] enter,int[] exit) {
        int n = enter.length;
        for(int i=0;i<n;i++){
            enter[i]--;
            exit[i]--;
        }
        int[] enterIdx = new int[n];
        for(int i=0;i<n;i++){
            enterIdx[enter[i]] = i;
        }
        int[] enterT = new int[n];
        int[] exitT = new int[n];
        int j = 0,cnt = 0;
        for(int i=0;i<n;i++){
            while(j<n && j <= enterIdx[exit[i]]){
                enterT[enter[j]] = cnt++;
                j++;
            }
            exitT[exit[i]] = cnt++;
        }
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                if(!(exitT[i] < enterT[j] || (exitT[j] < enterT[i]))){
                    answer[i]++;
                    answer[j]++;
                }
            }
        }
        return answer;
    }
    public int[] solution(int[]enter, int[] exit) {
        int n = enter.length;
        for (int i = 0; i < n; i++) {
            enter[i]--;
            exit[i]--;
        }
        int[] enterIdx = new int[n];
        for (int i = 0; i < n; i++) {
            enterIdx[enter[i]] = i;
        }
        int[] enterT = new int[n];
        int[] exitT = new int[n];

        int cnt = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && j <= enterIdx[exit[i]]) {
                enterT[enter[j]] = cnt++;
                j++;
            }
            exitT[exit[i]] = cnt++;
        }
        for(int x : exitT) System.out.print(x + " ");
        System.out.println();
        for(int x : enterT) System.out.print(x + " ");
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                //하나라도 참이 되면 안됨
                if (!(exitT[i] < enterT[j] || exitT[j] < enterT[i])) {
                    System.out.println(i + " " +j);
                    answer[i]++;
                    answer[j]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution1(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
