package realCode.Prac10;
import java.util.*;
public class Prob3 {
    public int addKey(int keys,int c){
        if(c >= 97 && c <= 122){
            return keys | (1 << (c-97));
        }
        return keys;
    }
    public boolean unlock(int keys,int c){
        int index = c - 65;
        return (keys & (1 << index)) > 0;
    }
    int solution(String[] board){
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,-1};
        int n = board.length;
        int m = board[0].length();
        char[][] map = new char[n][m];
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i].charAt(j);
                map[i][j] = c;
                if (c >= 97 && c <= 122) cnt++;
            }
        }
        int[][][] ch = new int[n][m][(1<<cnt) - 1];
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0,0,0});
        int L = 0;
        int keys = (1 << cnt) - 1;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int[] cur = Q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + cur[0];
                    int ny = dy[k] + cur[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == '#') continue;
                    char c = map[nx][ny];
                    int ks = addKey(cur[2], (int) c);
                    //현재 밑에 자식으로 내려갔다고 생각하고 짜여진 코드라서 L + 1
                    if (ks == keys) return L + 1;
                    if (c >= 65 && c <= 90 && !unlock(ks, (int) c)) continue;
                    ch[nx][ny][ks] = 1;
                    Q.offer(new int[]{nx, ny, ks});
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution(new String[]{"..a.b", "###B#", "..#A.", ".cC..", "....."}));
        System.out.println(T.solution(new String[]{"..a..", "###.#", "b.A.B"}));
        System.out.println(T.solution(new String[]{"...aA", "..B#.", "....b"}));
    }
}
