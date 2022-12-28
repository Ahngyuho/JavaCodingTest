package Prac6;

public class Prob2 {
    void DFS(int n) {
        if(n == 0) return;

        DFS(n/2);
        System.out.print(n%2);
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();

        T.DFS(7);
    }
}
