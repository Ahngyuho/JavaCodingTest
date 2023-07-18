package Prac8;
import java.util.*;

public class Prob2 {
    public int solution2(int n, int[][] edges) {
        int[][] dy = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) dy[i][j]=0;
                else dy[i][j]=100000;
            }
        }
        System.out.println(edges.length);
        for (int i = 0; i < edges.length; i++) {
            System.out.println();
            int cur = edges[i][0];
            for (int j = 1; j < edges[cur - 1].length; j = j + 2) {
                dy[cur][edges[cur - 1][j]] = edges[cur - 1][j+1];
            }
        }


        for(int z=1; z<=n; z++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dy[i][z]+dy[z][j]<dy[i][j])
                        dy[i][j]=dy[i][z]+dy[z][j];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(dy[i][j] == 100000) System.out.print("M ");
                else System.out.print(dy[i][j] + " ");
            }
            System.out.println();
        }

        return 0;
    }
    public int solution(int n, int[][] flights,int s,int e,int k){
        int[][] dy=new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) dy[i][j]=0;
                else dy[i][j]=100000;
            }
        }
        for(int[] x : flights){
            dy[x[0]][x[1]]=x[2];
        }
        for(int z=1; z<=n; z++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dy[i][z]+dy[z][j]<dy[i][j])
                        dy[i][j]=dy[i][z]+dy[z][j];
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(dy[i][j]==100000) System.out.print("M ");
                else System.out.print(dy[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=1;i<=n;i++){

        }
        return 0;
    }

    public int solution(int n, int[][] edges){
        int[][] dy=new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) dy[i][j]=0;
                else dy[i][j]=100000;
            }
        }
        for(int[] x : edges){
            dy[x[0]][x[1]]=x[2];
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(dy[i][j] + " ");
            }
            System.out.println();
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dy[i][k]+dy[k][j]<dy[i][j])
                        dy[i][j]=dy[i][k]+dy[k][j];
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(dy[i][j]==100000) System.out.print("M ");
                else System.out.print(dy[i][j]+" ");
            }
            System.out.println();
        }
        return 0;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
//        System.out.println(T.solution(5, new int[][]{{1, 2, 6}, {1, 3, 3}, {3, 2, 2},
//                {2, 4, 1}, {2, 5, 13}, {3, 4, 5}, {4, 2, 3}, {4, 5, 7}}));
        T.solution2(5, new int[][]{{1, 3, 2}, {2, 4, 4}, {3, 1, 2, 4, 3}, {4, 2, 4, 3, 3, 5, 6}, {5, 4, 6}});
    }
}
