public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        
        
        if(nums == null || nums.length == 0){
            
            return 0;
        }
        
        int count = 0;
        
        
        Arrays.sort(nums);
        
        int st = 0;
        int ed = nums.length - 1;
        
        while(st < ed){
            
            if(nums[st] + nums[ed] <= target){
                
                count += (ed - st);
                st++;

            }else{
                ed--;
            }
            
        }
        
        return count;
    }
}
