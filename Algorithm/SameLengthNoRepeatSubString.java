class Solution {
    public int findSubstring(String s, int k) {
            Set<String> stringSet = new HashSet<>();
            int start = 0;
            Set<Character> cSet = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                while (cSet.contains(c)) {
                    cSet.remove(s.charAt(start++));
                }
                cSet.add(c);
                if (cSet.size() == k) {
                    stringSet.add(s.substring(start, i + 1));
                    cSet.remove(s.charAt(start++));
                }
            }
            return stringSet.size();
    }       
}
