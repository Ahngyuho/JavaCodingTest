package realCode.Prac5;

public class Prob4 {
    int solution(int[] cost, int m) {
        int answer = 0;

        int lt = 0;
        int sum = 0;
        for (int rt = 0; rt < cost.length; rt++) {
            sum += cost[rt];

            while (sum > m) {
                answer = Math.max(answer, rt - lt + 1);
                sum -= cost[lt];
                lt++;
            }
        }

        return --answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution(new int[]{0, 150, 100, 0, 150, 0, 70, 140},350));
        System.out.println(T.solution(new int[]{100, 200, 300, 400, 500, 100},300));
        System.out.println(T.solution(new int[]{100, 200, 300, 400, 0, 100, 150, 500, 100},300));
    }
}
