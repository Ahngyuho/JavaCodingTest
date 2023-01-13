package realCode.Prac2;

import java.util.*;

public class Prob5 {
    public int getTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);

        return hour * 60 + minute;
    }

    private class Person implements Comparable<Person>{

        public String name;
        public int time;

        Person(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Person o) {
            return this.time - o.time;
        }
    }

    public String[] solution(String[] reports, String times) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Person> tmp = new ArrayList<>();

        for (String x : reports) {
            String[] s = x.split(" ");
            String[] time = s[1].split(":");

            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);

            tmp.add(new Person(s[0],hour*60+minute));
        }

        Collections.sort(tmp);

        String[] time = times.split(" ");
        String[] startTime = time[0].split(":");
        String[] endTime = time[1].split(":");

        int start = getTime(time[0]);
        int end = getTime(time[1]);

        for (Person x : tmp) {
            if (x.time >= start && x.time <= end) {
                answer.add(x.name);
            }
        }

        String[] ans = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Prob5 T = new Prob5();
        System.out.println(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23",
                "park 09:59", "luis 08:57"},"08:33 09:45"));
    }
}
