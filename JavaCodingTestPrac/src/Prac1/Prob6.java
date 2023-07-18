package Prac1;

import java.util.*;

public class Prob6 {
    public int solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) map.put(x, map.getOrDefault(x, 0) + 1);
        for (int i = 0; i < s.length(); i++) if(map.get(s.charAt(i)) == 1) return i+1;
        //원래는 Map 에 담아서 value 가 1인 문자를 찾으려고 했지만(keySet 이용)...
        //그것보단 위의 방식이 가장 깔끔
        //keySet 을 이용하면 추가로 해당 1인 문자의 위치를 찾아야 하는 코드를 더 작성
        //그것보다 String 의 문자를 하나씩 map 에 넣어서 value 가 1인 것을 찾으면
        //코드 한줄로 끝나게 된다.
        return -1;
    }
}
