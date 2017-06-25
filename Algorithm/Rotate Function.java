public class Solution {
    public int maxRotateFunction(int[] nums) {
        
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int m = nums.length;
        
        int res = 0;
        int sum = 0;
        
        
        for(int i = 0; i < m; i++){
            
            res += nums[i] * i;
            
            sum += nums[i];
        }
        
        
        int temp = res;
        
        for(int i = 1; i < m; i++){
            
            temp = temp + sum - m * nums[m - i];
            
            res = Math.max(res, temp);
        }
        
        return res;
    }
}
