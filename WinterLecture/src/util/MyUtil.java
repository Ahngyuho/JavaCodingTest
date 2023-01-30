package util;

public class MyUtil {
    public static String change(String s){
        char[] tmp = s.toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] == '[') tmp[i] = '{';
            if(tmp[i] == ']') tmp[i] = '}';
        }
        return String.valueOf(tmp);
    }
}
