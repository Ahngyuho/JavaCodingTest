package PracticeCode.Prac5;
import java.util.*;
public class Prob6 {
    public int getTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }
    public String[] solution(String[] reports,int k) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String,ArrayList<Integer>> nH = new HashMap<>();
        for(String x : reports){
            String name = x.split(" ")[0];
            String time = x.split(" ")[1];
            nH.putIfAbsent(name,new ArrayList<>());
            nH.get(name).add(getTime(time));
        }
        for(String x : nH.keySet()){
            ArrayList<Integer> curr = nH.get(x);
            curr.sort((a,b) -> a - b);
            int len = curr.size();
            int left = 0;
            for(int right = 0;right < len;right++){
                while(curr.get(right) - curr.get(left) > 60) left++;
                if(k == right - left + 1) {res.add(x);break;}
            }
        }
        res.sort((a,b) -> a.compareTo(b));
        String[] answer = new String[res.size()];
        for(int i=0;i<res.size();i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args) {
        Prob6 T = new Prob6();
        System.out.println(Arrays.toString(T.solution(new String[]{"luis 08:11", "daniel 10:21", "luis 09:12", "emily 08:34", "luis 09:45", "luis 08:45", "luis 18:48", "emily 09:12", "daniel 11:15", "emily 09:34", "luis 10:35", "luis 10:45"}, 3)));
        System.out.println(Arrays.toString(T.solution(new String[]{"andew 08:11", "daniel 10:21", "luis 09:12", "emily 08:34", "luis 09:45", "andew 08:45", "luis 09:33", "andew 08:48", "emily 09:12", "daniel 11:15", "emily 09:35", "luis 09:35", "luis 10:45"}, 4)));
        System.out.println(Arrays.toString(T.solution(new String[]{"james 08:35", "james 08:50", "james 00:00"}, 3)));
    }
}
