package PracticeCode.Prac2;

import java.util.*;

public class Prob6 {
    //2023 02 02
    public int getTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }
    public String[] solution(String[] reports,int time) {
        HashMap<String,Integer> remainTime = new HashMap<>();
        HashMap<String,Integer> entry = new HashMap<>();
        for(String x : reports){
            String a = x.split(" ")[0];
            int b = getTime(x.split(" ")[1]);
            String c = x.split(" ")[2];
            if(c.equals("in")){
                entry.put(a,b);
            }else if(c.equals("out")){
                int t = entry.get(a);
                remainTime.put(a,remainTime.getOrDefault(a,0) + b - t);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for(String x : remainTime.keySet()){
            if(remainTime.get(x) >= time) res.add(x);
        }
        res.sort(Comparator.naturalOrder());
        String[] answer = new String[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        realCode.Prac2.Prob6 T = new realCode.Prac2.Prob6();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"},60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"},120)));
    }
}
