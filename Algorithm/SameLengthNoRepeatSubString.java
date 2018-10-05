package am;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SameLengthNoRepeatSubString {


    public static void main(String[] args) {

        String s = "abcdab";

        System.out.println(new SameLengthNoRepeatSubString().getSubString(s, 4));
    }


    public List<String> getSubString(String s, int l) {


        List<String> res = new ArrayList<>();


        if (s == null || s.length() == 0) {

            return res;
        }


        Set<Character> set = new HashSet<>();

        int st = 0;
        int ed = 0;

        while (ed < s.length()) {

            while (set.contains(s.charAt(ed))) {

                set.remove(s.charAt(st));
                st++;
            }

            set.add(s.charAt(ed));
            ed++;


            if (ed - st == l) {

                res.add(s.substring(st, ed));
            }
        }

        return res;


    }

}
