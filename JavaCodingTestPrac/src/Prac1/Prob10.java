package Prac1;
import java.util.*;
public class Prob10 {
    //최소 공통 문자 찾기
    //맨 처음 문자열의 문자 : 문자 개수 정보를 map 에 담아 저장하고
    //주어진 문자열들과 비교해가면서 최후의 공통 문자를 찾는다.
    public char[] solution1(String[] words) {

        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> res = new ArrayList<>();
        for(char x : words[0].toCharArray()) map.put(x, map.getOrDefault(x, 0) + 1);
        for (int i = 1; i < words.length; i++) {
            HashMap<Character, Integer> tmp = new HashMap<>();
            for(char x : words[i].toCharArray()){
                if(map.getOrDefault(x,0) > 0){
                    //여기 아래로 내려왔다는 것은 value 가 1 이상이고 즉 key 가 무조건 존재한다는 의미
                    map.put(x,map.get(x) - 1);
                    //공통 문자 담기...
                    tmp.put(x,tmp.getOrDefault(x,0) + 1);
                }
            }
            map = new HashMap<>(tmp);
        }
        for(char x : map.keySet()){
            for (int i = 0; i < map.get(x); i++) {
                res.add(x);
            }
        }
        char[] answer = new char[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }


    public char[] solution(String[] words){
        char[] answer;
        HashMap<Character,Integer> map = new HashMap<>();
        //맨 처음 문자열 하나를 가져와 map 을 만든다. 이 map 에서 words 문자열을 탐색해 나가면서
        //최소로 중복 사용된 문자를 map 에 넣어줄 것이다.
        for(char x : words[0].toCharArray()) map.put(x, map.getOrDefault(x, 0) + 1);
        for(int i=1;i<words.length;i++){
            // 좀 더 최소화된 중복 문자 정보
            HashMap<Character, Integer> tmp = new HashMap<>();
            //입력으로 주어진 배열의 문자열로 또 다른 하나의 map 을 생성
            for(char x : words[i].toCharArray()){
                //이런 식으로 현재 중복된 문자열 정보에 새로운 문자열 정보를 가져와
                //더욱 최소화된 중복 문자를 찾아나간다.

                //문자열의 문자가 map 에 > 0 의 value 를 가진다면 현재 이 문자는 공통문자!
                if(map.getOrDefault(x,0) > 0){
                    map.put(x, map.get(x) - 1);
                    tmp.put(x, tmp.getOrDefault(x, 0) + 1);
                }

            }
            map = new HashMap<>(tmp);
//            for(char x : words[i].toCharArray()) tmp.put(x, tmp.getOrDefault(x, 0) + 1);
//            for(char x : map.keySet()){
//                //현재 map 에는 최소한 중복 사용된 문자 정보가 들어있다.
//                //여기서 문자 정보를 더 최소화 시키는 것인데 이 코드는 잘못된게
//                //HashMap 에서는 Node 를 만들어서 관리하는데 그 Node 들이 서로 연결되어 있는 듯 하다.
//                //keySet() 으로 반환된 iterator 가 그런식으로 Node 들을 관리하는 모양인데 지금 map.remove(x)
//                //를 하게 되면서 iterator 가 만든 규칙이 깨져버린거 같다. 그래서 오류...
//                //이런 방식으로는 코드 작성 불가
//                if(tmp.getOrDefault(x,0) < map.get(x)) map.remove(x);
//            }
        }
        ArrayList<Character> tmp = new ArrayList<>();
        for (char key : map.keySet()) {
            for (int i = 0; i < map.get(key); i++) {
                tmp.add(key);
            }
        }

        answer = new char[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
            System.out.print(answer[i] + " ");
        }

        return answer;
    }

    public static void main(String[] args) {
        Prob10 T = new Prob10();
        String[] tmp = new String[]{"steasue", "sasseysu", "kseseas"};
        System.out.println(T.solution1(tmp));
        String[] tmp1 = new String[]{"longlong", "longtong", "longbig"};
        System.out.println(T.solution1(tmp1));
    }
}
