package PracticeCode.Prac10;

import java.util.*;

public class Prob3 {
    public int addKey(int curKey,int key){
        if(key <= 122 && key >= 97) {
            int c = key - 97;
            return curKey | (1 << c);
        }
        return curKey;
    }
    public boolean unlock(int keys, int c) {
        int index = c - 65;
        return (keys & (1 << index)) > 0;
    }

        public int solution1(String[] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        char[][] chars = new char[n][m];
        int keyCnt = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                chars[i][j] = board[i].charAt(j);
                if(97 <= chars[i][j] && chars[i][j] <= 122){
                    keyCnt++;
                }
            }
        }
        int keys = (1 << keyCnt) - 1;
        int[][][] visited = new int[n][m][keys + 1];
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{0,0,0});
        visited[0][0][0] = 1;
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int[] cur = Q.poll();
                for(int k=0;k<4;k++){
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];
                    if(x < 0 || x >= n || y < 0 || y >= m || chars[x][y] == '#') continue;
                    int curKey = addKey(cur[2],(int)chars[x][y]);
                    if(keys == curKey) return L + 1;
                    if(visited[x][y][curKey] == 1) continue;
                    if(chars[x][y] >= 65 && chars[x][y] <= 90 && !unlock(cur[2],(int)chars[x][y])) continue;
                    visited[x][y][curKey] = 1;
                    Q.offer(new int[]{x,y,curKey});
                }
            }
            L++;
        }
        return -1;
    }

    public int solution(String[] board){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length();
        char[][] chars = new char[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i].charAt(j);
                chars[i][j] = c;
                if (c >= 97 && c <= 122) {
                    cnt++;
                }
            }
        }
        int keys = (1 << cnt) - 1;
        Queue<int[]> queue = new LinkedList();
        boolean[][][] visited = new boolean[n][m][keys + 1];
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];
                    if (x < 0 || x >= n || y < 0 || y >= m || chars[x][y] == '#') {
                        continue;
                    }
                    char c = chars[x][y];
                    int ks = addKey(cur[2], (int)c);
                    if(ks == keys) return L + 1;
                    if (visited[x][y][ks]) {
                        continue;
                    }
                    if (c >= 65 && c <= 90 && !unlock(cur[2], (int)c)) continue;
                    visited[x][y][ks] = true;
                    queue.offer(new int[]{x, y, ks});
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        Prob3 T = new Prob3();
        System.out.println(T.solution1(new String[]{"..a.b", "###B#", "..#A.", ".cC..", "....."}));
        System.out.println(T.solution1(new String[]{"..a..", "###.#", "b.A.B"}));
        System.out.println(T.solution1(new String[]{"...aA", "..B#.", "....b"}));
        System.out.println(T.solution1(new String[]{".....a", "####A#", "bB.#..","##..Cc"}));
    }
}
