package Prac2;
import java.util.*;
public class Prob9 {
    //01 29
    public int solution(int[][] board) {
        int n = board.length;
        int[] row = new int[n];
        int[] col = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                row[i] = Math.max(row[i],board[i][j]);
                col[i] = Math.max(col[i],board[j][i]);
            }
        }
        int answer = 0;
        int tmp;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tmp = Math.min(row[i],col[j]);
                answer += (tmp - board[i][j]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob9 T = new Prob9();
        System.out.println(T.solution(new int[][]{{2, 5, 7, 3},
                {6, 8, 9, 7},
                {3, 2, 4, 5},
                {7, 2, 5, 8}}));
        System.out.println(T.solution(new int[][]{{3, 7, 6, 2},
                {5, 3, 8, 7},
                {3, 2, 5, 7},
                {7, 7, 5, 3}}));
    }
}
