package PracticeCode.Prac6;
import java.util.*;

/*
* IP 주소
매개변수 s에 숫자로 구성된 문자열이 주어지면 이 문자열을 이용하여 유효한 IP주소의 경우
들을 찾고 싶습니다.
만약 문자열 s = "2025505" 이 주어지면 만들 수 있는 유효한 IP 주소는
["20.25.50.5","20.255.0.5","202.5.50.5","202.55.0.5"] 와 같습니다.
1) IP 주소는 4개의 숫자가 . 로 구분되어 있습니다.
2) IP 주소의 4개의 숫자는 0 ~ 255사이의 숫자로 구성됩니다.(0, 255포함)
3) IP 주소는 4개의 숫자는 0으로 시작해서는 안됩니다.
위에 입력의 경우 "2.0.255.0.5"와 같이 5개로 구성되어 있거나, "2.025.50.5"와 같이 0으로
시작하거나, "20.2.5.505"와 같이 255보다 큰 숫자가 존재하거나 하면 안됩니다.
매개변수 s에 숫자로 구성된 문자열이 주어지면 이 문자열을 이용하여 유효한 IP주소의 경우
들을 배열에 담아 반환하는 프로그램을 작성하세요. 순서는 상관없습니다.
매개변수 s의 숫자들의 순서를 임의로 바꾸거나, 숫자를 지워서는 안됩니다.
만들 수 있는 유효한 IP가 없을 경우 빈 배열을 반환합니다.
* */

public class Prob2 {
    LinkedList<String> tmp;
    ArrayList<String> res;
    public void DFS1(String s,int start){
        if(tmp.size() == 4 && start == s.length()){
            String t = "";
            for(String x : tmp){
                t += x + ".";
            }
            res.add(t.substring(0,t.length() - 1));
        }else{
            for(int i=start;i<s.length();i++){
                if(s.charAt(start) == '0' && i > start) return;
                String num = s.substring(start,i+1);
                if(Integer.parseInt(num) > 255) return;
                tmp.add(num);
                DFS1(s,i+1);
                tmp.pollLast();
            }
        }
    }

    public void DFS2(int start,String ip){
        if(start == ip.length() && tmp.size() == 4){
            String st = "";
            for(String x : tmp) st += x + ".";
            res.add(st.substring(0,st.length()-1));
        }else {
            for(int i=start;i<ip.length();i++){
                if(ip.charAt(start) == '0' && i > start) return;
                String octet = ip.substring(start,i+1);
                if(Integer.parseInt(octet) > 255) return;
                tmp.add(octet);
                DFS(i+1,ip);
                tmp.pollLast();
            }
        }

    }
    public String[] solution1(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS1(s,0);
        String[] answer = new String[res.size()];
        for(int i=0;i<res.size();i++) answer[i] = res.get(i);
        return answer;
    }
    public void DFS(int start, String s){
        if(tmp.size() == 4 && start == s.length()){
            String Ts = "";
            for(String x : tmp) Ts += x+".";
            res.add(Ts.substring(0, Ts.length()-1));
        }
        else{
            for(int i = start; i < s.length(); i++){
                if(s.charAt(start) == '0' && i > start) return;
                String num = s.substring(start, i + 1);
                if(Integer.parseInt(num) > 255) return;
                tmp.add(num);
                DFS(i + 1, s);
                tmp.pollLast();
            }
        }
    }

    public String[] solution(String s){
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS2(0, s);
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args) {
        Prob2 T = new Prob2();
        System.out.println(Arrays.toString(T.solution1("25114")));
        System.out.println(Arrays.toString(T.solution1("23251232")));
        System.out.println(Arrays.toString(T.solution1("21020132")));
        System.out.println(Arrays.toString(T.solution1("21350")));
        System.out.println(Arrays.toString(T.solution1("120225")));
        System.out.println(Arrays.toString(T.solution1("232012521")));
    }
}
