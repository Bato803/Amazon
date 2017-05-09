public class Solution {
    public int myAtoi(String s) {
        
        
        if(s == null || s.length() == 0){
            
            return 0;
        }
        
        
        int i = 0;
        
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        
        
        boolean flag = true;
        if(s.charAt(i) == '-'){
            i++;
            flag = false;
        }else if(s.charAt(i) == '+'){
            i++;
        }

        
        
        int sum = 0;
        while(i < s.length()){
            
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                break;
            }
            
            if(sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && (s.charAt(i) - '0') > Integer.MAX_VALUE % 10)){
                
                
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            sum = sum * 10 + s.charAt(i) - '0';
            i++;
            
            
        }
        
        return flag ? sum : -sum;
    }
}
