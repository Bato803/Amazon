public class Solution {
    public boolean canPartition(int[] nums) {
        
        
        if(nums == null || nums.length == 0){
            
            return false;
        }
        
        int sum = 0;
        
        for(int num : nums){
            
            sum += num;
        }
        
        if ((sum & 1) == 1) {
            return false;
        }
        
        
        sum /= 2;
        int m = nums.length;
        
        boolean[][] dp = new boolean[m + 1][sum + 1];
        
        
        dp[0][0] = true;
        
        for(int i = 1; i <= m; i++){
            
            dp[i][0] = true;
        }
        
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }
    
        
        for(int i = 1; i <= m; i++){
            
            for(int j = 1; j <= sum; j++){
                
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
                
            }
        }
        
        return dp[m][sum];
        
    }
}
