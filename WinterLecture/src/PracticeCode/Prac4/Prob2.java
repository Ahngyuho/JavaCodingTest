package PracticeCode.Prac4;
import java.util.*;
public class Prob2 {
    public int solution(int[][] meetings) {
        int answer = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] x : meetings){
            list.add(new int[]{x[0], 0});
            list.add(new int[]{x[1], 1});
        }
        Collections.sort(list,(a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int cnt = 0;
        for(int[] x : list){
            if(x[1] == 0) cnt++;
            else cnt--;
            answer = Math.max(cnt,answer);
        }
        return answer;
    }
    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
