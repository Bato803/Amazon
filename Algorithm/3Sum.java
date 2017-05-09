public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0){
            
            return res;
        }
        
        
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            
            int j = i + 1;
            
            int k = nums.length - 1;
            
            if(i != 0 && nums[i - 1] == nums[i]){
                
                continue;
            }
            
            while(j < k){
            
                if(nums[i] + nums[j] + nums[k] == 0){
                
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]);
                    r.add(nums[j]);
                    r.add(nums[k]);
                    res.add(r);
                
                    j++;
                    k--;
                
                    while(j < k && nums[j] == nums[j - 1]){
                        j++;
                    }
                    
                    while(j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        
        return res;
    }
}
