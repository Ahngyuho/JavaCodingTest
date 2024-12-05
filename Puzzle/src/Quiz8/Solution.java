package Quiz8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static final int N = 12;

    public static void main(String[] args) {
        List<int[]> log = new ArrayList<>();
        log.add(new int[]{0, 0});
        System.out.println(move(log));
    }

    public static int move(List<int[]> log) {
        // 맨 처음의 위치를 포함하여 N+1개 조사하면 종료
        if (log.size() == N + 1) {
            return 1;
        }

        int cnt = 0;
        // 전후 좌우로 이동
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : directions) {
            // 탐색이 끝나지 않았으면 이동시킴
            int[] lastPos = log.get(log.size() - 1);
            int[] nextPos = {lastPos[0] + d[0], lastPos[1] + d[1]};
            // 로그에 다음 위치가 기록되어 있는지 확인하기
            boolean check = false;
            for (int[] p : log) {
                if (Arrays.equals(p, nextPos)) {
                    check = true; // 있는 경우 플래그를 True로 변경
                    break;
                }
            }
            if (!check) {
                List<int[]> newLog = new ArrayList<>(log);
                newLog.add(nextPos);
                cnt += move(newLog);
            }
        }
        return cnt;
    }
}