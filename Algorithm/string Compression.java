public class Solution {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String originalString) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        char[] chs = originalString.toCharArray();
        int write = 0;
        for (int i = 1; i <= chs.length; i++) {
            if (i == chs.length) {
                sb.append(chs[write]);
                String number = String.valueOf(i - write);
                sb.append(number);
            }
            else if (chs[i] != chs[i - 1]) {
                sb.append(chs[write]);
                String number = String.valueOf(i - write);
                sb.append(number);
                write = i;
            }
        }
        String res = sb.toString();
        return res.length() >= originalString.length() ? originalString : res;
    }
}
