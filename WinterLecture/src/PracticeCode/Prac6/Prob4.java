package PracticeCode.Prac6;
import java.util.*;

public class Prob4 {
    class Data{
        public int num,idx,big;
        Data(int num, int idx, int big) {
            this.num = num; //배열 요소
            this.idx = idx; //배열 인덱스
            this.big = big; //초기값 0
        }
    }

    Data[] a,b;

    public void divide(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            divide(left, mid);
            divide(mid + 1, right);
            int p1 = left;
            int p2 = mid + 1;
            int p3 = left;

            while(p1 <= mid && p2 <= right){
                if(a[p1].num <= a[p2].num) b[p3++] = a[p1++];
                else{
                    b[p3] = a[p2++];
                    b[p3++].big += (mid - p1 + 1);
                }
            }
            while(p1 <= mid) b[p3++] = a[p1++];
            while(p2 <= right) b[p3++] = a[p2++];
            for (int i = left; i <= right; i++) {
                a[i] = b[i];
            }
        }
    }

    public int[] solution(int[] nums) {
        int n = nums.length;
        a = new Data[n];
        b = new Data[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Data(nums[i], i, 0);
        }
        divide(0, n - 1);
        int[] answer = new int[n - 1];
        for (int i = 0; i < n; i++) {
            if(a[i].idx == 0) continue;
            answer[a[i].idx - 1] = a[i].big;
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(Arrays.toString(T.solution(new int[]{6, 5, 8, 4, 2, 7, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 2, 7, 9, 1, 5, 6, 8, 7})));
    }
}
