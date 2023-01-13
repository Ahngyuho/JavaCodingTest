package realCode.Prac5;

import java.util.*;

public class Prob6 {
    public int getTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }

    String[] solution(String []reports,int k){
        HashMap<String,ArrayList<Integer>> nH = new HashMap<>();
        ArrayList<String> tmp = new ArrayList<>();

        for(String x : reports){
            String name = x.split(" ")[0];
            String time = x.split(" ")[1];
            nH.putIfAbsent(name,new ArrayList<>());
            nH.get(name).add(getTime(time));
        }

        for(String x : nH.keySet()){
            Collections.sort(nH.get(x),(a,b) -> a-b);
            int lt = 0;
            for(int rt = 0;rt<nH.get(x).size();rt++){
                while(nH.get(x).get(rt) - nH.get(x).get(lt) > 60) lt++;
                if(rt - lt + 1 >= k){
                    tmp.add(x);
                    break;
                }
            }
        }

        Collections.sort(tmp,(a,b) -> a.compareTo(b));
        String[] answer = new String[tmp.size()];
        for(int i = 0;i<tmp.size();i++) answer[i] = tmp.get(i);
        return answer;
    }

    public static void main(String[] args){
        Prob6 T = new Prob6();
        System.out.println(Arrays.toString(T.solution(new String[]{"luis 08:11", "daniel 10:21", "luis 09:12", "emily 08:34", "luis 09:45", "luis 08:45", "luis 18:48", "emily 09:12", "daniel 11:15", "emily 09:34", "luis 10:35", "luis 10:45"}, 3)));
        System.out.println(Arrays.toString(T.solution(new String[]{"andew 08:11", "daniel 10:21", "luis 09:12", "emily 08:34", "luis 09:45", "andew 08:45", "luis 09:33", "andew 08:48", "emily 09:12", "daniel 11:15", "emily 09:35", "luis 09:35", "luis 10:45"}, 4)));
        System.out.println(Arrays.toString(T.solution(new String[]{"andew 08:11", "daniel 10:21", "luis 09:12", "emily 08:34", "luis 09:45", "andew 08:45", "luis 09:33", "andew 08:48", "emily 09:12", "daniel 11:15", "emily 09:35", "luis 09:35", "luis 10:45"}, 4)));
    }
}
