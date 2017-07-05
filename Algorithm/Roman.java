public class Solution {
    public int romanToInt(String s) {
        
        
        if(s == null || s.length() == 0){
            return 0;
        }
        
        
        int[] nums = new int[s.length()];
        
        
        for(int i = 0; i < s.length(); i++){
            
            
            char c = s.charAt(i);
            
            switch(c){
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
            
            
        
        }
        
        int res = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            
            if(nums[i] < nums[i + 1]){
                res -= nums[i];
            }else{
                res += nums[i];
            }
            
        }
        res += nums[nums.length - 1];
        return res;
        
    }
}

public class Solution {
    public String intToRoman(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < nums.length; i++){
            
            
            while(num >= nums[i]){
                sb.append(strs[i]);
                num -= nums[i];
            }
            
        }
        
        return sb.toString();
        
    }
}
