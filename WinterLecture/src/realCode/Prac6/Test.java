package realCode.Prac6;

import java.util.*;

public class Test {
    public int m = 4;
    public int n = 4;
    public Stack<Integer> stack = new Stack<>();
    int[] ch = new int[5];

    public void DFS(int L){
        if(L == n){
            for(int x : stack) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=1;i<=m;i++){
                if(ch[i] == 0){
                    stack.push(i);
                    ch[i] = 1;
                    DFS(L + 1);
                    stack.pop();
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test T = new Test();
        T.DFS(0);
    }
}
