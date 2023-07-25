package PracticeCode.Prac1;
import com.sun.prism.j2d.J2DPipeline;

import java.util.*;
public class Prob6 {
    public int solution2(int[] keypad, String password) {
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] pad = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pad[i][j] = keypad[i * 3 + j];
            }
        }
        //숫자와 숫자 사이의 거리 배열
        int[][] dist = new int[10][10];
        Arrays.fill(dist, 2);
        for(int i=0;i<10;i++) dist[i][i] = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int from = pad[i][j];
                for (int k = 0; k < 8; k++) {
                    if (i + dx[k] >= 0 && i + dx[k] < 3 && j + dy[k] >= 0 && j + dy[k] < 3) {
                        int to = pad[i+dx[k]][j+dy[k]];
                        dist[from][to] = 1;
                    }
                }
            }
        }

        return answer;
    }
    public int solution1(int[] keypad, String password) {
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] pad = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pad[i][j] = keypad[i * 3 + j];
            }
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) list.add(new ArrayList<>());

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cur = pad[i][j];
                for (int k = 0; k < 8; k++) {
                    int x = dx[k] + i;
                    int y = dy[k] + j;
                    if (x >= 0 && x < 3 && y >= 0 && y < 3){
                        list.get(cur).add(pad[x][y]);
                    }
                }
            }
        }

        int[] pass = new int[password.length()];

        for (int i = 0; i < password.length(); i++) {
            pass[i] = password.charAt(i) - 48;
        }

        for (int i = 1; i < pass.length; i++) {
            if(pass[i] == pass[i-1]) continue;
            boolean flag = false;
            for (int x : list.get(pass[i - 1])) {
                if(x == pass[i]) {
                    flag = true;
                }
            }
            if(flag == true) answer += 1;
            else answer += 2;
        }

        return answer;
    }

    public int solution(int[] keypad, String password){
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                pad[i][j] = keypad[i*3 + j];
            }
        }
        for(int i = 0; i < 10; i++){
            Arrays.fill(dist[i], 2);
        }
        for(int i = 0; i < 10; i++) dist[i][i] = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int from = pad[i][j];
                for(int k = 0; k < 8; k++){
                    if(i+dx[k] >= 0 && i+dx[k] < 3 && j+dy[k] >= 0 && j+dy[k] < 3){
                        int to = pad[i+dx[k]][j+dy[k]];
                        dist[from][to] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < password.length() - 1; i++){
            int from = (int)password.charAt(i)-48;
            int to = (int)password.charAt(i+1)-48;
            answer += dist[from][to];
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob6 T = new Prob6();
        System.out.println(T.solution1(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution1(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution1(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution1(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
        System.out.println(T.solution1(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "561654845164154152385648658475684754864878479658461487546876564875164854864874687658794658794658756486847967465423455648654687494566879745646564875456465486554654"));
    }
}
