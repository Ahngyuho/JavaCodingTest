package Prac6;

import java.util.*;

/*
* 가장 가까운 큰수
* 자연수 N이 주어지면, N과 구성이 같으면서 N보다 큰 수 중 가장 작은 수를 출력하는 프로그
램을 작성하세요.
구성이 같다는 말은 각 자릿수가 같은 숫자들로 이루어졌다는 의미입니다. 예를 들어 123과
231은 서로 구성이 같습니다. 하지만 123과 215는 구성이 다릅니다
*
* 매개변수 n에 자연수 N(1<=N<=9999999)이 주어집니다.
* */

public class Prob5 {
    ArrayList<Integer> nums = new ArrayList<>();
    Stack<Integer> pm = new Stack<>();
    int[] ch;
    int m;
    int answer = 0,target;
    boolean flag = false;
    void DFS(int L) {
        if(flag) return;
        if (L == m) {
            answer = 0;

            for (int x : pm) {
                answer = answer * 10 + x;
                if (answer > target) flag = true;
            }
        } else {
            for (int i = 0; i < m; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm.push(nums.get(i));
                    DFS(L + 1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    int solution(int n) {
        target = n;
        int tmp = n;
        while (tmp > 0) {
            int t = tmp % 10;
            nums.add(t);
            tmp = tmp / 10;
        }

        Collections.sort(nums);
        m = nums.size();
        ch = new int[m];

        DFS(0);
        if(!flag) return -1;
        return answer;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(123));
    }
}
