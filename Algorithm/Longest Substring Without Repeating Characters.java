public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        if(s == null || s.length() == 0){
            
            return 0;
        }
        
        Set<Character> set = new HashSet<>();
        
        int st = 0;
        int ed = 0;
        
        int res = 1;
        
        while(ed < s.length()){
            
            
            while(set.contains(s.charAt(ed))){
                
                set.remove(s.charAt(st));
                
                st++;
                
            }
            
            set.add(s.charAt(ed));
            ed++;
            
            
            res = Math.max(ed - st, res);
            
        }
        
        
        return res;
        
    }
}
