package PracticeCode.Prac2;
import java.util.*;
public class card {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(card.class.getClassLoader());
        int[] arr = new int[]{2,2};
        
        long a,b,c;
        a = 1;
        b = 1;
        int cnt = 0;
        while(cnt < 11){
            c = a + b;
            long tmp = c;
            long sum = 0;
            while(tmp > 0){
                sum += tmp % 10;
                tmp /= 10;
            }
            if(c % sum == 0) {
                System.out.print(c + " ");
                cnt++;
            }
            a = b;
            b = c;
        }
    }
}
