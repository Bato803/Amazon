public class TinyUrl {


	public static void main(String[] args) {

		int id = 72;

		String s = idToShortKey(id);
		System.out.println(s);
		int tempId = shortKeytoID(s);
		System.out.println(tempId);


	}

	private String getShortKey(String url) {
		return url.substring("http://tiny.url/".length());
	}

	private static int toBase62(char c) {

		if (c >= '0' && c <= '9') {
			return c - '0';
		}
		if (c >= 'a' && c <= 'z') {
			return c - 'a' + 10;
		}
		if (c >= 'A' && c <= 'Z') {
			return c - 'A' + 36;
		}
		return -1;


	}

	private static int shortKeytoID(String short_key) {
		int id = 0;
		for (int i = 0; i < short_key.length(); ++i) {
			id = id * 62 + toBase62(short_key.charAt(i));
		}
		return id;
	}

	private static String idToShortKey(int id) {
		String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String short_url = "";
		while (id > 0) {
			short_url = chars.charAt(id % 62) + short_url;
			id = id / 62;
		}
		while (short_url.length() < 6) {
			short_url = "0" + short_url;
		}
		return short_url;
	}


}
