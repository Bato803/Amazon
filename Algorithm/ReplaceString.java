
public class ReplaceString {

	public static void main(String[] args) {

		String s = "abcdefg";

		String replace = "cde";

		String target = "ccc";

		System.out.println(new ReplaceString().replaceString(s, replace, target));

	}


	public String replaceString(String s, String replace, String target) {

		if (s == null || s.length() == 0) {

			return "";
		}

		for (int i = 0; i < s.length(); i++) {

			if (s.substring(i, i + replace.length()).equals(replace)) {

				char[] arr = s.toCharArray();

				for (int j = 0; j < target.length(); j++) {

					arr[i + j] = target.charAt(j);
				}

				return new String(arr);

			}
		}

		return null;


	}

}
