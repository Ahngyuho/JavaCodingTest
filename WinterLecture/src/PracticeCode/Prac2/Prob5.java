package PracticeCode.Prac2;
import java.util.*;
public class Prob5 {
    //2023 02 02
    class Info implements Comparable<Info>{
        public String name;
        public int time;
        public Info(String name,int time){
            this.name = name;
            this.time = time;
        }
        @Override
        public int compareTo(Info o){
            return this.time - o.time;
        }
    }
    public int getTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }
    public String[] solution(String[] reports,String times) {
        ArrayList<Info> res = new ArrayList<>();
        for(String x : reports){
            String a = x.split(" ")[0];
            int b = getTime(x.split(" ")[1]);
            res.add(new Info(a,b));
        }
        Collections.sort(res);
        int s = getTime(times.split(" ")[0]);
        int e = getTime(times.split(" ")[1]);
        ArrayList<String> tmp = new ArrayList<>();
        for(Info x : res){
            if(x.time >= s && x.time <= e) tmp.add(x.name);
        }
        String[] answer = new String[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            answer[i] = tmp.get(i);
            System.out.print(answer[i] + " ");
        }
        return answer;
    }
    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23",
                "park 09:59", "luis 08:57"},"08:33 09:45"));
    }
}
