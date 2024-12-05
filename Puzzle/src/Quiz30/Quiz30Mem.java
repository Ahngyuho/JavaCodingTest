package Quiz30;

public class Quiz30Mem {
    private static int N = 20; // 목표 구멍 수
    private static int[] memo; // 메모이제이션을 위한 배열

    public static int setTap(int remain) {
        // 메모이제이션: 이미 계산된 값이 있는 경우, 그 값을 사용
        if (memo[remain] != 0) return memo[remain];

        // 종료 조건: 현재 구멍 수가 1인 경우
        if (remain == 1) return 1;

        int cnt = 0;

        // 2구 멀티탭 처리
        for (int i = 1; i <= remain / 2; i++) {
            if (remain - i == i) {
                cnt += setTap(i) * (setTap(i) + 1) / 2;
            } else {
                cnt += setTap(remain - i) * setTap(i);
            }
        }

        // 3구 멀티탭 처리
        for (int i = 1; i <= remain / 3; i++) {
            for (int j = i; j <= (remain - i) / 2; j++) {
                int k = remain - i - j;
                if (k == i && i == j) {
                    cnt += setTap(i) * (setTap(i) + 1) * (setTap(i) + 2) / 6;
                } else if (k == i) {
                    cnt += setTap(i) * (setTap(i) + 1) * setTap(j) / 2;
                } else if (i == j) {
                    cnt += setTap(k) * setTap(i) * (setTap(i) + 1) / 2;
                } else if (k == j) {
                    cnt += setTap(j) * (setTap(j) + 1) * setTap(i) / 2;
                } else {
                    cnt += setTap(k) * setTap(j) * setTap(i);
                }
            }
        }

        // 결과를 메모이제이션 배열에 저장
        memo[remain] = cnt;
        return cnt;
    }

    public static void main(String[] args) {
        memo = new int[N + 1];
        for(int x : memo) System.out.print(x + " ");
        System.out.println(setTap(N));
    }
}
