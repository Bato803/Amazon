public class Solution {
    public String multiply(String num1, String num2) {
        
        
        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        
        
        int m = s1.length();
        int n = s2.length();
        
        
        int[] res = new int[m + n];
    
        
        
        for(int i = 0; i < m; i++){
            
            for(int j = 0; j < n; j++){
                
                
                int n1 = s1.charAt(i) - '0';
                
                int n2 = s2.charAt(j) - '0';
                
                
                res[i + j] += n1 * n2;
            }        
        }
        
        StringBuilder sb = new StringBuilder();
        
        int num = 0;
        int carry = 0;
        
        
        for(int i = 0; i < res.length; i++){
            
            int totalNum = res[i] + carry;
            
            num = totalNum % 10;
            carry = totalNum / 10;
            
            sb.append(num);
        }
        
        
                
        if(carry > 0){
           sb.append(carry);
        }
        
        sb.reverse();
        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
