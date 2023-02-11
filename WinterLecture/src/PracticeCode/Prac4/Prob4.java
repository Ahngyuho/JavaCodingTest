package PracticeCode.Prac4;
import java.util.*;
public class Prob4 {
    class Info implements Comparable<Info>{
        int num;
        char team;
        int attack;

        Info(int num,char team,int attack){
            this.num = num;
            this.team = team;
            this.attack = attack;
        }

        public int compareTo(Info o){
            return this.attack - o.attack;
        }
    }

    public int[] solution1(String[] students) {
        ArrayList<Info> list = new ArrayList<>();
        int n = students.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            char a = students[i].split(" ")[0].charAt(0);
            int b = Integer.parseInt(students[i].split(" ")[1]);
            list.add(new Info(i,a,b));
        }
        Collections.sort(list);
        int total =0 , j = 0;
        HashMap<Character,Integer> nH = new HashMap<>();
        for(int i=1;i<n;i++){
            for(;j<n;j++){
                if(list.get(j).attack < list.get(i).attack){
                    total += list.get(j).attack;
                    char x = list.get(j).team;
                    nH.put(x,nH.getOrDefault(x,0) + list.get(j).attack);
                }
                else break;
            }
            answer[list.get(i).num] = total - nH.getOrDefault(list.get(i).team,0);
        }
        return answer;
    }

    public int[] solution(String[] students) {
        HashMap<Character,ArrayList<Integer>> nH = new HashMap<>();
        int n = students.length;
        int[] answer = new int[n];
        Info[] stu = new Info[n];
        for(int i=0;i<n;i++){
            char a = students[i].split(" ")[0].charAt(0);
            int b = Integer.parseInt(students[i].split(" ")[1]);
            stu[i] = new Info(i,a,b);
        }
        Arrays.sort(stu,(a,b) -> a.attack - b.attack);
        int sum = stu[0].attack;
        nH.put(stu[0].team,new ArrayList<>());
        nH.get(stu[0].team).add(stu[0].attack);
        for(int i=1;i<n;i++){
            if(nH.containsKey(stu[i].team)){
                int tmpSum = sum;
                for(int y : nH.get(stu[i].team)) tmpSum -= y;
                answer[stu[i].num] = tmpSum;
            }else answer[stu[i].num] = sum;
            int j = i;
            while(j-1 >=0 && stu[i].attack == stu[j-1].attack){
                answer[stu[i].num] -= stu[j].attack;
                j--;
            }
            sum += stu[i].attack;
            nH.putIfAbsent(stu[i].team,new ArrayList<>());
            nH.get(stu[i].team).add(stu[i].attack);
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(Arrays.toString(T.solution1(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution1(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution1(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution1(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
