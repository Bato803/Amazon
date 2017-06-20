public class Solution {
public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();
		
		Set<String> set = new HashSet<>();
		for(String s : wordList){
		    set.add(s);
		}


		bfs(map,distance,beginWord,set);
		List<String> r = new ArrayList<>();
		
				    
		if(!map.containsKey(endWord)){
		    return res;
		}
		
		dfs(res,r ,distance,beginWord,endWord,map);

		return res;

	}


	private void dfs(List<List<String>> res, List<String> r, Map<String, Integer> distance,
					 String startWord,
					 String endWord, Map<String, List<String>> map) {

		r.add(endWord);

		if (startWord.equals(endWord)) {
			Collections.reverse(r);
			res.add(new ArrayList<String>(r));
			Collections.reverse(r);
		} else {

			for (String prev : map.get(endWord)) {
				if (distance.containsKey(prev) && distance.get(prev) + 1
												  == distance.get(endWord)) {
					dfs(res, r, distance, startWord, prev, map);
				}
			}
		}
		
		r.remove(r.size() - 1);

	}

	private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String beginWord,
					 Set<String> wordList) {

		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		distance.put(beginWord, 0);
		for (String s : wordList) {
			map.put(s, new ArrayList<>());
		}
		while (!q.isEmpty()) {

			String temp = q.poll();

			for (String s : getWords(temp, wordList)) {
				map.get(s).add(temp);
				if (!distance.containsKey(s)) {
					distance.put(s, distance.get(temp) + 1);
					q.add(s);
				}
			}

		}

	}

	private List<String> getWords(String beginWord, Set<String> wordList) {

		List<String> words = new ArrayList<>();

		for (int i = 0; i < beginWord.length(); i++) {

			for (char ch = 'a'; ch <= 'z'; ch++) {

				String temp = getWord(beginWord, ch, i);

				if (wordList.contains(temp)) {
					words.add(temp);
				}
			}
		}

		return words;

	}

	private String getWord(String beginWord, char ch, int pos) {

		char[] arr = beginWord.toCharArray();
		arr[pos] = ch;

		return new String(arr);
	}

}
