public class Solution {
    public boolean isMatch(String s, String p) {
        
        
        int i = 0;
        int j = 0;
        
        int sStart = 0;
        int pStart = -1;
        
        while(i < s.length()){
            
            
            if(j < p.length() &&(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                
                i++;
                j++;
                
            }else if(j < p.length() && p.charAt(j) == '*'){
                
                sStart = i;
                pStart = j;
                j++;
                
            }else if(pStart != -1){
                
                j = pStart + 1;
                i = sStart++;
                
            }else{
                return false;
            }
            
        }
        
        while(j < p.length() && p.charAt(j) == '*'){
            j++;
        }
        
        return j == p.length();
        
    }
}
