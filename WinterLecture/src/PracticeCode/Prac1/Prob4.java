package PracticeCode.Prac1;

import java.util.Arrays;

public class Prob4 {
    int[] solution1(int c,int r, int k) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] seat = new int[r][c];
        int cnt = 0;
        int x = -1;
        int y = 0;
        int dir = 0;
        while (cnt < k) {
//            boolean flag = true;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c || seat[nx][ny] == 1){
                dir = (dir + 1) % 4;
//                flag = false;
            }
//            if(flag) {
//                //이런 경우 조심...
//                cnt++;
//                x = nx;
//                y = ny;
//                seat[x][y] = 1;
//            }
            x += dx[dir];
            y += dy[dir];
            seat[x][y] = 1;
            cnt++;
//            if(flag == false)
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(seat[i][j] + " ");
            }
            System.out.println();
        }
        if(cnt > r*c) return new int[]{0,0};
        else return new int[]{y + 1, x + 1};
    }

    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        if(k > c*r) return new int[] {0, 0};
        int[][] seat = new int[c][r];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, count = 1, d = 1;
        while(count < k){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= c || ny < 0 || ny >=r || seat[nx][ny] > 0){
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
    }
}
