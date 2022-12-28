package Prac7;

public class Prob4 {
    int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy={0, 1, 1, 1, 0, -1, -1, -1};

    static int answer;
    static int n;

    void DFS(int x, int y, int[][] board) {
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny, board);
            }
        }
    }

    int solution(int[][] board) {
        n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    DFS(i, j, board);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution(new int[][]{{1, 1, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 1, 1}, {1, 1, 0, 1, 1, 0, 0}, {1, 0, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0, 0}}));
    }
}
