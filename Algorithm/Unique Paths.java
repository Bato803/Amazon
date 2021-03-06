public class Solution {
    public int uniquePaths(int m, int n) {
        
        if(m == 0 && n == 0){
            return 0;
        }
        
        if(m == 0 || n == 0){
            
            return 1;
        }
        
        
        int[][] dp = new int[m][n];
        
        
        for(int i = 0; i < m; i++){
            
            dp[i][0] = 1;
        }
        
        for(int i = 0; i < n; i++){
            
            dp[0][i] = 1;
        }
        
        
        for(int i = 1; i < m; i++){
            
            for(int j = 1; j < n; j++){
                
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                
            }
        }
        
        
        return dp[m - 1][n - 1];
        
    }
}



public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        
        int[][] dp = new int[m][n];
        
        
        if(obstacleGrid[0][0] == 0){
            dp[0][0] = 1;
        }else{
            return 0;
        }
        
        for(int i = 1; i < m; i++){
            dp[i][0] = obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1 ? 1 : 0;
        }
        
        for(int i = 1; i < n; i++){
            dp[0][i] = obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1 ? 1 : 0;
        }
        
        for(int i = 1; i < m; i++){
            
            for(int j = 1; j < n; j++){
                
                if(obstacleGrid[i][j] != 1){
                    dp[i][j]  = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
        
    }
}
