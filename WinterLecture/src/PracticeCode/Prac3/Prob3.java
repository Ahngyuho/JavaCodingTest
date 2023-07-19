package PracticeCode.Prac3;

import java.util.*;

public class Prob3 {
    public static void main(String[] args) {
        Prob3 T = new Prob3();
        System.out.println(T.solution2(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution2(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}}));
        System.out.println(T.solution2(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1},{1, 0, 0, 0, 1, 1}}));
    }

    public int solution2(int[][] board){
        //수직선을 그려보면
        //0 ----------- 3---------------- 7
        //여기서 각 위치에서 출발하여 한 점으로 모일 때의 총 거리의 최단거리를 구하려고 하면
        //모이려고 하는 위치가 각 위치에서의 최단 거리 여야 한다. 그 지점이 가운데 인거 같다.
        //해당 문제는 2차원 배열이지만 적용되는 규칙을 위와 동일하다고 생각한다.
        //그래서 학생들의 출발 위치들을 가져와서 산출될 수 있는 중간 위치를 구한다.
        //그리고 그 위치에서 각 출발 위치들의 거리를 더한다.
        int answer = 0;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();

        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 1){row.add(i);col.add(j);}
            }
        }
        Collections.sort(col);
        int x = row.get(row.size() / 2);
        int y = col.get(col.size() / 2);
        for(int p : row) answer += Math.abs(p - x);
        for(int p : col) answer += Math.abs(p - y);
        return answer;
    }

    public int solution(int[][] board) {
        int answer = 0;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        int n = board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(col);
        int x = row.get(row.size() / 2);
        int y = col.get(col.size() / 2);

        for(int p : row) answer += Math.abs(x - p);
        for(int p : col) answer += Math.abs(y - p);

        return answer;
    }
    //01 28
    public int solution1(int[][] board) {
        int n = board.length;
        int answer = 0;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        col.sort((a,b) -> a-b);
        int x = row.get(row.size() / 2);
        int y = col.get(col.size() / 2);
        for(int p : row) answer += Math.abs(x - p);
        for(int p : col) answer += Math.abs(y - p);
        return answer;
    }


}
