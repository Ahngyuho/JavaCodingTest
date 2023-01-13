package realCode.Prac3;

import java.util.*;

public class Prob1 {

    class binaryNum implements Comparable<binaryNum>{
        public int num;
        public int oneNums;
        public ArrayList<Integer> oneOrZero = new ArrayList<Integer>();

        binaryNum(int num) {
            this.num = num;
            this.oneNums = 0;
        }

        void setOneOrZero(int num){
            if(num == 0) return;
            else{
                setOneOrZero(num / 2);
                oneOrZero.add(num % 2);
            }
        }

        void setOneNums() {
            for (int x : this.oneOrZero) {
                if(x == 1) this.oneNums++;
            }
        }

        @Override
        public int compareTo(binaryNum o) {
            return this.oneNums - o.oneNums;
        }
    }

    public ArrayList<Integer> solution(int[] nums) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<binaryNum> tmp = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            binaryNum x = new binaryNum(nums[i]);
            x.setOneOrZero(nums[i]);
            x.setOneNums();
            tmp.add(x);
            System.out.println(x.oneNums);
        }

        Collections.sort(tmp);

        for(binaryNum x : tmp){
            answer.add(x.num);
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(new int[]{5, 6, 7, 8, 9}));
    }
}
