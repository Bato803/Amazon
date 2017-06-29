public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        
        
        if(nums == null || nums.length == 0){
            
            return 0;
        }
        
        int m = nums.length;
        
        int[] dp = new int[m];
        
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }
        
        int res = 1;
        
        for(int i = 1; i < m; i++){
            
            for(int j = 0;  j < i; j++){
                
                if(nums[i] > nums[j]){
                    
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }

            }
                            
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
