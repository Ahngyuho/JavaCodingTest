package realCode.Prac7;

import java.util.*;

public class Prob1 {
    Queue<Point> Q;

    int solution(int[] pool, int a, int b, int home) {
        int answer = 0;
        Q = new LinkedList<>();
        Q.offer(new Point(0, 0));
        int[][] ch = new int[2][10001];
        for (int x : pool) {
            ch[0][x] = 1;
            ch[1][x] = 1;
        }

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point p = Q.poll();
                if (p.x == home) ++answer;
                for (int nx : new int[]{p.x + a, p.x - b}) {
                    if (nx <= 10001 && ch[0][nx] == 0) {
                        ch[0][nx] = 1;
                        Q.offer(new Point(nx, 0));
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}