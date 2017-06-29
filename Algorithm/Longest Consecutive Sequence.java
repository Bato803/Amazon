public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] nums) {
        // write you code here
        
        if(nums == null || nums.length == 0){
            
            return 0;
        }
                
                
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            
            set.add(num);
        }
        
        
        int res = 1;
        
        for(int i = 0; i < nums.length; i++){

            int up = nums[i] + 1;
            
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            
            
            int down = nums[i] - 1;
            
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            
            res = Math.max(res, up - down - 1);
        }
        
        return res;
    }
}
