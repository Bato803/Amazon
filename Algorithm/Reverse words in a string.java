    public static void reverseWords(char[] s) {

        int n = 0;
        int m = s.length - 1;

        reverse(s, n, m);

        int last = 0;
        for (int i = 0; i < s.length; i++) {



            if (s[i] == ' ') {
                reverse(s, last, i - 1);
                last = i + 1;
            }


            if(i == s.length - 1){
                reverse(s, last, i);
            }

        }

        System.out.println(s);

    }


    private static void reverse(char[] s, int i, int j) {

        while (i <= j) {

            char temp = s[i];

            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;

        }

    }
    
    
    public class Solution {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
}
