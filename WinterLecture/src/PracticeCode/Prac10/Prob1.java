package PracticeCode.Prac10;

public class Prob1 {
    public int[] stu;
    public int[] t;
    int answer;
    public void DFS(int s,int sum,int T){
        boolean flag = true;
        for(int i=0;i<stu.length;i++){
            if((sum & stu[i]) == stu[i]) {
                flag = false;
                break;
            }
        }
        if(flag) answer++;
        for(int i=s;i<=T;i++){
            DFS(i + 1,sum + t[i],T);
        }
    }
    public int solution(int T,int[][] hate) {
        t = new int[T + 1];
        answer = 0;
        int n = hate.length;
        t[1] = 1;
        for(int i=2;i<=T;i++){
            t[i] = t[i-1] * 2;
        }
        stu = new int[n];
        for(int i=0;i<n;i++){
            for(int x : hate[i]){
                stu[i] += t[x];
            }
        }
        DFS(1,0,T);
        return answer;
    }

    public static void main(String[] args) {
        Prob1 T = new Prob1();
        System.out.println(T.solution(6, new int[][]{{1}, {4, 2}, {3, 2, 6}, {5}, {3, 4, 6}}));
        System.out.println(T.solution(6, new int[][]{{3, 1, 4}, {6, 1, 4}, {1}, {4, 1, 5, 6, 3}, {4, 2, 3}, {2, 4, 6}, {1, 6}, {2}, {4, 5, 1}}));
        System.out.println(T.solution(7, new int[][]{{3, 1, 6}, {5}, {4, 1, 7}, {1, 7, 4, 5, 2, 3, 6}, {7, 2, 4, 3, 1, 5}, {5, 4, 2}, {7, 2}, {3, 2, 5}, {1, 3}, {1}, {2}, {2, 5, 1, 7, 3}}));
        System.out.println(T.solution(9, new int[][]{{9, 6, 3, 1, 2}, {4, 8, 7, 9, 1, 5}, {3, 8, 5, 1, 2, 4, 9}, {8, 4, 9, 5}, {5, 6, 7, 3, 8}, {8, 3, 5, 9, 7}, {5, 2, 3}, {6}, {2, 6, 5}, {5}, {8, 9}, {3, 9}, {2, 4, 1, 3, 7, 6, 5, 8, 9}, {1, 2, 3, 7, 9, 4, 5, 8}, {3, 8, 5, 1, 4}, {7, 6, 9, 4, 1}, {1, 9, 3, 5, 7, 8, 2, 6}, {6, 4, 5}, {8, 5, 1, 6, 3, 2}, {1, 2, 8, 5}, {3}, {7, 3}}));
    }
}
