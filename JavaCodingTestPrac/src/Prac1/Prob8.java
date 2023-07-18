package Prac1;

import java.util.*;

public class Prob8 {
    public int solution(String s) {
        int answer = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) map.put(x, map.getOrDefault(x, 0) + 1);
        int cnt = 0;

        //원래는 아래 방법말고 좀 더 코드를 많이 작성해야 하는 방식으로 하려고 했었다.
        //최대 홀수 길이를 구하고 keySet 으로 value 를 탐색하며 홀수이면서
        //최대 홀수 길이와 같지 않는 것들을 구해서 answer += value - 1 을 해주려고 했었다

        //하지만 최대 홀수 길이는 중복될 수 있다. 그래서 위의 방법은 올바르지 않았다.
        //홀수 길이 하나만 남겨야 하므로 최대 홀수 길이를 구해서 이 값과 같지 않은 것들을
        //value - 1 을 해서 더해주려고 했으나 이 방법은 실패했다.

        //홀수 개수를 가진 알파벳은 하나 뿐이어야 한다.
        //그래서 그 알파벳들을 구하고 하나의 알바벳 종류를 제외한 나머지 종류들은
        //모두 문자열에서 제거해 줘야한다.
        for(char x : map.keySet()) {
            if(map.get(x) % 2 == 1) cnt++;
        }
        //홀수 개수를 구한것이 cnt 이고 문자열 길이에서 cnt 를 뺀다는 것은
        //홀수 길이인 알파벳들을 모두 하나씩 제거해 짝수로 만드는 것이다.
        //그리고 홀수는 하나만 남길 수 있다고 하였으므로 + 1 을 해주면 최대 길이가 나온다.
        //문제에서는 최대 길이만을 요구했으므로 가능한 방법이다.

        return cnt > 0 ? answer - cnt + 1 : answer;
    }

    public static void main(String[] args){
        Prob8 T = new Prob8();
        System.out.println(T.solution("abcbbbccaa"));
        System.out.println(T.solution("aabb"));
    }
}
