package PracticeCode.Prac1;

import java.util.Arrays;

public class Prob2 {
    int[] solution1(int[][] board, int k) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = board.length;
        int[] answer = new int[2];
        int curX = 0;
        int curY = 0;
        int dir = 0;
        int cnt = 0;
        while (cnt < k) {
            k++; //여기에 하나만 있어도 됨 위에서 if문에 걸리면 continue 되면서 아래의 이동하는 코드를 거치지 않기 때문
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                dir = (dir + 1) % 4;
//                k++; 처음 코드 작성 했을 때
                continue;
            }
            curX += dx[dir];
            curY += dy[dir];
//            k++; 처음 코드 작성 했을 때
        }
        answer[0] = curX;
        answer[1] = curY;
        return answer;
    }

    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1, count = 0;
        while(count < k){
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1){
                d = (d + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        int[][] arr={{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr, 10)));
    }
}
