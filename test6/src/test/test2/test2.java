package test.test2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void getOpeNum(String s) {
        String[] strings = s.split("[+\\-*/() \t#]");
        String regex = "\\d+\\.?\\d*";
        System.out.print("所有的操作数为:");
        for(String str: strings) {
            if(str.matches(regex)) {
                System.out.print(str+" ");
            }
        }
        System.out.println();

    }

    public static void getOpeChar(String s) {
        String[] strings = s.split("[\\d \\t]");
        System.out.print("所有的操作符为:");
        String regex = "[+\\-*/()]+";
        Pattern p = Pattern.compile(regex);
        for(String str: strings) {
            Matcher matcher = p.matcher(str);
            if(matcher.matches()){
                System.out.print(str);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "1.2+3.4*(5.6-7.8/ (9.0-10))";
        getOpeNum(s);
//        getOpeChar(s);
    }
}
