package realCode.Prac4;

import java.util.*;

public class Prob4 {
    class Mate implements Comparable<Mate>{
        public int num;
        public String team;
        public int attack;

        public Mate(int num,String team, int attack) {
            this.num = num;
            this.team = team;
            this.attack = attack;
        }

        @Override
        public int compareTo(Mate o) {
            return this.attack - o.attack;
        }
    }

    int[] solution(String[] students) {
        int[] answer = new int[students.length];
        ArrayList<Mate> tmp = new ArrayList<>();
        HashMap<String,Integer> Tp = new HashMap<>();

        int idx = 0;

        for (String x : students) {
            String x1 = x.split(" ")[0];
            int x2 = Integer.parseInt(x.split(" ")[1]);
            tmp.add(new Mate(idx,x1, x2));
            idx++;
        }

        Collections.sort(tmp);

        int j = 0;
        int total = 0;
        for (int i = 1; i < tmp.size(); i++) {
            while(tmp.get(j).attack < tmp.get(i).attack && i > j){
                j++;
                total += tmp.get(j).attack;
                Tp.put(tmp.get(j).team, Tp.getOrDefault(tmp.get(j).team,0) + tmp.get(j).attack);
            }

            if(Tp.containsKey(tmp.get(i).team)){
                answer[tmp.get(i).num] = total - Tp.get(tmp.get(i).team);
            }else{
                answer[tmp.get(i).num] = total;
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"}));
    }
}
