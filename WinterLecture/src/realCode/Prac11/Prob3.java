package realCode.Prac11;
import java.util.*;
public class Prob3 {
    int solution(int[] enter,int[] exit){
        int n = enter.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            enter[i]--;
            exit[i]--;
        }
        int[] enterT = new int[n];
        int[] exitT = new int[n];
        int[] enterIdx = new int[n];
        for(int i=0;i<n;i++){
            enterIdx[enter[i]] = i;
        }
        int cnt = 0;
        for(int i=0,j=0;i<n;i++){
            while(j < n && j <= enterIdx[exit[i]]){
                enterT[enter[j]] = cnt++;
                j++;
            }
            exitT[i] = cnt++;
        }
        return 1;
    }
}
