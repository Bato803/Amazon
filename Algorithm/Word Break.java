public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(wordDict == null || wordDict.size() == 0){
            return false;
        }
        
        int m = s.length();
        
        boolean[] dp = new boolean[m + 1];
        
        
        dp[0] = true;
        
        
        for(int i = 0; i < m; i++){
            
            if(!dp[i]){
                continue;
            }
            
            for(String word : wordDict){
                
                
                int end = i + word.length();
                
                if(end > m || dp[end]){
                    continue;
                }
                
                if(s.substring(i, end).equals(word)){
                
                    dp[end] = true;
                }
            }
        }
        
        return dp[m];
        
        
        
        
    }
}
