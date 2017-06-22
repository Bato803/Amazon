public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
         
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        

        
        
        
        return helper(nums, 0, nums.length - 1, nums.length - k);
        
    }
    
    private int helper(int[] nums, int st , int ed, int k){
        
        if(st == ed){
            return nums[st];
        }
        
        int pos = getPosition(nums, st, ed);
        
        
        if(pos == k){
            return nums[pos];
        }else if (pos < k){
            return helper(nums, pos + 1, ed, k);
        }else{
            return helper(nums, st, pos - 1, k);
        }
    }
    
    
    private int getPosition(int[] nums, int st, int ed){
        
        int left = st;
        int right = ed;
        
        int pivot = nums[ed];
        
        
        while(left < right){
            
            while(left < right && nums[left] < pivot){
                
                left++;
            }
            
            
            while(left < right && nums[right] >= pivot){
                right--;
            }
            
            
            swap(nums, left, right);
        }
        
        swap(nums, left, ed);
        
        return left;
    }
    
    private void swap(int[] nums, int i , int j){
        
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
}
