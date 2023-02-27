package PracticeCode.Prac6;
import java.util.*;
public class Prob5 {
    int[][] p, h, y, g, answer;
    int cnt = 0;
    boolean flag = false;
    public int find(int x,int y){
        return (x / 3) * 3 + (y / 3);
    }

    public void DFS1(int L,int[][] board){
        if(flag) return;
        if(L == cnt){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    answer[i][j] = board[i][j];
                }
            }
            flag = true;
        }else{
            for(int i=1;i<=9;i++){
                int nx = p[0][L];
                int ny = p[1][L];
                if(board[nx][ny] == 0 && h[nx][i] == 0 && y[ny][i] == 0 && g[find(nx,ny)][i] == 0){
                    h[nx][i] = y[ny][i] = g[find(nx,ny)][i] = 1;
                    board[nx][ny] = i;
                    DFS1(L+1,board);
                    h[nx][i] = y[ny][i] = g[find(nx,ny)][i] = 0;
                    board[nx][ny] = 0;
                }
            }
        }
    }
    public int[][] solution1(int[][] board) {
        p = new int[2][100];
        h = new int[10][10];
        y = new int[10][10];
        g = new int[10][10];
        answer = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == 0){
                    p[0][cnt] = i;
                    p[1][cnt++] = j;
                }else{
                    h[i][board[i][j]] = 1;
                    y[j][board[i][j]] = 1;
                    g[find(i,j)][board[i][j]] = 1;
                }
            }
        }
        DFS1(0, board);
        return answer;
    }
    public void DFS(int L,int[][] board){
        if(flag) return;
        if(L == cnt){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    answer[i][j] = board[i][j];
                }
            }
            flag = true;
            return;
        }else{
            for(int i=1;i<=9;i++){
                int xx = p[0][L];
                int yy = p[1][L];
                if(h[xx][i] == 0 && y[yy][i] == 0 && g[find(xx,yy)][i] == 0){
                    board[xx][yy] = i;
                    h[xx][i] = y[yy][i] = g[find(xx,yy)][i] = 1;
                    DFS(L+1,board);
                    board[xx][yy] = 0;
                    h[xx][i] = y[yy][i] = g[find(xx,yy)][i] = 0;
                }
            }
        }
    }
    public int[][] solution(int[][] board) {
        p = new int[2][100];
        h = new int[10][10];
        y = new int[10][10];
        g = new int[10][10];
        answer = new int[9][9];
        cnt = 0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == 0){
                    p[0][cnt] = i;
                    p[1][cnt++] = j;
                }else{
                    answer[i][j] = board[i][j];
                    h[i][board[i][j]] = 1;
                    y[j][board[i][j]] = 1;
                    g[find(i,j)][board[i][j]] = 1;
                }
            }
        }
        DFS(0,board);
        return answer;
    }
    public static void main(String[] args){
        Prob5 T = new Prob5();
        int[][] arr = new int[9][9];
        arr = T.solution1(new int[][]{{0, 2, 3, 0, 5, 0, 7, 8, 9},
                        {0, 5, 6, 0, 8, 9, 1, 0, 3},
                        {0, 8, 9, 1, 0, 3, 0, 5, 6},
                        {0, 1, 0, 0, 6, 0, 8, 9, 0},
                        {3, 0, 5, 0, 9, 7, 0, 1, 4},
                        {0, 9, 7, 0, 1, 0, 0, 6, 5},
                        {5, 3, 0, 6, 0, 2, 9, 7, 8},
                        {6, 0, 2, 9, 0, 8, 5, 3, 1},
                        {9, 0, 8, 0, 3, 0, 6, 0, 2}});
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
