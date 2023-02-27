package PracticeCode.Prac4;
import java.util.*;
public class Prob4 {
    class Info implements Comparable<Info>{
        int idx;
        char team;
        int power;

        Info(int num,char team,int attack){
            this.idx = num;
            this.team = team;
            this.power = attack;
        }

        public int compareTo(Info o){
            return this.power - o.power;
        }
    }

    public int[] solution3(String[] students) {
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<Info> stu = new ArrayList<>();
        for(int i=0;i<n;i++){
            char a = students[i].split(" ")[0].charAt(0);
            int b = Integer.parseInt(students[i].split(" ")[1]);
            stu.add(new Info(i,a,b));
        }
        Collections.sort(stu);
        HashMap<Character,Integer> Tp = new HashMap<>();
        int sum = 0,j = 0;
        for(int i=0;i<n;i++){
            for(;j<n;j++){
                if(stu.get(i).power > stu.get(j).power){
                    char t = stu.get(j).team;
                    sum += stu.get(j).power;
                    Tp.put(t, Tp.getOrDefault(t, 0) + stu.get(j).power);
                } else break;
            }
            char t = stu.get(i).team;
            answer[stu.get(i).idx] = sum - Tp.getOrDefault(t,0);
        }
        return answer;
    }

    public int[] solution2(String[] students) {
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
                if(list.get(j).power < list.get(i).power){
                    total += list.get(j).power;
                    char x = list.get(j).team;
                    nH.put(x,nH.getOrDefault(x,0) + list.get(j).power);
                }
                else break;
            }
            answer[list.get(i).idx] = total - nH.getOrDefault(list.get(i).team,0);
        }
        return answer;
    }

    public int[] solution1(String[] students) {
        HashMap<Character,ArrayList<Integer>> nH = new HashMap<>();
        int n = students.length;
        int[] answer = new int[n];
        Info[] stu = new Info[n];
        for(int i=0;i<n;i++){
            char a = students[i].split(" ")[0].charAt(0);
            int b = Integer.parseInt(students[i].split(" ")[1]);
            stu[i] = new Info(i,a,b);
        }
        Arrays.sort(stu,(a,b) -> a.power - b.power);
        int sum = stu[0].power;
        nH.put(stu[0].team,new ArrayList<>());
        nH.get(stu[0].team).add(stu[0].power);
        for(int i=1;i<n;i++){
            if(nH.containsKey(stu[i].team)){
                int tmpSum = sum;
                for(int y : nH.get(stu[i].team)) tmpSum -= y;
                answer[stu[i].idx] = tmpSum;
            }else answer[stu[i].idx] = sum;
            int j = i;
            while(j-1 >=0 && stu[i].power == stu[j-1].power){
                answer[stu[i].idx] -= stu[j].power;
                j--;
            }
            sum += stu[i].power;
            nH.putIfAbsent(stu[i].team,new ArrayList<>());
            nH.get(stu[i].team).add(stu[i].power);
        }
        return answer;
    }

    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<Info> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Character a = students[i].split(" ")[0].charAt(0);
            int b = Integer.parseInt(students[i].split(" ")[1]);
            list.add(new Info(i, a, b));
        }
        Collections.sort(list);
        HashMap<Character, Integer> Tp = new HashMap<>();
        int j = 0, total = 0;
        for(int i = 1; i < n; i++){
            for( ; j < n; j++){
                if(list.get(j).power < list.get(i).power){
                    total += list.get(j).power;
                    char x = list.get(j).team;
                    Tp.put(x, Tp.getOrDefault(x, 0) + list.get(j).power);
                }
                else break;
            }
            answer[list.get(i).idx] = total - Tp.getOrDefault(list.get(i).team, 0);
        }
        return answer;
    }

    public static void main(String[] args) {
        Prob4 T = new Prob4();
        System.out.println(Arrays.toString(T.solution3(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution3(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution3(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution3(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
