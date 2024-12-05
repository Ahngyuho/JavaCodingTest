package Quiz10;

public class Solution {

    public static void main(String[] args) {
        int boy = 20, girl = 10;
        boy += 1;
        girl += 1;

        // DP 배열 초기화
        int[][] dp = new int[boy][girl];
        dp[0][0] = 1;

        // DP를 이용하여 가능한 모든 도착 순서를 계산
        for (int b = 0; b < boy; b++) {
            for (int g = 0; g < girl; g++) {
                if (b > g) {  // 남자가 더 많아야 한다는 조건
                    if (b > 0) {
                        dp[b][g] += dp[b - 1][g];
                    }
                    if (g > 0) {
                        dp[b][g] += dp[b][g - 1];
                    }
                }
            }
        }

        // 결과는 dp[20][10]에 저장되어 있음
        System.out.println(dp[20][10]);
    }
}
