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
