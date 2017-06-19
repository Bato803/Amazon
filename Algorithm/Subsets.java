public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0){
            
            return res;
        }
        
        
        helper(nums, 0, res, new ArrayList<Integer>());
        
        return res;
        
    }
    
    
    private void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> r){
        
    
        res.add(new ArrayList<>(r));
        
        
        for(int i = pos; i < nums.length; i++){
            
            
            r.add(nums[i]);
            
            helper(nums, i + 1, res, r);
            
            r.remove(r.size() - 1);
        }
        
    }
}
