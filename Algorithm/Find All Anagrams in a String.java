public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        
        if(s == null || s.length() == 0 || s.length() < p.length()){
            return res;
        }
        
        int m = p.length();
        
        
        int i = 0;
        
        while(i < s.length()){
            
            int end = i + m;
            
            if(end <= s.length()){
                
                String temp = s.substring(i, end);
                
                if(isAnagrams(temp, p)){
                    res.add(i);
        
                }
            }
            
            i++;
            
        }
        
        return res;
    }
    
    private boolean isAnagrams(String t, String p){
        
        char[] arr = new char[26];
        
        for(int i = 0; i < p.length(); i++){
            
            arr[p.charAt(i) -'a']++;
        }
        
        for(int i = 0; i < t.length(); i++){
            arr[t.charAt(i) - 'a']--;
        }
        
        
        for(int i = 0; i < arr.length; i++){
            
            if(arr[i] != 0){
                return false;
            }
        }
        
        return true;
    }
}
