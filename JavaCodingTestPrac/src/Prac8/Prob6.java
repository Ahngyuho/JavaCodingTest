package Prac8;



public class Prob6 {
    int[] unf;
    public String solution1(int N,int[][] friend,int s1,int s2){
        unf = new int[N+1];
        for(int i=1;i<=N;i++) unf[i] = i;
        for(int[] x : friend){
             unf[Math.max(x[0],x[1])] = unf[Math.min(x[0],x[1])];
        }
        for(int i=1;i<=N;i++) System.out.print(unf[i]+ " ");
        if(unf[s1] == unf[s2]) return "YES";
        else return "NO";
    }

    public int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
    public void Union(int a, int b){
        int fa=Find(a);
        int fb=Find(b);
        if(fa < fb) unf[fb] = fa;
        else unf[fa] = fb;
//        if(fa!=fb) unf[fa]=fb;
    }
    public String solution(int n, int[][] friend, int s1, int s2){
        unf=new int[n+1];
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int[] x : friend){
            Union(x[0], x[1]);
        }
        int fa=Find(s1);
        int fb=Find(s2);
        for(int i=1;i<=n;i++) System.out.print(unf[i] + " ");
        if(fa==fb) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Prob6 T = new Prob6();
        System.out.println(T.solution(9, new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 5}, {6, 7}, {7, 8}, {8, 9}}, 3, 8));
        System.out.println(T.solution1(9, new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 5}, {6, 7}, {7, 8}, {8, 9}}, 3, 8));
    }
}
