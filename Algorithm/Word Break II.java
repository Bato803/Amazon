public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> res = new ArrayList<>();
        
        if(wordDict == null || wordDict.size() == 0){
            
            return res;
        }
        
        
        int m = s.length();
        
        List<String>[] dp = new ArrayList[m + 1];
        
        
        dp[0] = new ArrayList<>();
        
        
        for(int i = 0; i < m; i++){
            
            if(dp[i] == null){
                continue;
            }
            
            
            for(String word : wordDict){
                
                int len = word.length();
                int end = i + len;
                
                if(end > m){
                    continue;
                }
                
                
                if(s.substring(i, end).equals(word)){
                    
                    if(dp[end] == null){
                        
                        dp[end] = new ArrayList<>();
                    }
                    
                    dp[end].add(word);
                    
                }
                
            }
            
        }
        
        
        helper(dp , res, new ArrayList<String>(), s.length());
        
        return res;
        
    }
    
    
    private void helper(List<String>[] dp, List<String> res, List<String> r, int pos){
        
        
        if(pos == 0){
            
            StringBuilder sb = new StringBuilder();
            
            
            for(int i = r.size() - 1; i > 0; i--){
                
                sb.append(r.get(i)).append(" ");
            }
            
            sb.append(r.get(0));
            
            res.add(sb.toString());
            
            return;
            
            
        }else{
            
            
            if(dp[pos] != null){
                
                for(String s : dp[pos]){
                    
                    r.add(s);
                    
                    helper(dp, res, r, pos - s.length());
                    
                    r.remove(r.size()- 1);
                    
                }
                
            }
            
            
        }
        
    }
}
