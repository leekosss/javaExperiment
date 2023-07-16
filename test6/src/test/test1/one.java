package test.test1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class one {
    public static String[] getStrings(String s) {
        return s.split("[\\W]");
    }
    public static void main(String[] args) {
        String s = "int a, #double._c !m=567+y11; 15l";
        String[] strings = getStrings(s);
        String regex = "[a-zA-Z_][a-zA-Z0-9_]*";
        Pattern p = Pattern.compile(regex);
        Matcher m;
        System.out.print("C标识符为:");
        for(String str: strings) {
            m = p.matcher(str);
            if(m.matches()) {
                System.out.println(str+" ");
            }
        }

    }
}
