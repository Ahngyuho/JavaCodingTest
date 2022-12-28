package Prac6;

public class Prob3 {
    void DFS(int v) {
        if(v>7) return;
        else{
            System.out.println(v + " ");
            DFS(v*2);
            DFS(v*2 + 1);
        }
    }

    public static void main(String[] args) {
        Prob3 T = new Prob3();
        T.DFS(1);
    }
}
