public class MergeEmailLists {

	private List<List<String>> mergeEmails(String[][] emails) {
		List<List<String>> result = new ArrayList<>();
		if (emails == null || emails.length == 0 || emails[0].length == 0) {
			return result;
		}

		int m = emails.length;
		int[]
			parent =
			new int[m]; // initialize parent array, at the begining, each list is in its own group
		for (int i = 0; i < m; i++) {
			parent[i] = i;
		}

		// key: email, value: List of set numbers that email belongs to
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (String email : emails[i]) {
				if (!map.containsKey(email)) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					map.put(email, list);
				} else {
					map.get(email).add(i);
				}
			}
		}

		// union
		for (List<Integer> list : map.values()) {
			// list is already in order
			for (Integer aList : list) {
				// make larger parent node point to small parent node
				union(parent, list.get(0), aList);
			}
		}

		HashMap<Integer, Set<String>> hash = new HashMap<>();

		//initialization
		for (int i = 0; i < m; i++) {
			hash.put(i, new HashSet<>());
		}
		for (int i = 0; i < m; i++) {
			if (i != parent[i]) {
				int p = parent[i];
				if (hash.get(p).isEmpty()) {
					hash.get(p).addAll(Arrays.asList(emails[p]));
				}
				hash.get(p).addAll(Arrays.asList(emails[i]));
			} else {
				hash.get(i).addAll(Arrays.asList(emails[i]));
			}
		}

		for (Set<String> set : hash.values()) {
			if (!set.isEmpty()) {

				List<String> r = new ArrayList<>();
				r.addAll(set);

				Collections.sort(r);
				result.add(r);
			}
		}
		return result;
	}

	private void union(int[] parent, int x, int y) {
		int parentX = getParent(parent, x);
		int parentY = getParent(parent, y);
		if (parentX < parentY) {
			parent[parentY] = parentX;
		} else if (parentX > parentY) {
			parent[parentX] = parentY;
		}
	}

	private int getParent(int[] parent, int x) {

		if (x != parent[x]) {
			return getParent(parent, parent[x]);
		}

		return x;
	}

	public static void main(String[] args) {
		String[] e0 = {"A", "B"};
		String[] e1 = {"B", "C"};
		String[] e2 = {"D", "E"};

		String[][] emails = {e0, e1, e2};
		MergeEmailLists test = new MergeEmailLists();
		List<List<String>> result = test.mergeEmails(emails);

		List<String> r = new ArrayList<>();

		r.add("A");
		r.add("A");
		r.add("B");

		result.add(r);

		Collections.sort(result, new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				if (o1.size() == o2.size()) {
					for (int i = 0; i < o1.size(); i++) {

						if (!o2.get(i).equals(o1.get(i))) {
							return o1.get(i).compareTo(o2.get(i));
						}
					}
				} else {
					return o2.size() - o1.size();
				}

				return 0;
			}
		});

		for (List<String> set : result) {
			System.out.println(set);
		}


	}
}
