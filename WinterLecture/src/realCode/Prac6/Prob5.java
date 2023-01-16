package realCode.Prac6;

import java.util.*;

public class Prob5 {
    int cnt;
    int[][] answer = new int[10][10];
    int[][] p = new int[2][100];
    int[][] h = new int[10][10];
    int[][] y = new int[10][10];
    int[][] g = new int[10][10];
    int find(int x,int y){
        return (x / 3) * 3 + (y / 3);
    }
    boolean flag = false;

    void DFS(int L,int[][] board){
        if(flag) return;
        if(L == cnt){
            flag = true;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    answer[i][j] = board[i][j];
                }
            }
            return;
        }
        int x = p[0][L];
        int z = p[1][L];
        int gg = find(x,z);
        for(int i=1;i<=9;i++){
            if(h[x][i] == 0 && y[z][i] == 0 && g[gg][i] == 0){
                h[x][i] = y[z][i] = g[gg][i] = 1;
                board[x][z] = i;
                DFS(L+1,board);
                h[x][i] = y[z][i] = g[gg][i] = 0;
                board[x][z] = 0;
            }
        }
    }

    int[][] solution(int[][] board){
        p = new int[2][100];
        h = new int[10][10];
        y = new int[10][10];
        g = new int[10][10];
        cnt = 0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == 1){
                    p[0][cnt] = i;
                    p[1][cnt++] = j;
                }else{
                    h[i][board[i][j]] = 1;
                    y[i][board[i][j]] = 1;
                    g[find(i,j)][board[i][j]] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Prob5 T = new Prob5();
        for(int[] x :(T.solution(
                new int[][]{{0, 2, 3, 0, 5, 0, 7, 8, 9},
                        {0, 5, 6, 0, 8, 9, 1, 0, 3},
                        {0, 8, 9, 1, 0, 3, 0, 5, 6},
                        {0, 1, 0, 0, 6, 0, 8, 9, 0},
                        {3, 0, 5, 0, 9, 7, 0, 1, 4},
                        {0, 9, 7, 0, 1, 0, 0, 6, 5},
                        {5, 3, 0, 6, 0, 2, 9, 7, 8},
                        {6, 0, 2, 9, 0, 8, 5, 3, 1},
                        {9, 0, 8, 0, 3, 0, 6, 0, 2}}))){
            System.out.println(Arrays.toString(x));
        };
    }
}
