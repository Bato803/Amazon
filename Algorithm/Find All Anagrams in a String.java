
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        
        if(s == null || p == null || s .length() == 0 || p.length() == 0){
            
            return res;
        }
        
        int[] counts = new int[256];
        
        
        for(char c : p.toCharArray()){
            
            counts[c]++;
        }
        
        
        int st = 0; 
        int ed = 0;
        
        
        int count = p.length();
        
        while(ed < s.length()){
            
            if(counts[s.charAt(ed)] >= 1){
                count--;
            }
            
            
            counts[s.charAt(ed)]--;
            ed++;
            
            if(count == 0){
                res.add(st);
            }
            
            
            if(ed - st == p.length()){
                if(counts[s.charAt(st)] >= 0){
                    count++;
                }
                counts[s.charAt(st)]++;
                st++;
     
            }
   
        }
        
        return res;
    }
}




























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
