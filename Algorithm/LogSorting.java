package am;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LogSorting {

    class LogComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {

            int idx1 = s1.indexOf(' ');
            int idx2 = s2.indexOf(' ');
            String head1 = s1.substring(0, idx1);
            String head2 = s2.substring(0, idx2);
            String body1 = s1.substring(idx1);
            String body2 = s2.substring(idx2);
            if (body1.equals(body2)) {
                return head1.compareTo(head2);
            } else {
                return body1.compareTo(body2);
            }
        }
    }

    public String[] logSort(String[] logs) {
        // Write your code here
        List<String> list = new ArrayList<>();
        String[] ans = new String[logs.length];
        int cnt = logs.length - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            int index = logs[i].indexOf(' ');
            String body = logs[i].substring(index + 1);
            if (body.charAt(0) >= '0' && body.charAt(0) <= '9') {
                ans[cnt--] = logs[i];
            } else {
                list.add(logs[i]);
            }
        }
        LogComparator mc = new LogComparator();
        list.sort(mc);

        cnt = 0;
        for (String i : list) {
            ans[cnt++] = i;
        }
        return ans;
    }
}
