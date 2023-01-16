package realCode.Prac6;

public class Prob4 {
    class Pos{
        int num;
        int idx;
        int cnt;
        Pos(int num,int idx,int cnt){
            this.num = num;
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    Pos [] tmp = new Pos[10];
    void divide(int left,int right,Pos[] nums){
        if(left < right){
            int tt = 0;
            int mid = (left + right) / 2;
            divide(left, mid, nums);
            divide(mid + 1, right, nums);
            int p1 = left;
            int p2 = mid + 1;
            int p3 = left;
            while (p1 <= mid && p2 <= right) {
                if (nums[p1].num <= nums[p2].num) tmp[p3++] = nums[p1++];
                else {
                    nums[p2].cnt += mid - p1 + 1;
                    tmp[p3++] = nums[p2];
                    p2++;
                }
            }
            while (p1 <= mid) tmp[p3++] = nums[p1++];
            while (p2 <= right) tmp[p3++] = nums[p2++];
            for (int i = left; i <= right; i++) nums[i] = tmp[i];
        }
    }

    int[] solution(int[] nn){
        Pos[] a = new Pos[10];
        Pos[] b = new Pos[10];
        int n = nn.length;
        Pos[] nums = new Pos[n];

        for(int i=0;i<10;i++) a[i] = new Pos(nn[i],i,0);

        divide(0,n-1,nums);
        for(int i=0;i<=n;i++) System.out.println(nums[i] + " ");
        return new int[]{};
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution(new int[]{3, 2, 7, 9, 1, 5, 6, 8, 7}));
    }
}
