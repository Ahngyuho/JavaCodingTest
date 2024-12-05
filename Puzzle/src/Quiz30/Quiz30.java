package Quiz30;

public class Quiz30 {
    public static int setTap(int remain) {
        if (remain == 1) {
            return 1;
        }
        int cnt = 0;
        // 2구 탭 처리
        System.out.println(remain + " " + cnt);
        for (int i = 1; i <= remain / 2; i++) {
            if (remain - i == i) {
                cnt += setTap(i) * (setTap(i) + 1) / 2;
            } else {
                cnt += setTap(remain - i) * setTap(i);
            }
        }
        // 3구 탭 처리
        for (int i = 1; i <= remain / 3; i++) {
            for (int j = i; j <= (remain - i) / 2; j++) {
                if (remain - (i + j) == i && i == j) {
                    cnt += setTap(i) * (setTap(i) + 1) * (setTap(i) + 2) / 6;
                } else if (remain - (i + j) == i) {
                    cnt += setTap(i) * (setTap(i) + 1) * setTap(j) / 2;
                } else if (i == j) {
                    cnt += setTap(remain - (i + j)) * setTap(i) * (setTap(i) + 1) / 2;
                } else if (remain - (i + j) == j) {
                    cnt += setTap(j) * (setTap(j) + 1) * setTap(i) / 2;
                } else {
                    cnt += setTap(remain - (i + j)) * setTap(j) * setTap(i);
                }
            }
        }
        System.out.println(remain + " " + cnt);
        return cnt;
    }

    public static void main(String[] args) {
        int N = 20;
        System.out.println(setTap(N));
    }
}
