public class Solution {
    public int singleNumber(int[] nums) {
        
        
        int res = 0;
        
        for(int num : nums){
            
            res ^= num;
        }
        
        return res;
    }
}


public class Solution {
    public int singleNumber(int[] nums) {
        
        
        int res = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int j = 0; j < nums.length; j++){
                
                
                sum += (nums[j] >> i) & 1;
            }
            
            res |= (sum % 3) << i;
        }
        
        return res;
        
    }
}


public class Solution {
    public int singleNumber(int[] nums) {

        
        int one = 0, two = 0, three = 0;
        
        
        for(int num : nums){
            
            two |= one & num;
            
            one ^= num;
            
            three = one & two;
            
            one &= ~three;
            two &= ~three;
        }
        
        return one;
    }
}



public class Solution {
    public int[] singleNumber(int[] nums) {
        
        
        
        int[] res  = new int[2];
        
        
        if(nums == null || nums.length == 0){
            
            return res;
        }
        
        int temp = 0;
        
        for(int num : nums){
            
            temp ^= num;
        }
        
        int diff = temp & (~(temp - 1));
        
        int one = 0;
        int two = 0;
        
        for(int num : nums){
            
            if((num & diff) != 0){
                
                one ^= num;
            }else{
                
                two ^= num;
            }
        }
        
        res[0] = one;
        res[1] = two;
        
        return res;
        
    }
}
