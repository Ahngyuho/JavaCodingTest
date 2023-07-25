package Prac6;

import java.util.*;
class Main {
    static int n, r;
    Stack<Integer> combi = new Stack<>();
    public void DFS(int L, int s){
        if(L== r){
            for(int x : combi) System.out.print(x+" ");
            System.out.println();
        }
        else{
            for(int i=s; i<=n; i++){
                combi.push(i);
                DFS(L+1, i+1);
                combi.pop();
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        r =kb.nextInt();
        T.DFS(0, 1);
    }
}