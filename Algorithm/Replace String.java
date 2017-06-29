public class ReplaceString {


    public static void main(String[] args) {

        String s = "abcdefgbcdeb";
        String t = "bcde";

        String p = "123";


        ReplaceString replaceString = new ReplaceString();

        replaceString.replaceString(s, t, p);

        System.out.println(replaceString.replaceString(s, t, p));
    }


    public String replaceString(String s, String t, String p) {

        int len = t.length();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int st = 0;

        for (; i < s.length(); i++) {

            if (s.charAt(i) == t.charAt(0)) {

                if (s.substring(i, i + len).equals(t)) {

                    sb.append(s.substring(st, i)).append(p);
                    st = i + len;
                    i = i + len;

                }
            }

            if (i == s.length() - 1) {
                sb.append(s.substring(i, s.length()));
            }
        }


        return sb.toString();


    }
}
