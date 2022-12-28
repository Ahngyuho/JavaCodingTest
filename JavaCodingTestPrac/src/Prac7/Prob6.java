package Prac7;

import java.util.*;

public class Prob6 {
    static int answer = 0;
    Stack<Integer> pm = new Stack<>();
    int[] ch;
    int[][] relation;

    void DFS(int L) {
        if (L == 7) {
            boolean flag = true;
            int cnt = 0, a = 0, b = 0;
            for (int x : pm) {
                if (cnt == 0) {
                    a = x;
                    cnt++;
                } else {
                    b = x;
                    if (relation[a][b] == 1) {
                        flag = false;
                        break;
                    }
                    a = b;
                }
            }

            if(flag) answer++;
        }else{
            for (int i = 1; i <= 7; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm.push(i);
                    DFS(L + 1);
                    pm.pop();
                    ch[i] = 0;
                }
            }
        }
    }

    int solution(int[][] fight) {
        relation = new int[8][8];
        for (int[] x : fight) {
            //System.out.println(x[0] + " " + x[1]);
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }

        ch = new int[8];

        DFS(0);

        return answer;
    }

    public static void main(String[] args) {
        Prob6 T = new Prob6();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
    }
}
