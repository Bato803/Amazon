public class Solution {
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() == 0){
            
            return "";
        }
        
        int n = s.length();
        
        boolean[][] dp = new boolean[n][n];
        
        dp[0][0] = true;
        
        int max = 1;
        
        int head = 0;
        
        for(int j = 0; j < s.length(); j++){
            
            for(int i = 0; i <= j; i++){
                
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])){
                    
                    dp[i][j] = true;
                    
                    
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        
                        head = i;
                    }
                }
            }
        }
        
        return s.substring(head, head + max);
        
    }
}
