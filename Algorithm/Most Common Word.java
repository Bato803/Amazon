class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        
        
        int max = 0;
        
        String res = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words){
            
            
            if(!set.contains(word)){
            
                int count = map.getOrDefault(word, 0) + 1;
            
                map.put(word, count);
            
                if(count > max){
                
                    max = count;
                    res = word;
                }
            }
            
        }
        
        return res;
        
        
        
    }
}







public class Solution {
    /**
     * @param s: a string
     * @param excludewords: a dict
     * @return: the most frequent word
     */
    public String frequentWord(String s, Set<String> excludewords) {
        // Write your code here
        if (s == null || s.isEmpty()) {
            return null;
        }
        
        Map<String, Integer> countMap = new HashMap<>();
        int maxFreq = 0;
        String result = null;
        String[] words = s.split(" ");
        for(String word : words) {
            if (!Character.isLetter(word.charAt(word.length()-1))) {
                word = word.substring(0, word.length()-1);
            }
            if (!excludewords.contains(word)){
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
                if (maxFreq < countMap.get(word)) {
                    maxFreq = countMap.get(word);
                    result = word;
                } else if (maxFreq == countMap.get(word) && word.compareTo(result) < 0) {
                    result = word;
                }
            }
        }

        return result;
    }
}
















