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
