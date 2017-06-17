public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        
        if(strs == null || strs.length == 0){
            return res;
        }
        
      
        Map<String, List<String>> result = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            char[] map = new char[26];
            
            String s = strs[i];
            
            for(int j = 0; j < s.length(); j++){
                
                map[s.charAt(j) - 'a']++;
            }
            
            String temp = new String(map);
            
            
            if(!result.containsKey(temp)){
                
                result.put(temp, new ArrayList<>());
            }
            
            result.get(temp).add(s);
            
        }
        
        res.addAll(result.values());
        
        return res;
        
    }
}
