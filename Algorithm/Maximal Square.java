public class Solution {
    public int maximalSquare(char[][] matrix) {
        
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        
        int maxLen = 0;
                
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            
            if(matrix[i][0] == '1'){
                maxLen = 1;
                dp[i][0] = 1;
            }
        }
        
        for(int i = 0; i < n; i++){
            
            if(matrix[0][i] == '1'){
                
                maxLen = 1;
                dp[0][i] = 1;
            }
        }
        

        
        
        
        
        for(int i = 1; i < m; i++){
            
            for(int j = 1; j < n; j++){
                
                
                if(matrix[i][j] == '1'){
                    
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
                
            }
        }
        
        return maxLen * maxLen;
    }
}
