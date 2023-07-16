package test.test4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Excep {
    public static void main(String[] args) {
        double num=0;
        String[] str={"45.1","1th","123","123er45","x123","_123","123@","1a","a1"};
        String regex = "\\d+\\.?\\d*[^\\d]{0}";
        Pattern p = Pattern.compile(regex);
        for(String s: str) {
            Matcher matcher = p.matcher(s);
            if(matcher.matches()) {
//                System.out.println(s);
                 num += Double.parseDouble(s);
            }
        }
        System.out.println("num:"+num);
    }
}
