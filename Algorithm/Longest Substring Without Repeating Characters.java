public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int i = 0;
        int j = 0;
        
        Set<Character> set = new HashSet<>();
        
        int max = 1;
        
        while(i < s.length()){
            
            max = Math.max(i - j, max);
            
            while(set.contains(s.charAt(i))){
                
                set.remove(s.charAt(j++));
            }
            
            set.add(s.charAt(i++));
            
        }
        max = Math.max(i - j, max);
        return max;
        
    }
}
