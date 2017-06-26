public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        
        if(s == null || s.length() == 0){
            return false;
        }
        
        int m = s.length();
        
        for(int i = 1; i <= m / 2; i++){
            
            String temp = s.substring(0, i);
            
            if(m % temp.length() == 0){
                
                int count = m / temp.length();
                
                StringBuilder sb = new StringBuilder();
                
                while(count > 0){
                    sb.append(temp);
                    
                    count--;
                }
                if(sb.toString().equals(s)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
}
