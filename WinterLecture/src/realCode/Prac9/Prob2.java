package realCode.Prac9;

public class Prob2 {
    public int solution(int n, int[][] routes,int s,int e,int k){
        int[][] dy=new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) dy[i][j]=0;
                else dy[i][j]=100000;
            }
        }
        for(int[] x : routes){
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
}
