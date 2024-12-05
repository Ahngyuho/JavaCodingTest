package Quiz30;

public class MultiTap {

    private static int N = 20; // 목표 구멍 수
    private static int[] memo; // 메모이제이션을 위한 배열

    public static void main(String[] args) {
        memo = new int[N + 1];
        System.out.println(countWays(0));
    }

    public static int countWays(int current) {
        // 이미 계산된 값이 있는 경우, 그 값을 사용
        if (memo[current] != 0) return memo[current];

        // 종료 조건: 현재 구멍 수가 N에 도달한 경우
        if (current == N) return 1;

        // 종료 조건: 현재 구멍 수가 N을 초과한 경우
        if (current > N) return 0;

        int totalWays = 0;

        // 2구 추가
        totalWays += countWays(current + 2);

        // 3구 추가
        totalWays += countWays(current + 3);

        // 결과를 메모이제이션 배열에 저장
        memo[current] = totalWays;
        return totalWays;
    }
}