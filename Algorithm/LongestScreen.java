/*
A string, each character representing a scene. Between two identical characters is considered to be a continuous scene. For example: abcda, you can think of these five characters as the same scene. Or acafghbeb can think of two aca and beb scenes. If there is a coincidence between the scenes, then the scenes are combined. For example, abcab, where abca and bcab are coincident, then the five characters are considered to be the same scene. Give a string to find the longest scene.

1 <= |str| <=1e5
str contains only lowercase letters
Have you met this question in a real interview?  
Example
Given str = "abcda", return 5.

Explanation:
The longest scene is "abcda".
Given str = "abcab", return 5.

Explanation:
The longest scene is "abcab".


*/


package am;

import java.util.Arrays;
import java.util.Comparator;

public class LongestScreen {


    public static void main(String[] args) {

        String s = "abcab";

        System.out.println(new LongestScreen().getLongestScene(s));
    }

    class Interval {

        int st;
        int ed;


        public Interval(int st, int ed) {

            this.st = st;
            this.ed = ed;
        }


    }

    class IntervalCompatator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            if (a.st == b.st) {
                return a.ed - b.ed;
            }
            return a.st - b.st;
        }
    }


    public int getLongestScene(String s) {

        if (s == null || s.length() == 0) {

            return 0;
        }

        Interval[] intervals = new Interval[26];
        for (int i = 0; i < 26; i++) {

            intervals[i] = new Interval(s.length(), -1);
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (i < intervals[index].st) {
                intervals[index].st = i;
            }
            if (i > intervals[index].ed) {
                intervals[index].ed = i;
            }
        }


        Arrays.sort(intervals, (o1, o2) -> {
            if (o1.st == o2.st) {

                return o1.ed - o2.ed;
            }

            return o1.st - o2.st;
        });


        Interval pre = intervals[0];
        int maxLen = pre.ed - pre.st + 1;
        for (Interval curr : intervals) {

            if (curr.ed == -1) {
                continue;
            }

            if (pre.ed < curr.st) {
                pre = curr;
            } else {
                pre.ed = Math.max(pre.ed, curr.ed);
            }
            maxLen = Math.max(maxLen, pre.ed - pre.st + 1);
        }
        return maxLen;
    }
}
